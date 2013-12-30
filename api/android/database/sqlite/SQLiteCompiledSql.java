package android.database.sqlite;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.StrictMode;





class SQLiteCompiledSql {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:42.578 -0500", hash_original_field = "3A24461A013C94D7BA13623586A33758", hash_generated_field = "A53F7A6D67993B059CF1B45EC860B911")


    private static final String TAG = "SQLiteCompiledSql";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:42.580 -0500", hash_original_field = "AC0A81ABC82A618858F7E54D51784ED6", hash_generated_field = "73D1AC952D2B4C5623C43496E686F020")

    /* package */  SQLiteDatabase mDatabase;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:42.582 -0500", hash_original_field = "8BF79E4EB0813672F4D3D9C26E53F6B8", hash_generated_field = "A1CC52616FC90678C25CDB441BCF31A3")

    /* package */  int nHandle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:42.584 -0500", hash_original_field = "FE57180650E70C9EF2338A3A99AA1DA9", hash_generated_field = "0B7890D0DD71DE53FEBF1209A313A527")

    /* package */ int nStatement = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:42.586 -0500", hash_original_field = "5867C84921840102A9BF805D62E888CE", hash_generated_field = "B81E2364CA79F3120E8C50C5B5211504")

    private String mSqlStmt = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:42.588 -0500", hash_original_field = "05D6976C836A3613529DB18CD3C40A23", hash_generated_field = "7D1AA4359A52B133BFAD994AB60E8C14")

    private  Throwable mStackTrace;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:42.591 -0500", hash_original_field = "05C189D36F55B0DE335EE68D98FC7073", hash_generated_field = "17073FE6795C3D40106C41971C0D9256")

    private boolean mInUse = false;

    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:42.594 -0500", hash_original_method = "C9E5BB8A7566B989DACB4531BB979B78", hash_generated_method = "C9E5BB8A7566B989DACB4531BB979B78")
    
SQLiteCompiledSql(SQLiteDatabase db, String sql) {
        db.verifyDbIsOpen();
        db.verifyLockOwner();
        mDatabase = db;
        mSqlStmt = sql;
        if (StrictMode.vmSqliteObjectLeaksEnabled()) {
            mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
        } else {
            mStackTrace = null;
        }
        nHandle = db.mNativeHandle;
        native_compile(sql);
    }

    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:42.596 -0500", hash_original_method = "8853AA921C334D6AF9AE7213FF2A5D13", hash_generated_method = "AA3BACD8E1FD7E2C98E611F4CBDF1144")
    
void releaseSqlStatement() {
        // Note that native_finalize() checks to make sure that nStatement is
        // non-null before destroying it.
        if (nStatement != 0) {
            mDatabase.finalizeStatementLater(nStatement);
            nStatement = 0;
        }
    }

    /**
     * returns true if acquire() succeeds. false otherwise.
     */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:42.599 -0500", hash_original_method = "C3D2A814A65F76D9CB9F5D4B410FE699", hash_generated_method = "01B6F55405376AEEAD12C5FED208DC0A")
    
synchronized boolean acquire() {
        if (mInUse) {
            // it is already in use.
            return false;
        }
        mInUse = true;
        return true;
    }

    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:42.601 -0500", hash_original_method = "3B98FAB5CC48492CB208B835B8A64CFB", hash_generated_method = "489B127412461E42875B7CC63433FFAB")
    
synchronized void release() {
        mInUse = false;
    }

    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:42.604 -0500", hash_original_method = "AE3D09E3B5AB69E4329FBD89B4473FE6", hash_generated_method = "EC0B650A5BC83E75101F379BEC6CEBD3")
    
synchronized void releaseIfNotInUse() {
        // if it is not in use, release its memory from the database
        if (!mInUse) {
            releaseSqlStatement();
        }
    }

    /**
     * Make sure that the native resource is cleaned up.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:42.607 -0500", hash_original_method = "043FE176FAAAC79BBB94A20B9880CE43", hash_generated_method = "5AC1A6DFD2D7AED3F5003A1B3C44B240")
    
@Override
    protected void finalize() throws Throwable {
        try {
            if (nStatement == 0) return;
            // don't worry about finalizing this object if it is ALREADY in the
            // queue of statements to be finalized later
            if (mDatabase.isInQueueOfStatementsToBeFinalized(nStatement)) {
                return;
            }
            // finalizer should NEVER get called
            // but if the database itself is not closed and is GC'ed, then
            // all sub-objects attached to the database could end up getting GC'ed too.
            // in that case, don't print any warning.
            if (mInUse && mStackTrace != null) {
                int len = mSqlStmt.length();
                StrictMode.onSqliteObjectLeaked(
                    "Releasing statement in a finalizer. Please ensure " +
                    "that you explicitly call close() on your cursor: " +
                    mSqlStmt.substring(0, (len > 1000) ? 1000 : len),
                    mStackTrace);
            }
            releaseSqlStatement();
        } finally {
            super.finalize();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:42.609 -0500", hash_original_method = "F4C9B6A641BE298F80672A4BBE3F197C", hash_generated_method = "2CB70B5850AA96ED0046D5F3FE57F678")
    
@Override public String toString() {
        synchronized(this) {
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
            return buff.toString();
        }
    }

    /**
     * Compiles SQL into a SQLite program.
     *
     * <P>The database lock must be held when calling this method.
     * @param sql The SQL to compile.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:42.614 -0500", hash_original_method = "957AE60D3A9CE570CB89C0AA6C75F6C8", hash_generated_method = "2B124FEB513D2470D3DA6C6DFDC1125F")
    
    private final void native_compile(String sql){
    	//Formerly a native method
    	addTaint(sql.getTaint());
    }

}

