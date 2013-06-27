package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.conn.routing.HttpRoute;

public class RoutedRequest {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.549 -0400", hash_original_field = "10573B873D2FA5A365D558A45E328E47", hash_generated_field = "FF2F6BAD955D736150EC6E1C7F7F08FF")

    protected RequestWrapper request;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.549 -0400", hash_original_field = "9C46408A3BC655C68505C57A11D6C4EE", hash_generated_field = "082455967E4D3C7BAE7FAA337B8F6279")

    protected HttpRoute route;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.551 -0400", hash_original_method = "A38E23E6BBCA60A8718121827E32C27A", hash_generated_method = "D5065DCBC4D557B9B9954115D6A54A85")
    public  RoutedRequest(final RequestWrapper req, final HttpRoute route) {
        super();
        this.request = req;
        this.route   = route;
        // ---------- Original Method ----------
        //this.request = req;
        //this.route   = route;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.551 -0400", hash_original_method = "EEED72C5B947069252F55B1761C3E136", hash_generated_method = "8EAAD0943B93F2593E2612C20AF038C4")
    public final RequestWrapper getRequest() {
        RequestWrapper varB4EAC82CA7396A68D541C85D26508E83_684363343 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_684363343 = request;
        varB4EAC82CA7396A68D541C85D26508E83_684363343.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_684363343;
        // ---------- Original Method ----------
        //return request;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.557 -0400", hash_original_method = "A51AC1237DD43D471744BBD4E881146C", hash_generated_method = "993627F344313CD923511B96A375F5B0")
    public final HttpRoute getRoute() {
        HttpRoute varB4EAC82CA7396A68D541C85D26508E83_2052135961 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2052135961 = route;
        varB4EAC82CA7396A68D541C85D26508E83_2052135961.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2052135961;
        // ---------- Original Method ----------
        //return route;
    }

    
}

