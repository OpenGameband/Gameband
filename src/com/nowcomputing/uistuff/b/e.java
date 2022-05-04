package com.nowcomputing.uistuff.b;

import com.nowcomputing.GamebandConfig;
import com.nowcomputing.ImageDoodad;
import com.nowcomputing.LocaleUtil;
import com.nowcomputing.otherImageThingy;
import com.nowcomputing.uistuff.q;
import com.nowcomputing.uistuff.a.t;
import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public abstract class e extends JPanel implements ImageDoodad.m {
   private boolean a = true;
   private boolean g;
   protected final com.nowcomputing.uistuff.n b;
   protected JCheckBox c;
   protected JButton d;
   protected final t e;
   protected JPanel f;

   public e(t var1, String var2) {
      this.b = new com.nowcomputing.uistuff.n(LocaleUtil.n.a, LocaleUtil.n.a, 0);
      this.f = new JPanel();
      this.e = var1;
      this.setName(var2);
      this.setBackground(LocaleUtil.h.l);
      this.setLayout((LayoutManager)null);
      JPanel var3 = this.k();
      var3.setBounds(16, 5, 104, 39);
      JLabel var4 = new JLabel(var2);
      var4.setVerticalAlignment(1);
      var4.setFont(q.t);
      var4.setForeground(LocaleUtil.h.m);
      var4.setBounds(144, 14, 140, 50);
      this.add(var4);
   }

   protected void f() {
      ImageIcon var1 = new ImageIcon(this.getClass().getResource("/resources/delete_screen.png"));
      this.d = new JButton(var1);
      this.d.setToolTipText(LocaleUtil.getLocalizedString("DELETE_MENU"));
      this.d.setBackground(LocaleUtil.h.l);
      this.d.setBounds(420, 13, 20, 24);
      this.add(this.d);
      this.d.addActionListener(new f(this));
   }

   protected void g() {
      this.e();
      this.e.b(this);
   }

   protected void h() {
      this.c = new JCheckBox(LocaleUtil.getLocalizedString("ENABLED_BUTTON"));
      this.add(this.c);
      this.c.setFont(q.u);
      this.c.setForeground(LocaleUtil.h.m);
      this.c.setBounds(420, 15, 100, 20);
      this.c.setOpaque(false);
      this.c.setSelected(true);
      this.c.addItemListener(new g(this));
   }

   protected void i() {
      ImageIcon var1 = new ImageIcon(this.getClass().getResource("/resources/edit.png"));
      JButton var2 = new JButton(var1);
      var2.setToolTipText(LocaleUtil.getLocalizedString("EDIT_BUTTON"));
      var2.setBackground(LocaleUtil.h.l);
      var2.setBounds(360, 14, 20, 24);
      this.add(var2);
      var2.addActionListener(new h(this));
   }

   public void d() {
      this.b().a((ImageDoodad.m)this);
      this.b().f();
      this.g = false;
   }

   public void e() {
      this.g = true;
      this.b().a((ImageDoodad.m)null);
      this.b().g();
      this.b.a(false);
   }

   public abstract ImageDoodad.g b();

   public void a(ImageDoodad var1) {
      if (var1 != null) {
         this.b.a(var1, 0, 0);
      }

   }

   public void a() {
      ImageDoodad.f.l().execute(new i(this));
   }

   public boolean j() {
      return this.a;
   }

   public void a(boolean var1) {
      this.a = var1;
      if (this.c != null) {
         this.c.setSelected(var1);
      }

      if (var1) {
         this.d();
      } else {
         this.e();
         this.b.a(false);
         this.b.repaint();
      }

   }

   private JPanel k() {
      this.add(this.f);
      this.f.setBorder(new EmptyBorder(2, 2, 2, 2));
      this.f.setBackground(LocaleUtil.n.a);
      this.f.setLayout((LayoutManager)null);
      this.f.add(this.b);
      this.b.setOpaque(true);
      this.b.setBounds(2, 2, 100, 35);
      return this.f;
   }

   public void a(GamebandConfig.d var1) {
      this.b().a(GamebandConfig.c.a(var1));
      this.b().b(GamebandConfig.c.b(var1));
   }

   public otherImageThingy c() {
      return null;
   }

   public void a(otherImageThingy var1) {
   }

   // $FF: synthetic method
   static boolean a(e var0) {
      return var0.g;
   }
}
