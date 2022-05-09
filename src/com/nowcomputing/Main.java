package com.nowcomputing;

import com.codeminders.hidapi.ClassPathLibraryLoader;
import com.nowcomputing.uistuff.ak;
import com.nowcomputing.uistuff.am;
import com.nowcomputing.uistuff.s;
import java.awt.Cursor;
import java.io.File;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import a.*;

public class Main {
   private static final Logger logger;
   private static com.nowcomputing.pixelfurnace.f b;
   private static Vector<AbstractMinecraftLauncher> vec;
   private static s d;
   private static LockingUtil e;

   public static void main(String[] args) {
      System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
      Runtime.getRuntime().addShutdownHook(new u());

      try {
         GamebandConfig config = new GamebandConfig(GamebandConfig.defaultConfigFile);
         am.a();
         e = new LockingUtil("Gameband");

         try {
            if (!e.lock()) {
               logger.log(Level.INFO, "Another instance of this application is already running. Exiting.");
               System.out.println("Another instance of this application is already running. Exiting.");
               System.exit(0);
               return;
            }
         } catch (Throwable var6) {
            var6.printStackTrace();
         }

         ak var2 = new ak(config, 1000);
         logger.log(Level.FINE, Utils.e());
         removeOldPixelFurnaceBinariesBecauseYay();
         Utils.d();
         ClassPathLibraryLoader.loadNativeHIDLibrary(D.getLibPath());
         addLaunchers(config);
         F.a(D.getLibPath());

         try {
            String var3 = GbUtilNative.getUsbSerial(10896, 49);
            logger.log(Level.INFO, "Gameband serial: " + var3);
         } catch (Throwable var5) {
            logger.log(Level.INFO, "Error reading serial: " + var5);
         }

         d = new com.nowcomputing.uistuff.s(config, b);
         var2.b();
         var2.a();
         logger.log(Level.FINE, "Splash finished");
         d.setVisible(true);
         logger.log(Level.FINE, "Showed Main window");
         File var8 = new File(D.getLibPath(), ".acs");
         File var4 = new File(D.getLibPath(), ".act");
         if (var8.exists() || var4.exists()) {
            d.f();
            var8.delete();
            var4.delete();
         }

         d.e();
         logger.log(Level.FINE, "checkForUpdate finished");
      } catch (Throwable var7) {
         logger.log(Level.SEVERE, "Main thread caught exception: ", var7);
         System.exit(-1);
      }

   }

   private static void removeOldPixelFurnaceBinariesBecauseYay() {
      Utils.containsFiles(new File("PixelFurnace.app"));
      File var0 = new File("PixelFurnace.exe");
      if (var0.exists()) {
         var0.delete();
      }

      File var1 = new File("PixelFurnace_linux.bat");
      if (var1.exists()) {
         var1.delete();
      }

   }

   public static boolean a() {
      try {
         b.f();
         b.a(false);
         return true;
      } catch (Throwable var1) {
         logger.log(Level.WARNING, "Error opening Gameband HID device: ", var1);
         return false;
      }
   }

   public static void addLaunchers(GamebandConfig config) {
      vec = new Vector<>();
      vec.add(new MinecraftLauncher(config));
      vec.add(new TechnicLauncher(config));
      vec.add(new FTBLauncher(config));
      vec.add(new VoidLauncher(config));
      if (Boolean.parseBoolean(config.getProperty("launcher.minecraftedu", "false"))) {
         vec.add(new MinecraftEduLauncher(config));
      }
   }

   public static Vector getLaunchers() {
      return vec;
   }

   public static AbstractMinecraftLauncher c() {
      Iterator<AbstractMinecraftLauncher> var0 = vec.iterator();

      AbstractMinecraftLauncher launcher;
      do {
         if (!var0.hasNext()) {
            return vec.get(0);
         }

         launcher = var0.next();
      } while(!launcher.isJavaLaunchCommandValid());

      return launcher;
   }

   public static v d() {
      return !b.k() ? v.b : v.a;
   }

   public static void e() {
      d.setCursor(Cursor.getPredefinedCursor(3));

      try {
         b.g();
      } catch (Throwable var4) {
         logger.log(Level.SEVERE, "Error saving changes to Gameband: ", var4);
         am.a(d, LocaleUtil.getLocalizedString("GAMEBAND_WRITE_ERROR_TITLE"), LocaleUtil.getLocalizedString("GAMEBAND_WRITE_ERROR_TEXT"), "", "", "");
      } finally {
         d.setCursor(Cursor.getDefaultCursor());
      }

   }

   // $FF: synthetic method
   static Logger getLogger() {
      return logger;
   }

   // $FF: synthetic method
   static LockingUtil g() {
      return e;
   }

   static {
      System.setProperty("java.util.logging.manager", V.class.getName());
      logger = Logger.getLogger("com.nowcomputing");
      b = new com.nowcomputing.pixelfurnace.f();
      vec = null;
      e = null;
   }
}
