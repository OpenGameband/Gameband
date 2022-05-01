package b.a.a.a;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.JScrollPane;

class Class47 extends Class43 {
   public Class47() {
      super(JScrollPane.class);
   }

   protected int method214(JScrollPane var1, int var2) {
      int var3 = var1.getVerticalScrollBar().getUnitIncrement(1);
      Component var4 = var1.getViewport().getView();
      if (var3 == 0 && var4 instanceof JList) {
         JList var5 = (JList)var4;
         int var6 = var5.getVisibleRowCount();
         if (var6 > 0) {
            var3 = var5.getPreferredScrollableViewportSize().height / var6;
         }
      }

      var3 = Math.max(1, var3);
      return var2 / var3 * var3;
   }

   // $FF: synthetic method
   protected int method215(Component var1, int var2) {
      return this.method214((JScrollPane)var1, var2);
   }
}
