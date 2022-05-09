package com.nowcomputing.pixelfurnace;

import com.codeminders.hidapi.HIDDevice;

import java.io.IOException;
import java.util.concurrent.Callable;

class e implements Callable<HIDDevice> {
   // $FF: synthetic field
   final GamebandHID a;

   e(GamebandHID var1) {
      this.a = var1;
   }

   public HIDDevice call() throws IOException {
      return GamebandHID.a(this.a, 10896, 33, (String)null);
   }
}
