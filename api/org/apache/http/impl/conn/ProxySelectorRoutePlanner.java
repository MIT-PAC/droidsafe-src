package org.apache.http.impl.conn;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.549 -0400", hash_original_field = "1D823F19EC944D016B48B105C3632412", hash_generated_field = "262A27B6B6B1CBF25439CFECC3909997")

    protected SchemeRegistry schemeRegistry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.550 -0400", hash_original_field = "C9D3163C35CA6D216D5A20F21BF75B4A", hash_generated_field = "B499B9C301A586D28A25B3CD3E9E47FC")

    protected ProxySelector proxySelector;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.550 -0400", hash_original_method = "2940DDB99DA35A45D241AA850C69BABB", hash_generated_method = "B3F509D8D1C7E447234BE1F6047C77D8")
    public  ProxySelectorRoutePlanner(SchemeRegistry schreg,
                                     ProxySelector prosel) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("SchemeRegistry must not be null.");
        } 
        schemeRegistry = schreg;
        proxySelector  = prosel;
        
        
            
                
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.550 -0400", hash_original_method = "7BFDCA23B0C60DE048DC61BFB74DD1F2", hash_generated_method = "EDCAAC3078AC30A5F675C57C5C4C2B77")
    public ProxySelector getProxySelector() {
        ProxySelector varB4EAC82CA7396A68D541C85D26508E83_275023719 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_275023719 = this.proxySelector;
        varB4EAC82CA7396A68D541C85D26508E83_275023719.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_275023719;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.551 -0400", hash_original_method = "8D192BFFC053F859733660633466B9E1", hash_generated_method = "459A3B3BE9F0C2E926706EF05A5A3174")
    public void setProxySelector(ProxySelector prosel) {
        this.proxySelector = prosel;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.552 -0400", hash_original_method = "B16751A21C345B7821B79B349C2D4F51", hash_generated_method = "CECE9183372F645BA0DDB68700BD3E4C")
    public HttpRoute determineRoute(HttpHost target,
                                    HttpRequest request,
                                    HttpContext context) throws HttpException {
        HttpRoute varB4EAC82CA7396A68D541C85D26508E83_1302506672 = null; 
        HttpRoute varB4EAC82CA7396A68D541C85D26508E83_1563718202 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException
                ("Request must not be null.");
        } 
        HttpRoute route = ConnRouteParams.getForcedRoute(request.getParams());
        varB4EAC82CA7396A68D541C85D26508E83_1302506672 = route;
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException
                ("Target host must not be null.");
        } 
        final InetAddress local = ConnRouteParams.getLocalAddress(request.getParams());
        HttpHost proxy = (HttpHost) request.getParams().getParameter(ConnRoutePNames.DEFAULT_PROXY);
        {
            proxy = determineProxy(target, request, context);
        } 
        {
            boolean var3A3B1730A9B0E69F090BE371DC3D60A4_714131544 = (ConnRouteParams.NO_HOST.equals(proxy));
            {
                proxy = null;
            } 
        } 
        final Scheme schm = this.schemeRegistry.getScheme(target.getSchemeName());
        final boolean secure = schm.isLayered();
        {
            route = new HttpRoute(target, local, secure);
        } 
        {
            route = new HttpRoute(target, local, proxy, secure);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1563718202 = route;
        addTaint(target.getTaint());
        addTaint(request.getTaint());
        addTaint(context.getTaint());
        HttpRoute varA7E53CE21691AB073D9660D615818899_1926029990; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1926029990 = varB4EAC82CA7396A68D541C85D26508E83_1302506672;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1926029990 = varB4EAC82CA7396A68D541C85D26508E83_1563718202;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1926029990.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1926029990;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.553 -0400", hash_original_method = "D5DFF4CEFF9EFFF0748C4A7B53D21FF4", hash_generated_method = "37362AAFF40E7D5798623D22BEED7043")
    protected HttpHost determineProxy(HttpHost    target,
                                      HttpRequest request,
                                      HttpContext context) throws HttpException {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_1661475603 = null; 
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_700373326 = null; 
        ProxySelector psel = this.proxySelector;
        psel = ProxySelector.getDefault();
        varB4EAC82CA7396A68D541C85D26508E83_1661475603 = null;
        URI targetURI = null;
        try 
        {
            targetURI = new URI(target.toURI());
        } 
        catch (URISyntaxException usx)
        {
            if (DroidSafeAndroidRuntime.control) throw new HttpException
                ("Cannot convert host to URI: " + target, usx);
        } 
        List<Proxy> proxies = psel.select(targetURI);
        Proxy p = chooseProxy(proxies, target, request, context);
        HttpHost result = null;
        {
            boolean varFCF1B5702E4038D5A3FC290F3E09C300_475309429 = (p.type() == Proxy.Type.HTTP);
            {
                {
                    boolean var6DD03F89A211F49F0E2AE3307E289083_299804003 = (!(p.address() instanceof InetSocketAddress));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new HttpException
                    ("Unable to handle non-Inet proxy address: "+p.address());
                    } 
                } 
                final InetSocketAddress isa = (InetSocketAddress) p.address();
                result = new HttpHost(getHost(isa), isa.getPort());
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_700373326 = result;
        addTaint(target.getTaint());
        addTaint(request.getTaint());
        addTaint(context.getTaint());
        HttpHost varA7E53CE21691AB073D9660D615818899_250812344; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_250812344 = varB4EAC82CA7396A68D541C85D26508E83_1661475603;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_250812344 = varB4EAC82CA7396A68D541C85D26508E83_700373326;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_250812344.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_250812344;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.554 -0400", hash_original_method = "E71E40B42A0A74E659F7570AD29A596D", hash_generated_method = "A14B6DF35B054A0B17B9A5F436E130F6")
    protected String getHost(InetSocketAddress isa) {
        String varB4EAC82CA7396A68D541C85D26508E83_511111509 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_511111509 = isa.isUnresolved() ?
            isa.getHostName() : isa.getAddress().getHostAddress();
        addTaint(isa.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_511111509.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_511111509;
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.555 -0400", hash_original_method = "694ED3015481C37C82C93AB5B9471B72", hash_generated_method = "A72A567539E7C2CF807FB7AF5BB81D6A")
    protected Proxy chooseProxy(List<Proxy> proxies,
                                HttpHost    target,
                                HttpRequest request,
                                HttpContext context) {
        Proxy varB4EAC82CA7396A68D541C85D26508E83_958112647 = null; 
        {
            boolean var43769B345260203FA635DB8A1FF66D5E_384114983 = ((proxies == null) || proxies.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Proxy list must not be empty.");
            } 
        } 
        Proxy result = null;
        {
            int i = 0;
            boolean var29542154170D852D0661B604E0DF03B1_1664544636 = ((result == null) && (i < proxies.size()));
            {
                Proxy p = proxies.get(i);
                {
                    Object var7EE4CA5B556A0534978414FB5FF7D14D_1895521903 = (p.type());
                    
                    result = p;
                    
                } 
            } 
        } 
        {
            result = Proxy.NO_PROXY;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_958112647 = result;
        addTaint(proxies.getTaint());
        addTaint(target.getTaint());
        addTaint(request.getTaint());
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_958112647.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_958112647;
        
        
            
                
        
        
        
            
            
            
            
                
                
            
                
            
        
        
            
        
        
    }

    
}

