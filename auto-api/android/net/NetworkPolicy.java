package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import static com.android.internal.util.Preconditions.checkNotNull;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.internal.util.Objects;

public class NetworkPolicy implements Parcelable, Comparable<NetworkPolicy> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.549 -0400", hash_original_field = "66F6181BCB4CFF4CD38FBC804A036DB6", hash_generated_field = "B2CDC330F0BAA1352530D58D900DD1BE")

    public NetworkTemplate template;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.549 -0400", hash_original_field = "75749C2D1FBE021E078B12C6018CD718", hash_generated_field = "86C8E914F72A9427F577707623E56D85")

    public int cycleDay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.549 -0400", hash_original_field = "4FA37D568977CD887BF422220BE13785", hash_generated_field = "87A16CEE2AA5296B256BDBCE8C466488")

    public long warningBytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.549 -0400", hash_original_field = "4B419CC42D4170727100897B0EA0539D", hash_generated_field = "5D2C19639CAE20134F8C72858C479A2E")

    public long limitBytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.549 -0400", hash_original_field = "8FCBE7B365C47B90C65C89211C47D13B", hash_generated_field = "66F3F270AC8612F13D1A1C517B91D9EA")

    public long lastSnooze;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.572 -0400", hash_original_method = "719C24F8BE1248DF6A461023036B66AA", hash_generated_method = "3550B4B21E9EC1B088693EA5F5E52A49")
    public  NetworkPolicy(NetworkTemplate template, int cycleDay, long warningBytes, long limitBytes,
            long lastSnooze) {
        this.template = checkNotNull(template, "missing NetworkTemplate");
        this.cycleDay = cycleDay;
        this.warningBytes = warningBytes;
        this.limitBytes = limitBytes;
        this.lastSnooze = lastSnooze;
        // ---------- Original Method ----------
        //this.template = checkNotNull(template, "missing NetworkTemplate");
        //this.cycleDay = cycleDay;
        //this.warningBytes = warningBytes;
        //this.limitBytes = limitBytes;
        //this.lastSnooze = lastSnooze;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.581 -0400", hash_original_method = "60FCEF3D01A6B189740F65177391DDF0", hash_generated_method = "11DE13DCBA6497EEC7DA8F3A613FF638")
    public  NetworkPolicy(Parcel in) {
        template = in.readParcelable(null);
        cycleDay = in.readInt();
        warningBytes = in.readLong();
        limitBytes = in.readLong();
        lastSnooze = in.readLong();
        // ---------- Original Method ----------
        //template = in.readParcelable(null);
        //cycleDay = in.readInt();
        //warningBytes = in.readLong();
        //limitBytes = in.readLong();
        //lastSnooze = in.readLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.585 -0400", hash_original_method = "A386F04ADA8A00FB5A1B1E46AA17FE85", hash_generated_method = "0EBD0485079B68D02F83E11B5C765458")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(template, flags);
        dest.writeInt(cycleDay);
        dest.writeLong(warningBytes);
        dest.writeLong(limitBytes);
        dest.writeLong(lastSnooze);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeParcelable(template, flags);
        //dest.writeInt(cycleDay);
        //dest.writeLong(warningBytes);
        //dest.writeLong(limitBytes);
        //dest.writeLong(lastSnooze);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.586 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "3681BA697EBA7DC6B55A1907DB567155")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1099759834 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1099759834;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.608 -0400", hash_original_method = "3B515BD8C18D4AA3426DE2CF748D864D", hash_generated_method = "9603A71E17754BBCFF937AAF3248D57C")
    public boolean isOverLimit(long totalBytes) {
        totalBytes += 2 * DEFAULT_MTU;
        addTaint(totalBytes);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1824829890 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1824829890;
        // ---------- Original Method ----------
        //totalBytes += 2 * DEFAULT_MTU;
        //return limitBytes != LIMIT_DISABLED && totalBytes >= limitBytes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.609 -0400", hash_original_method = "94D3DEEA59ED3BCE504BE8B2D91F1F02", hash_generated_method = "C912F29F948B242DB8F1A41BFC738C09")
    public int compareTo(NetworkPolicy another) {
        addTaint(another.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_396932138 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_396932138;
        // ---------- Original Method ----------
        //if (another == null || another.limitBytes == LIMIT_DISABLED) {
            //return -1;
        //}
        //if (limitBytes == LIMIT_DISABLED || another.limitBytes < limitBytes) {
            //return 1;
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.609 -0400", hash_original_method = "65DB678FEF7477006B15C098764A0236", hash_generated_method = "4F73E547BEAA1F14E6BDA934F3C92BEB")
    @Override
    public int hashCode() {
        int varE2F91B8815F89DBABB5723C23F7AD388_743000118 = (Objects.hashCode(template, cycleDay, warningBytes, limitBytes, lastSnooze));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_115135482 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_115135482;
        // ---------- Original Method ----------
        //return Objects.hashCode(template, cycleDay, warningBytes, limitBytes, lastSnooze);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.621 -0400", hash_original_method = "29E54ABFFB72D1CE12A9FC870E79CFC8", hash_generated_method = "EAB2D3D86D01458E707028984CB65646")
    @Override
    public boolean equals(Object obj) {
        {
            NetworkPolicy other;
            other = (NetworkPolicy) obj;
            boolean var1E33E7A7A24747215D00952E86674F6F_256469661 = (Objects.equal(template, other.template) && cycleDay == other.cycleDay
                    && warningBytes == other.warningBytes && limitBytes == other.limitBytes
                    && lastSnooze == other.lastSnooze);
        } //End block
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2109167528 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2109167528;
        // ---------- Original Method ----------
        //if (obj instanceof NetworkPolicy) {
            //final NetworkPolicy other = (NetworkPolicy) obj;
            //return Objects.equal(template, other.template) && cycleDay == other.cycleDay
                    //&& warningBytes == other.warningBytes && limitBytes == other.limitBytes
                    //&& lastSnooze == other.lastSnooze;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.622 -0400", hash_original_method = "CB6123FDA6EA84240F335B44F0260DCB", hash_generated_method = "47A92A145CE78C10D167804E1F1C87E1")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1795339208 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1795339208 = "NetworkPolicy[" + template + "]: cycleDay=" + cycleDay + ", warningBytes="
                + warningBytes + ", limitBytes=" + limitBytes + ", lastSnooze=" + lastSnooze;
        varB4EAC82CA7396A68D541C85D26508E83_1795339208.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1795339208;
        // ---------- Original Method ----------
        //return "NetworkPolicy[" + template + "]: cycleDay=" + cycleDay + ", warningBytes="
                //+ warningBytes + ", limitBytes=" + limitBytes + ", lastSnooze=" + lastSnooze;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.622 -0400", hash_original_field = "6A109E2C5AC883E094EADEDF5DE5802D", hash_generated_field = "634F6779245E33ED26E2ECD8D3DDBED9")

    public static final long WARNING_DISABLED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.622 -0400", hash_original_field = "D402BBCAF6CA4BBE83F492470DD37017", hash_generated_field = "1777EABADE2803237815BFF06599E7C5")

    public static final long LIMIT_DISABLED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.623 -0400", hash_original_field = "720246958C83A94E115915DE30D4F554", hash_generated_field = "294C240462AE088B647BD5BA286AF2A9")

    public static final long SNOOZE_NEVER = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.623 -0400", hash_original_field = "3917372681143FB66049642B1F869357", hash_generated_field = "37F8964DE59710B321730DBFABCF8131")

    private static long DEFAULT_MTU = 1500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.623 -0400", hash_original_field = "C2409146E6E4B9061F56D86265B2F3B2", hash_generated_field = "180EDC3370D1E5C9B6946B64927B3249")

    public static final Creator<NetworkPolicy> CREATOR = new Creator<NetworkPolicy>() {
        public NetworkPolicy createFromParcel(Parcel in) {
            return new NetworkPolicy(in);
        }

        public NetworkPolicy[] newArray(int size) {
            return new NetworkPolicy[size];
        }
    };
}

