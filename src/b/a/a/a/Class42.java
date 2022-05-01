package b.a.a.a;

import java.awt.ComponentOrientation;
import java.awt.Container;

class Class42 {
   private final Container field98;

   public Class42(Container var1) {
      this.field98 = var1;
   }

   public boolean method191() {
      ComponentOrientation var1 = this.field98.getComponentOrientation();
      return var1.isHorizontal() && !var1.isLeftToRight();
   }
}
