package com.nowcomputing.e;

import com.nowcomputing.Image;

public abstract class funnyImageThing extends com.nowcomputing.a.TimerListener {
   protected short d;
   protected Image image1;
   protected Image image2;

   public void a(Image var1) {
      this.image1 = var1;
   }

   public void b(Image var1) {
      this.image2 = var1;
   }

   public short h() {
      return this.d;
   }
}
