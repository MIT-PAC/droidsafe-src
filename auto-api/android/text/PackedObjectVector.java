package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.util.ArrayUtils;

class PackedObjectVector<E> {
    private int mColumns;
    private int mRows;
    private int mRowGapStart;
    private int mRowGapLength;
    private Object[] mValues;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.205 -0400", hash_original_method = "7647E7B16FB2C073A83B6C5C46BD0BB0", hash_generated_method = "8EF0AD72FA07489B96D6914F572083DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PackedObjectVector(int columns) {
        dsTaint.addTaint(columns);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.205 -0400", hash_original_method = "1C46B70362A26F7DECFFAE89D2DE52CF", hash_generated_method = "DE73C6AFB682DB6BD80C393C5941B890")
    @DSModeled(DSC.SAFE)
    public E getValue(int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        row += mRowGapLength;
        Object value;
        value = mValues[row * mColumns + column];
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (row >= mRowGapStart)
            //row += mRowGapLength;
        //Object value = mValues[row * mColumns + column];
        //return (E) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.205 -0400", hash_original_method = "C9FAD217A876C18081065D61EE309BF7", hash_generated_method = "47672D1C35BAA301DBAA180FCD7B1E8F")
    @DSModeled(DSC.SAFE)
    public void setValue(int row, int column, E value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        row += mRowGapLength;
        mValues[row * mColumns + column] = value;
        // ---------- Original Method ----------
        //if (row >= mRowGapStart)
            //row += mRowGapLength;
        //mValues[row * mColumns + column] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.206 -0400", hash_original_method = "4D54718FEF2171E694149D7895F4552C", hash_generated_method = "8AB502DB36FEA2E6BA25D8B273A6BC36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void insertAt(int row, E[] values) {
        dsTaint.addTaint(values[0].dsTaint);
        dsTaint.addTaint(row);
        moveRowGapTo(row);
        growBuffer();
        {
            int i;
            i = 0;
            setValue(row, i, null);
        } //End collapsed parenthetic
        {
            int i;
            i = 0;
            setValue(row, i, values[i]);
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.206 -0400", hash_original_method = "E80F8248AEB29BC6824FCA0E99840E40", hash_generated_method = "3367C13916FF527085FBC815BE5C3BB0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void deleteAt(int row, int count) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(row);
        moveRowGapTo(row + count);
        {
            boolean var26E99CD6B85A7FA237C6BDC9DA9F5FC7_954963211 = (mRowGapLength > size() * 2);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //moveRowGapTo(row + count);
        //mRowGapStart -= count;
        //mRowGapLength += count;
        //if (mRowGapLength > size() * 2)
        //{
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.206 -0400", hash_original_method = "A7F055B05F3BF0E7B9EF67A5904EF45B", hash_generated_method = "CAA6770BA698562A6C38FA565345F254")
    @DSModeled(DSC.SAFE)
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRows - mRowGapLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.206 -0400", hash_original_method = "00C81AD9ACCD847707085D62472884FD", hash_generated_method = "1333B547F3BD6F2C5B2A963D025D5E86")
    @DSModeled(DSC.SAFE)
    public int width() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mColumns;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.207 -0400", hash_original_method = "6242267CE6FD4DA11CE3B8DDDCD83B59", hash_generated_method = "4453CF50CA41B9A5E86983D2F13C64C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void growBuffer() {
        int newsize;
        newsize = size() + 1;
        newsize = ArrayUtils.idealIntArraySize(newsize * mColumns) / mColumns;
        Object[] newvalues;
        newvalues = new Object[newsize * mColumns];
        int after;
        after = mRows - (mRowGapStart + mRowGapLength);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.207 -0400", hash_original_method = "31F6FBDDD7D0FB1F20A58E1CEB067332", hash_generated_method = "E8A88DCC2EA3E419BF3FAB7E2DF2B35C")
    @DSModeled(DSC.SAFE)
    private void moveRowGapTo(int where) {
        dsTaint.addTaint(where);
        {
            int moving;
            moving = where + mRowGapLength - (mRowGapStart + mRowGapLength);
            {
                int i;
                i = mRowGapStart + mRowGapLength;
                {
                    int destrow;
                    destrow = i - (mRowGapStart + mRowGapLength) + mRowGapStart;
                    {
                        int j;
                        j = 0;
                        {
                            Object val;
                            val = mValues[i * mColumns + j];
                            mValues[destrow * mColumns + j] = val;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            int moving;
            moving = mRowGapStart - where;
            {
                int i;
                i = where + moving - 1;
                {
                    int destrow;
                    destrow = i - where + mRowGapStart + mRowGapLength - moving;
                    {
                        int j;
                        j = 0;
                        {
                            Object val;
                            val = mValues[i * mColumns + j];
                            mValues[destrow * mColumns + j] = val;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.208 -0400", hash_original_method = "D4D4661D97DE10B055DBC1529423C904", hash_generated_method = "5D101C2925463666319288E50873E35B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dump() {
        {
            int i;
            i = 0;
            {
                {
                    int j;
                    j = 0;
                    {
                        Object val;
                        val = mValues[i * mColumns + j];
                        System.out.print(val + " ");
                        System.out.print("(" + val + ") ");
                    } //End block
                } //End collapsed parenthetic
                System.out.print(" << \n");
            } //End block
        } //End collapsed parenthetic
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

