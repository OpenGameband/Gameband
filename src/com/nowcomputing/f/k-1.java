package com.nowcomputing.f;

import com.nowcomputing.ImageDoodad;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;

class k implements ActionListener {
   // $FF: synthetic field
   final i a;

   k(i var1) {
      this.a = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.a.setCursor(Cursor.getPredefinedCursor(3));

      try {
         ImageDoodad.f var2 = new ImageDoodad.f();
         var2.f();
         var2.i();
         var2.j();
         var2.a(i.a(this.a));
         var2.b();
         var2.g();
      } catch (Throwable var6) {
         i.d().log(Level.WARNING, "Error configuring Gameband", var6);
         var6.printStackTrace();
      } finally {
         this.a.setCursor(Cursor.getDefaultCursor());
      }

      this.a.c.b();
   }
}
