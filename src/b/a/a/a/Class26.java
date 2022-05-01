package b.a.a.a;

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;

class Class26 implements Class41 {
   protected final Map field57 = new HashMap();

   public Class26 method86(Class11 var1) {
      return this.method87(var1.method58(), var1);
   }

   public Class26 method87(Class var1, Class41 var2) {
      this.field57.put(var1, var2);
      return this;
   }

   public boolean method88(Component var1) {
      Class41 var2 = this.method90(var1);
      return var2 != null ? var2.method189(var1) : false;
   }

   public int method89(Component var1, int var2) {
      Class41 var3 = this.method90(var1);
      return var3 != null ? var3.method190(var1, var2) : var2;
   }

   protected final Class41 method90(Component var1) {
      Class var2 = var1.getClass();

      while(true) {
         Class41 var3 = (Class41)this.field57.get(var2);
         if (var3 != null) {
            return var3;
         }

         if (var2 == Component.class) {
            return null;
         }

         var2 = var2.getSuperclass().asSubclass(Component.class);
      }
   }
}
