package com.nowcomputing.d;

// $FF: synthetic class
class k {
   // $FF: synthetic field
   static final int[] a = new int[l.a().length];

   static {
      try {
         a[l.a.ordinal()] = 1;
      } catch (NoSuchFieldError var4) {
      }

      try {
         a[l.b.ordinal()] = 2;
      } catch (NoSuchFieldError var3) {
      }

      try {
         a[l.c.ordinal()] = 3;
      } catch (NoSuchFieldError var2) {
      }

      try {
         a[l.d.ordinal()] = 4;
      } catch (NoSuchFieldError var1) {
      }

   }
}
