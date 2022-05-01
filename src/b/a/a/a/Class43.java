package b.a.a.a;

import java.awt.Component;

abstract class Class43 implements Class11 {
   private final Class field99;

   protected Class43(Class var1) {
      this.field99 = var1;
   }

   public final Class method192() {
      return this.field99;
   }

   public final boolean method193(Component var1) {
      return this.method195((Component)this.field99.cast(var1));
   }

   public final int method194(Component var1, int var2) {
      return this.method196((Component)this.field99.cast(var1), var2);
   }

   protected boolean method195(Component var1) {
      return true;
   }

   protected int method196(Component var1, int var2) {
      return var2;
   }
}
