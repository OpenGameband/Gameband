package com.nowcomputing.c.b;

import com.nowcomputing.randomInterface;

class e {
   short[] a;
   // $FF: synthetic field
   final d b;

   e(d var1) {
      this.b = var1;
      this.a = new short[768];
   }

   public void a() {
      com.nowcomputing.c.c.b.a(this.a);
   }

   public byte a(com.nowcomputing.c.c.b var1) {
      int var2 = 1;

      do {
         var2 = var2 << 1 | var1.a(this.a, var2);
      } while(var2 < 256);

      return (byte)var2;
   }

   public byte a(com.nowcomputing.c.c.b var1, byte var2) {
      int var3 = 1;

      do {
         int var4 = var2 >> 7 & 1;
         var2 = (byte)(var2 << 1);
         int var5 = var1.a(this.a, (1 + var4 << 8) + var3);
         var3 = var3 << 1 | var5;
         if (var4 != var5) {
            while(var3 < 256) {
               var3 = var3 << 1 | var1.a(this.a, var3);
            }

            return (byte)var3;
         }
      } while(var3 < 256);

      return (byte)var3;
   }
}
