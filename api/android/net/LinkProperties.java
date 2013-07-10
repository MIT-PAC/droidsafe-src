package android.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.116 -0400", hash_original_field = "E6BA5CF0E40609A434B9830189A5C361", hash_generated_field = "6D2C834A0EA52BA031060A9E0AEE620E")

    String mIfaceName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.116 -0400", hash_original_field = "6AEFC7DC6659B9C6DA99F3CB40F9A569", hash_generated_field = "00DE8BD688F501E4FB5528A63461C364")

    private Collection<LinkAddress> mLinkAddresses = new ArrayList<LinkAddress>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.116 -0400", hash_original_field = "FD91D9D1E504FC4A4ED4F0BB92CA1204", hash_generated_field = "D0EA13350ECE9796647D8145F3FB5864")

    private Collection<InetAddress> mDnses = new ArrayList<InetAddress>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.116 -0400", hash_original_field = "722D48B16FEB25182D36B7B66149CEE2", hash_generated_field = "2D860F9C91CB145D416269098C36EC63")

    private Collection<RouteInfo> mRoutes = new ArrayList<RouteInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.116 -0400", hash_original_field = "333D05D23A1925EB4A47F41C960FCCB0", hash_generated_field = "E6A788E6ED925BAD844282A07CD34FF9")

    private ProxyProperties mHttpProxy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.117 -0400", hash_original_method = "A2AA1798C08A5590A3DB637A5B794F80", hash_generated_method = "61D49920A9252FA3879C7DD8F5F55E1D")
    public  LinkProperties() {
        clear();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.124 -0400", hash_original_method = "836BF23A93C2D960D78EC02574131087", hash_generated_method = "AC566DDE17FDE3D6B0F97F08411F7373")
    public  LinkProperties(LinkProperties source) {
        {
            mIfaceName = source.getInterfaceName();
            {
                Iterator<LinkAddress> var59DB07A15473864E1C5588C8655CA6E3_27437227 = (source.getLinkAddresses()).iterator();
                var59DB07A15473864E1C5588C8655CA6E3_27437227.hasNext();
                LinkAddress l = var59DB07A15473864E1C5588C8655CA6E3_27437227.next();
                mLinkAddresses.add(l);
            } 
            {
                Iterator<InetAddress> varAF10DA590F783BAD26DEEDB471E7BD07_1778396313 = (source.getDnses()).iterator();
                varAF10DA590F783BAD26DEEDB471E7BD07_1778396313.hasNext();
                InetAddress i = varAF10DA590F783BAD26DEEDB471E7BD07_1778396313.next();
                mDnses.add(i);
            } 
            {
                Iterator<RouteInfo> var5AEB519FA22FBA3D61143458993DDC82_969178397 = (source.getRoutes()).iterator();
                var5AEB519FA22FBA3D61143458993DDC82_969178397.hasNext();
                RouteInfo r = var5AEB519FA22FBA3D61143458993DDC82_969178397.next();
                mRoutes.add(r);
            } 
            mHttpProxy = (source.getHttpProxy() == null)  ?
                null : new ProxyProperties(source.getHttpProxy());
        } 
        
        
            
            
            
            
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.124 -0400", hash_original_method = "658C71C3CDAAE8BF2A6E808615EC0533", hash_generated_method = "D58C219F5C5992BE6A4B05BFFDE78502")
    public void setInterfaceName(String iface) {
        mIfaceName = iface;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.125 -0400", hash_original_method = "DE3FEB2907F1F43DDDDBA76FC2B5A592", hash_generated_method = "CFE0A869169EA27A27A7D5ADDC0B007E")
    public String getInterfaceName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1157394690 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1157394690 = mIfaceName;
        varB4EAC82CA7396A68D541C85D26508E83_1157394690.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1157394690;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.128 -0400", hash_original_method = "873086E492F590532E0F956B14530004", hash_generated_method = "F9BD768F673EA50EA0E0C2DC517948C5")
    public Collection<InetAddress> getAddresses() {
        Collection<InetAddress> varB4EAC82CA7396A68D541C85D26508E83_438606716 = null; 
        Collection<InetAddress> addresses = new ArrayList<InetAddress>();
        {
            Iterator<LinkAddress> varDF96464DD29D4BD0B0137A05D67E51BB_2143689779 = (mLinkAddresses).iterator();
            varDF96464DD29D4BD0B0137A05D67E51BB_2143689779.hasNext();
            LinkAddress linkAddress = varDF96464DD29D4BD0B0137A05D67E51BB_2143689779.next();
            {
                addresses.add(linkAddress.getAddress());
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_438606716 = Collections.unmodifiableCollection(addresses);
        varB4EAC82CA7396A68D541C85D26508E83_438606716.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_438606716;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.129 -0400", hash_original_method = "1B49E50669A271748C7EE163D2678E87", hash_generated_method = "911CB430011BD1592676CF4A964808BA")
    public void addLinkAddress(LinkAddress address) {
        mLinkAddresses.add(address);
        addTaint(address.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.131 -0400", hash_original_method = "72D86E86409333B5516C160027F12741", hash_generated_method = "CBF8E23998DA6C25B332046E2A3013D7")
    public Collection<LinkAddress> getLinkAddresses() {
        Collection<LinkAddress> varB4EAC82CA7396A68D541C85D26508E83_963224493 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_963224493 = Collections.unmodifiableCollection(mLinkAddresses);
        varB4EAC82CA7396A68D541C85D26508E83_963224493.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_963224493;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.133 -0400", hash_original_method = "34CA5CC4558FA9428BD44173436D0F22", hash_generated_method = "D674353956780C7E1DEA381F7DF5875F")
    public void addDns(InetAddress dns) {
        mDnses.add(dns);
        addTaint(dns.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.134 -0400", hash_original_method = "71F7664B03379576DA51ED6043500785", hash_generated_method = "30588ABAC76185ECA5C3FAD39FF142A7")
    public Collection<InetAddress> getDnses() {
        Collection<InetAddress> varB4EAC82CA7396A68D541C85D26508E83_110210564 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_110210564 = Collections.unmodifiableCollection(mDnses);
        varB4EAC82CA7396A68D541C85D26508E83_110210564.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_110210564;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.134 -0400", hash_original_method = "D2F9F5371D010F9C9B4F83D9513356DD", hash_generated_method = "CF497BE7CA790421615629C6965AC22C")
    public void addRoute(RouteInfo route) {
        mRoutes.add(route);
        addTaint(route.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.135 -0400", hash_original_method = "A7B26240781BB7C0E135CB45CD0D9800", hash_generated_method = "5138431EB3DEAAE43C01B29EA83EED72")
    public Collection<RouteInfo> getRoutes() {
        Collection<RouteInfo> varB4EAC82CA7396A68D541C85D26508E83_476212792 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_476212792 = Collections.unmodifiableCollection(mRoutes);
        varB4EAC82CA7396A68D541C85D26508E83_476212792.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_476212792;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.135 -0400", hash_original_method = "A3A7E4451F64D99820B4BAAEF1AFE8A2", hash_generated_method = "8C961CFF90F31516B337EDFD675E66E4")
    public void setHttpProxy(ProxyProperties proxy) {
        mHttpProxy = proxy;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.136 -0400", hash_original_method = "6E571D9EDF02B85B7F325367F981AC91", hash_generated_method = "BBE9062B195816AD73E0FB20AD065415")
    public ProxyProperties getHttpProxy() {
        ProxyProperties varB4EAC82CA7396A68D541C85D26508E83_749956514 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_749956514 = mHttpProxy;
        varB4EAC82CA7396A68D541C85D26508E83_749956514.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_749956514;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.136 -0400", hash_original_method = "4D86E4F145913ECB4C1EE8109466CAB3", hash_generated_method = "A8ED76BD4957AE90AC09315AE270F855")
    public void clear() {
        mIfaceName = null;
        mLinkAddresses.clear();
        mDnses.clear();
        mRoutes.clear();
        mHttpProxy = null;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.137 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "E6D5C8C22AD917ECC1E99C23BA71CCD3")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_924922597 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_924922597;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.149 -0400", hash_original_method = "FDC9878366ECD283FC0D7411AB5ED4B7", hash_generated_method = "646EEBC5BD656540671F8BBBB543E121")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1012469026 = null; 
        String ifaceName = (mIfaceName == null ? "" : "InterfaceName: " + mIfaceName + " ");
        String linkAddresses = "LinkAddresses: [";
        {
            Iterator<LinkAddress> varA54DF54142E944DE1695D23EA874915C_1847148649 = (mLinkAddresses).iterator();
            varA54DF54142E944DE1695D23EA874915C_1847148649.hasNext();
            LinkAddress addr = varA54DF54142E944DE1695D23EA874915C_1847148649.next();
            linkAddresses += addr.toString() + ",";
        } 
        linkAddresses += "] ";
        String dns = "DnsAddresses: [";
        {
            Iterator<InetAddress> varF82ABEA2736FEE01B3D433C6A400C80E_1545759248 = (mDnses).iterator();
            varF82ABEA2736FEE01B3D433C6A400C80E_1545759248.hasNext();
            InetAddress addr = varF82ABEA2736FEE01B3D433C6A400C80E_1545759248.next();
            dns += addr.getHostAddress() + ",";
        } 
        dns += "] ";
        String routes = "Routes: [";
        {
            Iterator<RouteInfo> var884AA7CBDA9AFAD5F88BFEB52967F598_1845543427 = (mRoutes).iterator();
            var884AA7CBDA9AFAD5F88BFEB52967F598_1845543427.hasNext();
            RouteInfo route = var884AA7CBDA9AFAD5F88BFEB52967F598_1845543427.next();
            routes += route.toString() + ",";
        } 
        routes += "] ";
        String proxy = (mHttpProxy == null ? "" : "HttpProxy: " + mHttpProxy.toString() + " ");
        varB4EAC82CA7396A68D541C85D26508E83_1012469026 = ifaceName + linkAddresses + routes + dns + proxy;
        varB4EAC82CA7396A68D541C85D26508E83_1012469026.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1012469026;
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.149 -0400", hash_original_method = "48DB33246C86C278D2BAD545A88B9470", hash_generated_method = "33F2E7628C1FF2EF031659E1BF3CBF9B")
    public boolean isIdenticalInterfaceName(LinkProperties target) {
        boolean var6F2AB3D9835C0A270859893D0ED96986_920728677 = (TextUtils.equals(getInterfaceName(), target.getInterfaceName()));
        addTaint(target.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_376714369 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_376714369;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.150 -0400", hash_original_method = "D0F0B04B5ACB5FD8D13B5B828D9A160C", hash_generated_method = "C5E0561B9D6E7F30FB28B0C65506F772")
    public boolean isIdenticalAddresses(LinkProperties target) {
        Collection<InetAddress> targetAddresses = target.getAddresses();
        Collection<InetAddress> sourceAddresses = getAddresses();
        {
            boolean var171F2F84DB8A7D85E1317944C116AFCC_714741760 = ((sourceAddresses.size() == targetAddresses.size()));
            Object varC949C242E33C773B3451D3552B0945BC_1848852792 = (sourceAddresses.containsAll(targetAddresses));
        } 
        addTaint(target.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_771741495 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_771741495;
        
        
        
        
                    
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.151 -0400", hash_original_method = "14A4F7F9C3E90075B30F314D9FCFE073", hash_generated_method = "D13918C2A5988D373EC20C97B5C3B4FF")
    public boolean isIdenticalDnses(LinkProperties target) {
        Collection<InetAddress> targetDnses = target.getDnses();
        {
            boolean varE3CBC7C3F925563121730FFF5E3D651F_622014540 = ((mDnses.size() == targetDnses.size()));
            Object var09E03C66279AC68D4F5A138A51FD11CA_1900105631 = (mDnses.containsAll(targetDnses));
        } 
        addTaint(target.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_335864488 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_335864488;
        
        
        
                    
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.152 -0400", hash_original_method = "3C11F6A9D4CB5E313FF4392D544C8E01", hash_generated_method = "8CF0F2E883BDFD1EDBD3A8AB51766A1A")
    public boolean isIdenticalRoutes(LinkProperties target) {
        Collection<RouteInfo> targetRoutes = target.getRoutes();
        {
            boolean var8A4690F8676279C4E003E24A9E634512_725827341 = ((mRoutes.size() == targetRoutes.size()));
            Object varFC1EE2679A5375D5CE177F9337267C1C_249686213 = (mRoutes.containsAll(targetRoutes));
        } 
        addTaint(target.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_814505989 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_814505989;
        
        
        
                    
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.153 -0400", hash_original_method = "DD4569AF6E08EF8065FD20A93C9D719F", hash_generated_method = "3C559BAF55DCA6F5583426384D3E08AD")
    public boolean isIdenticalHttpProxy(LinkProperties target) {
        {
            boolean varFBC502E80F6E2ED4131D5F3B922A0FAC_2117862390 = (getHttpProxy() == null);
            Object var7FD26D8E5D9A81FA18A194614D9B2D1C_1059227754 = (target.getHttpProxy() == null);
            Object var68066F11042D8854D996D502391CDF43_810206921 = (getHttpProxy().equals(target.getHttpProxy()));
        } 
        addTaint(target.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1801284713 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1801284713;
        
        
                    
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.154 -0400", hash_original_method = "E1692DB8F3E9AF5A893AE4BBE4FFDED0", hash_generated_method = "814197BF3623759F40317D1698FBD80C")
    @Override
    public boolean equals(Object obj) {
        LinkProperties target = (LinkProperties) obj;
        boolean var0154B8A40FDF40E2B692EE07A0C7B198_1198438886 = (isIdenticalInterfaceName(target) &&
                isIdenticalAddresses(target) &&
                isIdenticalDnses(target) &&
                isIdenticalRoutes(target) &&
                isIdenticalHttpProxy(target));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1048994120 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1048994120;
        
        
        
        
        
                
                
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.157 -0400", hash_original_method = "F16C063B63526E6739B6C0383B3231A3", hash_generated_method = "90F7973B6830B9A16ED2C6847C378622")
    public CompareResult<LinkAddress> compareAddresses(LinkProperties target) {
        CompareResult<LinkAddress> varB4EAC82CA7396A68D541C85D26508E83_1486377675 = null; 
        CompareResult<LinkAddress> result = new CompareResult<LinkAddress>();
        result.removed = new ArrayList<LinkAddress>(mLinkAddresses);
        result.added.clear();
        {
            {
                Iterator<LinkAddress> var1CF02BF0C3749BAA471402895ECF294B_1490894433 = (target.getLinkAddresses()).iterator();
                var1CF02BF0C3749BAA471402895ECF294B_1490894433.hasNext();
                LinkAddress newAddress = var1CF02BF0C3749BAA471402895ECF294B_1490894433.next();
                {
                    {
                        boolean varCF42614A09F8D2355BF1BA86279EFF16_1870261143 = (! result.removed.remove(newAddress));
                        {
                            result.added.add(newAddress);
                        } 
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1486377675 = result;
        addTaint(target.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1486377675.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1486377675;
        
        
        
        
        
            
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.160 -0400", hash_original_method = "C56C38D458207E713A2F639173CF494C", hash_generated_method = "754AF81545A12F12EEED817A3ECC0F38")
    public CompareResult<InetAddress> compareDnses(LinkProperties target) {
        CompareResult<InetAddress> varB4EAC82CA7396A68D541C85D26508E83_2124105650 = null; 
        CompareResult<InetAddress> result = new CompareResult<InetAddress>();
        result.removed = new ArrayList<InetAddress>(mDnses);
        result.added.clear();
        {
            {
                Iterator<InetAddress> var5D025E9A74EF4251C9BAA6B2C125325C_1468420467 = (target.getDnses()).iterator();
                var5D025E9A74EF4251C9BAA6B2C125325C_1468420467.hasNext();
                InetAddress newAddress = var5D025E9A74EF4251C9BAA6B2C125325C_1468420467.next();
                {
                    {
                        boolean varCF42614A09F8D2355BF1BA86279EFF16_1291810298 = (! result.removed.remove(newAddress));
                        {
                            result.added.add(newAddress);
                        } 
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2124105650 = result;
        addTaint(target.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2124105650.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2124105650;
        
        
        
        
        
            
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.163 -0400", hash_original_method = "39063DDD1454993D1B4985089C8FABB6", hash_generated_method = "C98CA2066992355EC3ADEFB5EF488DBC")
    public CompareResult<RouteInfo> compareRoutes(LinkProperties target) {
        CompareResult<RouteInfo> varB4EAC82CA7396A68D541C85D26508E83_775986453 = null; 
        CompareResult<RouteInfo> result = new CompareResult<RouteInfo>();
        result.removed = new ArrayList<RouteInfo>(mRoutes);
        result.added.clear();
        {
            {
                Iterator<RouteInfo> var98E042D986256D5C143CD1D8775297CE_421953956 = (target.getRoutes()).iterator();
                var98E042D986256D5C143CD1D8775297CE_421953956.hasNext();
                RouteInfo r = var98E042D986256D5C143CD1D8775297CE_421953956.next();
                {
                    {
                        boolean varC873CBADB2439759A1631563A981C60B_1452793701 = (! result.removed.remove(r));
                        {
                            result.added.add(r);
                        } 
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_775986453 = result;
        addTaint(target.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_775986453.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_775986453;
        
        
        
        
        
            
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.165 -0400", hash_original_method = "28ECE8095E829F4615B9B35514C29B36", hash_generated_method = "0D28CEAEF25C1EFC9EC925C94C56FFA9")
    @Override
    public int hashCode() {
        int varE71D32073B9D953373F280788B927A4F_2146705307 = (((null == mIfaceName) ? 0 : mIfaceName.hashCode()
                + mLinkAddresses.size() * 31
                + mDnses.size() * 37
                + mRoutes.size() * 41
                + ((null == mHttpProxy) ? 0 : mHttpProxy.hashCode()))); 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1744373893 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1744373893;
        
        
                
                
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.174 -0400", hash_original_method = "FA484CCA03B27F5C12EABAE629DE360A", hash_generated_method = "B43594A97BF9FC4C54025DCBEE0CD7BB")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getInterfaceName());
        dest.writeInt(mLinkAddresses.size());
        {
            Iterator<LinkAddress> varDF96464DD29D4BD0B0137A05D67E51BB_2056093521 = (mLinkAddresses).iterator();
            varDF96464DD29D4BD0B0137A05D67E51BB_2056093521.hasNext();
            LinkAddress linkAddress = varDF96464DD29D4BD0B0137A05D67E51BB_2056093521.next();
            {
                dest.writeParcelable(linkAddress, flags);
            } 
        } 
        dest.writeInt(mDnses.size());
        {
            Iterator<InetAddress> varD0C0A861F30CBF0FE56B8F003A69B034_1899379892 = (mDnses).iterator();
            varD0C0A861F30CBF0FE56B8F003A69B034_1899379892.hasNext();
            InetAddress d = varD0C0A861F30CBF0FE56B8F003A69B034_1899379892.next();
            {
                dest.writeByteArray(d.getAddress());
            } 
        } 
        dest.writeInt(mRoutes.size());
        {
            Iterator<RouteInfo> var884AA7CBDA9AFAD5F88BFEB52967F598_2032094106 = (mRoutes).iterator();
            var884AA7CBDA9AFAD5F88BFEB52967F598_2032094106.hasNext();
            RouteInfo route = var884AA7CBDA9AFAD5F88BFEB52967F598_2032094106.next();
            {
                dest.writeParcelable(route, flags);
            } 
        } 
        {
            dest.writeByte((byte)1);
            dest.writeParcelable(mHttpProxy, flags);
        } 
        {
            dest.writeByte((byte)0);
        } 
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
        
            
        
        
        
            
        
        
        
            
        
        
            
            
        
            
        
    }

    
    public static class CompareResult<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.174 -0400", hash_original_field = "C4B1F39807DCA632860153E967535069", hash_generated_field = "656FE863E184B8E40AE962362C5E65EA")

        public Collection<T> removed = new ArrayList<T>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.174 -0400", hash_original_field = "CB13C543EE6E3E67C92366544BE592A7", hash_generated_field = "C6B74BD881B85CA2CE669431297F84E6")

        public Collection<T> added = new ArrayList<T>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.174 -0400", hash_original_method = "8B9C887FE92C246DB85CDDBCEEBB2CF3", hash_generated_method = "8B9C887FE92C246DB85CDDBCEEBB2CF3")
        public CompareResult ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.182 -0400", hash_original_method = "432CBAB98383F022B31745E1B8881CF6", hash_generated_method = "D5B78390E38AA71DA04E154217C70C04")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_18344896 = null; 
            String retVal = "removed=[";
            {
                Iterator<T> varC423D6E3AA0BA108FCAE25E1A62A868B_1121891572 = (removed).iterator();
                varC423D6E3AA0BA108FCAE25E1A62A868B_1121891572.hasNext();
                T addr = varC423D6E3AA0BA108FCAE25E1A62A868B_1121891572.next();
                retVal += addr.toString() + ",";
            } 
            retVal += "] added=[";
            {
                Iterator<T> var5AD5BD4A6E3B2EEAB3BA044D5B8651B9_1967917180 = (added).iterator();
                var5AD5BD4A6E3B2EEAB3BA044D5B8651B9_1967917180.hasNext();
                T addr = var5AD5BD4A6E3B2EEAB3BA044D5B8651B9_1967917180.next();
                retVal += addr.toString() + ",";
            } 
            retVal += "]";
            varB4EAC82CA7396A68D541C85D26508E83_18344896 = retVal;
            varB4EAC82CA7396A68D541C85D26508E83_18344896.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_18344896;
            
            
            
            
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.182 -0400", hash_original_field = "AD9F190960A42BD6F0B1EE16B7E966B8", hash_generated_field = "24691869BF8BBA8F28BDB834441D45F0")

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
    
}

