package android.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;
import java.net.UnknownHostException;
import java.net.InetAddress;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.util.Collection;

public class RouteInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.422 -0400", hash_original_field = "20FA5FDA87CAF7DA2AF783B06FECA0CC", hash_generated_field = "E49ACA82B1444E6526072819A9167A9F")

    private LinkAddress mDestination;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.423 -0400", hash_original_field = "A3011FC9B1E2E4E1F51ADA03BB8E2709", hash_generated_field = "7CC3B75FF58A17722EF6B89CB1C05CD5")

    private InetAddress mGateway;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.423 -0400", hash_original_field = "75283F9EF09855A8ADC5A1F98FCF1F5C", hash_generated_field = "37F4FF220768DADFAC04D15463D51A4A")

    private boolean mIsDefault;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.423 -0400", hash_original_field = "E09EAA67E50D034EFD051379F631DEF3", hash_generated_field = "9DEB0F47D4D95D76C37945712CE421B8")

    private boolean mIsHost;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.424 -0400", hash_original_method = "E18B95CB9612527F42443FCFFAAF42E3", hash_generated_method = "507A145437AA4B5FF3F0FE4682190968")
    public  RouteInfo(LinkAddress destination, InetAddress gateway) {
    if(destination == null)        
        {
    if(gateway != null)            
            {
    if(gateway instanceof Inet4Address)                
                {
                    destination = new LinkAddress(Inet4Address.ANY, 0);
                } 
                else
                {
                    destination = new LinkAddress(Inet6Address.ANY, 0);
                } 
            } 
            else
            {
                RuntimeException var0F436CE62D3E74AB33F0F05B1F07477A_1204708012 = new RuntimeException("Invalid arguments passed in.");
                var0F436CE62D3E74AB33F0F05B1F07477A_1204708012.addTaint(taint);
                throw var0F436CE62D3E74AB33F0F05B1F07477A_1204708012;
            } 
        } 
    if(gateway == null)        
        {
    if(destination.getAddress() instanceof Inet4Address)            
            {
                gateway = Inet4Address.ANY;
            } 
            else
            {
                gateway = Inet6Address.ANY;
            } 
        } 
        mDestination = new LinkAddress(NetworkUtils.getNetworkPart(destination.getAddress(),
                destination.getNetworkPrefixLength()), destination.getNetworkPrefixLength());
        mGateway = gateway;
        mIsDefault = isDefault();
        mIsHost = isHost();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.425 -0400", hash_original_method = "69D5DE546AFD98D206E268F1C948A647", hash_generated_method = "8FC1A9AD84B436766E8F7826A0FC6230")
    public  RouteInfo(InetAddress gateway) {
        this(null, gateway);
        addTaint(gateway.getTaint());
        
    }

    
        public static RouteInfo makeHostRoute(InetAddress host) {
        return makeHostRoute(host, null);
    }

    
        public static RouteInfo makeHostRoute(InetAddress host, InetAddress gateway) {
        if (host == null) return null;
        if (host instanceof Inet4Address) {
            return new RouteInfo(new LinkAddress(host, 32), gateway);
        } else {
            return new RouteInfo(new LinkAddress(host, 128), gateway);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.426 -0400", hash_original_method = "BB5D6BF5854981BD1DD4B0D75DB6E8C7", hash_generated_method = "393209D811B2CF7F1EB4A6B713489F18")
    private boolean isHost() {
        boolean varFF746EBC5176A4B2B72BB69BB861F7D2_1654392981 = ((mGateway.equals(Inet4Address.ANY) || mGateway.equals(Inet6Address.ANY)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_741197183 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_741197183;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.426 -0400", hash_original_method = "FAF1A1F97A113F82E8429CDDF8F77F02", hash_generated_method = "33723101ED37AB1E718582ADD799BED9")
    private boolean isDefault() {
        boolean val = false;
    if(mGateway != null)        
        {
    if(mGateway instanceof Inet4Address)            
            {
                val = (mDestination == null || mDestination.getNetworkPrefixLength() == 0);
            } 
            else
            {
                val = (mDestination == null || mDestination.getNetworkPrefixLength() == 0);
            } 
        } 
        boolean var3A6D0284E743DC4A9B86F97D6DD1A3BF_787690823 = (val);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1986459967 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1986459967;
        
        
        
            
                
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.427 -0400", hash_original_method = "1DFF4C9A700CC3886F6C70CFCDBFA85F", hash_generated_method = "E3C57887FB3CE120FB596600BC455F44")
    public LinkAddress getDestination() {
LinkAddress var1651AAAB4F528E3F559D89910825A761_176686523 =         mDestination;
        var1651AAAB4F528E3F559D89910825A761_176686523.addTaint(taint);
        return var1651AAAB4F528E3F559D89910825A761_176686523;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.427 -0400", hash_original_method = "EBF08E83FF9E78B73EDA9A9990BB8494", hash_generated_method = "7420C8EDAFEC503542F881B0D4B3EBE2")
    public InetAddress getGateway() {
InetAddress var8DEDA131532E3CB530C9A7D0E0654CCE_1280139257 =         mGateway;
        var8DEDA131532E3CB530C9A7D0E0654CCE_1280139257.addTaint(taint);
        return var8DEDA131532E3CB530C9A7D0E0654CCE_1280139257;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.427 -0400", hash_original_method = "E1C93CD9EE24D2AA8F06A9C7E7B28049", hash_generated_method = "29CC5695051D73657BFAD5A85A7E9595")
    public boolean isDefaultRoute() {
        boolean var75283F9EF09855A8ADC5A1F98FCF1F5C_91411230 = (mIsDefault);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1535293160 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1535293160;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.427 -0400", hash_original_method = "2A05D2869C11595F53C52D7E29A06E41", hash_generated_method = "F9299CEF47FE0D8C7E5D94C9824E6556")
    public boolean isHostRoute() {
        boolean varE09EAA67E50D034EFD051379F631DEF3_1223124370 = (mIsHost);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_950696249 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_950696249;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.428 -0400", hash_original_method = "0AA1B383C324478F235BB186C8938BCB", hash_generated_method = "3830B9FD8229CAA6894FEC8FD274140A")
    public String toString() {
        String val = "";
    if(mDestination != null)        
        val = mDestination.toString();
    if(mGateway != null)        
        val += " -> " + mGateway.getHostAddress();
String varD943F4EF06EF0FF7F541DA63567F3076_279096601 =         val;
        varD943F4EF06EF0FF7F541DA63567F3076_279096601.addTaint(taint);
        return varD943F4EF06EF0FF7F541DA63567F3076_279096601;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.429 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "A85A1E546B1FCB4232BF6841999EDAA5")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_494170455 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_196203679 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_196203679;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.429 -0400", hash_original_method = "75D0FB165031E3DBB8B900D70000DB62", hash_generated_method = "26E61C371F634F8FE7EEB224E2CCE504")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
    if(mDestination == null)        
        {
            dest.writeByte((byte) 0);
        } 
        else
        {
            dest.writeByte((byte) 1);
            dest.writeByteArray(mDestination.getAddress().getAddress());
            dest.writeInt(mDestination.getNetworkPrefixLength());
        } 
    if(mGateway == null)        
        {
            dest.writeByte((byte) 0);
        } 
        else
        {
            dest.writeByte((byte) 1);
            dest.writeByteArray(mGateway.getAddress());
        } 
        
        
            
        
            
            
            
        
        
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.430 -0400", hash_original_method = "5CF3A2DBAE721423A1CBA779912D2779", hash_generated_method = "21C64E86AD45ECAAB27C1DCBDF2A4ADD")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(this == obj)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_809405817 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2060528169 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2060528169;
        }
    if(!(obj instanceof RouteInfo))        
        {
        boolean var68934A3E9455FA72420237EB05902327_1772439284 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2115247760 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2115247760;
        }
        RouteInfo target = (RouteInfo) obj;
        boolean sameDestination = ( mDestination == null) ?
                target.getDestination() == null
                : mDestination.equals(target.getDestination());
        boolean sameAddress = (mGateway == null) ?
                target.getGateway() == null
                : mGateway.equals(target.getGateway());
        boolean varC220D51DBB9ED6BFBE06E2A3D608BD3F_2033924821 = (sameDestination && sameAddress
            && mIsDefault == target.mIsDefault);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1765727439 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1765727439;
        
        
        
        
        
                
                
        
                
                
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.430 -0400", hash_original_method = "BB776300BCED21F4485D8738DE0E6814", hash_generated_method = "174AF3F2F36257601A64D84CB69E5E3C")
    @Override
    public int hashCode() {
        int varEB7CF23688D390869F84D01BFB676E77_1081541055 = ((mDestination == null ? 0 : mDestination.hashCode())
            + (mGateway == null ? 0 :mGateway.hashCode())
            + (mIsDefault ? 3 : 7));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_626160653 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_626160653;
        
        
            
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.430 -0400", hash_original_method = "CBA981572951BCD1DD27D7FBA4D7D8C9", hash_generated_method = "FEF39BDA21E996D600252BC0FFB530FF")
    private boolean matches(InetAddress destination) {
        addTaint(destination.getTaint());
    if(destination == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1425247547 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1587972809 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1587972809;
        }
    if(isDefault())        
        {
        boolean varB326B5062B2F0E69046810717534CB09_379658504 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_305264132 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_305264132;
        }
        InetAddress dstNet = NetworkUtils.getNetworkPart(destination,
                mDestination.getNetworkPrefixLength());
        boolean var08BA79ABE14C9DD356127E0F297B77F6_723605513 = (mDestination.getAddress().equals(dstNet));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_264656200 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_264656200;
        
        
        
        
                
        
    }

    
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.431 -0400", hash_original_field = "021D8C9C5A7781A8A38C32808BDD3610", hash_generated_field = "128F0AA00E42EAC56D7B0EF75CE1AD19")

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

