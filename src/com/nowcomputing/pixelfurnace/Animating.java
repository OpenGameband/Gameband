package com.nowcomputing.pixelfurnace;

class Animating implements Runnable {
   // $FF: synthetic field
   final Animation a;

   Animating(Animation var1) {
      this.a = var1;
   }

   public void run() {
      try {
         Thread.sleep(500L);
      } catch (InterruptedException var2) {
      }

      com.nowcomputing.e.e.a(this.a, true);
   }
}
