package com.nowcomputing;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

class J implements Callable {
   // $FF: synthetic field
   final UpdateEntry a;
   // $FF: synthetic field
   final File b;
   // $FF: synthetic field
   final Class1 c;

   J(Class1 var1, UpdateEntry var2, File var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public Void a() throws IOException {
      Class1.method12(this.c, this.a, this.b);
      return null;
   }

   // $FF: synthetic method
   public Object call() throws IOException {
      return this.a();
   }
}
