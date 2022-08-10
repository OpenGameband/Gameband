package com.nowcomputing.a;

import com.nowcomputing.Image;

public class g extends TimerListener {
   private Image image;
   private int e;
   private int f;
   private duality g;
   private int h;
   private int i;
   private int j;
   private boolean k;

   public void a(String var1, duality var2, int var3, int var4, boolean var5) {
      this.image = Image.FromFile(var1);
      this.g = var2;
      this.h = var3;
      this.i = var4;
      this.k = var5;
   }

   public void a(Image var1, duality var2, int var3, int var4) {
      this.image = var1;
      this.g = var2;
      this.h = var3;
      this.i = var4;
   }

   protected void disable() {
      super.disable();
      if (this.g != duality.a && !this.k) {
         this.e = this.image.getWidth();
         this.f = 20;
      } else {
         this.e = this.image.getWidth() - 20;
         this.f = 0;
      }

      if (this.i > 0) {
         this.a(this.i);
      }

      this.j = (int)((float)this.f() * ((float)this.h / 1000.0F));
   }

   public boolean isEmpty() {
      if (this.image != null) {
         return !this.getBool();
      } else {
         return false;
      }
   }

   public Image e() {
      if (this.g == duality.a && this.f == 0) {
         if (--this.j > 0) {
            return this.image;
         }
      } else if (this.g == duality.b && this.f == 20 - this.image.getWidth() && --this.j > 0) {
         return this.a(this.image, this.f, 0);
      }

      Image var1 = null;
      var1 = this.a(this.image, this.f--, 0);
      if (--this.e < 0) {
         this.setBool(true);
      }

      return var1;
   }

   private Image a(Image var1, int var2, int var3) {
      Image var4 = new Image(20, 7);
      var4.ramImageInForcefully(var1, var2, var3);
      return var4;
   }
}
