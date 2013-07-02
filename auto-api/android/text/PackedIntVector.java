package android.text;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import com.android.internal.util.ArrayUtils;

class PackedIntVector {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.093 -0400", hash_original_field = "11C985F30142FD30ACDDFE7CD3BD4A9B", hash_generated_field = "75F4039C98FB52077D38E34F530EB3FF")

    private int mColumns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.093 -0400", hash_original_field = "839FCD25B196D1E9D74989EB7586909A", hash_generated_field = "18B06BC67D1393EDA8ED9BB923EF7CD3")

    private int mRows;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.093 -0400", hash_original_field = "717D446B0EDDE3F55A9FB9E6279E6014", hash_generated_field = "EA98696F1B775619308B0863F513F9F1")

    private int mRowGapStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.093 -0400", hash_original_field = "2765BE84E84BC9CBE3B823946D881A10", hash_generated_field = "EB5D193EB3BD0BD6791276EC10232CBE")

    private int mRowGapLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.093 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "99CDF6DB2A492E619A6F25FAC593741C")

    private int[] mValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.093 -0400", hash_original_field = "49FB44D57F23EE2C95BAA3838BB33FA5", hash_generated_field = "8A8172715F1B9899286D01C54C2B982A")

    private int[] mValueGap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.094 -0400", hash_original_method = "49572B82831972D93E19442EBCB45603", hash_generated_method = "6DCB4BA64977301CCE79D34F3045D8C8")
    public  PackedIntVector(int columns) {
        mColumns = columns;
        mRows = 0;
        mRowGapStart = 0;
        mRowGapLength = mRows;
        mValues = null;
        mValueGap = new int[2 * columns];
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.094 -0400", hash_original_method = "127603F69B46B56B0057C44974C5D0F5", hash_generated_method = "7A230AE2C78CD126558B9C58E7044B97")
    public int getValue(int row, int column) {
        final int columns = mColumns;
        {
            boolean var2A4A8D030010DB622499908914125EFE_1917220216 = (((row | column) < 0) || (row >= size()) || (column >= columns));
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(row + ", " + column);
            } 
        } 
        {
            row += mRowGapLength;
        } 
        int value = mValues[row * columns + column];
        int[] valuegap = mValueGap;
        {
            value += valuegap[column + columns];
        } 
        addTaint(row);
        addTaint(column);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_340220333 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_340220333;
        
        
        
            
        
        
            
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.095 -0400", hash_original_method = "DF9491EC74B5A8AD3F1F814A7288BD27", hash_generated_method = "3FC8945836DA74B6B97BF3687C57FF09")
    public void setValue(int row, int column, int value) {
        {
            boolean varC707DA84CAF21DF47BA9EF5117D73FA2_1011404609 = (((row | column) < 0) || (row >= size()) || (column >= mColumns));
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(row + ", " + column);
            } 
        } 
        {
            row += mRowGapLength;
        } 
        int[] valuegap = mValueGap;
        {
            value -= valuegap[column + mColumns];
        } 
        mValues[row * mColumns + column] = value;
        
        
            
        
        
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.095 -0400", hash_original_method = "339196B1319A98FF890A6A44D9B8F936", hash_generated_method = "78A2B288FD81E57E73E67B7FF7E3CB91")
    private void setValueInternal(int row, int column, int value) {
        {
            row += mRowGapLength;
        } 
        int[] valuegap = mValueGap;
        {
            value -= valuegap[column + mColumns];
        } 
        mValues[row * mColumns + column] = value;
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.096 -0400", hash_original_method = "717B6A8B8BE261E23908EA9C8BC6E7EA", hash_generated_method = "A65C8A254260393562D0C50276DBA46C")
    public void adjustValuesBelow(int startRow, int column, int delta) {
        {
            boolean var9F9858628E569DC62C736458BF03F43D_73850097 = (((startRow | column) < 0) || (startRow > size()) ||
                (column >= width()));
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(startRow + ", " + column);
            } 
        } 
        {
            startRow += mRowGapLength;
        } 
        moveValueGapTo(column, startRow);
        mValueGap[column + mColumns] += delta;
        addTaint(startRow);
        
        
                
            
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.096 -0400", hash_original_method = "6AE5D8E6865DDCD084B3272F01FD2E51", hash_generated_method = "719A70DB321367F092ACF0DC78DAC3B7")
    public void insertAt(int row, int[] values) {
        {
            boolean var1B727FC6E9C960A0A368AF6437037F86_861178188 = ((row < 0) || (row > size()));
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("row " + row);
            } 
        } 
        {
            boolean var211F855C0462B858E40BD8187D92C309_369053744 = ((values != null) && (values.length < width()));
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("value count " + values.length);
            } 
        } 
        moveRowGapTo(row);
        {
            growBuffer();
        } 
        {
            {
                int i = mColumns - 1;
                {
                    setValueInternal(row, i, 0);
                } 
            } 
        } 
        {
            {
                int i = mColumns - 1;
                {
                    setValueInternal(row, i, values[i]);
                } 
            } 
        } 
        addTaint(row);
        addTaint(values[0]);
        
        
            
        
        
            
        
        
        
            
        
        
        
        
            
                
            
        
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.097 -0400", hash_original_method = "29D77D40DB4AFADA133299814B25205C", hash_generated_method = "9E99ECA1012B684893B061CF121B3833")
    public void deleteAt(int row, int count) {
        {
            boolean var0B06188E919776FA771A4738B64DB932_1603615524 = (((row | count) < 0) || (row + count > size()));
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(row + ", " + count);
            } 
        } 
        moveRowGapTo(row + count);
        mRowGapStart -= count;
        mRowGapLength += count;
        addTaint(row);
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.098 -0400", hash_original_method = "A7F055B05F3BF0E7B9EF67A5904EF45B", hash_generated_method = "2A18A8D5D1F53B07B2F6B23AC619592D")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1904220146 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1904220146;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.098 -0400", hash_original_method = "00C81AD9ACCD847707085D62472884FD", hash_generated_method = "DEA8D037CBC794FC559C71BE85C8A37C")
    public int width() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_106351143 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_106351143;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.099 -0400", hash_original_method = "B5C941269BF1E9CDD155EBF5B7D0DBA9", hash_generated_method = "E4571B8DC1A6A22C66053A392EB92616")
    private final void growBuffer() {
        final int columns = mColumns;
        int newsize = size() + 1;
        newsize = ArrayUtils.idealIntArraySize(newsize * columns) / columns;
        int[] newvalues = new int[newsize * columns];
        final int[] valuegap = mValueGap;
        final int rowgapstart = mRowGapStart;
        int after = mRows - (rowgapstart + mRowGapLength);
        {
            System.arraycopy(mValues, 0, newvalues, 0, columns * rowgapstart);
            System.arraycopy(mValues, (mRows - after) * columns,
                             newvalues, (newsize - after) * columns,
                             after * columns);
        } 
        {
            int i = 0;
            {
                {
                    valuegap[i] += newsize - mRows;
                    {
                        valuegap[i] = rowgapstart;
                    } 
                } 
            } 
        } 
        mRowGapLength += newsize - mRows;
        mRows = newsize;
        mValues = newvalues;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.100 -0400", hash_original_method = "6D74A2161397D319519D26FF483664C7", hash_generated_method = "2667F8FB1A7DE2BB2121556D48F07449")
    private final void moveValueGapTo(int column, int where) {
        final int[] valuegap = mValueGap;
        final int[] values = mValues;
        final int columns = mColumns;
        {
            {
                int i = valuegap[column];
                {
                    values[i * columns + column] += valuegap[column + columns];
                } 
            } 
        } 
        {
            {
                int i = where;
                {
                    values[i * columns + column] -= valuegap[column + columns];
                } 
            } 
        } 
        valuegap[column] = where;
        addTaint(column);
        addTaint(where);
        
        
        
        
        
            
        
            
                
            
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.101 -0400", hash_original_method = "6D396DEEC3DAD541F2D5DA5D46CC7D37", hash_generated_method = "0FA0244A6B5D007BA0FB771943037B61")
    private final void moveRowGapTo(int where) {
        {
            int moving = where + mRowGapLength - (mRowGapStart + mRowGapLength);
            final int columns = mColumns;
            final int[] valuegap = mValueGap;
            final int[] values = mValues;
            final int gapend = mRowGapStart + mRowGapLength;
            {
                int i = gapend;
                {
                    int destrow = i - gapend + mRowGapStart;
                    {
                        int j = 0;
                        {
                            int val = values[i * columns+ j];
                            {
                                val += valuegap[j + columns];
                            } 
                            {
                                val -= valuegap[j + columns];
                            } 
                            values[destrow * columns + j] = val;
                        } 
                    } 
                } 
            } 
        } 
        {
            int moving = mRowGapStart - where;
            final int columns = mColumns;
            final int[] valuegap = mValueGap;
            final int[] values = mValues;
            final int gapend = mRowGapStart + mRowGapLength;
            {
                int i = where + moving - 1;
                {
                    int destrow = i - where + gapend - moving;
                    {
                        int j = 0;
                        {
                            int val = values[i * columns+ j];
                            {
                                val += valuegap[j + columns];
                            } 
                            {
                                val -= valuegap[j + columns];
                            } 
                            values[destrow * columns + j] = val;
                        } 
                    } 
                } 
            } 
        } 
        mRowGapStart = where;
        
        
    }

    
}

