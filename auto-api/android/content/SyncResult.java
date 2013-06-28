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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.297 -0400", hash_original_field = "2F2EFE3175254AA8769886FBB83265D2", hash_generated_field = "BFD8A20F4C8DD7D4765EBA24654CDDFF")

    public boolean syncAlreadyInProgress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.297 -0400", hash_original_field = "3171EF0F7797317DF358FDA93E4CFAD3", hash_generated_field = "CF979CB696F4952381CD588FAF28D8C8")

    public boolean tooManyDeletions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.297 -0400", hash_original_field = "6AC8D01A0D843D1EF20D6C6A8BBF16BE", hash_generated_field = "9E1F14B63E64AB3B8FE86B9ECF85BDF8")

    public boolean tooManyRetries;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.297 -0400", hash_original_field = "B3E788D045B0C02113CA7BB9EBE60A7E", hash_generated_field = "2AD2DD4B2337D671F2E174B85A6496D1")

    public boolean databaseError;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.297 -0400", hash_original_field = "FF49CCF250C7250C8ACCB36A94EC155F", hash_generated_field = "436339CBC4C22C7F23F88B3E5A99EA3D")

    public boolean fullSyncRequested;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.297 -0400", hash_original_field = "13BAC3659683FB6DE6C8C097F491F7A2", hash_generated_field = "84E1F34EBFFCDB4B1646B7A9635BC1B6")

    public boolean partialSyncUnavailable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.297 -0400", hash_original_field = "9BE9F4BFA4ADA6C36CA6ADB0A72BA2C3", hash_generated_field = "00EE69B9457A1BE039F1B1AA3795A676")

    public boolean moreRecordsToGet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.298 -0400", hash_original_field = "77D196B208370F23D20E064B8B1B5DA0", hash_generated_field = "34D6FB90E0771C5EFE225745790D4357")

    public long delayUntil;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.298 -0400", hash_original_field = "446501053769C06C565094B26D26E8EF", hash_generated_field = "2DA27E0BB7E62E76DC01A86038B45A30")

    public SyncStats stats;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.298 -0400", hash_original_method = "74DBC91B11F83F26A5C8672BC9110150", hash_generated_method = "696D826DA747067EB7D4C0224C4748CF")
    public  SyncResult() {
        this(false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.298 -0400", hash_original_method = "A4EB0430511E7A235909D5D8195B83C3", hash_generated_method = "91BECAE191A031A094F0515DFDD12796")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.299 -0400", hash_original_method = "B695CA7A40C0F72A389E260A4C1183F2", hash_generated_method = "79661FDB89DDD261A68FCB658DDD1AB8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.300 -0400", hash_original_method = "BBFDB64A99265F3C16497008E73E4C9A", hash_generated_method = "E2E78C4900BDDB0AD9D9868D561635CF")
    public boolean hasHardError() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_280139990 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_280139990;
        // ---------- Original Method ----------
        //return stats.numParseExceptions > 0
                //|| stats.numConflictDetectedExceptions > 0
                //|| stats.numAuthExceptions > 0
                //|| tooManyDeletions
                //|| tooManyRetries
                //|| databaseError;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.301 -0400", hash_original_method = "E6525D3C6B30E4EB9644C9103954127F", hash_generated_method = "3105F572E3B2399B6C6A15C9A9CAA736")
    public boolean hasSoftError() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1628564786 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1628564786;
        // ---------- Original Method ----------
        //return syncAlreadyInProgress || stats.numIoExceptions > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.302 -0400", hash_original_method = "4476315D4E8DB7AB870F2DCC294654C2", hash_generated_method = "AF3248AE475A8D95610E5E995CB2617E")
    public boolean hasError() {
        boolean varF5ECE22A2EC0AA13658513FEEF2C337F_913041849 = (hasSoftError() || hasHardError());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1232861253 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1232861253;
        // ---------- Original Method ----------
        //return hasSoftError() || hasHardError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.303 -0400", hash_original_method = "8205DB1BC4B4653595BD73EDC8C83B31", hash_generated_method = "D59F3A82D7D896517A74B708D873CC5A")
    public boolean madeSomeProgress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1100167191 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1100167191;
        // ---------- Original Method ----------
        //return ((stats.numDeletes > 0) && !tooManyDeletions)
                //|| stats.numInserts > 0
                //|| stats.numUpdates > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.304 -0400", hash_original_method = "2FCB3E59F9154933B8824104898248D1", hash_generated_method = "B15481B6AE55774897A58BCDD638EDC6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.305 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "85235340F67F811D22A87989780AFBF1")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1318702163 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1318702163;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.306 -0400", hash_original_method = "EE19136D87E129AE1F87F388C7ADFCD3", hash_generated_method = "7ACB1EE1F2BA20E19A4B0B9DEC60A8A3")
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
        addTaint(parcel.getTaint());
        addTaint(flags);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.307 -0400", hash_original_method = "7124545C2E1A8AB9232718D7A155D522", hash_generated_method = "6959C86F1BD6CE73AFCED98B05DAF0AB")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2104598377 = null; //Variable for return #1
        StringBuilder sb = new StringBuilder();
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
        varB4EAC82CA7396A68D541C85D26508E83_2104598377 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_2104598377.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2104598377;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.310 -0400", hash_original_method = "4BAB8C537F83CAF09BA4245CA1B5A6A2", hash_generated_method = "355E3C1EDE47A620E7F2025EDC173544")
    public String toDebugString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1360627890 = null; //Variable for return #1
        StringBuffer sb = new StringBuffer();
        {
            sb.append("f1");
        } //End block
        {
            sb.append("r1");
        } //End block
        {
            boolean var2CE0AA7E0D34CB9BB18B774C69DE79B7_1221505512 = (hasHardError());
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
            boolean var2CF9F1F03CE1917A3682EE34C3D2F638_320165321 = (hasSoftError());
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
        varB4EAC82CA7396A68D541C85D26508E83_1360627890 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1360627890.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1360627890;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.310 -0400", hash_original_field = "6D5119A348BD0CC32773C034FE96684C", hash_generated_field = "7027FBC7AA2E8EFBEEF08475D7C0847B")

    public static final SyncResult ALREADY_IN_PROGRESS;
    static {
        ALREADY_IN_PROGRESS = new SyncResult(true);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.310 -0400", hash_original_field = "78B42CBC7BB00AEC88D972EE0CA8E716", hash_generated_field = "0BFBE4FA78FD3B51E53BE26F718EB099")

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

