package org.apache.http.conn.routing;

// Droidsafe Imports
import java.net.InetAddress;
// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import org.apache.http.HttpHost;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;

public final class HttpRoute implements RouteInfo, Cloneable {
    private final HttpHost targetHost;
    private final InetAddress localAddress;
    private final HttpHost[] proxyChain;
    private final TunnelType tunnelled;
    private final LayerType layered;
    private final boolean secure;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.004 -0400", hash_original_method = "5CB4C66072DE9146913D6ADB77CB6362", hash_generated_method = "E965EC299C43F0082FD4D129DB34382B")
    @DSModeled(DSC.SAFE)
    private HttpRoute(InetAddress local,
                      HttpHost target, HttpHost[] proxies,
                      boolean secure,
                      TunnelType tunnelled, LayerType layered) {
        dsTaint.addTaint(layered.dsTaint);
        dsTaint.addTaint(tunnelled.dsTaint);
        dsTaint.addTaint(target.dsTaint);
        dsTaint.addTaint(secure);
        dsTaint.addTaint(local.dsTaint);
        dsTaint.addTaint(proxies[0].dsTaint);
        
      this.targetHost   = target;
        this.localAddress = local;
        this.proxyChain   = proxies;
        this.secure       = secure;
        this.tunnelled    = tunnelled;
        this.layered      = layered;
        
        {
        	if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Target host may not be null.");
        } //End block
        {
        	if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Proxy required if tunnelled.");
        } //End block
        tunnelled = TunnelType.PLAIN;
        layered = LayerType.PLAIN;
        
        
        // ---------- Original Method ----------
        //if (target == null) {
            //throw new IllegalArgumentException
                //("Target host may not be null.");
        //}
        //if ((tunnelled == TunnelType.TUNNELLED) && (proxies == null)) {
            //throw new IllegalArgumentException
                //("Proxy required if tunnelled.");
        //}
        //if (tunnelled == null)
            //tunnelled = TunnelType.PLAIN;
        //if (layered == null)
            //layered = LayerType.PLAIN;
        //this.targetHost   = target;
        //this.localAddress = local;
        //this.proxyChain   = proxies;
        //this.secure       = secure;
        //this.tunnelled    = tunnelled;
        //this.layered      = layered;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.004 -0400", hash_original_method = "552F6B1597CA5ECF686CDEE0458B0DC7", hash_generated_method = "C6B86E7BDEE45571119152ED9240514F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HttpRoute(HttpHost target, InetAddress local, HttpHost[] proxies,
                     boolean secure, TunnelType tunnelled, LayerType layered) {
        this(local, target, toChain(proxies), secure, tunnelled, layered);
        dsTaint.addTaint(layered.dsTaint);
        dsTaint.addTaint(tunnelled.dsTaint);
        dsTaint.addTaint(target.dsTaint);
        dsTaint.addTaint(secure);
        dsTaint.addTaint(local.dsTaint);
        dsTaint.addTaint(proxies[0].dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.004 -0400", hash_original_method = "65CC9974914C583AD70C403F8621F2C0", hash_generated_method = "9C945A859D74FD81FA143495EF481F7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HttpRoute(HttpHost target, InetAddress local, HttpHost proxy,
                     boolean secure, TunnelType tunnelled, LayerType layered) {
        this(local, target, toChain(proxy), secure, tunnelled, layered);
        dsTaint.addTaint(layered.dsTaint);
        dsTaint.addTaint(tunnelled.dsTaint);
        dsTaint.addTaint(proxy.dsTaint);
        dsTaint.addTaint(target.dsTaint);
        dsTaint.addTaint(secure);
        dsTaint.addTaint(local.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.004 -0400", hash_original_method = "76AC245ADF42DED69B554EDA9FD556DE", hash_generated_method = "11CE47C4ACF06AFC85BA52DB0E7BD686")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HttpRoute(HttpHost target, InetAddress local, boolean secure) {
        this(local, target, null, secure, TunnelType.PLAIN, LayerType.PLAIN);
        dsTaint.addTaint(target.dsTaint);
        dsTaint.addTaint(secure);
        dsTaint.addTaint(local.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.004 -0400", hash_original_method = "30B1C0BF43231AE18DB893662C2E010C", hash_generated_method = "D1CD12A7653472BA679C59A3E113288A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HttpRoute(HttpHost target) {
        this(null, target, null, false, TunnelType.PLAIN, LayerType.PLAIN);
        dsTaint.addTaint(target.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.004 -0400", hash_original_method = "BFF1075A3FB2A926B1AAFF01869C54BF", hash_generated_method = "49D7E755AA877CC979A6F78F86C57846")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HttpRoute(HttpHost target, InetAddress local, HttpHost proxy,
                     boolean secure) {
        this(local, target, toChain(proxy), secure,
             secure ? TunnelType.TUNNELLED : TunnelType.PLAIN,
             secure ? LayerType.LAYERED    : LayerType.PLAIN);
        dsTaint.addTaint(proxy.dsTaint);
        dsTaint.addTaint(target.dsTaint);
        dsTaint.addTaint(secure);
        dsTaint.addTaint(local.dsTaint);
        {
            throw new IllegalArgumentException
                ("Proxy host may not be null.");
        } //End block
        // ---------- Original Method ----------
        //if (proxy == null) {
            //throw new IllegalArgumentException
                //("Proxy host may not be null.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.004 -0400", hash_original_method = "1F6E08AD78395DDC36B17C9725479A05", hash_generated_method = "1CB58370D9C0D265BF2B44F328DE8743")
    private static HttpHost[] toChain(HttpHost proxy) {
        if (proxy == null)
            return null;
        return new HttpHost[]{ proxy };
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.004 -0400", hash_original_method = "19BAC4EB9F0AC75365ACA9BCF61634EC", hash_generated_method = "B467CF89C47A8499C7872AAA69802292")
    private static HttpHost[] toChain(HttpHost[] proxies) {
        if ((proxies == null) || (proxies.length < 1))
            return null;
        for (HttpHost proxy : proxies) {
            if (proxy == null)
                throw new IllegalArgumentException
                        ("Proxy chain may not contain null elements.");
        }
        HttpHost[] result = new HttpHost[proxies.length];
        System.arraycopy(proxies, 0, result, 0, proxies.length);
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.004 -0400", hash_original_method = "00F8E4422BF57DE6758D681F4A99BDB6", hash_generated_method = "F58319E22E8E9FD0CC25075B14A326D1")
    @DSModeled(DSC.SAFE)
    public final HttpHost getTargetHost() {
        return (HttpHost)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.targetHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.004 -0400", hash_original_method = "28495B9032685860E947A62701D0E919", hash_generated_method = "4FACBE78E76A301A3A12CC86AA336AA2")
    @DSModeled(DSC.SAFE)
    public final InetAddress getLocalAddress() {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.localAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.004 -0400", hash_original_method = "8A1F6C82C6946ABA9036325DB5D1093A", hash_generated_method = "F5DCE9E3CD773E5A8F480F7E2DA66AE7")
    @DSModeled(DSC.SAFE)
    public final int getHopCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (proxyChain == null) ? 1 : (proxyChain.length+1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.004 -0400", hash_original_method = "6FAF652E1C9EAABAB417C8ED32D41F4A", hash_generated_method = "D38C54C44450B6DB103C8D2EE3EE6FB9")
    @DSModeled(DSC.SAFE)
    public final HttpHost getHopTarget(int hop) {
        dsTaint.addTaint(hop);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Hop index must not be negative: " + hop);
        int hopcount;
        hopcount = getHopCount();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Hop index " + hop +
                 " exceeds route length " + hopcount);
        HttpHost result;
        result = this.proxyChain[hop];
        result = this.targetHost;
        return (HttpHost)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (hop < 0)
            //throw new IllegalArgumentException
                //("Hop index must not be negative: " + hop);
        //final int hopcount = getHopCount();
        //if (hop >= hopcount)
            //throw new IllegalArgumentException
                //("Hop index " + hop +
                 //" exceeds route length " + hopcount);
        //HttpHost result = null;
        //if (hop < hopcount-1)
            //result = this.proxyChain[hop];
        //else
            //result = this.targetHost;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.004 -0400", hash_original_method = "E9E1E8AC6D9C2477F7E0F63BF0C4ED60", hash_generated_method = "B62CDA1A97C048836E7D1E20505E32D6")
    @DSModeled(DSC.SAFE)
    public final HttpHost getProxyHost() {
        return (HttpHost)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (this.proxyChain == null) ? null : this.proxyChain[0];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.004 -0400", hash_original_method = "350E5C2EB4A104FE6F444729C8CD5444", hash_generated_method = "AA2D26A8050AD75135DF371C69A08E9F")
    @DSModeled(DSC.SAFE)
    public final TunnelType getTunnelType() {
        return (TunnelType)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.tunnelled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.004 -0400", hash_original_method = "5CD3D72A708D2B06B9BD542F01F3D0EE", hash_generated_method = "7782B023D7E7C9E46C20398458305437")
    @DSModeled(DSC.SAFE)
    public final boolean isTunnelled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (this.tunnelled == TunnelType.TUNNELLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.004 -0400", hash_original_method = "24DDB6A6987422E004B186B027F8E19E", hash_generated_method = "478F0E5AB51BBB5CB96629C61383906C")
    @DSModeled(DSC.SAFE)
    public final LayerType getLayerType() {
        return (LayerType)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.layered;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.004 -0400", hash_original_method = "90484F935FB331F087FF42A42BD08719", hash_generated_method = "4C5CF28DA8680541E4439EBAC78F39EE")
    @DSModeled(DSC.SAFE)
    public final boolean isLayered() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (this.layered == LayerType.LAYERED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.004 -0400", hash_original_method = "F448B780707B5356535204966A8ECD14", hash_generated_method = "B0A493DBF9425F1FFC3CD811B3533583")
    @DSModeled(DSC.SAFE)
    public final boolean isSecure() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.secure;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.005 -0400", hash_original_method = "3549831666270A81F0B6433F4C19950E", hash_generated_method = "0B334E124CAC32B70A24D3C3290861AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        HttpRoute that;
        that = (HttpRoute) o;
        boolean equal;
        equal = this.targetHost.equals(that.targetHost);
        equal &=
            ( this.localAddress == that.localAddress) ||
            ((this.localAddress != null) &&
              this.localAddress.equals(that.localAddress));
        equal &=
            ( this.proxyChain        == that.proxyChain) ||
            ((this.proxyChain        != null) &&
             (that.proxyChain        != null) &&
             (this.proxyChain.length == that.proxyChain.length));
        equal &=
            (this.secure    == that.secure) &&
            (this.tunnelled == that.tunnelled) &&
            (this.layered   == that.layered);
        {
            {
                int i;
                i = 0;
                equal = this.proxyChain[i].equals(that.proxyChain[i]);
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.005 -0400", hash_original_method = "BE36FC25647C071258E2596D1C885DDC", hash_generated_method = "B3ABBC7D300046D8867A45B46465E662")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final int hashCode() {
        int hc;
        hc = this.targetHost.hashCode();
        hc ^= localAddress.hashCode();
        {
            hc ^= proxyChain.length;
            {
                HttpHost aProxyChain = proxyChain[0];
                hc ^= aProxyChain.hashCode();
            } //End collapsed parenthetic
        } //End block
        hc ^= 0x11111111;
        hc ^= this.tunnelled.hashCode();
        hc ^= this.layered.hashCode();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int hc = this.targetHost.hashCode();
        //if (this.localAddress != null)
            //hc ^= localAddress.hashCode();
        //if (this.proxyChain != null) {
            //hc ^= proxyChain.length;
            //for (HttpHost aProxyChain : proxyChain) hc ^= aProxyChain.hashCode();
        //}
        //if (this.secure)
            //hc ^= 0x11111111;
        //hc ^= this.tunnelled.hashCode();
        //hc ^= this.layered.hashCode();
        //return hc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.005 -0400", hash_original_method = "ED2086285AC52BF0F96F27196507174B", hash_generated_method = "30096F584793068B163BEA0701CC7749")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final String toString() {
        StringBuilder cab;
        cab = new StringBuilder(50 + getHopCount()*30);
        cab.append("HttpRoute[");
        {
            cab.append(this.localAddress);
            cab.append("->");
        } //End block
        cab.append('{');
        cab.append('t');
        cab.append('l');
        cab.append('s');
        cab.append("}->");
        {
            {
                HttpHost aProxyChain = this.proxyChain[0];
                {
                    cab.append(aProxyChain);
                    cab.append("->");
                } //End block
            } //End collapsed parenthetic
        } //End block
        cab.append(this.targetHost);
        cab.append(']');
        String var0C869D71626BE999F1EAAE2140845A9A_1822823023 = (cab.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder cab = new StringBuilder(50 + getHopCount()*30);
        //cab.append("HttpRoute[");
        //if (this.localAddress != null) {
            //cab.append(this.localAddress);
            //cab.append("->");
        //}
        //cab.append('{');
        //if (this.tunnelled == TunnelType.TUNNELLED)
            //cab.append('t');
        //if (this.layered == LayerType.LAYERED)
            //cab.append('l');
        //if (this.secure)
            //cab.append('s');
        //cab.append("}->");
        //if (this.proxyChain != null) {
            //for (HttpHost aProxyChain : this.proxyChain) {
                //cab.append(aProxyChain);
                //cab.append("->");
            //}
        //}
        //cab.append(this.targetHost);
        //cab.append(']');
        //return cab.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.005 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "722479E75DCA60F9AC40DAEFF018D079")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object var234434AAD2BC7C43140CB7A97B63D24C_552457907 = (super.clone());
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}


