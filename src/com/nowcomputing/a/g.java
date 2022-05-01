package com.nowcomputing.a;

public class g extends a {
   private com.nowcomputing.d d;
   private int e;
   private int f;
   private h g;
   private int h;
   private int i;
   private int j;
   private boolean k;

   public void a(String var1, h var2, int var3, int var4, boolean var5) {
      this.d = com.nowcomputing.d.a(var1);
      this.g = var2;
      this.h = var3;
      this.i = var4;
      this.k = var5;
   }

   public void a(com.nowcomputing.d var1, h var2, int var3, int var4) {
      this.d = var1;
      this.g = var2;
      this.h = var3;
      this.i = var4;
   }

   protected void a() {
      super.a();
      if (this.g != com.nowcomputing.a.h.a && !this.k) {
         this.e = this.d.a();
         this.f = 20;
      } else {
         this.e = this.d.a() - 20;
         this.f = 0;
      }

      if (this.i > 0) {
         this.a(this.i);
      }

      this.j = (int)((float)this.f() * ((float)this.h / 1000.0F));
   }

   public boolean d() {
      if (this.d != null) {
         return !this.g();
      } else {
         return false;
      }
   }

   public com.nowcomputing.d e() {
      if (this.g == com.nowcomputing.a.h.a && this.f == 0) {
         if (--this.j > 0) {
            return this.d;
         }
      } else if (this.g == com.nowcomputing.a.h.b && this.f == 20 - this.d.a() && --this.j > 0) {
         return this.a(this.d, this.f, 0);
      }

      com.nowcomputing.d var1 = null;
      var1 = this.a(this.d, this.f--, 0);
      if (--this.e < 0) {
         this.a(true);
      }

      return var1;
   }

   private com.nowcomputing.d a(com.nowcomputing.d var1, int var2, int var3) {
      com.nowcomputing.d var4 = new com.nowcomputing.d(20, 7);
      var4.a(var1, var2, var3);
      return var4;
   }
}
