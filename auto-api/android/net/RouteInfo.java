package android.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import java.net.UnknownHostException;
import java.net.InetAddress;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.util.Collection;

public class RouteInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.970 -0400", hash_original_field = "20FA5FDA87CAF7DA2AF783B06FECA0CC", hash_generated_field = "E49ACA82B1444E6526072819A9167A9F")

    private LinkAddress mDestination;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.970 -0400", hash_original_field = "A3011FC9B1E2E4E1F51ADA03BB8E2709", hash_generated_field = "7CC3B75FF58A17722EF6B89CB1C05CD5")

    private InetAddress mGateway;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.970 -0400", hash_original_field = "75283F9EF09855A8ADC5A1F98FCF1F5C", hash_generated_field = "37F4FF220768DADFAC04D15463D51A4A")

    private boolean mIsDefault;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.970 -0400", hash_original_field = "E09EAA67E50D034EFD051379F631DEF3", hash_generated_field = "9DEB0F47D4D95D76C37945712CE421B8")

    private boolean mIsHost;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.970 -0400", hash_original_method = "E18B95CB9612527F42443FCFFAAF42E3", hash_generated_method = "4A479E104AF6D1B7B182ADAFA801B48A")
    public  RouteInfo(LinkAddress destination, InetAddress gateway) {
        {
            {
                {
                    destination = new LinkAddress(Inet4Address.ANY, 0);
                } 
                {
                    destination = new LinkAddress(Inet6Address.ANY, 0);
                } 
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Invalid arguments passed in.");
            } 
        } 
        {
            {
                boolean var9EBB9AD2F167F7EC69DAE24F357BC566_1024074520 = (destination.getAddress() instanceof Inet4Address);
                {
                    gateway = Inet4Address.ANY;
                } 
                {
                    gateway = Inet6Address.ANY;
                } 
            } 
        } 
        mDestination = new LinkAddress(NetworkUtils.getNetworkPart(destination.getAddress(),
                destination.getNetworkPrefixLength()), destination.getNetworkPrefixLength());
        mGateway = gateway;
        mIsDefault = isDefault();
        mIsHost = isHost();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.971 -0400", hash_original_method = "69D5DE546AFD98D206E268F1C948A647", hash_generated_method = "8FC1A9AD84B436766E8F7826A0FC6230")
    public  RouteInfo(InetAddress gateway) {
        this(null, gateway);
        addTaint(gateway.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    public static RouteInfo makeHostRoute(InetAddress host) {
        return makeHostRoute(host, null);
    }

    
    @DSModeled(DSC.SAFE)
    public static RouteInfo makeHostRoute(InetAddress host, InetAddress gateway) {
        if (host == null) return null;
        if (host instanceof Inet4Address) {
            return new RouteInfo(new LinkAddress(host, 32), gateway);
        } else {
            return new RouteInfo(new LinkAddress(host, 128), gateway);
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.972 -0400", hash_original_method = "BB5D6BF5854981BD1DD4B0D75DB6E8C7", hash_generated_method = "85A35C19503565F221E116DE6FA10A34")
    private boolean isHost() {
        boolean var47BFA14530C4B496D917771FE378958A_2038330170 = ((mGateway.equals(Inet4Address.ANY) || mGateway.equals(Inet6Address.ANY)));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1053450839 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1053450839;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.972 -0400", hash_original_method = "FAF1A1F97A113F82E8429CDDF8F77F02", hash_generated_method = "1576FBAD0B74327468AD811F0ACA266A")
    private boolean isDefault() {
        boolean val = false;
        {
            {
                val = (mDestination == null || mDestination.getNetworkPrefixLength() == 0);
            } 
            {
                val = (mDestination == null || mDestination.getNetworkPrefixLength() == 0);
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2116994630 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2116994630;
        
        
        
            
                
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.974 -0400", hash_original_method = "1DFF4C9A700CC3886F6C70CFCDBFA85F", hash_generated_method = "8FAAFFE04F176A878FE96503DC7A23BE")
    public LinkAddress getDestination() {
        LinkAddress varB4EAC82CA7396A68D541C85D26508E83_1208230535 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1208230535 = mDestination;
        varB4EAC82CA7396A68D541C85D26508E83_1208230535.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1208230535;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.974 -0400", hash_original_method = "EBF08E83FF9E78B73EDA9A9990BB8494", hash_generated_method = "9BF800A707FA7867B8444ECEE6F3903F")
    public InetAddress getGateway() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1224171908 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1224171908 = mGateway;
        varB4EAC82CA7396A68D541C85D26508E83_1224171908.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1224171908;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.975 -0400", hash_original_method = "E1C93CD9EE24D2AA8F06A9C7E7B28049", hash_generated_method = "6ACBC1270967F204A4AF39088727CF7A")
    public boolean isDefaultRoute() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1929579596 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1929579596;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.975 -0400", hash_original_method = "2A05D2869C11595F53C52D7E29A06E41", hash_generated_method = "9296F1421719C7BD49EA85CD6F3F0AEA")
    public boolean isHostRoute() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_954543082 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_954543082;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.976 -0400", hash_original_method = "0AA1B383C324478F235BB186C8938BCB", hash_generated_method = "2F16EFD633C9B1F0A528C2B7950EC759")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1159912834 = null; 
        String val = "";
        val = mDestination.toString();
        val += " -> " + mGateway.getHostAddress();
        varB4EAC82CA7396A68D541C85D26508E83_1159912834 = val;
        varB4EAC82CA7396A68D541C85D26508E83_1159912834.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1159912834;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.976 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "C0EDA5604A0A128FFD3FB752C828B4B7")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1585638789 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1585638789;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.976 -0400", hash_original_method = "75D0FB165031E3DBB8B900D70000DB62", hash_generated_method = "6D392BF5D3A58C86E54B925EE2822F35")
    public void writeToParcel(Parcel dest, int flags) {
        {
            dest.writeByte((byte) 0);
        } 
        {
            dest.writeByte((byte) 1);
            dest.writeByteArray(mDestination.getAddress().getAddress());
            dest.writeInt(mDestination.getNetworkPrefixLength());
        } 
        {
            dest.writeByte((byte) 0);
        } 
        {
            dest.writeByte((byte) 1);
            dest.writeByteArray(mGateway.getAddress());
        } 
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
            
        
            
            
            
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.977 -0400", hash_original_method = "5CF3A2DBAE721423A1CBA779912D2779", hash_generated_method = "110AAC0765ECB84C63D7BC167E447DB1")
    @Override
    public boolean equals(Object obj) {
        RouteInfo target = (RouteInfo) obj;
        boolean sameDestination;
        sameDestination = target.getDestination() == null;
        sameDestination = mDestination.equals(target.getDestination());
        boolean sameAddress;
        sameAddress = target.getGateway() == null;
        sameAddress = mGateway.equals(target.getGateway());
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1697424662 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1697424662;
        
        
        
        
        
                
                
        
                
                
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.977 -0400", hash_original_method = "BB776300BCED21F4485D8738DE0E6814", hash_generated_method = "CF3E68EE702452E11F274AA8693CBC69")
    @Override
    public int hashCode() {
        int varFECAFB0F1FEE2C4DF70A1FF7F20C39A7_1697787116 = ((mDestination == null ? 0 : mDestination.hashCode())
            + (mGateway == null ? 0 :mGateway.hashCode())
            + (mIsDefault ? 3 : 7)); 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_910839350 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_910839350;
        
        
            
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.978 -0400", hash_original_method = "CBA981572951BCD1DD27D7FBA4D7D8C9", hash_generated_method = "46ED3C7A72161DE68E1D0EB243F2643E")
    private boolean matches(InetAddress destination) {
        {
            boolean var159E492D9519415ECBACE0F2B303DC2A_2110032314 = (isDefault());
        } 
        InetAddress dstNet = NetworkUtils.getNetworkPart(destination,
                mDestination.getNetworkPrefixLength());
        boolean var99C6B9679C063B6179E46A7C4C28C68A_1964862655 = (mDestination.getAddress().equals(dstNet));
        addTaint(destination.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1143098153 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1143098153;
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    public static RouteInfo selectBestRoute(Collection<RouteInfo> routes, InetAddress dest) {
        if ((routes == null) || (dest == null)) return null;
        RouteInfo bestRoute = null;
        for (RouteInfo route : routes) {
            if (NetworkUtils.addressTypeMatches(route.mDestination.getAddress(), dest)) {
                if ((bestRoute != null) &&
                        (bestRoute.mDestination.getNetworkPrefixLength() >=
                        route.mDestination.getNetworkPrefixLength())) {
                    continue;
                }
                if (route.matches(dest)) bestRoute = route;
            }
        }
        return bestRoute;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.978 -0400", hash_original_field = "021D8C9C5A7781A8A38C32808BDD3610", hash_generated_field = "128F0AA00E42EAC56D7B0EF75CE1AD19")

    public static final Creator<RouteInfo> CREATOR =
        new Creator<RouteInfo>() {
        public RouteInfo createFromParcel(Parcel in) {
            InetAddress destAddr = null;
            int prefix = 0;
            InetAddress gateway = null;

            if (in.readByte() == 1) {
                byte[] addr = in.createByteArray();
                prefix = in.readInt();

                try {
                    destAddr = InetAddress.getByAddress(addr);
                } catch (UnknownHostException e) {}
            }

            if (in.readByte() == 1) {
                byte[] addr = in.createByteArray();

                try {
                    gateway = InetAddress.getByAddress(addr);
                } catch (UnknownHostException e) {}
            }

            LinkAddress dest = null;

            if (destAddr != null) {
                dest = new LinkAddress(destAddr, prefix);
            }

            return new RouteInfo(dest, gateway);
        }

        public RouteInfo[] newArray(int size) {
            return new RouteInfo[size];
        }
    };
    
    public RouteInfo createFromParcel(Parcel in) {
            InetAddress destAddr = null;
            int prefix = 0;
            InetAddress gateway = null;

            if (in.readByte() == 1) {
                byte[] addr = in.createByteArray();
                prefix = in.readInt();

                try {
                    destAddr = InetAddress.getByAddress(addr);
                } catch (UnknownHostException e) {}
            }

            if (in.readByte() == 1) {
                byte[] addr = in.createByteArray();

                try {
                    gateway = InetAddress.getByAddress(addr);
                } catch (UnknownHostException e) {}
            }

            LinkAddress dest = null;

            if (destAddr != null) {
                dest = new LinkAddress(destAddr, prefix);
            }

            return new RouteInfo(dest, gateway);
        }
    
    
    public RouteInfo[] newArray(int size) {
            return new RouteInfo[size];
        }
    
}

