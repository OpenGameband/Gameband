package com.nowcomputing.c.b;

import com.nowcomputing.randomInterface;

import java.io.InputStream;
import java.io.OutputStream;

public class b {
   com.nowcomputing.c.a.a a = new com.nowcomputing.c.a.a();
   com.nowcomputing.c.c.b b = new com.nowcomputing.c.c.b();
   short[] c = new short[192];
   short[] d = new short[12];
   short[] e = new short[12];
   short[] f = new short[12];
   short[] g = new short[12];
   short[] h = new short[192];
   com.nowcomputing.c.c.a[] i = new com.nowcomputing.c.c.a[4];
   short[] j = new short[114];
   com.nowcomputing.c.c.a k = new com.nowcomputing.c.c.a(4);
   c l = new c(this);
   c m = new c(this);
   d n = new d(this);
   int o = -1;
   int p = -1;
   int q;

   public b() {
      for(int var1 = 0; var1 < 4; ++var1) {
         this.i[var1] = new com.nowcomputing.c.c.a(6);
      }

   }

   boolean a(int var1) {
      if (var1 < 0) {
         return false;
      } else {
         if (this.o != var1) {
            this.o = var1;
            this.p = Math.max(this.o, 1);
            this.a.a(Math.max(this.p, 4096));
         }

         return true;
      }
   }

   boolean a(int var1, int var2, int var3) {
      if (var1 <= 8 && var2 <= 4 && var3 <= 4) {
         this.n.a(var2, var1);
         int var4 = 1 << var3;
         this.l.a(var4);
         this.m.a(var4);
         this.q = var4 - 1;
         return true;
      } else {
         return false;
      }
   }

   void a() {
      this.a.a(false);
      com.nowcomputing.c.c.b.a(this.c);
      com.nowcomputing.c.c.b.a(this.h);
      com.nowcomputing.c.c.b.a(this.d);
      com.nowcomputing.c.c.b.a(this.e);
      com.nowcomputing.c.c.b.a(this.f);
      com.nowcomputing.c.c.b.a(this.g);
      com.nowcomputing.c.c.b.a(this.j);
      this.n.a();

      for(int var1 = 0; var1 < 4; ++var1) {
         this.i[var1].a();
      }

      this.l.a();
      this.m.a();
      this.k.a();
      this.b.b();
   }

   public boolean a(InputStream var1, OutputStream var2, long var3) {
      this.b.a(var1);
      this.a.a(var2);
      this.a();
      int var5 = com.nowcomputing.c.b.a.a();
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;
      int var9 = 0;
      long var10 = 0L;
      byte var12 = 0;

      while(var3 < 0L || var10 < var3) {
         int var13 = (int)var10 & this.q;
         if (this.b.a(this.c, (var5 << 4) + var13) == 0) {
            e var17 = this.n.a((int)var10, var12);
            if (!com.nowcomputing.c.b.a.e(var5)) {
               var12 = var17.a(this.b, this.a.b(var6));
            } else {
               var12 = var17.a(this.b);
            }

            this.a.a(var12);
            var5 = com.nowcomputing.c.b.a.a(var5);
            ++var10;
         } else {
            int var14;
            int var15;
            if (this.b.a(this.d, var5) == 1) {
               var14 = 0;
               if (this.b.a(this.e, var5) == 0) {
                  if (this.b.a(this.h, (var5 << 4) + var13) == 0) {
                     var5 = com.nowcomputing.c.b.a.d(var5);
                     var14 = 1;
                  }
               } else {
                  if (this.b.a(this.f, var5) == 0) {
                     var15 = var7;
                  } else {
                     if (this.b.a(this.g, var5) == 0) {
                        var15 = var8;
                     } else {
                        var15 = var9;
                        var9 = var8;
                     }

                     var8 = var7;
                  }

                  var7 = var6;
                  var6 = var15;
               }

               if (var14 == 0) {
                  var14 = this.m.a(this.b, var13) + 2;
                  var5 = com.nowcomputing.c.b.a.c(var5);
               }
            } else {
               var9 = var8;
               var8 = var7;
               var7 = var6;
               var14 = 2 + this.l.a(this.b, var13);
               var5 = com.nowcomputing.c.b.a.b(var5);
               var15 = this.i[com.nowcomputing.c.b.a.f(var14)].a(this.b);
               if (var15 >= 4) {
                  int var16 = (var15 >> 1) - 1;
                  var6 = (2 | var15 & 1) << var16;
                  if (var15 < 14) {
                     var6 += com.nowcomputing.c.c.a.a(this.j, var6 - var15 - 1, this.b, var16);
                  } else {
                     var6 += this.b.a(var16 - 4) << 4;
                     var6 += this.k.b(this.b);
                     if (var6 < 0) {
                        if (var6 != -1) {
                           return false;
                        }
                        break;
                     }
                  }
               } else {
                  var6 = var15;
               }
            }

            if ((long)var6 >= var10 || var6 >= this.p) {
               return false;
            }

            this.a.a(var6, var14);
            var10 += (long)var14;
            var12 = this.a.b(0);
         }
      }

      this.a.b();
      this.a.a();
      this.b.a();
      return true;
   }

   public boolean a(byte[] var1) {
      if (var1.length < 5) {
         return false;
      } else {
         int var2 = var1[0] & 255;
         int var3 = var2 % 9;
         int var4 = var2 / 9;
         int var5 = var4 % 5;
         int var6 = var4 / 5;
         int var7 = 0;

         for(int var8 = 0; var8 < 4; ++var8) {
            var7 += (var1[1 + var8] & 255) << var8 * 8;
         }

         return !this.a(var3, var5, var6) ? false : this.a(var7);
      }
   }
}
