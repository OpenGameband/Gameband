package com.nowcomputing.c.a;

import java.io.OutputStream;

public class a {
   byte[] a;
   int b;
   int c = 0;
   int d;
   OutputStream e;

   public void a(int var1) {
      if (this.a == null || this.c != var1) {
         this.a = new byte[var1];
      }

      this.c = var1;
      this.b = 0;
      this.d = 0;
   }

   public void a(OutputStream var1) {
      this.a();
      this.e = var1;
   }

   public void a() {
      this.b();
      this.e = null;
   }

   public void a(boolean var1) {
      if (!var1) {
         this.d = 0;
         this.b = 0;
      }

   }

   public void b() {
      int var1 = this.b - this.d;
      if (var1 != 0) {
         this.e.write(this.a, this.d, var1);
         if (this.b >= this.c) {
            this.b = 0;
         }

         this.d = this.b;
      }
   }

   public void a(int var1, int var2) {
      int var3 = this.b - var1 - 1;
      if (var3 < 0) {
         var3 += this.c;
      }

      for(; var2 != 0; --var2) {
         if (var3 >= this.c) {
            var3 = 0;
         }

         this.a[this.b++] = this.a[var3++];
         if (this.b >= this.c) {
            this.b();
         }
      }

   }

   public void a(byte var1) {
      this.a[this.b++] = var1;
      if (this.b >= this.c) {
         this.b();
      }

   }

   public byte b(int var1) {
      int var2 = this.b - var1 - 1;
      if (var2 < 0) {
         var2 += this.c;
      }

      return this.a[var2];
   }
}
