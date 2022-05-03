package com.nowcomputing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateStreamDecoder {
   private static final Logger logger = Logger.getLogger(Utils.class.getName());
   private ArrayList b = new ArrayList();
   private boolean c;

   public static UpdateStreamDecoder a(InputStream inputStream) {
      UpdateStreamDecoder var1 = new UpdateStreamDecoder();
      BufferedReader var2 = null;

      try {
         var2 = new BufferedReader(new InputStreamReader(inputStream));

         String var3;
         while((var3 = var2.readLine()) != null) {
            if (!var3.isEmpty()) {
               var1.a(var3);
            }
         }
      } catch (IOException var12) {
         logger.log(Level.WARNING, "Error reading desc from stream: ", var12);
      } finally {
         if (var2 != null) {
            try {
               var2.close();
            } catch (IOException var11) {
            }
         }

      }

      return var1;
   }

   private void a(String var1) {
      UpdateEntry var2 = new UpdateEntry(var1);
      this.b.add(var2);
      if (var2.g()) {
         this.c = true;
      }

   }

   public ArrayList getLines() {
      return this.b;
   }
}
