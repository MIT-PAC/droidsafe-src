package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public final class SyncResult implements Parcelable {
    public boolean syncAlreadyInProgress;
    public boolean tooManyDeletions;
    public boolean tooManyRetries;
    public boolean databaseError;
    public boolean fullSyncRequested;
    public boolean partialSyncUnavailable;
    public boolean moreRecordsToGet;
    public long delayUntil;
    public SyncStats stats;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.065 -0400", hash_original_method = "74DBC91B11F83F26A5C8672BC9110150", hash_generated_method = "696D826DA747067EB7D4C0224C4748CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SyncResult() {
        this(false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.066 -0400", hash_original_method = "A4EB0430511E7A235909D5D8195B83C3", hash_generated_method = "ABD091230C37192BA610EE22E9606C62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SyncResult(boolean syncAlreadyInProgress) {
        dsTaint.addTaint(syncAlreadyInProgress);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.066 -0400", hash_original_method = "B695CA7A40C0F72A389E260A4C1183F2", hash_generated_method = "88F47D9D65C8FCC494BC8DD1854ADB26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SyncResult(Parcel parcel) {
        dsTaint.addTaint(parcel.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.067 -0400", hash_original_method = "BBFDB64A99265F3C16497008E73E4C9A", hash_generated_method = "AF080F679F7B44635DF244A204471420")
    @DSModeled(DSC.SAFE)
    public boolean hasHardError() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return stats.numParseExceptions > 0
                //|| stats.numConflictDetectedExceptions > 0
                //|| stats.numAuthExceptions > 0
                //|| tooManyDeletions
                //|| tooManyRetries
                //|| databaseError;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.067 -0400", hash_original_method = "E6525D3C6B30E4EB9644C9103954127F", hash_generated_method = "F117C11AA29A36CA1A98388210C37A80")
    @DSModeled(DSC.SAFE)
    public boolean hasSoftError() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return syncAlreadyInProgress || stats.numIoExceptions > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.067 -0400", hash_original_method = "4476315D4E8DB7AB870F2DCC294654C2", hash_generated_method = "F3D9A9BEB2112966C93D22A29562D6F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasError() {
        boolean varF5ECE22A2EC0AA13658513FEEF2C337F_752038330 = (hasSoftError() || hasHardError());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return hasSoftError() || hasHardError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.068 -0400", hash_original_method = "8205DB1BC4B4653595BD73EDC8C83B31", hash_generated_method = "04D6C2FEFFABCB6FB16D77548E2B7462")
    @DSModeled(DSC.SAFE)
    public boolean madeSomeProgress() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((stats.numDeletes > 0) && !tooManyDeletions)
                //|| stats.numInserts > 0
                //|| stats.numUpdates > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.068 -0400", hash_original_method = "2FCB3E59F9154933B8824104898248D1", hash_generated_method = "B15481B6AE55774897A58BCDD638EDC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear() {
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
                    "you are not allowed to clear the ALREADY_IN_PROGRESS SyncStats");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.068 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.069 -0400", hash_original_method = "EE19136D87E129AE1F87F388C7ADFCD3", hash_generated_method = "DF9AE225A9AA60693BC808F8612F5AC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel parcel, int flags) {
        dsTaint.addTaint(parcel.dsTaint);
        dsTaint.addTaint(flags);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.069 -0400", hash_original_method = "7124545C2E1A8AB9232718D7A155D522", hash_generated_method = "3672372EB9383279128D1D48A4F43A55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("SyncResult:");
        {
            sb.append(" syncAlreadyInProgress: ").append(syncAlreadyInProgress);
        } //End block
        sb.append(" tooManyDeletions: ").append(tooManyDeletions);
        sb.append(" tooManyRetries: ").append(tooManyRetries);
        sb.append(" databaseError: ").append(databaseError);
        sb.append(" fullSyncRequested: ").append(fullSyncRequested);
        {
            sb.append(" partialSyncUnavailable: ").append(partialSyncUnavailable);
        } //End block
        sb.append(" moreRecordsToGet: ").append(moreRecordsToGet);
        sb.append(" delayUntil: ").append(delayUntil);
        sb.append(stats);
        String var806458D832AB974D230FEE4CBBDBD390_1569059975 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.070 -0400", hash_original_method = "4BAB8C537F83CAF09BA4245CA1B5A6A2", hash_generated_method = "C8ACDF6E0267163F515950D7F289CD21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toDebugString() {
        StringBuffer sb;
        sb = new StringBuffer();
        {
            sb.append("f1");
        } //End block
        {
            sb.append("r1");
        } //End block
        {
            boolean var2CE0AA7E0D34CB9BB18B774C69DE79B7_630995773 = (hasHardError());
            {
                sb.append("X1");
            } //End block
        } //End collapsed parenthetic
        {
            sb.append("e").append(stats.numParseExceptions);
        } //End block
        {
            sb.append("c").append(stats.numConflictDetectedExceptions);
        } //End block
        {
            sb.append("a").append(stats.numAuthExceptions);
        } //End block
        {
            sb.append("D1");
        } //End block
        {
            sb.append("R1");
        } //End block
        {
            sb.append("b1");
        } //End block
        {
            boolean var2CF9F1F03CE1917A3682EE34C3D2F638_1341087951 = (hasSoftError());
            {
                sb.append("x1");
            } //End block
        } //End collapsed parenthetic
        {
            sb.append("l1");
        } //End block
        {
            sb.append("I").append(stats.numIoExceptions);
        } //End block
        String var806458D832AB974D230FEE4CBBDBD390_2121852091 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static final SyncResult ALREADY_IN_PROGRESS;
    static {
        ALREADY_IN_PROGRESS = new SyncResult(true);
    }
    
    public static final Creator<SyncResult> CREATOR = new Creator<SyncResult>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.070 -0400", hash_original_method = "4C8D61D924E0543F15189C7113C38388", hash_generated_method = "00C12D3F2110C925FD9A3E2F8A4CB2AF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SyncResult createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            SyncResult var513D51A4317763EB6A21E0D316D1F702_553534942 = (new SyncResult(in));
            return (SyncResult)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SyncResult(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.070 -0400", hash_original_method = "E92662981D9050E05B83CC0170AFD08C", hash_generated_method = "706276791558C9981AFB9E749487189C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SyncResult[] newArray(int size) {
            dsTaint.addTaint(size);
            SyncResult[] var26EAAE024149AD54A88C3F207EA182E4_308558954 = (new SyncResult[size]);
            return (SyncResult[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SyncResult[size];
        }

        
}; //Transformed anonymous class
}

