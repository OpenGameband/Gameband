package com.nowcomputing.b.a.a;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class s extends DialogButton {
   public s(com.nowcomputing.b.a.CustomDialog var1, String var2, ImageIcon var3, String var4, Integer var5, KeyStroke var6) {
      super(var1, var2, var3, var4, var5, var6);
      this.setEnabled(false);
   }

   public void actionPerformed(ActionEvent var1) {
      this.a.a((Rectangle)null);
   }
}
