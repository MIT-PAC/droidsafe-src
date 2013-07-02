package android.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcelable;
import android.os.Parcel;

public class SyncStats implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.325 -0400", hash_original_field = "4D71AE137C8B2E7A14525A08368B1901", hash_generated_field = "BDB1B90CA7DB793AAF5432BA8C758FAF")

    public long numAuthExceptions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.325 -0400", hash_original_field = "1949CD228872C1BDADF76D55AC3F36BA", hash_generated_field = "A3FF633E4E96FA5FC86A9EC6664E93C1")

    public long numIoExceptions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.325 -0400", hash_original_field = "97618CF24E8E88B9537620BE60B62227", hash_generated_field = "8D71B8B2B6402AE1755ED9C82A8672E5")

    public long numParseExceptions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.325 -0400", hash_original_field = "629A240D267702A6F1FDD5702188478A", hash_generated_field = "9BE31FAD49A3630028560BD5EEDDCAE4")

    public long numConflictDetectedExceptions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.325 -0400", hash_original_field = "16C6233C5AC8AB175CCF9BCCDF06A70B", hash_generated_field = "198BCFC3BE411FDA379AABCED6A3DCC0")

    public long numInserts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.325 -0400", hash_original_field = "15230D8A318B50C432B8DA9F137EEA38", hash_generated_field = "E3241C984FAFA64FFD8373F935845026")

    public long numUpdates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.325 -0400", hash_original_field = "DB0F3D80E51EDDBC980BCA1E980D67B9", hash_generated_field = "8F8FA0231416101828398E30FD14C0D5")

    public long numDeletes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.325 -0400", hash_original_field = "FEC1FCC4A89DEF29A9B7C6D06198C501", hash_generated_field = "440A6357CB8B6502A76172CE2E833894")

    public long numEntries;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.325 -0400", hash_original_field = "815D4910B1798B7096DE973E5E56EF66", hash_generated_field = "BEDE6C478C5CF4979A6294A473E9E9F1")

    public long numSkippedEntries;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.326 -0400", hash_original_method = "AD75EEB91F0DE3327218E1B3E5E5D264", hash_generated_method = "5F01C26B38FCDD2B4D2DAB5F51DAB603")
    public  SyncStats() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.327 -0400", hash_original_method = "260AFEEBBB5524547C0B494C2066E7B3", hash_generated_method = "FE23EC0D5E9F39412B3AC18888EA58BE")
    public  SyncStats(Parcel in) {
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.328 -0400", hash_original_method = "2B2EA245A3AB4724B2781C31270E76F8", hash_generated_method = "D566467F949CDD57F7572EBCD38EBAF8")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1071585881 = null; 
        StringBuilder sb = new StringBuilder();
        sb.append(" stats [");
        sb.append(" numAuthExceptions: ").append(numAuthExceptions);
        sb.append(" numIoExceptions: ").append(numIoExceptions);
        sb.append(" numParseExceptions: ").append(numParseExceptions);
        sb.append(" numConflictDetectedExceptions: ").append(numConflictDetectedExceptions);
        sb.append(" numInserts: ").append(numInserts);
        sb.append(" numUpdates: ").append(numUpdates);
        sb.append(" numDeletes: ").append(numDeletes);
        sb.append(" numEntries: ").append(numEntries);
        sb.append(" numSkippedEntries: ").append(numSkippedEntries);
        sb.append("]");
        varB4EAC82CA7396A68D541C85D26508E83_1071585881 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1071585881.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1071585881;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.331 -0400", hash_original_method = "1DD335886100A2D5B4563E7A7FCB1E25", hash_generated_method = "93AA46C01012055B3F5E59B0B8F94448")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.331 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "4E475650F05690BCE98D0546E2E6956E")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1848896576 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1848896576;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.332 -0400", hash_original_method = "E0866F8CBFAFA913559B9596FBB866BC", hash_generated_method = "94E7DFD1E4201ABF10E2AEEBC357DE8D")
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
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.332 -0400", hash_original_field = "55F2D29CBE234779B1FDF539D493D020", hash_generated_field = "17E16BE7064CEFEFD5C68A11BA2D5E7F")

    public static final Creator<SyncStats> CREATOR = new Creator<SyncStats>() {
        public SyncStats createFromParcel(Parcel in) {
            return new SyncStats(in);
        }

        public SyncStats[] newArray(int size) {
            return new SyncStats[size];
        }
    };
    
    public SyncStats createFromParcel(Parcel in) {
            return new SyncStats(in);
        }
    
    
    public SyncStats[] newArray(int size) {
            return new SyncStats[size];
        }
    
}

