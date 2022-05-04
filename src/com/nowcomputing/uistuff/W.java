package com.nowcomputing.uistuff;

import com.sun.java.swing.Painter;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class W implements Painter {
   public void a(Graphics2D var1, JComponent var2, int var3, int var4) {
      var1.setColor(GamebandColors.a());
      var1.fillRect(3, 3, var3 - 6, var4 - 6);
   }

   // $FF: synthetic method
   public void paint(Graphics2D var1, Object var2, int var3, int var4) {
      this.a(var1, (JComponent)var2, var3, var4);
   }
}
