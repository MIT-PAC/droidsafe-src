package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadWriteDoubleArrayBuffer extends DoubleArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.926 -0400", hash_original_method = "B4E24CEABED532340C057028C27A20CE", hash_generated_method = "30DD4679B5186BAE4A2F06B95707AF49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadWriteDoubleArrayBuffer(double[] array) {
        super(array);
        dsTaint.addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.927 -0400", hash_original_method = "7B955F583014E9C4E7246DF4D4A38AFC", hash_generated_method = "1F96B7091F197D38E55140B896526D86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadWriteDoubleArrayBuffer(int capacity) {
        super(capacity);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.927 -0400", hash_original_method = "070D24C1E4BB222D9665C788C08CE160", hash_generated_method = "001440A74C1335960B41C844B6945BE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadWriteDoubleArrayBuffer(int capacity, double[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        dsTaint.addTaint(backingArray[0]);
        dsTaint.addTaint(arrayOffset);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
        static ReadWriteDoubleArrayBuffer copy(DoubleArrayBuffer other, int markOfOther) {
        ReadWriteDoubleArrayBuffer buf =
                new ReadWriteDoubleArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.927 -0400", hash_original_method = "5AAFDD62868C036C158BF06CDC5CBF15", hash_generated_method = "FCDFB3B6A1DB09C86885E65E7492E5C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public DoubleBuffer asReadOnlyBuffer() {
        DoubleBuffer var4A22C6C66D99A80E0D3EB6E3EAFB318E_212297554 = (ReadOnlyDoubleArrayBuffer.copy(this, mark));
        return (DoubleBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ReadOnlyDoubleArrayBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.927 -0400", hash_original_method = "335CB60FAB792A2A62A6EF4754C454D6", hash_generated_method = "3447538E7DA7132946793A16BAADB1CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public DoubleBuffer compact() {
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return (DoubleBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.927 -0400", hash_original_method = "BCF332FB26078E1D870C2E24915718AE", hash_generated_method = "61A4A83A3ACF378644D1698682613165")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public DoubleBuffer duplicate() {
        DoubleBuffer var8C82ED9E4FDE12C9486E1252174918B6_278204100 = (copy(this, mark));
        return (DoubleBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.928 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "1F2BF0EB1F192C8C411CC0427A2B9F5B")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isReadOnly() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.928 -0400", hash_original_method = "B39E44D51BEA2E7F8F320F30D5A69080", hash_generated_method = "B0A39144046DC35FE5273B01ACCFBF0D")
    @DSModeled(DSC.SAFE)
    @Override
    protected double[] protectedArray() {
        double[] retVal = new double[1];
        retVal[0] = dsTaint.getTaintFloat();
        return retVal;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.928 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "B6AF1441163DC81E5A7523DBEAED19DC")
    @DSModeled(DSC.SAFE)
    @Override
    protected int protectedArrayOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.928 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "F14C0EBC785314AEABBE7CBCFAB3FB1D")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean protectedHasArray() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.928 -0400", hash_original_method = "3ABE5CDAB9C61826E50F217BC06E7CD8", hash_generated_method = "788FF11AD7444EC6E76F187DA022982F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public DoubleBuffer put(double c) {
        dsTaint.addTaint(c);
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        backingArray[offset + position++] = c;
        return (DoubleBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.928 -0400", hash_original_method = "C8225EBC0979909DB9C4BC520342492D", hash_generated_method = "4E3E9EA760F716757EA18C104CB1F339")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public DoubleBuffer put(int index, double c) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(c);
        checkIndex(index);
        backingArray[offset + index] = c;
        return (DoubleBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.929 -0400", hash_original_method = "DCC0A3236B3D19199252F779E8F302AC", hash_generated_method = "B1CF8FC53166E3758A95C1A537303A50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public DoubleBuffer put(double[] src, int srcOffset, int doubleCount) {
        dsTaint.addTaint(doubleCount);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        {
            boolean var74C0A42AB3BAE67C7C3CC56E2CA2CC6D_1469811880 = (doubleCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(src, srcOffset, backingArray, offset + position, doubleCount);
        position += doubleCount;
        return (DoubleBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (doubleCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //System.arraycopy(src, srcOffset, backingArray, offset + position, doubleCount);
        //position += doubleCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.929 -0400", hash_original_method = "34292390282C3C5B07F994751AC72ECC", hash_generated_method = "2FD826DC7757AC582E71E412D167B70F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public DoubleBuffer slice() {
        DoubleBuffer varA87670A0FADC7C2B399FBFC205F5700A_894439676 = (new ReadWriteDoubleArrayBuffer(remaining(), backingArray, offset + position));
        return (DoubleBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ReadWriteDoubleArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

