package android.hardware.usb;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class UsbEndpoint implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.369 -0400", hash_original_field = "9C8E67CB570F7F2DF167C544686B922A", hash_generated_field = "1BE2BFB4A5E404FE17164B090FF85336")

    private int mAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.369 -0400", hash_original_field = "57D8B4049AE5C9E100E84EE9D1F3BF3E", hash_generated_field = "38E582B0031888860D19E53B65089433")

    private int mAttributes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.369 -0400", hash_original_field = "01BE87558ED87E26957E94A9074FFDC0", hash_generated_field = "8952F4B8923F9E4C8C48FDFD4E227622")

    private int mMaxPacketSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.369 -0400", hash_original_field = "DA2A452A82BCAB083D9BBB9CCC9A14CA", hash_generated_field = "74B0CD5DC79AAA2AADBA9285C7DC7647")

    private int mInterval;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.372 -0400", hash_original_method = "DE7C1D5317206A67C09F18E7BB17C60A", hash_generated_method = "9275E1A01A6F3627508892E18D01B491")
    public  UsbEndpoint(int address, int attributes, int maxPacketSize, int interval) {
        mAddress = address;
        mAttributes = attributes;
        mMaxPacketSize = maxPacketSize;
        mInterval = interval;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.373 -0400", hash_original_method = "1ACE37C7AEF4979E99CF3DA88C3DB9F0", hash_generated_method = "6888967DBF0EBEDA6EC8E34F9065F621")
    public int getAddress() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1900465477 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1900465477;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.374 -0400", hash_original_method = "530E1C5174A47AC9C94137EACF355AFA", hash_generated_method = "B72509D43A8F3E79CD2637BE95FFA214")
    public int getEndpointNumber() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_339024452 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_339024452;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.374 -0400", hash_original_method = "5E2273EF2E39AF02B90546F0D57EC6D9", hash_generated_method = "9B7EA1257585C0F50156E28C5F095980")
    public int getDirection() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1092962814 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1092962814;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.375 -0400", hash_original_method = "36DAD0B9D253F08C19BBEFC651F6D4C9", hash_generated_method = "FF8B975FFBC01671480793821D82E216")
    public int getAttributes() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2096460873 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2096460873;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.376 -0400", hash_original_method = "ED0BDC5BE5FF0D5E260DB90C1E62D731", hash_generated_method = "3A7874684BA1CA460C4BDF2864B1EAFB")
    public int getType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1154039486 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1154039486;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.377 -0400", hash_original_method = "E96412E34BF386D230BE1BA24C763C9C", hash_generated_method = "1705614052CEECC7EFC71575CDBC1B68")
    public int getMaxPacketSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2047697029 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2047697029;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.377 -0400", hash_original_method = "C237023D57B3F5BEEDC74CA45F45E95A", hash_generated_method = "383C9F47BB5D0F4AC643F746C53C7DE5")
    public int getInterval() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1280311219 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1280311219;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.381 -0400", hash_original_method = "B003A6A19E3A4AFD160CE93D619076F2", hash_generated_method = "E891B1C9303441F21C35472184329A61")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_841775154 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_841775154 = "UsbEndpoint[mAddress=" + mAddress + ",mAttributes=" + mAttributes +
                ",mMaxPacketSize=" + mMaxPacketSize + ",mInterval=" + mInterval +"]";
        varB4EAC82CA7396A68D541C85D26508E83_841775154.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_841775154;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.382 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D03407A1CB78B3319F385CE772D5C007")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1585431158 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1585431158;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.383 -0400", hash_original_method = "BC3F7EF4329C93155CA4CAEEEA5C5049", hash_generated_method = "67220704BB1DF65EC3DB238A27C2BE1B")
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(mAddress);
        parcel.writeInt(mAttributes);
        parcel.writeInt(mMaxPacketSize);
        parcel.writeInt(mInterval);
        addTaint(parcel.getTaint());
        addTaint(flags);
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.383 -0400", hash_original_field = "1F925C8BDC204DFBE1A9F1D995B6F52C", hash_generated_field = "438080ABC723F019CBF0CEFAFA519D03")

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
    
}

