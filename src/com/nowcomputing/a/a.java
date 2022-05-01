package com.nowcomputing.a;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public abstract class a implements ActionListener {
   protected int a = 20;
   protected b b;
   protected Timer c;
   private boolean d;

   protected void a() {
      this.a(false);
   }

   public void b() {
      this.c();
      this.a();
      if (this.a < 1) {
         this.a = 1;
      }

      this.c = new Timer(1000 / this.a, this);
      this.c.start();
   }

   public void c() {
      if (this.c != null) {
         this.c.stop();
         this.c = null;
      }

   }

   public abstract boolean d();

   public abstract com.nowcomputing.d e();

   public void actionPerformed(ActionEvent var1) {
      if (this.b != null && this.d()) {
         this.b.a(this.e());
         if (!this.d()) {
            this.b.a();
         }
      }

   }

   public void a(b var1) {
      this.b = var1;
   }

   public int f() {
      return this.a;
   }

   public void a(int var1) {
      this.a = var1;
   }

   public boolean g() {
      return this.d;
   }

   protected void a(boolean var1) {
      this.d = var1;
   }
}
