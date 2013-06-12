package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    public static final Creator<LinkProperties> CREATOR = new Creator<LinkProperties>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.159 -0400", hash_original_method = "0C82553AE9182D627E9FE9D3BDCCC2D2", hash_generated_method = "47FE1B0E4021B5D8D5D143A719FA2A24")
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
                boolean varA34511E23A7BE70AFB33ABE4FC1AF4E2_488450461 = (in.readByte() == 1);
                {
                    netProp.setHttpProxy((ProxyProperties)in.readParcelable(null));
                } //End block
            } //End collapsed parenthetic
            return (LinkProperties)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.159 -0400", hash_original_method = "CDB87C960A6DC4E6DB35A27BB9B9B68F", hash_generated_method = "BF812BB0BA070741F45CAC67CDF12C22")
        @DSModeled(DSC.SAFE)
        public LinkProperties[] newArray(int size) {
            dsTaint.addTaint(size);
            return (LinkProperties[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new LinkProperties[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.159 -0400", hash_original_method = "A2AA1798C08A5590A3DB637A5B794F80", hash_generated_method = "C652760EA909D04A2DF1B9FCAB371AAC")
    @DSModeled(DSC.SAFE)
    public LinkProperties() {
        clear();
        // ---------- Original Method ----------
        //clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.159 -0400", hash_original_method = "836BF23A93C2D960D78EC02574131087", hash_generated_method = "EEBD09B51F823026F590D0309FE8D920")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkProperties(LinkProperties source) {
        dsTaint.addTaint(source.dsTaint);
        {
            mIfaceName = source.getInterfaceName();
            {
                Iterator<LinkAddress> seatecAstronomy42 = source.getLinkAddresses().iterator();
                seatecAstronomy42.hasNext();
                LinkAddress l = seatecAstronomy42.next();
                mLinkAddresses.add(l);
            } //End collapsed parenthetic
            {
                Iterator<InetAddress> seatecAstronomy42 = source.getDnses().iterator();
                seatecAstronomy42.hasNext();
                InetAddress i = seatecAstronomy42.next();
                mDnses.add(i);
            } //End collapsed parenthetic
            {
                Iterator<RouteInfo> seatecAstronomy42 = source.getRoutes().iterator();
                seatecAstronomy42.hasNext();
                RouteInfo r = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.160 -0400", hash_original_method = "658C71C3CDAAE8BF2A6E808615EC0533", hash_generated_method = "F6E003458A343BB2297B3C7731D82B6B")
    @DSModeled(DSC.SAFE)
    public void setInterfaceName(String iface) {
        dsTaint.addTaint(iface);
        // ---------- Original Method ----------
        //mIfaceName = iface;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.160 -0400", hash_original_method = "DE3FEB2907F1F43DDDDBA76FC2B5A592", hash_generated_method = "8359383DC1C6AF3C782769B1A7AC6336")
    @DSModeled(DSC.SAFE)
    public String getInterfaceName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mIfaceName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.160 -0400", hash_original_method = "873086E492F590532E0F956B14530004", hash_generated_method = "7D50B49A2BB20D6F36987F2D2137D8F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<InetAddress> getAddresses() {
        Collection<InetAddress> addresses;
        addresses = new ArrayList<InetAddress>();
        {
            Iterator<LinkAddress> seatecAstronomy42 = mLinkAddresses.iterator();
            seatecAstronomy42.hasNext();
            LinkAddress linkAddress = seatecAstronomy42.next();
            {
                addresses.add(linkAddress.getAddress());
            } //End block
        } //End collapsed parenthetic
        Collection<InetAddress> varDFB04F28F130C4EA44091020FD08E9A2_1572368590 = (Collections.unmodifiableCollection(addresses));
        return (Collection<InetAddress>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Collection<InetAddress> addresses = new ArrayList<InetAddress>();
        //for (LinkAddress linkAddress : mLinkAddresses) {
            //addresses.add(linkAddress.getAddress());
        //}
        //return Collections.unmodifiableCollection(addresses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.160 -0400", hash_original_method = "1B49E50669A271748C7EE163D2678E87", hash_generated_method = "9ADC16F87C831EB4953A009285003DC6")
    @DSModeled(DSC.SAFE)
    public void addLinkAddress(LinkAddress address) {
        dsTaint.addTaint(address.dsTaint);
        mLinkAddresses.add(address);
        // ---------- Original Method ----------
        //if (address != null) mLinkAddresses.add(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.160 -0400", hash_original_method = "72D86E86409333B5516C160027F12741", hash_generated_method = "BB57AB126CA225FC9FAD1C35B799373D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<LinkAddress> getLinkAddresses() {
        Collection<LinkAddress> varC3E793C4D5AF361A2C1AC6DB8EFBAB36_1016785428 = (Collections.unmodifiableCollection(mLinkAddresses));
        return (Collection<LinkAddress>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Collections.unmodifiableCollection(mLinkAddresses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.160 -0400", hash_original_method = "34CA5CC4558FA9428BD44173436D0F22", hash_generated_method = "56A55DA288831198534149AE393F8073")
    @DSModeled(DSC.SAFE)
    public void addDns(InetAddress dns) {
        dsTaint.addTaint(dns.dsTaint);
        mDnses.add(dns);
        // ---------- Original Method ----------
        //if (dns != null) mDnses.add(dns);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.160 -0400", hash_original_method = "71F7664B03379576DA51ED6043500785", hash_generated_method = "E207BAFA9129A636EFA0AE2E21E5E1CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<InetAddress> getDnses() {
        Collection<InetAddress> var55A6126CFAA0F65F2C26620090D813AD_274815789 = (Collections.unmodifiableCollection(mDnses));
        return (Collection<InetAddress>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Collections.unmodifiableCollection(mDnses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.160 -0400", hash_original_method = "D2F9F5371D010F9C9B4F83D9513356DD", hash_generated_method = "74A165EA265927D1A47218E0864F7B9C")
    @DSModeled(DSC.SAFE)
    public void addRoute(RouteInfo route) {
        dsTaint.addTaint(route.dsTaint);
        mRoutes.add(route);
        // ---------- Original Method ----------
        //if (route != null) mRoutes.add(route);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.161 -0400", hash_original_method = "A7B26240781BB7C0E135CB45CD0D9800", hash_generated_method = "3A92E50F60AC02044BA7D714B2DEC371")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<RouteInfo> getRoutes() {
        Collection<RouteInfo> var9703EB08BD311C538B60DEDA6370A838_566087660 = (Collections.unmodifiableCollection(mRoutes));
        return (Collection<RouteInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Collections.unmodifiableCollection(mRoutes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.161 -0400", hash_original_method = "A3A7E4451F64D99820B4BAAEF1AFE8A2", hash_generated_method = "B8D3915FA5F7A896769A3735AC6444E2")
    @DSModeled(DSC.SAFE)
    public void setHttpProxy(ProxyProperties proxy) {
        dsTaint.addTaint(proxy.dsTaint);
        // ---------- Original Method ----------
        //mHttpProxy = proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.161 -0400", hash_original_method = "6E571D9EDF02B85B7F325367F981AC91", hash_generated_method = "C167945EE73BCBE7B5F3194E59A35E47")
    @DSModeled(DSC.SAFE)
    public ProxyProperties getHttpProxy() {
        return (ProxyProperties)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mHttpProxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.161 -0400", hash_original_method = "4D86E4F145913ECB4C1EE8109466CAB3", hash_generated_method = "43E833A68327787AC781092BD1D6EB6E")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.161 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.161 -0400", hash_original_method = "FDC9878366ECD283FC0D7411AB5ED4B7", hash_generated_method = "B36F866149FEC025D1229DB6A79E704F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String ifaceName;
        ifaceName = (mIfaceName == null ? "" : "InterfaceName: " + mIfaceName + " ");//DSFIXME:  CODE0008: Nested ternary operator in expression
        String linkAddresses;
        linkAddresses = "LinkAddresses: [";
        {
            Iterator<LinkAddress> seatecAstronomy42 = mLinkAddresses.iterator();
            seatecAstronomy42.hasNext();
            LinkAddress addr = seatecAstronomy42.next();
            linkAddresses += addr.toString() + ",";
        } //End collapsed parenthetic
        linkAddresses += "] ";
        String dns;
        dns = "DnsAddresses: [";
        {
            Iterator<InetAddress> seatecAstronomy42 = mDnses.iterator();
            seatecAstronomy42.hasNext();
            InetAddress addr = seatecAstronomy42.next();
            dns += addr.getHostAddress() + ",";
        } //End collapsed parenthetic
        dns += "] ";
        String routes;
        routes = "Routes: [";
        {
            Iterator<RouteInfo> seatecAstronomy42 = mRoutes.iterator();
            seatecAstronomy42.hasNext();
            RouteInfo route = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.161 -0400", hash_original_method = "48DB33246C86C278D2BAD545A88B9470", hash_generated_method = "EFCF10847263962D38F733DE9E688445")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isIdenticalInterfaceName(LinkProperties target) {
        dsTaint.addTaint(target.dsTaint);
        boolean var6F2AB3D9835C0A270859893D0ED96986_611950170 = (TextUtils.equals(getInterfaceName(), target.getInterfaceName()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return TextUtils.equals(getInterfaceName(), target.getInterfaceName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.162 -0400", hash_original_method = "D0F0B04B5ACB5FD8D13B5B828D9A160C", hash_generated_method = "52AA826B9A22FB80C9CD2D89E99598F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isIdenticalAddresses(LinkProperties target) {
        dsTaint.addTaint(target.dsTaint);
        Collection<InetAddress> targetAddresses;
        targetAddresses = target.getAddresses();
        Collection<InetAddress> sourceAddresses;
        sourceAddresses = getAddresses();
        {
            boolean var171F2F84DB8A7D85E1317944C116AFCC_1058164759 = ((sourceAddresses.size() == targetAddresses.size()));
            Object varC949C242E33C773B3451D3552B0945BC_227690225 = (sourceAddresses.containsAll(targetAddresses));
        } //End flattened ternary
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Collection<InetAddress> targetAddresses = target.getAddresses();
        //Collection<InetAddress> sourceAddresses = getAddresses();
        //return (sourceAddresses.size() == targetAddresses.size()) ?
                    //sourceAddresses.containsAll(targetAddresses) : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.162 -0400", hash_original_method = "14A4F7F9C3E90075B30F314D9FCFE073", hash_generated_method = "73378C4E1DA0FCBA14938D4005CAC376")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isIdenticalDnses(LinkProperties target) {
        dsTaint.addTaint(target.dsTaint);
        Collection<InetAddress> targetDnses;
        targetDnses = target.getDnses();
        {
            boolean varE3CBC7C3F925563121730FFF5E3D651F_2099225083 = ((mDnses.size() == targetDnses.size()));
            Object var09E03C66279AC68D4F5A138A51FD11CA_1154157878 = (mDnses.containsAll(targetDnses));
        } //End flattened ternary
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Collection<InetAddress> targetDnses = target.getDnses();
        //return (mDnses.size() == targetDnses.size()) ?
                    //mDnses.containsAll(targetDnses) : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.162 -0400", hash_original_method = "3C11F6A9D4CB5E313FF4392D544C8E01", hash_generated_method = "DDC9E8308DC3965B9FAD6482023A3E91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isIdenticalRoutes(LinkProperties target) {
        dsTaint.addTaint(target.dsTaint);
        Collection<RouteInfo> targetRoutes;
        targetRoutes = target.getRoutes();
        {
            boolean var8A4690F8676279C4E003E24A9E634512_1799897595 = ((mRoutes.size() == targetRoutes.size()));
            Object varFC1EE2679A5375D5CE177F9337267C1C_392376961 = (mRoutes.containsAll(targetRoutes));
        } //End flattened ternary
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Collection<RouteInfo> targetRoutes = target.getRoutes();
        //return (mRoutes.size() == targetRoutes.size()) ?
                    //mRoutes.containsAll(targetRoutes) : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.162 -0400", hash_original_method = "DD4569AF6E08EF8065FD20A93C9D719F", hash_generated_method = "82F9433715526DF4FA1E94EFC08D8D22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isIdenticalHttpProxy(LinkProperties target) {
        dsTaint.addTaint(target.dsTaint);
        {
            boolean varFBC502E80F6E2ED4131D5F3B922A0FAC_1061352409 = (getHttpProxy() == null);
            Object var7FD26D8E5D9A81FA18A194614D9B2D1C_1525337848 = (target.getHttpProxy() == null);
            Object var68066F11042D8854D996D502391CDF43_1044335991 = (getHttpProxy().equals(target.getHttpProxy()));
        } //End flattened ternary
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getHttpProxy() == null ? target.getHttpProxy() == null :
                    //getHttpProxy().equals(target.getHttpProxy());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.162 -0400", hash_original_method = "E1692DB8F3E9AF5A893AE4BBE4FFDED0", hash_generated_method = "24803203BAFEDA7586C121EAD3102EF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        LinkProperties target;
        target = (LinkProperties) obj;
        boolean var0154B8A40FDF40E2B692EE07A0C7B198_388784056 = (isIdenticalInterfaceName(target) &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.163 -0400", hash_original_method = "F16C063B63526E6739B6C0383B3231A3", hash_generated_method = "85C5CD576E64249CF532081B8F20D000")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CompareResult<LinkAddress> compareAddresses(LinkProperties target) {
        dsTaint.addTaint(target.dsTaint);
        CompareResult<LinkAddress> result;
        result = new CompareResult<LinkAddress>();
        result.removed = new ArrayList<LinkAddress>(mLinkAddresses);
        result.added.clear();
        {
            {
                Iterator<LinkAddress> seatecAstronomy42 = target.getLinkAddresses().iterator();
                seatecAstronomy42.hasNext();
                LinkAddress newAddress = seatecAstronomy42.next();
                {
                    {
                        boolean varCF42614A09F8D2355BF1BA86279EFF16_101368340 = (! result.removed.remove(newAddress));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.163 -0400", hash_original_method = "C56C38D458207E713A2F639173CF494C", hash_generated_method = "11AB3375FDDCFE473641D8011E9E8FC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CompareResult<InetAddress> compareDnses(LinkProperties target) {
        dsTaint.addTaint(target.dsTaint);
        CompareResult<InetAddress> result;
        result = new CompareResult<InetAddress>();
        result.removed = new ArrayList<InetAddress>(mDnses);
        result.added.clear();
        {
            {
                Iterator<InetAddress> seatecAstronomy42 = target.getDnses().iterator();
                seatecAstronomy42.hasNext();
                InetAddress newAddress = seatecAstronomy42.next();
                {
                    {
                        boolean varCF42614A09F8D2355BF1BA86279EFF16_565677183 = (! result.removed.remove(newAddress));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.163 -0400", hash_original_method = "39063DDD1454993D1B4985089C8FABB6", hash_generated_method = "0C47BA9F03452D22008CC0B45A6C02CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CompareResult<RouteInfo> compareRoutes(LinkProperties target) {
        dsTaint.addTaint(target.dsTaint);
        CompareResult<RouteInfo> result;
        result = new CompareResult<RouteInfo>();
        result.removed = new ArrayList<RouteInfo>(mRoutes);
        result.added.clear();
        {
            {
                Iterator<RouteInfo> seatecAstronomy42 = target.getRoutes().iterator();
                seatecAstronomy42.hasNext();
                RouteInfo r = seatecAstronomy42.next();
                {
                    {
                        boolean varC873CBADB2439759A1631563A981C60B_441534813 = (! result.removed.remove(r));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.163 -0400", hash_original_method = "28ECE8095E829F4615B9B35514C29B36", hash_generated_method = "28058E2159F7C8931A9813C196E8B60C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varE71D32073B9D953373F280788B927A4F_2092653255 = (((null == mIfaceName) ? 0 : mIfaceName.hashCode()
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.163 -0400", hash_original_method = "FA484CCA03B27F5C12EABAE629DE360A", hash_generated_method = "2DD8BD240B3CFB99DA402ECA4BFBA08E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        dest.writeString(getInterfaceName());
        dest.writeInt(mLinkAddresses.size());
        {
            Iterator<LinkAddress> seatecAstronomy42 = mLinkAddresses.iterator();
            seatecAstronomy42.hasNext();
            LinkAddress linkAddress = seatecAstronomy42.next();
            {
                dest.writeParcelable(linkAddress, flags);
            } //End block
        } //End collapsed parenthetic
        dest.writeInt(mDnses.size());
        {
            Iterator<InetAddress> seatecAstronomy42 = mDnses.iterator();
            seatecAstronomy42.hasNext();
            InetAddress d = seatecAstronomy42.next();
            {
                dest.writeByteArray(d.getAddress());
            } //End block
        } //End collapsed parenthetic
        dest.writeInt(mRoutes.size());
        {
            Iterator<RouteInfo> seatecAstronomy42 = mRoutes.iterator();
            seatecAstronomy42.hasNext();
            RouteInfo route = seatecAstronomy42.next();
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.164 -0400", hash_original_method = "432CBAB98383F022B31745E1B8881CF6", hash_generated_method = "5278C7FDD550782849F0C0C4B362ACEB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String retVal;
            retVal = "removed=[";
            {
                Iterator<T> seatecAstronomy42 = removed.iterator();
                seatecAstronomy42.hasNext();
                T addr = seatecAstronomy42.next();
                retVal += addr.toString() + ",";
            } //End collapsed parenthetic
            retVal += "] added=[";
            {
                Iterator<T> seatecAstronomy42 = added.iterator();
                seatecAstronomy42.hasNext();
                T addr = seatecAstronomy42.next();
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


    
}


