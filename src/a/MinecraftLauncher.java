package a;

import c.a.a.c;
import com.nowcomputing.*;
import com.nowcomputing.uistuff.GamebandDialog;
import com.nowcomputing.uistuff.N;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.logging.Level;

public class MinecraftLauncher extends AbstractMinecraftLauncher {
   public MinecraftLauncher(GamebandConfig var1) {
      super(var1);
   }

   public String[] buildJavaCommand() {
      String[] stringArray = super.buildJavaCommand();
      if (this.validateJavaLaunchCommand(stringArray)) {
         switch (i.a[Utils.b().ordinal()]) {
            case 1: {
               File file = new File(D.getMinecraftPath(), ".mc.exe");
               if (!file.exists()) {
                  logger.log(Level.FINE, "File .mc.exe not found");
                  File file2 = new File(D.getMinecraftPath(), "minecraft.exe");
                  if (file2.exists()) {
                     try {
                        Utils.a(file2, file);
                     } catch (IOException e) {
                        e.printStackTrace();
                     }
                     logger.log(Level.FINE, "Copied existing minecraft exe to .mc.exe");
                     file = new File(D.getMinecraftPath(), ".mc.exe");
                     if (!file.exists()) {
                        file = file2;
                     }
                  } else {
                     logger.log(Level.FINE, "File minecraft.exe not found");
                  }
               }
               stringArray = new String[]{file.getPath(), "--tmpDir", System.getProperty("java.io.tmpdir"), "--workDir", ".", "--lockDir", file.getParent()};
               break;
            }
            case 2: {
               if (!MinecraftLauncher.isOSVersionCompatible()) break;
               File file = D.getMinecraftPath();
               File file3 = new File(new File(file, "runtime"), "Minecraft.app");
               String string = file3.getAbsolutePath() + "/Contents/MacOS/launcher";
               stringArray = new String[]{string, "--tmpDir", System.getProperty("java.io.tmpdir"), "--workDir", file.getAbsolutePath()};
               break;
            }
         }
      }
      return stringArray;
   }

   public static boolean isOSVersionCompatible() {
      boolean var0 = false;

      try {
         WindowsVersionComparator var1 = new WindowsVersionComparator(10, 8, 0);
         WindowsVersionComparator var2 = new WindowsVersionComparator(System.getProperty("os.version"));
         var0 = var1.compareTo(var2) <= 0;
      } catch (IllegalArgumentException var3) {
      }
      return var0;
   }

   public String getDisplayName() {
      return "Minecraft";
   }

   public String getSupportURL() {
      return "https://help.mojang.com";
   }

   public boolean setLaunchCMD() {
      this.config.setProperty("launch_cmd", "");
      return true;
   }

   public boolean isJavaLaunchCommandValid() {
      return this.validateJavaLaunchCommand(this.buildJavaCommand());
   }

   private boolean validateJavaLaunchCommand(String[] var1) {
      if (var1 != null && var1.length >= 5) {
         return var1[0].equals("java") && var1[1].equals("-jar") && var1[2].equals("launcher.jar") && var1[3].equals("--workDir") && var1[4].equals(".");
      } else {
         return false;
      }
   }

   public void f() {
      MinecraftDownloader var1 = new MinecraftDownloader(this.config);
      if (var1.a() != M.a) {
         GamebandDialog infoDialog = new GamebandDialog("Getting the latest Minecraft Launcher", "This won't take long...", "", true);
         infoDialog.setVisible(true);
         var1.a((com.nowcomputing.R)(new MinecraftDownloadDialog(this, infoDialog, var1)));
         var1.c();
         infoDialog.c();
      }

   }

   public void i() throws IOException {
      this.m();
      if (!this.n()) {
         throw new IOException("Can't download Minecraft.exe");
      } else {
         super.i();
      }
   }

   private void m() {
      try {
         String var1 = D.getMinecraftPath().getCanonicalPath();
         String var2 = D.getMinecraftPath().getPath();
         File var3 = new File(D.getMinecraftPath(), "launcher_profiles.json");
         String var4 = Utils.readFile(var3);
         c.a.a.a.b var5 = new c.a.a.a.b();
         c var6 = (c)var5.a(var4);
         boolean var7 = false;
         c var8 = (c)var6.get("profiles");
         Iterator var9 = var8.values().iterator();

         while(true) {
            c var11;
            String var13;
            String var14;
            do {
               do {
                  if (!var9.hasNext()) {
                     if (var7) {
                        c.a.a.f var18 = new c.a.a.f();
                        var6.a((Writer)var18);
                        Utils.a(var3, var18.toString());
                     }

                     return;
                  }

                  Object var10 = var9.next();
                  var11 = (c)var10;
                  String var12 = (String)var11.get("name");
               } while(!var11.containsKey("gameDir"));

               var13 = (String)var11.get("gameDir");
               var14 = var13;
               if (!var13.startsWith(var1)) {
                  int var15 = var13.indexOf(var2);
                  if (var15 != -1) {
                     String var16 = Utils.c(var13.substring(var15));
                     var14 = var1 + File.separator + var16;
                  } else {
                     var14 = "";
                  }
               }

               File var19 = new File(var14);
               if (var19.exists()) {
                  var14 = var19.getCanonicalPath();
               } else {
                  var14 = "";
               }
            } while(var13.equals(var14));

            if (var14 != null && !var14.equals("")) {
               var11.put("gameDir", var14);
            } else {
               var11.remove("gameDir");
            }

            var7 = true;
         }
      } catch (Throwable var17) {
      }
   }

   private boolean n() {
      if (Utils.b() == B.b) {
         String[] var1 = this.buildJavaCommand();
         File var2 = new File(var1[0]);
         if (!var2.exists()) {
            N.a((Component)null, (String[])(new String[]{"We're having problems downloading Minecraft :(", "This is usually due to being blocked by antivirus or firewall software. Please add Gameband to your antivirus software's whitelist.", "Alternatively, you can manually download the minecraft.exe file and copy it into the minecraft folder on Gameband:"}), (String)"Gameband Error", (String)"https://launcher.mojang.com/download/Minecraft.exe");
            File var3 = new File(D.getMinecraftPath(), "minecraft.exe");
            return var3.exists();
         }
      }

      return true;
   }

   public boolean g() {
      return true;
   }
}
