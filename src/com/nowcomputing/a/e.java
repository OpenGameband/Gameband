package com.nowcomputing.a;

import com.nowcomputing.Image;
import com.nowcomputing.AnimatedImage;

import java.util.ArrayList;

public class e extends Transition {
   private Image image;
   private int e;
   private int f;
   private int g;
   private Direction h;
   private boolean i;

   public e(Direction var1, boolean var2) {
      this.h = Direction.left;
      this.h = var1;
      this.i = var2;
   }

   protected void disable() {
      super.disable();
      int n = this.image.getWidth();
      int n2 = this.image.getHeight();
      this.e = this.h == Direction.left || this.h == Direction.right ? (this.i ? 20 + n + 1 : (n < 20 ? 21 : n + 1)) : (this.i ? 7 + n2 + 1 : (n2 < 7 ? 8 : n2 + 1));
      switch (com.nowcomputing.a.f.a[this.h.ordinal()]) {
         case 1: {
            this.f = 20;
            break;
         }
         case 2: {
            this.f = -n;
            break;
         }
         case 3: {
            this.g = 7;
            break;
         }
         case 4: {
            this.g = -n2;
         }
      }
   }

   public boolean isEmpty() {
      if (this.image != null) {
         return !this.getBool();
      } else {
         return false;
      }
   }

   public Image e() {
      Image d2 = null;
      --this.e;
      switch (com.nowcomputing.a.f.a[this.h().ordinal()]) {
         case 1: {
            d2 = this.a(this.image, this.f--, 0);
            break;
         }
         case 2: {
            d2 = this.a(this.image, this.f++, 0);
            break;
         }
         case 3: {
            d2 = this.a(this.image, 0, this.g--);
            break;
         }
         case 4: {
            d2 = this.a(this.image, 0, this.g++);
         }
      }
      if (this.e == 0) {
         this.setBool(true);
      }
      return d2;
   }

   public void a(Image var1) {
      this.image = var1;
   }

   public void a(String var1) {
      this.image = Image.FromFile(var1);
   }

   public Direction h() {
      return this.h;
   }

   private Image a(Image var1, int var2, int var3) {
      Image var4 = new Image(20, 7);
      var4.ramImageInForcefully(var1, var2, var3);
      return var4;
   }

   public AnimatedImage i() {
      this.disable();
      this.setBool(false);
      ArrayList var1 = new ArrayList();

      while(this.isEmpty()) {
         var1.add(this.e());
      }

      return new AnimatedImage(var1, this.randomNumber);
   }
}
