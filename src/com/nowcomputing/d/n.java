package com.nowcomputing.d;

import com.nowcomputing.ImageDoodad;
import com.nowcomputing.otherImageThingy;

import java.io.IOException;
import java.util.ArrayList;

public class n {
   short[] a = new short[6];
   short[] b;

   public int a() {
      return 6 + this.j();
   }

   public short[] b() {
      return this.a;
   }

   public short[] c() {
      return this.b;
   }

   public short d() {
      return this.a[0];
   }

   public void a(short var1) {
      this.a[0] = var1;
   }

   public short e() {
      return this.a[1];
   }

   public void b(short var1) {
      this.a[1] = var1;
   }

   public int f() {
      return (int)((float)this.a[2] * 0.7F);
   }

   public void a(int var1) {
      this.a[2] = (short)((int)((float)var1 / 0.7F));
   }

   public short g() {
      return this.a[3];
   }

   public void c(short var1) {
      this.a[3] = var1;
   }

   public int h() {
      return (int)(1000.0F / ((float)this.a[3] * 0.7F));
   }

   public void b(int var1) {
      this.a[3] = (short)((int)(1000.0F / ((float)var1 * 0.7F)));
   }

   public short i() {
      return this.a[4];
   }

   public void d(short var1) {
      this.a[4] = var1;
   }

   public short j() {
      return this.a[5];
   }

   public void e(short var1) {
      this.a[5] = var1;
   }

   public ImageDoodad k() {
      if (this.d() >= 16 && this.d() <= 31) {
         return a((short[])this.b, (int)0, this.j());
      } else {
         throw new IOException("Screen is not a Scroll");
      }
   }

   public void a(ImageDoodad var1) {
      if (var1.a() < 20) {
         ImageDoodad var2 = new ImageDoodad(20, 7);
         var2.a(var1);
         var1 = var2;
      }

      short[] var3 = b(var1);
      this.e((short)var3.length);
      this.b = new short[var3.length];
      System.arraycopy(var3, 0, this.b, 0, var3.length);
   }

   public otherImageThingy l() {
      if (this.d() >= 32 && this.d() <= 47) {
         int var1 = this.j() / 10;
         ArrayList var2 = new ArrayList(var1);

         for(int var3 = 0; var3 < var1; ++var3) {
            var2.add(a((short[])this.b, (int)(var3 * 10), 10));
         }

         return new otherImageThingy(var2, this.h());
      } else {
         throw new IOException("Screen is not an Animation");
      }
   }

   public void a(otherImageThingy var1) {
      int var2 = Math.min(var1.a(), 50);
      int var3 = var2 * 10;
      this.e((short)var3);
      this.b = new short[var3];

      for(int var4 = 0; var4 < var2; ++var4) {
         short[] var5 = b(var1.a(var4));
         System.arraycopy(var5, 0, this.b, var4 * 10, 10);
      }

   }

   public static n a(short[] var0, int var1) {
      n var2 = new n();
      System.arraycopy(var0, var1, var2.a, 0, var2.a.length);
      var2.b = new short[var0[var1 + 6 - 1]];
      System.arraycopy(var0, var1 + 6, var2.b, 0, var2.b.length);
      return var2;
   }

   static short[] b(ImageDoodad var0) {
      int var1 = var0.a() / 2;
      short[] var2 = new short[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = a(var0, var3 * 2);
      }

      return var2;
   }

   private static short a(ImageDoodad var0, int var1) {
      short var2 = 0;

      for(int var3 = 0; var3 < 7; ++var3) {
         if (var0.a(var1, var3)) {
            var2 = (short)(var2 | 1 << var3);
         }

         if (var0.a(var1 + 1, var3)) {
            var2 = (short)(var2 | 1 << var3 + 7);
         }
      }

      return var2;
   }

   static ImageDoodad a(short[] var0, int var1, int var2) {
      ImageDoodad var3 = new ImageDoodad(var2 * 2, 7);

      for(int var4 = 0; var4 < var2; ++var4) {
         short var5 = var0[var1 + var4];
         a(var3, var5, var4 * 2);
      }

      return var3;
   }

   private static void a(ImageDoodad var0, short var1, int var2) {
      for(int var3 = 0; var3 < 7; ++var3) {
         var0.a(var2, var3, a(var1, var3));
         var0.a(var2 + 1, var3, a(var1, var3 + 7));
      }

   }

   public static boolean a(short var0, int var1) {
      return (var0 & 1 << var1) != 0;
   }

   public String m() {
      StringBuilder var1 = new StringBuilder();
      var1.append('\n');
      var1.append("------\n");
      var1.append("Screen\n");
      var1.append("------\n");
      short var2 = this.d();
      switch(var2) {
      case 0:
         var1.append("Type: Time (12-hour)\n");
         break;
      case 1:
         var1.append("Type: Time (24-hour)\n");
         break;
      case 2:
         var1.append("Type: Date (MM/DD)\n");
         break;
      case 3:
         var1.append("Type: Date (DD/MM)\n");
         break;
      case 16:
         var1.append("Type: Scroll\n");
         break;
      case 17:
         var1.append("Type: Freespace\n");
         break;
      case 32:
         var1.append("Type: Animation\n");
         break;
      case 33:
         var1.append("Type: Animation Intro\n");
      }

      if (var2 == 16 || var2 == 2 || var2 == 3) {
         var1.append("Pause mode: " + this.e());
         var1.append('\n');
         var1.append("Pause duration: " + this.f());
         var1.append('\n');
      }

      var1.append("Frame duration: " + this.g());
      var1.append('\n');
      var1.append("Data len: " + this.j());
      var1.append('\n');
      var1.append('\n');
      return var1.toString();
   }
}
