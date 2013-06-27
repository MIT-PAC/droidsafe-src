package org.apache.http.impl.conn;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.811 -0400", hash_original_field = "1D823F19EC944D016B48B105C3632412", hash_generated_field = "262A27B6B6B1CBF25439CFECC3909997")

    protected SchemeRegistry schemeRegistry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.813 -0400", hash_original_field = "C9D3163C35CA6D216D5A20F21BF75B4A", hash_generated_field = "B499B9C301A586D28A25B3CD3E9E47FC")

    protected ProxySelector proxySelector;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.820 -0400", hash_original_method = "2940DDB99DA35A45D241AA850C69BABB", hash_generated_method = "B3F509D8D1C7E447234BE1F6047C77D8")
    public  ProxySelectorRoutePlanner(SchemeRegistry schreg,
                                     ProxySelector prosel) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("SchemeRegistry must not be null.");
        } //End block
        schemeRegistry = schreg;
        proxySelector  = prosel;
        // ---------- Original Method ----------
        //if (schreg == null) {
            //throw new IllegalArgumentException
                //("SchemeRegistry must not be null.");
        //}
        //schemeRegistry = schreg;
        //proxySelector  = prosel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.825 -0400", hash_original_method = "7BFDCA23B0C60DE048DC61BFB74DD1F2", hash_generated_method = "35CCD6F1EE62BA639527F5C961EE0123")
    public ProxySelector getProxySelector() {
        ProxySelector varB4EAC82CA7396A68D541C85D26508E83_858754893 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_858754893 = this.proxySelector;
        varB4EAC82CA7396A68D541C85D26508E83_858754893.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_858754893;
        // ---------- Original Method ----------
        //return this.proxySelector;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.825 -0400", hash_original_method = "8D192BFFC053F859733660633466B9E1", hash_generated_method = "459A3B3BE9F0C2E926706EF05A5A3174")
    public void setProxySelector(ProxySelector prosel) {
        this.proxySelector = prosel;
        // ---------- Original Method ----------
        //this.proxySelector = prosel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.826 -0400", hash_original_method = "B16751A21C345B7821B79B349C2D4F51", hash_generated_method = "E107BFF816BF2BAC6EA4871CB728B079")
    public HttpRoute determineRoute(HttpHost target,
                                    HttpRequest request,
                                    HttpContext context) throws HttpException {
        HttpRoute varB4EAC82CA7396A68D541C85D26508E83_840921965 = null; //Variable for return #1
        HttpRoute varB4EAC82CA7396A68D541C85D26508E83_1042662479 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException
                ("Request must not be null.");
        } //End block
        HttpRoute route;
        route = ConnRouteParams.getForcedRoute(request.getParams());
        varB4EAC82CA7396A68D541C85D26508E83_840921965 = route;
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException
                ("Target host must not be null.");
        } //End block
        InetAddress local;
        local = ConnRouteParams.getLocalAddress(request.getParams());
        HttpHost proxy;
        proxy = (HttpHost) request.getParams().getParameter(ConnRoutePNames.DEFAULT_PROXY);
        {
            proxy = determineProxy(target, request, context);
        } //End block
        {
            boolean var3A3B1730A9B0E69F090BE371DC3D60A4_653782085 = (ConnRouteParams.NO_HOST.equals(proxy));
            {
                proxy = null;
            } //End block
        } //End collapsed parenthetic
        Scheme schm;
        schm = this.schemeRegistry.getScheme(target.getSchemeName());
        boolean secure;
        secure = schm.isLayered();
        {
            route = new HttpRoute(target, local, secure);
        } //End block
        {
            route = new HttpRoute(target, local, proxy, secure);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1042662479 = route;
        addTaint(target.getTaint());
        addTaint(request.getTaint());
        addTaint(context.getTaint());
        HttpRoute varA7E53CE21691AB073D9660D615818899_1456028435; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1456028435 = varB4EAC82CA7396A68D541C85D26508E83_840921965;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1456028435 = varB4EAC82CA7396A68D541C85D26508E83_1042662479;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1456028435.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1456028435;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.827 -0400", hash_original_method = "D5DFF4CEFF9EFFF0748C4A7B53D21FF4", hash_generated_method = "E5EE93B18D406B9A9B9BFCBFECA12519")
    protected HttpHost determineProxy(HttpHost    target,
                                      HttpRequest request,
                                      HttpContext context) throws HttpException {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_1866928252 = null; //Variable for return #1
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_748518794 = null; //Variable for return #2
        ProxySelector psel;
        psel = this.proxySelector;
        psel = ProxySelector.getDefault();
        varB4EAC82CA7396A68D541C85D26508E83_1866928252 = null;
        URI targetURI;
        targetURI = null;
        try 
        {
            targetURI = new URI(target.toURI());
        } //End block
        catch (URISyntaxException usx)
        {
            if (DroidSafeAndroidRuntime.control) throw new HttpException
                ("Cannot convert host to URI: " + target, usx);
        } //End block
        List<Proxy> proxies;
        proxies = psel.select(targetURI);
        Proxy p;
        p = chooseProxy(proxies, target, request, context);
        HttpHost result;
        result = null;
        {
            boolean varFCF1B5702E4038D5A3FC290F3E09C300_189438122 = (p.type() == Proxy.Type.HTTP);
            {
                {
                    boolean var6DD03F89A211F49F0E2AE3307E289083_1414941961 = (!(p.address() instanceof InetSocketAddress));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new HttpException
                    ("Unable to handle non-Inet proxy address: "+p.address());
                    } //End block
                } //End collapsed parenthetic
                InetSocketAddress isa;
                isa = (InetSocketAddress) p.address();
                result = new HttpHost(getHost(isa), isa.getPort());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_748518794 = result;
        addTaint(target.getTaint());
        addTaint(request.getTaint());
        addTaint(context.getTaint());
        HttpHost varA7E53CE21691AB073D9660D615818899_311510302; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_311510302 = varB4EAC82CA7396A68D541C85D26508E83_1866928252;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_311510302 = varB4EAC82CA7396A68D541C85D26508E83_748518794;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_311510302.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_311510302;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.827 -0400", hash_original_method = "E71E40B42A0A74E659F7570AD29A596D", hash_generated_method = "4FCA75DACE99DD4996C2C420446A2BD6")
    protected String getHost(InetSocketAddress isa) {
        String varB4EAC82CA7396A68D541C85D26508E83_1519370872 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1519370872 = isa.isUnresolved() ?
            isa.getHostName() : isa.getAddress().getHostAddress();
        addTaint(isa.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1519370872.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1519370872;
        // ---------- Original Method ----------
        //return isa.isUnresolved() ?
            //isa.getHostName() : isa.getAddress().getHostAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.828 -0400", hash_original_method = "694ED3015481C37C82C93AB5B9471B72", hash_generated_method = "D0CAEC34F045EF9634523E8E6B149C44")
    protected Proxy chooseProxy(List<Proxy> proxies,
                                HttpHost    target,
                                HttpRequest request,
                                HttpContext context) {
        Proxy varB4EAC82CA7396A68D541C85D26508E83_354646048 = null; //Variable for return #1
        {
            boolean var43769B345260203FA635DB8A1FF66D5E_1399605473 = ((proxies == null) || proxies.isEmpty());
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
            boolean var29542154170D852D0661B604E0DF03B1_350152543 = ((result == null) && (i < proxies.size()));
            {
                Proxy p;
                p = proxies.get(i);
                {
                    Object var7EE4CA5B556A0534978414FB5FF7D14D_205379171 = (p.type());
                    //Begin case DIRECT HTTP 
                    result = p;
                    //End case DIRECT HTTP 
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            result = Proxy.NO_PROXY;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_354646048 = result;
        addTaint(proxies.getTaint());
        addTaint(target.getTaint());
        addTaint(request.getTaint());
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_354646048.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_354646048;
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

