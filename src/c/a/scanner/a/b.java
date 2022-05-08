package c.a.scanner.a;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class b {
   private LinkedList a;
   private d b = new d((Reader)null);
   private e c = null;
   private int d = 0;

   private int a(LinkedList var1) {
      if (var1.size() == 0) {
         return -1;
      } else {
         Integer var2 = (Integer)var1.getFirst();
         return var2;
      }
   }

   public void a() {
      this.c = null;
      this.d = 0;
      this.a = null;
   }

   public void a(Reader var1) {
      this.b.a(var1);
      this.a();
   }

   public int b() {
      return this.b.a();
   }

   public Object a(String var1) throws UnexpectedDoodadException {
      return this.a(var1, (a)null);
   }

   public Object a(String var1, a var2) throws UnexpectedDoodadException {
      StringReader var3 = new StringReader(var1);

      try {
         return this.a((Reader)var3, var2);
      } catch (IOException var5) {
         throw new UnexpectedDoodadException(-1, 2, var5);
      }
   }

   public Object a(Reader var1, a var2) throws UnexpectedDoodadException, IOException {
      this.a(var1);
      LinkedList var3 = new LinkedList();
      LinkedList var4 = new LinkedList();

      try {
         do {
            this.c();
            String var5;
            Map var6;
            List var7;
            label67:
            switch(this.d) {
            case -1:
               throw new UnexpectedDoodadException(this.b(), 1, this.c);
            case 0:
               switch(this.c.a) {
               case 0:
                  this.d = 1;
                  var3.addFirst(new Integer(this.d));
                  var4.addFirst(this.c.b);
                  break label67;
               case 1:
                  this.d = 2;
                  var3.addFirst(new Integer(this.d));
                  var4.addFirst(this.a(var2));
                  break label67;
               case 2:
               default:
                  this.d = -1;
                  break label67;
               case 3:
                  this.d = 3;
                  var3.addFirst(new Integer(this.d));
                  var4.addFirst(this.b(var2));
                  break label67;
               }
            case 1:
               if (this.c.a == -1) {
                  return var4.removeFirst();
               }

               throw new UnexpectedDoodadException(this.b(), 1, this.c);
            case 2:
               switch(this.c.a) {
               case 0:
                  if (this.c.b instanceof String) {
                     var5 = (String)this.c.b;
                     var4.addFirst(var5);
                     this.d = 4;
                     var3.addFirst(new Integer(this.d));
                  } else {
                     this.d = -1;
                  }
                  break label67;
               case 2:
                  if (var4.size() > 1) {
                     var3.removeFirst();
                     var4.removeFirst();
                     this.d = this.a(var3);
                  } else {
                     this.d = 1;
                  }
               case 5:
                  break label67;
               default:
                  this.d = -1;
                  break label67;
               }
            case 3:
               List var10;
               switch(this.c.a) {
               case 0:
                  var10 = (List)var4.getFirst();
                  var10.add(this.c.b);
                  break label67;
               case 1:
                  var10 = (List)var4.getFirst();
                  var6 = this.a(var2);
                  var10.add(var6);
                  this.d = 2;
                  var3.addFirst(new Integer(this.d));
                  var4.addFirst(var6);
                  break label67;
               case 2:
               default:
                  this.d = -1;
                  break label67;
               case 3:
                  var10 = (List)var4.getFirst();
                  var7 = this.b(var2);
                  var10.add(var7);
                  this.d = 3;
                  var3.addFirst(new Integer(this.d));
                  var4.addFirst(var7);
                  break label67;
               case 4:
                  if (var4.size() > 1) {
                     var3.removeFirst();
                     var4.removeFirst();
                     this.d = this.a(var3);
                  } else {
                     this.d = 1;
                  }
               case 5:
                  break label67;
               }
            case 4:
               switch(this.c.a) {
               case 0:
                  var3.removeFirst();
                  var5 = (String)var4.removeFirst();
                  var6 = (Map)var4.getFirst();
                  var6.put(var5, this.c.b);
                  this.d = this.a(var3);
                  break;
               case 1:
                  var3.removeFirst();
                  var5 = (String)var4.removeFirst();
                  var6 = (Map)var4.getFirst();
                  Map var8 = this.a(var2);
                  var6.put(var5, var8);
                  this.d = 2;
                  var3.addFirst(new Integer(this.d));
                  var4.addFirst(var8);
                  break;
               case 2:
               case 4:
               case 5:
               default:
                  this.d = -1;
                  break;
               case 3:
                  var3.removeFirst();
                  var5 = (String)var4.removeFirst();
                  var6 = (Map)var4.getFirst();
                  var7 = this.b(var2);
                  var6.put(var5, var7);
                  this.d = 3;
                  var3.addFirst(new Integer(this.d));
                  var4.addFirst(var7);
               case 6:
               }
            }

            if (this.d == -1) {
               throw new UnexpectedDoodadException(this.b(), 1, this.c);
            }
         } while(this.c.a != -1);
      } catch (IOException var9) {
         throw var9;
      }

      throw new UnexpectedDoodadException(this.b(), 1, this.c);
   }

   private void c() throws UnexpectedDoodadException, IOException {
      this.c = this.b.c();
      if (this.c == null) {
         this.c = new e(-1, (Object)null);
      }

   }

   private Map a(a var1) {
      if (var1 == null) {
         return new c.a.scanner.c();
      } else {
         Map var2 = var1.a();
         return (Map)(var2 == null ? new c.a.scanner.c() : var2);
      }
   }

   private List b(a var1) {
      if (var1 == null) {
         return new c.a.scanner.dingusList();
      } else {
         List var2 = var1.b();
         return (List)(var2 == null ? new c.a.scanner.dingusList() : var2);
      }
   }
}
