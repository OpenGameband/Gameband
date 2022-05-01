package com.nowcomputing.f;

// $FF: synthetic class
class x {
   // $FF: synthetic field
   static final int[] a = new int[com.nowcomputing.v.a().length];

   static {
      try {
         a[com.nowcomputing.v.c.ordinal()] = 1;
      } catch (NoSuchFieldError var3) {
      }

      try {
         a[com.nowcomputing.v.a.ordinal()] = 2;
      } catch (NoSuchFieldError var2) {
      }

      try {
         a[com.nowcomputing.v.b.ordinal()] = 3;
      } catch (NoSuchFieldError var1) {
      }

   }
}
