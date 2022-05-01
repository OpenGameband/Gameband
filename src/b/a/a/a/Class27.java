package b.a.a.a;

import java.awt.Component;
import java.awt.Dimension;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;

final class Class27 {
   private static final Set field58 = new HashSet();

   public static int method91(Component var0) {
      Dimension var1 = var0.getPreferredSize();
      int var2 = method92(var0, var1.width, var1.height);
      if (var2 < 0) {
         boolean var3 = false;
         Iterator var4 = field58.iterator();

         while(var4.hasNext()) {
            Class var5 = (Class)var4.next();
            if (var5.isInstance(var0)) {
               var3 = true;
               break;
            }
         }

         if (!var3) {
            var2 = 0;
         }
      }

      return var2;
   }

   private static int method92(Component var0, int var1, int var2) {
      return var0.getBaseline(var1, var2);
   }

   static {
      field58.add(JSeparator.class);
      field58.add(JProgressBar.class);
   }
}
