package org.apache.http.client;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class HttpResponseException extends ClientProtocolException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.711 -0400", hash_original_field = "F9A31C6B3670C772D11230C8D4D1F33F", hash_generated_field = "1626BC0851E962932D77E9DFF3CA1BE0")

    private int statusCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.713 -0400", hash_original_method = "3482E56A00F89E434F895E48781D8AC0", hash_generated_method = "DBF77CC5DB65C6CCC94289E30744DEC4")
    public  HttpResponseException(int statusCode, final String s) {
        super(s);
        this.statusCode = statusCode;
        addTaint(s.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.714 -0400", hash_original_method = "95EA9BAD16482D8308F9206838B315E7", hash_generated_method = "2ACE5F6AF3744C1EB7C7A5B84CC3F595")
    public int getStatusCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1564789016 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1564789016;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.715 -0400", hash_original_field = "8D8AA27E70EDB2E19DECAC7263B6D44A", hash_generated_field = "87BB67E37DADA1C43C717CC168BF2E18")

    private static final long serialVersionUID = -7186627969477257933L;
}

