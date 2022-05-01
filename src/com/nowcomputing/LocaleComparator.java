package com.nowcomputing;

import java.util.Comparator;
import java.util.ResourceBundle;

final class LocaleComparator implements Comparator<ResourceBundle> {
   public int compare(ResourceBundle bundle1, ResourceBundle bundle2) {
      String locale1 = this.getLocale(bundle1).toLowerCase();
      String locale2 = this.getLocale(bundle2).toLowerCase();
      return locale1.compareTo(locale2);
   }

   private String getLocale(ResourceBundle bundle) {
      String locale = bundle.getLocale().getDisplayName(bundle.getLocale());
      if (locale.equals("")) {
         locale = "English";
      }
      return locale;
   }
}
