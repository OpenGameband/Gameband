package com.nowcomputing;

import java.util.logging.Level;

class x extends Thread {
   // $FF: synthetic field
   final w a;

   x(w var1) {
      this.a = var1;
   }

   public void run() {
      try {
         w.a(this.a, false);
         (new E(3, 400)).a(new y(this));
      } catch (Exception var2) {
         this.a.b = var2;
         w.a.log(Level.WARNING, "Error in update thread", var2);
         if (w.b(this.a) != null) {
            w.b(this.a).b(-1);
         }
      }

   }
}
