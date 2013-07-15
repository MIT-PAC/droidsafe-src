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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.491 -0400", hash_original_field = "E6BA5CF0E40609A434B9830189A5C361", hash_generated_field = "6D2C834A0EA52BA031060A9E0AEE620E")

    String mIfaceName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.491 -0400", hash_original_field = "6AEFC7DC6659B9C6DA99F3CB40F9A569", hash_generated_field = "00DE8BD688F501E4FB5528A63461C364")

    private Collection<LinkAddress> mLinkAddresses = new ArrayList<LinkAddress>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.491 -0400", hash_original_field = "FD91D9D1E504FC4A4ED4F0BB92CA1204", hash_generated_field = "D0EA13350ECE9796647D8145F3FB5864")

    private Collection<InetAddress> mDnses = new ArrayList<InetAddress>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.491 -0400", hash_original_field = "722D48B16FEB25182D36B7B66149CEE2", hash_generated_field = "2D860F9C91CB145D416269098C36EC63")

    private Collection<RouteInfo> mRoutes = new ArrayList<RouteInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.491 -0400", hash_original_field = "333D05D23A1925EB4A47F41C960FCCB0", hash_generated_field = "E6A788E6ED925BAD844282A07CD34FF9")

    private ProxyProperties mHttpProxy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.492 -0400", hash_original_method = "A2AA1798C08A5590A3DB637A5B794F80", hash_generated_method = "61D49920A9252FA3879C7DD8F5F55E1D")
    public  LinkProperties() {
        clear();
        // ---------- Original Method ----------
        //clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.492 -0400", hash_original_method = "836BF23A93C2D960D78EC02574131087", hash_generated_method = "F804DC29CB66E37CE1DE0BEA496C0816")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.493 -0400", hash_original_method = "658C71C3CDAAE8BF2A6E808615EC0533", hash_generated_method = "D58C219F5C5992BE6A4B05BFFDE78502")
    public void setInterfaceName(String iface) {
        mIfaceName = iface;
        // ---------- Original Method ----------
        //mIfaceName = iface;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.493 -0400", hash_original_method = "DE3FEB2907F1F43DDDDBA76FC2B5A592", hash_generated_method = "00DBDC025AE1C4F2B2711052096EE4DC")
    public String getInterfaceName() {
String varDBBF7F34FEA77D2F5A034B4E3366C61F_1175500303 =         mIfaceName;
        varDBBF7F34FEA77D2F5A034B4E3366C61F_1175500303.addTaint(taint);
        return varDBBF7F34FEA77D2F5A034B4E3366C61F_1175500303;
        // ---------- Original Method ----------
        //return mIfaceName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.494 -0400", hash_original_method = "873086E492F590532E0F956B14530004", hash_generated_method = "46084C32BC0EA4A4E8FE44B084DB2542")
    public Collection<InetAddress> getAddresses() {
        Collection<InetAddress> addresses = new ArrayList<InetAddress>();
for(LinkAddress linkAddress : mLinkAddresses)
        {
            addresses.add(linkAddress.getAddress());
        } //End block
Collection<InetAddress> var6419FF4782F380F3448977EB89A48275_1919595701 =         Collections.unmodifiableCollection(addresses);
        var6419FF4782F380F3448977EB89A48275_1919595701.addTaint(taint);
        return var6419FF4782F380F3448977EB89A48275_1919595701;
        // ---------- Original Method ----------
        //Collection<InetAddress> addresses = new ArrayList<InetAddress>();
        //for (LinkAddress linkAddress : mLinkAddresses) {
            //addresses.add(linkAddress.getAddress());
        //}
        //return Collections.unmodifiableCollection(addresses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.494 -0400", hash_original_method = "1B49E50669A271748C7EE163D2678E87", hash_generated_method = "B5C32F8523096D26414BC375B4BA9125")
    public void addLinkAddress(LinkAddress address) {
        addTaint(address.getTaint());
    if(address != null)        
        mLinkAddresses.add(address);
        // ---------- Original Method ----------
        //if (address != null) mLinkAddresses.add(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.495 -0400", hash_original_method = "72D86E86409333B5516C160027F12741", hash_generated_method = "1941AE18889B18A697099717EC7A2651")
    public Collection<LinkAddress> getLinkAddresses() {
Collection<LinkAddress> var27C4CB910FDED38F12DD8846316AB7F8_2005307710 =         Collections.unmodifiableCollection(mLinkAddresses);
        var27C4CB910FDED38F12DD8846316AB7F8_2005307710.addTaint(taint);
        return var27C4CB910FDED38F12DD8846316AB7F8_2005307710;
        // ---------- Original Method ----------
        //return Collections.unmodifiableCollection(mLinkAddresses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.495 -0400", hash_original_method = "34CA5CC4558FA9428BD44173436D0F22", hash_generated_method = "B21EEBA61233533A53DED90C5483E9C4")
    public void addDns(InetAddress dns) {
        addTaint(dns.getTaint());
    if(dns != null)        
        mDnses.add(dns);
        // ---------- Original Method ----------
        //if (dns != null) mDnses.add(dns);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.495 -0400", hash_original_method = "71F7664B03379576DA51ED6043500785", hash_generated_method = "467C85ABF76119727FB9FE9EEBF686D2")
    public Collection<InetAddress> getDnses() {
Collection<InetAddress> var403B15EFA3DEE7746142DD35B22D830C_2026083592 =         Collections.unmodifiableCollection(mDnses);
        var403B15EFA3DEE7746142DD35B22D830C_2026083592.addTaint(taint);
        return var403B15EFA3DEE7746142DD35B22D830C_2026083592;
        // ---------- Original Method ----------
        //return Collections.unmodifiableCollection(mDnses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.495 -0400", hash_original_method = "D2F9F5371D010F9C9B4F83D9513356DD", hash_generated_method = "84C07B5B887C9A3C118E62B25E32A916")
    public void addRoute(RouteInfo route) {
        addTaint(route.getTaint());
    if(route != null)        
        mRoutes.add(route);
        // ---------- Original Method ----------
        //if (route != null) mRoutes.add(route);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.496 -0400", hash_original_method = "A7B26240781BB7C0E135CB45CD0D9800", hash_generated_method = "46DCAE447C5F05E9F3A1C774DE6A67B1")
    public Collection<RouteInfo> getRoutes() {
Collection<RouteInfo> var5AD2DA20604AB9506F6623852FC9A803_533550709 =         Collections.unmodifiableCollection(mRoutes);
        var5AD2DA20604AB9506F6623852FC9A803_533550709.addTaint(taint);
        return var5AD2DA20604AB9506F6623852FC9A803_533550709;
        // ---------- Original Method ----------
        //return Collections.unmodifiableCollection(mRoutes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.496 -0400", hash_original_method = "A3A7E4451F64D99820B4BAAEF1AFE8A2", hash_generated_method = "8C961CFF90F31516B337EDFD675E66E4")
    public void setHttpProxy(ProxyProperties proxy) {
        mHttpProxy = proxy;
        // ---------- Original Method ----------
        //mHttpProxy = proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.496 -0400", hash_original_method = "6E571D9EDF02B85B7F325367F981AC91", hash_generated_method = "352AD3DD3C4D13D8016303D99EFCA098")
    public ProxyProperties getHttpProxy() {
ProxyProperties var8C1D00C1505CE1BA6F0EC413A8FF4F4A_1967034512 =         mHttpProxy;
        var8C1D00C1505CE1BA6F0EC413A8FF4F4A_1967034512.addTaint(taint);
        return var8C1D00C1505CE1BA6F0EC413A8FF4F4A_1967034512;
        // ---------- Original Method ----------
        //return mHttpProxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.497 -0400", hash_original_method = "4D86E4F145913ECB4C1EE8109466CAB3", hash_generated_method = "A8ED76BD4957AE90AC09315AE270F855")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.497 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8827EB6ED5EE35586619A7AC08AEC4ED")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1484843669 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1152223887 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1152223887;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.498 -0400", hash_original_method = "FDC9878366ECD283FC0D7411AB5ED4B7", hash_generated_method = "4EC53AE83A89CFFD9A978BBFC6BC56F3")
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
String var430472DB386972AD2D3982D89089051C_863804347 =         ifaceName + linkAddresses + routes + dns + proxy;
        var430472DB386972AD2D3982D89089051C_863804347.addTaint(taint);
        return var430472DB386972AD2D3982D89089051C_863804347;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.498 -0400", hash_original_method = "48DB33246C86C278D2BAD545A88B9470", hash_generated_method = "58746B84144008F348B058B8A34DD720")
    public boolean isIdenticalInterfaceName(LinkProperties target) {
        addTaint(target.getTaint());
        boolean varD20D30097790CAF68F9CE6536FAE7A8F_1731274473 = (TextUtils.equals(getInterfaceName(), target.getInterfaceName()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_685383607 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_685383607;
        // ---------- Original Method ----------
        //return TextUtils.equals(getInterfaceName(), target.getInterfaceName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.499 -0400", hash_original_method = "D0F0B04B5ACB5FD8D13B5B828D9A160C", hash_generated_method = "0676051722CACADFC56DBFAC2F1A6EBD")
    public boolean isIdenticalAddresses(LinkProperties target) {
        addTaint(target.getTaint());
        Collection<InetAddress> targetAddresses = target.getAddresses();
        Collection<InetAddress> sourceAddresses = getAddresses();
        boolean var203BC4A5FC3DC79E520CB82BF00AC7E7_2140651018 = ((sourceAddresses.size() == targetAddresses.size()) ?
                    sourceAddresses.containsAll(targetAddresses) : false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_249774975 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_249774975;
        // ---------- Original Method ----------
        //Collection<InetAddress> targetAddresses = target.getAddresses();
        //Collection<InetAddress> sourceAddresses = getAddresses();
        //return (sourceAddresses.size() == targetAddresses.size()) ?
                    //sourceAddresses.containsAll(targetAddresses) : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.499 -0400", hash_original_method = "14A4F7F9C3E90075B30F314D9FCFE073", hash_generated_method = "B828E8842A9EA42900356A13801D0F55")
    public boolean isIdenticalDnses(LinkProperties target) {
        addTaint(target.getTaint());
        Collection<InetAddress> targetDnses = target.getDnses();
        boolean varAD75F03F5A5C47B5084FF92D7EA741A3_1750794053 = ((mDnses.size() == targetDnses.size()) ?
                    mDnses.containsAll(targetDnses) : false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_24848705 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_24848705;
        // ---------- Original Method ----------
        //Collection<InetAddress> targetDnses = target.getDnses();
        //return (mDnses.size() == targetDnses.size()) ?
                    //mDnses.containsAll(targetDnses) : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.499 -0400", hash_original_method = "3C11F6A9D4CB5E313FF4392D544C8E01", hash_generated_method = "FB292F40F62AFBCCD4F6471BE174BAEA")
    public boolean isIdenticalRoutes(LinkProperties target) {
        addTaint(target.getTaint());
        Collection<RouteInfo> targetRoutes = target.getRoutes();
        boolean varF82B5BD70A878FCD29A431DC790087FD_1362711118 = ((mRoutes.size() == targetRoutes.size()) ?
                    mRoutes.containsAll(targetRoutes) : false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1373478115 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1373478115;
        // ---------- Original Method ----------
        //Collection<RouteInfo> targetRoutes = target.getRoutes();
        //return (mRoutes.size() == targetRoutes.size()) ?
                    //mRoutes.containsAll(targetRoutes) : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.500 -0400", hash_original_method = "DD4569AF6E08EF8065FD20A93C9D719F", hash_generated_method = "BE9DD1A6EFD3A95A6EB3397B4189FFC8")
    public boolean isIdenticalHttpProxy(LinkProperties target) {
        addTaint(target.getTaint());
        boolean varC24E6D324D9440BD46B58A535186305B_601163263 = (getHttpProxy() == null ? target.getHttpProxy() == null :
                    getHttpProxy().equals(target.getHttpProxy()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_329138992 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_329138992;
        // ---------- Original Method ----------
        //return getHttpProxy() == null ? target.getHttpProxy() == null :
                    //getHttpProxy().equals(target.getHttpProxy());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.500 -0400", hash_original_method = "E1692DB8F3E9AF5A893AE4BBE4FFDED0", hash_generated_method = "AAEFE7E5F236E51D93D2A9E0DB18C9BB")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(this == obj)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_846104035 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_819515845 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_819515845;
        }
    if(!(obj instanceof LinkProperties))        
        {
        boolean var68934A3E9455FA72420237EB05902327_1077306103 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1104906307 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1104906307;
        }
        LinkProperties target = (LinkProperties) obj;
        boolean varAB87A44EA60FE1170ECBD60F0833B347_1468406450 = (isIdenticalInterfaceName(target) &&
                isIdenticalAddresses(target) &&
                isIdenticalDnses(target) &&
                isIdenticalRoutes(target) &&
                isIdenticalHttpProxy(target));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_503640270 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_503640270;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.501 -0400", hash_original_method = "F16C063B63526E6739B6C0383B3231A3", hash_generated_method = "1D78D4FF9F9840BFD962E4E9AD6F28D7")
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
CompareResult<LinkAddress> varDC838461EE2FA0CA4C9BBB70A15456B0_1027406539 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1027406539.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1027406539;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.502 -0400", hash_original_method = "C56C38D458207E713A2F639173CF494C", hash_generated_method = "18F9B3D1477E1BB3BA5C0A1F89EB3707")
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
CompareResult<InetAddress> varDC838461EE2FA0CA4C9BBB70A15456B0_439974277 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_439974277.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_439974277;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.502 -0400", hash_original_method = "39063DDD1454993D1B4985089C8FABB6", hash_generated_method = "F208902E0CF3AFF68EDD224A000C8133")
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
CompareResult<RouteInfo> varDC838461EE2FA0CA4C9BBB70A15456B0_718880752 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_718880752.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_718880752;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.503 -0400", hash_original_method = "28ECE8095E829F4615B9B35514C29B36", hash_generated_method = "957163436E843858A71185FDFF6E09B0")
    @Override
    public int hashCode() {
        int var27402B80DD6C8091D74B50D5808EB9A1_1547615973 = (((null == mIfaceName) ? 0 : mIfaceName.hashCode()
                + mLinkAddresses.size() * 31
                + mDnses.size() * 37
                + mRoutes.size() * 41
                + ((null == mHttpProxy) ? 0 : mHttpProxy.hashCode())));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_894944891 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_894944891;
        // ---------- Original Method ----------
        //return ((null == mIfaceName) ? 0 : mIfaceName.hashCode()
                //+ mLinkAddresses.size() * 31
                //+ mDnses.size() * 37
                //+ mRoutes.size() * 41
                //+ ((null == mHttpProxy) ? 0 : mHttpProxy.hashCode()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.503 -0400", hash_original_method = "FA484CCA03B27F5C12EABAE629DE360A", hash_generated_method = "B55B692B9637845F2A23BB664526EAEF")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.504 -0400", hash_original_field = "C4B1F39807DCA632860153E967535069", hash_generated_field = "656FE863E184B8E40AE962362C5E65EA")

        public Collection<T> removed = new ArrayList<T>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.504 -0400", hash_original_field = "CB13C543EE6E3E67C92366544BE592A7", hash_generated_field = "C6B74BD881B85CA2CE669431297F84E6")

        public Collection<T> added = new ArrayList<T>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.504 -0400", hash_original_method = "8B9C887FE92C246DB85CDDBCEEBB2CF3", hash_generated_method = "8B9C887FE92C246DB85CDDBCEEBB2CF3")
        public CompareResult ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.505 -0400", hash_original_method = "432CBAB98383F022B31745E1B8881CF6", hash_generated_method = "7782EAC5742D9BC832725E88E427BBA3")
        @Override
        public String toString() {
            String retVal = "removed=[";
for(T addr : removed)
            retVal += addr.toString() + ",";
            retVal += "] added=[";
for(T addr : added)
            retVal += addr.toString() + ",";
            retVal += "]";
String var906583DF257E5B26DD99AC8582D137B0_1476379577 =             retVal;
            var906583DF257E5B26DD99AC8582D137B0_1476379577.addTaint(taint);
            return var906583DF257E5B26DD99AC8582D137B0_1476379577;
            // ---------- Original Method ----------
            //String retVal = "removed=[";
            //for (T addr : removed) retVal += addr.toString() + ",";
            //retVal += "] added=[";
            //for (T addr : added) retVal += addr.toString() + ",";
            //retVal += "]";
            //return retVal;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.506 -0400", hash_original_field = "AD9F190960A42BD6F0B1EE16B7E966B8", hash_generated_field = "24691869BF8BBA8F28BDB834441D45F0")

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

