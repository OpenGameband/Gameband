package com.nowcomputing;

import com.nowcomputing.f.ai;
import java.io.File;

public class F {
   public static void a(File var0) {
      if (!c(var0)) {
         ai var1 = new ai();
         var1.setVisible(true);
         var1.a();
         b(var0);
      }

   }

   private static void b(File var0) {
      (new File(var0, ".act")).delete();
   }

   private static boolean c(File var0) {
      return !(new File(var0, ".act")).exists();
   }
}
