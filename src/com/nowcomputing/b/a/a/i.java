package com.nowcomputing.b.a.a;

import com.nowcomputing.LockingUtil;
import com.nowcomputing.f.N;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

public class i extends b {
   private final JFileChooser b = new JFileChooser(".");
   private j c;

   public i(LockingUtil.a.a var1, String var2, ImageIcon var3, String var4, Integer var5, KeyStroke var6) {
      super(var1, var2, var3, var4, var5, var6);
      this.b.setFileFilter(new FileNameExtensionFilter("GIF Images", new String[]{"gif"}));
   }

   public void actionPerformed(ActionEvent var1) {
      this.a(j.b);
      int var2 = this.b.showSaveDialog(this.a);
      if (var2 == 0) {
         File var3 = this.b.getSelectedFile();
         if (var3 != null) {
            if (!var3.getPath().toLowerCase().endsWith(".gif")) {
               String var4 = var3.getPath() + ".gif";
               var3 = new File(var4);
            }

            if (var3.exists()) {
               int var6 = N.a((Component)this.a, (String)com.nowcomputing.f.a("OVERWRITE_FILE_TEXT"), (String)com.nowcomputing.f.a("OVERWRITE_FILE_TITLE"), (String[])(new String[]{com.nowcomputing.f.a("YES"), com.nowcomputing.f.a("NO")}));
               if (var6 == 1) {
                  return;
               }
            }

            try {
               this.a.a().b(var3);
               N.a((Component)this.a, (String)com.nowcomputing.f.a("EXPORT_FILE_SUCCESS_TEXT"), (String)com.nowcomputing.f.a("EXPORT_FILE_SUCCESS_TITLE"));
               this.a(j.a);
            } catch (IOException var5) {
               N.a((Component)this.a, (String)com.nowcomputing.f.a("EXPORT_FILE_ERROR_TEXT"), (String)com.nowcomputing.f.a("EXPORT_FILE_ERROR_TITLE"));
               var5.printStackTrace();
            }
         }
      }

   }

   private void a(j var1) {
      this.c = var1;
   }
}
