package android.content;

// Droidsafe Imports
import android.os.Parcel;
import android.os.Parcelable;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class SyncResult implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.702 -0400", hash_original_field = "2F2EFE3175254AA8769886FBB83265D2", hash_generated_field = "BFD8A20F4C8DD7D4765EBA24654CDDFF")

    public boolean syncAlreadyInProgress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.702 -0400", hash_original_field = "3171EF0F7797317DF358FDA93E4CFAD3", hash_generated_field = "CF979CB696F4952381CD588FAF28D8C8")

    public boolean tooManyDeletions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.702 -0400", hash_original_field = "6AC8D01A0D843D1EF20D6C6A8BBF16BE", hash_generated_field = "9E1F14B63E64AB3B8FE86B9ECF85BDF8")

    public boolean tooManyRetries;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.702 -0400", hash_original_field = "B3E788D045B0C02113CA7BB9EBE60A7E", hash_generated_field = "2AD2DD4B2337D671F2E174B85A6496D1")

    public boolean databaseError;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.702 -0400", hash_original_field = "FF49CCF250C7250C8ACCB36A94EC155F", hash_generated_field = "436339CBC4C22C7F23F88B3E5A99EA3D")

    public boolean fullSyncRequested;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.702 -0400", hash_original_field = "13BAC3659683FB6DE6C8C097F491F7A2", hash_generated_field = "84E1F34EBFFCDB4B1646B7A9635BC1B6")

    public boolean partialSyncUnavailable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.703 -0400", hash_original_field = "9BE9F4BFA4ADA6C36CA6ADB0A72BA2C3", hash_generated_field = "00EE69B9457A1BE039F1B1AA3795A676")

    public boolean moreRecordsToGet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.703 -0400", hash_original_field = "77D196B208370F23D20E064B8B1B5DA0", hash_generated_field = "34D6FB90E0771C5EFE225745790D4357")

    public long delayUntil;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.703 -0400", hash_original_field = "446501053769C06C565094B26D26E8EF", hash_generated_field = "2DA27E0BB7E62E76DC01A86038B45A30")

    public SyncStats stats;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.703 -0400", hash_original_method = "74DBC91B11F83F26A5C8672BC9110150", hash_generated_method = "696D826DA747067EB7D4C0224C4748CF")
    public  SyncResult() {
        this(false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.706 -0400", hash_original_method = "A4EB0430511E7A235909D5D8195B83C3", hash_generated_method = "91BECAE191A031A094F0515DFDD12796")
    private  SyncResult(boolean syncAlreadyInProgress) {
        this.syncAlreadyInProgress = syncAlreadyInProgress;
        this.tooManyDeletions = false;
        this.tooManyRetries = false;
        this.fullSyncRequested = false;
        this.partialSyncUnavailable = false;
        this.moreRecordsToGet = false;
        this.delayUntil = 0;
        this.stats = new SyncStats();
        // ---------- Original Method ----------
        //this.syncAlreadyInProgress = syncAlreadyInProgress;
        //this.tooManyDeletions = false;
        //this.tooManyRetries = false;
        //this.fullSyncRequested = false;
        //this.partialSyncUnavailable = false;
        //this.moreRecordsToGet = false;
        //this.delayUntil = 0;
        //this.stats = new SyncStats();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.710 -0400", hash_original_method = "B695CA7A40C0F72A389E260A4C1183F2", hash_generated_method = "79661FDB89DDD261A68FCB658DDD1AB8")
    private  SyncResult(Parcel parcel) {
        syncAlreadyInProgress = parcel.readInt() != 0;
        tooManyDeletions = parcel.readInt() != 0;
        tooManyRetries = parcel.readInt() != 0;
        databaseError = parcel.readInt() != 0;
        fullSyncRequested = parcel.readInt() != 0;
        partialSyncUnavailable = parcel.readInt() != 0;
        moreRecordsToGet = parcel.readInt() != 0;
        delayUntil = parcel.readLong();
        stats = new SyncStats(parcel);
        // ---------- Original Method ----------
        //syncAlreadyInProgress = parcel.readInt() != 0;
        //tooManyDeletions = parcel.readInt() != 0;
        //tooManyRetries = parcel.readInt() != 0;
        //databaseError = parcel.readInt() != 0;
        //fullSyncRequested = parcel.readInt() != 0;
        //partialSyncUnavailable = parcel.readInt() != 0;
        //moreRecordsToGet = parcel.readInt() != 0;
        //delayUntil = parcel.readLong();
        //stats = new SyncStats(parcel);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.712 -0400", hash_original_method = "BBFDB64A99265F3C16497008E73E4C9A", hash_generated_method = "DAF5662E2D6573255621D8F251F96AF6")
    public boolean hasHardError() {
        boolean varC1E5348BDEDEF87650486371D9F53BCE_178199086 = (stats.numParseExceptions > 0
                || stats.numConflictDetectedExceptions > 0
                || stats.numAuthExceptions > 0
                || tooManyDeletions
                || tooManyRetries
                || databaseError);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1679086631 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1679086631;
        // ---------- Original Method ----------
        //return stats.numParseExceptions > 0
                //|| stats.numConflictDetectedExceptions > 0
                //|| stats.numAuthExceptions > 0
                //|| tooManyDeletions
                //|| tooManyRetries
                //|| databaseError;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.714 -0400", hash_original_method = "E6525D3C6B30E4EB9644C9103954127F", hash_generated_method = "8E87FA4B4F425E2D1B5931E29D90C57D")
    public boolean hasSoftError() {
        boolean varB24245B74C0818ECDFED556A8CFBDB85_20310662 = (syncAlreadyInProgress || stats.numIoExceptions > 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1733561223 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1733561223;
        // ---------- Original Method ----------
        //return syncAlreadyInProgress || stats.numIoExceptions > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.716 -0400", hash_original_method = "4476315D4E8DB7AB870F2DCC294654C2", hash_generated_method = "F9C81506218CE39C37A1491B0B9CFD65")
    public boolean hasError() {
        boolean varA7CBEB8A9F801420526255EFB7B70B18_1852847440 = (hasSoftError() || hasHardError());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_684670721 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_684670721;
        // ---------- Original Method ----------
        //return hasSoftError() || hasHardError();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.716 -0400", hash_original_method = "8205DB1BC4B4653595BD73EDC8C83B31", hash_generated_method = "DEBDAE21F4B06D9D02218486B56AC135")
    public boolean madeSomeProgress() {
        boolean varACF5483D3442CF7F9E8F05B96BCA3DA6_1134246352 = (((stats.numDeletes > 0) && !tooManyDeletions)
                || stats.numInserts > 0
                || stats.numUpdates > 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_497028903 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_497028903;
        // ---------- Original Method ----------
        //return ((stats.numDeletes > 0) && !tooManyDeletions)
                //|| stats.numInserts > 0
                //|| stats.numUpdates > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.718 -0400", hash_original_method = "2FCB3E59F9154933B8824104898248D1", hash_generated_method = "C8042321F51466B1524807E7567285C9")
    public void clear() {
        if(syncAlreadyInProgress)        
        {
            UnsupportedOperationException var3CDB679B53FC17FAD7DF42A36EA298AC_1197964856 = new UnsupportedOperationException(
                    "you are not allowed to clear the ALREADY_IN_PROGRESS SyncStats");
            var3CDB679B53FC17FAD7DF42A36EA298AC_1197964856.addTaint(taint);
            throw var3CDB679B53FC17FAD7DF42A36EA298AC_1197964856;
        } //End block
        tooManyDeletions = false;
        tooManyRetries = false;
        databaseError = false;
        fullSyncRequested = false;
        partialSyncUnavailable = false;
        moreRecordsToGet = false;
        delayUntil = 0;
        stats.clear();
        // ---------- Original Method ----------
        //if (syncAlreadyInProgress) {
            //throw new UnsupportedOperationException(
                    //"you are not allowed to clear the ALREADY_IN_PROGRESS SyncStats");
        //}
        //tooManyDeletions = false;
        //tooManyRetries = false;
        //databaseError = false;
        //fullSyncRequested = false;
        //partialSyncUnavailable = false;
        //moreRecordsToGet = false;
        //delayUntil = 0;
        //stats.clear();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.718 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "B3BBF4F8430E78CA625F0F9C7C535354")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1601661281 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_572093992 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_572093992;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.720 -0400", hash_original_method = "EE19136D87E129AE1F87F388C7ADFCD3", hash_generated_method = "708C3691B191D67B2BA3755433BD311E")
    public void writeToParcel(Parcel parcel, int flags) {
        addTaint(flags);
        addTaint(parcel.getTaint());
        parcel.writeInt(syncAlreadyInProgress ? 1 : 0);
        parcel.writeInt(tooManyDeletions ? 1 : 0);
        parcel.writeInt(tooManyRetries ? 1 : 0);
        parcel.writeInt(databaseError ? 1 : 0);
        parcel.writeInt(fullSyncRequested ? 1 : 0);
        parcel.writeInt(partialSyncUnavailable ? 1 : 0);
        parcel.writeInt(moreRecordsToGet ? 1 : 0);
        parcel.writeLong(delayUntil);
        stats.writeToParcel(parcel, flags);
        // ---------- Original Method ----------
        //parcel.writeInt(syncAlreadyInProgress ? 1 : 0);
        //parcel.writeInt(tooManyDeletions ? 1 : 0);
        //parcel.writeInt(tooManyRetries ? 1 : 0);
        //parcel.writeInt(databaseError ? 1 : 0);
        //parcel.writeInt(fullSyncRequested ? 1 : 0);
        //parcel.writeInt(partialSyncUnavailable ? 1 : 0);
        //parcel.writeInt(moreRecordsToGet ? 1 : 0);
        //parcel.writeLong(delayUntil);
        //stats.writeToParcel(parcel, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.722 -0400", hash_original_method = "7124545C2E1A8AB9232718D7A155D522", hash_generated_method = "3D4BDE326BD042CC5DD5F40C0DC058BF")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SyncResult:");
        if(syncAlreadyInProgress)        
        {
            sb.append(" syncAlreadyInProgress: ").append(syncAlreadyInProgress);
        } //End block
        if(tooManyDeletions)        
        sb.append(" tooManyDeletions: ").append(tooManyDeletions);
        if(tooManyRetries)        
        sb.append(" tooManyRetries: ").append(tooManyRetries);
        if(databaseError)        
        sb.append(" databaseError: ").append(databaseError);
        if(fullSyncRequested)        
        sb.append(" fullSyncRequested: ").append(fullSyncRequested);
        if(partialSyncUnavailable)        
        {
            sb.append(" partialSyncUnavailable: ").append(partialSyncUnavailable);
        } //End block
        if(moreRecordsToGet)        
        sb.append(" moreRecordsToGet: ").append(moreRecordsToGet);
        if(delayUntil > 0)        
        sb.append(" delayUntil: ").append(delayUntil);
        sb.append(stats);
String var2460B846747F8B22185AD8BE722266A5_2037503970 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_2037503970.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_2037503970;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.725 -0400", hash_original_method = "4BAB8C537F83CAF09BA4245CA1B5A6A2", hash_generated_method = "F1240AE3D92C149AB1DCEC293F9B3444")
    public String toDebugString() {
        StringBuffer sb = new StringBuffer();
        if(fullSyncRequested)        
        {
            sb.append("f1");
        } //End block
        if(partialSyncUnavailable)        
        {
            sb.append("r1");
        } //End block
        if(hasHardError())        
        {
            sb.append("X1");
        } //End block
        if(stats.numParseExceptions > 0)        
        {
            sb.append("e").append(stats.numParseExceptions);
        } //End block
        if(stats.numConflictDetectedExceptions > 0)        
        {
            sb.append("c").append(stats.numConflictDetectedExceptions);
        } //End block
        if(stats.numAuthExceptions > 0)        
        {
            sb.append("a").append(stats.numAuthExceptions);
        } //End block
        if(tooManyDeletions)        
        {
            sb.append("D1");
        } //End block
        if(tooManyRetries)        
        {
            sb.append("R1");
        } //End block
        if(databaseError)        
        {
            sb.append("b1");
        } //End block
        if(hasSoftError())        
        {
            sb.append("x1");
        } //End block
        if(syncAlreadyInProgress)        
        {
            sb.append("l1");
        } //End block
        if(stats.numIoExceptions > 0)        
        {
            sb.append("I").append(stats.numIoExceptions);
        } //End block
String var2460B846747F8B22185AD8BE722266A5_489761175 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_489761175.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_489761175;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.726 -0400", hash_original_field = "6D5119A348BD0CC32773C034FE96684C", hash_generated_field = "7027FBC7AA2E8EFBEEF08475D7C0847B")

    public static final SyncResult ALREADY_IN_PROGRESS;
    static {
        ALREADY_IN_PROGRESS = new SyncResult(true);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.726 -0400", hash_original_field = "78B42CBC7BB00AEC88D972EE0CA8E716", hash_generated_field = "0BFBE4FA78FD3B51E53BE26F718EB099")

    public static final Creator<SyncResult> CREATOR = new Creator<SyncResult>() {
        public SyncResult createFromParcel(Parcel in) {
            return new SyncResult(in);
        }

        public SyncResult[] newArray(int size) {
            return new SyncResult[size];
        }
    };
    // orphaned legacy method
    public SyncResult createFromParcel(Parcel in) {
            return new SyncResult(in);
        }
    
    // orphaned legacy method
    public SyncResult[] newArray(int size) {
            return new SyncResult[size];
        }
    
}

