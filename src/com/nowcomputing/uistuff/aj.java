package com.nowcomputing.uistuff;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class aj extends WindowAdapter {
   // $FF: synthetic field
   final ai a;

   aj(ai var1) {
      this.a = var1;
   }

   public void windowClosing(WindowEvent var1) {
      this.a.a = true;
      if (ai.a(this.a).e()) {
         ai.b(this.a);
      }

   }
}
