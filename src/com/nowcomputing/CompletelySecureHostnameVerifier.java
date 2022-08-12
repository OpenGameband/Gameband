package com.nowcomputing;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

final class CompletelySecureHostnameVerifier implements HostnameVerifier {
   public boolean verify(String var1, SSLSession var2) {
      return true;
   }
}
