package android.net.wifi;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcelable;
import android.os.Parcel;

public class ScanResult implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.369 -0400", hash_original_field = "0D09D7B23E604623465E83B0DC113F4D", hash_generated_field = "F7FE1695EF676C936EDB74F734CEDF60")

    public String SSID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.369 -0400", hash_original_field = "4EB26185F9AD8B5D6AFBADC09D7D5096", hash_generated_field = "2B401C010EEC74A39C75E8EEE69DE741")

    public String BSSID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.369 -0400", hash_original_field = "F7B11037F2050959293AAFB493B7653C", hash_generated_field = "ED500412E13DF4E867C4A3F4F20A041D")

    public String capabilities;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.369 -0400", hash_original_field = "C9E9A848920877E76685B2E4E76DE38D", hash_generated_field = "D6582AE921E596E1A991761518312A0E")

    public int level;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.369 -0400", hash_original_field = "FAD6C43B628858E0B472D0C164557FCF", hash_generated_field = "D8E433C66DAD37D40F223C5E121FF070")

    public int frequency;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.369 -0400", hash_original_method = "B81746E5555BB1C130130EC15E62207F", hash_generated_method = "719C1669155F4840ADC34BB00169FF8E")
    public  ScanResult(String SSID, String BSSID, String caps, int level, int frequency) {
        this.SSID = SSID;
        this.BSSID = BSSID;
        this.capabilities = caps;
        this.level = level;
        this.frequency = frequency;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.370 -0400", hash_original_method = "3BF3B5ECD6A260296AD88686E08D9EA2", hash_generated_method = "C0623DD8C3B2E06C5DD97045448FB727")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_167772127 = null; 
        StringBuffer sb = new StringBuffer();
        String none = "<none>";
        sb.append("SSID: ").
            append(SSID == null ? none : SSID).
            append(", BSSID: ").
            append(BSSID == null ? none : BSSID).
            append(", capabilities: ").
            append(capabilities == null ? none : capabilities).
            append(", level: ").
            append(level).
            append(", frequency: ").
            append(frequency);
        varB4EAC82CA7396A68D541C85D26508E83_167772127 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_167772127.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_167772127;
        
        
        
        
            
            
            
            
            
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.371 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "55E6FBE3E9A8746BD1C2182602639D00")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1785918864 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1785918864;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.371 -0400", hash_original_method = "8ED27770F672F68987FCE9C19DB9995F", hash_generated_method = "C48ECCE5DA0EAA54A80C854CFBAA5AAC")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(SSID);
        dest.writeString(BSSID);
        dest.writeString(capabilities);
        dest.writeInt(level);
        dest.writeInt(frequency);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.371 -0400", hash_original_field = "680517245A246D643DCA76FD0591B0C1", hash_generated_field = "0B6E8115881E2F7154B7AD5C086C74FA")

    public static final Creator<ScanResult> CREATOR =
        new Creator<ScanResult>() {
            public ScanResult createFromParcel(Parcel in) {
                return new ScanResult(
                    in.readString(),
                    in.readString(),
                    in.readString(),
                    in.readInt(),
                    in.readInt()
                );
            }

            public ScanResult[] newArray(int size) {
                return new ScanResult[size];
            }
        };
    
    public ScanResult createFromParcel(Parcel in) {
                return new ScanResult(
                    in.readString(),
                    in.readString(),
                    in.readString(),
                    in.readInt(),
                    in.readInt()
                );
            }
    
    
    public ScanResult[] newArray(int size) {
                return new ScanResult[size];
            }
    
}

