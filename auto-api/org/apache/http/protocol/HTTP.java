package org.apache.http.protocol;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public final class HTTP {
    public static final int CR = 13;
    public static final int LF = 10;
    public static final int SP = 32;
    public static final int HT = 9;
    public static final String TRANSFER_ENCODING = "Transfer-Encoding";
    public static final String CONTENT_LEN  = "Content-Length";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String CONTENT_ENCODING = "Content-Encoding";
    public static final String EXPECT_DIRECTIVE = "Expect";
    public static final String CONN_DIRECTIVE = "Connection";
    public static final String TARGET_HOST = "Host";
    public static final String USER_AGENT = "User-Agent";
    public static final String DATE_HEADER = "Date";
    public static final String SERVER_HEADER = "Server";
    public static final String EXPECT_CONTINUE = "100-continue";
    public static final String CONN_CLOSE = "Close";
    public static final String CONN_KEEP_ALIVE = "Keep-Alive";
    public static final String CHUNK_CODING = "chunked";
    public static final String IDENTITY_CODING = "identity";
    public static final String UTF_8 = "UTF-8";
    public static final String UTF_16 = "UTF-16";
    public static final String US_ASCII = "US-ASCII";
    public static final String ASCII = "ASCII";
    public static final String ISO_8859_1 = "ISO-8859-1";
    public static final String DEFAULT_CONTENT_CHARSET = ISO_8859_1;
    public static final String DEFAULT_PROTOCOL_CHARSET = US_ASCII;
    public final static String OCTET_STREAM_TYPE = "application/octet-stream";
    public final static String PLAIN_TEXT_TYPE = "text/plain";
    public final static String CHARSET_PARAM = "; charset=";
    public final static String DEFAULT_CONTENT_TYPE = OCTET_STREAM_TYPE;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.036 -0400", hash_original_method = "3A6FCD823D5B25065B735A0BBABE71E6", hash_generated_method = "23EB6DA0BF2877EA5B4A57F04470E546")
    @DSModeled(DSC.SAFE)
    private HTTP() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.036 -0400", hash_original_method = "134212A674CF385E582642AFF649A905", hash_generated_method = "E308477FC9CABEB85C4755A08378A651")
    public static boolean isWhitespace(char ch) {
        return ch == SP || ch == HT || ch == CR || ch == LF;
    }

    
}


