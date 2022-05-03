package com.nowcomputing;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class j {
   public static final Logger a = Logger.getLogger(Utils.class.getName());

   public static void a(boolean var0) {
      // $FF: Couldn't be decompiled
   }

   public static void a(String var0, boolean var1) {
      // $FF: Couldn't be decompiled
   }

   private static String a() {
      return System.getProperty("user.dir");
   }

   private static String b() {
      String var0 = System.getProperty("user.dir");
      return var0.substring(0, 2);
   }

   private static String c() {
      return "";
   }

   private static void a(String var0) {
      try {
         File var1 = new File("/tmp/gbeject.sh");
         Utils.a(var1, "sleep 1\ndiskutil eject \"" + var0 + "\"\n" + "rm /tmp/gbeject.sh\n");
         var1.setExecutable(true);
         ProcessBuilder var2 = new ProcessBuilder(new String[]{"/tmp/gbeject.sh"});
         var2.directory(new File("/tmp"));
         Process var3 = var2.start();
      } catch (IOException var4) {
      }

   }

   private static void b(String var0) {
      try {
         File var1 = File.createTempFile("gbtool", ".exe");
         InputStream var2 = j.class.getResourceAsStream("/resources/gbtool.exe");
         Utils.a(var2, var1);
         var1.setExecutable(true);
         a.log(Level.FINE, "Executing " + var1.getPath() + " -e 2A90 0031 -d");
         ProcessBuilder var3 = new ProcessBuilder(new String[]{var1.getPath(), "-e", "2A90", "0031", "-d"});
         var3.directory(var1.getParentFile());
         Process var4 = var3.start();
      } catch (IOException var5) {
      }

   }

   private static void c(String var0) {
   }
}
