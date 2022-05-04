package a;

import com.nowcomputing.DownloadRunnable;
import com.nowcomputing.randomInterfaceThatDoesNothing;
import com.nowcomputing.uistuff.GamebandDialog;

class n implements randomInterfaceThatDoesNothing {
   // $FF: synthetic field
   final DownloadRunnable a;
   // $FF: synthetic field
   final GamebandDialog b;
   // $FF: synthetic field
   final VoidLauncher c;

   n(VoidLauncher var1, DownloadRunnable var2, GamebandDialog var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public void a(long var1) {
      VoidLauncher.a(this.c, var1);
      int var3 = (int)((float) VoidLauncher.a(this.c) / (float)this.a.a() * 100.0F);
      if (var3 == 100) {
         this.b.b();
      } else {
         this.b.setProgressBarValue(var3);
      }

   }
}
