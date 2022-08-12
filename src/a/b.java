//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package a;

import com.nowcomputing.uistuff.GamebandDialog;
import com.nowcomputing.DownloadRunnable;
import com.nowcomputing.randomInterfaceThatDoesNothing;

class b implements randomInterfaceThatDoesNothing {
    final DownloadRunnable a;
    final GamebandDialog b;
    final FTBLauncher c;

    b(FTBLauncher var1, DownloadRunnable var2, GamebandDialog var3) {
        this.c = var1;
        this.a = var2;
        this.b = var3;
    }

    public void a(long var1) {
        FTBLauncher.a(this.c, var1);
        int var3 = (int)((float) FTBLauncher.a(this.c) / (float)this.a.a() * 100.0F);
        if (var3 == 100) {
            this.b.close();
        } else {
            this.b.setProgressBarValue(var3);
        }

    }
}
