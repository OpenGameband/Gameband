package b.a.a.a;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

final class Class53 extends AbstractList implements RandomAccess {
   private final List field114;
   private final int field115;
   private int field116 = 0;

   Class53(List var1) {
      this.field114 = var1;
      this.field115 = var1.size();
   }

   public void method233(int var1, Class52 var2) {
      this.field114.add(this.field115 + var1, var2);
      ++this.field116;
   }

   public Class52 method234(int var1) {
      return (Class52)this.field114.get(this.field115 + var1);
   }

   public int size() {
      return this.field116;
   }

   // $FF: synthetic method
   public void add(int var1, Object var2) {
      this.method233(var1, (Class52)var2);
   }

   // $FF: synthetic method
   public Object get(int var1) {
      return this.method234(var1);
   }
}
