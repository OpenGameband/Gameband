package b.a.a.a;

import java.util.List;
import javax.swing.JComponent;

final class Class6 {
   private final Class41 field8;
   private final int field9;
   private final boolean field10;
   private final List field11;
   private int field12;
   private int field13;

   Class6(Class41 var1, int var2, boolean var3, List var4) {
      this.field8 = var1;
      this.field9 = var2;
      this.field10 = var3;
      this.field11 = var4;
   }

   void method18(int var1) {
      this.field12 = var1;
   }

   void method19(int var1) {
      this.field13 = var1;
   }

   void method20(int var1, JComponent var2, int var3) {
      int var4 = 0;

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         Class32 var6 = (Class32)this.field11.get(var1 + var5);
         var4 += var6.method119();
         if (var5 + 1 < var3) {
            var4 += var6.method113();
         }
      }

      var5 = method22(var2);
      int var7 = 0;
      if (Class20.method75(var2)) {
         var7 = var4 - var5;
      } else if (this.field8.method189(var2)) {
         var7 = this.field8.method190(var2, var4 - var5);
      }

      var2.setSize(var2.getWidth(), var5 + var7);
   }

   int method21(JComponent var1, int var2, int var3, int var4, int var5) {
      int var6 = var1.getPreferredSize().height;
      int var7 = 0;
      if (this.field8.method189(var1)) {
         var7 = this.field8.method190(var1, this.field12 - var6);
      }

      var1.setSize(var3, var6 + var7);
      int var8 = Class27.method91(var1);
      int var9;
      if (var8 > 0) {
         var9 = var5 - var8;
      } else if (var8 == 0) {
         var9 = 0;
      } else {
         var9 = (var4 - var6) / 2;
      }

      var1.setLocation(this.field10 ? this.field9 - var2 - var3 : var2, this.field13 + var9);
      return var7;
   }

   private static int method22(JComponent var0) {
      int var1 = var0.getHeight();
      return var1 > 0 ? var1 : var0.getPreferredSize().height;
   }
}
