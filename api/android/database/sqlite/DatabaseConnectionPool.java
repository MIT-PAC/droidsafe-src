package android.database.sqlite;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import android.content.res.Resources;
import android.os.SystemClock;
import android.util.Log;





class DatabaseConnectionPool {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.022 -0500", hash_original_field = "D458AE8E95C1FC2D2C535B3D0654ED60", hash_generated_field = "6C058760B23A5C13D7BB739FC64924DB")


    private static final String TAG = "DatabaseConnectionPool";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.025 -0500", hash_original_field = "F58D467CCD0C73A616F2728389AB6A3C", hash_generated_field = "6DB5215553C1840CAEC8065EEA2DFF1E")

    private volatile int mMaxPoolSize =
        Resources.getSystem().getInteger(com.android.internal.R.integer.db_connection_pool_size);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.027 -0500", hash_original_field = "ACF9FE0E11976FB2553438AD3CE5E453", hash_generated_field = "18B787FE623D5F75DA1743A19683143E")

    private final ArrayList<PoolObj> mPool = new ArrayList<PoolObj>(mMaxPoolSize);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.029 -0500", hash_original_field = "EC7FEC78D655B787EA24F290F017C2B7", hash_generated_field = "6A70A90B4FFE8ED9A2AB9CBA8BB34AB9")

    private  SQLiteDatabase mParentDbObj;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.032 -0500", hash_original_field = "AA5335FB09DCC9CCA821116C81FA1FBE", hash_generated_field = "0246BE72854112F07DA372D7CE27006A")

    private Random rand; // lazily initialized

    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.034 -0500", hash_original_method = "642674B3CBAE34C61C10ECDA81AF12DF", hash_generated_method = "642674B3CBAE34C61C10ECDA81AF12DF")
    
DatabaseConnectionPool(SQLiteDatabase db) {
        this.mParentDbObj = db;
        if (Log.isLoggable(TAG, Log.DEBUG)) {
            Log.d(TAG, "Max Pool Size: " + mMaxPoolSize);
        }
    }

    /**
     * close all database connections in the pool - even if they are in use!
     */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.037 -0500", hash_original_method = "BA169038399FE60257FEACB6F83742BB", hash_generated_method = "F4DE400B5ECB636CE5878A6196E9F7A7")
    
synchronized void close() {
        if (Log.isLoggable(TAG, Log.DEBUG)) {
            Log.d(TAG, "Closing the connection pool on " + mParentDbObj.getPath() + toString());
        }
        for (int i = mPool.size() - 1; i >= 0; i--) {
            mPool.get(i).mDb.close();
        }
        mPool.clear();
    }

    /**
     * get a free connection from the pool
     *
     * @param sql if not null, try to find a connection inthe pool which already has cached
     * the compiled statement for this sql.
     * @return the Database connection that the caller can use
     */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.040 -0500", hash_original_method = "29479C12BC42199BDE721BCCF404E99A", hash_generated_method = "EABA6C2E5398A2C547ACC10A61508936")
    
synchronized SQLiteDatabase get(String sql) {
        SQLiteDatabase db = null;
        PoolObj poolObj = null;
        int poolSize = mPool.size();
        if (Log.isLoggable(TAG, Log.DEBUG)) {
            assert sql != null;
            doAsserts();
        }
        if (getFreePoolSize() == 0) {
            // no free ( = available) connections
            if (mMaxPoolSize == poolSize) {
                // maxed out. can't open any more connections.
                // let the caller wait on one of the pooled connections
                // preferably a connection caching the pre-compiled statement of the given SQL
                if (mMaxPoolSize == 1) {
                    poolObj = mPool.get(0);
                } else {
                    for (int i = 0; i < mMaxPoolSize; i++) {
                        if (mPool.get(i).mDb.isInStatementCache(sql)) {
                            poolObj = mPool.get(i);
                            break;
                        }
                    }
                    if (poolObj == null) {
                        // there are no database connections with the given SQL pre-compiled.
                        // ok to return any of the connections.
                        if (rand == null) {
                            rand = new Random(SystemClock.elapsedRealtime());
                        }
                        poolObj = mPool.get(rand.nextInt(mMaxPoolSize));
                    }
                }
                db = poolObj.mDb;
            } else {
                // create a new connection and add it to the pool, since we haven't reached
                // max pool size allowed
                db = mParentDbObj.createPoolConnection((short)(poolSize + 1));
                poolObj = new PoolObj(db);
                mPool.add(poolSize, poolObj);
            }
        } else {
            // there are free connections available. pick one
            // preferably a connection caching the pre-compiled statement of the given SQL
            for (int i = 0; i < poolSize; i++) {
                if (mPool.get(i).isFree() && mPool.get(i).mDb.isInStatementCache(sql)) {
                    poolObj = mPool.get(i);
                    break;
                }
            }
            if (poolObj == null) {
                // didn't find a free database connection with the given SQL already
                // pre-compiled. return a free connection (this means, the same SQL could be
                // pre-compiled on more than one database connection. potential wasted memory.)
                for (int i = 0; i < poolSize; i++) {
                    if (mPool.get(i).isFree()) {
                        poolObj = mPool.get(i);
                        break;
                    }
                }
            }
            db = poolObj.mDb;
        }

        assert poolObj != null;
        assert poolObj.mDb == db;

        poolObj.acquire();
        if (Log.isLoggable(TAG, Log.DEBUG)) {
            Log.d(TAG, "END get-connection: " + toString() + poolObj.toString());
        }
        return db;
        // TODO if a thread acquires a connection and dies without releasing the connection, then
        // there could be a connection leak.
    }

    /**
     * release the given database connection back to the pool.
     * @param db the connection to be released
     */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.043 -0500", hash_original_method = "C508883C202336989018472FC420E1EA", hash_generated_method = "5646E4AECD89E9D0C3A80970E4BB3B1E")
    
synchronized void release(SQLiteDatabase db) {
        if (Log.isLoggable(TAG, Log.DEBUG)) {
            assert db.mConnectionNum > 0;
            doAsserts();
            assert mPool.get(db.mConnectionNum - 1).mDb == db;
        }

        PoolObj poolObj = mPool.get(db.mConnectionNum - 1);

        if (Log.isLoggable(TAG, Log.DEBUG)) {
            Log.d(TAG, "BEGIN release-conn: " + toString() + poolObj.toString());
        }

        if (poolObj.isFree()) {
            throw new IllegalStateException("Releasing object already freed: " +
                    db.mConnectionNum);
        }

        poolObj.release();
        if (Log.isLoggable(TAG, Log.DEBUG)) {
            Log.d(TAG, "END release-conn: " + toString() + poolObj.toString());
        }
    }

    /**
     * Returns a list of all database connections in the pool (both free and busy connections).
     * This method is used when "adb bugreport" is done.
     */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.045 -0500", hash_original_method = "D267C5BE0AC41A86583B003ED8AE5C35", hash_generated_method = "49B7569C3BAAE699A4F8A4AC950390DC")
    
synchronized ArrayList<SQLiteDatabase> getConnectionList() {
        ArrayList<SQLiteDatabase> list = new ArrayList<SQLiteDatabase>();
        for (int i = mPool.size() - 1; i >= 0; i--) {
            list.add(mPool.get(i).mDb);
        }
        return list;
    }

    /**
     * package level access for testing purposes only. otherwise, private should be sufficient.
     */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.047 -0500", hash_original_method = "FCCC68E0BE173C0DC0076E45C706F445", hash_generated_method = "FCCC68E0BE173C0DC0076E45C706F445")
    
int getFreePoolSize() {
        int count = 0;
        for (int i = mPool.size() - 1; i >= 0; i--) {
            if (mPool.get(i).isFree()) {
                count++;
            }
        }
        return count++;
    }

    /**
     * only for testing purposes
     */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.049 -0500", hash_original_method = "94796DA212EFDAF0BC89ABDE3263411C", hash_generated_method = "94796DA212EFDAF0BC89ABDE3263411C")
    
ArrayList<PoolObj> getPool() {
        return mPool;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.053 -0500", hash_original_method = "9BBFDBA2A96C9EEA2C362B37886D3C5D", hash_generated_method = "F4DBBA6B261C69CD16C34211DC2E1C63")
    
@Override
    public String toString() {
        StringBuilder buff = new StringBuilder();
        buff.append("db: ");
        buff.append(mParentDbObj.getPath());
        buff.append(", totalsize = ");
        buff.append(mPool.size());
        buff.append(", #free = ");
        buff.append(getFreePoolSize());
        buff.append(", maxpoolsize = ");
        buff.append(mMaxPoolSize);
        for (PoolObj p : mPool) {
            buff.append("\n");
            buff.append(p.toString());
        }
        return buff.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.055 -0500", hash_original_method = "8B6A0047A202C3A27DBFDE3CD809337B", hash_generated_method = "0253D1A72B2E2D37A5769D2E4B0EF8CE")
    
private void doAsserts() {
        for (int i = 0; i < mPool.size(); i++) {
            mPool.get(i).verify();
            assert mPool.get(i).mDb.mConnectionNum == (i + 1);
        }
    }

    /** only used for testing purposes. */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.058 -0500", hash_original_method = "96488BAB5A39A9E992D6669775E5CBE2", hash_generated_method = "6FF68961EF1ADA0AF66CC0A574046C16")
    
synchronized void setMaxPoolSize(int size) {
        mMaxPoolSize = size;
    }

    /** only used for testing purposes. */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.060 -0500", hash_original_method = "A46AC3F11215B4A1E1FF85A064F0CFC1", hash_generated_method = "CE54283B2B9347A707D56942852DC94E")
    
synchronized int getMaxPoolSize() {
        return mMaxPoolSize;
    }

    /** only used for testing purposes. */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.062 -0500", hash_original_method = "EE241D81DC808707D5F785FD2863CDE3", hash_generated_method = "EE241D81DC808707D5F785FD2863CDE3")
    
boolean isDatabaseObjFree(SQLiteDatabase db) {
        return mPool.get(db.mConnectionNum - 1).isFree();
    }

    
    static class PoolObj {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.072 -0500", hash_original_field = "0225E37C4B8A4E95808D931D59B1E5B7", hash_generated_field = "3E252BD97600562FDA798CEE6D61D62F")

        private static final boolean FREE = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.075 -0500", hash_original_field = "A72DC3B2741799A62BE7D3A556B9C8DF", hash_generated_field = "95E2AC55156607626DFBEE0C02F9BE1A")

        private static final boolean BUSY = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.067 -0500", hash_original_field = "F34517A3CF2A339F68B081C837324DA1", hash_generated_field = "92D26B03BAC08A535924894FFC21F4C1")


        private  SQLiteDatabase mDb;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.070 -0500", hash_original_field = "9012DF29D185800EDA5DC094183A34D6", hash_generated_field = "1F70E86597E6AA266596A89FFFE3A0B1")

        private boolean mFreeBusyFlag = FREE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.077 -0500", hash_original_field = "07ED8AEA7AB869D53AB329ACB9F4B68D", hash_generated_field = "EF5B3847AF4720774496AF98E55B78BC")

        // @GuardedBy("this")
        private int mNumHolders = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.080 -0500", hash_original_field = "35223FE950BD5009FF8CABCC4DA4193A", hash_generated_field = "25CE0E089CD0F5FC31F4F7C0D46231B7")

        // @GuardedBy("this")
        private HashSet<Long> mHolderIds = new HashSet<Long>();

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.082 -0500", hash_original_method = "DC316C09CB4059B013C925E31D9707E2", hash_generated_method = "41ADA07EBA71B844039B21EB2DEE0C70")
        
public PoolObj(SQLiteDatabase db) {
            mDb = db;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.085 -0500", hash_original_method = "45198477A389ECAEEDC0006E6891DF34", hash_generated_method = "80D515F13C53A3CDD088ED60C4E10D2E")
        
private synchronized void acquire() {
            if (Log.isLoggable(TAG, Log.DEBUG)) {
                assert isFree();
                long id = Thread.currentThread().getId();
                assert !mHolderIds.contains(id);
                mHolderIds.add(id);
            }

            mNumHolders++;
            mFreeBusyFlag = BUSY;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.088 -0500", hash_original_method = "AE7C5C4381BC6984ACC18DB5CB72EB59", hash_generated_method = "D3B0E6CD7052940AAECFCA70A283FAE5")
        
private synchronized void release() {
            if (Log.isLoggable(TAG, Log.DEBUG)) {
                long id = Thread.currentThread().getId();
                assert mHolderIds.size() == mNumHolders;
                assert mHolderIds.contains(id);
                mHolderIds.remove(id);
            }

            mNumHolders--;
            if (mNumHolders == 0) {
                mFreeBusyFlag = FREE;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.090 -0500", hash_original_method = "789BC5D306614F739870740EDEE72A08", hash_generated_method = "0C6508D555518D1CDABD32967936DBE1")
        
private synchronized boolean isFree() {
            if (Log.isLoggable(TAG, Log.DEBUG)) {
                verify();
            }
            return (mFreeBusyFlag == FREE);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.093 -0500", hash_original_method = "55CDA36173BE763B72AF18BF479F1305", hash_generated_method = "301630570D604875E674DC021DE17922")
        
private synchronized void verify() {
            if (mFreeBusyFlag == FREE) {
                assert mNumHolders == 0;
            } else {
                assert mNumHolders > 0;
            }
        }

        /**
         * only for testing purposes
         */
        /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.095 -0500", hash_original_method = "16D989C7D844FEE29812B797BE2CFCD6", hash_generated_method = "945EC54B01EFE1D0FE96997599AA69D8")
        
synchronized int getNumHolders() {
            return mNumHolders;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.097 -0500", hash_original_method = "6B148DC19CAC05BE88274109F5158F0D", hash_generated_method = "690D57D629B1A258706DB5BBEBBE1994")
        
@Override
        public String toString() {
            StringBuilder buff = new StringBuilder();
            buff.append(", conn # ");
            buff.append(mDb.mConnectionNum);
            buff.append(", mCountHolders = ");
            synchronized(this) {
                buff.append(mNumHolders);
                buff.append(", freeBusyFlag = ");
                buff.append(mFreeBusyFlag);
                for (Long l : mHolderIds) {
                    buff.append(", id = " + l);
                }
            }
            return buff.toString();
        }
    }

    /** only used for testing purposes. */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.064 -0500", hash_original_method = "CEDD9D91870F2CDCC14A9842125741BE", hash_generated_method = "CEDD9D91870F2CDCC14A9842125741BE")
    
int getSize() {
        return mPool.size();
    }
}

