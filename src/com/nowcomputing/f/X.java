package com.nowcomputing.f;

import com.sun.java.swing.Painter;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class X implements Painter {
   public void a(Graphics2D var1, JComponent var2, int var3, int var4) {
      var1.setColor(var2.getBackground());
      var1.setStroke(new BasicStroke(4.0F));
      var1.drawRect(0, 0, var3, var4);
   }

   // $FF: synthetic method
   public void paint(Graphics2D var1, Object var2, int var3, int var4) {
      this.a(var1, (JComponent)var2, var3, var4);
   }
}
