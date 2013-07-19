package java.nio;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

final class ReadWriteDoubleArrayBuffer extends DoubleArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.685 -0400", hash_original_method = "B4E24CEABED532340C057028C27A20CE", hash_generated_method = "94E77AA6E102F947FEF29D19E50CF5F5")
      ReadWriteDoubleArrayBuffer(double[] array) {
        super(array);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.686 -0400", hash_original_method = "7B955F583014E9C4E7246DF4D4A38AFC", hash_generated_method = "EB41EA5E489DBFB3334B7D9D360186C1")
      ReadWriteDoubleArrayBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.686 -0400", hash_original_method = "070D24C1E4BB222D9665C788C08CE160", hash_generated_method = "46C105BC38298713126612575D74DDEE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.687 -0400", hash_original_method = "5AAFDD62868C036C158BF06CDC5CBF15", hash_generated_method = "6C79B4F406471DAECFB95793F25BA697")
    @Override
    public DoubleBuffer asReadOnlyBuffer() {
DoubleBuffer var20B0BA473CE6FF86AB93C6E901F2517B_102056208 =         ReadOnlyDoubleArrayBuffer.copy(this, mark);
        var20B0BA473CE6FF86AB93C6E901F2517B_102056208.addTaint(taint);
        return var20B0BA473CE6FF86AB93C6E901F2517B_102056208;
        // ---------- Original Method ----------
        //return ReadOnlyDoubleArrayBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.687 -0400", hash_original_method = "335CB60FAB792A2A62A6EF4754C454D6", hash_generated_method = "8BD3DEF95D146EC3AF17272EF9B9849D")
    @Override
    public DoubleBuffer compact() {
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
DoubleBuffer var72A74007B2BE62B849F475C7BDA4658B_1580387434 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1580387434.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1580387434;
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.688 -0400", hash_original_method = "BCF332FB26078E1D870C2E24915718AE", hash_generated_method = "B10F1E574460EB9318B536CB5D3DAC06")
    @Override
    public DoubleBuffer duplicate() {
DoubleBuffer var6ED4708F04CD11720ECFFDBFD927116F_1598820059 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_1598820059.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_1598820059;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.688 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "1E96198082481C6B222643B84898BA95")
    @Override
    public boolean isReadOnly() {
        boolean var68934A3E9455FA72420237EB05902327_1785958383 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1060591222 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1060591222;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.688 -0400", hash_original_method = "B39E44D51BEA2E7F8F320F30D5A69080", hash_generated_method = "4366CC8B03F3FEEB49A319694A7E9EED")
    @Override
    protected double[] protectedArray() {
        double[] var8D50CD27AA8B6BEC65C484FFCC5B2334_561577372 = (backingArray);
                double[] var74D44D7D9EE6FE6C3433D694F869E521_1471611935 = {getTaintDouble()};
        return var74D44D7D9EE6FE6C3433D694F869E521_1471611935;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.689 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "7A95EC4B0740DB9A149305371E1B22D6")
    @Override
    protected int protectedArrayOffset() {
        int var7A86C157EE9713C34FBD7A1EE40F0C5A_292400708 = (offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_631617887 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_631617887;
        // ---------- Original Method ----------
        //return offset;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.689 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "F97C540BDF3D7086BEEC40ED4E59C604")
    @Override
    protected boolean protectedHasArray() {
        boolean varB326B5062B2F0E69046810717534CB09_1413039450 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1200265007 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1200265007;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.689 -0400", hash_original_method = "3ABE5CDAB9C61826E50F217BC06E7CD8", hash_generated_method = "633F51F1C7B41C351542DF84AB77B850")
    @Override
    public DoubleBuffer put(double c) {
        addTaint(c);
        if(position == limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1688496666 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1688496666.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1688496666;
        } //End block
        backingArray[offset + position++] = c;
DoubleBuffer var72A74007B2BE62B849F475C7BDA4658B_1342916189 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1342916189.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1342916189;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.690 -0400", hash_original_method = "C8225EBC0979909DB9C4BC520342492D", hash_generated_method = "9F16024E31379B0EC7C693EAF620B231")
    @Override
    public DoubleBuffer put(int index, double c) {
        addTaint(c);
        addTaint(index);
        checkIndex(index);
        backingArray[offset + index] = c;
DoubleBuffer var72A74007B2BE62B849F475C7BDA4658B_2115269598 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2115269598.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2115269598;
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.690 -0400", hash_original_method = "DCC0A3236B3D19199252F779E8F302AC", hash_generated_method = "B000199E715A7875667D1107E8BD4CB8")
    @Override
    public DoubleBuffer put(double[] src, int srcOffset, int doubleCount) {
        addTaint(doubleCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        if(doubleCount > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_584052209 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_584052209.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_584052209;
        } //End block
        System.arraycopy(src, srcOffset, backingArray, offset + position, doubleCount);
        position += doubleCount;
DoubleBuffer var72A74007B2BE62B849F475C7BDA4658B_887889195 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_887889195.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_887889195;
        // ---------- Original Method ----------
        //if (doubleCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //System.arraycopy(src, srcOffset, backingArray, offset + position, doubleCount);
        //position += doubleCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.690 -0400", hash_original_method = "34292390282C3C5B07F994751AC72ECC", hash_generated_method = "65D0ED722C9D89D2F476F6457C1A1188")
    @Override
    public DoubleBuffer slice() {
DoubleBuffer varE90987852C9448D1F6ECADB1CCED5380_732105272 =         new ReadWriteDoubleArrayBuffer(remaining(), backingArray, offset + position);
        varE90987852C9448D1F6ECADB1CCED5380_732105272.addTaint(taint);
        return varE90987852C9448D1F6ECADB1CCED5380_732105272;
        // ---------- Original Method ----------
        //return new ReadWriteDoubleArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

