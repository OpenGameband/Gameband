package com.nowcomputing.e;

import com.nowcomputing.GamebandConfig;
import com.nowcomputing.Image;
import com.nowcomputing.pixelfurnace.GBTime;

public class e extends funnyImageThing {
   private boolean g;
   private b h;

   public e(b var1) {
      this.h = var1;
   }

   public void b() {
      if (this.h == com.nowcomputing.e.b.b) {
         this.g = false;
         GBTime.getThreadPool().execute(new f(this));
      }

      super.resetTimer();
   }

   public Image e() {
      if (this.h == com.nowcomputing.e.b.b) {
         if (this.g) {
            this.setBool(true);
         }
      } else {
         this.setBool(true);
      }

      return this.image2;
   }

   public boolean isEmpty() {
      if (this.image2 != null) {
         return !this.getBool();
      } else {
         return false;
      }
   }
}
