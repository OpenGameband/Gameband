package com.nowcomputing.b.a;

import com.nowcomputing.LockingUtil;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class e implements ChangeListener {
   // $FF: synthetic field
   final CustomDialog a;

   e(CustomDialog var1) {
      this.a = var1;
   }

   public void stateChanged(ChangeEvent var1) {
      JSpinner var2 = (JSpinner)var1.getSource();
      LockingUtil.logger.a.a(this.a).b((Integer)var2.getValue());
      LockingUtil.logger.a.b(this.a).setMaximum(LockingUtil.logger.a.a(this.a).a() - 1);
      LockingUtil.logger.a.c(this.a).o().setEnabled(LockingUtil.logger.a.a(this.a).a() > 1);
      LockingUtil.logger.a.c(this.a).n().setEnabled(LockingUtil.logger.a.a(this.a).a() < 50);
      LockingUtil.logger.a.c(this.a).q().setEnabled(LockingUtil.logger.a.a(this.a).a() < 50);
   }
}
