package com.nowcomputing.uistuff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class Q implements ActionListener {
   // $FF: synthetic field
   final N a;
   // $FF: synthetic field
   final int b;

   Q(N var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      this.a.a(this.b);
      this.a.dispose();
   }
}
