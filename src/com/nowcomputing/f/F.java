package com.nowcomputing.f;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class F implements ActionListener {
   // $FF: synthetic field
   final D a;

   F(D var1) {
      this.a = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      D.a(this.a).a(false);
      this.a.c.b();
   }
}
