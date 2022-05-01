package b.a.a.a;

import java.util.Iterator;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

final class Class37 implements Class51 {
   private static final JComponent field84 = new JPanel();
   private final List field85;
   private final Class37 field86;
   private final Class45 field87;
   private final JLabel field88;
   private int field89;
   private boolean field90;
   private int field91 = 0;
   private int field92 = 0;

   Class37(List var1, Class37 var2, Class45 var3, JLabel var4, int var5) {
      this.field85 = var1;
      this.field86 = var2;
      this.field87 = var3;
      this.field88 = var4;
      this.field89 = var5 <= 0 ? 0 : var5;
      if (this.field88 != null) {
         this.field87.method210(this.field88);
      }

   }

   void method172(JComponent var1, int var2) {
      Class52 var3;
      if (var1 != null) {
         var3 = new Class52(var2, var1);
         this.field87.method210(var1);
      } else {
         var3 = new Class52(var2, field84);
      }

      this.field91 += var2;
      this.field85.add(var3);
   }

   void method173() {
      if (this.field90) {
         if (this.field86.method179() != this.method179()) {
            Iterator var1 = this.field85.iterator();

            while(var1.hasNext()) {
               Class52 var2 = (Class52)var1.next();
               if (!var2.method228()) {
                  JComponent var3 = Class20.method74(var2.method232(), "spanRow() cannot work on a sub-grid where the number of columns is different from the above sub-grid");
                  var2.method231(var3);
                  this.field87.method210(var3);
               }
            }
         }

      }
   }

   JLabel method174() {
      return this.field88;
   }

   JComponent method175() {
      if (this.field88 != null) {
         return this.field88;
      } else {
         return this.field85.isEmpty() ? null : ((Class52)this.field85.get(0)).method225();
      }
   }

   public int method176() {
      return this.field89;
   }

   public void method177(int var1) {
      if (this.field86 != null && this.field90) {
         this.field89 = this.field86.method176();
      }

      if (this.field89 == 0) {
         this.field89 = var1;
      }

   }

   public int method178() {
      return (this.field88 != null ? this.field88.getPreferredSize().width : 0) + this.field92;
   }

   public int method179() {
      int var1 = 0;

      Class52 var3;
      for(Iterator var2 = this.field85.iterator(); var2.hasNext(); var1 += var3.method232()) {
         var3 = (Class52)var2.next();
      }

      return var1;
   }

   public int method180(int var1, Class25 var2) {
      int var3 = 0;
      int var4 = this.method179();
      float var5 = (float)var4 / (float)var1;

      int var8;
      for(Iterator var6 = this.field85.iterator(); var6.hasNext(); var3 = Math.max(var3, var8)) {
         Class52 var7 = (Class52)var6.next();
         var8 = var2.method85(var7);
         var8 = (int)((float)var8 * var5 / (float)var7.method232());
      }

      return var3;
   }

   public int method181() {
      return Class1.method4(this.field88, this.field85, this.field87.method213());
   }

   public int method182(Class6 var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = var2;
      int var9 = 0;
      if (var7 > 0) {
         if (this.field88 != null) {
            var9 = Math.max(0, var1.method21(this.field88, var2 + this.field92, var7 - this.field92, var3, var4));
         }

         var8 = var2 + var7 + var5;
      }

      int var10 = this.method179();
      if (var10 > 0) {
         int var11 = var6 - (var10 - 1) * var5;
         int var12 = var11 / var10;
         int var13 = var11 % var10;

         int var17;
         for(Iterator var14 = this.field85.iterator(); var14.hasNext(); var8 += var17 + var5) {
            Class52 var15 = (Class52)var14.next();
            int var16 = var15.method232();
            var17 = var12 * var16 + (var16 - 1) * var5;
            if (!var14.hasNext()) {
               var17 += var13;
            }

            if (var15.method228()) {
               JComponent var18 = var15.method225();
               var9 = Math.max(0, var1.method21(var18, var8, var17, var3, var4));
            }
         }
      }

      return var9;
   }

   public List method183() {
      return this.field85;
   }

   static {
      field84.setOpaque(false);
   }
}
