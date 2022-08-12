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

import com.nowcomputing.e.Transition;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class GBComms {
   private static final Logger logger = Logger.getLogger(Utils.class.getName());
   private GbData data = new GbData();
   private List<Animation> animations = new ArrayList<>();
   private GamebandHID gbHID = new GamebandHID();
   private Transition transition;
   private static final ExecutorService threadPool = Executors.newCachedThreadPool();
   private boolean g;

   public GBComms() {
      this.transition = com.nowcomputing.e.c.DEFAULT_TRANSITION;
   }

   public short getOrientation() {
      return this.data != null ? this.data.d() : 0;
   }

   public void setOrientation(short var1) {
      if (this.data != null) {
         this.data.setSixthBit(var1);
      }

   }

   public void setGamebandTimezone() {
      DateTimeZone timeZone                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    = DateTimeZone.forTimeZone(LocaleUtil.e());
      logger.log(Level.FINE, "Setting Gameband timezone to: " + timeZone);
      long currentTime = System.currentTimeMillis();
      int timeInMinutes = timeZone.getStandardOffset(currentTime) / '\uea60'; // so fucking dumb, \uea60 is just 60000, TODO: unfuck this
      int var5 = ConvertLocalToUTC(timeZone) / '\uea60' + timeInMinutes;
      if (timeZone.isStandardOffset(currentTime)) {
         this.data.c((short)(timeInMinutes / 15));
         this.data.d((short)(var5 / 15));
      } else {
         this.data.c((short)(var5 / 15));
         this.data.d((short)(timeInMinutes / 15));
      }

      this.data.a(timeZone.nextTransition(currentTime) / 1000L);
   }

   public void a(Transition var1) {
      this.transition = var1;
      Iterator var2 = this.animations.iterator();

      while(var2.hasNext()) {
         Animation var3 = (Animation)var2.next();
         if (!(var3 instanceof ImageAnimation)) {
            var3.a(com.nowcomputing.e.c.animateRight(this.transition));
         }
      }

   }

   public Transition c() {
      return this.transition;
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
      this.data.g((short)this.animations.size());
   }

   public void ReadData() throws IOException {
      short[] data;
      try {
         this.gbHID.open();
         logger.log(Level.FINE, "Opened Gameband HID device");
         data = this.gbHID.readGameband();
      } catch (IOException e) {
         throw e;
      } catch (Throwable e) {
         logger.log(Level.WARNING, "Error reading from Gameband", e);
         throw e;
      }

      logger.log(Level.FINE, "Read data");
      logger.log(Level.FINE, this.formatData(data));

      try {
         short[] var2 = this.b(data);
         if (var2[0] == data[10] && var2[1] == data[11]) {
            this.a(data);
            a(this, data);
            logger.log(Level.FINE, this.h());
         } else {
            logger.log(Level.SEVERE, "Error reading from Gameband - incorrect checksum");
            this.data = new GbData();
         }
      } catch (Exception var5) {
         logger.log(Level.SEVERE, "Error reading data Gameband", var5);
         this.data = new GbData();
      }

   }

   public void setGamebandTime() throws IOException {
      logger.log(Level.FINE, "Computer timezone: " + TimeZone.getDefault().getID());
      logger.log(Level.FINE, "Computer local time: " + new Date());
      int seconds = (int)((new Date()).getTime() / 1000L);
      logger.log(Level.FINE, "Setting Gameband time (UTC) to: " + seconds);
      if (!this.gbHID.setTime(seconds)) {
         logger.log(Level.WARNING, "Error setting Gameband time!");
      }

      this.setGamebandTimezone();
      this.data.f((short)47);
      this.data.g((short)this.animations.size());
      short[] var2 = this.GetAnimationsAsData();
      short[] var3 = this.b(var2);
      var2[10] = var3[0];
      var2[11] = var3[1];
      logger.log(Level.FINE, "Data to write");
      logger.log(Level.FINE, this.formatData(var2));
      logger.log(Level.FINE, this.h());

      try {
         this.a(var2);
      } catch (IOException var8) {
         String var5 = this.data.f() + "|";

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

   private short[] GetAnimationsAsData() {
      int var1 = 0;

      Animation var3;
      for(Iterator var2 = this.animations.iterator(); var2.hasNext(); var1 += var3.c().a()) {
         var3 = (Animation)var2.next();
      }

      this.data.a(var1);
      short[] var8 = new short[12 + var1];
      System.arraycopy(this.data.a, 0, var8, 0, 12);
      int var9 = 12;

      for (Animation animation : this.animations) {

         GamebandScreen screen = animation.c();
         System.arraycopy(screen.getScreenInfo(), 0, var8, var9, 6);
         var9 += 6;
         short[] var7 = screen.getImageData();
         if (var7 != null) {
            System.arraycopy(screen.getImageData(), 0, var8, var9, screen.getImageData().length);
            var9 += screen.getImageData().length;
         }
      }

      return var8;
   }

   private void a(short var1, short var2) throws IOException {
      short[] var3 = this.gbHID.readGameband();
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
      var1.append("Timezone 1: " + this.data.a());
      var1.append('\n');
      var1.append("Timezone 2: " + this.data.b());
      var1.append('\n');
      var1.append("Timezone Change: " + this.data.c());
      var1.append('\n');
      var1.append("Orientation: " + this.data.d());
      var1.append('\n');
      var1.append("Transition frame duration: " + this.data.e());
      var1.append('\n');
      var1.append("Number of screens: " + this.data.f());
      var1.append('\n');
      var1.append("Checksum0: " + this.data.g());
      var1.append('\n');
      var1.append("Checksum1: " + this.data.h());
      var1.append('\n');
      Iterator var2 = this.animations.iterator();

      while(var2.hasNext()) {
         Animation var3 = (Animation)var2.next();
         var1.append(var3.c().toString());
      }

      return var1.toString();
   }

   private static void a(GBComms time, short[] var1) {
      time.data = new GbData(var1);
      time.animations = new ArrayList();
      int var2 = 12;

      for(int var3 = 0; var3 < var1[8]; ++var3) {
         GamebandScreen var4 = GamebandScreen.a(var1, var2);
         var2 += 6 + var1[var2 + 5];
         switch(var4.getScreenType()) {
         case 0:
         case 1:
            time.animations.add(new TimeAnimation(var4, threadPool));
            time.a(com.nowcomputing.e.c.getTransition(var4.i()));
            break;
         case 2:
         case 3:
            time.animations.add(new DateScreen(var4, threadPool));
            time.a(com.nowcomputing.e.c.getTransition(var4.i()));
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
            time.animations.add(new ImageAnimation(var4, threadPool));
            break;
         case 17:
            time.animations.add(new FreeSpaceAnimation(var4, threadPool));
            break;
         case 32:
         case 34:
            time.animations.add(new RawAnimation(var4, threadPool));
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
         if (var3 instanceof TimeAnimation) {
            var1 = true;
            break;
         }
      }

      if (!var1) {
         this.animations.add(new TimeAnimation(threadPool));
      }

   }

   public void j() {
      boolean var1 = false;

      for(Animation animation : animations) {
         if (animation instanceof DateScreen) {
            var1 = true;
            break;
         }
      }

      if (!var1) {
         this.animations.add(new DateScreen(threadPool));
      }

   }

   public static int ConvertLocalToUTC(DateTimeZone timeZone) { // (I think)
      DateTime dateTime = new DateTime(timeZone);
      if (timeZone.isStandardOffset(dateTime.getMillis())) { // is DST
         int var2 = timeZone.getOffset(timeZone.nextTransition(dateTime.getMillis()));
         return var2 - timeZone.getStandardOffset(dateTime.getMillis());
      } else {
         return timeZone.getOffset(dateTime) - timeZone.getStandardOffset(dateTime.getMillis());
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
