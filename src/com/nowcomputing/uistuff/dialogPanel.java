package com.nowcomputing.uistuff;

import com.nowcomputing.LocaleUtil;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class dialogPanel extends JPanel {
   protected JPanel c;
   protected JPanel d;
   protected JButton e;
   protected JButton f;
   protected JButton g;
   private boolean a;
   private boolean b;
   private boolean h;
   private String i;
   private ImageIcon j;
   private String k;

   public dialogPanel() {
      this.setBackground(GamebandColors.a);
      this.setLayout(new BorderLayout());
   }

   public void a(String var1) {
      this.i = var1;
   }

   protected void a(ImageIcon var1) {
      this.j = var1;
   }

   public void b(String var1) {
      this.k = var1;
   }

   public void a() throws IOException {
      this.add(this.g(), "North");
      this.add(this.b(), "Center");
   }

   protected Component g() throws IOException {
      this.c = new JPanel();
      this.c.setBackground(GamebandColors.b);
      this.c.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, GamebandColors.a(800, 1)));
      this.c.setLayout(new BorderLayout());
      this.c.add(this.m(), "West");
      this.c.add(this.n(), "East");
      JComponent var1 = this.j != null ? this.c() : this.d();
      this.c.add(var1, "Center");
      return this.c;
   }

   private JComponent c() {
      return new JLabel(this.j, 0);
   }

   private JComponent d() {
      JLabel var1 = new JLabel(this.i, 0);
      var1.setFont(GamebandFonts.j);
      var1.setForeground(GamebandColors.b());
      var1.setPreferredSize(new Dimension(100, 52));
      return var1;
   }

   private Component m() throws IOException {
      JPanel var1 = new JPanel();
      var1.setPreferredSize(new Dimension(180, 52));
      var1.setLayout(new BoxLayout(var1, 0));
      var1.setOpaque(false);
      if (this.i()) {
//         try {
            this.e = new B(new ImageIcon(this.getClass().getResource("/resources/home.png")));
            this.e.setPressedIcon(new ImageIcon(GamebandColors.getImage("/resources/home_pressed.png")));
            this.e.setToolTipText(LocaleUtil.getLocalizedString("GOTO_MAIN_MENU"));
//         } catch (IOException var3) {
//            this.e = new JButton("Home");
//         }

         var1.add(this.e);
      }

      var1.add(Box.createHorizontalGlue());
      return var1;
   }

   private Component n() throws IOException {
      JPanel var1 = new JPanel();
      var1.setPreferredSize(new Dimension(180, 52));
      var1.setLayout(new BoxLayout(var1, 0));
      var1.setOpaque(false);
      var1.add(Box.createHorizontalGlue());
      if (this.k()) {
         this.a(var1);
      }

      if (this.j()) {
//         try {
            this.f = new B(new ImageIcon(this.getClass().getResource("/resources/eject.png")));
            this.f.setPressedIcon(new ImageIcon(GamebandColors.getImage("/resources/eject_pressed.png")));
            this.f.setToolTipText(LocaleUtil.getLocalizedString("EJECT"));
//         } catch (IOException var3) {
//            this.f = new JButton("Eject");
//         }

         var1.add(this.f);
      }

      return var1;
   }

   private void a(JPanel var1) throws IOException {
//      try {
         this.g = new B(new ImageIcon(this.getClass().getResource("/resources/help.png")));
         this.g.setPressedIcon(new ImageIcon(GamebandColors.getImage("/resources/help_pressed.png")));
         this.g.setToolTipText(LocaleUtil.getLocalizedString("HELP"));
//      } catch (IOException var3) {
//         this.g = new JButton("Help");
//      }

      this.g.addActionListener(new A(this));
      var1.add(this.g);
   }

   protected Component b() {
      this.d = new JPanel();
      this.d.setOpaque(false);
      return this.d;
   }

   public JPanel h() {
      return this.d;
   }

   public JButton f() {
      return this.e;
   }

   public JButton e() {
      return this.f;
   }

   public boolean i() {
      return this.a;
   }

   public void a(boolean var1) {
      this.a = var1;
   }

   public boolean j() {
      return this.b;
   }

   public void b(boolean var1) {
      this.b = var1;
   }

   public boolean k() {
      return this.h;
   }

   public void c(boolean var1) {
      this.h = var1;
   }

   public void l() {
      N.a((Component)this, (String[])(new String[]{LocaleUtil.getLocalizedString("DISCLAIMER_HEADING"), LocaleUtil.getLocalizedString("DISCLAIMER_TEXT_1"), LocaleUtil.getLocalizedString("DISCLAIMER_TEXT_2"), LocaleUtil.getLocalizedString("DISCLAIMER_TEXT_3"), LocaleUtil.getLocalizedString("DISCLAIMER_TEXT_4")}), (String)"Gameband", (String)"www.nowcomputing.com/support");
   }
}
