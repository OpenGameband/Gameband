//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package a;

import com.nowcomputing.GamebandConfig;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

public class d extends AbstractMinecraftLauncher {
    public d(GamebandConfig var1) {
        super(var1);
    }

    public String h() {
        String var1 = super.h();
        return var1 + File.separatorChar + "minecraftedu";
    }

    public String getDisplayName() {
        return "MinecraftEdu";
    }

    public String getSupportURL() {
        return "";
    }

    public String[] buildJavaCommand() {
        String var1 = a(new File(this.h()));
        ArrayList var2 = new ArrayList();
        var2.add("java");
        var2.add("-Xmx" + var1 + "M");
        var2.add("-Xms" + var1 + "M");
        var2.add("-jar");
        var2.add("Launcher.jar");
        return (String[])var2.toArray(new String[var2.size()]);
    }

    public boolean setLaunchCMD() {
        this.config.setProperty("launch_cmd", "java -jar Launcher.jar");
        return true;
    }

    public boolean isJavaLaunchCommandValid() {
        String[] var1 = this.buildJavaCommand();
        return var1 != null && var1[var1.length - 1].equals("Launcher.jar");
    }

    public void f() {
    }

    public boolean g() {
        return (new File(this.h(), "Launcher.jar")).exists();
    }

    private static String a(File var0) {
        String var1 = a(var0.getAbsolutePath() + File.separatorChar + "launcher_res/settings/launchersettings.ini", "client-ram");
        if (var1 == null || var1.trim().equals("")) {
            var1 = "700";
        }

        return var1;
    }

    public static String a(String var0, String var1) {
        Properties var2 = new Properties();
        var1 = var1.toLowerCase();

        try {
            FileInputStream var3 = new FileInputStream(var0);
            var2.load(var3);
            var3.close();
            return var2.getProperty(var1);
        } catch (Exception var4) {
            System.out.println("Error reading ini file: " + var4);
            return "";
        }
    }
}
