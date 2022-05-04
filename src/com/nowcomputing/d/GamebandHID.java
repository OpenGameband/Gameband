package com.nowcomputing.d;

import com.codeminders.hidapi.HIDDevice;
import com.codeminders.hidapi.HIDDeviceInfo;
import com.codeminders.hidapi.HIDDeviceNotFoundException;
import com.codeminders.hidapi.HIDManager;
import com.nowcomputing.Retrier;
import java.io.IOException;

public class GamebandHID {
   private HIDManager a;
   private HIDDevice b = null;
   private int c;

   public void a() throws IOException {
      if (this.b != null) {
         this.b.close();
      }

      this.a = HIDManager.getInstance();

      try {
         this.b = (HIDDevice)(new Retrier(3, 100)).a(new e(this));
      } catch (Exception var2) {
         this.b = this.a(1240, 63, (String)null);
      }

   }

   private HIDDevice a(int var1, int var2, String var3) throws IOException {
      HIDDeviceInfo[] var4 = this.a.listDevices();
      HIDDeviceInfo[] var5 = var4;
      int var6 = var4.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         HIDDeviceInfo var8 = var5[var7];
         if (var8.getVendor_id() == var1 && var8.getProduct_id() == var2 && (var3 == null || var8.getSerial_number().equals(var3))) {
            this.c = var8.getRelease_number();
            return var8.open();
         }
      }

      throw new HIDDeviceNotFoundException();
   }

   public short[] b() throws IOException {
      short[] var1 = new short[2048];
      short var2 = 6144;

      for(int var3 = 0; var3 < 128; ++var3) {
         short[] var4 = this.b(var2 + var3 * 16);
         System.arraycopy(var4, 0, var1, var3 * 16, 16);
      }

      return var1;
   }

   public boolean a(short[] var1) throws IOException {
      short[] var2 = b(var1);
      int var3 = var2.length;
      this.b(6144, var3);

      try {
         int var4 = 0;

         for(boolean var5 = false; var4 < var2.length; var4 += 16) {
            this.a(6144 + var4, var2, var4);
            short[] var6 = this.b(6144 + var4);
            if (!a(var6, var2, var4, 16)) {
               throw new IOException("Error checking written data");
            }
         }
      } finally {
         this.c();
      }

      return true;
   }

   public static boolean a(short[] var0, short[] var1, int var2, int var3) {
      if (var0 == var1) {
         return true;
      } else if (var0 != null && var1 != null) {
         int var4 = var3;

         for(int var5 = 0; var5 < var4; ++var5) {
            if (var5 > var2 + var3) {
               return false;
            }

            if (var0[var5] != var1[var5 + var2]) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean a(int var1) throws IOException {
      byte[] var2 = new byte[9];
      var2[0] = 0;
      var2[1] = 2;
      b(var2, 5, var1);
      byte[] var3 = new byte[2];
      return this.a(var2, var3, 3);
   }

   private void b(int var1, int var2) throws IOException {
      byte[] var3 = new byte[7];
      var3[0] = 0;
      var3[1] = 4;
      a(var3, 3, var1);
      a(var3, 5, var2);
      this.b(var3, 5);
   }

   private void c() throws IOException {
      byte[] var1 = new byte[]{0, 10, 0};
      this.b(var1, 11);
   }

   private void a(int var1, short[] var2, int var3) throws IOException {
      this.a(var1, var2, var3, 16);
   }

   private void a(int var1, short[] var2, int var3, int var4) throws IOException{
      if (var2.length < var3 + var4) {
         throw new IOException("Error. Each data write must be of " + var4 + " words)");
      } else {
         byte[] var5 = new byte[37];
         var5[0] = 0;
         var5[1] = 6;
         a(var5, 3, var1);
         int var6 = 0;

         for(int var7 = 0; var7 < var4; ++var7) {
            a(var5, var6 + 5, var2[var3 + var7]);
            var6 += 2;
         }

         this.b(var5, 7);
      }
   }

   private short[] b(int var1) throws IOException {
      byte[] var2 = new byte[]{0, 8, 0, 0, 0};
      a(var2, 3, var1);
      short[] var3 = new short[16];
      byte[] var4 = new byte[34];
      if (this.a(var2, var4, 9)) {
         for(int var5 = 0; var5 < 16; ++var5) {
            var3[var5] = a(var4, var5 * 2 + 2);
         }
      }

      return var3;
   }

   private void b(byte[] var1, int var2) throws IOException {
      byte[] var3 = new byte[2];
      if (!this.a(var1, var3, var2)) {
         throw new IOException("Error sending command to Gameband");
      }
   }

   private boolean a(byte[] var1, byte[] var2, int var3) throws IOException {
      this.b.write(var1);
      this.b.enableBlocking();
      byte[] var4 = new byte[64];
      int var5 = this.b.readTimeout(var4, 5000);
      if (var5 <= 0) {
         return false;
      } else {
         try {
            Thread.sleep(1L);
         } catch (InterruptedException var7) {
         }

         System.arraycopy(var4, 0, var2, 0, var2.length);
         if (var2[0] != var3) {
            return false;
         } else {
            return var2[1] == 0;
         }
      }
   }

   static short[] b(short[] var0) {
      int var1 = a(var0.length, 32);
      short[] var2 = new short[var1];
      System.arraycopy(var0, 0, var2, 0, var0.length);
      return var2;
   }

   static void a(byte[] var0, int var1, int var2) {
      var0[var1] = (byte)var2;
      var0[var1 + 1] = (byte)(var2 >>> 8);
   }

   static void b(byte[] var0, int var1, int var2) {
      var0[var1] = (byte)var2;
      var0[var1 + 1] = (byte)(var2 >>> 8);
      var0[var1 + 2] = (byte)(var2 >>> 16);
      var0[var1 + 3] = (byte)(var2 >>> 24);
   }

   static short a(byte[] var0, int var1) {
      short var2 = (short)(var0[var1] & 255 | var0[var1 + 1] << 8);
      return var2;
   }

   static int a(int var0, int var1) {
      return (int)(Math.ceil((double)var0 / (double)var1) * (double)var1);
   }

   // $FF: synthetic method
   static HIDDevice a(GamebandHID var0, int var1, int var2, String var3) throws IOException {
      return var0.a(var1, var2, var3);
   }
}
