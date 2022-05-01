package com.nowcomputing.c.c;

import java.io.InputStream;

public class b {
   int a;
   int b;
   InputStream c;

   public final void a(InputStream var1) {
      this.c = var1;
   }

   public final void a() {
      this.c = null;
   }

   public final void b() {
      this.b = 0;
      this.a = -1;

      for(int var1 = 0; var1 < 5; ++var1) {
         this.b = this.b << 8 | this.c.read();
      }

   }

   public final int a(int var1) {
      int var2 = 0;

      for(int var3 = var1; var3 != 0; --var3) {
         this.a >>>= 1;
         int var4 = this.b - this.a >>> 31;
         this.b -= this.a & var4 - 1;
         var2 = var2 << 1 | 1 - var4;
         if ((this.a & -16777216) == 0) {
            this.b = this.b << 8 | this.c.read();
            this.a <<= 8;
         }
      }

      return var2;
   }

   public int a(short[] var1, int var2) {
      short var3 = var1[var2];
      int var4 = (this.a >>> 11) * var3;
      if ((this.b ^ Integer.MIN_VALUE) < (var4 ^ Integer.MIN_VALUE)) {
         this.a = var4;
         var1[var2] = (short)(var3 + (2048 - var3 >>> 5));
         if ((this.a & -16777216) == 0) {
            this.b = this.b << 8 | this.c.read();
            this.a <<= 8;
         }

         return 0;
      } else {
         this.a -= var4;
         this.b -= var4;
         var1[var2] = (short)(var3 - (var3 >>> 5));
         if ((this.a & -16777216) == 0) {
            this.b = this.b << 8 | this.c.read();
            this.a <<= 8;
         }

         return 1;
      }
   }

   public static void a(short[] var0) {
      for(int var1 = 0; var1 < var0.length; ++var1) {
         var0[var1] = 1024;
      }

   }
}
