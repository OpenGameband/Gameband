package com.nowcomputing;

import java.io.*;
import java.net.*;
import java.security.DigestInputStream;
import java.security.KeyManagementException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

/**
 * originally called com.nowcomputing.S
 */
public class Utils {
   public static final Logger logger = Logger.getLogger(Utils.class.getName());

   public static String getAllFromInputStream(InputStream var0) {
      String var1 = "";
      BufferedReader var2 = null;

      String var3;
      try {
         for (var2 = new BufferedReader(new InputStreamReader(var0)); (var3 = var2.readLine()) != null; var1 = var1 + var3) {
         }
      }catch (IOException e){
         logger.log(Level.WARNING, e.toString());
      } finally {
         closeButUnsafe((Closeable)var2);
      }

      return var1;
   }

   public static String readFile(File var0) throws IOException{
      return getAllFromInputStream(new FileInputStream(var0));
   }

   /**
    * Does the exact same thing as readFile but badly
    * @param f The file to get all text from
    * @return the contents of the file as a string, or null if the file doesn't exist
    */
   public static String readFileLazy(File f) {
      try {
         return readFile(f);
      } catch (IOException e) {
         return null;
      }
   }

   public static void a(File var0, String var1) {
      OutputStreamWriter outputStreamWriter = null;
      FileOutputStream fos = null;

      try {
         if (var0.exists()) {
            var0.setWritable(true);
            if (b() == OSDetectionIsHard.osx) {
               ProcessBuilder var4 = new ProcessBuilder("chflags", "-R", "nouchg", var0.getPath());
               var4.start();
            }

            var0.delete();
         }

         if (var1 != null) {
            var0.getParentFile().mkdirs();
            fos = new FileOutputStream(var0);
            outputStreamWriter = new OutputStreamWriter(fos);
            outputStreamWriter.write(var1);
         }
      } catch (IOException var13) {
         logger.log(Level.FINE, "Error writing file " + var0.getName(), var13);
      } finally {
         if (fos != null) {
            try {
               if (outputStreamWriter != null) {
                  outputStreamWriter.flush();
               }

               fos.flush();
               fos.getFD().sync();
            } catch (IOException var12) {
            }
         }

         closeButUnsafe(fos);
         closeButUnsafe(outputStreamWriter);
      }

   }

   public static String c(File var0) {
      DigestInputStream var1 = null;
      FileInputStream var2 = null;

      try {
         MessageDigest var3 = MessageDigest.getInstance("MD5");
         var2 = new FileInputStream(var0);
         var1 = new DigestInputStream(var2, var3);
         byte[] var4 = new byte[1024];

         while(var1.read(var4) != -1) {
         }

         byte[] var5 = var3.digest();
         StringBuffer var6 = new StringBuffer(64);

         for(int var7 = 0; var7 < var5.length; ++var7) {
            String var8 = Integer.toHexString(255 & var5[var7]);
            if (var8.length() == 1) {
               var6.append('0');
            }

            var6.append(var8);
         }

         String var16 = var6.toString();
         return var16;
      } catch (NoSuchAlgorithmException var13) {
         logger.log(Level.FINE, "Error calculating md5 of file " + var0.getName(), var13);
      } catch (IOException var14) {
         logger.log(Level.FINE, "Error calculating md5 of file " + var0.getName(), var14);
      } finally {
         closeButUnsafe((Closeable)var1);
         closeButUnsafe((Closeable)var2);
      }

      return "";
   }

   public static boolean d(File var0) {
      File var1 = new File(var0.getPath() + ".MD5");
      if (var0.exists() && var1.exists()) {
         String var2 = readFileLazy(var1);
         String var3 = c(var0);
         return var2.equals(var3);
      } else {
         return false;
      }
   }

   public static boolean a(List var0) {
      Iterator var1 = var0.iterator();

      File var2;
      do {
         if (!var1.hasNext()) {
            return true;
         }

         var2 = (File)var1.next();
      } while(var2.getName().endsWith(".MD5") || d(var2));

      return false;
   }

   public static void e(File var0) {
      try {
         Object var1;
         if (var0.exists()) {
            var1 = new FileInputStream(var0);
         } else {
            var1 = Utils.class.getClassLoader().getResourceAsStream(var0.getName());
         }

         Properties var2 = new Properties();
         var2.load((InputStream)var1);
         String var3 = var2.getProperty("java.util.logging.FileHandler.pattern");
         File var4 = new File(D.getGamebandPath(), var3);
         var2.setProperty("java.util.logging.FileHandler.pattern", var4.getAbsolutePath());
         ByteArrayOutputStream var5 = new ByteArrayOutputStream();
         var2.store(var5, "");
         LogManager.getLogManager().readConfiguration(new ByteArrayInputStream(var5.toByteArray()));
      } catch (Exception var6) {
      }

   }

   public static void a(File var0, File var1) throws IOException {
      a((InputStream)(new FileInputStream(var0)), (File)var1);
   }

   public static void a(InputStream is, File f) throws IOException{
      FileOutputStream fos = null;

      try {
         fos = new FileOutputStream(f);
         byte[] var3 = new byte[4096];
         boolean var4 = true;

         int var8;
         while ((var8 = is.read(var3)) > 0) {
            fos.write(var3, 0, var8);
         }
      }catch (FileNotFoundException e){
         throw new RuntimeException(e);
      } finally {
         closeButUnsafe((Closeable)is);
         if (fos != null) {
            fos.flush();
            fos.getFD().sync();
            closeButUnsafe((Closeable)fos);
         }

      }

   }

   public static boolean containsFiles(File dir) {
      if (!dir.exists()) {
         return true;
      } else {
         if (dir.isDirectory()) {
            File[] fileList = dir.listFiles();
            int listLen = fileList.length;

            for(int i = 0; i < listLen; ++i) {
               File f = fileList[i];
               if (!containsFiles(f)) {
                  return false;
               }
            }
         }

         return g(dir);
      }
   }

   public static boolean g(File var0) {
      int var1 = 5; // Thanks magic numbers

      while(var1-- > 0) {
         try {
            if (var0.delete()) {
               return true;
            }
         } catch (Exception var4) {
         }

         try {
            Thread.sleep(200L);
         } catch (InterruptedException var3) {
         }
      }

      logger.log(Level.FINE, "Error deleting file " + var0.getPath());
      return false;
   }

   public static boolean a(File var0, File var1, FilenameFilter var2) {
      logger.log(Level.FINE, "Moving files from " + var0.getPath() + " to " + var1.getPath());
      File[] var3 = var0.listFiles(var2);
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         File var6 = var3[var5];
         File var7 = new File(var1 + File.separator + var6.getName());
         if (var6.isDirectory()) {
            if (!var7.exists()) {
               var7.mkdir();
            }

            if (!a(var6, var7, var2)) {
               logger.log(Level.FINE, "Error moving directory from " + var6.getPath() + " to " + var7.getPath());
               return false;
            }
         } else if (!b(var6, var7)) {
            return false;
         }
      }

      return true;
   }

   public static boolean b(File var0, File var1) {
      if (var1.exists() && !g(var1)) {
         return false;
      } else {
         logger.log(Level.FINER, "Renaming file from " + var0.getPath() + " to " + var1.getPath());
         if (var1.getParentFile() != null) {
            var1.getParentFile().mkdirs();
         }

         if (!var0.renameTo(var1)) {
            logger.log(Level.FINE, "Error renaming file from " + var0.getPath() + " to " + var1.getPath());
            return false;
         } else {
            return true;
         }
      }
   }

   public static void c(File var0, File var1) throws IOException {
      ZipInputStream var2 = null;

      try {
         var2 = new ZipInputStream(new FileInputStream(var0));

         for(ZipEntry var3 = var2.getNextEntry(); var3 != null; var3 = var2.getNextEntry()) {
            String var4 = var3.getName();
            File var5 = new File(var1 + File.separator + var4);
            if (var3.isDirectory()) {
               if (!var5.exists()) {
                  var5.mkdir();
               }
            } else {
               File var6 = new File(var3.getName());
               if (var6.exists()) {
                  a(var6, var5);
               }
            }
         }

         var2.closeEntry();
      } finally {
         closeButUnsafe((Closeable)var2);
      }
   }

   public static void a(File var0, File var1, List var2) throws IOException {
      ZipInputStream var3 = null;

      try {
         logger.log(Level.FINE, "Unzipping file: " + var0.getPath() + " to dir " + var1.getPath());
         byte[] var4 = new byte[1024];
         var3 = new ZipInputStream(new FileInputStream(var0));

         for(ZipEntry var5 = var3.getNextEntry(); var5 != null; var5 = var3.getNextEntry()) {
            String var6 = var5.getName();
            logger.log(Level.FINER, "Extracting file: " + var6);
            File var7 = new File(var1 + File.separator + var6);
            if (var5.isDirectory()) {
               if (!var7.exists()) {
                  var7.mkdir();
               }
            } else {
               File var8 = new File(var7.getParent());
               if (!var8.exists()) {
                  var8.mkdirs();
               }

               if (var7.exists()) {
                  g(var7);
               }

               FileOutputStream var9 = null;

               try {
                  var9 = new FileOutputStream(var7);

                  int var10;
                  while((var10 = var3.read(var4)) > 0) {
                     var9.write(var4, 0, var10);
                  }

                  if (var2 != null) {
                     var2.add(var7);
                  }
               } finally {
                  if (var9 != null) {
                     try {
                        var9.flush();
                        var9.getFD().sync();
                     } catch (IOException var22) {
                     }

                     closeButUnsafe((Closeable)var9);
                  }

               }
            }
         }

         var3.closeEntry();
      } finally {
         closeButUnsafe((Closeable)var3);
      }
   }

   public static String a() {
      StringBuilder var0 = new StringBuilder(128);

      try {
         Enumeration var1 = NetworkInterface.getNetworkInterfaces();

         while(true) {
            byte[] var2;
            do {
               if (!var1.hasMoreElements()) {
                  return var0.toString();
               }

               var2 = ((NetworkInterface)var1.nextElement()).getHardwareAddress();
            } while(var2 == null);

            StringBuilder var3 = new StringBuilder(64);

            for(int var4 = 0; var4 < var2.length; ++var4) {
               var3.append(String.format("%02X%s", var2[var4], var4 < var2.length - 1 ? ":" : ""));
            }

            if (isMacAddressAllowed(var3.toString())) {
               if (!"".equals(var0.toString())) {
                  var0.append(',');
               }

               var0.append(var3);
            }
         }
      } catch (SocketException var5) {
         logger.log(Level.FINE, "Error reading Mac address", var5);
         return var0.toString();
      }
   }

   private static boolean isMacAddressAllowed(String var0) {
      return var0 != null && !var0.equals("") && !var0.equals("00:00:00:00:00:00:00:E0") && !var0.startsWith("00:1C:42") && !var0.startsWith("00:16:3E") && !var0.startsWith("08:00:27") && !var0.startsWith("00:03:FF") && !var0.startsWith("00:50:56") && !var0.startsWith("00:0C:29") && !var0.startsWith("00:05:69");
   }

   public static OSDetectionIsHard b() {
      String var0 = System.getProperty("os.name").toLowerCase();

      for(OSDetectionIsHard var4 : OSDetectionIsHard.values()) {
         String[] var5 = var4.b();
         int var6 = var5.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            String var8 = var5[var7];
            if (var0.contains(var8)) {
               return var4;
            }
         }
      }

      return OSDetectionIsHard.unknown;
   }

   public static short[] a(byte[] var0) {
      int var1 = 0;
      int var2 = 0;
      byte[] var3 = var0;
      int var4 = var0.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         byte var6 = var3[var5];
         var1 = (var1 + (var6 & 255)) % 255;
         var2 = (var2 + var1) % 255;
      }

      return new short[]{(short)var1, (short)var2};
   }

   public static long c() {
      File var0 = new File(".");
      return var0.getUsableSpace();
   }

   public static ClassLoader a(String var0) throws MalformedURLException {
      File var1 = new File(var0);
      URL[] var2 = new URL[]{var1.toURI().toURL()};
      URLClassLoader var3 = new URLClassLoader(var2);
      return var3;
   }

   public static void d() {
      try {
         TrustManager[] trustManagers = new TrustManager[]{new T()};
         SSLContext sslContext = SSLContext.getInstance("SSL");
         sslContext.init((KeyManager[])null, trustManagers, new SecureRandom());
         HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
         U var2 = new U();
         HttpsURLConnection.setDefaultHostnameVerifier(var2);
      } catch (KeyManagementException e) {
         logger.log(Level.WARNING, e.toString(), e);
      } catch (NoSuchAlgorithmException ex) {
         logger.log(Level.WARNING, ex.toString(), ex);
      }

   }

   public static void writeLocaleFile(Object var0, File var1) {
      FileOutputStream var2 = null;
      ObjectOutputStream var3 = null;

      try {
         var2 = new FileOutputStream(var1);
         var3 = new ObjectOutputStream(var2);
         var3.writeObject(var0);
      } catch (IOException var8) {
         logger.log(Level.FINE, "Error writing locale file " + var1, var8);
      } finally {
         closeButUnsafe(var3);
         closeButUnsafe(var2);
      }

   }

   public static Object deserializeFile(File var0) {
      Object var1 = null;
      FileInputStream var2 = null;
      ObjectInputStream var3 = null;

      try {
         var2 = new FileInputStream(var0);
         var3 = new ObjectInputStream(var2);
         var1 = var3.readObject();
      } catch (Throwable var8) {
         logger.log(Level.FINE, "Error deserializing object file " + var0.getPath());
      } finally {
         closeButUnsafe((Closeable)var3);
         closeButUnsafe((Closeable)var2);
      }

      return var1;
   }

   public static InputStream b(String var0) throws IOException {
      logger.log(Level.FINE, "Getting URL " + var0);
      HttpURLConnection var1 = (HttpURLConnection)(new URL(var0)).openConnection();
      var1.setRequestMethod("GET");
      var1.setDoInput(true);
      return var1.getInputStream();
   }

   public static String e() {
      String var0 = WindowsVersionComparator.getImplementationVersion().toString();
      if (b() == OSDetectionIsHard.windows) {
         var0 = var0 + '|' + g();
      } else {
         var0 = var0 + '|' + System.getProperty("os.name");
      }

      var0 = var0 + '|' + System.getProperty("os.version");
      var0 = var0 + '|' + System.getProperty("os.arch");
      var0 = var0 + '|' + System.getProperty("java.version");
      var0 = var0 + '|' + System.getProperty("java.vendor");
      String var1 = a();
      if (var1 != null) {
         var0 = var0 + '|' + var1;
      }

      try {
         var0 = var0 + '|' + (new File(".")).getCanonicalPath();
      } catch (IOException var3) {
         var0 = var0 + '|' + var3.toString();
      }

      return var0;
   }

   private static String g() {
      String var0 = null;
      ProcessBuilder var1 = new ProcessBuilder(new String[]{"cmd", "/c", "ver"});

      try {
         Process var2 = var1.start();
         BufferedReader var3 = new BufferedReader(new InputStreamReader(var2.getInputStream()));
         String var4 = null;

         while((var4 = var3.readLine()) != null) {
            var0 = g(var4);
            if (var0 != null) {
               break;
            }
         }

         closeButUnsafe((Closeable)var3);
      } catch (IOException var5) {
      }

      if (var0 == null) {
         var0 = System.getProperty("os.name");
      }

      return var0;
   }

   private static String g(String var0) {
      String var1 = "Microsoft Windows \\[Version ([0-9]+)\\.([0-9]+)\\.([0-9]+)\\]";
      Pattern var2 = Pattern.compile("Microsoft Windows \\[Version ([0-9]+)\\.([0-9]+)\\.([0-9]+)\\]");
      Matcher var3 = var2.matcher(var0);
      if (var3.matches()) {
         String var4 = "Windows " + var3.group(1);
         if (!var3.group(2).equals("0")) {
            var4 = var4 + "." + var3.group(2);
         }

         return var4;
      } else {
         return null;
      }
   }

   public static void a(File var0, FilenameFilter var1) {
      File[] var2 = var0.listFiles(var1);
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         File var5 = var2[var4];
         hideFile(var5);
      }

   }

   public static void hideFile(File var0) {
      try {
         String var1 = var0.getCanonicalPath();
         ProcessBuilder var2;
         if (b() == OSDetectionIsHard.windows) {
            var2 = new ProcessBuilder(new String[]{"attrib", "+H", var1});
            var2.start();
         } else if (b() == OSDetectionIsHard.osx) {
            var2 = new ProcessBuilder(new String[]{"chflags", "hidden", var1});
            var2.start();
         } else if (b() == OSDetectionIsHard.linux) {
            var2 = new ProcessBuilder(new String[]{"fatattr", "+h", var1});
            var2.start();
         }
      } catch (IOException var3) {
         logger.log(Level.INFO, "Error making file " + var0.getAbsolutePath() + " hidden");
      }

   }

   public static void lsregisterShenanigans() throws IOException {
      if (b() == OSDetectionIsHard.osx) {
         String var0 = null;
         if ((new File("/System/Library/Frameworks/CoreServices.framework/Versions/A/Frameworks/LaunchServices.framework/Versions/A/Support/lsregister")).exists()) {
            var0 = "/System/Library/Frameworks/CoreServices.framework/Versions/A/Frameworks/LaunchServices.framework/Versions/A/Support/lsregister";
         } else if ((new File("/System/Library/Frameworks/ApplicationServices.framework/Versions/A/Frameworks/LaunchServices.framework/Versions/Current/Support/lsregister")).exists()) {
            var0 = "/System/Library/Frameworks/ApplicationServices.framework/Versions/A/Frameworks/LaunchServices.framework/Versions/Current/Support/lsregister";
         } else {
            ProcessBuilder var1 = new ProcessBuilder(new String[]{"find", "/System", "-name", "lsregister", "-print"});
            Process var2 = var1.start();
            BufferedReader var3 = new BufferedReader(new InputStreamReader(var2.getInputStream()));

            for(String var4 = null; (var4 = var3.readLine()) != null; var0 = var4) {
            }

            closeButUnsafe((Closeable)var3);
            if (var0 == null) {
               throw new IOException("Can't find lsregister");
            }
         }

         String var5 = "sleep 1 \n";
         String var6 = var0 + " -u " + (new File(D.getGamebandPath(), "Gameband.app")).getAbsolutePath() + " " + System.getProperty("user.dir") + "/PixelFurnace.app \n";
         File var7 = new File("/tmp/gbunreg.sh");
         a(var7, var5 + var6);
         var7.setExecutable(true);
         ProcessBuilder var8 = new ProcessBuilder(new String[]{"/tmp/gbunreg.sh"});
         var8.directory(new File("/tmp"));
         var8.start();
         logger.log(Level.FINE, "Called lsregister");
      }
   }

   public static int a(int var0, int var1, int var2) {
      return var0 < var1 ? var1 : (var0 > var2 ? var2 : var0);
   }

   public static String fixSeperator(String var0) {
      if (File.separatorChar == '\\') {
         var0 = var0.replace('/', '\\');
      } else {
         var0 = var0.replace('\\', '/');
      }

      return var0;
   }

   public static String d(String var0) {
      FileInputStream var1 = null;

      String var3;
      try {
         MessageDigest var2 = MessageDigest.getInstance("SHA1");
         var1 = new FileInputStream(var0);
         byte[] var13 = new byte[1024];
         boolean var4 = false;

         int var14;
         while((var14 = var1.read(var13)) != -1) {
            var2.update(var13, 0, var14);
         }

         byte[] var5 = var2.digest();
         StringBuffer var6 = new StringBuffer();

         for(int var7 = 0; var7 < var5.length; ++var7) {
            var6.append(Integer.toString((var5[var7] & 255) + 256, 16).substring(1));
         }

         String var15 = var6.toString();
         return var15;
      } catch (Exception var11) {
         var3 = "";
      } finally {
         closeButUnsafe((Closeable)var1);
      }

      return var3;
   }

   public static void a(String var0, String var1) throws IOException {
      BufferedInputStream var2 = null;
      BufferedOutputStream var3 = null;

      try {
         var2 = new BufferedInputStream(new FileInputStream(var0));
         var3 = new BufferedOutputStream(new FileOutputStream(var1));
         byte var4 = 5;
         byte[] var5 = new byte[var4];
         if (var2.read(var5, 0, var4) != var4) {
            throw new IOException("input .lzma file is too short");
         }

         com.nowcomputing.c.b.b var6 = new com.nowcomputing.c.b.b();
         if (!var6.a(var5)) {
            throw new IOException("Incorrect stream properties");
         }

         long var7 = 0L;

         for(int var9 = 0; var9 < 8; ++var9) {
            int var10 = var2.read();
            if (var10 < 0) {
               throw new IOException("Can't read stream size");
            }

            var7 |= (long)var10 << 8 * var9;
         }

         if (!var6.a(var2, var3, var7)) {
            throw new IOException("Error in data stream");
         }
      } finally {
         closeButUnsafe((Closeable)var2);
         closeButUnsafe((Closeable)var3);
      }

   }

   /**
    * Closes a Closeable
    * NOTE: completely redundant, could have just been c.close()
    * @param c a closable object
    */
   public static void closeButUnsafe(Closeable c) {
      if (c != null) {
         try {
            c.close();
         } catch (IOException e) {
            e.printStackTrace(); // This is new behavior but I am sad, this method is so useless
         }
      }
   }

   public static String arrayWithPrefix(String[] strings, String str) { // used for printing java command line params
      StringBuilder sb = new StringBuilder();
      boolean var3 = true;

      for (String s : strings) {
         if (var3) {
            var3 = false;
         } else {
            sb.append(str);
         }

         sb.append(s);
      }

      return sb.toString();
   }

   /**
    Returns true if the array arr contains string s
    @param arr the array to search
    @param s the string to match against
    */
   public static boolean arrContains(String[] arr, String s) {
      for (String var5 : arr) {
         if (s.equals(var5)) {
            return true;
         }
      }

      return false;
   }

   public static InputStream HttpGet(String var0) throws IOException {
      logger.log(Level.FINE, "Getting URL " + var0);
      URL var1 = new URL(var0);
      HttpURLConnection var2 = (HttpURLConnection)var1.openConnection();
      var2.setRequestMethod("GET");
      var2.setDoInput(true);
      return var2.getInputStream();
   }
}
