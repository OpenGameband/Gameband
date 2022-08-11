package com.nowcomputing.e;

import com.nowcomputing.Image;

public class j extends imageTransition {
   protected int g;
   protected l h;
   private Hand i;

   public j(Hand var1) {
      this.h = l.a;
      this.i = var1;
      this.speed = 1;
   }

   protected void disable() {
      // $FF: Couldn't be decompiled
   }

   public Image e() {
      // $FF: Couldn't be decompiled
   }

   public boolean isEmpty() {
      if (this.endImage != null) {
         return this.g > 0;
      } else {
         return false;
      }
   }

   protected Image a(Image var1, int var2, int var3) {
      Image var4 = new Image(20, 7);
      var4.ramImageInForcefully(var1, var2, var3);
      return var4;
   }
}
