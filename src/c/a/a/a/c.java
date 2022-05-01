package c.a.a.a;

public class c extends Exception {
   private int a;
   private Object b;
   private int c;

   public c(int var1, int var2, Object var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public String toString() {
      StringBuffer var1 = new StringBuffer();
      switch(this.a) {
      case 0:
         var1.append("Unexpected character (").append(this.b).append(") at position ").append(this.c).append(".");
         break;
      case 1:
         var1.append("Unexpected token ").append(this.b).append(" at position ").append(this.c).append(".");
         break;
      case 2:
         var1.append("Unexpected exception at position ").append(this.c).append(": ").append(this.b);
         break;
      default:
         var1.append("Unkown error at position ").append(this.c).append(".");
      }

      return var1.toString();
   }
}
