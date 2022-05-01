package b.a.a.a;

import java.util.Iterator;
import java.util.List;

final class Class23 implements Iterable {
   // $FF: synthetic field
   final List field55;

   Class23(List var1) {
      this.field55 = var1;
   }

   public Iterator iterator() {
      return new Class19(this.field55, (Class23)null);
   }
}
