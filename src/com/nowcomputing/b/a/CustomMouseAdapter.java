package com.nowcomputing.b.a;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class CustomMouseAdapter extends MouseAdapter {
   // $FF: synthetic field
   final CustomDialog a;

   CustomMouseAdapter(CustomDialog var1) {
      this.a = var1;
   }

   public void mouseEntered(MouseEvent var1) {
      if (this.a.l() != null) {
         this.a.setCursor(Cursor.getPredefinedCursor(0));
      }

   }
}
