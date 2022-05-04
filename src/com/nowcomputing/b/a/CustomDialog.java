package com.nowcomputing.b.a;

import com.nowcomputing.ImageDoodad;
import com.nowcomputing.LockingUtil;
import com.nowcomputing.LocaleUtil;
import com.nowcomputing.otherImageThingy;
import com.nowcomputing.uistuff.GamebandColors;
import com.nowcomputing.uistuff.L;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.KeyStroke;
import javax.swing.SpinnerNumberModel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

/**
 * Originally com.nowcomputing.b.a.a hence the confusion
 */
public class CustomDialog extends JDialog implements ActionListener, MouseListener, MouseMotionListener {
   private com.nowcomputing.b.FrameDingus a;
   private otherImageThingy b;
   private com.nowcomputing.uistuff.n c;
   private Deque d;
   private Deque e;
   private JMenuBar f;
   private JSlider g;
   private int h;
   private com.nowcomputing.b.a.b.a i;
   private q j;
   private p k;
   private com.nowcomputing.b.a.b.f l;
   private n m;
   private JButton n;
   private boolean o;
   private Timer p;
   private SpinnerNumberModel q;
   private SpinnerNumberModel r;
   private ImageIcon s;
   private ImageIcon t;
   private com.nowcomputing.b.a.a.a u;
   private ImageDoodad v;
   private boolean w;

   public CustomDialog(com.nowcomputing.b.FrameDingus var1, JFrame var2, otherImageThingy var3) {
      super(var2, true);
      this.c = new com.nowcomputing.uistuff.n(GamebandColors.f, GamebandColors.a, 1);
      this.d = new ArrayDeque();
      this.e = new ArrayDeque();
      this.m = new n();
      this.a = var1;
      this.b = var3;
      this.setDefaultCloseOperation(2);
      this.setResizable(false);
      this.u = new com.nowcomputing.b.a.a.a(this);
      this.B();
      this.c.setFocusable(true);
      this.a(this.h);
      Insets var4 = this.getInsets();
      this.setMinimumSize(new Dimension(800, 600 + var4.top + var4.bottom));
      this.setMaximumSize(new Dimension(800, 600 + var4.top + var4.bottom));
   }

   public otherImageThingy a() {
      return this.b;
   }

   public void a(File var1) throws IOException {
      this.b = otherImageThingy.a(var1);
      this.c(this.b.b());
      this.b(this.b.a());
      this.h = 0;
      this.a(this.h);
   }

   private void b(int var1) {
      this.r.setValue(var1);
      this.g.setMaximum(var1 - 1);
   }

   private void c(int var1) {
      int var2 = var1 > 0 ? var1 : 20;
      this.q.setValue(var2);
      this.b.c(var2);
   }

   public com.nowcomputing.uistuff.n b() {
      return this.c;
   }

   public ImageDoodad c() {
      return this.b.a(this.h);
   }

   public q d() {
      return this.j;
   }

   public void a(Rectangle var1) {
      if (var1 != null) {
         int var2 = var1.x;
         int var3 = var1.y;
         int var4 = var1.width;
         int var5 = var1.height;
         if (var2 < 0) {
            var4 += var2;
            var2 = 0;
         }

         if (var2 + var4 > 20) {
            var4 = 20 - var2;
         }

         if (var3 < 0) {
            var5 += var3;
            var3 = 0;
         }

         if (var3 + var5 > 7) {
            var5 = 7 - var3;
         }

         this.j = new q(var1);
         if (var4 == 0 || var5 == 0) {
            return;
         }

         L var6 = this.c.b(var2, var3);
         L var7 = this.c.b(var2 + var4 - 1, var3 + var5 - 1);
         Point var8 = this.a(var6.getLocationOnScreen());
         Point var9 = this.a(var7.getLocationOnScreen());
         this.a(var8.x, var8.y, var9.x - var8.x + var7.getWidth(), var9.y - var8.y + var7.getHeight());
         this.u.c().setEnabled(true);
         this.u.a().setEnabled(true);
         this.u.d().setEnabled(true);
         this.u.f().setEnabled(true);
      } else {
         this.j = null;
         this.f();
         this.u.c().setEnabled(false);
         this.u.a().setEnabled(false);
         this.u.d().setEnabled(false);
         this.u.f().setEnabled(false);
      }

   }

   public void e() {
      this.f();
      this.getContentPane().add(this.m, JLayeredPane.DRAG_LAYER);
      this.getContentPane().repaint();
   }

   public void f() {
      this.u.c().setEnabled(false);
      this.u.a().setEnabled(false);
      this.u.d().setEnabled(false);
      this.getContentPane().remove(this.m);
      this.getContentPane().repaint();
   }

   public void a(int var1, int var2, int var3, int var4) {
      this.m.setBounds(var1, var2, var3, var4);
   }

   public p g() {
      if (this.j == null) {
         return null;
      } else {
         p var1 = new p();
         var1.a(new Point(this.j.a().x, this.j.a().y));
         int var2 = this.j.a().width;
         int var3 = this.j.a().height;
         if (this.v == null) {
            ImageDoodad var4 = new ImageDoodad(var2, var3);
            var4.a(this.c.a(), this.j.a().x, this.j.a().y, var2, var3, 0, 0);
            var1.a(var4);
         } else {
            var1.a(this.v);
            var1.a(true);
         }

         return var1;
      }
   }

   public void h() {
      this.f();
      p var1 = this.g();
      ImageDoodad var2 = new ImageDoodad(var1.a().a(), var1.a().b());
      this.c().a(var2, var1.b().x, var1.b().y);
      this.m();
   }

   public void i() {
      this.e();
      this.a(new Rectangle(0, 0, 20, 7));
   }

   public Point a(Point var1) {
      Point var2 = this.getLocationOnScreen();
      Insets var3 = this.getInsets();
      return new Point(var1.x - (var2.x + var3.left), var1.y - (var2.y + var3.top + this.f.getHeight()));
   }

   public void j() {
      if (this.j != null) {
         this.k = this.g();
         this.u.b().setEnabled(true);
      }

   }

   public void k() {
      if (this.k != null) {
         this.v = new ImageDoodad(this.k.a().a(), this.k.a().b());
         this.v.a(this.k.a());
         this.a(this.h);
         this.b().a(this.v, this.k.b().x, this.k.b().y);
         this.e();
         this.a(new Rectangle(this.k.b().x, this.k.b().y, this.k.a().a(), this.k.a().b()));
      }

   }

   public com.nowcomputing.b.a.b.a l() {
      return this.i;
   }

   public void a(com.nowcomputing.b.a.b.a var1) {
      this.i = var1;
   }

   public void m() {
      this.a(this.h);
      this.b(this.b.a());
   }

   public void a(KeyStroke var1, String var2, Action var3) {
      this.getRootPane().getInputMap(1).put(var1, var2);
      if (var3 != null) {
         this.getRootPane().getActionMap().put(var2, var3);
      }

   }

   void n() {
      if (this.o) {
         this.p();
      } else {
         this.o();
      }

   }

   void o() {
      this.o = true;
      this.n.setIcon(this.t);
      this.p = new Timer(1000 / this.b.b(), this);
      this.p.start();
   }

   void p() {
      this.o = false;
      this.n.setIcon(this.s);
      if (this.p != null) {
         this.p.stop();
         this.p = null;
      }

   }

   void a(int var1) {
      if (var1 >= 0 && var1 < this.b.a()) {
         this.c.a(this.b.a(var1), 0, 0);
         this.h = var1;
         this.g.setValue(this.h);
      }

   }

   public void q() {
      if (--this.h < 0) {
         this.h = 0;
      }

      this.a(this.h);
   }

   public void r() {
      if (++this.h == this.b.a()) {
         this.h = this.b.a() - 1;
      }

      this.a(this.h);
   }

   public void s() {
      if (this.b.a() > 0) {
         this.b.e(this.h);
         this.m();
         this.u.o().setEnabled(this.b.a() > 1);
      }

   }

   public void t() {
      this.b.d(this.h);
      this.m();
      this.u.n().setEnabled(this.b.a() < 50);
      this.u.q().setEnabled(this.b.a() < 50);
   }

   public void u() {
      ImageDoodad var1 = new ImageDoodad(20, 7);
      var1.a(this.b.a(this.h));
      this.b.a(this.h, var1);
      this.m();
      this.u.n().setEnabled(this.b.a() < 50);
      this.u.q().setEnabled(this.b.a() < 50);
   }

   public com.nowcomputing.b.a.a.a v() {
      return this.u;
   }

   private void B() {
      m var1 = new m("/resources/pfbackground.png");
      this.setContentPane(var1);
      this.J();
      JPanel var2 = new JPanel(new BorderLayout(14, 14));
      var2.setBounds(77, 61, 645, 466);
      var2.add(this.C(), "First");
      var2.add(this.D(), "Before");
      var2.add(this.E(), "Center");
      var2.add(this.F(), "After");
      var2.add(this.G(), "Last");
      var2.addMouseListener(new CustomMouseAdapter(this));
      var2.setBackground(com.nowcomputing.uistuff.GamebandColors.d);
      this.getContentPane().add(var2);
      this.pack();
      int var3 = this.f.getHeight();
      var2.setBounds(77, 61 - var3, 645, 466);
   }

   private JPanel C() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setOpaque(false);
      var1.add(Box.createRigidArea(new Dimension(96, 116)), "Before");
      JPanel var2 = new JPanel(new BorderLayout(10, 0));
      var2.setOpaque(false);
      var1.add(var2, "Center");
      var2.add(Box.createRigidArea(new Dimension(0, 68)), "North");
      var2.add(new l(this));
      var2.add(this.H(), "After");
      var1.add(Box.createRigidArea(new Dimension(49, 116)), "After");
      return var1;
   }

   private JPanel D() {
      JPanel var1 = new JPanel();
      var1.setLayout(new BoxLayout(var1, 1));
      var1.setBackground(GamebandColors.d);
      var1.setBorder(new EmptyBorder(0, 33, 0, 0));
      var1.add(Box.createHorizontalStrut(49));
      this.l = new com.nowcomputing.b.a.b.f(this);
      this.l.setBackground(GamebandColors.e);
      JPanel var2 = new JPanel(new BorderLayout());
      var2.add(this.l, "Center");
      var1.add(var2);
      return var1;
   }

   private JPanel E() {
      JPanel var1 = new JPanel();
      var1.addMouseListener(new c(this));
      var1.setBackground(GamebandColors.f);
      var1.setLayout((LayoutManager)null);
      var1.add(this.c);
      this.c.setOpaque(true);
      this.c.setBounds(10, 10, 480, 168);

      for(int var2 = 0; var2 < 20; ++var2) {
         for(int var3 = 0; var3 < 7; ++var3) {
            this.c.b(var2, var3).addMouseListener(this);
            this.c.b(var2, var3).addMouseMotionListener(this);
         }
      }

      return var1;
   }

   private Component F() {
      JPanel var1 = new JPanel(new FlowLayout(1, 0, 0));
      var1.setOpaque(false);
      var1.add(Box.createHorizontalStrut(35));
      return var1;
   }

   private Component G() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setOpaque(false);
      var1.add(Box.createRigidArea(new Dimension(96, 0)), "Before");
      JPanel var2 = new JPanel();
      var2.setOpaque(false);
      var2.setLayout(new BoxLayout(var2, 1));
      var2.add(this.I());
      var1.add(var2, "Center");
      var1.add(Box.createRigidArea(new Dimension(49, 0)), "After");
      JPanel var3 = new JPanel(new FlowLayout(1, 0, 28));
      var3.setOpaque(false);
      JButton var4 = new JButton(LocaleUtil.getLocalizedString("DONE"));
      var4.setFont(com.nowcomputing.uistuff.q.y);
      var4.setFocusPainted(false);
      var4.setFocusable(false);
      var4.addActionListener(new d(this));
      var3.add(var4);
      var1.add(var3, "Last");
      return var1;
   }

   private Component H() {
      JPanel var1 = new JPanel();
      var1.setOpaque(false);
      var1.setLayout(new BoxLayout(var1, 1));
      JPanel var2 = new JPanel(new FlowLayout(2, 0, 0));
      var2.setOpaque(false);
      JLabel var3 = new JLabel(new ImageIcon(this.getClass().getResource("/resources/num_frames.png")));
      var2.add(var3);
      var2.add(Box.createHorizontalStrut(9));
      this.r = new SpinnerNumberModel(this.b.a(), 1, Math.max(this.b.a(), 50), 1);
      JSpinner var4 = new JSpinner(this.r);
      var4.setToolTipText(LocaleUtil.getLocalizedString("NUMBER_OF_FRAMES"));
      var4.setFont(com.nowcomputing.uistuff.q.z);
      var4.addChangeListener(new e(this));
      var4.setFocusable(false);
      Component[] var5 = var4.getEditor().getComponents();
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         Component var8 = var5[var7];
         var8.setFocusable(false);
      }

      var2.add(var4);
      var1.add(var2);
      var1.add(Box.createVerticalStrut(6));
      JPanel var12 = new JPanel(new FlowLayout(2, 0, 0));
      var12.setOpaque(false);
      var12.add(Box.createHorizontalStrut(10));
      JLabel var13 = new JLabel(new ImageIcon(this.getClass().getResource("/resources/speed.png")));
      var12.add(var13);
      var12.add(Box.createHorizontalStrut(6));
      this.q = new SpinnerNumberModel(this.b.b(), 1, Math.max(this.b.b(), 30), 1);
      JSpinner var14 = new JSpinner(this.q);
      var14.setToolTipText(LocaleUtil.getLocalizedString("FPS"));
      var14.setFont(com.nowcomputing.uistuff.q.z);
      var14.addChangeListener(new f(this));
      var14.setFocusable(false);
      Component[] var15 = var14.getEditor().getComponents();
      int var9 = var15.length;

      for(int var10 = 0; var10 < var9; ++var10) {
         Component var11 = var15[var10];
         var11.setFocusable(false);
      }

      var12.add(var14);
      var1.add(var12);
      return var1;
   }

   private Component I() {
      JPanel var1 = new JPanel();
      var1.setOpaque(false);
      var1.setBounds(0, 0, 500, 50);
      var1.setLayout(new BorderLayout());
      JPanel var2 = new JPanel(new FlowLayout(1, 0, 0));
      var2.setOpaque(false);
      var2.setBorder(new EmptyBorder(0, 13, 0, 18));
      JButton var3 = this.a("/resources/left_arrow.png", 18, 18);
      var3.setFocusable(false);
      var3.addActionListener(new g(this));
      var2.add(var3);
      JButton var4 = this.a("/resources/right_arrow.png", 18, 18);
      var4.setFocusable(false);
      var4.addActionListener(new h(this));
      var2.add(var4);
      var1.add(var2, "Before");
      this.g = new JSlider();
      this.g.setForeground(Color.WHITE);
      this.g.setFont(com.nowcomputing.uistuff.q.z);
      this.g.setMaximum(this.b.a() - 1);
      this.g.setMajorTickSpacing(5);
      this.g.setMinorTickSpacing(1);
      this.g.setPaintTicks(true);
      this.g.setSnapToTicks(true);
      this.g.setPaintLabels(true);
      this.g.setValue(0);
      this.g.setFocusable(false);
      this.g.addChangeListener(new i(this));
      var1.add(this.g, "Center");
      JPanel var5 = new JPanel(new FlowLayout(1, 0, 0));
      var5.setOpaque(false);
      var5.setBorder(new EmptyBorder(0, 20, 0, 10));
      this.s = new ImageIcon(this.getClass().getResource("/resources/play.png"));
      this.t = new ImageIcon(this.getClass().getResource("/resources/pause.png"));
      this.n = this.a("/resources/play.png", 37, 37);
      this.n.setBackground(GamebandColors.f);
      this.n.setFocusable(false);
      this.n.addActionListener(new j(this));
      var5.add(this.n);
      var1.add(var5, "After");
      return var1;
   }

   private JButton a(String var1, int var2, int var3) {
      JButton var4 = new JButton(new ImageIcon(this.getClass().getResource(var1)));
      var4.setSize(var2, var3);
      var4.setBorder(BorderFactory.createEmptyBorder());
      var4.setFocusPainted(false);
      var4.setBorderPainted(false);
      return var4;
   }

   private void J() {
      this.f = new JMenuBar();
      this.setJMenuBar(this.f);
      this.K();
      this.M();
      this.L();
   }

   private void K() {
      JMenu var1 = new JMenu(LocaleUtil.getLocalizedString("FILE_MENU"));
      var1.setMnemonic(70);
      this.f.add(var1);
      this.a(var1, this.u.g());
      this.a(var1, this.u.h());
      var1.addSeparator();
      this.a(var1, this.u.p());
   }

   private void L() {
      JMenu var1 = new JMenu(LocaleUtil.getLocalizedString("ANIMATION_MENU"));
      var1.setMnemonic(65);
      this.f.add(var1);
      this.a(var1, this.u.l());
      this.a(var1, this.u.m());
      var1.addSeparator();
      this.a(var1, this.u.n());
      this.a(var1, this.u.o());
      this.a(var1, this.u.q());
   }

   private void M() {
      JMenu var1 = new JMenu(LocaleUtil.getLocalizedString("EDIT_MENU"));
      var1.setMnemonic(69);
      this.f.add(var1);
      this.a(var1, this.u.i());
      this.a(var1, this.u.j());
      var1.addSeparator();
      this.a(var1, this.u.c());
      this.a(var1, this.u.a());
      this.a(var1, this.u.b());
      var1.addSeparator();
      this.a(var1, this.u.d());
      this.a(var1, this.u.e());
      this.a(var1, this.u.f());
      var1.addSeparator();
      this.a(var1, this.u.k());
   }

   private void a(JMenu var1, LockingUtil.a.a.b var2) {
      JMenuItem var3 = new JMenuItem(var2);
      var3.setIcon((Icon)null);
      var1.add(var3);
   }

   public void mouseClicked(MouseEvent var1) {
      if (this.l() != null) {
         this.l().mouseClicked(var1);
      }

   }

   public void mousePressed(MouseEvent var1) {
      if (this.l() != null) {
         this.l().mousePressed(var1);
      }

   }

   public void mouseReleased(MouseEvent var1) {
      if (this.l() != null) {
         this.l().mouseReleased(var1);
      }

   }

   public void mouseEntered(MouseEvent var1) {
      if (this.l() != null) {
         this.setCursor(this.l().b());
         this.l().mouseEntered(var1);
      }

   }

   public void mouseExited(MouseEvent var1) {
      if (this.l() != null) {
         this.l().mouseExited(var1);
      }

   }

   public void mouseDragged(MouseEvent var1) {
      if (this.l() != null) {
         this.l().mouseDragged(var1);
      }

   }

   public void mouseMoved(MouseEvent var1) {
      if (this.l() != null) {
         this.l().mouseMoved(var1);
      }

   }

   public void actionPerformed(ActionEvent var1) {
      this.a(this.h);
      if (++this.h == this.b.a()) {
         this.h = 0;
      }

   }

   public void w() {
      if (this.d.size() > 0) {
         this.a((ImageDoodad)null);
         this.e.push(new k(this.b, this.h));
         this.u.j().setEnabled(true);
         this.a((k)this.d.pop());
         if (this.d.size() == 0) {
            this.u.i().setEnabled(false);
         }

         this.m();
      }

   }

   public void x() {
      if (this.e.size() > 0) {
         this.d.push(new k(this.b, this.h));
         this.u.i().setEnabled(true);
         this.a((k)this.e.pop());
         if (this.e.size() == 0) {
            this.u.j().setEnabled(false);
         }

         this.m();
      }

   }

   public void y() {
      if (this.e.size() > 0) {
         this.e.clear();
      }

      this.d.push(new k(this.b, this.h));
      this.u.i().setEnabled(true);
   }

   public void a(k var1) {
      this.b = new otherImageThingy(var1.a());
      this.a(var1.b());
   }

   public void a(ImageDoodad var1) {
      this.v = var1;
   }

   public void z() {
      if (this.v != null) {
         q var1 = this.d();
         if (var1 != null) {
            this.y();
            this.c().a(this.v, var1.a().x, var1.a().y);
            this.m();
            this.a((Rectangle)null);
            this.a((ImageDoodad)null);
         }
      }

   }

   public boolean A() {
      if (!this.w) {
         return true;
      } else if (this.d.size() == 0) {
         return true;
      } else {
         LockingUtil.a.a.i var1 = this.u.h();
         var1.actionPerformed((ActionEvent)null);
         return true;
      }
   }

   public void dispose() {
      if (this.A()) {
         super.dispose();
      }

   }

   public void a(boolean var1) {
      this.w = var1;
   }

   // $FF: synthetic method
   static otherImageThingy a(CustomDialog var0) {
      return var0.b;
   }

   // $FF: synthetic method
   static JSlider b(CustomDialog var0) {
      return var0.g;
   }

   // $FF: synthetic method
   static LockingUtil.a.a.a c(CustomDialog var0) {
      return var0.u;
   }

   // $FF: synthetic method
   static int a(CustomDialog var0, int var1) {
      return var0.h = var1;
   }

   // $FF: synthetic method
   static int d(CustomDialog var0) {
      return var0.h;
   }
}
