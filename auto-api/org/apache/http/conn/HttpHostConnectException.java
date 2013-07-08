package org.apache.http.conn;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.net.ConnectException;
import org.apache.http.HttpHost;

public class HttpHostConnectException extends ConnectException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.053 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "A05924381413D1FF5A0ADAC711A8D56A")

    private HttpHost host;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.054 -0400", hash_original_method = "D25CD4256FF06B874DEF78FBD87843BC", hash_generated_method = "733ADD492E5E309B5C7F82A8B6F961CD")
    public  HttpHostConnectException(final HttpHost host, final ConnectException cause) {
        super("Connection to " + host + " refused");
        this.host = host;
        initCause(cause);
        addTaint(cause.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.054 -0400", hash_original_method = "6529E0B2BF5C95A4487D992F02B2AAA6", hash_generated_method = "1A816B4CB0CD5515B2A807F8F24ADC3A")
    public HttpHost getHost() {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_227660756 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_227660756 = this.host;
        varB4EAC82CA7396A68D541C85D26508E83_227660756.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_227660756;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.054 -0400", hash_original_field = "224AA2E31150F51A8D2814E346E0824F", hash_generated_field = "A69580887BB1364AC479063D7D0209BA")

    private static final long serialVersionUID = -3194482710275220224L;
}

