package com.nowcomputing;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

class L implements Callable {
   // $FF: synthetic field
   final File a;
   // $FF: synthetic field
   final File b;
   // $FF: synthetic field
   final Class1 c;

   L(Class1 var1, File var2, File var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public Void a() throws IOException {
      Class1.method14(this.c, this.a, this.b);
      return null;
   }

   // $FF: synthetic method
   public Object call() throws IOException {
      return this.a();
   }
}
