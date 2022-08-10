package com.nowcomputing.uistuff.b;

import com.nowcomputing.GamebandConfig;
import com.nowcomputing.Image;
import com.nowcomputing.Image.o;
import com.nowcomputing.LocaleUtil;
import com.nowcomputing.AnimatedImage;
import com.nowcomputing.uistuff.apackage.t;

public class m extends e {
   private o a;
   private AnimatedImage.g g;

   public m(t var1, o var2, boolean var3) {
      super(var1, LocaleUtil.getLocalizedString("ANIMATION"));
      this.a = var2;
      this.g = new AnimatedImage.g();
      this.a.a(this.g);
      this.a(GamebandConfig.d.a);
      this.a.h().b(new Image(20, 7));
      this.a.i().b(new Image(20, 7));
      this.g.a(var2.b(), AnimatedImage.h.a, 0, 20);
      this.f();
   }

   public Image.g b() {
      return this.a;
   }
}
