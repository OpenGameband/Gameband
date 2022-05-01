package com.nowcomputing.b.a;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLayeredPane;

public class m extends JLayeredPane {
   private Image a;

   public m(String var1) {
      try {
         this.a = ImageIO.read(this.getClass().getResource(var1));
      } catch (IOException var3) {
         var3.printStackTrace();
      }

   }

   public void paintComponent(Graphics var1) {
      super.paintComponent(var1);
      var1.drawImage(this.a, 0, 0, this.getWidth(), this.getHeight(), (ImageObserver)null);
   }
}
