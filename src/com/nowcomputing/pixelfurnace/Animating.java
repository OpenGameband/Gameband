package com.nowcomputing.pixelfurnace;

class Animating implements Runnable {
   // $FF: synthetic field
   final Animation animation;

   Animating(Animation animation) {
      this.animation = animation;
   }

   public void run() {
      try {
         Thread.sleep(500L);
      } catch (InterruptedException var2) {
      }

      com.nowcomputing.e.e.a(this.animation, true);
   }
}
