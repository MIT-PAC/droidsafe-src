package android.hardware.usb;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class UsbEndpoint implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.971 -0400", hash_original_field = "9C8E67CB570F7F2DF167C544686B922A", hash_generated_field = "1BE2BFB4A5E404FE17164B090FF85336")

    private int mAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.971 -0400", hash_original_field = "57D8B4049AE5C9E100E84EE9D1F3BF3E", hash_generated_field = "38E582B0031888860D19E53B65089433")

    private int mAttributes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.971 -0400", hash_original_field = "01BE87558ED87E26957E94A9074FFDC0", hash_generated_field = "8952F4B8923F9E4C8C48FDFD4E227622")

    private int mMaxPacketSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.971 -0400", hash_original_field = "DA2A452A82BCAB083D9BBB9CCC9A14CA", hash_generated_field = "74B0CD5DC79AAA2AADBA9285C7DC7647")

    private int mInterval;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.972 -0400", hash_original_method = "DE7C1D5317206A67C09F18E7BB17C60A", hash_generated_method = "9275E1A01A6F3627508892E18D01B491")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.972 -0400", hash_original_method = "1ACE37C7AEF4979E99CF3DA88C3DB9F0", hash_generated_method = "9842BEE5186E67D0A7D39FC68101F19D")
    public int getAddress() {
        int var9C8E67CB570F7F2DF167C544686B922A_524203777 = (mAddress);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1698065253 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1698065253;
        // ---------- Original Method ----------
        //return mAddress;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.972 -0400", hash_original_method = "530E1C5174A47AC9C94137EACF355AFA", hash_generated_method = "6ED4D56E9B5D8A0059255EF78DB8C657")
    public int getEndpointNumber() {
        int varFEDCFD6C3F9CD64A960777FBB3566E1D_937520325 = (mAddress & UsbConstants.USB_ENDPOINT_NUMBER_MASK);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_424507729 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_424507729;
        // ---------- Original Method ----------
        //return mAddress & UsbConstants.USB_ENDPOINT_NUMBER_MASK;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.972 -0400", hash_original_method = "5E2273EF2E39AF02B90546F0D57EC6D9", hash_generated_method = "8713FBAE30A2854B4228ADEBE9B6DFA6")
    public int getDirection() {
        int varC692078FC56E78E122A95215CC0E6D39_1985513469 = (mAddress & UsbConstants.USB_ENDPOINT_DIR_MASK);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_541214851 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_541214851;
        // ---------- Original Method ----------
        //return mAddress & UsbConstants.USB_ENDPOINT_DIR_MASK;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.973 -0400", hash_original_method = "36DAD0B9D253F08C19BBEFC651F6D4C9", hash_generated_method = "6FFAAC1DCC14EE477198E813F9BAE5C4")
    public int getAttributes() {
        int var57D8B4049AE5C9E100E84EE9D1F3BF3E_1145269001 = (mAttributes);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_254461248 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_254461248;
        // ---------- Original Method ----------
        //return mAttributes;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.973 -0400", hash_original_method = "ED0BDC5BE5FF0D5E260DB90C1E62D731", hash_generated_method = "459D7CD11199B20BE9405151B67F970A")
    public int getType() {
        int var712C9428EF2357EDC05DFC1FF3357561_453153581 = (mAttributes & UsbConstants.USB_ENDPOINT_XFERTYPE_MASK);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1534906921 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1534906921;
        // ---------- Original Method ----------
        //return mAttributes & UsbConstants.USB_ENDPOINT_XFERTYPE_MASK;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.973 -0400", hash_original_method = "E96412E34BF386D230BE1BA24C763C9C", hash_generated_method = "4D07BEE45B6F0E2EB455FCEB42A0AB2E")
    public int getMaxPacketSize() {
        int var01BE87558ED87E26957E94A9074FFDC0_1158670465 = (mMaxPacketSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1701593737 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1701593737;
        // ---------- Original Method ----------
        //return mMaxPacketSize;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.974 -0400", hash_original_method = "C237023D57B3F5BEEDC74CA45F45E95A", hash_generated_method = "2465F96DDD88AA5DBBB96FD1A1021051")
    public int getInterval() {
        int varDA2A452A82BCAB083D9BBB9CCC9A14CA_1069338355 = (mInterval);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1641799769 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1641799769;
        // ---------- Original Method ----------
        //return mInterval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.974 -0400", hash_original_method = "B003A6A19E3A4AFD160CE93D619076F2", hash_generated_method = "E29E9C3ABD727243C3F785E981F9F6C2")
    @Override
    public String toString() {
String var6A343BAC9DFF10320F68B5A4D553C4E8_1352967110 =         "UsbEndpoint[mAddress=" + mAddress + ",mAttributes=" + mAttributes +
                ",mMaxPacketSize=" + mMaxPacketSize + ",mInterval=" + mInterval +"]";
        var6A343BAC9DFF10320F68B5A4D553C4E8_1352967110.addTaint(taint);
        return var6A343BAC9DFF10320F68B5A4D553C4E8_1352967110;
        // ---------- Original Method ----------
        //return "UsbEndpoint[mAddress=" + mAddress + ",mAttributes=" + mAttributes +
                //",mMaxPacketSize=" + mMaxPacketSize + ",mInterval=" + mInterval +"]";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.974 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "3E912D02D61982B532458613ABC918B9")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_911687689 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1552261864 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1552261864;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.975 -0400", hash_original_method = "BC3F7EF4329C93155CA4CAEEEA5C5049", hash_generated_method = "507BF635A31282BA16C8F2F786AD2758")
    public void writeToParcel(Parcel parcel, int flags) {
        addTaint(flags);
        addTaint(parcel.getTaint());
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.975 -0400", hash_original_field = "1F925C8BDC204DFBE1A9F1D995B6F52C", hash_generated_field = "438080ABC723F019CBF0CEFAFA519D03")

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

