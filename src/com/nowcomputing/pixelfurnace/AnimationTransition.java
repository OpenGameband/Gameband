package com.nowcomputing.pixelfurnace;

class AnimationTransition implements Runnable {
   // $FF: synthetic field
   final Animation a;

   AnimationTransition(Animation var1) {
      this.a = var1;
   }

   public void run() {
      switch(a.getState()) {
         case stopped:
            return;
         case transitioningIn:
            if (this.a.Animating != null) {
               a.setState(AnimationState.animating);
               this.a.Animating.startTimer();
               return;
            }
            break;
         case animating:
            if (this.a.AnimateOut != null) {
               a.setState(AnimationState.transitioningOut);
               this.a.AnimateOut.startTimer();
               return;
            }
      }

      a.setState(AnimationState.stopped);
      if (this.a.d != null) {
         this.a.d.a();
      }

   }
}
