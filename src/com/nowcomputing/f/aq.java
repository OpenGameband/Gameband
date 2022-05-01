package com.nowcomputing.f;

import java.awt.CardLayout;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

public class aq extends JPanel implements ar {
   List a = new LinkedList();
   private CardLayout b = new CardLayout();
   private as c;
   private at d;
   private at e;

   public aq() {
      this.setLayout(this.b);
   }

   public void a(at var1) {
      var1.a(this);
      this.a.add(var1);
      this.b.addLayoutComponent(var1, var1.getName());
   }

   public void b(at var1) {
      this.e = var1;
      this.e.a(this);
   }

   public void a(as var1) {
      this.c = var1;
   }

   public void c(at var1) {
      this.d = var1;
      this.remove(var1);
      this.validate();
      this.add(var1, var1.getName());
      var1.e();
      this.b.show(this, var1.getName());
   }

   public void a() {
      if (this.e != null) {
         this.removeAll();
         this.add(this.e, "error");
         this.repaint();
      }

   }

   public void b() {
      int var1 = -1;
      if (this.d != null) {
         var1 = this.a.indexOf(this.d);
      }

      if (var1 + 1 < this.a.size()) {
         at var2 = (at)this.a.get(var1 + 1);
         this.c(var2);
      }

   }

   public void c() {
      if (this.c != null) {
         this.c.b(this.d);
      }

   }

   public void d() {
      if (this.c != null) {
         this.c.a(this.d);
      }

   }

   public boolean e() {
      return this.d != null ? this.d.b() : true;
   }
}
