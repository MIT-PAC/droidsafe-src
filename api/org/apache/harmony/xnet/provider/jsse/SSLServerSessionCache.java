package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import javax.net.ssl.SSLSession;

public interface SSLServerSessionCache {

  
  public byte[] getSessionData(byte[] id);

  
  public void putSessionData(SSLSession session, byte[] sessionData);
}
