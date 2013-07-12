package org.apache.http.impl.conn;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.900 -0400", hash_original_field = "1D823F19EC944D016B48B105C3632412", hash_generated_field = "262A27B6B6B1CBF25439CFECC3909997")

    protected SchemeRegistry schemeRegistry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.900 -0400", hash_original_field = "C9D3163C35CA6D216D5A20F21BF75B4A", hash_generated_field = "B499B9C301A586D28A25B3CD3E9E47FC")

    protected ProxySelector proxySelector;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.901 -0400", hash_original_method = "2940DDB99DA35A45D241AA850C69BABB", hash_generated_method = "B332770F5F158206A3E2F127538FBC12")
    public  ProxySelectorRoutePlanner(SchemeRegistry schreg,
                                     ProxySelector prosel) {
    if(schreg == null)        
        {
            IllegalArgumentException varC1A930A1E2305600F1F8F0BFDDECA23C_140487783 = new IllegalArgumentException
                ("SchemeRegistry must not be null.");
            varC1A930A1E2305600F1F8F0BFDDECA23C_140487783.addTaint(taint);
            throw varC1A930A1E2305600F1F8F0BFDDECA23C_140487783;
        } 
        schemeRegistry = schreg;
        proxySelector  = prosel;
        
        
            
                
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.901 -0400", hash_original_method = "7BFDCA23B0C60DE048DC61BFB74DD1F2", hash_generated_method = "8EC1962636EB61C615B6B5296CD3C882")
    public ProxySelector getProxySelector() {
ProxySelector varD3380ECC38BE7FD63E5966CA0B474B68_1194323898 =         this.proxySelector;
        varD3380ECC38BE7FD63E5966CA0B474B68_1194323898.addTaint(taint);
        return varD3380ECC38BE7FD63E5966CA0B474B68_1194323898;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.901 -0400", hash_original_method = "8D192BFFC053F859733660633466B9E1", hash_generated_method = "459A3B3BE9F0C2E926706EF05A5A3174")
    public void setProxySelector(ProxySelector prosel) {
        this.proxySelector = prosel;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.902 -0400", hash_original_method = "B16751A21C345B7821B79B349C2D4F51", hash_generated_method = "E12F3EA2A70AA6C44DC291FB645304B1")
    public HttpRoute determineRoute(HttpHost target,
                                    HttpRequest request,
                                    HttpContext context) throws HttpException {
        addTaint(context.getTaint());
        addTaint(request.getTaint());
        addTaint(target.getTaint());
    if(request == null)        
        {
            IllegalStateException varCC521902EA7C4FEA2EAC4BD15DE196C4_427579420 = new IllegalStateException
                ("Request must not be null.");
            varCC521902EA7C4FEA2EAC4BD15DE196C4_427579420.addTaint(taint);
            throw varCC521902EA7C4FEA2EAC4BD15DE196C4_427579420;
        } 
        HttpRoute route = ConnRouteParams.getForcedRoute(request.getParams());
    if(route != null)        
        {
HttpRoute var6679678B82FF79D06F753D1737D68FA6_273296859 =         route;
        var6679678B82FF79D06F753D1737D68FA6_273296859.addTaint(taint);
        return var6679678B82FF79D06F753D1737D68FA6_273296859;
        }
    if(target == null)        
        {
            IllegalStateException varC99BA3EA47D51B52C8067BBDFD32CF30_124322999 = new IllegalStateException
                ("Target host must not be null.");
            varC99BA3EA47D51B52C8067BBDFD32CF30_124322999.addTaint(taint);
            throw varC99BA3EA47D51B52C8067BBDFD32CF30_124322999;
        } 
        final InetAddress local = ConnRouteParams.getLocalAddress(request.getParams());
        HttpHost proxy = (HttpHost) request.getParams().getParameter(ConnRoutePNames.DEFAULT_PROXY);
    if(proxy == null)        
        {
            proxy = determineProxy(target, request, context);
        } 
        else
    if(ConnRouteParams.NO_HOST.equals(proxy))        
        {
            proxy = null;
        } 
        final Scheme schm = this.schemeRegistry.getScheme(target.getSchemeName());
        final boolean secure = schm.isLayered();
    if(proxy == null)        
        {
            route = new HttpRoute(target, local, secure);
        } 
        else
        {
            route = new HttpRoute(target, local, proxy, secure);
        } 
HttpRoute var6679678B82FF79D06F753D1737D68FA6_2123177130 =         route;
        var6679678B82FF79D06F753D1737D68FA6_2123177130.addTaint(taint);
        return var6679678B82FF79D06F753D1737D68FA6_2123177130;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.904 -0400", hash_original_method = "D5DFF4CEFF9EFFF0748C4A7B53D21FF4", hash_generated_method = "3ABC3BFA6F88B6293053F7852DDE325B")
    protected HttpHost determineProxy(HttpHost    target,
                                      HttpRequest request,
                                      HttpContext context) throws HttpException {
        addTaint(context.getTaint());
        addTaint(request.getTaint());
        addTaint(target.getTaint());
        ProxySelector psel = this.proxySelector;
    if(psel == null)        
        psel = ProxySelector.getDefault();
    if(psel == null)        
        {
HttpHost var540C13E9E156B687226421B24F2DF178_1039586883 =         null;
        var540C13E9E156B687226421B24F2DF178_1039586883.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1039586883;
        }
        URI targetURI = null;
        try 
        {
            targetURI = new URI(target.toURI());
        } 
        catch (URISyntaxException usx)
        {
            HttpException var5AE26294245DE54E73FE3EA474723263_919555161 = new HttpException
                ("Cannot convert host to URI: " + target, usx);
            var5AE26294245DE54E73FE3EA474723263_919555161.addTaint(taint);
            throw var5AE26294245DE54E73FE3EA474723263_919555161;
        } 
        List<Proxy> proxies = psel.select(targetURI);
        Proxy p = chooseProxy(proxies, target, request, context);
        HttpHost result = null;
    if(p.type() == Proxy.Type.HTTP)        
        {
    if(!(p.address() instanceof InetSocketAddress))            
            {
                HttpException var2A1EAAFE7B0CEFB7F9AC551058977B9C_1957944821 = new HttpException
                    ("Unable to handle non-Inet proxy address: "+p.address());
                var2A1EAAFE7B0CEFB7F9AC551058977B9C_1957944821.addTaint(taint);
                throw var2A1EAAFE7B0CEFB7F9AC551058977B9C_1957944821;
            } 
            final InetSocketAddress isa = (InetSocketAddress) p.address();
            result = new HttpHost(getHost(isa), isa.getPort());
        } 
HttpHost varDC838461EE2FA0CA4C9BBB70A15456B0_624889232 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_624889232.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_624889232;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.904 -0400", hash_original_method = "E71E40B42A0A74E659F7570AD29A596D", hash_generated_method = "67A45E9354C27A200F87A2C886239C2A")
    protected String getHost(InetSocketAddress isa) {
        addTaint(isa.getTaint());
String var2EE20BBBD78AB32415FDF46E966B3A7F_292084437 =         isa.isUnresolved() ?
            isa.getHostName() : isa.getAddress().getHostAddress();
        var2EE20BBBD78AB32415FDF46E966B3A7F_292084437.addTaint(taint);
        return var2EE20BBBD78AB32415FDF46E966B3A7F_292084437;
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.905 -0400", hash_original_method = "694ED3015481C37C82C93AB5B9471B72", hash_generated_method = "A1CF7669EEA6167F775F3066D2FEA129")
    protected Proxy chooseProxy(List<Proxy> proxies,
                                HttpHost    target,
                                HttpRequest request,
                                HttpContext context) {
        addTaint(context.getTaint());
        addTaint(request.getTaint());
        addTaint(target.getTaint());
        addTaint(proxies.getTaint());
    if((proxies == null) || proxies.isEmpty())        
        {
            IllegalArgumentException varD2437156B6B1DDFA25BD17D59A9901B5_480399678 = new IllegalArgumentException
                ("Proxy list must not be empty.");
            varD2437156B6B1DDFA25BD17D59A9901B5_480399678.addTaint(taint);
            throw varD2437156B6B1DDFA25BD17D59A9901B5_480399678;
        } 
        Proxy result = null;
for(int i=0;(result == null) && (i < proxies.size());i++)
        {
            Proxy p = proxies.get(i);
switch(p.type()){
            case DIRECT:
            case HTTP:
            result = p;
            break;
            case SOCKS:
            break;
}
        } 
    if(result == null)        
        {
            result = Proxy.NO_PROXY;
        } 
Proxy varDC838461EE2FA0CA4C9BBB70A15456B0_302382873 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_302382873.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_302382873;
        
        
            
                
        
        
        
            
            
            
            
                
                
            
                
            
        
        
            
        
        
    }

    
}

