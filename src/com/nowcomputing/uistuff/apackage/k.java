package com.nowcomputing.uistuff.apackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

class k implements ActionListener {
   // $FF: synthetic field
   final f a;

   k(f var1) {
      this.a = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      f.g(this.a).setSelected(true);
      int var2 = f.h(this.a).showOpenDialog(this.a);
      if (var2 == 0) {
         File var3 = f.h(this.a).getSelectedFile();
         if (var3 != null) {
            f.i(this.a).setText(var3.getName());
         }
      }

   }
}
