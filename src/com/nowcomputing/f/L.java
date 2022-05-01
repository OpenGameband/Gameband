package com.nowcomputing.f;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class L extends JComponent {
   static BufferedImage a;
   private boolean b;

   public L(Color var1) {
      this.setBackground(var1);
      if (a == null) {
         try {
            a = ImageIO.read(this.getClass().getResource("/resources/led.png"));
            h.a(a, h.a());
         } catch (IOException var3) {
            var3.printStackTrace();
         }
      }

   }

   public boolean a() {
      return this.b;
   }

   public void a(boolean var1) {
      this.b = var1;
   }

   public void paintComponent(Graphics var1) {
      if (this.isOpaque()) {
         var1.setColor(this.getBackground());
         var1.fillRect(0, 0, this.getWidth(), this.getHeight());
      }

      if (this.b) {
         var1.drawImage(a, 0, 0, this.getWidth(), this.getHeight(), (ImageObserver)null);
      }

   }
}
