package b.a.a.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JComponent;

abstract class Class44 extends Class32 implements Class5 {
   private final List field100 = new ArrayList();
   private boolean field101 = false;
   private boolean field102 = false;
   private int field103 = 0;
   private int field104 = 0;

   public Class5 method197(JComponent... var1) {
      JComponent[] var2 = var1;
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         JComponent var5 = var2[var4];
         this.method109(var5);
         this.field100.add(new Class31(var5));
         this.method108().method210(var5);
      }

      return this;
   }

   public Class5 method198() {
      this.field101 = true;
      return this;
   }

   List method199() {
      return this.field100;
   }

   int method200(int var1, int var2) {
      int var3 = this.field100.size();
      int var4 = this.field103 * var3 + var1 * (var3 - 1) + this.field104;
      return var4;
   }

   int method201() {
      return this.field102 ? 0 : this.method202();
   }

   private int method202() {
      return Class1.method1(this.field100, Class38.field93);
   }

   void method203(int var1) {
      this.field103 = var1 > 0 && !this.field102 ? var1 : this.method202();
   }

   int method204(Class6 var1, int var2, int var3, int var4, int var5, int var6, int var7, List var8) {
      int var9 = var2 + this.field104;
      int var10 = this.field100.size();
      int var11 = this.field103;
      int var12 = var11;
      int var13 = var11;
      int var14;
      if (!this.field101) {
         var14 = var11 * var10 + (var10 - 1) * var3 + this.field104;
         var9 += this.method206(var6, var14);
      } else {
         var14 = var6 - this.field104 - (var10 - 1) * var3;
         var12 = this.method207(var10, var11, var14);
         var13 = this.method208(var10, var11, var14);
      }

      return this.method205(var1, var9, var3, var11, var12, var13);
   }

   protected int method205(Class6 var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = var2;
      int var8 = this.field100.size();
      int var9 = 0;
      int var10 = 0;

      for(Iterator var11 = this.field100.iterator(); var11.hasNext(); ++var9) {
         Class31 var12 = (Class31)var11.next();
         int var13;
         if (var9 == 0) {
            var13 = var5;
         } else if (var9 == var8 - 1) {
            var13 = var6;
         } else {
            var13 = var4;
         }

         var10 = Math.max(var10, var1.method21(var12.method80(), var7, var13, this.method117(), this.method116()));
         var7 += var13 + var3;
      }

      return var10;
   }

   protected abstract int method206(int var1, int var2);

   protected abstract int method207(int var1, int var2, int var3);

   protected abstract int method208(int var1, int var2, int var3);
}
