package android.database.sqlite;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.StrictMode;
import android.util.Log;

class SQLiteCompiledSql {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.144 -0400", hash_original_field = "8C0B67E1F99496AB4CD09433C231BEB3", hash_generated_field = "AC0A81ABC82A618858F7E54D51784ED6")

    SQLiteDatabase mDatabase;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.144 -0400", hash_original_field = "83BEE6D182A8A0F703AE0355A9CE0E10", hash_generated_field = "8BF79E4EB0813672F4D3D9C26E53F6B8")

    int nHandle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.144 -0400", hash_original_field = "BA87FDEE2E7AA6456AD5BA42003403BD", hash_generated_field = "FE57180650E70C9EF2338A3A99AA1DA9")

    int nStatement = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.144 -0400", hash_original_field = "2C32D48E94476CFDBCFAAC89733E1B06", hash_generated_field = "B81E2364CA79F3120E8C50C5B5211504")

    private String mSqlStmt = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.144 -0400", hash_original_field = "9581B90EA40AE59A20069CB826265080", hash_generated_field = "7D1AA4359A52B133BFAD994AB60E8C14")

    private Throwable mStackTrace;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.144 -0400", hash_original_field = "65BFF43B7B1D9BD1E2B8EAE280F6029C", hash_generated_field = "17073FE6795C3D40106C41971C0D9256")

    private boolean mInUse = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.145 -0400", hash_original_method = "C9E5BB8A7566B989DACB4531BB979B78", hash_generated_method = "2C0CEDBE8BBC9A178E56B4DA1585DB92")
      SQLiteCompiledSql(SQLiteDatabase db, String sql) {
        db.verifyDbIsOpen();
        db.verifyLockOwner();
        mDatabase = db;
        mSqlStmt = sql;
        {
            boolean varBD0BED841C7A62596CB2EE0AC9816352_654434239 = (StrictMode.vmSqliteObjectLeaksEnabled());
            {
                mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
            } 
            {
                mStackTrace = null;
            } 
        } 
        nHandle = db.mNativeHandle;
        native_compile(sql);
        
        
        
        
        
        
            
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.145 -0400", hash_original_method = "8853AA921C334D6AF9AE7213FF2A5D13", hash_generated_method = "5EDE82FAD3450DB1D3333765C725F941")
     void releaseSqlStatement() {
        {
            mDatabase.finalizeStatementLater(nStatement);
            nStatement = 0;
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.146 -0400", hash_original_method = "C3D2A814A65F76D9CB9F5D4B410FE699", hash_generated_method = "CF9E242F967A7C651E52B13B79B6ADD2")
    synchronized boolean acquire() {
        mInUse = true;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1184697587 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1184697587;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.146 -0400", hash_original_method = "3B98FAB5CC48492CB208B835B8A64CFB", hash_generated_method = "1D65CE2608C808F3D02CFA088AEF5382")
    synchronized void release() {
        mInUse = false;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.147 -0400", hash_original_method = "AE3D09E3B5AB69E4329FBD89B4473FE6", hash_generated_method = "70D57804978106FAAE49AD6899F4EA80")
    synchronized void releaseIfNotInUse() {
        {
            releaseSqlStatement();
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.147 -0400", hash_original_method = "043FE176FAAAC79BBB94A20B9880CE43", hash_generated_method = "1E1B3671FC94A0BEA99F99EE260C393B")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            {
                boolean var0AA99A08D31F00E7A6817224CB16C1C3_378584727 = (mDatabase.isInQueueOfStatementsToBeFinalized(nStatement));
            } 
            {
                int len = mSqlStmt.length();
                StrictMode.onSqliteObjectLeaked(
                    "Releasing statement in a finalizer. Please ensure " +
                    "that you explicitly call close() on your cursor: " +
                    mSqlStmt.substring(0, (len > 1000) ? 1000 : len),
                    mStackTrace);
            } 
            releaseSqlStatement();
        } 
        finally 
        {
            super.finalize();
        } 
        
        
            
            
                
            
            
                
                
                    
                    
                    
                    
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.148 -0400", hash_original_method = "F4C9B6A641BE298F80672A4BBE3F197C", hash_generated_method = "58FED6F72F7F060B225AAC6F38822E30")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_3775054 = null; 
        {
            StringBuilder buff = new StringBuilder();
            buff.append(" nStatement=");
            buff.append(nStatement);
            buff.append(", mInUse=");
            buff.append(mInUse);
            buff.append(", db=");
            buff.append(mDatabase.getPath());
            buff.append(", db_connectionNum=");
            buff.append(mDatabase.mConnectionNum);
            buff.append(", sql=");
            int len = mSqlStmt.length();
            buff.append(mSqlStmt.substring(0, (len > 100) ? 100 : len));
            varB4EAC82CA7396A68D541C85D26508E83_3775054 = buff.toString();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_3775054.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_3775054;
        
        
            
            
            
            
            
            
            
            
            
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.149 -0400", hash_original_method = "957AE60D3A9CE570CB89C0AA6C75F6C8", hash_generated_method = "8658583CAA11B5DE376BF83B036DBA9E")
    private final void native_compile(String sql) {
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.150 -0400", hash_original_field = "8C1CC01C4889420B5B2B872C0B799D82", hash_generated_field = "A53F7A6D67993B059CF1B45EC860B911")

    private static final String TAG = "SQLiteCompiledSql";
}

