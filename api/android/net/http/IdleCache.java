package android.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import org.apache.http.HttpHost;

import android.os.SystemClock;





class IdleCache {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.138 -0500", hash_original_field = "7B2144BEEC0414B7B620CCBFC36930F5", hash_generated_field = "844D05329852E8C591AB6BCD91CF4039")


    private final static int IDLE_CACHE_MAX = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.138 -0500", hash_original_field = "5D4BE83937850A1A05D60BAFB8354CFD", hash_generated_field = "B31C9FE229293E94ED98B7862DD3C494")

    private final static int EMPTY_CHECK_MAX = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.140 -0500", hash_original_field = "D8E0BD98B94AF1ABD4D40812D3CD4B1C", hash_generated_field = "A07A037A70CF5B89CA1BD6E1B94EB41D")

    private final static int TIMEOUT = 6 * 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.141 -0500", hash_original_field = "787767ACA9553C8145CFC9B805FF35BB", hash_generated_field = "37419313EC4BFBD208F8E416592511E0")

    private final static int CHECK_INTERVAL = 2 * 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.142 -0500", hash_original_field = "0FF216EB85BA78ADDEC3C8A41FEC1EA4", hash_generated_field = "5DA8A4D4C2CDF098EB768C6225089E33")

    private Entry[] mEntries = new Entry[IDLE_CACHE_MAX];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.142 -0500", hash_original_field = "D01C96038701D525501067476D6E20FD", hash_generated_field = "FF64F9A7A53D85DAFE355CC940E3F92D")


    private int mCount = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.143 -0500", hash_original_field = "823D5CC7A6FBE6E7E207151FFC739A3B", hash_generated_field = "E1D81FFF9FA8DBF8F061A478C1B8E12A")


    private IdleReaper mThread = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.144 -0500", hash_original_field = "39077C14E378039D1D2674EB097F2854", hash_generated_field = "5F06A5363A8AD1B70971804573712105")

    private int mCached = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.145 -0500", hash_original_field = "763259DA916FAE756C76543310996E2A", hash_generated_field = "9E8AFFB866082F7AAC658675F2987073")

    private int mReused = 0;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.145 -0500", hash_original_method = "381EAC5E18A2676540DA51802FE9C22A", hash_generated_method = "381EAC5E18A2676540DA51802FE9C22A")
    IdleCache() {
        for (int i = 0; i < IDLE_CACHE_MAX; i++) {
            mEntries[i] = new Entry();
        }
    }

    
    class Entry {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.135 -0500", hash_original_field = "BB62408D38B8CFFE64423F7A37FB51DF", hash_generated_field = "BB62408D38B8CFFE64423F7A37FB51DF")

        HttpHost mHost;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.135 -0500", hash_original_field = "D468AD0EA1184CE89FA8A45254E2CDD6", hash_generated_field = "D468AD0EA1184CE89FA8A45254E2CDD6")

        Connection mConnection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.136 -0500", hash_original_field = "4664F919744F49AEF8673D87A7926AAD", hash_generated_field = "4664F919744F49AEF8673D87A7926AAD")

        long mTimeout;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.273 -0400", hash_original_method = "629F4A8E90A91F8ECA92C26A9EB219B2", hash_generated_method = "629F4A8E90A91F8ECA92C26A9EB219B2")
        public Entry ()
        {
            //Synthesized constructor
        }


    }


    
    private class IdleReaper extends Thread {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.273 -0400", hash_original_method = "C9AFDFC698BD8B70E3BC662C5244B0E4", hash_generated_method = "C9AFDFC698BD8B70E3BC662C5244B0E4")
        public IdleReaper ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.150 -0500", hash_original_method = "251C8B975B1D281BC736CAA8083B5C8E", hash_generated_method = "BB0F0F94ADAC2E85899BAFAA68AB3C32")
        public void run() {
            int check = 0;

            setName("IdleReaper");
            android.os.Process.setThreadPriority(
                    android.os.Process.THREAD_PRIORITY_BACKGROUND);
            synchronized (IdleCache.this) {
                while (check < EMPTY_CHECK_MAX) {
                    try {
                        IdleCache.this.wait(CHECK_INTERVAL);
                    } catch (InterruptedException ex) {
                    }
                    if (mCount == 0) {
                        check++;
                    } else {
                        check = 0;
                        clearIdle();
                    }
                }
                mThread = null;
            }
            if (HttpLog.LOGV) {
                HttpLog.v("IdleCache IdleReaper shutdown: cached " + mCached +
                          " reused " + mReused);
                mCached = 0;
                mReused = 0;
            }
        }

        
    }

    /**
     * Caches connection, if there is room.
     * @return true if connection cached
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.146 -0500", hash_original_method = "15C17CA69A0E3C6519F160E1B18C9284", hash_generated_method = "DDB193F4AB03DBF42B77F2F79AFB5FBA")
    synchronized boolean cacheConnection(
            HttpHost host, Connection connection) {

        boolean ret = false;

        if (HttpLog.LOGV) {
            HttpLog.v("IdleCache size " + mCount + " host "  + host);
        }

        if (mCount < IDLE_CACHE_MAX) {
            long time = SystemClock.uptimeMillis();
            for (int i = 0; i < IDLE_CACHE_MAX; i++) {
                Entry entry = mEntries[i];
                if (entry.mHost == null) {
                    entry.mHost = host;
                    entry.mConnection = connection;
                    entry.mTimeout = time + TIMEOUT;
                    mCount++;
                    if (HttpLog.LOGV) mCached++;
                    ret = true;
                    if (mThread == null) {
                        mThread = new IdleReaper();
                        mThread.start();
                    }
                    break;
                }
            }
        }
        return ret;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.147 -0500", hash_original_method = "84A867D5F5B3563DFEB3ADE540AAE988", hash_generated_method = "8D515E030AE7DD404198E0F4C7514E84")
    synchronized Connection getConnection(HttpHost host) {
        Connection ret = null;

        if (mCount > 0) {
            for (int i = 0; i < IDLE_CACHE_MAX; i++) {
                Entry entry = mEntries[i];
                HttpHost eHost = entry.mHost;
                if (eHost != null && eHost.equals(host)) {
                    ret = entry.mConnection;
                    entry.mHost = null;
                    entry.mConnection = null;
                    mCount--;
                    if (HttpLog.LOGV) mReused++;
                    break;
                }
            }
        }
        return ret;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.148 -0500", hash_original_method = "3CB6FBE953A3200168C4C82134203CFB", hash_generated_method = "B8167B7BD46151462D923C6809F040AC")
    synchronized void clear() {
        for (int i = 0; mCount > 0 && i < IDLE_CACHE_MAX; i++) {
            Entry entry = mEntries[i];
            if (entry.mHost != null) {
                entry.mHost = null;
                entry.mConnection.closeConnection();
                entry.mConnection = null;
                mCount--;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.149 -0500", hash_original_method = "D819290B68B2E791C413DF56F024C65B", hash_generated_method = "2737D354493D3C4E4BD3DE8A1BFACE75")
    private synchronized void clearIdle() {
        if (mCount > 0) {
            long time = SystemClock.uptimeMillis();
            for (int i = 0; i < IDLE_CACHE_MAX; i++) {
                Entry entry = mEntries[i];
                if (entry.mHost != null && time > entry.mTimeout) {
                    entry.mHost = null;
                    entry.mConnection.closeConnection();
                    entry.mConnection = null;
                    mCount--;
                }
            }
        }
    }
}

