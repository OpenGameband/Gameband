package com.nowcomputing;

public class X extends WindowsVersionComparator {
   private int f;

   public X(int var1, int var2, int var3, int var4) {
      super(var1, var2, var3);
      this.f = var4;
   }

   public X(String var1) {
      super(0, 0);
      if (var1 == null) {
         this.f = 0;
      } else {
         String[] var2 = var1.split("\\.");
         if (var2.length < 2) {
            throw new IllegalArgumentException("invalid version string");
         } else {
            int[] var3 = new int[var2.length];

            for(int var4 = 0; var4 < var2.length; ++var4) {
               try {
                  var3[var4] = Integer.valueOf(var2[var4]);
               } catch (NumberFormatException var6) {
                  throw new IllegalArgumentException("invalid version string.", var6);
               }
            }

            this.major = var3[0];
            this.minor = var3[1];
            if (var2.length >= 3) {
               this.patch = var3[2];
            } else {
               this.patch = 0;
            }

            if (var2.length >= 4) {
               this.f = var3[3];
            } else {
               this.f = 0;
            }

         }
      }
   }

   public final int e() {
      return this.f;
   }

   public String toString() {
      return this.major + "." + this.minor + "." + this.patch + "." + this.f + (this.beta ? " (beta)" : "");
   }

   public boolean equals(Object var1) {
      if (var1 != null && var1 instanceof X) {
         return super.equals(var1) && this.a((X)var1) == 0;
      } else {
         return false;
      }
   }

   public int a(X var1) {
      int var2 = super.getMajor(var1);
      if (var2 == 0) {
         if (this.f > var1.e()) {
            return 1;
         } else {
            return this.f == var1.e() ? 0 : -1;
         }
      } else {
         return var2;
      }
   }
}
