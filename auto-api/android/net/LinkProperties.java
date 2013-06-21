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
    String mIfaceName;
    private Collection<LinkAddress> mLinkAddresses = new ArrayList<LinkAddress>();
    private Collection<InetAddress> mDnses = new ArrayList<InetAddress>();
    private Collection<RouteInfo> mRoutes = new ArrayList<RouteInfo>();
    private ProxyProperties mHttpProxy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.887 -0400", hash_original_method = "A2AA1798C08A5590A3DB637A5B794F80", hash_generated_method = "61D49920A9252FA3879C7DD8F5F55E1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkProperties() {
        clear();
        // ---------- Original Method ----------
        //clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.892 -0400", hash_original_method = "836BF23A93C2D960D78EC02574131087", hash_generated_method = "31C34F9B0615982AD9D6E85E1A348A70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkProperties(LinkProperties source) {
        dsTaint.addTaint(source.dsTaint);
        {
            mIfaceName = source.getInterfaceName();
            {
                Iterator<LinkAddress> var59DB07A15473864E1C5588C8655CA6E3_502786129 = (source.getLinkAddresses()).iterator();
                var59DB07A15473864E1C5588C8655CA6E3_502786129.hasNext();
                LinkAddress l = var59DB07A15473864E1C5588C8655CA6E3_502786129.next();
                mLinkAddresses.add(l);
            } //End collapsed parenthetic
            {
                Iterator<InetAddress> varAF10DA590F783BAD26DEEDB471E7BD07_1702118998 = (source.getDnses()).iterator();
                varAF10DA590F783BAD26DEEDB471E7BD07_1702118998.hasNext();
                InetAddress i = varAF10DA590F783BAD26DEEDB471E7BD07_1702118998.next();
                mDnses.add(i);
            } //End collapsed parenthetic
            {
                Iterator<RouteInfo> var5AEB519FA22FBA3D61143458993DDC82_725953120 = (source.getRoutes()).iterator();
                var5AEB519FA22FBA3D61143458993DDC82_725953120.hasNext();
                RouteInfo r = var5AEB519FA22FBA3D61143458993DDC82_725953120.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.892 -0400", hash_original_method = "658C71C3CDAAE8BF2A6E808615EC0533", hash_generated_method = "6769CFBC2B1EC395DD5741EEFAB0DE68")
    @DSModeled(DSC.SAFE)
    public void setInterfaceName(String iface) {
        dsTaint.addTaint(iface);
        // ---------- Original Method ----------
        //mIfaceName = iface;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.893 -0400", hash_original_method = "DE3FEB2907F1F43DDDDBA76FC2B5A592", hash_generated_method = "6F7C5C83CEFB70D0F1EC8578D24206B7")
    @DSModeled(DSC.SAFE)
    public String getInterfaceName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mIfaceName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.894 -0400", hash_original_method = "873086E492F590532E0F956B14530004", hash_generated_method = "BB96550F613DC56A03E3D33494A95449")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<InetAddress> getAddresses() {
        Collection<InetAddress> addresses;
        addresses = new ArrayList<InetAddress>();
        {
            Iterator<LinkAddress> varDF96464DD29D4BD0B0137A05D67E51BB_374363623 = (mLinkAddresses).iterator();
            varDF96464DD29D4BD0B0137A05D67E51BB_374363623.hasNext();
            LinkAddress linkAddress = varDF96464DD29D4BD0B0137A05D67E51BB_374363623.next();
            {
                addresses.add(linkAddress.getAddress());
            } //End block
        } //End collapsed parenthetic
        Collection<InetAddress> varDFB04F28F130C4EA44091020FD08E9A2_42453730 = (Collections.unmodifiableCollection(addresses));
        return (Collection<InetAddress>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Collection<InetAddress> addresses = new ArrayList<InetAddress>();
        //for (LinkAddress linkAddress : mLinkAddresses) {
            //addresses.add(linkAddress.getAddress());
        //}
        //return Collections.unmodifiableCollection(addresses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.895 -0400", hash_original_method = "1B49E50669A271748C7EE163D2678E87", hash_generated_method = "FF4C364878586E522A297B0DD48A9CE5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addLinkAddress(LinkAddress address) {
        dsTaint.addTaint(address.dsTaint);
        mLinkAddresses.add(address);
        // ---------- Original Method ----------
        //if (address != null) mLinkAddresses.add(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.895 -0400", hash_original_method = "72D86E86409333B5516C160027F12741", hash_generated_method = "622B6AFEA8DC3CA9217788A9B50CF191")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<LinkAddress> getLinkAddresses() {
        Collection<LinkAddress> varC3E793C4D5AF361A2C1AC6DB8EFBAB36_973520286 = (Collections.unmodifiableCollection(mLinkAddresses));
        return (Collection<LinkAddress>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Collections.unmodifiableCollection(mLinkAddresses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.895 -0400", hash_original_method = "34CA5CC4558FA9428BD44173436D0F22", hash_generated_method = "D56CED5EF91DB0FB21EB2E18183EC3E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addDns(InetAddress dns) {
        dsTaint.addTaint(dns.dsTaint);
        mDnses.add(dns);
        // ---------- Original Method ----------
        //if (dns != null) mDnses.add(dns);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.895 -0400", hash_original_method = "71F7664B03379576DA51ED6043500785", hash_generated_method = "283DAA8993795BAF0909CC395E7C30D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<InetAddress> getDnses() {
        Collection<InetAddress> var55A6126CFAA0F65F2C26620090D813AD_106993268 = (Collections.unmodifiableCollection(mDnses));
        return (Collection<InetAddress>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Collections.unmodifiableCollection(mDnses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.896 -0400", hash_original_method = "D2F9F5371D010F9C9B4F83D9513356DD", hash_generated_method = "91A949C4C221CFEC1ABA9B1433ABA4C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addRoute(RouteInfo route) {
        dsTaint.addTaint(route.dsTaint);
        mRoutes.add(route);
        // ---------- Original Method ----------
        //if (route != null) mRoutes.add(route);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.896 -0400", hash_original_method = "A7B26240781BB7C0E135CB45CD0D9800", hash_generated_method = "3F7B3D36BC4AFAEBD9968FB4ECE728E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<RouteInfo> getRoutes() {
        Collection<RouteInfo> var9703EB08BD311C538B60DEDA6370A838_876057174 = (Collections.unmodifiableCollection(mRoutes));
        return (Collection<RouteInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Collections.unmodifiableCollection(mRoutes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.896 -0400", hash_original_method = "A3A7E4451F64D99820B4BAAEF1AFE8A2", hash_generated_method = "D1E68ADDC6BE3A95805C7BE20ED532AD")
    @DSModeled(DSC.SAFE)
    public void setHttpProxy(ProxyProperties proxy) {
        dsTaint.addTaint(proxy.dsTaint);
        // ---------- Original Method ----------
        //mHttpProxy = proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.897 -0400", hash_original_method = "6E571D9EDF02B85B7F325367F981AC91", hash_generated_method = "56149B4FA298874DDCFC40B47B93595B")
    @DSModeled(DSC.SAFE)
    public ProxyProperties getHttpProxy() {
        return (ProxyProperties)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mHttpProxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.897 -0400", hash_original_method = "4D86E4F145913ECB4C1EE8109466CAB3", hash_generated_method = "A8ED76BD4957AE90AC09315AE270F855")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.897 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.927 -0400", hash_original_method = "FDC9878366ECD283FC0D7411AB5ED4B7", hash_generated_method = "0FCCD85980BED373BF2C747F2026BD78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String ifaceName;
        ifaceName = (mIfaceName == null ? "" : "InterfaceName: " + mIfaceName + " ");//DSFIXME:  CODE0008: Nested ternary operator in expression
        String linkAddresses;
        linkAddresses = "LinkAddresses: [";
        {
            Iterator<LinkAddress> varA54DF54142E944DE1695D23EA874915C_1446362079 = (mLinkAddresses).iterator();
            varA54DF54142E944DE1695D23EA874915C_1446362079.hasNext();
            LinkAddress addr = varA54DF54142E944DE1695D23EA874915C_1446362079.next();
            linkAddresses += addr.toString() + ",";
        } //End collapsed parenthetic
        linkAddresses += "] ";
        String dns;
        dns = "DnsAddresses: [";
        {
            Iterator<InetAddress> varF82ABEA2736FEE01B3D433C6A400C80E_402152844 = (mDnses).iterator();
            varF82ABEA2736FEE01B3D433C6A400C80E_402152844.hasNext();
            InetAddress addr = varF82ABEA2736FEE01B3D433C6A400C80E_402152844.next();
            dns += addr.getHostAddress() + ",";
        } //End collapsed parenthetic
        dns += "] ";
        String routes;
        routes = "Routes: [";
        {
            Iterator<RouteInfo> var884AA7CBDA9AFAD5F88BFEB52967F598_506864905 = (mRoutes).iterator();
            var884AA7CBDA9AFAD5F88BFEB52967F598_506864905.hasNext();
            RouteInfo route = var884AA7CBDA9AFAD5F88BFEB52967F598_506864905.next();
            routes += route.toString() + ",";
        } //End collapsed parenthetic
        routes += "] ";
        String proxy;
        proxy = (mHttpProxy == null ? "" : "HttpProxy: " + mHttpProxy.toString() + " ");//DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.928 -0400", hash_original_method = "48DB33246C86C278D2BAD545A88B9470", hash_generated_method = "CF022120DE25149197C8310A3E412A29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isIdenticalInterfaceName(LinkProperties target) {
        dsTaint.addTaint(target.dsTaint);
        boolean var6F2AB3D9835C0A270859893D0ED96986_1778863984 = (TextUtils.equals(getInterfaceName(), target.getInterfaceName()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return TextUtils.equals(getInterfaceName(), target.getInterfaceName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.930 -0400", hash_original_method = "D0F0B04B5ACB5FD8D13B5B828D9A160C", hash_generated_method = "D415222DEEDF317832F9DE4553D95FFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isIdenticalAddresses(LinkProperties target) {
        dsTaint.addTaint(target.dsTaint);
        Collection<InetAddress> targetAddresses;
        targetAddresses = target.getAddresses();
        Collection<InetAddress> sourceAddresses;
        sourceAddresses = getAddresses();
        {
            boolean var171F2F84DB8A7D85E1317944C116AFCC_816057998 = ((sourceAddresses.size() == targetAddresses.size()));
            Object varC949C242E33C773B3451D3552B0945BC_1489272117 = (sourceAddresses.containsAll(targetAddresses));
        } //End flattened ternary
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Collection<InetAddress> targetAddresses = target.getAddresses();
        //Collection<InetAddress> sourceAddresses = getAddresses();
        //return (sourceAddresses.size() == targetAddresses.size()) ?
                    //sourceAddresses.containsAll(targetAddresses) : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.931 -0400", hash_original_method = "14A4F7F9C3E90075B30F314D9FCFE073", hash_generated_method = "FF326DDD36553F241769B364CBDC0E6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isIdenticalDnses(LinkProperties target) {
        dsTaint.addTaint(target.dsTaint);
        Collection<InetAddress> targetDnses;
        targetDnses = target.getDnses();
        {
            boolean varE3CBC7C3F925563121730FFF5E3D651F_1337969183 = ((mDnses.size() == targetDnses.size()));
            Object var09E03C66279AC68D4F5A138A51FD11CA_1293138330 = (mDnses.containsAll(targetDnses));
        } //End flattened ternary
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Collection<InetAddress> targetDnses = target.getDnses();
        //return (mDnses.size() == targetDnses.size()) ?
                    //mDnses.containsAll(targetDnses) : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.932 -0400", hash_original_method = "3C11F6A9D4CB5E313FF4392D544C8E01", hash_generated_method = "BFBA1546A447A4953B630277C9435DC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isIdenticalRoutes(LinkProperties target) {
        dsTaint.addTaint(target.dsTaint);
        Collection<RouteInfo> targetRoutes;
        targetRoutes = target.getRoutes();
        {
            boolean var8A4690F8676279C4E003E24A9E634512_1342740469 = ((mRoutes.size() == targetRoutes.size()));
            Object varFC1EE2679A5375D5CE177F9337267C1C_891562100 = (mRoutes.containsAll(targetRoutes));
        } //End flattened ternary
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Collection<RouteInfo> targetRoutes = target.getRoutes();
        //return (mRoutes.size() == targetRoutes.size()) ?
                    //mRoutes.containsAll(targetRoutes) : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.932 -0400", hash_original_method = "DD4569AF6E08EF8065FD20A93C9D719F", hash_generated_method = "DAB8FAB4B2367CD6AC97079B4A42A7ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isIdenticalHttpProxy(LinkProperties target) {
        dsTaint.addTaint(target.dsTaint);
        {
            boolean varFBC502E80F6E2ED4131D5F3B922A0FAC_2136532640 = (getHttpProxy() == null);
            Object var7FD26D8E5D9A81FA18A194614D9B2D1C_611387337 = (target.getHttpProxy() == null);
            Object var68066F11042D8854D996D502391CDF43_1949185331 = (getHttpProxy().equals(target.getHttpProxy()));
        } //End flattened ternary
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getHttpProxy() == null ? target.getHttpProxy() == null :
                    //getHttpProxy().equals(target.getHttpProxy());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.932 -0400", hash_original_method = "E1692DB8F3E9AF5A893AE4BBE4FFDED0", hash_generated_method = "303127A0E0F07D75CAB0E3F1EAB15581")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        LinkProperties target;
        target = (LinkProperties) obj;
        boolean var0154B8A40FDF40E2B692EE07A0C7B198_824901033 = (isIdenticalInterfaceName(target) &&
                isIdenticalAddresses(target) &&
                isIdenticalDnses(target) &&
                isIdenticalRoutes(target) &&
                isIdenticalHttpProxy(target));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.935 -0400", hash_original_method = "F16C063B63526E6739B6C0383B3231A3", hash_generated_method = "DEB23DF9CFDE1422C781794F0B1B337B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CompareResult<LinkAddress> compareAddresses(LinkProperties target) {
        dsTaint.addTaint(target.dsTaint);
        CompareResult<LinkAddress> result;
        result = new CompareResult<LinkAddress>();
        result.removed = new ArrayList<LinkAddress>(mLinkAddresses);
        result.added.clear();
        {
            {
                Iterator<LinkAddress> var1CF02BF0C3749BAA471402895ECF294B_878055282 = (target.getLinkAddresses()).iterator();
                var1CF02BF0C3749BAA471402895ECF294B_878055282.hasNext();
                LinkAddress newAddress = var1CF02BF0C3749BAA471402895ECF294B_878055282.next();
                {
                    {
                        boolean varCF42614A09F8D2355BF1BA86279EFF16_412439482 = (! result.removed.remove(newAddress));
                        {
                            result.added.add(newAddress);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (CompareResult<LinkAddress>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.936 -0400", hash_original_method = "C56C38D458207E713A2F639173CF494C", hash_generated_method = "667D74594CBBBAB5D1BB93AE053E6501")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CompareResult<InetAddress> compareDnses(LinkProperties target) {
        dsTaint.addTaint(target.dsTaint);
        CompareResult<InetAddress> result;
        result = new CompareResult<InetAddress>();
        result.removed = new ArrayList<InetAddress>(mDnses);
        result.added.clear();
        {
            {
                Iterator<InetAddress> var5D025E9A74EF4251C9BAA6B2C125325C_1632519881 = (target.getDnses()).iterator();
                var5D025E9A74EF4251C9BAA6B2C125325C_1632519881.hasNext();
                InetAddress newAddress = var5D025E9A74EF4251C9BAA6B2C125325C_1632519881.next();
                {
                    {
                        boolean varCF42614A09F8D2355BF1BA86279EFF16_1946892045 = (! result.removed.remove(newAddress));
                        {
                            result.added.add(newAddress);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (CompareResult<InetAddress>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.938 -0400", hash_original_method = "39063DDD1454993D1B4985089C8FABB6", hash_generated_method = "253281B3EAAF76F43D7E214F0B6E1D5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CompareResult<RouteInfo> compareRoutes(LinkProperties target) {
        dsTaint.addTaint(target.dsTaint);
        CompareResult<RouteInfo> result;
        result = new CompareResult<RouteInfo>();
        result.removed = new ArrayList<RouteInfo>(mRoutes);
        result.added.clear();
        {
            {
                Iterator<RouteInfo> var98E042D986256D5C143CD1D8775297CE_1396350092 = (target.getRoutes()).iterator();
                var98E042D986256D5C143CD1D8775297CE_1396350092.hasNext();
                RouteInfo r = var98E042D986256D5C143CD1D8775297CE_1396350092.next();
                {
                    {
                        boolean varC873CBADB2439759A1631563A981C60B_600420939 = (! result.removed.remove(r));
                        {
                            result.added.add(r);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (CompareResult<RouteInfo>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.939 -0400", hash_original_method = "28ECE8095E829F4615B9B35514C29B36", hash_generated_method = "21F21BF0E20ADAAA7AF3EB77E64C82AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varE71D32073B9D953373F280788B927A4F_838362590 = (((null == mIfaceName) ? 0 : mIfaceName.hashCode()
                + mLinkAddresses.size() * 31
                + mDnses.size() * 37
                + mRoutes.size() * 41
                + ((null == mHttpProxy) ? 0 : mHttpProxy.hashCode()))); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return ((null == mIfaceName) ? 0 : mIfaceName.hashCode()
                //+ mLinkAddresses.size() * 31
                //+ mDnses.size() * 37
                //+ mRoutes.size() * 41
                //+ ((null == mHttpProxy) ? 0 : mHttpProxy.hashCode()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.945 -0400", hash_original_method = "FA484CCA03B27F5C12EABAE629DE360A", hash_generated_method = "FACA7E7AA319D063753A7928C530229F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeString(getInterfaceName());
        dest.writeInt(mLinkAddresses.size());
        {
            Iterator<LinkAddress> varDF96464DD29D4BD0B0137A05D67E51BB_1603383378 = (mLinkAddresses).iterator();
            varDF96464DD29D4BD0B0137A05D67E51BB_1603383378.hasNext();
            LinkAddress linkAddress = varDF96464DD29D4BD0B0137A05D67E51BB_1603383378.next();
            {
                dest.writeParcelable(linkAddress, flags);
            } //End block
        } //End collapsed parenthetic
        dest.writeInt(mDnses.size());
        {
            Iterator<InetAddress> varD0C0A861F30CBF0FE56B8F003A69B034_337626187 = (mDnses).iterator();
            varD0C0A861F30CBF0FE56B8F003A69B034_337626187.hasNext();
            InetAddress d = varD0C0A861F30CBF0FE56B8F003A69B034_337626187.next();
            {
                dest.writeByteArray(d.getAddress());
            } //End block
        } //End collapsed parenthetic
        dest.writeInt(mRoutes.size());
        {
            Iterator<RouteInfo> var884AA7CBDA9AFAD5F88BFEB52967F598_888065107 = (mRoutes).iterator();
            var884AA7CBDA9AFAD5F88BFEB52967F598_888065107.hasNext();
            RouteInfo route = var884AA7CBDA9AFAD5F88BFEB52967F598_888065107.next();
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
        public Collection<T> removed = new ArrayList<T>();
        public Collection<T> added = new ArrayList<T>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.946 -0400", hash_original_method = "16071A940A728415BE2C19B2FBACE091", hash_generated_method = "16071A940A728415BE2C19B2FBACE091")
                public CompareResult ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.989 -0400", hash_original_method = "432CBAB98383F022B31745E1B8881CF6", hash_generated_method = "8B659537465D9963A4DE3DCAA95663E7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String retVal;
            retVal = "removed=[";
            {
                Iterator<T> varC423D6E3AA0BA108FCAE25E1A62A868B_856822692 = (removed).iterator();
                varC423D6E3AA0BA108FCAE25E1A62A868B_856822692.hasNext();
                T addr = varC423D6E3AA0BA108FCAE25E1A62A868B_856822692.next();
                retVal += addr.toString() + ",";
            } //End collapsed parenthetic
            retVal += "] added=[";
            {
                Iterator<T> var5AD5BD4A6E3B2EEAB3BA044D5B8651B9_323989077 = (added).iterator();
                var5AD5BD4A6E3B2EEAB3BA044D5B8651B9_323989077.hasNext();
                T addr = var5AD5BD4A6E3B2EEAB3BA044D5B8651B9_323989077.next();
                retVal += addr.toString() + ",";
            } //End collapsed parenthetic
            retVal += "]";
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //String retVal = "removed=[";
            //for (T addr : removed) retVal += addr.toString() + ",";
            //retVal += "] added=[";
            //for (T addr : added) retVal += addr.toString() + ",";
            //retVal += "]";
            //return retVal;
        }

        
    }


    
    public static final Creator<LinkProperties> CREATOR = new Creator<LinkProperties>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.990 -0400", hash_original_method = "0C82553AE9182D627E9FE9D3BDCCC2D2", hash_generated_method = "7538E9DBDD8235DFDF18403C235EEBD7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LinkProperties createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            LinkProperties netProp;
            netProp = new LinkProperties();
            String iface;
            iface = in.readString();
            {
                try 
                {
                    netProp.setInterfaceName(iface);
                } //End block
                catch (Exception e)
                { }
            } //End block
            int addressCount;
            addressCount = in.readInt();
            {
                int i;
                i = 0;
                {
                    netProp.addLinkAddress((LinkAddress)in.readParcelable(null));
                } //End block
            } //End collapsed parenthetic
            addressCount = in.readInt();
            {
                int i;
                i = 0;
                {
                    try 
                    {
                        netProp.addDns(InetAddress.getByAddress(in.createByteArray()));
                    } //End block
                    catch (UnknownHostException e)
                    { }
                } //End block
            } //End collapsed parenthetic
            addressCount = in.readInt();
            {
                int i;
                i = 0;
                {
                    netProp.addRoute((RouteInfo)in.readParcelable(null));
                } //End block
            } //End collapsed parenthetic
            {
                boolean varA34511E23A7BE70AFB33ABE4FC1AF4E2_1839700282 = (in.readByte() == 1);
                {
                    netProp.setHttpProxy((ProxyProperties)in.readParcelable(null));
                } //End block
            } //End collapsed parenthetic
            return (LinkProperties)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.990 -0400", hash_original_method = "CDB87C960A6DC4E6DB35A27BB9B9B68F", hash_generated_method = "1F27FEEA1F82CA3C90FCC4CA30ECAF96")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LinkProperties[] newArray(int size) {
            dsTaint.addTaint(size);
            LinkProperties[] var7E28AB5A642121A2806599E07564BC0D_652466046 = (new LinkProperties[size]);
            return (LinkProperties[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new LinkProperties[size];
        }

        
}; //Transformed anonymous class
}

