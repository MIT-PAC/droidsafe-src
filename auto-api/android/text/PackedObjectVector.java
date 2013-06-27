package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.util.ArrayUtils;

class PackedObjectVector<E> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.546 -0400", hash_original_field = "11C985F30142FD30ACDDFE7CD3BD4A9B", hash_generated_field = "75F4039C98FB52077D38E34F530EB3FF")

    private int mColumns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.547 -0400", hash_original_field = "839FCD25B196D1E9D74989EB7586909A", hash_generated_field = "18B06BC67D1393EDA8ED9BB923EF7CD3")

    private int mRows;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.547 -0400", hash_original_field = "717D446B0EDDE3F55A9FB9E6279E6014", hash_generated_field = "EA98696F1B775619308B0863F513F9F1")

    private int mRowGapStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.547 -0400", hash_original_field = "2765BE84E84BC9CBE3B823946D881A10", hash_generated_field = "EB5D193EB3BD0BD6791276EC10232CBE")

    private int mRowGapLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.547 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "8F96A7DD3A8AA044003D4A42FBE80825")

    private Object[] mValues;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.548 -0400", hash_original_method = "7647E7B16FB2C073A83B6C5C46BD0BB0", hash_generated_method = "9A70858516039202D340CEF6E58AC618")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.560 -0400", hash_original_method = "1C46B70362A26F7DECFFAE89D2DE52CF", hash_generated_method = "22A7FB80AFDA22FD7335DE807A5FB202")
    public E getValue(int row, int column) {
        E varB4EAC82CA7396A68D541C85D26508E83_1087561347 = null; //Variable for return #1
        row += mRowGapLength;
        Object value;
        value = mValues[row * mColumns + column];
        varB4EAC82CA7396A68D541C85D26508E83_1087561347 = (E) value;
        addTaint(row);
        addTaint(column);
        varB4EAC82CA7396A68D541C85D26508E83_1087561347.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1087561347;
        // ---------- Original Method ----------
        //if (row >= mRowGapStart)
            //row += mRowGapLength;
        //Object value = mValues[row * mColumns + column];
        //return (E) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.561 -0400", hash_original_method = "C9FAD217A876C18081065D61EE309BF7", hash_generated_method = "95ED1069A1C7501E9F5428700785CE03")
    public void setValue(int row, int column, E value) {
        row += mRowGapLength;
        mValues[row * mColumns + column] = value;
        // ---------- Original Method ----------
        //if (row >= mRowGapStart)
            //row += mRowGapLength;
        //mValues[row * mColumns + column] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.563 -0400", hash_original_method = "4D54718FEF2171E694149D7895F4552C", hash_generated_method = "A7E048A26DA7AADD51D66181CDD314C9")
    public void insertAt(int row, E[] values) {
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
        addTaint(row);
        addTaint(values[0].getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.564 -0400", hash_original_method = "E80F8248AEB29BC6824FCA0E99840E40", hash_generated_method = "3DC9E3B1D817B8A2BB9963D8CFC95943")
    public void deleteAt(int row, int count) {
        moveRowGapTo(row + count);
        mRowGapStart -= count;
        mRowGapLength += count;
        {
            boolean var26E99CD6B85A7FA237C6BDC9DA9F5FC7_957879185 = (mRowGapLength > size() * 2);
        } //End collapsed parenthetic
        addTaint(row);
        // ---------- Original Method ----------
        //moveRowGapTo(row + count);
        //mRowGapStart -= count;
        //mRowGapLength += count;
        //if (mRowGapLength > size() * 2)
        //{
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.580 -0400", hash_original_method = "A7F055B05F3BF0E7B9EF67A5904EF45B", hash_generated_method = "5A99A6C0B9C6B313C08F5190F0528B3F")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1242684505 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1242684505;
        // ---------- Original Method ----------
        //return mRows - mRowGapLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.581 -0400", hash_original_method = "00C81AD9ACCD847707085D62472884FD", hash_generated_method = "31798C608343145B8A2F762A0F611E6C")
    public int width() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_195380678 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_195380678;
        // ---------- Original Method ----------
        //return mColumns;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.582 -0400", hash_original_method = "6242267CE6FD4DA11CE3B8DDDCD83B59", hash_generated_method = "4453CF50CA41B9A5E86983D2F13C64C4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.596 -0400", hash_original_method = "31F6FBDDD7D0FB1F20A58E1CEB067332", hash_generated_method = "20D719410B90A42B4D2EF884F67F9E5C")
    private void moveRowGapTo(int where) {
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
        mRowGapStart = where;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.597 -0400", hash_original_method = "D4D4661D97DE10B055DBC1529423C904", hash_generated_method = "5D101C2925463666319288E50873E35B")
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

