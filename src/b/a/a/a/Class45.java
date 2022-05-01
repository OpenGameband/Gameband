package b.a.a.a;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JComponent;

final class Class45 {
   private final Container field105;
   private boolean field106 = false;

   Class45(Container var1) {
      this.field105 = var1;
   }

   void method209(Container var1) {
      if (var1 != this.field105) {
         throw new IllegalArgumentException("Must use layout instance with original parent container");
      }
   }

   void method210(Component var1) {
      try {
         this.field106 = true;
         this.field105.add(var1);
      } finally {
         this.field106 = false;
      }

   }

   void method211(JComponent var1) {
      for(Object var2 = var1; var2 != null; var2 = ((Container)var2).getParent()) {
         if (var2 == this.field105) {
            throw new IllegalArgumentException("Do not add the same component twice");
         }
      }

   }

   void method212() {
      if (!this.field106) {
         throw new IllegalArgumentException("Do not use this method");
      }
   }

   Container method213() {
      return this.field105;
   }
}
