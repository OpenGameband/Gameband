package com.nowcomputing.b.a.b;

import com.nowcomputing.LockingUtil;
import com.nowcomputing.uistuff.L;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

public class d extends a {
   private boolean b;
   private Cursor c;
   private Cursor d;

   d(com.nowcomputing.b.a.CustomDialog var1, boolean var2) {
      super(var1);
      this.b = var2;
      Toolkit var3 = Toolkit.getDefaultToolkit();

      try {
         Image var4 = var3.getImage(this.getClass().getResource("/resources/pencil_cursor.png"));
         this.c = var3.createCustomCursor(var4, new Point(2, 2), "pencil");
         Image var5 = var3.getImage(this.getClass().getResource("/resources/eraser_cursor.png"));
         this.d = var3.createCustomCursor(var5, new Point(2, 4), "eraser");
      } catch (Exception var6) {
         this.d = Cursor.getPredefinedCursor(0);
         this.c = Cursor.getPredefinedCursor(0);
      }

   }

   public void a() {
      this.a.a((Rectangle)null);
   }

   public void c() {
   }

   public Cursor b() {
      return this.b ? this.c : this.d;
   }

   public void mousePressed(MouseEvent var1) {
      L var2 = (L)var1.getSource();
      if (var2 != null) {
         boolean var3 = (var1.getModifiersEx() & 1024) == 1024;
         boolean var4 = (var1.getModifiersEx() & 4096) == 4096;
         if (var3 || var4) {
            this.a((L)var1.getSource(), this.b ? var3 : !var3);
         }
      }

   }

   public void mouseEntered(MouseEvent var1) {
      boolean var2 = (var1.getModifiersEx() & 1024) == 1024;
      boolean var3 = (var1.getModifiersEx() & 4096) == 4096;
      if (var2 || var3) {
         this.a((L)var1.getSource(), this.b ? var2 : !var2);
      }

   }

   private void a(L var1, boolean var2) {
      if (var1 != null) {
         this.a.y();
         Point var3 = this.a.b().a(var1);
         this.a.c().a(var3.x, var3.y, var2);
         var1.a(var2);
         var1.repaint();
      }

   }
}
