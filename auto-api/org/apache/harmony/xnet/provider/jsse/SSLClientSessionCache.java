package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.net.ssl.SSLSession;

public interface SSLClientSessionCache {

  
  public byte[] getSessionData(String host, int port);

  
  public void putSessionData(SSLSession session, byte[] sessionData);
}
