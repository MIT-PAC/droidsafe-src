package org.apache.http.impl.client;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;

public class TunnelRefusedException extends HttpException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.677 -0400", hash_original_field = "D1FC8EAF36937BE0C3BA8CFE0A2C1BFE", hash_generated_field = "641533335E49C8228D29EFDDBF1B520B")

    private HttpResponse response;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.677 -0400", hash_original_method = "E6490728CC48382F5DF5760ED5B82BB5", hash_generated_method = "5FFA439BBBFF9F5E54BDC9B83F45F9A7")
    public  TunnelRefusedException(final String message, final HttpResponse response) {
        super(message);
        addTaint(message.getTaint());
        this.response = response;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.677 -0400", hash_original_method = "3C5BCF9DD6B811984123D054EF330499", hash_generated_method = "EA0B559023C3AF69733C4B5FD7DD4CEC")
    public HttpResponse getResponse() {
HttpResponse var9180F5C05EE7124E45D77914B849345D_344063422 =         this.response;
        var9180F5C05EE7124E45D77914B849345D_344063422.addTaint(taint);
        return var9180F5C05EE7124E45D77914B849345D_344063422;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.678 -0400", hash_original_field = "444E3819A6F3EF9AD2831E3832D30207", hash_generated_field = "B459F0506B32570E8618A9CEE66C0FB8")

    private static final long serialVersionUID = -8646722842745617323L;
}

