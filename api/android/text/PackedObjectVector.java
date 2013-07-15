package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.util.ArrayUtils;

class PackedObjectVector<E> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.321 -0400", hash_original_field = "11C985F30142FD30ACDDFE7CD3BD4A9B", hash_generated_field = "75F4039C98FB52077D38E34F530EB3FF")

    private int mColumns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.321 -0400", hash_original_field = "839FCD25B196D1E9D74989EB7586909A", hash_generated_field = "18B06BC67D1393EDA8ED9BB923EF7CD3")

    private int mRows;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.321 -0400", hash_original_field = "717D446B0EDDE3F55A9FB9E6279E6014", hash_generated_field = "EA98696F1B775619308B0863F513F9F1")

    private int mRowGapStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.321 -0400", hash_original_field = "2765BE84E84BC9CBE3B823946D881A10", hash_generated_field = "EB5D193EB3BD0BD6791276EC10232CBE")

    private int mRowGapLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.321 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "8F96A7DD3A8AA044003D4A42FBE80825")

    private Object[] mValues;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.322 -0400", hash_original_method = "7647E7B16FB2C073A83B6C5C46BD0BB0", hash_generated_method = "9A70858516039202D340CEF6E58AC618")
    public  PackedObjectVector(int columns) {
        mColumns = columns;
        mRows = ArrayUtils.idealIntArraySize(0) / mColumns;
        mRowGapStart = 0;
        mRowGapLength = mRows;
        mValues = new Object[mRows * mColumns];
        // ---------- Original Method ----------
        //mColumns = columns;
        //mRows = ArrayUtils.idealIntArraySize(0) / mColumns;
        //mRowGapStart = 0;
        //mRowGapLength = mRows;
        //mValues = new Object[mRows * mColumns];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.322 -0400", hash_original_method = "1C46B70362A26F7DECFFAE89D2DE52CF", hash_generated_method = "2BC5924873A9820D041E7CA27FD21880")
    public E getValue(int row, int column) {
        addTaint(column);
        addTaint(row);
    if(row >= mRowGapStart)        
        row += mRowGapLength;
        Object value = mValues[row * mColumns + column];
E var1003C6094065F51E703D3FC5DD353D7E_2028946821 =         (E) value;
        var1003C6094065F51E703D3FC5DD353D7E_2028946821.addTaint(taint);
        return var1003C6094065F51E703D3FC5DD353D7E_2028946821;
        // ---------- Original Method ----------
        //if (row >= mRowGapStart)
            //row += mRowGapLength;
        //Object value = mValues[row * mColumns + column];
        //return (E) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.323 -0400", hash_original_method = "C9FAD217A876C18081065D61EE309BF7", hash_generated_method = "D37DDFDC406B0976D016D614124D6C6D")
    public void setValue(int row, int column, E value) {
    if(row >= mRowGapStart)        
        row += mRowGapLength;
        mValues[row * mColumns + column] = value;
        // ---------- Original Method ----------
        //if (row >= mRowGapStart)
            //row += mRowGapLength;
        //mValues[row * mColumns + column] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.324 -0400", hash_original_method = "4D54718FEF2171E694149D7895F4552C", hash_generated_method = "E1954D0D4AE9F0765712067ED7F6E68D")
    public void insertAt(int row, E[] values) {
        addTaint(values[0].getTaint());
        addTaint(row);
        moveRowGapTo(row);
    if(mRowGapLength == 0)        
        growBuffer();
        mRowGapStart++;
        mRowGapLength--;
    if(values == null)        
for(int i = 0;i < mColumns;i++)
        setValue(row, i, null);
        else
for(int i = 0;i < mColumns;i++)
        setValue(row, i, values[i]);
        // ---------- Original Method ----------
        //moveRowGapTo(row);
        //if (mRowGapLength == 0)
            //growBuffer();
        //mRowGapStart++;
        //mRowGapLength--;
        //if (values == null)
            //for (int i = 0; i < mColumns; i++)
                //setValue(row, i, null);
        //else
            //for (int i = 0; i < mColumns; i++)
                //setValue(row, i, values[i]);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.325 -0400", hash_original_method = "E80F8248AEB29BC6824FCA0E99840E40", hash_generated_method = "023C92C55A5CCD9C4772B1FAF775CE48")
    public void deleteAt(int row, int count) {
        addTaint(row);
        moveRowGapTo(row + count);
        mRowGapStart -= count;
        mRowGapLength += count;
    if(mRowGapLength > size() * 2)        
        {
        } //End block
        // ---------- Original Method ----------
        //moveRowGapTo(row + count);
        //mRowGapStart -= count;
        //mRowGapLength += count;
        //if (mRowGapLength > size() * 2)
        //{
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.325 -0400", hash_original_method = "A7F055B05F3BF0E7B9EF67A5904EF45B", hash_generated_method = "B406F0AC07FB02825EC3BF1FA9AFDA26")
    public int size() {
        int var60FCE0CE49C68973BD6EAD5B2D3866D1_1459357090 = (mRows - mRowGapLength);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1300615712 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1300615712;
        // ---------- Original Method ----------
        //return mRows - mRowGapLength;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.326 -0400", hash_original_method = "00C81AD9ACCD847707085D62472884FD", hash_generated_method = "4590DCB26BDEB902D87D1F061EC74E7E")
    public int width() {
        int var11C985F30142FD30ACDDFE7CD3BD4A9B_1432516555 = (mColumns);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_428719218 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_428719218;
        // ---------- Original Method ----------
        //return mColumns;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.328 -0400", hash_original_method = "6242267CE6FD4DA11CE3B8DDDCD83B59", hash_generated_method = "76CD3949D59289F5C314469443F38C9B")
    private void growBuffer() {
        int newsize = size() + 1;
        newsize = ArrayUtils.idealIntArraySize(newsize * mColumns) / mColumns;
        Object[] newvalues = new Object[newsize * mColumns];
        int after = mRows - (mRowGapStart + mRowGapLength);
        System.arraycopy(mValues, 0, newvalues, 0, mColumns * mRowGapStart);
        System.arraycopy(mValues, (mRows - after) * mColumns, newvalues, (newsize - after) * mColumns, after * mColumns);
        mRowGapLength += newsize - mRows;
        mRows = newsize;
        mValues = newvalues;
        // ---------- Original Method ----------
        //int newsize = size() + 1;
        //newsize = ArrayUtils.idealIntArraySize(newsize * mColumns) / mColumns;
        //Object[] newvalues = new Object[newsize * mColumns];
        //int after = mRows - (mRowGapStart + mRowGapLength);
        //System.arraycopy(mValues, 0, newvalues, 0, mColumns * mRowGapStart);
        //System.arraycopy(mValues, (mRows - after) * mColumns, newvalues, (newsize - after) * mColumns, after * mColumns);
        //mRowGapLength += newsize - mRows;
        //mRows = newsize;
        //mValues = newvalues;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.330 -0400", hash_original_method = "31F6FBDDD7D0FB1F20A58E1CEB067332", hash_generated_method = "5FE94BC6192458A151DB187330779CB5")
    private void moveRowGapTo(int where) {
    if(where == mRowGapStart)        
        return;
    if(where > mRowGapStart)        
        {
            int moving = where + mRowGapLength - (mRowGapStart + mRowGapLength);
for(int i = mRowGapStart + mRowGapLength;i < mRowGapStart + mRowGapLength + moving;i++)
            {
                int destrow = i - (mRowGapStart + mRowGapLength) + mRowGapStart;
for(int j = 0;j < mColumns;j++)
                {
                    Object val = mValues[i * mColumns + j];
                    mValues[destrow * mColumns + j] = val;
                } //End block
            } //End block
        } //End block
        else
        {
            int moving = mRowGapStart - where;
for(int i = where + moving - 1;i >= where;i--)
            {
                int destrow = i - where + mRowGapStart + mRowGapLength - moving;
for(int j = 0;j < mColumns;j++)
                {
                    Object val = mValues[i * mColumns + j];
                    mValues[destrow * mColumns + j] = val;
                } //End block
            } //End block
        } //End block
        mRowGapStart = where;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.331 -0400", hash_original_method = "D4D4661D97DE10B055DBC1529423C904", hash_generated_method = "A1FB8E7AC3A82954571F9B34F02DA715")
    public void dump() {
for(int i = 0;i < mRows;i++)
        {
for(int j = 0;j < mColumns;j++)
            {
                Object val = mValues[i * mColumns + j];
    if(i < mRowGapStart || i >= mRowGapStart + mRowGapLength)                
                System.out.print(val + " ");
                else
                System.out.print("(" + val + ") ");
            } //End block
            System.out.print(" << \n");
        } //End block
        System.out.print("-----\n\n");
        // ---------- Original Method ----------
        //for (int i = 0; i < mRows; i++)
        //{
            //for (int j = 0; j < mColumns; j++)
            //{
                //Object val = mValues[i * mColumns + j];
                //if (i < mRowGapStart || i >= mRowGapStart + mRowGapLength)
                    //System.out.print(val + " ");
                //else
                    //System.out.print("(" + val + ") ");
            //}
            //System.out.print(" << \n");
        //}
        //System.out.print("-----\n\n");
    }

    
}

