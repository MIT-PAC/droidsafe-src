package android.hardware.usb;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class UsbEndpoint implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.905 -0400", hash_original_field = "9C8E67CB570F7F2DF167C544686B922A", hash_generated_field = "1BE2BFB4A5E404FE17164B090FF85336")

    private int mAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.906 -0400", hash_original_field = "57D8B4049AE5C9E100E84EE9D1F3BF3E", hash_generated_field = "38E582B0031888860D19E53B65089433")

    private int mAttributes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.906 -0400", hash_original_field = "01BE87558ED87E26957E94A9074FFDC0", hash_generated_field = "8952F4B8923F9E4C8C48FDFD4E227622")

    private int mMaxPacketSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.906 -0400", hash_original_field = "DA2A452A82BCAB083D9BBB9CCC9A14CA", hash_generated_field = "74B0CD5DC79AAA2AADBA9285C7DC7647")

    private int mInterval;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.906 -0400", hash_original_method = "DE7C1D5317206A67C09F18E7BB17C60A", hash_generated_method = "9275E1A01A6F3627508892E18D01B491")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.907 -0400", hash_original_method = "1ACE37C7AEF4979E99CF3DA88C3DB9F0", hash_generated_method = "62E2FFDF6748E6AFA445881780920BE2")
    public int getAddress() {
        int var9C8E67CB570F7F2DF167C544686B922A_430510948 = (mAddress);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_970046874 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_970046874;
        // ---------- Original Method ----------
        //return mAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.907 -0400", hash_original_method = "530E1C5174A47AC9C94137EACF355AFA", hash_generated_method = "A99AC36F595D456E10C25B1E2BDFD0D3")
    public int getEndpointNumber() {
        int varFEDCFD6C3F9CD64A960777FBB3566E1D_479955195 = (mAddress & UsbConstants.USB_ENDPOINT_NUMBER_MASK);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_664516034 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_664516034;
        // ---------- Original Method ----------
        //return mAddress & UsbConstants.USB_ENDPOINT_NUMBER_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.907 -0400", hash_original_method = "5E2273EF2E39AF02B90546F0D57EC6D9", hash_generated_method = "F1E6773A4EA5D79F53899B4503F001B5")
    public int getDirection() {
        int varC692078FC56E78E122A95215CC0E6D39_1508759211 = (mAddress & UsbConstants.USB_ENDPOINT_DIR_MASK);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_680652650 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_680652650;
        // ---------- Original Method ----------
        //return mAddress & UsbConstants.USB_ENDPOINT_DIR_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.908 -0400", hash_original_method = "36DAD0B9D253F08C19BBEFC651F6D4C9", hash_generated_method = "F331E96F83DC60D45A2A943AFA3FE4C7")
    public int getAttributes() {
        int var57D8B4049AE5C9E100E84EE9D1F3BF3E_163154042 = (mAttributes);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_433194897 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_433194897;
        // ---------- Original Method ----------
        //return mAttributes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.908 -0400", hash_original_method = "ED0BDC5BE5FF0D5E260DB90C1E62D731", hash_generated_method = "7A91D2E91AD1D052A12844B35E126A0E")
    public int getType() {
        int var712C9428EF2357EDC05DFC1FF3357561_1473605076 = (mAttributes & UsbConstants.USB_ENDPOINT_XFERTYPE_MASK);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_373555326 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_373555326;
        // ---------- Original Method ----------
        //return mAttributes & UsbConstants.USB_ENDPOINT_XFERTYPE_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.908 -0400", hash_original_method = "E96412E34BF386D230BE1BA24C763C9C", hash_generated_method = "4EC2F3B202D0436CB7A868503236DEEC")
    public int getMaxPacketSize() {
        int var01BE87558ED87E26957E94A9074FFDC0_1831901696 = (mMaxPacketSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_331504197 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_331504197;
        // ---------- Original Method ----------
        //return mMaxPacketSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.909 -0400", hash_original_method = "C237023D57B3F5BEEDC74CA45F45E95A", hash_generated_method = "0A4F49FCB9925800DD0902C07D2D5647")
    public int getInterval() {
        int varDA2A452A82BCAB083D9BBB9CCC9A14CA_955040995 = (mInterval);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_412610785 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_412610785;
        // ---------- Original Method ----------
        //return mInterval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.909 -0400", hash_original_method = "B003A6A19E3A4AFD160CE93D619076F2", hash_generated_method = "63A030D0321E113C8984452ABE817F86")
    @Override
    public String toString() {
String var6A343BAC9DFF10320F68B5A4D553C4E8_348283016 =         "UsbEndpoint[mAddress=" + mAddress + ",mAttributes=" + mAttributes +
                ",mMaxPacketSize=" + mMaxPacketSize + ",mInterval=" + mInterval +"]";
        var6A343BAC9DFF10320F68B5A4D553C4E8_348283016.addTaint(taint);
        return var6A343BAC9DFF10320F68B5A4D553C4E8_348283016;
        // ---------- Original Method ----------
        //return "UsbEndpoint[mAddress=" + mAddress + ",mAttributes=" + mAttributes +
                //",mMaxPacketSize=" + mMaxPacketSize + ",mInterval=" + mInterval +"]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.909 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "21452C073E1925601EDD8B18A56DBD92")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_678963515 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1900991793 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1900991793;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.910 -0400", hash_original_method = "BC3F7EF4329C93155CA4CAEEEA5C5049", hash_generated_method = "507BF635A31282BA16C8F2F786AD2758")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.910 -0400", hash_original_field = "1F925C8BDC204DFBE1A9F1D995B6F52C", hash_generated_field = "438080ABC723F019CBF0CEFAFA519D03")

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

