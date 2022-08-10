package com.nowcomputing.pixelfurnace;

import com.nowcomputing.GamebandConfig;
import com.nowcomputing.Image;
import com.nowcomputing.AnimatedImage;
import com.nowcomputing.a.TimerListener;
import com.nowcomputing.a.b;
import com.nowcomputing.e.funnyImageThing;

import java.util.concurrent.ExecutorService;

public abstract class Animation implements b {
   protected funnyImageThing fi1;
   protected com.nowcomputing.a.TimerListener b;
   protected funnyImageThing fi2;
   protected m d;
   protected GamebandScreen screen;
   private AnimationState state;
   private short g;
   private ExecutorService executorService;

   protected Animation(short var1, ExecutorService var2) {
      this.state = AnimationState.stopped;
      this.g = var1;
      this.executorService = var2;
   }

   public short e() {
      return this.g;
   }

   protected void a(short var1) {
      this.g = var1;
   }

   public void f() {
      if (this.fi1 != null) {
         this.state = AnimationState.transitioningIn;
         this.executorService.execute(new h(this));
      } else if (this.b != null) {
         this.state = AnimationState.animating;
         this.executorService.execute(new i(this));
      }

   }

   public void stopTimers() {
      this.state = AnimationState.stopped;
      if (this.fi1 != null) {
         this.fi1.stopAndDestroyTimer();
      }

      if (this.b != null) {
         this.b.stopAndDestroyTimer();
      }

      if (this.fi2 != null) {
         this.fi2.stopAndDestroyTimer();
      }

   }

   public void a(Image var1) {
      if (this.d != null) {
         this.d.a(var1);
      }

   }

   public void a() {
      this.executorService.execute(new j(this));
   }

   public com.nowcomputing.e.funnyImageThing h() {
      return this.fi1;
   }

   public void a(funnyImageThing var1) {
      if (this.fi1 != null) {
         this.fi1.a((com.nowcomputing.a.b)null);
         this.fi1 = null;
      }

      this.fi1 = var1;
      this.fi1.a(this);
   }

   public funnyImageThing i() {
      return this.fi2;
   }

   public void b(funnyImageThing var1) {
      if (this.fi2 != null) {
         this.fi2.a((b)null);
         this.fi2 = null;
      }

      this.fi2 = var1;
      this.fi2.a(this);
   }

   public void a(TimerListener var1) {
      this.b = var1;
      this.b.a(this);
   }

   public void a(m var1) {
      this.d = var1;
   }

   public abstract GamebandScreen c();

   protected short j() {
      return this.fi1 != null ? this.fi1.h() : 0;
   }

   // $FF: synthetic method
   static AnimationState a(Animation var0) {
      return var0.state;
   }

   // $FF: synthetic method
   static AnimationState a(Animation var0, AnimationState var1) {
      return var0.state = var1;
   }
}
