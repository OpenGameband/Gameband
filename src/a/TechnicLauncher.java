package a;

import c.a.a.c;
import c.a.a.a.b;
import com.nowcomputing.*;
import com.nowcomputing.uistuff.GamebandDialog;
import java.io.File;
import java.io.Writer;
import java.net.URL;
import java.util.logging.Level;

public class TechnicLauncher extends AbstractMinecraftLauncher {
   private int c;

   public TechnicLauncher(GamebandConfig var1) {
      super(var1);
   }

   public String getDisplayName() {
      return "TechnicLauncher";
   }

   public String getSupportURL() {
      return "https://technicpack.zendesk.com/hc/en-us";
   }

   public boolean setLaunchCMD() {
      this.config.setProperty("launch_cmd", "java -Dawt.useSystemAAFontSettings=lcd -Djava.net.preferIPv4Stack=true -jar TechnicLauncher.jar -launcheronly");
      return true;
   }

   public boolean isJavaLaunchCommandValid() {
      String[] var1 = this.buildJavaCommand();
      return var1 != null && var1.length > 4 && var1[4].equals("TechnicLauncher.jar");
   }

   public void f() {
//      try {
         String var1 = this.h();
         a(new File(var1, "technic"));
         this.a(new File(var1), "TechnicLauncher.jar");
         String[] var2 = "java -Dawt.useSystemAAFontSettings=lcd -Djava.net.preferIPv4Stack=true -jar TechnicLauncher.jar -update".split(" ");
         String var3 = j();
         logger.log(Level.FINE, "bundledJava: " + var3);
         if (var3 != null) {
            var2[0] = var3;
         }

         latchedCommandRun.a(var2, var1, false);
         File var4 = new File(var1 + File.separatorChar + "technic", "temp.jar");
         if (var4.exists()) {
            File var5 = new File(var1, "TechnicLauncher.jar");
            if (var4.lastModified() > var5.lastModified()) {
               logger.log(Level.FINE, "New TechnicLauncher, moving temp.jar");

               try {
                  Thread.sleep(1000L);
               } catch (InterruptedException var7) {
               }

               if (Utils.b(var4, var5)) {
                  logger.log(Level.FINE, "TechnicLauncher updated");
               } else {
                  logger.log(Level.WARNING, "Error updating TechnicLauncher");
               }
            }
         }
//      } catch (IOException e) {
//         logger.log(Level.WARNING, "Error updating TechnicLauncher", e);
//      }

   }

   private void a(File var1, String var2) {
      if (!var1.exists()) {
         var1.mkdirs();
      }

      File var3 = new File(var1, var2);
      if (!var3.exists()) {
         GamebandDialog var4 = new GamebandDialog("Getting the latest Launcher", "This won't take long...", "", false);
         var4.setVisible(true);

         try {
            String var5 = Utils.getAllFromInputStream(Utils.e("http://api.technicpack.net/launcher/version/stable4"));
            b var6 = new b();
            c var7 = (c)var6.a(var5);
            c var8 = (c)var7.get("url");
            String var9 = (String)var8.get("jar");
            this.c = 0;
            DownloadRunnable var10 = new DownloadRunnable(new URL(var9), var3, (randomInterfaceThatDoesNothing)null);
            var10.a(new l(this, var10, var4));
            var10.run();
            var4.c();
         } catch (Exception var11) {
            logger.log(Level.WARNING, "Error getting launcher", var11);
         }
      }

   }

   private static void a(File var0) {
      if (!var0.exists()) {
         var0.mkdirs();
      }

      File var1 = new File(var0, "settings.json");
      if (var1 != null && var1.exists()) {
         try {
            String var2 = Utils.readFileLazy(var1);
            b var3 = new b();
            c var4 = (c)var3.a(var2);
            String var5 = (String)var4.get("directory");
            if (!"portable".equals(var5)) {
               a(var1, var4);
            }
         } catch (Exception var6) {
            b(var1);
         }
      } else {
         b(var1);
      }

   }

   private static void b(File var0) {
      c var1 = new c();
      a(var0, var1);
   }

   private static void a(File var0, c var1) {
      var1.put("directory", "portable");
      c.a.a.f var2 = new c.a.a.f();
      var1.a((Writer)var2);
      Utils.a(var0, var2.toString());
   }

   public boolean g() {
      return (new File(this.h(), "TechnicLauncher.jar")).exists();
   }

   // $FF: synthetic method
   static int a(TechnicLauncher var0, long var1) {
      return var0.c = (int)((long)var0.c + var1);
   }

   // $FF: synthetic method
   static int a(TechnicLauncher var0) {
      return var0.c;
   }
}
