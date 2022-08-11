package com.nowcomputing.pixelfurnace;

import com.nowcomputing.TimeDisplay;
import com.nowcomputing.LocaleUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;

public class DateScreen extends Animation {
   public DateScreen(ExecutorService exe) {
      super(getDefaultDateFormat(), exe);
   }

   public DateScreen(GamebandScreen var1, ExecutorService var2) {
      super(var1.getScreenType(), var2);
   }

   public void SetDateFormat(TimeDisplay var1) {
      if (var1 == TimeDisplay.normal) {
         this.a((short)3);
      } else if (var1 == TimeDisplay.crackhead) {
         this.a((short)2);
      }

   }

   public TimeDisplay b() {
      return this.e() == 2 ? TimeDisplay.crackhead : TimeDisplay.normal;
   }

   public GamebandScreen c() {
      if (this.screen == null) {
         this.screen = new GamebandScreen();
         this.screen.c((short)3000);
      }

      this.screen.d(this.j());
      if (this.j() == 0) {
         this.screen.setPauseDuration((int)1000);
      }

      this.screen.setScreenType(this.e());
      return this.screen;
   }

   public static short getDefaultDateFormat() {
      SimpleDateFormat var0 = (SimpleDateFormat)DateFormat.getDateInstance(3, LocaleUtil.a());
      String var1 = var0.toPattern();
      return (short)(var1.equals("M/d/yy") ? 2 : 3);
   }
}
