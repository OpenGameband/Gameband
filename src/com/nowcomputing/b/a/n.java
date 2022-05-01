package com.nowcomputing.b.a;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.Timer;

public class n extends JComponent {
   private float a;

   public n() {
      Timer var1 = new Timer(100, (ActionListener)null);
      var1.addActionListener(new o(this));
      var1.start();
   }

   public void paintComponent(Graphics var1) {
      super.paintComponent(var1);
      Graphics2D var2 = (Graphics2D)var1;
      var2.setPaint(Color.WHITE);
      BasicStroke var3 = new BasicStroke(1.0F, 0, 2, 1.5F, new float[]{5.0F, 5.0F}, this.a);
      var2.setStroke(var3);
      var2.drawRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);
   }

   // $FF: synthetic method
   static float a(n var0) {
      return ++var0.a;
   }
}
