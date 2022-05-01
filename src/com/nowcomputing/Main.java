package com.nowcomputing;

import com.codeminders.hidapi.ClassPathLibraryLoader;
import com.nowcomputing.f.ak;
import com.nowcomputing.f.am;
import java.awt.Cursor;
import java.io.File;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
   private static final Logger logger;
   private static com.nowcomputing.d.f b;
   private static Vector c;
   private static com.nowcomputing.f.s d;
   private static b e;

   public static void main(String[] var0) {
      System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
      Runtime.getRuntime().addShutdownHook(new u());

      try {
         GamebandConfig var1 = new GamebandConfig(GamebandConfig.defaultConfigFile);
         am.a();
         e = new b("Gameband");

         try {
            if (!e.a()) {
               logger.log(Level.INFO, "Another instance of this application is already running. Exiting.");
               System.out.println("Another instance of this application is already running. Exiting.");
               System.exit(0);
               return;
            }
         } catch (Throwable var6) {
            var6.printStackTrace();
         }

         ak var2 = new ak(var1, 1000);
         logger.log(Level.FINE, S.e());
         h();
         S.d();
         ClassPathLibraryLoader.loadNativeHIDLibrary(D.b());
         a(var1);
         F.a(D.b());

         try {
            String var3 = GbUtilNative.getUsbSerial(10896, 49);
            logger.log(Level.INFO, "Gameband serial: " + var3);
         } catch (Throwable var5) {
            logger.log(Level.INFO, "Error reading serial: " + var5);
         }

         d = new com.nowcomputing.f.s(var1, b);
         var2.b();
         var2.a();
         logger.log(Level.FINE, "Splash finished");
         d.setVisible(true);
         logger.log(Level.FINE, "Showed Main window");
         File var8 = new File(D.b(), ".acs");
         File var4 = new File(D.b(), ".act");
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

   private static void h() {
      S.f(new File("PixelFurnace.app"));
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

   public static void a(GamebandConfig var0) {
      c = new Vector();
      c.add(new a.g(var0));
      c.add(new a.k(var0));
      c.add(new a.a(var0));
      c.add(new a.m(var0));
      if (Boolean.parseBoolean(var0.getProperty("launcher.minecraftedu", "false"))) {
         c.add(new a.d(var0));
      }

   }

   public static Vector b() {
      return c;
   }

   public static a.e c() {
      Iterator var0 = c.iterator();

      a.e var1;
      do {
         if (!var0.hasNext()) {
            return (a.e)c.get(0);
         }

         var1 = (a.e)var0.next();
      } while(!var1.e());

      return var1;
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
         am.a(d, f.a("GAMEBAND_WRITE_ERROR_TITLE"), f.a("GAMEBAND_WRITE_ERROR_TEXT"), "", "", "");
      } finally {
         d.setCursor(Cursor.getDefaultCursor());
      }

   }

   // $FF: synthetic method
   static Logger f() {
      return logger;
   }

   // $FF: synthetic method
   static b g() {
      return e;
   }

   static {
      System.setProperty("java.util.logging.manager", V.class.getName());
      logger = Logger.getLogger("com.nowcomputing");
      b = new com.nowcomputing.d.f();
      c = null;
      e = null;
   }
}
