package com.nowcomputing.b.a.b;

import com.nowcomputing.Image;
import com.nowcomputing.b.a.*;
import com.nowcomputing.uistuff.L;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class mouseHandler extends a {
   private boolean b;
   private com.nowcomputing.b.a.p c;
   private int d;
   private int e;
   private Point f;
   private c g = new c(this, 37);
   private c h = new c(this, 39);
   private c i = new c(this, 38);
   private c j = new c(this, 40);
   private c k = new c(this, 10);

   mouseHandler(com.nowcomputing.b.a.CustomDialog var1) {
      super(var1);
   }

   public void a() {
      this.a.a(KeyStroke.getKeyStroke(37, 0), "moveLeft", this.g);
      this.a.a(KeyStroke.getKeyStroke(39, 0), "moveRight", this.h);
      this.a.a(KeyStroke.getKeyStroke(38, 0), "moveUp", this.i);
      this.a.a(KeyStroke.getKeyStroke(40, 0), "moveDown", this.j);
      this.a.a(KeyStroke.getKeyStroke(10, 0), "enter", this.k);
   }

   public void c() {
      this.a.a(KeyStroke.getKeyStroke(37, 0), "none", (Action)null);
      this.a.a(KeyStroke.getKeyStroke(39, 0), "none", (Action)null);
      this.a.a(KeyStroke.getKeyStroke(38, 0), "none", (Action)null);
      this.a.a(KeyStroke.getKeyStroke(40, 0), "none", (Action)null);
      this.a.a(KeyStroke.getKeyStroke(10, 0), "none", (Action)null);
      this.a.z();
   }

   public void mouseDragged(MouseEvent var1) {
      if (!this.b) {
         this.a(var1);
      }

   }

   public void mouseEntered(MouseEvent var1) {
      if (this.b) {
         L var2 = (L)var1.getSource();
         this.f = this.a.b().a(var2);
         this.b(this.f.x + this.d, this.f.y + this.e);
      }

   }

   public void mouseReleased(MouseEvent var1) {
      if (this.b) {
         this.d();
      }

   }

   private void a(MouseEvent var1) {
      this.e();
      this.b = true;
      L var2 = (L)var1.getSource();
      this.f = this.a.b().a(var2);
      this.d = this.c.b().x - this.f.x;
      this.e = this.c.b().y - this.f.y;
   }

   private void d() {
      this.b = false;
   }

   private void e() {
      this.a.y();
      q var1 = this.a.d();
      if (var1 == null) {
         this.a.a(new Rectangle(0, 0, 20, 7));
         this.a.e();
      }

      this.c = this.a.g();
      if (!this.c.c()) {
         Image var2 = new Image(this.c.a().getWidth(), this.c.a().getHeight());
         this.a.c().ramImageInForcefully(var2, this.c.b().x, this.c.b().y);
         this.a.a(this.c.a());
      }

   }

   private void b(int var1, int var2) {
      this.a.b().a(this.a.c(), 0, 0);
      this.a.b().a(this.c.a(), var1, var2);
      this.a.a(new Rectangle(var1, var2, this.c.a().getWidth(), this.c.a().getHeight()));
   }

   void a(int var1, int var2) {
      p var3 = this.a.g();
      if (var3 != null && var3.b().x + var1 >= 0 && var3.b().x + var3.a().getWidth() + var1 <= 20 && var3.b().y + var2 >= 0 && var3.b().y + var3.a().getHeight() + var2 <= 7) {
         this.e();
         this.b(var3.b().x + var1, var3.b().y + var2);
      }

   }

   public Cursor b() {
      return Cursor.getPredefinedCursor(13);
   }
}
