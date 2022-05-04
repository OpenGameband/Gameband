package com.nowcomputing.uistuff;

import com.nowcomputing.Main;
import java.util.logging.Level;

class u implements Runnable {
   // $FF: synthetic field
   final s a;

   u(s var1) {
      this.a = var1;
   }

   public void run() {
      try {
         synchronized(this.a) {
            if (!s.d(this.a)) {
               Main.a();
               s.a(this.a, true);
            }

            s.e(this.a).g();
         }
      } catch (Throwable var4) {
         s.g().log(Level.FINE, "Error writing to Gameband", var4);
      }

   }
}
