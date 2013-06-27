package org.apache.http.conn;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.ConnectException;
import org.apache.http.HttpHost;

public class HttpHostConnectException extends ConnectException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.209 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "A05924381413D1FF5A0ADAC711A8D56A")

    private HttpHost host;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.210 -0400", hash_original_method = "D25CD4256FF06B874DEF78FBD87843BC", hash_generated_method = "733ADD492E5E309B5C7F82A8B6F961CD")
    public  HttpHostConnectException(final HttpHost host, final ConnectException cause) {
        super("Connection to " + host + " refused");
        this.host = host;
        initCause(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
        //this.host = host;
        //initCause(cause);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.210 -0400", hash_original_method = "6529E0B2BF5C95A4487D992F02B2AAA6", hash_generated_method = "FA67B3FB700CB8A0F077F2984E1A8148")
    public HttpHost getHost() {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_2080171604 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2080171604 = this.host;
        varB4EAC82CA7396A68D541C85D26508E83_2080171604.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2080171604;
        // ---------- Original Method ----------
        //return this.host;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.210 -0400", hash_original_field = "224AA2E31150F51A8D2814E346E0824F", hash_generated_field = "83DCA78A15D56556111CC716B570B883")

    private static long serialVersionUID = -3194482710275220224L;
}

