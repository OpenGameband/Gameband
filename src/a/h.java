package a;

import com.nowcomputing.R;
import com.nowcomputing.MinecraftDownloader;

class h implements R {
   // $FF: synthetic field
   final com.nowcomputing.f.R a;
   // $FF: synthetic field
   final MinecraftDownloader b;
   // $FF: synthetic field
   final MinecraftLauncher c;

   h(MinecraftLauncher var1, com.nowcomputing.f.R var2, MinecraftDownloader var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public void b(int var1) {
      this.a.a("Oops, we couldn't download the latest Minecraft Launcher!");
      this.a.b(this.b.e().getMessage());
      this.a.d();
   }

   public void a(int var1) {
      if (var1 == 100) {
         this.a.a(true);
      } else {
         this.a.a(var1);
      }

   }

   public void a() {
      this.a.b();
   }
}
