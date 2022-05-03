package com.nowcomputing;

import java.io.File;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

public class f {
   public static final Logger a = Logger.getLogger(Utils.class.getName());
   private static final File f = new File(D.b(), "locale");
   private static final File g = new File(D.b(), "tz");
   private static final File h = new File(D.b(), "tzone");
   static ResourceBundle b = null;
   static Locale c = null;
   static ArrayList d = new ArrayList();
   static TimeZone e = null;
   private static DateFormat i;
   private static DateFormat j;
   private static ClassLoader k;

   private static void f() {
      Object var0 = null;
      if (f.exists()) {
         var0 = Utils.h(f);
      }

      if (var0 != null && var0 instanceof Locale) {
         c = (Locale)var0;
      } else {
         c = Locale.getDefault();
      }

      b();
      g();
   }

   private static void g() {
      if (g.exists()) {
         a(g);
         g.delete();
      } else {
         a(h);
      }

   }

   private static void a(File var0) {
      Object var1 = null;
      if (var0.exists()) {
         var1 = Utils.h(var0);
      }

      if (var1 != null && var1 instanceof TimeZone) {
         e = (TimeZone)var1;
         a.log(Level.FINE, "Read stored timezone: " + e);
      } else {
         e = TimeZone.getDefault();
         a.log(Level.FINE, "No stored timezone, default = " + e);
      }

   }

   public static String a(String var0) {
      String var1;
      try {
         ResourceBundle var2 = c();
         var1 = var2 != null ? var2.getString(var0) : var0;
         var1 = new String(var1.getBytes("ISO-8859-1"), "UTF-8");
      } catch (Throwable var3) {
         var1 = var0;
      }

      return var1;
   }

   public static Locale a() {
      if (c == null) {
         f();
      }

      return c;
   }

   public static void a(Locale var0) {
      try {
         c = var0;
         b();
         ResourceBundle.clearCache();
         ClassLoader var1 = Utils.a(D.b().getPath());
         b = ResourceBundle.getBundle("translations", a(), var1);
         Iterator var2 = d.iterator();

         while(var2.hasNext()) {
            t var3 = (t)var2.next();
            var3.c();
         }

         Utils.writeLocaleFile((Object)c, (File)f);
      } catch (Exception var4) {
         a.log(Level.FINE, "Error setting locale " + var0.getDisplayName(), var4);
      }

   }

   public static void b() {
      i = DateFormat.getDateTimeInstance(2, 3, c);
      j = DateFormat.getDateInstance(2, c);
   }

   public static void a(t var0) {
      d.add(var0);
   }

   public static ResourceBundle c() {
      if (b == null) {
         try {
            if (k == null) {
               k = Utils.a(D.b().getPath());
            }

            b = ResourceBundle.getBundle("translations", a(), k);
         } catch (Exception var1) {
            a.log(Level.FINE, "Error getting translations", var1);
         }
      }

      return b;
   }

   public static ResourceBundle[] d() {
      ResourceBundle[] var0 = new ResourceBundle[0];

      try {
         ClassLoader var1 = Utils.a(D.b().getPath());
         HashSet var2 = new HashSet();
         Locale[] var3 = Locale.getAvailableLocales();
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            Locale var6 = var3[var5];

            try {
               var2.add(ResourceBundle.getBundle("translations", var6, var1));
            } catch (MissingResourceException var8) {
            }
         }

         var0 = new ResourceBundle[var2.size()];
         int var10 = 0;

         ResourceBundle var12;
         for(Iterator var11 = var2.iterator(); var11.hasNext(); var0[var10++] = var12) {
            var12 = (ResourceBundle)var11.next();
         }

         a(var0);
      } catch (MalformedURLException var9) {
         a.log(Level.FINE, "Error enumerating translation files", var9);
      }

      return var0;
   }

   public static void a(ResourceBundle[] var0) {
      LocaleComparator var1 = new LocaleComparator();
      Arrays.sort(var0, var1);
   }

   public static TimeZone e() {
      if (e == null) {
         f();
      }

      return e;
   }

   public static void a(TimeZone var0) {
      e = var0;
      Utils.writeLocaleFile((Object)e, (File)h);
   }
}
