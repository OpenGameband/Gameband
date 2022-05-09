package com.nowcomputing.pixelfurnace;

import com.nowcomputing.GamebandConfig;
import com.nowcomputing.Utils;
import com.nowcomputing.otherImageThingy;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;

public class a extends g {
   private static final Logger f = Logger.getLogger(Utils.class.getName());

   public a(ExecutorService var1) {
      super((short)32, var1);
   }

   public a(n var1, ExecutorService var2) {
      super(var1.d(), var2);
      this.e = var1;
      this.b = new otherImageThingy.c();

      try {
         ((otherImageThingy.c)this.b).a(var1.l());
      } catch (IOException var4) {
         f.log(Level.WARNING, "", var4);
      }

   }

   public otherImageThingy b() {
      return this.e != null ? this.e.l() : null;
   }

   public n c() {
      if (this.e == null) {
         this.e = new n();
         this.e.a(this.e());
      }

      this.e.d((short)0);
      this.e.a((int)1000);
      this.e.b(this.b.f());
      this.e.a(((otherImageThingy.c)this.b).h());
      return this.e;
   }

   public void a(GamebandConfig.a var1) {
   }
}
