package com.nowcomputing.f.a;

import com.nowcomputing.GamebandConfig;
import com.nowcomputing.S;
import java.awt.Color;
import java.awt.LayoutManager;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class a extends JPanel {
   private static final Logger a = Logger.getLogger(S.class.getName());
   private JComboBox b;
   private JButton c;

   public a(p var1) {
      this.setBackground(com.nowcomputing.f.h.n);
      this.setLayout((LayoutManager)null);
      JButton var2 = this.a(com.nowcomputing.f.a("ADD_ANIMATION"), 22);
      var2.addActionListener(new b(this, var1));
      JLabel var3 = new JLabel(com.nowcomputing.f.a("SET_TRANSITION"));
      this.add(var3);
      var3.setFont(com.nowcomputing.f.q.v);
      var3.setForeground(Color.WHITE);
      var3.setBounds(27, 76, 166, 25);
      GamebandConfig.d[] var4 = new GamebandConfig.d[]{GamebandConfig.d.b, GamebandConfig.d.c, GamebandConfig.d.d, GamebandConfig.d.a};
      this.b = new JComboBox(var4);
      this.b.setSelectedItem(var1.g().c());
      this.add(this.b);
      this.b.setFont(com.nowcomputing.f.q.v);
      this.b.setForeground(com.nowcomputing.f.h.o);
      this.b.setBounds(22, 104, 146, 35);
      this.b.addActionListener(new c(this, var1));
      JButton var5 = this.a(com.nowcomputing.f.a("PREVIEW"), 156);
      var5.addActionListener(new d(this, var1));
      this.c = this.a(com.nowcomputing.f.a("SAVE_TO_GAMEBAND"), 208);
      this.c.addActionListener(new e(this, var1));
   }

   private JButton a(String var1, int var2) {
      JButton var3 = new JButton("<html><center>" + var1);
      this.add(var3);
      var3.setFont(com.nowcomputing.f.q.v);
      var3.setBackground(com.nowcomputing.f.h.j);
      var3.setForeground(com.nowcomputing.f.h.o);
      var3.setBounds(22, var2, 146, 40);
      return var3;
   }
}
