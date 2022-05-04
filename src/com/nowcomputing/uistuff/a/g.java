package com.nowcomputing.uistuff.a;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

class g implements FocusListener {
   // $FF: synthetic field
   final f a;

   g(f var1) {
      this.a = var1;
   }

   public void focusLost(FocusEvent var1) {
   }

   public void focusGained(FocusEvent var1) {
      f.a(this.a).setSelected(true);
   }
}
