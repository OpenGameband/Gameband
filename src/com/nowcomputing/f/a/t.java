package com.nowcomputing.f.a;

import com.nowcomputing.GamebandConfig;
import com.nowcomputing.S;
import com.nowcomputing.f.N;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class t extends JPanel implements MouseListener, MouseMotionListener {
   private static final Logger a = Logger.getLogger(S.class.getName());
   private final List b = new ArrayList();
   private final com.nowcomputing.f.b.c c = new com.nowcomputing.f.b.c(this);
   private com.nowcomputing.f.b.e d;
   private int e;
   private int f;
   private p g;

   t(p var1) {
      this.g = var1;
      this.addMouseListener(this);
      this.addMouseMotionListener(this);
   }

   public void a() {
      Iterator var1 = this.b.iterator();

      while(var1.hasNext()) {
         com.nowcomputing.f.b.e var2 = (com.nowcomputing.f.b.e)var1.next();
         if (var2.j()) {
            var2.d();
         }
      }

   }

   public void b() {
      Iterator var1 = this.b.iterator();

      while(var1.hasNext()) {
         com.nowcomputing.f.b.e var2 = (com.nowcomputing.f.b.e)var1.next();
         var2.e();
      }

   }

   public List c() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.b.iterator();

      while(var2.hasNext()) {
         com.nowcomputing.f.b.e var3 = (com.nowcomputing.f.b.e)var2.next();
         if (var3.j()) {
            var1.add(var3.b());
         }
      }

      return var1;
   }

   public void a(String var1, com.nowcomputing.a.d var2, boolean var3) {
      if (var1 != null && !var1.equals("")) {
         Object var4;
         if (var2 == com.nowcomputing.a.d.a) {
            this.d();
            com.nowcomputing.d.o var5 = new com.nowcomputing.d.o(com.nowcomputing.d.f.l());
            com.nowcomputing.d var6;
            if (var3) {
               var6 = com.nowcomputing.d.a("     " + var1 + "     ");
            } else {
               var6 = com.nowcomputing.d.a("     " + var1);
            }

            var5.b(var6);
            var4 = new com.nowcomputing.f.b.m(this, var5, var3);
         } else {
            var4 = new com.nowcomputing.f.b.l(this, new com.nowcomputing.d.a(com.nowcomputing.d.f.l()), var1, var2, var3);
         }

         this.c((com.nowcomputing.f.b.e)var4);
         ((com.nowcomputing.f.b.e)var4).a(true);
      }

   }

   public void a(File var1, com.nowcomputing.a.d var2, boolean var3) {
      try {
         BufferedImage var4 = ImageIO.read(var1);
         com.nowcomputing.f.b.j var5 = new com.nowcomputing.f.b.j(this, new com.nowcomputing.d.a(com.nowcomputing.d.f.l()), com.nowcomputing.d.a(var4, Math.min(49, var4.getWidth()), Math.min(49, var4.getHeight())), var2, var3);
         this.c(var5);
         var5.a(true);
      } catch (IOException var6) {
      }

   }

   public void a(File var1) {
      com.nowcomputing.f.b.a var2 = new com.nowcomputing.f.b.a(this, new com.nowcomputing.d.a(com.nowcomputing.d.f.l()));
      ((com.nowcomputing.f.b.a)var2).a(var1);
      this.c(var2);
      var2.a(true);
   }

   public void a(com.nowcomputing.a var1) {
      com.nowcomputing.f.b.a var2 = new com.nowcomputing.f.b.a(this, new com.nowcomputing.d.a(com.nowcomputing.d.f.l()));
      var2.a(var1);
      this.c(var2);
      var2.a(true);
   }

   public void a(com.nowcomputing.f.b.e var1) {
      this.g.a(var1);
      this.g.d(true);
   }

   public void b(com.nowcomputing.f.b.e var1) {
      this.b.remove(var1);
      this.remove(var1);
      this.e();
      this.validate();
      this.repaint();
      this.g.d(true);
   }

   public boolean a(com.nowcomputing.f.b.e var1, boolean var2) {
      if (var2 && !(var1 instanceof com.nowcomputing.f.b.n) && !(var1 instanceof com.nowcomputing.f.b.b) && !this.g.h()) {
         N.a(this.g.j(), new String[]{com.nowcomputing.f.a("ERROR_MAX_ANIMATIONS_HEADER"), com.nowcomputing.f.a("ERROR_MAX_ANIMATIONS_1"), com.nowcomputing.f.a("ERROR_MAX_ANIMATIONS_2")});
         return false;
      } else {
         var1.a(var2);
         this.g.d(true);
         return true;
      }
   }

   public com.nowcomputing.d.f d() {
      return this.g.g();
   }

   public void a(boolean var1) {
      this.g.d(var1);
   }

   void a(List var1) {
      this.b.clear();
      boolean var2 = false;
      boolean var3 = false;
      boolean var4 = false;
      Iterator var5 = var1.iterator();

      while(var5.hasNext()) {
         com.nowcomputing.d.g var6 = (com.nowcomputing.d.g)var5.next();
         switch(var6.e()) {
         case 0:
         case 1:
            this.c(new com.nowcomputing.f.b.n(this, (com.nowcomputing.d.q)var6));
            var2 = true;
            break;
         case 2:
         case 3:
            this.c(new com.nowcomputing.f.b.b(this, (com.nowcomputing.d.b)var6));
            var3 = true;
            break;
         case 16:
            boolean var7 = false;
            com.nowcomputing.d.n var8 = var6.c();
            GamebandConfig.d var9 = GamebandConfig.c.a(var8.i());
            var7 = var9 == GamebandConfig.d.b;
            com.nowcomputing.f.b.m var10 = new com.nowcomputing.f.b.m(this, (com.nowcomputing.d.o)var6, var7);
            this.c(var10);
            break;
         case 17:
            this.c(new com.nowcomputing.f.b.d(this, new com.nowcomputing.d.c(com.nowcomputing.d.f.l())));
            var4 = true;
            break;
         case 32:
            try {
               com.nowcomputing.f.b.a var11 = new com.nowcomputing.f.b.a(this, (com.nowcomputing.d.a)var6);
               var11.a(((com.nowcomputing.d.a)var6).b());
               this.c(var11);
            } catch (IOException var12) {
               a.log(Level.WARNING, "", var12);
            }
         case 34:
         }
      }

      if (!var2) {
         com.nowcomputing.f.b.n var13 = new com.nowcomputing.f.b.n(this, new com.nowcomputing.d.q(com.nowcomputing.d.f.l()));
         var13.a(false);
         this.c(var13);
      }

      if (!var3) {
         com.nowcomputing.f.b.b var14 = new com.nowcomputing.f.b.b(this, new com.nowcomputing.d.b(com.nowcomputing.d.f.l()));
         var14.a(false);
         this.c(var14);
      }

      if (!var4) {
         com.nowcomputing.f.b.d var15 = new com.nowcomputing.f.b.d(this, new com.nowcomputing.d.c(com.nowcomputing.d.f.l()));
         var15.a(false);
         this.c(var15);
      }

   }

   private void c(com.nowcomputing.f.b.e var1) {
      this.b.add(var1);
      this.a(var1, this.b.size() - 1);
   }

   private void a(com.nowcomputing.f.b.e var1, int var2) {
      var1.setBounds(0, var2 * 60, 520, 48);
      this.add(var1);
   }

   private void e() {
      for(int var1 = 0; var1 < this.b.size(); ++var1) {
         com.nowcomputing.f.b.e var2 = (com.nowcomputing.f.b.e)this.b.get(var1);
         this.remove(var2);
         this.a(var2, var1);
      }

      this.g.d(true);
   }

   private void a(int var1) {
      int var2 = var1 - this.getY();
      int var3 = this.b.indexOf(this.c);
      int var4 = var3;
      if (var2 >= this.c.getY() + 48 + 12) {
         var4 = var3 + 1;
      } else if (var2 <= this.c.getY() - 60) {
         var4 = var3 - 1;
      }

      if (var4 != var3) {
         this.b.remove(this.c);
         this.b.add(var4, this.c);
      }

      this.e();
   }

   private void f() {
      Iterator var1 = this.b.iterator();

      while(var1.hasNext()) {
         com.nowcomputing.f.b.e var2 = (com.nowcomputing.f.b.e)var1.next();
         this.remove(var2);
      }

   }

   private void d(com.nowcomputing.f.b.e var1) {
      this.d = var1;
      this.c.setLocation(var1.getLocation());
      Point var2 = var1.getLocationOnScreen();
      this.f();
      int var3 = this.b.indexOf(var1);
      this.b.remove(var3);
      this.b.add(var3, this.c);
      this.g.l().add(var1);
      this.g.l().setLayer(var1, JLayeredPane.DRAG_LAYER);
      Point var4 = this.g.l().getLocationOnScreen();
      var1.setLocation(var2.x - var4.x, var2.y - var4.y);
   }

   private void e(com.nowcomputing.f.b.e var1) {
      int var2 = this.b.indexOf(this.c);
      this.b.remove(var2);
      this.b.add(var2, var1);
      this.remove(this.c);
      this.g.l().remove(var1);
      this.a(var1, var2);
      this.g.l().repaint();
   }

   public void mouseDragged(MouseEvent var1) {
      if (this.d == null) {
         this.d = this.a(var1);
         if (this.d == null) {
            return;
         }

         this.e = var1.getX();
         this.f = var1.getY() - this.d.getY();
         this.d(this.d);
      }

      int var2 = S.a(35 + var1.getX() - this.e, -485, 520);
      int var3 = this.getY() + (this.b.size() - 1) * 60;
      int var4 = S.a(this.getY() + var1.getY() - this.f, this.getY() - 24, var3 + 24);
      this.d.setLocation(var2, var4);
      this.a(var4);
      this.g.l().repaint();
   }

   private com.nowcomputing.f.b.e a(MouseEvent var1) {
      t var2 = (t)var1.getSource();
      Component var3 = var2.getComponentAt(var1.getX(), var1.getY());
      return var3 instanceof com.nowcomputing.f.b.e ? (com.nowcomputing.f.b.e)var3 : null;
   }

   public void mousePressed(MouseEvent var1) {
   }

   public void mouseReleased(MouseEvent var1) {
      if (this.d != null) {
         this.e(this.d);
         this.d = null;
      }

   }

   public void mouseMoved(MouseEvent var1) {
   }

   public void mouseClicked(MouseEvent var1) {
   }

   public void mouseEntered(MouseEvent var1) {
   }

   public void mouseExited(MouseEvent var1) {
   }
}
