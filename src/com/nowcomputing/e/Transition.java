package com.nowcomputing.e;

import com.nowcomputing.LocaleUtil;

public enum Transition {
   none(0, "TRANSITION_NONE"),
   scroll(1, "TRANSITION_SCROLL"),
   dissolve(2, "TRANSITION_DISSOLVE"),
   rain(3, "TRANSITION_RAIN");

   private int e;
   private String f;

   Transition(int var3, String var4) {
      this.e = var3;
      this.f = var4;
   }

   public String getLocalizedString() {
      return LocaleUtil.getLocalizedString(this.f);
   }

   public String toString() {
      return this.getLocalizedString();
   }
}
