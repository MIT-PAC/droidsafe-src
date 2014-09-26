package android.hardware.usb;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public class UsbEndpoint implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.975 -0400", hash_original_field = "1F925C8BDC204DFBE1A9F1D995B6F52C", hash_generated_field = "438080ABC723F019CBF0CEFAFA519D03")

    public static final Parcelable.Creator<UsbEndpoint> CREATOR =
        new Parcelable.Creator<UsbEndpoint>() {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.605 -0500", hash_original_method = "323905F66B13C283569D71986A498D60", hash_generated_method = "107124ED8732EDCEF79068D66A9C5BD8")
        
public UsbEndpoint createFromParcel(Parcel in) {
            int address = in.readInt();
            int attributes = in.readInt();
            int maxPacketSize = in.readInt();
            int interval = in.readInt();
            return new UsbEndpoint(address, attributes, maxPacketSize, interval);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.607 -0500", hash_original_method = "466BB637EFE2303F0F935A9C778A4B5F", hash_generated_method = "B1A32AA15B6F386657379BE60418FC46")
        
public UsbEndpoint[] newArray(int size) {
            return new UsbEndpoint[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.572 -0500", hash_original_field = "C6748DE6B660DCB404EDCE764B192848", hash_generated_field = "1BE2BFB4A5E404FE17164B090FF85336")

    private  int mAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.574 -0500", hash_original_field = "618475F66B903113A1196A9C310B4562", hash_generated_field = "38E582B0031888860D19E53B65089433")

    private  int mAttributes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.576 -0500", hash_original_field = "D8BB4152BA1F1453839020FDFED7ADC5", hash_generated_field = "8952F4B8923F9E4C8C48FDFD4E227622")

    private  int mMaxPacketSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.579 -0500", hash_original_field = "9B30FDD4E41572A77BBD2E1BDEF8E30F", hash_generated_field = "74B0CD5DC79AAA2AADBA9285C7DC7647")

    private  int mInterval;

    /**
     * UsbEndpoint should only be instantiated by UsbService implementation
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.582 -0500", hash_original_method = "DE7C1D5317206A67C09F18E7BB17C60A", hash_generated_method = "1AFC289BC5BEC6DC5DDE2665C4774E26")
    
public UsbEndpoint(int address, int attributes, int maxPacketSize, int interval) {
        mAddress = address;
        mAttributes = attributes;
        mMaxPacketSize = maxPacketSize;
        mInterval = interval;
    }

    /**
     * Returns the endpoint's address field.
     * The address is a bitfield containing both the endpoint number
     * as well as the data direction of the endpoint.
     * the endpoint number and direction can also be accessed via
     * {@link #getEndpointNumber} and {@link #getDirection}.
     *
     * @return the endpoint's address
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.584 -0500", hash_original_method = "1ACE37C7AEF4979E99CF3DA88C3DB9F0", hash_generated_method = "28CCA00BE74BC393741988210C125FFA")
    
public int getAddress() {
        return mAddress;
    }

    /**
     * Extracts the endpoint's endpoint number from its address
     *
     * @return the endpoint's endpoint number
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.586 -0500", hash_original_method = "530E1C5174A47AC9C94137EACF355AFA", hash_generated_method = "7D4D27C38834323CA2543A986FCC32C1")
    
public int getEndpointNumber() {
        return mAddress & UsbConstants.USB_ENDPOINT_NUMBER_MASK;
    }

    /**
     * Returns the endpoint's direction.
     * Returns {@link UsbConstants#USB_DIR_OUT}
     * if the direction is host to device, and
     * {@link UsbConstants#USB_DIR_IN} if the
     * direction is device to host.
     * @see {@link UsbConstants#USB_DIR_IN}
     * @see {@link UsbConstants#USB_DIR_OUT}
     *
     * @return the endpoint's direction
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.589 -0500", hash_original_method = "5E2273EF2E39AF02B90546F0D57EC6D9", hash_generated_method = "A1FA6ABD86A2E814DA6C5A9F8B4D0E15")
    
public int getDirection() {
        return mAddress & UsbConstants.USB_ENDPOINT_DIR_MASK;
    }

    /**
     * Returns the endpoint's attributes field.
     *
     * @return the endpoint's attributes
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.591 -0500", hash_original_method = "36DAD0B9D253F08C19BBEFC651F6D4C9", hash_generated_method = "52C6D23851DC7FAA7602943CDF2520C5")
    
public int getAttributes() {
        return mAttributes;
    }

    /**
     * Returns the endpoint's type.
     * Possible results are:
     * <ul>
     * <li>{@link UsbConstants#USB_ENDPOINT_XFER_CONTROL} (endpoint zero)
     * <li>{@link UsbConstants#USB_ENDPOINT_XFER_ISOC} (isochronous endpoint)
     * <li>{@link UsbConstants#USB_ENDPOINT_XFER_BULK} (bulk endpoint)
     * <li>{@link UsbConstants#USB_ENDPOINT_XFER_INT} (interrupt endpoint)
     * </ul>
     *
     * @return the endpoint's type
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.593 -0500", hash_original_method = "ED0BDC5BE5FF0D5E260DB90C1E62D731", hash_generated_method = "662A8CEFE36E97D50AA6ACD7AB54FAD3")
    
public int getType() {
        return mAttributes & UsbConstants.USB_ENDPOINT_XFERTYPE_MASK;
    }

    /**
     * Returns the endpoint's maximum packet size.
     *
     * @return the endpoint's maximum packet size
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.596 -0500", hash_original_method = "E96412E34BF386D230BE1BA24C763C9C", hash_generated_method = "934C9BF7293BED5FEDD7D180EF63ECD2")
    
public int getMaxPacketSize() {
        return mMaxPacketSize;
    }

    /**
     * Returns the endpoint's interval field.
     *
     * @return the endpoint's interval
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.598 -0500", hash_original_method = "C237023D57B3F5BEEDC74CA45F45E95A", hash_generated_method = "72B739C4D3EAC363EFDB462B8A990D23")
    
public int getInterval() {
        return mInterval;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.601 -0500", hash_original_method = "B003A6A19E3A4AFD160CE93D619076F2", hash_generated_method = "C828B4354E2E02A9A2E234DF2219ED2C")
    
@Override
    public String toString() {
        return "UsbEndpoint[mAddress=" + mAddress + ",mAttributes=" + mAttributes +
                ",mMaxPacketSize=" + mMaxPacketSize + ",mInterval=" + mInterval +"]";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.612 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.615 -0500", hash_original_method = "BC3F7EF4329C93155CA4CAEEEA5C5049", hash_generated_method = "7FF4DE9DA29A7D67905EC884A7CD52C1")
    
public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(mAddress);
        parcel.writeInt(mAttributes);
        parcel.writeInt(mMaxPacketSize);
        parcel.writeInt(mInterval);
   }
    // orphaned legacy method
    public UsbEndpoint createFromParcel(Parcel in) {
            int address = in.readInt();
            int attributes = in.readInt();
            int maxPacketSize = in.readInt();
            int interval = in.readInt();
            return new UsbEndpoint(address, attributes, maxPacketSize, interval);
        }
    
    // orphaned legacy method
    public UsbEndpoint[] newArray(int size) {
            return new UsbEndpoint[size];
        }
    
}

