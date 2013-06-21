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
    SQLiteDatabase mDatabase;
    int nHandle;
    int nStatement = 0;
    private String mSqlStmt = null;
    private Throwable mStackTrace;
    private boolean mInUse = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.279 -0400", hash_original_method = "C9E5BB8A7566B989DACB4531BB979B78", hash_generated_method = "692E8EEA05EB26F1AC31B1012CE2C2CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SQLiteCompiledSql(SQLiteDatabase db, String sql) {
        dsTaint.addTaint(db.dsTaint);
        dsTaint.addTaint(sql);
        db.verifyDbIsOpen();
        db.verifyLockOwner();
        {
            boolean varBD0BED841C7A62596CB2EE0AC9816352_92825479 = (StrictMode.vmSqliteObjectLeaksEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.279 -0400", hash_original_method = "8853AA921C334D6AF9AE7213FF2A5D13", hash_generated_method = "5EDE82FAD3450DB1D3333765C725F941")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.279 -0400", hash_original_method = "C3D2A814A65F76D9CB9F5D4B410FE699", hash_generated_method = "BD90B4EF90C485E6143351C7A627147C")
    @DSModeled(DSC.SAFE)
    synchronized boolean acquire() {
        mInUse = true;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mInUse) {
            //return false;
        //}
        //mInUse = true;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.279 -0400", hash_original_method = "3B98FAB5CC48492CB208B835B8A64CFB", hash_generated_method = "1D65CE2608C808F3D02CFA088AEF5382")
    @DSModeled(DSC.SAFE)
    synchronized void release() {
        mInUse = false;
        // ---------- Original Method ----------
        //mInUse = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.280 -0400", hash_original_method = "AE3D09E3B5AB69E4329FBD89B4473FE6", hash_generated_method = "70D57804978106FAAE49AD6899F4EA80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void releaseIfNotInUse() {
        {
            releaseSqlStatement();
        } //End block
        // ---------- Original Method ----------
        //if (!mInUse) {
            //releaseSqlStatement();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.280 -0400", hash_original_method = "043FE176FAAAC79BBB94A20B9880CE43", hash_generated_method = "9B98F2DEAFDD7B2BDC86F6C87DEEE2BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            {
                boolean var0AA99A08D31F00E7A6817224CB16C1C3_409009251 = (mDatabase.isInQueueOfStatementsToBeFinalized(nStatement));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.281 -0400", hash_original_method = "F4C9B6A641BE298F80672A4BBE3F197C", hash_generated_method = "F325F266FF2FDCDB6164934F02115B02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
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
            String var0D89C4BB0E45E7CA7BE9B5E30C3E10F7_413887410 = (buff.toString());
        } //End block
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.281 -0400", hash_original_method = "957AE60D3A9CE570CB89C0AA6C75F6C8", hash_generated_method = "27024885483B7FC0209209C9F70216DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void native_compile(String sql) {
        dsTaint.addTaint(sql);
    }

    
    private static final String TAG = "SQLiteCompiledSql";
}

