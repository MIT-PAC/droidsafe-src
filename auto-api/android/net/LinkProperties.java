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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.290 -0400", hash_original_field = "E6BA5CF0E40609A434B9830189A5C361", hash_generated_field = "6D2C834A0EA52BA031060A9E0AEE620E")

    String mIfaceName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.290 -0400", hash_original_field = "6AEFC7DC6659B9C6DA99F3CB40F9A569", hash_generated_field = "00DE8BD688F501E4FB5528A63461C364")

    private Collection<LinkAddress> mLinkAddresses = new ArrayList<LinkAddress>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.290 -0400", hash_original_field = "FD91D9D1E504FC4A4ED4F0BB92CA1204", hash_generated_field = "D0EA13350ECE9796647D8145F3FB5864")

    private Collection<InetAddress> mDnses = new ArrayList<InetAddress>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.290 -0400", hash_original_field = "722D48B16FEB25182D36B7B66149CEE2", hash_generated_field = "2D860F9C91CB145D416269098C36EC63")

    private Collection<RouteInfo> mRoutes = new ArrayList<RouteInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.290 -0400", hash_original_field = "333D05D23A1925EB4A47F41C960FCCB0", hash_generated_field = "E6A788E6ED925BAD844282A07CD34FF9")

    private ProxyProperties mHttpProxy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.291 -0400", hash_original_method = "A2AA1798C08A5590A3DB637A5B794F80", hash_generated_method = "61D49920A9252FA3879C7DD8F5F55E1D")
    public  LinkProperties() {
        clear();
        // ---------- Original Method ----------
        //clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.396 -0400", hash_original_method = "836BF23A93C2D960D78EC02574131087", hash_generated_method = "A460FFEAB6DE1FD242CB78E1AF1478C6")
    public  LinkProperties(LinkProperties source) {
        {
            mIfaceName = source.getInterfaceName();
            {
                Iterator<LinkAddress> var59DB07A15473864E1C5588C8655CA6E3_1066440019 = (source.getLinkAddresses()).iterator();
                var59DB07A15473864E1C5588C8655CA6E3_1066440019.hasNext();
                LinkAddress l = var59DB07A15473864E1C5588C8655CA6E3_1066440019.next();
                mLinkAddresses.add(l);
            } //End collapsed parenthetic
            {
                Iterator<InetAddress> varAF10DA590F783BAD26DEEDB471E7BD07_1836793669 = (source.getDnses()).iterator();
                varAF10DA590F783BAD26DEEDB471E7BD07_1836793669.hasNext();
                InetAddress i = varAF10DA590F783BAD26DEEDB471E7BD07_1836793669.next();
                mDnses.add(i);
            } //End collapsed parenthetic
            {
                Iterator<RouteInfo> var5AEB519FA22FBA3D61143458993DDC82_1827343793 = (source.getRoutes()).iterator();
                var5AEB519FA22FBA3D61143458993DDC82_1827343793.hasNext();
                RouteInfo r = var5AEB519FA22FBA3D61143458993DDC82_1827343793.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.396 -0400", hash_original_method = "658C71C3CDAAE8BF2A6E808615EC0533", hash_generated_method = "D58C219F5C5992BE6A4B05BFFDE78502")
    public void setInterfaceName(String iface) {
        mIfaceName = iface;
        // ---------- Original Method ----------
        //mIfaceName = iface;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.397 -0400", hash_original_method = "DE3FEB2907F1F43DDDDBA76FC2B5A592", hash_generated_method = "9FE45D8FE0ED7CA95FB45BBB0B081BF1")
    public String getInterfaceName() {
        String varB4EAC82CA7396A68D541C85D26508E83_2069858299 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2069858299 = mIfaceName;
        varB4EAC82CA7396A68D541C85D26508E83_2069858299.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2069858299;
        // ---------- Original Method ----------
        //return mIfaceName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.430 -0400", hash_original_method = "873086E492F590532E0F956B14530004", hash_generated_method = "A563D0D33A5FA8F8E764FBD38C1E21FE")
    public Collection<InetAddress> getAddresses() {
        Collection<InetAddress> varB4EAC82CA7396A68D541C85D26508E83_493927600 = null; //Variable for return #1
        Collection<InetAddress> addresses;
        addresses = new ArrayList<InetAddress>();
        {
            Iterator<LinkAddress> varDF96464DD29D4BD0B0137A05D67E51BB_97837081 = (mLinkAddresses).iterator();
            varDF96464DD29D4BD0B0137A05D67E51BB_97837081.hasNext();
            LinkAddress linkAddress = varDF96464DD29D4BD0B0137A05D67E51BB_97837081.next();
            {
                addresses.add(linkAddress.getAddress());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_493927600 = Collections.unmodifiableCollection(addresses);
        varB4EAC82CA7396A68D541C85D26508E83_493927600.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_493927600;
        // ---------- Original Method ----------
        //Collection<InetAddress> addresses = new ArrayList<InetAddress>();
        //for (LinkAddress linkAddress : mLinkAddresses) {
            //addresses.add(linkAddress.getAddress());
        //}
        //return Collections.unmodifiableCollection(addresses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.431 -0400", hash_original_method = "1B49E50669A271748C7EE163D2678E87", hash_generated_method = "911CB430011BD1592676CF4A964808BA")
    public void addLinkAddress(LinkAddress address) {
        mLinkAddresses.add(address);
        addTaint(address.getTaint());
        // ---------- Original Method ----------
        //if (address != null) mLinkAddresses.add(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.443 -0400", hash_original_method = "72D86E86409333B5516C160027F12741", hash_generated_method = "956E0B877C0B06337073231FC89928AB")
    public Collection<LinkAddress> getLinkAddresses() {
        Collection<LinkAddress> varB4EAC82CA7396A68D541C85D26508E83_1579845377 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1579845377 = Collections.unmodifiableCollection(mLinkAddresses);
        varB4EAC82CA7396A68D541C85D26508E83_1579845377.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1579845377;
        // ---------- Original Method ----------
        //return Collections.unmodifiableCollection(mLinkAddresses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.443 -0400", hash_original_method = "34CA5CC4558FA9428BD44173436D0F22", hash_generated_method = "D674353956780C7E1DEA381F7DF5875F")
    public void addDns(InetAddress dns) {
        mDnses.add(dns);
        addTaint(dns.getTaint());
        // ---------- Original Method ----------
        //if (dns != null) mDnses.add(dns);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.444 -0400", hash_original_method = "71F7664B03379576DA51ED6043500785", hash_generated_method = "4AF99A26B13A6D242669DE5A85C420E4")
    public Collection<InetAddress> getDnses() {
        Collection<InetAddress> varB4EAC82CA7396A68D541C85D26508E83_2126888562 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2126888562 = Collections.unmodifiableCollection(mDnses);
        varB4EAC82CA7396A68D541C85D26508E83_2126888562.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2126888562;
        // ---------- Original Method ----------
        //return Collections.unmodifiableCollection(mDnses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.445 -0400", hash_original_method = "D2F9F5371D010F9C9B4F83D9513356DD", hash_generated_method = "CF497BE7CA790421615629C6965AC22C")
    public void addRoute(RouteInfo route) {
        mRoutes.add(route);
        addTaint(route.getTaint());
        // ---------- Original Method ----------
        //if (route != null) mRoutes.add(route);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.445 -0400", hash_original_method = "A7B26240781BB7C0E135CB45CD0D9800", hash_generated_method = "16754EAA1FA392BF6B8346C118988312")
    public Collection<RouteInfo> getRoutes() {
        Collection<RouteInfo> varB4EAC82CA7396A68D541C85D26508E83_1209708207 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1209708207 = Collections.unmodifiableCollection(mRoutes);
        varB4EAC82CA7396A68D541C85D26508E83_1209708207.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1209708207;
        // ---------- Original Method ----------
        //return Collections.unmodifiableCollection(mRoutes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.446 -0400", hash_original_method = "A3A7E4451F64D99820B4BAAEF1AFE8A2", hash_generated_method = "8C961CFF90F31516B337EDFD675E66E4")
    public void setHttpProxy(ProxyProperties proxy) {
        mHttpProxy = proxy;
        // ---------- Original Method ----------
        //mHttpProxy = proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.460 -0400", hash_original_method = "6E571D9EDF02B85B7F325367F981AC91", hash_generated_method = "593623EDC29C7583436530DE0298598D")
    public ProxyProperties getHttpProxy() {
        ProxyProperties varB4EAC82CA7396A68D541C85D26508E83_1309499150 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1309499150 = mHttpProxy;
        varB4EAC82CA7396A68D541C85D26508E83_1309499150.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1309499150;
        // ---------- Original Method ----------
        //return mHttpProxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.461 -0400", hash_original_method = "4D86E4F145913ECB4C1EE8109466CAB3", hash_generated_method = "A8ED76BD4957AE90AC09315AE270F855")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.461 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "1EC3EEBF45EA452A40D627F0CAD507B6")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2093329513 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2093329513;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.628 -0400", hash_original_method = "FDC9878366ECD283FC0D7411AB5ED4B7", hash_generated_method = "48F2C52B33D35E15108165518D53E2EB")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1679979035 = null; //Variable for return #1
        String ifaceName;
        ifaceName = (mIfaceName == null ? "" : "InterfaceName: " + mIfaceName + " ");//DSFIXME:  CODE0008: Nested ternary operator in expression
        String linkAddresses;
        linkAddresses = "LinkAddresses: [";
        {
            Iterator<LinkAddress> varA54DF54142E944DE1695D23EA874915C_533191123 = (mLinkAddresses).iterator();
            varA54DF54142E944DE1695D23EA874915C_533191123.hasNext();
            LinkAddress addr = varA54DF54142E944DE1695D23EA874915C_533191123.next();
            linkAddresses += addr.toString() + ",";
        } //End collapsed parenthetic
        linkAddresses += "] ";
        String dns;
        dns = "DnsAddresses: [";
        {
            Iterator<InetAddress> varF82ABEA2736FEE01B3D433C6A400C80E_80058942 = (mDnses).iterator();
            varF82ABEA2736FEE01B3D433C6A400C80E_80058942.hasNext();
            InetAddress addr = varF82ABEA2736FEE01B3D433C6A400C80E_80058942.next();
            dns += addr.getHostAddress() + ",";
        } //End collapsed parenthetic
        dns += "] ";
        String routes;
        routes = "Routes: [";
        {
            Iterator<RouteInfo> var884AA7CBDA9AFAD5F88BFEB52967F598_1561090356 = (mRoutes).iterator();
            var884AA7CBDA9AFAD5F88BFEB52967F598_1561090356.hasNext();
            RouteInfo route = var884AA7CBDA9AFAD5F88BFEB52967F598_1561090356.next();
            routes += route.toString() + ",";
        } //End collapsed parenthetic
        routes += "] ";
        String proxy;
        proxy = (mHttpProxy == null ? "" : "HttpProxy: " + mHttpProxy.toString() + " ");//DSFIXME:  CODE0008: Nested ternary operator in expression
        varB4EAC82CA7396A68D541C85D26508E83_1679979035 = ifaceName + linkAddresses + routes + dns + proxy;
        varB4EAC82CA7396A68D541C85D26508E83_1679979035.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1679979035;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.642 -0400", hash_original_method = "48DB33246C86C278D2BAD545A88B9470", hash_generated_method = "78EDE4AA488D54E3EE554A74B5E6DCEF")
    public boolean isIdenticalInterfaceName(LinkProperties target) {
        boolean var6F2AB3D9835C0A270859893D0ED96986_55840904 = (TextUtils.equals(getInterfaceName(), target.getInterfaceName()));
        addTaint(target.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_898548392 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_898548392;
        // ---------- Original Method ----------
        //return TextUtils.equals(getInterfaceName(), target.getInterfaceName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.644 -0400", hash_original_method = "D0F0B04B5ACB5FD8D13B5B828D9A160C", hash_generated_method = "ADDF56197D93414FFCD5F587C4F071B1")
    public boolean isIdenticalAddresses(LinkProperties target) {
        Collection<InetAddress> targetAddresses;
        targetAddresses = target.getAddresses();
        Collection<InetAddress> sourceAddresses;
        sourceAddresses = getAddresses();
        {
            boolean var171F2F84DB8A7D85E1317944C116AFCC_1080874027 = ((sourceAddresses.size() == targetAddresses.size()));
            Object varC949C242E33C773B3451D3552B0945BC_685553037 = (sourceAddresses.containsAll(targetAddresses));
        } //End flattened ternary
        addTaint(target.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_632396482 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_632396482;
        // ---------- Original Method ----------
        //Collection<InetAddress> targetAddresses = target.getAddresses();
        //Collection<InetAddress> sourceAddresses = getAddresses();
        //return (sourceAddresses.size() == targetAddresses.size()) ?
                    //sourceAddresses.containsAll(targetAddresses) : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.658 -0400", hash_original_method = "14A4F7F9C3E90075B30F314D9FCFE073", hash_generated_method = "50CB0DF44E3948DFB003C2F9ADD48F6D")
    public boolean isIdenticalDnses(LinkProperties target) {
        Collection<InetAddress> targetDnses;
        targetDnses = target.getDnses();
        {
            boolean varE3CBC7C3F925563121730FFF5E3D651F_184659426 = ((mDnses.size() == targetDnses.size()));
            Object var09E03C66279AC68D4F5A138A51FD11CA_730762701 = (mDnses.containsAll(targetDnses));
        } //End flattened ternary
        addTaint(target.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_453137921 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_453137921;
        // ---------- Original Method ----------
        //Collection<InetAddress> targetDnses = target.getDnses();
        //return (mDnses.size() == targetDnses.size()) ?
                    //mDnses.containsAll(targetDnses) : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.660 -0400", hash_original_method = "3C11F6A9D4CB5E313FF4392D544C8E01", hash_generated_method = "CCEE42749643321AF47E31EB05F4E42B")
    public boolean isIdenticalRoutes(LinkProperties target) {
        Collection<RouteInfo> targetRoutes;
        targetRoutes = target.getRoutes();
        {
            boolean var8A4690F8676279C4E003E24A9E634512_911244502 = ((mRoutes.size() == targetRoutes.size()));
            Object varFC1EE2679A5375D5CE177F9337267C1C_1068800799 = (mRoutes.containsAll(targetRoutes));
        } //End flattened ternary
        addTaint(target.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_575770380 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_575770380;
        // ---------- Original Method ----------
        //Collection<RouteInfo> targetRoutes = target.getRoutes();
        //return (mRoutes.size() == targetRoutes.size()) ?
                    //mRoutes.containsAll(targetRoutes) : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.669 -0400", hash_original_method = "DD4569AF6E08EF8065FD20A93C9D719F", hash_generated_method = "0CFEEC0BBFF0B25F4D97622BB50BDDE7")
    public boolean isIdenticalHttpProxy(LinkProperties target) {
        {
            boolean varFBC502E80F6E2ED4131D5F3B922A0FAC_2018685073 = (getHttpProxy() == null);
            Object var7FD26D8E5D9A81FA18A194614D9B2D1C_1365611472 = (target.getHttpProxy() == null);
            Object var68066F11042D8854D996D502391CDF43_679895555 = (getHttpProxy().equals(target.getHttpProxy()));
        } //End flattened ternary
        addTaint(target.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1393644258 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1393644258;
        // ---------- Original Method ----------
        //return getHttpProxy() == null ? target.getHttpProxy() == null :
                    //getHttpProxy().equals(target.getHttpProxy());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.686 -0400", hash_original_method = "E1692DB8F3E9AF5A893AE4BBE4FFDED0", hash_generated_method = "238FDC524D3EEDAD374A638A20AF55E1")
    @Override
    public boolean equals(Object obj) {
        LinkProperties target;
        target = (LinkProperties) obj;
        boolean var0154B8A40FDF40E2B692EE07A0C7B198_202028160 = (isIdenticalInterfaceName(target) &&
                isIdenticalAddresses(target) &&
                isIdenticalDnses(target) &&
                isIdenticalRoutes(target) &&
                isIdenticalHttpProxy(target));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_145150597 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_145150597;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.712 -0400", hash_original_method = "F16C063B63526E6739B6C0383B3231A3", hash_generated_method = "C61D86C88EA22D7C6E02812ED546413C")
    public CompareResult<LinkAddress> compareAddresses(LinkProperties target) {
        CompareResult<LinkAddress> varB4EAC82CA7396A68D541C85D26508E83_1322379513 = null; //Variable for return #1
        CompareResult<LinkAddress> result;
        result = new CompareResult<LinkAddress>();
        result.removed = new ArrayList<LinkAddress>(mLinkAddresses);
        result.added.clear();
        {
            {
                Iterator<LinkAddress> var1CF02BF0C3749BAA471402895ECF294B_1270059489 = (target.getLinkAddresses()).iterator();
                var1CF02BF0C3749BAA471402895ECF294B_1270059489.hasNext();
                LinkAddress newAddress = var1CF02BF0C3749BAA471402895ECF294B_1270059489.next();
                {
                    {
                        boolean varCF42614A09F8D2355BF1BA86279EFF16_352047287 = (! result.removed.remove(newAddress));
                        {
                            result.added.add(newAddress);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1322379513 = result;
        addTaint(target.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1322379513.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1322379513;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.769 -0400", hash_original_method = "C56C38D458207E713A2F639173CF494C", hash_generated_method = "EACC5FB4AB932DAFA1AF53D28B921F43")
    public CompareResult<InetAddress> compareDnses(LinkProperties target) {
        CompareResult<InetAddress> varB4EAC82CA7396A68D541C85D26508E83_1199725675 = null; //Variable for return #1
        CompareResult<InetAddress> result;
        result = new CompareResult<InetAddress>();
        result.removed = new ArrayList<InetAddress>(mDnses);
        result.added.clear();
        {
            {
                Iterator<InetAddress> var5D025E9A74EF4251C9BAA6B2C125325C_1879015229 = (target.getDnses()).iterator();
                var5D025E9A74EF4251C9BAA6B2C125325C_1879015229.hasNext();
                InetAddress newAddress = var5D025E9A74EF4251C9BAA6B2C125325C_1879015229.next();
                {
                    {
                        boolean varCF42614A09F8D2355BF1BA86279EFF16_1694966489 = (! result.removed.remove(newAddress));
                        {
                            result.added.add(newAddress);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1199725675 = result;
        addTaint(target.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1199725675.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1199725675;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.886 -0400", hash_original_method = "39063DDD1454993D1B4985089C8FABB6", hash_generated_method = "915806FC6BBB24CD66D5E78D82E355DB")
    public CompareResult<RouteInfo> compareRoutes(LinkProperties target) {
        CompareResult<RouteInfo> varB4EAC82CA7396A68D541C85D26508E83_1580787157 = null; //Variable for return #1
        CompareResult<RouteInfo> result;
        result = new CompareResult<RouteInfo>();
        result.removed = new ArrayList<RouteInfo>(mRoutes);
        result.added.clear();
        {
            {
                Iterator<RouteInfo> var98E042D986256D5C143CD1D8775297CE_714218834 = (target.getRoutes()).iterator();
                var98E042D986256D5C143CD1D8775297CE_714218834.hasNext();
                RouteInfo r = var98E042D986256D5C143CD1D8775297CE_714218834.next();
                {
                    {
                        boolean varC873CBADB2439759A1631563A981C60B_1031910245 = (! result.removed.remove(r));
                        {
                            result.added.add(r);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1580787157 = result;
        addTaint(target.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1580787157.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1580787157;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.888 -0400", hash_original_method = "28ECE8095E829F4615B9B35514C29B36", hash_generated_method = "4DE259C236D380E97E34C3D17E940AAD")
    @Override
    public int hashCode() {
        int varE71D32073B9D953373F280788B927A4F_93170379 = (((null == mIfaceName) ? 0 : mIfaceName.hashCode()
                + mLinkAddresses.size() * 31
                + mDnses.size() * 37
                + mRoutes.size() * 41
                + ((null == mHttpProxy) ? 0 : mHttpProxy.hashCode()))); //DSFIXME:  CODE0008: Nested ternary operator in expression
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_152545612 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_152545612;
        // ---------- Original Method ----------
        //return ((null == mIfaceName) ? 0 : mIfaceName.hashCode()
                //+ mLinkAddresses.size() * 31
                //+ mDnses.size() * 37
                //+ mRoutes.size() * 41
                //+ ((null == mHttpProxy) ? 0 : mHttpProxy.hashCode()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.054 -0400", hash_original_method = "FA484CCA03B27F5C12EABAE629DE360A", hash_generated_method = "76B3574A5F63FBFC1AB3E2E4028C8290")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getInterfaceName());
        dest.writeInt(mLinkAddresses.size());
        {
            Iterator<LinkAddress> varDF96464DD29D4BD0B0137A05D67E51BB_683874365 = (mLinkAddresses).iterator();
            varDF96464DD29D4BD0B0137A05D67E51BB_683874365.hasNext();
            LinkAddress linkAddress = varDF96464DD29D4BD0B0137A05D67E51BB_683874365.next();
            {
                dest.writeParcelable(linkAddress, flags);
            } //End block
        } //End collapsed parenthetic
        dest.writeInt(mDnses.size());
        {
            Iterator<InetAddress> varD0C0A861F30CBF0FE56B8F003A69B034_1002450131 = (mDnses).iterator();
            varD0C0A861F30CBF0FE56B8F003A69B034_1002450131.hasNext();
            InetAddress d = varD0C0A861F30CBF0FE56B8F003A69B034_1002450131.next();
            {
                dest.writeByteArray(d.getAddress());
            } //End block
        } //End collapsed parenthetic
        dest.writeInt(mRoutes.size());
        {
            Iterator<RouteInfo> var884AA7CBDA9AFAD5F88BFEB52967F598_540130479 = (mRoutes).iterator();
            var884AA7CBDA9AFAD5F88BFEB52967F598_540130479.hasNext();
            RouteInfo route = var884AA7CBDA9AFAD5F88BFEB52967F598_540130479.next();
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.054 -0400", hash_original_field = "C4B1F39807DCA632860153E967535069", hash_generated_field = "656FE863E184B8E40AE962362C5E65EA")

        public Collection<T> removed = new ArrayList<T>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.054 -0400", hash_original_field = "CB13C543EE6E3E67C92366544BE592A7", hash_generated_field = "C6B74BD881B85CA2CE669431297F84E6")

        public Collection<T> added = new ArrayList<T>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.054 -0400", hash_original_method = "8B9C887FE92C246DB85CDDBCEEBB2CF3", hash_generated_method = "8B9C887FE92C246DB85CDDBCEEBB2CF3")
        public CompareResult ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.166 -0400", hash_original_method = "432CBAB98383F022B31745E1B8881CF6", hash_generated_method = "685D58A8CD766011150DE491AA9E2EE1")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1322250010 = null; //Variable for return #1
            String retVal;
            retVal = "removed=[";
            {
                Iterator<T> varC423D6E3AA0BA108FCAE25E1A62A868B_940396451 = (removed).iterator();
                varC423D6E3AA0BA108FCAE25E1A62A868B_940396451.hasNext();
                T addr = varC423D6E3AA0BA108FCAE25E1A62A868B_940396451.next();
                retVal += addr.toString() + ",";
            } //End collapsed parenthetic
            retVal += "] added=[";
            {
                Iterator<T> var5AD5BD4A6E3B2EEAB3BA044D5B8651B9_580269884 = (added).iterator();
                var5AD5BD4A6E3B2EEAB3BA044D5B8651B9_580269884.hasNext();
                T addr = var5AD5BD4A6E3B2EEAB3BA044D5B8651B9_580269884.next();
                retVal += addr.toString() + ",";
            } //End collapsed parenthetic
            retVal += "]";
            varB4EAC82CA7396A68D541C85D26508E83_1322250010 = retVal;
            varB4EAC82CA7396A68D541C85D26508E83_1322250010.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1322250010;
            // ---------- Original Method ----------
            //String retVal = "removed=[";
            //for (T addr : removed) retVal += addr.toString() + ",";
            //retVal += "] added=[";
            //for (T addr : added) retVal += addr.toString() + ",";
            //retVal += "]";
            //return retVal;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.166 -0400", hash_original_field = "AD9F190960A42BD6F0B1EE16B7E966B8", hash_generated_field = "24691869BF8BBA8F28BDB834441D45F0")

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

