package com.nowcomputing.pixelfurnace;

import com.nowcomputing.Utils;
import com.nowcomputing.AnimatedImage;
import com.nowcomputing.a.ImagePlayer;
import com.nowcomputing.e.imageTransition;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RawAnimation extends Animation {
   private static final Logger logger = Logger.getLogger(Utils.class.getName());

   public RawAnimation(ExecutorService var1) {
      super((short)32, var1);
   }

   public RawAnimation(GamebandScreen var1, ExecutorService var2) {
      super(var1.getScreenType(), var2);
      this.screen = var1;
      this.Animating = new ImagePlayer();

      try {
         ((ImagePlayer)this.Animating).a(var1.getAnimation());
      } catch (IOException e) {
         logger.log(Level.WARNING, "", e);
      }

   }

   public AnimatedImage getAnimation() throws IOException {
      return this.screen != null ? this.screen.getAnimation() : null;
   }

   public GamebandScreen getScreen() {
      if (this.screen == null) {
         this.screen = new GamebandScreen();
         this.screen.setScreenType(this.getDateFormat());
      }

      this.screen.d((short)0);
      this.screen.setPauseDuration((int)1000);
      this.screen.b(this.Animating.f());
      this.screen.fromAnimatedImage(((com.nowcomputing.a.ImagePlayer)this.Animating).h());
      return this.screen;
   }

   public void a(imageTransition var1) {
   }
}
