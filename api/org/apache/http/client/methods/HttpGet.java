package org.apache.http.client.methods;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import java.net.URI;





@DSVAModeled
public class HttpGet extends HttpRequestBase {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.038 -0500", hash_original_field = "FAA38044AD16F915890905B63FBBCA42", hash_generated_field = "BCFE29A06D4EB94143E09A5AED669A6C")


    public final static String METHOD_NAME = "GET";
    
    @DSVAModeled
    private URI theURI;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.040 -0500", hash_original_method = "5037302FD966B72BDD781660024EF657", hash_generated_method = "0C8D3574F60C84033C0278476E55ECDE")
    
public HttpGet() {
        super();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.043 -0500", hash_original_method = "31474A7F59CE66F27E23571A1F0DC0EA", hash_generated_method = "746BE47C6BCD631FEA7CF15494CB8B2C")
    
public HttpGet(final URI uri) {
        super();
        setURI(uri);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.426 -0400", hash_original_method = "DACE54F54F01CEE5FF3D25626E7EEBF2", hash_generated_method = "18E73CB6390DC2C709D6D3975107CA40")
    public  HttpGet(final String uri) {
        super();
        addTaint(uri.getTaint());
        try {
            setURI(new URI(uri));
        } catch (Exception e) {
            
        }
        // ---------- Original Method ----------
        //setURI(URI.create(uri));
    }
    
    @DSModeled(DSC.SAFE)
    public void setURI(final URI uri) {
        this.theURI = uri;
    }
    

    @DSModeled(DSC.SAFE)
    public URI getURI() {
        return this.theURI;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.048 -0500", hash_original_method = "E4A43B2F65721A683997A037549396C3", hash_generated_method = "5FCF2FB47A767785DCEA247A24F7E8BC")
    
@Override
    public String getMethod() {
        return METHOD_NAME;
    }
}

