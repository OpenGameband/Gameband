package com.nowcomputing.f;

import com.nowcomputing.GamebandConfig;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.geom.Point2D.Float;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class h {
   private static final Color v = new Color(211, 211, 211);
   private static final Color w = new Color(68, 68, 68);
   private static final Color x = new Color(211, 211, 211);
   private static final Color y;
   private static final float[] z;
   private static final Color A;
   private static final Color B;
   private static final Color C;
   private static final Color D;
   private static final Color E;
   private static final Color F;
   private static final float[] G;
   private static final Color[] H;
   private static final Color I;
   private static final Color J;
   private static final Color K;
   private static final Color L;
   private static final Color M;
   private static final Color N;
   private static final float[] O;
   private static final Color[] P;
   public static final Color a;
   public static final Color b;
   private static Properties Q;
   private static Map R;
   private static Map S;
   private static Map T;
   private static Map U;
   private static ImageIcon V;
   public static final Color c;
   public static final Color d;
   public static final Color e;
   public static final Color f;
   public static final Color g;
   public static final Color h;
   public static final Color i;
   public static final Color j;
   public static final Color k;
   public static final Color l;
   public static final Color m;
   public static final Color n;
   public static final Color o;
   public static final Color p;
   public static final Color q;
   public static final Color r;
   public static final Color s;
   public static final Color t;
   public static final Color u;

   public static Color a() {
      return b("skin.led");
   }

   public static Color b() {
      return b("skin.text");
   }

   public static Color c() {
      return b("skin.button.bg");
   }

   public static Color d() {
      return b("skin.button.fg");
   }

   public static Color e() {
      return b("skin.highlight.button.bg");
   }

   public static Color f() {
      return b("skin.highlight.button.fg");
   }

   public static BufferedImage a(boolean var0) {
      String var1 = var0 ? "/resources/previewbg_left.jpg" : "/resources/previewbg_right.jpg";
      if ("diamond".equals(h())) {
         var1 = var0 ? "/resources/previewbg_left_diamond.png" : "/resources/previewbg_right_diamond.png";
      }

      return ImageIO.read(h.class.getResource(var1));
   }

   public static void a(BufferedImage var0, Color var1) {
      Graphics2D var2 = var0.createGraphics();
      var2.setColor(var1);
      var2.setComposite(AlphaComposite.SrcAtop);
      var2.fillRect(0, 0, var0.getWidth(), var0.getHeight());
   }

   public static BufferedImage a(String var0) {
      BufferedImage var1 = ImageIO.read(h.class.getResourceAsStream(var0));
      a(var1, e());
      return var1;
   }

   public static Icon a(int var0, int var1) {
      if (V == null) {
         BufferedImage var2 = new BufferedImage(var0, var1, 2);
         Graphics2D var3 = var2.createGraphics();
         Float var4 = new Float(0.0F, 0.0F);
         Float var5 = new Float((float)(var0 - 1), (float)var1);
         float[] var6 = m();
         Color[] var7 = l();
         if (var6.length != var7.length) {
            var6 = G;
            var7 = H;
         }

         var3.setPaint(new LinearGradientPaint(var4, var5, var6, var7));
         var3.fillRect(0, 0, var0, var1);
         V = new ImageIcon(var2);
      }

      return V;
   }

   private static Color b(String var0) {
      if (S == null) {
         g();
      }

      return (Color)S.get(var0);
   }

   private static void g() {
      i();
      S = new HashMap();
      a("skin.led", c("skin.led"));
      a("skin.text", c("skin.text"));
      a("skin.button.bg", c("skin.button.bg"));
      a("skin.button.fg", c("skin.button.fg"));
      a("skin.highlight.button.bg", c("skin.highlight.button.bg"));
      a("skin.highlight.button.fg", c("skin.highlight.button.fg"));
      T = new HashMap();
      T.put("redstone", a(n(), G));
      T.put("diamond", a(n(), O));
      U = new HashMap();
      U.put("redstone", a(n(), H));
      U.put("diamond", a(n(), P));
   }

   private static Color c(String var0) {
      Map var1 = (Map)R.get(h());
      if (var1 == null) {
         var1 = (Map)R.get("redstone");
      }

      return (Color)var1.get(var0);
   }

   private static String h() {
      return n().getProperty("skin", "redstone");
   }

   private static void i() {
      R = new HashMap();
      R.put("redstone", j());
      R.put("diamond", k());
   }

   private static HashMap j() {
      HashMap var0 = new HashMap();
      var0.put("skin.led", A);
      var0.put("skin.text", B);
      var0.put("skin.button.bg", C);
      var0.put("skin.button.fg", D);
      var0.put("skin.highlight.button.bg", E);
      var0.put("skin.highlight.button.fg", F);
      return var0;
   }

   private static HashMap k() {
      HashMap var0 = new HashMap();
      var0.put("skin.led", I);
      var0.put("skin.text", J);
      var0.put("skin.button.bg", K);
      var0.put("skin.button.fg", L);
      var0.put("skin.highlight.button.bg", M);
      var0.put("skin.highlight.button.fg", N);
      return var0;
   }

   private static void a(String var0, Color var1) {
      S.put(var0, a(n(), var0, var1));
   }

   private static Color a(Properties var0, String var1, Color var2) {
      String var3 = var0.getProperty(var1, "");
      return !var3.isEmpty() ? Color.decode(var3) : var2;
   }

   private static Color[] l() {
      return (Color[])U.get(h());
   }

   private static float[] m() {
      return (float[])T.get(h());
   }

   private static Properties n() {
      if (Q == null) {
         Q = new Properties();

         try {
            Q.load(new FileInputStream(GamebandConfig.defaultConfigFile));
         } catch (IOException var1) {
         }
      }

      return Q;
   }

   private static Color[] a(Properties var0, Color[] var1) {
      try {
         String var2 = var0.getProperty("skin.header.colors", "");
         if (!var2.isEmpty()) {
            String[] var3 = var2.split(",");
            Color[] var4 = new Color[var3.length];

            for(int var5 = 0; var5 < var3.length; ++var5) {
               var4[var5] = Color.decode(var3[var5]);
            }

            return var4;
         }
      } catch (NumberFormatException var6) {
      }

      return var1;
   }

   private static float[] a(Properties var0, float[] var1) {
      try {
         String var2 = var0.getProperty("skin.header.dist", "");
         if (!var2.isEmpty()) {
            String[] var3 = var2.split(",");
            float[] var4 = new float[var3.length];

            for(int var5 = 0; var5 < var3.length; ++var5) {
               var4[var5] = java.lang.Float.parseFloat(var3[var5]);
            }

            return var4;
         }
      } catch (NumberFormatException var6) {
      }

      return var1;
   }

   static {
      y = Color.WHITE;
      z = new float[]{0.0F, 0.5F, 1.0F};
      A = new Color(188, 0, 0);
      B = v;
      C = w;
      D = x;
      E = A;
      F = y;
      G = z;
      H = new Color[]{new Color(127, 35, 0), new Color(188, 0, 0), new Color(127, 35, 0)};
      I = new Color(43, 173, 148);
      J = v;
      K = w;
      L = x;
      M = I;
      N = y;
      O = z;
      P = new Color[]{new Color(17, 138, 135), new Color(51, 235, 203), new Color(17, 138, 135)};
      a = new Color(35, 35, 35);
      b = new Color(45, 45, 45);
      c = new Color(234, 237, 241);
      d = new Color(98, 98, 98);
      e = new Color(83, 83, 83);
      f = new Color(64, 64, 64);
      g = new Color(25, 25, 25);
      h = new Color(87, 87, 85);
      i = c;
      j = c;
      k = f;
      l = h;
      m = Color.WHITE;
      n = g;
      o = g;
      p = f;
      q = h;
      r = f;
      s = Color.WHITE;
      t = new Color(255, 45, 38);
      u = new Color(243, 172, 17);
   }
}
