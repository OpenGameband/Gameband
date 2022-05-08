package com.nowcomputing.uistuff;

import com.nowcomputing.LocaleUtil;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

public class I extends JDialog {
   private JLabel a;
   private JLabel b;
   private JLabel c;
   private JLabel d;
   private JLabel e;
   private JButton f = new JButton();

   public I(JFrame var1, String var2, String var3, String var4, String var5, String var6) {
      super(var1, true);
      this.a(var2, var3, var4, var5, var6);
      this.setDefaultCloseOperation(2);
      this.setResizable(false);
      this.pack();
      Insets var7 = this.getInsets();
      Dimension var8 = new Dimension(800 + var7.left + var7.right, 600 + var7.top + var7.bottom);
      this.setMinimumSize(var8);
      this.setMaximumSize(var8);
      this.setLocationRelativeTo(var1);
      this.getRootPane().getInputMap(2).put(KeyStroke.getKeyStroke(27, 0), "close");
      this.getRootPane().getInputMap(2).put(KeyStroke.getKeyStroke(10, 0), "close");
      this.getRootPane().getActionMap().put("close", new J(this));
   }

   private void a(String var1, String var2, String var3, String var4, String var5) {
      this.setTitle(LocaleUtil.getLocalizedString("ERROR_WINDOW_TITLE"));
      a var6 = new a();
      this.add(var6);
      JPanel var7 = new JPanel();
      var7.setOpaque(false);
      var6.add(var7);
      var7.setLayout(new BoxLayout(var7, 1));
      var7.setBorder(new EmptyBorder(120, 0, 0, 0));
      this.a = new C(var1, 500, "center");
      this.a.setAlignmentX(0.5F);
      am.a(var7, this.a, GamebandFonts.i, Color.white);
      var7.add(Box.createVerticalStrut(20));
      this.b = new C(var2, 500, "center");
      this.b.setAlignmentX(0.5F);
      am.a(var7, this.b, GamebandFonts.k, Color.white);
      var7.add(Box.createVerticalStrut(10));
      this.c = new C(var3, 500, "center");
      this.c.setAlignmentX(0.5F);
      am.a(var7, this.c, GamebandFonts.k, Color.white);
      var7.add(Box.createVerticalStrut(10));
      this.d = new C(var4, 500, "center");
      this.d.setAlignmentX(0.5F);
      am.a(var7, this.d, GamebandFonts.k, Color.white);
      var7.add(Box.createVerticalStrut(10));
      this.e = new C(var5, 500, "center");
      this.e.setAlignmentX(0.5F);
      am.a(var7, this.e, GamebandFonts.k, Color.white);
      var7.add(Box.createVerticalStrut(40));
      this.f.setFont(GamebandFonts.n);
      this.f.setBackground(GamebandColors.e());
      this.f.setForeground(GamebandColors.f());
      this.f.setAlignmentX(0.5F);
      this.f.setText(LocaleUtil.getLocalizedString("OK"));
      this.f.addActionListener(new K(this));
      var7.add(this.f);
   }
}
