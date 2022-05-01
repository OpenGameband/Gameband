package com.nowcomputing.b.a;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class e implements ChangeListener {
   // $FF: synthetic field
   final a a;

   e(a var1) {
      this.a = var1;
   }

   public void stateChanged(ChangeEvent var1) {
      JSpinner var2 = (JSpinner)var1.getSource();
      com.nowcomputing.b.a.a.a(this.a).b((Integer)var2.getValue());
      com.nowcomputing.b.a.a.b(this.a).setMaximum(com.nowcomputing.b.a.a.a(this.a).a() - 1);
      com.nowcomputing.b.a.a.c(this.a).o().setEnabled(com.nowcomputing.b.a.a.a(this.a).a() > 1);
      com.nowcomputing.b.a.a.c(this.a).n().setEnabled(com.nowcomputing.b.a.a.a(this.a).a() < 50);
      com.nowcomputing.b.a.a.c(this.a).q().setEnabled(com.nowcomputing.b.a.a.a(this.a).a() < 50);
   }
}
