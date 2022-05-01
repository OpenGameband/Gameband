package b.a.a.a;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JComponent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Class8 implements LayoutManager2 {
   private final Class3 field14;
   private final Container field15;
   private final Class45 field16;
   private final Class42 field17;
   private Class41 field18;
   private Dimension field19 = null;
   private Dimension field20 = null;
   private Dimension field21 = null;
   private int field22;
   private int field23;
   private int field24;
   private int field25;
   private int field26;
   private int field27;
   private int field28;
   private double field29;
   private double field30 = 1.0D;
   private double field31 = 1.0D;
   private double field32 = 1.0D;
   private double field33 = 1.0D;
   private boolean field34 = false;
   private Class16 field35;
   private boolean field36;
   private final List field37;
   private final List field38;
   private int field39;
   private int field40;
   private int field41;

   Class8(Class3 var1, Class45 var2, List var3, Class42 var4) {
      this.field35 = Class16.field49;
      this.field36 = true;
      this.field38 = new ArrayList();
      this.field14 = var1;
      this.field16 = var2;
      this.field15 = this.field16.method213();
      this.field37 = var3;
      this.field17 = var4;
   }

   void method27(double var1, double var3, double var5, double var7) {
      this.field30 = var1 < 0.0D ? 0.0D : var1;
      this.field31 = var3 < 0.0D ? 0.0D : var3;
      this.field32 = var5 < 0.0D ? 0.0D : var5;
      this.field33 = var7 < 0.0D ? 0.0D : var7;
   }

   void method28(Class41 var1) {
      this.field18 = var1;
   }

   public void addLayoutComponent(String var1, Component var2) {
   }

   public void addLayoutComponent(Component var1, Object var2) {
      this.field16.method212();
   }

   public void removeLayoutComponent(Component var1) {
      throw new IllegalArgumentException("Do not use this method");
   }

   public void layoutContainer(Container var1) {
      this.field16.method209(var1);
      if (!this.field37.isEmpty()) {
         synchronized(var1.getTreeLock()) {
            this.method37();
            double var3 = 0.0D;
            if (this.field29 > 0.0D) {
               var3 = Math.max(0.0D, (double)(var1.getHeight() - this.field19.height) / this.field29);
            }

            boolean var5 = this.field17.method191();
            int var6 = this.method30();
            int var7 = this.method29();
            int var8 = var1.getWidth();
            var8 = Math.max(var8, this.field20.width);
            int var9 = var8 - this.method30() - this.method32();
            int var10 = var9;
            if (this.field39 > 0) {
               var10 = var9 - (this.field39 + this.field40 * this.field26);
            }

            var10 -= (this.field41 - 1) * this.field28;
            Class6 var11 = new Class6(this.field18, var8, var5, this.field37);
            Iterator var12 = this.field37.iterator();

            while(var12.hasNext()) {
               Class32 var13 = (Class32)var12.next();
               if (!var13.method134()) {
                  var11.method19(var7);
                  int var14 = (int)(var13.method121() * var3);
                  var11.method18(var14 + var13.method117());
                  var13.method140(var11, var6, this.field26, this.field28, this.field27, var9, var10, this.field38);
                  var13.method118(var13.method117() + var14);
                  var7 += var13.method119() + var13.method113();
               }
            }

            int var19 = 0;

            for(Iterator var20 = this.field37.iterator(); var20.hasNext(); ++var19) {
               Class32 var21 = (Class32)var20.next();
               Iterator var15 = var21.method138().iterator();

               while(var15.hasNext()) {
                  Class33 var16 = (Class33)var15.next();
                  if (var16.method144() && !var16.method145()) {
                     var11.method20(var19, var16.method60(), var16.method143());
                  }
               }
            }

         }
      }
   }

   public Dimension minimumLayoutSize(Container var1) {
      this.field16.method209(var1);
      this.method37();
      return new Dimension(this.field20);
   }

   public Dimension preferredLayoutSize(Container var1) {
      this.field16.method209(var1);
      this.method37();
      return new Dimension(this.field19);
   }

   public Dimension maximumLayoutSize(Container var1) {
      this.field16.method209(var1);
      this.method37();
      return new Dimension(this.field21);
   }

   public float getLayoutAlignmentX(Container var1) {
      return 0.5F;
   }

   public float getLayoutAlignmentY(Container var1) {
      return 0.5F;
   }

   public void invalidateLayout(Container var1) {
      this.method53();
   }

   private int method29() {
      double var10001 = this.field30 * (double)this.field22;
      return this.field15.getInsets().top + (int)var10001;
   }

   private int method30() {
      double var10001 = this.field31 * (double)this.field23;
      return this.field15.getInsets().left + (int)var10001;
   }

   private int method31() {
      double var10001 = this.field32 * (double)this.field24;
      return this.field15.getInsets().bottom + (int)var10001;
   }

   private int method32() {
      double var10001 = this.field33 * (double)this.field25;
      return this.field15.getInsets().right + (int)var10001;
   }

   private void method33() {
      this.method34();
      this.method35();
   }

   private void method34() {
      this.field26 = 0;
      this.field27 = 0;
      this.field28 = 0;

      Class32 var2;
      for(Iterator var1 = this.field37.iterator(); var1.hasNext(); this.field28 = Math.max(this.field28, var2.method133())) {
         var2 = (Class32)var1.next();
         this.field26 = Math.max(this.field26, var2.method131());
         this.field27 = Math.max(this.field27, var2.method132());
      }

   }

   private void method35() {
      Class29 var1 = Class29.method94();
      int var2 = 0;
      Iterator var3 = this.field37.iterator();

      label49:
      while(var3.hasNext()) {
         Class32 var4 = (Class32)var3.next();
         ++var2;
         if (!var4.method134()) {
            Class32 var5 = this.method50(var2);
            if (var5 == null) {
               break;
            }

            int var6 = 0;
            int var7 = 0;
            List var8 = var4.method139();
            List var9 = var5.method139();
            ComponentPlacement var10;
            if (var4.method111()) {
               var10 = ComponentPlacement.UNRELATED;
            } else {
               var10 = ComponentPlacement.RELATED;
            }

            Iterator var11 = var8.iterator();

            while(true) {
               Class33 var12;
               do {
                  if (!var11.hasNext()) {
                     var4.method112(var7);
                     continue label49;
                  }

                  var12 = (Class33)var11.next();
               } while(!var12.method145());

               JComponent var13 = var12.method60();
               int var14 = var13.getPreferredSize().height;
               Iterator var15 = var9.iterator();

               while(var15.hasNext()) {
                  Class33 var16 = (Class33)var15.next();
                  if (var16.method144()) {
                     JComponent var17 = var16.method60();
                     int var18 = var17.getPreferredSize().height;
                     int var19 = var1.method95(var13, var17, var10, this.field15);
                     int var20 = var14 + var19 + var18;
                     if (var20 > var6) {
                        var6 = var20;
                        var7 = var19;
                     }
                  }
               }
            }
         }
      }

   }

   private void method36() {
      Iterator var1 = Class19.method71(this.field37).iterator();
      if (var1.hasNext()) {
         int var2 = 0;
         int var3 = 0;
         Class32 var5 = (Class32)var1.next();

         Class32 var4;
         int var6;
         while(var1.hasNext()) {
            var4 = var5;
            var5 = (Class32)var1.next();
            if (var4.method121() == 0.0D) {
               var6 = var4.method117() + var4.method113() - var4.method116() + var5.method116();
               if (var4.method111()) {
                  var3 = Math.max(var3, var6);
               } else {
                  var2 = Math.max(var2, var6);
               }
            }
         }

         var1 = Class19.method71(this.field37).iterator();
         var5 = (Class32)var1.next();

         while(var1.hasNext()) {
            var4 = var5;
            var5 = (Class32)var1.next();
            if (var4.method121() == 0.0D) {
               var6 = var4.method111() ? var3 : var2;
               var6 += var4.method116() - var4.method117() - var5.method116();
               var4.method112(var6);
            }
         }

      }
   }

   private void method37() {
      if (this.field19 == null) {
         if (this.field37.isEmpty()) {
            this.field19 = new Dimension(0, 0);
            this.field20 = new Dimension(0, 0);
         } else {
            this.method39();
            Iterator var1 = this.field37.iterator();

            Class32 var2;
            while(var1.hasNext()) {
               var2 = (Class32)var1.next();
               var2.method137();
            }

            this.method46();
            this.method33();
            this.method38();
            var1 = this.field37.iterator();

            while(var1.hasNext()) {
               var2 = (Class32)var1.next();
               var2.method114();
               var2.method115(this.field35);
            }

            if (this.field34) {
               this.method36();
            }

            this.method41();
            int var7 = this.method45();
            int var8 = this.method43(Class38.field93);
            var8 = Math.max(var7, var8);
            int var3 = this.method43(Class49.field109);
            var3 = Math.max(var7, var3);
            int var4 = this.method42() + this.method29() + this.method31() + 1;
            this.field29 = 0.0D;

            Class32 var6;
            for(Iterator var5 = this.field37.iterator(); var5.hasNext(); this.field29 += var6.method121()) {
               var6 = (Class32)var5.next();
            }

            this.field19 = new Dimension(var8, var4);
            this.field20 = new Dimension(var3, var4);
            int var9 = this.field29 > 0.0D ? Integer.MAX_VALUE : var4;
            this.field21 = new Dimension(Integer.MAX_VALUE, var9);
         }
      }
   }

   private void method38() {
      int var1 = 0;

      for(Iterator var2 = this.field37.iterator(); var2.hasNext(); ++var1) {
         Class32 var3 = (Class32)var2.next();
         Iterator var4 = var3.method138().iterator();

         while(var4.hasNext()) {
            Class33 var5 = (Class33)var4.next();
            if (var5.method144()) {
               List var6 = this.field37.subList(var1, var1 + var5.method143());
               var5.method142(var6);
            }
         }
      }

   }

   private void method39() {
      this.field41 = 0;

      Iterator var1;
      Class32 var2;
      for(var1 = this.field37.iterator(); var1.hasNext(); this.field41 = Math.max(this.field41, var2.method122())) {
         var2 = (Class32)var1.next();
      }

      var1 = this.field37.iterator();

      while(var1.hasNext()) {
         var2 = (Class32)var1.next();
         var2.method123(this.field41);
      }

   }

   private int method40(int var1) {
      int var2 = 0;

      Class32 var4;
      for(Iterator var3 = this.field37.iterator(); var3.hasNext(); var2 = Math.max(var2, var4.method125(var1))) {
         var4 = (Class32)var3.next();
      }

      return var2;
   }

   private void method41() {
      this.field38.clear();
      this.field39 = 0;
      this.field40 = 0;

      for(int var1 = 0; var1 < this.field41; ++var1) {
         int var2 = 0;

         Class32 var4;
         for(Iterator var3 = this.field37.iterator(); var3.hasNext(); var2 = Math.max(var2, var4.method126(var1))) {
            var4 = (Class32)var3.next();
         }

         this.field38.add(var2);
         this.field39 += var2;
         if (var2 > 0) {
            ++this.field40;
         }
      }

   }

   private int method42() {
      int var1 = 0;

      Class32 var3;
      for(Iterator var2 = this.field37.iterator(); var2.hasNext(); var1 += var3.method117() + var3.method113()) {
         var3 = (Class32)var2.next();
      }

      return var1;
   }

   private int method43(Class25 var1) {
      int var2 = 0;

      for(int var3 = 0; var3 < this.field41; ++var3) {
         int var4 = this.method40(var3);
         int var5 = this.method44(var3, var4, var1);
         int var6 = var5 * var4 + this.field26 * (var4 - 1) + 1;
         var2 = Math.max(var2, var6);
      }

      var2 *= this.field41;
      if (this.field39 > 0) {
         var2 += this.field39 + this.field40 * this.field26;
      }

      var2 += (this.field41 - 1) * this.field28;
      var2 += this.method30() + this.method32();
      return var2;
   }

   private int method44(int var1, int var2, Class25 var3) {
      int var4 = 0;

      int var7;
      for(Iterator var5 = this.field37.iterator(); var5.hasNext(); var4 = Math.max(var4, var7)) {
         Class32 var6 = (Class32)var5.next();
         var7 = var6.method127(var1, var2, var3);
         int var8 = var6.method124(var1);
         if (var8 > 1) {
            int var9;
            for(var9 = 1; var9 < var8; ++var9) {
               var7 -= this.field28 + (Integer)this.field38.get(var1 + var9) + this.field26;
            }

            var9 = var7 % var8;
            var7 /= var8;
            if (var9 > 0) {
               ++var7;
            }
         }
      }

      return var4;
   }

   private int method45() {
      int var1 = 0;
      int var4;
      if (this.field36) {
         for(Iterator var2 = this.field37.iterator(); var2.hasNext(); var1 = Math.max(var1, var4)) {
            Class32 var3 = (Class32)var2.next();
            var4 = var3.method129();
         }
      }

      int var6 = 0;

      int var5;
      for(Iterator var7 = this.field37.iterator(); var7.hasNext(); var6 = Math.max(var6, var5)) {
         Class32 var8 = (Class32)var7.next();
         var8.method130(var1);
         var5 = var8.method128(this.field26, this.field27);
      }

      return var6 + this.method30() + this.method32() + 1;
   }

   private void method46() {
      this.method47();
      this.method48();
      this.method52();
   }

   private void method47() {
      this.field22 = 0;
      Class32 var1 = this.method49();
      if (var1 != null) {
         Class29 var2 = Class29.method94();

         int var5;
         for(Iterator var3 = var1.method139().iterator(); var3.hasNext(); this.field22 = Math.max(this.field22, var5)) {
            Class13 var4 = (Class13)var3.next();
            var5 = var2.method97(var4.method60(), this.field15);
         }
      }

   }

   private void method48() {
      this.field24 = 0;
      int var1 = 0;
      int var2 = 0;
      Class32 var3 = this.method51();
      if (var3 != null) {
         Class29 var4 = Class29.method94();
         Iterator var5 = var3.method139().iterator();

         while(var5.hasNext()) {
            Class13 var6 = (Class13)var5.next();
            int var7 = var6.method61();
            int var8 = var4.method98(var6.method60(), this.field15);
            int var9 = var7 + var8;
            if (var9 > var1) {
               var1 = var9;
               var2 = var8;
            }
         }

         this.field24 = Math.max(this.field24, var2);
      }

   }

   private Class32 method49() {
      Iterator var1 = this.field37.iterator();

      Class32 var2;
      do {
         if (!var1.hasNext()) {
            return null;
         }

         var2 = (Class32)var1.next();
      } while(var2.method134());

      return var2;
   }

   private Class32 method50(int var1) {
      for(int var2 = var1; var2 < this.field37.size(); ++var2) {
         Class32 var3 = (Class32)this.field37.get(var2);
         if (!var3.method134()) {
            return var3;
         }
      }

      return null;
   }

   private Class32 method51() {
      ListIterator var1 = this.field37.listIterator(this.field37.size());

      Class32 var2;
      do {
         if (!var1.hasPrevious()) {
            return null;
         }

         var2 = (Class32)var1.previous();
      } while(var2.method134());

      return var2;
   }

   private void method52() {
      this.field23 = 0;
      this.field25 = 0;
      Class29 var1 = Class29.method94();
      Iterator var2 = this.field37.iterator();

      while(var2.hasNext()) {
         Class32 var3 = (Class32)var2.next();
         JComponent var4 = var3.method135();
         if (var4 != null) {
            this.field23 = Math.max(this.field23, var1.method99(var4, this.field15));
         }

         JComponent var5 = var3.method136();
         if (var5 != null) {
            this.field25 = Math.max(this.field25, var1.method100(var5, this.field15));
         }
      }

   }

   private void method53() {
      this.field19 = null;
   }
}
