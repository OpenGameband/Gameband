//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package a;

import com.nowcomputing.D;
import com.nowcomputing.Main;
import com.nowcomputing.GamebandConfig;
import com.nowcomputing.f;
import com.nowcomputing.l;
import com.nowcomputing.f.am;
import java.io.File;
import java.util.logging.Level;
import javax.swing.JFrame;

public class c extends l {
    public c(GamebandConfig var1) {
        super(var1);
        File var2 = D.getMinecraftPath();
        if (!var2.exists()) {
            var2.mkdir();
        }

    }

    public boolean d() {
        try {
            FTBLauncher.e var1 = Main.c();
            var1.f();
            var1.i();
            return true;
        } catch (Exception var2) {
            a.log(Level.FINE, "Caught exception launching Minecraft: ", var2);
            am.a((JFrame)null, f.a("NO_LAUNCH_HEADING"), f.a("NO_LAUNCH_1"), var2.getMessage(), "", "");
            return false;
        }
    }
}
