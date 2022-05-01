package b.a.a.a;

import java.awt.Container;
import java.util.Iterator;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.LayoutStyle.ComponentPlacement;

final class Class1 {
   static int method1(Iterable var0, Class25 var1) {
      int var2 = 0;

      Class13 var4;
      for(Iterator var3 = var0.iterator(); var3.hasNext(); var2 = Math.max(var2, var1.method85(var4))) {
         var4 = (Class13)var3.next();
      }

      return var2;
   }

   static int method2(List var0, Container var1) {
      return method6(Class29.method94(), var0, var1, ComponentPlacement.UNRELATED);
   }

   static int method3(List var0, Container var1) {
      return method6(Class29.method94(), var0, var1, ComponentPlacement.RELATED);
   }

   static int method4(JComponent var0, List var1, Container var2) {
      Class29 var3 = Class29.method94();
      int var4 = 0;
      if (var0 != null && !var1.isEmpty()) {
         var4 = method7(var3, var0, ((Class13)var1.get(0)).method60(), var2, ComponentPlacement.RELATED);
      }

      return Math.max(var4, method6(var3, var1, var2, ComponentPlacement.RELATED));
   }

   static boolean method5(Class41 var0, Iterable var1) {
      Iterator var2 = var1.iterator();

      Class33 var3;
      do {
         if (!var2.hasNext()) {
            return true;
         }

         var3 = (Class33)var2.next();
      } while(!var0.method189(var3.method60()) || !var3.method145());

      return false;
   }

   private static int method6(Class29 var0, List var1, Container var2, ComponentPlacement var3) {
      int var4 = 0;
      int var5 = var1.size() - 1;

      for(int var6 = 0; var6 < var5; ++var6) {
         JComponent var7 = ((Class13)var1.get(var6)).method60();
         JComponent var8 = ((Class13)var1.get(var6 + 1)).method60();
         int var9 = method7(var0, var7, var8, var2, var3);
         var4 = Math.max(var4, var9);
      }

      return var4;
   }

   private static int method7(Class29 var0, JComponent var1, JComponent var2, Container var3, ComponentPlacement var4) {
      return var0.method96(var1, var2, var4, var3);
   }
}
