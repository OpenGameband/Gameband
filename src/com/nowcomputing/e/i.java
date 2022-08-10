package com.nowcomputing.e;

import com.nowcomputing.Image;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class i extends funnyImageThing {
   private List h;
   Random g = new Random();
   private Image i;

   i() {
      this.d = 2;
   }

   protected synchronized void disable() {
      this.i = new Image(20, 7);
      if (this.image1 != null) {
         this.i.ramImageIn(this.image1, 20, 7, 0, 0);
      }

      this.h = new ArrayList(140);

      for(int var1 = 0; var1 < 7; ++var1) {
         for(int var2 = 0; var2 < 20; ++var2) {
            this.h.add(new Point(var2, var1));
         }
      }

      super.disable();
   }

   public synchronized Image e() {
      this.b(8);
      if (this.h.size() == 0) {
         this.a(true);
      }

      return this.i;
   }

   private void b(int var1) {
      for(int var2 = 0; var2 < var1; ++var2) {
         if (this.h.size() > 0) {
            int var3 = this.g.nextInt(this.h.size());
            Point var4 = (Point)this.h.remove(var3);
            this.i.setPixel(var4.x, var4.y, this.image2.getPixel(var4.x, var4.y));
         }
      }

   }

   public boolean isEmpty() {
      if (this.image2 != null) {
         return !this.g();
      } else {
         return false;
      }
   }
}
