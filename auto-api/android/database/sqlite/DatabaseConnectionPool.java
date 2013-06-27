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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.833 -0400", hash_original_field = "60CF7A6EA37051AFA5579BFF259593F0", hash_generated_field = "6DB5215553C1840CAEC8065EEA2DFF1E")

    private volatile int mMaxPoolSize = Resources.getSystem().getInteger(com.android.internal.R.integer.db_connection_pool_size);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.833 -0400", hash_original_field = "12B157B7C91520FB14A4B196CCE78F51", hash_generated_field = "3E7BDBDB36590D8BC66CF890095C8703")

    private ArrayList<PoolObj> mPool = new ArrayList<PoolObj>(mMaxPoolSize);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.833 -0400", hash_original_field = "2C90046C1A99E452326AB92D99B81C31", hash_generated_field = "6A70A90B4FFE8ED9A2AB9CBA8BB34AB9")

    private SQLiteDatabase mParentDbObj;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.833 -0400", hash_original_field = "34D1C35063280164066ECC517050DA0B", hash_generated_field = "0246BE72854112F07DA372D7CE27006A")

    private Random rand;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.856 -0400", hash_original_method = "642674B3CBAE34C61C10ECDA81AF12DF", hash_generated_method = "9603FDC3F3907998D22049C9E93289A9")
      DatabaseConnectionPool(SQLiteDatabase db) {
        this.mParentDbObj = db;
        {
            boolean var7061DF8A5335B809C796044C2A062407_648188043 = (Log.isLoggable(TAG, Log.DEBUG));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.865 -0400", hash_original_method = "BA169038399FE60257FEACB6F83742BB", hash_generated_method = "63858F82C7BADFF98C728E5A04F6CCF8")
    synchronized void close() {
        {
            boolean var7061DF8A5335B809C796044C2A062407_747610536 = (Log.isLoggable(TAG, Log.DEBUG));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.921 -0400", hash_original_method = "29479C12BC42199BDE721BCCF404E99A", hash_generated_method = "4A8BA7A2A532D67E983C9B7C31BAEEE9")
    synchronized SQLiteDatabase get(String sql) {
        SQLiteDatabase varB4EAC82CA7396A68D541C85D26508E83_1043425651 = null; //Variable for return #1
        SQLiteDatabase db;
        db = null;
        PoolObj poolObj;
        poolObj = null;
        int poolSize;
        poolSize = mPool.size();
        {
            boolean var7061DF8A5335B809C796044C2A062407_281644131 = (Log.isLoggable(TAG, Log.DEBUG));
            {
                doAsserts();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var9B1D07D25E4500725BE2762D29331B41_2033064975 = (getFreePoolSize() == 0);
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
                                    boolean var319607DB85374E6772E2EF345FC32D08_564768018 = (mPool.get(i).mDb.isInStatementCache(sql));
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
                            boolean varBCF331DAA437C07B9E1DC7F5A9576EA7_2068469385 = (mPool.get(i).isFree() && mPool.get(i).mDb.isInStatementCache(sql));
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
                                boolean var58C433B19A8B81690E11AB44135FE75C_1404158476 = (mPool.get(i).isFree());
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
            boolean var7061DF8A5335B809C796044C2A062407_1926040273 = (Log.isLoggable(TAG, Log.DEBUG));
            {
                Log.d(TAG, "END get-connection: " + toString() + poolObj.toString());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1043425651 = db;
        addTaint(sql.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1043425651.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1043425651;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.926 -0400", hash_original_method = "C508883C202336989018472FC420E1EA", hash_generated_method = "D88BC310DB14F842C13CCDD75C9B778A")
    synchronized void release(SQLiteDatabase db) {
        {
            boolean var7061DF8A5335B809C796044C2A062407_1832273221 = (Log.isLoggable(TAG, Log.DEBUG));
            {
                doAsserts();
            } //End block
        } //End collapsed parenthetic
        PoolObj poolObj;
        poolObj = mPool.get(db.mConnectionNum - 1);
        {
            boolean var7061DF8A5335B809C796044C2A062407_460251934 = (Log.isLoggable(TAG, Log.DEBUG));
            {
                Log.d(TAG, "BEGIN release-conn: " + toString() + poolObj.toString());
            } //End block
        } //End collapsed parenthetic
        {
            boolean varD844887BCF703DE90E24EEEBA4E5F37C_1065852979 = (poolObj.isFree());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Releasing object already freed: " +
                    db.mConnectionNum);
            } //End block
        } //End collapsed parenthetic
        poolObj.release();
        {
            boolean var7061DF8A5335B809C796044C2A062407_1574115324 = (Log.isLoggable(TAG, Log.DEBUG));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.938 -0400", hash_original_method = "D267C5BE0AC41A86583B003ED8AE5C35", hash_generated_method = "331B19DD0B6C4363426D59A0CD6E95A1")
    synchronized ArrayList<SQLiteDatabase> getConnectionList() {
        ArrayList<SQLiteDatabase> varB4EAC82CA7396A68D541C85D26508E83_879686702 = null; //Variable for return #1
        ArrayList<SQLiteDatabase> list;
        list = new ArrayList<SQLiteDatabase>();
        {
            int i;
            i = mPool.size() - 1;
            {
                list.add(mPool.get(i).mDb);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_879686702 = list;
        varB4EAC82CA7396A68D541C85D26508E83_879686702.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_879686702;
        // ---------- Original Method ----------
        //ArrayList<SQLiteDatabase> list = new ArrayList<SQLiteDatabase>();
        //for (int i = mPool.size() - 1; i >= 0; i--) {
            //list.add(mPool.get(i).mDb);
        //}
        //return list;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.952 -0400", hash_original_method = "FCCC68E0BE173C0DC0076E45C706F445", hash_generated_method = "E94287E7A1106EBFAA761073A629E6ED")
     int getFreePoolSize() {
        int count;
        count = 0;
        {
            int i;
            i = mPool.size() - 1;
            {
                {
                    boolean var6EFA29D66A5AE03A39596A10625232FD_1068835359 = (mPool.get(i).isFree());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1338745960 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1338745960;
        // ---------- Original Method ----------
        //int count = 0;
        //for (int i = mPool.size() - 1; i >= 0; i--) {
            //if (mPool.get(i).isFree()) {
                //count++;
            //}
        //}
        //return count++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.956 -0400", hash_original_method = "94796DA212EFDAF0BC89ABDE3263411C", hash_generated_method = "A4BC2307E858A7AAEB3E4D2F87FCDDB8")
     ArrayList<PoolObj> getPool() {
        ArrayList<PoolObj> varB4EAC82CA7396A68D541C85D26508E83_1674141200 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1674141200 = mPool;
        varB4EAC82CA7396A68D541C85D26508E83_1674141200.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1674141200;
        // ---------- Original Method ----------
        //return mPool;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.047 -0400", hash_original_method = "9BBFDBA2A96C9EEA2C362B37886D3C5D", hash_generated_method = "AC9BDE3EC3B5515755AE7F3A20B781A6")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_367285593 = null; //Variable for return #1
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
            Iterator<PoolObj> varCCA2E604ADC040E096C584C6F35D4EE4_1456739474 = (mPool).iterator();
            varCCA2E604ADC040E096C584C6F35D4EE4_1456739474.hasNext();
            PoolObj p = varCCA2E604ADC040E096C584C6F35D4EE4_1456739474.next();
            {
                buff.append("\n");
                buff.append(p.toString());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_367285593 = buff.toString();
        varB4EAC82CA7396A68D541C85D26508E83_367285593.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_367285593;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.050 -0400", hash_original_method = "8B6A0047A202C3A27DBFDE3CD809337B", hash_generated_method = "11847386EA54451C0FAF5DF7E84E6662")
    private void doAsserts() {
        {
            int i;
            i = 0;
            boolean var54BC86BAC9CE390930BD89A6719C890C_668331290 = (i < mPool.size());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.068 -0400", hash_original_method = "96488BAB5A39A9E992D6669775E5CBE2", hash_generated_method = "9D4509CE641891DA5CEC26B706A255AF")
    synchronized void setMaxPoolSize(int size) {
        mMaxPoolSize = size;
        // ---------- Original Method ----------
        //mMaxPoolSize = size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.068 -0400", hash_original_method = "A46AC3F11215B4A1E1FF85A064F0CFC1", hash_generated_method = "EF02473FF4457BBFEB189C3C1D128632")
    synchronized int getMaxPoolSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1585001904 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1585001904;
        // ---------- Original Method ----------
        //return mMaxPoolSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.070 -0400", hash_original_method = "EE241D81DC808707D5F785FD2863CDE3", hash_generated_method = "AEED6D68ED6AAC9D00F1D052091EA134")
     boolean isDatabaseObjFree(SQLiteDatabase db) {
        boolean varE763731B50FB2D0B9F176636A3724F75_268829325 = (mPool.get(db.mConnectionNum - 1).isFree());
        addTaint(db.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1135942533 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1135942533;
        // ---------- Original Method ----------
        //return mPool.get(db.mConnectionNum - 1).isFree();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.070 -0400", hash_original_method = "CEDD9D91870F2CDCC14A9842125741BE", hash_generated_method = "FBF9E4911DA977982A7B90C219D1AEB3")
     int getSize() {
        int var592A56EFB728CEDE41CBCA444E33C6A9_1944800897 = (mPool.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1057293813 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1057293813;
        // ---------- Original Method ----------
        //return mPool.size();
    }

    
    static class PoolObj {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.074 -0400", hash_original_field = "2C1EEFAAB431F1A18FBAAB2A87866E85", hash_generated_field = "92D26B03BAC08A535924894FFC21F4C1")

        private SQLiteDatabase mDb;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.074 -0400", hash_original_field = "104472608290748D816A6C07B2880048", hash_generated_field = "1F70E86597E6AA266596A89FFFE3A0B1")

        private boolean mFreeBusyFlag = FREE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.074 -0400", hash_original_field = "4A6A4A2228837A3EFA044106F58FECB5", hash_generated_field = "FF81CB096E95719A97BE9903BC741745")

        private int mNumHolders = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.074 -0400", hash_original_field = "38B23B32824C5446EA08DC3CB0CE5726", hash_generated_field = "25A1DD62940277CC7CAA21B9DBF3C46E")

        private HashSet<Long> mHolderIds = new HashSet<Long>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.075 -0400", hash_original_method = "DC316C09CB4059B013C925E31D9707E2", hash_generated_method = "C727BF994E820394181F7F366C811F68")
        public  PoolObj(SQLiteDatabase db) {
            mDb = db;
            // ---------- Original Method ----------
            //mDb = db;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.088 -0400", hash_original_method = "45198477A389ECAEEDC0006E6891DF34", hash_generated_method = "46997260D7F811EF656CCF5AC0F4456D")
        private synchronized void acquire() {
            {
                boolean varF062350F2983BA11C030C10A71A73C26_1240484021 = (Log.isLoggable(TAG, Log.DEBUG));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.097 -0400", hash_original_method = "AE7C5C4381BC6984ACC18DB5CB72EB59", hash_generated_method = "A0F260F366FA7E0790A02FDF2E673524")
        private synchronized void release() {
            {
                boolean varF062350F2983BA11C030C10A71A73C26_1183070481 = (Log.isLoggable(TAG, Log.DEBUG));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.109 -0400", hash_original_method = "789BC5D306614F739870740EDEE72A08", hash_generated_method = "A985184176D5F034BD9EDC5653745E64")
        private synchronized boolean isFree() {
            {
                boolean varF062350F2983BA11C030C10A71A73C26_2122425289 = (Log.isLoggable(TAG, Log.DEBUG));
                {
                    verify();
                } //End block
            } //End collapsed parenthetic
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_191792701 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_191792701;
            // ---------- Original Method ----------
            //if (Log.isLoggable(TAG, Log.DEBUG)) {
                //verify();
            //}
            //return (mFreeBusyFlag == FREE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.110 -0400", hash_original_method = "55CDA36173BE763B72AF18BF479F1305", hash_generated_method = "D870C0B48C8F780AB14EAB37DCC5B591")
        private synchronized void verify() {
            // ---------- Original Method ----------
            //if (mFreeBusyFlag == FREE) {
                //assert mNumHolders == 0;
            //} else {
                //assert mNumHolders > 0;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.111 -0400", hash_original_method = "16D989C7D844FEE29812B797BE2CFCD6", hash_generated_method = "C54BDAD881C124F6B8B7711D7EE299C5")
        synchronized int getNumHolders() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_960079037 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_960079037;
            // ---------- Original Method ----------
            //return mNumHolders;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.355 -0400", hash_original_method = "6B148DC19CAC05BE88274109F5158F0D", hash_generated_method = "1D512507738EAC4B31A532793A7D32D8")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1268329700 = null; //Variable for return #1
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
                    Iterator<Long> var0E6E6B9552BE314E653CCAB776377B09_1866858893 = (mHolderIds).iterator();
                    var0E6E6B9552BE314E653CCAB776377B09_1866858893.hasNext();
                    Long l = var0E6E6B9552BE314E653CCAB776377B09_1866858893.next();
                    {
                        buff.append(", id = " + l);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1268329700 = buff.toString();
            varB4EAC82CA7396A68D541C85D26508E83_1268329700.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1268329700;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.356 -0400", hash_original_field = "5225948491C0BC6C574CDC802AA03B1F", hash_generated_field = "8119A909468DDDAFA61023A87204A1CA")

        private static boolean FREE = true;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.356 -0400", hash_original_field = "F6FA0FB62361E0E94DAD7A0B25A19298", hash_generated_field = "CC2BF8BBDFA553BCE0FA85EA75F25787")

        private static boolean BUSY = false;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.356 -0400", hash_original_field = "616D3F6306688F4F772D0E3578FA8FC0", hash_generated_field = "101C809EB19C22667277246CB28BC987")

    private static String TAG = "DatabaseConnectionPool";
}

