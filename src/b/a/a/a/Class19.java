package b.a.a.a;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

final class Class19 implements Iterator {
   private final List field53;
   private int field54;

   public static Iterable method71(List var0) {
      return new Class23(var0);
   }

   private Class19(List var1) {
      this.field54 = 0;
      this.field53 = var1;
   }

   public Class32 method72() {
      int var1 = this.method73();
      if (var1 != -1) {
         this.field54 = var1 + 1;
         return (Class32)this.field53.get(var1);
      } else {
         throw new NoSuchElementException();
      }
   }

   public boolean hasNext() {
      return this.method73() != -1;
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }

   private int method73() {
      for(int var1 = this.field54; var1 < this.field53.size(); ++var1) {
         Class32 var2 = (Class32)this.field53.get(var1);
         if (!var2.method134()) {
            return var1;
         }
      }

      return -1;
   }

   // $FF: synthetic method
   public Object next() {
      return this.method72();
   }

   // $FF: synthetic method
   Class19(List var1, Class23 var2) {
      this(var1);
   }
}
