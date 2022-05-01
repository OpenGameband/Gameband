package c.a.a;

import java.io.StringWriter;

public class f extends StringWriter {
   private int a = 0;

   public void write(int var1) {
      char var2 = (char)var1;
      if (var2 != '[' && var2 != '{') {
         if (var2 == ',') {
            super.write(var1);
            super.write(10);
            this.a();
         } else if (var2 != ']' && var2 != '}') {
            if (var2 == ':') {
               super.write(var1);
               super.write(" ");
            } else {
               super.write(var1);
            }
         } else {
            super.write(10);
            --this.a;
            this.a();
            super.write(var1);
         }
      } else {
         super.write(var1);
         super.write(10);
         ++this.a;
         this.a();
      }

   }

   private void a() {
      for(int var1 = 0; var1 < this.a; ++var1) {
         super.write("  ");
      }

   }
}
