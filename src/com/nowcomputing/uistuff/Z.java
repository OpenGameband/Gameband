package com.nowcomputing.uistuff;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicRadioButtonUI;
import javax.swing.text.View;
import sun.swing.SwingUtilities2;

public class Z extends BasicRadioButtonUI {
   private static Dimension a = new Dimension();
   private static Rectangle b = new Rectangle();
   private static Rectangle c = new Rectangle();
   private static Rectangle d = new Rectangle();

   public synchronized void paint(Graphics var1, JComponent var2) {
      AbstractButton var3 = (AbstractButton)var2;
      ButtonModel var4 = var3.getModel();
      Font var5 = var2.getFont();
      var1.setFont(var5);
      FontMetrics var6 = SwingUtilities2.getFontMetrics(var2, var1, var5);
      Insets var7 = var2.getInsets();
      a = var3.getSize(a);
      b.x = var7.left;
      b.y = var7.top;
      b.width = a.width - (var7.right + b.x);
      b.height = a.height - (var7.bottom + b.y);
      c.x = c.y = c.width = c.height = 0;
      d.x = d.y = d.width = d.height = 0;
      Icon var8 = var3.getIcon();
      Object var9 = null;
      Object var10 = null;
      String var11 = SwingUtilities.layoutCompoundLabel(var2, var6, var3.getText(), var8 != null ? var8 : this.getDefaultIcon(), var3.getVerticalAlignment(), var3.getHorizontalAlignment(), var3.getVerticalTextPosition(), var3.getHorizontalTextPosition(), b, c, d, var3.getText() == null ? 0 : var3.getIconTextGap());
      if (var2.isOpaque()) {
         var1.setColor(var3.getBackground());
         var1.fillRect(0, 0, a.width, a.height);
      }

      if (var8 != null) {
         if (!var4.isEnabled()) {
            if (var4.isSelected()) {
               var8 = var3.getDisabledSelectedIcon();
            } else {
               var8 = var3.getDisabledIcon();
            }
         } else if (var4.isPressed() && var4.isArmed()) {
            var8 = var3.getPressedIcon();
            if (var8 == null) {
               var8 = var3.getSelectedIcon();
            }
         } else if (var4.isSelected()) {
            if (var3.isRolloverEnabled() && var4.isRollover()) {
               var8 = var3.getRolloverSelectedIcon();
               if (var8 == null) {
                  var8 = var3.getSelectedIcon();
               }
            } else {
               var8 = var3.getSelectedIcon();
            }
         } else if (var3.isRolloverEnabled() && var4.isRollover()) {
            var8 = var3.getRolloverIcon();
         }

         if (var8 == null) {
            var8 = var3.getIcon();
         }

         var8.paintIcon(var2, var1, c.x, c.y);
      }

      if (var11 != null) {
         View var12 = (View)var2.getClientProperty("html");
         if (var12 != null) {
            var12.paint(var1, d);
         } else {
            this.paintText(var1, var3, d, var11);
         }

         if (var3.hasFocus() && var3.isFocusPainted() && d.width > 0 && d.height > 0) {
            this.paintFocus(var1, d, a);
         }
      }

      if (((AbstractButton)var2).isSelected()) {
         Graphics2D var13 = (Graphics2D)var1;
         var13.setPaint(GamebandColors.a());
         var13.setStroke(new BasicStroke(6.0F));
         var13.drawRect(0, 0, var2.getWidth(), var2.getHeight());
      }

   }
}
