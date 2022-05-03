package com.nowcomputing;
// This is a synthetic class, not my problem
// $FF: synthetic class
class A {
   // $FF: synthetic field
   static final int[] a = new int[B.a().length];

   static {
      try {
         a[B.b.ordinal()] = 1;
      } catch (NoSuchFieldError var4) {
      }

      try {
         a[B.c.ordinal()] = 2;
      } catch (NoSuchFieldError var3) {
      }

      try {
         a[B.a.ordinal()] = 3;
      } catch (NoSuchFieldError var2) {
      }

      try {
         a[B.d.ordinal()] = 4;
      } catch (NoSuchFieldError var1) {
      }

   }
}
