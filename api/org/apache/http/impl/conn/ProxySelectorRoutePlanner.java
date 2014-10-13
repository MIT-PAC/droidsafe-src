package org.apache.http.impl.conn;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.protocol.HttpContext;

public class ProxySelectorRoutePlanner implements HttpRoutePlanner {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.702 -0500", hash_original_field = "FFCBB3FF9A8B5221F5621A7A590508B0", hash_generated_field = "262A27B6B6B1CBF25439CFECC3909997")

    protected SchemeRegistry schemeRegistry;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.704 -0500", hash_original_field = "BD8907878A7DA3B0E5B8AF7E66FD6133", hash_generated_field = "B499B9C301A586D28A25B3CD3E9E47FC")

    protected ProxySelector proxySelector;

    /**
     * Creates a new proxy selector route planner.
     *
     * @param schreg    the scheme registry
     * @param prosel    the proxy selector, or
     *                  <code>null</code> for the system default
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.707 -0500", hash_original_method = "2940DDB99DA35A45D241AA850C69BABB", hash_generated_method = "233D9C497249B4182F6C699E5A5AEB4F")
    
public ProxySelectorRoutePlanner(SchemeRegistry schreg,
                                     ProxySelector prosel) {

        if (schreg == null) {
            throw new IllegalArgumentException
                ("SchemeRegistry must not be null.");
        }
        schemeRegistry = schreg;
        proxySelector  = prosel;
    }

    /**
     * Obtains the proxy selector to use.
     *
     * @return the proxy selector, or <code>null</code> for the system default
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.709 -0500", hash_original_method = "7BFDCA23B0C60DE048DC61BFB74DD1F2", hash_generated_method = "F39972908F6A56C4ED115C3866308504")
    
public ProxySelector getProxySelector() {
        return this.proxySelector;
    }

    /**
     * Sets the proxy selector to use.
     *
     * @param prosel    the proxy selector, or
     *                  <code>null</code> to use the system default
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.712 -0500", hash_original_method = "8D192BFFC053F859733660633466B9E1", hash_generated_method = "1B3C585CE85476DAEF614C2867B107EA")
    
public void setProxySelector(ProxySelector prosel) {
        this.proxySelector = prosel;
    }

    // non-javadoc, see interface HttpRoutePlanner
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.714 -0500", hash_original_method = "B16751A21C345B7821B79B349C2D4F51", hash_generated_method = "084FA6E885FE7584185FAF481605ED19")
    
public HttpRoute determineRoute(HttpHost target,
                                    HttpRequest request,
                                    HttpContext context)
        throws HttpException {

        if (request == null) {
            throw new IllegalStateException
                ("Request must not be null.");
        }

        // If we have a forced route, we can do without a target.
        HttpRoute route =
            ConnRouteParams.getForcedRoute(request.getParams());
        if (route != null)
            return route;

        // If we get here, there is no forced route.
        // So we need a target to compute a route.

        if (target == null) {
            throw new IllegalStateException
                ("Target host must not be null.");
        }

        final InetAddress local =
            ConnRouteParams.getLocalAddress(request.getParams());

        // BEGIN android-changed
        //     If the client or request explicitly specifies a proxy (or no
        //     proxy), prefer that over the ProxySelector's VM-wide default.
        HttpHost proxy = (HttpHost) request.getParams().getParameter(ConnRoutePNames.DEFAULT_PROXY);
        if (proxy == null) {
            proxy = determineProxy(target, request, context);
        } else if (ConnRouteParams.NO_HOST.equals(proxy)) {
            // value is explicitly unset
            proxy = null;
        }
        // END android-changed

        final Scheme schm =
            this.schemeRegistry.getScheme(target.getSchemeName());
        // as it is typically used for TLS/SSL, we assume that
        // a layered scheme implies a secure connection
        final boolean secure = schm.isLayered();

        if (proxy == null) {
            route = new HttpRoute(target, local, secure);
        } else {
            route = new HttpRoute(target, local, proxy, secure);
        }
        return route;
    }

    /**
     * Determines a proxy for the given target.
     *
     * @param target    the planned target, never <code>null</code>
     * @param request   the request to be sent, never <code>null</code>
     * @param context   the context, or <code>null</code>
     *
     * @return  the proxy to use, or <code>null</code> for a direct route
     *
     * @throws HttpException
     *         in case of system proxy settings that cannot be handled
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.717 -0500", hash_original_method = "D5DFF4CEFF9EFFF0748C4A7B53D21FF4", hash_generated_method = "14EF3B907582DAACD36CDF9102EE8DCD")
    
protected HttpHost determineProxy(HttpHost    target,
                                      HttpRequest request,
                                      HttpContext context)
        throws HttpException {

        // the proxy selector can be 'unset', so we better deal with null here
        ProxySelector psel = this.proxySelector;
        if (psel == null)
            psel = ProxySelector.getDefault();
        if (psel == null)
            return null;

        URI targetURI = null;
        try {
            targetURI = new URI(target.toURI());
        } catch (URISyntaxException usx) {
            throw new HttpException
                ("Cannot convert host to URI: " + target, usx);
        }
        List<Proxy> proxies = psel.select(targetURI);

        Proxy p = chooseProxy(proxies, target, request, context);

        HttpHost result = null;
        if (p.type() == Proxy.Type.HTTP) {
            // convert the socket address to an HttpHost
            if (!(p.address() instanceof InetSocketAddress)) {
                throw new HttpException
                    ("Unable to handle non-Inet proxy address: "+p.address());
            }
            final InetSocketAddress isa = (InetSocketAddress) p.address();
            // assume default scheme (http)
            result = new HttpHost(getHost(isa), isa.getPort());
        }

        return result;
    }

    /**
     * Obtains a host from an {@link InetSocketAddress}.
     *
     * @param isa       the socket address
     *
     * @return  a host string, either as a symbolic name or
     *          as a literal IP address string
     * <br/>
     * (TODO: determine format for IPv6 addresses, with or without [brackets])
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.719 -0500", hash_original_method = "E71E40B42A0A74E659F7570AD29A596D", hash_generated_method = "D753955B088170EDBEF92362EF8B671E")
    
protected String getHost(InetSocketAddress isa) {

        //@@@ Will this work with literal IPv6 addresses, or do we
        //@@@ need to wrap these in [] for the string representation?
        //@@@ Having it in this method at least allows for easy workarounds.
       return isa.isUnresolved() ?
            isa.getHostName() : isa.getAddress().getHostAddress();
 
    }

    /*
     * Chooses a proxy from a list of available proxies.
     * The default implementation just picks the first non-SOCKS proxy
     * from the list. If there are only SOCKS proxies,
     * {@link Proxy#NO_PROXY Proxy.NO_PROXY} is returned.
     * Derived classes may implement more advanced strategies,
     * such as proxy rotation if there are multiple options.
     *
     * @param proxies   the list of proxies to choose from,
     *                  never <code>null</code> or empty
     * @param target    the planned target, never <code>null</code>
     * @param request   the request to be sent, never <code>null</code>
     * @param context   the context, or <code>null</code>
     *
     * @return  a proxy of type {@link Proxy.Type#DIRECT DIRECT}
     *          or {@link Proxy.Type#HTTP HTTP}, never <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.722 -0500", hash_original_method = "694ED3015481C37C82C93AB5B9471B72", hash_generated_method = "CD647C76698C28DB96765D71FA1C8570")
    
protected Proxy chooseProxy(List<Proxy> proxies,
                                HttpHost    target,
                                HttpRequest request,
                                HttpContext context) {

        if ((proxies == null) || proxies.isEmpty()) {
            throw new IllegalArgumentException
                ("Proxy list must not be empty.");
        }

        Proxy result = null;

        // check the list for one we can use
        for (int i=0; (result == null) && (i < proxies.size()); i++) {

            Proxy p = proxies.get(i);
            switch (p.type()) {

            case DIRECT:
            case HTTP:
                result = p;
                break;

            case SOCKS:
                // SOCKS hosts are not handled on the route level.
                // The socket may make use of the SOCKS host though.
                break;
            }
        }

        if (result == null) {
            //@@@ log as warning or info that only a socks proxy is available?
            // result can only be null if all proxies are socks proxies
            // socks proxies are not handled on the route planning level
            result = Proxy.NO_PROXY;
        }

        return result;
    }
    
}

