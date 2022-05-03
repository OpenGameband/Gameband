//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package a;

import a.FTBLauncher;
import com.nowcomputing.f.R;
import com.nowcomputing.h;
import com.nowcomputing.i;

class b implements i {
    final h a;
    final R b;
    final FTBLauncher c;

    b(FTBLauncher var1, h var2, R var3) {
        this.c = var1;
        this.a = var2;
        this.b = var3;
    }

    public void a(long var1) {
        FTBLauncher.a(this.c, var1);
        int var3 = (int)((float) FTBLauncher.a(this.c) / (float)this.a.a() * 100.0F);
        if (var3 == 100) {
            this.b.b();
        } else {
            this.b.a(var3);
        }

    }
}
