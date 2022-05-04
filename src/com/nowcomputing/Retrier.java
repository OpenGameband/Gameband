package com.nowcomputing;

import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Retrier {
   private static final Logger logger = Logger.getLogger(Utils.class.getName());
   private final int b;
   private final int c;

   public Retrier(int var1, int var2) {
      this.b = var1;
      this.c = var2;
   }

   public Object a(Callable var1) throws Exception {
      long var2 = System.currentTimeMillis();
      int var4 = 1;

      while(true) {
         try {
            return var1.call();
         } catch (Exception var8) {
            if (var4 == this.b) {
               logger.log(Level.FINE, "Too many retries, giving up...", var8);
               throw var8;
            }

            logger.log(Level.FINE, "Retryer caught exception[{0}]: {1}", new Object[]{var4, var8.toString()});
            if (this.c > 0) {
               try {
                  Thread.sleep((long)this.c);
               } catch (InterruptedException var7) {
               }
            }

            ++var4;
         }
      }
   }
}
