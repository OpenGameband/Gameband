package b.a.a.a;

import java.awt.Container;
import javax.swing.JComponent;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;

final class Class29 {
   private final LayoutStyle field60 = LayoutStyle.getInstance();
   private int field61 = -1;

   public static Class29 method94() {
      return new Class29();
   }

   public int method95(JComponent var1, JComponent var2, ComponentPlacement var3, Container var4) {
      return this.field60.getPreferredGap(var1, var2, var3, 5, var4);
   }

   public int method96(JComponent var1, JComponent var2, ComponentPlacement var3, Container var4) {
      return this.field60.getPreferredGap(var1, var2, var3, 3, var4);
   }

   public int method97(JComponent var1, Container var2) {
      return this.field60.getContainerGap(var1, 1, var2);
   }

   public int method98(JComponent var1, Container var2) {
      return this.field60.getContainerGap(var1, 5, var2);
   }

   public int method99(JComponent var1, Container var2) {
      return this.field60.getContainerGap(var1, 7, var2);
   }

   public int method100(JComponent var1, Container var2) {
      return this.field60.getContainerGap(var1, 3, var2);
   }
}
