package com.nowcomputing.uistuff;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class O extends WindowAdapter {
   // $FF: synthetic field
   final GamebandPopup a;

   O(GamebandPopup var1) {
      this.a = var1;
   }

   public void windowClosing(WindowEvent var1) {
      this.a.a(-1);
   }
}
