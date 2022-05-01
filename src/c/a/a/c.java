package c.a.a;

import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class c extends HashMap implements b, d, Map {
   public static void a(Map var0, Writer var1) {
      if (var0 == null) {
         var1.write("null");
      } else {
         boolean var2 = true;
         Iterator var3 = var0.entrySet().iterator();
         var1.write(123);

         while(var3.hasNext()) {
            if (var2) {
               var2 = false;
            } else {
               var1.write(44);
            }

            Entry var4 = (Entry)var3.next();
            var1.write(34);
            var1.write(a(String.valueOf(var4.getKey())));
            var1.write(34);
            var1.write(58);
            e.a(var4.getValue(), var1);
         }

         var1.write(125);
      }
   }

   public void a(Writer var1) {
      a(this, var1);
   }

   public static String a(Map var0) {
      if (var0 == null) {
         return "null";
      } else {
         StringBuffer var1 = new StringBuffer();
         boolean var2 = true;
         Iterator var3 = var0.entrySet().iterator();
         var1.append('{');

         while(var3.hasNext()) {
            if (var2) {
               var2 = false;
            } else {
               var1.append(',');
            }

            Entry var4 = (Entry)var3.next();
            a(String.valueOf(var4.getKey()), var4.getValue(), var1);
         }

         var1.append('}');
         return var1.toString();
      }
   }

   public String a() {
      return a((Map)this);
   }

   private static String a(String var0, Object var1, StringBuffer var2) {
      var2.append('"');
      if (var0 == null) {
         var2.append("null");
      } else {
         e.a(var0, var2);
      }

      var2.append('"').append(':');
      var2.append(e.a(var1));
      return var2.toString();
   }

   public String toString() {
      return this.a();
   }

   public static String a(String var0) {
      return e.a(var0);
   }
}
