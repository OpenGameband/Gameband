package com.nowcomputing.uistuff.b;

import com.nowcomputing.Image;
import com.nowcomputing.AnimatedImage;
import com.nowcomputing.uistuff.apackage.t;

public class k extends e {
   private Image.a a;
   private AnimatedImage.c g;

   public k(t var1, String var2, Image.a var3) {
      super(var1, var2);
      this.a = var3;
      this.g = new AnimatedImage.c();
      var3.a(this.g);
      this.f();
   }

   public Image.g b() {
      return this.a;
   }

   public void a(AnimatedImage var1) {
      this.g.a(var1);
   }

   public AnimatedImage c() {
      return this.g.h();
   }
}
