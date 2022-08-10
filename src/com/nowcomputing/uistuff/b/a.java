package com.nowcomputing.uistuff.b;

import com.nowcomputing.GamebandConfig;
import com.nowcomputing.Image;
import com.nowcomputing.LocaleUtil;
import com.nowcomputing.AnimatedImage;
import com.nowcomputing.uistuff.apackage.t;
import java.io.File;

public class a extends e {
   private Image.a a;
   private AnimatedImage.c g;

   public a(t var1, Image.a var2) {
      super(var1, LocaleUtil.getLocalizedString("ANIMATION"));
      this.a = var2;
      this.g = new AnimatedImage.c();
      var2.a(this.g);
      this.b().b(GamebandConfig.c.b(GamebandConfig.d.a));
      var2.i().b(new Image(20, 7));
      this.i();
      this.f();
   }

   public Image.g b() {
      return this.a;
   }

   public void a(File var1) {
      this.g.a(var1);
   }

   public void a(AnimatedImage var1) {
      this.g.a(var1);
   }

   public AnimatedImage c() {
      return this.g.h();
   }

   public void a(GamebandConfig.d var1) {
   }
}
