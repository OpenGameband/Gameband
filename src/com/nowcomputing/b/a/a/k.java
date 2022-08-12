package com.nowcomputing.b.a.a;

import com.nowcomputing.LocaleUtil;
import com.nowcomputing.uistuff.GamebandPopup;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

public class k extends DialogButton {
   private final JFileChooser b = new JFileChooser(".");

   public k(com.nowcomputing.b.a.CustomDialog var1, String var2, ImageIcon var3, String var4, Integer var5, KeyStroke var6) {
      super(var1, var2, var3, var4, var5, var6);
      this.b.setFileFilter(new FileNameExtensionFilter("GIF Images", new String[]{"gif"}));
   }

   public void actionPerformed(ActionEvent var1) {
      int var2 = this.b.showOpenDialog(this.a);
      if (var2 == 0) {
         File var3 = this.b.getSelectedFile();

         try {
            this.a.a(var3);
            byte var4 = 0;
            int var6 = var4 + 1;
         } catch (Exception var5) {
            GamebandPopup.a((Component)this.a, (String) LocaleUtil.getLocalizedString("IMPORT_FILE_ERROR_TEXT"), (String) LocaleUtil.getLocalizedString("IMPORT_FILE_ERROR_TITLE"));
            var5.printStackTrace();
         }
      }

   }
}
