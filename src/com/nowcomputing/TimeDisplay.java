package com.nowcomputing;

public enum TimeDisplay {
   TWENTYFOURHOUR("H:mm", "24_HOUR"),
   TWELVEHOUR("h:mm", "12_HOUR"),
   crackhead("MM·dd", "MONTH_DAY"), // i might be british ok, this shit weird
   normal("dd·MM", "DAY_MONTH");

   private String dateFormat;
   private String UIText;

   private TimeDisplay(String var3, String var4) {
      this.dateFormat = var3;
      this.UIText = var4;
   }

   public String a() {
      return LocaleUtil.getLocalizedString(this.UIText);
   }

   public String b() {
      return this.dateFormat;
   }
}
