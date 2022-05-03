package com.nowcomputing.b.a.a;

import com.nowcomputing.LockingUtil;

import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class d extends b {
   public d(LockingUtil.a.a var1, String var2, ImageIcon var3, String var4, Integer var5, KeyStroke var6) {
      super(var1, var2, var3, var4, var5, var6);
      this.setEnabled(false);
   }

   public void actionPerformed(ActionEvent var1) {
      this.a.y();
      this.a.j();
      this.a.h();
   }
}
