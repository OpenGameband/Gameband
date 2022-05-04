package com.nowcomputing.uistuff;

import com.nowcomputing.ImageDoodad;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import javax.swing.JPanel;

public class n extends JPanel {
   public static final Color a;
   private final L[][] b = new L[20][7];
   private int c;

   public n(Color var1, Color var2, int var3) {
      this.c = var3;
      GridLayout var4 = new GridLayout(7, 20, var3, var3);
      this.setLayout(var4);
      this.setBackground(var1);

      for(int var5 = 0; var5 < 7; ++var5) {
         for(int var6 = 0; var6 < 20; ++var6) {
            this.b[var6][var5] = new L(var2);
            this.add(this.b[var6][var5]);
         }
      }

   }

   public void setOpaque(boolean var1) {
      super.setOpaque(var1);
      if (this.b != null) {
         for(int var2 = 0; var2 < 7; ++var2) {
            for(int var3 = 0; var3 < 20; ++var3) {
               if (this.b[var3][var2] != null) {
                  this.b[var3][var2].setOpaque(var1);
               }
            }
         }
      }

   }

   public void a(int var1, int var2, boolean var3) {
      if (var1 >= 0 && var1 < 20 && var2 >= 0 && var2 < 7) {
         this.b[var1][var2].a(var3);
      }

   }

   public void a(boolean var1) {
      for(int var2 = 0; var2 < 20; ++var2) {
         for(int var3 = 0; var3 < 7; ++var3) {
            this.a(var2, var3, var1);
         }
      }

   }

   public void a(ImageDoodad var1, int var2, int var3) {
      int var4 = var1.a();
      int var5 = var1.b();

      for(int var6 = 0; var6 < var5; ++var6) {
         for(int var7 = 0; var7 < var4; ++var7) {
            this.a(var7 + var2, var6 + var3, var1.a(var7, var6));
         }
      }

      this.repaint();
   }

   public ImageDoodad a() {
      ImageDoodad var1 = new ImageDoodad(20, 7);

      for(int var2 = 0; var2 < 7; ++var2) {
         for(int var3 = 0; var3 < 20; ++var3) {
            var1.a(var3, var2, this.b[var3][var2].a());
         }
      }

      return var1;
   }

   public Point a(L var1) {
      for(int var2 = 0; var2 < 7; ++var2) {
         for(int var3 = 0; var3 < 20; ++var3) {
            if (var1 == this.b[var3][var2]) {
               return new Point(var3, var2);
            }
         }
      }

      return new Point(0, 0);
   }

   public Point a(int var1, int var2) {
      int var3 = this.b[0][0].getWidth() + this.c;
      int var4 = this.b[0][0].getHeight() + this.c;
      return new Point(var1 / var3, var2 / var4);
   }

   public L b(int var1, int var2) {
      return this.b[var1][var2];
   }

   static {
      a = Color.BLACK;
   }
}
