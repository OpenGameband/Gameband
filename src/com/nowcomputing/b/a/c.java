package com.nowcomputing.b.a;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class c extends MouseAdapter {
   // $FF: synthetic field
   final a a;

   c(a var1) {
      this.a = var1;
   }

   public void mouseEntered(MouseEvent var1) {
      if (this.a.l() != null) {
         this.a.setCursor(this.a.l().b());
      }

   }

   public void mouseExited(MouseEvent var1) {
      this.a.setCursor(Cursor.getPredefinedCursor(0));
   }
}
