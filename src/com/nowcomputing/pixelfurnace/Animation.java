package com.nowcomputing.pixelfurnace;

import com.nowcomputing.Image;
import com.nowcomputing.a.Transition;
import com.nowcomputing.a.b;
import com.nowcomputing.e.imageTransition;

import java.util.concurrent.ExecutorService;

public abstract class Animation implements b {
   protected imageTransition AnimateIn;
   protected Transition Animating;// ?
   protected imageTransition AnimateOut;
   protected UnusedInterface d;
   protected GamebandScreen screen;
   private AnimationState state;
   private short dateFormat;
   private ExecutorService executorService;

   protected Animation(short dateFormat, ExecutorService executorService) {
      this.state = AnimationState.stopped;
      this.dateFormat = dateFormat;
      this.executorService = executorService;
   }

   public AnimationState getState() {
      return state;
   }
   public void setState(AnimationState animationState) {
      this.state = animationState;
   }
   public short getDateFormat() {
      return this.dateFormat;
   }

   protected void setDateFormat(short var1) {
      this.dateFormat = var1;
   }

   public void f() {
      if (this.AnimateIn != null) {
         this.state = AnimationState.transitioningIn;
         this.executorService.execute(new TransitionIn(this));
      } else if (this.Animating != null) {
         this.state = AnimationState.animating;
         this.executorService.execute(new Animating(this));
      }

   }

   public void stopAnimation() {
      this.state = AnimationState.stopped;
      if (this.AnimateIn != null) {
         this.AnimateIn.stopAndDestroyTimer();
      }

      if (this.Animating != null) {
         this.Animating.stopAndDestroyTimer();
      }

      if (this.AnimateOut != null) {
         this.AnimateOut.stopAndDestroyTimer();
      }

   }

   public void a(Image var1) {
      if (this.d != null) {
         this.d.a(var1);
      }

   }

   public void a() {
      this.executorService.execute(new AnimationTransition(this));
   }

   public imageTransition h() {
      return this.AnimateIn;
   }

   public void a(imageTransition var1) {
      if (this.AnimateIn != null) {
         this.AnimateIn.a((com.nowcomputing.a.b)null);
         this.AnimateIn = null;
      }

      this.AnimateIn = var1;
      this.AnimateIn.a(this);
   }

   public imageTransition i() {
      return this.AnimateOut;
   }

   public void b(imageTransition var1) {
      if (this.AnimateOut != null) {
         this.AnimateOut.a((b)null);
         this.AnimateOut = null;
      }

      this.AnimateOut = var1;
      this.AnimateOut.a(this);
   }

   public void a(Transition var1) {
      this.Animating = var1;
      this.Animating.a(this);
   }

   public void a(UnusedInterface var1) {
      this.d = var1;
   }

   public abstract GamebandScreen getScreen();

   protected short j() {
      return this.AnimateIn != null ? this.AnimateIn.h() : 0;
   }
}
