package com.nowcomputing.uistuff.b;

import com.nowcomputing.ImageDoodad;
import com.nowcomputing.N;
import com.nowcomputing.LocaleUtil;
import com.nowcomputing.otherImageThingy;
import com.nowcomputing.uistuff.GamebandFonts;
import com.nowcomputing.uistuff.apackage.t;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class b extends e implements ActionListener {
   ImageDoodad.b a;
   private otherImageThingy.g g;

   public b(t var1, ImageDoodad.b var2) {
      super(var1, LocaleUtil.getLocalizedString("DATE"));
      this.a = var2;
      this.h();
      this.g = new otherImageThingy.g();
      var2.a(this.g);
      JRadioButton var3 = new JRadioButton(N.d.a());
      var3.setActionCommand(N.d.a());
      var3.setOpaque(false);
      var3.setFont(GamebandFonts.u);
      var3.setForeground(LocaleUtil.h.m);
      var3.setBounds(278, 6, 120, 20);
      this.add(var3);
      JRadioButton var4 = new JRadioButton(N.c.a());
      var4.setActionCommand(N.c.a());
      var4.setOpaque(false);
      var4.setFont(GamebandFonts.u);
      var4.setForeground(LocaleUtil.h.m);
      var4.setBounds(278, 24, 120, 20);
      this.add(var4);
      if (var2.e() == 2) {
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
      String var2 = var1.format(new Date());
      this.a(this.e.d().c());
      ImageDoodad var3 = this.a(var2);
      this.a.h().b(var3);
      this.a.i().a(var3);
      this.a.i().b(new ImageDoodad(20, 7));
      this.g.a(var3, otherImageThingy.h.a, 3000, 20);
      super.d();
   }

   public void actionPerformed(ActionEvent var1) {
      if (N.d.a().equals(var1.getActionCommand())) {
         this.a.a(N.d);
      } else if (N.c.a().equals(var1.getActionCommand())) {
         this.a.a(N.c);
      }

      this.e.a(true);
      if (this.j()) {
         this.e();
         this.d();
      }

   }

   private ImageDoodad a(String var1) {
      int var2 = this.e.d().a() == 0 ? 3 : 0;
      ImageDoodad var3 = new ImageDoodad(20, 7);
      var3.a((ImageDoodad) ImageDoodad.a(var1), var2, 1);
      return var3;
   }
}
