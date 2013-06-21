package android.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.HttpHost;
import android.os.SystemClock;

class IdleCache {
    private Entry[] mEntries = new Entry[IDLE_CACHE_MAX];
    private int mCount = 0;
    private IdleReaper mThread = null;
    private int mCached = 0;
    private int mReused = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.891 -0400", hash_original_method = "381EAC5E18A2676540DA51802FE9C22A", hash_generated_method = "DBECC726A74B01192825BA264BEABDB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     IdleCache() {
        {
            int i;
            i = 0;
            {
                mEntries[i] = new Entry();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (int i = 0; i < IDLE_CACHE_MAX; i++) {
            //mEntries[i] = new Entry();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.892 -0400", hash_original_method = "15C17CA69A0E3C6519F160E1B18C9284", hash_generated_method = "07FFDDD586AA711FCE54EAE5F0D23B14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized boolean cacheConnection(
            HttpHost host, Connection connection) {
        dsTaint.addTaint(connection.dsTaint);
        dsTaint.addTaint(host.dsTaint);
        boolean ret;
        ret = false;
        {
            HttpLog.v("IdleCache size " + mCount + " host "  + host);
        } //End block
        {
            long time;
            time = SystemClock.uptimeMillis();
            {
                int i;
                i = 0;
                {
                    Entry entry;
                    entry = mEntries[i];
                    {
                        entry.mHost = host;
                        entry.mConnection = connection;
                        entry.mTimeout = time + TIMEOUT;
                        ret = true;
                        {
                            mThread = new IdleReaper();
                            mThread.start();
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.892 -0400", hash_original_method = "84A867D5F5B3563DFEB3ADE540AAE988", hash_generated_method = "B6A5E97D35149BDB667B6B8AE924254F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized Connection getConnection(HttpHost host) {
        dsTaint.addTaint(host.dsTaint);
        Connection ret;
        ret = null;
        {
            {
                int i;
                i = 0;
                {
                    Entry entry;
                    entry = mEntries[i];
                    HttpHost eHost;
                    eHost = entry.mHost;
                    {
                        boolean varAED9549D6459777C64E1C7E151A999BD_1872452145 = (eHost != null && eHost.equals(host));
                        {
                            ret = entry.mConnection;
                            entry.mHost = null;
                            entry.mConnection = null;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (Connection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Connection ret = null;
        //if (mCount > 0) {
            //for (int i = 0; i < IDLE_CACHE_MAX; i++) {
                //Entry entry = mEntries[i];
                //HttpHost eHost = entry.mHost;
                //if (eHost != null && eHost.equals(host)) {
                    //ret = entry.mConnection;
                    //entry.mHost = null;
                    //entry.mConnection = null;
                    //mCount--;
                    //if (HttpLog.LOGV) mReused++;
                    //break;
                //}
            //}
        //}
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.893 -0400", hash_original_method = "3CB6FBE953A3200168C4C82134203CFB", hash_generated_method = "E0F74B8F9CF50683C06F8CF869C93DC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void clear() {
        {
            int i;
            i = 0;
            {
                Entry entry;
                entry = mEntries[i];
                {
                    entry.mHost = null;
                    entry.mConnection.closeConnection();
                    entry.mConnection = null;
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (int i = 0; mCount > 0 && i < IDLE_CACHE_MAX; i++) {
            //Entry entry = mEntries[i];
            //if (entry.mHost != null) {
                //entry.mHost = null;
                //entry.mConnection.closeConnection();
                //entry.mConnection = null;
                //mCount--;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.893 -0400", hash_original_method = "D819290B68B2E791C413DF56F024C65B", hash_generated_method = "A9B56A42B266CF89CC9CD3295AAD9B4B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void clearIdle() {
        {
            long time;
            time = SystemClock.uptimeMillis();
            {
                int i;
                i = 0;
                {
                    Entry entry;
                    entry = mEntries[i];
                    {
                        entry.mHost = null;
                        entry.mConnection.closeConnection();
                        entry.mConnection = null;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (mCount > 0) {
            //long time = SystemClock.uptimeMillis();
            //for (int i = 0; i < IDLE_CACHE_MAX; i++) {
                //Entry entry = mEntries[i];
                //if (entry.mHost != null && time > entry.mTimeout) {
                    //entry.mHost = null;
                    //entry.mConnection.closeConnection();
                    //entry.mConnection = null;
                    //mCount--;
                //}
            //}
        //}
    }

    
    class Entry {
        HttpHost mHost;
        Connection mConnection;
        long mTimeout;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.893 -0400", hash_original_method = "353831000CECA5D9D5B60D3D4A47F9C3", hash_generated_method = "353831000CECA5D9D5B60D3D4A47F9C3")
                public Entry ()
        {
        }


    }


    
    private class IdleReaper extends Thread {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.893 -0400", hash_original_method = "5A85154523C9FD8277590A959F40657B", hash_generated_method = "5A85154523C9FD8277590A959F40657B")
                public IdleReaper ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.894 -0400", hash_original_method = "251C8B975B1D281BC736CAA8083B5C8E", hash_generated_method = "909CF68A2ADA26BAB05A726708D9936A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            int check;
            check = 0;
            setName("IdleReaper");
            android.os.Process.setThreadPriority(
                    android.os.Process.THREAD_PRIORITY_BACKGROUND);
            {
                Object varE94B22B047AD5AC83E36E5F483BEB0F2_2013946619 = (IdleCache.this);
                {
                    {
                        try 
                        {
                            IdleCache.this.wait(CHECK_INTERVAL);
                        } //End block
                        catch (InterruptedException ex)
                        { }
                        {
                            check = 0;
                            clearIdle();
                        } //End block
                    } //End block
                    mThread = null;
                } //End block
            } //End collapsed parenthetic
            {
                HttpLog.v("IdleCache IdleReaper shutdown: cached " + mCached +
                          " reused " + mReused);
                mCached = 0;
                mReused = 0;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private final static int IDLE_CACHE_MAX = 8;
    private final static int EMPTY_CHECK_MAX = 5;
    private final static int TIMEOUT = 6 * 1000;
    private final static int CHECK_INTERVAL = 2 * 1000;
}

