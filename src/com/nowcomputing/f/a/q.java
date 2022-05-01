package com.nowcomputing.f.a;

import com.nowcomputing.f.y;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class q extends JPanel implements com.nowcomputing.d.m {
   private final com.nowcomputing.f.n a;
   private BufferedImage b;
   private List c;
   private int d;

   public q(p var1) {
      this.a = new com.nowcomputing.f.n(com.nowcomputing.f.n.a, com.nowcomputing.f.n.a, 0);
      this.c = new ArrayList();
      this.setBackground(Color.BLACK);
      boolean var2 = var1.g().a() == 1;

      try {
         this.b = com.nowcomputing.f.h.a(var2);
      } catch (IOException var6) {
      }

      this.setLayout((LayoutManager)null);
      this.a.setOpaque(false);
      this.add(this.a);
      JButton var3 = new JButton();
      var3.setContentAreaFilled(false);
      var3.setBorderPainted(false);
      this.add(var3);
      var3.addActionListener(new r(this));
      if (var2) {
         this.a.setBounds(320, 282, 160, 56);
         var3.setBounds(536, 290, 27, 38);
      } else {
         this.a.setBounds(300, 295, 160, 56);
         var3.setBounds(227, 303, 28, 39);
      }

      JPanel var4 = new JPanel();
      this.add(var4);
      var4.setBounds(0, 400, 800, 100);
      var4.setOpaque(false);
      var4.setBorder(new EmptyBorder(60, 0, 0, 0));
      y var5 = new y(com.nowcomputing.f.a("CLOSE_BUTTON"));
      var5.setFont(com.nowcomputing.f.q.n);
      var5.setBackground(com.nowcomputing.f.h.e());
      var5.setForeground(com.nowcomputing.f.h.f());
      var4.add(var5);
      var5.addActionListener(new s(this, var1));
   }

   public void paintComponent(Graphics var1) {
      super.paintComponent(var1);
      var1.drawImage(this.b, 0, 0, this.getWidth(), this.getHeight(), (ImageObserver)null);
   }

   public void a(List var1) {
      if (this.d != 0) {
         ((com.nowcomputing.d.g)this.c.get(this.d - 1)).g();
         this.d = 0;
      }

      this.a.a(false);
      this.c = var1;
      Iterator var2 = this.c.iterator();

      while(var2.hasNext()) {
         com.nowcomputing.d.g var3 = (com.nowcomputing.d.g)var2.next();
         var3.a((com.nowcomputing.d.m)this);
      }

   }

   public void b() {
      if (this.d != 0) {
         ((com.nowcomputing.d.g)this.c.get(this.d - 1)).g();
      }

      if (this.d == this.c.size()) {
         this.d = 0;
      }

      if (this.c.size() > 0) {
         ((com.nowcomputing.d.g)this.c.get(this.d++)).f();
      }

   }

   public void a(com.nowcomputing.d var1) {
      if (var1 != null) {
         this.a.a(var1, 0, 0);
      }

   }

   public void a() {
      this.d = 0;
   }
}
