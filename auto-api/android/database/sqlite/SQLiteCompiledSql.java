package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.StrictMode;
import android.util.Log;

class SQLiteCompiledSql {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.446 -0400", hash_original_field = "8C0B67E1F99496AB4CD09433C231BEB3", hash_generated_field = "AC0A81ABC82A618858F7E54D51784ED6")

    SQLiteDatabase mDatabase;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.447 -0400", hash_original_field = "83BEE6D182A8A0F703AE0355A9CE0E10", hash_generated_field = "8BF79E4EB0813672F4D3D9C26E53F6B8")

    int nHandle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.447 -0400", hash_original_field = "BA87FDEE2E7AA6456AD5BA42003403BD", hash_generated_field = "FE57180650E70C9EF2338A3A99AA1DA9")

    int nStatement = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.447 -0400", hash_original_field = "2C32D48E94476CFDBCFAAC89733E1B06", hash_generated_field = "B81E2364CA79F3120E8C50C5B5211504")

    private String mSqlStmt = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.447 -0400", hash_original_field = "9581B90EA40AE59A20069CB826265080", hash_generated_field = "7D1AA4359A52B133BFAD994AB60E8C14")

    private Throwable mStackTrace;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.447 -0400", hash_original_field = "65BFF43B7B1D9BD1E2B8EAE280F6029C", hash_generated_field = "17073FE6795C3D40106C41971C0D9256")

    private boolean mInUse = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.460 -0400", hash_original_method = "C9E5BB8A7566B989DACB4531BB979B78", hash_generated_method = "45115BDCC1745791FF435D2D8B9C8BCE")
      SQLiteCompiledSql(SQLiteDatabase db, String sql) {
        db.verifyDbIsOpen();
        db.verifyLockOwner();
        mDatabase = db;
        mSqlStmt = sql;
        {
            boolean varBD0BED841C7A62596CB2EE0AC9816352_768060045 = (StrictMode.vmSqliteObjectLeaksEnabled());
            {
                mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
            } //End block
            {
                mStackTrace = null;
            } //End block
        } //End collapsed parenthetic
        nHandle = db.mNativeHandle;
        native_compile(sql);
        // ---------- Original Method ----------
        //db.verifyDbIsOpen();
        //db.verifyLockOwner();
        //mDatabase = db;
        //mSqlStmt = sql;
        //if (StrictMode.vmSqliteObjectLeaksEnabled()) {
            //mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
        //} else {
            //mStackTrace = null;
        //}
        //nHandle = db.mNativeHandle;
        //native_compile(sql);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.463 -0400", hash_original_method = "8853AA921C334D6AF9AE7213FF2A5D13", hash_generated_method = "5EDE82FAD3450DB1D3333765C725F941")
     void releaseSqlStatement() {
        {
            mDatabase.finalizeStatementLater(nStatement);
            nStatement = 0;
        } //End block
        // ---------- Original Method ----------
        //if (nStatement != 0) {
            //mDatabase.finalizeStatementLater(nStatement);
            //nStatement = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.479 -0400", hash_original_method = "C3D2A814A65F76D9CB9F5D4B410FE699", hash_generated_method = "5E0B20EE8A5B84C8E84A034D6659EB47")
    synchronized boolean acquire() {
        mInUse = true;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2119449324 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2119449324;
        // ---------- Original Method ----------
        //if (mInUse) {
            //return false;
        //}
        //mInUse = true;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.480 -0400", hash_original_method = "3B98FAB5CC48492CB208B835B8A64CFB", hash_generated_method = "1D65CE2608C808F3D02CFA088AEF5382")
    synchronized void release() {
        mInUse = false;
        // ---------- Original Method ----------
        //mInUse = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.480 -0400", hash_original_method = "AE3D09E3B5AB69E4329FBD89B4473FE6", hash_generated_method = "70D57804978106FAAE49AD6899F4EA80")
    synchronized void releaseIfNotInUse() {
        {
            releaseSqlStatement();
        } //End block
        // ---------- Original Method ----------
        //if (!mInUse) {
            //releaseSqlStatement();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.482 -0400", hash_original_method = "043FE176FAAAC79BBB94A20B9880CE43", hash_generated_method = "F49A3959A3FD0AB3AC21049F506A196F")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            {
                boolean var0AA99A08D31F00E7A6817224CB16C1C3_497387890 = (mDatabase.isInQueueOfStatementsToBeFinalized(nStatement));
            } //End collapsed parenthetic
            {
                int len;
                len = mSqlStmt.length();
                StrictMode.onSqliteObjectLeaked(
                    "Releasing statement in a finalizer. Please ensure " +
                    "that you explicitly call close() on your cursor: " +
                    mSqlStmt.substring(0, (len > 1000) ? 1000 : len),
                    mStackTrace);
            } //End block
            releaseSqlStatement();
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //if (nStatement == 0) return;
            //if (mDatabase.isInQueueOfStatementsToBeFinalized(nStatement)) {
                //return;
            //}
            //if (mInUse && mStackTrace != null) {
                //int len = mSqlStmt.length();
                //StrictMode.onSqliteObjectLeaked(
                    //"Releasing statement in a finalizer. Please ensure " +
                    //"that you explicitly call close() on your cursor: " +
                    //mSqlStmt.substring(0, (len > 1000) ? 1000 : len),
                    //mStackTrace);
            //}
            //releaseSqlStatement();
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.504 -0400", hash_original_method = "F4C9B6A641BE298F80672A4BBE3F197C", hash_generated_method = "9B603B21823FCCDF2E11EF8DED984630")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1619287950 = null; //Variable for return #1
        {
            StringBuilder buff;
            buff = new StringBuilder();
            buff.append(" nStatement=");
            buff.append(nStatement);
            buff.append(", mInUse=");
            buff.append(mInUse);
            buff.append(", db=");
            buff.append(mDatabase.getPath());
            buff.append(", db_connectionNum=");
            buff.append(mDatabase.mConnectionNum);
            buff.append(", sql=");
            int len;
            len = mSqlStmt.length();
            buff.append(mSqlStmt.substring(0, (len > 100) ? 100 : len));
            varB4EAC82CA7396A68D541C85D26508E83_1619287950 = buff.toString();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1619287950.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1619287950;
        // ---------- Original Method ----------
        //synchronized(this) {
            //StringBuilder buff = new StringBuilder();
            //buff.append(" nStatement=");
            //buff.append(nStatement);
            //buff.append(", mInUse=");
            //buff.append(mInUse);
            //buff.append(", db=");
            //buff.append(mDatabase.getPath());
            //buff.append(", db_connectionNum=");
            //buff.append(mDatabase.mConnectionNum);
            //buff.append(", sql=");
            //int len = mSqlStmt.length();
            //buff.append(mSqlStmt.substring(0, (len > 100) ? 100 : len));
            //return buff.toString();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.505 -0400", hash_original_method = "957AE60D3A9CE570CB89C0AA6C75F6C8", hash_generated_method = "8658583CAA11B5DE376BF83B036DBA9E")
    private final void native_compile(String sql) {
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.506 -0400", hash_original_field = "8C1CC01C4889420B5B2B872C0B799D82", hash_generated_field = "84C47D820DBFD97AC1D74E1508197089")

    private static String TAG = "SQLiteCompiledSql";
}

