package com.nowcomputing;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

class K implements Callable<Void> {
   // $FF: synthetic field
   final File a;
   // $FF: synthetic field
   final File b;
   // $FF: synthetic field
   final Class1 c;

   K(Class1 var1, File var2, File var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   @Override
   public Void call() throws IOException {
      Class1.method13(this.c, this.a, this.b);
      return null;
   }
}
