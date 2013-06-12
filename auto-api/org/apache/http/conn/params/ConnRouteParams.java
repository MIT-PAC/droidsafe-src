package org.apache.http.conn.params;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.net.InetAddress;
import org.apache.http.HttpHost;
import org.apache.http.params.HttpParams;
import org.apache.http.conn.routing.HttpRoute;

public class ConnRouteParams implements ConnRoutePNames {
    public static final HttpHost NO_HOST =
        new HttpHost("127.0.0.255", 0, "no-host");
    public static final HttpRoute NO_ROUTE = new HttpRoute(NO_HOST);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.987 -0400", hash_original_method = "2F583F6C69B80DBD9155194B569BE764", hash_generated_method = "B56CDD380F17400DADFAE9BFA27B9497")
    @DSModeled(DSC.SAFE)
    private ConnRouteParams() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.987 -0400", hash_original_method = "E75D121FDB3E170AE23E7EDECAF29000", hash_generated_method = "E7D155192D53F7632F219DBBBB4C9AFA")
    public static HttpHost getDefaultProxy(HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException("Parameters must not be null.");
        }
        HttpHost proxy = (HttpHost)
            params.getParameter(DEFAULT_PROXY);
        if ((proxy != null) && NO_HOST.equals(proxy)) {
            proxy = null;
        }
        return proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.987 -0400", hash_original_method = "49317954D5EBD5F28B2656B10CFB38A3", hash_generated_method = "81B11DD955AF9B9880F88DC4851DCDC3")
    public static void setDefaultProxy(HttpParams params,
                                             HttpHost proxy) {
        if (params == null) {
            throw new IllegalArgumentException("Parameters must not be null.");
        }
        params.setParameter(DEFAULT_PROXY, proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.987 -0400", hash_original_method = "5DAC36E561A1B4897EACF2D00E5FE007", hash_generated_method = "FF3CF7845F4CCDAB9A251F539CDBCA4D")
    public static HttpRoute getForcedRoute(HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException("Parameters must not be null.");
        }
        HttpRoute route = (HttpRoute)
            params.getParameter(FORCED_ROUTE);
        if ((route != null) && NO_ROUTE.equals(route)) {
            route = null;
        }
        return route;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.988 -0400", hash_original_method = "07DB9F0458B5079746CBE9BE59C5E99C", hash_generated_method = "835399968526A6E79409D748AB4D1B44")
    public static void setForcedRoute(HttpParams params,
                                            HttpRoute route) {
        if (params == null) {
            throw new IllegalArgumentException("Parameters must not be null.");
        }
        params.setParameter(FORCED_ROUTE, route);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.988 -0400", hash_original_method = "34B1651D44BDD2A6852C4B7591C5FF46", hash_generated_method = "4B23E223AFDC567C633186D18CFD16B8")
    public static InetAddress getLocalAddress(HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException("Parameters must not be null.");
        }
        InetAddress local = (InetAddress)
            params.getParameter(LOCAL_ADDRESS);
        return local;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.988 -0400", hash_original_method = "DD9D8CA6968C4F4E34A4098B9D14DC8D", hash_generated_method = "87730081EB8B7527793B3AB51E2E539E")
    public static void setLocalAddress(HttpParams params,
                                             InetAddress local) {
        if (params == null) {
            throw new IllegalArgumentException("Parameters must not be null.");
        }
        params.setParameter(LOCAL_ADDRESS, local);
    }

    
}


