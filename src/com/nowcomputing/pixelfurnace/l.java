package com.nowcomputing.pixelfurnace;

enum l {
   a("STOPPED", 0),
   b("TRANSITIONING_IN", 1),
   c("ANIMATING", 2),
   d("TRANSITIONING_OUT", 3);

   private static final /* synthetic */ l[] e;

   public static l[] a() {
      return l.e.clone();
   }

   l(final String name, final int ordinal) {
   }

   static {
      e = new l[]{a, b, c, d};
   }
}
