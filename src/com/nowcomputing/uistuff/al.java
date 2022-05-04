package com.nowcomputing.uistuff;

class al extends Thread {
   // $FF: synthetic field
   final ak a;

   al(ak var1) {
      this.a = var1;
   }

   public void run() {
      try {
         Thread.sleep((long)ak.a(this.a));
      } catch (InterruptedException var2) {
      }

      ak.b(this.a);
      ak.c(this.a);
   }
}
