package android.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface EventHandler {
    
    public static final int OK = 0;
    
    public static final int ERROR = -1;
    
    public static final int ERROR_LOOKUP = -2;
    
    public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
    
    public static final int ERROR_AUTH = -4;
    
    public static final int ERROR_PROXYAUTH = -5;
    
    public static final int ERROR_CONNECT = -6;
    
    public static final int ERROR_IO = -7;
    
    public static final int ERROR_TIMEOUT = -8;
    
    public static final int ERROR_REDIRECT_LOOP = -9;
    
    public static final int ERROR_UNSUPPORTED_SCHEME = -10;
    
    public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
    
    public static final int ERROR_BAD_URL = -12;
    
    public static final int FILE_ERROR = -13;
    
    public static final int FILE_NOT_FOUND_ERROR = -14;
    
    public static final int TOO_MANY_REQUESTS_ERROR = -15;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void status(int major_version,
                       int minor_version,
                       int code,
                       String reason_phrase);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void headers(Headers headers);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void data(byte[] data, int len);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void endData();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void certificate(SslCertificate certificate);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void error(int id, String description);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean handleSslErrorRequest(SslError error);

}
