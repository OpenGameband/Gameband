package com.nowcomputing.uistuff;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class J extends AbstractAction {
   // $FF: synthetic field
   final I a;

   J(I var1) {
      this.a = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.a.dispose();
   }
}
