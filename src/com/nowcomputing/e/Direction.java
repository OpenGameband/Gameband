package com.nowcomputing.e;

public enum Direction {
   a("LEFT", 0),
   b("RIGHT", 1),
   c("UP", 2),
   d("DOWN", 3);

   Direction(String text, int index){

   }

   private static final Direction[] e;
   public static Direction[] a() {
      return (Direction[])e.clone();
   }
   static {
      e = new Direction[]{a, b, c, d};
   }
}
