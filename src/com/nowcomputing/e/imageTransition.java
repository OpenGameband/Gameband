package com.nowcomputing.e;

import com.nowcomputing.Image;

public abstract class imageTransition extends com.nowcomputing.a.TimerListener {
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
