package com.nowcomputing.uistuff.apackage;

import com.nowcomputing.GamebandConfig;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

class c implements ActionListener {
   // $FF: synthetic field
   final p a;
   // $FF: synthetic field
   final a b;

   c(a var1, p var2) {
      this.b = var1;
      this.a = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      JComboBox var2 = (JComboBox)var1.getSource();
      GamebandConfig.d var3 = (GamebandConfig.d)var2.getSelectedItem();
      this.a.e();
      this.a.g().a(var3);
      this.a.d(true);
      if (this.a.d().isVisible()) {
         this.a.f();
      }

   }
}
