package com.nowcomputing.a;

import java.util.ArrayList;

public class e extends a {
   private com.nowcomputing.d d;
   private int e;
   private int f;
   private int g;
   private d h;
   private boolean i;

   public e(d var1, boolean var2) {
      this.h = com.nowcomputing.a.d.a;
      this.h = var1;
      this.i = var2;
   }

   protected void a() {
      // $FF: Couldn't be decompiled
   }

   public boolean d() {
      if (this.d != null) {
         return !this.g();
      } else {
         return false;
      }
   }

   public com.nowcomputing.d e() {
      // $FF: Couldn't be decompiled
   }

   public void a(com.nowcomputing.d var1) {
      this.d = var1;
   }

   public void a(String var1) {
      this.d = com.nowcomputing.d.a(var1);
   }

   public d h() {
      return this.h;
   }

   private com.nowcomputing.d a(com.nowcomputing.d var1, int var2, int var3) {
      com.nowcomputing.d var4 = new com.nowcomputing.d(20, 7);
      var4.a(var1, var2, var3);
      return var4;
   }

   public com.nowcomputing.a i() {
      this.a();
      this.a(false);
      ArrayList var1 = new ArrayList();

      while(this.d()) {
         var1.add(this.e());
      }

      return new com.nowcomputing.a(var1, this.a);
   }
}
