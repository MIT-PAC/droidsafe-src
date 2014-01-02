package org.apache.http.conn.ssl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

public interface X509HostnameVerifier extends HostnameVerifier {

    boolean verify(String host, SSLSession session);

    void verify(String host, SSLSocket ssl) throws IOException;

    void verify(String host, X509Certificate cert) throws SSLException;

    
    void verify(String host, String[] cns, String[] subjectAlts)
          throws SSLException;


}
