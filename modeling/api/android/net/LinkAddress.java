package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.UnknownHostException;

import android.os.Parcel;
import android.os.Parcelable;

public class LinkAddress implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.999 -0400", hash_original_field = "B0BE06D5C388ED18692D43797B3D4462", hash_generated_field = "8FA213B8981AE83560DF995BD24C9D6A")

    public static final Creator<LinkAddress> CREATOR =
        new Creator<LinkAddress>() {
            @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.565 -0500", hash_original_method = "83B2C513933861A367E964D1BD3071CA", hash_generated_method = "433A3DB656F92B4C0F035F29F9FC8587")
        
public LinkAddress createFromParcel(Parcel in) {
                InetAddress address = null;
                int prefixLength = 0;
                if (in.readByte() == 1) {
                    try {
                        address = InetAddress.getByAddress(in.createByteArray());
                        prefixLength = in.readInt();
                    } catch (UnknownHostException e) { }
                }
                return new LinkAddress(address, prefixLength);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.569 -0500", hash_original_method = "F56764B2973FF5F5F2BA4C093D2C56A1", hash_generated_method = "8E9377E098BC033302C3052D7C842DAB")
        
public LinkAddress[] newArray(int size) {
                return new LinkAddress[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.535 -0500", hash_original_field = "FDCE7272CFC91A6374FBF7F54D5CC8E4", hash_generated_field = "220CE3F94E98B4B531A4938FAFF932C0")

    private  InetAddress address;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.537 -0500", hash_original_field = "1AA9974238E4283C84A2103371F7F10F", hash_generated_field = "084C50C9B5174447084CD13D800A5566")

    private  int prefixLength;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.540 -0500", hash_original_method = "E18970F19EA2BD1962AA6C76D20344B4", hash_generated_method = "41E2CE26583B356C20EED1A245A153D5")
    
public LinkAddress(InetAddress address, int prefixLength) {
        if (address == null || prefixLength < 0 ||
                ((address instanceof Inet4Address) && prefixLength > 32) ||
                (prefixLength > 128)) {
            throw new IllegalArgumentException("Bad LinkAddress params " + address +
                    prefixLength);
        }
        this.address = address;
        this.prefixLength = prefixLength;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.542 -0500", hash_original_method = "C1B2B41E8E3046D397247308090C2940", hash_generated_method = "E208BC43761C89A1603AE59E1D2387DA")
    
public LinkAddress(InterfaceAddress interfaceAddress) {
        this.address = interfaceAddress.getAddress();
        this.prefixLength = interfaceAddress.getNetworkPrefixLength();
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.544 -0500", hash_original_method = "5FAB79F8CDEEE71CFB15A1270E373FE2", hash_generated_method = "41184820433EEA60DC65BB7B286C78B8")
    
@Override
    public String toString() {
        return (address == null ? "" : (address.getHostAddress() + "/" + prefixLength));
    }

    /**
     * Compares this {@code LinkAddress} instance against the specified address
     * in {@code obj}. Two addresses are equal if their InetAddress and prefixLength
     * are equal
     *
     * @param obj the object to be tested for equality.
     * @return {@code true} if both objects are equal, {@code false} otherwise.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.547 -0500", hash_original_method = "22B797A588843480EFDE3E6D1B46B555", hash_generated_method = "9A894EF673B0CEEF38258473CC7F0635")
    
@Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LinkAddress)) {
            return false;
        }
        LinkAddress linkAddress = (LinkAddress) obj;
        return this.address.equals(linkAddress.address) &&
            this.prefixLength == linkAddress.prefixLength;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.549 -0500", hash_original_method = "9EA21E5C93FB30EF49C5DDE7580A80C1", hash_generated_method = "B2D785CFEE4549A27C27ED85B91F9CBF")
    
@Override
    /*
     * generate hashcode based on significant fields
     */
    public int hashCode() {
        return ((null == address) ? 0 : address.hashCode()) + prefixLength;
    }

    /**
     * Returns the InetAddress for this address.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.551 -0500", hash_original_method = "F0319BA9B19AC93124B00C2891893A52", hash_generated_method = "824B3030C6402BCEBDA9F70F4F75F58E")
    
public InetAddress getAddress() {
        return address;
    }

    /**
     * Get network prefix length
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.553 -0500", hash_original_method = "2E2106DAF5193DB540436A7E1AE68959", hash_generated_method = "7335CB03B4DBBE641112BD64B8954681")
    
public int getNetworkPrefixLength() {
        return prefixLength;
    }

    /**
     * Implement the Parcelable interface
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.556 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    /**
     * Implement the Parcelable interface.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.561 -0500", hash_original_method = "977238F2CE06FE4C6D167170C229C693", hash_generated_method = "7183DDBB0956A3DB834943941911A91C")
    
public void writeToParcel(Parcel dest, int flags) {
        if (address != null) {
            dest.writeByte((byte)1);
            dest.writeByteArray(address.getAddress());
            dest.writeInt(prefixLength);
        } else {
            dest.writeByte((byte)0);
        }
    }
    // orphaned legacy method
    public LinkAddress createFromParcel(Parcel in) {
                InetAddress address = null;
                int prefixLength = 0;
                if (in.readByte() == 1) {
                    try {
                        address = InetAddress.getByAddress(in.createByteArray());
                        prefixLength = in.readInt();
                    } catch (UnknownHostException e) { }
                }
                return new LinkAddress(address, prefixLength);
            }
    
    // orphaned legacy method
    public LinkAddress[] newArray(int size) {
                return new LinkAddress[size];
            }
    
}

