package com.nowcomputing.b.a.b;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class c extends AbstractAction {
   private int b;
   // $FF: synthetic field
   final mouseHandler a;

   public c(mouseHandler var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      switch(this.b) {
      case 10:
         this.a.a.z();
         break;
      case 37:
         this.a.a(-1, 0);
         break;
      case 38:
         this.a.a(0, -1);
         break;
      case 39:
         this.a.a(1, 0);
         break;
      case 40:
         this.a.a(0, 1);
      }

   }
}
