package com.nowcomputing.uistuff.b;

import com.nowcomputing.*;
import com.nowcomputing.ImageDoodad.q;
import com.nowcomputing.uistuff.a.t;
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
   private static final Logger g = Logger.getLogger(Utils.class.getName());
   q a;
   private otherImageThingy.g h;

   public n(t var1, q var2) {
      super(var1, LocaleUtil.getLocalizedString("TIME"));
      this.a = var2;
      this.h();
      this.h = new otherImageThingy.g();
      var2.a(this.h);
      JRadioButton var3 = new JRadioButton(N.a.a());
      var3.setActionCommand(N.a.a());
      var3.setOpaque(false);
      var3.setFont(LocaleUtil.q.u);
      var3.setForeground(LocaleUtil.h.m);
      var3.setBounds(278, 6, 120, 20);
      this.add(var3);
      JRadioButton var4 = new JRadioButton(N.b.a());
      var4.setActionCommand(N.b.a());
      var4.setOpaque(false);
      var4.setFont(LocaleUtil.q.u);
      var4.setForeground(LocaleUtil.h.m);
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

   public ImageDoodad.g b() {
      return this.a;
   }

   public void d() {
      SimpleDateFormat var1 = new SimpleDateFormat(this.a.b().b(), LocaleUtil.a());
      var1.setTimeZone(LocaleUtil.e());
      Date var2 = new Date();
      g.log(Level.FINE, "PF: current time: " + var2.getTime());
      String var3 = var1.format(var2);
      g.log(Level.FINE, "PF: formatted time: " + var3);
      this.a(this.e.d().c());
      ImageDoodad var4 = this.a(var3);
      if (this.a.b() == N.b) {
         Calendar var5 = Calendar.getInstance();
         this.a(var4, var5.get(11) > 11);
      }

      this.a.h().b(var4);
      this.a.i().a(var4);
      this.a.i().b(new ImageDoodad(20, 7));
      this.h.a(var4, otherImageThingy.h.a, 3000, 0);
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

   private ImageDoodad a(String var1) {
      boolean var2 = false;
      int var4;
      if (this.e.d().a() == 0) {
         var4 = var1.length() == 4 ? 7 : 3;
      } else {
         var4 = var1.length() == 4 ? 4 : 0;
      }

      ImageDoodad var3 = new ImageDoodad(20, 7);
      var3.a((ImageDoodad) ImageDoodad.a(var1), var4, 1);
      return var3;
   }

   private void a(ImageDoodad var1, boolean var2) {
      int var3 = this.e.d().a() == 0 ? 1 : 18;
      var1.a(var3, var2 ? var1.b() - 3 : 1, true);
      var1.a(var3, var2 ? var1.b() - 2 : 2, true);
   }
}
