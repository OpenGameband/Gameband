package com.nowcomputing;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * called com.nowcomputing.d
 */
public class Image {
   boolean[][] imageData;
   private int width;
   private int height;

   public Image(int var1, int var2) {
      this.width = var1;
      this.height = var2;
      this.imageData = new boolean[this.width][this.height];
   }

   public Image(Image var1) {
      this.width = var1.getWidth();
      this.height = var1.getHeight();
      this.imageData = new boolean[this.width][this.height];

      for(int i = 0; i < this.height; ++i) {
         for(int var3 = 0; var3 < this.width; ++var3) {
            this.imageData[var3][i] = var1.imageData[var3][i];
         }
      }

   }

   public void setPixel(int x, int y, boolean pixelValue) {
      if (x >= 0 && x < this.width && y >= 0 && y < this.height) {
         this.imageData[x][y] = pixelValue;
      }

   }

   public boolean getPixel(int x, int y) { // this kinda jank
      return x >= 0 && x < this.width && y >= 0 && y < this.height && this.imageData[x][y];
   }

   public int getWidth() {
      return this.width;
   }

   public int getHeight() {
      return this.height;
   }

   public void setImage(Image var1) {
      this.ramImageInForcefully((Image)var1, 0, 0);
   }

   public void ramImageInForcefully(Image image, int var2, int var3) {
      this.gentlyCoerceImageIntoHole(image, 0, 0, image.getWidth(), image.getHeight(), var2, var3);
   }

   public void ramImageIn(Image image, int var2, int var3, int var4, int var5) {
      this.gentlyCoerceImageIntoHole(image, 0, 0, var2, var3, var4, var5);
   }

   public void gentlyCoerceImageIntoHole(Image image, int x, int y, int startX, int startY, int endX, int endY) { // this is probably right
      for(int iX = 0; iX < startX; ++iX) {
         for(int iY = 0; iY < startY; ++iY) {
            this.setPixel(iX + endX, iY + endY, image.getPixel(iX + x, iY + y));
         }
      }

   }

   public void invertImage() {
      this.invertPart(0, 0, this.width, this.height);
   }

   public void invertPart(int var1, int var2, int var3, int var4) {
      for(int iY = var2; iY < var4; ++iY) {
         for(int iX = var1; iX < var3; ++iX) {
            this.setPixel(iX, iY, !this.getPixel(iX, iY));
         }
      }

   }

   public BufferedImage ToBufferedImage() {
      BufferedImage var1 = new BufferedImage(this.width, this.height, 2);

      for(int var2 = 0; var2 < this.height; ++var2) {
         for(int var3 = 0; var3 < this.width; ++var3) {
            var1.setRGB(var3, var2, this.getPixel(var3, var2) ? Color.WHITE.getRGB() : Color.BLACK.getRGB());
         }
      }

      return var1;
   }

   public static Image FromFile(String path) {
      return FromBufferedImage(o.b(path));
   }

   public static Image FromBufferedImage(BufferedImage image) {
      return FromBufferedImage(image, image.getWidth(), image.getHeight());
   }

   public static Image FromBufferedImage(BufferedImage image, int width, int height) {
      Image outImage = new Image(width, height);
      int outWidth = image.getWidth();
      int outHeight = image.getHeight();

      for(int iH = 0; iH < outHeight; ++iH) {
         for(int iW = 0; iW < outWidth; ++iW) {
            int RGBPixel = image.getRGB(iW, iH);
            outImage.setPixel(iW, iH, RGBPixel != Color.BLACK.getRGB());
         }
      }

      return outImage;
   }
}
