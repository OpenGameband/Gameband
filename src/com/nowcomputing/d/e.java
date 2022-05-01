package com.nowcomputing.d;

import com.codeminders.hidapi.HIDDevice;
import java.util.concurrent.Callable;

class e implements Callable {
   // $FF: synthetic field
   final d a;

   e(d var1) {
      this.a = var1;
   }

   public HIDDevice a() {
      return d.a(this.a, 10896, 33, (String)null);
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
