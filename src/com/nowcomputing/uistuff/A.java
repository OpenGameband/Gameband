package com.nowcomputing.uistuff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class A implements ActionListener {
   // $FF: synthetic field
   final dialogPanel a;

   A(dialogPanel var1) {
      this.a = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.a.l();
   }
}
