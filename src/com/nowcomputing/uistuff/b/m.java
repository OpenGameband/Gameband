package com.nowcomputing.uistuff.b;

import com.nowcomputing.GamebandConfig;
import com.nowcomputing.ImageDoodad;
import com.nowcomputing.ImageDoodad.o;
import com.nowcomputing.LocaleUtil;
import com.nowcomputing.otherImageThingy;
import com.nowcomputing.uistuff.a.t;

public class m extends e {
   private o a;
   private otherImageThingy.g g;

   public m(t var1, o var2, boolean var3) {
      super(var1, LocaleUtil.getLocalizedString("ANIMATION"));
      this.a = var2;
      this.g = new otherImageThingy.g();
      this.a.a(this.g);
      this.a(GamebandConfig.d.a);
      this.a.h().b(new ImageDoodad(20, 7));
      this.a.i().b(new ImageDoodad(20, 7));
      this.g.a(var2.b(), otherImageThingy.h.a, 0, 20);
      this.f();
   }

   public ImageDoodad.g b() {
      return this.a;
   }
}
