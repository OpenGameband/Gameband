package com.nowcomputing.f.b;

import com.nowcomputing.ImageDoodad;
import com.nowcomputing.f.a.t;

public class d extends e {
   private ImageDoodad.c a;
   private com.nowcomputing.a.g g;

   public d(t var1, ImageDoodad.c var2) {
      super(var1, com.nowcomputing.f.a("FREE_SPACE"));
      this.a = var2;
      this.h();
      this.g = new com.nowcomputing.a.g();
      var2.a(this.g);
   }

   public ImageDoodad.g b() {
      return this.a;
   }

   public void d() {
      String var1 = this.a.b();
      this.a(this.e.d().c());
      ImageDoodad var2 = ImageDoodad.a(var1);
      this.a.h().b(var2);
      ImageDoodad var3 = new ImageDoodad(20, 7);
      var3.a(var2, var2.a() - 20, 0, 20, 7, 0, 0);
      this.a.i().a(var3);
      this.a.i().b(new ImageDoodad(20, 7));
      this.g.a(var1, com.nowcomputing.a.h.b, 1000, 20, true);
      super.d();
   }
}
