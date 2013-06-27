package org.apache.http.conn.routing;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.InetAddress;
import org.apache.http.HttpHost;

public final class HttpRoute implements RouteInfo, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.475 -0400", hash_original_field = "3F08D0C1EE30947C2F84BB49ACD4C461", hash_generated_field = "7B58806231BEF3BA039CB1C0F515C7D6")

    private HttpHost targetHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.475 -0400", hash_original_field = "5C73038C2146DC3AED672FCA3B0ADB95", hash_generated_field = "10EEA7EDCC69FFFCA8BA704DF8B9F4B1")

    private InetAddress localAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.475 -0400", hash_original_field = "7A2DD2189AFBB29C40B72010D69E5341", hash_generated_field = "9682DC3432E3E3ED390A25A380BAA9D2")

    private HttpHost[] proxyChain;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.475 -0400", hash_original_field = "67C7F7D4D32F4FB2F36BB398BBCACCC0", hash_generated_field = "E015AA325755E4410D4EEEB2DE5795E3")

    private TunnelType tunnelled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.475 -0400", hash_original_field = "9442E6482C63DEF4C35BC13B704C52E2", hash_generated_field = "54A65546030D5940821BF07A848F0902")

    private LayerType layered;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.475 -0400", hash_original_field = "1C0B76FCE779F78F51BE339C49445C49", hash_generated_field = "D17DE8BC324386A0F759A8245C34BC17")

    private boolean secure;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.477 -0400", hash_original_method = "5CB4C66072DE9146913D6ADB77CB6362", hash_generated_method = "927BB5F8253224F1A756FDFB9028EC63")
    private  HttpRoute(InetAddress local,
                      HttpHost target, HttpHost[] proxies,
                      boolean secure,
                      TunnelType tunnelled, LayerType layered) {
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
        this.targetHost   = target;
        this.localAddress = local;
        this.proxyChain   = proxies;
        this.secure       = secure;
        this.tunnelled    = tunnelled;
        this.layered      = layered;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.477 -0400", hash_original_method = "552F6B1597CA5ECF686CDEE0458B0DC7", hash_generated_method = "50EEBD76B7F39E55EB9DAAFDE4935DD2")
    public  HttpRoute(HttpHost target, InetAddress local, HttpHost[] proxies,
                     boolean secure, TunnelType tunnelled, LayerType layered) {
        this(local, target, toChain(proxies), secure, tunnelled, layered);
        addTaint(target.getTaint());
        addTaint(local.getTaint());
        addTaint(proxies[0].getTaint());
        addTaint(secure);
        addTaint(tunnelled.getTaint());
        addTaint(layered.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.482 -0400", hash_original_method = "65CC9974914C583AD70C403F8621F2C0", hash_generated_method = "41C421CC4A0CCE3E2EF49AFBEA5AA9A9")
    public  HttpRoute(HttpHost target, InetAddress local, HttpHost proxy,
                     boolean secure, TunnelType tunnelled, LayerType layered) {
        this(local, target, toChain(proxy), secure, tunnelled, layered);
        addTaint(target.getTaint());
        addTaint(local.getTaint());
        addTaint(proxy.getTaint());
        addTaint(secure);
        addTaint(tunnelled.getTaint());
        addTaint(layered.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.482 -0400", hash_original_method = "76AC245ADF42DED69B554EDA9FD556DE", hash_generated_method = "5C6A10D8E362889D3FCA3FDD404BEF30")
    public  HttpRoute(HttpHost target, InetAddress local, boolean secure) {
        this(local, target, null, secure, TunnelType.PLAIN, LayerType.PLAIN);
        addTaint(target.getTaint());
        addTaint(local.getTaint());
        addTaint(secure);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.483 -0400", hash_original_method = "30B1C0BF43231AE18DB893662C2E010C", hash_generated_method = "5C0081891C0BEB28A75B40D4B82FF215")
    public  HttpRoute(HttpHost target) {
        this(null, target, null, false, TunnelType.PLAIN, LayerType.PLAIN);
        addTaint(target.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.490 -0400", hash_original_method = "BFF1075A3FB2A926B1AAFF01869C54BF", hash_generated_method = "A4F7DC3868A2C5646DE71DFCE628C3AB")
    public  HttpRoute(HttpHost target, InetAddress local, HttpHost proxy,
                     boolean secure) {
        this(local, target, toChain(proxy), secure,
             secure ? TunnelType.TUNNELLED : TunnelType.PLAIN,
             secure ? LayerType.LAYERED    : LayerType.PLAIN);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Proxy host may not be null.");
        } //End block
        addTaint(target.getTaint());
        addTaint(local.getTaint());
        addTaint(proxy.getTaint());
        addTaint(secure);
        // ---------- Original Method ----------
        //if (proxy == null) {
            //throw new IllegalArgumentException
                //("Proxy host may not be null.");
        //}
    }

    
        private static HttpHost[] toChain(HttpHost proxy) {
        if (proxy == null)
            return null;
        return new HttpHost[]{ proxy };
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.491 -0400", hash_original_method = "00F8E4422BF57DE6758D681F4A99BDB6", hash_generated_method = "517F2043058B4C067C8767BAA66C0CF6")
    public final HttpHost getTargetHost() {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_1500156413 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1500156413 = this.targetHost;
        varB4EAC82CA7396A68D541C85D26508E83_1500156413.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1500156413;
        // ---------- Original Method ----------
        //return this.targetHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.492 -0400", hash_original_method = "28495B9032685860E947A62701D0E919", hash_generated_method = "A9FC431120EC03B21F3D6C36017FEBCE")
    public final InetAddress getLocalAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1470226316 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1470226316 = this.localAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1470226316.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1470226316;
        // ---------- Original Method ----------
        //return this.localAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.492 -0400", hash_original_method = "8A1F6C82C6946ABA9036325DB5D1093A", hash_generated_method = "1D1C271A1DEBB3C26831697DD64736E0")
    public final int getHopCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_440889980 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_440889980;
        // ---------- Original Method ----------
        //return (proxyChain == null) ? 1 : (proxyChain.length+1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.493 -0400", hash_original_method = "6FAF652E1C9EAABAB417C8ED32D41F4A", hash_generated_method = "592F94BD01115E9D7810D8D64156B116")
    public final HttpHost getHopTarget(int hop) {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_1975118953 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Hop index must not be negative: " + hop);
        int hopcount;
        hopcount = getHopCount();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Hop index " + hop +
                 " exceeds route length " + hopcount);
        HttpHost result;
        result = null;
        result = this.proxyChain[hop];
        result = this.targetHost;
        varB4EAC82CA7396A68D541C85D26508E83_1975118953 = result;
        addTaint(hop);
        varB4EAC82CA7396A68D541C85D26508E83_1975118953.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1975118953;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.493 -0400", hash_original_method = "E9E1E8AC6D9C2477F7E0F63BF0C4ED60", hash_generated_method = "59BD27D37AD7A97DA81729CC027BB78D")
    public final HttpHost getProxyHost() {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_1007880197 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1007880197 = (this.proxyChain == null) ? null : this.proxyChain[0];
        varB4EAC82CA7396A68D541C85D26508E83_1007880197.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1007880197;
        // ---------- Original Method ----------
        //return (this.proxyChain == null) ? null : this.proxyChain[0];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.493 -0400", hash_original_method = "350E5C2EB4A104FE6F444729C8CD5444", hash_generated_method = "55A3863E2CE8102B75DA42AB2D39EDEB")
    public final TunnelType getTunnelType() {
        TunnelType varB4EAC82CA7396A68D541C85D26508E83_1941639754 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1941639754 = this.tunnelled;
        varB4EAC82CA7396A68D541C85D26508E83_1941639754.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1941639754;
        // ---------- Original Method ----------
        //return this.tunnelled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.494 -0400", hash_original_method = "5CD3D72A708D2B06B9BD542F01F3D0EE", hash_generated_method = "10454A9EA5D2598449A99B353FD9BA0E")
    public final boolean isTunnelled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_113459869 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_113459869;
        // ---------- Original Method ----------
        //return (this.tunnelled == TunnelType.TUNNELLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.502 -0400", hash_original_method = "24DDB6A6987422E004B186B027F8E19E", hash_generated_method = "0A47E1AB8978FB8D8CEC604E258FEB9D")
    public final LayerType getLayerType() {
        LayerType varB4EAC82CA7396A68D541C85D26508E83_894923690 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_894923690 = this.layered;
        varB4EAC82CA7396A68D541C85D26508E83_894923690.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_894923690;
        // ---------- Original Method ----------
        //return this.layered;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.507 -0400", hash_original_method = "90484F935FB331F087FF42A42BD08719", hash_generated_method = "5E3F652F185FFE4D14030715EFE57932")
    public final boolean isLayered() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1491881662 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1491881662;
        // ---------- Original Method ----------
        //return (this.layered == LayerType.LAYERED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.507 -0400", hash_original_method = "F448B780707B5356535204966A8ECD14", hash_generated_method = "FC2CA3CFB4024E652AFC455600D7B408")
    public final boolean isSecure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1975500031 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1975500031;
        // ---------- Original Method ----------
        //return this.secure;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.508 -0400", hash_original_method = "3549831666270A81F0B6433F4C19950E", hash_generated_method = "CDF40C17DDE11E2E051042DA38FB1021")
    @Override
    public final boolean equals(Object o) {
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_1451057803 = (o == this);
        } //End collapsed parenthetic
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
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1606763230 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1606763230;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.583 -0400", hash_original_method = "BE36FC25647C071258E2596D1C885DDC", hash_generated_method = "C2A77527FBD3C8030AAA2F7508F3543E")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_902814731 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_902814731;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.648 -0400", hash_original_method = "ED2086285AC52BF0F96F27196507174B", hash_generated_method = "9FFF208C3B31A6A8CCFC7F70B2CDC66E")
    @Override
    public final String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1677193101 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1677193101 = cab.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1677193101.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1677193101;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.661 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "5EE318CDD937EFB1A8BC27360AE2F293")
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_2097967057 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2097967057 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_2097967057.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2097967057;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

