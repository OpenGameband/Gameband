package com.nowcomputing.f;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

class g implements ActionListener {
   // $FF: synthetic field
   final Locale a;
   // $FF: synthetic field
   final f b;

   g(f var1, Locale var2) {
      this.b = var1;
      this.a = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      com.nowcomputing.f.a(this.a);
      this.b.c.b();
   }
}
