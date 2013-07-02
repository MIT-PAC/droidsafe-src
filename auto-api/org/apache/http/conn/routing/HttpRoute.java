package org.apache.http.conn.routing;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.net.InetAddress;
import org.apache.http.HttpHost;

public final class HttpRoute implements RouteInfo, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.167 -0400", hash_original_field = "3F08D0C1EE30947C2F84BB49ACD4C461", hash_generated_field = "7B58806231BEF3BA039CB1C0F515C7D6")

    private HttpHost targetHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.167 -0400", hash_original_field = "5C73038C2146DC3AED672FCA3B0ADB95", hash_generated_field = "10EEA7EDCC69FFFCA8BA704DF8B9F4B1")

    private InetAddress localAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.167 -0400", hash_original_field = "7A2DD2189AFBB29C40B72010D69E5341", hash_generated_field = "9682DC3432E3E3ED390A25A380BAA9D2")

    private HttpHost[] proxyChain;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.167 -0400", hash_original_field = "67C7F7D4D32F4FB2F36BB398BBCACCC0", hash_generated_field = "E015AA325755E4410D4EEEB2DE5795E3")

    private TunnelType tunnelled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.167 -0400", hash_original_field = "9442E6482C63DEF4C35BC13B704C52E2", hash_generated_field = "54A65546030D5940821BF07A848F0902")

    private LayerType layered;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.167 -0400", hash_original_field = "1C0B76FCE779F78F51BE339C49445C49", hash_generated_field = "D17DE8BC324386A0F759A8245C34BC17")

    private boolean secure;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.168 -0400", hash_original_method = "5CB4C66072DE9146913D6ADB77CB6362", hash_generated_method = "927BB5F8253224F1A756FDFB9028EC63")
    private  HttpRoute(InetAddress local,
                      HttpHost target, HttpHost[] proxies,
                      boolean secure,
                      TunnelType tunnelled, LayerType layered) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Target host may not be null.");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Proxy required if tunnelled.");
        } 
        tunnelled = TunnelType.PLAIN;
        layered = LayerType.PLAIN;
        this.targetHost   = target;
        this.localAddress = local;
        this.proxyChain   = proxies;
        this.secure       = secure;
        this.tunnelled    = tunnelled;
        this.layered      = layered;
        
        
            
                
        
        
            
                
        
        
            
        
            
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.168 -0400", hash_original_method = "552F6B1597CA5ECF686CDEE0458B0DC7", hash_generated_method = "50EEBD76B7F39E55EB9DAAFDE4935DD2")
    public  HttpRoute(HttpHost target, InetAddress local, HttpHost[] proxies,
                     boolean secure, TunnelType tunnelled, LayerType layered) {
        this(local, target, toChain(proxies), secure, tunnelled, layered);
        addTaint(target.getTaint());
        addTaint(local.getTaint());
        addTaint(proxies[0].getTaint());
        addTaint(secure);
        addTaint(tunnelled.getTaint());
        addTaint(layered.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.168 -0400", hash_original_method = "65CC9974914C583AD70C403F8621F2C0", hash_generated_method = "41C421CC4A0CCE3E2EF49AFBEA5AA9A9")
    public  HttpRoute(HttpHost target, InetAddress local, HttpHost proxy,
                     boolean secure, TunnelType tunnelled, LayerType layered) {
        this(local, target, toChain(proxy), secure, tunnelled, layered);
        addTaint(target.getTaint());
        addTaint(local.getTaint());
        addTaint(proxy.getTaint());
        addTaint(secure);
        addTaint(tunnelled.getTaint());
        addTaint(layered.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.169 -0400", hash_original_method = "76AC245ADF42DED69B554EDA9FD556DE", hash_generated_method = "5C6A10D8E362889D3FCA3FDD404BEF30")
    public  HttpRoute(HttpHost target, InetAddress local, boolean secure) {
        this(local, target, null, secure, TunnelType.PLAIN, LayerType.PLAIN);
        addTaint(target.getTaint());
        addTaint(local.getTaint());
        addTaint(secure);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.169 -0400", hash_original_method = "30B1C0BF43231AE18DB893662C2E010C", hash_generated_method = "5C0081891C0BEB28A75B40D4B82FF215")
    public  HttpRoute(HttpHost target) {
        this(null, target, null, false, TunnelType.PLAIN, LayerType.PLAIN);
        addTaint(target.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.169 -0400", hash_original_method = "BFF1075A3FB2A926B1AAFF01869C54BF", hash_generated_method = "A4F7DC3868A2C5646DE71DFCE628C3AB")
    public  HttpRoute(HttpHost target, InetAddress local, HttpHost proxy,
                     boolean secure) {
        this(local, target, toChain(proxy), secure,
             secure ? TunnelType.TUNNELLED : TunnelType.PLAIN,
             secure ? LayerType.LAYERED    : LayerType.PLAIN);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Proxy host may not be null.");
        } 
        addTaint(target.getTaint());
        addTaint(local.getTaint());
        addTaint(proxy.getTaint());
        addTaint(secure);
        
        
            
                
        
    }

    
    private static HttpHost[] toChain(HttpHost proxy) {
        if (proxy == null)
            return null;
        return new HttpHost[]{ proxy };
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.170 -0400", hash_original_method = "00F8E4422BF57DE6758D681F4A99BDB6", hash_generated_method = "E36DFA4F81E41958FD81A37C40584DEE")
    public final HttpHost getTargetHost() {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_822861989 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_822861989 = this.targetHost;
        varB4EAC82CA7396A68D541C85D26508E83_822861989.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_822861989;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.170 -0400", hash_original_method = "28495B9032685860E947A62701D0E919", hash_generated_method = "AFD5CBBDD244DC1E735447D7353C869A")
    public final InetAddress getLocalAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1385547006 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1385547006 = this.localAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1385547006.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1385547006;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.171 -0400", hash_original_method = "8A1F6C82C6946ABA9036325DB5D1093A", hash_generated_method = "304FE782FBE372921F696042E90AB5CD")
    public final int getHopCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_108647576 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_108647576;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.172 -0400", hash_original_method = "6FAF652E1C9EAABAB417C8ED32D41F4A", hash_generated_method = "A53E7704A0F4C454C1ED993F10333DAD")
    public final HttpHost getHopTarget(int hop) {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_1167054541 = null; 
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Hop index must not be negative: " + hop);
        final int hopcount = getHopCount();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Hop index " + hop +
                 " exceeds route length " + hopcount);
        HttpHost result = null;
        result = this.proxyChain[hop];
        result = this.targetHost;
        varB4EAC82CA7396A68D541C85D26508E83_1167054541 = result;
        addTaint(hop);
        varB4EAC82CA7396A68D541C85D26508E83_1167054541.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1167054541;
        
        
            
                
        
        
            
                
                 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.172 -0400", hash_original_method = "E9E1E8AC6D9C2477F7E0F63BF0C4ED60", hash_generated_method = "E09EEC81F03C3CEBCB7C3B1F545EE5C7")
    public final HttpHost getProxyHost() {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_1667405001 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1667405001 = (this.proxyChain == null) ? null : this.proxyChain[0];
        varB4EAC82CA7396A68D541C85D26508E83_1667405001.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1667405001;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.173 -0400", hash_original_method = "350E5C2EB4A104FE6F444729C8CD5444", hash_generated_method = "6E9A752AEB24BEFB5EAEA7970B0907C6")
    public final TunnelType getTunnelType() {
        TunnelType varB4EAC82CA7396A68D541C85D26508E83_59678627 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_59678627 = this.tunnelled;
        varB4EAC82CA7396A68D541C85D26508E83_59678627.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_59678627;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.173 -0400", hash_original_method = "5CD3D72A708D2B06B9BD542F01F3D0EE", hash_generated_method = "319FC1A7E7EAE73EC8213210F661780E")
    public final boolean isTunnelled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_773856010 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_773856010;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.174 -0400", hash_original_method = "24DDB6A6987422E004B186B027F8E19E", hash_generated_method = "40E8C0A19E49539E4EA9FC71AD449516")
    public final LayerType getLayerType() {
        LayerType varB4EAC82CA7396A68D541C85D26508E83_1790375845 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1790375845 = this.layered;
        varB4EAC82CA7396A68D541C85D26508E83_1790375845.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1790375845;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.174 -0400", hash_original_method = "90484F935FB331F087FF42A42BD08719", hash_generated_method = "0ECD9E5EC0DEF4F72BD10C93E57330C2")
    public final boolean isLayered() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1136695638 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1136695638;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.174 -0400", hash_original_method = "F448B780707B5356535204966A8ECD14", hash_generated_method = "3DF80B12615895C680794CDC2CE91BD6")
    public final boolean isSecure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_599007789 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_599007789;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.175 -0400", hash_original_method = "3549831666270A81F0B6433F4C19950E", hash_generated_method = "B62FD8025A1C188ADA0621145BE8A655")
    @Override
    public final boolean equals(Object o) {
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_855451581 = (o == this);
        } 
        HttpRoute that = (HttpRoute) o;
        boolean equal = this.targetHost.equals(that.targetHost);
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
                int i = 0;
                equal = this.proxyChain[i].equals(that.proxyChain[i]);
            } 
        } 
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1707753945 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1707753945;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.184 -0400", hash_original_method = "BE36FC25647C071258E2596D1C885DDC", hash_generated_method = "302CAF07CDC881116FD2270BD449E8CD")
    @Override
    public final int hashCode() {
        int hc = this.targetHost.hashCode();
        hc ^= localAddress.hashCode();
        {
            hc ^= proxyChain.length;
            {
                HttpHost aProxyChain = proxyChain[0];
                hc ^= aProxyChain.hashCode();
            } 
        } 
        hc ^= 0x11111111;
        hc ^= this.tunnelled.hashCode();
        hc ^= this.layered.hashCode();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_366144950 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_366144950;
        
        
        
            
        
            
            
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.203 -0400", hash_original_method = "ED2086285AC52BF0F96F27196507174B", hash_generated_method = "641B94A95590E6D757CF712325C7C4BC")
    @Override
    public final String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_369635768 = null; 
        StringBuilder cab = new StringBuilder(50 + getHopCount()*30);
        cab.append("HttpRoute[");
        {
            cab.append(this.localAddress);
            cab.append("->");
        } 
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
                } 
            } 
        } 
        cab.append(this.targetHost);
        cab.append(']');
        varB4EAC82CA7396A68D541C85D26508E83_369635768 = cab.toString();
        varB4EAC82CA7396A68D541C85D26508E83_369635768.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_369635768;
        
        
        
        
            
            
        
        
        
            
        
            
        
            
        
        
            
                
                
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.204 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "695F54B93A09696A71994342CECCD8F2")
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_2039702296 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2039702296 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_2039702296.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2039702296;
        
        
    }

    
}

