package com.nowcomputing;

// $FF: synthetic class
class k {
   // $FF: synthetic field
   static final int[] a = new int[OSDetectionIsHard.values().length];

   static {
      try {
         a[OSDetectionIsHard.osx.ordinal()] = 1;
      } catch (NoSuchFieldError var4) {
      }

      try {
         a[OSDetectionIsHard.windows.ordinal()] = 2;
      } catch (NoSuchFieldError var3) {
      }

      try {
         a[OSDetectionIsHard.linux.ordinal()] = 3;
      } catch (NoSuchFieldError var2) {
      }

      try {
         a[OSDetectionIsHard.unknown.ordinal()] = 4;
      } catch (NoSuchFieldError var1) {
      }

   }
}
