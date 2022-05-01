package com.nowcomputing;

class C implements Comparable {
   final Object a;
   final Object b;

   C(Object var1, Object var2) {
      this.a = var1;
      this.b = var2;
   }

   public int a(C var1) {
      int var2;
      if (this.a instanceof Comparable) {
         var2 = ((Comparable)this.a).compareTo(var1.a);
         if (var2 > 0) {
            return 1;
         }

         if (var2 < 0) {
            return -1;
         }
      }

      if (this.b instanceof Comparable) {
         var2 = ((Comparable)this.b).compareTo(var1.b);
         if (var2 > 0) {
            return 1;
         }

         if (var2 < 0) {
            return -1;
         }
      }

      return 0;
   }

   // $FF: synthetic method
   public int compareTo(Object var1) {
      return this.a((C)var1);
   }
}
