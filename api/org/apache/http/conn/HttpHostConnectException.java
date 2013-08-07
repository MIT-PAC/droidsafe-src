package org.apache.http.conn;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.net.ConnectException;

import org.apache.http.HttpHost;






public class HttpHostConnectException extends ConnectException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.711 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "A05924381413D1FF5A0ADAC711A8D56A")

    private HttpHost host;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.711 -0400", hash_original_method = "D25CD4256FF06B874DEF78FBD87843BC", hash_generated_method = "B68E0961CE08096778410A4975A47668")
    public  HttpHostConnectException(final HttpHost host, final ConnectException cause) {
        super("Connection to " + host + " refused");
        addTaint(cause.getTaint());
        this.host = host;
        initCause(cause);
        // ---------- Original Method ----------
        //this.host = host;
        //initCause(cause);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.712 -0400", hash_original_method = "6529E0B2BF5C95A4487D992F02B2AAA6", hash_generated_method = "4BC59CA6278CA5B64A53416959282D2D")
    public HttpHost getHost() {
HttpHost var66CBD60FD8EB006652E02A446703F8AC_1677732750 =         this.host;
        var66CBD60FD8EB006652E02A446703F8AC_1677732750.addTaint(taint);
        return var66CBD60FD8EB006652E02A446703F8AC_1677732750;
        // ---------- Original Method ----------
        //return this.host;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.712 -0400", hash_original_field = "224AA2E31150F51A8D2814E346E0824F", hash_generated_field = "A69580887BB1364AC479063D7D0209BA")

    private static final long serialVersionUID = -3194482710275220224L;
}

