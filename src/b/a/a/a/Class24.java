package b.a.a.a;

import javax.swing.JComponent;

class Class24 implements Class13 {
   private JComponent field56;

   public Class24(JComponent var1) {
      this.field56 = var1;
   }

   protected void method79(JComponent var1) {
      this.field56 = var1;
   }

   public JComponent method80() {
      return this.field56;
   }

   public int method81() {
      return this.method80().getPreferredSize().height;
   }

   public int method82() {
      return this.method80().getMinimumSize().width;
   }

   public int method83() {
      return this.method80().getPreferredSize().width;
   }

   public int method84() {
      return Class27.method91(this.method80());
   }
}
