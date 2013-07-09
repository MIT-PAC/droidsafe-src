package org.apache.http.impl.client;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;

public class TunnelRefusedException extends HttpException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.321 -0400", hash_original_field = "D1FC8EAF36937BE0C3BA8CFE0A2C1BFE", hash_generated_field = "641533335E49C8228D29EFDDBF1B520B")

    private HttpResponse response;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.321 -0400", hash_original_method = "E6490728CC48382F5DF5760ED5B82BB5", hash_generated_method = "61EA5A1940435F65CD748EA8C0409BFF")
    public  TunnelRefusedException(final String message, final HttpResponse response) {
        super(message);
        this.response = response;
        addTaint(message.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.322 -0400", hash_original_method = "3C5BCF9DD6B811984123D054EF330499", hash_generated_method = "E513FEADBC73829BA57D39622419E271")
    public HttpResponse getResponse() {
        HttpResponse varB4EAC82CA7396A68D541C85D26508E83_1792164881 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1792164881 = this.response;
        varB4EAC82CA7396A68D541C85D26508E83_1792164881.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1792164881;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.322 -0400", hash_original_field = "444E3819A6F3EF9AD2831E3832D30207", hash_generated_field = "B459F0506B32570E8618A9CEE66C0FB8")

    private static final long serialVersionUID = -8646722842745617323L;
}

