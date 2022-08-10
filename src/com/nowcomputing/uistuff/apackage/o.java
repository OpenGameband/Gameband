package com.nowcomputing.uistuff.apackage;

import com.nowcomputing.ImageDisplay;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public enum o {
   a,
   b,
   c,
   d;

   public static o a(File var0) {
      try {
         BufferedImage var1 = ImageIO.read(var0);
         if (var1 != null) {
            ImageDisplay var2 = new ImageDisplay();
            if (var2.a(var0.getPath()) == 0) {
               if (var2.a() > 1) {
                  return b;
               }

               return a;
            }

            return c;
         }
      } catch (IOException var3) {
      }

      return d;
   }
}
