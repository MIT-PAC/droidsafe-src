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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.617 -0400", hash_original_method = "F940BC288E8C5874A897555B433F598F", hash_generated_method = "F940BC288E8C5874A897555B433F598F")
        public SQLiteDebug ()
    {
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
        @Deprecated public long totalBytes;
        @Deprecated public long referencedBytes;
        @Deprecated public long databaseBytes;
        @Deprecated public int numPagers;
        public int memoryUsed;
        public int pageCacheOverflo;
        public int largestMemAlloc;
        public ArrayList<DbStats> dbStats;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.621 -0400", hash_original_method = "A378B0D3062FC682C07EB244C75FD825", hash_generated_method = "A378B0D3062FC682C07EB244C75FD825")
                public PagerStats ()
        {
        }


    }


    
    public static class DbStats {
        public String dbName;
        public long pageSize;
        public long dbSize;
        public int lookaside;
        public String cache;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.622 -0400", hash_original_method = "25D4B03C8D42132F3189FD0C37F279E2", hash_generated_method = "44596247CCDC21C9F650ECA5E80F6855")
        @DSModeled(DSC.SAFE)
        public DbStats(String dbName, long pageCount, long pageSize, int lookaside,
            int hits, int misses, int cachesize) {
            dsTaint.addTaint(pageCount);
            dsTaint.addTaint(cachesize);
            dsTaint.addTaint(hits);
            dsTaint.addTaint(dbName);
            dsTaint.addTaint(pageSize);
            dsTaint.addTaint(lookaside);
            dsTaint.addTaint(misses);
            this.pageSize = pageSize / 1024;
            dbSize = (pageCount * pageSize) / 1024;
            this.cache = hits + "/" + misses + "/" + cachesize;
            // ---------- Original Method ----------
            //this.dbName = dbName;
            //this.pageSize = pageSize / 1024;
            //dbSize = (pageCount * pageSize) / 1024;
            //this.lookaside = lookaside;
            //this.cache = hits + "/" + misses + "/" + cachesize;
        }

        
    }


    
    public static final boolean DEBUG_SQL_STATEMENTS =
            Log.isLoggable("SQLiteStatements", Log.VERBOSE);
    public static final boolean DEBUG_SQL_TIME =
            Log.isLoggable("SQLiteTime", Log.VERBOSE);
    public static final boolean DEBUG_SQL_CACHE =
            Log.isLoggable("SQLiteCompiledSql", Log.VERBOSE);
    public static final boolean DEBUG_ACTIVE_CURSOR_FINALIZATION =
            Log.isLoggable("SQLiteCursorClosing", Log.VERBOSE);
    public static final boolean DEBUG_LOCK_TIME_TRACKING =
            Log.isLoggable("SQLiteLockTime", Log.VERBOSE);
    public static final boolean DEBUG_LOCK_TIME_TRACKING_STACK_TRACE =
            Log.isLoggable("SQLiteLockStackTrace", Log.VERBOSE);
    public static final boolean DEBUG_LOG_SLOW_QUERIES = Build.IS_DEBUGGABLE;
    private static int sNumActiveCursorsFinalized = 0;
}

