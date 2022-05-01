package c.a.a;

import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a extends ArrayList implements b, d, List {
   public static void a(List var0, Writer var1) {
      if (var0 == null) {
         var1.write("null");
      } else {
         boolean var2 = true;
         Iterator var3 = var0.iterator();
         var1.write(91);

         while(var3.hasNext()) {
            if (var2) {
               var2 = false;
            } else {
               var1.write(44);
            }

            Object var4 = var3.next();
            if (var4 == null) {
               var1.write("null");
            } else {
               e.a(var4, var1);
            }
         }

         var1.write(93);
      }
   }

   public void a(Writer var1) {
      a(this, var1);
   }

   public static String a(List var0) {
      if (var0 == null) {
         return "null";
      } else {
         boolean var1 = true;
         StringBuffer var2 = new StringBuffer();
         Iterator var3 = var0.iterator();
         var2.append('[');

         while(var3.hasNext()) {
            if (var1) {
               var1 = false;
            } else {
               var2.append(',');
            }

            Object var4 = var3.next();
            if (var4 == null) {
               var2.append("null");
            } else {
               var2.append(e.a(var4));
            }
         }

         var2.append(']');
         return var2.toString();
      }
   }

   public String a() {
      return a((List)this);
   }

   public String toString() {
      return this.a();
   }
}
