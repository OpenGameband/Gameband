package com.nowcomputing.e;

import com.nowcomputing.Image;
import com.nowcomputing.pixelfurnace.GBComms;

public class e extends imageTransition {
   private boolean g;
   private Hand h;

   public e(Hand var1) {
      this.h = var1;
   }

   public void b() {
      if (this.h == Hand.left) {
         this.g = false;
         GBComms.getThreadPool().execute(new f(this));
      }

      super.startTimer();
   }

   public Image e() {
      if (this.h == Hand.left) {
         if (this.g) {
            this.setBool(true);
         }
      } else {
         this.setBool(true);
      }

      return this.endImage;
   }

   public boolean isEmpty() {
      if (this.endImage != null) {
         return !this.getBool();
      } else {
         return false;
      }
   }
}
