package com.nowcomputing.f;

import java.awt.Color;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class o extends at {
   protected o() {
      super("Finished");
      this.a();
   }

   protected void a() {
      JPanel var1 = new JPanel();
      var1.setOpaque(false);
      this.add(var1);
      var1.setLayout(new BoxLayout(var1, 1));
      var1.setBorder(new EmptyBorder(140, 0, 0, 0));
      C var2 = new C(com.nowcomputing.f.a("SETUP_FINISHED_HEADING"), 420, "center");
      var2.setAlignmentX(0.5F);
      am.a(var1, var2, q.i, h.a());
      var1.add(Box.createVerticalStrut(20));
      C var3 = new C(com.nowcomputing.f.a("SETUP_FINISHED_1"), 420, "center");
      var3.setAlignmentX(0.5F);
      am.a(var1, var3, q.k, Color.white);
      var1.add(Box.createVerticalStrut(30));
      C var4 = new C(com.nowcomputing.f.a("SETUP_FINISHED_2"), 420, "center");
      var4.setAlignmentX(0.5F);
      am.a(var1, var4, q.k, Color.white);
      var1.add(Box.createVerticalStrut(40));
      JButton var5 = new JButton(com.nowcomputing.f.a("OK"));
      var5.setFont(q.n);
      var5.setAlignmentX(0.5F);
      var5.setBackground(h.e());
      var5.setForeground(h.f());
      var5.addActionListener(new p(this));
      var1.add(var5);
   }
}
