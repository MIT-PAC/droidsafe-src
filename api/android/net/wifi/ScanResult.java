package android.net.wifi;

// Droidsafe Imports
import android.os.Parcel;
import android.os.Parcelable;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ScanResult implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.921 -0400", hash_original_field = "0D09D7B23E604623465E83B0DC113F4D", hash_generated_field = "F7FE1695EF676C936EDB74F734CEDF60")

    public String SSID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.922 -0400", hash_original_field = "4EB26185F9AD8B5D6AFBADC09D7D5096", hash_generated_field = "2B401C010EEC74A39C75E8EEE69DE741")

    public String BSSID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.922 -0400", hash_original_field = "F7B11037F2050959293AAFB493B7653C", hash_generated_field = "ED500412E13DF4E867C4A3F4F20A041D")

    public String capabilities;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.922 -0400", hash_original_field = "C9E9A848920877E76685B2E4E76DE38D", hash_generated_field = "D6582AE921E596E1A991761518312A0E")

    public int level;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.922 -0400", hash_original_field = "FAD6C43B628858E0B472D0C164557FCF", hash_generated_field = "D8E433C66DAD37D40F223C5E121FF070")

    public int frequency;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.923 -0400", hash_original_method = "B81746E5555BB1C130130EC15E62207F", hash_generated_method = "719C1669155F4840ADC34BB00169FF8E")
    public  ScanResult(String SSID, String BSSID, String caps, int level, int frequency) {
        this.SSID = SSID;
        this.BSSID = BSSID;
        this.capabilities = caps;
        this.level = level;
        this.frequency = frequency;
        // ---------- Original Method ----------
        //this.SSID = SSID;
        //this.BSSID = BSSID;
        //this.capabilities = caps;
        //this.level = level;
        //this.frequency = frequency;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.924 -0400", hash_original_method = "3BF3B5ECD6A260296AD88686E08D9EA2", hash_generated_method = "DA296083A9CAE597F75C983750CB051F")
    @Override
    public String toString() {
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
String var2460B846747F8B22185AD8BE722266A5_611380921 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_611380921.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_611380921;
        // ---------- Original Method ----------
        //StringBuffer sb = new StringBuffer();
        //String none = "<none>";
        //sb.append("SSID: ").
            //append(SSID == null ? none : SSID).
            //append(", BSSID: ").
            //append(BSSID == null ? none : BSSID).
            //append(", capabilities: ").
            //append(capabilities == null ? none : capabilities).
            //append(", level: ").
            //append(level).
            //append(", frequency: ").
            //append(frequency);
        //return sb.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.924 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8C2AC82D3BE8AABC2F156DA422740453")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_428149901 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1500028045 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1500028045;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.924 -0400", hash_original_method = "8ED27770F672F68987FCE9C19DB9995F", hash_generated_method = "21B7DD015A7D63165F89B57520768D45")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeString(SSID);
        dest.writeString(BSSID);
        dest.writeString(capabilities);
        dest.writeInt(level);
        dest.writeInt(frequency);
        // ---------- Original Method ----------
        //dest.writeString(SSID);
        //dest.writeString(BSSID);
        //dest.writeString(capabilities);
        //dest.writeInt(level);
        //dest.writeInt(frequency);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.924 -0400", hash_original_field = "680517245A246D643DCA76FD0591B0C1", hash_generated_field = "0B6E8115881E2F7154B7AD5C086C74FA")

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
    // orphaned legacy method
    public ScanResult createFromParcel(Parcel in) {
                return new ScanResult(
                    in.readString(),
                    in.readString(),
                    in.readString(),
                    in.readInt(),
                    in.readInt()
                );
            }
    
    // orphaned legacy method
    public ScanResult[] newArray(int size) {
                return new ScanResult[size];
            }
    
}

