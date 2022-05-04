package com.nowcomputing.b.a;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class d implements ActionListener {
   // $FF: synthetic field
   final CustomDialog a;

   d(CustomDialog var1) {
      this.a = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.a.z();
      this.a.dispose();
   }
}
