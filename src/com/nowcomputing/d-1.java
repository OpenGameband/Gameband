package com.nowcomputing;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class d {
   boolean[][] a;
   private int b;
   private int c;

   public d(int var1, int var2) {
      this.b = var1;
      this.c = var2;
      this.a = new boolean[this.b][this.c];
   }

   public d(d var1) {
      this.b = var1.a();
      this.c = var1.b();
      this.a = new boolean[this.b][this.c];

      for(int var2 = 0; var2 < this.c; ++var2) {
         for(int var3 = 0; var3 < this.b; ++var3) {
            this.a[var3][var2] = var1.a[var3][var2];
         }
      }

   }

   public void a(int var1, int var2, boolean var3) {
      if (var1 >= 0 && var1 < this.b && var2 >= 0 && var2 < this.c) {
         this.a[var1][var2] = var3;
      }

   }

   public boolean a(int var1, int var2) {
      return var1 >= 0 && var1 < this.b && var2 >= 0 && var2 < this.c ? this.a[var1][var2] : false;
   }

   public int a() {
      return this.b;
   }

   public int b() {
      return this.c;
   }

   public void a(d var1) {
      this.a((d)var1, 0, 0);
   }

   public void a(d var1, int var2, int var3) {
      this.a(var1, 0, 0, var1.a(), var1.b(), var2, var3);
   }

   public void a(d var1, int var2, int var3, int var4, int var5) {
      this.a(var1, 0, 0, var2, var3, var4, var5);
   }

   public void a(d var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var4; ++var8) {
         for(int var9 = 0; var9 < var5; ++var9) {
            this.a(var8 + var6, var9 + var7, var1.a(var8 + var2, var9 + var3));
         }
      }

   }

   public void c() {
      this.a(0, 0, this.b, this.c);
   }

   public void a(int var1, int var2, int var3, int var4) {
      for(int var5 = var2; var5 < var4; ++var5) {
         for(int var6 = var1; var6 < var3; ++var6) {
            this.a(var6, var5, !this.a(var6, var5));
         }
      }

   }

   public BufferedImage d() {
      BufferedImage var1 = new BufferedImage(this.b, this.c, 2);

      for(int var2 = 0; var2 < this.c; ++var2) {
         for(int var3 = 0; var3 < this.b; ++var3) {
            var1.setRGB(var3, var2, this.a(var3, var2) ? Color.WHITE.getRGB() : Color.BLACK.getRGB());
         }
      }

      return var1;
   }

   public static d a(String var0) {
      return a(o.b(var0));
   }

   public static d a(BufferedImage var0) {
      return a(var0, var0.getWidth(), var0.getHeight());
   }

   public static d a(BufferedImage var0, int var1, int var2) {
      d var3 = new d(var1, var2);
      int var4 = var0.getWidth();
      int var5 = var0.getHeight();

      for(int var6 = 0; var6 < var5; ++var6) {
         for(int var7 = 0; var7 < var4; ++var7) {
            int var8 = var0.getRGB(var7, var6);
            var3.a(var7, var6, var8 != Color.BLACK.getRGB());
         }
      }

      return var3;
   }
}
