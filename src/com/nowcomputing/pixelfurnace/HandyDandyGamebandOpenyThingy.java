package com.nowcomputing.pixelfurnace;

import com.codeminders.hidapi.HIDDevice;

import java.io.IOException;
import java.util.concurrent.Callable;

class HandyDandyGamebandOpenyThingy implements Callable<HIDDevice> {
   final GamebandHID gbHID;

   HandyDandyGamebandOpenyThingy(GamebandHID gbHID) {
      this.gbHID = gbHID;
   }

   public HIDDevice call() throws IOException {
      return GamebandHID.OpenRandomHid(this.gbHID, 10896, 33, (String)null); // open gameband device
   }
}
