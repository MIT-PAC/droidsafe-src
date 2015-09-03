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
import droidsafe.annotations.*;
import android.database.CursorWindow;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;

import droidsafe.helpers.DSUtils;

public class SQLiteQuery extends SQLiteProgram {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeFillWindow(int databasePtr, int statementPtr, int windowPtr,
            int startPos, int offsetParam) {
        return  databasePtr + statementPtr + windowPtr + startPos + offsetParam;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeColumnCount(int statementPtr) {
        return statementPtr;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static String nativeColumnName(int statementPtr, int columnIndex) {
        String str = new String();
        str.addTaint(statementPtr + columnIndex);
        return str;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.469 -0500", hash_original_field = "60D09076627E73BCAEEB6F563954C30A", hash_generated_field = "33B4EC31717AE04F4951ABB455378F67")

    private static final String TAG = "SQLiteQuery";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.483 -0500", hash_original_field = "635E86039A5B1D292EA8131FF2D5D0BF", hash_generated_field = "834FF8F7040C5E40B4484771C7969574")

    private int mOffsetIndex = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.486 -0500", hash_original_field = "68E7C3569E191B98218FD7A043574AEA", hash_generated_field = "0FB4858B613824FE6FDA94A379EBC4D0")

    private boolean mClosed = false;

    /**
     * Create a persistent query object.
     *
     * @param db The database that this query object is associated with
     * @param query The SQL string for this query. 
     * @param offsetIndex The 1-based index to the OFFSET parameter, 
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.488 -0500", hash_original_method = "B04E51F22DB6FA67074D367FD62C2A3B", hash_generated_method = "B04E51F22DB6FA67074D367FD62C2A3B")
    
SQLiteQuery(SQLiteDatabase db, String query, int offsetIndex, String[] bindArgs) {
        super(db, query);
        mOffsetIndex = offsetIndex;
        bindAllArgsAsStrings(bindArgs);
    }

    /**
     * Constructor used to create new instance to replace a given instance of this class.
     * This constructor is used when the current Query object is now associated with a different
     * {@link SQLiteDatabase} object.
     *
     * @param db The database that this query object is associated with
     * @param query the instance of {@link SQLiteQuery} to be replaced
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.491 -0500", hash_original_method = "ACE77F48482E9278318C8F93FF273D4F", hash_generated_method = "ACE77F48482E9278318C8F93FF273D4F")
    
SQLiteQuery(SQLiteDatabase db, SQLiteQuery query) {
        super(db, query.mSql);
        this.mBindArgs = query.mBindArgs;
        this.mOffsetIndex = query.mOffsetIndex;
    }

    /**
     * Reads rows into a buffer. This method acquires the database lock.
     *
     * @param window The window to fill into
     * @return number of total rows in the query
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.493 -0500", hash_original_method = "D55C6AB533D249202FC7A2AC29FF93BB", hash_generated_method = "2020EB7A90BA7B22232FE2964D5A4746")
    
int fillWindow(CursorWindow window) {
        mDatabase.lock(mSql);
        long timeStart = SystemClock.uptimeMillis();
        try {
            acquireReference();
            try {
                window.acquireReference();
                int startPos = window.getStartPosition();
                int numRows = nativeFillWindow(nHandle, nStatement, window.mWindowPtr,
                        startPos, mOffsetIndex);
                if (SQLiteDebug.DEBUG_LOG_SLOW_QUERIES) {
                    long elapsed = SystemClock.uptimeMillis() - timeStart;
                    if (SQLiteDebug.shouldLogSlowQuery(elapsed)) {
                        Log.d(TAG, "fillWindow took " + elapsed
                                + " ms: window=\"" + window
                                + "\", startPos=" + startPos
                                + ", offset=" + mOffsetIndex
                                + ", filledRows=" + window.getNumRows()
                                + ", countedRows=" + numRows
                                + ", query=\"" + mSql + "\""
                                + ", args=[" + (mBindArgs != null ?
                                        TextUtils.join(", ", mBindArgs.values()) : "")
                                + "]");
                    }
                }
                mDatabase.logTimeStat(mSql, timeStart);
                return numRows;
            } catch (IllegalStateException e){
                // simply ignore it
                return 0;
            } catch (SQLiteDatabaseCorruptException e) {
                mDatabase.onCorruption();
                throw e;
            } catch (SQLiteException e) {
                Log.e(TAG, "exception: " + e.getMessage() + "; query: " + mSql);
                throw e;
            } finally {
                window.releaseReference();
            }
        } finally {
            releaseReference();
            mDatabase.unlock();
        }
    }

    /**
     * Get the column count for the statement. Only valid on query based
     * statements. The database must be locked
     * when calling this method.
     * 
     * @return The number of column in the statement's result set.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.496 -0500", hash_original_method = "54618FF47D2C419F49442C51D0DA0774", hash_generated_method = "54618FF47D2C419F49442C51D0DA0774")
    
int columnCountLocked() {
        acquireReference();
        try {
            return nativeColumnCount(nStatement);
        } finally {
            releaseReference();
        }
    }

    /**
     * Retrieves the column name for the given column index. The database must be locked
     * when calling this method.
     * 
     * @param columnIndex the index of the column to get the name for
     * @return The requested column's name
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.498 -0500", hash_original_method = "B5AB077B4013E218660670FE95A73F4B", hash_generated_method = "B5AB077B4013E218660670FE95A73F4B")
    
String columnNameLocked(int columnIndex) {
        acquireReference();
        try {
            return nativeColumnName(nStatement, columnIndex);
        } finally {
            releaseReference();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.501 -0500", hash_original_method = "818F0EC4250B389213C92FDEA7A7A5CE", hash_generated_method = "E3988E23A202244D7F0D4727DC92B445")
    
@Override
    public String toString() {
        return "SQLiteQuery: " + mSql;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.504 -0500", hash_original_method = "C1F8301470323E9B4CE9B1F32DF8E225", hash_generated_method = "E59CB6D70209DADFB4D42037D59EB518")
    
@Override
    public void close() {
        super.close();
        mClosed = true;
    }

    /**
     * Called by SQLiteCursor when it is requeried.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.506 -0500", hash_original_method = "10930ECAA546E890A142B67C44E349E2", hash_generated_method = "10930ECAA546E890A142B67C44E349E2")
    
void requery() {
        if (mClosed) {
            throw new IllegalStateException("requerying a closed cursor");
        }
        compileAndbindAllArgs();
    }
}

