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
    public NetworkTemplate template;
    public int cycleDay;
    public long warningBytes;
    public long limitBytes;
    public long lastSnooze;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.100 -0400", hash_original_method = "719C24F8BE1248DF6A461023036B66AA", hash_generated_method = "78855EBEB00C07D028614AD9B44D6B78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkPolicy(NetworkTemplate template, int cycleDay, long warningBytes, long limitBytes,
            long lastSnooze) {
        dsTaint.addTaint(template.dsTaint);
        dsTaint.addTaint(limitBytes);
        dsTaint.addTaint(lastSnooze);
        dsTaint.addTaint(cycleDay);
        dsTaint.addTaint(warningBytes);
        this.template = checkNotNull(template, "missing NetworkTemplate");
        // ---------- Original Method ----------
        //this.template = checkNotNull(template, "missing NetworkTemplate");
        //this.cycleDay = cycleDay;
        //this.warningBytes = warningBytes;
        //this.limitBytes = limitBytes;
        //this.lastSnooze = lastSnooze;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.101 -0400", hash_original_method = "60FCEF3D01A6B189740F65177391DDF0", hash_generated_method = "B0E959519EC6D2C152AD932CA5912E36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkPolicy(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.101 -0400", hash_original_method = "A386F04ADA8A00FB5A1B1E46AA17FE85", hash_generated_method = "0F9A1FF88DAA27F2183A5866EE831463")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.101 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.101 -0400", hash_original_method = "3B515BD8C18D4AA3426DE2CF748D864D", hash_generated_method = "F1F99C3B77DBD409480B2BA4DB39A0BA")
    @DSModeled(DSC.SAFE)
    public boolean isOverLimit(long totalBytes) {
        dsTaint.addTaint(totalBytes);
        totalBytes += 2 * DEFAULT_MTU;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //totalBytes += 2 * DEFAULT_MTU;
        //return limitBytes != LIMIT_DISABLED && totalBytes >= limitBytes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.102 -0400", hash_original_method = "94D3DEEA59ED3BCE504BE8B2D91F1F02", hash_generated_method = "E01A847926E5AEA2D2D4FE0372AD5285")
    @DSModeled(DSC.SAFE)
    public int compareTo(NetworkPolicy another) {
        dsTaint.addTaint(another.dsTaint);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (another == null || another.limitBytes == LIMIT_DISABLED) {
            //return -1;
        //}
        //if (limitBytes == LIMIT_DISABLED || another.limitBytes < limitBytes) {
            //return 1;
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.102 -0400", hash_original_method = "65DB678FEF7477006B15C098764A0236", hash_generated_method = "BC5075906F516D346C231BBA94528ECD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varE2F91B8815F89DBABB5723C23F7AD388_268725730 = (Objects.hashCode(template, cycleDay, warningBytes, limitBytes, lastSnooze));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Objects.hashCode(template, cycleDay, warningBytes, limitBytes, lastSnooze);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.102 -0400", hash_original_method = "29E54ABFFB72D1CE12A9FC870E79CFC8", hash_generated_method = "3FF21BE9E0ED5B1C7FF39734EE866A7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        {
            NetworkPolicy other;
            other = (NetworkPolicy) obj;
            boolean var1E33E7A7A24747215D00952E86674F6F_829193599 = (Objects.equal(template, other.template) && cycleDay == other.cycleDay
                    && warningBytes == other.warningBytes && limitBytes == other.limitBytes
                    && lastSnooze == other.lastSnooze);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (obj instanceof NetworkPolicy) {
            //final NetworkPolicy other = (NetworkPolicy) obj;
            //return Objects.equal(template, other.template) && cycleDay == other.cycleDay
                    //&& warningBytes == other.warningBytes && limitBytes == other.limitBytes
                    //&& lastSnooze == other.lastSnooze;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.103 -0400", hash_original_method = "CB6123FDA6EA84240F335B44F0260DCB", hash_generated_method = "AE7093E8432AE8440CB42CBD6232CE38")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "NetworkPolicy[" + template + "]: cycleDay=" + cycleDay + ", warningBytes="
                //+ warningBytes + ", limitBytes=" + limitBytes + ", lastSnooze=" + lastSnooze;
    }

    
    public static final long WARNING_DISABLED = -1;
    public static final long LIMIT_DISABLED = -1;
    public static final long SNOOZE_NEVER = -1;
    private static final long DEFAULT_MTU = 1500;
    public static final Creator<NetworkPolicy> CREATOR = new Creator<NetworkPolicy>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.103 -0400", hash_original_method = "36B6FBCF5E8EB4247DB4769E0E257CA0", hash_generated_method = "7B86F21768BB40E6D7A52F473353B313")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NetworkPolicy createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            NetworkPolicy var27B083E21468F465F19C44384EF706C5_1945487702 = (new NetworkPolicy(in));
            return (NetworkPolicy)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new NetworkPolicy(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.103 -0400", hash_original_method = "E266B1D7949E71853CAFBAC409E27D8A", hash_generated_method = "A0AF67175C3FA404AD8B879BD2FA3927")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NetworkPolicy[] newArray(int size) {
            dsTaint.addTaint(size);
            NetworkPolicy[] var336B3F5AC91D56C4E9BD68D79C7B0C26_1161020310 = (new NetworkPolicy[size]);
            return (NetworkPolicy[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new NetworkPolicy[size];
        }

        
}; //Transformed anonymous class
}

