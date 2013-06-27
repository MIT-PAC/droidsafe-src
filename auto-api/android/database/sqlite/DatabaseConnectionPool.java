package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

class DatabaseConnectionPool {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.424 -0400", hash_original_field = "60CF7A6EA37051AFA5579BFF259593F0", hash_generated_field = "6DB5215553C1840CAEC8065EEA2DFF1E")

    private volatile int mMaxPoolSize = Resources.getSystem().getInteger(com.android.internal.R.integer.db_connection_pool_size);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.424 -0400", hash_original_field = "12B157B7C91520FB14A4B196CCE78F51", hash_generated_field = "3E7BDBDB36590D8BC66CF890095C8703")

    private ArrayList<PoolObj> mPool = new ArrayList<PoolObj>(mMaxPoolSize);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.424 -0400", hash_original_field = "2C90046C1A99E452326AB92D99B81C31", hash_generated_field = "6A70A90B4FFE8ED9A2AB9CBA8BB34AB9")

    private SQLiteDatabase mParentDbObj;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.424 -0400", hash_original_field = "34D1C35063280164066ECC517050DA0B", hash_generated_field = "0246BE72854112F07DA372D7CE27006A")

    private Random rand;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.444 -0400", hash_original_method = "642674B3CBAE34C61C10ECDA81AF12DF", hash_generated_method = "EFC54464E934D93855F7784F6EC31AC0")
      DatabaseConnectionPool(SQLiteDatabase db) {
        this.mParentDbObj = db;
        {
            boolean var7061DF8A5335B809C796044C2A062407_971692944 = (Log.isLoggable(TAG, Log.DEBUG));
            {
                Log.d(TAG, "Max Pool Size: " + mMaxPoolSize);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //this.mParentDbObj = db;
        //if (Log.isLoggable(TAG, Log.DEBUG)) {
            //Log.d(TAG, "Max Pool Size: " + mMaxPoolSize);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.463 -0400", hash_original_method = "BA169038399FE60257FEACB6F83742BB", hash_generated_method = "B4E4891896E8084A3C52C49BDC479F9B")
    synchronized void close() {
        {
            boolean var7061DF8A5335B809C796044C2A062407_1690038135 = (Log.isLoggable(TAG, Log.DEBUG));
            {
                Log.d(TAG, "Closing the connection pool on " + mParentDbObj.getPath() + toString());
            } //End block
        } //End collapsed parenthetic
        {
            int i;
            i = mPool.size() - 1;
            {
                mPool.get(i).mDb.close();
            } //End block
        } //End collapsed parenthetic
        mPool.clear();
        // ---------- Original Method ----------
        //if (Log.isLoggable(TAG, Log.DEBUG)) {
            //Log.d(TAG, "Closing the connection pool on " + mParentDbObj.getPath() + toString());
        //}
        //for (int i = mPool.size() - 1; i >= 0; i--) {
            //mPool.get(i).mDb.close();
        //}
        //mPool.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.519 -0400", hash_original_method = "29479C12BC42199BDE721BCCF404E99A", hash_generated_method = "D346E427BBC1F3B5685792458CC608BE")
    synchronized SQLiteDatabase get(String sql) {
        SQLiteDatabase varB4EAC82CA7396A68D541C85D26508E83_1281427782 = null; //Variable for return #1
        SQLiteDatabase db;
        db = null;
        PoolObj poolObj;
        poolObj = null;
        int poolSize;
        poolSize = mPool.size();
        {
            boolean var7061DF8A5335B809C796044C2A062407_1696950097 = (Log.isLoggable(TAG, Log.DEBUG));
            {
                doAsserts();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var9B1D07D25E4500725BE2762D29331B41_1212443761 = (getFreePoolSize() == 0);
            {
                {
                    {
                        poolObj = mPool.get(0);
                    } //End block
                    {
                        {
                            int i;
                            i = 0;
                            {
                                {
                                    boolean var319607DB85374E6772E2EF345FC32D08_1790709499 = (mPool.get(i).mDb.isInStatementCache(sql));
                                    {
                                        poolObj = mPool.get(i);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                        {
                            {
                                rand = new Random(SystemClock.elapsedRealtime());
                            } //End block
                            poolObj = mPool.get(rand.nextInt(mMaxPoolSize));
                        } //End block
                    } //End block
                    db = poolObj.mDb;
                } //End block
                {
                    db = mParentDbObj.createPoolConnection((short)(poolSize + 1));
                    poolObj = new PoolObj(db);
                    mPool.add(poolSize, poolObj);
                } //End block
            } //End block
            {
                {
                    int i;
                    i = 0;
                    {
                        {
                            boolean varBCF331DAA437C07B9E1DC7F5A9576EA7_838614089 = (mPool.get(i).isFree() && mPool.get(i).mDb.isInStatementCache(sql));
                            {
                                poolObj = mPool.get(i);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    {
                        int i;
                        i = 0;
                        {
                            {
                                boolean var58C433B19A8B81690E11AB44135FE75C_1654056508 = (mPool.get(i).isFree());
                                {
                                    poolObj = mPool.get(i);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                db = poolObj.mDb;
            } //End block
        } //End collapsed parenthetic
        poolObj.acquire();
        {
            boolean var7061DF8A5335B809C796044C2A062407_483736153 = (Log.isLoggable(TAG, Log.DEBUG));
            {
                Log.d(TAG, "END get-connection: " + toString() + poolObj.toString());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1281427782 = db;
        addTaint(sql.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1281427782.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1281427782;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.532 -0400", hash_original_method = "C508883C202336989018472FC420E1EA", hash_generated_method = "BAAA968E25588B93C75CF89FDCAD4B50")
    synchronized void release(SQLiteDatabase db) {
        {
            boolean var7061DF8A5335B809C796044C2A062407_1570735300 = (Log.isLoggable(TAG, Log.DEBUG));
            {
                doAsserts();
            } //End block
        } //End collapsed parenthetic
        PoolObj poolObj;
        poolObj = mPool.get(db.mConnectionNum - 1);
        {
            boolean var7061DF8A5335B809C796044C2A062407_1188355391 = (Log.isLoggable(TAG, Log.DEBUG));
            {
                Log.d(TAG, "BEGIN release-conn: " + toString() + poolObj.toString());
            } //End block
        } //End collapsed parenthetic
        {
            boolean varD844887BCF703DE90E24EEEBA4E5F37C_2020536989 = (poolObj.isFree());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Releasing object already freed: " +
                    db.mConnectionNum);
            } //End block
        } //End collapsed parenthetic
        poolObj.release();
        {
            boolean var7061DF8A5335B809C796044C2A062407_1472887655 = (Log.isLoggable(TAG, Log.DEBUG));
            {
                Log.d(TAG, "END release-conn: " + toString() + poolObj.toString());
            } //End block
        } //End collapsed parenthetic
        addTaint(db.getTaint());
        // ---------- Original Method ----------
        //if (Log.isLoggable(TAG, Log.DEBUG)) {
            //assert db.mConnectionNum > 0;
            //doAsserts();
            //assert mPool.get(db.mConnectionNum - 1).mDb == db;
        //}
        //PoolObj poolObj = mPool.get(db.mConnectionNum - 1);
        //if (Log.isLoggable(TAG, Log.DEBUG)) {
            //Log.d(TAG, "BEGIN release-conn: " + toString() + poolObj.toString());
        //}
        //if (poolObj.isFree()) {
            //throw new IllegalStateException("Releasing object already freed: " +
                    //db.mConnectionNum);
        //}
        //poolObj.release();
        //if (Log.isLoggable(TAG, Log.DEBUG)) {
            //Log.d(TAG, "END release-conn: " + toString() + poolObj.toString());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.536 -0400", hash_original_method = "D267C5BE0AC41A86583B003ED8AE5C35", hash_generated_method = "18479ACFB50118440631EF3DC8FA1494")
    synchronized ArrayList<SQLiteDatabase> getConnectionList() {
        ArrayList<SQLiteDatabase> varB4EAC82CA7396A68D541C85D26508E83_752871728 = null; //Variable for return #1
        ArrayList<SQLiteDatabase> list;
        list = new ArrayList<SQLiteDatabase>();
        {
            int i;
            i = mPool.size() - 1;
            {
                list.add(mPool.get(i).mDb);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_752871728 = list;
        varB4EAC82CA7396A68D541C85D26508E83_752871728.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_752871728;
        // ---------- Original Method ----------
        //ArrayList<SQLiteDatabase> list = new ArrayList<SQLiteDatabase>();
        //for (int i = mPool.size() - 1; i >= 0; i--) {
            //list.add(mPool.get(i).mDb);
        //}
        //return list;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.547 -0400", hash_original_method = "FCCC68E0BE173C0DC0076E45C706F445", hash_generated_method = "76D218732FB06556061A6BE6DD8F658B")
     int getFreePoolSize() {
        int count;
        count = 0;
        {
            int i;
            i = mPool.size() - 1;
            {
                {
                    boolean var6EFA29D66A5AE03A39596A10625232FD_110500419 = (mPool.get(i).isFree());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_456165131 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_456165131;
        // ---------- Original Method ----------
        //int count = 0;
        //for (int i = mPool.size() - 1; i >= 0; i--) {
            //if (mPool.get(i).isFree()) {
                //count++;
            //}
        //}
        //return count++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.548 -0400", hash_original_method = "94796DA212EFDAF0BC89ABDE3263411C", hash_generated_method = "76827C50AA482F4C7FB4D1664C38F052")
     ArrayList<PoolObj> getPool() {
        ArrayList<PoolObj> varB4EAC82CA7396A68D541C85D26508E83_732983740 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_732983740 = mPool;
        varB4EAC82CA7396A68D541C85D26508E83_732983740.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_732983740;
        // ---------- Original Method ----------
        //return mPool;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.653 -0400", hash_original_method = "9BBFDBA2A96C9EEA2C362B37886D3C5D", hash_generated_method = "7C9E33EE17F3351D1499462505FBB6D3")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_446534216 = null; //Variable for return #1
        StringBuilder buff;
        buff = new StringBuilder();
        buff.append("db: ");
        buff.append(mParentDbObj.getPath());
        buff.append(", totalsize = ");
        buff.append(mPool.size());
        buff.append(", #free = ");
        buff.append(getFreePoolSize());
        buff.append(", maxpoolsize = ");
        buff.append(mMaxPoolSize);
        {
            Iterator<PoolObj> varCCA2E604ADC040E096C584C6F35D4EE4_1618575329 = (mPool).iterator();
            varCCA2E604ADC040E096C584C6F35D4EE4_1618575329.hasNext();
            PoolObj p = varCCA2E604ADC040E096C584C6F35D4EE4_1618575329.next();
            {
                buff.append("\n");
                buff.append(p.toString());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_446534216 = buff.toString();
        varB4EAC82CA7396A68D541C85D26508E83_446534216.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_446534216;
        // ---------- Original Method ----------
        //StringBuilder buff = new StringBuilder();
        //buff.append("db: ");
        //buff.append(mParentDbObj.getPath());
        //buff.append(", totalsize = ");
        //buff.append(mPool.size());
        //buff.append(", #free = ");
        //buff.append(getFreePoolSize());
        //buff.append(", maxpoolsize = ");
        //buff.append(mMaxPoolSize);
        //for (PoolObj p : mPool) {
            //buff.append("\n");
            //buff.append(p.toString());
        //}
        //return buff.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.654 -0400", hash_original_method = "8B6A0047A202C3A27DBFDE3CD809337B", hash_generated_method = "F48596AE45B450F4CCE11BBD20B0C986")
    private void doAsserts() {
        {
            int i;
            i = 0;
            boolean var54BC86BAC9CE390930BD89A6719C890C_1657650731 = (i < mPool.size());
            {
                mPool.get(i).verify();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (int i = 0; i < mPool.size(); i++) {
            //mPool.get(i).verify();
            //assert mPool.get(i).mDb.mConnectionNum == (i + 1);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.655 -0400", hash_original_method = "96488BAB5A39A9E992D6669775E5CBE2", hash_generated_method = "9D4509CE641891DA5CEC26B706A255AF")
    synchronized void setMaxPoolSize(int size) {
        mMaxPoolSize = size;
        // ---------- Original Method ----------
        //mMaxPoolSize = size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.655 -0400", hash_original_method = "A46AC3F11215B4A1E1FF85A064F0CFC1", hash_generated_method = "9DE7F0F73EFE440F697DB02FD2F10EE8")
    synchronized int getMaxPoolSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_525141518 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_525141518;
        // ---------- Original Method ----------
        //return mMaxPoolSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.656 -0400", hash_original_method = "EE241D81DC808707D5F785FD2863CDE3", hash_generated_method = "81DF7766626FF6C6D3B6E0BFE7AE6754")
     boolean isDatabaseObjFree(SQLiteDatabase db) {
        boolean varE763731B50FB2D0B9F176636A3724F75_1146135649 = (mPool.get(db.mConnectionNum - 1).isFree());
        addTaint(db.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_7022541 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_7022541;
        // ---------- Original Method ----------
        //return mPool.get(db.mConnectionNum - 1).isFree();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.660 -0400", hash_original_method = "CEDD9D91870F2CDCC14A9842125741BE", hash_generated_method = "3FBDF29F0157E06C3450B5FAE4C2B299")
     int getSize() {
        int var592A56EFB728CEDE41CBCA444E33C6A9_605898276 = (mPool.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1771846082 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1771846082;
        // ---------- Original Method ----------
        //return mPool.size();
    }

    
    static class PoolObj {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.661 -0400", hash_original_field = "2C1EEFAAB431F1A18FBAAB2A87866E85", hash_generated_field = "92D26B03BAC08A535924894FFC21F4C1")

        private SQLiteDatabase mDb;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.661 -0400", hash_original_field = "104472608290748D816A6C07B2880048", hash_generated_field = "1F70E86597E6AA266596A89FFFE3A0B1")

        private boolean mFreeBusyFlag = FREE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.661 -0400", hash_original_field = "4A6A4A2228837A3EFA044106F58FECB5", hash_generated_field = "FF81CB096E95719A97BE9903BC741745")

        private int mNumHolders = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.661 -0400", hash_original_field = "38B23B32824C5446EA08DC3CB0CE5726", hash_generated_field = "25A1DD62940277CC7CAA21B9DBF3C46E")

        private HashSet<Long> mHolderIds = new HashSet<Long>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.662 -0400", hash_original_method = "DC316C09CB4059B013C925E31D9707E2", hash_generated_method = "C727BF994E820394181F7F366C811F68")
        public  PoolObj(SQLiteDatabase db) {
            mDb = db;
            // ---------- Original Method ----------
            //mDb = db;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.681 -0400", hash_original_method = "45198477A389ECAEEDC0006E6891DF34", hash_generated_method = "BBAC94FB16BB92C98CCB86914E57550B")
        private synchronized void acquire() {
            {
                boolean varF062350F2983BA11C030C10A71A73C26_1164146798 = (Log.isLoggable(TAG, Log.DEBUG));
                {
                    long id;
                    id = Thread.currentThread().getId();
                    mHolderIds.add(id);
                } //End block
            } //End collapsed parenthetic
            mFreeBusyFlag = BUSY;
            // ---------- Original Method ----------
            //if (Log.isLoggable(TAG, Log.DEBUG)) {
                //assert isFree();
                //long id = Thread.currentThread().getId();
                //assert !mHolderIds.contains(id);
                //mHolderIds.add(id);
            //}
            //mNumHolders++;
            //mFreeBusyFlag = BUSY;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.682 -0400", hash_original_method = "AE7C5C4381BC6984ACC18DB5CB72EB59", hash_generated_method = "5A3A749918706C856778CDC27D79B171")
        private synchronized void release() {
            {
                boolean varF062350F2983BA11C030C10A71A73C26_1401051391 = (Log.isLoggable(TAG, Log.DEBUG));
                {
                    long id;
                    id = Thread.currentThread().getId();
                    mHolderIds.remove(id);
                } //End block
            } //End collapsed parenthetic
            {
                mFreeBusyFlag = FREE;
            } //End block
            // ---------- Original Method ----------
            //if (Log.isLoggable(TAG, Log.DEBUG)) {
                //long id = Thread.currentThread().getId();
                //assert mHolderIds.size() == mNumHolders;
                //assert mHolderIds.contains(id);
                //mHolderIds.remove(id);
            //}
            //mNumHolders--;
            //if (mNumHolders == 0) {
                //mFreeBusyFlag = FREE;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.683 -0400", hash_original_method = "789BC5D306614F739870740EDEE72A08", hash_generated_method = "FED793EEEC4E2440B63D1449F38B58AB")
        private synchronized boolean isFree() {
            {
                boolean varF062350F2983BA11C030C10A71A73C26_1608087032 = (Log.isLoggable(TAG, Log.DEBUG));
                {
                    verify();
                } //End block
            } //End collapsed parenthetic
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1350444174 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1350444174;
            // ---------- Original Method ----------
            //if (Log.isLoggable(TAG, Log.DEBUG)) {
                //verify();
            //}
            //return (mFreeBusyFlag == FREE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.683 -0400", hash_original_method = "55CDA36173BE763B72AF18BF479F1305", hash_generated_method = "D870C0B48C8F780AB14EAB37DCC5B591")
        private synchronized void verify() {
            // ---------- Original Method ----------
            //if (mFreeBusyFlag == FREE) {
                //assert mNumHolders == 0;
            //} else {
                //assert mNumHolders > 0;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.684 -0400", hash_original_method = "16D989C7D844FEE29812B797BE2CFCD6", hash_generated_method = "5F5D3F8B209BDF0C9746DFAA2DFC4DFE")
        synchronized int getNumHolders() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_763253470 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_763253470;
            // ---------- Original Method ----------
            //return mNumHolders;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.885 -0400", hash_original_method = "6B148DC19CAC05BE88274109F5158F0D", hash_generated_method = "7019D4B8B05F1E58AFA45141C7271047")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1419573705 = null; //Variable for return #1
            StringBuilder buff;
            buff = new StringBuilder();
            buff.append(", conn # ");
            buff.append(mDb.mConnectionNum);
            buff.append(", mCountHolders = ");
            {
                buff.append(mNumHolders);
                buff.append(", freeBusyFlag = ");
                buff.append(mFreeBusyFlag);
                {
                    Iterator<Long> var0E6E6B9552BE314E653CCAB776377B09_506020988 = (mHolderIds).iterator();
                    var0E6E6B9552BE314E653CCAB776377B09_506020988.hasNext();
                    Long l = var0E6E6B9552BE314E653CCAB776377B09_506020988.next();
                    {
                        buff.append(", id = " + l);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1419573705 = buff.toString();
            varB4EAC82CA7396A68D541C85D26508E83_1419573705.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1419573705;
            // ---------- Original Method ----------
            //StringBuilder buff = new StringBuilder();
            //buff.append(", conn # ");
            //buff.append(mDb.mConnectionNum);
            //buff.append(", mCountHolders = ");
            //synchronized(this) {
                //buff.append(mNumHolders);
                //buff.append(", freeBusyFlag = ");
                //buff.append(mFreeBusyFlag);
                //for (Long l : mHolderIds) {
                    //buff.append(", id = " + l);
                //}
            //}
            //return buff.toString();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.902 -0400", hash_original_field = "5225948491C0BC6C574CDC802AA03B1F", hash_generated_field = "8119A909468DDDAFA61023A87204A1CA")

        private static boolean FREE = true;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.902 -0400", hash_original_field = "F6FA0FB62361E0E94DAD7A0B25A19298", hash_generated_field = "CC2BF8BBDFA553BCE0FA85EA75F25787")

        private static boolean BUSY = false;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.902 -0400", hash_original_field = "616D3F6306688F4F772D0E3578FA8FC0", hash_generated_field = "101C809EB19C22667277246CB28BC987")

    private static String TAG = "DatabaseConnectionPool";
}

