package com.nowcomputing.e;

public class c {
   public static final d a;

   public static a a(d var0) {
      if (var0.equals(d.a)) {
         return new e(b.a);
      } else if (var0.equals(d.c)) {
         return new i();
      } else if (var0.equals(d.b)) {
         return new j(b.a);
      } else {
         return var0.equals(d.d) ? new g(b.a) : null;
      }
   }

   public static a b(d var0) {
      if (var0.equals(d.a)) {
         return new e(b.b);
      } else if (var0.equals(d.c)) {
         return new i();
      } else if (var0.equals(d.b)) {
         return new j(b.b);
      } else {
         return var0.equals(d.d) ? new g(b.b) : null;
      }
   }

   public static d a(int var0) {
      if (var0 == 0) {
         return d.a;
      } else if (var0 == 1) {
         return d.b;
      } else if (var0 == 2) {
         return d.c;
      } else {
         return var0 == 3 ? d.d : null;
      }
   }

   static {
      a = d.d;
   }
}
