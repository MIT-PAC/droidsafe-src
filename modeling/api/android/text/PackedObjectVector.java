package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import com.android.internal.util.ArrayUtils;

class PackedObjectVector<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.129 -0500", hash_original_field = "5D305AA3AFBCC646419732255616147E", hash_generated_field = "75F4039C98FB52077D38E34F530EB3FF")

    private int mColumns;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.132 -0500", hash_original_field = "62A7B245FE69D0C88FD3CBB3F9AE6568", hash_generated_field = "18B06BC67D1393EDA8ED9BB923EF7CD3")

    private int mRows;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.134 -0500", hash_original_field = "9828EB158F3AF7FD600C6FEB32A01FE4", hash_generated_field = "EA98696F1B775619308B0863F513F9F1")

    private int mRowGapStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.137 -0500", hash_original_field = "4E829280F69229C952DC0CF8B0968F13", hash_generated_field = "EB5D193EB3BD0BD6791276EC10232CBE")

    private int mRowGapLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.139 -0500", hash_original_field = "D3F28F3EBFA7D0D8D614CF293C7CCCA8", hash_generated_field = "8F96A7DD3A8AA044003D4A42FBE80825")

    private Object[] mValues;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.142 -0500", hash_original_method = "7647E7B16FB2C073A83B6C5C46BD0BB0", hash_generated_method = "4AAC06021A1B925441F85903A5548533")
    
public
    PackedObjectVector(int columns)
    {
        mColumns = columns;
        mRows = ArrayUtils.idealIntArraySize(0) / mColumns;

        mRowGapStart = 0;
        mRowGapLength = mRows;

        mValues = new Object[mRows * mColumns];
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.146 -0500", hash_original_method = "1C46B70362A26F7DECFFAE89D2DE52CF", hash_generated_method = "D5383D59D2326962D80334249643A70A")
    
public E
    getValue(int row, int column)
    {
        if (row >= mRowGapStart)
            row += mRowGapLength;

        Object value = mValues[row * mColumns + column];

        return (E) value;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.149 -0500", hash_original_method = "C9FAD217A876C18081065D61EE309BF7", hash_generated_method = "1C4CB6B3B88542BAF5B5FF7F7C41CEA4")
    
public void
    setValue(int row, int column, E value)
    {
        if (row >= mRowGapStart)
            row += mRowGapLength;

        mValues[row * mColumns + column] = value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.152 -0500", hash_original_method = "4D54718FEF2171E694149D7895F4552C", hash_generated_method = "053114478BC7B3C327679578A6F082B4")
    
public void
    insertAt(int row, E[] values)
    {
        moveRowGapTo(row);

        if (mRowGapLength == 0)
            growBuffer();

        mRowGapStart++;
        mRowGapLength--;

        if (values == null)
            for (int i = 0; i < mColumns; i++)
                setValue(row, i, null);
        else
            for (int i = 0; i < mColumns; i++)
                setValue(row, i, values[i]);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.155 -0500", hash_original_method = "E80F8248AEB29BC6824FCA0E99840E40", hash_generated_method = "FBB1F0388862EA283E30C069E223A03E")
    
public void
    deleteAt(int row, int count)
    {
        moveRowGapTo(row + count);

        mRowGapStart -= count;
        mRowGapLength += count;

        if (mRowGapLength > size() * 2)
        {
            // dump();
            // growBuffer();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.157 -0500", hash_original_method = "A7F055B05F3BF0E7B9EF67A5904EF45B", hash_generated_method = "74F46419807A9BD28AD5DC8BEC857162")
    
public int
    size()
    {
        return mRows - mRowGapLength;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.160 -0500", hash_original_method = "00C81AD9ACCD847707085D62472884FD", hash_generated_method = "525004621FECD4C505A7ED932738A65D")
    
public int
    width()
    {
        return mColumns;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.163 -0500", hash_original_method = "6242267CE6FD4DA11CE3B8DDDCD83B59", hash_generated_method = "18015842C631FB5BDF5FCC9C70E615C3")
    
private void
    growBuffer()
    {
        int newsize = size() + 1;
        newsize = ArrayUtils.idealIntArraySize(newsize * mColumns) / mColumns;
        Object[] newvalues = new Object[newsize * mColumns];

        int after = mRows - (mRowGapStart + mRowGapLength);

        System.arraycopy(mValues, 0, newvalues, 0, mColumns * mRowGapStart);
        System.arraycopy(mValues, (mRows - after) * mColumns, newvalues, (newsize - after) * mColumns, after * mColumns);

        mRowGapLength += newsize - mRows;
        mRows = newsize;
        mValues = newvalues;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.166 -0500", hash_original_method = "31F6FBDDD7D0FB1F20A58E1CEB067332", hash_generated_method = "B0D8EB4F9E4A1F89ADEE63DF0ABA44D4")
    
private void
    moveRowGapTo(int where)
    {
        if (where == mRowGapStart)
            return;

        if (where > mRowGapStart)
        {
            int moving = where + mRowGapLength - (mRowGapStart + mRowGapLength);

            for (int i = mRowGapStart + mRowGapLength; i < mRowGapStart + mRowGapLength + moving; i++)
            {
                int destrow = i - (mRowGapStart + mRowGapLength) + mRowGapStart;

                for (int j = 0; j < mColumns; j++)
                {
                    Object val = mValues[i * mColumns + j];

                    mValues[destrow * mColumns + j] = val;
                }
            }
        }
        else /* where < mRowGapStart */
        {
            int moving = mRowGapStart - where;

            for (int i = where + moving - 1; i >= where; i--)
            {
                int destrow = i - where + mRowGapStart + mRowGapLength - moving;

                for (int j = 0; j < mColumns; j++)
                {
                    Object val = mValues[i * mColumns + j];

                    mValues[destrow * mColumns + j] = val;
                }
            }
        }

        mRowGapStart = where;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.169 -0500", hash_original_method = "D4D4661D97DE10B055DBC1529423C904", hash_generated_method = "6737EEBB6642F6684DFFE4F81EA370A8")
    
public void // XXX
    dump()
    {
        for (int i = 0; i < mRows; i++)
        {
            for (int j = 0; j < mColumns; j++)
            {
                Object val = mValues[i * mColumns + j];

                if (i < mRowGapStart || i >= mRowGapStart + mRowGapLength)
                    System.out.print(val + " ");
                else
                    System.out.print("(" + val + ") ");
            }

            System.out.print(" << \n");
        }

        System.out.print("-----\n\n");
    }
    
}

