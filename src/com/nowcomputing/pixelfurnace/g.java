package com.nowcomputing.pixelfurnace;

import com.nowcomputing.GamebandConfig;
import com.nowcomputing.ImageDoodad;
import com.nowcomputing.otherImageThingy;

import java.util.concurrent.ExecutorService;

public abstract class g implements otherImageThingy.b {
   protected GamebandConfig.a a;
   protected otherImageThingy.a b;
   protected GamebandConfig.a c;
   protected m d;
   protected n e;
   private l f;
   private short g;
   private ExecutorService h;

   protected g(short var1, ExecutorService var2) {
      this.f = l.a;
      this.g = var1;
      this.h = var2;
   }

   public short e() {
      return this.g;
   }

   protected void a(short var1) {
      this.g = var1;
   }

   public void f() {
      if (this.a != null) {
         this.f = l.b;
         this.h.execute(new h(this));
      } else if (this.b != null) {
         this.f = l.c;
         this.h.execute(new i(this));
      }

   }

   public void g() {
      this.f = l.a;
      if (this.a != null) {
         this.a.c();
      }

      if (this.b != null) {
         this.b.c();
      }

      if (this.c != null) {
         this.c.c();
      }

   }

   public void a(ImageDoodad var1) {
      if (this.d != null) {
         this.d.a(var1);
      }

   }

   public void a() {
      this.h.execute(new j(this));
   }

   public GamebandConfig.a h() {
      return this.a;
   }

   public void a(GamebandConfig.a var1) {
      if (this.a != null) {
         this.a.a((otherImageThingy.b)null);
         this.a = null;
      }

      this.a = var1;
      this.a.a(this);
   }

   public GamebandConfig.a i() {
      return this.c;
   }

   public void b(GamebandConfig.a var1) {
      if (this.c != null) {
         this.c.a((otherImageThingy.b)null);
         this.c = null;
      }

      this.c = var1;
      this.c.a(this);
   }

   public void a(otherImageThingy.a var1) {
      this.b = var1;
      this.b.a(this);
   }

   public void a(m var1) {
      this.d = var1;
   }

   public abstract n c();

   protected short j() {
      return this.a != null ? this.a.h() : 0;
   }

   // $FF: synthetic method
   static l a(g var0) {
      return var0.f;
   }

   // $FF: synthetic method
   static l a(g var0, l var1) {
      return var0.f = var1;
   }
}
