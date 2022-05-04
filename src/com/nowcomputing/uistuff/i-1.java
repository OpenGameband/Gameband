package com.nowcomputing.uistuff;

import com.nowcomputing.LocaleUtil;
import com.nowcomputing.Utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class i extends at implements ActionListener, MouseListener {
   private static final Logger d = Logger.getLogger(Utils.class.getName());
   private JList e;
   private JLabel f;
   private JLabel g;
   private ImageIcon h = new ImageIcon(this.getClass().getResource("/resources/left_hand.png"));
   private ImageIcon i = new ImageIcon(this.getClass().getResource("/resources/right_hand.png"));
   JRadioButton a;
   JRadioButton b;
   private ButtonGroup j;
   private short k;

   protected i() {
      super("Configuration");
      this.a = new JRadioButton(this.h);
      this.b = new JRadioButton(this.i);
      this.j = new ButtonGroup();
      this.a();
   }

   private void a(short var1) {
      this.k = var1;
      if (var1 == 0) {
         this.j.setSelected(this.b.getModel(), true);
         this.g.setForeground(LocaleUtil.h.a());
         this.f.setForeground(Color.WHITE);
      } else if (var1 == 1) {
         this.j.setSelected(this.a.getModel(), true);
         this.g.setForeground(Color.WHITE);
         this.f.setForeground(LocaleUtil.h.a());
      }

   }

   protected void a() {
      this.setLayout(new BoxLayout(this, 1));
      this.setBorder(new EmptyBorder(40, 230, 0, 0));
      this.a(LocaleUtil.getLocalizedString("WHERE_ARE_YOU"), q.k, LocaleUtil.h.a());
      this.a(LocaleUtil.getLocalizedString("CONFIRM_TIMEZONE"), q.k, Color.WHITE);
      this.add(Box.createVerticalStrut(5));
      this.f();
      this.add(Box.createVerticalStrut(30));
      this.a(LocaleUtil.getLocalizedString("LEFT_OR_RIGHT"), q.k, LocaleUtil.h.a());
      this.a(LocaleUtil.getLocalizedString("ORIENTATION_1"), q.k, Color.WHITE);
      this.a(LocaleUtil.getLocalizedString("ORIENTATION_2"), q.m, Color.WHITE);
      this.add(Box.createVerticalStrut(10));
      this.g();
      this.add(Box.createVerticalStrut(25));
      this.h();
   }

   private void a(String var1, Font var2, Color var3) {
      C var4 = new C(var1, 300);
      am.a(this, var4, var2, var3);
      var4.setAlignmentX(0.0F);
   }

   private void f() {
      this.e = new JList(com.nowcomputing.O.a());
      this.e.setSelectionMode(0);
      this.e.setLayoutOrientation(0);
      this.e.setBackground(LocaleUtil.h.p);
      this.e.setForeground(Color.WHITE);
      this.e.setBorder((Border)null);
      JScrollPane var1 = new JScrollPane(this.e);
      var1.setPreferredSize(new Dimension(340, 80));
      var1.setMaximumSize(new Dimension(340, 80));
      var1.setAlignmentX(0.0F);
      var1.setBorder((Border)null);
      this.add(var1);
      this.e.setFont(q.C);
      this.e.addListSelectionListener(new j(this));
      String var2 = com.nowcomputing.O.a(LocaleUtil.e());
      this.e.setSelectedValue(var2, true);
   }

   private void g() {
      JPanel var1 = new JPanel();
      var1.setOpaque(false);
      var1.setAlignmentX(0.0F);
      var1.setLayout(new BoxLayout(var1, 0));
      var1.setMaximumSize(new Dimension(340, 190));
      this.add(var1);
      Z var2 = new Z();
      this.a.addActionListener(this);
      this.a.setUI(var2);
      this.j.add(this.a);
      this.b.addActionListener(this);
      this.b.setUI(var2);
      this.j.add(this.b);
      this.f = new JLabel(LocaleUtil.getLocalizedString("MY_LEFT_HAND"));
      var1.add(this.a(this.a, this.f));
      var1.add(Box.createHorizontalGlue());
      this.g = new JLabel(LocaleUtil.getLocalizedString("MY_RIGHT_HAND"));
      var1.add(this.a(this.b, this.g));
      this.a((short)0);
   }

   private Component a(JRadioButton var1, JLabel var2) {
      JPanel var3 = new JPanel();
      var3.setOpaque(false);
      var3.setLayout(new BoxLayout(var3, 1));
      var3.setMaximumSize(new Dimension(158, 190));
      var3.add(var1);
      var3.add(Box.createVerticalStrut(6));
      var2.addMouseListener(this);
      var2.setMaximumSize(new Dimension(158, 24));
      var2.setHorizontalAlignment(0);
      var2.setOpaque(true);
      var2.setBackground(LocaleUtil.h.p);
      var2.setForeground(Color.WHITE);
      var2.setFont(q.k);
      var3.add(var2);
      return var3;
   }

   private void h() {
      JPanel var1 = new JPanel();
      var1.setOpaque(false);
      var1.setAlignmentX(0.0F);
      var1.setMaximumSize(new Dimension(340, 80));
      this.add(var1);
      JButton var2 = new JButton(LocaleUtil.getLocalizedString("CONFIRM"));
      var2.setFont(q.n);
      var2.setBackground(LocaleUtil.h.e());
      var2.setForeground(LocaleUtil.h.f());
      var2.addActionListener(new k(this));
      var1.add(var2);
   }

   public void actionPerformed(ActionEvent var1) {
      Object var2 = var1.getSource();
      if (var2.equals(this.a)) {
         this.a((short)1);
      } else if (var2.equals(this.b)) {
         this.a((short)0);
      }

   }

   public void mouseClicked(MouseEvent var1) {
      Object var2 = var1.getSource();
      if (var2.equals(this.f)) {
         this.a((short)1);
      } else if (var2.equals(this.g)) {
         this.a((short)0);
      }

   }

   public void mousePressed(MouseEvent var1) {
   }

   public void mouseReleased(MouseEvent var1) {
   }

   public void mouseEntered(MouseEvent var1) {
   }

   public void mouseExited(MouseEvent var1) {
   }

   // $FF: synthetic method
   static short a(i var0) {
      return var0.k;
   }

   // $FF: synthetic method
   static Logger d() {
      return d;
   }
}
