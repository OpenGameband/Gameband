package com.nowcomputing.f;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class G {
   static final Logger a = Logger.getLogger(com.nowcomputing.S.class.getName());
   private File b = b();
   private boolean c;

   public G() {
      a.log(Level.FINE, "Local Minecraft dir = " + this.b);
   }

   public boolean a() {
      return this.c() && (new File(this.b, "saves")).exists();
   }

   public void a(boolean var1) {
      this.c = var1;
   }

   private boolean c() {
      return this.b != null && this.b.exists() && this.b.isDirectory();
   }

   public static File b() {
      // $FF: Couldn't be decompiled
   }
}
