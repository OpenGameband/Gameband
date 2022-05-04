package com.nowcomputing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/*
GamebandConfig is a thin veneer around the Properties class
 */
public class GamebandConfig {
   public static final File defaultConfigFile = new File(D.getLibPath(), "gameband.properties");
   private final File configFile;
   Properties properties = new Properties();

   public GamebandConfig(File defaultConfigFile) {
      this.configFile = defaultConfigFile;

      try { // Note from
         this.properties.load(new FileInputStream(defaultConfigFile));
         D.setMinecraftPath(this.getProperty("minecraft_dir", "minecraft"));
      } catch (Exception ignored) {
      }

   }

   public String getProperty(String var1, String var2) {
      return this.properties != null ? this.properties.getProperty(var1, var2) : var2;
   }

   public static String fixPath(String var0) {
      String var1;
      if (File.separator.equals("/")) {
         var1 = var0.replace('\\', '/');
      } else {
         var1 = var0.replace('/', '\\');
      }

      if (!var1.endsWith(File.separator)) {
         var1 = var1 + File.separator;
      }

      return var1;
   }

   public void setProperty(String var1, String var2) {
      if (var2.isEmpty()) {
         this.properties.remove(var1);
      } else {
         this.properties.setProperty(var1, var2);
      }

      try {
         this.properties.store(new FileOutputStream(this.configFile), "");
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
