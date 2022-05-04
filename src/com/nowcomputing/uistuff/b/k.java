package com.nowcomputing.uistuff.b;

import com.nowcomputing.ImageDoodad;
import com.nowcomputing.otherImageThingy;
import com.nowcomputing.uistuff.a.t;

public class k extends e {
   private ImageDoodad.a a;
   private otherImageThingy.c g;

   public k(t var1, String var2, ImageDoodad.a var3) {
      super(var1, var2);
      this.a = var3;
      this.g = new otherImageThingy.c();
      var3.a(this.g);
      this.f();
   }

   public ImageDoodad.g b() {
      return this.a;
   }

   public void a(otherImageThingy var1) {
      this.g.a(var1);
   }

   public otherImageThingy c() {
      return this.g.h();
   }
}
