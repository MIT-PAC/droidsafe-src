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
    private LinkAddress mDestination;
    private InetAddress mGateway;
    private boolean mIsDefault;
    private boolean mIsHost;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.423 -0400", hash_original_method = "E18B95CB9612527F42443FCFFAAF42E3", hash_generated_method = "C8287DBE33E6BFE3CE737941F34F1B6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RouteInfo(LinkAddress destination, InetAddress gateway) {
        dsTaint.addTaint(gateway.dsTaint);
        dsTaint.addTaint(destination.dsTaint);
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
                boolean var9EBB9AD2F167F7EC69DAE24F357BC566_1738957835 = (destination.getAddress() instanceof Inet4Address);
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
        mIsDefault = isDefault();
        mIsHost = isHost();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.423 -0400", hash_original_method = "69D5DE546AFD98D206E268F1C948A647", hash_generated_method = "BAD51EC0B7EAC002E6705B0FEAD7EB78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RouteInfo(InetAddress gateway) {
        this(null, gateway);
        dsTaint.addTaint(gateway.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.424 -0400", hash_original_method = "BB5D6BF5854981BD1DD4B0D75DB6E8C7", hash_generated_method = "F45571B795D5D373A1EA9DDC7402246F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isHost() {
        boolean var47BFA14530C4B496D917771FE378958A_1401891694 = ((mGateway.equals(Inet4Address.ANY) || mGateway.equals(Inet6Address.ANY)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mGateway.equals(Inet4Address.ANY) || mGateway.equals(Inet6Address.ANY));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.424 -0400", hash_original_method = "FAF1A1F97A113F82E8429CDDF8F77F02", hash_generated_method = "B74E025FE7D3B8E169C72E34C0D83C46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.424 -0400", hash_original_method = "1DFF4C9A700CC3886F6C70CFCDBFA85F", hash_generated_method = "A69E4D67F18232388A09DD0B03467783")
    @DSModeled(DSC.SAFE)
    public LinkAddress getDestination() {
        return (LinkAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mDestination;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.424 -0400", hash_original_method = "EBF08E83FF9E78B73EDA9A9990BB8494", hash_generated_method = "6C3BD2D671F40D6E704F97F24D72E829")
    @DSModeled(DSC.SAFE)
    public InetAddress getGateway() {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mGateway;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.424 -0400", hash_original_method = "E1C93CD9EE24D2AA8F06A9C7E7B28049", hash_generated_method = "283E6ECACDBAE9C66E02C931BF524575")
    @DSModeled(DSC.SAFE)
    public boolean isDefaultRoute() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsDefault;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.425 -0400", hash_original_method = "2A05D2869C11595F53C52D7E29A06E41", hash_generated_method = "BC0651BA2C1186DCC2F77B280A8A80E5")
    @DSModeled(DSC.SAFE)
    public boolean isHostRoute() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.425 -0400", hash_original_method = "0AA1B383C324478F235BB186C8938BCB", hash_generated_method = "4A4953B9841803497D1060AF47C65182")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String val;
        val = "";
        val = mDestination.toString();
        val += " -> " + mGateway.getHostAddress();
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String val = "";
        //if (mDestination != null) val = mDestination.toString();
        //if (mGateway != null) val += " -> " + mGateway.getHostAddress();
        //return val;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.425 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.426 -0400", hash_original_method = "75D0FB165031E3DBB8B900D70000DB62", hash_generated_method = "073A11F2F03FB97A559D910F862CB612")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.426 -0400", hash_original_method = "5CF3A2DBAE721423A1CBA779912D2779", hash_generated_method = "497AF6B4F801AE357A219B2BD6614D4E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        RouteInfo target;
        target = (RouteInfo) obj;
        boolean sameDestination;
        sameDestination = target.getDestination() == null;
        sameDestination = mDestination.equals(target.getDestination());
        boolean sameAddress;
        sameAddress = target.getGateway() == null;
        sameAddress = mGateway.equals(target.getGateway());
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.426 -0400", hash_original_method = "BB776300BCED21F4485D8738DE0E6814", hash_generated_method = "EA4CC2B2B5D48E29DCC63888F0EF4068")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varFECAFB0F1FEE2C4DF70A1FF7F20C39A7_2093888655 = ((mDestination == null ? 0 : mDestination.hashCode())
            + (mGateway == null ? 0 :mGateway.hashCode())
            + (mIsDefault ? 3 : 7)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (mDestination == null ? 0 : mDestination.hashCode())
            //+ (mGateway == null ? 0 :mGateway.hashCode())
            //+ (mIsDefault ? 3 : 7);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.427 -0400", hash_original_method = "CBA981572951BCD1DD27D7FBA4D7D8C9", hash_generated_method = "C9248441ACB9664E115C363F885D403C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean matches(InetAddress destination) {
        dsTaint.addTaint(destination.dsTaint);
        {
            boolean var159E492D9519415ECBACE0F2B303DC2A_742836730 = (isDefault());
        } //End collapsed parenthetic
        InetAddress dstNet;
        dstNet = NetworkUtils.getNetworkPart(destination,
                mDestination.getNetworkPrefixLength());
        boolean var99C6B9679C063B6179E46A7C4C28C68A_1724040082 = (mDestination.getAddress().equals(dstNet));
        return dsTaint.getTaintBoolean();
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

    
    public static final Creator<RouteInfo> CREATOR = new Creator<RouteInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.428 -0400", hash_original_method = "F8D90C254555897C2A5C82BCD0750763", hash_generated_method = "ADAE25C73AFB087614899FC33B604C36")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RouteInfo createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            InetAddress destAddr;
            destAddr = null;
            int prefix;
            prefix = 0;
            InetAddress gateway;
            gateway = null;
            {
                boolean varA34511E23A7BE70AFB33ABE4FC1AF4E2_1382852655 = (in.readByte() == 1);
                {
                    byte[] addr;
                    addr = in.createByteArray();
                    prefix = in.readInt();
                    try 
                    {
                        destAddr = InetAddress.getByAddress(addr);
                    } //End block
                    catch (UnknownHostException e)
                    { }
                } //End block
            } //End collapsed parenthetic
            {
                boolean varA34511E23A7BE70AFB33ABE4FC1AF4E2_1931764841 = (in.readByte() == 1);
                {
                    byte[] addr;
                    addr = in.createByteArray();
                    try 
                    {
                        gateway = InetAddress.getByAddress(addr);
                    } //End block
                    catch (UnknownHostException e)
                    { }
                } //End block
            } //End collapsed parenthetic
            LinkAddress dest;
            dest = null;
            {
                dest = new LinkAddress(destAddr, prefix);
            } //End block
            RouteInfo var548F31B0A2DBCC33C0E197B231C43529_798462697 = (new RouteInfo(dest, gateway));
            return (RouteInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //InetAddress destAddr = null;
            //int prefix = 0;
            //InetAddress gateway = null;
            //if (in.readByte() == 1) {
                //byte[] addr = in.createByteArray();
                //prefix = in.readInt();
                //try {
                    //destAddr = InetAddress.getByAddress(addr);
                //} catch (UnknownHostException e) {}
            //}
            //if (in.readByte() == 1) {
                //byte[] addr = in.createByteArray();
                //try {
                    //gateway = InetAddress.getByAddress(addr);
                //} catch (UnknownHostException e) {}
            //}
            //LinkAddress dest = null;
            //if (destAddr != null) {
                //dest = new LinkAddress(destAddr, prefix);
            //}
            //return new RouteInfo(dest, gateway);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.429 -0400", hash_original_method = "FC2B57FC3E35651C4C9C65A6C1759C04", hash_generated_method = "75C43B179144A3832FB7DFD812840737")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RouteInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            RouteInfo[] varCEEBC9F9007D15DFF96F4C3F2867DBF4_877174510 = (new RouteInfo[size]);
            return (RouteInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new RouteInfo[size];
        }

        
}; //Transformed anonymous class
}

