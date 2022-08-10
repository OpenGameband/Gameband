package com.nowcomputing.b;

import com.nowcomputing.b.a.CustomDialog;
import com.nowcomputing.AnimatedImage;

import javax.swing.JFrame;

public class FrameDingus {
   private JFrame a;
   private CustomDialog b;

   public FrameDingus(JFrame var1, AnimatedImage var2, boolean var3) {
      this.a = var1;
      if (var2 == null) {
         var2 = new AnimatedImage(10, 20);
      }

      this.b = new CustomDialog(this, this.a, var2);
      this.b.a(var3);
   }

   public void a() {
      this.b.setLocationRelativeTo(this.a);
      this.b.setVisible(true);
   }

   public AnimatedImage b() {
      return this.b.a();
   }
}
