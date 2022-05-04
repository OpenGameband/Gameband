package com.nowcomputing.b.a.a;

import com.nowcomputing.LocaleUtil;

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

   public a(com.nowcomputing.b.a.CustomDialog var1) {
      this.a = new k(var1, LocaleUtil.getLocalizedString("IMPORT_MENU"), a("import.png"), LocaleUtil.getLocalizedString("IMPORT_MENU_DESC"), new Integer(73), (KeyStroke)null);
      this.b = new i(var1, LocaleUtil.getLocalizedString("EXPORT_MENU"), a("export.png"), LocaleUtil.getLocalizedString("EXPORT_MENU_DESC"), new Integer(69), (KeyStroke)null);
      this.c = new h(var1, LocaleUtil.getLocalizedString("EXIT_MENU"), (ImageIcon)null, LocaleUtil.getLocalizedString("EXIT_MENU_DESC"), new Integer(88), (KeyStroke)null);
      this.j = new t(var1, LocaleUtil.getLocalizedString("UNDO_MENU"), a("undo.png"), LocaleUtil.getLocalizedString("UNDO_MENU_DESC"), new Integer(85), KeyStroke.getKeyStroke(90, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
      this.k = new q(var1, LocaleUtil.getLocalizedString("REDO_MENU"), a("redo.png"), LocaleUtil.getLocalizedString("REDO_MENU_DESC"), new Integer(82), KeyStroke.getKeyStroke(90, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask() | 1));
      this.f = new d(var1, LocaleUtil.getLocalizedString("CUT_MENU"), a("cut.png"), LocaleUtil.getLocalizedString("CUT_MENU_DESC"), new Integer(84), KeyStroke.getKeyStroke(88, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
      this.d = new c(var1, LocaleUtil.getLocalizedString("COPY_MENU"), a("copy.png"), LocaleUtil.getLocalizedString("COPY_MENU_DESC"), new Integer(67), KeyStroke.getKeyStroke(67, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
      this.e = new o(var1, LocaleUtil.getLocalizedString("PASTE_MENU"), a("paste.png"), LocaleUtil.getLocalizedString("PASTE_MENU_DESC"), new Integer(80), KeyStroke.getKeyStroke(86, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
      this.g = new e(var1, LocaleUtil.getLocalizedString("DELETE_MENU"), a("delete.png"), LocaleUtil.getLocalizedString("DELETE_MENU_DESC"), new Integer(68), KeyStroke.getKeyStroke(127, 0));
      this.h = new r(var1, LocaleUtil.getLocalizedString("SELECT_ALL_MENU"), (ImageIcon)null, LocaleUtil.getLocalizedString("SELECT_ALL_MENU_DESC"), new Integer(83), KeyStroke.getKeyStroke(65, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
      this.i = new s(var1, LocaleUtil.getLocalizedString("SELECT_NONE_MENU"), (ImageIcon)null, LocaleUtil.getLocalizedString("SELECT_NONE_MENU_DESC"), new Integer(78), KeyStroke.getKeyStroke(68, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
      this.l = new m(var1, LocaleUtil.getLocalizedString("INVERT_MENU"), (ImageIcon)null, LocaleUtil.getLocalizedString("INVERT_MENU_DESC"), new Integer(73), (KeyStroke)null);
      this.m = new n(var1, LocaleUtil.getLocalizedString("NEXT_FRAME_MENU"), (ImageIcon)null, LocaleUtil.getLocalizedString("NEXT_FRAME_MENU_DESC"), new Integer(78), KeyStroke.getKeyStroke(39, 8));
      this.n = new p(var1, LocaleUtil.getLocalizedString("PREV_FRAME_MENU"), (ImageIcon)null, LocaleUtil.getLocalizedString("PREV_FRAME_MENU_DESC"), new Integer(80), KeyStroke.getKeyStroke(37, 8));
      this.o = new l(var1, LocaleUtil.getLocalizedString("INSERT_FRAME_MENU"), (ImageIcon)null, LocaleUtil.getLocalizedString("INSERT_FRAME_MENU_DESC"), new Integer(73), KeyStroke.getKeyStroke(73, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
      this.p = new f(var1, LocaleUtil.getLocalizedString("DELETE_FRAME_MENU"), (ImageIcon)null, LocaleUtil.getLocalizedString("DELETE_FRAME_MENU_DESC"), new Integer(68), KeyStroke.getKeyStroke(69, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
      this.q = new g(var1, LocaleUtil.getLocalizedString("DUPLICATE_FRAME_MENU"), (ImageIcon)null, LocaleUtil.getLocalizedString("DUPLICATE_FRAME_MENU_DESC"), new Integer(85), KeyStroke.getKeyStroke(85, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
   }

   static ImageIcon a(String var0) {
      String var1 = "/resources/" + var0;
      URL var2 = com.nowcomputing.b.a.CustomDialog.class.getResource(var1);
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

   public DialogButton p() {
      return this.c;
   }

   public g q() {
      return this.q;
   }
}
