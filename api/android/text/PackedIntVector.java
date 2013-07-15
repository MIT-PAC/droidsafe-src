package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.util.ArrayUtils;

class PackedIntVector {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.291 -0400", hash_original_field = "11C985F30142FD30ACDDFE7CD3BD4A9B", hash_generated_field = "75F4039C98FB52077D38E34F530EB3FF")

    private int mColumns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.292 -0400", hash_original_field = "839FCD25B196D1E9D74989EB7586909A", hash_generated_field = "18B06BC67D1393EDA8ED9BB923EF7CD3")

    private int mRows;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.292 -0400", hash_original_field = "717D446B0EDDE3F55A9FB9E6279E6014", hash_generated_field = "EA98696F1B775619308B0863F513F9F1")

    private int mRowGapStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.292 -0400", hash_original_field = "2765BE84E84BC9CBE3B823946D881A10", hash_generated_field = "EB5D193EB3BD0BD6791276EC10232CBE")

    private int mRowGapLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.292 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "99CDF6DB2A492E619A6F25FAC593741C")

    private int[] mValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.292 -0400", hash_original_field = "49FB44D57F23EE2C95BAA3838BB33FA5", hash_generated_field = "8A8172715F1B9899286D01C54C2B982A")

    private int[] mValueGap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.293 -0400", hash_original_method = "49572B82831972D93E19442EBCB45603", hash_generated_method = "6DCB4BA64977301CCE79D34F3045D8C8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.294 -0400", hash_original_method = "127603F69B46B56B0057C44974C5D0F5", hash_generated_method = "58656AACBD301EEBE46E095E01C7E732")
    public int getValue(int row, int column) {
        addTaint(column);
        addTaint(row);
        final int columns = mColumns;
    if(((row | column) < 0) || (row >= size()) || (column >= columns))        
        {
            IndexOutOfBoundsException varBDD876D8C48C6628B3208FA12558FDF5_2070887542 = new IndexOutOfBoundsException(row + ", " + column);
            varBDD876D8C48C6628B3208FA12558FDF5_2070887542.addTaint(taint);
            throw varBDD876D8C48C6628B3208FA12558FDF5_2070887542;
        } //End block
    if(row >= mRowGapStart)        
        {
            row += mRowGapLength;
        } //End block
        int value = mValues[row * columns + column];
        int[] valuegap = mValueGap;
    if(row >= valuegap[column])        
        {
            value += valuegap[column + columns];
        } //End block
        int var2063C1608D6E0BAF80249C42E2BE5804_1887975217 = (value);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1842962780 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1842962780;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.295 -0400", hash_original_method = "DF9491EC74B5A8AD3F1F814A7288BD27", hash_generated_method = "56A2DB8C61644CA37F36B04C9ECE525C")
    public void setValue(int row, int column, int value) {
    if(((row | column) < 0) || (row >= size()) || (column >= mColumns))        
        {
            IndexOutOfBoundsException varBDD876D8C48C6628B3208FA12558FDF5_1243659628 = new IndexOutOfBoundsException(row + ", " + column);
            varBDD876D8C48C6628B3208FA12558FDF5_1243659628.addTaint(taint);
            throw varBDD876D8C48C6628B3208FA12558FDF5_1243659628;
        } //End block
    if(row >= mRowGapStart)        
        {
            row += mRowGapLength;
        } //End block
        int[] valuegap = mValueGap;
    if(row >= valuegap[column])        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.296 -0400", hash_original_method = "339196B1319A98FF890A6A44D9B8F936", hash_generated_method = "A890ACBC1CA8B56AC017771E7ACC54FE")
    private void setValueInternal(int row, int column, int value) {
    if(row >= mRowGapStart)        
        {
            row += mRowGapLength;
        } //End block
        int[] valuegap = mValueGap;
    if(row >= valuegap[column])        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.297 -0400", hash_original_method = "717B6A8B8BE261E23908EA9C8BC6E7EA", hash_generated_method = "98D1C3BE2FFBB2591A20F51A65FBC23B")
    public void adjustValuesBelow(int startRow, int column, int delta) {
        addTaint(startRow);
    if(((startRow | column) < 0) || (startRow > size()) ||
                (column >= width()))        
        {
            IndexOutOfBoundsException varFAEEDFE22EEC9BA2F9980175CF1C3DD1_1345016342 = new IndexOutOfBoundsException(startRow + ", " + column);
            varFAEEDFE22EEC9BA2F9980175CF1C3DD1_1345016342.addTaint(taint);
            throw varFAEEDFE22EEC9BA2F9980175CF1C3DD1_1345016342;
        } //End block
    if(startRow >= mRowGapStart)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.297 -0400", hash_original_method = "6AE5D8E6865DDCD084B3272F01FD2E51", hash_generated_method = "B582FCC020781596586F3E8247F859A2")
    public void insertAt(int row, int[] values) {
        addTaint(values[0]);
        addTaint(row);
    if((row < 0) || (row > size()))        
        {
            IndexOutOfBoundsException var85DC1D3C6326D96841CD4E0FD5C9246A_341791529 = new IndexOutOfBoundsException("row " + row);
            var85DC1D3C6326D96841CD4E0FD5C9246A_341791529.addTaint(taint);
            throw var85DC1D3C6326D96841CD4E0FD5C9246A_341791529;
        } //End block
    if((values != null) && (values.length < width()))        
        {
            IndexOutOfBoundsException var9CD6FA6A5CEC43A0E95F99301E8E335E_354827217 = new IndexOutOfBoundsException("value count " + values.length);
            var9CD6FA6A5CEC43A0E95F99301E8E335E_354827217.addTaint(taint);
            throw var9CD6FA6A5CEC43A0E95F99301E8E335E_354827217;
        } //End block
        moveRowGapTo(row);
    if(mRowGapLength == 0)        
        {
            growBuffer();
        } //End block
        mRowGapStart++;
        mRowGapLength--;
    if(values == null)        
        {
for(int i = mColumns - 1;i >= 0;i--)
            {
                setValueInternal(row, i, 0);
            } //End block
        } //End block
        else
        {
for(int i = mColumns - 1;i >= 0;i--)
            {
                setValueInternal(row, i, values[i]);
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.298 -0400", hash_original_method = "29D77D40DB4AFADA133299814B25205C", hash_generated_method = "0B1153091A2ACB1683D8B7D8E626F972")
    public void deleteAt(int row, int count) {
        addTaint(row);
    if(((row | count) < 0) || (row + count > size()))        
        {
            IndexOutOfBoundsException varBDB07202BD380498CB903939EA7731A6_489175319 = new IndexOutOfBoundsException(row + ", " + count);
            varBDB07202BD380498CB903939EA7731A6_489175319.addTaint(taint);
            throw varBDB07202BD380498CB903939EA7731A6_489175319;
        } //End block
        moveRowGapTo(row + count);
        mRowGapStart -= count;
        mRowGapLength += count;
        // ---------- Original Method ----------
        //if (((row | count) < 0) || (row + count > size())) {
            //throw new IndexOutOfBoundsException(row + ", " + count);
        //}
        //moveRowGapTo(row + count);
        //mRowGapStart -= count;
        //mRowGapLength += count;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.299 -0400", hash_original_method = "A7F055B05F3BF0E7B9EF67A5904EF45B", hash_generated_method = "C9CF86E7F63EAC004457B34A96CA30AF")
    public int size() {
        int var60FCE0CE49C68973BD6EAD5B2D3866D1_1980156883 = (mRows - mRowGapLength);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_124182531 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_124182531;
        // ---------- Original Method ----------
        //return mRows - mRowGapLength;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.299 -0400", hash_original_method = "00C81AD9ACCD847707085D62472884FD", hash_generated_method = "872D72DB9854A3BDF8BEED9059432DC1")
    public int width() {
        int var11C985F30142FD30ACDDFE7CD3BD4A9B_652213598 = (mColumns);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1306657437 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1306657437;
        // ---------- Original Method ----------
        //return mColumns;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.300 -0400", hash_original_method = "B5C941269BF1E9CDD155EBF5B7D0DBA9", hash_generated_method = "96CC886EC5F83DB4FD4670263D01A615")
    private final void growBuffer() {
        final int columns = mColumns;
        int newsize = size() + 1;
        newsize = ArrayUtils.idealIntArraySize(newsize * columns) / columns;
        int[] newvalues = new int[newsize * columns];
        final int[] valuegap = mValueGap;
        final int rowgapstart = mRowGapStart;
        int after = mRows - (rowgapstart + mRowGapLength);
    if(mValues != null)        
        {
            System.arraycopy(mValues, 0, newvalues, 0, columns * rowgapstart);
            System.arraycopy(mValues, (mRows - after) * columns,
                             newvalues, (newsize - after) * columns,
                             after * columns);
        } //End block
for(int i = 0;i < columns;i++)
        {
    if(valuegap[i] >= rowgapstart)            
            {
                valuegap[i] += newsize - mRows;
    if(valuegap[i] < rowgapstart)                
                {
                    valuegap[i] = rowgapstart;
                } //End block
            } //End block
        } //End block
        mRowGapLength += newsize - mRows;
        mRows = newsize;
        mValues = newvalues;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.301 -0400", hash_original_method = "6D74A2161397D319519D26FF483664C7", hash_generated_method = "3AB19E5EF5F4BDA3FC54AB9BB6B39235")
    private final void moveValueGapTo(int column, int where) {
        addTaint(where);
        addTaint(column);
        final int[] valuegap = mValueGap;
        final int[] values = mValues;
        final int columns = mColumns;
    if(where == valuegap[column])        
        {
            return;
        } //End block
        else
    if(where > valuegap[column])        
        {
for(int i = valuegap[column];i < where;i++)
            {
                values[i * columns + column] += valuegap[column + columns];
            } //End block
        } //End block
        else
        {
for(int i = where;i < valuegap[column];i++)
            {
                values[i * columns + column] -= valuegap[column + columns];
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.302 -0400", hash_original_method = "6D396DEEC3DAD541F2D5DA5D46CC7D37", hash_generated_method = "A2F11BF6138504881F84DB80D0E37A77")
    private final void moveRowGapTo(int where) {
    if(where == mRowGapStart)        
        {
            return;
        } //End block
        else
    if(where > mRowGapStart)        
        {
            int moving = where + mRowGapLength - (mRowGapStart + mRowGapLength);
            final int columns = mColumns;
            final int[] valuegap = mValueGap;
            final int[] values = mValues;
            final int gapend = mRowGapStart + mRowGapLength;
for(int i = gapend;i < gapend + moving;i++)
            {
                int destrow = i - gapend + mRowGapStart;
for(int j = 0;j < columns;j++)
                {
                    int val = values[i * columns+ j];
    if(i >= valuegap[j])                    
                    {
                        val += valuegap[j + columns];
                    } //End block
    if(destrow >= valuegap[j])                    
                    {
                        val -= valuegap[j + columns];
                    } //End block
                    values[destrow * columns + j] = val;
                } //End block
            } //End block
        } //End block
        else
        {
            int moving = mRowGapStart - where;
            final int columns = mColumns;
            final int[] valuegap = mValueGap;
            final int[] values = mValues;
            final int gapend = mRowGapStart + mRowGapLength;
for(int i = where + moving - 1;i >= where;i--)
            {
                int destrow = i - where + gapend - moving;
for(int j = 0;j < columns;j++)
                {
                    int val = values[i * columns+ j];
    if(i >= valuegap[j])                    
                    {
                        val += valuegap[j + columns];
                    } //End block
    if(destrow >= valuegap[j])                    
                    {
                        val -= valuegap[j + columns];
                    } //End block
                    values[destrow * columns + j] = val;
                } //End block
            } //End block
        } //End block
        mRowGapStart = where;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

