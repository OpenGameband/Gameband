package com.nowcomputing.pixelfurnace;

import com.codeminders.hidapi.HIDDevice;
import com.codeminders.hidapi.HIDDeviceInfo;
import com.codeminders.hidapi.HIDDeviceNotFoundException;
import com.codeminders.hidapi.HIDManager;
import com.nowcomputing.Retrier;
import java.io.IOException;

public class GamebandHID {
   private HIDManager hidManager;
   private HIDDevice gamebandHIDDevice = null;

   public void open() throws IOException {
      if (this.gamebandHIDDevice != null) {
         this.gamebandHIDDevice.close();
      }

      this.hidManager = HIDManager.getInstance();

      try {
         this.gamebandHIDDevice = (HIDDevice)(new Retrier(3, 100)).a(new HandyDandyGamebandOpenyThingy(this));
      } catch (Exception var2) {
         this.gamebandHIDDevice = this.open(1240, 63, (String)null);
      }

   }

   private HIDDevice open(int vid, int pid, String serial) throws IOException {
      HIDDeviceInfo[] devices = this.hidManager.listDevices();
      HIDDeviceInfo[] devices1 = devices; // i'm not sure why we're doubling our ram usage here
      int devicesLen = devices.length;

      for(int i = 0; i < devicesLen; ++i) {
         HIDDeviceInfo deviceInfo = devices1[i];
         if (deviceInfo.getVendor_id() == vid && deviceInfo.getProduct_id() == pid && (serial == null || deviceInfo.getSerial_number().equals(serial))) {
            int releaseNumber = deviceInfo.getRelease_number();
            return deviceInfo.open();
         }
      }

      throw new HIDDeviceNotFoundException();
   }

   public short[] readGameband() throws IOException { // wild guess on the name here
      short[] buf = new short[2048]; // response from gameband
      short offset = 6144; // this is probably a command

      for(int i = 0; i < 128; ++i) {
         short[] resp = this.readChunk(offset + i * 16);
         System.arraycopy(resp, 0, buf, i * 16, 16);
      }

      return buf;
   }

   public boolean a(short[] var1) throws IOException {
      short[] var2 = someFormattingBollocks(var1);
      int var3 = var2.length;
      this.setGBValue(6144, var3);

      try {
         int var4 = 0;

         for(boolean var5 = false; var4 < var2.length; var4 += 16) { // what the assmunching fuck is this for loop
            this.writeWithData(6144 + var4, var2, var4);
            short[] var6 = this.readChunk(6144 + var4);
            if (!compareResponse(var6, var2, var4, 16)) {
               throw new IOException("Error checking written data");
            }
         }
      } finally {
         this.sendDoneCommand();
      }

      return true;
   }

   public static boolean compareResponse(short[] arr1, short[] arr2, int var2, int var3) {
      if (arr1 == arr2) {
         return true;
      } else if (arr1 != null && arr2 != null) {
         int var4 = var3;

         for(int i = 0; i < var4; ++i) {
            if (i > var2 + var3) {
               return false;
            }

            if (arr1[i] != arr2[i + var2]) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean setTime(int var1) throws IOException {
      byte[] var2 = new byte[9];
      var2[0] = 0;
      var2[1] = 2;
      funnyThingsInvolvingPowersOf2(var2, 5, var1);
      byte[] var3 = new byte[2];
      return this.writeToGameband(var2, var3, 3);
   }

   private void setGBValue(int var1, int var2) throws IOException { // again, wild guessing
      byte[] var3 = new byte[7];
      var3[0] = 0;
      var3[1] = 4;
      buildCommandFromCode(var3, 3, var1);
      buildCommandFromCode(var3, 5, var2);
      this.write(var3, 5);
   }

   private void sendDoneCommand() throws IOException { // I think the gameband works on a kind of session
      byte[] var1 = new byte[]{0, 10, 0};
      this.write(var1, 11);
   }

   private void writeWithData(int commandCode, short[] data, int offset) throws IOException {
      this.writeWithData(commandCode, data, offset, 16);
   }

   private void writeWithData(int commandCode, short[] data, int offset, int dataSize) throws IOException{
      if (data.length < offset + dataSize) {
         throw new IOException("Error. Each data write must be of " + dataSize + " words)");
      } else {
         byte[] inputMysteryBuf = new byte[37];
         inputMysteryBuf[0] = 0;
         inputMysteryBuf[1] = 6;
         buildCommandFromCode(inputMysteryBuf, 3, commandCode);
         int funnyNumber = 0;

         for(int i = 0; i < dataSize; ++i) {
            buildCommandFromCode(inputMysteryBuf, funnyNumber + 5, data[offset + i]);
            funnyNumber += 2;
         }

         this.write(inputMysteryBuf, 7);
      }
   }

   /**
    * I honestly have no fucking clue
    * @param offset i'm making a wild fucking guess here
    * @return the response from the gameband
    * @throws IOException (probably)
    */
   private short[] readChunk(int offset) throws IOException {
      byte[] bytes = new byte[]{0, 8, 0, 0, 0}; // command (I think)
      buildCommandFromCode(bytes, 3, offset);
      short[] buf = new short[16];
      byte[] resp = new byte[34];
      if (this.writeToGameband(bytes, resp, 9)) { // nine is important probably, maybe it's a status code
         for(int i = 0; i < 16; ++i) {
            buf[i] = a(resp, i * 2 + 2);
         }
      }

      return buf;
   }

   private void write(byte[] data, int check) throws IOException {
      byte[] buf = new byte[2]; // (doesn't give a shit)
      if (!this.writeToGameband(data, buf, check)) {
         throw new IOException("Error sending command to Gameband");
      }
   }

   /**
    *
    * @param data the data to send to gameband
    * @param buf output buffer for response
    * @param check Expected status code
    * @return true if all good false if gameband says no
    * @throws IOException if kaboom
    */
   private boolean writeToGameband(byte[] data, byte[] buf, int check) throws IOException {
      this.gamebandHIDDevice.write(data);
      this.gamebandHIDDevice.enableBlocking();
      byte[] resp = new byte[64];
      int status = this.gamebandHIDDevice.readTimeout(resp, 5000); // this smacks of C code
      if (status <= 0) {
         return false;
      } else {
         try {
            Thread.sleep(1L); // why is this a long
         } catch (InterruptedException e) { // fucking classic, unhandled exception
         }

         System.arraycopy(resp, 0, buf, 0, buf.length); // get only the parts of the response you give a shit about
         if (buf[0] != check) {
            return false;
         } else {
            return buf[1] == 0;
         }
      }
   }

   static short[] someFormattingBollocks(short[] var0) {
      int var1 = CeilDeezNuts(var0.length, 32);
      short[] var2 = new short[var1];
      System.arraycopy(var0, 0, var2, 0, var0.length);
      return var2;
   }

   static void buildCommandFromCode(byte[] bytes, int index, int val) {
      bytes[index] = (byte)val;
      bytes[index + 1] = (byte)(val >>> 8);
   }

   static void funnyThingsInvolvingPowersOf2(byte[] var0, int var1, int var2) {
      var0[var1] = (byte)var2;
      var0[var1 + 1] = (byte)(var2 >>> 8);
      var0[var1 + 2] = (byte)(var2 >>> 16);
      var0[var1 + 3] = (byte)(var2 >>> 24);
   }

   static short a(byte[] var0, int var1) { // TODO: ask someone with a clue how this works ???
      short var2 = (short)(var0[var1] & 255 | var0[var1 + 1] << 8);
      return var2;
   }

   static int CeilDeezNuts(int var0, int var1) {
      return (int)(Math.ceil((double)var0 / (double)var1) * (double)var1);
   }

   // $FF: synthetic method
   static HIDDevice OpenRandomHid(GamebandHID gbHid, int vid, int pid, String serial) throws IOException {
      return gbHid.open(vid, pid, serial);
   }
}
