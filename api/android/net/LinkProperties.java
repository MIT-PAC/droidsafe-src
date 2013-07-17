package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.net.ProxyProperties;
import android.os.Parcelable;
import android.os.Parcel;
import android.text.TextUtils;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class LinkProperties implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.165 -0400", hash_original_field = "E6BA5CF0E40609A434B9830189A5C361", hash_generated_field = "6D2C834A0EA52BA031060A9E0AEE620E")

    String mIfaceName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.165 -0400", hash_original_field = "6AEFC7DC6659B9C6DA99F3CB40F9A569", hash_generated_field = "00DE8BD688F501E4FB5528A63461C364")

    private Collection<LinkAddress> mLinkAddresses = new ArrayList<LinkAddress>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.165 -0400", hash_original_field = "FD91D9D1E504FC4A4ED4F0BB92CA1204", hash_generated_field = "D0EA13350ECE9796647D8145F3FB5864")

    private Collection<InetAddress> mDnses = new ArrayList<InetAddress>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.165 -0400", hash_original_field = "722D48B16FEB25182D36B7B66149CEE2", hash_generated_field = "2D860F9C91CB145D416269098C36EC63")

    private Collection<RouteInfo> mRoutes = new ArrayList<RouteInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.166 -0400", hash_original_field = "333D05D23A1925EB4A47F41C960FCCB0", hash_generated_field = "E6A788E6ED925BAD844282A07CD34FF9")

    private ProxyProperties mHttpProxy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.166 -0400", hash_original_method = "A2AA1798C08A5590A3DB637A5B794F80", hash_generated_method = "61D49920A9252FA3879C7DD8F5F55E1D")
    public  LinkProperties() {
        clear();
        // ---------- Original Method ----------
        //clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.166 -0400", hash_original_method = "836BF23A93C2D960D78EC02574131087", hash_generated_method = "F804DC29CB66E37CE1DE0BEA496C0816")
    public  LinkProperties(LinkProperties source) {
        if(source != null)        
        {
            mIfaceName = source.getInterfaceName();
for(LinkAddress l : source.getLinkAddresses())
            mLinkAddresses.add(l);
for(InetAddress i : source.getDnses())
            mDnses.add(i);
for(RouteInfo r : source.getRoutes())
            mRoutes.add(r);
            mHttpProxy = (source.getHttpProxy() == null)  ?
                null : new ProxyProperties(source.getHttpProxy());
        } //End block
        // ---------- Original Method ----------
        //if (source != null) {
            //mIfaceName = source.getInterfaceName();
            //for (LinkAddress l : source.getLinkAddresses()) mLinkAddresses.add(l);
            //for (InetAddress i : source.getDnses()) mDnses.add(i);
            //for (RouteInfo r : source.getRoutes()) mRoutes.add(r);
            //mHttpProxy = (source.getHttpProxy() == null)  ?
                //null : new ProxyProperties(source.getHttpProxy());
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.167 -0400", hash_original_method = "658C71C3CDAAE8BF2A6E808615EC0533", hash_generated_method = "D58C219F5C5992BE6A4B05BFFDE78502")
    public void setInterfaceName(String iface) {
        mIfaceName = iface;
        // ---------- Original Method ----------
        //mIfaceName = iface;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.167 -0400", hash_original_method = "DE3FEB2907F1F43DDDDBA76FC2B5A592", hash_generated_method = "3549AA94729BD490DE81C34953F7AC48")
    public String getInterfaceName() {
String varDBBF7F34FEA77D2F5A034B4E3366C61F_541616525 =         mIfaceName;
        varDBBF7F34FEA77D2F5A034B4E3366C61F_541616525.addTaint(taint);
        return varDBBF7F34FEA77D2F5A034B4E3366C61F_541616525;
        // ---------- Original Method ----------
        //return mIfaceName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.168 -0400", hash_original_method = "873086E492F590532E0F956B14530004", hash_generated_method = "071DF1DF6662181B5FE04E68C5FB16D3")
    public Collection<InetAddress> getAddresses() {
        Collection<InetAddress> addresses = new ArrayList<InetAddress>();
for(LinkAddress linkAddress : mLinkAddresses)
        {
            addresses.add(linkAddress.getAddress());
        } //End block
Collection<InetAddress> var6419FF4782F380F3448977EB89A48275_878829172 =         Collections.unmodifiableCollection(addresses);
        var6419FF4782F380F3448977EB89A48275_878829172.addTaint(taint);
        return var6419FF4782F380F3448977EB89A48275_878829172;
        // ---------- Original Method ----------
        //Collection<InetAddress> addresses = new ArrayList<InetAddress>();
        //for (LinkAddress linkAddress : mLinkAddresses) {
            //addresses.add(linkAddress.getAddress());
        //}
        //return Collections.unmodifiableCollection(addresses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.168 -0400", hash_original_method = "1B49E50669A271748C7EE163D2678E87", hash_generated_method = "B5C32F8523096D26414BC375B4BA9125")
    public void addLinkAddress(LinkAddress address) {
        addTaint(address.getTaint());
        if(address != null)        
        mLinkAddresses.add(address);
        // ---------- Original Method ----------
        //if (address != null) mLinkAddresses.add(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.169 -0400", hash_original_method = "72D86E86409333B5516C160027F12741", hash_generated_method = "94CD5D9F60DF7B185E6D9EA6F712320A")
    public Collection<LinkAddress> getLinkAddresses() {
Collection<LinkAddress> var27C4CB910FDED38F12DD8846316AB7F8_780008042 =         Collections.unmodifiableCollection(mLinkAddresses);
        var27C4CB910FDED38F12DD8846316AB7F8_780008042.addTaint(taint);
        return var27C4CB910FDED38F12DD8846316AB7F8_780008042;
        // ---------- Original Method ----------
        //return Collections.unmodifiableCollection(mLinkAddresses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.169 -0400", hash_original_method = "34CA5CC4558FA9428BD44173436D0F22", hash_generated_method = "B21EEBA61233533A53DED90C5483E9C4")
    public void addDns(InetAddress dns) {
        addTaint(dns.getTaint());
        if(dns != null)        
        mDnses.add(dns);
        // ---------- Original Method ----------
        //if (dns != null) mDnses.add(dns);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.183 -0400", hash_original_method = "71F7664B03379576DA51ED6043500785", hash_generated_method = "936B2E7CED78914F9A9356E7725664D3")
    public Collection<InetAddress> getDnses() {
Collection<InetAddress> var403B15EFA3DEE7746142DD35B22D830C_793784961 =         Collections.unmodifiableCollection(mDnses);
        var403B15EFA3DEE7746142DD35B22D830C_793784961.addTaint(taint);
        return var403B15EFA3DEE7746142DD35B22D830C_793784961;
        // ---------- Original Method ----------
        //return Collections.unmodifiableCollection(mDnses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.183 -0400", hash_original_method = "D2F9F5371D010F9C9B4F83D9513356DD", hash_generated_method = "84C07B5B887C9A3C118E62B25E32A916")
    public void addRoute(RouteInfo route) {
        addTaint(route.getTaint());
        if(route != null)        
        mRoutes.add(route);
        // ---------- Original Method ----------
        //if (route != null) mRoutes.add(route);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.183 -0400", hash_original_method = "A7B26240781BB7C0E135CB45CD0D9800", hash_generated_method = "5DE9054FA921C1C0D32E15800604CAEE")
    public Collection<RouteInfo> getRoutes() {
Collection<RouteInfo> var5AD2DA20604AB9506F6623852FC9A803_940561220 =         Collections.unmodifiableCollection(mRoutes);
        var5AD2DA20604AB9506F6623852FC9A803_940561220.addTaint(taint);
        return var5AD2DA20604AB9506F6623852FC9A803_940561220;
        // ---------- Original Method ----------
        //return Collections.unmodifiableCollection(mRoutes);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.183 -0400", hash_original_method = "A3A7E4451F64D99820B4BAAEF1AFE8A2", hash_generated_method = "8C961CFF90F31516B337EDFD675E66E4")
    public void setHttpProxy(ProxyProperties proxy) {
        mHttpProxy = proxy;
        // ---------- Original Method ----------
        //mHttpProxy = proxy;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.183 -0400", hash_original_method = "6E571D9EDF02B85B7F325367F981AC91", hash_generated_method = "7E2E994E48BBC4AB41C142EB915A22AE")
    public ProxyProperties getHttpProxy() {
ProxyProperties var8C1D00C1505CE1BA6F0EC413A8FF4F4A_99294844 =         mHttpProxy;
        var8C1D00C1505CE1BA6F0EC413A8FF4F4A_99294844.addTaint(taint);
        return var8C1D00C1505CE1BA6F0EC413A8FF4F4A_99294844;
        // ---------- Original Method ----------
        //return mHttpProxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.184 -0400", hash_original_method = "4D86E4F145913ECB4C1EE8109466CAB3", hash_generated_method = "A8ED76BD4957AE90AC09315AE270F855")
    public void clear() {
        mIfaceName = null;
        mLinkAddresses.clear();
        mDnses.clear();
        mRoutes.clear();
        mHttpProxy = null;
        // ---------- Original Method ----------
        //mIfaceName = null;
        //mLinkAddresses.clear();
        //mDnses.clear();
        //mRoutes.clear();
        //mHttpProxy = null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.184 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "354EC4FFCE7CACACCD67615F09F90490")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1411332935 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1264700301 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1264700301;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.184 -0400", hash_original_method = "FDC9878366ECD283FC0D7411AB5ED4B7", hash_generated_method = "430E3CA27EC3E5068A7AD56254E8C80D")
    @Override
    public String toString() {
        String ifaceName = (mIfaceName == null ? "" : "InterfaceName: " + mIfaceName + " ");
        String linkAddresses = "LinkAddresses: [";
for(LinkAddress addr : mLinkAddresses)
        linkAddresses += addr.toString() + ",";
        linkAddresses += "] ";
        String dns = "DnsAddresses: [";
for(InetAddress addr : mDnses)
        dns += addr.getHostAddress() + ",";
        dns += "] ";
        String routes = "Routes: [";
for(RouteInfo route : mRoutes)
        routes += route.toString() + ",";
        routes += "] ";
        String proxy = (mHttpProxy == null ? "" : "HttpProxy: " + mHttpProxy.toString() + " ");
String var430472DB386972AD2D3982D89089051C_280524827 =         ifaceName + linkAddresses + routes + dns + proxy;
        var430472DB386972AD2D3982D89089051C_280524827.addTaint(taint);
        return var430472DB386972AD2D3982D89089051C_280524827;
        // ---------- Original Method ----------
        //String ifaceName = (mIfaceName == null ? "" : "InterfaceName: " + mIfaceName + " ");
        //String linkAddresses = "LinkAddresses: [";
        //for (LinkAddress addr : mLinkAddresses) linkAddresses += addr.toString() + ",";
        //linkAddresses += "] ";
        //String dns = "DnsAddresses: [";
        //for (InetAddress addr : mDnses) dns += addr.getHostAddress() + ",";
        //dns += "] ";
        //String routes = "Routes: [";
        //for (RouteInfo route : mRoutes) routes += route.toString() + ",";
        //routes += "] ";
        //String proxy = (mHttpProxy == null ? "" : "HttpProxy: " + mHttpProxy.toString() + " ");
        //return ifaceName + linkAddresses + routes + dns + proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.184 -0400", hash_original_method = "48DB33246C86C278D2BAD545A88B9470", hash_generated_method = "FF427748934BE77575F2B0DD57EE4C28")
    public boolean isIdenticalInterfaceName(LinkProperties target) {
        addTaint(target.getTaint());
        boolean varD20D30097790CAF68F9CE6536FAE7A8F_2104934393 = (TextUtils.equals(getInterfaceName(), target.getInterfaceName()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1055086612 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1055086612;
        // ---------- Original Method ----------
        //return TextUtils.equals(getInterfaceName(), target.getInterfaceName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.185 -0400", hash_original_method = "D0F0B04B5ACB5FD8D13B5B828D9A160C", hash_generated_method = "0B93783F70D33D2BC32F88B9F8E42323")
    public boolean isIdenticalAddresses(LinkProperties target) {
        addTaint(target.getTaint());
        Collection<InetAddress> targetAddresses = target.getAddresses();
        Collection<InetAddress> sourceAddresses = getAddresses();
        boolean var203BC4A5FC3DC79E520CB82BF00AC7E7_1932729720 = ((sourceAddresses.size() == targetAddresses.size()) ?
                    sourceAddresses.containsAll(targetAddresses) : false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1908911582 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1908911582;
        // ---------- Original Method ----------
        //Collection<InetAddress> targetAddresses = target.getAddresses();
        //Collection<InetAddress> sourceAddresses = getAddresses();
        //return (sourceAddresses.size() == targetAddresses.size()) ?
                    //sourceAddresses.containsAll(targetAddresses) : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.185 -0400", hash_original_method = "14A4F7F9C3E90075B30F314D9FCFE073", hash_generated_method = "48F46139A584B7085DBA3D9489591D0F")
    public boolean isIdenticalDnses(LinkProperties target) {
        addTaint(target.getTaint());
        Collection<InetAddress> targetDnses = target.getDnses();
        boolean varAD75F03F5A5C47B5084FF92D7EA741A3_1346998138 = ((mDnses.size() == targetDnses.size()) ?
                    mDnses.containsAll(targetDnses) : false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1573487585 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1573487585;
        // ---------- Original Method ----------
        //Collection<InetAddress> targetDnses = target.getDnses();
        //return (mDnses.size() == targetDnses.size()) ?
                    //mDnses.containsAll(targetDnses) : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.185 -0400", hash_original_method = "3C11F6A9D4CB5E313FF4392D544C8E01", hash_generated_method = "6E4832EB8B5546138C52656E8F7389AB")
    public boolean isIdenticalRoutes(LinkProperties target) {
        addTaint(target.getTaint());
        Collection<RouteInfo> targetRoutes = target.getRoutes();
        boolean varF82B5BD70A878FCD29A431DC790087FD_1411585955 = ((mRoutes.size() == targetRoutes.size()) ?
                    mRoutes.containsAll(targetRoutes) : false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_141816809 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_141816809;
        // ---------- Original Method ----------
        //Collection<RouteInfo> targetRoutes = target.getRoutes();
        //return (mRoutes.size() == targetRoutes.size()) ?
                    //mRoutes.containsAll(targetRoutes) : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.185 -0400", hash_original_method = "DD4569AF6E08EF8065FD20A93C9D719F", hash_generated_method = "FE4C11FF68E6D3CE30FE3355036F32B9")
    public boolean isIdenticalHttpProxy(LinkProperties target) {
        addTaint(target.getTaint());
        boolean varC24E6D324D9440BD46B58A535186305B_1881584451 = (getHttpProxy() == null ? target.getHttpProxy() == null :
                    getHttpProxy().equals(target.getHttpProxy()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_753592446 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_753592446;
        // ---------- Original Method ----------
        //return getHttpProxy() == null ? target.getHttpProxy() == null :
                    //getHttpProxy().equals(target.getHttpProxy());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.185 -0400", hash_original_method = "E1692DB8F3E9AF5A893AE4BBE4FFDED0", hash_generated_method = "C94B55E80A1D9CD8773BECD64A710FAF")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        if(this == obj)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_240650217 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1221503266 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1221503266;
        }
        if(!(obj instanceof LinkProperties))        
        {
        boolean var68934A3E9455FA72420237EB05902327_2131527282 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1108575638 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1108575638;
        }
        LinkProperties target = (LinkProperties) obj;
        boolean varAB87A44EA60FE1170ECBD60F0833B347_1142618175 = (isIdenticalInterfaceName(target) &&
                isIdenticalAddresses(target) &&
                isIdenticalDnses(target) &&
                isIdenticalRoutes(target) &&
                isIdenticalHttpProxy(target));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1040697391 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1040697391;
        // ---------- Original Method ----------
        //if (this == obj) return true;
        //if (!(obj instanceof LinkProperties)) return false;
        //LinkProperties target = (LinkProperties) obj;
        //return isIdenticalInterfaceName(target) &&
                //isIdenticalAddresses(target) &&
                //isIdenticalDnses(target) &&
                //isIdenticalRoutes(target) &&
                //isIdenticalHttpProxy(target);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.186 -0400", hash_original_method = "F16C063B63526E6739B6C0383B3231A3", hash_generated_method = "3EC9D5A7B274FE4D61955D627B0BE9A5")
    public CompareResult<LinkAddress> compareAddresses(LinkProperties target) {
        addTaint(target.getTaint());
        CompareResult<LinkAddress> result = new CompareResult<LinkAddress>();
        result.removed = new ArrayList<LinkAddress>(mLinkAddresses);
        result.added.clear();
        if(target != null)        
        {
for(LinkAddress newAddress : target.getLinkAddresses())
            {
                if(! result.removed.remove(newAddress))                
                {
                    result.added.add(newAddress);
                } //End block
            } //End block
        } //End block
CompareResult<LinkAddress> varDC838461EE2FA0CA4C9BBB70A15456B0_268413415 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_268413415.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_268413415;
        // ---------- Original Method ----------
        //CompareResult<LinkAddress> result = new CompareResult<LinkAddress>();
        //result.removed = new ArrayList<LinkAddress>(mLinkAddresses);
        //result.added.clear();
        //if (target != null) {
            //for (LinkAddress newAddress : target.getLinkAddresses()) {
                //if (! result.removed.remove(newAddress)) {
                    //result.added.add(newAddress);
                //}
            //}
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.186 -0400", hash_original_method = "C56C38D458207E713A2F639173CF494C", hash_generated_method = "7392540AF25EA68A0AD4DC9470ED3368")
    public CompareResult<InetAddress> compareDnses(LinkProperties target) {
        addTaint(target.getTaint());
        CompareResult<InetAddress> result = new CompareResult<InetAddress>();
        result.removed = new ArrayList<InetAddress>(mDnses);
        result.added.clear();
        if(target != null)        
        {
for(InetAddress newAddress : target.getDnses())
            {
                if(! result.removed.remove(newAddress))                
                {
                    result.added.add(newAddress);
                } //End block
            } //End block
        } //End block
CompareResult<InetAddress> varDC838461EE2FA0CA4C9BBB70A15456B0_181511754 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_181511754.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_181511754;
        // ---------- Original Method ----------
        //CompareResult<InetAddress> result = new CompareResult<InetAddress>();
        //result.removed = new ArrayList<InetAddress>(mDnses);
        //result.added.clear();
        //if (target != null) {
            //for (InetAddress newAddress : target.getDnses()) {
                //if (! result.removed.remove(newAddress)) {
                    //result.added.add(newAddress);
                //}
            //}
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.186 -0400", hash_original_method = "39063DDD1454993D1B4985089C8FABB6", hash_generated_method = "602D40076167C76E930A48C85F292F4E")
    public CompareResult<RouteInfo> compareRoutes(LinkProperties target) {
        addTaint(target.getTaint());
        CompareResult<RouteInfo> result = new CompareResult<RouteInfo>();
        result.removed = new ArrayList<RouteInfo>(mRoutes);
        result.added.clear();
        if(target != null)        
        {
for(RouteInfo r : target.getRoutes())
            {
                if(! result.removed.remove(r))                
                {
                    result.added.add(r);
                } //End block
            } //End block
        } //End block
CompareResult<RouteInfo> varDC838461EE2FA0CA4C9BBB70A15456B0_1361917675 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1361917675.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1361917675;
        // ---------- Original Method ----------
        //CompareResult<RouteInfo> result = new CompareResult<RouteInfo>();
        //result.removed = new ArrayList<RouteInfo>(mRoutes);
        //result.added.clear();
        //if (target != null) {
            //for (RouteInfo r : target.getRoutes()) {
                //if (! result.removed.remove(r)) {
                    //result.added.add(r);
                //}
            //}
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.186 -0400", hash_original_method = "28ECE8095E829F4615B9B35514C29B36", hash_generated_method = "350D6A145A8E5037BFED39CBE504AAE3")
    @Override
    public int hashCode() {
        int var27402B80DD6C8091D74B50D5808EB9A1_1831083412 = (((null == mIfaceName) ? 0 : mIfaceName.hashCode()
                + mLinkAddresses.size() * 31
                + mDnses.size() * 37
                + mRoutes.size() * 41
                + ((null == mHttpProxy) ? 0 : mHttpProxy.hashCode())));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1853874588 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1853874588;
        // ---------- Original Method ----------
        //return ((null == mIfaceName) ? 0 : mIfaceName.hashCode()
                //+ mLinkAddresses.size() * 31
                //+ mDnses.size() * 37
                //+ mRoutes.size() * 41
                //+ ((null == mHttpProxy) ? 0 : mHttpProxy.hashCode()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.187 -0400", hash_original_method = "FA484CCA03B27F5C12EABAE629DE360A", hash_generated_method = "B55B692B9637845F2A23BB664526EAEF")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeString(getInterfaceName());
        dest.writeInt(mLinkAddresses.size());
for(LinkAddress linkAddress : mLinkAddresses)
        {
            dest.writeParcelable(linkAddress, flags);
        } //End block
        dest.writeInt(mDnses.size());
for(InetAddress d : mDnses)
        {
            dest.writeByteArray(d.getAddress());
        } //End block
        dest.writeInt(mRoutes.size());
for(RouteInfo route : mRoutes)
        {
            dest.writeParcelable(route, flags);
        } //End block
        if(mHttpProxy != null)        
        {
            dest.writeByte((byte)1);
            dest.writeParcelable(mHttpProxy, flags);
        } //End block
        else
        {
            dest.writeByte((byte)0);
        } //End block
        // ---------- Original Method ----------
        //dest.writeString(getInterfaceName());
        //dest.writeInt(mLinkAddresses.size());
        //for(LinkAddress linkAddress : mLinkAddresses) {
            //dest.writeParcelable(linkAddress, flags);
        //}
        //dest.writeInt(mDnses.size());
        //for(InetAddress d : mDnses) {
            //dest.writeByteArray(d.getAddress());
        //}
        //dest.writeInt(mRoutes.size());
        //for(RouteInfo route : mRoutes) {
            //dest.writeParcelable(route, flags);
        //}
        //if (mHttpProxy != null) {
            //dest.writeByte((byte)1);
            //dest.writeParcelable(mHttpProxy, flags);
        //} else {
            //dest.writeByte((byte)0);
        //}
    }

    
    public static class CompareResult<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.187 -0400", hash_original_field = "C4B1F39807DCA632860153E967535069", hash_generated_field = "656FE863E184B8E40AE962362C5E65EA")

        public Collection<T> removed = new ArrayList<T>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.187 -0400", hash_original_field = "CB13C543EE6E3E67C92366544BE592A7", hash_generated_field = "C6B74BD881B85CA2CE669431297F84E6")

        public Collection<T> added = new ArrayList<T>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.187 -0400", hash_original_method = "8B9C887FE92C246DB85CDDBCEEBB2CF3", hash_generated_method = "8B9C887FE92C246DB85CDDBCEEBB2CF3")
        public CompareResult ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.187 -0400", hash_original_method = "432CBAB98383F022B31745E1B8881CF6", hash_generated_method = "5985032AEB41D1EFDBE089454C4EE87D")
        @Override
        public String toString() {
            String retVal = "removed=[";
for(T addr : removed)
            retVal += addr.toString() + ",";
            retVal += "] added=[";
for(T addr : added)
            retVal += addr.toString() + ",";
            retVal += "]";
String var906583DF257E5B26DD99AC8582D137B0_1178724127 =             retVal;
            var906583DF257E5B26DD99AC8582D137B0_1178724127.addTaint(taint);
            return var906583DF257E5B26DD99AC8582D137B0_1178724127;
            // ---------- Original Method ----------
            //String retVal = "removed=[";
            //for (T addr : removed) retVal += addr.toString() + ",";
            //retVal += "] added=[";
            //for (T addr : added) retVal += addr.toString() + ",";
            //retVal += "]";
            //return retVal;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.187 -0400", hash_original_field = "AD9F190960A42BD6F0B1EE16B7E966B8", hash_generated_field = "24691869BF8BBA8F28BDB834441D45F0")

    public static final Creator<LinkProperties> CREATOR =
        new Creator<LinkProperties>() {
            public LinkProperties createFromParcel(Parcel in) {
                LinkProperties netProp = new LinkProperties();
                String iface = in.readString();
                if (iface != null) {
                    try {
                        netProp.setInterfaceName(iface);
                    } catch (Exception e) {
                        return null;
                    }
                }
                int addressCount = in.readInt();
                for (int i=0; i<addressCount; i++) {
                    netProp.addLinkAddress((LinkAddress)in.readParcelable(null));
                }
                addressCount = in.readInt();
                for (int i=0; i<addressCount; i++) {
                    try {
                        netProp.addDns(InetAddress.getByAddress(in.createByteArray()));
                    } catch (UnknownHostException e) { }
                }
                addressCount = in.readInt();
                for (int i=0; i<addressCount; i++) {
                    netProp.addRoute((RouteInfo)in.readParcelable(null));
                }
                if (in.readByte() == 1) {
                    netProp.setHttpProxy((ProxyProperties)in.readParcelable(null));
                }
                return netProp;
            }

            public LinkProperties[] newArray(int size) {
                return new LinkProperties[size];
            }
        };
    // orphaned legacy method
    public LinkProperties createFromParcel(Parcel in) {
                LinkProperties netProp = new LinkProperties();
                String iface = in.readString();
                if (iface != null) {
                    try {
                        netProp.setInterfaceName(iface);
                    } catch (Exception e) {
                        return null;
                    }
                }
                int addressCount = in.readInt();
                for (int i=0; i<addressCount; i++) {
                    netProp.addLinkAddress((LinkAddress)in.readParcelable(null));
                }
                addressCount = in.readInt();
                for (int i=0; i<addressCount; i++) {
                    try {
                        netProp.addDns(InetAddress.getByAddress(in.createByteArray()));
                    } catch (UnknownHostException e) { }
                }
                addressCount = in.readInt();
                for (int i=0; i<addressCount; i++) {
                    netProp.addRoute((RouteInfo)in.readParcelable(null));
                }
                if (in.readByte() == 1) {
                    netProp.setHttpProxy((ProxyProperties)in.readParcelable(null));
                }
                return netProp;
            }
    
    // orphaned legacy method
    public LinkProperties[] newArray(int size) {
                return new LinkProperties[size];
            }
    
}

