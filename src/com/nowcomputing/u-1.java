package com.nowcomputing;

import java.util.logging.Level;

final class u extends Thread {
   public void run() {
      try {
         Main.f().log(Level.FINE, "Gameband application exiting...");
         if (Main.g() != null) {
            try {
               Main.g().b();
            } catch (Throwable var7) {
            }
         }

         try {
            S.f();
         } catch (Exception var6) {
            Main.f().log(Level.WARNING, "Error calling lsregister", var6);
         }

         Main.f().log(Level.FINE, "Gameband application exited.");
      } finally {
         V.a();
      }

   }
}
