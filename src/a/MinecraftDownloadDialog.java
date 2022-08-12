package a;

import com.nowcomputing.R;
import com.nowcomputing.MinecraftDownloader;

class MinecraftDownloadDialog implements R {
   // $FF: synthetic field
   final com.nowcomputing.uistuff.GamebandDialog a;
   // $FF: synthetic field
   final MinecraftDownloader b;
   // $FF: synthetic field
   final MinecraftLauncher c;

   MinecraftDownloadDialog(MinecraftLauncher var1, com.nowcomputing.uistuff.GamebandDialog var2, MinecraftDownloader var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public void fail(int var1) {
      this.a.a("Oops, we couldn't download the latest Minecraft Launcher!");
      this.a.b(this.b.e().getMessage());
      this.a.alertDialog();
   }

   public void setProgress(int var1) {
      if (var1 == 100) {
         this.a.setProgressBarIndeterminate(true);
      } else {
         this.a.setProgressBarValue(var1);
      }

   }

   public void exit() {
      this.a.close();
   }
}
