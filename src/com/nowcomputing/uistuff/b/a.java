package com.nowcomputing.uistuff.b;

import com.nowcomputing.GamebandConfig;
import com.nowcomputing.ImageDoodad;
import com.nowcomputing.LocaleUtil;
import com.nowcomputing.otherImageThingy;
import com.nowcomputing.uistuff.a.t;
import java.io.File;

public class a extends e {
   private ImageDoodad.a a;
   private otherImageThingy.c g;

   public a(t var1, ImageDoodad.a var2) {
      super(var1, LocaleUtil.getLocalizedString("ANIMATION"));
      this.a = var2;
      this.g = new otherImageThingy.c();
      var2.a(this.g);
      this.b().b(GamebandConfig.c.b(GamebandConfig.d.a));
      var2.i().b(new ImageDoodad(20, 7));
      this.i();
      this.f();
   }

   public ImageDoodad.g b() {
      return this.a;
   }

   public void a(File var1) {
      this.g.a(var1);
   }

   public void a(otherImageThingy var1) {
      this.g.a(var1);
   }

   public otherImageThingy c() {
      return this.g.h();
   }

   public void a(GamebandConfig.d var1) {
   }
}
