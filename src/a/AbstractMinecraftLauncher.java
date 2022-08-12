//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package a;

import com.nowcomputing.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractMinecraftLauncher {
    protected static final Logger logger = Logger.getLogger(Utils.class.getName());
    protected GamebandConfig config;

    protected AbstractMinecraftLauncher(GamebandConfig var1) {
        this.config = var1;
    }

    public abstract String getDisplayName();

    public abstract String getSupportURL();

    public abstract boolean setLaunchCMD();

    public abstract boolean isJavaLaunchCommandValid();

    public abstract void f();

    public void i() throws IOException {
        String[] var1 = this.buildJavaCommand();

        try {
            if (var1[0].equals("java")) {
                String var2 = j();
                if (var2 != null) {
                    var1[0] = var2;
                }
            }

            latchedCommandRun.a(var1, this.h(), this.k());
        } catch (Exception var3) {
            throw new IOException("Error launching '" + Utils.arrayWithPrefix(var1, " ") + "' : " + var3);
        }
    }

    public static String j() {
        switch(OSDetectionIsHard.getOS()) {
            case windows:
                String var0 = System.getProperty("os.arch");
                File var1 = new File(PathUtils.getMinecraftPath(), "runtime");
                File var2 = new File(var1, var0.contains("x86") ? "jre-x32" : "jre-x64");
                return getJavaPath(var2.getAbsoluteFile());
            case osx:
                if (MinecraftLauncher.isOSVersionCompatible()) {
                    return getJavaPath(new File(PathUtils.getMinecraftPath(), "Minecraft.app/Contents/runtime/jre-x64"));
                }
            default: // rip linux users
                return null;
        }
    }

    private static String getJavaPath(File path) {
        if (path.isDirectory()) {
            File[] fileList = path.listFiles();

            for (File javaPath : fileList) {
                if (javaPath.isDirectory()) {
                    File javaBinPath = new File(javaPath, "bin/java");
                    if (doesJavaWork(javaBinPath.getAbsolutePath())) {
                        return javaBinPath.getAbsolutePath();
                    }
                }
            }
        }

        return null;
    }

    private static boolean doesJavaWork(String javaPath) {
        BufferedReader buf = null;

        try {
            ArrayList list = new ArrayList();
            list.add(javaPath);
            list.add("-version");
            ProcessBuilder javaVersionProcessBuild = new ProcessBuilder(list);
            Process javaVersionProcess = javaVersionProcessBuild.start();
            buf = new BufferedReader(new InputStreamReader(javaVersionProcess.getInputStream()));

            while(buf.readLine() != null) {
            }

            boolean guessWhatChickenButt = true; // THIS IS ALWAYS TRUE, WHY??????
            return guessWhatChickenButt;
        } catch (Exception e) {
            logger.log(Level.FINE, "Error running java: ", e);
        } finally {
            Utils.closeButUnsafe(buf);
        }

        return false;
    }

    public String[] buildJavaCommand() {
        String var1 = this.config.getProperty("launch_cmd", "java -jar launcher.jar --workDir .");
        return var1.split(" ");
    }

    public String h() {
        String var1 = PathUtils.getMinecraftPath().getAbsolutePath();
        var1 = GamebandConfig.fixPath(var1);
        return var1;
    }

    public boolean k() {
        return Boolean.parseBoolean(this.config.getProperty("minecraft_output", "false"));
    }

    public String toString() {
        return this.getDisplayName();
    }

    public abstract boolean g();
}
