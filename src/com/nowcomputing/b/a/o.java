package com.nowcomputing.b.a;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class o implements ActionListener {
   // $FF: synthetic field
   final n a;

   o(n var1) {
      this.a = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      n.a(this.a);
      this.a.repaint();
   }
}
