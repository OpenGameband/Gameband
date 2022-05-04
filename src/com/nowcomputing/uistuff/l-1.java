package com.nowcomputing.uistuff;

import com.nowcomputing.LocaleUtil;

import java.awt.Color;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class l extends at {
   protected l() {
      super("Disclaimer");
      this.a();
   }

   protected void a() {
      JPanel var1 = new JPanel();
      var1.setOpaque(false);
      this.add(var1);
      var1.setLayout(new BoxLayout(var1, 1));
      var1.setBorder(new EmptyBorder(140, 0, 0, 0));
      C var2 = new C(LocaleUtil.getLocalizedString("DISCLAIMER_HEADING"), 420, "center");
      var2.setAlignmentX(0.5F);
      am.a(var1, var2, q.i, GamebandColors.a());
      var1.add(Box.createVerticalStrut(20));
      C var3 = new C(LocaleUtil.getLocalizedString("DISCLAIMER_TEXT_1"), 420, "center");
      var3.setAlignmentX(0.5F);
      am.a(var1, var3, q.k, Color.white);
      var1.add(Box.createVerticalStrut(6));
      C var4 = new C(LocaleUtil.getLocalizedString("DISCLAIMER_TEXT_2"), 420, "center");
      var4.setAlignmentX(0.5F);
      am.a(var1, var4, q.k, Color.white);
      var1.add(Box.createVerticalStrut(6));
      C var5 = new C(LocaleUtil.getLocalizedString("DISCLAIMER_TEXT_3"), 420, "center");
      var5.setAlignmentX(0.5F);
      am.a(var1, var5, q.k, Color.white);
      var1.add(Box.createVerticalStrut(10));
      C var6 = new C(LocaleUtil.getLocalizedString("DISCLAIMER_TEXT_4"), 420, "center");
      var6.setAlignmentX(0.5F);
      am.a(var1, var6, q.k, Color.white);
      var1.add(Box.createVerticalStrut(40));
      JButton var7 = new JButton(LocaleUtil.getLocalizedString("OK"));
      var7.setFont(q.n);
      var7.setAlignmentX(0.5F);
      var7.setBackground(GamebandColors.e());
      var7.setForeground(GamebandColors.f());
      var7.addActionListener(new m(this));
      var1.add(var7);
   }
}
