//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package a;

import com.nowcomputing.GamebandConfig;
import com.nowcomputing.Utils;
import com.nowcomputing.DownloadRunnable;
import com.nowcomputing.randomInterfaceThatDoesNothing;
import com.nowcomputing.uistuff.GamebandDialog;

import java.io.File;
import java.net.URL;
import java.util.logging.Level;

public class FTBLauncher extends AbstractMinecraftLauncher {
    private int c;

    public FTBLauncher(GamebandConfig config) {
        super(config);
    }

    public String getDisplayName() {
        return "FTB Launcher";
    }

    public String getSupportURL() {
        return "https://www.feed-the-beast.com/support";
    }

    public String[] buildJavaCommand() {
        String[] var1 = super.buildJavaCommand();
        if (Utils.arrContains(var1, "--cache-dir")) {
            this.config.setProperty("launch_cmd", "java -jar FTB_Launcher.jar --dynamic-dir FTB --pack-dir FTB --skip-first");

            var1 = "launch_cmd".split(" ");
        }

        int var2 = var1.length;
        String[] var3 = new String[var2 + 2];

        for(int var4 = 0; var4 < var2; ++var4) {
            var3[var4] = var1[var4];
        }

        var3[var2] = "--cache-dir";
        var3[var2 + 1] = System.getProperty("user.dir") + File.separatorChar + "minecraft" + File.separatorChar + "FTB";
        return var3;
    }

    public boolean setLaunchCMD() {
        this.config.setProperty("launch_cmd", "java -jar FTB_Launcher.jar --dynamic-dir FTB --pack-dir FTB --skip-first");
        return true;
    }

    public boolean isJavaLaunchCommandValid() {
        String[] var1 = this.buildJavaCommand();
        return var1 != null && var1[2].equals("FTB_Launcher.jar");
    }

    public void f() {
        File var1 = new File(this.h());
        if (!var1.exists()) {
            var1.mkdirs();
        }

        File var2 = new File(var1, "FTB_Launcher.jar");
        if (!var2.exists()) {
            GamebandDialog var3 = new GamebandDialog("Getting the latest Launcher", "This won't take long...", "", false);
            var3.setVisible(true);

            try {
                this.c = 0;
                DownloadRunnable var4 = new DownloadRunnable(new URL("http://ftb.cursecdn.com/FTB2/launcher/FTB_Launcher.jar"), var2, (randomInterfaceThatDoesNothing)null);
                var4.a(new b(this, var4, var3));
                var4.run();
                var3.c();
            } catch (Exception var5) {
                logger.log(Level.WARNING, "Error getting launcher", var5);
            }
        }

    }

    public boolean g() {
        return (new File(this.h(), "FTB_Launcher.jar")).exists();
    }

    // $FF: synthetic method
    static int a(a.FTBLauncher var0, long var1) {
        return var0.c = (int)((long)var0.c + var1);
    }

    // $FF: synthetic method
    static int a(a.FTBLauncher var0) {
        return var0.c;
    }
}
