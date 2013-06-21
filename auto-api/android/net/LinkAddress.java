package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.UnknownHostException;

public class LinkAddress implements Parcelable {
    private InetAddress address;
    private int prefixLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.792 -0400", hash_original_method = "E18970F19EA2BD1962AA6C76D20344B4", hash_generated_method = "9FC3F75304EEA42B78EE8937FA0C48FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkAddress(InetAddress address, int prefixLength) {
        dsTaint.addTaint(address.dsTaint);
        dsTaint.addTaint(prefixLength);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad LinkAddress params " + address +
                    prefixLength);
        } //End block
        // ---------- Original Method ----------
        //if (address == null || prefixLength < 0 ||
                //((address instanceof Inet4Address) && prefixLength > 32) ||
                //(prefixLength > 128)) {
            //throw new IllegalArgumentException("Bad LinkAddress params " + address +
                    //prefixLength);
        //}
        //this.address = address;
        //this.prefixLength = prefixLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.793 -0400", hash_original_method = "C1B2B41E8E3046D397247308090C2940", hash_generated_method = "97BA21EEE5A9A8A0EB3BD4DF22173F05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkAddress(InterfaceAddress interfaceAddress) {
        dsTaint.addTaint(interfaceAddress.dsTaint);
        this.address = interfaceAddress.getAddress();
        this.prefixLength = interfaceAddress.getNetworkPrefixLength();
        // ---------- Original Method ----------
        //this.address = interfaceAddress.getAddress();
        //this.prefixLength = interfaceAddress.getNetworkPrefixLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.793 -0400", hash_original_method = "5FAB79F8CDEEE71CFB15A1270E373FE2", hash_generated_method = "AC1480067655AA0D2FB9C98BCE708798")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varE67D8B96255E170511E524F2B40894F4_1151272401 = ((address == null ? "" : (address.getHostAddress() + "/" + prefixLength))); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (address == null ? "" : (address.getHostAddress() + "/" + prefixLength));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.793 -0400", hash_original_method = "22B797A588843480EFDE3E6D1B46B555", hash_generated_method = "B8604624471023147F3D932466EDAA4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        LinkAddress linkAddress;
        linkAddress = (LinkAddress) obj;
        boolean var195E25D4C8453452BE01B1BC7E2B7999_1546536715 = (this.address.equals(linkAddress.address) &&
            this.prefixLength == linkAddress.prefixLength);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(obj instanceof LinkAddress)) {
            //return false;
        //}
        //LinkAddress linkAddress = (LinkAddress) obj;
        //return this.address.equals(linkAddress.address) &&
            //this.prefixLength == linkAddress.prefixLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.794 -0400", hash_original_method = "9EA21E5C93FB30EF49C5DDE7580A80C1", hash_generated_method = "8221EC93A50E761D45EFD32CCD64B5F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var53C32C44D1879E92E4FF52253C962024_1850531669 = (((null == address) ? 0 : address.hashCode()) + prefixLength); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return ((null == address) ? 0 : address.hashCode()) + prefixLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.794 -0400", hash_original_method = "F0319BA9B19AC93124B00C2891893A52", hash_generated_method = "FC5E46BCF945F23313A97C581817054D")
    @DSModeled(DSC.SAFE)
    public InetAddress getAddress() {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.794 -0400", hash_original_method = "2E2106DAF5193DB540436A7E1AE68959", hash_generated_method = "77F57FB060087309CD13B9D6E403EFA9")
    @DSModeled(DSC.SAFE)
    public int getNetworkPrefixLength() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return prefixLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.794 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.799 -0400", hash_original_method = "977238F2CE06FE4C6D167170C229C693", hash_generated_method = "103E43329F0DC6ADE87F6E7949D67537")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        {
            dest.writeByte((byte)1);
            dest.writeByteArray(address.getAddress());
            dest.writeInt(prefixLength);
        } //End block
        {
            dest.writeByte((byte)0);
        } //End block
        // ---------- Original Method ----------
        //if (address != null) {
            //dest.writeByte((byte)1);
            //dest.writeByteArray(address.getAddress());
            //dest.writeInt(prefixLength);
        //} else {
            //dest.writeByte((byte)0);
        //}
    }

    
    public static final Creator<LinkAddress> CREATOR = new Creator<LinkAddress>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.801 -0400", hash_original_method = "83B2C513933861A367E964D1BD3071CA", hash_generated_method = "91B6AA9C3D944DA05DBEE5B55EAFE054")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LinkAddress createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            InetAddress address;
            address = null;
            int prefixLength;
            prefixLength = 0;
            {
                boolean varA34511E23A7BE70AFB33ABE4FC1AF4E2_998636558 = (in.readByte() == 1);
                {
                    try 
                    {
                        address = InetAddress.getByAddress(in.createByteArray());
                        prefixLength = in.readInt();
                    } //End block
                    catch (UnknownHostException e)
                    { }
                } //End block
            } //End collapsed parenthetic
            LinkAddress varD6C5F684EFE90B60C53E6E548F46E3B7_1530720471 = (new LinkAddress(address, prefixLength));
            return (LinkAddress)dsTaint.getTaint();
            // ---------- Original Method ----------
            //InetAddress address = null;
            //int prefixLength = 0;
            //if (in.readByte() == 1) {
                    //try {
                        //address = InetAddress.getByAddress(in.createByteArray());
                        //prefixLength = in.readInt();
                    //} catch (UnknownHostException e) { }
                //}
            //return new LinkAddress(address, prefixLength);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.802 -0400", hash_original_method = "F56764B2973FF5F5F2BA4C093D2C56A1", hash_generated_method = "438F216898AE5BFB8DB9C7327DA6BD4F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LinkAddress[] newArray(int size) {
            dsTaint.addTaint(size);
            LinkAddress[] var4BE3917B6F962E4E834F36356E9FB6D9_2137598487 = (new LinkAddress[size]);
            return (LinkAddress[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new LinkAddress[size];
        }

        
}; //Transformed anonymous class
}

