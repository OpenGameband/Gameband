package com.nowcomputing.uistuff;

import com.nowcomputing.LocaleUtil;
import com.nowcomputing.Utils;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class q {
   public static final Logger a = Logger.getLogger(Utils.class.getName());
   private static String[] D = new String[]{"en", "es", "fr", "de", "it", "pt"};
   private static boolean E = false;
   private static boolean F = false;
   public static final Font b = new Font("SanSerif", 0, 16);
   public static final Font c = new Font("SanSerif", 0, 14);
   public static Font d;
   public static Font e;
   public static Font f;
   public static Font g;
   public static Font h;
   public static Font i;
   public static Font j;
   public static Font k;
   public static Font l;
   public static Font m;
   public static Font n;
   public static Font o;
   public static Font p;
   public static Font q;
   public static Font r;
   public static Font s;
   public static Font t;
   public static Font u;
   public static Font v;
   public static Font w;
   public static Font x;
   public static Font y;
   public static Font z;
   public static Font A;
   public static Font B;
   public static Font C;

   public static Font a(int var0, int var1) {
      String var2 = LocaleUtil.a().getLanguage();
      if (var2.equals("ja")) {
         if (!F) {
            a(".lib/osaka.unicode.ttf");
            F = true;
         }

         return new Font("osaka_unicode", 0, var1);
      } else if (a(D, var2)) {
         if (!E) {
            a("/resources/Gotham-Book.otf");
            E = true;
         }

         return new Font("Gotham Book", var0, var1);
      } else {
         return new Font("SanSerif", 0, var1 - 2);
      }
   }

   public static void a(String var0) {
      Object var1 = null;

      try {
         File var2 = new File(var0);
         if (var2.exists()) {
            var1 = new FileInputStream(var2);
         } else {
            var1 = q.class.getResourceAsStream(var0);
         }

         Font var3 = Font.createFont(0, (InputStream)var1);
         GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(var3);
         a.log(Level.FINER, "Loaded font " + var0);
      } catch (FontFormatException var14) {
         a.log(Level.WARNING, "Error loading font", var14);
      } catch (IOException var15) {
         a.log(Level.WARNING, "Error loading font", var15);
      } finally {
         try {
            if (var1 != null) {
               ((InputStream)var1).close();
            }
         } catch (IOException var13) {
         }

      }

   }

   private static boolean a(String[] var0, String var1) {
      String[] var2 = var0;
      int var3 = var0.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String var5 = var2[var4];
         if (var5.equals(var1)) {
            return true;
         }
      }

      return false;
   }

   private static void b() {
      d = a(0, 17);
      e = a(0, 16);
      f = a(0, 14);
      g = a(0, 12);
      h = a(0, 10);
      i = a(0, 26);
      j = d;
      k = e;
      l = a(1, 16);
      m = a(2, 14);
      n = f;
      o = g;
      p = e;
      q = g;
      r = g;
      s = g;
      t = e;
      u = f;
      v = f;
      w = e;
      x = f;
      y = e;
      z = h;
      A = f;
      B = g;
      C = f;
   }

   // $FF: synthetic method
   static void a() {
      b();
   }

   static {
      LocaleUtil.a((com.nowcomputing.t)(new r()));
      b();
   }
}
