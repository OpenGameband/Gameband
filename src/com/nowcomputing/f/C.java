package com.nowcomputing.f;

import javax.swing.JLabel;

public class C extends JLabel {
   private int a = 0;
   private String b = "left";

   public C(String var1, int var2) {
      this.a = var2;
      this.setText(var1);
   }

   public C(String var1, int var2, String var3) {
      this.a = var2;
      this.b = var3;
      this.setText(var1);
   }

   public void setText(String var1) {
      if (this.a == 0) {
         this.a = this.getWidth();
      }

      super.setText("<html><div style='width:" + this.a + "px; text-align:" + this.b + "'>" + var1);
   }
}
