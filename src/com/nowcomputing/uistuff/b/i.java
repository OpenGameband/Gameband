package com.nowcomputing.uistuff.b;

class i implements Runnable {
   // $FF: synthetic field
   final e a;

   i(e var1) {
      this.a = var1;
   }

   public void run() {
      try {
         Thread.sleep(1000L);
         if (!e.a(this.a)) {
            this.a.b().f();
         }
      } catch (InterruptedException var2) {
         var2.printStackTrace();
      }

   }
}
