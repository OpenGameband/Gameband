package com.nowcomputing.a;

import com.nowcomputing.LocaleUtil;

public enum d {
   a("LEFT"),
   b("RIGHT"),
   c("UP"),
   d("DOWN");

   private String e;

   private static final /* synthetic */ d[] f;

   public static d[] a() {
      return (com.nowcomputing.a.d[])f.clone();
   }

   private d(String var3) {
      this.e = var3;
   }

   public String toString() {
      return LocaleUtil.getLocalizedString(this.e);
   }
   static {
      f = new d[] { d.a, d.b, d.c, d.d };
   }
}
