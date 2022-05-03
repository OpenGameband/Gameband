package com.nowcomputing.a;

import com.nowcomputing.ImageDoodad;

import java.io.File;

public class c extends a {
   private com.nowcomputing.a d;
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
      this.a(com.nowcomputing.a.a(var1));
   }

   public void a(com.nowcomputing.a var1) {
      this.d = var1;
      if (this.d.a() > 0) {
         this.a(this.d.b());
      }

      this.e = 0;
   }

   public com.nowcomputing.a h() {
      return this.d;
   }
}
