package com.nowcomputing;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Class1 implements i {
   static final Logger logger = Logger.getLogger(Utils.class.getName());
   protected File field2;
   protected File field3;
   protected R field4;
   protected long field5;
   protected long field6;
   protected boolean field7;
   protected h field8;
   private final FilenameFilter field9 = new H(this);

   protected Class1(File var1) {
      this.field2 = var1;
      this.field3 = new File(this.field2, ".tmp");
   }

   public void method1(String var1) {
      UpdateStreamDecoder var2;
      try {
         var2 = this.method3(var1);
      } catch (IOException var10) {
         logger.log(Level.FINE, "Error reading update info " + var1);
         return;
      }

      long var3 = 0L;
      ArrayList<UpdateEntry> updateList = new ArrayList<>();
      Iterator var6 = var2.getLines().iterator();

      while(var6.hasNext()) {
         UpdateEntry var7 = (UpdateEntry)var6.next();
         if (this.field7) {
            return;
         }

         if (this.method4(var7)) {
            var3 += var7.h();
            updateList.add(var7);
         }
      }

      this.method2(var3);
      long var11 = 0L;
      this.field6 = 0L;
      Iterator var8 = updateList.iterator();

      while(var8.hasNext()) {
         UpdateEntry var9 = (UpdateEntry)var8.next();
         if (this.field7) {
            return;
         }

         if (this.method5(var9)) {
            this.method7(var9);
         }
      }

      if (this.field4 != null) {
         this.field4.a();
      }

      Utils.i(new File(this.field2, "Gameband_linux.bat"));
      Utils.i(new File(this.field2, ".lib"));
      Utils.i(new File(this.field2, "autorun.inf"));
      Utils.i(new File(this.field2, ".VolumeIcon.icns"));
      Utils.a((File)this.field2, (FilenameFilter)(new I(this)));
   }

   private void method2(long var1) {
      this.field5 = var1;
   }

   private UpdateStreamDecoder method3(String var1) throws IOException{
      return UpdateStreamDecoder.a(this.method10(var1));
   }

   private boolean method4(UpdateEntry var1) {
      String var2 = Utils.c(new File(new File(this.field2, var1.d()), var1.getC()));
      return !var1.f().equals(var2);
   }

   private boolean method5(UpdateEntry var1) {
      File var2 = new File(this.field3, var1.e());
      String var3 = var2.getAbsolutePath();
      Utils.f(var2);
      var2.mkdirs();
      Utils.i(this.field3);
      File var4 = new File(var2, var1.e());
      logger.log(Level.FINE, "Downloading package " + var1.c() + " to " + var4.getPath());

      try {
         (new E(3, 500)).a(new J(this, var1, var4));
         return true;
      } catch (Exception var6) {
         logger.log(Level.WARNING, "Error downloading file " + var1.c(), var6);
         var4.delete();
         return false;
      }
   }

   private void method6(UpdateEntry var1, File var2) throws IOException {
      if (var2.exists()) {
         var2.delete();
      }

      this.field8 = new h(this.method10(var1.c()), var2, this);
      this.field8.run();
      if (!this.field8.b()) {
         throw this.field8.c();
      } else if (!var1.e().equals(Utils.c(var2))) {
         throw new IOException("Incorrect md5 for downloaded file " + var1.getC());
      }
   }

   private void method7(UpdateEntry var1) {
      String var2 = "Updating " + var1.getC() + " to " + var1.b();
      logger.log(Level.INFO, var2);
      File var3 = new File(this.field3, var1.e());
      File var4 = new File(var3, var1.e());
      File var5 = new File(var3, "unpack");

      try {
         (new E(3, 500)).a(new K(this, var4, var5));
      } catch (Exception var8) {
         logger.log(Level.WARNING, "unpack error: " + var8.toString());
         return;
      }

      File var6 = new File(var3, "backup");

      try {
         (new E(3, 500)).a(new L(this, var4, var6));
      } catch (Exception var9) {
         if (!var9.toString().contains("autorun.inf")) {
            logger.log(Level.WARNING, "Error creating package backup: " + var9.toString());
         }

         return;
      }

      if (Utils.a(var5, new File(this.field2, var1.d()), this.field9)) {
         logger.log(Level.INFO, var1.getC() + " update ok");
      } else {
         Utils.a(var6, this.field2, (FilenameFilter)null);
         logger.log(Level.WARNING, "Error applying update. Restored backup.");
      }

      Utils.f(var3);
   }

   private void method8(File var1, File var2) {
      Utils.f(var2);
      var2.mkdir();
      Utils.c(var1, var2);
   }

   private void method9(File var1, File var2) {
      Utils.f(var2);
      var2.mkdir();
      ArrayList var3 = new ArrayList();
      Utils.a(var1, var2, (List)var3);
      if (!Utils.a((List)var3)) {
         throw new IOException("MD5 error when unpacking the update");
      }
   }

   protected abstract InputStream method10(String var1) throws IOException;

   public void method11(long var1) {
      this.field6 += var1;
      if (this.field4 != null) {
         int var3 = (int)((float)this.field6 / (float)this.field5 * 100.0F);
         logger.log(Level.FINE, "bytesDownloaded = " + this.field6 + "; " + var3 + "% of " + this.field5);
         this.field4.a(var3);
      }

   }

   // $FF: synthetic method
   static void method12(Class1 var0, UpdateEntry var1, File var2) {
      var0.method6(var1, var2);
   }

   // $FF: synthetic method
   static void method13(Class1 var0, File var1, File var2) {
      var0.method9(var1, var2);
   }

   // $FF: synthetic method
   static void method14(Class1 var0, File var1, File var2) {
      var0.method8(var1, var2);
   }
}
