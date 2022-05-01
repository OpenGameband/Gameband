package com.nowcomputing.e;

import java.awt.Point;

public class h {
   private Point b;
   private Point c;
   private int d;
   // $FF: synthetic field
   final g a;

   public h(g var1, Point var2, Point var3, int var4) {
      this.a = var1;
      this.c = var2;
      this.b = var3;
      this.d = var4;
   }

   public boolean a(com.nowcomputing.d var1) {
      int var2 = this.c.x;
      Point var10000 = this.c;
      var10000.x -= this.d;
      if (this.c.x < this.b.x) {
         this.c.x = this.b.x;
      }

      var1.a(this.c.x, this.c.y, true);
      if (!this.a.f.a(var2, this.c.y) || this.a.a(new Point(var2, this.c.y))) {
         var1.a(var2, this.c.y, false);
      }

      return this.c.x != this.b.x;
   }
}
