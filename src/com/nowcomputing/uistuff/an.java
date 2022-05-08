package com.nowcomputing.uistuff;

import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

final class an implements com.nowcomputing.t {
   public void c() {
      LookAndFeelInfo[] var1 = UIManager.getInstalledLookAndFeels();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         LookAndFeelInfo var4 = var1[var3];
         if ("Nimbus".equals(var4.getName())) {
            UIDefaults var5 = UIManager.getLookAndFeelDefaults();
            var5.put("Button.font", GamebandFonts.n);
            break;
         }
      }

   }
}
