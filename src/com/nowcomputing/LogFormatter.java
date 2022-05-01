package com.nowcomputing;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public final class LogFormatter extends Formatter {
   private static final String a = System.getProperty("line.separator");
   private SimpleDateFormat b = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");

   public String format(LogRecord var1) {
      StringBuilder var2 = new StringBuilder(256);
      var2.append(this.b.format(new Date(var1.getMillis()))).append(' ').append(var1.getLevel().getLocalizedName()).append(": ").append(this.formatMessage(var1)).append(a);
      if (var1.getThrown() != null) {
         PrintWriter var3 = null;
         StringWriter var4 = null;

         try {
            var4 = new StringWriter();
            var3 = new PrintWriter(var4);
            var1.getThrown().printStackTrace(var3);
            var2.append(var4.toString());
         } catch (Exception var14) {
         } finally {
            if (var4 != null) {
               try {
                  var4.close();
               } catch (IOException var13) {
               }
            }

            if (var3 != null) {
               var3.close();
            }

         }
      }

      return var2.toString();
   }
}
