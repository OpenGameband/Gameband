package com.nowcomputing.b.a;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class f implements ChangeListener {
   // $FF: synthetic field
   final a a;

   f(a var1) {
      this.a = var1;
   }

   public void stateChanged(ChangeEvent var1) {
      JSpinner var2 = (JSpinner)var1.getSource();
      com.nowcomputing.b.a.a.a(this.a).c((Integer)var2.getValue());
   }
}
