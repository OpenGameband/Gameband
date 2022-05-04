package com.nowcomputing.uistuff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class K implements ActionListener {
   // $FF: synthetic field
   final I a;

   K(I var1) {
      this.a = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.a.dispose();
   }
}
