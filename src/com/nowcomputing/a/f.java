package com.nowcomputing.a;

// $FF: synthetic class
class f {
   // $FF: synthetic field
   static final int[] a = new int[d.a().length];

   static {
      try {
         a[d.a.ordinal()] = 1;
      } catch (NoSuchFieldError var4) {
      }

      try {
         a[d.b.ordinal()] = 2;
      } catch (NoSuchFieldError var3) {
      }

      try {
         a[d.c.ordinal()] = 3;
      } catch (NoSuchFieldError var2) {
      }

      try {
         a[d.d.ordinal()] = 4;
      } catch (NoSuchFieldError var1) {
      }

   }
}
