package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.util.ArrayUtils;

class PackedIntVector {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.365 -0400", hash_original_field = "11C985F30142FD30ACDDFE7CD3BD4A9B", hash_generated_field = "75F4039C98FB52077D38E34F530EB3FF")

    private int mColumns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.365 -0400", hash_original_field = "839FCD25B196D1E9D74989EB7586909A", hash_generated_field = "18B06BC67D1393EDA8ED9BB923EF7CD3")

    private int mRows;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.365 -0400", hash_original_field = "717D446B0EDDE3F55A9FB9E6279E6014", hash_generated_field = "EA98696F1B775619308B0863F513F9F1")

    private int mRowGapStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.366 -0400", hash_original_field = "2765BE84E84BC9CBE3B823946D881A10", hash_generated_field = "EB5D193EB3BD0BD6791276EC10232CBE")

    private int mRowGapLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.366 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "99CDF6DB2A492E619A6F25FAC593741C")

    private int[] mValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.366 -0400", hash_original_field = "49FB44D57F23EE2C95BAA3838BB33FA5", hash_generated_field = "8A8172715F1B9899286D01C54C2B982A")

    private int[] mValueGap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.366 -0400", hash_original_method = "49572B82831972D93E19442EBCB45603", hash_generated_method = "6DCB4BA64977301CCE79D34F3045D8C8")
    public  PackedIntVector(int columns) {
        mColumns = columns;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.383 -0400", hash_original_method = "127603F69B46B56B0057C44974C5D0F5", hash_generated_method = "8FD9A0882C1155892291BE0F6ED61106")
    public int getValue(int row, int column) {
        int columns;
        columns = mColumns;
        {
            boolean var2A4A8D030010DB622499908914125EFE_664027883 = (((row | column) < 0) || (row >= size()) || (column >= columns));
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
        addTaint(row);
        addTaint(column);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_463213893 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_463213893;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.384 -0400", hash_original_method = "DF9491EC74B5A8AD3F1F814A7288BD27", hash_generated_method = "6B30A8DA3048B8D49E90D79C80E8DFE1")
    public void setValue(int row, int column, int value) {
        {
            boolean varC707DA84CAF21DF47BA9EF5117D73FA2_1116638316 = (((row | column) < 0) || (row >= size()) || (column >= mColumns));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.387 -0400", hash_original_method = "339196B1319A98FF890A6A44D9B8F936", hash_generated_method = "E6C728429BBFB5A65280D34A67C9BA31")
    private void setValueInternal(int row, int column, int value) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.392 -0400", hash_original_method = "717B6A8B8BE261E23908EA9C8BC6E7EA", hash_generated_method = "50494031DFDF2CCF0600A214B935F2C5")
    public void adjustValuesBelow(int startRow, int column, int delta) {
        {
            boolean var9F9858628E569DC62C736458BF03F43D_1746351571 = (((startRow | column) < 0) || (startRow > size()) ||
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
        addTaint(startRow);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.397 -0400", hash_original_method = "6AE5D8E6865DDCD084B3272F01FD2E51", hash_generated_method = "E7601D15CB03A2A60862737B1ACD89A7")
    public void insertAt(int row, int[] values) {
        {
            boolean var1B727FC6E9C960A0A368AF6437037F86_1351815003 = ((row < 0) || (row > size()));
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("row " + row);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var211F855C0462B858E40BD8187D92C309_1183012732 = ((values != null) && (values.length < width()));
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
        addTaint(row);
        addTaint(values[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.409 -0400", hash_original_method = "29D77D40DB4AFADA133299814B25205C", hash_generated_method = "11F46C892027F6152ABCCB61CAC82F2D")
    public void deleteAt(int row, int count) {
        {
            boolean var0B06188E919776FA771A4738B64DB932_391641869 = (((row | count) < 0) || (row + count > size()));
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(row + ", " + count);
            } //End block
        } //End collapsed parenthetic
        moveRowGapTo(row + count);
        mRowGapStart -= count;
        mRowGapLength += count;
        addTaint(row);
        // ---------- Original Method ----------
        //if (((row | count) < 0) || (row + count > size())) {
            //throw new IndexOutOfBoundsException(row + ", " + count);
        //}
        //moveRowGapTo(row + count);
        //mRowGapStart -= count;
        //mRowGapLength += count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.410 -0400", hash_original_method = "A7F055B05F3BF0E7B9EF67A5904EF45B", hash_generated_method = "894C72A56F8A55F9CC01423F709D9A8C")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_844773398 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_844773398;
        // ---------- Original Method ----------
        //return mRows - mRowGapLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.411 -0400", hash_original_method = "00C81AD9ACCD847707085D62472884FD", hash_generated_method = "AEC2F71520E40B5B2D08EF5277E81177")
    public int width() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1361444396 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1361444396;
        // ---------- Original Method ----------
        //return mColumns;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.417 -0400", hash_original_method = "B5C941269BF1E9CDD155EBF5B7D0DBA9", hash_generated_method = "98E7AEB4CED8CF667F2640C1FC104678")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.421 -0400", hash_original_method = "6D74A2161397D319519D26FF483664C7", hash_generated_method = "043DDBED7368B9772919D3C981CAB2EB")
    private final void moveValueGapTo(int column, int where) {
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
        addTaint(column);
        addTaint(where);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.444 -0400", hash_original_method = "6D396DEEC3DAD541F2D5DA5D46CC7D37", hash_generated_method = "FB89000DF4B6199190E3A7158F186F7A")
    private final void moveRowGapTo(int where) {
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
        mRowGapStart = where;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

