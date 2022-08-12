package com.nowcomputing.uistuff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class V implements ActionListener {
   // $FF: synthetic field
   final GamebandDialog a;

   V(GamebandDialog var1) {
      this.a = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.a.close();
   }
}
