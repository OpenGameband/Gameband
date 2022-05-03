package com.nowcomputing.e;

import com.nowcomputing.ImageDoodad;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class i extends a {
   private List h;
   Random g = new Random();
   private ImageDoodad i;

   i() {
      this.d = 2;
   }

   protected synchronized void a() {
      this.i = new ImageDoodad(20, 7);
      if (this.e != null) {
         this.i.a(this.e, 20, 7, 0, 0);
      }

      this.h = new ArrayList(140);

      for(int var1 = 0; var1 < 7; ++var1) {
         for(int var2 = 0; var2 < 20; ++var2) {
            this.h.add(new Point(var2, var1));
         }
      }

      super.a();
   }

   public synchronized ImageDoodad e() {
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
            this.i.a(var4.x, var4.y, this.f.a(var4.x, var4.y));
         }
      }

   }

   public boolean d() {
      if (this.f != null) {
         return !this.g();
      } else {
         return false;
      }
   }
}
