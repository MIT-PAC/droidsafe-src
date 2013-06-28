package org.apache.http.client.methods;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.URI;

public class HttpPost extends HttpEntityEnclosingRequestBase {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.771 -0400", hash_original_method = "034A352FF9B05AAB848E440712ABE34B", hash_generated_method = "C6A37AF96414D210988FC17BEF563259")
    public  HttpPost() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.771 -0400", hash_original_method = "160A4A8C6AAC5C78A2F503FA797FE66F", hash_generated_method = "54897B9E0E632E485EEEB8336C04CC0B")
    public  HttpPost(final URI uri) {
        super();
        setURI(uri);
        addTaint(uri.getTaint());
        // ---------- Original Method ----------
        //setURI(uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.771 -0400", hash_original_method = "B5DCF56430FBBF48F34820708ADBDBD9", hash_generated_method = "0BAC90B8BC03B1BA3BA7CBCDB416E860")
    public  HttpPost(final String uri) {
        super();
        setURI(URI.create(uri));
        addTaint(uri.getTaint());
        // ---------- Original Method ----------
        //setURI(URI.create(uri));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.772 -0400", hash_original_method = "E4A43B2F65721A683997A037549396C3", hash_generated_method = "37A3AA428B53352A8F676854B7CF6E73")
    @Override
    public String getMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_1092318087 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1092318087 = METHOD_NAME;
        varB4EAC82CA7396A68D541C85D26508E83_1092318087.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1092318087;
        // ---------- Original Method ----------
        //return METHOD_NAME;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.772 -0400", hash_original_field = "E95841742F765A744B2C09D4A4229248", hash_generated_field = "93D97E8CFD3DD4E05FB1997B1AF38224")

    public final static String METHOD_NAME = "POST";
}

