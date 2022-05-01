package b.a.a.a;

import java.util.List;
import javax.swing.JComponent;

abstract class Class32 implements Class2 {
   private Class45 field62;
   private Class41 field63;
   private Class42 field64;
   private boolean field65 = false;
   private int field66 = 0;
   private int field67;
   private int field68;
   private double field69 = -1.0D;
   private int field70;
   private int field71 = 0;

   final void method107(Class45 var1, Class41 var2, Class42 var3) {
      this.field62 = var1;
      this.field63 = var2;
      this.field64 = var3;
   }

   protected final Class45 method108() {
      return this.field62;
   }

   protected final void method109(JComponent var1) {
      this.field62.method211(var1);
   }

   final void method110() {
      this.field65 = true;
   }

   final boolean method111() {
      return this.field65;
   }

   final void method112(int var1) {
      this.field66 = var1;
   }

   final int method113() {
      return this.field71 == 0 ? this.field66 : 0;
   }

   final void method114() {
      this.field68 = Class1.method1(this.method139(), Class28.field59);
      this.field67 = Class1.method1(this.method139(), Class35.field80);
      boolean var1 = Class1.method5(this.field63, this.method138());
      if (var1 || this.field69 == -1.0D) {
         this.field69 = var1 ? 0.0D : 1.0D;
      }

   }

   void method115(Class16 var1) {
   }

   protected final int method116() {
      return this.field71 == 0 ? this.field67 : 0;
   }

   final int method117() {
      return this.field71 == 0 ? this.field68 : 0;
   }

   final void method118(int var1) {
      this.field70 = var1;
   }

   final int method119() {
      return this.field71 == 0 ? this.field70 : 0;
   }

   final void method120(double var1) {
      if (var1 >= 0.0D) {
         this.field69 = var1;
      }

   }

   final double method121() {
      return this.field71 == 0 ? this.field69 : 0.0D;
   }

   int method122() {
      return 0;
   }

   void method123(int var1) {
   }

   int method124(int var1) {
      return 1;
   }

   int method125(int var1) {
      return 0;
   }

   int method126(int var1) {
      return 0;
   }

   int method127(int var1, int var2, Class25 var3) {
      return 0;
   }

   int method128(int var1, int var2) {
      return 0;
   }

   int method129() {
      return 0;
   }

   void method130(int var1) {
   }

   int method131() {
      return Class1.method3(this.method139(), this.field62.method213());
   }

   int method132() {
      return Class1.method2(this.method139(), this.field62.method213());
   }

   int method133() {
      return 0;
   }

   boolean method134() {
      return this.method139().isEmpty();
   }

   JComponent method135() {
      return this.method139().isEmpty() ? null : ((Class33)this.method139().get(0)).method60();
   }

   JComponent method136() {
      return this.method139().isEmpty() ? null : ((Class33)this.method139().get(this.method139().size() - 1)).method60();
   }

   void method137() {
   }

   abstract List method138();

   List method139() {
      return this.method138();
   }

   final int method140(Class6 var1, int var2, int var3, int var4, int var5, int var6, int var7, List var8) {
      return this.field71 == 0 ? this.method141(var1, var2, var3, var4, var5, var6, var7, var8) : 0;
   }

   abstract int method141(Class6 var1, int var2, int var3, int var4, int var5, int var6, int var7, List var8);
}
