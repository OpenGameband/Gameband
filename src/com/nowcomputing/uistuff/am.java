package com.nowcomputing.uistuff;

import com.nowcomputing.LocaleUtil;
import com.nowcomputing.Utils;
import com.sun.java.swing.Painter;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.logging.Level;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public abstract class am {
   private static Painter b = new Y();
   private static Painter c = new Y();
   private static Painter d = new X();
   public static final UIDefaults a = new UIDefaults();

   public static void a(JComponent var0, JComponent var1, Font var2, Color var3, int var4, int var5, int var6, int var7) {
      var1.setFont(var2);
      var1.setForeground(var3);
      var1.setBounds(var4, var5, var6, var7);
      var0.add(var1);
   }

   public static void a(JComponent var0, JComponent var1, Font var2, Color var3) {
      var1.setFont(var2);
      var1.setForeground(var3);
      var0.add(var1);
   }

   public static void a(JFrame var0, String var1, String var2, String var3, String var4, String var5) {
      I var6 = new I(var0, var1, var2, var3, var4, var5);
      var6.setVisible(true);
   }

   public static void a() {
      a.put("Button[Pressed].backgroundPainter", b);

      try {
         LookAndFeelInfo[] var0 = UIManager.getInstalledLookAndFeels();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            LookAndFeelInfo var3 = var0[var2];
            if ("Nimbus".equals(var3.getName())) {
               UIManager.setLookAndFeel(var3.getClassName());
               UIDefaults var4 = UIManager.getLookAndFeelDefaults();
               var4.put("Button[Default+Focused+MouseOver].backgroundPainter", b);
               var4.put("Button[Default+Focused+Pressed].backgroundPainter", c);
               var4.put("Button[Default+Focused].backgroundPainter", b);
               var4.put("Button[Default+MouseOver].backgroundPainter", b);
               var4.put("Button[Default+Pressed].backgroundPainter", c);
               var4.put("Button[Default].backgroundPainter", b);
               var4.put("Button[Disabled].backgroundPainter", b);
               var4.put("Button[Enabled].backgroundPainter", b);
               var4.put("Button[Focused+MouseOver].backgroundPainter", b);
               var4.put("Button[Focused+Pressed].backgroundPainter", c);
               var4.put("Button[Focused].backgroundPainter", b);
               var4.put("Button[MouseOver].backgroundPainter", b);
               var4.put("Button[Pressed].backgroundPainter", c);
               var4.put("Button.font", q.n);
               var4.put("Button.background", GamebandColors.j);
               var4.put("TextField[Enabled].borderPainter", d);
               var4.put("TextField[Focused].borderPainter", d);
               var4.put("PasswordField[Enabled].borderPainter", d);
               var4.put("PasswordField[Focused].borderPainter", d);
               var4.put("ComboBox[Enabled+Selected].backgroundPainter", b);
               var4.put("ComboBox[Enabled].backgroundPainter", b);
               var4.put("ComboBox[Focused+MouseOver].backgroundPainter", b);
               var4.put("ComboBox[Focused+Pressed].backgroundPainter", b);
               var4.put("ComboBox[Focused].backgroundPainter", b);
               var4.put("ComboBox[MouseOver].backgroundPainter", b);
               var4.put("ComboBox[Pressed].backgroundPainter", b);
               var4.put("ProgressBar.tileWhenIndeterminate", false);
               var4.put("ProgressBar[Enabled+Indeterminate].foregroundPainter", new W());
               var4.put("ProgressBar[Enabled+Indeterminate].progressPadding", 0);
               var4.put("ProgressBar.cycleTime", 2000);
               UIManager.put("nimbusOrange", GamebandColors.a());
               InputMap var5 = (InputMap)UIManager.get("TextField.focusInputMap");
               int var6 = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
               var5.put(KeyStroke.getKeyStroke(67, var6), "copy-to-clipboard");
               var5.put(KeyStroke.getKeyStroke(86, var6), "paste-from-clipboard");
               var5.put(KeyStroke.getKeyStroke(88, var6), "cut-to-clipboard");
               break;
            }
         }

         LocaleUtil.a((com.nowcomputing.t)(new an()));
      } catch (Exception var7) {
         Utils.logger.log(Level.SEVERE, (String)null, var7);
      }

   }

   public static Window a(Component var0) {
      if (var0 == null) {
         return null;
      } else {
         return !(var0 instanceof Frame) && !(var0 instanceof Dialog) ? a(var0.getParent()) : (Window)var0;
      }
   }
}
