package org.apache.http.client.methods;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.net.URI;

public class HttpGet extends HttpRequestBase {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.171 -0400", hash_original_method = "5037302FD966B72BDD781660024EF657", hash_generated_method = "8EFE493527A73BE90AE403202B61D198")
    public  HttpGet() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.172 -0400", hash_original_method = "31474A7F59CE66F27E23571A1F0DC0EA", hash_generated_method = "5836DA1D051A606B6242F1ABC917AC67")
    public  HttpGet(final URI uri) {
        super();
        addTaint(uri.getTaint());
        setURI(uri);
        // ---------- Original Method ----------
        //setURI(uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.173 -0400", hash_original_method = "DACE54F54F01CEE5FF3D25626E7EEBF2", hash_generated_method = "18E73CB6390DC2C709D6D3975107CA40")
    public  HttpGet(final String uri) {
        super();
        addTaint(uri.getTaint());
        setURI(URI.create(uri));
        // ---------- Original Method ----------
        //setURI(URI.create(uri));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.174 -0400", hash_original_method = "E4A43B2F65721A683997A037549396C3", hash_generated_method = "A467123862D94C2D60E3C2B08166AE4F")
    @Override
    public String getMethod() {
String varADA0547DEAD34D39E77CF79940AB756D_245939213 =         METHOD_NAME;
        varADA0547DEAD34D39E77CF79940AB756D_245939213.addTaint(taint);
        return varADA0547DEAD34D39E77CF79940AB756D_245939213;
        // ---------- Original Method ----------
        //return METHOD_NAME;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.174 -0400", hash_original_field = "EA60A3A4BBB7965B19FD39563086C8C5", hash_generated_field = "BCFE29A06D4EB94143E09A5AED669A6C")

    public final static String METHOD_NAME = "GET";
}

