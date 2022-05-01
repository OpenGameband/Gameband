package com.nowcomputing.b.a.a;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public abstract class b extends AbstractAction {
   protected com.nowcomputing.b.a.a a;

   public b(com.nowcomputing.b.a.a var1, String var2, ImageIcon var3, String var4, Integer var5, KeyStroke var6) {
      super(var2, var3);
      this.a = var1;
      this.putValue("ShortDescription", var4);
      this.putValue("MnemonicKey", var5);
      if (var6 != null) {
         this.putValue("AcceleratorKey", var6);
      }

   }
}
