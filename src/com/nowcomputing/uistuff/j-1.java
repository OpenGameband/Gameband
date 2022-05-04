package com.nowcomputing.uistuff;

import com.nowcomputing.LocaleUtil;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class j implements ListSelectionListener {
   // $FF: synthetic field
   final i a;

   j(i var1) {
      this.a = var1;
   }

   public void valueChanged(ListSelectionEvent var1) {
      JList var2 = (JList)var1.getSource();
      String var3 = (String)var2.getSelectedValue();
      LocaleUtil.a(com.nowcomputing.O.a(var3));
   }
}
