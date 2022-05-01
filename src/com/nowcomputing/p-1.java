package com.nowcomputing;

// $FF: synthetic class
class p {
   // $FF: synthetic field
   static final int[] a = new int[B.a().length];

   static {
      try {
         a[B.b.ordinal()] = 1;
      } catch (NoSuchFieldError var3) {
      }

      try {
         a[B.c.ordinal()] = 2;
      } catch (NoSuchFieldError var2) {
      }

      try {
         a[B.a.ordinal()] = 3;
      } catch (NoSuchFieldError var1) {
      }

   }
}
