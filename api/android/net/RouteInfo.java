package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;

import android.os.Parcel;
import android.os.Parcelable;

public class RouteInfo implements Parcelable {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.040 -0500", hash_original_method = "47DE57C9E0058D54F0DCCD6C2FCBB66B", hash_generated_method = "F7BB8525EDAD235BDEE16189A33C325D")
    
public static RouteInfo makeHostRoute(InetAddress host) {
        return makeHostRoute(host, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.043 -0500", hash_original_method = "04534EFC09D172FC5FF477624B7F71E2", hash_generated_method = "0903DD28D2BC721744918F957AE77ABA")
    
public static RouteInfo makeHostRoute(InetAddress host, InetAddress gateway) {
        if (host == null) return null;

        if (host instanceof Inet4Address) {
            return new RouteInfo(new LinkAddress(host, 32), gateway);
        } else {
            return new RouteInfo(new LinkAddress(host, 128), gateway);
        }
    }

    /**
     * Find the route from a Collection of routes that best matches a given address.
     * May return null if no routes are applicable.
     * @param routes a Collection of RouteInfos to chose from
     * @param dest the InetAddress your trying to get to
     * @return the RouteInfo from the Collection that best fits the given address
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.082 -0500", hash_original_method = "71B2FD618F41F3F10AED78DDC584C5B5", hash_generated_method = "D5C1464D9CBFFD7FDEF25798ABF91481")
    
public static RouteInfo selectBestRoute(Collection<RouteInfo> routes, InetAddress dest) {
        if ((routes == null) || (dest == null)) return null;

        RouteInfo bestRoute = null;
        // pick a longest prefix match under same address type
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
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.072 -0500", hash_original_method = "F8D90C254555897C2A5C82BCD0750763", hash_generated_method = "98FB3B478593285346CEEFC12952379E")
        
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.074 -0500", hash_original_method = "FC2B57FC3E35651C4C9C65A6C1759C04", hash_generated_method = "1BFC89B539412FC84BE22014A9D1A059")
        
public RouteInfo[] newArray(int size) {
            return new RouteInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.025 -0500", hash_original_field = "1E6D3BAA5597D7178B19E1AF3552B259", hash_generated_field = "E49ACA82B1444E6526072819A9167A9F")

    private  LinkAddress mDestination;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.027 -0500", hash_original_field = "76BAF2516020856D10FCEA6359BB42C5", hash_generated_field = "7CC3B75FF58A17722EF6B89CB1C05CD5")

    private  InetAddress mGateway;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.030 -0500", hash_original_field = "5C871AF21542173A28C29252E3E74C6D", hash_generated_field = "37F4FF220768DADFAC04D15463D51A4A")

    private  boolean mIsDefault;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.032 -0500", hash_original_field = "CC3FF6C4EC784CE444E6560833F03CEC", hash_generated_field = "9DEB0F47D4D95D76C37945712CE421B8")

    private  boolean mIsHost;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.035 -0500", hash_original_method = "E18B95CB9612527F42443FCFFAAF42E3", hash_generated_method = "5ECDA717B22C27E2EB67D7827679FD0A")
    
public RouteInfo(LinkAddress destination, InetAddress gateway) {
        if (destination == null) {
            if (gateway != null) {
                if (gateway instanceof Inet4Address) {
                    destination = new LinkAddress(Inet4Address.ANY, 0);
                } else {
                    destination = new LinkAddress(Inet6Address.ANY, 0);
                }
            } else {
                // no destination, no gateway. invalid.
                throw new RuntimeException("Invalid arguments passed in.");
            }
        }
        if (gateway == null) {
            if (destination.getAddress() instanceof Inet4Address) {
                gateway = Inet4Address.ANY;
            } else {
                gateway = Inet6Address.ANY;
            }
        }
        mDestination = new LinkAddress(NetworkUtils.getNetworkPart(destination.getAddress(),
                destination.getNetworkPrefixLength()), destination.getNetworkPrefixLength());
        mGateway = gateway;
        mIsDefault = isDefault();
        mIsHost = isHost();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.038 -0500", hash_original_method = "69D5DE546AFD98D206E268F1C948A647", hash_generated_method = "26117A540DBC9451C4E35B02746B81AE")
    
public RouteInfo(InetAddress gateway) {
        this(null, gateway);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.045 -0500", hash_original_method = "BB5D6BF5854981BD1DD4B0D75DB6E8C7", hash_generated_method = "AF491B167AB4E8B5800D256F530C9872")
    
private boolean isHost() {
        return (mGateway.equals(Inet4Address.ANY) || mGateway.equals(Inet6Address.ANY));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.047 -0500", hash_original_method = "FAF1A1F97A113F82E8429CDDF8F77F02", hash_generated_method = "1414C670869536BE8A0CB973924FD4AF")
    
private boolean isDefault() {
        boolean val = false;
        if (mGateway != null) {
            if (mGateway instanceof Inet4Address) {
                val = (mDestination == null || mDestination.getNetworkPrefixLength() == 0);
            } else {
                val = (mDestination == null || mDestination.getNetworkPrefixLength() == 0);
            }
        }
        return val;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.049 -0500", hash_original_method = "1DFF4C9A700CC3886F6C70CFCDBFA85F", hash_generated_method = "AFA3FBEF4C70A0EA4281450697C789A6")
    
public LinkAddress getDestination() {
        return mDestination;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.051 -0500", hash_original_method = "EBF08E83FF9E78B73EDA9A9990BB8494", hash_generated_method = "4C54B4C28077AFC9A5FA43B4F820BE9B")
    
public InetAddress getGateway() {
        return mGateway;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.053 -0500", hash_original_method = "E1C93CD9EE24D2AA8F06A9C7E7B28049", hash_generated_method = "11A7DA9768005482B144D921E685EC2A")
    
public boolean isDefaultRoute() {
        return mIsDefault;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.056 -0500", hash_original_method = "2A05D2869C11595F53C52D7E29A06E41", hash_generated_method = "F28935E9E7C3CFACC7A6DAD1F15127F1")
    
public boolean isHostRoute() {
        return mIsHost;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.058 -0500", hash_original_method = "0AA1B383C324478F235BB186C8938BCB", hash_generated_method = "5985ABF7D6D567CD2FECE2ECFED41D03")
    
public String toString() {
        String val = "";
        if (mDestination != null) val = mDestination.toString();
        if (mGateway != null) val += " -> " + mGateway.getHostAddress();
        return val;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.060 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.063 -0500", hash_original_method = "75D0FB165031E3DBB8B900D70000DB62", hash_generated_method = "EAB76EC13E081189F33F92B93D713E77")
    
public void writeToParcel(Parcel dest, int flags) {
        if (mDestination == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeByteArray(mDestination.getAddress().getAddress());
            dest.writeInt(mDestination.getNetworkPrefixLength());
        }

        if (mGateway == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeByteArray(mGateway.getAddress());
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.066 -0500", hash_original_method = "5CF3A2DBAE721423A1CBA779912D2779", hash_generated_method = "EFBDB305BB41EFA77361E4C575C44002")
    
@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof RouteInfo)) return false;

        RouteInfo target = (RouteInfo) obj;

        boolean sameDestination = ( mDestination == null) ?
                target.getDestination() == null
                : mDestination.equals(target.getDestination());

        boolean sameAddress = (mGateway == null) ?
                target.getGateway() == null
                : mGateway.equals(target.getGateway());

        return sameDestination && sameAddress
            && mIsDefault == target.mIsDefault;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.068 -0500", hash_original_method = "BB776300BCED21F4485D8738DE0E6814", hash_generated_method = "863F1A86F0621A862C5F03CF0507DBEE")
    
@Override
    public int hashCode() {
        return (mDestination == null ? 0 : mDestination.hashCode())
            + (mGateway == null ? 0 :mGateway.hashCode())
            + (mIsDefault ? 3 : 7);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:07.079 -0500", hash_original_method = "CBA981572951BCD1DD27D7FBA4D7D8C9", hash_generated_method = "E9448F3667D5DD37904240312F4F5ADA")
    
private boolean matches(InetAddress destination) {
        if (destination == null) return false;

        // if the destination is present and the route is default.
        // return true
        if (isDefault()) return true;

        // match the route destination and destination with prefix length
        InetAddress dstNet = NetworkUtils.getNetworkPart(destination,
                mDestination.getNetworkPrefixLength());

        return mDestination.getAddress().equals(dstNet);
    }
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

