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

public class GamebandPopup extends JDialog {
   private int a;

   public GamebandPopup(Frame var1, String var2) {
      super(var1, var2, true);
   }

   public GamebandPopup(Dialog var1, String var2) {
      super(var1, var2, true);
   }

   private void setPanel(JPanel var1) {
      Container var2 = this.getContentPane();
      var2.setLayout(new BorderLayout());
      var2.add(var1, "Center");
      this.setResizable(false);
      this.pack();
      this.setLocationRelativeTo(this.getOwner());
      this.addWindowListener(new O(this));
   }

   private static JPanel a(GamebandPopup var0, String[] var1, String[] var2) {
      JPanel var3 = NewPanel();
      CreatePanel(var1, var3);
      a(var0, var2, var3);
      return var3;
   }

   private static JPanel a(GamebandPopup var0, String[] var1, String[] var2, String var3) {
      JPanel panel = NewPanel();
      CreatePanel(var1, panel);
      panel.add(Box.createVerticalStrut(10));
      a(var3, panel);
      a(var0, var2, panel);
      return panel;
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

   public static JPanel NewPanel() {
      JPanel var0 = new JPanel();
      var0.setBackground(GamebandColors.n);
      var0.setLayout(new BoxLayout(var0, 1));
      var0.setBorder(new EmptyBorder(20, 20, 20, 20));
      return var0;
   }

   public static void a(GamebandPopup var0, String[] var1, JPanel var2) {
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

   public static void CreatePanel(String[] var0, JPanel var1) {
      for (String s : var0) {
         C var6 = new C(s, 360, "center");
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
      GamebandPopup var3 = a(var0, var2);
      var3.setPanel(a(var3, var1, new String[]{"OK"}));
      var3.setVisible(true);
   }

   public static void PopupDialog(Component rootWindow, String[] text, String title, String var3) {
      GamebandPopup popup = a(rootWindow, title);
      popup.setPanel(a(popup, text, new String[]{"OK"}, var3));
      popup.setVisible(true);
   }

   public static int a(Component var0, String var1, String var2, String[] var3) {
      return a(var0, new String[]{var1}, var2, var3);
   }

   public static int a(Component var0, String[] var1, String var2, String[] var3) {
      GamebandPopup var4 = a(var0, var2);
      var4.setPanel(a(var4, var1, var3));
      var4.setVisible(true);
      return var4.b();
   }

   private static GamebandPopup a(Component var0, String var1) {
      Window var3 = am.getWindow(var0);
      GamebandPopup var2;
      if (var3 instanceof Frame) {
         var2 = new GamebandPopup((Frame)var3, var1);
      } else {
         var2 = new GamebandPopup((Dialog)var3, var1);
      }

      return var2;
   }
}
