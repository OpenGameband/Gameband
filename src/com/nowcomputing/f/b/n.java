package com.nowcomputing.f.b;

import com.nowcomputing.N;
import com.nowcomputing.S;
import com.nowcomputing.d.q;
import com.nowcomputing.f.a.t;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class n extends e implements ActionListener {
   private static final Logger g = Logger.getLogger(S.class.getName());
   q a;
   private com.nowcomputing.a.g h;

   public n(t var1, q var2) {
      super(var1, com.nowcomputing.f.a("TIME"));
      this.a = var2;
      this.h();
      this.h = new com.nowcomputing.a.g();
      var2.a(this.h);
      JRadioButton var3 = new JRadioButton(N.a.a());
      var3.setActionCommand(N.a.a());
      var3.setOpaque(false);
      var3.setFont(com.nowcomputing.f.q.u);
      var3.setForeground(com.nowcomputing.f.h.m);
      var3.setBounds(278, 6, 120, 20);
      this.add(var3);
      JRadioButton var4 = new JRadioButton(N.b.a());
      var4.setActionCommand(N.b.a());
      var4.setOpaque(false);
      var4.setFont(com.nowcomputing.f.q.u);
      var4.setForeground(com.nowcomputing.f.h.m);
      var4.setBounds(278, 24, 120, 20);
      this.add(var4);
      if (var2.e() == 0) {
         var4.setSelected(true);
      } else {
         var3.setSelected(true);
      }

      ButtonGroup var5 = new ButtonGroup();
      var5.add(var3);
      var5.add(var4);
      var3.addActionListener(this);
      var4.addActionListener(this);
   }

   public com.nowcomputing.d.g b() {
      return this.a;
   }

   public void d() {
      SimpleDateFormat var1 = new SimpleDateFormat(this.a.b().b(), com.nowcomputing.f.a());
      var1.setTimeZone(com.nowcomputing.f.e());
      Date var2 = new Date();
      g.log(Level.FINE, "PF: current time: " + var2.getTime());
      String var3 = var1.format(var2);
      g.log(Level.FINE, "PF: formatted time: " + var3);
      this.a(this.e.d().c());
      com.nowcomputing.d var4 = this.a(var3);
      if (this.a.b() == N.b) {
         Calendar var5 = Calendar.getInstance();
         this.a(var4, var5.get(11) > 11);
      }

      this.a.h().b(var4);
      this.a.i().a(var4);
      this.a.i().b(new com.nowcomputing.d(20, 7));
      this.h.a(var4, com.nowcomputing.a.h.a, 3000, 0);
      super.d();
   }

   public void actionPerformed(ActionEvent var1) {
      if (N.a.a().equals(var1.getActionCommand())) {
         this.a.a(N.a);
      } else if (N.b.a().equals(var1.getActionCommand())) {
         this.a.a(N.b);
      }

      this.e.a(true);
      if (this.j()) {
         this.e();
         this.d();
      }

   }

   private com.nowcomputing.d a(String var1) {
      boolean var2 = false;
      int var4;
      if (this.e.d().a() == 0) {
         var4 = var1.length() == 4 ? 7 : 3;
      } else {
         var4 = var1.length() == 4 ? 4 : 0;
      }

      com.nowcomputing.d var3 = new com.nowcomputing.d(20, 7);
      var3.a((com.nowcomputing.d)com.nowcomputing.d.a(var1), var4, 1);
      return var3;
   }

   private void a(com.nowcomputing.d var1, boolean var2) {
      int var3 = this.e.d().a() == 0 ? 1 : 18;
      var1.a(var3, var2 ? var1.b() - 3 : 1, true);
      var1.a(var3, var2 ? var1.b() - 2 : 2, true);
   }
}