package org.apache.http.conn.routing;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.net.InetAddress;
import org.apache.http.HttpHost;

public final class HttpRoute implements RouteInfo, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.508 -0400", hash_original_field = "3F08D0C1EE30947C2F84BB49ACD4C461", hash_generated_field = "7B58806231BEF3BA039CB1C0F515C7D6")

    private HttpHost targetHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.508 -0400", hash_original_field = "5C73038C2146DC3AED672FCA3B0ADB95", hash_generated_field = "10EEA7EDCC69FFFCA8BA704DF8B9F4B1")

    private InetAddress localAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.508 -0400", hash_original_field = "7A2DD2189AFBB29C40B72010D69E5341", hash_generated_field = "9682DC3432E3E3ED390A25A380BAA9D2")

    private HttpHost[] proxyChain;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.508 -0400", hash_original_field = "67C7F7D4D32F4FB2F36BB398BBCACCC0", hash_generated_field = "E015AA325755E4410D4EEEB2DE5795E3")

    private TunnelType tunnelled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.508 -0400", hash_original_field = "9442E6482C63DEF4C35BC13B704C52E2", hash_generated_field = "54A65546030D5940821BF07A848F0902")

    private LayerType layered;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.508 -0400", hash_original_field = "1C0B76FCE779F78F51BE339C49445C49", hash_generated_field = "D17DE8BC324386A0F759A8245C34BC17")

    private boolean secure;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.512 -0400", hash_original_method = "5CB4C66072DE9146913D6ADB77CB6362", hash_generated_method = "8BE5AECB45EA0EE285D4C64FEB37352D")
    private  HttpRoute(InetAddress local,
                      HttpHost target, HttpHost[] proxies,
                      boolean secure,
                      TunnelType tunnelled, LayerType layered) {
    if(target == null)        
        {
            IllegalArgumentException var0834355F17AB1D6D8F9C33D9EE9B8ED6_437040874 = new IllegalArgumentException
                ("Target host may not be null.");
            var0834355F17AB1D6D8F9C33D9EE9B8ED6_437040874.addTaint(taint);
            throw var0834355F17AB1D6D8F9C33D9EE9B8ED6_437040874;
        } //End block
    if((tunnelled == TunnelType.TUNNELLED) && (proxies == null))        
        {
            IllegalArgumentException var5FBFFDC61457ABEB821EDECA5DBAA216_440266806 = new IllegalArgumentException
                ("Proxy required if tunnelled.");
            var5FBFFDC61457ABEB821EDECA5DBAA216_440266806.addTaint(taint);
            throw var5FBFFDC61457ABEB821EDECA5DBAA216_440266806;
        } //End block
    if(tunnelled == null)        
        tunnelled = TunnelType.PLAIN;
    if(layered == null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.513 -0400", hash_original_method = "552F6B1597CA5ECF686CDEE0458B0DC7", hash_generated_method = "B0596E800CC93678B3E603F4787CC1B9")
    public  HttpRoute(HttpHost target, InetAddress local, HttpHost[] proxies,
                     boolean secure, TunnelType tunnelled, LayerType layered) {
        this(local, target, toChain(proxies), secure, tunnelled, layered);
        addTaint(layered.getTaint());
        addTaint(tunnelled.getTaint());
        addTaint(secure);
        addTaint(proxies[0].getTaint());
        addTaint(local.getTaint());
        addTaint(target.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.514 -0400", hash_original_method = "65CC9974914C583AD70C403F8621F2C0", hash_generated_method = "955C97DB9EB785367673C6775CDEDA35")
    public  HttpRoute(HttpHost target, InetAddress local, HttpHost proxy,
                     boolean secure, TunnelType tunnelled, LayerType layered) {
        this(local, target, toChain(proxy), secure, tunnelled, layered);
        addTaint(layered.getTaint());
        addTaint(tunnelled.getTaint());
        addTaint(secure);
        addTaint(proxy.getTaint());
        addTaint(local.getTaint());
        addTaint(target.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.514 -0400", hash_original_method = "76AC245ADF42DED69B554EDA9FD556DE", hash_generated_method = "CF084E54BF4D36C7C9B58D6AC3AB4D4C")
    public  HttpRoute(HttpHost target, InetAddress local, boolean secure) {
        this(local, target, null, secure, TunnelType.PLAIN, LayerType.PLAIN);
        addTaint(secure);
        addTaint(local.getTaint());
        addTaint(target.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.515 -0400", hash_original_method = "30B1C0BF43231AE18DB893662C2E010C", hash_generated_method = "5C0081891C0BEB28A75B40D4B82FF215")
    public  HttpRoute(HttpHost target) {
        this(null, target, null, false, TunnelType.PLAIN, LayerType.PLAIN);
        addTaint(target.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.515 -0400", hash_original_method = "BFF1075A3FB2A926B1AAFF01869C54BF", hash_generated_method = "5955E4445A54C067714CD7CA828D28B7")
    public  HttpRoute(HttpHost target, InetAddress local, HttpHost proxy,
                     boolean secure) {
        this(local, target, toChain(proxy), secure,
             secure ? TunnelType.TUNNELLED : TunnelType.PLAIN,
             secure ? LayerType.LAYERED    : LayerType.PLAIN);
        addTaint(secure);
        addTaint(proxy.getTaint());
        addTaint(local.getTaint());
        addTaint(target.getTaint());
    if(proxy == null)        
        {
            IllegalArgumentException var0CD84C903ADF2DDB413B21B5128ACE60_2146136117 = new IllegalArgumentException
                ("Proxy host may not be null.");
            var0CD84C903ADF2DDB413B21B5128ACE60_2146136117.addTaint(taint);
            throw var0CD84C903ADF2DDB413B21B5128ACE60_2146136117;
        } //End block
        // ---------- Original Method ----------
        //if (proxy == null) {
            //throw new IllegalArgumentException
                //("Proxy host may not be null.");
        //}
    }

    
        @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.516 -0400", hash_original_method = "00F8E4422BF57DE6758D681F4A99BDB6", hash_generated_method = "CF83FA7ECA9C911FE5A6BC5292FAE978")
    public final HttpHost getTargetHost() {
HttpHost var67C71439C5981484698447EE93E1A003_380642974 =         this.targetHost;
        var67C71439C5981484698447EE93E1A003_380642974.addTaint(taint);
        return var67C71439C5981484698447EE93E1A003_380642974;
        // ---------- Original Method ----------
        //return this.targetHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.516 -0400", hash_original_method = "28495B9032685860E947A62701D0E919", hash_generated_method = "91F60EC8BA9A89D187CB47B8593C8A94")
    public final InetAddress getLocalAddress() {
InetAddress varD252CCE80C2F3B9DE81EE46EA65F5895_642404393 =         this.localAddress;
        varD252CCE80C2F3B9DE81EE46EA65F5895_642404393.addTaint(taint);
        return varD252CCE80C2F3B9DE81EE46EA65F5895_642404393;
        // ---------- Original Method ----------
        //return this.localAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.517 -0400", hash_original_method = "8A1F6C82C6946ABA9036325DB5D1093A", hash_generated_method = "09104FE3A72DDFE02FCC49A4D05F09D1")
    public final int getHopCount() {
        int var7CFF713CFFC25845EFE8BFC10A30B95A_317159818 = ((proxyChain == null) ? 1 : (proxyChain.length+1));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93068648 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93068648;
        // ---------- Original Method ----------
        //return (proxyChain == null) ? 1 : (proxyChain.length+1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.517 -0400", hash_original_method = "6FAF652E1C9EAABAB417C8ED32D41F4A", hash_generated_method = "98798182CE2F2AED95C160F39D8828D6")
    public final HttpHost getHopTarget(int hop) {
        addTaint(hop);
    if(hop < 0)        
        {
        IllegalArgumentException var853EA8D3011B4A803E1D3E44BA5221BB_425121176 = new IllegalArgumentException
                ("Hop index must not be negative: " + hop);
        var853EA8D3011B4A803E1D3E44BA5221BB_425121176.addTaint(taint);
        throw var853EA8D3011B4A803E1D3E44BA5221BB_425121176;
        }
        final int hopcount = getHopCount();
    if(hop >= hopcount)        
        {
        IllegalArgumentException varD7176FBE3B9AF72DACF25B8C4974B725_1485119286 = new IllegalArgumentException
                ("Hop index " + hop +
                 " exceeds route length " + hopcount);
        varD7176FBE3B9AF72DACF25B8C4974B725_1485119286.addTaint(taint);
        throw varD7176FBE3B9AF72DACF25B8C4974B725_1485119286;
        }
        HttpHost result = null;
    if(hop < hopcount-1)        
        result = this.proxyChain[hop];
        else
        result = this.targetHost;
HttpHost varDC838461EE2FA0CA4C9BBB70A15456B0_121973951 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_121973951.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_121973951;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.518 -0400", hash_original_method = "E9E1E8AC6D9C2477F7E0F63BF0C4ED60", hash_generated_method = "67787A525D6E44E05D1081BEF4D36946")
    public final HttpHost getProxyHost() {
HttpHost varF8CC471EE86A19D0A727D1FC9C328686_2006702640 =         (this.proxyChain == null) ? null : this.proxyChain[0];
        varF8CC471EE86A19D0A727D1FC9C328686_2006702640.addTaint(taint);
        return varF8CC471EE86A19D0A727D1FC9C328686_2006702640;
        // ---------- Original Method ----------
        //return (this.proxyChain == null) ? null : this.proxyChain[0];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.518 -0400", hash_original_method = "350E5C2EB4A104FE6F444729C8CD5444", hash_generated_method = "28CF462295EF6B2430F5026FBC6AC6F6")
    public final TunnelType getTunnelType() {
TunnelType var2217FBB31A61A2BC06264383F23E2C7F_633097238 =         this.tunnelled;
        var2217FBB31A61A2BC06264383F23E2C7F_633097238.addTaint(taint);
        return var2217FBB31A61A2BC06264383F23E2C7F_633097238;
        // ---------- Original Method ----------
        //return this.tunnelled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.518 -0400", hash_original_method = "5CD3D72A708D2B06B9BD542F01F3D0EE", hash_generated_method = "422B7DCD147AF9B09AAA5BCB3F0B4B40")
    public final boolean isTunnelled() {
        boolean var6E17A163EAADFAAEEF827D05D550510F_1169438785 = ((this.tunnelled == TunnelType.TUNNELLED));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1106029138 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1106029138;
        // ---------- Original Method ----------
        //return (this.tunnelled == TunnelType.TUNNELLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.519 -0400", hash_original_method = "24DDB6A6987422E004B186B027F8E19E", hash_generated_method = "D4BE2F26A226B361C7280893C1B8EB6F")
    public final LayerType getLayerType() {
LayerType var0B365440B9E6602F90569354BDD2D5AF_2134920322 =         this.layered;
        var0B365440B9E6602F90569354BDD2D5AF_2134920322.addTaint(taint);
        return var0B365440B9E6602F90569354BDD2D5AF_2134920322;
        // ---------- Original Method ----------
        //return this.layered;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.519 -0400", hash_original_method = "90484F935FB331F087FF42A42BD08719", hash_generated_method = "AB024A2CCA2551CB4840B51A6B83C4F5")
    public final boolean isLayered() {
        boolean var78483962D1129A47EBB9F287858CE500_658974782 = ((this.layered == LayerType.LAYERED));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_67497820 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_67497820;
        // ---------- Original Method ----------
        //return (this.layered == LayerType.LAYERED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.519 -0400", hash_original_method = "F448B780707B5356535204966A8ECD14", hash_generated_method = "66AC717C0673B874B7C3695045ACD941")
    public final boolean isSecure() {
        boolean var1A6CF3022022F86E5EAF7A933D51276A_513231294 = (this.secure);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_223582773 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_223582773;
        // ---------- Original Method ----------
        //return this.secure;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.520 -0400", hash_original_method = "3549831666270A81F0B6433F4C19950E", hash_generated_method = "28EA9C6AF6E189A80A5A25FF7A83B466")
    @Override
    public final boolean equals(Object o) {
        addTaint(o.getTaint());
    if(o == this)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1143640062 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_739464570 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_739464570;
        }
    if(!(o instanceof HttpRoute))        
        {
        boolean var68934A3E9455FA72420237EB05902327_96646924 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1676050829 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1676050829;
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
    if(equal && (this.proxyChain != null))        
        {
for(int i=0;equal && (i<this.proxyChain.length);i++)
            equal = this.proxyChain[i].equals(that.proxyChain[i]);
        } //End block
        boolean var465289687A70DB7AA7217CC240C29F0F_349646026 = (equal);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1146137836 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1146137836;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.521 -0400", hash_original_method = "BE36FC25647C071258E2596D1C885DDC", hash_generated_method = "36E04D17BB2902C7C81BDC3D21111F2C")
    @Override
    public final int hashCode() {
        int hc = this.targetHost.hashCode();
    if(this.localAddress != null)        
        hc ^= localAddress.hashCode();
    if(this.proxyChain != null)        
        {
            hc ^= proxyChain.length;
for(HttpHost aProxyChain : proxyChain)
            hc ^= aProxyChain.hashCode();
        } //End block
    if(this.secure)        
        hc ^= 0x11111111;
        hc ^= this.tunnelled.hashCode();
        hc ^= this.layered.hashCode();
        int var6320C1115D5BC2B6CA615B96BE050884_157170807 = (hc);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_74639124 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_74639124;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.522 -0400", hash_original_method = "ED2086285AC52BF0F96F27196507174B", hash_generated_method = "F0B7EC04B902FCB965A2B538B1A9FADD")
    @Override
    public final String toString() {
        StringBuilder cab = new StringBuilder(50 + getHopCount()*30);
        cab.append("HttpRoute[");
    if(this.localAddress != null)        
        {
            cab.append(this.localAddress);
            cab.append("->");
        } //End block
        cab.append('{');
    if(this.tunnelled == TunnelType.TUNNELLED)        
        cab.append('t');
    if(this.layered == LayerType.LAYERED)        
        cab.append('l');
    if(this.secure)        
        cab.append('s');
        cab.append("}->");
    if(this.proxyChain != null)        
        {
for(HttpHost aProxyChain : this.proxyChain)
            {
                cab.append(aProxyChain);
                cab.append("->");
            } //End block
        } //End block
        cab.append(this.targetHost);
        cab.append(']');
String var5D73975C9EFF81CD9FF6232386AC7C22_1446896898 =         cab.toString();
        var5D73975C9EFF81CD9FF6232386AC7C22_1446896898.addTaint(taint);
        return var5D73975C9EFF81CD9FF6232386AC7C22_1446896898;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.522 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "2EF9DA81981704AA59E6A0AE17EA0F42")
    @Override
    public Object clone() throws CloneNotSupportedException {
Object var46F3A0D86742C1D6E099C2B166941A33_70672661 =         super.clone();
        var46F3A0D86742C1D6E099C2B166941A33_70672661.addTaint(taint);
        return var46F3A0D86742C1D6E099C2B166941A33_70672661;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

