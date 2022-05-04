package com.nowcomputing.uistuff;

import java.awt.Desktop;
import java.net.URI;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.event.HyperlinkEvent.EventType;

class ab implements HyperlinkListener {
   // $FF: synthetic field
   final aa a;

   ab(aa var1) {
      this.a = var1;
   }

   public void hyperlinkUpdate(HyperlinkEvent var1) {
      if (var1.getEventType() == EventType.ACTIVATED) {
         try {
            URI var2;
            if (var1.getURL() != null) {
               var2 = var1.getURL().toURI();
            } else {
               var2 = new URI("http://" + var1.getDescription());
            }

            Desktop.getDesktop().browse(var2);
         } catch (Exception var3) {
            System.out.println(var3);
            var3.printStackTrace();
         }
      }

   }
}
