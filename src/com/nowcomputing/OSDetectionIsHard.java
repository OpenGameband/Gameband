package com.nowcomputing;

public enum OSDetectionIsHard {
   linux("linux", new String[]{"linux", "unix"}),
   windows("windows", new String[]{"win"}),
   osx("osx", new String[]{"mac"}),
   unknown("unknown", null);

   private final String internalName;
   private final String[] javaName;

   private OSDetectionIsHard(String var3, String[] var4) {
      this.internalName = var3;
      this.javaName = var4 == null ? new String[0] : var4;
   }

   public static OSDetectionIsHard getOS() {
      for (OSDetectionIsHard os: values()) {
         for (String s: os.javaName) {
            if (s.contentEquals(System.getProperty("os.name"))){
               return os;
            }
         }
      }
      return unknown;
   }

   public String[] b() {
      return this.javaName;
   }
}
