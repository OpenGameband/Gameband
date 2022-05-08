package com.nowcomputing.uistuff;

import com.nowcomputing.LocaleUtil;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.concurrent.CountDownLatch;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.KeyStroke;

public class GamebandDialog extends JFrame {
   private CountDownLatch a = new CountDownLatch(1);
   private JFrame b = new JFrame();
   private final JProgressBar progressBar = new JProgressBar();
   private JLabel d = new JLabel();
   private JLabel e = new JLabel();
   private JButton cancelButton = new JButton(LocaleUtil.getLocalizedString("CANCEL"));
   private JButton okButton = new JButton(LocaleUtil.getLocalizedString("OK"));
   private String str1;
   private String str2;
   private String str3;
   private boolean k;
   private boolean l;

   public GamebandDialog(String var1, String var2, String var3, boolean var4) {
      this.str1 = var1;
      this.str2 = var2;
      this.str3 = var3;
      this.k = var4;
      this.e();
   }

   public void a(String var1) {
      this.d.setText(var1);
   }

   public void b(String var1) {
      this.e.setText(var1);
   }

   private void e() {
      this.setDefaultCloseOperation(0);
      a var1 = new a();
      this.setContentPane(var1);
      this.getContentPane().setLayout((LayoutManager)null);
      JPanel var2 = this.f();
      var2.setBounds(0, 200, 800, 400);
      var1.add(var2);
      this.setResizable(false);
      this.pack();
      Insets var3 = this.getInsets();
      Dimension var4 = new Dimension(800 + var3.left + var3.right, 600 + var3.top + var3.bottom);
      this.setMinimumSize(var4);
      this.setMaximumSize(var4);
      this.setLocationRelativeTo((Component)null);
      this.getRootPane().getInputMap(2).put(KeyStroke.getKeyStroke(27, 0), "close");
      this.getRootPane().getActionMap().put("close", new S(this));
      this.addWindowListener(new T(this));
   }

   private JPanel f() {
      JPanel var1 = new JPanel();
      var1.setLayout((LayoutManager)null);
      var1.setOpaque(false);
      JLabel var2 = new JLabel(this.str1);
      var2.setHorizontalAlignment(0);
      am.a(var1, var2, GamebandFonts.i, Color.white, 0, 0, 800, 43);
      var2.setFont(GamebandFonts.i);
      this.d = new JLabel(this.str2);
      this.d.setHorizontalAlignment(0);
      am.a(var1, this.d, GamebandFonts.k, Color.white, 0, 45, 800, 43);
      this.e = new JLabel(this.str3);
      this.e.setHorizontalAlignment(0);
      am.a(var1, this.e, GamebandFonts.k, Color.white, 0, 71, 800, 43);
      this.progressBar.setBorder(BorderFactory.createEmptyBorder());
      am.a(var1, this.progressBar, GamebandFonts.p, GamebandColors.a(), 136, 114, 534, 24);
      if (this.k) {
         this.cancelButton.setBackground(GamebandColors.k);
         this.cancelButton.addActionListener(new U(this));
         am.a(var1, this.cancelButton, GamebandFonts.q, Color.white, 550, 152, 120, 32);
      }

      this.okButton.setBackground(GamebandColors.e());
      this.okButton.addActionListener(new V(this));
      am.a(var1, this.okButton, GamebandFonts.n, GamebandColors.f(), 387, 120, 60, 32);
      this.okButton.setVisible(false);
      return var1;
   }

   protected void a() {
      this.l = true;
      this.b();
   }

   public void b() {
      this.dispose();
      this.a.countDown();
   }

   public void c() {
      try {
         this.a.await();
      } catch (InterruptedException var2) {
         var2.printStackTrace();
      }

   }

   public void alertDialog() {
      this.progressBar.setVisible(false);
      this.cancelButton.setVisible(false);
      this.okButton.setVisible(true);
      this.okButton.requestFocusInWindow();
   }

   public void setProgressBarValue(int var1) {
      this.progressBar.setValue(var1);
   }

   public void setProgressBarIndeterminate(boolean var1) {
      this.progressBar.setIndeterminate(var1);
   }

   // $FF: synthetic method
   static boolean a(GamebandDialog var0) {
      return var0.k;
   }
}
