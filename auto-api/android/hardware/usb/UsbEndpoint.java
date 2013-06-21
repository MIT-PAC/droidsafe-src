package android.hardware.usb;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class UsbEndpoint implements Parcelable {
    private int mAddress;
    private int mAttributes;
    private int mMaxPacketSize;
    private int mInterval;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.120 -0400", hash_original_method = "DE7C1D5317206A67C09F18E7BB17C60A", hash_generated_method = "76C49497A21B4230EA4CE06FFFE22997")
    @DSModeled(DSC.SAFE)
    public UsbEndpoint(int address, int attributes, int maxPacketSize, int interval) {
        dsTaint.addTaint(interval);
        dsTaint.addTaint(address);
        dsTaint.addTaint(attributes);
        dsTaint.addTaint(maxPacketSize);
        // ---------- Original Method ----------
        //mAddress = address;
        //mAttributes = attributes;
        //mMaxPacketSize = maxPacketSize;
        //mInterval = interval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.121 -0400", hash_original_method = "1ACE37C7AEF4979E99CF3DA88C3DB9F0", hash_generated_method = "1B12EDB62D6222D24D1D610A6D16D95E")
    @DSModeled(DSC.SAFE)
    public int getAddress() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.121 -0400", hash_original_method = "530E1C5174A47AC9C94137EACF355AFA", hash_generated_method = "F64CE727DB859CD52E81F29072C05D44")
    @DSModeled(DSC.SAFE)
    public int getEndpointNumber() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAddress & UsbConstants.USB_ENDPOINT_NUMBER_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.121 -0400", hash_original_method = "5E2273EF2E39AF02B90546F0D57EC6D9", hash_generated_method = "E5BB70F03FE5E0E43409710D8BD3B1E6")
    @DSModeled(DSC.SAFE)
    public int getDirection() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAddress & UsbConstants.USB_ENDPOINT_DIR_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.122 -0400", hash_original_method = "36DAD0B9D253F08C19BBEFC651F6D4C9", hash_generated_method = "01B1006A9BCCBB0AA0EA66E1CD41A347")
    @DSModeled(DSC.SAFE)
    public int getAttributes() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAttributes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.122 -0400", hash_original_method = "ED0BDC5BE5FF0D5E260DB90C1E62D731", hash_generated_method = "9F19DCAB7E2F83A546F3FE3545D3B5C3")
    @DSModeled(DSC.SAFE)
    public int getType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAttributes & UsbConstants.USB_ENDPOINT_XFERTYPE_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.122 -0400", hash_original_method = "E96412E34BF386D230BE1BA24C763C9C", hash_generated_method = "5C26A3DA24877C0353466F3486B6A835")
    @DSModeled(DSC.SAFE)
    public int getMaxPacketSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMaxPacketSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.123 -0400", hash_original_method = "C237023D57B3F5BEEDC74CA45F45E95A", hash_generated_method = "B5D867DC1068F500F22B8CA5B15BF53E")
    @DSModeled(DSC.SAFE)
    public int getInterval() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mInterval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.123 -0400", hash_original_method = "B003A6A19E3A4AFD160CE93D619076F2", hash_generated_method = "A6114BC60A0AD20468727648C35F59DA")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "UsbEndpoint[mAddress=" + mAddress + ",mAttributes=" + mAttributes +
                //",mMaxPacketSize=" + mMaxPacketSize + ",mInterval=" + mInterval +"]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.123 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.124 -0400", hash_original_method = "BC3F7EF4329C93155CA4CAEEEA5C5049", hash_generated_method = "034683E83061BE3E4724CBBE37FEF2BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel parcel, int flags) {
        dsTaint.addTaint(parcel.dsTaint);
        dsTaint.addTaint(flags);
        parcel.writeInt(mAddress);
        parcel.writeInt(mAttributes);
        parcel.writeInt(mMaxPacketSize);
        parcel.writeInt(mInterval);
        // ---------- Original Method ----------
        //parcel.writeInt(mAddress);
        //parcel.writeInt(mAttributes);
        //parcel.writeInt(mMaxPacketSize);
        //parcel.writeInt(mInterval);
    }

    
    public static final Parcelable.Creator<UsbEndpoint> CREATOR = new Parcelable.Creator<UsbEndpoint>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.124 -0400", hash_original_method = "323905F66B13C283569D71986A498D60", hash_generated_method = "073775DD995B2D674F9EBF669242EB4A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public UsbEndpoint createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            int address;
            address = in.readInt();
            int attributes;
            attributes = in.readInt();
            int maxPacketSize;
            maxPacketSize = in.readInt();
            int interval;
            interval = in.readInt();
            UsbEndpoint var6D893EC7ED9BD789F5A80604CF498752_954274921 = (new UsbEndpoint(address, attributes, maxPacketSize, interval));
            return (UsbEndpoint)dsTaint.getTaint();
            // ---------- Original Method ----------
            //int address = in.readInt();
            //int attributes = in.readInt();
            //int maxPacketSize = in.readInt();
            //int interval = in.readInt();
            //return new UsbEndpoint(address, attributes, maxPacketSize, interval);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.124 -0400", hash_original_method = "466BB637EFE2303F0F935A9C778A4B5F", hash_generated_method = "C674360426AB5D3AE147F311A1380AA4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public UsbEndpoint[] newArray(int size) {
            dsTaint.addTaint(size);
            UsbEndpoint[] varA107765A472910C89996F55A256129D9_1144091483 = (new UsbEndpoint[size]);
            return (UsbEndpoint[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UsbEndpoint[size];
        }

        
}; //Transformed anonymous class
}

