package com.nowcomputing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class O {
   private static final Map a = new HashMap();
   private static String[] b = new String[0];

   public static String[] a() {
      return b;
   }

   public static TimeZone a(String var0) {
      return (TimeZone)a.get(var0);
   }

   public static String a(TimeZone var0) {
      String var1 = var0.getID();
      String var2 = var1.substring(var1.lastIndexOf("/") + 1).replace('_', ' ');
      Iterator var3 = a.entrySet().iterator();

      Entry var4;
      do {
         if (!var3.hasNext()) {
            return "";
         }

         var4 = (Entry)var3.next();
      } while(!((String)var4.getKey()).contains(var2));

      return (String)var4.getKey();
   }

   static {
      Pattern var0 = Pattern.compile("GMT[\\+\\-][0-9]{2}\\:[0-9]{2}");
      HashMap var1 = new HashMap();
      HashMap var2 = new HashMap();

      try {
         String[] var3 = TimeZone.getAvailableIDs();
         int var4 = var3.length;

         int var5;
         int var8;
         Iterator var11;
         TimeZone var12;
         for(var5 = 0; var5 < var4; ++var5) {
            String var6 = var3[var5];
            if (!var6.contains("SystemV")) {
               TimeZone var7 = TimeZone.getTimeZone(var6);
               if (!var0.matcher(var7.getDisplayName()).matches()) {
                  var8 = var7.getRawOffset();
                  Object var9 = (List)var1.get(var8);
                  if (var9 == null) {
                     var9 = new ArrayList();
                     var1.put(var8, var9);
                  }

                  boolean var10 = true;
                  var11 = ((List)var9).iterator();

                  while(var11.hasNext()) {
                     var12 = (TimeZone)var11.next();
                     if (var7.hasSameRules(var12)) {
                        var10 = false;
                        ((List)var2.get(var12)).add(var7);
                        break;
                     }
                  }

                  if (var10) {
                     ((List)var9).add(var7);
                     ArrayList var28 = new ArrayList();
                     var28.add(var7);
                     var2.put(var7, var28);
                  }
               }
            }
         }

         Iterator var19 = var1.entrySet().iterator();

         while(var19.hasNext()) {
            Entry var21 = (Entry)var19.next();
            var5 = (Integer)var21.getKey();
            int var24 = var5 / '\uea60';
            boolean var25 = false;
            if (var24 < 0) {
               var25 = true;
               var24 = -var24;
            }

            var8 = var24 / 60;
            int var26 = var24 - var8 * 60;
            String var27 = "GMT" + (var25 ? "-" : "+") + (var8 < 10 ? "0" : "") + var8 + ":" + (var26 < 10 ? "0" : "") + var26;
            var11 = ((List)var21.getValue()).iterator();

            while(var11.hasNext()) {
               var12 = (TimeZone)var11.next();
               ArrayList var13 = new ArrayList();
               Iterator var14 = ((List)var2.get(var12)).iterator();

               while(var14.hasNext()) {
                  TimeZone var15 = (TimeZone)var14.next();
                  String var16 = var15.getID();
                  var13.add(var16.substring(var16.lastIndexOf("/") + 1).replace('_', ' '));
               }

               Collections.sort(var13);
               StringBuilder var29 = new StringBuilder("(" + var27 + ") ");
               String var30 = null;
               Iterator var31 = var13.iterator();

               while(var31.hasNext()) {
                  String var17 = (String)var31.next();
                  if (!var17.equals(var30)) {
                     var29.append(var17);
                     var29.append(", ");
                     var30 = var17;
                  }
               }

               var29.delete(var29.length() - 2, var29.length());
               a.put(var29.toString(), var12);
            }
         }

         ArrayList var20 = new ArrayList();
         Iterator var22 = a.entrySet().iterator();

         while(var22.hasNext()) {
            Entry var23 = (Entry)var22.next();
            var20.add(new C(((TimeZone)var23.getValue()).getRawOffset(), var23.getKey()));
         }

         Collections.sort(var20);
         b = new String[var20.size()];

         for(var4 = 0; var4 < var20.size(); ++var4) {
            b[var4] = (String)((C)var20.get(var4)).b;
         }
      } catch (Exception var18) {
      }

   }
}
