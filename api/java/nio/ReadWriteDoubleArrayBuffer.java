package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

final class ReadWriteDoubleArrayBuffer extends DoubleArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.096 -0400", hash_original_method = "B4E24CEABED532340C057028C27A20CE", hash_generated_method = "94E77AA6E102F947FEF29D19E50CF5F5")
      ReadWriteDoubleArrayBuffer(double[] array) {
        super(array);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.097 -0400", hash_original_method = "7B955F583014E9C4E7246DF4D4A38AFC", hash_generated_method = "EB41EA5E489DBFB3334B7D9D360186C1")
      ReadWriteDoubleArrayBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.097 -0400", hash_original_method = "070D24C1E4BB222D9665C788C08CE160", hash_generated_method = "46C105BC38298713126612575D74DDEE")
      ReadWriteDoubleArrayBuffer(int capacity, double[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(arrayOffset);
        addTaint(backingArray[0]);
        addTaint(capacity);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.098 -0400", hash_original_method = "5AAFDD62868C036C158BF06CDC5CBF15", hash_generated_method = "24B78A3AF65935A427EBEC0E541E60C5")
    @Override
    public DoubleBuffer asReadOnlyBuffer() {
DoubleBuffer var20B0BA473CE6FF86AB93C6E901F2517B_579011577 =         ReadOnlyDoubleArrayBuffer.copy(this, mark);
        var20B0BA473CE6FF86AB93C6E901F2517B_579011577.addTaint(taint);
        return var20B0BA473CE6FF86AB93C6E901F2517B_579011577;
        // ---------- Original Method ----------
        //return ReadOnlyDoubleArrayBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.098 -0400", hash_original_method = "335CB60FAB792A2A62A6EF4754C454D6", hash_generated_method = "B8CB106C6E924237D3410EDABCB96C9A")
    @Override
    public DoubleBuffer compact() {
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
DoubleBuffer var72A74007B2BE62B849F475C7BDA4658B_1855307325 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1855307325.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1855307325;
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.099 -0400", hash_original_method = "BCF332FB26078E1D870C2E24915718AE", hash_generated_method = "F2581C2A8BAC1AB9E68E498E1347D092")
    @Override
    public DoubleBuffer duplicate() {
DoubleBuffer var6ED4708F04CD11720ECFFDBFD927116F_1611044836 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_1611044836.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_1611044836;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.099 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "2DB4459575C67DE16E4A26AF1AC3DE4C")
    @Override
    public boolean isReadOnly() {
        boolean var68934A3E9455FA72420237EB05902327_1515814199 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2004297774 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2004297774;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.100 -0400", hash_original_method = "B39E44D51BEA2E7F8F320F30D5A69080", hash_generated_method = "F2381CF7B4FC272F076E7F9EFFD693D9")
    @Override
    protected double[] protectedArray() {
        double[] var8D50CD27AA8B6BEC65C484FFCC5B2334_2136398447 = (backingArray);
                double[] var74D44D7D9EE6FE6C3433D694F869E521_341252420 = {getTaintDouble()};
        return var74D44D7D9EE6FE6C3433D694F869E521_341252420;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.100 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "9863461110212B9EDF9557993B0828DD")
    @Override
    protected int protectedArrayOffset() {
        int var7A86C157EE9713C34FBD7A1EE40F0C5A_49260741 = (offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_932793637 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_932793637;
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.100 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "DAE27B1EB2A1FD291F992982A30269BF")
    @Override
    protected boolean protectedHasArray() {
        boolean varB326B5062B2F0E69046810717534CB09_954483970 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2101434767 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2101434767;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.101 -0400", hash_original_method = "3ABE5CDAB9C61826E50F217BC06E7CD8", hash_generated_method = "C6497E6772F012E09FBF4DE9608C9526")
    @Override
    public DoubleBuffer put(double c) {
        addTaint(c);
    if(position == limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1264282210 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1264282210.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1264282210;
        } //End block
        backingArray[offset + position++] = c;
DoubleBuffer var72A74007B2BE62B849F475C7BDA4658B_1636598134 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1636598134.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1636598134;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.102 -0400", hash_original_method = "C8225EBC0979909DB9C4BC520342492D", hash_generated_method = "31176A9C781F3BEDAF307E95B85E81C6")
    @Override
    public DoubleBuffer put(int index, double c) {
        addTaint(c);
        addTaint(index);
        checkIndex(index);
        backingArray[offset + index] = c;
DoubleBuffer var72A74007B2BE62B849F475C7BDA4658B_2120200016 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2120200016.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2120200016;
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.102 -0400", hash_original_method = "DCC0A3236B3D19199252F779E8F302AC", hash_generated_method = "36D76E76D135070A27C9E8D7C703F095")
    @Override
    public DoubleBuffer put(double[] src, int srcOffset, int doubleCount) {
        addTaint(doubleCount);
        addTaint(srcOffset);
        addTaint(src[0]);
    if(doubleCount > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1933463235 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1933463235.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1933463235;
        } //End block
        System.arraycopy(src, srcOffset, backingArray, offset + position, doubleCount);
        position += doubleCount;
DoubleBuffer var72A74007B2BE62B849F475C7BDA4658B_2091956297 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2091956297.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2091956297;
        // ---------- Original Method ----------
        //if (doubleCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //System.arraycopy(src, srcOffset, backingArray, offset + position, doubleCount);
        //position += doubleCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.103 -0400", hash_original_method = "34292390282C3C5B07F994751AC72ECC", hash_generated_method = "CF56327C14A4C27C4D52F2F3B9DE42DE")
    @Override
    public DoubleBuffer slice() {
DoubleBuffer varE90987852C9448D1F6ECADB1CCED5380_1746920111 =         new ReadWriteDoubleArrayBuffer(remaining(), backingArray, offset + position);
        varE90987852C9448D1F6ECADB1CCED5380_1746920111.addTaint(taint);
        return varE90987852C9448D1F6ECADB1CCED5380_1746920111;
        // ---------- Original Method ----------
        //return new ReadWriteDoubleArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

