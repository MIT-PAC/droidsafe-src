package org.apache.http.impl.conn;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

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
import org.apache.http.protocol.HttpContext;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.conn.params.ConnRoutePNames;

public class ProxySelectorRoutePlanner implements HttpRoutePlanner {
    protected SchemeRegistry schemeRegistry;
    protected ProxySelector proxySelector;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.033 -0400", hash_original_method = "2940DDB99DA35A45D241AA850C69BABB", hash_generated_method = "6B32D5EAF770278C8F818DAE1C3B69A1")
    @DSModeled(DSC.SAFE)
    public ProxySelectorRoutePlanner(SchemeRegistry schreg,
                                     ProxySelector prosel) {
        dsTaint.addTaint(prosel.dsTaint);
        dsTaint.addTaint(schreg.dsTaint);
        {
            throw new IllegalArgumentException
                ("SchemeRegistry must not be null.");
        } //End block
        // ---------- Original Method ----------
        //if (schreg == null) {
            //throw new IllegalArgumentException
                //("SchemeRegistry must not be null.");
        //}
        //schemeRegistry = schreg;
        //proxySelector  = prosel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.033 -0400", hash_original_method = "7BFDCA23B0C60DE048DC61BFB74DD1F2", hash_generated_method = "DE7CD628DB31D4F85305175EB277027B")
    @DSModeled(DSC.SAFE)
    public ProxySelector getProxySelector() {
        return (ProxySelector)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.proxySelector;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.033 -0400", hash_original_method = "8D192BFFC053F859733660633466B9E1", hash_generated_method = "9DC865520FB065E7275F35E79C08F8E9")
    @DSModeled(DSC.SAFE)
    public void setProxySelector(ProxySelector prosel) {
        dsTaint.addTaint(prosel.dsTaint);
        // ---------- Original Method ----------
        //this.proxySelector = prosel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.033 -0400", hash_original_method = "B16751A21C345B7821B79B349C2D4F51", hash_generated_method = "8249A7A1925BB0B3CF426C68842A2A6D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HttpRoute determineRoute(HttpHost target,
                                    HttpRequest request,
                                    HttpContext context) throws HttpException {
        dsTaint.addTaint(request.dsTaint);
        dsTaint.addTaint(target.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        {
        	if (DroidSafeAndroidRuntime.control) throw new IllegalStateException
                ("Request must not be null.");
        } //End block
        HttpRoute route;
        route = ConnRouteParams.getForcedRoute(request.getParams());
        {
        	if (DroidSafeAndroidRuntime.control) throw new IllegalStateException
                ("Target host must not be null.");
        } //End block
        final InetAddress local;
        local = ConnRouteParams.getLocalAddress(request.getParams());
        HttpHost proxy;
        proxy = (HttpHost) request.getParams().getParameter(ConnRoutePNames.DEFAULT_PROXY);
        {
            proxy = determineProxy(target, request, context);
        } //End block
        {
            boolean var3A3B1730A9B0E69F090BE371DC3D60A4_820650284 = (ConnRouteParams.NO_HOST.equals(proxy));
            {
                proxy = null;
            } //End block
        } //End collapsed parenthetic
        final Scheme schm;
        schm = this.schemeRegistry.getScheme(target.getSchemeName());
        final boolean secure;
        secure = schm.isLayered();
        {
            route = new HttpRoute(target, local, secure);
        } //End block
        {
            route = new HttpRoute(target, local, proxy, secure);
        } //End block
        return (HttpRoute)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.033 -0400", hash_original_method = "D5DFF4CEFF9EFFF0748C4A7B53D21FF4", hash_generated_method = "B82DFFF6255EB08FCB39C82E98E13F95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected HttpHost determineProxy(HttpHost    target,
                                      HttpRequest request,
                                      HttpContext context) throws HttpException {
        dsTaint.addTaint(request.dsTaint);
        dsTaint.addTaint(target.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        ProxySelector psel;
        psel = this.proxySelector;
        psel = ProxySelector.getDefault();
        URI targetURI;
        targetURI = null;
        try 
        {
            targetURI = new URI(target.toURI());
        } //End block
        catch (URISyntaxException usx)
        {
            throw new HttpException
                ("Cannot convert host to URI: " + target, usx);
        } //End block
        List<Proxy> proxies;
        proxies = psel.select(targetURI);
        Proxy p;
        p = chooseProxy(proxies, target, request, context);
        HttpHost result;
        result = null;
        {
            boolean varFCF1B5702E4038D5A3FC290F3E09C300_365112235 = (p.type() == Proxy.Type.HTTP);
            {
                {
                    boolean var6DD03F89A211F49F0E2AE3307E289083_1699990995 = (!(p.address() instanceof InetSocketAddress));
                    {
                    	if (DroidSafeAndroidRuntime.control) throw new HttpException
                    ("Unable to handle non-Inet proxy address: "+p.address());
                    } //End block
                } //End collapsed parenthetic
                final InetSocketAddress isa;
                isa = (InetSocketAddress) p.address();
                result = new HttpHost(getHost(isa), isa.getPort());
            } //End block
        } //End collapsed parenthetic
        return (HttpHost)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.033 -0400", hash_original_method = "E71E40B42A0A74E659F7570AD29A596D", hash_generated_method = "C4B043EDCF7F4D86DF2CABB8A56C317A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String getHost(InetSocketAddress isa) {
        dsTaint.addTaint(isa.dsTaint);
        {
            boolean var876B1E7764FDC6B3ADEB01C46E76222F_491112666 = (isa.isUnresolved());
            Object varFEFAE048F8D01D850A11BE31BE806B8A_178855966 = (isa.getHostName());
            Object var99B0E3A8377118FD5C52C6A7670F0053_96463837 = (isa.getAddress().getHostAddress());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return isa.isUnresolved() ?
            //isa.getHostName() : isa.getAddress().getHostAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.034 -0400", hash_original_method = "694ED3015481C37C82C93AB5B9471B72", hash_generated_method = "0A26B1BCB3F275E811F413A1C05E4A88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Proxy chooseProxy(List<Proxy> proxies,
                                HttpHost    target,
                                HttpRequest request,
                                HttpContext context) {
        dsTaint.addTaint(request.dsTaint);
        dsTaint.addTaint(target.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(proxies.dsTaint);
        {
            boolean var43769B345260203FA635DB8A1FF66D5E_1136860056 = ((proxies == null) || proxies.isEmpty());
            {
            	if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Proxy list must not be empty.");
            } //End block
        } //End collapsed parenthetic
        Proxy result;
        result = null;
        {
            int i;
            i = 0;
            boolean var29542154170D852D0661B604E0DF03B1_1103556061 = ((result == null) && (i < proxies.size()));
            {
                Proxy p;
                p = proxies.get(i);
                {
                    Object var7EE4CA5B556A0534978414FB5FF7D14D_1052544285 = (p.type());
                    //Begin case DIRECT HTTP 
                    result = p;
                    //End case DIRECT HTTP 
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            result = Proxy.NO_PROXY;
        } //End block
        return (Proxy)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if ((proxies == null) || proxies.isEmpty()) {
            //throw new IllegalArgumentException
                //("Proxy list must not be empty.");
        //}
        //Proxy result = null;
        //for (int i=0; (result == null) && (i < proxies.size()); i++) {
            //Proxy p = proxies.get(i);
            //switch (p.type()) {
            //case DIRECT:
            //case HTTP:
                //result = p;
                //break;
            //case SOCKS:
                //break;
            //}
        //}
        //if (result == null) {
            //result = Proxy.NO_PROXY;
        //}
        //return result;
    }

    
}


