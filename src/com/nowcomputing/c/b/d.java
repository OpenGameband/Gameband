package com.nowcomputing.c.b;

class d {
   e[] a;
   int b;
   int c;
   int d;
   // $FF: synthetic field
   final b e;

   d(b var1) {
      this.e = var1;
   }

   public void a(int var1, int var2) {
      if (this.a == null || this.b != var2 || this.c != var1) {
         this.c = var1;
         this.d = (1 << var1) - 1;
         this.b = var2;
         int var3 = 1 << this.b + this.c;
         this.a = new e[var3];

         for(int var4 = 0; var4 < var3; ++var4) {
            this.a[var4] = new e(this);
         }

      }
   }

   public void a() {
      int var1 = 1 << this.b + this.c;

      for(int var2 = 0; var2 < var1; ++var2) {
         this.a[var2].a();
      }

   }

   e a(int var1, byte var2) {
      return this.a[((var1 & this.d) << this.b) + ((var2 & 255) >>> 8 - this.b)];
   }
}
