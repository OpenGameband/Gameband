package b.a.a.a;

import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JLabel;

final class Class20 {
   static JComponent method74(int var0, String var1) {
      JLabel var2 = new JLabel("spanRow()");
      var2.setName("DesignGridLayout.spanRow-Marker");
      var2.setHorizontalAlignment(0);
      var2.setOpaque(true);
      var2.setBackground(Color.RED);
      var2.setToolTipText(var1);
      return var2;
   }

   static boolean method75(JComponent var0) {
      return var0 instanceof JLabel && "DesignGridLayout.spanRow-Marker".equals(var0.getName());
   }
}
