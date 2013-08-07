package android.net;

// Droidsafe Imports
import droidsafe.annotations.*;
import static com.android.internal.util.Preconditions.checkNotNull;
import android.os.Parcel;
import android.os.Parcelable;

import com.android.internal.util.Objects;






public class NetworkPolicy implements Parcelable, Comparable<NetworkPolicy> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.449 -0400", hash_original_field = "66F6181BCB4CFF4CD38FBC804A036DB6", hash_generated_field = "B2CDC330F0BAA1352530D58D900DD1BE")

    public NetworkTemplate template;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.450 -0400", hash_original_field = "75749C2D1FBE021E078B12C6018CD718", hash_generated_field = "86C8E914F72A9427F577707623E56D85")

    public int cycleDay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.450 -0400", hash_original_field = "4FA37D568977CD887BF422220BE13785", hash_generated_field = "87A16CEE2AA5296B256BDBCE8C466488")

    public long warningBytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.450 -0400", hash_original_field = "4B419CC42D4170727100897B0EA0539D", hash_generated_field = "5D2C19639CAE20134F8C72858C479A2E")

    public long limitBytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.450 -0400", hash_original_field = "8FCBE7B365C47B90C65C89211C47D13B", hash_generated_field = "66F3F270AC8612F13D1A1C517B91D9EA")

    public long lastSnooze;
    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.451 -0400", hash_original_method = "719C24F8BE1248DF6A461023036B66AA", hash_generated_method = "3550B4B21E9EC1B088693EA5F5E52A49")
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.452 -0400", hash_original_method = "60FCEF3D01A6B189740F65177391DDF0", hash_generated_method = "11DE13DCBA6497EEC7DA8F3A613FF638")
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.452 -0400", hash_original_method = "A386F04ADA8A00FB5A1B1E46AA17FE85", hash_generated_method = "F9674402A8455DFA9AC45C655E37A9AA")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeParcelable(template, flags);
        dest.writeInt(cycleDay);
        dest.writeLong(warningBytes);
        dest.writeLong(limitBytes);
        dest.writeLong(lastSnooze);
        // ---------- Original Method ----------
        //dest.writeParcelable(template, flags);
        //dest.writeInt(cycleDay);
        //dest.writeLong(warningBytes);
        //dest.writeLong(limitBytes);
        //dest.writeLong(lastSnooze);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.453 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "87A8B61F1122F19E39B42089F82B9D9F")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1400259146 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_294666519 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_294666519;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.453 -0400", hash_original_method = "3B515BD8C18D4AA3426DE2CF748D864D", hash_generated_method = "C447EB345AFEA8005E24427268B8EE76")
    public boolean isOverLimit(long totalBytes) {
        addTaint(totalBytes);
        totalBytes += 2 * DEFAULT_MTU;
        boolean varEA490C1CBDA74BDB3282C7BD10890679_1585050712 = (limitBytes != LIMIT_DISABLED && totalBytes >= limitBytes);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1740643732 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1740643732;
        // ---------- Original Method ----------
        //totalBytes += 2 * DEFAULT_MTU;
        //return limitBytes != LIMIT_DISABLED && totalBytes >= limitBytes;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.454 -0400", hash_original_method = "94D3DEEA59ED3BCE504BE8B2D91F1F02", hash_generated_method = "FADCC4A4465EE8B92EDF51A4B718FABF")
    public int compareTo(NetworkPolicy another) {
        addTaint(another.getTaint());
        if(another == null || another.limitBytes == LIMIT_DISABLED)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_752756985 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1850254552 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1850254552;
        } //End block
        if(limitBytes == LIMIT_DISABLED || another.limitBytes < limitBytes)        
        {
            int varC4CA4238A0B923820DCC509A6F75849B_1723419609 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_370633570 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_370633570;
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_247818769 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_35526982 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_35526982;
        // ---------- Original Method ----------
        //if (another == null || another.limitBytes == LIMIT_DISABLED) {
            //return -1;
        //}
        //if (limitBytes == LIMIT_DISABLED || another.limitBytes < limitBytes) {
            //return 1;
        //}
        //return 0;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.455 -0400", hash_original_method = "65DB678FEF7477006B15C098764A0236", hash_generated_method = "34DEB7A7DE77ADFF0E0F76A074666DDF")
    @Override
    public int hashCode() {
        int varBE0E82DDD5A41534CFF412AF1A0E6D18_1362039480 = (Objects.hashCode(template, cycleDay, warningBytes, limitBytes, lastSnooze));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_191891003 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_191891003;
        // ---------- Original Method ----------
        //return Objects.hashCode(template, cycleDay, warningBytes, limitBytes, lastSnooze);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.455 -0400", hash_original_method = "29E54ABFFB72D1CE12A9FC870E79CFC8", hash_generated_method = "24E2258E65DBB830468AB5A161CAEDF4")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        if(obj instanceof NetworkPolicy)        
        {
            final NetworkPolicy other = (NetworkPolicy) obj;
            boolean varE615F42CE2583FB39907D7148460E416_2065073732 = (Objects.equal(template, other.template) && cycleDay == other.cycleDay
                    && warningBytes == other.warningBytes && limitBytes == other.limitBytes
                    && lastSnooze == other.lastSnooze);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_271848454 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_271848454;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_966764143 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_356705399 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_356705399;
        // ---------- Original Method ----------
        //if (obj instanceof NetworkPolicy) {
            //final NetworkPolicy other = (NetworkPolicy) obj;
            //return Objects.equal(template, other.template) && cycleDay == other.cycleDay
                    //&& warningBytes == other.warningBytes && limitBytes == other.limitBytes
                    //&& lastSnooze == other.lastSnooze;
        //}
        //return false;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.456 -0400", hash_original_method = "CB6123FDA6EA84240F335B44F0260DCB", hash_generated_method = "7F67E93D4AD041935E71C7E4343EF9AB")
    @Override
    public String toString() {
String varFA46F86AB5F1A50C4B2CF392C6DDF73C_428073831 =         "NetworkPolicy[" + template + "]: cycleDay=" + cycleDay + ", warningBytes="
                + warningBytes + ", limitBytes=" + limitBytes + ", lastSnooze=" + lastSnooze;
        varFA46F86AB5F1A50C4B2CF392C6DDF73C_428073831.addTaint(taint);
        return varFA46F86AB5F1A50C4B2CF392C6DDF73C_428073831;
        // ---------- Original Method ----------
        //return "NetworkPolicy[" + template + "]: cycleDay=" + cycleDay + ", warningBytes="
                //+ warningBytes + ", limitBytes=" + limitBytes + ", lastSnooze=" + lastSnooze;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.456 -0400", hash_original_field = "6A109E2C5AC883E094EADEDF5DE5802D", hash_generated_field = "634F6779245E33ED26E2ECD8D3DDBED9")

    public static final long WARNING_DISABLED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.456 -0400", hash_original_field = "D402BBCAF6CA4BBE83F492470DD37017", hash_generated_field = "1777EABADE2803237815BFF06599E7C5")

    public static final long LIMIT_DISABLED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.457 -0400", hash_original_field = "720246958C83A94E115915DE30D4F554", hash_generated_field = "294C240462AE088B647BD5BA286AF2A9")

    public static final long SNOOZE_NEVER = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.457 -0400", hash_original_field = "3917372681143FB66049642B1F869357", hash_generated_field = "682CA4B7512FEB9C83A8E9BE89FFD46E")

    private static final long DEFAULT_MTU = 1500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.457 -0400", hash_original_field = "C2409146E6E4B9061F56D86265B2F3B2", hash_generated_field = "180EDC3370D1E5C9B6946B64927B3249")

    public static final Creator<NetworkPolicy> CREATOR = new Creator<NetworkPolicy>() {
        public NetworkPolicy createFromParcel(Parcel in) {
            return new NetworkPolicy(in);
        }

        public NetworkPolicy[] newArray(int size) {
            return new NetworkPolicy[size];
        }
    };
    // orphaned legacy method
    public NetworkPolicy createFromParcel(Parcel in) {
            return new NetworkPolicy(in);
        }
    
    // orphaned legacy method
    public NetworkPolicy[] newArray(int size) {
            return new NetworkPolicy[size];
        }
    
}

