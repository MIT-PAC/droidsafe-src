package org.apache.http.client.methods;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.*;
import java.net.*;

import droidsafe.runtime.*;
import java.net.URI;

public class HttpPost extends HttpEntityEnclosingRequestBase {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.325 -0500", hash_original_field = "C6D1332D7E2FBBF1CFD284F30D60129A", hash_generated_field = "93D97E8CFD3DD4E05FB1997B1AF38224")

    public final static String METHOD_NAME = "POST";
    
    @DSVAModeled
    private URI theURI;

    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.328 -0500", hash_original_method = "034A352FF9B05AAB848E440712ABE34B", hash_generated_method = "8731034ED4B7D7C5F2C0F73BBAB5A4A9")
    
public HttpPost() {
        super();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.331 -0500", hash_original_method = "160A4A8C6AAC5C78A2F503FA797FE66F", hash_generated_method = "B46316C1B560DDE61F4B685238FCB29F")
    
public HttpPost(final URI uri) {
        super();
        setURI(uri);
    }
    
	public HttpPost(final String uri) {
        super();
        try {
            setURI(new URI(uri));
        } catch (URISyntaxException e) {
            
        }
        addTaint(uri.getTaint());
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.335 -0500", hash_original_method = "E4A43B2F65721A683997A037549396C3", hash_generated_method = "5FCF2FB47A767785DCEA247A24F7E8BC")
    
@Override
    public String getMethod() {
        return METHOD_NAME;
    }

    @DSSafe()
    public void setURI(final URI uri) {
        this.theURI = uri;
    }
    
    @DSSafe()
    public URI getURI() {
        return this.theURI;
    }

}

