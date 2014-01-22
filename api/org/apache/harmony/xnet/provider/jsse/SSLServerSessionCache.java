package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.net.ssl.SSLSession;

public interface SSLServerSessionCache {
  
  @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public byte[] getSessionData(byte[] id);
  
  @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void putSessionData(SSLSession session, byte[] sessionData);
}
