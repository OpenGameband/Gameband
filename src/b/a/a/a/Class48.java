package b.a.a.a;

import java.awt.Component;
import java.awt.Container;

class Class48 extends Class43 {
   private final Class41 field108;

   public Class48(Class41 var1) {
      super(Container.class);
      this.field108 = var1;
   }

   protected boolean method216(Container var1) {
      Component[] var2 = var1.getComponents();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Component var5 = var2[var4];
         if (this.field108.method189(var5)) {
            return true;
         }
      }

      return false;
   }

   protected int method217(Container var1, int var2) {
      int var3 = 0;
      Component[] var4 = var1.getComponents();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         Component var7 = var4[var6];
         if (this.field108.method189(var7)) {
            var3 = Math.max(var3, this.field108.method190(var7, var2));
         }
      }

      return var3;
   }

   // $FF: synthetic method
   protected int method218(Component var1, int var2) {
      return this.method217((Container)var1, var2);
   }

   // $FF: synthetic method
   protected boolean method219(Component var1) {
      return this.method216((Container)var1);
   }
}
