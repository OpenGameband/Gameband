package c.a.a;

import java.io.Writer;
import java.util.List;
import java.util.Map;

public class e {
   public static void a(Object var0, Writer var1) {
      if (var0 == null) {
         var1.write("null");
      } else if (var0 instanceof String) {
         var1.write(34);
         var1.write(a((String)var0));
         var1.write(34);
      } else if (var0 instanceof Double) {
         if (!((Double)var0).isInfinite() && !((Double)var0).isNaN()) {
            var1.write(var0.toString());
         } else {
            var1.write("null");
         }

      } else if (!(var0 instanceof Float)) {
         if (var0 instanceof Number) {
            var1.write(var0.toString());
         } else if (var0 instanceof Boolean) {
            var1.write(var0.toString());
         } else if (var0 instanceof d) {
            ((d)var0).a(var1);
         } else if (var0 instanceof b) {
            var1.write(((b)var0).a());
         } else if (var0 instanceof Map) {
            c.a((Map)var0, var1);
         } else if (var0 instanceof List) {
            dingusList.a((List)var0, var1);
         } else {
            var1.write(var0.toString());
         }
      } else {
         if (!((Float)var0).isInfinite() && !((Float)var0).isNaN()) {
            var1.write(var0.toString());
         } else {
            var1.write("null");
         }

      }
   }

   public static String a(Object var0) {
      if (var0 == null) {
         return "null";
      } else if (var0 instanceof String) {
         return "\"" + a((String)var0) + "\"";
      } else if (var0 instanceof Double) {
         return !((Double)var0).isInfinite() && !((Double)var0).isNaN() ? var0.toString() : "null";
      } else if (var0 instanceof Float) {
         return !((Float)var0).isInfinite() && !((Float)var0).isNaN() ? var0.toString() : "null";
      } else if (var0 instanceof Number) {
         return var0.toString();
      } else if (var0 instanceof Boolean) {
         return var0.toString();
      } else if (var0 instanceof b) {
         return ((b)var0).a();
      } else if (var0 instanceof Map) {
         return c.a((Map)var0);
      } else {
         return var0 instanceof List ? dingusList.a((List)var0) : var0.toString();
      }
   }

   public static String a(String var0) {
      if (var0 == null) {
         return null;
      } else {
         StringBuffer var1 = new StringBuffer();
         a(var0, var1);
         return var1.toString();
      }
   }

   static void a(String var0, StringBuffer var1) {
      for(int var2 = 0; var2 < var0.length(); ++var2) {
         char var3 = var0.charAt(var2);
         switch(var3) {
         case '\b':
            var1.append("\\b");
            continue;
         case '\t':
            var1.append("\\t");
            continue;
         case '\n':
            var1.append("\\n");
            continue;
         case '\f':
            var1.append("\\f");
            continue;
         case '\r':
            var1.append("\\r");
            continue;
         case '"':
            var1.append("\\\"");
            continue;
         case '/':
            var1.append("\\/");
            continue;
         case '\\':
            var1.append("\\\\");
            continue;
         }

         if (var3 >= 0 && var3 <= 31 || var3 >= 127 && var3 <= 159 || var3 >= 8192 && var3 <= 8447) {
            String var4 = Integer.toHexString(var3);
            var1.append("\\u");

            for(int var5 = 0; var5 < 4 - var4.length(); ++var5) {
               var1.append('0');
            }

            var1.append(var4.toUpperCase());
         } else {
            var1.append(var3);
         }
      }

   }
}
