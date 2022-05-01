package com.nowcomputing.f;

// $FF: synthetic class
class H {
   // $FF: synthetic field
   static final int[] a = new int[com.nowcomputing.B.a().length];

   static {
      try {
         a[com.nowcomputing.B.a.ordinal()] = 1;
      } catch (NoSuchFieldError var3) {
      }

      try {
         a[com.nowcomputing.B.b.ordinal()] = 2;
      } catch (NoSuchFieldError var2) {
      }

      try {
         a[com.nowcomputing.B.c.ordinal()] = 3;
      } catch (NoSuchFieldError var1) {
      }

   }
}
