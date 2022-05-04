package com.nowcomputing.a;

import com.nowcomputing.ImageDoodad;
import com.nowcomputing.otherImageThingy;

import java.util.ArrayList;

public class e extends a {
   private ImageDoodad d;
   private int e;
   private int f;
   private int g;
   private d h;
   private boolean i;

   public e(d var1, boolean var2) {
      this.h = com.nowcomputing.a.d.a;
      this.h = var1;
      this.i = var2;
   }

   protected void a() {
      super.a();
      int n = this.d.a();
      int n2 = this.d.b();
      this.e = this.h == com.nowcomputing.a.d.a || this.h == com.nowcomputing.a.d.b ? (this.i ? 20 + n + 1 : (n < 20 ? 21 : n + 1)) : (this.i ? 7 + n2 + 1 : (n2 < 7 ? 8 : n2 + 1));
      switch (com.nowcomputing.a.f.a[this.h.ordinal()]) {
         case 1: {
            this.f = 20;
            break;
         }
         case 2: {
            this.f = -n;
            break;
         }
         case 3: {
            this.g = 7;
            break;
         }
         case 4: {
            this.g = -n2;
         }
      }
   }

   public boolean d() {
      if (this.d != null) {
         return !this.g();
      } else {
         return false;
      }
   }

   public ImageDoodad e() {
      ImageDoodad d2 = null;
      --this.e;
      switch (com.nowcomputing.a.f.a[this.h().ordinal()]) {
         case 1: {
            d2 = this.a(this.d, this.f--, 0);
            break;
         }
         case 2: {
            d2 = this.a(this.d, this.f++, 0);
            break;
         }
         case 3: {
            d2 = this.a(this.d, 0, this.g--);
            break;
         }
         case 4: {
            d2 = this.a(this.d, 0, this.g++);
         }
      }
      if (this.e == 0) {
         this.a(true);
      }
      return d2;
   }

   public void a(ImageDoodad var1) {
      this.d = var1;
   }

   public void a(String var1) {
      this.d = ImageDoodad.a(var1);
   }

   public d h() {
      return this.h;
   }

   private ImageDoodad a(ImageDoodad var1, int var2, int var3) {
      ImageDoodad var4 = new ImageDoodad(20, 7);
      var4.a(var1, var2, var3);
      return var4;
   }

   public otherImageThingy i() {
      this.a();
      this.a(false);
      ArrayList var1 = new ArrayList();

      while(this.d()) {
         var1.add(this.e());
      }

      return new otherImageThingy(var1, this.a);
   }
}
