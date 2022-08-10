package com.nowcomputing;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

// Some of the only "sane" code in here, makes minimal references to the rest of the code, though I don't think it's even used
public class GbUtilNative {
   private static final Logger logger = Logger.getLogger(GbUtilNative.class.getName());
   private static final String[] windowsGBUtil = new String[]{"gbutil_jni_64.dll", "gbutil_jni_32.dll"};
   private static final String[] macGBUtil = new String[]{"libgbutil_jni_64.dylib", "libgbutil_jni_32.dylib"};
   private static final String[] linuxGBUtil = new String[]{"libgbutil_jni_64.so", "libgbutil_jni_32.so"};

   public static boolean loadNativeLibrary() {
      switch (p.a[Utils.b().ordinal()]) {
         case 1: {
            return GbUtilNative.loadNativeLibrary(windowsGBUtil);
         }
         case 2: {
            return GbUtilNative.loadNativeLibrary(macGBUtil);
         }
         case 3: {
            return GbUtilNative.loadNativeLibrary(linuxGBUtil);
         }
      }
      return false;
   }

   private static boolean loadNativeLibrary(String[] paths) {
      for (String nativeLib : paths) { // slick :) (check commit history)
         File libFile = new File(D.getLibPath(), nativeLib);

         try {
            Runtime.getRuntime().load(libFile.getAbsolutePath());
            logger.log(Level.FINE, "Successfully loaded native library: " + libFile.getAbsolutePath());
            return true;
         } catch (Exception e) { // not slick :(
            logger.log(Level.INFO, "Error loading library: " + libFile.getAbsolutePath(), e);
         } catch (UnsatisfiedLinkError ex) {
            logger.log(Level.INFO, ex.toString());
         }
      }

      return false;
   }

   public static native String getUsbMount(int vid, int pid);

   public static native String getUsbSerial(int vid, int pid);

   public static native int lockInstance(String name); // don't know why these exist, nor what they do

   public static native void unlockInstance(int instance, String name);

   static {
      try {
         loadNativeLibrary();
      } catch (UnsatisfiedLinkError e) {
         logger.log(Level.INFO, e.toString());
      } catch (Throwable ex) {
         logger.log(Level.INFO, "Exception loading native library: ", ex);
      }

   }
}
