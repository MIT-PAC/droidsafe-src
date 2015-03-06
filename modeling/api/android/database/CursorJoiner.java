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
 * Copyright (C) 2008 The Android Open Source Project
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


package android.database;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Iterator;

public final class CursorJoiner implements Iterator<CursorJoiner.Result>, Iterable<CursorJoiner.Result> {

    /**
     * Reads the strings from the cursor that are specifed in the columnIndicies
     * array and saves them in values beginning at startingIndex, skipping a slot
     * for each value. If columnIndicies has length 3 and startingIndex is 1, the
     * values will be stored in slots 1, 3, and 5.
     * @param values the String[] to populate
     * @param cursor the cursor from which to read
     * @param columnIndicies the indicies of the values to read from the cursor
     * @param startingIndex the slot in which to start storing values, and must be either 0 or 1.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.275 -0500", hash_original_method = "84AE19E5FEA6BD44A102FDD1C7D63C31", hash_generated_method = "A7890E5D0CF846B9D0C76B6F6DA78123")
    
private static void populateValues(String[] values, Cursor cursor, int[] columnIndicies,
            int startingIndex) {
        assert startingIndex == 0 || startingIndex == 1;
        for (int i = 0; i < columnIndicies.length; i++) {
            values[startingIndex + i*2] = cursor.getString(columnIndicies[i]);
        }
    }

    /**
     * Compare the values. Values contains n pairs of strings. If all the pairs of strings match
     * then returns 0. Otherwise returns the comparison result of the first non-matching pair
     * of values, -1 if the first of the pair is less than the second of the pair or 1 if it
     * is greater.
     * @param values the n pairs of values to compare
     * @return -1, 0, or 1 as described above.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.281 -0500", hash_original_method = "ED7115340A8A7EF690F3B814A164C906", hash_generated_method = "D989FEEA6C655E7554E6D80F9E00F0E6")
    
private static int compareStrings(String... values) {
        if ((values.length % 2) != 0) {
            throw new IllegalArgumentException("you must specify an even number of values");
        }

        for (int index = 0; index < values.length; index+=2) {
            if (values[index] == null) {
                if (values[index+1] == null) continue;
                return -1;
            }

            if (values[index+1] == null) {
                return 1;
            }

            int comp = values[index].compareTo(values[index+1]);
            if (comp != 0) {
                //return comp < 0 ? -1 : 1;
                return (comp + values[0].length()); //values has taint too
            }
        }

        return 0;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.241 -0500", hash_original_field = "8F033C9D1093FC5C83D7F968042B46D9", hash_generated_field = "5EDFE9F4B72E9F71F7005B3044004FBC")

    private Cursor mCursorLeft;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.243 -0500", hash_original_field = "2FFA8FE21B4853E84F3F8FC65B258111", hash_generated_field = "50661CD2909550FD138E09A388BA6E26")

    private Cursor mCursorRight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.245 -0500", hash_original_field = "256EE5033CE2828F5196E8246A4042BD", hash_generated_field = "93AB6D3868EAC81A7C9BAE36C55580B0")

    private boolean mCompareResultIsValid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.248 -0500", hash_original_field = "99EE09849C46BA1CF2AFFBFE596EBAF8", hash_generated_field = "CCB92ADA2B30F4AFA2CC14ED51AD85D6")

    private Result mCompareResult;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.250 -0500", hash_original_field = "154243D35C2AFE345870A0FF18F0B421", hash_generated_field = "2FF43DAABAD6158AEE507A75B88B4B20")

    private int[] mColumnsLeft;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.252 -0500", hash_original_field = "CAB3D56813DC0969C27DC83CB89ECC1E", hash_generated_field = "36736B2C969265CB7BAE0B3051EE8A49")

    private int[] mColumnsRight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.255 -0500", hash_original_field = "9F998ED85AA977DAB1E9E21D505A99EC", hash_generated_field = "59263FDE2010B8226CB0D43320D5A579")

    private String[] mValues;
    
    public CursorJoiner(
            Cursor cursorLeft, String[] columnNamesLeft,
            Cursor cursorRight, String[] columnNamesRight) {
    	 mCursorLeft = cursorLeft;
         mCursorRight = cursorRight;
        addTaint(columnNamesRight[0].getTaint());
        addTaint(columnNamesLeft[0].getTaint());
        if (columnNamesLeft.length != columnNamesRight.length) {
            throw new IllegalArgumentException(
                    "you must have the same number of columns on the left and right, "
                            + columnNamesLeft.length + " != " + columnNamesRight.length);
        }
        /* GITI DSModeled
        mCursorLeft = cursorLeft;
        mCursorRight = cursorRight;
        mCursorLeft.moveToFirst();
        mCursorRight.moveToFirst();
        mCompareResultIsValid = false;
        mColumnsLeft = buildColumnIndiciesArray(cursorLeft, columnNamesLeft);
        mColumnsRight = buildColumnIndiciesArray(cursorRight, columnNamesRight);
        mValues = new String[mColumnsLeft.length * 2];
        */
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    public Iterator iterator() {
        return this;
    }

    /**
     * Lookup the indicies of the each column name and return them in an array.
     * @param cursor the cursor that contains the columns
     * @param columnNames the array of names to lookup
     * @return an array of column indices
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.265 -0500", hash_original_method = "9B0D8B6CEE5AA7BD346EB9D2E041D4FA", hash_generated_method = "4BC89F7A72DA2A988961B8D9881BB9CE")
    
private int[] buildColumnIndiciesArray(Cursor cursor, String[] columnNames) {
        int[] columns = new int[columnNames.length];
        for (int i = 0; i < columnNames.length; i++) {
            columns[i] = cursor.getColumnIndexOrThrow(columnNames[i]);
        }
        return columns;
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    public boolean hasNext() {
        /* 
        if (mCompareResultIsValid) {
            switch (mCompareResult) {
                case BOTH:
                    return !mCursorLeft.isLast() || !mCursorRight.isLast();
                case LEFT:
                    return !mCursorLeft.isLast() || !mCursorRight.isAfterLast();
                case RIGHT:
                    return !mCursorLeft.isAfterLast() || !mCursorRight.isLast();
                default:
                    throw new IllegalStateException("bad value for mCompareResult, "
                            + mCompareResult);
            }
        } else {
            return !mCursorLeft.isAfterLast() || !mCursorRight.isAfterLast();
        }
        */
    	return mCursorLeft.isLast() || !mCursorRight.isLast() || 
    			!mCursorLeft.isAfterLast() || !mCursorRight.isAfterLast();
    }
    
    //public Result next() {
    @DSSafe(DSCat.SAFE_LIST)
    public Result next() {
        /* GITI DSModeled:  For modeling purposes, we probably do not care what the result returned
         * is, so return a valid Result.BOTH.
         */
        if (!hasNext()) {
            throw new IllegalStateException("you must only call next() when hasNext() is true");
        }
        incrementCursors();
        boolean hasLeft = !mCursorLeft.isAfterLast();
        boolean hasRight = !mCursorRight.isAfterLast();
        mValues[0] = mCursorLeft.getString(0);
        mValues[0] = mCursorRight.getString(0);
        return Result.RIGHT;
    }

    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.272 -0500", hash_original_method = "0B82084F50DA03E6D8656F079228A747", hash_generated_method = "CE00AE31FCA2916858ED9702E50EE4BB")
    
public void remove() {
        throw new UnsupportedOperationException("not implemented");
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void incrementCursors() {
       mCursorLeft.moveToNext();
       mCursorRight.moveToNext();
    }
    
    public enum Result {
        RIGHT,
        LEFT,
        BOTH;
        
        Result() {
        	
        }
    }
    
}

