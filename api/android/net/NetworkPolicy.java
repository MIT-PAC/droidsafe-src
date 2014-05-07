package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static com.android.internal.util.Preconditions.checkNotNull;
import android.os.Parcel;
import android.os.Parcelable;

import com.android.internal.util.Objects;

public class NetworkPolicy implements Parcelable, Comparable<NetworkPolicy> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.665 -0500", hash_original_field = "35BC11FA8A4A0884AFC216BBB557E617", hash_generated_field = "634F6779245E33ED26E2ECD8D3DDBED9")

    public static final long WARNING_DISABLED = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.668 -0500", hash_original_field = "DE010BB639EAA3DDE0D5FB2CC41AFD22", hash_generated_field = "1777EABADE2803237815BFF06599E7C5")

    public static final long LIMIT_DISABLED = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.671 -0500", hash_original_field = "95BF1C75F83BF005829E88AEBF89BEC7", hash_generated_field = "294C240462AE088B647BD5BA286AF2A9")

    public static final long SNOOZE_NEVER = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.683 -0500", hash_original_field = "73322C3A2022BDF2DC3A04396C3D6D44", hash_generated_field = "682CA4B7512FEB9C83A8E9BE89FFD46E")

    private static final long DEFAULT_MTU = 1500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.457 -0400", hash_original_field = "C2409146E6E4B9061F56D86265B2F3B2", hash_generated_field = "180EDC3370D1E5C9B6946B64927B3249")

    public static final Creator<NetworkPolicy> CREATOR = new Creator<NetworkPolicy>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.708 -0500", hash_original_method = "36B6FBCF5E8EB4247DB4769E0E257CA0", hash_generated_method = "183F9A4303A8A2E7CF83C914919AD39B")
        
public NetworkPolicy createFromParcel(Parcel in) {
            return new NetworkPolicy(in);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.711 -0500", hash_original_method = "E266B1D7949E71853CAFBAC409E27D8A", hash_generated_method = "8F8FC3B173801E8500B5FAC668B9D643")
        
public NetworkPolicy[] newArray(int size) {
            return new NetworkPolicy[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.673 -0500", hash_original_field = "84A4D3911A021A3ED65FC1EBB53BD5D3", hash_generated_field = "B2CDC330F0BAA1352530D58D900DD1BE")

    public  NetworkTemplate template;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.675 -0500", hash_original_field = "6D31B241F1975D97AB78663E7460590C", hash_generated_field = "86C8E914F72A9427F577707623E56D85")

    public int cycleDay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.677 -0500", hash_original_field = "83E6535BED4572DD7C1D58CFF259B2A6", hash_generated_field = "87A16CEE2AA5296B256BDBCE8C466488")

    public long warningBytes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.679 -0500", hash_original_field = "23DD28EC049CA9D27929F5539991D1E7", hash_generated_field = "5D2C19639CAE20134F8C72858C479A2E")

    public long limitBytes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.681 -0500", hash_original_field = "CCF6FCCDD8D4FC02481FDD86F6E451C6", hash_generated_field = "66F3F270AC8612F13D1A1C517B91D9EA")

    public long lastSnooze;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.686 -0500", hash_original_method = "719C24F8BE1248DF6A461023036B66AA", hash_generated_method = "A16531E0E2EC907DA8D3D508B7C7EA7B")
    
public NetworkPolicy(NetworkTemplate template, int cycleDay, long warningBytes, long limitBytes,
            long lastSnooze) {
        this.template = checkNotNull(template, "missing NetworkTemplate");
        this.cycleDay = cycleDay;
        this.warningBytes = warningBytes;
        this.limitBytes = limitBytes;
        this.lastSnooze = lastSnooze;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.689 -0500", hash_original_method = "60FCEF3D01A6B189740F65177391DDF0", hash_generated_method = "0381A3FA73FC1CCB06742B98770FF646")
    
public NetworkPolicy(Parcel in) {
        template = in.readParcelable(null);
        cycleDay = in.readInt();
        warningBytes = in.readLong();
        limitBytes = in.readLong();
        lastSnooze = in.readLong();
    }

    /** {@inheritDoc} */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.691 -0500", hash_original_method = "A386F04ADA8A00FB5A1B1E46AA17FE85", hash_generated_method = "B77001EC2FC9FBD90B3E10CD533C8DB0")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(template, flags);
        dest.writeInt(cycleDay);
        dest.writeLong(warningBytes);
        dest.writeLong(limitBytes);
        dest.writeLong(lastSnooze);
    }

    /** {@inheritDoc} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.693 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    /**
     * Test if given measurement is near enough to {@link #limitBytes} to be
     * considered over-limit.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.695 -0500", hash_original_method = "3B515BD8C18D4AA3426DE2CF748D864D", hash_generated_method = "F60C0BDA58A763EAD1369C294E3DF243")
    
public boolean isOverLimit(long totalBytes) {
        // over-estimate, since kernel will trigger limit once first packet
        // trips over limit.
        totalBytes += 2 * DEFAULT_MTU;
        return limitBytes != LIMIT_DISABLED && totalBytes >= limitBytes;
    }

    /** {@inheritDoc} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.697 -0500", hash_original_method = "94D3DEEA59ED3BCE504BE8B2D91F1F02", hash_generated_method = "63A5CDBD96E0A7B504C7DE406AEDB281")
    
public int compareTo(NetworkPolicy another) {
        if (another == null || another.limitBytes == LIMIT_DISABLED) {
            // other value is missing or disabled; we win
            return -1;
        }
        if (limitBytes == LIMIT_DISABLED || another.limitBytes < limitBytes) {
            // we're disabled or other limit is smaller; they win
            return 1;
        }
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.700 -0500", hash_original_method = "65DB678FEF7477006B15C098764A0236", hash_generated_method = "C2440A66E1BCCC6935833C6BBD9BA113")
    
@Override
    public int hashCode() {
        return Objects.hashCode(template, cycleDay, warningBytes, limitBytes, lastSnooze);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.702 -0500", hash_original_method = "29E54ABFFB72D1CE12A9FC870E79CFC8", hash_generated_method = "FCD6C59FD3468B04C44328784A998130")
    
@Override
    public boolean equals(Object obj) {
        if (obj instanceof NetworkPolicy) {
            final NetworkPolicy other = (NetworkPolicy) obj;
            return Objects.equal(template, other.template) && cycleDay == other.cycleDay
                    && warningBytes == other.warningBytes && limitBytes == other.limitBytes
                    && lastSnooze == other.lastSnooze;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.704 -0500", hash_original_method = "CB6123FDA6EA84240F335B44F0260DCB", hash_generated_method = "3DDF313AFB2564959CA137EE984A693C")
    
@Override
    public String toString() {
        return "NetworkPolicy[" + template + "]: cycleDay=" + cycleDay + ", warningBytes="
                + warningBytes + ", limitBytes=" + limitBytes + ", lastSnooze=" + lastSnooze;
    }
    // orphaned legacy method
    public NetworkPolicy createFromParcel(Parcel in) {
            return new NetworkPolicy(in);
        }
    
    // orphaned legacy method
    public NetworkPolicy[] newArray(int size) {
            return new NetworkPolicy[size];
        }
    
}

