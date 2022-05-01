package com.nowcomputing;

import java.io.IOException;

/**
 * I think this is a data structure for an update
 * TODO: Figure out what the fields for this do/are for
 */
public class UpdateEntry {
   private String a;
   private String b;
   private String c;
   private String d;
   private String e;
   private long f;
   private WindowsVersionComparator g;
   private boolean h;

   public UpdateEntry(String updateString) {
      String[] var2 = updateString.split(":");
      try {
         this.a(var2);
      } catch (IOException ex) {
         ex.printStackTrace();
      }
   }

   private void a(String[] var1) throws IOException {
      if (var1.length != 8) {
         throw new IOException("Wrong number of values in the update entry");
      } else {
         this.b(var1[0]);
         this.d(var1[1]);
         this.a(var1[2]);
         this.e(var1[3]);
         this.c(var1[4]);
         this.a(Long.parseLong(var1[5]));
         this.a(Boolean.parseBoolean(var1[7]));

         try {
            this.a(new WindowsVersionComparator(var1[6]));
         } catch (IllegalArgumentException e) {
            e.printStackTrace();
         }

      }
   }

   public String getC() {
      return this.c;
   }

   private void a(String var1) {
      this.c = var1;
   }

   public WindowsVersionComparator b() {
      return this.g;
   }

   private void a(WindowsVersionComparator var1) {
      this.g = var1;
   }

   public String c() {
      return this.a;
   }

   private void b(String var1) {
      this.a = var1;
   }

   public String d() {
      return this.e;
   }

   private void c(String var1) {
      this.e = var1;
   }

   private void d(String var1) {
      this.b = var1;
   }

   public String e() {
      return this.b;
   }

   public String f() {
      return this.d;
   }

   private void e(String var1) {
      this.d = var1;
   }

   public boolean g() {
      return this.h;
   }

   private void a(boolean var1) {
      this.h = var1;
   }

   public long h() {
      return this.f;
   }

   private void a(long var1) {
      this.f = var1;
   }
}
