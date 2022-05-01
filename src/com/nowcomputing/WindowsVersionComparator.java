package com.nowcomputing;

//import java.util.logging.Logger;

/**
 * This is crap, it is bad
 * but it maybe works
 *
 * NOTE: might not work on modern java, it's funny because this thing only runs on java 8
 */
public class WindowsVersionComparator implements Comparable<WindowsVersionComparator> {
   //private static final Logger logger = Logger.getLogger(S.class.getName());
   protected int major;
   protected int minor;
   protected int patch;
   protected boolean beta;
   private static final String javaVersion = WindowsVersionComparator.class.getPackage().getImplementationVersion();
   public static final WindowsVersionComparator defaultWindowsVersion = new WindowsVersionComparator(0, 0, 0);

   public WindowsVersionComparator(int major, int minor, int patch) { // NO BETA? *insert megamind peeking meme*
      this.major = major;
      this.minor = minor;
      this.patch = patch;
   }

   public final int getMajor() {
      return this.major;
   }

   public final int getMinor() {
      return this.minor;
   }

   public final int getPatch() {
      return this.patch;
   }

   public WindowsVersionComparator(int var1, int var2) {
      this.major = var1;
      this.minor = var2;
      this.patch = 0;
   }

   public WindowsVersionComparator(String versionString) { // TODO: this is a mess that I can not be bothered dealing with, needs refactoring
      if (versionString == null) {
         this.major = 0;
         this.minor = 0;
         this.patch = 0;
      } else {
         String[] var2 = versionString.split("\\.");
         if (var2.length < 2) {
            throw new IllegalArgumentException("invalid version string");
         } else {
            int[] var3 = new int[var2.length];

            for(int i = 0; i < var2.length; ++i) {
               try {
                  var3[i] = Integer.valueOf(var2[i]);
               } catch (NumberFormatException var6) {
                  if (i != var2.length - 1 || !var2[i].equals("b")) {
                     throw new IllegalArgumentException("invalid version string.", var6);
                  }

                  this.beta = true;
               }
            }

            if (this.beta && var2.length == 2) {
               throw new IllegalArgumentException("invalid version string");
            } else {
               this.major = var3[0];
               this.minor = var3[1];
               if (var2.length >= 3) {
                  this.patch = var3[2];
               } else {
                  this.patch = 0;
               }

            }
         }
      }
   }

   public String toString() {
      return this.major + "." + this.minor + "." + this.patch + (this.beta ? " (beta)" : "");
   }

   public boolean equals(Object var1) {
      if (var1 instanceof WindowsVersionComparator) {
         if (var1 == this) {
            return true;
         } else {
            WindowsVersionComparator versionComparator = (WindowsVersionComparator)var1;
            return this.compareTo(versionComparator) == 0;
         }
      } else {
         return false;
      }
   }

   public int compareTo(WindowsVersionComparator var1) {
      if (this.major > var1.getMajor()) {
         return 1;
      } else if (this.minor > var1.getMinor()) {
         return 1;
      } else if (this.patch > var1.getPatch()) {
         return 1;
      } else {
         return this.major == var1.getMajor() && this.minor == var1.getMinor() && this.patch == var1.getPatch() ? 0 : -1;
      }
   }

   public int hashCode() {
      return 31 + this.major + this.minor + this.patch;
   }

   public static WindowsVersionComparator getImplementationVersion() {
      return new WindowsVersionComparator(javaVersion);
   }

}
