package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.ArrayList;
import android.os.Build;
import android.os.SystemProperties;
import android.util.Log;

public final class SQLiteDebug {
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.815 -0400", hash_original_method = "83B613D0065469E827ECA0D8C3DB3A45", hash_generated_method = "64828BC89FB466CB73C861F58DB54904")
    public static final boolean shouldLogSlowQuery(long elapsedTimeMillis) {
        int slowQueryMillis = SystemProperties.getInt("db.log.slow_query_threshold", -1);
        return slowQueryMillis >= 0 && elapsedTimeMillis > slowQueryMillis;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.816 -0400", hash_original_method = "8951B139D654ADCB97191CBCD8A2648C", hash_generated_method = "6C45876E71144F311C1A012577F445A1")
    public static PagerStats getDatabaseInfo() {
        PagerStats stats = new PagerStats();
        getPagerStats(stats);
        stats.dbStats = SQLiteDatabase.getDbStats();
        return stats;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.816 -0400", hash_original_method = "C200FA1C335A6B915ECDB07487204354", hash_generated_method = "6DF3B1C145E39009B69FC91E2043465C")
    public static void getPagerStats(PagerStats stats) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.816 -0400", hash_original_method = "FB497DF0BE4C68FEE0641ECD169B11A5", hash_generated_method = "A7B236C54144E38BAE5F1CD85536AF26")
    public static long getHeapSize() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.816 -0400", hash_original_method = "A808C61059552F1A0FD5F32B2427E14D", hash_generated_method = "BC8C84A56ACE91401105E55BA591E59A")
    public static long getHeapAllocatedSize() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.816 -0400", hash_original_method = "07BF86B4C6B2B39C7021B5D42FA96017", hash_generated_method = "1BDE9FAA17A3712413B61E299D10FD88")
    public static long getHeapFreeSize() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.816 -0400", hash_original_method = "CDD34301EDD58BA01C0EEBBF57B35387", hash_generated_method = "02DCD82E0271DED912B0BD3637AD5E3F")
    public static void getHeapDirtyPages(int[] pages) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.816 -0400", hash_original_method = "00208FE8D5D51F500C244A3EA93E0E34", hash_generated_method = "71FB7AB63BDEFAC4C033357F08001BBF")
    public static int getNumActiveCursorsFinalized() {
        return sNumActiveCursorsFinalized;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.817 -0400", hash_original_method = "C4B2F04DB714E228A5907EB20DE16B65", hash_generated_method = "589534524DF61D665FCF724F205A9025")
    static synchronized void notifyActiveCursorFinalized() {
        sNumActiveCursorsFinalized++;
    }

    
    public static class PagerStats {
        @Deprecated
        public long totalBytes;
        @Deprecated
        public long referencedBytes;
        @Deprecated
        public long databaseBytes;
        @Deprecated
        public int numPagers;
        public int memoryUsed;
        public int pageCacheOverflo;
        public int largestMemAlloc;
        public ArrayList<DbStats> dbStats;
        
    }


    
    public static class DbStats {
        public String dbName;
        public long pageSize;
        public long dbSize;
        public int lookaside;
        public String cache;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.817 -0400", hash_original_method = "25D4B03C8D42132F3189FD0C37F279E2", hash_generated_method = "21E7E6E8F11F840B2DEDD472CBCC0BA0")
        @DSModeled(DSC.SAFE)
        public DbStats(String dbName, long pageCount, long pageSize, int lookaside,
            int hits, int misses, int cachesize) {
            dsTaint.addTaint(pageCount);
            dsTaint.addTaint(hits);
            dsTaint.addTaint(cachesize);
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


    
}


