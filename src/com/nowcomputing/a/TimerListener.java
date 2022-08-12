package com.nowcomputing.a;

import com.nowcomputing.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public abstract class TimerListener implements ActionListener {
   protected int randomNumber = 20;
   protected b b;
   protected Timer timer;
   private boolean bool; // i am 12% sure the obfuscator is fucking with me here

   protected void disable() {
      this.setBool(false);
   }

   public void startTimer() {
      this.stopAndDestroyTimer();
      this.disable();
      if (this.randomNumber < 1) {
         this.randomNumber = 1;
      }

      this.timer = new Timer(1000 / this.randomNumber, this); // 20th of a second, this should be good
      this.timer.start();
   }

   public void stopAndDestroyTimer() {
      if (this.timer != null) {
         this.timer.stop();
         this.timer = null;
      }

   }

   public abstract boolean isEmpty();

   public abstract Image e();

   public void actionPerformed(ActionEvent var1) {
      if (this.b != null && this.isEmpty()) {
         this.b.a(this.e());
         if (!this.isEmpty()) {
            this.b.a();
         }
      }

   }

   public void a(b var1) {
      this.b = var1;
   }

   public int f() {
      return this.randomNumber;
   }

   public void a(int var1) {
      this.randomNumber = var1;
   }

   public boolean getBool() {
      return this.bool;
   }

   protected void setBool(boolean var1) {
      this.bool = var1;
   }
}
