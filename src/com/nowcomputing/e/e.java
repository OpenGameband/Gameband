package com.nowcomputing.e;

import com.nowcomputing.GamebandConfig;
import com.nowcomputing.ImageDoodad;

public class e extends a {
   private boolean g;
   private b h;

   public e(b var1) {
      this.h = var1;
   }

   public void b() {
      if (this.h == GamebandConfig.b.b) {
         this.g = false;
         ImageDoodad.f.l().execute(new f(this));
      }

      super.b();
   }

   public ImageDoodad e() {
      if (this.h == GamebandConfig.b.b) {
         if (this.g) {
            this.a(true);
         }
      } else {
         this.a(true);
      }

      return this.f;
   }

   public boolean d() {
      if (this.f != null) {
         return !this.g();
      } else {
         return false;
      }
   }

   // $FF: synthetic method
   static boolean a(e var0, boolean var1) {
      return var0.g = var1;
   }
}
