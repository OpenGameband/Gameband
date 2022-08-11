package com.nowcomputing.pixelfurnace;

class TransitionIn implements Runnable {
   // $FF: synthetic field
   final Animation parent;

   TransitionIn(Animation var1) {
      this.parent = var1;
   }

   public void run() {
      this.parent.AnimateIn.resetTimer();
   }
}
