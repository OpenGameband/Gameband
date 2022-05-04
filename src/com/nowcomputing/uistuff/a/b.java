package com.nowcomputing.uistuff.a;

import com.nowcomputing.LocaleUtil;
import com.nowcomputing.uistuff.N;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class b implements ActionListener {
   // $FF: synthetic field
   final p a;
   // $FF: synthetic field
   final a b;

   b(a var1, p var2) {
      this.b = var1;
      this.a = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      if (this.a.h()) {
         this.a.c(true);
      } else {
         N.a(this.a.j(), new String[]{LocaleUtil.getLocalizedString("ERROR_MAX_ANIMATIONS_HEADER"), LocaleUtil.getLocalizedString("ERROR_MAX_ANIMATIONS_1"), LocaleUtil.getLocalizedString("ERROR_MAX_ANIMATIONS_2")});
      }

   }
}
