package com.nowcomputing.f;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class a extends JPanel {
   private Image a;

   public a() {
      this("/resources/background.png");
   }

   public a(String var1) {
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
