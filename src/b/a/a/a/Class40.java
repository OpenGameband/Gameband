package b.a.a.a;

import java.util.ArrayList;
import java.util.List;

class Class40 implements Class4 {
   private final double field95;
   private final List field96;
   // $FF: synthetic field
   final Class3 field97;

   Class40(Class3 var1, double var2) {
      this.field97 = var1;
      this.field96 = new ArrayList();
      this.field95 = var2;
   }

   public Class5 method185() {
      return (Class5)Class3.method12(this.field97, new Class22(), this.field95, this.field96);
   }

   public Class5 method186() {
      return (Class5)Class3.method12(this.field97, new Class18(), this.field95, this.field96);
   }

   public Class7 method187() {
      return ((Class34)Class3.method12(this.field97, this.method188(), this.field95, this.field96)).method150();
   }

   private Class34 method188() {
      if (!Class3.method13(this.field97).isEmpty()) {
         Class32 var1 = (Class32)Class3.method13(this.field97).get(Class3.method13(this.field97).size() - 1);
         if (var1 instanceof Class34) {
            return new Class34((Class34)var1);
         }
      }

      return new Class34((Class34)null);
   }
}
