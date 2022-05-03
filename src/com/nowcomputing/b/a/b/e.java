package com.nowcomputing.b.a.b;

import com.nowcomputing.LockingUtil;
import com.nowcomputing.Utils;
import com.nowcomputing.f.L;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public class e extends a {
   private Point b;
   private boolean c;
   private L d;
   private L e;

   e(LockingUtil.a.a var1) {
      super(var1);
   }

   public void a() {
   }

   public void c() {
   }

   public Cursor b() {
      return Cursor.getPredefinedCursor(1);
   }

   public void mousePressed(MouseEvent var1) {
      this.c = false;
      this.a.f();
   }

   public void mouseDragged(MouseEvent var1) {
      if (!this.c) {
         this.c = true;
         this.b = this.a.a(var1.getLocationOnScreen());
         this.a.e();
         this.a.a(this.b.x, this.b.y, 1, 1);
         this.d = (L)var1.getSource();
      } else {
         Point var2 = this.a.a(var1.getLocationOnScreen());
         int var3 = Math.abs(var2.x - this.b.x);
         int var4 = Math.abs(var2.y - this.b.y);
         int var5 = var2.x > this.b.x ? this.b.x : this.b.x - var3;
         int var6 = var2.y > this.b.y ? this.b.y : this.b.y - var4;
         this.a.a(var5, var6, var3, var4);
      }

      this.a.getContentPane().repaint();
   }

   public void mouseReleased(MouseEvent var1) {
      if (this.c) {
         this.c = false;
         Point var2 = this.a.b().a(this.d);
         int var3 = this.d.getX() + var1.getPoint().x;
         var3 = Utils.a(var3, 0, this.a.b().getWidth());
         int var4 = this.d.getY() + var1.getPoint().y;
         var4 = Utils.a(var4, 0, this.a.b().getHeight());
         Point var5 = this.a.b().a(var3, var4);
         Point var6 = new Point(Math.min(var2.x, var5.x), Math.min(var2.y, var5.y));
         Point var7 = new Point(Math.max(var2.x, var5.x), Math.max(var2.y, var5.y));
         this.a.a(new Rectangle(var6.x, var6.y, var7.x - var6.x + 1, var7.y - var6.y + 1));
      } else {
         this.a.a((Rectangle)null);
      }

   }

   public void mouseEntered(MouseEvent var1) {
      this.e = (L)var1.getComponent();
   }
}
