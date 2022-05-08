package com.nowcomputing.uistuff;

import com.nowcomputing.LocaleUtil;

import java.awt.Color;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ag extends at {
   public ag() {
      super("Error");
      this.a();
   }

   protected void a() {
      JPanel var1 = new JPanel();
      var1.setOpaque(false);
      this.add(var1);
      var1.setLayout(new BoxLayout(var1, 1));
      var1.setBorder(new EmptyBorder(180, 0, 0, 0));
      JLabel var2 = new JLabel(LocaleUtil.getLocalizedString("NO_REG_HEADING"));
      var2.setAlignmentX(0.5F);
      am.a(var1, var2, GamebandFonts.i, GamebandColors.a());
      var1.add(Box.createVerticalStrut(10));
      JLabel var3 = new JLabel(LocaleUtil.getLocalizedString("NO_REG_1"));
      var3.setAlignmentX(0.5F);
      am.a(var1, var3, GamebandFonts.k, Color.white);
      JLabel var4 = new JLabel(LocaleUtil.getLocalizedString("NO_REG_2"));
      var4.setAlignmentX(0.5F);
      am.a(var1, var4, GamebandFonts.k, Color.white);
      var1.add(Box.createVerticalStrut(40));
      JButton var5 = new JButton(LocaleUtil.getLocalizedString("OK"));
      var5.setFont(GamebandFonts.n);
      var5.setAlignmentX(0.5F);
      var5.setBackground(GamebandColors.e());
      var5.setForeground(GamebandColors.f());
      var5.addActionListener(new ah(this));
      var1.add(var5);
   }
}
