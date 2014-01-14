package android.net.wifi;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public class ScanResult implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.924 -0400", hash_original_field = "680517245A246D643DCA76FD0591B0C1", hash_generated_field = "0B6E8115881E2F7154B7AD5C086C74FA")

    public static final Creator<ScanResult> CREATOR =
        new Creator<ScanResult>() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.202 -0500", hash_original_method = "BC0BC21C35AE7AEEA6D20EE623F1DB0A", hash_generated_method = "B805C8A062C30AB6451CCBD036279207")
        
public ScanResult createFromParcel(Parcel in) {
                return new ScanResult(
                    in.readString(),
                    in.readString(),
                    in.readString(),
                    in.readInt(),
                    in.readInt()
                );
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.204 -0500", hash_original_method = "26455827E25EAA2F9112FF9001164636", hash_generated_method = "0E4F40DCFC37BBC248778432A5F0DCC0")
        
public ScanResult[] newArray(int size) {
                return new ScanResult[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.181 -0500", hash_original_field = "D51FFCCB8BC400B151A7DB122CC667EF", hash_generated_field = "F7FE1695EF676C936EDB74F734CEDF60")

    public String SSID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.183 -0500", hash_original_field = "570781433B420D8B8DC7F4BA85DC7D9F", hash_generated_field = "2B401C010EEC74A39C75E8EEE69DE741")

    public String BSSID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.186 -0500", hash_original_field = "A983D53F80FEE3BA141338A1B3844141", hash_generated_field = "ED500412E13DF4E867C4A3F4F20A041D")

    public String capabilities;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.188 -0500", hash_original_field = "6C23DC7E65CEAB9FBA953CF49B6B6875", hash_generated_field = "D6582AE921E596E1A991761518312A0E")

    public int level;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.190 -0500", hash_original_field = "5A37A6160C2F76A8A5914EB71B165D07", hash_generated_field = "D8E433C66DAD37D40F223C5E121FF070")

    public int frequency;

    /**
     * We'd like to obtain the following attributes,
     * but they are not reported via the socket
     * interface, even though they are known
     * internally by wpa_supplicant.
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.192 -0500", hash_original_method = "B81746E5555BB1C130130EC15E62207F", hash_generated_method = "D96AC526FD7FD9E2FB02DA563C343FF8")
    
public ScanResult(String SSID, String BSSID, String caps, int level, int frequency) {
        this.SSID = SSID;
        this.BSSID = BSSID;
        this.capabilities = caps;
        this.level = level;
        this.frequency = frequency;
        //networkConfig = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.195 -0500", hash_original_method = "3BF3B5ECD6A260296AD88686E08D9EA2", hash_generated_method = "9D61867682DEAA67854014FC90C1C4CF")
    
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

        return sb.toString();
    }

    /** Implement the Parcelable interface {@hide} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.197 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    /** Implement the Parcelable interface {@hide} */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.199 -0500", hash_original_method = "8ED27770F672F68987FCE9C19DB9995F", hash_generated_method = "CAFE51F751BF21DDDEB9DF3276CB258D")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(SSID);
        dest.writeString(BSSID);
        dest.writeString(capabilities);
        dest.writeInt(level);
        dest.writeInt(frequency);
    }
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

