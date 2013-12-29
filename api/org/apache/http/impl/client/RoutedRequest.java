package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.conn.routing.HttpRoute;






public class RoutedRequest {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:21.844 -0500", hash_original_field = "1B86BBB8E2250F22E920B3E428610E45", hash_generated_field = "FF2F6BAD955D736150EC6E1C7F7F08FF")


    protected  RequestWrapper request;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:21.845 -0500", hash_original_field = "8824947D446181E666F5CCE159788709", hash_generated_field = "082455967E4D3C7BAE7FAA337B8F6279")

    protected  HttpRoute route;

    /**
     * Creates a new routed request.
     *
     * @param req   the request
     * @param route   the route
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:21.846 -0500", hash_original_method = "A38E23E6BBCA60A8718121827E32C27A", hash_generated_method = "EACB2A8AC45F9E3F33B52F2A89935418")
    public RoutedRequest(final RequestWrapper req, final HttpRoute route) {
        super();
        this.request = req;
        this.route   = route;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:21.847 -0500", hash_original_method = "EEED72C5B947069252F55B1761C3E136", hash_generated_method = "2C7936F9D77E107EF5E41D9FF028E3CC")
    public final RequestWrapper getRequest() {
        return request;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:21.847 -0500", hash_original_method = "A51AC1237DD43D471744BBD4E881146C", hash_generated_method = "34C7DA051C58A0672C915D7D35F32FE9")
    public final HttpRoute getRoute() {
        return route;
    }

    
}

