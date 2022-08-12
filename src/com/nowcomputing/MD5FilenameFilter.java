package com.nowcomputing;

import java.io.File;
import java.io.FilenameFilter;

class MD5FilenameFilter implements FilenameFilter {

   MD5FilenameFilter() {

   }

   public boolean accept(File var1, String var2) {
      return !var2.endsWith(".MD5");
   }
}
