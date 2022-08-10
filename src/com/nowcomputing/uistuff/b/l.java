package com.nowcomputing.uistuff.b;

import com.nowcomputing.GamebandConfig;
import com.nowcomputing.Image;
import com.nowcomputing.LocaleUtil;
import com.nowcomputing.AnimatedImage;
import com.nowcomputing.uistuff.apackage.t;

public class l extends k {
   public l(t var1, Image.a var2, String var3, AnimatedImage.d var4, boolean var5) {
      super(var1, LocaleUtil.getLocalizedString("ANIMATION"), var2);
      AnimatedImage.e var6 = new AnimatedImage.e(var4, var5);
      var6.a(var3);
      this.a(var6.i());
   }

   public void a(GamebandConfig.d var1) {
   }
}
