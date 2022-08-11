package com.nowcomputing.pixelfurnace;

public class GbData { // Another one of my magic wild guesses
   short[] a = new short[12];

   public GbData() {
      this.f((short)47);
   }

   public GbData(short[] var1) {
      System.arraycopy(var1, 0, this.a, 0, 12);
   }

   public static int a(short var0) {
      return var0 << 18 >> 18;
   }

   public static short b(short var0) {
      return (short)(var0 & 16383);
   }

   public short a() {
      return (short)a(this.a[0]);
   }

   public void c(short var1) {
      this.a[0] = b(var1);
   }

   public short b() {
      return (short)a(this.a[1]);
   }

   public void d(short var1) {
      this.a[1] = b(var1);
   }

   public long c() {
      long var1 = (long)(this.a[2] & 255 | (this.a[3] & 255) << 8 | (this.a[4] & 255) << 16 | (this.a[5] & 255) << 24);
      return var1;
   }

   public void a(long var1) {
      this.a[2] = (short)((int)(var1 & 255L));
      this.a[3] = (short)((int)(var1 >> 8 & 255L));
      this.a[4] = (short)((int)(var1 >> 16 & 255L));
      this.a[5] = (short)((int)(var1 >> 24 & 255L));
   }

   public short d() {
      return this.a[6];
   }

   public void setSixthBit(short var1) {
      this.a[6] = var1;
   }

   public short e() {
      return this.a[7];
   }

   public void f(short var1) {
      this.a[7] = var1;
   }

   public short f() {
      return this.a[8];
   }

   public void g(short var1) {
      this.a[8] = var1;
   }

   public short g() {
      return this.a[10];
   }

   public short h() {
      return this.a[11];
   }

   public void a(int var1) {
      this.a[9] = (short)var1;
   }
}
