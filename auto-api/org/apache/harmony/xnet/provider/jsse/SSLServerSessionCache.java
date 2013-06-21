package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.net.ssl.SSLSession;

public interface SSLServerSessionCache {

  
  public byte[] getSessionData(byte[] id);

  
  public void putSessionData(SSLSession session, byte[] sessionData);
}
