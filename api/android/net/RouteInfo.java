package android.net;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;

import android.os.Parcel;
import android.os.Parcelable;





public class RouteInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.216 -0400", hash_original_field = "20FA5FDA87CAF7DA2AF783B06FECA0CC", hash_generated_field = "E49ACA82B1444E6526072819A9167A9F")

    private LinkAddress mDestination;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.217 -0400", hash_original_field = "A3011FC9B1E2E4E1F51ADA03BB8E2709", hash_generated_field = "7CC3B75FF58A17722EF6B89CB1C05CD5")

    private InetAddress mGateway;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.217 -0400", hash_original_field = "75283F9EF09855A8ADC5A1F98FCF1F5C", hash_generated_field = "37F4FF220768DADFAC04D15463D51A4A")

    private boolean mIsDefault;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.217 -0400", hash_original_field = "E09EAA67E50D034EFD051379F631DEF3", hash_generated_field = "9DEB0F47D4D95D76C37945712CE421B8")

    private boolean mIsHost;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.218 -0400", hash_original_method = "E18B95CB9612527F42443FCFFAAF42E3", hash_generated_method = "A3E4B0436CD803812923ABBACF405CFE")
    public  RouteInfo(LinkAddress destination, InetAddress gateway) {
        if(destination == null)        
        {
            if(gateway != null)            
            {
                if(gateway instanceof Inet4Address)                
                {
                    destination = new LinkAddress(Inet4Address.ANY, 0);
                } //End block
                else
                {
                    destination = new LinkAddress(Inet6Address.ANY, 0);
                } //End block
            } //End block
            else
            {
                RuntimeException var0F436CE62D3E74AB33F0F05B1F07477A_1014350402 = new RuntimeException("Invalid arguments passed in.");
                var0F436CE62D3E74AB33F0F05B1F07477A_1014350402.addTaint(taint);
                throw var0F436CE62D3E74AB33F0F05B1F07477A_1014350402;
            } //End block
        } //End block
        if(gateway == null)        
        {
            if(destination.getAddress() instanceof Inet4Address)            
            {
                gateway = Inet4Address.ANY;
            } //End block
            else
            {
                gateway = Inet6Address.ANY;
            } //End block
        } //End block
        mDestination = new LinkAddress(NetworkUtils.getNetworkPart(destination.getAddress(),
                destination.getNetworkPrefixLength()), destination.getNetworkPrefixLength());
        mGateway = gateway;
        mIsDefault = isDefault();
        mIsHost = isHost();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.236 -0400", hash_original_method = "69D5DE546AFD98D206E268F1C948A647", hash_generated_method = "8FC1A9AD84B436766E8F7826A0FC6230")
    public  RouteInfo(InetAddress gateway) {
        this(null, gateway);
        addTaint(gateway.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    public static RouteInfo makeHostRoute(InetAddress host) {
        return makeHostRoute(host, null);
    }

    
    @DSModeled(DSC.BAN)
    public static RouteInfo makeHostRoute(InetAddress host, InetAddress gateway) {
        if (host == null) return null;
        if (host instanceof Inet4Address) {
            return new RouteInfo(new LinkAddress(host, 32), gateway);
        } else {
            return new RouteInfo(new LinkAddress(host, 128), gateway);
        }
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.237 -0400", hash_original_method = "BB5D6BF5854981BD1DD4B0D75DB6E8C7", hash_generated_method = "B48B433582A57B9A2023163683031997")
    private boolean isHost() {
        boolean varFF746EBC5176A4B2B72BB69BB861F7D2_1758220762 = ((mGateway.equals(Inet4Address.ANY) || mGateway.equals(Inet6Address.ANY)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2042308532 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2042308532;
        // ---------- Original Method ----------
        //return (mGateway.equals(Inet4Address.ANY) || mGateway.equals(Inet6Address.ANY));
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.237 -0400", hash_original_method = "FAF1A1F97A113F82E8429CDDF8F77F02", hash_generated_method = "76E1CBC74261849B270ABE1212C721A3")
    private boolean isDefault() {
        boolean val = false;
        if(mGateway != null)        
        {
            if(mGateway instanceof Inet4Address)            
            {
                val = (mDestination == null || mDestination.getNetworkPrefixLength() == 0);
            } //End block
            else
            {
                val = (mDestination == null || mDestination.getNetworkPrefixLength() == 0);
            } //End block
        } //End block
        boolean var3A6D0284E743DC4A9B86F97D6DD1A3BF_741829938 = (val);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1895252350 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1895252350;
        // ---------- Original Method ----------
        //boolean val = false;
        //if (mGateway != null) {
            //if (mGateway instanceof Inet4Address) {
                //val = (mDestination == null || mDestination.getNetworkPrefixLength() == 0);
            //} else {
                //val = (mDestination == null || mDestination.getNetworkPrefixLength() == 0);
            //}
        //}
        //return val;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.237 -0400", hash_original_method = "1DFF4C9A700CC3886F6C70CFCDBFA85F", hash_generated_method = "FA0CA5E40F8E771A63FCF523BDA84B16")
    public LinkAddress getDestination() {
LinkAddress var1651AAAB4F528E3F559D89910825A761_1235816825 =         mDestination;
        var1651AAAB4F528E3F559D89910825A761_1235816825.addTaint(taint);
        return var1651AAAB4F528E3F559D89910825A761_1235816825;
        // ---------- Original Method ----------
        //return mDestination;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.237 -0400", hash_original_method = "EBF08E83FF9E78B73EDA9A9990BB8494", hash_generated_method = "BF807F87417CEDF6268601BBD3B04BEC")
    public InetAddress getGateway() {
InetAddress var8DEDA131532E3CB530C9A7D0E0654CCE_1773637548 =         mGateway;
        var8DEDA131532E3CB530C9A7D0E0654CCE_1773637548.addTaint(taint);
        return var8DEDA131532E3CB530C9A7D0E0654CCE_1773637548;
        // ---------- Original Method ----------
        //return mGateway;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.238 -0400", hash_original_method = "E1C93CD9EE24D2AA8F06A9C7E7B28049", hash_generated_method = "00FB9C560D174A09DECCB35253C8C4C9")
    public boolean isDefaultRoute() {
        boolean var75283F9EF09855A8ADC5A1F98FCF1F5C_662093835 = (mIsDefault);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1225626099 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1225626099;
        // ---------- Original Method ----------
        //return mIsDefault;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.238 -0400", hash_original_method = "2A05D2869C11595F53C52D7E29A06E41", hash_generated_method = "522CE2E22E00E5E5F92588A5E61EFF9D")
    public boolean isHostRoute() {
        boolean varE09EAA67E50D034EFD051379F631DEF3_891064133 = (mIsHost);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_268891219 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_268891219;
        // ---------- Original Method ----------
        //return mIsHost;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.238 -0400", hash_original_method = "0AA1B383C324478F235BB186C8938BCB", hash_generated_method = "76DE9011E7DAC7EF7648B31AF2D4FF5F")
    public String toString() {
        String val = "";
        if(mDestination != null)        
        val = mDestination.toString();
        if(mGateway != null)        
        val += " -> " + mGateway.getHostAddress();
String varD943F4EF06EF0FF7F541DA63567F3076_547608906 =         val;
        varD943F4EF06EF0FF7F541DA63567F3076_547608906.addTaint(taint);
        return varD943F4EF06EF0FF7F541DA63567F3076_547608906;
        // ---------- Original Method ----------
        //String val = "";
        //if (mDestination != null) val = mDestination.toString();
        //if (mGateway != null) val += " -> " + mGateway.getHostAddress();
        //return val;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.238 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8FCD00A083F3FC1B346F407464379C55")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1722079254 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1694489213 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1694489213;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.238 -0400", hash_original_method = "75D0FB165031E3DBB8B900D70000DB62", hash_generated_method = "26E61C371F634F8FE7EEB224E2CCE504")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        if(mDestination == null)        
        {
            dest.writeByte((byte) 0);
        } //End block
        else
        {
            dest.writeByte((byte) 1);
            dest.writeByteArray(mDestination.getAddress().getAddress());
            dest.writeInt(mDestination.getNetworkPrefixLength());
        } //End block
        if(mGateway == null)        
        {
            dest.writeByte((byte) 0);
        } //End block
        else
        {
            dest.writeByte((byte) 1);
            dest.writeByteArray(mGateway.getAddress());
        } //End block
        // ---------- Original Method ----------
        //if (mDestination == null) {
            //dest.writeByte((byte) 0);
        //} else {
            //dest.writeByte((byte) 1);
            //dest.writeByteArray(mDestination.getAddress().getAddress());
            //dest.writeInt(mDestination.getNetworkPrefixLength());
        //}
        //if (mGateway == null) {
            //dest.writeByte((byte) 0);
        //} else {
            //dest.writeByte((byte) 1);
            //dest.writeByteArray(mGateway.getAddress());
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.239 -0400", hash_original_method = "5CF3A2DBAE721423A1CBA779912D2779", hash_generated_method = "BD40483FDD0F145B0E7A3F8F151CFBDD")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        if(this == obj)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_527903421 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1146425991 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1146425991;
        }
        if(!(obj instanceof RouteInfo))        
        {
        boolean var68934A3E9455FA72420237EB05902327_336258936 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1989744676 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1989744676;
        }
        RouteInfo target = (RouteInfo) obj;
        boolean sameDestination = ( mDestination == null) ?
                target.getDestination() == null
                : mDestination.equals(target.getDestination());
        boolean sameAddress = (mGateway == null) ?
                target.getGateway() == null
                : mGateway.equals(target.getGateway());
        boolean varC220D51DBB9ED6BFBE06E2A3D608BD3F_652412208 = (sameDestination && sameAddress
            && mIsDefault == target.mIsDefault);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2059029125 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2059029125;
        // ---------- Original Method ----------
        //if (this == obj) return true;
        //if (!(obj instanceof RouteInfo)) return false;
        //RouteInfo target = (RouteInfo) obj;
        //boolean sameDestination = ( mDestination == null) ?
                //target.getDestination() == null
                //: mDestination.equals(target.getDestination());
        //boolean sameAddress = (mGateway == null) ?
                //target.getGateway() == null
                //: mGateway.equals(target.getGateway());
        //return sameDestination && sameAddress
            //&& mIsDefault == target.mIsDefault;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.239 -0400", hash_original_method = "BB776300BCED21F4485D8738DE0E6814", hash_generated_method = "CF11CECF46D4EBC966C0C1052C068DEF")
    @Override
    public int hashCode() {
        int varEB7CF23688D390869F84D01BFB676E77_1495108065 = ((mDestination == null ? 0 : mDestination.hashCode())
            + (mGateway == null ? 0 :mGateway.hashCode())
            + (mIsDefault ? 3 : 7));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2060706236 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2060706236;
        // ---------- Original Method ----------
        //return (mDestination == null ? 0 : mDestination.hashCode())
            //+ (mGateway == null ? 0 :mGateway.hashCode())
            //+ (mIsDefault ? 3 : 7);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.239 -0400", hash_original_method = "CBA981572951BCD1DD27D7FBA4D7D8C9", hash_generated_method = "EDFC5D1A4CE193AB82DC377B26403EB9")
    private boolean matches(InetAddress destination) {
        addTaint(destination.getTaint());
        if(destination == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_912650514 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1856264700 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1856264700;
        }
        if(isDefault())        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1644693980 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_449379603 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_449379603;
        }
        InetAddress dstNet = NetworkUtils.getNetworkPart(destination,
                mDestination.getNetworkPrefixLength());
        boolean var08BA79ABE14C9DD356127E0F297B77F6_482725739 = (mDestination.getAddress().equals(dstNet));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1910711358 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1910711358;
        // ---------- Original Method ----------
        //if (destination == null) return false;
        //if (isDefault()) return true;
        //InetAddress dstNet = NetworkUtils.getNetworkPart(destination,
                //mDestination.getNetworkPrefixLength());
        //return mDestination.getAddress().equals(dstNet);
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.239 -0400", hash_original_field = "021D8C9C5A7781A8A38C32808BDD3610", hash_generated_field = "128F0AA00E42EAC56D7B0EF75CE1AD19")

    public static final Creator<RouteInfo> CREATOR =
        new Creator<RouteInfo>() {
        @DSModeled(DSC.BAN)
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

        @DSModeled(DSC.BAN)
        public RouteInfo[] newArray(int size) {
            return new RouteInfo[size];
        }
    };
    // orphaned legacy method
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
    
    // orphaned legacy method
    public RouteInfo[] newArray(int size) {
            return new RouteInfo[size];
        }
    
}

