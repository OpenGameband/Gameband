package com.nowcomputing.uistuff.apackage;

import com.nowcomputing.*;
import com.nowcomputing.a.Direction;
import com.nowcomputing.pixelfurnace.GBComms;
import com.nowcomputing.pixelfurnace.Animation;
import com.nowcomputing.uistuff.GamebandColors;
import com.nowcomputing.uistuff.GamebandFonts;
import com.nowcomputing.uistuff.dialogPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class p {
   private static final Logger a = Logger.getLogger(Utils.class.getName());
   private GBComms b;
   private dialogPanel c;
   private com.nowcomputing.uistuff.apackage.a d;
   private t e;
   private q f;
   private f g;
   private Container h;
   private JFrame i;
   private JLayeredPane j;

   public p(JFrame var1, GBComms var2) throws IOException {
      this.i = var1;
      this.b = var2;
      JPanel var3 = new JPanel();
      var3.setLayout(new BorderLayout());
      var3.setBackground(GamebandColors.a);
      this.a((Container)var3);
      this.b();
      var2.a(false);
   }

   private void a(Container var1) {
      this.h = var1;
   }

   public void a() {
      this.e();
      this.h.setVisible(false);
   }

   public void b() throws IOException {
      this.d().removeAll();
      dialogPanel var1 = new dialogPanel();
      var1.a(LocaleUtil.getLocalizedString("PIXELFURNACE"));
      var1.a(true);
      var1.b(true);
      var1.c(false);
      var1.b("https://gameband.zendesk.com/hc/en-us/articles/201744701-How-do-I-use-Pixel-Furnace-");
      var1.a();
      this.d().add(var1);
      this.c = var1;
      this.a(var1.h());
      this.q();
      this.c();
      this.d().add(this.f);
      this.d().invalidate();
   }

   private void a(JPanel var1) {
      var1.setLayout(new BorderLayout());
      this.j = new JLayeredPane();
      this.j.setBackground(GamebandColors.a);
      var1.add(this.j);
      this.j.setOpaque(false);
      this.j.setLayout(new BoxLayout(this.j, 0));
      this.j.setBounds(0, 0, 800, 600);
      this.j.add(Box.createRigidArea(new Dimension(35, 0)));
      this.j.add(this.o());
      this.j.add(Box.createRigidArea(new Dimension(25, 0)));
      this.j.add(this.p());
      this.j.add(Box.createRigidArea(new Dimension(30, 0)));
   }

   private JPanel o() {
      JPanel var1 = new JPanel();
      var1.setOpaque(false);
      var1.setLayout(new BoxLayout(var1, 1));
      var1.add(Box.createRigidArea(new Dimension(517, 0)));
      JPanel var2 = new JPanel();
      var2.setLayout(new BoxLayout(var2, 0));
      var2.setOpaque(false);
      var2.add(Box.createRigidArea(new Dimension(0, 100)));
      var1.add(var2);
      JPanel var3 = new JPanel();
      var3.setLayout(new BoxLayout(var3, 1));
      var3.setOpaque(false);
      JLabel var4 = new JLabel(LocaleUtil.getLocalizedString("MAIN_HEADING"));
      var4.setForeground(Color.WHITE);
      var4.setFont(GamebandFonts.j);
      var4.setAlignmentX(0.5F);
      var4.setHorizontalAlignment(0);
      var3.add(var4);
      JLabel var5 = new JLabel(LocaleUtil.getLocalizedString("SUB_HEADING"));
      var5.setForeground(Color.WHITE);
      var5.setFont(GamebandFonts.k);
      var5.setAlignmentX(0.5F);
      var5.setHorizontalAlignment(0);
      var3.add(var5);
      var2.add(var3);
      this.e = new t(this);
      this.e.setLayout((LayoutManager)null);
      this.e.setOpaque(false);
      this.e.a(this.g().getAnimations());
      var1.add(this.e);
      return var1;
   }

   private JPanel p() {
      JPanel var1 = new JPanel();
      var1.setOpaque(false);
      var1.setLayout(new BoxLayout(var1, 1));
      var1.add(Box.createRigidArea(new Dimension(186, 100)));
      this.d = new a(this);
      var1.add(this.d);
      var1.add(Box.createVerticalStrut(130));
      return var1;
   }

   q c() {
      this.f = new q(this);
      this.f.setBounds(0, 0, 800, 600);
      return this.f;
   }

   private f q() {
      this.g = new f(this);
      this.g.setOpaque(false);
      return this.g;
   }

   public Container d() {
      return this.h;
   }

   public void a(boolean var1) {
      if (var1) {
         this.d().removeAll();
         this.d().add(this.c);
         ((JComponent)this.d()).revalidate();
         this.d().repaint();
         this.f();
      } else {
         this.e();
      }

   }

   public void b(boolean var1) {
      this.a(!var1);
      if (var1) {
         this.d().removeAll();
         this.f.a(this.e.c());
         this.d().add(this.f);
         this.d().repaint();
      }

   }

   public void c(boolean var1) {
      this.a(!var1);
      if (var1) {
         this.d().removeAll();
         this.d().add(this.g);
         this.g.setVisible(true);
         this.d().repaint();
      }

   }

   public void e() {
      this.e.b();
   }

   public void f() {
      this.e.a();
   }

   public GBComms g() {
      return this.b;
   }

   public boolean h() {
      int var1 = 0;
      List var2 = this.e.c();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         Animation var4 = (Animation)var3.next();
         short var5 = var4.getDateFormat();
         if (var5 != 0 && var5 != 1 && var5 != 3 && var5 != 2) {
            ++var1;
         }
      }

      if (var1 < this.g().e()) {
         return true;
      } else {
         return false;
      }
   }

   public void a(String var1, Direction var2, boolean var3) {
      this.e.a(var1, var2, var3);
      this.d(true);
   }

   public void a(File var1, Direction var2, boolean var3) {
      this.e.a(var1, var2, var3);
      this.d(true);
   }

   public void a(File var1) {
      this.e.a(var1);
      this.d(true);
   }

   public void i() {
      LockingUtil.a var1 = new LockingUtil.a(this.i, (AnimatedImage)null, true);
      var1.a();
      this.e.a(var1.b());
      this.d(true);
   }

   public void a(com.nowcomputing.uistuff.b.e var1) {
      var1.e();
      LockingUtil.a var2 = new LockingUtil.a(this.i, var1.c(), true);
      var2.a();
      var1.a(var2.b());
      var1.d();
   }

   public void d(boolean var1) {
      this.b.a(var1);
   }

   public Component j() {
      return this.i;
   }

   public List k() {
      return this.e.c();
   }

   public JLayeredPane l() {
      return this.j;
   }

   public JButton m() {
      return this.c.f();
   }

   public JButton n() {
      return this.c.e();
   }
}
