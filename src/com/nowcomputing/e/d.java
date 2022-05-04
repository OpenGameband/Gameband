package com.nowcomputing.e;

import com.nowcomputing.LocaleUtil;

public enum d {
   a(0, "TRANSITION_NONE"),
   b(1, "TRANSITION_SCROLL"),
   c(2, "TRANSITION_DISSOLVE"),
   d(3, "TRANSITION_RAIN");

   private int e;
   private String f;

   private d(int var3, String var4) {
      this.e = var3;
      this.f = var4;
   }

   public String a() {
      return LocaleUtil.getLocalizedString(this.f);
   }

   public String toString() {
      return this.a();
   }
}
