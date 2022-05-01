package com.nowcomputing.f;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.SwingUtilities;

class ac implements ActionListener {
   // $FF: synthetic field
   final aa a;

   ac(aa var1) {
      this.a = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      JComboBox var2 = (JComboBox)var1.getSource();
      a.e var3 = (a.e)var2.getSelectedItem();
      SwingUtilities.invokeLater(new ad(this, var3));
   }
}
