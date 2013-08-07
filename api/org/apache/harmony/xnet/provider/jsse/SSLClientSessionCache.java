package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.annotations.*;
import javax.net.ssl.SSLSession;

public interface SSLClientSessionCache {

  
  public byte[] getSessionData(String host, int port);

  
  public void putSessionData(SSLSession session, byte[] sessionData);
}
