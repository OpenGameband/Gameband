package b.a.a.a;

import java.awt.Component;
import javax.swing.JSlider;

class Class30 extends Class43 {
   public Class30() {
      super(JSlider.class);
   }

   protected boolean method101(JSlider var1) {
      return var1.getOrientation() == 1;
   }

   // $FF: synthetic method
   protected boolean method102(Component var1) {
      return this.method101((JSlider)var1);
   }
}
