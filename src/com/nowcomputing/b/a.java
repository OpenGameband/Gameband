package com.nowcomputing.b;

import javax.swing.JFrame;

public class a {
   private JFrame a;
   private com.nowcomputing.b.a.a b;

   public a(JFrame var1, com.nowcomputing.a var2, boolean var3) {
      this.a = var1;
      if (var2 == null) {
         var2 = new com.nowcomputing.a(10, 20);
      }

      this.b = new com.nowcomputing.b.a.a(this, this.a, var2);
      this.b.a(var3);
   }

   public void a() {
      this.b.setLocationRelativeTo(this.a);
      this.b.setVisible(true);
   }

   public com.nowcomputing.a b() {
      return this.b.a();
   }
}
