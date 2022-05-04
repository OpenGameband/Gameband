package com.nowcomputing.c.b;

import com.nowcomputing.randomInterface;

class c {
   short[] a;
   com.nowcomputing.c.c.a[] b;
   com.nowcomputing.c.c.a[] c;
   com.nowcomputing.c.c.a d;
   int e;
   // $FF: synthetic field
   final b f;

   c(b var1) {
      this.f = var1;
      this.a = new short[2];
      this.b = new com.nowcomputing.c.c.a[16];
      this.c = new com.nowcomputing.c.c.a[16];
      this.d = new com.nowcomputing.c.c.a(8);
      this.e = 0;
   }

   public void a(int var1) {
      while(this.e < var1) {
         this.b[this.e] = new com.nowcomputing.c.c.a(3);
         this.c[this.e] = new com.nowcomputing.c.c.a(3);
         ++this.e;
      }

   }

   public void a() {
      com.nowcomputing.c.c.b.a(this.a);

      for(int var1 = 0; var1 < this.e; ++var1) {
         this.b[var1].a();
         this.c[var1].a();
      }

      this.d.a();
   }

   public int a(com.nowcomputing.c.c.b var1, int var2) {
      if (var1.a(this.a, 0) == 0) {
         return this.b[var2].a(var1);
      } else {
         byte var3 = 8;
         int var4;
         if (var1.a(this.a, 1) == 0) {
            var4 = var3 + this.c[var2].a(var1);
         } else {
            var4 = var3 + 8 + this.d.a(var1);
         }

         return var4;
      }
   }
}
