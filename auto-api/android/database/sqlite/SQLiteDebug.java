package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import android.os.Build;
import android.os.SystemProperties;
import android.util.Log;

public final class SQLiteDebug {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.606 -0400", hash_original_method = "E568765EE49290FB5EEF63EB9FC3FADB", hash_generated_method = "E568765EE49290FB5EEF63EB9FC3FADB")
    public SQLiteDebug ()
    {
        //Synthesized constructor
    }


        public static final boolean shouldLogSlowQuery(long elapsedTimeMillis) {
        int slowQueryMillis = SystemProperties.getInt("db.log.slow_query_threshold", -1);
        return slowQueryMillis >= 0 && elapsedTimeMillis > slowQueryMillis;
    }

    
        public static PagerStats getDatabaseInfo() {
        PagerStats stats = new PagerStats();
        getPagerStats(stats);
        stats.dbStats = SQLiteDatabase.getDbStats();
        return stats;
    }

    
        public static void getPagerStats(PagerStats stats) {
    }

    
        public static long getHeapSize() {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long getHeapAllocatedSize() {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long getHeapFreeSize() {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static void getHeapDirtyPages(int[] pages) {
    }

    
        public static int getNumActiveCursorsFinalized() {
        return sNumActiveCursorsFinalized;
    }

    
        static synchronized void notifyActiveCursorFinalized() {
        sNumActiveCursorsFinalized++;
    }

    
    public static class PagerStats {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.649 -0400", hash_original_field = "A9E6DAE7D3BBAAD5132BB58948800A6B", hash_generated_field = "D031842CEE05E89DE639101A3C8A3F02")

        @Deprecated public long totalBytes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.650 -0400", hash_original_field = "0F850831EA9DA9FD8595B5002BC38DCC", hash_generated_field = "7BBFC5861C15C680578377197F068F74")

        @Deprecated public long referencedBytes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.650 -0400", hash_original_field = "15077AAB17ED47A453D7894BBD2F11CC", hash_generated_field = "F1BC06931B9D7107A9F5F2D73FA78BF6")

        @Deprecated public long databaseBytes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.650 -0400", hash_original_field = "4E6A4F0E8F426B82AA1E2FFA7E0DD2B3", hash_generated_field = "85D757B755767B5AF1AE1CFEBCAD1D9E")

        @Deprecated public int numPagers;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.650 -0400", hash_original_field = "A92B3598BF8E02BB125E3A439F81B40D", hash_generated_field = "DE0E00BC422334B42AA7EF91AAC9A0FF")

        public int memoryUsed;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.650 -0400", hash_original_field = "6DF2821604572CE47F588787FDC611A4", hash_generated_field = "D28AA2452CF1AA26E90EEC74339794F7")

        public int pageCacheOverflo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.650 -0400", hash_original_field = "5AC58ED02DAB887620BD7A6EFCC050BA", hash_generated_field = "2C9126B94C1F6FA077A1D93367A1BBCE")

        public int largestMemAlloc;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.650 -0400", hash_original_field = "7CC7B0A8F0833561E3C1EBB5428367F2", hash_generated_field = "1F63E2345B81BB66941DB033DF970795")

        public ArrayList<DbStats> dbStats;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.650 -0400", hash_original_method = "8C8E95FFCB1088531CECBA4CD1169D76", hash_generated_method = "8C8E95FFCB1088531CECBA4CD1169D76")
        public PagerStats ()
        {
            //Synthesized constructor
        }


    }


    
    public static class DbStats {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.660 -0400", hash_original_field = "E44CD6DD02C2EDF46DDD6CCEB4CBCD2E", hash_generated_field = "8C827F3F2368083D7F50B00240006370")

        public String dbName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.660 -0400", hash_original_field = "45DF2C05040EF7BFE7235E1B67CB8F12", hash_generated_field = "4E2DCA0B5B9D1506E2B9DD574B0B48D9")

        public long pageSize;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.661 -0400", hash_original_field = "00028776344C2A74532B887E8318146F", hash_generated_field = "378B20660B340CFE98A75889CB1FD200")

        public long dbSize;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.661 -0400", hash_original_field = "734C8836532256ED7F917AD7E542F291", hash_generated_field = "2A61C27A06F6C26068BDF51FBC7913C9")

        public int lookaside;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.661 -0400", hash_original_field = "0FEA6A13C52B4D4725368F24B045CA84", hash_generated_field = "97FB095B43F87A1209F791E3E2375559")

        public String cache;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.687 -0400", hash_original_method = "25D4B03C8D42132F3189FD0C37F279E2", hash_generated_method = "E543A68E2B8BAB41A9EFBC14410135C7")
        public  DbStats(String dbName, long pageCount, long pageSize, int lookaside,
            int hits, int misses, int cachesize) {
            this.dbName = dbName;
            this.pageSize = pageSize / 1024;
            dbSize = (pageCount * pageSize) / 1024;
            this.lookaside = lookaside;
            this.cache = hits + "/" + misses + "/" + cachesize;
            // ---------- Original Method ----------
            //this.dbName = dbName;
            //this.pageSize = pageSize / 1024;
            //dbSize = (pageCount * pageSize) / 1024;
            //this.lookaside = lookaside;
            //this.cache = hits + "/" + misses + "/" + cachesize;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.692 -0400", hash_original_field = "A38590EA71493D949AD4B9D2FAADA868", hash_generated_field = "2FC95BE9271BDB3B4F8E432CB492C4EE")

    public static final boolean DEBUG_SQL_STATEMENTS =
            Log.isLoggable("SQLiteStatements", Log.VERBOSE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.692 -0400", hash_original_field = "3A28441CC571EC38625C812E3D6478AF", hash_generated_field = "E4A8B30EADB861CBC923AA2E89967AE8")

    public static final boolean DEBUG_SQL_TIME =
            Log.isLoggable("SQLiteTime", Log.VERBOSE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.692 -0400", hash_original_field = "7E6F0E4DD9D7BD340B4A7F480C44E9D3", hash_generated_field = "891F04ADD0F1E4356B569170DDC136D5")

    public static final boolean DEBUG_SQL_CACHE =
            Log.isLoggable("SQLiteCompiledSql", Log.VERBOSE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.692 -0400", hash_original_field = "F81E4F81A227523858603838AF2F12AF", hash_generated_field = "6FF919663B9D3BC18FDB7244CE9511D7")

    public static final boolean DEBUG_ACTIVE_CURSOR_FINALIZATION =
            Log.isLoggable("SQLiteCursorClosing", Log.VERBOSE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.692 -0400", hash_original_field = "37AE52BBF85EAEA3A5C065DE0AF47B48", hash_generated_field = "89FAA4A7D4A67F765FA3C70E336262DD")

    public static final boolean DEBUG_LOCK_TIME_TRACKING =
            Log.isLoggable("SQLiteLockTime", Log.VERBOSE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.692 -0400", hash_original_field = "6B655B6AC2C485E33BC215B4F9AA52E1", hash_generated_field = "4C53BF47CE123600D2CDE4F7CE0EB0C7")

    public static final boolean DEBUG_LOCK_TIME_TRACKING_STACK_TRACE =
            Log.isLoggable("SQLiteLockStackTrace", Log.VERBOSE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.692 -0400", hash_original_field = "978FCDCD365665AC714019003C39DA1F", hash_generated_field = "6A086B2B268FC4E58C707C6479D11AD3")

    public static final boolean DEBUG_LOG_SLOW_QUERIES = Build.IS_DEBUGGABLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.692 -0400", hash_original_field = "7E819EEA52C6BE1457C6A46272F45792", hash_generated_field = "9B3AC867859C3F2C7A80205759E2C585")

    private static int sNumActiveCursorsFinalized = 0;
}

