package com.nowcomputing;

import com.codeminders.hidapi.ClassPathLibraryLoader;
import com.nowcomputing.pixelfurnace.GBComms;
import com.nowcomputing.uistuff.ak;
import com.nowcomputing.uistuff.am;
import com.nowcomputing.uistuff.MainMenu;
import java.awt.Cursor;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import a.*;

public class Main {
   private static final Logger logger;
   private static GBComms gbComms;
   private static Vector<AbstractMinecraftLauncher> launchers;
   private static MainMenu frame;
   private static LockingUtil lockingUtil;

   public static void main(String[] args) {
      System.setProperty("java.util.Arrays.useLegacyMergeSort", "true"); // why
      Runtime.getRuntime().addShutdownHook(new ShutdownHook());

      try {
         GamebandConfig config = new GamebandConfig(GamebandConfig.defaultConfigFile);
         am.a();
         lockingUtil = new LockingUtil("Gameband"); // fun fact, this doesn't work

         try {
            if (!lockingUtil.lock()) { // lol, doesn't even fucking work
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
         deletePixelFurnace();
         Utils.d();
         ClassPathLibraryLoader.loadNativeHIDLibrary(PathUtils.getLibPath());
         addLaunchers(config);
         F.a(PathUtils.getLibPath());

         try {
            String var3 = GbUtilNative.getUsbSerial(10896, 49);
            logger.log(Level.INFO, "Gameband serial: " + var3);
         } catch (Throwable var5) {
            logger.log(Level.INFO, "Error reading serial: " + var5);
         }

         frame = new MainMenu(config, gbComms);
         var2.b();
         var2.a();
         logger.log(Level.FINE, "Splash finished");
         frame.setVisible(true);
         logger.log(Level.FINE, "Showed Main window");
         File ACSfile = new File(PathUtils.getLibPath(), ".acs");
         File ACTfile = new File(PathUtils.getLibPath(), ".act");
         if (ACSfile.exists() || ACTfile.exists()) {
            frame.f();
            ACSfile.delete();
            ACTfile.delete();
         }

         frame.e();
         logger.log(Level.FINE, "checkForUpdate finished");
      } catch (Throwable var7) {
         logger.log(Level.SEVERE, "Main thread caught exception: ", var7);
         System.exit(-1);
      }

   }

   private static void deletePixelFurnace() { // ngl this kinda dumb
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
         gbComms.ReadData();
         gbComms.a(false);
         return true;
      } catch (IOException e) {
         logger.log(Level.WARNING, "Error opening Gameband HID device: ", e);
         return false;
      }
   }

   public static void addLaunchers(GamebandConfig config) {
      launchers = new Vector<>();
      launchers.add(new MinecraftLauncher(config));
      launchers.add(new TechnicLauncher(config));
      launchers.add(new FTBLauncher(config));
      launchers.add(new VoidLauncher(config));
      if (Boolean.parseBoolean(config.getProperty("launcher.minecraftedu", "false"))) {
         launchers.add(new MinecraftEduLauncher(config));
      }
   }

   public static Vector getLaunchers() {
      return launchers;
   }

   public static AbstractMinecraftLauncher c() {
      Iterator<AbstractMinecraftLauncher> var0 = launchers.iterator();

      AbstractMinecraftLauncher launcher;
      do {
         if (!var0.hasNext()) {
            return launchers.get(0);
         }

         launcher = var0.next();
      } while(!launcher.isJavaLaunchCommandValid());

      return launcher;
   }

   public static void e() {
      frame.setCursor(Cursor.getPredefinedCursor(3));

      try {
         gbComms.setGamebandTime();
      } catch (IOException e) {
         logger.log(Level.SEVERE, "Error saving changes to Gameband: ", e);
         am.a(frame, LocaleUtil.getLocalizedString("GAMEBAND_WRITE_ERROR_TITLE"), LocaleUtil.getLocalizedString("GAMEBAND_WRITE_ERROR_TEXT"), "", "", "");
      } finally {
         frame.setCursor(Cursor.getDefaultCursor());
      }

   }

   // $FF: synthetic method
   static Logger getLogger() {
      return logger;
   }

   // $FF: synthetic method
   static LockingUtil g() {
      return lockingUtil;
   }

   static {
      System.setProperty("java.util.logging.manager", V.class.getName());
      logger = Logger.getLogger("com.nowcomputing");
      gbComms = new GBComms();
      launchers = null;
      lockingUtil = null;
   }
}
