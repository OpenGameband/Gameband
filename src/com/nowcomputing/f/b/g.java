package com.nowcomputing.f.b;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class g implements ItemListener {
   // $FF: synthetic field
   final e a;

   g(e var1) {
      this.a = var1;
   }

   public void itemStateChanged(ItemEvent var1) {
      if (!this.a.e.a(this.a, var1.getStateChange() == 1)) {
         this.a.c.setSelected(false);
      }

   }
}
