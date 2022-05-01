package b.a.a.a;

final class Class36 {
   private static String field81 = null;
   private static String field82 = null;
   private static String field83 = null;

   static int method170() {
      // $FF: Couldn't be decompiled
   }

   private static Class12 method171() {
      String var0 = System.getProperty("os.name");
      if (var0.startsWith("Mac OS")) {
         return Class12.field43;
      } else if (var0.startsWith("Linux")) {
         return Class12.field44;
      } else {
         return var0.startsWith("Windows") ? Class12.field42 : Class12.field45;
      }
   }
}
