package com.nowcomputing.pixelfurnace;

import com.nowcomputing.Image;
import com.nowcomputing.AnimatedImage;

import java.io.IOException;
import java.util.ArrayList;

public class GamebandScreen {
   short[] screenInfo = new short[6];
   short[] imageData;

   public int a() {
      return 6 + this.getDataLength();
   }

   public short[] getScreenInfo() {
      return this.screenInfo;
   }

   public short[] getImageData() {
      return this.imageData;
   }

   public short getScreenType() {
      return this.screenInfo[0];
   }

   public void setScreenType(short screenType) {
      this.screenInfo[0] = screenType;
   }

   public short getPauseMode() {
      return this.screenInfo[1];
   }

   public void setPauseMode(short var1) {
      this.screenInfo[1] = var1;
   }

   public int getPauseDuration() {
      return (int)((float)this.screenInfo[2] * 0.7F);
   }

   public void setPauseDuration(int pauseDuration) {
      this.screenInfo[2] = (short)((int)((float)pauseDuration / 0.7F));
   }

   public short getFrameDuration() {
      return this.screenInfo[3];
   }

   public void c(short var1) {
      this.screenInfo[3] = var1;
   }

   public int h() {
      return (int)(1000.0F / ((float)this.screenInfo[3] * 0.7F));
   }

   public void b(int var1) {
      this.screenInfo[3] = (short)((int)(1000.0F / ((float)var1 * 0.7F)));
   }

   public short i() {
      return this.screenInfo[4];
   }

   public void d(short var1) {
      this.screenInfo[4] = var1;
   }

   public short getDataLength() {
      return this.screenInfo[5];
   }

   public void setDataLength(short dataLength) {
      this.screenInfo[5] = dataLength;
   }

   public Image getScroll() throws IOException {
      if (this.getScreenType() >= 16 && this.getScreenType() <= 31) {
         return a((short[])this.imageData, (int)0, this.getDataLength());
      } else {
         throw new IOException("Screen is not a Scroll");
      }
   }

   public void setImage(Image image) {
      if (image.getWidth() < 20) { // scale image width
         Image scaledImage = new Image(20, 7);
         scaledImage.setImage(image);
         image = scaledImage;
      }

      short[] imageData = imagetoData(image);
      this.setDataLength((short)imageData.length);
      this.imageData = new short[imageData.length];
      System.arraycopy(imageData, 0, this.imageData, 0, imageData.length);
   }

   public AnimatedImage getAnimation() throws IOException {
      if (this.getScreenType() >= 32 && this.getScreenType() <= 47) {
         int frameCount = this.getDataLength() / 10;
         ArrayList<Image> frames = new ArrayList<>(frameCount);

         for(int i = 0; i < frameCount; ++i) {
            frames.add(a(this.imageData, (int)(i * 10), 10));
         }

         return new AnimatedImage(frames, this.h());
      } else {
         throw new IOException("Screen is not an Animation");
      }
   }

   public void fromAnimatedImage(AnimatedImage animatedImage) {
      int frameCount = Math.min(animatedImage.getFrameCount(), 50); // maximum of 50 frames
      int var3 = frameCount * 10; // idk
      this.setDataLength((short)var3);
      this.imageData = new short[var3];

      for(int i = 0; i < frameCount; ++i) {
         short[] imageData = imagetoData(animatedImage.getFrame(i));
         System.arraycopy(imageData, 0, this.imageData, i * 10, 10);
      }

   }

   public static GamebandScreen a(short[] var0, int var1) {
      GamebandScreen var2 = new GamebandScreen();
      System.arraycopy(var0, var1, var2.screenInfo, 0, var2.screenInfo.length);
      var2.imageData = new short[var0[var1 + 6 - 1]];
      System.arraycopy(var0, var1 + 6, var2.imageData, 0, var2.imageData.length);
      return var2;
   }

   static short[] imagetoData(Image image) { // Guessing
      int halfWidth = image.getWidth() / 2;
      short[] imageData = new short[halfWidth];

      for(int i = 0; i < halfWidth; ++i) {
         imageData[i] = a(image, i * 2);
      }

      return imageData;
   }

   private static short a(Image var0, int var1) {
      short shortdingus = 0;

      for(int i = 0; i < 7; ++i) {
         if (var0.getPixel(var1, i)) {
            shortdingus = (short)(shortdingus | 1 << i);
         }

         if (var0.getPixel(var1 + 1, i)) {
            shortdingus = (short)(shortdingus | 1 << i + 7);
         }
      }

      return shortdingus;
   }

   static Image a(short[] var0, int var1, int var2) {
      Image var3 = new Image(var2 * 2, 7);

      for(int var4 = 0; var4 < var2; ++var4) {
         short var5 = var0[var1 + var4];
         a(var3, var5, var4 * 2);
      }

      return var3;
   }

   private static void a(Image var0, short var1, int var2) {
      for(int var3 = 0; var3 < 7; ++var3) {
         var0.setPixel(var2, var3, a(var1, var3));
         var0.setPixel(var2 + 1, var3, a(var1, var3 + 7));
      }

   }

   public static boolean a(short var0, int var1) {
      return (var0 & 1 << var1) != 0;
   }

   public String toString() { // Returns the info about the screen
      StringBuilder sb = new StringBuilder();
      sb.append('\n');
      sb.append("------\n");
      sb.append("Screen\n");
      sb.append("------\n");
      short screenType = this.getScreenType();
      switch(screenType) {
      case 0:
         sb.append("Type: Time (12-hour)\n");
         break;
      case 1:
         sb.append("Type: Time (24-hour)\n");
         break;
      case 2:
         sb.append("Type: Date (MM/DD)\n");
         break;
      case 3: // way to base 2 idiots
         sb.append("Type: Date (DD/MM)\n");
         break;
      case 16:
         sb.append("Type: Scroll\n");
         break;
      case 17:
         sb.append("Type: Freespace\n");
         break;
      case 32:
         sb.append("Type: Animation\n");
         break;
      case 33:
         sb.append("Type: Animation Intro\n");
      }

      if (screenType == 16 || screenType == 2 || screenType == 3) {
         sb.append("Pause mode: " + this.getPauseMode());
         sb.append('\n');
         sb.append("Pause duration: " + this.getPauseDuration());
         sb.append('\n');
      }

      sb.append("Frame duration: " + this.getFrameDuration());
      sb.append('\n');
      sb.append("Data len: " + this.getDataLength());
      sb.append('\n');
      sb.append('\n');
      return sb.toString();
   }
}
