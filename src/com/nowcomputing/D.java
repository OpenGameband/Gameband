package com.nowcomputing;

import java.io.File;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class D {
   public static final Logger a = Logger.getLogger(S.class.getName());
   private static File b = e();
   private static File c;
   private static File d;
   private static File e;

   public static File a() {
      return b;
   }

   public static File b() {
      return c;
   }

   public static File c() {
      return d;
   }

   private static void d() {
      c = new File(b, ".lib");
      e = new File(b, ".tmp");
      d = new File(b, "minecraft");
   }

   private static File e() {
      File var0 = null;

      try {
         File var1 = new File(D.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
         var0 = var1.getParentFile().getParentFile();
      } catch (URISyntaxException var2) {
      }

      return var0;
   }

   private static File f() {
      File var0 = null;

      try {
         String var1 = GbUtilNative.getUsbMount(10896, 49);
         a.log(Level.INFO, "getUsbMount:  " + var1);
         a.log(Level.INFO, "getUsbMount.getAbsolutePath:  " + (new File(var1)).getAbsolutePath());
         var0 = new File(var1);
      } catch (Throwable var2) {
         a.log(Level.INFO, "Error from getUsbMount: " + var2);
      }

      return var0;
   }

   public static void a(String var0) {
      d = new File(b, var0);
   }

   static {
      if (b == null) {
         b = new File(".");
      }

      String var0 = System.getProperties().getProperty("GAMEBAND_WORKING_DIR");
      if (var0 != null && !var0.isEmpty()) {
         b = new File(var0);
      }

      d();
      S.e(new File(c, "gameband.properties"));
      File var1 = f();
      if (!b.equals(var1)) {
         a.log(Level.INFO, "Working dir [" + b.getAbsolutePath() + "] != gbMount [" + var1 + "]");
      }

   }
}
