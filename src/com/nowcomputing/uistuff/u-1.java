package com.nowcomputing.uistuff;

import com.nowcomputing.Main;
import java.util.logging.Level;

class u implements Runnable {
   // $FF: synthetic field
   final MainMenu a;

   u(MainMenu var1) {
      this.a = var1;
   }

   public void run() {
      try {
         synchronized(this.a) {
            if (!MainMenu.d(this.a)) {
               Main.a();
               MainMenu.a(this.a, true);
            }

            MainMenu.e(this.a).g();
         }
      } catch (Throwable var4) {
         MainMenu.g().log(Level.FINE, "Error writing to Gameband", var4);
      }

   }
}
