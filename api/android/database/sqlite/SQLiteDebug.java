package android.database.sqlite;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;

import android.os.Build;
import android.os.SystemProperties;
import android.util.Log;




import droidsafe.helpers.DSUtils;

public final class SQLiteDebug {

    /**
     * Determines whether a query should be logged.
     *
     * Reads the "db.log.slow_query_threshold" system property, which can be changed
     * by the user at any time.  If the value is zero, then all queries will
     * be considered slow.  If the value does not exist, then no queries will
     * be considered slow.
     *
     * This value can be changed dynamically while the system is running.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.810 -0500", hash_original_method = "83B613D0065469E827ECA0D8C3DB3A45", hash_generated_method = "64828BC89FB466CB73C861F58DB54904")
    public static final boolean shouldLogSlowQuery(long elapsedTimeMillis) {
        int slowQueryMillis = SystemProperties.getInt("db.log.slow_query_threshold", -1);
        return slowQueryMillis >= 0 && elapsedTimeMillis > slowQueryMillis;
    }

    /**
     * return all pager and database stats for the current process.
     * @return {@link PagerStats}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.824 -0500", hash_original_method = "8951B139D654ADCB97191CBCD8A2648C", hash_generated_method = "6C45876E71144F311C1A012577F445A1")
    public static PagerStats getDatabaseInfo() {
        PagerStats stats = new PagerStats();
        getPagerStats(stats);
        stats.dbStats = SQLiteDatabase.getDbStats();
        return stats;
    }

    
    @DSModeled(DSC.SAFE)
    public static void getPagerStats(PagerStats stats) {
    }

    
    @DSModeled(DSC.SAFE)
    public static long getHeapSize() {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSModeled(DSC.SAFE)
    public static long getHeapAllocatedSize() {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSModeled(DSC.SAFE)
    public static long getHeapFreeSize() {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSModeled(DSC.SAFE)
    public static void getHeapDirtyPages(int[] pages) {
    }

    /**
     * Returns the number of active cursors that have been finalized. This depends on the GC having
     * run but is still useful for tests.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.833 -0500", hash_original_method = "00208FE8D5D51F500C244A3EA93E0E34", hash_generated_method = "71FB7AB63BDEFAC4C033357F08001BBF")
    public static int getNumActiveCursorsFinalized() {
        return sNumActiveCursorsFinalized;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.834 -0500", hash_original_method = "C4B2F04DB714E228A5907EB20DE16B65", hash_generated_method = "589534524DF61D665FCF724F205A9025")
    static synchronized void notifyActiveCursorFinalized() {
        sNumActiveCursorsFinalized++;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.803 -0500", hash_original_field = "9452F0C93BB32A6907C53EB035E5D486", hash_generated_field = "2FC95BE9271BDB3B4F8E432CB492C4EE")

    public static final boolean DEBUG_SQL_STATEMENTS =
            Log.isLoggable("SQLiteStatements", Log.VERBOSE);

    
    public static class PagerStats {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.811 -0500", hash_original_field = "46BB95F5F874577C616EA9532A3E50A6", hash_generated_field = "D031842CEE05E89DE639101A3C8A3F02")

        @Deprecated
        public long totalBytes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.812 -0500", hash_original_field = "22163642773C44A8450422997043CDA6", hash_generated_field = "7BBFC5861C15C680578377197F068F74")

        @Deprecated
        public long referencedBytes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.813 -0500", hash_original_field = "F25E94752CD40447C63E7211D7B11112", hash_generated_field = "F1BC06931B9D7107A9F5F2D73FA78BF6")

        @Deprecated
        public long databaseBytes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.813 -0500", hash_original_field = "EF3AECCF2AC7F33E4C3736BF2DE63752", hash_generated_field = "85D757B755767B5AF1AE1CFEBCAD1D9E")

        @Deprecated
        public int numPagers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.814 -0500", hash_original_field = "1C5367CF9DA900ADCE2BD624CD4B1F21", hash_generated_field = "DE0E00BC422334B42AA7EF91AAC9A0FF")

        public int memoryUsed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.815 -0500", hash_original_field = "5E406612A9F36D562113281EBBFA5655", hash_generated_field = "D28AA2452CF1AA26E90EEC74339794F7")

        public int pageCacheOverflo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.816 -0500", hash_original_field = "C6C8DD215B50D18EEF922408CDADD3B2", hash_generated_field = "2C9126B94C1F6FA077A1D93367A1BBCE")

        public int largestMemAlloc;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.817 -0500", hash_original_field = "D58CA053948F2C9157CEAA4C1039EEF9", hash_generated_field = "1F63E2345B81BB66941DB033DF970795")

        public ArrayList<DbStats> dbStats;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.724 -0400", hash_original_method = "8C8E95FFCB1088531CECBA4CD1169D76", hash_generated_method = "8C8E95FFCB1088531CECBA4CD1169D76")
        public PagerStats ()
        {
            //Synthesized constructor
        }


    }


    
    public static class DbStats {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.818 -0500", hash_original_field = "5BD3C7DBADB99AC4730A24E25D779347", hash_generated_field = "8C827F3F2368083D7F50B00240006370")

        public String dbName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.819 -0500", hash_original_field = "7AEE04CB04D7BB43D137188327011899", hash_generated_field = "4E2DCA0B5B9D1506E2B9DD574B0B48D9")

        public long pageSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.820 -0500", hash_original_field = "61ABCB8150A8838946E90D75EDC31070", hash_generated_field = "378B20660B340CFE98A75889CB1FD200")

        public long dbSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.821 -0500", hash_original_field = "7366F2B95CEC1D3CE1D3B21B10C271D1", hash_generated_field = "2A61C27A06F6C26068BDF51FBC7913C9")

        public int lookaside;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.821 -0500", hash_original_field = "CA415120793D1E03483C70CE881D1BA0", hash_generated_field = "97FB095B43F87A1209F791E3E2375559")

        public String cache;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.822 -0500", hash_original_method = "25D4B03C8D42132F3189FD0C37F279E2", hash_generated_method = "5DA18EC812D3C65184FF81F318E99C62")
        public DbStats(String dbName, long pageCount, long pageSize, int lookaside,
            int hits, int misses, int cachesize) {
            this.dbName = dbName;
            this.pageSize = pageSize / 1024;
            dbSize = (pageCount * pageSize) / 1024;
            this.lookaside = lookaside;
            this.cache = hits + "/" + misses + "/" + cachesize;
        }

        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.804 -0500", hash_original_field = "96B2A77B19C76228FEAC38F7C37A402D", hash_generated_field = "E4A8B30EADB861CBC923AA2E89967AE8")

    public static final boolean DEBUG_SQL_TIME =
            Log.isLoggable("SQLiteTime", Log.VERBOSE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.805 -0500", hash_original_field = "7747F1462D9F825BB536348718D04540", hash_generated_field = "891F04ADD0F1E4356B569170DDC136D5")

    public static final boolean DEBUG_SQL_CACHE =
            Log.isLoggable("SQLiteCompiledSql", Log.VERBOSE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.806 -0500", hash_original_field = "35875E78EA3AED6506EF4619D96FAC53", hash_generated_field = "6FF919663B9D3BC18FDB7244CE9511D7")

    public static final boolean DEBUG_ACTIVE_CURSOR_FINALIZATION =
            Log.isLoggable("SQLiteCursorClosing", Log.VERBOSE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.807 -0500", hash_original_field = "6425058ABBE7588AE78A80D34E551462", hash_generated_field = "89FAA4A7D4A67F765FA3C70E336262DD")

    public static final boolean DEBUG_LOCK_TIME_TRACKING =
            Log.isLoggable("SQLiteLockTime", Log.VERBOSE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.807 -0500", hash_original_field = "431332A06B4930CB8A42D196B44EEF9D", hash_generated_field = "4C53BF47CE123600D2CDE4F7CE0EB0C7")

    public static final boolean DEBUG_LOCK_TIME_TRACKING_STACK_TRACE =
            Log.isLoggable("SQLiteLockStackTrace", Log.VERBOSE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.809 -0500", hash_original_field = "C715A8A25ABE2CD4A6618FAB41364898", hash_generated_field = "6A086B2B268FC4E58C707C6479D11AD3")

    public static final boolean DEBUG_LOG_SLOW_QUERIES = Build.IS_DEBUGGABLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.832 -0500", hash_original_field = "CE7F1BB356927AAB40AC80E99E15F5AC", hash_generated_field = "9B3AC867859C3F2C7A80205759E2C585")


    private static int sNumActiveCursorsFinalized = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.719 -0400", hash_original_method = "E568765EE49290FB5EEF63EB9FC3FADB", hash_generated_method = "E568765EE49290FB5EEF63EB9FC3FADB")
    public SQLiteDebug ()
    {
        //Synthesized constructor
    }
}

