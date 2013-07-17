package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

class DatabaseConnectionPool {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.130 -0400", hash_original_field = "60CF7A6EA37051AFA5579BFF259593F0", hash_generated_field = "6DB5215553C1840CAEC8065EEA2DFF1E")

    private volatile int mMaxPoolSize = Resources.getSystem().getInteger(com.android.internal.R.integer.db_connection_pool_size);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.130 -0400", hash_original_field = "12B157B7C91520FB14A4B196CCE78F51", hash_generated_field = "18B787FE623D5F75DA1743A19683143E")

    private final ArrayList<PoolObj> mPool = new ArrayList<PoolObj>(mMaxPoolSize);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.130 -0400", hash_original_field = "2C90046C1A99E452326AB92D99B81C31", hash_generated_field = "6A70A90B4FFE8ED9A2AB9CBA8BB34AB9")

    private SQLiteDatabase mParentDbObj;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.130 -0400", hash_original_field = "34D1C35063280164066ECC517050DA0B", hash_generated_field = "0246BE72854112F07DA372D7CE27006A")

    private Random rand;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.131 -0400", hash_original_method = "642674B3CBAE34C61C10ECDA81AF12DF", hash_generated_method = "405D2245E138C6BA6810E66559719176")
      DatabaseConnectionPool(SQLiteDatabase db) {
        this.mParentDbObj = db;
        if(Log.isLoggable(TAG, Log.DEBUG))        
        {
            Log.d(TAG, "Max Pool Size: " + mMaxPoolSize);
        } //End block
        // ---------- Original Method ----------
        //this.mParentDbObj = db;
        //if (Log.isLoggable(TAG, Log.DEBUG)) {
            //Log.d(TAG, "Max Pool Size: " + mMaxPoolSize);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.132 -0400", hash_original_method = "BA169038399FE60257FEACB6F83742BB", hash_generated_method = "513FA28A3AABA906A7ABCD4DA846E1CB")
    synchronized void close() {
        if(Log.isLoggable(TAG, Log.DEBUG))        
        {
            Log.d(TAG, "Closing the connection pool on " + mParentDbObj.getPath() + toString());
        } //End block
for(int i = mPool.size() - 1;i >= 0;i--)
        {
            mPool.get(i).mDb.close();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.134 -0400", hash_original_method = "29479C12BC42199BDE721BCCF404E99A", hash_generated_method = "684055CE5905DFB78CE119A44FB5FBA8")
    synchronized SQLiteDatabase get(String sql) {
        addTaint(sql.getTaint());
        SQLiteDatabase db = null;
        PoolObj poolObj = null;
        int poolSize = mPool.size();
        if(Log.isLoggable(TAG, Log.DEBUG))        
        {
            doAsserts();
        } //End block
        if(getFreePoolSize() == 0)        
        {
            if(mMaxPoolSize == poolSize)            
            {
                if(mMaxPoolSize == 1)                
                {
                    poolObj = mPool.get(0);
                } //End block
                else
                {
for(int i = 0;i < mMaxPoolSize;i++)
                    {
                        if(mPool.get(i).mDb.isInStatementCache(sql))                        
                        {
                            poolObj = mPool.get(i);
                            break;
                        } //End block
                    } //End block
                    if(poolObj == null)                    
                    {
                        if(rand == null)                        
                        {
                            rand = new Random(SystemClock.elapsedRealtime());
                        } //End block
                        poolObj = mPool.get(rand.nextInt(mMaxPoolSize));
                    } //End block
                } //End block
                db = poolObj.mDb;
            } //End block
            else
            {
                db = mParentDbObj.createPoolConnection((short)(poolSize + 1));
                poolObj = new PoolObj(db);
                mPool.add(poolSize, poolObj);
            } //End block
        } //End block
        else
        {
for(int i = 0;i < poolSize;i++)
            {
                if(mPool.get(i).isFree() && mPool.get(i).mDb.isInStatementCache(sql))                
                {
                    poolObj = mPool.get(i);
                    break;
                } //End block
            } //End block
            if(poolObj == null)            
            {
for(int i = 0;i < poolSize;i++)
                {
                    if(mPool.get(i).isFree())                    
                    {
                        poolObj = mPool.get(i);
                        break;
                    } //End block
                } //End block
            } //End block
            db = poolObj.mDb;
        } //End block
        poolObj.acquire();
        if(Log.isLoggable(TAG, Log.DEBUG))        
        {
            Log.d(TAG, "END get-connection: " + toString() + poolObj.toString());
        } //End block
SQLiteDatabase var2F732BA7E0C8A6B94C1D7B25B6A078BE_2114648838 =         db;
        var2F732BA7E0C8A6B94C1D7B25B6A078BE_2114648838.addTaint(taint);
        return var2F732BA7E0C8A6B94C1D7B25B6A078BE_2114648838;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.136 -0400", hash_original_method = "C508883C202336989018472FC420E1EA", hash_generated_method = "F5DAFAD1ACE845079D92D76C2986FA79")
    synchronized void release(SQLiteDatabase db) {
        addTaint(db.getTaint());
        if(Log.isLoggable(TAG, Log.DEBUG))        
        {
            doAsserts();
        } //End block
        PoolObj poolObj = mPool.get(db.mConnectionNum - 1);
        if(Log.isLoggable(TAG, Log.DEBUG))        
        {
            Log.d(TAG, "BEGIN release-conn: " + toString() + poolObj.toString());
        } //End block
        if(poolObj.isFree())        
        {
            IllegalStateException var86AA019ED02B9EB1FB277029C6C2821D_1689956996 = new IllegalStateException("Releasing object already freed: " +
                    db.mConnectionNum);
            var86AA019ED02B9EB1FB277029C6C2821D_1689956996.addTaint(taint);
            throw var86AA019ED02B9EB1FB277029C6C2821D_1689956996;
        } //End block
        poolObj.release();
        if(Log.isLoggable(TAG, Log.DEBUG))        
        {
            Log.d(TAG, "END release-conn: " + toString() + poolObj.toString());
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.137 -0400", hash_original_method = "D267C5BE0AC41A86583B003ED8AE5C35", hash_generated_method = "20B431BD11A0E335C75B66FCF2356EA7")
    synchronized ArrayList<SQLiteDatabase> getConnectionList() {
        ArrayList<SQLiteDatabase> list = new ArrayList<SQLiteDatabase>();
for(int i = mPool.size() - 1;i >= 0;i--)
        {
            list.add(mPool.get(i).mDb);
        } //End block
ArrayList<SQLiteDatabase> varED12C351C2E8CA4F85F097DDC7E77B4D_1198855045 =         list;
        varED12C351C2E8CA4F85F097DDC7E77B4D_1198855045.addTaint(taint);
        return varED12C351C2E8CA4F85F097DDC7E77B4D_1198855045;
        // ---------- Original Method ----------
        //ArrayList<SQLiteDatabase> list = new ArrayList<SQLiteDatabase>();
        //for (int i = mPool.size() - 1; i >= 0; i--) {
            //list.add(mPool.get(i).mDb);
        //}
        //return list;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.137 -0400", hash_original_method = "FCCC68E0BE173C0DC0076E45C706F445", hash_generated_method = "71B83AF5834DDF4C42DDACDE340190BE")
     int getFreePoolSize() {
        int count = 0;
for(int i = mPool.size() - 1;i >= 0;i--)
        {
            if(mPool.get(i).isFree())            
            {
                count++;
            } //End block
        } //End block
        int varD676675D81EFB6DCF67814B2BE42B3B8_333451081 = (count++);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1347538494 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1347538494;
        // ---------- Original Method ----------
        //int count = 0;
        //for (int i = mPool.size() - 1; i >= 0; i--) {
            //if (mPool.get(i).isFree()) {
                //count++;
            //}
        //}
        //return count++;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.138 -0400", hash_original_method = "94796DA212EFDAF0BC89ABDE3263411C", hash_generated_method = "9B4464315F1C999CA287CA8A4E1E82C6")
     ArrayList<PoolObj> getPool() {
ArrayList<PoolObj> varB4506CA02789EEFE1322E696990510A4_1488361759 =         mPool;
        varB4506CA02789EEFE1322E696990510A4_1488361759.addTaint(taint);
        return varB4506CA02789EEFE1322E696990510A4_1488361759;
        // ---------- Original Method ----------
        //return mPool;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.139 -0400", hash_original_method = "9BBFDBA2A96C9EEA2C362B37886D3C5D", hash_generated_method = "82AB4D0E1480320DD306FCEFAFCEF14D")
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
for(PoolObj p : mPool)
        {
            buff.append("\n");
            buff.append(p.toString());
        } //End block
String varA8F8BFF7B1F2F52B225C2C2411606CA3_1991099664 =         buff.toString();
        varA8F8BFF7B1F2F52B225C2C2411606CA3_1991099664.addTaint(taint);
        return varA8F8BFF7B1F2F52B225C2C2411606CA3_1991099664;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.139 -0400", hash_original_method = "8B6A0047A202C3A27DBFDE3CD809337B", hash_generated_method = "77C1B699DA78CB73993DB6036DAEE561")
    private void doAsserts() {
for(int i = 0;i < mPool.size();i++)
        {
            mPool.get(i).verify();
        } //End block
        // ---------- Original Method ----------
        //for (int i = 0; i < mPool.size(); i++) {
            //mPool.get(i).verify();
            //assert mPool.get(i).mDb.mConnectionNum == (i + 1);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.140 -0400", hash_original_method = "96488BAB5A39A9E992D6669775E5CBE2", hash_generated_method = "9D4509CE641891DA5CEC26B706A255AF")
    synchronized void setMaxPoolSize(int size) {
        mMaxPoolSize = size;
        // ---------- Original Method ----------
        //mMaxPoolSize = size;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.141 -0400", hash_original_method = "A46AC3F11215B4A1E1FF85A064F0CFC1", hash_generated_method = "E2746A3095C813A2B84538CC50F1992D")
    synchronized int getMaxPoolSize() {
        int varE09C7B9591348137B71BF1DB7F072E31_1949507518 = (mMaxPoolSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2133952051 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2133952051;
        // ---------- Original Method ----------
        //return mMaxPoolSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.141 -0400", hash_original_method = "EE241D81DC808707D5F785FD2863CDE3", hash_generated_method = "66C701FDE32383F7A05F0CE114314757")
     boolean isDatabaseObjFree(SQLiteDatabase db) {
        addTaint(db.getTaint());
        boolean var5DEA20A71EE431AD3C1F2E172820BE06_2132839825 = (mPool.get(db.mConnectionNum - 1).isFree());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_514351160 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_514351160;
        // ---------- Original Method ----------
        //return mPool.get(db.mConnectionNum - 1).isFree();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.142 -0400", hash_original_method = "CEDD9D91870F2CDCC14A9842125741BE", hash_generated_method = "2D1AEBEB786F67C5D9B5D7A176B8B766")
     int getSize() {
        int var945EC9F080E24881B59692063D2865DE_800567093 = (mPool.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1775960268 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1775960268;
        // ---------- Original Method ----------
        //return mPool.size();
    }

    
    static class PoolObj {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.142 -0400", hash_original_field = "2C1EEFAAB431F1A18FBAAB2A87866E85", hash_generated_field = "92D26B03BAC08A535924894FFC21F4C1")

        private SQLiteDatabase mDb;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.142 -0400", hash_original_field = "104472608290748D816A6C07B2880048", hash_generated_field = "1F70E86597E6AA266596A89FFFE3A0B1")

        private boolean mFreeBusyFlag = FREE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.142 -0400", hash_original_field = "4A6A4A2228837A3EFA044106F58FECB5", hash_generated_field = "FF81CB096E95719A97BE9903BC741745")

        private int mNumHolders = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.143 -0400", hash_original_field = "38B23B32824C5446EA08DC3CB0CE5726", hash_generated_field = "25A1DD62940277CC7CAA21B9DBF3C46E")

        private HashSet<Long> mHolderIds = new HashSet<Long>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.143 -0400", hash_original_method = "DC316C09CB4059B013C925E31D9707E2", hash_generated_method = "C727BF994E820394181F7F366C811F68")
        public  PoolObj(SQLiteDatabase db) {
            mDb = db;
            // ---------- Original Method ----------
            //mDb = db;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.144 -0400", hash_original_method = "45198477A389ECAEEDC0006E6891DF34", hash_generated_method = "F7534B4562044B2F9E882537D42D3807")
        private synchronized void acquire() {
            if(Log.isLoggable(TAG, Log.DEBUG))            
            {
                long id = Thread.currentThread().getId();
                mHolderIds.add(id);
            } //End block
            mNumHolders++;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.144 -0400", hash_original_method = "AE7C5C4381BC6984ACC18DB5CB72EB59", hash_generated_method = "8873B8B0FCDF6106A3D7D5A951D3C338")
        private synchronized void release() {
            if(Log.isLoggable(TAG, Log.DEBUG))            
            {
                long id = Thread.currentThread().getId();
                mHolderIds.remove(id);
            } //End block
            mNumHolders--;
            if(mNumHolders == 0)            
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.145 -0400", hash_original_method = "789BC5D306614F739870740EDEE72A08", hash_generated_method = "56BA1E993BF21D718E089AEFBC1E0468")
        private synchronized boolean isFree() {
            if(Log.isLoggable(TAG, Log.DEBUG))            
            {
                verify();
            } //End block
            boolean varCBA7543F51647F6046E3FFE5E58A1CA5_2132081378 = ((mFreeBusyFlag == FREE));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_413272765 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_413272765;
            // ---------- Original Method ----------
            //if (Log.isLoggable(TAG, Log.DEBUG)) {
                //verify();
            //}
            //return (mFreeBusyFlag == FREE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.145 -0400", hash_original_method = "55CDA36173BE763B72AF18BF479F1305", hash_generated_method = "3EE20EE305535CA4A83FE4585D8E99A5")
        private synchronized void verify() {
            if(mFreeBusyFlag == FREE)            
            {
            } //End block
            else
            {
            } //End block
            // ---------- Original Method ----------
            //if (mFreeBusyFlag == FREE) {
                //assert mNumHolders == 0;
            //} else {
                //assert mNumHolders > 0;
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.146 -0400", hash_original_method = "16D989C7D844FEE29812B797BE2CFCD6", hash_generated_method = "1285FE0B32C197E344F2224B41F79530")
        synchronized int getNumHolders() {
            int varB8F40214A10D489952B71239BFD4B30C_1697655318 = (mNumHolders);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_699008033 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_699008033;
            // ---------- Original Method ----------
            //return mNumHolders;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.146 -0400", hash_original_method = "6B148DC19CAC05BE88274109F5158F0D", hash_generated_method = "A065688496972A70AC55B69D76817A17")
        @Override
        public String toString() {
            StringBuilder buff = new StringBuilder();
            buff.append(", conn # ");
            buff.append(mDb.mConnectionNum);
            buff.append(", mCountHolders = ");
            synchronized
(this)            {
                buff.append(mNumHolders);
                buff.append(", freeBusyFlag = ");
                buff.append(mFreeBusyFlag);
for(Long l : mHolderIds)
                {
                    buff.append(", id = " + l);
                } //End block
            } //End block
String varA8F8BFF7B1F2F52B225C2C2411606CA3_1716239749 =             buff.toString();
            varA8F8BFF7B1F2F52B225C2C2411606CA3_1716239749.addTaint(taint);
            return varA8F8BFF7B1F2F52B225C2C2411606CA3_1716239749;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.146 -0400", hash_original_field = "5225948491C0BC6C574CDC802AA03B1F", hash_generated_field = "3E252BD97600562FDA798CEE6D61D62F")

        private static final boolean FREE = true;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.147 -0400", hash_original_field = "F6FA0FB62361E0E94DAD7A0B25A19298", hash_generated_field = "95E2AC55156607626DFBEE0C02F9BE1A")

        private static final boolean BUSY = false;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.147 -0400", hash_original_field = "616D3F6306688F4F772D0E3578FA8FC0", hash_generated_field = "6C058760B23A5C13D7BB739FC64924DB")

    private static final String TAG = "DatabaseConnectionPool";
}

