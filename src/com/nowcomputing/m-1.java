package com.nowcomputing;

import java.util.Iterator;
import java.util.logging.Level;

class m extends Thread {
   // $FF: synthetic field
   final latchedCommandRun a;

   m(latchedCommandRun var1) {
      this.a = var1;
   }

   public void run() {
      try {
         this.a.randomInterface = this.a.c();
         Iterator var1 = this.a.list.iterator();

         n var2;
         while(var1.hasNext()) {
            var2 = (n)var1.next();
            var2.a();
         }

         if (this.a.randomInterface != null) {
            this.a.randomInterface.a();
            var1 = this.a.list.iterator();

            while(var1.hasNext()) {
               var2 = (n)var1.next();
               var2.b();
            }
         }
      } catch (RuntimeException var7) {
         latchedCommandRun.logger.log(Level.WARNING, "Error preparing backupService.", var7);
      } catch (Exception var8) {
         latchedCommandRun.logger.log(Level.WARNING, "Error preparing backupService.", var8);
      } finally {
         latchedCommandRun.a(this.a).countDown();
         latchedCommandRun.logger.log(Level.FINE, "BackgroundThread exiting");
      }

   }
}
