package com.nowcomputing.f;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.util.Timer;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class b extends z {
   private static final Logger h = Logger.getLogger(com.nowcomputing.S.class.getName());
   private boolean i = false;
   private final e j;
   protected final JPanel a = new JPanel();
   private final JLabel k = new JLabel();
   private final JLabel l = new JLabel();
   private final JLabel m = new JLabel();
   private final JProgressBar n = new JProgressBar();
   private JPanel o;
   private final y p = new y();
   private final y q = new y();
   private final JTextPane r = new JTextPane();
   private JPanel s;
   protected JPanel b;
   private Timer t = new Timer();
   private y u = new y();

   public b(e var1) {
      this.j = var1;
      this.a();
   }

   public void a() {
      this.removeAll();
      this.a(com.nowcomputing.f.a("BACKUP_WINDOW_TITLE"));
      super.a();
   }

   protected Component b() {
      super.b();
      this.d.setLayout(new BorderLayout());
      JPanel var1 = new JPanel();
      var1.setOpaque(false);
      var1.setLayout(new BoxLayout(var1, 1));
      this.d.add(var1, "North");
      var1.add(this.a(220));
      var1.add(Box.createVerticalStrut(10));
      this.d.add(this.b(380), "Center");
      return this.d;
   }

   private JPanel a(int var1) {
      this.a.removeAll();
      this.a.setLayout(new BoxLayout(this.a, 1));
      this.a.setOpaque(false);
      this.k.setText(com.nowcomputing.f.a("BACKUP_PROGRESS_HEADING"));
      this.k.setAlignmentX(0.5F);
      am.a(this.a, this.k, com.nowcomputing.f.q.j, Color.white);
      this.a.add(Box.createVerticalStrut(4));
      this.l.setText(com.nowcomputing.f.a("BACKUP_PROGRESS_1"));
      this.l.setAlignmentX(0.5F);
      am.a(this.a, this.l, com.nowcomputing.f.q.k, Color.white);
      this.m.setAlignmentX(0.5F);
      am.a(this.a, this.m, com.nowcomputing.f.q.k, Color.white);
      this.m.setVisible(false);
      this.a.add(Box.createVerticalStrut(10));
      this.n.setBorder(BorderFactory.createEmptyBorder());
      this.n.setAlignmentX(0.5F);
      this.n.setMinimumSize(new Dimension(534, 24));
      this.n.setMaximumSize(new Dimension(534, 24));
      this.n.setIndeterminate(true);
      am.a(this.a, this.n, com.nowcomputing.f.q.p, com.nowcomputing.f.h.a());
      this.n.setVisible(true);
      this.a.add(Box.createVerticalStrut(10));
      this.o = new JPanel();
      this.o.setOpaque(false);
      this.a.add(this.o);
      this.p.setBackground(com.nowcomputing.f.h.k);
      this.p.setText(com.nowcomputing.f.a("BACKUP_CANCEL_BUTTON"));
      this.p.addActionListener(new c(this));
      this.o.setVisible(true);
      this.o.add(this.p);
      this.q.setText(com.nowcomputing.f.a("QUIT_AND_EJECT"));
      this.u.setText(com.nowcomputing.f.a("GOTO_MAIN_MENU"));
      this.s = new JPanel();
      this.s.setOpaque(false);
      this.s.setAlignmentX(0.5F);
      this.s.add(this.q);
      this.s.add(this.u);
      return this.a;
   }

   private JPanel b(int var1) {
      this.b = new JPanel();
      this.b.setMinimumSize(new Dimension(800, var1));
      this.b.setMaximumSize(new Dimension(800, var1));
      this.b.setLayout((LayoutManager)null);
      this.b.setOpaque(false);
      this.r.setEditable(false);
      this.r.setMargin((Insets)null);
      this.r.setBorder(new EmptyBorder(0, 0, 0, 0));
      this.r.setBackground(Color.BLACK);
      this.r.setContentType("text/html");
      this.r.setText("<html><body style='background-color:#000000'><div style='width:100%; height:50px;'></div><center><h1 style='color:#e0d0d0'>Loading news..</h1></center></body></html>");
      this.r.addHyperlinkListener(new d(this));
      JScrollPane var2 = new JScrollPane(this.r);
      var2.setBounds(30, 0, 740, 290);
      this.b.add(var2);
      this.b.add(this.r);
      var2.setViewportView(this.r);
      var2.setBorder(BorderFactory.createBevelBorder(1));
      return this.b;
   }

   private void a(ActionEvent var1) {
      this.setCursor(Cursor.getPredefinedCursor(3));

      try {
         if (this.j != null) {
            this.j.d();
         }

         this.d();
      } finally {
         this.setCursor(Cursor.getDefaultCursor());
      }

   }

   void c() {
      this.setVisible(false);
      this.n();
   }

   public void d() {
      this.k.setText(com.nowcomputing.f.a("BACKUP_CANCELLED_HEADING"));
      this.l.setText(com.nowcomputing.f.a("BACKUP_CANCELLED_1"));
      this.m.setText(com.nowcomputing.f.a("BACKUP_FINISHED_1"));
      this.m.setVisible(true);
      this.m();
   }

   private void m() {
      this.i = true;
      this.t.cancel();
      this.n.setVisible(false);
      this.o.setVisible(false);
      this.a.add(this.s);
      this.q.requestFocusInWindow();
   }

   private void n() {
      this.i = false;
      this.a();
      this.revalidate();
   }

   public JButton e() {
      return this.q;
   }

   public JButton f() {
      return this.u;
   }

   // $FF: synthetic method
   static void a(b var0, ActionEvent var1) {
      var0.a(var1);
   }
}
