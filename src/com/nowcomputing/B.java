package com.nowcomputing;

public enum B {
   a("linux", new String[]{"linux", "unix"}),
   b("windows", new String[]{"win"}),
   c("osx", new String[]{"mac"}),
   d("unknown", (String[])null);

   private final String e;
   private final String[] f;

   public static B[] a() {
      return (B[]) LocaleComparator.clone();
   }

   private B(String var3, String[] var4) {
      this.e = var3;
      this.f = var4 == null ? new String[0] : var4;
   }

   public String[] b() {
      return this.f;
   }
}
