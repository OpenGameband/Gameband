package c.a.a.a;

public class e {
   public int a = 0;
   public Object b = null;

   public e(int var1, Object var2) {
      this.a = var1;
      this.b = var2;
   }

   public String toString() {
      StringBuffer var1 = new StringBuffer();
      switch(this.a) {
      case -1:
         var1.append("END OF FILE");
         break;
      case 0:
         var1.append("VALUE(").append(this.b).append(")");
         break;
      case 1:
         var1.append("LEFT BRACE({)");
         break;
      case 2:
         var1.append("RIGHT BRACE(})");
         break;
      case 3:
         var1.append("LEFT SQUARE([)");
         break;
      case 4:
         var1.append("RIGHT SQUARE(])");
         break;
      case 5:
         var1.append("COMMA(,)");
         break;
      case 6:
         var1.append("COLON(:)");
      }

      return var1.toString();
   }
}
