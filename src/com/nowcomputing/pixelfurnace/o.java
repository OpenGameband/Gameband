package com.nowcomputing.pixelfurnace;

import com.nowcomputing.ImageDoodad;
import com.nowcomputing.Utils;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;

public class o extends g {
   private static final Logger f = Logger.getLogger(Utils.class.getName());
   private ImageDoodad g;

   public o(ExecutorService var1) {
      super((short)16, var1);
   }

   public o(n var1, ExecutorService var2) {
      super(var1.d(), var2);
      this.e = var1;

      try {
         this.g = var1.k();
      } catch (IOException var4) {
         f.log(Level.WARNING, "Error reading scroll data from Gameband");
      }

   }

   public void b(ImageDoodad var1) {
      this.g = var1;
   }

   public ImageDoodad b() {
      return this.g;
   }

   public n c() {
      if (this.e == null) {
         this.e = new n();
         this.e.b((short)0);
         this.e.a((int)0);
         this.e.b((int)20);
         this.e.a(this.e());
         this.e.d(this.j());
      }

      this.e.a(this.g);
      return this.e;
   }
}
