package com.nowcomputing.uistuff;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Window;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class N extends JDialog {
   private int a;

   public N(Frame var1, String var2) {
      super(var1, var2, true);
   }

   public N(Dialog var1, String var2) {
      super(var1, var2, true);
   }

   private void a(JPanel var1) {
      Container var2 = this.getContentPane();
      var2.setLayout(new BorderLayout());
      var2.add(var1, "Center");
      this.setResizable(false);
      this.pack();
      this.setLocationRelativeTo(this.getOwner());
      this.addWindowListener(new O(this));
   }

   private static JPanel a(N var0, String[] var1, String[] var2) {
      JPanel var3 = a();
      a(var1, var3);
      a(var0, var2, var3);
      return var3;
   }

   private static JPanel a(N var0, String[] var1, String[] var2, String var3) {
      JPanel var4 = a();
      a(var1, var4);
      var4.add(Box.createVerticalStrut(10));
      a(var3, var4);
      a(var0, var2, var4);
      return var4;
   }

   private static void a(String var0, JPanel var1) {
      JEditorPane var2 = new JEditorPane();
      var2.setBackground(new Color(0, 0, 0, 0));
      var2.setAlignmentY(0.0F);
      var2.setAlignmentX(0.5F);
      var2.setEditable(false);
      var2.setMargin((Insets)null);
      var2.setFont(GamebandFonts.s);
      var2.setContentType("text/html");
      String var3 = "<html><body style='text-align:center'><a style='color:#e0d0d0;font-size:12px;font-family:helvetica;' href='" + var0 + "'>" + var0;
      var2.setText(var3);
      var2.addHyperlinkListener(new P());
      var1.add(var2);
   }

   public static JPanel a() {
      JPanel var0 = new JPanel();
      var0.setBackground(GamebandColors.n);
      var0.setLayout(new BoxLayout(var0, 1));
      var0.setBorder(new EmptyBorder(20, 20, 20, 20));
      return var0;
   }

   public static void a(N var0, String[] var1, JPanel var2) {
      JPanel var3 = new JPanel();
      var3.setAlignmentX(0.5F);
      var2.add(var3);
      var3.setOpaque(false);
      var3.setBorder(new EmptyBorder(20, 0, 0, 0));

      for(int var4 = 0; var4 < var1.length; ++var4) {
         JButton var6 = new JButton(var1[var4]);
         var6.setFont(GamebandFonts.n);
         var6.addActionListener(new Q(var0, var4));
         var3.add(var6);
      }

   }

   public static void a(String[] var0, JPanel var1) {
      String[] var2 = var0;
      int var3 = var0.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String var5 = var2[var4];
         C var6 = new C(var5, 360, "center");
         var6.setFont(GamebandFonts.k);
         var6.setForeground(Color.WHITE);
         var6.setAlignmentX(0.5F);
         var1.add(var6);
         var1.add(Box.createVerticalStrut(2));
      }

   }

   protected void a(int var1) {
      this.a = var1;
   }

   public int b() {
      return this.a;
   }

   public static void a(Component var0, String[] var1) {
      a(var0, var1, "Gameband");
   }

   public static void a(Component var0, String var1, String var2) {
      a(var0, new String[]{var1}, var2);
   }

   public static void a(Component var0, String[] var1, String var2) {
      N var3 = a(var0, var2);
      var3.a(a(var3, var1, new String[]{"OK"}));
      var3.setVisible(true);
   }

   public static void a(Component var0, String[] var1, String var2, String var3) {
      N var4 = a(var0, var2);
      var4.a(a(var4, var1, new String[]{"OK"}, var3));
      var4.setVisible(true);
   }

   public static int a(Component var0, String var1, String var2, String[] var3) {
      return a(var0, new String[]{var1}, var2, var3);
   }

   public static int a(Component var0, String[] var1, String var2, String[] var3) {
      N var4 = a(var0, var2);
      var4.a(a(var4, var1, var3));
      var4.setVisible(true);
      return var4.b();
   }

   private static N a(Component var0, String var1) {
      Window var3 = am.a(var0);
      N var2;
      if (var3 instanceof Frame) {
         var2 = new N((Frame)var3, var1);
      } else {
         var2 = new N((Dialog)var3, var1);
      }

      return var2;
   }
}
