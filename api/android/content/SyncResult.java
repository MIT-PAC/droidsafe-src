package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public final class SyncResult implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.077 -0500", hash_original_field = "E795FCB39BBD6EF29604FA75C6911ED0", hash_generated_field = "64D14EC76565F2A3816742941F7A6009")

    public static  SyncResult ALREADY_IN_PROGRESS;
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.726 -0400", hash_original_field = "78B42CBC7BB00AEC88D972EE0CA8E716", hash_generated_field = "0BFBE4FA78FD3B51E53BE26F718EB099")

    public static final Creator<SyncResult> CREATOR = new Creator<SyncResult>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.099 -0500", hash_original_method = "4C8D61D924E0543F15189C7113C38388", hash_generated_method = "D8D14ED9A11EAD32BB2AB0B3A2186A07")
        
public SyncResult createFromParcel(Parcel in) {
            return new SyncResult(in);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.102 -0500", hash_original_method = "E92662981D9050E05B83CC0170AFD08C", hash_generated_method = "050819128E38B7993E1BF55A2C36E783")
        
public SyncResult[] newArray(int size) {
            return new SyncResult[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.058 -0500", hash_original_field = "72FB2C5FCA6712D23033D0F911FEBEA3", hash_generated_field = "BFD8A20F4C8DD7D4765EBA24654CDDFF")

    public  boolean syncAlreadyInProgress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.060 -0500", hash_original_field = "827D61C8FB7FB1FE8BB834946D852625", hash_generated_field = "CF979CB696F4952381CD588FAF28D8C8")

    public boolean tooManyDeletions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.062 -0500", hash_original_field = "1B1E65876481C200F51229A3C2712AF1", hash_generated_field = "9E1F14B63E64AB3B8FE86B9ECF85BDF8")

    public boolean tooManyRetries;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.064 -0500", hash_original_field = "91D52975C5DA65973F89CB16B947AE17", hash_generated_field = "2AD2DD4B2337D671F2E174B85A6496D1")

    public boolean databaseError;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.066 -0500", hash_original_field = "B65D2856AB417003465ECBFE1D042C6F", hash_generated_field = "436339CBC4C22C7F23F88B3E5A99EA3D")

    public boolean fullSyncRequested;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.068 -0500", hash_original_field = "CA447005461167E8256D2F9375D9A421", hash_generated_field = "84E1F34EBFFCDB4B1646B7A9635BC1B6")

    public boolean partialSyncUnavailable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.070 -0500", hash_original_field = "CA896820FCAFADE83D6AA0725E0C6070", hash_generated_field = "00EE69B9457A1BE039F1B1AA3795A676")

    public boolean moreRecordsToGet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.072 -0500", hash_original_field = "FF2672CE15194FA4F169DAC34CF8A869", hash_generated_field = "34D6FB90E0771C5EFE225745790D4357")

    public long delayUntil;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.075 -0500", hash_original_field = "D9857DDC747D1046CEB8C2050F9A9119", hash_generated_field = "2DA27E0BB7E62E76DC01A86038B45A30")

    public  SyncStats stats;

    /**
     * Create a "clean" SyncResult. If this is returned without any changes then the
     * SyncManager will consider the sync to have completed successfully. The various fields
     * can be set by the SyncAdapter in order to give the SyncManager more information as to
     * the disposition of the sync.
     * <p>
     * The errors are classified into two broad categories: hard errors and soft errors.
     * Soft errors are retried with exponential backoff. Hard errors are not retried (except
     * when the hard error is for a {@link ContentResolver#SYNC_EXTRAS_UPLOAD} request,
     * in which the request is retryed without the {@link ContentResolver#SYNC_EXTRAS_UPLOAD}
     * extra set). The SyncManager checks the type of error by calling
     * {@link SyncResult#hasHardError()} and  {@link SyncResult#hasSoftError()}. If both are
     * true then the SyncManager treats it as a hard error, not a soft error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.079 -0500", hash_original_method = "74DBC91B11F83F26A5C8672BC9110150", hash_generated_method = "B051DFA8BAF8903AFC907085721076D3")
    
public SyncResult() {
        this(false);
    }

    /**
     * Internal helper for creating a clean SyncResult or one that indicated that
     * a sync is already in progress.
     * @param syncAlreadyInProgress if true then set the {@link #syncAlreadyInProgress} flag
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.083 -0500", hash_original_method = "A4EB0430511E7A235909D5D8195B83C3", hash_generated_method = "62AA43D4C8F4ECD3CE768F32C5D2AB84")
    
private SyncResult(boolean syncAlreadyInProgress) {
        this.syncAlreadyInProgress = syncAlreadyInProgress;
        this.tooManyDeletions = false;
        this.tooManyRetries = false;
        this.fullSyncRequested = false;
        this.partialSyncUnavailable = false;
        this.moreRecordsToGet = false;
        this.delayUntil = 0;
        this.stats = new SyncStats();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.086 -0500", hash_original_method = "B695CA7A40C0F72A389E260A4C1183F2", hash_generated_method = "62EE061EE2DF04FC1CCC5B557E691591")
    
private SyncResult(Parcel parcel) {
        syncAlreadyInProgress = parcel.readInt() != 0;
        tooManyDeletions = parcel.readInt() != 0;
        tooManyRetries = parcel.readInt() != 0;
        databaseError = parcel.readInt() != 0;
        fullSyncRequested = parcel.readInt() != 0;
        partialSyncUnavailable = parcel.readInt() != 0;
        moreRecordsToGet = parcel.readInt() != 0;
        delayUntil = parcel.readLong();
        stats = new SyncStats(parcel);
    }

    /**
     * Convenience method for determining if the SyncResult indicates that a hard error
     * occurred. See {@link #SyncResult()} for an explanation of what the SyncManager does
     * when it sees a hard error.
     * <p>
     * A hard error is indicated when any of the following is true:
     * <ul>
     * <li> {@link SyncStats#numParseExceptions} > 0
     * <li> {@link SyncStats#numConflictDetectedExceptions} > 0
     * <li> {@link SyncStats#numAuthExceptions} > 0
     * <li> {@link #tooManyDeletions}
     * <li> {@link #tooManyRetries}
     * <li> {@link #databaseError}
     * @return true if a hard error is indicated
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.088 -0500", hash_original_method = "BBFDB64A99265F3C16497008E73E4C9A", hash_generated_method = "0C77ED41812194EA44D566C0C6B9017A")
    
public boolean hasHardError() {
        return stats.numParseExceptions > 0
                || stats.numConflictDetectedExceptions > 0
                || stats.numAuthExceptions > 0
                || tooManyDeletions
                || tooManyRetries
                || databaseError;
    }

    /**
     * Convenience method for determining if the SyncResult indicates that a soft error
     * occurred. See {@link #SyncResult()} for an explanation of what the SyncManager does
     * when it sees a soft error.
     * <p>
     * A soft error is indicated when any of the following is true:
     * <ul>
     * <li> {@link SyncStats#numIoExceptions} > 0
     * <li> {@link #syncAlreadyInProgress}
     * </ul>
     * @return true if a hard error is indicated
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.090 -0500", hash_original_method = "E6525D3C6B30E4EB9644C9103954127F", hash_generated_method = "9501DA9F7834C052A289D8FDA5F42DC7")
    
public boolean hasSoftError() {
        return syncAlreadyInProgress || stats.numIoExceptions > 0;
    }

    /**
     * A convenience method for determining of the SyncResult indicates that an error occurred.
     * @return true if either a soft or hard error occurred
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.092 -0500", hash_original_method = "4476315D4E8DB7AB870F2DCC294654C2", hash_generated_method = "51CA7377457AE130DE117AD44ED74083")
    
public boolean hasError() {
        return hasSoftError() || hasHardError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.094 -0500", hash_original_method = "8205DB1BC4B4653595BD73EDC8C83B31", hash_generated_method = "447B617A7E00FF3BECDC34806D63E514")
    
public boolean madeSomeProgress() {
        return ((stats.numDeletes > 0) && !tooManyDeletions)
                || stats.numInserts > 0
                || stats.numUpdates > 0;
    }

    /**
     * Clears the SyncResult to a clean state. Throws an {@link UnsupportedOperationException}
     * if this is called when {@link #syncAlreadyInProgress} is set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.097 -0500", hash_original_method = "2FCB3E59F9154933B8824104898248D1", hash_generated_method = "A7E6DDBC34672E6F1464C7326B920728")
    
public void clear() {
        if (syncAlreadyInProgress) {
            throw new UnsupportedOperationException(
                    "you are not allowed to clear the ALREADY_IN_PROGRESS SyncStats");
        }
        tooManyDeletions = false;
        tooManyRetries = false;
        databaseError = false;
        fullSyncRequested = false;
        partialSyncUnavailable = false;
        moreRecordsToGet = false;
        delayUntil = 0;
        stats.clear();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.107 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.109 -0500", hash_original_method = "EE19136D87E129AE1F87F388C7ADFCD3", hash_generated_method = "A1556F399678DA2B9A16F2DDDA7AB308")
    
public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(syncAlreadyInProgress ? 1 : 0);
        parcel.writeInt(tooManyDeletions ? 1 : 0);
        parcel.writeInt(tooManyRetries ? 1 : 0);
        parcel.writeInt(databaseError ? 1 : 0);
        parcel.writeInt(fullSyncRequested ? 1 : 0);
        parcel.writeInt(partialSyncUnavailable ? 1 : 0);
        parcel.writeInt(moreRecordsToGet ? 1 : 0);
        parcel.writeLong(delayUntil);
        stats.writeToParcel(parcel, flags);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.112 -0500", hash_original_method = "7124545C2E1A8AB9232718D7A155D522", hash_generated_method = "0CD8A5C975C3982BC07C8BFF2F9E8045")
    
@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SyncResult:");
        if (syncAlreadyInProgress) {
            sb.append(" syncAlreadyInProgress: ").append(syncAlreadyInProgress);
        }
        if (tooManyDeletions) sb.append(" tooManyDeletions: ").append(tooManyDeletions);
        if (tooManyRetries) sb.append(" tooManyRetries: ").append(tooManyRetries);
        if (databaseError) sb.append(" databaseError: ").append(databaseError);
        if (fullSyncRequested) sb.append(" fullSyncRequested: ").append(fullSyncRequested);
        if (partialSyncUnavailable) {
            sb.append(" partialSyncUnavailable: ").append(partialSyncUnavailable);
        }
        if (moreRecordsToGet) sb.append(" moreRecordsToGet: ").append(moreRecordsToGet);
        if (delayUntil > 0) sb.append(" delayUntil: ").append(delayUntil);
        sb.append(stats);
        return sb.toString();
    }
    static {
        ALREADY_IN_PROGRESS = new SyncResult(true);
    }

    /**
     * Generates a debugging string indicating the status.
     * The string consist of a sequence of code letter followed by the count.
     * Code letters are f - fullSyncRequested, r - partialSyncUnavailable,
     * X - hardError, e - numParseExceptions, c - numConflictDetectedExceptions,
     * a - numAuthExceptions, D - tooManyDeletions, R - tooManyRetries,
     * b - databaseError, x - softError, l - syncAlreadyInProgress,
     * I - numIoExceptions
     * @return debugging string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.115 -0500", hash_original_method = "4BAB8C537F83CAF09BA4245CA1B5A6A2", hash_generated_method = "4BBA0B61C3FD28B33E6A4CEA5F5778FD")
    
public String toDebugString() {
        StringBuffer sb = new StringBuffer();

        if (fullSyncRequested) {
            sb.append("f1");
        }
        if (partialSyncUnavailable) {
            sb.append("r1");
        }
        if (hasHardError()) {
            sb.append("X1");
        }
        if (stats.numParseExceptions > 0) {
            sb.append("e").append(stats.numParseExceptions);
        }
        if (stats.numConflictDetectedExceptions > 0) {
            sb.append("c").append(stats.numConflictDetectedExceptions);
        }
        if (stats.numAuthExceptions > 0) {
            sb.append("a").append(stats.numAuthExceptions);
        }
        if (tooManyDeletions) {
            sb.append("D1");
        }
        if (tooManyRetries) {
            sb.append("R1");
        }
        if (databaseError) {
            sb.append("b1");
        }
        if (hasSoftError()) {
            sb.append("x1");
        }
        if (syncAlreadyInProgress) {
            sb.append("l1");
        }
        if (stats.numIoExceptions > 0) {
            sb.append("I").append(stats.numIoExceptions);
        }
        return sb.toString();
    }
    // orphaned legacy method
    public SyncResult createFromParcel(Parcel in) {
            return new SyncResult(in);
        }
    
    // orphaned legacy method
    public SyncResult[] newArray(int size) {
            return new SyncResult[size];
        }
    
}

