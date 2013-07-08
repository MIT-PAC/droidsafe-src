package android.text;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import com.android.internal.util.ArrayUtils;

class PackedObjectVector<E> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.127 -0400", hash_original_field = "11C985F30142FD30ACDDFE7CD3BD4A9B", hash_generated_field = "75F4039C98FB52077D38E34F530EB3FF")

    private int mColumns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.127 -0400", hash_original_field = "839FCD25B196D1E9D74989EB7586909A", hash_generated_field = "18B06BC67D1393EDA8ED9BB923EF7CD3")

    private int mRows;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.127 -0400", hash_original_field = "717D446B0EDDE3F55A9FB9E6279E6014", hash_generated_field = "EA98696F1B775619308B0863F513F9F1")

    private int mRowGapStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.127 -0400", hash_original_field = "2765BE84E84BC9CBE3B823946D881A10", hash_generated_field = "EB5D193EB3BD0BD6791276EC10232CBE")

    private int mRowGapLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.127 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "8F96A7DD3A8AA044003D4A42FBE80825")

    private Object[] mValues;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.127 -0400", hash_original_method = "7647E7B16FB2C073A83B6C5C46BD0BB0", hash_generated_method = "9A70858516039202D340CEF6E58AC618")
    public  PackedObjectVector(int columns) {
        mColumns = columns;
        mRows = ArrayUtils.idealIntArraySize(0) / mColumns;
        mRowGapStart = 0;
        mRowGapLength = mRows;
        mValues = new Object[mRows * mColumns];
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.128 -0400", hash_original_method = "1C46B70362A26F7DECFFAE89D2DE52CF", hash_generated_method = "9FCBB2E7F0E31D3E2E66ADC89BC083F5")
    public E getValue(int row, int column) {
        E varB4EAC82CA7396A68D541C85D26508E83_2087647354 = null; 
        row += mRowGapLength;
        Object value = mValues[row * mColumns + column];
        varB4EAC82CA7396A68D541C85D26508E83_2087647354 = (E) value;
        addTaint(row);
        addTaint(column);
        varB4EAC82CA7396A68D541C85D26508E83_2087647354.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2087647354;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.128 -0400", hash_original_method = "C9FAD217A876C18081065D61EE309BF7", hash_generated_method = "95ED1069A1C7501E9F5428700785CE03")
    public void setValue(int row, int column, E value) {
        row += mRowGapLength;
        mValues[row * mColumns + column] = value;
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.129 -0400", hash_original_method = "4D54718FEF2171E694149D7895F4552C", hash_generated_method = "16E2978AD88839ECAAEFA96FCC8BF28B")
    public void insertAt(int row, E[] values) {
        moveRowGapTo(row);
        growBuffer();
        {
            int i = 0;
            setValue(row, i, null);
        } 
        {
            int i = 0;
            setValue(row, i, values[i]);
        } 
        addTaint(row);
        addTaint(values[0].getTaint());
        
        
        
            
        
        
        
            
                
        
            
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.130 -0400", hash_original_method = "E80F8248AEB29BC6824FCA0E99840E40", hash_generated_method = "961D57DB08A63D7C544F3F7398D1838D")
    public void deleteAt(int row, int count) {
        moveRowGapTo(row + count);
        mRowGapStart -= count;
        mRowGapLength += count;
        {
            boolean var26E99CD6B85A7FA237C6BDC9DA9F5FC7_1668156727 = (mRowGapLength > size() * 2);
        } 
        addTaint(row);
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.130 -0400", hash_original_method = "A7F055B05F3BF0E7B9EF67A5904EF45B", hash_generated_method = "D6B10E4FD374C8B14D1D57E743E89C17")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2106607043 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2106607043;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.131 -0400", hash_original_method = "00C81AD9ACCD847707085D62472884FD", hash_generated_method = "72F191941931A1B830974C096884B628")
    public int width() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_325988499 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_325988499;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.132 -0400", hash_original_method = "6242267CE6FD4DA11CE3B8DDDCD83B59", hash_generated_method = "76CD3949D59289F5C314469443F38C9B")
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
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.132 -0400", hash_original_method = "31F6FBDDD7D0FB1F20A58E1CEB067332", hash_generated_method = "6B6099B3E3EE158B2610EC8DCFE039E0")
    private void moveRowGapTo(int where) {
        {
            int moving = where + mRowGapLength - (mRowGapStart + mRowGapLength);
            {
                int i = mRowGapStart + mRowGapLength;
                {
                    int destrow = i - (mRowGapStart + mRowGapLength) + mRowGapStart;
                    {
                        int j = 0;
                        {
                            Object val = mValues[i * mColumns + j];
                            mValues[destrow * mColumns + j] = val;
                        } 
                    } 
                } 
            } 
        } 
        {
            int moving = mRowGapStart - where;
            {
                int i = where + moving - 1;
                {
                    int destrow = i - where + mRowGapStart + mRowGapLength - moving;
                    {
                        int j = 0;
                        {
                            Object val = mValues[i * mColumns + j];
                            mValues[destrow * mColumns + j] = val;
                        } 
                    } 
                } 
            } 
        } 
        mRowGapStart = where;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.133 -0400", hash_original_method = "D4D4661D97DE10B055DBC1529423C904", hash_generated_method = "94BDE0E45722C50571ACF457F4AFEC77")
    public void dump() {
        {
            int i = 0;
            {
                {
                    int j = 0;
                    {
                        Object val = mValues[i * mColumns + j];
                        System.out.print(val + " ");
                        System.out.print("(" + val + ") ");
                    } 
                } 
                System.out.print(" << \n");
            } 
        } 
        System.out.print("-----\n\n");
        
        
        
            
            
                
                
                    
                
                    
            
            
        
        
    }

    
}

