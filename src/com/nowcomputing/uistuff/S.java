package com.nowcomputing.uistuff;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class S extends AbstractAction {
   // $FF: synthetic field
   final GamebandDialog a;

   S(GamebandDialog var1) {
      this.a = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      if (GamebandDialog.a(this.a)) {
         this.a.ok();
      }

   }
}
