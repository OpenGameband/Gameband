package com.nowcomputing;

import java.util.logging.Level;

class x extends Thread {
   // $FF: synthetic field
   final MinecraftDownloader a;

   x(MinecraftDownloader var1) {
      this.a = var1;
   }

   public void run() {
      try {
         MinecraftDownloader.a(this.a, false);
         (new E(3, 400)).a(new y(this));
      } catch (Exception var2) {
         this.a.b = var2;
         MinecraftDownloader.log.log(Level.WARNING, "Error in update thread", var2);
         if (MinecraftDownloader.b(this.a) != null) {
            MinecraftDownloader.b(this.a).b(-1);
         }
      }

   }
}
