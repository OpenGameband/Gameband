package com.nowcomputing.f.b;

import com.nowcomputing.GamebandConfig;
import com.nowcomputing.d.o;
import com.nowcomputing.f.a.t;

public class m extends e {
   private o a;
   private com.nowcomputing.a.g g;

   public m(t var1, o var2, boolean var3) {
      super(var1, com.nowcomputing.f.a("ANIMATION"));
      this.a = var2;
      this.g = new com.nowcomputing.a.g();
      this.a.a(this.g);
      this.a(GamebandConfig.d.a);
      this.a.h().b(new com.nowcomputing.d(20, 7));
      this.a.i().b(new com.nowcomputing.d(20, 7));
      this.g.a(var2.b(), com.nowcomputing.a.h.a, 0, 20);
      this.f();
   }

   public com.nowcomputing.d.g b() {
      return this.a;
   }
}
