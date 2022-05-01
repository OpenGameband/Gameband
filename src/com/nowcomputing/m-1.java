package com.nowcomputing;

import java.util.Iterator;
import java.util.logging.Level;

class m extends Thread {
   // $FF: synthetic field
   final l a;

   m(l var1) {
      this.a = var1;
   }

   public void run() {
      try {
         this.a.c = this.a.c();
         Iterator var1 = this.a.d.iterator();

         n var2;
         while(var1.hasNext()) {
            var2 = (n)var1.next();
            var2.a();
         }

         if (this.a.c != null) {
            this.a.c.a();
            var1 = this.a.d.iterator();

            while(var1.hasNext()) {
               var2 = (n)var1.next();
               var2.b();
            }
         }
      } catch (RuntimeException var7) {
         l.a.log(Level.WARNING, "Error preparing backupService.", var7);
      } catch (Exception var8) {
         l.a.log(Level.WARNING, "Error preparing backupService.", var8);
      } finally {
         l.a(this.a).countDown();
         l.a.log(Level.FINE, "BackgroundThread exiting");
      }

   }
}
