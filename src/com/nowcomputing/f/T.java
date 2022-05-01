package com.nowcomputing.f;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class T extends WindowAdapter {
   // $FF: synthetic field
   final R a;

   T(R var1) {
      this.a = var1;
   }

   public void windowClosing(WindowEvent var1) {
      this.a.a();
   }
}
