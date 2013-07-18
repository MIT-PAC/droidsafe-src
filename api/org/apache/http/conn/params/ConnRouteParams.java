package org.apache.http.conn.params;

// Droidsafe Imports
import java.net.InetAddress;

import org.apache.http.HttpHost;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.params.HttpParams;

import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class ConnRouteParams implements ConnRoutePNames {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.757 -0400", hash_original_method = "2F583F6C69B80DBD9155194B569BE764", hash_generated_method = "FFA6007C752912BAF6FA892E8F7D0248")
    private  ConnRouteParams() {
        // ---------- Original Method ----------
    }

    
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

    
    public static void setDefaultProxy(HttpParams params,
                                             HttpHost proxy) {
        if (params == null) {
            throw new IllegalArgumentException("Parameters must not be null.");
        }
        params.setParameter(DEFAULT_PROXY, proxy);
    }

    
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

    
    public static void setForcedRoute(HttpParams params,
                                            HttpRoute route) {
        if (params == null) {
            throw new IllegalArgumentException("Parameters must not be null.");
        }
        params.setParameter(FORCED_ROUTE, route);
    }

    
    public static InetAddress getLocalAddress(HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException("Parameters must not be null.");
        }
        InetAddress local = (InetAddress)
            params.getParameter(LOCAL_ADDRESS);
        return local;
    }

    
    public static void setLocalAddress(HttpParams params,
                                             InetAddress local) {
        if (params == null) {
            throw new IllegalArgumentException("Parameters must not be null.");
        }
        params.setParameter(LOCAL_ADDRESS, local);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.759 -0400", hash_original_field = "44C71CB67B550E5A1F6E82C06BACB694", hash_generated_field = "FAE323EF23E9AD73D7AF5D28E86E6ED7")

    public static final HttpHost NO_HOST =
        new HttpHost("127.0.0.255", 0, "no-host");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.759 -0400", hash_original_field = "C54F7A337B613C7461445275E68622D3", hash_generated_field = "21C3B0F0B6993EB3CF4E0DF755BE9E2A")

    public static final HttpRoute NO_ROUTE = new HttpRoute(NO_HOST);
}

