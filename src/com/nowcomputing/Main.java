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
   private static Vector<AbstractMinecraftLauncher> vec;
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
            if (!lockingUtil.lock()) {
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
         ClassPathLibraryLoader.loadNativeHIDLibrary(D.getLibPath());
         addLaunchers(config);
         F.a(D.getLibPath());

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
         File var8 = new File(D.getLibPath(), ".acs");
         File var4 = new File(D.getLibPath(), ".act");
         if (var8.exists() || var4.exists()) {
            frame.f();
            var8.delete();
            var4.delete();
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
      vec = null;
      lockingUtil = null;
   }
}
