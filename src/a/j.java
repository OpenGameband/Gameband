package a;

import com.nowcomputing.LocaleUtil;

public class j extends AbstractMinecraftLauncher {
   public String getDisplayName() {
      return LocaleUtil.getLocalizedString("OTHER_LAUNCHER");
   }

   public String getSupportURL() {
      return "";
   }

   public boolean setLaunchCMD() {
      return false;
   }

   public boolean isJavaLaunchCommandValid() {
      return false;
   }

   public void f() {
   }

   public boolean g() {
      return false;
   }
}
