package a;

import com.nowcomputing.f.R;

class l implements com.nowcomputing.i {
   // $FF: synthetic field
   final com.nowcomputing.h a;
   // $FF: synthetic field
   final R b;
   // $FF: synthetic field
   final k c;

   l(k var1, com.nowcomputing.h var2, R var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public void a(long var1) {
      k.a(this.c, var1);
      int var3 = (int)((float)k.a(this.c) / (float)this.a.a() * 100.0F);
      if (var3 == 100) {
         this.b.b();
      } else {
         this.b.a(var3);
      }

   }
}
