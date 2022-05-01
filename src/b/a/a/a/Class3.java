package b.a.a.a;

import java.awt.Container;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.RootPaneContainer;

public class Class3 {
   private static Class41 field1 = new Class21();
   private final Class8 field2;
   private final Class45 field3;
   private final Class42 field4;
   private final List field5 = new ArrayList();
   private Class32 field6 = null;
   private Class41 field7;

   public Class3(Container var1) {
      this.field7 = field1;
      if (var1 == null) {
         throw new NullPointerException("parent cannot be null");
      } else {
         Container var2 = var1;
         if (var1 instanceof RootPaneContainer) {
            var2 = ((RootPaneContainer)var1).getContentPane();
         }

         this.field3 = new Class45(var2);
         this.field4 = new Class42(var2);
         this.field2 = new Class8(this, this.field3, this.field5, this.field4);
         this.field2.method28(this.field7);
         var2.setLayout(this.field2);
      }
   }

   public Class3 method8(double var1, double var3, double var5, double var7) {
      this.field2.method27(var1, var3, var5, var7);
      return this;
   }

   public Class4 method9() {
      return new Class40(this, -1.0D);
   }

   public void method10() {
      if (this.field6 != null) {
         this.field6.method110();
      }

   }

   private Class32 method11(Class32 var1, double var2, List var4) {
      this.field6 = var1;
      this.field5.add(var1);
      var1.method107(this.field3, this.field7, this.field4);
      var1.method120(var2);
      Iterator var5 = var4.iterator();

      while(var5.hasNext()) {
         Class17 var6 = (Class17)var5.next();
         var6.method67(var1);
      }

      return var1;
   }

   // $FF: synthetic method
   static Class32 method12(Class3 var0, Class32 var1, double var2, List var4) {
      return var0.method11(var1, var2, var4);
   }

   // $FF: synthetic method
   static List method13(Class3 var0) {
      return var0.field5;
   }
}
