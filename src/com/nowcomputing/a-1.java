package com.nowcomputing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.imageio.IIOException;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.FileImageOutputStream;

public class a {
   private ArrayList a;
   private int b;

   public a(int var1, int var2) {
      this.b = var2;
      this.a = new ArrayList(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         this.a.add(new ImageDoodad(20, 7));
      }

   }

   public a(a var1) {
      this.b = var1.b();
      this.a = new ArrayList(var1.a.size());

      for(int var2 = 0; var2 < var1.a.size(); ++var2) {
         this.a.add(new ImageDoodad((ImageDoodad)var1.a.get(var2)));
      }

   }

   public a(ArrayList var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public a(ArrayList var1) {
      if (var1 != null && var1.size() > 0) {
         if (((r)var1.get(0)).b > 0) {
            this.b = 1000 / ((r)var1.get(0)).b;
         } else {
            this.b = 12;
         }

         int var2 = var1.size();
         this.a = new ArrayList(var2);

         for(int var3 = 0; var3 < var2; ++var3) {
            this.a.add(ImageDoodad.a((BufferedImage)((r)var1.get(var3)).a, 20, 7));
         }
      }

   }

   public ImageDoodad a(int var1) {
      return (ImageDoodad)this.a.get(var1);
   }

   public int a() {
      return this.a != null ? this.a.size() : 0;
   }

   public void b(int var1) {
      while(var1 < this.a.size()) {
         this.a.remove(this.a.size() - 1);
      }

      while(var1 > this.a.size()) {
         this.a.add(new ImageDoodad(20, 7));
      }

   }

   public int b() {
      return this.b;
   }

   public void c(int var1) {
      this.b = var1;
   }

   public static a a(File var0) {
      q var1 = new q();
      if (var1.a(var0.getPath()) != 0) {
         throw new IOException();
      } else {
         a var2 = new a(var1.c());
         return var2;
      }
   }

   public void b(File var1) {
      ImageWriter var2 = d();
      ImageWriteParam var3 = var2.getDefaultWriteParam();
      ImageTypeSpecifier var4 = ImageTypeSpecifier.createFromBufferedImageType(2);
      IIOMetadata var5 = var2.getDefaultImageMetadata(var4, var3);
      String var6 = var5.getNativeMetadataFormatName();
      IIOMetadataNode var7 = (IIOMetadataNode)var5.getAsTree(var6);
      IIOMetadataNode var8 = a(var7, "GraphicControlExtension");
      var8.setAttribute("disposalMethod", "none");
      var8.setAttribute("userInputFlag", "FALSE");
      var8.setAttribute("transparentColorFlag", "FALSE");
      var8.setAttribute("delayTime", Integer.toString(100 / this.b()));
      var8.setAttribute("transparentColorIndex", "0");
      IIOMetadataNode var9 = a(var7, "CommentExtensions");
      IIOMetadataNode var10 = a(var9, "CommentExtension");
      var10.setAttribute("value", "Created with Gameband!");
      IIOMetadataNode var11 = a(var7, "ApplicationExtensions");
      IIOMetadataNode var12 = new IIOMetadataNode("ApplicationExtension");
      var12.setAttribute("applicationID", "NETSCAPE");
      var12.setAttribute("authenticationCode", "2.0");
      byte var13 = 0;
      var12.setUserObject(new byte[]{1, (byte)(var13 & 255), (byte)(var13 >> 8 & 255)});
      var11.appendChild(var12);
      var5.setFromTree(var6, var7);
      var2.setOutput(new FileImageOutputStream(var1));
      var2.prepareWriteSequence((IIOMetadata)null);
      Iterator var14 = this.a.iterator();

      while(var14.hasNext()) {
         ImageDoodad var15 = (ImageDoodad)var14.next();
         var2.writeToSequence(new IIOImage(var15.d(), (List)null, var5), var3);
      }

      var2.endWriteSequence();
   }

   private static IIOMetadataNode a(IIOMetadataNode var0, String var1) {
      int var2 = var0.getLength();

      for(int var3 = 0; var3 < var2; ++var3) {
         if (var0.item(var3).getNodeName().compareToIgnoreCase(var1) == 0) {
            return (IIOMetadataNode)var0.item(var3);
         }
      }

      IIOMetadataNode var4 = new IIOMetadataNode(var1);
      var0.appendChild(var4);
      return var4;
   }

   private static ImageWriter d() {
      Iterator var0 = ImageIO.getImageWritersByFormatName("gif");
      if (!var0.hasNext()) {
         throw new IIOException("No GIF Image Writers Exist");
      } else {
         return (ImageWriter)var0.next();
      }
   }

   public void c() {
      Iterator var1 = this.a.iterator();

      while(var1.hasNext()) {
         ImageDoodad var2 = (ImageDoodad)var1.next();
         var2.c();
      }

   }

   public void d(int var1) {
      this.a(var1, new ImageDoodad(20, 7));
   }

   public void a(int var1, ImageDoodad var2) {
      this.a.add(var1, var2);
   }

   public void e(int var1) {
      if (var1 >= 0 && var1 < this.a.size()) {
         this.a.remove(var1);
      }

   }
}
