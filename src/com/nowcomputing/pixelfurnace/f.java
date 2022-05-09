package com.nowcomputing.pixelfurnace;

import com.nowcomputing.GamebandConfig;
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

public class f {
   private static final Logger a = Logger.getLogger(Utils.class.getName());
   private p b = new p();
   private List c = new ArrayList();
   private GamebandHID d = new GamebandHID();
   private com.nowcomputing.e.d e;
   private static final ExecutorService f = Executors.newCachedThreadPool();
   private boolean g;

   public f() {
      this.e = com.nowcomputing.e.c.a;
   }

   public short a() {
      return this.b != null ? this.b.d() : 0;
   }

   public void a(short var1) {
      if (this.b != null) {
         this.b.e(var1);
      }

   }

   public void b() {
      DateTimeZone var1 = DateTimeZone.forTimeZone(LocaleUtil.e());
      a.log(Level.FINE, "Setting Gameband timezone to: " + var1);
      long var2 = System.currentTimeMillis();
      int var4 = var1.getStandardOffset(var2) / '\uea60';
      int var5 = a(var1) / '\uea60' + var4;
      if (var1.isStandardOffset(var2)) {
         this.b.c((short)(var4 / 15));
         this.b.d((short)(var5 / 15));
      } else {
         this.b.c((short)(var5 / 15));
         this.b.d((short)(var4 / 15));
      }

      this.b.a(var1.nextTransition(var2) / 1000L);
   }

   public void a(com.nowcomputing.e.d var1) {
      this.e = var1;
      Iterator var2 = this.c.iterator();

      while(var2.hasNext()) {
         g var3 = (g)var2.next();
         if (!(var3 instanceof o)) {
            var3.a(com.nowcomputing.e.c.a(this.e));
         }
      }

   }

   public com.nowcomputing.e.d c() {
      return this.e;
   }

   public List d() {
      return this.c;
   }

   public int e() {
      return 4;
   }

   public void a(List var1) {
      this.c.clear();
      this.c = var1;
      this.b.g((short)this.c.size());
   }

   public void f() throws IOException {
      short[] var1;
      try {
         this.d.a();
         a.log(Level.FINE, "Opened Gameband HID device");
         var1 = this.d.b();
      } catch (IOException var3) {
         throw var3;
      } catch (Throwable var4) {
         a.log(Level.WARNING, "Error reading from Gameband", var4);
         throw var4;
      }

      a.log(Level.FINE, "Read data");
      a.log(Level.FINE, this.c(var1));

      try {
         short[] var2 = this.b(var1);
         if (var2[0] == var1[10] && var2[1] == var1[11]) {
            this.a(var1);
            a(this, var1);
            a.log(Level.FINE, this.h());
         } else {
            a.log(Level.SEVERE, "Error reading from Gameband - incorrect checksum");
            this.b = new p();
         }
      } catch (Exception var5) {
         a.log(Level.SEVERE, "Error reading data Gameband", var5);
         this.b = new p();
      }

   }

   public void g() throws IOException {
      a.log(Level.FINE, "Computer timezone: " + TimeZone.getDefault().getID());
      a.log(Level.FINE, "Computer local time: " + new Date());
      int var1 = (int)((new Date()).getTime() / 1000L);
      a.log(Level.FINE, "Setting Gameband time (UTC) to: " + var1);
      if (!this.d.a(var1)) {
         a.log(Level.WARNING, "Error setting Gameband time!");
      }

      this.b();
      this.b.f((short)47);
      this.b.g((short)this.c.size());
      short[] var2 = this.m();
      short[] var3 = this.b(var2);
      var2[10] = var3[0];
      var2[11] = var3[1];
      a.log(Level.FINE, "Data to write");
      a.log(Level.FINE, this.c(var2));
      a.log(Level.FINE, this.h());

      try {
         this.a(var2);
      } catch (IOException var8) {
         String var5 = this.b.f() + "|";

         g var7;
         for(Iterator var6 = this.c.iterator(); var6.hasNext(); var5 = var5 + var7.e() + ":" + var7.c().a() + ",") {
            var7 = (g)var6.next();
         }

         throw new IOException("Data too big (" + var2.length + ") " + var5);
      }

      this.d.a();
      this.d.a(var2);
      a.log(Level.FINE, "Wrote data to Gameband OK");
      this.a(var3[0], var3[1]);
      a.log(Level.FINE, "Checked written data OK");
      this.a(false);
   }

   private short[] m() {
      int var1 = 0;

      g var3;
      for(Iterator var2 = this.c.iterator(); var2.hasNext(); var1 += var3.c().a()) {
         var3 = (g)var2.next();
      }

      this.b.a(var1);
      short[] var8 = new short[12 + var1];
      System.arraycopy(this.b.a, 0, var8, 0, 12);
      int var9 = 12;
      Iterator var4 = this.c.iterator();

      while(var4.hasNext()) {
         g var5 = (g)var4.next();
         n var6 = var5.c();
         System.arraycopy(var6.b(), 0, var8, var9, 6);
         var9 += 6;
         short[] var7 = var6.c();
         if (var7 != null) {
            System.arraycopy(var6.c(), 0, var8, var9, var6.c().length);
            var9 += var6.c().length;
         }
      }

      return var8;
   }

   private void a(short var1, short var2) throws IOException {
      short[] var3 = this.d.b();
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
               a.log(Level.WARNING, "Sanity check: Value[" + var2 + "] " + var1[var2] + " is too big.");
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

   private String c(short[] var1) {
      StringBuilder var2 = new StringBuilder();
      short[] var3 = var1;
      int var4 = var1.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         short var6 = var3[var5];
         var2.append(String.format("%04x", var6));
         var2.append(' ');
      }

      return var2.toString();
   }

   public String h() {
      StringBuilder var1 = new StringBuilder();
      var1.append('\n');
      var1.append("Timezone 1: " + this.b.a());
      var1.append('\n');
      var1.append("Timezone 2: " + this.b.b());
      var1.append('\n');
      var1.append("Timezone Change: " + this.b.c());
      var1.append('\n');
      var1.append("Orientation: " + this.b.d());
      var1.append('\n');
      var1.append("Transition frame duration: " + this.b.e());
      var1.append('\n');
      var1.append("Number of screens: " + this.b.f());
      var1.append('\n');
      var1.append("Checksum0: " + this.b.g());
      var1.append('\n');
      var1.append("Checksum1: " + this.b.h());
      var1.append('\n');
      Iterator var2 = this.c.iterator();

      while(var2.hasNext()) {
         g var3 = (g)var2.next();
         var1.append(var3.c().m());
      }

      return var1.toString();
   }

   private static void a(f var0, short[] var1) {
      var0.b = new p(var1);
      var0.c = new ArrayList();
      int var2 = 12;

      for(int var3 = 0; var3 < var1[8]; ++var3) {
         n var4 = n.a(var1, var2);
         var2 += 6 + var1[var2 + 5];
         switch(var4.d()) {
         case 0:
         case 1:
            var0.c.add(new q(var4, f));
            var0.a(GamebandConfig.c.a(var4.i()));
            break;
         case 2:
         case 3:
            var0.c.add(new b(var4, f));
            var0.a(GamebandConfig.c.a(var4.i()));
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
            var0.c.add(new o(var4, f));
            break;
         case 17:
            var0.c.add(new c(var4, f));
            break;
         case 32:
         case 34:
            var0.c.add(new a(var4, f));
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
      Iterator var2 = this.c.iterator();

      while(var2.hasNext()) {
         g var3 = (g)var2.next();
         if (var3 instanceof q) {
            var1 = true;
            break;
         }
      }

      if (!var1) {
         this.c.add(new q(f));
      }

   }

   public void j() {
      boolean var1 = false;
      Iterator var2 = this.c.iterator();

      while(var2.hasNext()) {
         g var3 = (g)var2.next();
         if (var3 instanceof b) {
            var1 = true;
            break;
         }
      }

      if (!var1) {
         this.c.add(new b(f));
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

   public static ExecutorService l() {
      return f;
   }
}
