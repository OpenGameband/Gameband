package com.nowcomputing.pixelfurnace;

import com.nowcomputing.LocaleUtil;
import com.nowcomputing.Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class GBTime {
   private static final Logger logger = Logger.getLogger(Utils.class.getName());
   private GbCommand command = new GbCommand();
   private List animations = new ArrayList();
   private GamebandHID gbHID = new GamebandHID();
   private com.nowcomputing.e.d e;
   private static final ExecutorService threadPool = Executors.newCachedThreadPool();
   private boolean g;

   public GBTime() {
      this.e = com.nowcomputing.e.c.a;
   }

   public short getOrientation() {
      return this.command != null ? this.command.d() : 0;
   }

   public void setOrientation(short var1) {
      if (this.command != null) {
         this.command.setSixthBit(var1);
      }

   }

   public void setGamebandTimezone() {
      DateTimeZone timeZone                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    = DateTimeZone.forTimeZone(LocaleUtil.e());
      logger.log(Level.FINE, "Setting Gameband timezone to: " + timeZone);
      long var2 = System.currentTimeMillis();
      int var4 = timeZone.getStandardOffset(var2) / '\uea60';
      int var5 = a(timeZone) / '\uea60' + var4;
      if (timeZone.isStandardOffset(var2)) {
         this.command.c((short)(var4 / 15));
         this.command.d((short)(var5 / 15));
      } else {
         this.command.c((short)(var5 / 15));
         this.command.d((short)(var4 / 15));
      }

      this.command.a(timeZone.nextTransition(var2) / 1000L);
   }

   public void a(com.nowcomputing.e.d var1) {
      this.e = var1;
      Iterator var2 = this.animations.iterator();

      while(var2.hasNext()) {
         Animation var3 = (Animation)var2.next();
         if (!(var3 instanceof o)) {
            var3.a(com.nowcomputing.e.c.a(this.e));
         }
      }

   }

   public com.nowcomputing.e.d c() {
      return this.e;
   }

   public List<Animation> getAnimations() {
      return this.animations;
   }

   public int e() {
      return 4;
   }

   public void a(List var1) {
      this.animations.clear();
      this.animations = var1;
      this.command.g((short)this.animations.size());
   }

   public void f() throws IOException {
      short[] var1;
      try {
         this.gbHID.open();
         logger.log(Level.FINE, "Opened Gameband HID device");
         var1 = this.gbHID.getGBInfo();
      } catch (IOException var3) {
         throw var3;
      } catch (Throwable var4) {
         logger.log(Level.WARNING, "Error reading from Gameband", var4);
         throw var4;
      }

      logger.log(Level.FINE, "Read data");
      logger.log(Level.FINE, this.formatData(var1));

      try {
         short[] var2 = this.b(var1);
         if (var2[0] == var1[10] && var2[1] == var1[11]) {
            this.a(var1);
            a(this, var1);
            logger.log(Level.FINE, this.h());
         } else {
            logger.log(Level.SEVERE, "Error reading from Gameband - incorrect checksum");
            this.command = new GbCommand();
         }
      } catch (Exception var5) {
         logger.log(Level.SEVERE, "Error reading data Gameband", var5);
         this.command = new GbCommand();
      }

   }

   public void setGamebandTime() throws IOException {
      logger.log(Level.FINE, "Computer timezone: " + TimeZone.getDefault().getID());
      logger.log(Level.FINE, "Computer local time: " + new Date());
      int seconds = (int)((new Date()).getTime() / 1000L);
      logger.log(Level.FINE, "Setting Gameband time (UTC) to: " + seconds);
      if (!this.gbHID.getGBValue(seconds)) {
         logger.log(Level.WARNING, "Error setting Gameband time!");
      }

      this.setGamebandTimezone();
      this.command.f((short)47);
      this.command.g((short)this.animations.size());
      short[] var2 = this.m();
      short[] var3 = this.b(var2);
      var2[10] = var3[0];
      var2[11] = var3[1];
      logger.log(Level.FINE, "Data to write");
      logger.log(Level.FINE, this.formatData(var2));
      logger.log(Level.FINE, this.h());

      try {
         this.a(var2);
      } catch (IOException var8) {
         String var5 = this.command.f() + "|";

         Animation var7;
         for(Iterator var6 = this.animations.iterator(); var6.hasNext(); var5 = var5 + var7.e() + ":" + var7.c().a() + ",") {
            var7 = (Animation)var6.next();
         }

         throw new IOException("Data too big (" + var2.length + ") " + var5);
      }

      this.gbHID.open();
      this.gbHID.a(var2);
      logger.log(Level.FINE, "Wrote data to Gameband OK");
      this.a(var3[0], var3[1]);
      logger.log(Level.FINE, "Checked written data OK");
      this.a(false);
   }

   private short[] m() {
      int var1 = 0;

      Animation var3;
      for(Iterator var2 = this.animations.iterator(); var2.hasNext(); var1 += var3.c().a()) {
         var3 = (Animation)var2.next();
      }

      this.command.a(var1);
      short[] var8 = new short[12 + var1];
      System.arraycopy(this.command.a, 0, var8, 0, 12);
      int var9 = 12;
      Iterator var4 = this.animations.iterator();

      while(var4.hasNext()) {
         Animation var5 = (Animation)var4.next();
         GamebandScreen var6 = var5.c();
         System.arraycopy(var6.getScreenInfo(), 0, var8, var9, 6);
         var9 += 6;
         short[] var7 = var6.getImageData();
         if (var7 != null) {
            System.arraycopy(var6.getImageData(), 0, var8, var9, var6.getImageData().length);
            var9 += var6.getImageData().length;
         }
      }

      return var8;
   }

   private void a(short var1, short var2) throws IOException {
      short[] var3 = this.gbHID.getGBInfo();
      short[] var4 = this.b(var3);
      if (var1 != var4[0] || var1 != var3[10] || var2 != var4[1] || var2 != var3[11]) {
         throw new IOException("Checksum error after writing data to Gameband");
      }
   }

   private void a(short[] var1) throws IOException {
      if (var1.length > 2048) {
         throw new IOException("Sanity check: Data length too big: " + var1.length);
      } else {
         for(int var2 = 0; var2 < var1.length; ++var2) {
            if (var1[var2] != (var1[var2] & 16383)) {
               logger.log(Level.WARNING, "Sanity check: Value[" + var2 + "] " + var1[var2] + " is too big.");
               var1[var2] = (short)(var1[var2] & 16383);
            }
         }

      }
   }

   private short[] b(short[] var1) {
      byte[] var2 = a(var1, 12, var1[9]);
      short[] var3 = Utils.a(var2);
      return var3;
   }

   private String formatData(short[] var1) {
      StringBuilder sb = new StringBuilder();
      short[] data = var1;
      int var4 = var1.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         short var6 = data[var5];
         sb.append(String.format("%04x", var6));
         sb.append(' ');
      }

      return sb.toString();
   }

   public String h() {
      StringBuilder var1 = new StringBuilder();
      var1.append('\n');
      var1.append("Timezone 1: " + this.command.a());
      var1.append('\n');
      var1.append("Timezone 2: " + this.command.b());
      var1.append('\n');
      var1.append("Timezone Change: " + this.command.c());
      var1.append('\n');
      var1.append("Orientation: " + this.command.d());
      var1.append('\n');
      var1.append("Transition frame duration: " + this.command.e());
      var1.append('\n');
      var1.append("Number of screens: " + this.command.f());
      var1.append('\n');
      var1.append("Checksum0: " + this.command.g());
      var1.append('\n');
      var1.append("Checksum1: " + this.command.h());
      var1.append('\n');
      Iterator var2 = this.animations.iterator();

      while(var2.hasNext()) {
         Animation var3 = (Animation)var2.next();
         var1.append(var3.c().toString());
      }

      return var1.toString();
   }

   private static void a(GBTime time, short[] var1) {
      time.command = new GbCommand(var1);
      time.animations = new ArrayList();
      int var2 = 12;

      for(int var3 = 0; var3 < var1[8]; ++var3) {
         GamebandScreen var4 = GamebandScreen.a(var1, var2);
         var2 += 6 + var1[var2 + 5];
         switch(var4.getScreenType()) {
         case 0:
         case 1:
            time.animations.add(new q(var4, threadPool));
            time.a(com.nowcomputing.e.c.a(var4.i()));
            break;
         case 2:
         case 3:
            time.animations.add(new b(var4, threadPool));
            time.a(com.nowcomputing.e.c.a(var4.i()));
         case 4:
         case 5:
         case 6:
         case 7:
         case 8:
         case 9:
         case 10:
         case 11:
         case 12:
         case 13:
         case 14:
         case 15:
         case 18:
         case 19:
         case 20:
         case 21:
         case 22:
         case 23:
         case 24:
         case 25:
         case 26:
         case 27:
         case 28:
         case 29:
         case 30:
         case 31:
         case 33:
         default:
            break;
         case 16:
            time.animations.add(new o(var4, threadPool));
            break;
         case 17:
            time.animations.add(new c(var4, threadPool));
            break;
         case 32:
         case 34:
            time.animations.add(new a(var4, threadPool));
         }
      }

   }

   private static byte[] a(short[] var0, int var1, short var2) {
      byte[] var3 = new byte[var2 * 2];
      int var4 = 0;

      for(int var5 = 0; var4 < var2; ++var4) {
         var3[var5] = (byte)(var0[var1 + var4] & 255);
         var3[var5 + 1] = (byte)(var0[var1 + var4] >> 8 & 63);
         var5 += 2;
      }

      return var3;
   }

   public void i() {
      boolean var1 = false;
      Iterator var2 = this.animations.iterator();

      while(var2.hasNext()) {
         Animation var3 = (Animation)var2.next();
         if (var3 instanceof q) {
            var1 = true;
            break;
         }
      }

      if (!var1) {
         this.animations.add(new q(threadPool));
      }

   }

   public void j() {
      boolean var1 = false;
      Iterator var2 = this.animations.iterator();

      while(var2.hasNext()) {
         Animation var3 = (Animation)var2.next();
         if (var3 instanceof b) {
            var1 = true;
            break;
         }
      }

      if (!var1) {
         this.animations.add(new b(threadPool));
      }

   }

   public static int a(DateTimeZone var0) {
      DateTime var1 = new DateTime(var0);
      if (var0.isStandardOffset(var1.getMillis())) {
         int var2 = var0.getOffset(var0.nextTransition(var1.getMillis()));
         return var2 - var0.getStandardOffset(var1.getMillis());
      } else {
         return var0.getOffset(var1) - var0.getStandardOffset(var1.getMillis());
      }
   }

   public boolean k() {
      return this.g;
   }

   public void a(boolean var1) {
      this.g = var1;
   }

   public static ExecutorService getThreadPool() {
      return threadPool;
   }
}
