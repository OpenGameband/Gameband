package com.nowcomputing.pixelfurnace;

import com.nowcomputing.Image;
import com.nowcomputing.Utils;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImageAnimation extends Animation {
   private static final Logger f = Logger.getLogger(Utils.class.getName());
   private Image g;

   public ImageAnimation(ExecutorService var1) {
      super((short)16, var1);
   }

   public ImageAnimation(GamebandScreen var1, ExecutorService var2) {
      super(var1.getScreenType(), var2);
      this.screen = var1;

      try {
         this.g = var1.getScroll();
      } catch (IOException var4) {
         f.log(Level.WARNING, "Error reading scroll data from Gameband");
      }

   }

   public void b(Image var1) {
      this.g = var1;
   }

   public Image b() {
      return this.g;
   }

   public GamebandScreen c() {
      if (this.screen == null) {
         this.screen = new GamebandScreen();
         this.screen.setPauseMode((short)0);
         this.screen.setPauseDuration((int)0);
         this.screen.b((int)20);
         this.screen.setScreenType(this.e());
         this.screen.d(this.j());
      }

      this.screen.setImage(this.g);
      return this.screen;
   }
}
