package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcelable;
import android.os.Parcel;

public class SyncStats implements Parcelable {
    public long numAuthExceptions;
    public long numIoExceptions;
    public long numParseExceptions;
    public long numConflictDetectedExceptions;
    public long numInserts;
    public long numUpdates;
    public long numDeletes;
    public long numEntries;
    public long numSkippedEntries;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.086 -0400", hash_original_method = "AD75EEB91F0DE3327218E1B3E5E5D264", hash_generated_method = "5F01C26B38FCDD2B4D2DAB5F51DAB603")
    @DSModeled(DSC.SAFE)
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
        // ---------- Original Method ----------
        //numAuthExceptions = 0;
        //numIoExceptions = 0;
        //numParseExceptions = 0;
        //numConflictDetectedExceptions = 0;
        //numInserts = 0;
        //numUpdates = 0;
        //numDeletes = 0;
        //numEntries = 0;
        //numSkippedEntries = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.087 -0400", hash_original_method = "260AFEEBBB5524547C0B494C2066E7B3", hash_generated_method = "E2BB99215AD2DA52A01D93FF3895E182")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SyncStats(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        numAuthExceptions = in.readLong();
        numIoExceptions = in.readLong();
        numParseExceptions = in.readLong();
        numConflictDetectedExceptions = in.readLong();
        numInserts = in.readLong();
        numUpdates = in.readLong();
        numDeletes = in.readLong();
        numEntries = in.readLong();
        numSkippedEntries = in.readLong();
        // ---------- Original Method ----------
        //numAuthExceptions = in.readLong();
        //numIoExceptions = in.readLong();
        //numParseExceptions = in.readLong();
        //numConflictDetectedExceptions = in.readLong();
        //numInserts = in.readLong();
        //numUpdates = in.readLong();
        //numDeletes = in.readLong();
        //numEntries = in.readLong();
        //numSkippedEntries = in.readLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.088 -0400", hash_original_method = "2B2EA245A3AB4724B2781C31270E76F8", hash_generated_method = "9B83AB9E5133D67BCF643D9D955D3A24")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder();
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
        String var806458D832AB974D230FEE4CBBDBD390_445223259 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.089 -0400", hash_original_method = "1DD335886100A2D5B4563E7A7FCB1E25", hash_generated_method = "93AA46C01012055B3F5E59B0B8F94448")
    @DSModeled(DSC.SAFE)
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
        // ---------- Original Method ----------
        //numAuthExceptions = 0;
        //numIoExceptions = 0;
        //numParseExceptions = 0;
        //numConflictDetectedExceptions = 0;
        //numInserts = 0;
        //numUpdates = 0;
        //numDeletes = 0;
        //numEntries = 0;
        //numSkippedEntries = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.089 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.089 -0400", hash_original_method = "E0866F8CBFAFA913559B9596FBB866BC", hash_generated_method = "CCF2E6027FA7A9E516695A2F0397D9B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeLong(numAuthExceptions);
        dest.writeLong(numIoExceptions);
        dest.writeLong(numParseExceptions);
        dest.writeLong(numConflictDetectedExceptions);
        dest.writeLong(numInserts);
        dest.writeLong(numUpdates);
        dest.writeLong(numDeletes);
        dest.writeLong(numEntries);
        dest.writeLong(numSkippedEntries);
        // ---------- Original Method ----------
        //dest.writeLong(numAuthExceptions);
        //dest.writeLong(numIoExceptions);
        //dest.writeLong(numParseExceptions);
        //dest.writeLong(numConflictDetectedExceptions);
        //dest.writeLong(numInserts);
        //dest.writeLong(numUpdates);
        //dest.writeLong(numDeletes);
        //dest.writeLong(numEntries);
        //dest.writeLong(numSkippedEntries);
    }

    
    public static final Creator<SyncStats> CREATOR = new Creator<SyncStats>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.089 -0400", hash_original_method = "C2645D5BA9D9FCCEB63132F3E7AAEA49", hash_generated_method = "4A3FBA4ADADBB6E794F76A53DBE15C7A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SyncStats createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            SyncStats var6D174742EFB33E5F6FDC914DCDC1B7D8_1589758932 = (new SyncStats(in));
            return (SyncStats)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SyncStats(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.090 -0400", hash_original_method = "F2454254615F13F768A13C331B8D3123", hash_generated_method = "20BDC4FAEB7A6CBB31A89AC3C1FC9245")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SyncStats[] newArray(int size) {
            dsTaint.addTaint(size);
            SyncStats[] var0C6C1A294AA732A037990BD1BCC74ED9_1658026189 = (new SyncStats[size]);
            return (SyncStats[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SyncStats[size];
        }

        
}; //Transformed anonymous class
}

