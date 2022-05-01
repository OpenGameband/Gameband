package b.a.a.a;

final class Class22 extends Class44 {
   protected int method76(int var1, int var2) {
      return (var1 - var2) / 2;
   }

   protected int method77(int var1, int var2, int var3) {
      int var4 = var1 > 1 ? 2 : 1;
      return (var3 - (var1 - var4) * var2) / var4;
   }

   protected int method78(int var1, int var2, int var3) {
      int var4 = var1 > 1 ? 2 : 1;
      int var5 = (var3 - (var1 - var4) * var2) / var4;
      if ((var3 - (var1 - var4) * var2) % var4 > 0) {
         ++var5;
      }

      return var5;
   }
}
