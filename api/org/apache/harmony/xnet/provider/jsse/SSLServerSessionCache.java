package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.net.ssl.SSLSession;

public interface SSLServerSessionCache {

  
  public byte[] getSessionData(byte[] id);

  
  public void putSessionData(SSLSession session, byte[] sessionData);
}
