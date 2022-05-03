package com.nowcomputing.b.a.a;

import com.nowcomputing.LockingUtil;

import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class a {
   private k a;
   private i b;
   private h c;
   private c d;
   private o e;
   private d f;
   private e g;
   private r h;
   private s i;
   private t j;
   private q k;
   private m l;
   private n m;
   private p n;
   private l o;
   private f p;
   private g q;

   public a(LockingUtil.a.a var1) {
      this.a = new k(var1, com.nowcomputing.f.a("IMPORT_MENU"), a("import.png"), com.nowcomputing.f.a("IMPORT_MENU_DESC"), new Integer(73), (KeyStroke)null);
      this.b = new i(var1, com.nowcomputing.f.a("EXPORT_MENU"), a("export.png"), com.nowcomputing.f.a("EXPORT_MENU_DESC"), new Integer(69), (KeyStroke)null);
      this.c = new h(var1, com.nowcomputing.f.a("EXIT_MENU"), (ImageIcon)null, com.nowcomputing.f.a("EXIT_MENU_DESC"), new Integer(88), (KeyStroke)null);
      this.j = new t(var1, com.nowcomputing.f.a("UNDO_MENU"), a("undo.png"), com.nowcomputing.f.a("UNDO_MENU_DESC"), new Integer(85), KeyStroke.getKeyStroke(90, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
      this.k = new q(var1, com.nowcomputing.f.a("REDO_MENU"), a("redo.png"), com.nowcomputing.f.a("REDO_MENU_DESC"), new Integer(82), KeyStroke.getKeyStroke(90, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask() | 1));
      this.f = new d(var1, com.nowcomputing.f.a("CUT_MENU"), a("cut.png"), com.nowcomputing.f.a("CUT_MENU_DESC"), new Integer(84), KeyStroke.getKeyStroke(88, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
      this.d = new c(var1, com.nowcomputing.f.a("COPY_MENU"), a("copy.png"), com.nowcomputing.f.a("COPY_MENU_DESC"), new Integer(67), KeyStroke.getKeyStroke(67, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
      this.e = new o(var1, com.nowcomputing.f.a("PASTE_MENU"), a("paste.png"), com.nowcomputing.f.a("PASTE_MENU_DESC"), new Integer(80), KeyStroke.getKeyStroke(86, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
      this.g = new e(var1, com.nowcomputing.f.a("DELETE_MENU"), a("delete.png"), com.nowcomputing.f.a("DELETE_MENU_DESC"), new Integer(68), KeyStroke.getKeyStroke(127, 0));
      this.h = new r(var1, com.nowcomputing.f.a("SELECT_ALL_MENU"), (ImageIcon)null, com.nowcomputing.f.a("SELECT_ALL_MENU_DESC"), new Integer(83), KeyStroke.getKeyStroke(65, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
      this.i = new s(var1, com.nowcomputing.f.a("SELECT_NONE_MENU"), (ImageIcon)null, com.nowcomputing.f.a("SELECT_NONE_MENU_DESC"), new Integer(78), KeyStroke.getKeyStroke(68, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
      this.l = new m(var1, com.nowcomputing.f.a("INVERT_MENU"), (ImageIcon)null, com.nowcomputing.f.a("INVERT_MENU_DESC"), new Integer(73), (KeyStroke)null);
      this.m = new n(var1, com.nowcomputing.f.a("NEXT_FRAME_MENU"), (ImageIcon)null, com.nowcomputing.f.a("NEXT_FRAME_MENU_DESC"), new Integer(78), KeyStroke.getKeyStroke(39, 8));
      this.n = new p(var1, com.nowcomputing.f.a("PREV_FRAME_MENU"), (ImageIcon)null, com.nowcomputing.f.a("PREV_FRAME_MENU_DESC"), new Integer(80), KeyStroke.getKeyStroke(37, 8));
      this.o = new l(var1, com.nowcomputing.f.a("INSERT_FRAME_MENU"), (ImageIcon)null, com.nowcomputing.f.a("INSERT_FRAME_MENU_DESC"), new Integer(73), KeyStroke.getKeyStroke(73, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
      this.p = new f(var1, com.nowcomputing.f.a("DELETE_FRAME_MENU"), (ImageIcon)null, com.nowcomputing.f.a("DELETE_FRAME_MENU_DESC"), new Integer(68), KeyStroke.getKeyStroke(69, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
      this.q = new g(var1, com.nowcomputing.f.a("DUPLICATE_FRAME_MENU"), (ImageIcon)null, com.nowcomputing.f.a("DUPLICATE_FRAME_MENU_DESC"), new Integer(85), KeyStroke.getKeyStroke(85, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
   }

   static ImageIcon a(String var0) {
      String var1 = "/resources/" + var0;
      URL var2 = LockingUtil.a.a.class.getResource(var1);
      if (var2 == null) {
         System.err.println("Resource not found: " + var1);
         return null;
      } else {
         return new ImageIcon(var2);
      }
   }

   public c a() {
      return this.d;
   }

   public o b() {
      return this.e;
   }

   public d c() {
      return this.f;
   }

   public e d() {
      return this.g;
   }

   public r e() {
      return this.h;
   }

   public s f() {
      return this.i;
   }

   public k g() {
      return this.a;
   }

   public i h() {
      return this.b;
   }

   public t i() {
      return this.j;
   }

   public q j() {
      return this.k;
   }

   public m k() {
      return this.l;
   }

   public n l() {
      return this.m;
   }

   public p m() {
      return this.n;
   }

   public l n() {
      return this.o;
   }

   public f o() {
      return this.p;
   }

   public b p() {
      return this.c;
   }

   public g q() {
      return this.q;
   }
}
