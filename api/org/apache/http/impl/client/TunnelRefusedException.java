package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;






public class TunnelRefusedException extends HttpException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.733 -0500", hash_original_field = "D752CE1A88C1F886A16B7C99A68D1C67", hash_generated_field = "B459F0506B32570E8618A9CEE66C0FB8")


    private static final long serialVersionUID = -8646722842745617323L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.735 -0500", hash_original_field = "AAE2B12EC2C7A9BE56B582863EC04771", hash_generated_field = "641533335E49C8228D29EFDDBF1B520B")


    private  HttpResponse response;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.738 -0500", hash_original_method = "E6490728CC48382F5DF5760ED5B82BB5", hash_generated_method = "A4DD459CDE5E6FF00A1B0DA145E3C7E8")
    
public TunnelRefusedException(final String message, final HttpResponse response) {
        super(message);
        this.response = response;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.740 -0500", hash_original_method = "3C5BCF9DD6B811984123D054EF330499", hash_generated_method = "05194DD02A87297C724F2644C569C6B2")
    
public HttpResponse getResponse() {
        return this.response;
    }
}

