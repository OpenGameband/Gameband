package com.nowcomputing;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class l {
   protected static final Logger a = Logger.getLogger(Utils.class.getName());
   protected GamebandConfig b;
   protected c c;
   private Thread e;
   private CountDownLatch f = new CountDownLatch(1);
   protected List d = new ArrayList();

   public l(GamebandConfig var1) {
      this.b = var1;
      this.a();
   }

   public void a(n var1) {
      this.d.add(var1);
   }

   public void a() {
      this.e = new m(this);
      this.e.start();
   }

   public c b() {
      return this.c;
   }

   protected c c() {
      Object var1 = null;
      return (c)var1;
   }

   public abstract boolean d();

   public static void a(String[] var0, String var1, boolean var2) {
      BufferedReader var3 = null;

      try {
         a.log(Level.FINE, "Launching command: " + Utils.a(var0, " "));
         ProcessBuilder var4 = new ProcessBuilder(var0);
         var4.redirectErrorStream(true);
         var4.directory(new File(var1));
         Process var5 = var4.start();
         var3 = new BufferedReader(new InputStreamReader(var5.getInputStream()));

         while(var3.readLine() != null) {
            if (var2) {
               a.log(Level.INFO, "Command output: " + var3.readLine());
            }
         }

         try {
            int var6 = var5.waitFor();
            a.log(Level.INFO, "Command exit value: " + var6);
         } catch (InterruptedException var14) {
            a.log(Level.WARNING, var14.getMessage());
         }
      } finally {
         if (var3 != null) {
            try {
               var3.close();
            } catch (IOException var13) {
            }
         }

         a.log(Level.FINE, "Command exited");
      }

   }

   // $FF: synthetic method
   static CountDownLatch a(l var0) {
      return var0.f;
   }
}
