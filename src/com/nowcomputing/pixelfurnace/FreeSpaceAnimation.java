package com.nowcomputing.pixelfurnace;

import com.nowcomputing.Image;
import com.nowcomputing.LocaleUtil;
import com.nowcomputing.Utils;
import java.text.NumberFormat;
import java.util.concurrent.ExecutorService;

public class FreeSpaceAnimation extends Animation {
   private String f;

   public FreeSpaceAnimation(ExecutorService var1) {
      super((short)17, var1);
      this.a(Utils.c());
   }

   public FreeSpaceAnimation(GamebandScreen var1, ExecutorService var2) {
      super(var1.getScreenType(), var2);
   }

   public void a(long var1) {
      NumberFormat var3 = NumberFormat.getInstance(LocaleUtil.a());
      var3.setMaximumFractionDigits(1);
      long var4 = var1 / 1024L / 1024L;
      if (var4 > 999L) {
         float var6 = (float)var4 / 1024.0F;
         this.f = "Free: " + var3.format((double)var6);
         this.a(this.f, 'G');
      } else {
         this.f = "Free: " + var4;
         this.a(this.f, 'M');
      }

   }

   private void a(String var1, char var2) {
      int var3 = this.f.length();
      if (var3 <= 10) {
         if (var3 > 8) {
            this.f = this.f + var2;
         } else if (var3 > 7) {
            this.f = this.f + var2;
            this.f = this.f + 'B';
         } else if (var3 > 6) {
            this.f = this.f + ' ';
            this.f = this.f + var2;
            this.f = this.f + 'B';
         }

      }
   }

   public String b() {
      return this.f;
   }

   public GamebandScreen getScreen() {
      if (this.screen == null) {
         this.screen = new GamebandScreen();
         this.screen.setPauseMode((short)1);
         this.screen.setPauseDuration((int)1000);
         this.screen.b((int)20);
      }

      this.screen.setScreenType(this.getDateFormat());
      this.screen.d(this.j());
      this.a(Utils.c());
      this.screen.setImage(Image.FromFile(this.b()));
      return this.screen;
   }
}
