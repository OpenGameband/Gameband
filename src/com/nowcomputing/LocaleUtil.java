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

/**
 * the bane of my existence, was called com.nowcomputing.f
 */
public class LocaleUtil {
   public static final Logger logger = Logger.getLogger(Utils.class.getName());
   private static final File localePath = new File(D.getLibPath(), "locale");
   private static final File tzPath = new File(D.getLibPath(), "tz");
   private static final File tzonePath = new File(D.getLibPath(), "tzone");
   static ResourceBundle resourceBundle = null;
   static Locale locale = null;
   static ArrayList list = new ArrayList();
   static TimeZone timeZone = null;
   private static DateFormat dateTimeFormat;
   private static DateFormat dateFormat;
   private static ClassLoader loader;

   private static void setLocale() {
      Object localeFile = null;
      if (localePath.exists()) {
         localeFile = Utils.deserializeFile(localePath);
      }

      if (localeFile != null && localeFile instanceof Locale) {
         locale = (Locale)localeFile;
      } else {
         locale = Locale.getDefault();
      }

      setDateStyle();
      g();
   }

   private static void g() {
      if (tzPath.exists()) {
         getStoredTimezone(tzPath);
         tzPath.delete();
      } else {
         getStoredTimezone(tzonePath);
      }

   }

   private static void getStoredTimezone(File var0) {
      Object var1 = null;
      if (var0.exists()) {
         var1 = Utils.deserializeFile(var0);
      }

      if (var1 != null && var1 instanceof TimeZone) {
         timeZone = (TimeZone)var1;
         logger.log(Level.FINE, "Read stored timezone: " + timeZone);
      } else {
         timeZone = TimeZone.getDefault();
         logger.log(Level.FINE, "No stored timezone, default = " + timeZone);
      }

   }

   public static String getLocalizedString(String var0) {
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
      if (locale == null) {
         setLocale();
      }

      return locale;
   }

   public static void a(Locale var0) {
      try {
         locale = var0;
         setDateStyle();
         ResourceBundle.clearCache();
         ClassLoader var1 = Utils.a(D.getLibPath().getPath());
         resourceBundle = ResourceBundle.getBundle("translations", a(), var1);
         Iterator var2 = list.iterator();

         while(var2.hasNext()) {
            resetAction var3 = (resetAction)var2.next();
            var3.reset();
         }

         Utils.writeLocaleFile((Object) locale, (File) localePath);
      } catch (Exception var4) {
         logger.log(Level.FINE, "Error setting locale " + var0.getDisplayName(), var4);
      }

   }

   public static void setDateStyle() {
      dateTimeFormat = DateFormat.getDateTimeInstance(2, 3, locale);
      dateFormat = DateFormat.getDateInstance(2, locale);
   }

   public static void a(resetAction var0) {
      list.add(var0);
   }

   public static ResourceBundle c() {
      if (resourceBundle == null) {
         try {
            if (loader == null) {
               loader = Utils.a(D.getLibPath().getPath());
            }

            resourceBundle = ResourceBundle.getBundle("translations", a(), loader);
         } catch (Exception var1) {
            logger.log(Level.FINE, "Error getting translations", var1);
         }
      }

      return resourceBundle;
   }

   public static ResourceBundle[] d() {
      ResourceBundle[] var0 = new ResourceBundle[0];

      try {
         ClassLoader var1 = Utils.a(D.getLibPath().getPath());
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
      } catch (MalformedURLException e) {
         logger.log(Level.FINE, "Error enumerating translation files", e);
      }

      return var0;
   }

   public static void a(ResourceBundle[] var0) {
      LocaleComparator var1 = new LocaleComparator();
      Arrays.sort(var0, var1);
   }

   public static TimeZone e() {
      if (timeZone == null) {
         setLocale();
      }

      return timeZone;
   }

   public static void a(TimeZone var0) {
      timeZone = var0;
      Utils.writeLocaleFile((Object) timeZone, (File) tzonePath);
   }
}
