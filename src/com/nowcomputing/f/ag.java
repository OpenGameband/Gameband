package com.nowcomputing.f;

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
      JLabel var2 = new JLabel(com.nowcomputing.f.a("NO_REG_HEADING"));
      var2.setAlignmentX(0.5F);
      am.a(var1, var2, q.i, h.a());
      var1.add(Box.createVerticalStrut(10));
      JLabel var3 = new JLabel(com.nowcomputing.f.a("NO_REG_1"));
      var3.setAlignmentX(0.5F);
      am.a(var1, var3, q.k, Color.white);
      JLabel var4 = new JLabel(com.nowcomputing.f.a("NO_REG_2"));
      var4.setAlignmentX(0.5F);
      am.a(var1, var4, q.k, Color.white);
      var1.add(Box.createVerticalStrut(40));
      JButton var5 = new JButton(com.nowcomputing.f.a("OK"));
      var5.setFont(q.n);
      var5.setAlignmentX(0.5F);
      var5.setBackground(h.e());
      var5.setForeground(h.f());
      var5.addActionListener(new ah(this));
      var1.add(var5);
   }
}
