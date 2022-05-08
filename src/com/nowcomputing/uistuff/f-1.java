package com.nowcomputing.uistuff;

import com.nowcomputing.LocaleUtil;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Locale;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class f extends at {
   protected f() {
      super("LANGUAGE");
      this.a();
   }

   protected void a() {
      this.setLayout(new BoxLayout(this, 1));
      this.setBorder(new EmptyBorder(175, 246, 0, 0));
      C var1 = new C(LocaleUtil.getLocalizedString("CHOOSE_LANGUAGE_HEADING"), 240);
      am.a(this, var1, GamebandFonts.i, GamebandColors.a());
      var1.setAlignmentX(0.0F);
      this.add(Box.createVerticalStrut(8));
      C var2 = new C(LocaleUtil.getLocalizedString("CHOOSE_LANGUAGE_1"), 240);
      am.a(this, var2, GamebandFonts.l, Color.WHITE);
      var2.setAlignmentX(0.0F);
      this.add(Box.createVerticalStrut(3));
      C var3 = new C(LocaleUtil.getLocalizedString("CHOOSE_LANGUAGE_2"), 240);
      am.a(this, var3, GamebandFonts.m, Color.WHITE);
      var3.setAlignmentX(0.0F);
      this.add(Box.createVerticalStrut(30));
      this.add(this.d());
   }

   private JPanel d() {
      JPanel var1 = new JPanel();
      var1.setAlignmentX(0.0F);
      var1.setLayout(new GridLayout(0, 3, 2, 2));
      var1.setMaximumSize(new Dimension(306, 66));
      var1.setOpaque(false);
      var1.add(this.a(new Locale("en")));
      var1.add(this.a(new Locale("es")));
      var1.add(this.a(new Locale("fr")));
      var1.add(this.a(new Locale("de")));
      var1.add(this.a(new Locale("ja")));
      var1.add(this.a(new Locale("ko")));
      return var1;
   }

   private Component a(Locale var1) {
      JButton var2 = new JButton(var1.getDisplayLanguage(var1));
      if (var1.getDisplayLanguage().equals(LocaleUtil.a().getDisplayLanguage())) {
         var2.setBackground(GamebandColors.e());
         var2.setForeground(GamebandColors.f());
      } else {
         var2.setBackground(GamebandColors.c());
         var2.setForeground(GamebandColors.d());
      }

      var2.setFont(GamebandFonts.b);
      var2.addActionListener(new g(this, var1));
      return var2;
   }

   public boolean b() {
      this.c.a();
      return false;
   }
}
