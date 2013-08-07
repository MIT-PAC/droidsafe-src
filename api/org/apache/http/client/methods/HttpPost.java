package org.apache.http.client.methods;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.*;

import droidsafe.runtime.*;
import java.net.URI;

public class HttpPost extends HttpEntityEnclosingRequestBase {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:02.230 -0400", hash_original_method = "034A352FF9B05AAB848E440712ABE34B", hash_generated_method = "C6A37AF96414D210988FC17BEF563259")
    public  HttpPost() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:02.231 -0400", hash_original_method = "160A4A8C6AAC5C78A2F503FA797FE66F", hash_generated_method = "A8B986D251D55D73FE046BB884E3CBB5")
    public  HttpPost(final URI uri) {
        super();
        addTaint(uri.getTaint());
        setURI(uri);
        // ---------- Original Method ----------
        //setURI(uri);
    }

    
    @DSModeled(DSC.SPEC)
	public HttpPost(final String uri) {
        super();
        addTaint(uri.getTaint());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:02.232 -0400", hash_original_method = "E4A43B2F65721A683997A037549396C3", hash_generated_method = "020122F04CB94F2FDB3CF24BDD629B5F")
    @Override
    public String getMethod() {
String varADA0547DEAD34D39E77CF79940AB756D_1023403035 =         METHOD_NAME;
        varADA0547DEAD34D39E77CF79940AB756D_1023403035.addTaint(taint);
        return varADA0547DEAD34D39E77CF79940AB756D_1023403035;
        // ---------- Original Method ----------
        //return METHOD_NAME;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:02.233 -0400", hash_original_field = "E95841742F765A744B2C09D4A4229248", hash_generated_field = "93D97E8CFD3DD4E05FB1997B1AF38224")

    public final static String METHOD_NAME = "POST";
}

