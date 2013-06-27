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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.115 -0400", hash_original_field = "379C729523CD5967E1C64411ED82B1A2", hash_generated_field = "5DA8A4D4C2CDF098EB768C6225089E33")

    private Entry[] mEntries = new Entry[IDLE_CACHE_MAX];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.115 -0400", hash_original_field = "DFBC16768366A2556A52E5DCDCD8E737", hash_generated_field = "FF64F9A7A53D85DAFE355CC940E3F92D")

    private int mCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.115 -0400", hash_original_field = "4637F257714ED0010AAAD4B2D42CA0B5", hash_generated_field = "E1D81FFF9FA8DBF8F061A478C1B8E12A")

    private IdleReaper mThread = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.115 -0400", hash_original_field = "38257BA3A260211EFCDC2FFD340429F5", hash_generated_field = "5F06A5363A8AD1B70971804573712105")

    private int mCached = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.115 -0400", hash_original_field = "91F643CB351DFCE613F512FC46A2B2E7", hash_generated_field = "9E8AFFB866082F7AAC658675F2987073")

    private int mReused = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.116 -0400", hash_original_method = "381EAC5E18A2676540DA51802FE9C22A", hash_generated_method = "DBECC726A74B01192825BA264BEABDB5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.145 -0400", hash_original_method = "15C17CA69A0E3C6519F160E1B18C9284", hash_generated_method = "CA42BA956F8AA0DBB9938A76DB23B03A")
    synchronized boolean cacheConnection(
            HttpHost host, Connection connection) {
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
        addTaint(host.getTaint());
        addTaint(connection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1854622456 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1854622456;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.149 -0400", hash_original_method = "84A867D5F5B3563DFEB3ADE540AAE988", hash_generated_method = "DD09A228786A78B93511F5E0921B3BE8")
    synchronized Connection getConnection(HttpHost host) {
        Connection varB4EAC82CA7396A68D541C85D26508E83_29393491 = null; //Variable for return #1
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
                        boolean varAED9549D6459777C64E1C7E151A999BD_666407926 = (eHost != null && eHost.equals(host));
                        {
                            ret = entry.mConnection;
                            entry.mHost = null;
                            entry.mConnection = null;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_29393491 = ret;
        addTaint(host.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_29393491.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_29393491;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.151 -0400", hash_original_method = "3CB6FBE953A3200168C4C82134203CFB", hash_generated_method = "E0F74B8F9CF50683C06F8CF869C93DC2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.152 -0400", hash_original_method = "D819290B68B2E791C413DF56F024C65B", hash_generated_method = "A9B56A42B266CF89CC9CD3295AAD9B4B")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.152 -0400", hash_original_field = "AE3E518F8FFDE1F8C00699B4C58E95B5", hash_generated_field = "BB62408D38B8CFFE64423F7A37FB51DF")

        HttpHost mHost;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.152 -0400", hash_original_field = "8FB9CEDC14BF8DE9558825242E11E275", hash_generated_field = "D468AD0EA1184CE89FA8A45254E2CDD6")

        Connection mConnection;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.152 -0400", hash_original_field = "A6EFB54FFD2811DD57158A62FDEF145A", hash_generated_field = "4664F919744F49AEF8673D87A7926AAD")

        long mTimeout;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.152 -0400", hash_original_method = "629F4A8E90A91F8ECA92C26A9EB219B2", hash_generated_method = "629F4A8E90A91F8ECA92C26A9EB219B2")
        public Entry ()
        {
            //Synthesized constructor
        }


    }


    
    private class IdleReaper extends Thread {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.153 -0400", hash_original_method = "C9AFDFC698BD8B70E3BC662C5244B0E4", hash_generated_method = "C9AFDFC698BD8B70E3BC662C5244B0E4")
        public IdleReaper ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.169 -0400", hash_original_method = "251C8B975B1D281BC736CAA8083B5C8E", hash_generated_method = "AE17F84397CE5E2F8F7309664CE0F8BA")
        public void run() {
            int check;
            check = 0;
            setName("IdleReaper");
            android.os.Process.setThreadPriority(
                    android.os.Process.THREAD_PRIORITY_BACKGROUND);
            {
                Object varE94B22B047AD5AC83E36E5F483BEB0F2_701705315 = (IdleCache.this);
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.169 -0400", hash_original_field = "03E5A01A6925293D011A56AE5E24D1E6", hash_generated_field = "92DCF8D1B7EA7170529FEBBC12E1B496")

    private static int IDLE_CACHE_MAX = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.170 -0400", hash_original_field = "F6F867A703F127802873EF72834A03A9", hash_generated_field = "F96C8ED01B0B13CAA083FB7CC0F2BC01")

    private static int EMPTY_CHECK_MAX = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.170 -0400", hash_original_field = "D86BC5265DAD5551631EE19814B1E068", hash_generated_field = "3F369D0FFD13643BB005255061B62B48")

    private static int TIMEOUT = 6 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.170 -0400", hash_original_field = "134D854D0A1BB3BE0EBA823B202676B5", hash_generated_field = "91EEB42022844BE15A88DA3B79798EF7")

    private static int CHECK_INTERVAL = 2 * 1000;
}

