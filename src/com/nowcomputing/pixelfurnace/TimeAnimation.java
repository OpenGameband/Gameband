package com.nowcomputing.pixelfurnace;

import com.nowcomputing.TimeDisplay;
import com.nowcomputing.LocaleUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;

public class TimeAnimation extends Animation {
   public TimeAnimation(ExecutorService var1) {
      super(d(), var1);
   }

   public TimeAnimation(GamebandScreen var1, ExecutorService var2) {
      super(var1.getScreenType(), var2);
   }

   public void a(TimeDisplay var1) {
      if (var1 == TimeDisplay.TWELVEHOUR) {
         this.a((short)0);
      } else if (var1 == TimeDisplay.TWENTYFOURHOUR) {
         this.a((short)1);
      }

   }

   public TimeDisplay b() {
      return this.e() == 0 ? TimeDisplay.TWELVEHOUR : TimeDisplay.TWENTYFOURHOUR;
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

   public static short d() {
      SimpleDateFormat var0 = (SimpleDateFormat)DateFormat.getTimeInstance(3, LocaleUtil.a());
      String var1 = var0.toPattern();
      return (short)(var1.equals("h:mm a") ? 0 : 1);
   }
}
