package com.nowcomputing;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Originally called com.nowcomputing.b
 */
public class LockingUtil {
   public static final Logger logger = Logger.getLogger(Utils.class.getName());
   private final String handle;
   private int lockID;

   public LockingUtil(String handle) {
      this.handle = handle;
   }

   public boolean lock() {
      try {
         this.lockID = GbUtilNative.lockInstance(this.handle);
         return this.lockID != -1;
      } catch (Throwable e) {
         return true;
      }
   }

   public void unlock() {
      try {
         GbUtilNative.unlockInstance(this.lockID, this.handle);
      } catch (Throwable e) {
         logger.log(Level.WARNING, e.toString());
      }

   }
}
