package com.nowcomputing;

public enum N {
   a("H:mm", "24_HOUR"),
   b("h:mm", "12_HOUR"),
   c("MM·dd", "MONTH_DAY"),
   d("dd·MM", "DAY_MONTH");

   private String e;
   private String f;

   private N(String var3, String var4) {
      this.e = var3;
      this.f = var4;
   }

   public String a() {
      return LocaleUtil.getLocalizedString(this.f);
   }

   public String b() {
      return this.e;
   }
}
