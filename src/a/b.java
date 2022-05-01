//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package a;

import com.nowcomputing.h;
import com.nowcomputing.i;
import com.nowcomputing.f.R;

class b implements i {
    b(FTBLauncher var1, h var2, R var3) {
        this.c = var1;
        this.a = var2;
        this.b = var3;
    }

    public void a(long var1) {
        FTBLauncher.logger.a(this.c, var1);
        int var3 = (int)((float) FTBLauncher.logger.a(this.c) / (float)this.a.a() * 100.0F);
        if (var3 == 100) {
            this.b.b();
        } else {
            this.b.a(var3);
        }

    }
}
