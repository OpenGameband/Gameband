package com.nowcomputing.b.a;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class i implements ChangeListener {
   // $FF: synthetic field
   final a a;

   i(a var1) {
      this.a = var1;
   }

   public void stateChanged(ChangeEvent var1) {
      JSlider var2 = (JSlider)var1.getSource();
      com.nowcomputing.b.a.a.a(this.a, var2.getValue());
      this.a.z();
      this.a.a(com.nowcomputing.b.a.a.d(this.a));
   }
}