package org.apache.http.client.methods;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.URI;

public class HttpGet extends HttpRequestBase {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.939 -0400", hash_original_method = "5037302FD966B72BDD781660024EF657", hash_generated_method = "8EFE493527A73BE90AE403202B61D198")
    public  HttpGet() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.940 -0400", hash_original_method = "31474A7F59CE66F27E23571A1F0DC0EA", hash_generated_method = "2E7489B19D44AF145C44B97BB9C2452D")
    public  HttpGet(final URI uri) {
        super();
        setURI(uri);
        addTaint(uri.getTaint());
        // ---------- Original Method ----------
        //setURI(uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.940 -0400", hash_original_method = "DACE54F54F01CEE5FF3D25626E7EEBF2", hash_generated_method = "5EAB2F77E41D049AAB655EF81AD5F531")
    public  HttpGet(final String uri) {
        super();
        setURI(URI.create(uri));
        addTaint(uri.getTaint());
        // ---------- Original Method ----------
        //setURI(URI.create(uri));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.941 -0400", hash_original_method = "E4A43B2F65721A683997A037549396C3", hash_generated_method = "D596288803D1A3C507D930353F7D8575")
    @Override
    public String getMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_415657435 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_415657435 = METHOD_NAME;
        varB4EAC82CA7396A68D541C85D26508E83_415657435.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_415657435;
        // ---------- Original Method ----------
        //return METHOD_NAME;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.941 -0400", hash_original_field = "EA60A3A4BBB7965B19FD39563086C8C5", hash_generated_field = "BCFE29A06D4EB94143E09A5AED669A6C")

    public final static String METHOD_NAME = "GET";
}

