package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.util.ArrayUtils;

class PackedIntVector {
    private int mColumns;
    private int mRows;
    private int mRowGapStart;
    private int mRowGapLength;
    private int[] mValues;
    private int[] mValueGap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.191 -0400", hash_original_method = "49572B82831972D93E19442EBCB45603", hash_generated_method = "31CDD5D37E8F35B69D2EB8C60FEFA02D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PackedIntVector(int columns) {
        dsTaint.addTaint(columns);
        mRows = 0;
        mRowGapStart = 0;
        mRowGapLength = mRows;
        mValues = null;
        mValueGap = new int[2 * columns];
        // ---------- Original Method ----------
        //mColumns = columns;
        //mRows = 0;
        //mRowGapStart = 0;
        //mRowGapLength = mRows;
        //mValues = null;
        //mValueGap = new int[2 * columns];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.191 -0400", hash_original_method = "127603F69B46B56B0057C44974C5D0F5", hash_generated_method = "6BF1F9A57E24E5733A9888FC445D1922")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getValue(int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        int columns;
        columns = mColumns;
        {
            boolean var2A4A8D030010DB622499908914125EFE_642741781 = (((row | column) < 0) || (row >= size()) || (column >= columns));
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(row + ", " + column);
            } //End block
        } //End collapsed parenthetic
        {
            row += mRowGapLength;
        } //End block
        int value;
        value = mValues[row * columns + column];
        int[] valuegap;
        valuegap = mValueGap;
        {
            value += valuegap[column + columns];
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final int columns = mColumns;
        //if (((row | column) < 0) || (row >= size()) || (column >= columns)) {
            //throw new IndexOutOfBoundsException(row + ", " + column);
        //}
        //if (row >= mRowGapStart) {
            //row += mRowGapLength;
        //}
        //int value = mValues[row * columns + column];
        //int[] valuegap = mValueGap;
        //if (row >= valuegap[column]) {
            //value += valuegap[column + columns];
        //}
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.192 -0400", hash_original_method = "DF9491EC74B5A8AD3F1F814A7288BD27", hash_generated_method = "BCF2DE3CFF42177B2B6C4659E149A68B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setValue(int row, int column, int value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        {
            boolean varC707DA84CAF21DF47BA9EF5117D73FA2_2089831488 = (((row | column) < 0) || (row >= size()) || (column >= mColumns));
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(row + ", " + column);
            } //End block
        } //End collapsed parenthetic
        {
            row += mRowGapLength;
        } //End block
        int[] valuegap;
        valuegap = mValueGap;
        {
            value -= valuegap[column + mColumns];
        } //End block
        mValues[row * mColumns + column] = value;
        // ---------- Original Method ----------
        //if (((row | column) < 0) || (row >= size()) || (column >= mColumns)) {
            //throw new IndexOutOfBoundsException(row + ", " + column);
        //}
        //if (row >= mRowGapStart) {
            //row += mRowGapLength;
        //}
        //int[] valuegap = mValueGap;
        //if (row >= valuegap[column]) {
            //value -= valuegap[column + mColumns];
        //}
        //mValues[row * mColumns + column] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.192 -0400", hash_original_method = "339196B1319A98FF890A6A44D9B8F936", hash_generated_method = "D20AD4321414B1BAF13432CAE960E776")
    @DSModeled(DSC.SAFE)
    private void setValueInternal(int row, int column, int value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        {
            row += mRowGapLength;
        } //End block
        int[] valuegap;
        valuegap = mValueGap;
        {
            value -= valuegap[column + mColumns];
        } //End block
        mValues[row * mColumns + column] = value;
        // ---------- Original Method ----------
        //if (row >= mRowGapStart) {
            //row += mRowGapLength;
        //}
        //int[] valuegap = mValueGap;
        //if (row >= valuegap[column]) {
            //value -= valuegap[column + mColumns];
        //}
        //mValues[row * mColumns + column] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.193 -0400", hash_original_method = "717B6A8B8BE261E23908EA9C8BC6E7EA", hash_generated_method = "4EF028215F96DFD06244C11D9959C4CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void adjustValuesBelow(int startRow, int column, int delta) {
        dsTaint.addTaint(startRow);
        dsTaint.addTaint(delta);
        dsTaint.addTaint(column);
        {
            boolean var9F9858628E569DC62C736458BF03F43D_1619442435 = (((startRow | column) < 0) || (startRow > size()) ||
                (column >= width()));
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(startRow + ", " + column);
            } //End block
        } //End collapsed parenthetic
        {
            startRow += mRowGapLength;
        } //End block
        moveValueGapTo(column, startRow);
        mValueGap[column + mColumns] += delta;
        // ---------- Original Method ----------
        //if (((startRow | column) < 0) || (startRow > size()) ||
                //(column >= width())) {
            //throw new IndexOutOfBoundsException(startRow + ", " + column);
        //}
        //if (startRow >= mRowGapStart) {
            //startRow += mRowGapLength;
        //}
        //moveValueGapTo(column, startRow);
        //mValueGap[column + mColumns] += delta;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.193 -0400", hash_original_method = "6AE5D8E6865DDCD084B3272F01FD2E51", hash_generated_method = "C92D1EA8E112889540FD46D8B30D62D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void insertAt(int row, int[] values) {
        dsTaint.addTaint(values[0]);
        dsTaint.addTaint(row);
        {
            boolean var1B727FC6E9C960A0A368AF6437037F86_547612918 = ((row < 0) || (row > size()));
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("row " + row);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var211F855C0462B858E40BD8187D92C309_1806421080 = ((values != null) && (values.length < width()));
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("value count " + values.length);
            } //End block
        } //End collapsed parenthetic
        moveRowGapTo(row);
        {
            growBuffer();
        } //End block
        {
            {
                int i;
                i = mColumns - 1;
                {
                    setValueInternal(row, i, 0);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                int i;
                i = mColumns - 1;
                {
                    setValueInternal(row, i, values[i]);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if ((row < 0) || (row > size())) {
            //throw new IndexOutOfBoundsException("row " + row);
        //}
        //if ((values != null) && (values.length < width())) {
            //throw new IndexOutOfBoundsException("value count " + values.length);
        //}
        //moveRowGapTo(row);
        //if (mRowGapLength == 0) {
            //growBuffer();
        //}
        //mRowGapStart++;
        //mRowGapLength--;
        //if (values == null) {
            //for (int i = mColumns - 1; i >= 0; i--) {
                //setValueInternal(row, i, 0);
            //}
        //} else {
            //for (int i = mColumns - 1; i >= 0; i--) {
                //setValueInternal(row, i, values[i]);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.194 -0400", hash_original_method = "29D77D40DB4AFADA133299814B25205C", hash_generated_method = "6686139EC75C15BD00D4506672385BDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void deleteAt(int row, int count) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(row);
        {
            boolean var0B06188E919776FA771A4738B64DB932_1037465159 = (((row | count) < 0) || (row + count > size()));
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(row + ", " + count);
            } //End block
        } //End collapsed parenthetic
        moveRowGapTo(row + count);
        // ---------- Original Method ----------
        //if (((row | count) < 0) || (row + count > size())) {
            //throw new IndexOutOfBoundsException(row + ", " + count);
        //}
        //moveRowGapTo(row + count);
        //mRowGapStart -= count;
        //mRowGapLength += count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.194 -0400", hash_original_method = "A7F055B05F3BF0E7B9EF67A5904EF45B", hash_generated_method = "CAA6770BA698562A6C38FA565345F254")
    @DSModeled(DSC.SAFE)
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRows - mRowGapLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.194 -0400", hash_original_method = "00C81AD9ACCD847707085D62472884FD", hash_generated_method = "1333B547F3BD6F2C5B2A963D025D5E86")
    @DSModeled(DSC.SAFE)
    public int width() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mColumns;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.195 -0400", hash_original_method = "B5C941269BF1E9CDD155EBF5B7D0DBA9", hash_generated_method = "98E7AEB4CED8CF667F2640C1FC104678")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void growBuffer() {
        int columns;
        columns = mColumns;
        int newsize;
        newsize = size() + 1;
        newsize = ArrayUtils.idealIntArraySize(newsize * columns) / columns;
        int[] newvalues;
        newvalues = new int[newsize * columns];
        int[] valuegap;
        valuegap = mValueGap;
        int rowgapstart;
        rowgapstart = mRowGapStart;
        int after;
        after = mRows - (rowgapstart + mRowGapLength);
        {
            System.arraycopy(mValues, 0, newvalues, 0, columns * rowgapstart);
            System.arraycopy(mValues, (mRows - after) * columns,
                             newvalues, (newsize - after) * columns,
                             after * columns);
        } //End block
        {
            int i;
            i = 0;
            {
                {
                    valuegap[i] += newsize - mRows;
                    {
                        valuegap[i] = rowgapstart;
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        mRowGapLength += newsize - mRows;
        mRows = newsize;
        mValues = newvalues;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.195 -0400", hash_original_method = "6D74A2161397D319519D26FF483664C7", hash_generated_method = "BD08655EBA64216339C9160A444AC1BC")
    @DSModeled(DSC.SAFE)
    private final void moveValueGapTo(int column, int where) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(where);
        int[] valuegap;
        valuegap = mValueGap;
        int[] values;
        values = mValues;
        int columns;
        columns = mColumns;
        {
            {
                int i;
                i = valuegap[column];
                {
                    values[i * columns + column] += valuegap[column + columns];
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                int i;
                i = where;
                {
                    values[i * columns + column] -= valuegap[column + columns];
                } //End block
            } //End collapsed parenthetic
        } //End block
        valuegap[column] = where;
        // ---------- Original Method ----------
        //final int[] valuegap = mValueGap;
        //final int[] values = mValues;
        //final int columns = mColumns;
        //if (where == valuegap[column]) {
            //return;
        //} else if (where > valuegap[column]) {
            //for (int i = valuegap[column]; i < where; i++) {
                //values[i * columns + column] += valuegap[column + columns];
            //}
        //} else  {
            //for (int i = where; i < valuegap[column]; i++) {
                //values[i * columns + column] -= valuegap[column + columns];
            //}
        //}
        //valuegap[column] = where;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.196 -0400", hash_original_method = "6D396DEEC3DAD541F2D5DA5D46CC7D37", hash_generated_method = "D79FB0A29C0675E9D49B78CBADDBB337")
    @DSModeled(DSC.SAFE)
    private final void moveRowGapTo(int where) {
        dsTaint.addTaint(where);
        {
            int moving;
            moving = where + mRowGapLength - (mRowGapStart + mRowGapLength);
            int columns;
            columns = mColumns;
            int[] valuegap;
            valuegap = mValueGap;
            int[] values;
            values = mValues;
            int gapend;
            gapend = mRowGapStart + mRowGapLength;
            {
                int i;
                i = gapend;
                {
                    int destrow;
                    destrow = i - gapend + mRowGapStart;
                    {
                        int j;
                        j = 0;
                        {
                            int val;
                            val = values[i * columns+ j];
                            {
                                val += valuegap[j + columns];
                            } //End block
                            {
                                val -= valuegap[j + columns];
                            } //End block
                            values[destrow * columns + j] = val;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            int moving;
            moving = mRowGapStart - where;
            int columns;
            columns = mColumns;
            int[] valuegap;
            valuegap = mValueGap;
            int[] values;
            values = mValues;
            int gapend;
            gapend = mRowGapStart + mRowGapLength;
            {
                int i;
                i = where + moving - 1;
                {
                    int destrow;
                    destrow = i - where + gapend - moving;
                    {
                        int j;
                        j = 0;
                        {
                            int val;
                            val = values[i * columns+ j];
                            {
                                val += valuegap[j + columns];
                            } //End block
                            {
                                val -= valuegap[j + columns];
                            } //End block
                            values[destrow * columns + j] = val;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

