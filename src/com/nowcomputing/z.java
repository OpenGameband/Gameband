package com.nowcomputing;

class z implements randomInterfaceThatDoesNothing {
   // $FF: synthetic field
   final MinecraftDownloader a;

   z(MinecraftDownloader var1) {
      this.a = var1;
   }

   public void a(long var1) {
      if (MinecraftDownloader.b(this.a) != null) {
         MinecraftDownloader.c(this.a, var1);
         int var3 = (int)((float) MinecraftDownloader.c(this.a) / (float) MinecraftDownloader.d(this.a) * 100.0F);
         MinecraftDownloader.b(this.a).setProgress(var3);
      }

   }
}
