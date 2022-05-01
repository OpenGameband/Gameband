package com.nowcomputing;

import java.util.logging.Logger;

public class b {
   public static final Logger a = Logger.getLogger(S.class.getName());
   private String b;
   private int c;

   public b(String var1) {
      this.b = var1;
   }

   public boolean a() {
      try {
         this.c = GbUtilNative.lockInstance(this.b);
         return this.c != -1;
      } catch (Throwable var2) {
         return true;
      }
   }

   public void b() {
      try {
         GbUtilNative.unlockInstance(this.c, this.b);
      } catch (Throwable var2) {
      }

   }
}
