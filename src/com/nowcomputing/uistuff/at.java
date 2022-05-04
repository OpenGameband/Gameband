package com.nowcomputing.uistuff;

import com.nowcomputing.LocaleUtil;

public abstract class at extends a implements com.nowcomputing.t {
   protected ar c;

   protected at(String var1) {
      this.setName(var1);
      LocaleUtil.a((com.nowcomputing.t)this);
   }

   public void a(ar var1) {
      this.c = var1;
   }

   public void e() {
   }

   public boolean b() {
      return true;
   }

   public void c() {
      this.removeAll();
      this.a();
   }

   protected abstract void a();
}
