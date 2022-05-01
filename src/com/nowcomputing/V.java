package com.nowcomputing;

import java.util.logging.LogManager;

public class V extends LogManager {
   static V a;

   public V() {
      a = this;
   }

   public void reset() {
   }

   private void b() {
      super.reset();
   }

   public static void a() {
      if (a != null) {
         a.b();
      }

   }
}
