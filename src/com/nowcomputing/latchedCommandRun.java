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

public abstract class latchedCommandRun {
   protected static final Logger logger = Logger.getLogger(Utils.class.getName());
   protected GamebandConfig config;
   protected randomInterface randomInterface;
   private Thread thread;
   private CountDownLatch latch = new CountDownLatch(1);
   protected List list = new ArrayList();

   public latchedCommandRun(GamebandConfig config) {
      this.config = config;
      this.a();
   }

   public void a(n var1) {
      this.list.add(var1);
   }

   public void a() {
      this.thread = new m(this);
      this.thread.start();
   }

   public randomInterface b() {
      return this.randomInterface;
   }

   protected randomInterface c() {
      Object var1 = null;
      return (randomInterface)var1;
   }

   public abstract boolean d();

   public static void a(String[] var0, String var1, boolean var2) throws IOException {
      BufferedReader var3 = null;

      try {
         logger.log(Level.FINE, "Launching command: " + Utils.a(var0, " "));
         ProcessBuilder var4 = new ProcessBuilder(var0);
         var4.redirectErrorStream(true);
         var4.directory(new File(var1));
         Process var5 = var4.start();
         var3 = new BufferedReader(new InputStreamReader(var5.getInputStream()));

         while(var3.readLine() != null) {
            if (var2) {
               logger.log(Level.INFO, "Command output: " + var3.readLine());
            }
         }

         try {
            int var6 = var5.waitFor();
            logger.log(Level.INFO, "Command exit value: " + var6);
         } catch (InterruptedException var14) {
            logger.log(Level.WARNING, var14.getMessage());
         }
      } finally {
         if (var3 != null) {
            try {
               var3.close();
            } catch (IOException var13) {
            }
         }

         logger.log(Level.FINE, "Command exited");
      }

   }

   // $FF: synthetic method
   static CountDownLatch a(latchedCommandRun var0) {
      return var0.latch;
   }
}
