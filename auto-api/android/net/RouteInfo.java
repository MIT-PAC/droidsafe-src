package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import java.net.UnknownHostException;
import java.net.InetAddress;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.util.Collection;

public class RouteInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.291 -0400", hash_original_field = "20FA5FDA87CAF7DA2AF783B06FECA0CC", hash_generated_field = "E49ACA82B1444E6526072819A9167A9F")

    private LinkAddress mDestination;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.291 -0400", hash_original_field = "A3011FC9B1E2E4E1F51ADA03BB8E2709", hash_generated_field = "7CC3B75FF58A17722EF6B89CB1C05CD5")

    private InetAddress mGateway;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.291 -0400", hash_original_field = "75283F9EF09855A8ADC5A1F98FCF1F5C", hash_generated_field = "37F4FF220768DADFAC04D15463D51A4A")

    private boolean mIsDefault;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.291 -0400", hash_original_field = "E09EAA67E50D034EFD051379F631DEF3", hash_generated_field = "9DEB0F47D4D95D76C37945712CE421B8")

    private boolean mIsHost;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.317 -0400", hash_original_method = "E18B95CB9612527F42443FCFFAAF42E3", hash_generated_method = "06DF0F4CECD4A22DBB1521B63B00D1CA")
    public  RouteInfo(LinkAddress destination, InetAddress gateway) {
        {
            {
                {
                    destination = new LinkAddress(Inet4Address.ANY, 0);
                } //End block
                {
                    destination = new LinkAddress(Inet6Address.ANY, 0);
                } //End block
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Invalid arguments passed in.");
            } //End block
        } //End block
        {
            {
                boolean var9EBB9AD2F167F7EC69DAE24F357BC566_1947070985 = (destination.getAddress() instanceof Inet4Address);
                {
                    gateway = Inet4Address.ANY;
                } //End block
                {
                    gateway = Inet6Address.ANY;
                } //End block
            } //End collapsed parenthetic
        } //End block
        mDestination = new LinkAddress(NetworkUtils.getNetworkPart(destination.getAddress(),
                destination.getNetworkPrefixLength()), destination.getNetworkPrefixLength());
        mGateway = gateway;
        mIsDefault = isDefault();
        mIsHost = isHost();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.320 -0400", hash_original_method = "69D5DE546AFD98D206E268F1C948A647", hash_generated_method = "8FC1A9AD84B436766E8F7826A0FC6230")
    public  RouteInfo(InetAddress gateway) {
        this(null, gateway);
        addTaint(gateway.getTaint());
        // ---------- Original Method ----------
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.322 -0400", hash_original_method = "BB5D6BF5854981BD1DD4B0D75DB6E8C7", hash_generated_method = "A60A0A3B79139B0822E560BADE813140")
    private boolean isHost() {
        boolean var47BFA14530C4B496D917771FE378958A_166648828 = ((mGateway.equals(Inet4Address.ANY) || mGateway.equals(Inet6Address.ANY)));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1280433885 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1280433885;
        // ---------- Original Method ----------
        //return (mGateway.equals(Inet4Address.ANY) || mGateway.equals(Inet6Address.ANY));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.323 -0400", hash_original_method = "FAF1A1F97A113F82E8429CDDF8F77F02", hash_generated_method = "E7CD7D8A2E7A216B8EFFA73D7BD7FB17")
    private boolean isDefault() {
        boolean val;
        val = false;
        {
            {
                val = (mDestination == null || mDestination.getNetworkPrefixLength() == 0);
            } //End block
            {
                val = (mDestination == null || mDestination.getNetworkPrefixLength() == 0);
            } //End block
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1546328540 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1546328540;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.323 -0400", hash_original_method = "1DFF4C9A700CC3886F6C70CFCDBFA85F", hash_generated_method = "AE54F84B819D6756C180A52E9C9CAEF7")
    public LinkAddress getDestination() {
        LinkAddress varB4EAC82CA7396A68D541C85D26508E83_1164927080 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1164927080 = mDestination;
        varB4EAC82CA7396A68D541C85D26508E83_1164927080.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1164927080;
        // ---------- Original Method ----------
        //return mDestination;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.346 -0400", hash_original_method = "EBF08E83FF9E78B73EDA9A9990BB8494", hash_generated_method = "10725AFEB432A2F87ABAFE745BD7B9B0")
    public InetAddress getGateway() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_974830333 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_974830333 = mGateway;
        varB4EAC82CA7396A68D541C85D26508E83_974830333.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_974830333;
        // ---------- Original Method ----------
        //return mGateway;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.347 -0400", hash_original_method = "E1C93CD9EE24D2AA8F06A9C7E7B28049", hash_generated_method = "E4D354F06C41F526439DED12DF6E1325")
    public boolean isDefaultRoute() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_241704421 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_241704421;
        // ---------- Original Method ----------
        //return mIsDefault;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.347 -0400", hash_original_method = "2A05D2869C11595F53C52D7E29A06E41", hash_generated_method = "D6C1FE6201998D44F8FFB5A6415C5966")
    public boolean isHostRoute() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_768423085 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_768423085;
        // ---------- Original Method ----------
        //return mIsHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.352 -0400", hash_original_method = "0AA1B383C324478F235BB186C8938BCB", hash_generated_method = "8EF059FBAF152EFB271B6E3D59D4FD0E")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_132081220 = null; //Variable for return #1
        String val;
        val = "";
        val = mDestination.toString();
        val += " -> " + mGateway.getHostAddress();
        varB4EAC82CA7396A68D541C85D26508E83_132081220 = val;
        varB4EAC82CA7396A68D541C85D26508E83_132081220.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_132081220;
        // ---------- Original Method ----------
        //String val = "";
        //if (mDestination != null) val = mDestination.toString();
        //if (mGateway != null) val += " -> " + mGateway.getHostAddress();
        //return val;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.353 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "2C23007324E68F6500273B170A0AB48D")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1008813026 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1008813026;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.378 -0400", hash_original_method = "75D0FB165031E3DBB8B900D70000DB62", hash_generated_method = "6D392BF5D3A58C86E54B925EE2822F35")
    public void writeToParcel(Parcel dest, int flags) {
        {
            dest.writeByte((byte) 0);
        } //End block
        {
            dest.writeByte((byte) 1);
            dest.writeByteArray(mDestination.getAddress().getAddress());
            dest.writeInt(mDestination.getNetworkPrefixLength());
        } //End block
        {
            dest.writeByte((byte) 0);
        } //End block
        {
            dest.writeByte((byte) 1);
            dest.writeByteArray(mGateway.getAddress());
        } //End block
        addTaint(dest.getTaint());
        addTaint(flags);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.380 -0400", hash_original_method = "5CF3A2DBAE721423A1CBA779912D2779", hash_generated_method = "397FDCD3F84C92B23B6720AB9AD9D7A4")
    @Override
    public boolean equals(Object obj) {
        RouteInfo target;
        target = (RouteInfo) obj;
        boolean sameDestination;
        sameDestination = target.getDestination() == null;
        sameDestination = mDestination.equals(target.getDestination());
        boolean sameAddress;
        sameAddress = target.getGateway() == null;
        sameAddress = mGateway.equals(target.getGateway());
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_40734502 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_40734502;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.408 -0400", hash_original_method = "BB776300BCED21F4485D8738DE0E6814", hash_generated_method = "5B7021BFC9BCAAC33A2A81B7F4A812FC")
    @Override
    public int hashCode() {
        int varFECAFB0F1FEE2C4DF70A1FF7F20C39A7_1055530385 = ((mDestination == null ? 0 : mDestination.hashCode())
            + (mGateway == null ? 0 :mGateway.hashCode())
            + (mIsDefault ? 3 : 7)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1307291922 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1307291922;
        // ---------- Original Method ----------
        //return (mDestination == null ? 0 : mDestination.hashCode())
            //+ (mGateway == null ? 0 :mGateway.hashCode())
            //+ (mIsDefault ? 3 : 7);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.409 -0400", hash_original_method = "CBA981572951BCD1DD27D7FBA4D7D8C9", hash_generated_method = "E64B0F1C3F6A971D6D46BCA00118B41B")
    private boolean matches(InetAddress destination) {
        {
            boolean var159E492D9519415ECBACE0F2B303DC2A_1343473464 = (isDefault());
        } //End collapsed parenthetic
        InetAddress dstNet;
        dstNet = NetworkUtils.getNetworkPart(destination,
                mDestination.getNetworkPrefixLength());
        boolean var99C6B9679C063B6179E46A7C4C28C68A_564817356 = (mDestination.getAddress().equals(dstNet));
        addTaint(destination.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1195307242 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1195307242;
        // ---------- Original Method ----------
        //if (destination == null) return false;
        //if (isDefault()) return true;
        //InetAddress dstNet = NetworkUtils.getNetworkPart(destination,
                //mDestination.getNetworkPrefixLength());
        //return mDestination.getAddress().equals(dstNet);
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.410 -0400", hash_original_field = "021D8C9C5A7781A8A38C32808BDD3610", hash_generated_field = "128F0AA00E42EAC56D7B0EF75CE1AD19")

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
}

