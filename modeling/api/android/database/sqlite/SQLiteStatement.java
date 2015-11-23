/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.database.sqlite;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.IOException;

import android.database.DatabaseUtils;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import dalvik.system.BlockGuard;

public class SQLiteStatement extends SQLiteProgram {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.342 -0500", hash_original_field = "5D559E29F3B7D0D51AE5C73FE3F2D3F0", hash_generated_field = "B25F6A4CB29F6325E49F04F66EE5886C")

    private static final String TAG = "SQLiteStatement";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.345 -0500", hash_original_field = "E63805B0E924F8ED616216BEB6CB6005", hash_generated_field = "DF1BFFA8AE77C9EB2467DB4A53480D19")

    private static final boolean READ = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.348 -0500", hash_original_field = "FBD12BAEA28977523A9EA4EA7C38D0D0", hash_generated_field = "4E20ADB74C14AC29719A4662B74CC6FA")

    private static final boolean WRITE = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.356 -0500", hash_original_field = "7C3FC1FC837C724A2D92EB1DEE1FF582", hash_generated_field = "51E8612B8DBE387C00FDA982510BC3C4")

    private static final int TRANS_STARTED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.359 -0500", hash_original_field = "4ED2C00F9BF8DE47B9B586DFB9282DD5", hash_generated_field = "8F182F697D081190134825A0E369736C")

    private static final int LOCK_ACQUIRED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.350 -0500", hash_original_field = "F226644BA47AF122E4485EA17FD2B3BB", hash_generated_field = "2F51843A821BD5FB98E893CC1830882F")

    private SQLiteDatabase mOrigDb;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.352 -0500", hash_original_field = "7BB479D2050B776CF48FB8B4E674911B", hash_generated_field = "19B55F2750B971E6310D64ADB9B2D0CF")

    private int mState;

    /**
     * Don't use SQLiteStatement constructor directly, please use
     * {@link SQLiteDatabase#compileStatement(String)}
     * @param db
     * @param sql
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.363 -0500", hash_original_method = "5DDFF8C2B7E2F1702052BA1709F992B7", hash_generated_method = "B9E4508E756E5A8384F3CA53B674C040")
    
SQLiteStatement(SQLiteDatabase db, String sql, Object[] bindArgs) {
        super(db, sql, bindArgs, false /* don't compile sql statement */);
        this.addTaint(sql.getTaint());
        this.addTaint(bindArgs[0].toString().getTaint());
    }

    /**
     * Execute this SQL statement, if it is not a SELECT / INSERT / DELETE / UPDATE, for example
     * CREATE / DROP table, view, trigger, index etc.
     *
     * @throws android.database.SQLException If the SQL string is invalid for
     *         some reason
     */
    @DSSink({DSSinkKind.DATABASE})
    @DSSpec(DSCat.DATABASE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.366 -0500", hash_original_method = "AF1FDD5D94DA5350C3682852D1772235", hash_generated_method = "A885B32B2E08E78A2AC63B81A3B37E4B")
    
public void execute() {
        executeUpdateDelete();
    }

    /**
     * Execute this SQL statement, if the the number of rows affected by execution of this SQL
     * statement is of any importance to the caller - for example, UPDATE / DELETE SQL statements.
     *
     * @return the number of rows affected by this SQL statement execution.
     * @throws android.database.SQLException If the SQL string is invalid for
     *         some reason
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.369 -0500", hash_original_method = "66D9912335771E2036ED62B64CF3BC86", hash_generated_method = "268D0D68A247442B9D4A5C3F6F9FBAF9")
    
public int executeUpdateDelete() {
        mDatabase.addTaint(this.getTaint());
        int ret = this.getTaintInt();
        ret += mDatabase.getTaintInt();
        return ret;
        /*        
        try {
            saveSqlAsLastSqlStatement();
            acquireAndLock(WRITE);
            int numChanges = 0;
            if ((mStatementType & STATEMENT_DONT_PREPARE) > 0) {
                // since the statement doesn't have to be prepared,
                // call the following native method which will not prepare
                // the query plan
                native_executeSql(mSql);
            } else {
                numChanges = native_execute();
            }
            return numChanges;
        } finally {
            releaseAndUnlock();
        }
        */
    }

    /**
     * Execute this SQL statement and return the ID of the row inserted due to this call.
     * The SQL statement should be an INSERT for this to be a useful call.
     *
     * @return the row ID of the last row inserted, if this insert is successful. -1 otherwise.
     *
     * @throws android.database.SQLException If the SQL string is invalid for
     *         some reason
     */
    @DSComment("Database access")
    @DSSpec(DSCat.DATABASE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.373 -0500", hash_original_method = "78D2410201CEBD83C87275DB09AEC8B4", hash_generated_method = "2A4D5BD1B81B68465454108E8B5D9953")
    
public long executeInsert() {
        mDatabase.addTaint(this.getTaint());
        int ret = this.getTaintInt();
        ret += mDatabase.getTaintInt();
        return ret;
        /*
        try {
            saveSqlAsLastSqlStatement();
            acquireAndLock(WRITE);
            return native_executeInsert();
        } finally {
            releaseAndUnlock();
        }
        */
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.376 -0500", hash_original_method = "7424F80A42A729003FCB274AD124711E", hash_generated_method = "3A989A9BAE3E3173B88012F0004E7441")
    
private void saveSqlAsLastSqlStatement() {
        mDatabase.addTaint(this.getTaint());
        /*
        if (((mStatementType & SQLiteProgram.STATEMENT_TYPE_MASK) ==
                DatabaseUtils.STATEMENT_UPDATE) ||
                (mStatementType & SQLiteProgram.STATEMENT_TYPE_MASK) ==
                DatabaseUtils.STATEMENT_BEGIN) {
            mDatabase.setLastSqlStatement(mSql);
        }
        */
    }
    /**
     * Execute a statement that returns a 1 by 1 table with a numeric value.
     * For example, SELECT COUNT(*) FROM table;
     *
     * @return The result of the query.
     *
     * @throws android.database.sqlite.SQLiteDoneException if the query returns zero rows
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.378 -0500", hash_original_method = "12DB780B550F95E5C10FD5998E83FEFD", hash_generated_method = "704999B0017ADF597420BBE86A43C1B6")
    
public long simpleQueryForLong() {
        //some control flow for exception
        if (mState == 0)
            throw new SQLiteDoneException(
                                          "expected 1 row from this query but query returned no data. check the query: " +
                                          mSql);
        mDatabase.addTaint(this.getTaint());
        long ret = (long)this.getTaintInt();
        ret += (long) mDatabase.getTaintInt();
        return ret;
        
        /*
        try {
            long timeStart = acquireAndLock(READ);
            long retValue = native_1x1_long();
            mDatabase.logTimeStat(mSql, timeStart);
            return retValue;
        } catch (SQLiteDoneException e) {
            throw new SQLiteDoneException(
                    "expected 1 row from this query but query returned no data. check the query: " +
                    mSql);
        } finally {
            releaseAndUnlock();
        }
        */
    }

    /**
     * Execute a statement that returns a 1 by 1 table with a text value.
     * For example, SELECT COUNT(*) FROM table;
     *
     * @return The result of the query.
     *
     * @throws android.database.sqlite.SQLiteDoneException if the query returns zero rows
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.381 -0500", hash_original_method = "6D794A242164C6F60D732256A15CB380", hash_generated_method = "F0BBF8BAAA27EEAEBE61BE18BA557A10")
    
public String simpleQueryForString() {
          //some control flow for exception
        if (mState == 0)
            throw new SQLiteDoneException(
                                          "expected 1 row from this query but query returned no data. check the query: " +
                                          mSql);
        mDatabase.addTaint(this.getTaint());
        String ret = new String();
        ret.addTaint(this.getTaint());
        ret.addTaint(mDatabase.getTaint());
        return ret;
        /*
        try {
            long timeStart = acquireAndLock(READ);
            String retValue = native_1x1_string();
            mDatabase.logTimeStat(mSql, timeStart);
            return retValue;
        } catch (SQLiteDoneException e) {
            throw new SQLiteDoneException(
                    "expected 1 row from this query but query returned no data. check the query: " +
                    mSql);
        } finally {
            releaseAndUnlock();
        }
        */
    }

    /**
     * Executes a statement that returns a 1 by 1 table with a blob value.
     *
     * @return A read-only file descriptor for a copy of the blob value, or {@code null}
     *         if the value is null or could not be read for some reason.
     *
     * @throws android.database.sqlite.SQLiteDoneException if the query returns zero rows
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.385 -0500", hash_original_method = "6321C559FCE18D31DAAE4496BAD49A23", hash_generated_method = "26025A6DDCA536D8F17C08E177E19F12")
    
public ParcelFileDescriptor simpleQueryForBlobFileDescriptor() {
           //some control flow for exception
        if (mState == 0)
            throw new SQLiteDoneException(
                                          "expected 1 row from this query but query returned no data. check the query: " +
                                          mSql);
        mDatabase.addTaint(this.getTaint());
        ParcelFileDescriptor ret = new ParcelFileDescriptor();
        ret.addTaint(this.getTaint());
        ret.addTaint(mDatabase.getTaint());
        return ret;

        /*
        try {
            long timeStart = acquireAndLock(READ);
            ParcelFileDescriptor retValue = native_1x1_blob_ashmem();
            mDatabase.logTimeStat(mSql, timeStart);
            return retValue;
        } catch (IOException ex) {
            Log.e(TAG, "simpleQueryForBlobFileDescriptor() failed", ex);
            return null;
        } catch (SQLiteDoneException e) {
            throw new SQLiteDoneException(
                    "expected 1 row from this query but query returned no data. check the query: " +
                    mSql);
        } finally {
            releaseAndUnlock();
        }
        */
    }

    /**
     * Called before every method in this class before executing a SQL statement,
     * this method does the following:
     * <ul>
     *   <li>make sure the database is open</li>
     *   <li>get a database connection from the connection pool,if possible</li>
     *   <li>notifies {@link BlockGuard} of read/write</li>
     *   <li>if the SQL statement is an update, start transaction if not already in one.
     *   otherwise, get lock on the database</li>
     *   <li>acquire reference on this object</li>
     *   <li>and then return the current time _after_ the database lock was acquired</li>
     * </ul>
     * <p>
     * This method removes the duplicate code from the other public
     * methods in this class.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.389 -0500", hash_original_method = "7802DA1EF14C1A6C860FAB64147EEA65", hash_generated_method = "31DF08AA7DB680B5B797A6320AA8C336")
    
private long acquireAndLock(boolean rwFlag) {
        return 0;
        /*
        mState = 0;
        // use pooled database connection handles for SELECT SQL statements
        mDatabase.verifyDbIsOpen();
        SQLiteDatabase db = ((mStatementType & SQLiteProgram.STATEMENT_USE_POOLED_CONN) > 0)
                ? mDatabase.getDbConnection(mSql) : mDatabase;
        // use the database connection obtained above
        mOrigDb = mDatabase;
        mDatabase = db;
        setNativeHandle(mDatabase.mNativeHandle);
        if (rwFlag == WRITE) {
            BlockGuard.getThreadPolicy().onWriteToDisk();
        } else {
            BlockGuard.getThreadPolicy().onReadFromDisk();
        }

        /*
         * Special case handling of SQLiteDatabase.execSQL("BEGIN transaction").
         * we know it is execSQL("BEGIN transaction") from the caller IF there is no lock held.
         * beginTransaction() methods in SQLiteDatabase call lockForced() before
         * calling execSQL("BEGIN transaction").
         */
        /*
        if ((mStatementType & SQLiteProgram.STATEMENT_TYPE_MASK) == DatabaseUtils.STATEMENT_BEGIN) {
            if (!mDatabase.isDbLockedByCurrentThread()) {
                // transaction is  NOT started by calling beginTransaction() methods in
                // SQLiteDatabase
                mDatabase.setTransactionUsingExecSqlFlag();
            }
        } else if ((mStatementType & SQLiteProgram.STATEMENT_TYPE_MASK) ==
                DatabaseUtils.STATEMENT_UPDATE) {
            // got update SQL statement. if there is NO pending transaction, start one
            if (!mDatabase.inTransaction()) {
                mDatabase.beginTransactionNonExclusive();
                mState = TRANS_STARTED;
            }
        }
        // do I have database lock? if not, grab it.
        if (!mDatabase.isDbLockedByCurrentThread()) {
            mDatabase.lock(mSql);
            mState = LOCK_ACQUIRED;
        }

        acquireReference();
        long startTime = SystemClock.uptimeMillis();
        mDatabase.closePendingStatements();
        compileAndbindAllArgs();
        return startTime;
        */
    }

    /**
     * this method releases locks and references acquired in {@link #acquireAndLock(boolean)}
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.392 -0500", hash_original_method = "3195EF2C5595E73848E74AA3B0A84A6E", hash_generated_method = "46E7D271BFA3A6DF8E46090A8915A023")
    
private void releaseAndUnlock() {
        releaseReference();
        if (mState == TRANS_STARTED) {
            try {
                mDatabase.setTransactionSuccessful();
            } finally {
                mDatabase.endTransaction();
            }
        } else if (mState == LOCK_ACQUIRED) {
            mDatabase.unlock();
        }
        if ((mStatementType & SQLiteProgram.STATEMENT_TYPE_MASK) ==
                DatabaseUtils.STATEMENT_COMMIT ||
                (mStatementType & SQLiteProgram.STATEMENT_TYPE_MASK) ==
                DatabaseUtils.STATEMENT_ABORT) {
            mDatabase.resetTransactionUsingExecSqlFlag();
        }
        clearBindings();
        // release the compiled sql statement so that the caller's SQLiteStatement no longer
        // has a hard reference to a database object that may get deallocated at any point.
        release();
        // restore the database connection handle to the original value
        mDatabase = mOrigDb;
        setNativeHandle(mDatabase.mNativeHandle);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.396 -0500", hash_original_method = "DA760EA6BB282F82E2B89FD24EBEEAD3", hash_generated_method = "DC5161720DAB8EB47E5EA4047FBF472A")
    
    private final int native_execute(){
    	//Formerly a native method
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.401 -0500", hash_original_method = "8482A8304EDF98FD537E7B2A3BC31388", hash_generated_method = "9F284F813ADAB367EF93E398BBFD5E94")
    
    private final long native_executeInsert(){
    	//Formerly a native method
    	return getTaintLong();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.405 -0500", hash_original_method = "FE0D02F573B183DE07F8BDF82793A3EA", hash_generated_method = "109B3F1E1771FF600B0FC63E1CA1E863")
    
    private final long native_1x1_long(){
    	//Formerly a native method
    	return getTaintLong();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.900 -0400", hash_original_method = "07DFC0F07DCBF43769548BE4FBA916EE", hash_generated_method = "28030A1C7DC39244AA70D827443E96B9")
    private final String native_1x1_string() {
    	String foo = new String();
    	return foo;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.900 -0400", hash_original_method = "D5A94C086543C65F36827FC2C8B73314", hash_generated_method = "2FF5ECD0A356350F1F45EEEF9C01561B")
    private final ParcelFileDescriptor native_1x1_blob_ashmem() throws IOException {
    	return new ParcelFileDescriptor();
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.418 -0500", hash_original_method = "BD9AF961A0959F9D5CBC2D8FDDD3B169", hash_generated_method = "80B7D2E3456BEDA8261A1E0B72D02043")
    
    private final void native_executeSql(String sql){
    	//Formerly a native method
    	addTaint(sql.getTaint());
    }

}

