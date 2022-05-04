package com.nowcomputing.uistuff;

import com.nowcomputing.LocaleUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

class af implements ActionListener {
   // $FF: synthetic field
   final aa a;

   af(aa var1) {
      this.a = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      JComboBox var2 = (JComboBox)var1.getSource();
      String var3 = (String)var2.getSelectedItem();
      LocaleUtil.a(com.nowcomputing.O.a(var3));
      this.a.d().a(true);
   }
}
