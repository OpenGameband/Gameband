package a;

import com.nowcomputing.GamebandConfig;
import com.nowcomputing.Utils;
import com.nowcomputing.X;
import com.nowcomputing.f.R;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Level;

public class VoidLauncher extends AbstractMinecraftLauncher {
   private int c;

   public VoidLauncher(GamebandConfig var1) {
      super(var1);
   }

   public String getDisplayName() {
      return "VoidLauncher";
   }

   public String getSupportURL() {
      return "http://voidlauncherforums.voidswrath.com";
   }

   public boolean setLaunchCMD() {
      this.config.setProperty("launch_cmd", "java -jar VoidLauncher.jar --gameband_dir=void");
      return true;
   }

   public boolean isJavaLaunchCommandValid() {
      String[] var1 = this.buildJavaCommand();
      return var1 != null && var1[2].equals("VoidLauncher.jar");
   }

   public void f() {
      File var1 = new File(this.h());
      if (!var1.exists()) {
         var1.mkdirs();
      }

      File var2 = new File(var1, "VoidLauncher.jar");
      if (!var2.exists()) {
         this.a(var2);
      } else {
         X var3 = this.m();
         X var4 = this.l();
         if (var3.a(var4) < 0) {
            this.a(var2);
         }
      }

   }

   private X l() {
      try {
         InputStream var1 = Utils.e("http://voidswrath.com/release/releases/version.txt");
         BufferedReader var2 = new BufferedReader(new InputStreamReader(var1));
         String var3 = var2.readLine();
         return new X(var3);
      } catch (IOException var4) {
         var4.printStackTrace();
         return new X(0, 0, 0, 0);
      }
   }

   private X m() {
      try {
         File var1 = new File(this.h(), "void/VoidLauncher/jarversion");
         if (var1.exists()) {
            String var2 = Utils.readFileLazy(var1);
            return new X(var2);
         }
      } catch (Exception var3) {
         logger.log(Level.WARNING, "Error getting launcher version void/VoidLauncher/jarversion", var3);
      }

      return new X(0, 0, 0, 0);
   }

   public void a(File var1) {
      R var2 = new R("Getting the latest Launcher", "This won't take long...", "", false);
      var2.setVisible(true);

      try {
         this.c = 0;
         com.nowcomputing.h var3 = new com.nowcomputing.h(new URL("http://vl4.voidswrath.com/release/releases/linux/VoidLauncher.jar"), var1, (com.nowcomputing.i)null);
         var3.a(new n(this, var3, var2));
         var3.run();
         var2.c();
      } catch (Exception var4) {
         logger.log(Level.WARNING, "Error getting launcher", var4);
      }

   }

   public boolean g() {
      return (new File(this.h(), "VoidLauncher.jar")).exists();
   }

   // $FF: synthetic method
   static int a(VoidLauncher var0, long var1) {
      return var0.c = (int)((long)var0.c + var1);
   }

   // $FF: synthetic method
   static int a(VoidLauncher var0) {
      return var0.c;
   }
}
