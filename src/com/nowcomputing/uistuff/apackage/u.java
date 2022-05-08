package com.nowcomputing.uistuff.apackage;

import javax.swing.text.AttributeSet;
import javax.swing.text.DocumentFilter;

public class u extends DocumentFilter {
   private int a;

   public u(int var1) {
      this.a = var1;
   }

   public void insertString(FilterBypass var1, int var2, String var3, AttributeSet var4) {
      int var5 = var1.getDocument().getLength();
      int var6 = var3.length();
      if (var5 + var6 <= this.a) {
         super.insertString(var1, var2, var3, var4);
      }

   }

   public void replace(FilterBypass var1, int var2, int var3, String var4, AttributeSet var5) {
      int var6 = var1.getDocument().getLength();
      int var7 = var4.length();
      if (var6 + var7 <= this.a) {
         super.replace(var1, var2, var3, var4, var5);
      }

   }
}
