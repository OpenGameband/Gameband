package b.a.a.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

final class Class34 extends Class32 implements Class7 {
   private Class37 field72 = null;
   private int field73 = 0;
   private int field74 = 0;
   private final Class34 field75;
   private final List field76 = new ArrayList();
   private final List field77 = new ArrayList();
   private List field78 = null;
   private static final Class51 field79 = new Class10();

   Class34(Class34 var1) {
      this.field75 = var1;
   }

   public Class7 method146(JComponent var1, int var2) {
      this.method109(var1);
      this.field72.method172(var1, var2);
      return this;
   }

   public Class7 method147(JComponent... var1) {
      JComponent[] var2 = var1;
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         JComponent var5 = var2[var4];
         this.method146(var5, 1);
      }

      return this;
   }

   public Class7 method148() {
      return this.method149(1);
   }

   public Class7 method149(int var1) {
      return this.method146((JComponent)null, var1);
   }

   public Class7 method150() {
      return this.method151((JLabel)null, 0);
   }

   private Class7 method151(JLabel var1, int var2) {
      if (this.field72 != null) {
         this.field72.method177(1);
         this.field73 += this.field72.method176();
      }

      Class37 var3 = this.field75 != null ? this.field75.method167(this.field73) : null;
      this.field72 = new Class37(new Class53(this.field77), var3, this.method108(), var1, var2);
      this.field76.add(this.field72);
      return this;
   }

   void method152() {
      Iterator var1 = this.field76.iterator();

      while(var1.hasNext()) {
         Class37 var2 = (Class37)var1.next();
         var2.method173();
      }

   }

   int method153(int var1) {
      return this.method168(var1).method223();
   }

   void method154(Class16 var1) {
      Iterator var2 = this.field76.iterator();

      while(var2.hasNext()) {
         Class37 var3 = (Class37)var2.next();
         JLabel var4 = var3.method174();
         if (var4 != null) {
            var4.setHorizontalAlignment(var1.method66());
         }
      }

   }

   int method155(int var1) {
      return this.method168(var1).method221();
   }

   int method156() {
      int var1 = 0;

      Class37 var3;
      for(Iterator var2 = this.field76.iterator(); var2.hasNext(); var1 += var3.method176() > 0 ? var3.method176() : 1) {
         var3 = (Class37)var2.next();
      }

      return var1;
   }

   void method157(int var1) {
      int var2 = var1;
      Iterator var3 = this.field76.iterator();

      while(var3.hasNext()) {
         Class37 var4 = (Class37)var3.next();
         if (var3.hasNext()) {
            var2 -= var4.method176();
         } else {
            var4.method177(var2);
         }
      }

      this.field74 = var1;
   }

   int method158(int var1) {
      return this.method168(var1).method222();
   }

   int method159(int var1, int var2, Class25 var3) {
      return this.method168(var1).method224(var2, var3);
   }

   int method160() {
      int var1 = 0;

      Class37 var3;
      for(Iterator var2 = this.field76.iterator(); var2.hasNext(); var1 = Math.max(var1, var3.method181())) {
         var3 = (Class37)var2.next();
      }

      return var1;
   }

   int method161() {
      Class29 var1 = Class29.method94();
      int var2 = 0;

      for(int var3 = 0; var3 < this.field76.size() - 1; ++var3) {
         List var4 = ((Class37)this.field76.get(var3)).method183();
         List var5 = ((Class37)this.field76.get(var3 + 1)).method183();
         if (!var4.isEmpty() && !var5.isEmpty()) {
            JComponent var6 = ((Class52)var4.get(var4.size() - 1)).method225();
            JComponent var7 = ((Class52)var5.get(0)).method225();
            int var8 = var1.method96(var6, var7, ComponentPlacement.UNRELATED, this.method108().method213());
            var2 = Math.max(var2, var8);
         }
      }

      return var2;
   }

   boolean method162() {
      Iterator var1 = this.field76.iterator();

      Class37 var2;
      do {
         if (!var1.hasNext()) {
            return true;
         }

         var2 = (Class37)var1.next();
      } while(var2.method175() == null);

      return false;
   }

   JComponent method163() {
      return this.field76.isEmpty() ? null : ((Class37)this.field76.get(0)).method175();
   }

   List method164() {
      return this.field77;
   }

   List method165() {
      if (this.field78 == null) {
         this.field78 = new ArrayList(this.field77.size() + this.field76.size());

         Class37 var2;
         for(Iterator var1 = this.field76.iterator(); var1.hasNext(); this.field78.addAll(var2.method183())) {
            var2 = (Class37)var1.next();
            if (var2.method174() != null) {
               this.field78.add(new Class52(1, var2.method174()));
            }
         }
      }

      return this.field78;
   }

   int method166(Class6 var1, int var2, int var3, int var4, int var5, int var6, int var7, List var8) {
      int var9 = var2;
      int var10 = 0;
      int var11 = var7 / this.field74;
      int var12 = 0;
      Iterator var13 = var8.iterator();
      Iterator var14 = this.field76.iterator();

      while(var14.hasNext()) {
         Class37 var15 = (Class37)var14.next();
         int var16 = (Integer)var13.next();
         int var17 = var11;

         int var18;
         for(var18 = 1; var18 < var15.method176(); ++var18) {
            var17 += var4 + var11;
            int var19 = (Integer)var13.next();
            if (var19 > 0) {
               var17 += var19 + var3;
            }
         }

         var12 += var15.method176();
         if (var12 == this.field74) {
            var18 = var7 % this.field74;
            var17 += var18;
         }

         var18 = var15.method182(var1, var9, this.method117(), this.method116(), var3, var17, var16);
         var10 = Math.max(var10, var18);
         var9 += var17 + var4;
         if (var16 > 0) {
            var9 += var16 + var3;
         }
      }

      return var10;
   }

   Class37 method167(int var1) {
      int var2 = 0;
      Iterator var3 = this.field76.iterator();

      while(var3.hasNext()) {
         Class37 var4 = (Class37)var3.next();
         if (var2 == var1) {
            return var4;
         }

         var2 += var4.method176();
         if (var2 > var1) {
            break;
         }
      }

      return null;
   }

   private Class51 method168(int var1) {
      Class37 var2 = this.method167(var1);
      return (Class51)(var2 != null ? var2 : field79);
   }
}
