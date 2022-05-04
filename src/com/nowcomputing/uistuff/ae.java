package com.nowcomputing.uistuff;

import com.nowcomputing.LocaleUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

class ae implements ActionListener {
   // $FF: synthetic field
   final aa a;

   ae(aa var1) {
      this.a = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      JComboBox var2 = (JComboBox)var1.getSource();
      LocaleUtil.a(aa.a(this.a)[var2.getSelectedIndex()].getLocale());
   }
}
