package android.database.sqlite;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

class DatabaseConnectionPool {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.089 -0400", hash_original_field = "60CF7A6EA37051AFA5579BFF259593F0", hash_generated_field = "6DB5215553C1840CAEC8065EEA2DFF1E")

    private volatile int mMaxPoolSize = Resources.getSystem().getInteger(com.android.internal.R.integer.db_connection_pool_size);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.090 -0400", hash_original_field = "12B157B7C91520FB14A4B196CCE78F51", hash_generated_field = "18B787FE623D5F75DA1743A19683143E")

    private final ArrayList<PoolObj> mPool = new ArrayList<PoolObj>(mMaxPoolSize);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.090 -0400", hash_original_field = "2C90046C1A99E452326AB92D99B81C31", hash_generated_field = "6A70A90B4FFE8ED9A2AB9CBA8BB34AB9")

    private SQLiteDatabase mParentDbObj;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.090 -0400", hash_original_field = "34D1C35063280164066ECC517050DA0B", hash_generated_field = "0246BE72854112F07DA372D7CE27006A")

    private Random rand;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.090 -0400", hash_original_method = "642674B3CBAE34C61C10ECDA81AF12DF", hash_generated_method = "1CAC48F6FC7606C2C28B39B6C03F0B43")
      DatabaseConnectionPool(SQLiteDatabase db) {
        this.mParentDbObj = db;
        {
            boolean var7061DF8A5335B809C796044C2A062407_98462310 = (Log.isLoggable(TAG, Log.DEBUG));
            {
                Log.d(TAG, "Max Pool Size: " + mMaxPoolSize);
            } 
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.091 -0400", hash_original_method = "BA169038399FE60257FEACB6F83742BB", hash_generated_method = "2C96F6090842E5B42D9C86C272D19E7F")
    synchronized void close() {
        {
            boolean var7061DF8A5335B809C796044C2A062407_1560545723 = (Log.isLoggable(TAG, Log.DEBUG));
            {
                Log.d(TAG, "Closing the connection pool on " + mParentDbObj.getPath() + toString());
            } 
        } 
        {
            int i = mPool.size() - 1;
            {
                mPool.get(i).mDb.close();
            } 
        } 
        mPool.clear();
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.093 -0400", hash_original_method = "29479C12BC42199BDE721BCCF404E99A", hash_generated_method = "E7F90338B20EA4F9B6D8BD3EAE6AA0D4")
    synchronized SQLiteDatabase get(String sql) {
        SQLiteDatabase varB4EAC82CA7396A68D541C85D26508E83_662799551 = null; 
        SQLiteDatabase db = null;
        PoolObj poolObj = null;
        int poolSize = mPool.size();
        {
            boolean var7061DF8A5335B809C796044C2A062407_346300136 = (Log.isLoggable(TAG, Log.DEBUG));
            {
                doAsserts();
            } 
        } 
        {
            boolean var9B1D07D25E4500725BE2762D29331B41_835011691 = (getFreePoolSize() == 0);
            {
                {
                    {
                        poolObj = mPool.get(0);
                    } 
                    {
                        {
                            int i = 0;
                            {
                                {
                                    boolean var319607DB85374E6772E2EF345FC32D08_923057484 = (mPool.get(i).mDb.isInStatementCache(sql));
                                    {
                                        poolObj = mPool.get(i);
                                    } 
                                } 
                            } 
                        } 
                        {
                            {
                                rand = new Random(SystemClock.elapsedRealtime());
                            } 
                            poolObj = mPool.get(rand.nextInt(mMaxPoolSize));
                        } 
                    } 
                    db = poolObj.mDb;
                } 
                {
                    db = mParentDbObj.createPoolConnection((short)(poolSize + 1));
                    poolObj = new PoolObj(db);
                    mPool.add(poolSize, poolObj);
                } 
            } 
            {
                {
                    int i = 0;
                    {
                        {
                            boolean varBCF331DAA437C07B9E1DC7F5A9576EA7_540370485 = (mPool.get(i).isFree() && mPool.get(i).mDb.isInStatementCache(sql));
                            {
                                poolObj = mPool.get(i);
                            } 
                        } 
                    } 
                } 
                {
                    {
                        int i = 0;
                        {
                            {
                                boolean var58C433B19A8B81690E11AB44135FE75C_919793289 = (mPool.get(i).isFree());
                                {
                                    poolObj = mPool.get(i);
                                } 
                            } 
                        } 
                    } 
                } 
                db = poolObj.mDb;
            } 
        } 
        poolObj.acquire();
        {
            boolean var7061DF8A5335B809C796044C2A062407_1545411635 = (Log.isLoggable(TAG, Log.DEBUG));
            {
                Log.d(TAG, "END get-connection: " + toString() + poolObj.toString());
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_662799551 = db;
        addTaint(sql.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_662799551.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_662799551;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.094 -0400", hash_original_method = "C508883C202336989018472FC420E1EA", hash_generated_method = "4C034D207F4C86A2067F5B516B8302C5")
    synchronized void release(SQLiteDatabase db) {
        {
            boolean var7061DF8A5335B809C796044C2A062407_1190566996 = (Log.isLoggable(TAG, Log.DEBUG));
            {
                doAsserts();
            } 
        } 
        PoolObj poolObj = mPool.get(db.mConnectionNum - 1);
        {
            boolean var7061DF8A5335B809C796044C2A062407_448794401 = (Log.isLoggable(TAG, Log.DEBUG));
            {
                Log.d(TAG, "BEGIN release-conn: " + toString() + poolObj.toString());
            } 
        } 
        {
            boolean varD844887BCF703DE90E24EEEBA4E5F37C_1327896219 = (poolObj.isFree());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Releasing object already freed: " +
                    db.mConnectionNum);
            } 
        } 
        poolObj.release();
        {
            boolean var7061DF8A5335B809C796044C2A062407_524115095 = (Log.isLoggable(TAG, Log.DEBUG));
            {
                Log.d(TAG, "END release-conn: " + toString() + poolObj.toString());
            } 
        } 
        addTaint(db.getTaint());
        
        
            
            
            
        
        
        
            
        
        
            
                    
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.095 -0400", hash_original_method = "D267C5BE0AC41A86583B003ED8AE5C35", hash_generated_method = "FBEB39815C024EF6CB0C8C8D22277CCA")
    synchronized ArrayList<SQLiteDatabase> getConnectionList() {
        ArrayList<SQLiteDatabase> varB4EAC82CA7396A68D541C85D26508E83_1985993242 = null; 
        ArrayList<SQLiteDatabase> list = new ArrayList<SQLiteDatabase>();
        {
            int i = mPool.size() - 1;
            {
                list.add(mPool.get(i).mDb);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1985993242 = list;
        varB4EAC82CA7396A68D541C85D26508E83_1985993242.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1985993242;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.095 -0400", hash_original_method = "FCCC68E0BE173C0DC0076E45C706F445", hash_generated_method = "E849EE778F84A858526FB8C13E78A691")
     int getFreePoolSize() {
        int count = 0;
        {
            int i = mPool.size() - 1;
            {
                {
                    boolean var6EFA29D66A5AE03A39596A10625232FD_1893899457 = (mPool.get(i).isFree());
                } 
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_328331245 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_328331245;
        
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.096 -0400", hash_original_method = "94796DA212EFDAF0BC89ABDE3263411C", hash_generated_method = "4879D8A2524B4779DAB3E74B623512B3")
     ArrayList<PoolObj> getPool() {
        ArrayList<PoolObj> varB4EAC82CA7396A68D541C85D26508E83_1318284326 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1318284326 = mPool;
        varB4EAC82CA7396A68D541C85D26508E83_1318284326.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1318284326;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.102 -0400", hash_original_method = "9BBFDBA2A96C9EEA2C362B37886D3C5D", hash_generated_method = "C1453FBBAC240626E8FE712502CD3A3F")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2044607846 = null; 
        StringBuilder buff = new StringBuilder();
        buff.append("db: ");
        buff.append(mParentDbObj.getPath());
        buff.append(", totalsize = ");
        buff.append(mPool.size());
        buff.append(", #free = ");
        buff.append(getFreePoolSize());
        buff.append(", maxpoolsize = ");
        buff.append(mMaxPoolSize);
        {
            Iterator<PoolObj> varCCA2E604ADC040E096C584C6F35D4EE4_830415151 = (mPool).iterator();
            varCCA2E604ADC040E096C584C6F35D4EE4_830415151.hasNext();
            PoolObj p = varCCA2E604ADC040E096C584C6F35D4EE4_830415151.next();
            {
                buff.append("\n");
                buff.append(p.toString());
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2044607846 = buff.toString();
        varB4EAC82CA7396A68D541C85D26508E83_2044607846.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2044607846;
        
        
        
        
        
        
        
        
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.103 -0400", hash_original_method = "8B6A0047A202C3A27DBFDE3CD809337B", hash_generated_method = "73B92839C89ADE35EBD39C34A71DEBC0")
    private void doAsserts() {
        {
            int i = 0;
            boolean var54BC86BAC9CE390930BD89A6719C890C_425661240 = (i < mPool.size());
            {
                mPool.get(i).verify();
            } 
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.103 -0400", hash_original_method = "96488BAB5A39A9E992D6669775E5CBE2", hash_generated_method = "9D4509CE641891DA5CEC26B706A255AF")
    synchronized void setMaxPoolSize(int size) {
        mMaxPoolSize = size;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.104 -0400", hash_original_method = "A46AC3F11215B4A1E1FF85A064F0CFC1", hash_generated_method = "64235ACF38F33318115E0FF2252289E4")
    synchronized int getMaxPoolSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1367700038 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1367700038;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.104 -0400", hash_original_method = "EE241D81DC808707D5F785FD2863CDE3", hash_generated_method = "AA75BB72201C4535CDE4D726B1963B06")
     boolean isDatabaseObjFree(SQLiteDatabase db) {
        boolean varE763731B50FB2D0B9F176636A3724F75_1434387288 = (mPool.get(db.mConnectionNum - 1).isFree());
        addTaint(db.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_696941914 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_696941914;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.105 -0400", hash_original_method = "CEDD9D91870F2CDCC14A9842125741BE", hash_generated_method = "6AE9F7E9076E5D9698BD6FED522BBBE6")
     int getSize() {
        int var592A56EFB728CEDE41CBCA444E33C6A9_1028027431 = (mPool.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_330292086 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_330292086;
        
        
    }

    
    static class PoolObj {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.105 -0400", hash_original_field = "2C1EEFAAB431F1A18FBAAB2A87866E85", hash_generated_field = "92D26B03BAC08A535924894FFC21F4C1")

        private SQLiteDatabase mDb;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.105 -0400", hash_original_field = "104472608290748D816A6C07B2880048", hash_generated_field = "1F70E86597E6AA266596A89FFFE3A0B1")

        private boolean mFreeBusyFlag = FREE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.106 -0400", hash_original_field = "4A6A4A2228837A3EFA044106F58FECB5", hash_generated_field = "FF81CB096E95719A97BE9903BC741745")

        private int mNumHolders = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.106 -0400", hash_original_field = "38B23B32824C5446EA08DC3CB0CE5726", hash_generated_field = "25A1DD62940277CC7CAA21B9DBF3C46E")

        private HashSet<Long> mHolderIds = new HashSet<Long>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.107 -0400", hash_original_method = "DC316C09CB4059B013C925E31D9707E2", hash_generated_method = "C727BF994E820394181F7F366C811F68")
        public  PoolObj(SQLiteDatabase db) {
            mDb = db;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.107 -0400", hash_original_method = "45198477A389ECAEEDC0006E6891DF34", hash_generated_method = "6845A2584A0EF992434BBD2EA175C37B")
        private synchronized void acquire() {
            {
                boolean varF062350F2983BA11C030C10A71A73C26_1038905535 = (Log.isLoggable(TAG, Log.DEBUG));
                {
                    long id = Thread.currentThread().getId();
                    mHolderIds.add(id);
                } 
            } 
            mFreeBusyFlag = BUSY;
            
            
                
                
                
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.108 -0400", hash_original_method = "AE7C5C4381BC6984ACC18DB5CB72EB59", hash_generated_method = "2C1EFAAFC11FD4820A2EE4AFC245460C")
        private synchronized void release() {
            {
                boolean varF062350F2983BA11C030C10A71A73C26_682598711 = (Log.isLoggable(TAG, Log.DEBUG));
                {
                    long id = Thread.currentThread().getId();
                    mHolderIds.remove(id);
                } 
            } 
            {
                mFreeBusyFlag = FREE;
            } 
            
            
                
                
                
                
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.108 -0400", hash_original_method = "789BC5D306614F739870740EDEE72A08", hash_generated_method = "6C827695EFFB334B0807A50E42CBC21C")
        private synchronized boolean isFree() {
            {
                boolean varF062350F2983BA11C030C10A71A73C26_1778445409 = (Log.isLoggable(TAG, Log.DEBUG));
                {
                    verify();
                } 
            } 
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_697599345 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_697599345;
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.108 -0400", hash_original_method = "55CDA36173BE763B72AF18BF479F1305", hash_generated_method = "D870C0B48C8F780AB14EAB37DCC5B591")
        private synchronized void verify() {
            
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.109 -0400", hash_original_method = "16D989C7D844FEE29812B797BE2CFCD6", hash_generated_method = "7F2E6F8B5960BDE881F1546738CACCA2")
        synchronized int getNumHolders() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1643284459 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1643284459;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.117 -0400", hash_original_method = "6B148DC19CAC05BE88274109F5158F0D", hash_generated_method = "CEA3E8A1FD28440BA3FC698748C7C3C7")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_848306929 = null; 
            StringBuilder buff = new StringBuilder();
            buff.append(", conn # ");
            buff.append(mDb.mConnectionNum);
            buff.append(", mCountHolders = ");
            {
                buff.append(mNumHolders);
                buff.append(", freeBusyFlag = ");
                buff.append(mFreeBusyFlag);
                {
                    Iterator<Long> var0E6E6B9552BE314E653CCAB776377B09_1485567600 = (mHolderIds).iterator();
                    var0E6E6B9552BE314E653CCAB776377B09_1485567600.hasNext();
                    Long l = var0E6E6B9552BE314E653CCAB776377B09_1485567600.next();
                    {
                        buff.append(", id = " + l);
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_848306929 = buff.toString();
            varB4EAC82CA7396A68D541C85D26508E83_848306929.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_848306929;
            
            
            
            
            
            
                
                
                
                
                    
                
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.118 -0400", hash_original_field = "5225948491C0BC6C574CDC802AA03B1F", hash_generated_field = "3E252BD97600562FDA798CEE6D61D62F")

        private static final boolean FREE = true;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.118 -0400", hash_original_field = "F6FA0FB62361E0E94DAD7A0B25A19298", hash_generated_field = "95E2AC55156607626DFBEE0C02F9BE1A")

        private static final boolean BUSY = false;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.118 -0400", hash_original_field = "616D3F6306688F4F772D0E3578FA8FC0", hash_generated_field = "6C058760B23A5C13D7BB739FC64924DB")

    private static final String TAG = "DatabaseConnectionPool";
}

