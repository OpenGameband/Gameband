package com.nowcomputing.a;

import com.nowcomputing.ImageDoodad;
import com.nowcomputing.otherImageThingy;

import java.io.File;

public class c extends a {
   private otherImageThingy d;
   private int e;

   protected void a() {
      super.a();
      this.e = 0;
   }

   public void b() {
      if (this.d != null && this.d.a() > 0) {
         super.b();
      }

   }

   public boolean d() {
      return this.e < this.d.a();
   }

   public ImageDoodad e() {
      ImageDoodad var1 = null;
      if (this.e == this.d.a()) {
         this.a(true);
      } else {
         var1 = this.d.a(this.e++);
      }

      return var1;
   }

   public void a(File var1) {
      this.a(otherImageThingy.a(var1));
   }

   public void a(otherImageThingy var1) {
      this.d = var1;
      if (this.d.a() > 0) {
         this.a(this.d.b());
      }

      this.e = 0;
   }

   public otherImageThingy h() {
      return this.d;
   }
}
