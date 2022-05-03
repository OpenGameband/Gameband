package com.nowcomputing.f;

import b.a.a.a.Class3;
import com.nowcomputing.*;

import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class aa extends z implements ActionListener {
   private static final Logger j = Logger.getLogger(Utils.class.getName());
   private ResourceBundle[] k = com.nowcomputing.f.d();
   private ArrayList l = new ArrayList();
   private ImageIcon m = new ImageIcon(this.getClass().getResource("/resources/left_hand_small.png"));
   private ImageIcon n = new ImageIcon(this.getClass().getResource("/resources/right_hand_small.png"));
   JRadioButton a;
   JRadioButton b;
   private ButtonGroup o;
   private short p;
   private ImageDoodad.f q;
   private GamebandConfig r;
   private JComboBox s;
   private JEditorPane t;
   private ImageIcon u;
   private ImageIcon v;
   JRadioButton h;
   JRadioButton i;
   private ButtonGroup w;

   aa(ImageDoodad.f var1, GamebandConfig var2) {
      this.a = new JRadioButton(this.m);
      this.b = new JRadioButton(this.n);
      this.o = new ButtonGroup();
      this.u = new ImageIcon(this.getClass().getResource("/resources/redstone.png"));
      this.v = new ImageIcon(this.getClass().getResource("/resources/diamond.png"));
      this.h = new JRadioButton(this.u);
      this.i = new JRadioButton(this.v);
      this.w = new ButtonGroup();
      this.q = var1;
      this.r = var2;
      ResourceBundle[] var3 = this.k;
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         ResourceBundle var6 = var3[var5];
         String var7 = var6.getLocale().getDisplayName(var6.getLocale());
         this.l.add(var7);
      }

      this.t = this.d(Main.c().b());
      this.a();
   }

   private JEditorPane d(String var1) {
      JEditorPane var2 = new JEditorPane();
      var2.setBorder(BorderFactory.createEmptyBorder());
      var2.setEditable(false);
      var2.setFont(com.nowcomputing.f.q.s);
      var2.setContentType("text/html");
      String var3 = "<html><body bgcolor='#232323'><a style='color:#e0d0d0;font-size:12px;font-family:helvetica;' href='" + var1 + "'>" + var1;
      var2.setText(var3);
      var2.addHyperlinkListener(new ab(this));
      return var2;
   }

   public void a() {
      this.removeAll();
      this.a((String)com.nowcomputing.f.a("OPTIONS_HEADING").toUpperCase());
      this.a(true);
      this.b(true);
      super.a();
   }

   void c() {
      this.setVisible(false);
   }

   protected Component b() {
      super.b();
      Class3 var1 = (new Class3(this.d)).method8(5.0D, 5.0D, 0.0D, 5.0D);
      this.c(var1);
      this.b(var1);
      this.a(var1);
      return this.d;
   }

   private void a(Class3 var1) {
      var1.method9().method65().method23(this.g(com.nowcomputing.f.a("GENERAL_OPTIONS").toUpperCase()));
      var1.method9().method14().method16(new JSeparator()).method17();
      var1.method10();
      JPanel var2 = new JPanel(new FlowLayout(0));
      var2.setOpaque(false);
      var2.add(this.o());
      var2.add(Box.createHorizontalStrut(166));
      var2.add(this.p());
      var1.method9().method15().method16(var2);
   }

   private JComponent o() {
      JPanel var1 = new JPanel();
      var1.setLayout(new BoxLayout(var1, 1));
      var1.setOpaque(false);
      var1.add(Box.createHorizontalStrut(270));
      var1.add(this.e(com.nowcomputing.f.a("CHOOSE_LANGUAGE")));
      var1.add(Box.createVerticalStrut(10));
      var1.add(this.s());
      var1.add(Box.createVerticalStrut(30));
      var1.add(this.v());
      Component[] var2 = var1.getComponents();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Component var5 = var2[var4];
         ((JComponent)var5).setAlignmentX(0.0F);
      }

      return var1;
   }

   private JComponent p() {
      JPanel var1 = new JPanel();
      var1.setLayout(new BoxLayout(var1, 1));
      var1.setOpaque(false);
      var1.add(this.x());
      var1.add(this.y());
      Component[] var2 = var1.getComponents();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Component var5 = var2[var4];
         ((JComponent)var5).setAlignmentX(0.0F);
      }

      return var1;
   }

   private JComponent a(JComponent var1, int var2, JComponent var3) {
      JPanel var4 = new JPanel();
      var4.setLayout(new BoxLayout(var4, 0));
      var4.setBorder(new EmptyBorder(0, 0, 0, 0));
      var4.setOpaque(false);
      var4.add(var1);
      var4.add(Box.createHorizontalStrut(var2));
      var4.add(var3);
      Component[] var5 = var4.getComponents();
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         Component var8 = var5[var7];
         ((JComponent)var8).setAlignmentY(1.0F);
      }

      return var4;
   }

   private void b(Class3 var1) {
      var1.method9().method65().method23(this.g(com.nowcomputing.f.a("GAMEBAND_DISPLAY_SETTINGS").toUpperCase()));
      var1.method9().method14().method16(new JSeparator()).method17();
      var1.method10();
      var1.method9().method65().method24(this.e(com.nowcomputing.f.a("CHOOSE_TIMEZONE")), 3).method25().method65().method24(this.e(com.nowcomputing.f.a("CHOOSE_ORIENTATION")), 3);
      var1.method9().method65().method24(this.t(), 3).method25().method65().method24(this.w(), 3).method25();
      var1.method10();
   }

   private void c(Class3 var1) {
      var1.method9().method65().method23(this.g(com.nowcomputing.f.a("MINECRAFT_OPTIONS").toUpperCase()));
      var1.method9().method14().method16(new JSeparator()).method17();
      var1.method10();
      var1.method9().method65().method23(this.e(com.nowcomputing.f.a("CHOOSE_LAUNCHER"))).method23(this.r()).method26(2);
      var1.method9().method65().method23(new JLabel(" "));
      var1.method9().method65().method23(this.q());
      var1.method9().method65().method23(new JLabel(" "));
      var1.method10();
   }

   private JComponent q() {
      JPanel var1 = new JPanel();
      var1.setLayout(new BoxLayout(var1, 0));
      var1.setOpaque(false);
      var1.add(this.e("For support go to: "));
      var1.add(this.e(" "));
      var1.add(this.t);
      return var1;
   }

   private JComponent r() {
      Vector var1 = Main.getLaunchers();
      this.s = new JComboBox(var1);
      this.s.setSelectedItem(Main.c());
      this.s.setPrototypeDisplayValue("1234567890");
      this.s.setFont(com.nowcomputing.f.q.C);
      this.s.addActionListener(new ac(this));
      return this.s;
   }

   private JComponent s() {
      JComboBox var1;
      if (this.l.size() == 0) {
         String[] var2 = new String[]{"English"};
         var1 = new JComboBox(var2);
      } else {
         var1 = new JComboBox(this.l.toArray());
         var1.setSelectedIndex(this.u());
      }

      var1.setPrototypeDisplayValue("1234567890");
      var1.setFont(com.nowcomputing.f.q.c);
      var1.addActionListener(new ae(this));
      return var1;
   }

   private JComponent t() {
      JComboBox var1 = new JComboBox(com.nowcomputing.O.a());
      var1.setPrototypeDisplayValue("12345678901234567890");
      String var2 = com.nowcomputing.O.a(com.nowcomputing.f.e());
      var1.setSelectedItem(var2);
      var1.setFont(com.nowcomputing.f.q.C);
      var1.addActionListener(new af(this));
      return var1;
   }

   protected ImageDoodad.f d() {
      return this.q;
   }

   private int u() {
      Locale var1 = com.nowcomputing.f.a();
      String var2 = var1.getDisplayName(var1);

      for(int var3 = 0; var3 < this.k.length; ++var3) {
         String var4 = this.k[var3].getLocale().getDisplayName(this.k[var3].getLocale());
         if (var1.getDisplayName(var1).equals(var4)) {
            return var3;
         }
      }

      return 0;
   }

   private JComponent v() {
      return this.a(this.f(com.nowcomputing.f.a("SOFTWARE_VERSION")), 10, this.h(WindowsVersionComparator.getImplementationVersion().toString()));
   }

   private JLabel e(String var1) {
      JLabel var2 = new JLabel(var1);
      var2.setFont(com.nowcomputing.f.q.A);
      var2.setForeground(com.nowcomputing.f.h.b());
      return var2;
   }

   private JLabel f(String var1) {
      JLabel var2 = new JLabel(var1);
      var2.setFont(com.nowcomputing.f.q.B);
      var2.setForeground(com.nowcomputing.f.h.b());
      return var2;
   }

   private JLabel g(String var1) {
      JLabel var2 = new JLabel(var1);
      var2.setFont(com.nowcomputing.f.q.j);
      var2.setForeground(com.nowcomputing.f.h.b());
      return var2;
   }

   private JComponent h(String var1) {
      JTextField var2 = new JTextField();
      var2.setText(var1);
      var2.setEditable(false);
      var2.setBackground(com.nowcomputing.f.h.a);
      var2.setForeground(com.nowcomputing.f.h.b());
      var2.setFont(com.nowcomputing.f.q.B);
      var2.setBorder((Border)null);
      return var2;
   }

   private JPanel w() {
      JPanel var1 = new JPanel();
      var1.setOpaque(false);
      var1.setLayout(new BoxLayout(var1, 2));
      var1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
      Z var2 = new Z();
      this.a.setActionCommand("LEFT");
      this.a.addActionListener(this);
      this.a.setUI(var2);
      this.o.add(this.a);
      this.b.setActionCommand("RIGHT");
      this.b.addActionListener(this);
      this.b.setUI(var2);
      this.o.add(this.b);
      var1.add(this.a(this.b));
      var1.add(Box.createHorizontalStrut(20));
      var1.add(this.a(this.a));
      return var1;
   }

   private Component a(JRadioButton var1) {
      JPanel var2 = new JPanel();
      var2.setOpaque(false);
      var2.setLayout(new BoxLayout(var2, 1));
      var2.add(var1);
      return var2;
   }

   private JComponent x() {
      return this.e(com.nowcomputing.f.a("OPTIONS_SKIN"));
   }

   private JPanel y() {
      JPanel var1 = new JPanel();
      var1.setOpaque(false);
      var1.setLayout(new BoxLayout(var1, 2));
      var1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
      Z var2 = new Z();
      this.h.setActionCommand("REDSTONE");
      this.h.addActionListener(this);
      this.h.setUI(var2);
      this.w.add(this.h);
      this.i.setActionCommand("DIAMOND");
      this.i.addActionListener(this);
      this.i.setUI(var2);
      this.w.add(this.i);
      var1.add(this.b(this.h));
      var1.add(Box.createHorizontalStrut(20));
      var1.add(this.b(this.i));
      return var1;
   }

   private Component b(JRadioButton var1) {
      JPanel var2 = new JPanel();
      var2.setOpaque(false);
      var2.setLayout(new BoxLayout(var2, 1));
      var2.add(var1);
      return var2;
   }

   public void a(short var1) {
      this.p = var1;
      if (var1 == 0) {
         this.o.setSelected(this.b.getModel(), true);
      } else if (var1 == 1) {
         this.o.setSelected(this.a.getModel(), true);
      }

   }

   public void c(String var1) {
      if (var1.equals("diamond")) {
         this.w.setSelected(this.i.getModel(), true);
      } else {
         this.w.setSelected(this.h.getModel(), true);
      }

   }

   public void actionPerformed(ActionEvent var1) {
      String var2 = var1.getActionCommand();
      if (var2.equals("LEFT")) {
         this.p = 1;
         this.d().a(true);
      } else if (var2.equals("RIGHT")) {
         this.p = 0;
         this.d().a(true);
      }

      if (var2.equals("DIAMOND")) {
         try {
            this.r.setProperty("skin", "diamond");
         } catch (IOException var5) {
            j.log(Level.WARNING, "Error setting skin", var5);
         }
      } else if (var2.equals("REDSTONE")) {
         try {
            this.r.setProperty("skin", "redstone");
         } catch (IOException var4) {
            j.log(Level.WARNING, "Error setting skin", var4);
         }
      }

   }

   public short m() {
      return this.p;
   }

   public void a(a.e var1) {
      if (var1 instanceof a.j) {
         N.a((Component)this, (String[])(new String[]{com.nowcomputing.f.a("OTHER_LAUNCHER_TEXT1"), com.nowcomputing.f.a("OTHER_LAUNCHER_TEXT2")}), (String)com.nowcomputing.f.a("OTHER_LAUNCHER_TITLE"), (String)"www.nowcomputing.com/contact");
         this.s.setSelectedIndex(0);
      } else {
         if (!(var1 instanceof a.g) && !var1.g()) {
            String[] var2 = new String[]{com.nowcomputing.f.a("NO"), com.nowcomputing.f.a("YES")};
            String[] var3 = new String[]{com.nowcomputing.f.a("LAUNCHER_DISCLAIMER"), com.nowcomputing.f.a("LAUNCHER_DISCLAIMER_1")};
            int var4 = N.a((Component)this, (String[])var3, (String)"Gameband", (String[])var2);
            if (var4 == 0) {
               this.s.setSelectedIndex(0);
               return;
            }
         }

         try {
            var1.d();
            String var6 = "<html><body bgcolor='#232323'><a style='color:#e0d0d0;font-size:12px;font-family:helvetica;' href='" + Main.c().b() + "'>" + Main.c().b();
            this.t.setText(var6);
         } catch (IOException var5) {
            this.s.setSelectedIndex(0);
         }
      }

   }

   public void n() {
      this.a(this.q.a());
      this.c(this.r.getProperty("skin", "redstone"));
   }

   // $FF: synthetic method
   static ResourceBundle[] a(aa var0) {
      return var0.k;
   }
}
