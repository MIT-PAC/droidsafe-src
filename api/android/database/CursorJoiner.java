package android.database;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Iterator;






public final class CursorJoiner implements Iterator<CursorJoiner.Result>, Iterable<CursorJoiner.Result> {
    private Cursor mCursorLeft;
    private Cursor mCursorRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.223 -0400", hash_original_field = "7177A8D6DE964D7088434EA5C744F6EB", hash_generated_field = "93AB6D3868EAC81A7C9BAE36C55580B0")

    private boolean mCompareResultIsValid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.223 -0400", hash_original_field = "70C3D71BCDE78FEDF6F5D88C51E3BD7A", hash_generated_field = "CCB92ADA2B30F4AFA2CC14ED51AD85D6")

    private Result mCompareResult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.223 -0400", hash_original_field = "2A3B81178AA60BF5C16969CB0BC5469B", hash_generated_field = "2FF43DAABAD6158AEE507A75B88B4B20")

    private int[] mColumnsLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.223 -0400", hash_original_field = "6C450B3CF03CC057B1C9C39218CD46F0", hash_generated_field = "36736B2C969265CB7BAE0B3051EE8A49")

    private int[] mColumnsRight;
    private String[] mValues;
    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public Iterator iterator() {
        return this;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.224 -0400", hash_original_method = "9B0D8B6CEE5AA7BD346EB9D2E041D4FA", hash_generated_method = "08DB92CFE303949AA36FBF8D1140F053")
    private int[] buildColumnIndiciesArray(Cursor cursor, String[] columnNames) {
        addTaint(columnNames[0].getTaint());
        addTaint(cursor.getTaint());
        int[] columns = new int[columnNames.length];
for(int i = 0;i < columnNames.length;i++)
        {
            columns[i] = cursor.getColumnIndexOrThrow(columnNames[i]);
        } //End block
        int[] var54CA84A794888FE8D92834787DFA935A_1945452398 = (columns);
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_913162839 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_913162839;
        // ---------- Original Method ----------
        //int[] columns = new int[columnNames.length];
        //for (int i = 0; i < columnNames.length; i++) {
            //columns[i] = cursor.getColumnIndexOrThrow(columnNames[i]);
        //}
        //return columns;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    //public Result next() {
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

    
    @DSModeled(DSC.SAFE)
    public void remove() {
        throw new UnsupportedOperationException("not implemented");
    }

    
    @DSModeled(DSC.BAN)
    private static void populateValues(String[] values, Cursor cursor, int[] columnIndicies,
            int startingIndex) {
        assert startingIndex == 0 || startingIndex == 1;
        for (int i = 0; i < columnIndicies.length; i++) {
            values[startingIndex + i*2] = cursor.getString(columnIndicies[i]);
        }
    }

    
    @DSModeled(DSC.BAN)
    private void incrementCursors() {
       mCursorLeft.moveToNext();
       mCursorRight.moveToNext();
    }

    
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
                return comp < 0 ? -1 : 1;
            }
        }
        return 0;
    }

    
    public enum Result {
        RIGHT,
        LEFT,
        BOTH;
        
        @DSModeled(DSC.SAFE)
        Result() {
        	
        }
    }

    
}

