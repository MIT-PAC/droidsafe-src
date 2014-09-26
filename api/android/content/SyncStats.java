package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public class SyncStats implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.769 -0400", hash_original_field = "55F2D29CBE234779B1FDF539D493D020", hash_generated_field = "17E16BE7064CEFEFD5C68A11BA2D5E7F")

    public static final Creator<SyncStats> CREATOR = new Creator<SyncStats>() {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.203 -0500", hash_original_method = "C2645D5BA9D9FCCEB63132F3E7AAEA49", hash_generated_method = "AE16B33C3F0D3A0C2E4B5D1E33802719")
        
public SyncStats createFromParcel(Parcel in) {
            return new SyncStats(in);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.206 -0500", hash_original_method = "F2454254615F13F768A13C331B8D3123", hash_generated_method = "79CBA3857A99A23E703D04724DF53888")
        
public SyncStats[] newArray(int size) {
            return new SyncStats[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.168 -0500", hash_original_field = "D8485F351CB9CAA5138E591C77601B48", hash_generated_field = "BDB1B90CA7DB793AAF5432BA8C758FAF")

    public long numAuthExceptions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.170 -0500", hash_original_field = "9E5A54A2281E61DEE0CE463EB7032292", hash_generated_field = "A3FF633E4E96FA5FC86A9EC6664E93C1")

    public long numIoExceptions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.172 -0500", hash_original_field = "86A79B28BC28A9176A7C08A86CCC6002", hash_generated_field = "8D71B8B2B6402AE1755ED9C82A8672E5")

    public long numParseExceptions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.174 -0500", hash_original_field = "5729767CC2214D41F83F141AB9AE51D3", hash_generated_field = "9BE31FAD49A3630028560BD5EEDDCAE4")

    public long numConflictDetectedExceptions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.177 -0500", hash_original_field = "1D6FA2EFA2FB95829064AA4A7839CDDF", hash_generated_field = "198BCFC3BE411FDA379AABCED6A3DCC0")

    public long numInserts;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.179 -0500", hash_original_field = "4702DECA2FF0BC9F21AB2DBF8CF53859", hash_generated_field = "E3241C984FAFA64FFD8373F935845026")

    public long numUpdates;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.181 -0500", hash_original_field = "DA58016584C80157BBFB58A448DCA3A8", hash_generated_field = "8F8FA0231416101828398E30FD14C0D5")

    public long numDeletes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.183 -0500", hash_original_field = "21292EBDD2D2AA2409496C9CAC2F5D0B", hash_generated_field = "440A6357CB8B6502A76172CE2E833894")

    public long numEntries;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.185 -0500", hash_original_field = "274417E55959CCE5B360BE34981D93BC", hash_generated_field = "BEDE6C478C5CF4979A6294A473E9E9F1")

    public long numSkippedEntries;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.187 -0500", hash_original_method = "AD75EEB91F0DE3327218E1B3E5E5D264", hash_generated_method = "243FB9DD19779AAF19CB4B2AD5A5C3A3")
    
public SyncStats() {
        numAuthExceptions = 0;
        numIoExceptions = 0;
        numParseExceptions = 0;
        numConflictDetectedExceptions = 0;
        numInserts = 0;
        numUpdates = 0;
        numDeletes = 0;
        numEntries = 0;
        numSkippedEntries = 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.190 -0500", hash_original_method = "260AFEEBBB5524547C0B494C2066E7B3", hash_generated_method = "CC3D24B9070A64FDF6C4F04E0E970488")
    
public SyncStats(Parcel in) {
        numAuthExceptions = in.readLong();
        numIoExceptions = in.readLong();
        numParseExceptions = in.readLong();
        numConflictDetectedExceptions = in.readLong();
        numInserts = in.readLong();
        numUpdates = in.readLong();
        numDeletes = in.readLong();
        numEntries = in.readLong();
        numSkippedEntries = in.readLong();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.193 -0500", hash_original_method = "2B2EA245A3AB4724B2781C31270E76F8", hash_generated_method = "E85C6836B6E8D17E5DF3DF000EDE6EA4")
    
@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" stats [");
        if (numAuthExceptions > 0) sb.append(" numAuthExceptions: ").append(numAuthExceptions);
        if (numIoExceptions > 0) sb.append(" numIoExceptions: ").append(numIoExceptions);
        if (numParseExceptions > 0) sb.append(" numParseExceptions: ").append(numParseExceptions);
        if (numConflictDetectedExceptions > 0)
            sb.append(" numConflictDetectedExceptions: ").append(numConflictDetectedExceptions);
        if (numInserts > 0) sb.append(" numInserts: ").append(numInserts);
        if (numUpdates > 0) sb.append(" numUpdates: ").append(numUpdates);
        if (numDeletes > 0) sb.append(" numDeletes: ").append(numDeletes);
        if (numEntries > 0) sb.append(" numEntries: ").append(numEntries);
        if (numSkippedEntries > 0) sb.append(" numSkippedEntries: ").append(numSkippedEntries);
        sb.append("]");
        return sb.toString();
    }

    /**
     * Reset all the counters to 0.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.195 -0500", hash_original_method = "1DD335886100A2D5B4563E7A7FCB1E25", hash_generated_method = "38B64ED35408E53105D19C6AADAB23EF")
    
public void clear() {
        numAuthExceptions = 0;
        numIoExceptions = 0;
        numParseExceptions = 0;
        numConflictDetectedExceptions = 0;
        numInserts = 0;
        numUpdates = 0;
        numDeletes = 0;
        numEntries = 0;
        numSkippedEntries = 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.197 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.200 -0500", hash_original_method = "E0866F8CBFAFA913559B9596FBB866BC", hash_generated_method = "D56621CF3A07B62BA1471D0B59947C84")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(numAuthExceptions);
        dest.writeLong(numIoExceptions);
        dest.writeLong(numParseExceptions);
        dest.writeLong(numConflictDetectedExceptions);
        dest.writeLong(numInserts);
        dest.writeLong(numUpdates);
        dest.writeLong(numDeletes);
        dest.writeLong(numEntries);
        dest.writeLong(numSkippedEntries);
    }
    // orphaned legacy method
    public SyncStats createFromParcel(Parcel in) {
            return new SyncStats(in);
        }
    
    // orphaned legacy method
    public SyncStats[] newArray(int size) {
            return new SyncStats[size];
        }
    
}

