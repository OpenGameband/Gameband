package com.nowcomputing;

import java.io.File;
import java.io.FilenameFilter;

class I implements FilenameFilter {
   // $FF: synthetic field
   final Class1 a;

   I(Class1 var1) {
      this.a = var1;
   }

   public boolean accept(File var1, String var2) {
      return var2.startsWith("._");
   }
}
