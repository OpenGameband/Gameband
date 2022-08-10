package com.nowcomputing.pixelfurnace;

enum AnimationState {
   stopped("STOPPED", 0),
   transitioningIn("TRANSITIONING_IN", 1),
   animating("ANIMATING", 2),
   transitioningOut("TRANSITIONING_OUT", 3);

   AnimationState(final String name, final int ordinal) {
   }
}
