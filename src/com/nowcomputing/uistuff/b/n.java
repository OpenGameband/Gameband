package com.nowcomputing.uistuff.b;

import com.nowcomputing.*;
import com.nowcomputing.Image.q;
import com.nowcomputing.uistuff.apackage.t;
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
   ImageDisplay a;
   private AnimatedImage.g h;

   public n(t var1, ImageDisplay var2) {
      super(var1, LocaleUtil.getLocalizedString("TIME"));
      this.a = var2;
      this.h();
      this.h = new AnimatedImage.g();
      var2.a(this.h);
      JRadioButton var3 = new JRadioButton(TimeDisplay.TWENTYFOURHOUR.a());
      var3.setActionCommand(TimeDisplay.TWENTYFOURHOUR.a());
      var3.setOpaque(false);
      var3.setFont(LocaleUtil.q.u);
      var3.setForeground(LocaleUtil.h.m);
      var3.setBounds(278, 6, 120, 20);
      this.add(var3);
      JRadioButton var4 = new JRadioButton(TimeDisplay.TWELVEHOUR.a());
      var4.setActionCommand(TimeDisplay.TWELVEHOUR.a());
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

   public Image.g b() {
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
      Image var4 = this.a(var3);
      if (this.a.b() == TimeDisplay.TWELVEHOUR) {
         Calendar var5 = Calendar.getInstance();
         this.a(var4, var5.get(11) > 11);
      }

      this.a.h().b(var4);
      this.a.i().a(var4);
      this.a.i().b(new Image(20, 7));
      this.h.a(var4, AnimatedImage.h.a, 3000, 0);
      super.d();
   }

   public void actionPerformed(ActionEvent var1) {
      if (TimeDisplay.TWENTYFOURHOUR.a().equals(var1.getActionCommand())) {
         this.a.a(TimeDisplay.TWENTYFOURHOUR);
      } else if (TimeDisplay.TWELVEHOUR.a().equals(var1.getActionCommand())) {
         this.a.a(TimeDisplay.TWELVEHOUR);
      }

      this.e.a(true);
      if (this.j()) {
         this.e();
         this.d();
      }

   }

   private Image a(String var1) {
      boolean var2 = false;
      int var4;
      if (this.e.d().a() == 0) {
         var4 = var1.length() == 4 ? 7 : 3;
      } else {
         var4 = var1.length() == 4 ? 4 : 0;
      }

      Image var3 = new Image(20, 7);
      var3.ramImageInForcefully((Image) Image.FromFile(var1), var4, 1);
      return var3;
   }

   private void a(Image var1, boolean var2) {
      int var3 = this.e.d().a() == 0 ? 1 : 18;
      var1.setPixel(var3, var2 ? var1.getHeight() - 3 : 1, true);
      var1.setPixel(var3, var2 ? var1.getHeight() - 2 : 2, true);
   }
}
