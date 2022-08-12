package com.nowcomputing;

import java.io.File;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PathUtils {
   public static final Logger logger = Logger.getLogger(Utils.class.getName());
   private static File gamebandPath = getJarLocation();
   private static File libPath;
   private static File minecraftPath;
   private static File tmpPath;

   public static File getGamebandPath() {
      return gamebandPath;
   }

   public static File getLibPath() {
      return libPath;
   }

   public static File getMinecraftPath() {
      return minecraftPath;
   }

   private static void setPaths() {
      libPath = new File(gamebandPath, ".lib");
      tmpPath = new File(gamebandPath, ".tmp");
      minecraftPath = new File(gamebandPath, "minecraft");
   }

   private static File getJarLocation() {
      File gamebandPath = null;

      try {
         File jarPath = new File(PathUtils.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
         gamebandPath = jarPath.getParentFile().getParentFile();
      } catch (URISyntaxException var2) {
      }

      return gamebandPath;
   }

   private static File getUSBMount() {
      File mountPath = null;

      try {
         String mountPathString = GbUtilNative.getUsbMount(10896, 49);
         logger.log(Level.INFO, "getUsbMount:  " + mountPathString);
         logger.log(Level.INFO, "getUsbMount.getAbsolutePath:  " + (new File(mountPathString)).getAbsolutePath());
         mountPath = new File(mountPathString);
      } catch (Throwable e) {
         logger.log(Level.INFO, "Error from getUsbMount: " + e);
      }

      return mountPath;
   }

   public static void setMinecraftPath(String var0) {
      minecraftPath = new File(gamebandPath, var0);
   }

   static {
      if (gamebandPath == null) {
         gamebandPath = new File(".");
      }

      String gamebandWorkingDir = System.getProperties().getProperty("GAMEBAND_WORKING_DIR");
      if (gamebandWorkingDir != null && !gamebandWorkingDir.isEmpty()) {
         gamebandPath = new File(gamebandWorkingDir);
      }

      setPaths();
      Utils.e(new File(libPath, "gameband.properties"));
      File usbMountPath = getUSBMount();
      if (!gamebandPath.equals(usbMountPath)) {
         logger.log(Level.INFO, "Working dir [" + gamebandPath.getAbsolutePath() + "] != gbMount [" + usbMountPath + "]");
      }

   }
}
