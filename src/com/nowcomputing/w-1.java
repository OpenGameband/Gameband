package com.nowcomputing;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class w {
   static final Logger a = Logger.getLogger(S.class.getName());
   private static String c;
   private static String d;
   private static String e;
   private static String f;
   private static String g;
   private static String h;
   private static String i;
   private R j;
   private long k;
   private long l;
   private Thread m;
   private boolean n;
   private h o;
   protected Exception b;

   public w(GamebandConfig var1) {
      String var2 = D.c().getAbsolutePath();
      var2 = GamebandConfig.fixPath(var2);
      c = var2 + File.separator + "launcher.jar";
      d = c + ".lzma";
      h = var2 + File.separator + ".mc.exe";
      i = h + ".tmp";
      f = var2 + File.separator + "runtime" + File.separator + "Minecraft.app";
      e = f + File.separator + "Contents" + File.separator + "MacOS" + File.separator + "launcher";
      g = f + ".zip";
   }

   public void a(R var1) {
      this.j = var1;
   }

   public M a() {
      // $FF: Couldn't be decompiled
   }

   public static c.a.a.c b() {
      c.a.a.c var0 = null;

      try {
         String var1 = S.a(S.b("https://launchermeta.mojang.com/mc/launcher.json"));
         c.a.a.a.b var2 = new c.a.a.a.b();
         var0 = (c.a.a.c)var2.a(var1);
      } catch (IOException var3) {
         a.log(Level.FINE, "Error Checking for new Minecraft launcher", var3);
      } catch (c.a.a.a.c var4) {
         a.log(Level.FINE, "Error reading Minecraft launcher json", var4);
      }

      return var0;
   }

   private boolean a(c.a.a.c var1) {
      try {
         c.a.a.c var2 = (c.a.a.c)var1.get("windows");
         String var3 = (String)var2.get("apphash");
         String var4 = S.d(h);
         return !var4.equals(var3);
      } catch (Exception var5) {
         return false;
      }
   }

   private boolean b(c.a.a.c var1) {
      try {
         c.a.a.c var2 = (c.a.a.c)var1.get("java");
         String var3 = (String)var2.get("sha1");
         String var4 = S.d(c);
         return !var4.equals(var3);
      } catch (Exception var5) {
         return false;
      }
   }

   private boolean c(c.a.a.c var1) {
      try {
         c.a.a.c var2 = (c.a.a.c)var1.get("osx");
         String var3 = (String)var2.get("apphash");
         String var4 = S.d(e);
         return !var4.equals(var3);
      } catch (Exception var5) {
         return false;
      }
   }

   public void c() {
      this.m = new x(this);
      this.m.start();
   }

   public void d() {
      // $FF: Couldn't be decompiled
   }

   private void d(c.a.a.c var1) {
      c.a.a.c var2 = (c.a.a.c)var1.get("osx");
      this.a((String)var2.get("applink"), g, (String)var2.get("downloadhash"));
      File var3 = new File(g);
      S.a(var3, new File(f), (List)null);
      var3.delete();
      if (this.j != null) {
         this.j.a();
      }

   }

   private void e(c.a.a.c var1) {
      c.a.a.c var2 = (c.a.a.c)var1.get("windows");
      this.a((String)var2.get("applink"), i, (String)var2.get("apphash"));
      S.b(new File(i), new File(h));
      S.i(new File(h));
      if (this.j != null) {
         this.j.a();
      }

   }

   private void f(c.a.a.c var1) {
      c.a.a.c var2 = (c.a.a.c)var1.get("java");
      c.a.a.c var3 = (c.a.a.c)var2.get("lzma");
      this.a((String)var3.get("url"), d, (String)var3.get("sha1"));
      S.a(d, c);
      String var4 = (String)var2.get("sha1");
      String var5 = S.d(c);
      if (!var5.equals(var4)) {
         throw new IOException("Error uncompressing " + d);
      } else {
         if (this.j != null) {
            this.j.a();
         }

      }
   }

   public void a(String var1, String var2, String var3) {
      a.log(Level.INFO, "Downloading " + var2);
      this.o = new h(new URL(var1), new File(var2), new z(this));
      this.k = (long)this.o.a();
      this.o.run();
      if (!this.o.b()) {
         throw this.o.c();
      } else {
         String var4 = S.d(var2);
         if (!var4.equals(var3)) {
            throw new IOException("Error downloading " + var2);
         }
      }
   }

   public Exception e() {
      return this.b;
   }

   // $FF: synthetic method
   static boolean a(w var0, boolean var1) {
      return var0.n = var1;
   }

   // $FF: synthetic method
   static boolean a(w var0) {
      return var0.n;
   }

   // $FF: synthetic method
   static long a(w var0, long var1) {
      return var0.k = var1;
   }

   // $FF: synthetic method
   static long b(w var0, long var1) {
      return var0.l = var1;
   }

   // $FF: synthetic method
   static R b(w var0) {
      return var0.j;
   }

   // $FF: synthetic method
   static long c(w var0, long var1) {
      return var0.l += var1;
   }

   // $FF: synthetic method
   static long c(w var0) {
      return var0.l;
   }

   // $FF: synthetic method
   static long d(w var0) {
      return var0.k;
   }
}