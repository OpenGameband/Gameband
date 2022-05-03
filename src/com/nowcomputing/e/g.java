package com.nowcomputing.e;

import com.nowcomputing.GamebandConfig;
import com.nowcomputing.ImageDoodad;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class g extends a {
   private List h;
   private List i = new ArrayList();
   Random g = new Random();
   private ImageDoodad j;
   private b k;

   g(b var1) {
      this.k = var1;
      this.d = 3;
   }

   protected void a() {
      if (this.f != null) {
         this.j = new ImageDoodad(20, 7);
         if (this.e != null) {
            this.j.a(this.e);
         }

         this.h = new ArrayList(140);

         for(int var1 = 0; var1 < 20; ++var1) {
            for(int var2 = 0; var2 < 7; ++var2) {
               if (this.k == GamebandConfig.b.a && this.f.a(var1, var2)) {
                  this.h.add(new Point(var1, var2));
               } else if (this.k == GamebandConfig.b.b && this.e.a(var1, var2)) {
                  this.h.add(new Point(var1, var2));
               }
            }
         }
      }

      super.a();
   }

   public boolean a(Point var1) {
      return this.h.contains(var1);
   }

   public ImageDoodad e() {
      this.b(1);
      this.i();
      if (this.h.size() == 0 && this.i.size() == 0) {
         this.a(true);
      }

      return this.j;
   }

   private void b(int var1) {
      for(int var2 = 0; var2 < var1; ++var2) {
         if (this.h.size() > 0) {
            int var3 = Math.min(this.g.nextInt(3), this.h.size() - 1);
            Point var4 = (Point)this.h.remove(var3);
            if (this.k == GamebandConfig.b.a) {
               this.i.add(new h(this, new Point(20, var4.y), var4, 1));
            } else {
               this.i.add(new h(this, var4, new Point(-1, var4.y), 1));
            }
         }
      }

   }

   private void i() {
      Iterator var1 = this.i.iterator();

      while(var1.hasNext()) {
         h var2 = (h)var1.next();
         if (!var2.a(this.j)) {
            var1.remove();
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
