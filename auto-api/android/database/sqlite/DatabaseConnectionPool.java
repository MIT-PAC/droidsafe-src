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
    private volatile int mMaxPoolSize =
        Resources.getSystem().getInteger(com.android.internal.R.integer.db_connection_pool_size);
    private ArrayList<PoolObj> mPool = new ArrayList<PoolObj>(mMaxPoolSize);
    private SQLiteDatabase mParentDbObj;
    private Random rand;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.229 -0400", hash_original_method = "642674B3CBAE34C61C10ECDA81AF12DF", hash_generated_method = "677D6794B2AAED8F5A0D6B3C368CDB88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     DatabaseConnectionPool(SQLiteDatabase db) {
        dsTaint.addTaint(db.dsTaint);
        {
            boolean var7061DF8A5335B809C796044C2A062407_1625456868 = (Log.isLoggable(TAG, Log.DEBUG));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.230 -0400", hash_original_method = "BA169038399FE60257FEACB6F83742BB", hash_generated_method = "23C291C0F84C2D869BBF3DC65A0251FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void close() {
        {
            boolean var7061DF8A5335B809C796044C2A062407_449607506 = (Log.isLoggable(TAG, Log.DEBUG));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.231 -0400", hash_original_method = "29479C12BC42199BDE721BCCF404E99A", hash_generated_method = "7D8FB34F8317EBD68C5CA2DCF883EA78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized SQLiteDatabase get(String sql) {
        dsTaint.addTaint(sql);
        SQLiteDatabase db;
        db = null;
        PoolObj poolObj;
        poolObj = null;
        int poolSize;
        poolSize = mPool.size();
        {
            boolean var7061DF8A5335B809C796044C2A062407_1409087882 = (Log.isLoggable(TAG, Log.DEBUG));
            {
                doAsserts();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var9B1D07D25E4500725BE2762D29331B41_1901006581 = (getFreePoolSize() == 0);
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
                                    boolean var319607DB85374E6772E2EF345FC32D08_1736308860 = (mPool.get(i).mDb.isInStatementCache(sql));
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
                            boolean varBCF331DAA437C07B9E1DC7F5A9576EA7_152917053 = (mPool.get(i).isFree() && mPool.get(i).mDb.isInStatementCache(sql));
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
                                boolean var58C433B19A8B81690E11AB44135FE75C_2100163788 = (mPool.get(i).isFree());
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
            boolean var7061DF8A5335B809C796044C2A062407_275552361 = (Log.isLoggable(TAG, Log.DEBUG));
            {
                Log.d(TAG, "END get-connection: " + toString() + poolObj.toString());
            } //End block
        } //End collapsed parenthetic
        return (SQLiteDatabase)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.231 -0400", hash_original_method = "C508883C202336989018472FC420E1EA", hash_generated_method = "B833D27747FCE3E583111748813142AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void release(SQLiteDatabase db) {
        dsTaint.addTaint(db.dsTaint);
        {
            boolean var7061DF8A5335B809C796044C2A062407_372100692 = (Log.isLoggable(TAG, Log.DEBUG));
            {
                doAsserts();
            } //End block
        } //End collapsed parenthetic
        PoolObj poolObj;
        poolObj = mPool.get(db.mConnectionNum - 1);
        {
            boolean var7061DF8A5335B809C796044C2A062407_979561399 = (Log.isLoggable(TAG, Log.DEBUG));
            {
                Log.d(TAG, "BEGIN release-conn: " + toString() + poolObj.toString());
            } //End block
        } //End collapsed parenthetic
        {
            boolean varD844887BCF703DE90E24EEEBA4E5F37C_637386374 = (poolObj.isFree());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Releasing object already freed: " +
                    db.mConnectionNum);
            } //End block
        } //End collapsed parenthetic
        poolObj.release();
        {
            boolean var7061DF8A5335B809C796044C2A062407_1310437 = (Log.isLoggable(TAG, Log.DEBUG));
            {
                Log.d(TAG, "END release-conn: " + toString() + poolObj.toString());
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.232 -0400", hash_original_method = "D267C5BE0AC41A86583B003ED8AE5C35", hash_generated_method = "5ED45274D5C2B330446E3F1B3CF6BA84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized ArrayList<SQLiteDatabase> getConnectionList() {
        ArrayList<SQLiteDatabase> list;
        list = new ArrayList<SQLiteDatabase>();
        {
            int i;
            i = mPool.size() - 1;
            {
                list.add(mPool.get(i).mDb);
            } //End block
        } //End collapsed parenthetic
        return (ArrayList<SQLiteDatabase>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ArrayList<SQLiteDatabase> list = new ArrayList<SQLiteDatabase>();
        //for (int i = mPool.size() - 1; i >= 0; i--) {
            //list.add(mPool.get(i).mDb);
        //}
        //return list;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.232 -0400", hash_original_method = "FCCC68E0BE173C0DC0076E45C706F445", hash_generated_method = "8EA41A3D23D94FFE6E9D8A4EBB305AC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int getFreePoolSize() {
        int count;
        count = 0;
        {
            int i;
            i = mPool.size() - 1;
            {
                {
                    boolean var6EFA29D66A5AE03A39596A10625232FD_1698774189 = (mPool.get(i).isFree());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int count = 0;
        //for (int i = mPool.size() - 1; i >= 0; i--) {
            //if (mPool.get(i).isFree()) {
                //count++;
            //}
        //}
        //return count++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.232 -0400", hash_original_method = "94796DA212EFDAF0BC89ABDE3263411C", hash_generated_method = "3E971CD61B734D574E51388734000327")
    @DSModeled(DSC.SAFE)
     ArrayList<PoolObj> getPool() {
        return (ArrayList<PoolObj>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mPool;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.238 -0400", hash_original_method = "9BBFDBA2A96C9EEA2C362B37886D3C5D", hash_generated_method = "541056FD37A9FFACAE32317E3B0E9415")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
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
            Iterator<PoolObj> varCCA2E604ADC040E096C584C6F35D4EE4_787215206 = (mPool).iterator();
            varCCA2E604ADC040E096C584C6F35D4EE4_787215206.hasNext();
            PoolObj p = varCCA2E604ADC040E096C584C6F35D4EE4_787215206.next();
            {
                buff.append("\n");
                buff.append(p.toString());
            } //End block
        } //End collapsed parenthetic
        String var7886FFD5307B2368E4A89A54A82E532B_751086071 = (buff.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.239 -0400", hash_original_method = "8B6A0047A202C3A27DBFDE3CD809337B", hash_generated_method = "40EBF44E52AB2EBB01AAFDB17D89F3D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void doAsserts() {
        {
            int i;
            i = 0;
            boolean var54BC86BAC9CE390930BD89A6719C890C_1988331574 = (i < mPool.size());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.239 -0400", hash_original_method = "96488BAB5A39A9E992D6669775E5CBE2", hash_generated_method = "108CEC9BDF4DBEA2518256637D68AE73")
    @DSModeled(DSC.SAFE)
    synchronized void setMaxPoolSize(int size) {
        dsTaint.addTaint(size);
        // ---------- Original Method ----------
        //mMaxPoolSize = size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.240 -0400", hash_original_method = "A46AC3F11215B4A1E1FF85A064F0CFC1", hash_generated_method = "8BFCC5171CCF4D1D3BBF0EE9CBD7F48C")
    @DSModeled(DSC.SAFE)
    synchronized int getMaxPoolSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMaxPoolSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.240 -0400", hash_original_method = "EE241D81DC808707D5F785FD2863CDE3", hash_generated_method = "081D67374DE510DBC8926926209B445E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isDatabaseObjFree(SQLiteDatabase db) {
        dsTaint.addTaint(db.dsTaint);
        boolean varE763731B50FB2D0B9F176636A3724F75_186943715 = (mPool.get(db.mConnectionNum - 1).isFree());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mPool.get(db.mConnectionNum - 1).isFree();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.240 -0400", hash_original_method = "CEDD9D91870F2CDCC14A9842125741BE", hash_generated_method = "573906F911822987DD1002DA6A0A219E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int getSize() {
        int var592A56EFB728CEDE41CBCA444E33C6A9_1513384601 = (mPool.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPool.size();
    }

    
    static class PoolObj {
        private SQLiteDatabase mDb;
        private boolean mFreeBusyFlag = FREE;
        private int mNumHolders = 0;
        private HashSet<Long> mHolderIds = new HashSet<Long>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.241 -0400", hash_original_method = "DC316C09CB4059B013C925E31D9707E2", hash_generated_method = "FA000B6747F8605349AC90B0445CFCED")
        @DSModeled(DSC.SAFE)
        public PoolObj(SQLiteDatabase db) {
            dsTaint.addTaint(db.dsTaint);
            // ---------- Original Method ----------
            //mDb = db;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.241 -0400", hash_original_method = "45198477A389ECAEEDC0006E6891DF34", hash_generated_method = "0D6468705A2164536506EDD1D72D81B8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private synchronized void acquire() {
            {
                boolean varF062350F2983BA11C030C10A71A73C26_2060044888 = (Log.isLoggable(TAG, Log.DEBUG));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.243 -0400", hash_original_method = "AE7C5C4381BC6984ACC18DB5CB72EB59", hash_generated_method = "88510EC045E13F85A736758749C92FA6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private synchronized void release() {
            {
                boolean varF062350F2983BA11C030C10A71A73C26_1577738570 = (Log.isLoggable(TAG, Log.DEBUG));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.243 -0400", hash_original_method = "789BC5D306614F739870740EDEE72A08", hash_generated_method = "870F4907D9604723D97FD3AE71122FD9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private synchronized boolean isFree() {
            {
                boolean varF062350F2983BA11C030C10A71A73C26_2114208713 = (Log.isLoggable(TAG, Log.DEBUG));
                {
                    verify();
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (Log.isLoggable(TAG, Log.DEBUG)) {
                //verify();
            //}
            //return (mFreeBusyFlag == FREE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.243 -0400", hash_original_method = "55CDA36173BE763B72AF18BF479F1305", hash_generated_method = "D870C0B48C8F780AB14EAB37DCC5B591")
        @DSModeled(DSC.SAFE)
        private synchronized void verify() {
            // ---------- Original Method ----------
            //if (mFreeBusyFlag == FREE) {
                //assert mNumHolders == 0;
            //} else {
                //assert mNumHolders > 0;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.244 -0400", hash_original_method = "16D989C7D844FEE29812B797BE2CFCD6", hash_generated_method = "82EDAFBFFF89DE538CC2F6BF04D9EB7F")
        @DSModeled(DSC.SAFE)
        synchronized int getNumHolders() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mNumHolders;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.261 -0400", hash_original_method = "6B148DC19CAC05BE88274109F5158F0D", hash_generated_method = "97DA42626E74858C3BF7A542438A2430")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
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
                    Iterator<Long> var0E6E6B9552BE314E653CCAB776377B09_1979961138 = (mHolderIds).iterator();
                    var0E6E6B9552BE314E653CCAB776377B09_1979961138.hasNext();
                    Long l = var0E6E6B9552BE314E653CCAB776377B09_1979961138.next();
                    {
                        buff.append(", id = " + l);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            String var0D89C4BB0E45E7CA7BE9B5E30C3E10F7_2105650180 = (buff.toString());
            return dsTaint.getTaintString();
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

        
        private static final boolean FREE = true;
        private static final boolean BUSY = false;
    }


    
    private static final String TAG = "DatabaseConnectionPool";
}

