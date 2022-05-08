package com.nowcomputing.uistuff.b;

import com.nowcomputing.GamebandConfig;
import com.nowcomputing.ImageDoodad;
import com.nowcomputing.LocaleUtil;
import com.nowcomputing.otherImageThingy;
import com.nowcomputing.uistuff.apackage.t;

public class j extends k {
   public j(t var1, ImageDoodad.a var2, ImageDoodad var3, otherImageThingy.d var4, boolean var5) {
      super(var1, LocaleUtil.getLocalizedString("ANIMATION"), var2);
      otherImageThingy.e var6 = new otherImageThingy.e(var4, var5);
      var6.a(var3);
      this.a(var6.i());
   }

   public void a(GamebandConfig.d var1) {
   }
}
