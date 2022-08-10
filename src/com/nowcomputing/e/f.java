package com.nowcomputing.e;

class f implements Runnable {
   // $FF: synthetic field
   final e a;

   f(e var1) {
      this.a = var1;
   }

   public void run() {
      try {
         Thread.sleep(500L);
      } catch (InterruptedException var2) {
      }
   }
}
