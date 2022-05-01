package com.nowcomputing;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GbUtilNative {
   private static final Logger logger = Logger.getLogger(GbUtilNative.class.getName());
   private static final String[] b = new String[]{"gbutil_jni_64.dll", "gbutil_jni_32.dll"};
   private static final String[] c = new String[]{"libgbutil_jni_64.dylib", "libgbutil_jni_32.dylib"};
   private static final String[] d = new String[]{"libgbutil_jni_64.so", "libgbutil_jni_32.so"};

   public static boolean a() {
      // $FF: Couldn't be decompiled
   }

   private static boolean a(String[] var0) {
      String[] var1 = var0;
      int var2 = var0.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         String var4 = var1[var3];
         File var5 = new File(D.b(), var4);

         try {
            Runtime.getRuntime().load(var5.getAbsolutePath());
            logger.log(Level.FINE, "Successfully loaded native library: " + var5.getAbsolutePath());
            return true;
         } catch (Exception var7) {
            logger.log(Level.INFO, "Error loading library: " + var5.getAbsolutePath(), var7);
         } catch (UnsatisfiedLinkError var8) {
            logger.log(Level.INFO, var8.toString());
         }
      }

      return false;
   }

   public static native String getUsbMount(int var0, int var1);

   public static native String getUsbSerial(int var0, int var1);

   public static native int lockInstance(String var0);

   public static native void unlockInstance(int var0, String var1);

   static {
      try {
         a();
      } catch (UnsatisfiedLinkError var1) {
         logger.log(Level.INFO, var1.toString());
      } catch (Throwable var2) {
         logger.log(Level.INFO, "Exception loading native library: ", var2);
      }

   }
}
