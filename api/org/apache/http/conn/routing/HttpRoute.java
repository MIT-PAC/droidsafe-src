package org.apache.http.conn.routing;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.net.InetAddress;

import org.apache.http.HttpHost;






public final class HttpRoute implements RouteInfo, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.840 -0400", hash_original_field = "3F08D0C1EE30947C2F84BB49ACD4C461", hash_generated_field = "7B58806231BEF3BA039CB1C0F515C7D6")

    private HttpHost targetHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.840 -0400", hash_original_field = "5C73038C2146DC3AED672FCA3B0ADB95", hash_generated_field = "10EEA7EDCC69FFFCA8BA704DF8B9F4B1")

    private InetAddress localAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.840 -0400", hash_original_field = "7A2DD2189AFBB29C40B72010D69E5341", hash_generated_field = "9682DC3432E3E3ED390A25A380BAA9D2")

    private HttpHost[] proxyChain;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.840 -0400", hash_original_field = "67C7F7D4D32F4FB2F36BB398BBCACCC0", hash_generated_field = "E015AA325755E4410D4EEEB2DE5795E3")

    private TunnelType tunnelled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.840 -0400", hash_original_field = "9442E6482C63DEF4C35BC13B704C52E2", hash_generated_field = "54A65546030D5940821BF07A848F0902")

    private LayerType layered;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.840 -0400", hash_original_field = "1C0B76FCE779F78F51BE339C49445C49", hash_generated_field = "D17DE8BC324386A0F759A8245C34BC17")

    private boolean secure;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.842 -0400", hash_original_method = "5CB4C66072DE9146913D6ADB77CB6362", hash_generated_method = "7EC28756D055E8C24B912B1E20C9D016")
    private  HttpRoute(InetAddress local,
                      HttpHost target, HttpHost[] proxies,
                      boolean secure,
                      TunnelType tunnelled, LayerType layered) {
        if(target == null)        
        {
            IllegalArgumentException var0834355F17AB1D6D8F9C33D9EE9B8ED6_1197213148 = new IllegalArgumentException
                ("Target host may not be null.");
            var0834355F17AB1D6D8F9C33D9EE9B8ED6_1197213148.addTaint(taint);
            throw var0834355F17AB1D6D8F9C33D9EE9B8ED6_1197213148;
        } //End block
        if((tunnelled == TunnelType.TUNNELLED) && (proxies == null))        
        {
            IllegalArgumentException var5FBFFDC61457ABEB821EDECA5DBAA216_90699496 = new IllegalArgumentException
                ("Proxy required if tunnelled.");
            var5FBFFDC61457ABEB821EDECA5DBAA216_90699496.addTaint(taint);
            throw var5FBFFDC61457ABEB821EDECA5DBAA216_90699496;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.843 -0400", hash_original_method = "552F6B1597CA5ECF686CDEE0458B0DC7", hash_generated_method = "B0596E800CC93678B3E603F4787CC1B9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.843 -0400", hash_original_method = "65CC9974914C583AD70C403F8621F2C0", hash_generated_method = "955C97DB9EB785367673C6775CDEDA35")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.844 -0400", hash_original_method = "76AC245ADF42DED69B554EDA9FD556DE", hash_generated_method = "CF084E54BF4D36C7C9B58D6AC3AB4D4C")
    public  HttpRoute(HttpHost target, InetAddress local, boolean secure) {
        this(local, target, null, secure, TunnelType.PLAIN, LayerType.PLAIN);
        addTaint(secure);
        addTaint(local.getTaint());
        addTaint(target.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.844 -0400", hash_original_method = "30B1C0BF43231AE18DB893662C2E010C", hash_generated_method = "5C0081891C0BEB28A75B40D4B82FF215")
    public  HttpRoute(HttpHost target) {
        this(null, target, null, false, TunnelType.PLAIN, LayerType.PLAIN);
        addTaint(target.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.844 -0400", hash_original_method = "BFF1075A3FB2A926B1AAFF01869C54BF", hash_generated_method = "54399607A10F6B944175D7166B291229")
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
            IllegalArgumentException var0CD84C903ADF2DDB413B21B5128ACE60_1144624432 = new IllegalArgumentException
                ("Proxy host may not be null.");
            var0CD84C903ADF2DDB413B21B5128ACE60_1144624432.addTaint(taint);
            throw var0CD84C903ADF2DDB413B21B5128ACE60_1144624432;
        } //End block
        // ---------- Original Method ----------
        //if (proxy == null) {
            //throw new IllegalArgumentException
                //("Proxy host may not be null.");
        //}
    }

    
    @DSModeled(DSC.BAN)
    private static HttpHost[] toChain(HttpHost proxy) {
        if (proxy == null)
            return null;
        return new HttpHost[]{ proxy };
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.845 -0400", hash_original_method = "00F8E4422BF57DE6758D681F4A99BDB6", hash_generated_method = "F65488FF532FAE77E7DE06834B8A5540")
    public final HttpHost getTargetHost() {
HttpHost var67C71439C5981484698447EE93E1A003_1489709390 =         this.targetHost;
        var67C71439C5981484698447EE93E1A003_1489709390.addTaint(taint);
        return var67C71439C5981484698447EE93E1A003_1489709390;
        // ---------- Original Method ----------
        //return this.targetHost;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.846 -0400", hash_original_method = "28495B9032685860E947A62701D0E919", hash_generated_method = "E7A23E6DF1953DFB9F2328F941733633")
    public final InetAddress getLocalAddress() {
InetAddress varD252CCE80C2F3B9DE81EE46EA65F5895_55946335 =         this.localAddress;
        varD252CCE80C2F3B9DE81EE46EA65F5895_55946335.addTaint(taint);
        return varD252CCE80C2F3B9DE81EE46EA65F5895_55946335;
        // ---------- Original Method ----------
        //return this.localAddress;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.846 -0400", hash_original_method = "8A1F6C82C6946ABA9036325DB5D1093A", hash_generated_method = "94E349461D60B6CBC5EC775A80A400E2")
    public final int getHopCount() {
        int var7CFF713CFFC25845EFE8BFC10A30B95A_197034337 = ((proxyChain == null) ? 1 : (proxyChain.length+1));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_126941121 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_126941121;
        // ---------- Original Method ----------
        //return (proxyChain == null) ? 1 : (proxyChain.length+1);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.847 -0400", hash_original_method = "6FAF652E1C9EAABAB417C8ED32D41F4A", hash_generated_method = "49CAEA680264F7EAAC2E4005822F94C8")
    public final HttpHost getHopTarget(int hop) {
        addTaint(hop);
        if(hop < 0)        
        {
        IllegalArgumentException var853EA8D3011B4A803E1D3E44BA5221BB_557138053 = new IllegalArgumentException
                ("Hop index must not be negative: " + hop);
        var853EA8D3011B4A803E1D3E44BA5221BB_557138053.addTaint(taint);
        throw var853EA8D3011B4A803E1D3E44BA5221BB_557138053;
        }
        final int hopcount = getHopCount();
        if(hop >= hopcount)        
        {
        IllegalArgumentException varD7176FBE3B9AF72DACF25B8C4974B725_87091114 = new IllegalArgumentException
                ("Hop index " + hop +
                 " exceeds route length " + hopcount);
        varD7176FBE3B9AF72DACF25B8C4974B725_87091114.addTaint(taint);
        throw varD7176FBE3B9AF72DACF25B8C4974B725_87091114;
        }
        HttpHost result = null;
        if(hop < hopcount-1)        
        result = this.proxyChain[hop];
        else
        result = this.targetHost;
HttpHost varDC838461EE2FA0CA4C9BBB70A15456B0_2084940145 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_2084940145.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_2084940145;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.847 -0400", hash_original_method = "E9E1E8AC6D9C2477F7E0F63BF0C4ED60", hash_generated_method = "13668F2CB7F1DF9C6B9747AEFEC57041")
    public final HttpHost getProxyHost() {
HttpHost varF8CC471EE86A19D0A727D1FC9C328686_2103283138 =         (this.proxyChain == null) ? null : this.proxyChain[0];
        varF8CC471EE86A19D0A727D1FC9C328686_2103283138.addTaint(taint);
        return varF8CC471EE86A19D0A727D1FC9C328686_2103283138;
        // ---------- Original Method ----------
        //return (this.proxyChain == null) ? null : this.proxyChain[0];
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.847 -0400", hash_original_method = "350E5C2EB4A104FE6F444729C8CD5444", hash_generated_method = "5D4F6FEE9EE29B236EB9F94B5572C347")
    public final TunnelType getTunnelType() {
TunnelType var2217FBB31A61A2BC06264383F23E2C7F_835160810 =         this.tunnelled;
        var2217FBB31A61A2BC06264383F23E2C7F_835160810.addTaint(taint);
        return var2217FBB31A61A2BC06264383F23E2C7F_835160810;
        // ---------- Original Method ----------
        //return this.tunnelled;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.848 -0400", hash_original_method = "5CD3D72A708D2B06B9BD542F01F3D0EE", hash_generated_method = "FAC54F521AA7908EFD94C4D41BE5EE73")
    public final boolean isTunnelled() {
        boolean var6E17A163EAADFAAEEF827D05D550510F_681190803 = ((this.tunnelled == TunnelType.TUNNELLED));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_511141930 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_511141930;
        // ---------- Original Method ----------
        //return (this.tunnelled == TunnelType.TUNNELLED);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.848 -0400", hash_original_method = "24DDB6A6987422E004B186B027F8E19E", hash_generated_method = "093225BD0E54B22E82469B0F88ADF7C7")
    public final LayerType getLayerType() {
LayerType var0B365440B9E6602F90569354BDD2D5AF_1115478046 =         this.layered;
        var0B365440B9E6602F90569354BDD2D5AF_1115478046.addTaint(taint);
        return var0B365440B9E6602F90569354BDD2D5AF_1115478046;
        // ---------- Original Method ----------
        //return this.layered;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.848 -0400", hash_original_method = "90484F935FB331F087FF42A42BD08719", hash_generated_method = "AD97A5A5CC546E3C65B256E9C20C7541")
    public final boolean isLayered() {
        boolean var78483962D1129A47EBB9F287858CE500_1877568813 = ((this.layered == LayerType.LAYERED));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1671448760 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1671448760;
        // ---------- Original Method ----------
        //return (this.layered == LayerType.LAYERED);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.848 -0400", hash_original_method = "F448B780707B5356535204966A8ECD14", hash_generated_method = "16D1F4428A45DD368A02F5B98907EE8D")
    public final boolean isSecure() {
        boolean var1A6CF3022022F86E5EAF7A933D51276A_1171767373 = (this.secure);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_878236854 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_878236854;
        // ---------- Original Method ----------
        //return this.secure;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.849 -0400", hash_original_method = "3549831666270A81F0B6433F4C19950E", hash_generated_method = "36E2C85CFB2CE6AEEAE0A8E750CB7484")
    @Override
    public final boolean equals(Object o) {
        addTaint(o.getTaint());
        if(o == this)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1703005728 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1138909687 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1138909687;
        }
        if(!(o instanceof HttpRoute))        
        {
        boolean var68934A3E9455FA72420237EB05902327_1732239929 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_501709877 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_501709877;
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
        boolean var465289687A70DB7AA7217CC240C29F0F_1572298248 = (equal);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_39521570 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_39521570;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.850 -0400", hash_original_method = "BE36FC25647C071258E2596D1C885DDC", hash_generated_method = "CE687ED56510A76B869256110443FBE7")
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
        int var6320C1115D5BC2B6CA615B96BE050884_1214144581 = (hc);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_707821719 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_707821719;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.850 -0400", hash_original_method = "ED2086285AC52BF0F96F27196507174B", hash_generated_method = "38CAB20873E67F75A0B9E1F2ED6154E8")
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
String var5D73975C9EFF81CD9FF6232386AC7C22_1226563064 =         cab.toString();
        var5D73975C9EFF81CD9FF6232386AC7C22_1226563064.addTaint(taint);
        return var5D73975C9EFF81CD9FF6232386AC7C22_1226563064;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.851 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "26A44EC2B2965CA7CBB6F031F5C5B4AC")
    @Override
    public Object clone() throws CloneNotSupportedException {
Object var46F3A0D86742C1D6E099C2B166941A33_432511757 =         super.clone();
        var46F3A0D86742C1D6E099C2B166941A33_432511757.addTaint(taint);
        return var46F3A0D86742C1D6E099C2B166941A33_432511757;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

