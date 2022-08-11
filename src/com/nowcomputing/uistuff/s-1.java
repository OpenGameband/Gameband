package com.nowcomputing.uistuff;

import com.nowcomputing.*;
import com.nowcomputing.pixelfurnace.GBComms;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class MainMenu extends JFrame implements e, com.nowcomputing.n, resetAction, ActionListener {
   private static final Logger a = Logger.getLogger(Utils.class.getName());
   private GamebandConfig b;
   private latchedCommandRun c;
   private com.nowcomputing.uistuff.apackage.p d;
   private M e;
   private aa f;
   private GBComms g;
   private boolean h;
   private b i;
   private CountDownLatch j = null;

   public MainMenu(GamebandConfig var1, GBComms var2) {
      this.b = var1;
      this.g = var2;
     // this.c = new com.nowcomputing.uistuff.c(var1); // not my problem
      this.c.a((com.nowcomputing.n)this);
      this.setTitle("Gameband " + WindowsVersionComparator.getImplementationVersion().toString());
      this.setDefaultCloseOperation(0);
      this.setResizable(false);
      this.h();
      this.o();
      Insets var3 = this.getInsets();
      Dimension var4 = new Dimension(800 + var3.left + var3.right, 600 + var3.top + var3.bottom);
      this.setMinimumSize(var4);
      this.setMaximumSize(var4);
      this.setLocationRelativeTo((Component)null);

      InputStream var5;
      try {
         var5 = com.nowcomputing.uistuff.apackage.p.class.getResourceAsStream("/resources/icon.png");
         if (var5 != null) {
            this.setIconImage(ImageIO.read(var5));
         }
      } catch (IOException var7) {
      }

      this.addWindowListener(new t(this));

      try {
         var5 = b.class.getResourceAsStream("/icon.png");
         if (var5 != null) {
            this.setIconImage(ImageIO.read(var5));
         }
      } catch (IOException var6) {
      }

      LocaleUtil.a((resetAction)this);
   }

   private void h() {
      this.e = new M();
      this.i = new b(this);
      this.f = new aa(this.g, this.b);
      this.j();
   }

   private void i() {
      this.e.d().removeActionListener(this);
      this.e.m().removeActionListener(this);
      this.e.n().removeActionListener(this);
      this.e.e().removeActionListener(this);
      this.i.f().removeActionListener(this);
      this.i.e().removeActionListener(this);
      this.f.f().removeActionListener(this);
      this.f.e().removeActionListener(this);
   }

   private void j() {
      this.e.d().addActionListener(this);
      this.e.m().addActionListener(this);
      this.e.n().addActionListener(this);
      this.e.e().addActionListener(this);
      this.i.f().addActionListener(this);
      this.i.e().addActionListener(this);
      this.f.f().addActionListener(this);
      this.f.e().addActionListener(this);
   }

   private void k() {
      this.setVisible(false);

      try {
         if (this.c.d()) {
            a.log(Level.FINE, "Game finished");
            this.setVisible(true);
            this.l();
         }
      } finally {
         this.e.d().setEnabled(true);
         this.setVisible(true);
      }

   }

   private void l() {
      Thread var1 = new Thread(new u(this));
      var1.start();
   }

   private void m() {
      this.n();
      this.d = new com.nowcomputing.uistuff.apackage.p(this, this.g);
      this.d.m().addActionListener(this);
      this.d.n().addActionListener(this);
      this.d.f();
      this.setContentPane(this.d.d());
      this.validate();
      this.d.a(true);
   }

   private void n() {
      if (!this.h) {
         this.h = true;
         this.setCursor(Cursor.getPredefinedCursor(3));

         try {
            boolean var1 = Main.a();
            if (!var1) {
               N.a((Component)this, (String[])(new String[]{LocaleUtil.getLocalizedString("GAMEBAND_NOT_DETECTED_TITLE"), LocaleUtil.getLocalizedString("GAMEBAND_NOT_DETECTED_TEXT"), LocaleUtil.getLocalizedString("GAMEBAND_NOT_DETECTED_TEXT_1")}), (String) LocaleUtil.getLocalizedString("ERROR_WINDOW_TITLE"), (String)"www.nowcomputing.com/contact");
            }
         } finally {
            this.setCursor(Cursor.getDefaultCursor());
         }

      }
   }

   private void o() {
      this.setContentPane(this.e);
      this.e.d().setEnabled(true);
      this.pack();
   }

   private void p() {
      this.n();
      this.f.n();
      this.f.setVisible(true);
      this.setContentPane(this.f);
      this.pack();
   }

   public void d() {
      if (this.c.b() != null && !this.c.b().c()) {
         this.c.b().b();
      }

   }

   public void actionPerformed(ActionEvent var1) {
      // $FF: Couldn't be decompiled
   }

   private void q() {
      if (this.d != null) {
         this.g.a(this.d.k());
      }

      this.g.setOrientation(this.f.m());
      this.g.setGamebandTimezone();
      Main.e();
   }

   public void reset() {
      a.log(Level.FINE, "GamebandApplication.onLocaleChange()");
      this.i();
      this.r();
      this.j();
   }

   private void r() {
      this.e.a();
      this.i.a();
      this.f.a();
   }

   public void e() {
      if (Boolean.parseBoolean(this.b.getProperty("auto_update", "true"))) {
         this.j = new CountDownLatch(1);

         try {
            com.nowcomputing.s var1 = new com.nowcomputing.s();
            var1.method1("gbupdate.info");
         } finally {
            this.j.countDown();
         }
      }

   }

   public void f() {
      this.e.l();
   }

   public void a() {
   }

   public void b() {
   }

   // $FF: synthetic method
   static b a(MainMenu var0) {
      return var0.i;
   }

   // $FF: synthetic method
   static void b(MainMenu var0) {
      var0.q();
   }

   // $FF: synthetic method
   static CountDownLatch c(MainMenu var0) {
      return var0.j;
   }

   // $FF: synthetic method
   static boolean d(MainMenu var0) {
      return var0.h;
   }

   // $FF: synthetic method
   static boolean a(MainMenu var0, boolean var1) {
      return var0.h = var1;
   }

   // $FF: synthetic method
   static Image.f e(MainMenu var0) {
      return var0.g;
   }

   // $FF: synthetic method
   static Logger g() {
      return a;
   }

   // $FF: synthetic method
   static void f(MainMenu var0) {
      var0.k();
   }

   // $FF: synthetic method
   static void g(MainMenu var0) {
      var0.m();
   }
}
