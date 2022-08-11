package com.nowcomputing.e;

public class c {
   public static final Transition DEFAULT_TRANSITION = Transition.rain;

   public static imageTransition animateRight(Transition var0) {
      if (var0.equals(Transition.none)) {
         return new e(Hand.right);
      } else if (var0.equals(Transition.dissolve)) {
         return new i();
      } else if (var0.equals(Transition.scroll)) {
         return new j(Hand.right);
      } else {
         return var0.equals(Transition.rain) ? new g(Hand.right) : null;
      }
   }

   public static imageTransition animateLeft(Transition var0) {
      if (var0.equals(Transition.none)) {
         return new e(Hand.left);
      } else if (var0.equals(Transition.dissolve)) {
         return new i();
      } else if (var0.equals(Transition.scroll)) {
         return new j(Hand.left);
      } else {
         return var0.equals(Transition.rain) ? new g(Hand.left) : null;
      }
   }

   public static Transition getTransition(int transitionNum) {
      if (transitionNum == 0) {
         return Transition.none;
      } else if (transitionNum == 1) {
         return Transition.scroll;
      } else if (transitionNum == 2) {
         return Transition.dissolve;
      } else {
         return transitionNum == 3 ? Transition.rain : null;
      }
   }
}
