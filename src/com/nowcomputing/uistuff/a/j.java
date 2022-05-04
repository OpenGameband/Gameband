package com.nowcomputing.uistuff.a;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

class j implements ActionListener {
   // $FF: synthetic field
   final f a;

   j(f var1) {
      this.a = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      f.d(this.a).setSelected(true);
      int var2 = f.e(this.a).showOpenDialog(this.a);
      if (var2 == 0) {
         File var3 = f.e(this.a).getSelectedFile();
         if (var3 != null) {
            f.f(this.a).setText(var3.getName());
         }
      }

   }
}
