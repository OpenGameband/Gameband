package com.nowcomputing.uistuff;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class T extends WindowAdapter {
   // $FF: synthetic field
   final GamebandDialog a;

   T(GamebandDialog var1) {
      this.a = var1;
   }

   public void windowClosing(WindowEvent var1) {
      this.a.ok();
   }
}
