package com.nowcomputing;

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

/**
 * was com.nowcomputing.a
 */
public class AnimatedImage {
   private ArrayList<Image> frames;
   private int anInt;

   public AnimatedImage(int size, int var2) {
      this.anInt = var2;
      this.frames = new ArrayList(size);

      for(int i = 0; i < size; ++i) {
         this.frames.add(new Image(20, 7));
      }

   }

   public AnimatedImage(AnimatedImage imageThingy) {
      this.anInt = imageThingy.getInt();
      this.frames = new ArrayList(imageThingy.frames.size());

      for(int var2 = 0; var2 < imageThingy.frames.size(); ++var2) {
         this.frames.add(new Image((Image)imageThingy.frames.get(var2)));
      }

   }

   public AnimatedImage(ArrayList images, int size) {
      this.frames = images;
      this.anInt = size;
   }

   public AnimatedImage(ArrayList<ImageWithANumber> imageList) {
      if (imageList != null && imageList.size() > 0) {
         if (imageList.get(0).anInt > 0) {
            this.anInt = 1000 / imageList.get(0).anInt;
         } else {
            this.anInt = 12;
         }

         int imageListSize = imageList.size();
         this.frames = new ArrayList(imageListSize);

         for(int i = 0; i < imageListSize; ++i) {
            this.frames.add(Image.FromBufferedImage(imageList.get(i).image, 20, 7));
         }
      }

   }

   public Image getFrame(int index) {
      return this.frames.get(index);
   }

   public int getFrameCount() {
      return this.frames != null ? this.frames.size() : 0;
   }

   public void removeFrame(int var1) {
      while(var1 < this.frames.size()) {
         this.frames.remove(this.frames.size() - 1);
      }

      while(var1 > this.frames.size()) {
         this.frames.add(new Image(20, 7));
      }

   }

   public int getInt() {
      return this.anInt;
   }

   public void setInt(int var1) {
      this.anInt = var1;
   }

   public static AnimatedImage LoadFromFile(File gifFile) throws IOException {
      ImageDisplay imageDisplay = new ImageDisplay();
      if (imageDisplay.a(gifFile.getPath()) != 0) {
         throw new IOException();
      } else {
         AnimatedImage animatedImage = new AnimatedImage(imageDisplay.getList());
         return animatedImage;
      }
   }

   public void exportGIF(File outFile) throws IOException {
      ImageWriter imageWriter = getImageWriter();
      ImageWriteParam imageWriteParam = imageWriter.getDefaultWriteParam();
      ImageTypeSpecifier typeSpecifier = ImageTypeSpecifier.createFromBufferedImageType(2);
      IIOMetadata iioMetadata = imageWriter.getDefaultImageMetadata(typeSpecifier, imageWriteParam);
      String formatName = iioMetadata.getNativeMetadataFormatName();
      IIOMetadataNode iioMetadataAsTree = (IIOMetadataNode)iioMetadata.getAsTree(formatName);
      IIOMetadataNode graphicControlExtension = AddIfNotExists(iioMetadataAsTree, "GraphicControlExtension");
      graphicControlExtension.setAttribute("disposalMethod", "none");
      graphicControlExtension.setAttribute("userInputFlag", "FALSE");
      graphicControlExtension.setAttribute("transparentColorFlag", "FALSE");
      graphicControlExtension.setAttribute("delayTime", Integer.toString(100 / this.getInt()));
      graphicControlExtension.setAttribute("transparentColorIndex", "0");
      IIOMetadataNode commentExtensions = AddIfNotExists(iioMetadataAsTree, "CommentExtensions");
      IIOMetadataNode commentExtension = AddIfNotExists(commentExtensions, "CommentExtension");
      commentExtension.setAttribute("value", "Created with Gameband!");
      IIOMetadataNode applicationExtensions = AddIfNotExists(iioMetadataAsTree, "ApplicationExtensions");
      IIOMetadataNode applicationExtension = new IIOMetadataNode("ApplicationExtension");
      applicationExtension.setAttribute("applicationID", "NETSCAPE");
      applicationExtension.setAttribute("authenticationCode", "2.0");
      byte mysteryByte = 0;
      applicationExtension.setUserObject(new byte[]{1, (byte)(mysteryByte & 255), (byte)(mysteryByte >> 8 & 255)});
      applicationExtensions.appendChild(applicationExtension);
      iioMetadata.setFromTree(formatName, iioMetadataAsTree);
      imageWriter.setOutput(new FileImageOutputStream(outFile));
      imageWriter.prepareWriteSequence((IIOMetadata)null);
      Iterator images = this.frames.iterator();

      while(images.hasNext()) {
         Image image = (Image)images.next();
         imageWriter.writeToSequence(new IIOImage(image.ToBufferedImage(), (List)null, iioMetadata), imageWriteParam);
      }

      imageWriter.endWriteSequence();
   }

   private static IIOMetadataNode AddIfNotExists(IIOMetadataNode parentNode, String var1) {
      int metadataLength = parentNode.getLength();

      for(int i = 0; i < metadataLength; ++i) {
         if (parentNode.item(i).getNodeName().compareToIgnoreCase(var1) == 0) {
            return (IIOMetadataNode)parentNode.item(i);
         }
      }

      IIOMetadataNode iioMetadataNode = new IIOMetadataNode(var1);
      parentNode.appendChild(iioMetadataNode);
      return iioMetadataNode;
   }

   private static ImageWriter getImageWriter() throws IIOException {
      Iterator var0 = ImageIO.getImageWritersByFormatName("gif");
      if (!var0.hasNext()) {
         throw new IIOException("No GIF Image Writers Exist");
      } else {
         return (ImageWriter)var0.next();
      }
   }

   public void invertImage() {
      Iterator var1 = this.frames.iterator();

      while(var1.hasNext()) {
         Image var2 = (Image)var1.next();
         var2.invertImage();
      }

   }

   public void insertFrame(int index) {
      this.insertFrame(index, new Image(20, 7));
   }

   public void insertFrame(int index, Image image) {
      this.frames.add(index, image);
   }

   public void truncateToSize(int size) {
      if (size >= 0 && size < this.frames.size()) {
         this.frames.remove(size);
      }

   }
}
