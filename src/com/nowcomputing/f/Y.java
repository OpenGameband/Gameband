package com.nowcomputing.f;

import com.sun.java.swing.Painter;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.AbstractButton;
import javax.swing.JComponent;

public class Y implements Painter {
   public void a(Graphics2D var1, JComponent var2, int var3, int var4) {
      var1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      if (var2 instanceof AbstractButton) {
         AbstractButton var5 = (AbstractButton)var2;
         if (var5.getModel().isPressed()) {
            var1.setColor(var2.getBackground().darker());
         } else if (var5.getModel().isRollover()) {
            var1.setColor(var2.getBackground().brighter());
         } else {
            var1.setColor(var2.getBackground());
         }
      } else {
         var1.setColor(var2.getBackground());
      }

      var1.fillRect(0, 0, var3 - 1, var4 - 1);
   }

   // $FF: synthetic method
   public void paint(Graphics2D var1, Object var2, int var3, int var4) {
      this.a(var1, (JComponent)var2, var3, var4);
   }
}
