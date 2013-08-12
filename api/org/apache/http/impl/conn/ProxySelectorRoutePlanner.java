package org.apache.http.impl.conn;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.191 -0400", hash_original_field = "1D823F19EC944D016B48B105C3632412", hash_generated_field = "262A27B6B6B1CBF25439CFECC3909997")

    protected SchemeRegistry schemeRegistry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.192 -0400", hash_original_field = "C9D3163C35CA6D216D5A20F21BF75B4A", hash_generated_field = "B499B9C301A586D28A25B3CD3E9E47FC")

    protected ProxySelector proxySelector;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.192 -0400", hash_original_method = "2940DDB99DA35A45D241AA850C69BABB", hash_generated_method = "8E04EF4A2941AA185CBB522F58F32F20")
    public  ProxySelectorRoutePlanner(SchemeRegistry schreg,
                                     ProxySelector prosel) {
        if(schreg == null)        
        {
            IllegalArgumentException varC1A930A1E2305600F1F8F0BFDDECA23C_346872090 = new IllegalArgumentException
                ("SchemeRegistry must not be null.");
            varC1A930A1E2305600F1F8F0BFDDECA23C_346872090.addTaint(taint);
            throw varC1A930A1E2305600F1F8F0BFDDECA23C_346872090;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.193 -0400", hash_original_method = "7BFDCA23B0C60DE048DC61BFB74DD1F2", hash_generated_method = "D10328A02B8C419DADC75934E15533A5")
    public ProxySelector getProxySelector() {
ProxySelector varD3380ECC38BE7FD63E5966CA0B474B68_290099454 =         this.proxySelector;
        varD3380ECC38BE7FD63E5966CA0B474B68_290099454.addTaint(taint);
        return varD3380ECC38BE7FD63E5966CA0B474B68_290099454;
        // ---------- Original Method ----------
        //return this.proxySelector;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.193 -0400", hash_original_method = "8D192BFFC053F859733660633466B9E1", hash_generated_method = "459A3B3BE9F0C2E926706EF05A5A3174")
    public void setProxySelector(ProxySelector prosel) {
        this.proxySelector = prosel;
        // ---------- Original Method ----------
        //this.proxySelector = prosel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.195 -0400", hash_original_method = "B16751A21C345B7821B79B349C2D4F51", hash_generated_method = "0422597328675735B00400BF0443E4C4")
    public HttpRoute determineRoute(HttpHost target,
                                    HttpRequest request,
                                    HttpContext context) throws HttpException {
        addTaint(context.getTaint());
        addTaint(request.getTaint());
        addTaint(target.getTaint());
        if(request == null)        
        {
            IllegalStateException varCC521902EA7C4FEA2EAC4BD15DE196C4_1157134010 = new IllegalStateException
                ("Request must not be null.");
            varCC521902EA7C4FEA2EAC4BD15DE196C4_1157134010.addTaint(taint);
            throw varCC521902EA7C4FEA2EAC4BD15DE196C4_1157134010;
        } //End block
        HttpRoute route = ConnRouteParams.getForcedRoute(request.getParams());
        if(route != null)        
        {
HttpRoute var6679678B82FF79D06F753D1737D68FA6_1718592157 =         route;
        var6679678B82FF79D06F753D1737D68FA6_1718592157.addTaint(taint);
        return var6679678B82FF79D06F753D1737D68FA6_1718592157;
        }
        if(target == null)        
        {
            IllegalStateException varC99BA3EA47D51B52C8067BBDFD32CF30_1116128251 = new IllegalStateException
                ("Target host must not be null.");
            varC99BA3EA47D51B52C8067BBDFD32CF30_1116128251.addTaint(taint);
            throw varC99BA3EA47D51B52C8067BBDFD32CF30_1116128251;
        } //End block
        final InetAddress local = ConnRouteParams.getLocalAddress(request.getParams());
        HttpHost proxy = (HttpHost) request.getParams().getParameter(ConnRoutePNames.DEFAULT_PROXY);
        if(proxy == null)        
        {
            proxy = determineProxy(target, request, context);
        } //End block
        else
        if(ConnRouteParams.NO_HOST.equals(proxy))        
        {
            proxy = null;
        } //End block
        final Scheme schm = this.schemeRegistry.getScheme(target.getSchemeName());
        final boolean secure = schm.isLayered();
        if(proxy == null)        
        {
            route = new HttpRoute(target, local, secure);
        } //End block
        else
        {
            route = new HttpRoute(target, local, proxy, secure);
        } //End block
HttpRoute var6679678B82FF79D06F753D1737D68FA6_330765704 =         route;
        var6679678B82FF79D06F753D1737D68FA6_330765704.addTaint(taint);
        return var6679678B82FF79D06F753D1737D68FA6_330765704;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.197 -0400", hash_original_method = "D5DFF4CEFF9EFFF0748C4A7B53D21FF4", hash_generated_method = "67C4ED832E0CCCD6B1A71B51CB4062B0")
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
HttpHost var540C13E9E156B687226421B24F2DF178_91123974 =         null;
        var540C13E9E156B687226421B24F2DF178_91123974.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_91123974;
        }
        URI targetURI = null;
        try 
        {
            targetURI = new URI(target.toURI());
        } //End block
        catch (URISyntaxException usx)
        {
            HttpException var5AE26294245DE54E73FE3EA474723263_1118907077 = new HttpException
                ("Cannot convert host to URI: " + target, usx);
            var5AE26294245DE54E73FE3EA474723263_1118907077.addTaint(taint);
            throw var5AE26294245DE54E73FE3EA474723263_1118907077;
        } //End block
        List<Proxy> proxies = psel.select(targetURI);
        Proxy p = chooseProxy(proxies, target, request, context);
        HttpHost result = null;
        if(p.type() == Proxy.Type.HTTP)        
        {
            if(!(p.address() instanceof InetSocketAddress))            
            {
                HttpException var2A1EAAFE7B0CEFB7F9AC551058977B9C_777795753 = new HttpException
                    ("Unable to handle non-Inet proxy address: "+p.address());
                var2A1EAAFE7B0CEFB7F9AC551058977B9C_777795753.addTaint(taint);
                throw var2A1EAAFE7B0CEFB7F9AC551058977B9C_777795753;
            } //End block
            final InetSocketAddress isa = (InetSocketAddress) p.address();
            result = new HttpHost(getHost(isa), isa.getPort());
        } //End block
HttpHost varDC838461EE2FA0CA4C9BBB70A15456B0_1046479367 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1046479367.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1046479367;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.198 -0400", hash_original_method = "E71E40B42A0A74E659F7570AD29A596D", hash_generated_method = "DF9559A756EC8A4D639F3B6513FFDFBA")
    protected String getHost(InetSocketAddress isa) {
        addTaint(isa.getTaint());
String var2EE20BBBD78AB32415FDF46E966B3A7F_778595061 =         isa.isUnresolved() ?
            isa.getHostName() : isa.getAddress().getHostAddress();
        var2EE20BBBD78AB32415FDF46E966B3A7F_778595061.addTaint(taint);
        return var2EE20BBBD78AB32415FDF46E966B3A7F_778595061;
        // ---------- Original Method ----------
        //return isa.isUnresolved() ?
            //isa.getHostName() : isa.getAddress().getHostAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.199 -0400", hash_original_method = "694ED3015481C37C82C93AB5B9471B72", hash_generated_method = "E400545ED757EB5247FC80BB5C8B05AC")
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
            IllegalArgumentException varD2437156B6B1DDFA25BD17D59A9901B5_1263812513 = new IllegalArgumentException
                ("Proxy list must not be empty.");
            varD2437156B6B1DDFA25BD17D59A9901B5_1263812513.addTaint(taint);
            throw varD2437156B6B1DDFA25BD17D59A9901B5_1263812513;
        } //End block
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
        } //End block
        if(result == null)        
        {
            result = Proxy.NO_PROXY;
        } //End block
Proxy varDC838461EE2FA0CA4C9BBB70A15456B0_703354712 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_703354712.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_703354712;
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

