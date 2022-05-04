package com.nowcomputing.b;

import com.nowcomputing.b.a.CustomDialog;
import com.nowcomputing.otherImageThingy;

import javax.swing.JFrame;

public class FrameDingus {
   private JFrame a;
   private CustomDialog b;

   public FrameDingus(JFrame var1, otherImageThingy var2, boolean var3) {
      this.a = var1;
      if (var2 == null) {
         var2 = new otherImageThingy(10, 20);
      }

      this.b = new CustomDialog(this, this.a, var2);
      this.b.a(var3);
   }

   public void a() {
      this.b.setLocationRelativeTo(this.a);
      this.b.setVisible(true);
   }

   public otherImageThingy b() {
      return this.b.a();
   }
}
