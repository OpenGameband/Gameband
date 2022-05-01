package com.nowcomputing;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class o {
   private static Font a;
   private static FontMetrics b;
   private static BufferedImage c = new BufferedImage(20, 7, 2);

   public static Font a(int var0) {
      return new Font("gameband", 0, var0);
   }

   public static int a(String var0) {
      Graphics var1 = c.getGraphics();
      if (b == null && var1 != null) {
         b = var1.getFontMetrics(a);
      }

      return b != null ? b.stringWidth(var0) : 0;
   }

   public static BufferedImage b(String var0) {
      byte var1 = 7;
      int var2 = a(var0);
      if (var2 == 0) {
         var2 = 20;
      }

      int var3 = 1;
      if (b != null) {
         var3 = (int)Math.floor((double)b.getDescent());
      }

      BufferedImage var4 = new BufferedImage(var2, var1, 2);
      Graphics2D var5 = var4.createGraphics();
      var5.setColor(Color.BLACK);
      var5.fillRect(0, 0, var2, var1);
      var5.setColor(Color.WHITE);
      var5.setFont(a);
      var5.drawString(var0, 0, var1 - var3);
      var5.dispose();
      return var4;
   }

   static {
      com.nowcomputing.f.q.a("/resources/gameband.ttf");
      a = a(8);
   }
}
