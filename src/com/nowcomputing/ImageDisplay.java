package com.nowcomputing;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ImageDisplay { // whew, this is a whole load of bullshit i'm not prepared to unwrap right now
   protected BufferedInputStream inputStream;
   protected int b;
   protected int c;
   protected int d;
   protected boolean e;
   protected int f;
   protected int g = 1;
   protected int[] h;
   protected int[] i;
   protected int[] j;
   protected int k;
   protected int l;
   protected int m;
   protected int n;
   protected boolean o;
   protected boolean p;
   protected int q;
   protected int r;
   protected int s;
   protected int t;
   protected int u;
   protected Rectangle rectangle;
   protected BufferedImage bufferedImage;
   protected BufferedImage bufferedImage1;
   protected byte[] bytes = new byte[256];
   protected int z = 0;
   protected int A = 0;
   protected int B = 0;
   protected boolean C = false;
   protected int D = 0;
   protected int E;
   protected short[] F;
   protected byte[] G;
   protected byte[] H;
   protected byte[] I;
   protected ArrayList list;
   protected int K;

   public int a() {
      return this.K;
   }

   protected void b() {
      int[] imageData = ((DataBufferInt)this.bufferedImage.getRaster().getDataBuffer()).getData();
      int var2;
      if (this.B > 0) {
         if (this.B == 3) {
            var2 = this.K - 2;
            if (var2 > 0) {
               this.bufferedImage1 = this.a(var2 - 1);
            } else {
               this.bufferedImage1 = null;
            }
         }

         if (this.bufferedImage1 != null) {
            int[] var13 = ((DataBufferInt)this.bufferedImage1.getRaster().getDataBuffer()).getData();
            System.arraycopy(var13, 0, imageData, 0, this.c * this.d);
            if (this.B == 2) {
               Graphics2D var3 = this.bufferedImage.createGraphics();
               Color var4 = null;
               if (this.C) {
                  var4 = new Color(0, 0, 0, 0);
               } else {
                  var4 = new Color(this.m);
               }

               var3.setColor(var4);
               var3.setComposite(AlphaComposite.Src);
               var3.fill(this.rectangle);
               var3.dispose();
            }
         }
      }

      var2 = 1;
      byte var14 = 8;
      int var15 = 0;

      for(int var5 = 0; var5 < this.u; ++var5) {
         int var6 = var5;
         if (this.p) {
            if (var15 >= this.u) {
               ++var2;
               switch(var2) {
               case 2:
                  var15 = 4;
                  break;
               case 3:
                  var15 = 2;
                  var14 = 4;
                  break;
               case 4:
                  var15 = 1;
                  var14 = 2;
               }
            }

            var6 = var15;
            var15 += var14;
         }

         var6 += this.s;
         if (var6 < this.d) {
            int var7 = var6 * this.c;
            int var8 = var7 + this.r;
            int var9 = var8 + this.t;
            if (var7 + this.c < var9) {
               var9 = var7 + this.c;
            }

            for(int var10 = var5 * this.t; var8 < var9; ++var8) {
               int var11 = this.I[var10++] & 255;
               int var12 = this.j[var11];
               if (var12 != 0) {
                  imageData[var8] = var12;
               }
            }
         }
      }

   }

   public ArrayList getList() {
      return this.list;
   }

   public BufferedImage a(int var1) {
      BufferedImage var2 = null;
      if (var1 >= 0 && var1 < this.K) {
         var2 = ((ImageWithANumber)this.list.get(var1)).image;
      }

      return var2;
   }

   public int a(BufferedInputStream var1) {
      this.f();
      if (var1 != null) {
         this.inputStream = var1;
         this.k();
         if (!this.e()) {
            this.i();
            if (this.K < 0) {
               this.b = 1;
            }
         }
      } else {
         this.b = 2;
      }

      try {
         if (var1 != null) {
            var1.close();
         }
      } catch (IOException var3) {
      }

      return this.b;
   }

   public int a(String var1) {
      this.b = 0;

      try {
         this.inputStream = new BufferedInputStream(new FileInputStream(var1));
         this.b = this.a(this.inputStream);
      } catch (IOException var3) {
         this.b = 2;
      }

      return this.b;
   }

   protected void d() {
      byte var1 = -1;
      int var2 = this.t * this.u;
      if (this.I == null || this.I.length < var2) {
         this.I = new byte[var2];
      }

      if (this.F == null) {
         this.F = new short[4096];
      }

      if (this.G == null) {
         this.G = new byte[4096];
      }

      if (this.H == null) {
         this.H = new byte[4097];
      }

      int var15 = this.g();
      int var4 = 1 << var15;
      int var7 = var4 + 1;
      int var3 = var4 + 2;
      int var9 = var1;
      int var6 = var15 + 1;
      int var5 = (1 << var6) - 1;

      int var11;
      for(var11 = 0; var11 < var4; ++var11) {
         this.F[var11] = 0;
         this.G[var11] = (byte)var11;
      }

      int var18 = 0;
      int var19 = 0;
      int var17 = 0;
      int var16 = 0;
      int var12 = 0;
      int var10 = 0;
      int var14 = 0;
      int var13 = 0;

      while(var13 < var2) {
         if (var17 == 0) {
            if (var10 < var6) {
               if (var12 == 0) {
                  var12 = this.h();
                  if (var12 <= 0) {
                     break;
                  }

                  var18 = 0;
               }

               var14 += (this.bytes[var18] & 255) << var10;
               var10 += 8;
               ++var18;
               --var12;
               continue;
            }

            var11 = var14 & var5;
            var14 >>= var6;
            var10 -= var6;
            if (var11 > var3 || var11 == var7) {
               break;
            }

            if (var11 == var4) {
               var6 = var15 + 1;
               var5 = (1 << var6) - 1;
               var3 = var4 + 2;
               var9 = var1;
               continue;
            }

            if (var9 == var1) {
               this.H[var17++] = this.G[var11];
               var9 = var11;
               var16 = var11;
               continue;
            }

            int var8 = var11;
            if (var11 == var3) {
               this.H[var17++] = (byte)var16;
               var11 = var9;
            }

            while(var11 > var4) {
               this.H[var17++] = this.G[var11];
               var11 = this.F[var11];
            }

            var16 = this.G[var11] & 255;
            if (var3 >= 4096) {
               break;
            }

            this.H[var17++] = (byte)var16;
            this.F[var3] = (short)var9;
            this.G[var3] = (byte)var16;
            ++var3;
            if ((var3 & var5) == 0 && var3 < 4096) {
               ++var6;
               var5 += var3;
            }

            var9 = var8;
         }

         --var17;
         this.I[var19++] = this.H[var17];
         ++var13;
      }

      for(var13 = var19; var13 < var2; ++var13) {
         this.I[var13] = 0;
      }

   }

   protected boolean e() {
      return this.b != 0;
   }

   protected void f() {
      this.b = 0;
      this.K = 0;
      this.list = new ArrayList();
      this.h = null;
      this.i = null;
   }

   protected int g() {
      int var1 = 0;

      try {
         var1 = this.inputStream.read();
      } catch (IOException var3) {
         this.b = 1;
      }

      return var1;
   }

   protected int h() {
      this.z = this.g();
      int var1 = 0;
      if (this.z > 0) {
         int var4;
         try {
            for(boolean var2 = false; var1 < this.z; var1 += var4) {
               var4 = this.inputStream.read(this.bytes, var1, this.z - var1);
               if (var4 == -1) {
                  break;
               }
            }
         } catch (IOException var3) {
         }

         if (var1 < this.z) {
            this.b = 1;
         }
      }

      return var1;
   }

   protected int[] b(int var1) {
      int var2 = 3 * var1;
      int[] var3 = null;
      byte[] var4 = new byte[var2];
      int var5 = 0;

      try {
         var5 = this.inputStream.read(var4);
      } catch (IOException var11) {
      }

      if (var5 < var2) {
         this.b = 1;
      } else {
         var3 = new int[256];
         int var6 = 0;

         int var8;
         int var9;
         int var10;
         for(int var7 = 0; var6 < var1; var3[var6++] = -16777216 | var8 << 16 | var9 << 8 | var10) {
            var8 = var4[var7++] & 255;
            var9 = var4[var7++] & 255;
            var10 = var4[var7++] & 255;
         }
      }

      return var3;
   }

   protected void i() {
      boolean var1 = false;

      while(!var1 && !this.e()) {
         int var2 = this.g();
         switch(var2) {
         case 0:
            break;
         case 33:
            var2 = this.g();
            switch(var2) {
            case 249:
               this.j();
               continue;
            case 255:
               this.h();
               String var3 = "";

               for(int var4 = 0; var4 < 11; ++var4) {
                  var3 = var3 + (char)this.bytes[var4];
               }

               if (var3.equals("NETSCAPE2.0")) {
                  this.n();
               } else {
                  this.q();
               }
               continue;
            default:
               this.q();
               continue;
            }
         case 44:
            this.l();
            break;
         case 59:
            var1 = true;
            break;
         default:
            this.b = 1;
         }
      }

   }

   protected void j() {
      this.g();
      int var1 = this.g();
      this.A = (var1 & 28) >> 2;
      if (this.A == 0) {
         this.A = 1;
      }

      this.C = (var1 & 1) != 0;
      this.D = this.o() * 10;
      if (this.D == 0) {
         this.D = 100;
      }

      this.E = this.g();
      this.g();
   }

   protected void k() {
      String var1 = "";

      for(int var2 = 0; var2 < 6; ++var2) {
         var1 = var1 + (char)this.g();
      }

      if (!var1.startsWith("GIF")) {
         this.b = 1;
      } else {
         this.m();
         if (this.e && !this.e()) {
            this.h = this.b(this.f);
            this.l = this.h[this.k];
         }

      }
   }

   protected void l() {
      this.r = this.o();
      this.s = this.o();
      this.t = this.o();
      this.u = this.o();
      int var1 = this.g();
      this.o = (var1 & 128) != 0;
      this.p = (var1 & 64) != 0;
      this.q = 2 << (var1 & 7);
      if (this.o) {
         this.i = this.b(this.q);
         this.j = this.i;
      } else {
         this.j = this.h;
         if (this.k == this.E) {
            this.l = 0;
         }
      }

      int var2 = 0;
      if (this.C) {
         var2 = this.j[this.E];
         this.j[this.E] = 0;
      }

      if (this.j == null) {
         this.b = 1;
      }

      if (!this.e()) {
         this.d();
         this.q();
         if (!this.e()) {
            ++this.K;
            this.bufferedImage = new BufferedImage(this.c, this.d, 3);
            this.b();
            this.list.add(new ImageWithANumber(this.bufferedImage, this.D));
            if (this.C) {
               this.j[this.E] = var2;
            }

            this.p();
         }
      }
   }

   protected void m() {
      this.c = this.o();
      this.d = this.o();
      int var1 = this.g();
      this.e = (var1 & 128) != 0;
      this.f = 2 << (var1 & 7);
      this.k = this.g();
      this.n = this.g();
   }

   protected void n() {
      do {
         this.h();
         if (this.bytes[0] == 1) {
            int var1 = this.bytes[1] & 255;
            int var2 = this.bytes[2] & 255;
            this.g = var2 << 8 | var1;
         }
      } while(this.z > 0 && !this.e());

   }

   protected int o() {
      return this.g() | this.g() << 8;
   }

   protected void p() {
      this.B = this.A;
      this.rectangle = new Rectangle(this.r, this.s, this.t, this.u);
      this.bufferedImage1 = this.bufferedImage;
      this.m = this.l;
      this.A = 0;
      this.C = false;
      this.D = 0;
      this.i = null;
   }

   protected void q() {
      do {
         this.h();
      } while(this.z > 0 && !this.e());

   }
}
