package com.nowcomputing.a;

import com.nowcomputing.LocaleUtil;

public enum Direction {
   left("LEFT"),
   right("RIGHT"),
   up("UP"),
   down("DOWN");

   private String text;

   Direction(String var3) {
      this.text = var3;
   }

   public String toString() {
      return LocaleUtil.getLocalizedString(this.text);
   }
}
