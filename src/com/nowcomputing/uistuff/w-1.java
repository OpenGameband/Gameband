package com.nowcomputing.uistuff;

class w extends Thread {
   // $FF: synthetic field
   final MainMenu a;

   w(MainMenu var1) {
      this.a = var1;
   }

   public void run() {
      MainMenu.g(this.a);
   }
}
