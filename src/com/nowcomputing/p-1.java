package com.nowcomputing;

// $FF: synthetic class
class p {
   // $FF: synthetic field
   static final int[] a = new int[OSDetectionIsHard.values().length];

   static {
      try {
         a[OSDetectionIsHard.windows.ordinal()] = 1;
      } catch (NoSuchFieldError var3) {
      }

      try {
         a[OSDetectionIsHard.osx.ordinal()] = 2;
      } catch (NoSuchFieldError var2) {
      }

      try {
         a[OSDetectionIsHard.linux.ordinal()] = 3;
      } catch (NoSuchFieldError var1) {
      }

   }
}
