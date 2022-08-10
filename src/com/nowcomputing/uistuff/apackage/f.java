package com.nowcomputing.uistuff.apackage;

import com.nowcomputing.LocaleUtil;
import com.nowcomputing.AnimatedImage;
import com.nowcomputing.uistuff.N;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AbstractDocument;

public class f extends JPanel {
   private p a;
   private JRadioButton b;
   private JRadioButton c;
   private JRadioButton d;
   private JRadioButton e;
   private JTextField f;
   private JFileChooser g;
   private final JLabel h = new JLabel();
   private JFileChooser i;
   private final JLabel j = new JLabel();
   private JComboBox k;
   private JComboBox l;
   private final JCheckBox m;
   private final JCheckBox n;

   f(p var1) {
      this.a = var1;
      this.setLayout((LayoutManager)null);
      this.m = new JCheckBox(LocaleUtil.getLocalizedString("SCROLL_OFF"));
      this.n = new JCheckBox(LocaleUtil.getLocalizedString("SCROLL_OFF"));
      JPanel var2 = new JPanel();
      var2.setBounds(78, 62, 644, 486);
      var2.setLayout((LayoutManager)null);
      var2.setBackground(LocaleUtil.h.r);
      this.add(var2);
      this.a(var2);
      JPanel var3 = new JPanel();
      var3.setBackground(LocaleUtil.h.q);
      var3.setBounds(0, 0, 644, 20);
      var2.add(var3);
      var2.add(this.a(this.b));
      var2.add(this.b(this.c));
      var2.add(this.c(this.d));
      var2.add(this.d(this.e));
      var2.add(this.a());
   }

   public void setVisible(boolean var1) {
      if (var1) {
         this.g = new JFileChooser(".");
         this.g.setFileFilter(new FileNameExtensionFilter("Images", new String[]{"png", "gif"}));
         this.i = new JFileChooser(".");
         this.i.setFileFilter(new FileNameExtensionFilter("GIF Images", new String[]{"gif"}));
         this.f.setText("");
         this.h.setText("");
         this.j.setText("");
      }

      super.setVisible(var1);
   }

   private void a(JPanel var1) {
      ButtonGroup var2 = new ButtonGroup();
      this.b = new JRadioButton(LocaleUtil.getLocalizedString("SCROLL_TEXT"));
      this.b.setSelected(true);
      this.b.setOpaque(false);
      var2.add(this.b);
      this.c = new JRadioButton(LocaleUtil.getLocalizedString("SCROLL_IMAGE"));
      this.c.setOpaque(false);
      var2.add(this.c);
      this.d = new JRadioButton(LocaleUtil.getLocalizedString("LOAD_GIF"));
      this.d.setOpaque(false);
      var2.add(this.d);
      this.e = new JRadioButton(LocaleUtil.getLocalizedString("CREATE_ANIM"));
      this.e.setOpaque(false);
      var2.add(this.e);
   }

   private JPanel a(JRadioButton var1) {
      JPanel var2 = this.e(var1);
      var2.setBounds(0, 20, 644, 92);
      this.f = new JTextField();
      this.f.setBounds(86, 50, 160, 36);
      this.f.setColumns(16);
      this.f.setFont(com.nowcomputing.o.a(24));
      ((AbstractDocument)this.f.getDocument()).setDocumentFilter(new u(100));
      this.f.addFocusListener(new g(this));
      this.f.addActionListener(new h(this));
      var2.add(this.f);
      this.k = new JComboBox(AnimatedImage.d.a());
      JPanel var3 = this.a(this.k, this.m);
      this.k.addActionListener(new i(this));
      var2.add(var3);
      return var2;
   }

   private JPanel b(JRadioButton var1) {
      JPanel var2 = this.e(var1);
      var2.setBounds(0, 116, 644, 92);
      this.h.setFont(LocaleUtil.q.x);
      this.h.setBounds(195, 48, 120, 26);
      var2.add(this.h);
      JButton var3 = new JButton(LocaleUtil.getLocalizedString("OPEN_BUTTON"));
      var3.setFont(LocaleUtil.q.x);
      var3.setBounds(86, 50, 100, 26);
      var2.add(var3);
      var3.addActionListener(new j(this));
      this.l = new JComboBox(AnimatedImage.d.a());
      JPanel var4 = this.a(this.l, this.n);
      var2.add(var4);
      return var2;
   }

   private JPanel c(JRadioButton var1) {
      JPanel var2 = this.e(var1);
      var2.setBounds(0, 212, 644, 92);
      this.j.setFont(LocaleUtil.q.x);
      this.j.setBounds(195, 48, 220, 26);
      var2.add(this.j);
      JButton var3 = new JButton(LocaleUtil.getLocalizedString("OPEN_BUTTON"));
      var3.setFont(LocaleUtil.q.x);
      var3.setBounds(86, 50, 100, 26);
      var2.add(var3);
      var3.addActionListener(new k(this));
      return var2;
   }

   private JPanel d(JRadioButton var1) {
      JPanel var2 = this.e(var1);
      var2.setBounds(0, 308, 644, 92);
      var1.setBounds(65, 38, 480, 20);
      return var2;
   }

   private JPanel a() {
      JPanel var1 = new JPanel();
      var1.setBackground(LocaleUtil.h.q);
      var1.setLayout(new FlowLayout(1, 30, 20));
      var1.setBounds(0, 404, 644, 104);
      JButton var2 = new JButton(LocaleUtil.getLocalizedString("CANCEL"));
      var1.add(var2);
      var2.setFont(LocaleUtil.q.w);
      var2.addActionListener(new l(this));
      JButton var3 = new JButton(LocaleUtil.getLocalizedString("GO_BUTTON"));
      var1.add(var3);
      var3.setFont(LocaleUtil.q.w);
      var3.addActionListener(new m(this));
      return var1;
   }

   private JPanel e(JRadioButton var1) {
      JPanel var2 = new JPanel();
      var2.setBackground(LocaleUtil.h.q);
      var2.setLayout((LayoutManager)null);
      var1.setBounds(65, 25, 280, 20);
      var1.setFont(LocaleUtil.q.w);
      var1.setForeground(LocaleUtil.h.s);
      var2.add(var1);
      return var2;
   }

   private JPanel a(JComboBox var1, JCheckBox var2) {
      JPanel var3 = new JPanel();
      var3.setBounds(296, 0, 345, 92);
      var3.setOpaque(false);
      var3.setLayout(new BoxLayout(var3, 1));
      JPanel var4 = new JPanel();
      var4.setLayout(new FlowLayout(2, 0, 0));
      var4.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 20));
      var4.setOpaque(false);
      var3.add(var4);
      JLabel var5 = new JLabel(LocaleUtil.getLocalizedString("SCROLL_DIRECTION"));
      var5.setBounds(2, 25, 260, 20);
      var5.setFont(LocaleUtil.q.x);
      var5.setForeground(LocaleUtil.h.s);
      var4.add(var5);
      var1.setBounds(0, 50, 100, 26);
      var1.setFont(LocaleUtil.q.x);
      var4.add(var1);
      JPanel var6 = new JPanel();
      var6.setLayout(new FlowLayout(2, 0, 0));
      var6.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
      var6.setOpaque(false);
      var3.add(var6);
      var2.setBounds(144, 52, 160, 26);
      var2.setOpaque(false);
      var2.setFont(LocaleUtil.q.x);
      var2.setForeground(LocaleUtil.h.s);
      var2.setHorizontalTextPosition(2);
      var6.add(var2);
      return var3;
   }

   private void b() {
      if (this.b.isSelected()) {
         String var1 = this.f.getText();
         if (!var1.equals("")) {
            this.a.a(var1, (AnimatedImage.d)this.k.getSelectedItem(), this.m.isSelected());
         }

         this.a.c(false);
      } else {
         o var2;
         File var5;
         if (this.c.isSelected()) {
            var5 = this.a(this.g);
            if (var5 != null) {
               var2 = o.a(var5);
               if (var2 != o.a && var2 != o.c) {
                  if (var2 == o.b) {
                     N.a((Component)this, (String[])(new String[]{LocaleUtil.getLocalizedString("ERROR_WRONG_FORMAT_HEADER"), LocaleUtil.getLocalizedString("ERROR_NOT_STATIC_IMAGE_1"), LocaleUtil.getLocalizedString("ERROR_NOT_STATIC_IMAGE_2")}));
                  } else {
                     N.a((Component)this, (String[])(new String[]{LocaleUtil.getLocalizedString("ERROR_WRONG_FORMAT_HEADER"), LocaleUtil.getLocalizedString("ERROR_WRONG_FORMAT"), LocaleUtil.getLocalizedString("ERROR_NOT_STATIC_IMAGE_2")}));
                  }
               } else {
                  this.a.a(var5, (AnimatedImage.d)this.l.getSelectedItem(), this.n.isSelected());
                  this.a.c(false);
               }
            }
         } else if (this.d.isSelected()) {
            var5 = this.a(this.i);
            if (var5 != null) {
               var2 = o.a(var5);
               if (var2 != o.a && var2 != o.b) {
                  N.a((Component)this, (String[])(new String[]{LocaleUtil.getLocalizedString("ERROR_WRONG_FORMAT_HEADER"), LocaleUtil.getLocalizedString("ERROR_WRONG_FORMAT"), LocaleUtil.getLocalizedString("ERROR_NOT_GIF")}));
               } else {
                  try {
                     this.a.a(var5);
                  } catch (IOException var4) {
                     N.a((Component)this, (String[])(new String[]{LocaleUtil.getLocalizedString("ERROR_WRONG_FORMAT_HEADER"), LocaleUtil.getLocalizedString("ERROR_WRONG_FORMAT"), LocaleUtil.getLocalizedString("ERROR_NOT_GIF")}));
                  }

                  this.a.c(false);
               }
            }
         } else if (this.e.isSelected()) {
            this.a.i();
            this.a.c(false);
         }
      }

   }

   private File a(JFileChooser var1) {
      File var2 = var1.getSelectedFile();
      if (var2 == null) {
         int var3 = var1.showOpenDialog(this);
         if (var3 == 0) {
            var2 = var1.getSelectedFile();
         }
      }

      return var2;
   }

   // $FF: synthetic method
   static JRadioButton a(f var0) {
      return var0.b;
   }

   // $FF: synthetic method
   static void b(f var0) {
      var0.b();
   }

   // $FF: synthetic method
   static JTextField c(f var0) {
      return var0.f;
   }

   // $FF: synthetic method
   static JRadioButton d(f var0) {
      return var0.c;
   }

   // $FF: synthetic method
   static JFileChooser e(f var0) {
      return var0.g;
   }

   // $FF: synthetic method
   static JLabel f(f var0) {
      return var0.h;
   }

   // $FF: synthetic method
   static JRadioButton g(f var0) {
      return var0.d;
   }

   // $FF: synthetic method
   static JFileChooser h(f var0) {
      return var0.i;
   }

   // $FF: synthetic method
   static JLabel i(f var0) {
      return var0.j;
   }

   // $FF: synthetic method
   static p j(f var0) {
      return var0.a;
   }
}
