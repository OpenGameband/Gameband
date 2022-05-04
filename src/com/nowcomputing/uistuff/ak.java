package com.nowcomputing.uistuff;

import com.nowcomputing.GamebandConfig;

import java.awt.Frame;
import java.awt.SplashScreen;

public class ak extends Frame {
   private boolean a = false;
   private boolean b = false;
   private int c;

   public ak(GamebandConfig var1, int var2) {
      super("Gameband");
      this.c = Integer.parseInt(var1.getProperty("splash_timeout", Integer.toString(var2)));
      if (this.c < 1000) {
         this.c = 1000;
      }

      SplashScreen var3 = SplashScreen.getSplashScreen();
      if (var3 == null) {
         this.b = true;
      } else {
         al var4 = new al(this);
         var4.start();
      }
   }

   private synchronized void c() {
      this.b = true;
      this.notifyAll();
   }

   public synchronized void a() {
      while(!this.b) {
         try {
            this.wait();
         } catch (InterruptedException var2) {
         }
      }

   }

   public synchronized void b() {
      this.a = true;
      this.notifyAll();
   }

   private synchronized void d() {
      while(!this.a) {
         try {
            this.wait();
         } catch (InterruptedException var2) {
         }
      }

   }

   // $FF: synthetic method
   static int a(ak var0) {
      return var0.c;
   }

   // $FF: synthetic method
   static void b(ak var0) {
      var0.d();
   }

   // $FF: synthetic method
   static void c(ak var0) {
      var0.c();
   }
}
