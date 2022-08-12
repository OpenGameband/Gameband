package com.nowcomputing.e;

import com.nowcomputing.Image;
import com.nowcomputing.a.Transition;

public abstract class imageTransition extends Transition {
   protected short speed; // ?
   protected Image startImage;
   protected Image endImage;

   public void a(Image var1) {
      this.startImage = var1;
   }

   public void b(Image var1) {
      this.endImage = var1;
   }

   public short h() {
      return this.speed;
   }
}
