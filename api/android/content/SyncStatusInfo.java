package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class SyncStatusInfo implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.589 -0500", hash_original_field = "F6DDD389535BD862127788159866DF12", hash_generated_field = "78D7348159FCA08FC47896DADC9A6ECC")

    static final int VERSION = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.627 -0500", hash_original_field = "A5C7BE17890DC342F3396758FD0DD22D", hash_generated_field = "4CCB2F73BD98045FB7A49DC531F6A5B0")

    private static final String TAG = "Sync";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.818 -0400", hash_original_field = "4B380E2AA31D16D86BF89F8EE0A58282", hash_generated_field = "34F7BA97EC5F779445C9A58D21D7DF7D")

    public static final Creator<SyncStatusInfo> CREATOR = new Creator<SyncStatusInfo>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.651 -0500", hash_original_method = "7000403894FD3D88AA5C75270F571170", hash_generated_method = "54800B516C81ACD8991B10950466CDDB")
        
public SyncStatusInfo createFromParcel(Parcel in) {
            return new SyncStatusInfo(in);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.654 -0500", hash_original_method = "59BC53FE0FEC79565943AAF0BCFA71FD", hash_generated_method = "A1E80DDA67CF95C5E67C809BD8B9F400")
        
public SyncStatusInfo[] newArray(int size) {
            return new SyncStatusInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.591 -0500", hash_original_field = "B11D0145EE299937169261FF5464F8E6", hash_generated_field = "A9902B6EC2628AF68CD4117B511E65F0")

    public  int authorityId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.593 -0500", hash_original_field = "1B9B3FB2A9D2F8EA7767FA1AE420A5B4", hash_generated_field = "5D7384269F724CBADC7F9E403A55C48C")

    public long totalElapsedTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.595 -0500", hash_original_field = "5D38FF7D9D19C76DB29EFDB471CB5A52", hash_generated_field = "45FA19DB50FC1AFC3AFA9748BF15F97C")

    public int numSyncs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.597 -0500", hash_original_field = "D4F58EBC13ED34850FFA4B5CA6B6E225", hash_generated_field = "297E9C7A23835F11C9957370D1ED8A75")

    public int numSourcePoll;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.600 -0500", hash_original_field = "3FFE612AFD2CE3A582AD57C6FEC6E860", hash_generated_field = "F9A2FDC9C88FCD806F4525422EF10BF1")

    public int numSourceServer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.602 -0500", hash_original_field = "B3092568BED8EAECEE608AD2F1BF45E4", hash_generated_field = "B0F48BB93F3B5FE342F20AE3FB948F58")

    public int numSourceLocal;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.604 -0500", hash_original_field = "42EC0977E1217DAAA532FB1D29B3F537", hash_generated_field = "8CF18E48FF0658748266846505863C84")

    public int numSourceUser;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.606 -0500", hash_original_field = "B2A303BF3D36632E3DCCAA59406B5146", hash_generated_field = "12AEAE23203E6890D332E062563C0CF9")

    public int numSourcePeriodic;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.608 -0500", hash_original_field = "5858735DF731FC09776DB21A7D63ED21", hash_generated_field = "D1DD70D28F5DEB94EE2F4546FE50674D")

    public long lastSuccessTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.610 -0500", hash_original_field = "DA21108AB2A021E42DED3B778850CBB7", hash_generated_field = "FA28C0FBC143DEA0A6029269A23776E9")

    public int lastSuccessSource;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.612 -0500", hash_original_field = "9C5372D6B57FBDD1EA3B3AAC70764FF4", hash_generated_field = "6AFA009245A986652AE38EE5259B6ED5")

    public long lastFailureTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.614 -0500", hash_original_field = "B89280834F59DC8282A07C690D43922A", hash_generated_field = "073927D6239FA4A9D397F9C6F6FB3874")

    public int lastFailureSource;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.616 -0500", hash_original_field = "FE9A48F70A385ECEBD7FB6FBAFA83DC8", hash_generated_field = "29147D591F50D9505557E1B4326C0CB8")

    public String lastFailureMesg;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.619 -0500", hash_original_field = "C2EEB488C0DF909F7FB261C7B8A79BC0", hash_generated_field = "A4E8436F857C29CAAE565EB026B82BBE")

    public long initialFailureTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.621 -0500", hash_original_field = "DB70A1B82DCF9D0BCECDD1827D9C7A46", hash_generated_field = "C4E7D79FB8FE79DA47A44B5030EA64A2")

    public boolean pending;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.623 -0500", hash_original_field = "9D85567FAB9D464CACFC789120075426", hash_generated_field = "906CA71C20CC6AD4C27A4C720CE75383")

    public boolean initialize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.625 -0500", hash_original_field = "2F9DBF5BD7EA77B3D91FF5817DBA8331", hash_generated_field = "191FD4C3F411078AF38A8B10F0164DAD")

    public ArrayList<Long> periodicSyncTimes;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.629 -0500", hash_original_method = "A601236BC9972CD1DA6DEFC9BDCCDDF9", hash_generated_method = "A601236BC9972CD1DA6DEFC9BDCCDDF9")
    
SyncStatusInfo(int authorityId) {
        this.authorityId = authorityId;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.640 -0500", hash_original_method = "48BE1C9789126DF2BDCDE38D758F27DD", hash_generated_method = "48BE1C9789126DF2BDCDE38D758F27DD")
    
SyncStatusInfo(Parcel parcel) {
        int version = parcel.readInt();
        if (version != VERSION && version != 1) {
            Log.w("SyncStatusInfo", "Unknown version: " + version);
        }
        authorityId = parcel.readInt();
        totalElapsedTime = parcel.readLong();
        numSyncs = parcel.readInt();
        numSourcePoll = parcel.readInt();
        numSourceServer = parcel.readInt();
        numSourceLocal = parcel.readInt();
        numSourceUser = parcel.readInt();
        lastSuccessTime = parcel.readLong();
        lastSuccessSource = parcel.readInt();
        lastFailureTime = parcel.readLong();
        lastFailureSource = parcel.readInt();
        lastFailureMesg = parcel.readString();
        initialFailureTime = parcel.readLong();
        pending = parcel.readInt() != 0;
        initialize = parcel.readInt() != 0;
        if (version == 1) {
            periodicSyncTimes = null;
        } else {
            int N = parcel.readInt();
            if (N < 0) {
                periodicSyncTimes = null;
            } else {
                periodicSyncTimes = new ArrayList<Long>();
                for (int i=0; i<N; i++) {
                    periodicSyncTimes.add(parcel.readLong());
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.632 -0500", hash_original_method = "7E33E8226B73A02621B31754517607B3", hash_generated_method = "FAAF24998EAF5A6F374E088CFC265A72")
    
public int getLastFailureMesgAsInt(int def) {
        try {
            if (lastFailureMesg != null) {
                return Integer.parseInt(lastFailureMesg);
            }
        } catch (NumberFormatException e) {
            Log.d(TAG, "error parsing lastFailureMesg of " + lastFailureMesg, e);
        }
        return def;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.634 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.637 -0500", hash_original_method = "9461760C81A4DFF607A36CA2D6370E1C", hash_generated_method = "2E60B0C1E313DDA83CF03B6E7D3E6A14")
    
public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(VERSION);
        parcel.writeInt(authorityId);
        parcel.writeLong(totalElapsedTime);
        parcel.writeInt(numSyncs);
        parcel.writeInt(numSourcePoll);
        parcel.writeInt(numSourceServer);
        parcel.writeInt(numSourceLocal);
        parcel.writeInt(numSourceUser);
        parcel.writeLong(lastSuccessTime);
        parcel.writeInt(lastSuccessSource);
        parcel.writeLong(lastFailureTime);
        parcel.writeInt(lastFailureSource);
        parcel.writeString(lastFailureMesg);
        parcel.writeLong(initialFailureTime);
        parcel.writeInt(pending ? 1 : 0);
        parcel.writeInt(initialize ? 1 : 0);
        if (periodicSyncTimes != null) {
            parcel.writeInt(periodicSyncTimes.size());
            for (long periodicSyncTime : periodicSyncTimes) {
                parcel.writeLong(periodicSyncTime);
            }
        } else {
            parcel.writeInt(-1);
        }
    }

    @DSSink({DSSinkKind.SYNCHRONIZATION_DATA})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.642 -0500", hash_original_method = "BB3C22BCE01837AA4BAC40A0B35F8BC2", hash_generated_method = "E6DF29A0C803CBABCAB30F4C265C5317")
    
public void setPeriodicSyncTime(int index, long when) {
        ensurePeriodicSyncTimeSize(index);
        periodicSyncTimes.set(index, when);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.644 -0500", hash_original_method = "CB3B6F2BD6B69A04BBE5B4B8321ED55E", hash_generated_method = "1E231E5C13520B687E0DE2A9860D3F11")
    
private void ensurePeriodicSyncTimeSize(int index) {
        if (periodicSyncTimes == null) {
            periodicSyncTimes = new ArrayList<Long>(0);
        }

        final int requiredSize = index + 1;
        if (periodicSyncTimes.size() < requiredSize) {
            for (int i = periodicSyncTimes.size(); i < requiredSize; i++) {
                periodicSyncTimes.add((long) 0);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.647 -0500", hash_original_method = "E0266DD4F289B692F6E7B79E10E75B20", hash_generated_method = "251C49A55B5191AE5B17ED4632F8B629")
    
public long getPeriodicSyncTime(int index) {
        if (periodicSyncTimes == null || periodicSyncTimes.size() < (index + 1)) {
            return 0;
        }
        return periodicSyncTimes.get(index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.649 -0500", hash_original_method = "5D5F49D9C483CE201F8BB2B6D37F0FB1", hash_generated_method = "553566F1AAE5564061B963E59166F8B8")
    
public void removePeriodicSyncTime(int index) {
        ensurePeriodicSyncTimeSize(index);
        periodicSyncTimes.remove(index);
    }
    // orphaned legacy method
    public SyncStatusInfo createFromParcel(Parcel in) {
            return new SyncStatusInfo(in);
        }
    
    // orphaned legacy method
    public SyncStatusInfo[] newArray(int size) {
            return new SyncStatusInfo[size];
        }
    
}

