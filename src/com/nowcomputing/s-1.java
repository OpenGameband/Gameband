package com.nowcomputing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class s extends Class1 {
   private String i;

   public s() {
      super(D.setMinecraftPath());
      this.a();
   }

   private void a() {
      this.i = "https://gameband.nowcomputing.com/sw/00-updates/";

      try {
         HttpURLConnection var1 = this.c("https://gameband.nowcomputing.com/api");
         String var2 = this.a(var1);
         if (var2 != null && !var2.isEmpty()) {
            Document var3 = this.d(var2);
            Element var4 = this.a(var3, "query-update-reply", false);
            if (var4 != null) {
               String var5 = this.a(var4, "url").getTextContent();
               String var6 = this.a(var4, "bucket").getTextContent();
               String var7 = this.a(var4, "folder").getTextContent();
               this.i = var5 + "/" + var6 + "/" + var7 + "/";
            }
         }
      } catch (Exception var8) {
         logger.log(Level.WARNING, var8.toString(), var8);
      }

   }

   private HttpURLConnection c(String var1) {
      logger.log(Level.FINE, "Getting api URL " + var1);
      URL var2 = new URL(var1);
      HttpURLConnection var3 = (HttpURLConnection)var2.openConnection();
      var3.setRequestMethod("GET");
      var3.setDoInput(true);
      return var3;
   }

   private String a(HttpURLConnection var1) {
      StringBuilder var2 = new StringBuilder(128);
      BufferedReader var3 = null;

      try {
         InputStream var4 = null;
         int var5 = var1.getResponseCode();
         if (var5 == 200) {
            var4 = var1.getInputStream();
         } else {
            var4 = var1.getErrorStream();
         }

         var3 = new BufferedReader(new InputStreamReader(var4));
         String var6 = "";

         while((var6 = var3.readLine()) != null) {
            var2.append(var6);
         }
      } finally {
         if (var3 != null) {
            try {
               var3.close();
            } catch (IOException var12) {
            }
         }

      }

      logger.log(Level.FINER, "  Reply: " + var2);
      return var2.toString();
   }

   private Document d(String var1) {
      try {
         DocumentBuilderFactory var2 = DocumentBuilderFactory.newInstance();
         DocumentBuilder var3 = var2.newDocumentBuilder();
         InputSource var4 = new InputSource(new StringReader(var1));
         return var3.parse(var4);
      } catch (ParserConfigurationException var5) {
         throw new RuntimeException(var5);
      } catch (SAXException var6) {
         throw new RuntimeException(var6);
      } catch (IOException var7) {
         throw new RuntimeException(var7);
      }
   }

   private Element a(Document var1, String var2, boolean var3) {
      Node var4 = var1.getFirstChild();
      Element var5 = this.a((Element)var4, "error-msg");
      if (var5 != null) {
         logger.log(Level.WARNING, "WS Error: " + var5.getTextContent());
         if (var3) {
            return var5;
         }
      } else if (var4.getNodeName().equals(var2)) {
         return (Element)var4;
      }

      return null;
   }

   private Element a(Element var1, String var2) {
      NodeList var3 = var1.getElementsByTagName(var2);
      return var3.getLength() != 0 ? (Element)var3.item(0) : null;
   }

   protected InputStream method10(String var1) {
      logger.log(Level.FINE, "Getting URL " + this.i + var1);
      URL var2 = new URL(this.i + var1);
      HttpURLConnection var3 = (HttpURLConnection)var2.openConnection();
      var3.setRequestMethod("GET");
      var3.setDoInput(true);
      return var3.getInputStream();
   }
}
