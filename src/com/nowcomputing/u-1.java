package com.nowcomputing;

import java.util.logging.Level;

// this does mac shenanigans
final class ShutdownHook extends Thread { // thanks pringles
   public void run() {
      try {
         Main.getLogger().log(Level.FINE, "Gameband application exiting...");
         if (Main.g() != null) {
            try {
               Main.g().unlock();
            } catch (Throwable var7) {
            }
         }

         try {
            Utils.lsregisterShenanigans();
         } catch (Exception var6) {
            Main.getLogger().log(Level.WARNING, "Error calling lsregister", var6);
         }

         Main.getLogger().log(Level.FINE, "Gameband application exited.");
      } finally {
         V.a();
      }

   }
}
