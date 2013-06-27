package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.503 -0400", hash_original_field = "E6BA5CF0E40609A434B9830189A5C361", hash_generated_field = "6D2C834A0EA52BA031060A9E0AEE620E")

    String mIfaceName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.503 -0400", hash_original_field = "6AEFC7DC6659B9C6DA99F3CB40F9A569", hash_generated_field = "00DE8BD688F501E4FB5528A63461C364")

    private Collection<LinkAddress> mLinkAddresses = new ArrayList<LinkAddress>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.503 -0400", hash_original_field = "FD91D9D1E504FC4A4ED4F0BB92CA1204", hash_generated_field = "D0EA13350ECE9796647D8145F3FB5864")

    private Collection<InetAddress> mDnses = new ArrayList<InetAddress>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.503 -0400", hash_original_field = "722D48B16FEB25182D36B7B66149CEE2", hash_generated_field = "2D860F9C91CB145D416269098C36EC63")

    private Collection<RouteInfo> mRoutes = new ArrayList<RouteInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.503 -0400", hash_original_field = "333D05D23A1925EB4A47F41C960FCCB0", hash_generated_field = "E6A788E6ED925BAD844282A07CD34FF9")

    private ProxyProperties mHttpProxy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.504 -0400", hash_original_method = "A2AA1798C08A5590A3DB637A5B794F80", hash_generated_method = "61D49920A9252FA3879C7DD8F5F55E1D")
    public  LinkProperties() {
        clear();
        // ---------- Original Method ----------
        //clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.595 -0400", hash_original_method = "836BF23A93C2D960D78EC02574131087", hash_generated_method = "2B9D6B91886D6A2460EF6B4E9BF66913")
    public  LinkProperties(LinkProperties source) {
        {
            mIfaceName = source.getInterfaceName();
            {
                Iterator<LinkAddress> var59DB07A15473864E1C5588C8655CA6E3_1921458013 = (source.getLinkAddresses()).iterator();
                var59DB07A15473864E1C5588C8655CA6E3_1921458013.hasNext();
                LinkAddress l = var59DB07A15473864E1C5588C8655CA6E3_1921458013.next();
                mLinkAddresses.add(l);
            } //End collapsed parenthetic
            {
                Iterator<InetAddress> varAF10DA590F783BAD26DEEDB471E7BD07_822753787 = (source.getDnses()).iterator();
                varAF10DA590F783BAD26DEEDB471E7BD07_822753787.hasNext();
                InetAddress i = varAF10DA590F783BAD26DEEDB471E7BD07_822753787.next();
                mDnses.add(i);
            } //End collapsed parenthetic
            {
                Iterator<RouteInfo> var5AEB519FA22FBA3D61143458993DDC82_1786420225 = (source.getRoutes()).iterator();
                var5AEB519FA22FBA3D61143458993DDC82_1786420225.hasNext();
                RouteInfo r = var5AEB519FA22FBA3D61143458993DDC82_1786420225.next();
                mRoutes.add(r);
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.596 -0400", hash_original_method = "658C71C3CDAAE8BF2A6E808615EC0533", hash_generated_method = "D58C219F5C5992BE6A4B05BFFDE78502")
    public void setInterfaceName(String iface) {
        mIfaceName = iface;
        // ---------- Original Method ----------
        //mIfaceName = iface;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.611 -0400", hash_original_method = "DE3FEB2907F1F43DDDDBA76FC2B5A592", hash_generated_method = "4D81E91BA88F9490C5C57E86593BAA31")
    public String getInterfaceName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1698032595 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1698032595 = mIfaceName;
        varB4EAC82CA7396A68D541C85D26508E83_1698032595.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1698032595;
        // ---------- Original Method ----------
        //return mIfaceName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.627 -0400", hash_original_method = "873086E492F590532E0F956B14530004", hash_generated_method = "682C809A334BC140B1655E4C0CF83C15")
    public Collection<InetAddress> getAddresses() {
        Collection<InetAddress> varB4EAC82CA7396A68D541C85D26508E83_1461001954 = null; //Variable for return #1
        Collection<InetAddress> addresses;
        addresses = new ArrayList<InetAddress>();
        {
            Iterator<LinkAddress> varDF96464DD29D4BD0B0137A05D67E51BB_1798562502 = (mLinkAddresses).iterator();
            varDF96464DD29D4BD0B0137A05D67E51BB_1798562502.hasNext();
            LinkAddress linkAddress = varDF96464DD29D4BD0B0137A05D67E51BB_1798562502.next();
            {
                addresses.add(linkAddress.getAddress());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1461001954 = Collections.unmodifiableCollection(addresses);
        varB4EAC82CA7396A68D541C85D26508E83_1461001954.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1461001954;
        // ---------- Original Method ----------
        //Collection<InetAddress> addresses = new ArrayList<InetAddress>();
        //for (LinkAddress linkAddress : mLinkAddresses) {
            //addresses.add(linkAddress.getAddress());
        //}
        //return Collections.unmodifiableCollection(addresses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.631 -0400", hash_original_method = "1B49E50669A271748C7EE163D2678E87", hash_generated_method = "911CB430011BD1592676CF4A964808BA")
    public void addLinkAddress(LinkAddress address) {
        mLinkAddresses.add(address);
        addTaint(address.getTaint());
        // ---------- Original Method ----------
        //if (address != null) mLinkAddresses.add(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.636 -0400", hash_original_method = "72D86E86409333B5516C160027F12741", hash_generated_method = "C72B3AB36D190E967067B6F67074E656")
    public Collection<LinkAddress> getLinkAddresses() {
        Collection<LinkAddress> varB4EAC82CA7396A68D541C85D26508E83_1616795677 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1616795677 = Collections.unmodifiableCollection(mLinkAddresses);
        varB4EAC82CA7396A68D541C85D26508E83_1616795677.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1616795677;
        // ---------- Original Method ----------
        //return Collections.unmodifiableCollection(mLinkAddresses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.641 -0400", hash_original_method = "34CA5CC4558FA9428BD44173436D0F22", hash_generated_method = "D674353956780C7E1DEA381F7DF5875F")
    public void addDns(InetAddress dns) {
        mDnses.add(dns);
        addTaint(dns.getTaint());
        // ---------- Original Method ----------
        //if (dns != null) mDnses.add(dns);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.642 -0400", hash_original_method = "71F7664B03379576DA51ED6043500785", hash_generated_method = "633DDBE6C7C4362C3285CB6FDACE0DDD")
    public Collection<InetAddress> getDnses() {
        Collection<InetAddress> varB4EAC82CA7396A68D541C85D26508E83_570638379 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_570638379 = Collections.unmodifiableCollection(mDnses);
        varB4EAC82CA7396A68D541C85D26508E83_570638379.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_570638379;
        // ---------- Original Method ----------
        //return Collections.unmodifiableCollection(mDnses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.643 -0400", hash_original_method = "D2F9F5371D010F9C9B4F83D9513356DD", hash_generated_method = "CF497BE7CA790421615629C6965AC22C")
    public void addRoute(RouteInfo route) {
        mRoutes.add(route);
        addTaint(route.getTaint());
        // ---------- Original Method ----------
        //if (route != null) mRoutes.add(route);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.646 -0400", hash_original_method = "A7B26240781BB7C0E135CB45CD0D9800", hash_generated_method = "512E169997EB85E8DC248E2FE13EFF66")
    public Collection<RouteInfo> getRoutes() {
        Collection<RouteInfo> varB4EAC82CA7396A68D541C85D26508E83_1056287487 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1056287487 = Collections.unmodifiableCollection(mRoutes);
        varB4EAC82CA7396A68D541C85D26508E83_1056287487.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1056287487;
        // ---------- Original Method ----------
        //return Collections.unmodifiableCollection(mRoutes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.651 -0400", hash_original_method = "A3A7E4451F64D99820B4BAAEF1AFE8A2", hash_generated_method = "8C961CFF90F31516B337EDFD675E66E4")
    public void setHttpProxy(ProxyProperties proxy) {
        mHttpProxy = proxy;
        // ---------- Original Method ----------
        //mHttpProxy = proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.651 -0400", hash_original_method = "6E571D9EDF02B85B7F325367F981AC91", hash_generated_method = "1794F0206A9F167F4DC918360D242520")
    public ProxyProperties getHttpProxy() {
        ProxyProperties varB4EAC82CA7396A68D541C85D26508E83_1360495891 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1360495891 = mHttpProxy;
        varB4EAC82CA7396A68D541C85D26508E83_1360495891.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1360495891;
        // ---------- Original Method ----------
        //return mHttpProxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.653 -0400", hash_original_method = "4D86E4F145913ECB4C1EE8109466CAB3", hash_generated_method = "A8ED76BD4957AE90AC09315AE270F855")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.673 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "52C6CB5B8A12837D8AB4719FBF99CB84")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1459693208 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1459693208;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.900 -0400", hash_original_method = "FDC9878366ECD283FC0D7411AB5ED4B7", hash_generated_method = "BE7627B32F0AC817F1C0B03F1F69B1FE")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2051511789 = null; //Variable for return #1
        String ifaceName;
        ifaceName = (mIfaceName == null ? "" : "InterfaceName: " + mIfaceName + " ");//DSFIXME:  CODE0008: Nested ternary operator in expression
        String linkAddresses;
        linkAddresses = "LinkAddresses: [";
        {
            Iterator<LinkAddress> varA54DF54142E944DE1695D23EA874915C_1192918490 = (mLinkAddresses).iterator();
            varA54DF54142E944DE1695D23EA874915C_1192918490.hasNext();
            LinkAddress addr = varA54DF54142E944DE1695D23EA874915C_1192918490.next();
            linkAddresses += addr.toString() + ",";
        } //End collapsed parenthetic
        linkAddresses += "] ";
        String dns;
        dns = "DnsAddresses: [";
        {
            Iterator<InetAddress> varF82ABEA2736FEE01B3D433C6A400C80E_1660035927 = (mDnses).iterator();
            varF82ABEA2736FEE01B3D433C6A400C80E_1660035927.hasNext();
            InetAddress addr = varF82ABEA2736FEE01B3D433C6A400C80E_1660035927.next();
            dns += addr.getHostAddress() + ",";
        } //End collapsed parenthetic
        dns += "] ";
        String routes;
        routes = "Routes: [";
        {
            Iterator<RouteInfo> var884AA7CBDA9AFAD5F88BFEB52967F598_1998609678 = (mRoutes).iterator();
            var884AA7CBDA9AFAD5F88BFEB52967F598_1998609678.hasNext();
            RouteInfo route = var884AA7CBDA9AFAD5F88BFEB52967F598_1998609678.next();
            routes += route.toString() + ",";
        } //End collapsed parenthetic
        routes += "] ";
        String proxy;
        proxy = (mHttpProxy == null ? "" : "HttpProxy: " + mHttpProxy.toString() + " ");//DSFIXME:  CODE0008: Nested ternary operator in expression
        varB4EAC82CA7396A68D541C85D26508E83_2051511789 = ifaceName + linkAddresses + routes + dns + proxy;
        varB4EAC82CA7396A68D541C85D26508E83_2051511789.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2051511789;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.917 -0400", hash_original_method = "48DB33246C86C278D2BAD545A88B9470", hash_generated_method = "1A0FB1ED3535029E02FB3C7695AD2850")
    public boolean isIdenticalInterfaceName(LinkProperties target) {
        boolean var6F2AB3D9835C0A270859893D0ED96986_496127634 = (TextUtils.equals(getInterfaceName(), target.getInterfaceName()));
        addTaint(target.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_114624577 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_114624577;
        // ---------- Original Method ----------
        //return TextUtils.equals(getInterfaceName(), target.getInterfaceName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.926 -0400", hash_original_method = "D0F0B04B5ACB5FD8D13B5B828D9A160C", hash_generated_method = "D2247F6243A48DA91F39993E64AC8B2B")
    public boolean isIdenticalAddresses(LinkProperties target) {
        Collection<InetAddress> targetAddresses;
        targetAddresses = target.getAddresses();
        Collection<InetAddress> sourceAddresses;
        sourceAddresses = getAddresses();
        {
            boolean var171F2F84DB8A7D85E1317944C116AFCC_885424360 = ((sourceAddresses.size() == targetAddresses.size()));
            Object varC949C242E33C773B3451D3552B0945BC_359204172 = (sourceAddresses.containsAll(targetAddresses));
        } //End flattened ternary
        addTaint(target.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1018067757 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1018067757;
        // ---------- Original Method ----------
        //Collection<InetAddress> targetAddresses = target.getAddresses();
        //Collection<InetAddress> sourceAddresses = getAddresses();
        //return (sourceAddresses.size() == targetAddresses.size()) ?
                    //sourceAddresses.containsAll(targetAddresses) : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.929 -0400", hash_original_method = "14A4F7F9C3E90075B30F314D9FCFE073", hash_generated_method = "C43970A6F0D0957E1C115C410BAF4DDF")
    public boolean isIdenticalDnses(LinkProperties target) {
        Collection<InetAddress> targetDnses;
        targetDnses = target.getDnses();
        {
            boolean varE3CBC7C3F925563121730FFF5E3D651F_392056655 = ((mDnses.size() == targetDnses.size()));
            Object var09E03C66279AC68D4F5A138A51FD11CA_1699489488 = (mDnses.containsAll(targetDnses));
        } //End flattened ternary
        addTaint(target.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_717539116 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_717539116;
        // ---------- Original Method ----------
        //Collection<InetAddress> targetDnses = target.getDnses();
        //return (mDnses.size() == targetDnses.size()) ?
                    //mDnses.containsAll(targetDnses) : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.949 -0400", hash_original_method = "3C11F6A9D4CB5E313FF4392D544C8E01", hash_generated_method = "4F1AF4E4FFA7C0273855E113EB69DBCF")
    public boolean isIdenticalRoutes(LinkProperties target) {
        Collection<RouteInfo> targetRoutes;
        targetRoutes = target.getRoutes();
        {
            boolean var8A4690F8676279C4E003E24A9E634512_1060779665 = ((mRoutes.size() == targetRoutes.size()));
            Object varFC1EE2679A5375D5CE177F9337267C1C_627964169 = (mRoutes.containsAll(targetRoutes));
        } //End flattened ternary
        addTaint(target.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2061192059 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2061192059;
        // ---------- Original Method ----------
        //Collection<RouteInfo> targetRoutes = target.getRoutes();
        //return (mRoutes.size() == targetRoutes.size()) ?
                    //mRoutes.containsAll(targetRoutes) : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.950 -0400", hash_original_method = "DD4569AF6E08EF8065FD20A93C9D719F", hash_generated_method = "C53766182D17E1B689C91273421681B1")
    public boolean isIdenticalHttpProxy(LinkProperties target) {
        {
            boolean varFBC502E80F6E2ED4131D5F3B922A0FAC_807363843 = (getHttpProxy() == null);
            Object var7FD26D8E5D9A81FA18A194614D9B2D1C_872991073 = (target.getHttpProxy() == null);
            Object var68066F11042D8854D996D502391CDF43_1625321654 = (getHttpProxy().equals(target.getHttpProxy()));
        } //End flattened ternary
        addTaint(target.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1042849411 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1042849411;
        // ---------- Original Method ----------
        //return getHttpProxy() == null ? target.getHttpProxy() == null :
                    //getHttpProxy().equals(target.getHttpProxy());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.952 -0400", hash_original_method = "E1692DB8F3E9AF5A893AE4BBE4FFDED0", hash_generated_method = "304D21503760DA916A44A3671E55E5A8")
    @Override
    public boolean equals(Object obj) {
        LinkProperties target;
        target = (LinkProperties) obj;
        boolean var0154B8A40FDF40E2B692EE07A0C7B198_449922078 = (isIdenticalInterfaceName(target) &&
                isIdenticalAddresses(target) &&
                isIdenticalDnses(target) &&
                isIdenticalRoutes(target) &&
                isIdenticalHttpProxy(target));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_698221996 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_698221996;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.983 -0400", hash_original_method = "F16C063B63526E6739B6C0383B3231A3", hash_generated_method = "383D4A5814279A8FE4FF9F156840B489")
    public CompareResult<LinkAddress> compareAddresses(LinkProperties target) {
        CompareResult<LinkAddress> varB4EAC82CA7396A68D541C85D26508E83_621158511 = null; //Variable for return #1
        CompareResult<LinkAddress> result;
        result = new CompareResult<LinkAddress>();
        result.removed = new ArrayList<LinkAddress>(mLinkAddresses);
        result.added.clear();
        {
            {
                Iterator<LinkAddress> var1CF02BF0C3749BAA471402895ECF294B_1796062342 = (target.getLinkAddresses()).iterator();
                var1CF02BF0C3749BAA471402895ECF294B_1796062342.hasNext();
                LinkAddress newAddress = var1CF02BF0C3749BAA471402895ECF294B_1796062342.next();
                {
                    {
                        boolean varCF42614A09F8D2355BF1BA86279EFF16_1189670447 = (! result.removed.remove(newAddress));
                        {
                            result.added.add(newAddress);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_621158511 = result;
        addTaint(target.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_621158511.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_621158511;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.033 -0400", hash_original_method = "C56C38D458207E713A2F639173CF494C", hash_generated_method = "DDA0E4F756EA3C45C920821806036B20")
    public CompareResult<InetAddress> compareDnses(LinkProperties target) {
        CompareResult<InetAddress> varB4EAC82CA7396A68D541C85D26508E83_321938973 = null; //Variable for return #1
        CompareResult<InetAddress> result;
        result = new CompareResult<InetAddress>();
        result.removed = new ArrayList<InetAddress>(mDnses);
        result.added.clear();
        {
            {
                Iterator<InetAddress> var5D025E9A74EF4251C9BAA6B2C125325C_2075713550 = (target.getDnses()).iterator();
                var5D025E9A74EF4251C9BAA6B2C125325C_2075713550.hasNext();
                InetAddress newAddress = var5D025E9A74EF4251C9BAA6B2C125325C_2075713550.next();
                {
                    {
                        boolean varCF42614A09F8D2355BF1BA86279EFF16_1590480946 = (! result.removed.remove(newAddress));
                        {
                            result.added.add(newAddress);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_321938973 = result;
        addTaint(target.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_321938973.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_321938973;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.070 -0400", hash_original_method = "39063DDD1454993D1B4985089C8FABB6", hash_generated_method = "9DC8F7E42A936EAFEA5362BA43A52364")
    public CompareResult<RouteInfo> compareRoutes(LinkProperties target) {
        CompareResult<RouteInfo> varB4EAC82CA7396A68D541C85D26508E83_1579327771 = null; //Variable for return #1
        CompareResult<RouteInfo> result;
        result = new CompareResult<RouteInfo>();
        result.removed = new ArrayList<RouteInfo>(mRoutes);
        result.added.clear();
        {
            {
                Iterator<RouteInfo> var98E042D986256D5C143CD1D8775297CE_1487007354 = (target.getRoutes()).iterator();
                var98E042D986256D5C143CD1D8775297CE_1487007354.hasNext();
                RouteInfo r = var98E042D986256D5C143CD1D8775297CE_1487007354.next();
                {
                    {
                        boolean varC873CBADB2439759A1631563A981C60B_1832915588 = (! result.removed.remove(r));
                        {
                            result.added.add(r);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1579327771 = result;
        addTaint(target.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1579327771.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1579327771;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.071 -0400", hash_original_method = "28ECE8095E829F4615B9B35514C29B36", hash_generated_method = "C4EAA180344145356A7EDB2B87C99AD9")
    @Override
    public int hashCode() {
        int varE71D32073B9D953373F280788B927A4F_1865357242 = (((null == mIfaceName) ? 0 : mIfaceName.hashCode()
                + mLinkAddresses.size() * 31
                + mDnses.size() * 37
                + mRoutes.size() * 41
                + ((null == mHttpProxy) ? 0 : mHttpProxy.hashCode()))); //DSFIXME:  CODE0008: Nested ternary operator in expression
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_455490362 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_455490362;
        // ---------- Original Method ----------
        //return ((null == mIfaceName) ? 0 : mIfaceName.hashCode()
                //+ mLinkAddresses.size() * 31
                //+ mDnses.size() * 37
                //+ mRoutes.size() * 41
                //+ ((null == mHttpProxy) ? 0 : mHttpProxy.hashCode()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.185 -0400", hash_original_method = "FA484CCA03B27F5C12EABAE629DE360A", hash_generated_method = "A25BDBD6B161F54997E3F8D9C9A88CA2")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getInterfaceName());
        dest.writeInt(mLinkAddresses.size());
        {
            Iterator<LinkAddress> varDF96464DD29D4BD0B0137A05D67E51BB_2002361379 = (mLinkAddresses).iterator();
            varDF96464DD29D4BD0B0137A05D67E51BB_2002361379.hasNext();
            LinkAddress linkAddress = varDF96464DD29D4BD0B0137A05D67E51BB_2002361379.next();
            {
                dest.writeParcelable(linkAddress, flags);
            } //End block
        } //End collapsed parenthetic
        dest.writeInt(mDnses.size());
        {
            Iterator<InetAddress> varD0C0A861F30CBF0FE56B8F003A69B034_307660550 = (mDnses).iterator();
            varD0C0A861F30CBF0FE56B8F003A69B034_307660550.hasNext();
            InetAddress d = varD0C0A861F30CBF0FE56B8F003A69B034_307660550.next();
            {
                dest.writeByteArray(d.getAddress());
            } //End block
        } //End collapsed parenthetic
        dest.writeInt(mRoutes.size());
        {
            Iterator<RouteInfo> var884AA7CBDA9AFAD5F88BFEB52967F598_1969605299 = (mRoutes).iterator();
            var884AA7CBDA9AFAD5F88BFEB52967F598_1969605299.hasNext();
            RouteInfo route = var884AA7CBDA9AFAD5F88BFEB52967F598_1969605299.next();
            {
                dest.writeParcelable(route, flags);
            } //End block
        } //End collapsed parenthetic
        {
            dest.writeByte((byte)1);
            dest.writeParcelable(mHttpProxy, flags);
        } //End block
        {
            dest.writeByte((byte)0);
        } //End block
        addTaint(dest.getTaint());
        addTaint(flags);
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.185 -0400", hash_original_field = "C4B1F39807DCA632860153E967535069", hash_generated_field = "656FE863E184B8E40AE962362C5E65EA")

        public Collection<T> removed = new ArrayList<T>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.186 -0400", hash_original_field = "CB13C543EE6E3E67C92366544BE592A7", hash_generated_field = "C6B74BD881B85CA2CE669431297F84E6")

        public Collection<T> added = new ArrayList<T>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.186 -0400", hash_original_method = "8B9C887FE92C246DB85CDDBCEEBB2CF3", hash_generated_method = "8B9C887FE92C246DB85CDDBCEEBB2CF3")
        public CompareResult ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.272 -0400", hash_original_method = "432CBAB98383F022B31745E1B8881CF6", hash_generated_method = "1F86F87B1E6CBB59D912E3589AD8CB52")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1401576914 = null; //Variable for return #1
            String retVal;
            retVal = "removed=[";
            {
                Iterator<T> varC423D6E3AA0BA108FCAE25E1A62A868B_517878220 = (removed).iterator();
                varC423D6E3AA0BA108FCAE25E1A62A868B_517878220.hasNext();
                T addr = varC423D6E3AA0BA108FCAE25E1A62A868B_517878220.next();
                retVal += addr.toString() + ",";
            } //End collapsed parenthetic
            retVal += "] added=[";
            {
                Iterator<T> var5AD5BD4A6E3B2EEAB3BA044D5B8651B9_1713715802 = (added).iterator();
                var5AD5BD4A6E3B2EEAB3BA044D5B8651B9_1713715802.hasNext();
                T addr = var5AD5BD4A6E3B2EEAB3BA044D5B8651B9_1713715802.next();
                retVal += addr.toString() + ",";
            } //End collapsed parenthetic
            retVal += "]";
            varB4EAC82CA7396A68D541C85D26508E83_1401576914 = retVal;
            varB4EAC82CA7396A68D541C85D26508E83_1401576914.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1401576914;
            // ---------- Original Method ----------
            //String retVal = "removed=[";
            //for (T addr : removed) retVal += addr.toString() + ",";
            //retVal += "] added=[";
            //for (T addr : added) retVal += addr.toString() + ",";
            //retVal += "]";
            //return retVal;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.272 -0400", hash_original_field = "AD9F190960A42BD6F0B1EE16B7E966B8", hash_generated_field = "24691869BF8BBA8F28BDB834441D45F0")

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
}

