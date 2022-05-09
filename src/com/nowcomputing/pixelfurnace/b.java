package com.nowcomputing.pixelfurnace;

import com.nowcomputing.N;
import com.nowcomputing.LocaleUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;

public class b extends g {
   public b(ExecutorService var1) {
      super(d(), var1);
   }

   public b(n var1, ExecutorService var2) {
      super(var1.d(), var2);
   }

   public void a(N var1) {
      if (var1 == N.d) {
         this.a((short)3);
      } else if (var1 == N.c) {
         this.a((short)2);
      }

   }

   public N b() {
      return this.e() == 2 ? N.c : N.d;
   }

   public n c() {
      if (this.e == null) {
         this.e = new n();
         this.e.c((short)3000);
      }

      this.e.d(this.j());
      if (this.j() == 0) {
         this.e.a((int)1000);
      }

      this.e.a(this.e());
      return this.e;
   }

   public static short d() {
      SimpleDateFormat var0 = (SimpleDateFormat)DateFormat.getDateInstance(3, LocaleUtil.a());
      String var1 = var0.toPattern();
      return (short)(var1.equals("M/d/yy") ? 2 : 3);
   }
}
