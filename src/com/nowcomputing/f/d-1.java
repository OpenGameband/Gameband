package com.nowcomputing.f;

import java.awt.Desktop;
import java.net.URI;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.event.HyperlinkEvent.EventType;

class d implements HyperlinkListener {
   // $FF: synthetic field
   final b a;

   d(b var1) {
      this.a = var1;
   }

   public void hyperlinkUpdate(HyperlinkEvent var1) {
      if (var1.getEventType() == EventType.ACTIVATED) {
         try {
            this.a(var1.getURL().toURI());
         } catch (Exception var3) {
         }
      }

   }

   private void a(URI var1) {
      Desktop var2 = Desktop.getDesktop();
      var2.browse(var1);
   }
}
