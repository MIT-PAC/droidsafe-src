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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.924 -0400", hash_original_field = "9C8E67CB570F7F2DF167C544686B922A", hash_generated_field = "1BE2BFB4A5E404FE17164B090FF85336")

    private int mAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.925 -0400", hash_original_field = "57D8B4049AE5C9E100E84EE9D1F3BF3E", hash_generated_field = "38E582B0031888860D19E53B65089433")

    private int mAttributes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.925 -0400", hash_original_field = "01BE87558ED87E26957E94A9074FFDC0", hash_generated_field = "8952F4B8923F9E4C8C48FDFD4E227622")

    private int mMaxPacketSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.925 -0400", hash_original_field = "DA2A452A82BCAB083D9BBB9CCC9A14CA", hash_generated_field = "74B0CD5DC79AAA2AADBA9285C7DC7647")

    private int mInterval;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.930 -0400", hash_original_method = "DE7C1D5317206A67C09F18E7BB17C60A", hash_generated_method = "9275E1A01A6F3627508892E18D01B491")
    public  UsbEndpoint(int address, int attributes, int maxPacketSize, int interval) {
        mAddress = address;
        mAttributes = attributes;
        mMaxPacketSize = maxPacketSize;
        mInterval = interval;
        // ---------- Original Method ----------
        //mAddress = address;
        //mAttributes = attributes;
        //mMaxPacketSize = maxPacketSize;
        //mInterval = interval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.930 -0400", hash_original_method = "1ACE37C7AEF4979E99CF3DA88C3DB9F0", hash_generated_method = "1D1DBFCFF423C523FED83D89AB597960")
    public int getAddress() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_515054707 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_515054707;
        // ---------- Original Method ----------
        //return mAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.948 -0400", hash_original_method = "530E1C5174A47AC9C94137EACF355AFA", hash_generated_method = "F45D1DB3E4366BC214BB4FAC0B229E23")
    public int getEndpointNumber() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1870285957 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1870285957;
        // ---------- Original Method ----------
        //return mAddress & UsbConstants.USB_ENDPOINT_NUMBER_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.949 -0400", hash_original_method = "5E2273EF2E39AF02B90546F0D57EC6D9", hash_generated_method = "EB5E524B033716045BCFE2FCC9077C96")
    public int getDirection() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_874020283 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_874020283;
        // ---------- Original Method ----------
        //return mAddress & UsbConstants.USB_ENDPOINT_DIR_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.949 -0400", hash_original_method = "36DAD0B9D253F08C19BBEFC651F6D4C9", hash_generated_method = "F8E0CB7E43D6EB1C3A32433CA4DAB73B")
    public int getAttributes() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1902062216 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1902062216;
        // ---------- Original Method ----------
        //return mAttributes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.949 -0400", hash_original_method = "ED0BDC5BE5FF0D5E260DB90C1E62D731", hash_generated_method = "562D96EF599ABEA51BD46E76DA82849B")
    public int getType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1563162424 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1563162424;
        // ---------- Original Method ----------
        //return mAttributes & UsbConstants.USB_ENDPOINT_XFERTYPE_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.950 -0400", hash_original_method = "E96412E34BF386D230BE1BA24C763C9C", hash_generated_method = "49848B16A9F21DD65DCC6C73C4C917F8")
    public int getMaxPacketSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_28245937 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_28245937;
        // ---------- Original Method ----------
        //return mMaxPacketSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.953 -0400", hash_original_method = "C237023D57B3F5BEEDC74CA45F45E95A", hash_generated_method = "456E2474DC3CC8D27548BC8DB35171C1")
    public int getInterval() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_248751266 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_248751266;
        // ---------- Original Method ----------
        //return mInterval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.972 -0400", hash_original_method = "B003A6A19E3A4AFD160CE93D619076F2", hash_generated_method = "6B01B88D86B0BB673FAC44AD8443D9C9")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_271789768 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_271789768 = "UsbEndpoint[mAddress=" + mAddress + ",mAttributes=" + mAttributes +
                ",mMaxPacketSize=" + mMaxPacketSize + ",mInterval=" + mInterval +"]";
        varB4EAC82CA7396A68D541C85D26508E83_271789768.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_271789768;
        // ---------- Original Method ----------
        //return "UsbEndpoint[mAddress=" + mAddress + ",mAttributes=" + mAttributes +
                //",mMaxPacketSize=" + mMaxPacketSize + ",mInterval=" + mInterval +"]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.972 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "494FCC38643595BC7EF33EA2FA690E6F")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1095217694 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1095217694;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.986 -0400", hash_original_method = "BC3F7EF4329C93155CA4CAEEEA5C5049", hash_generated_method = "67220704BB1DF65EC3DB238A27C2BE1B")
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(mAddress);
        parcel.writeInt(mAttributes);
        parcel.writeInt(mMaxPacketSize);
        parcel.writeInt(mInterval);
        addTaint(parcel.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //parcel.writeInt(mAddress);
        //parcel.writeInt(mAttributes);
        //parcel.writeInt(mMaxPacketSize);
        //parcel.writeInt(mInterval);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.987 -0400", hash_original_field = "1F925C8BDC204DFBE1A9F1D995B6F52C", hash_generated_field = "438080ABC723F019CBF0CEFAFA519D03")

    public static final Parcelable.Creator<UsbEndpoint> CREATOR =
        new Parcelable.Creator<UsbEndpoint>() {
        public UsbEndpoint createFromParcel(Parcel in) {
            int address = in.readInt();
            int attributes = in.readInt();
            int maxPacketSize = in.readInt();
            int interval = in.readInt();
            return new UsbEndpoint(address, attributes, maxPacketSize, interval);
        }

        public UsbEndpoint[] newArray(int size) {
            return new UsbEndpoint[size];
        }
    };
}

