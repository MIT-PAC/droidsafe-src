package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.conn.routing.HttpRoute;

public class RoutedRequest {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.669 -0400", hash_original_field = "10573B873D2FA5A365D558A45E328E47", hash_generated_field = "FF2F6BAD955D736150EC6E1C7F7F08FF")

    protected RequestWrapper request;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.669 -0400", hash_original_field = "9C46408A3BC655C68505C57A11D6C4EE", hash_generated_field = "082455967E4D3C7BAE7FAA337B8F6279")

    protected HttpRoute route;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.670 -0400", hash_original_method = "A38E23E6BBCA60A8718121827E32C27A", hash_generated_method = "D5065DCBC4D557B9B9954115D6A54A85")
    public  RoutedRequest(final RequestWrapper req, final HttpRoute route) {
        super();
        this.request = req;
        this.route   = route;
        // ---------- Original Method ----------
        //this.request = req;
        //this.route   = route;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.671 -0400", hash_original_method = "EEED72C5B947069252F55B1761C3E136", hash_generated_method = "23091CA4DE1D06D69495BAB84905EAC0")
    public final RequestWrapper getRequest() {
RequestWrapper varCA5195E6E15F740103A7066F05C33A8B_1557855597 =         request;
        varCA5195E6E15F740103A7066F05C33A8B_1557855597.addTaint(taint);
        return varCA5195E6E15F740103A7066F05C33A8B_1557855597;
        // ---------- Original Method ----------
        //return request;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.671 -0400", hash_original_method = "A51AC1237DD43D471744BBD4E881146C", hash_generated_method = "366AAC54CBDF2FCC004D70D8D00A4625")
    public final HttpRoute getRoute() {
HttpRoute var6679678B82FF79D06F753D1737D68FA6_1190586451 =         route;
        var6679678B82FF79D06F753D1737D68FA6_1190586451.addTaint(taint);
        return var6679678B82FF79D06F753D1737D68FA6_1190586451;
        // ---------- Original Method ----------
        //return route;
    }

    
}

