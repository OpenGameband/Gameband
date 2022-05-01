package com.nowcomputing.f.b;

import com.nowcomputing.GamebandConfig;
import com.nowcomputing.f.a.t;
import java.io.File;

public class a extends e {
   private com.nowcomputing.d.a a;
   private com.nowcomputing.a.c g;

   public a(t var1, com.nowcomputing.d.a var2) {
      super(var1, com.nowcomputing.f.a("ANIMATION"));
      this.a = var2;
      this.g = new com.nowcomputing.a.c();
      var2.a(this.g);
      this.b().b(GamebandConfig.c.b(GamebandConfig.d.a));
      var2.i().b(new com.nowcomputing.d(20, 7));
      this.i();
      this.f();
   }

   public com.nowcomputing.d.g b() {
      return this.a;
   }

   public void a(File var1) {
      this.g.a(var1);
   }

   public void a(com.nowcomputing.a var1) {
      this.g.a(var1);
   }

   public com.nowcomputing.a c() {
      return this.g.h();
   }

   public void a(GamebandConfig.d var1) {
   }
}
