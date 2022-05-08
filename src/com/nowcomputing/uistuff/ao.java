package com.nowcomputing.uistuff;

import com.nowcomputing.LocaleUtil;

import java.awt.Color;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ao extends at {
   protected ao() {
      super("Welcome");
      this.a();
   }

   protected void a() {
      JPanel var1 = new JPanel();
      var1.setOpaque(false);
      this.add(var1);
      var1.setLayout(new BoxLayout(var1, 1));
      var1.setBorder(new EmptyBorder(175, 0, 0, 0));
      C var2 = new C(LocaleUtil.getLocalizedString("WELCOME_TO_GAMEBAND"), 300, "center");
      var2.setAlignmentX(0.5F);
      am.a(var1, var2, GamebandFonts.i, GamebandColors.a());
      var1.add(Box.createVerticalStrut(10));
      C var3 = new C(LocaleUtil.getLocalizedString("WELCOME_1"), 300, "center");
      var3.setAlignmentX(0.5F);
      am.a(var1, var3, GamebandFonts.k, Color.white);
      var1.add(Box.createVerticalStrut(10));
      C var4 = new C(LocaleUtil.getLocalizedString("WELCOME_2"), 300, "center");
      var4.setAlignmentX(0.5F);
      am.a(var1, var4, GamebandFonts.k, Color.white);
      var1.add(Box.createVerticalStrut(40));
      JButton var5 = new JButton(LocaleUtil.getLocalizedString("OK"));
      var5.setFont(GamebandFonts.n);
      var5.setAlignmentX(0.5F);
      var5.setBackground(GamebandColors.e());
      var5.setForeground(GamebandColors.f());
      var5.addActionListener(new ap(this));
      var1.add(var5);
   }

   public boolean b() {
      this.c.a();
      return false;
   }
}
