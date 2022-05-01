package com.nowcomputing.c.c;

public class a {
   short[] a;
   int b;

   public a(int var1) {
      this.b = var1;
      this.a = new short[1 << var1];
   }

   public void a() {
      com.nowcomputing.c.c.b.a(this.a);
   }

   public int a(b var1) {
      int var2 = 1;

      for(int var3 = this.b; var3 != 0; --var3) {
         var2 = (var2 << 1) + var1.a(this.a, var2);
      }

      return var2 - (1 << this.b);
   }

   public int b(b var1) {
      int var2 = 1;
      int var3 = 0;

      for(int var4 = 0; var4 < this.b; ++var4) {
         int var5 = var1.a(this.a, var2);
         var2 <<= 1;
         var2 += var5;
         var3 |= var5 << var4;
      }

      return var3;
   }

   public static int a(short[] var0, int var1, b var2, int var3) {
      int var4 = 1;
      int var5 = 0;

      for(int var6 = 0; var6 < var3; ++var6) {
         int var7 = var2.a(var0, var1 + var4);
         var4 <<= 1;
         var4 += var7;
         var5 |= var7 << var6;
      }

      return var5;
   }
}
