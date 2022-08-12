//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package a;

import com.nowcomputing.PathUtils;
import com.nowcomputing.Main;
import com.nowcomputing.GamebandConfig;
import com.nowcomputing.LocaleUtil;
import com.nowcomputing.latchedCommandRun;
import com.nowcomputing.uistuff.am;
import java.io.File;
import java.util.logging.Level;
import javax.swing.JFrame;

public class c extends latchedCommandRun {
    public c(GamebandConfig var1) {
        super(var1);
        File var2 = PathUtils.getMinecraftPath();
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
            logger.log(Level.FINE, "Caught exception launching Minecraft: ", var2);
            am.a((JFrame)null, LocaleUtil.getLocalizedString("NO_LAUNCH_HEADING"), LocaleUtil.getLocalizedString("NO_LAUNCH_1"), var2.getMessage(), "", "");
            return false;
        }
    }
}
