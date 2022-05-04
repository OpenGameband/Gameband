package com.nowcomputing.uistuff;

import javax.swing.Icon;
import javax.swing.JButton;

public class y extends JButton {
   public y() {
      this((String)null, (Icon)null);
   }

   public y(String var1) {
      this(var1, (Icon)null);
   }

   public y(String var1, Icon var2) {
      super(var1, var2);
      this.setBackground(GamebandColors.c());
      this.setForeground(GamebandColors.d());
   }
}
