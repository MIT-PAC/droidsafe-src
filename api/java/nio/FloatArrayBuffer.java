package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

abstract class FloatArrayBuffer extends FloatBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.984 -0400", hash_original_field = "8D50CD27AA8B6BEC65C484FFCC5B2334", hash_generated_field = "8679C1DDE03C0998C5B4254D7B007554")

    protected float[] backingArray;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.984 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.985 -0400", hash_original_method = "D11EDAC27157134F6D93222FED96804A", hash_generated_method = "235954FFD5A65E27D2B4AC86646DAA42")
      FloatArrayBuffer(float[] array) {
        this(array.length, array, 0);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.985 -0400", hash_original_method = "1F51B561748313656A83CE5668F8D726", hash_generated_method = "6ABAF8ACDB270E1271ACAA69FBF587EF")
      FloatArrayBuffer(int capacity) {
        this(capacity, new float[capacity], 0);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.987 -0400", hash_original_method = "08256304DC715C68C786DDFF589B597E", hash_generated_method = "97450B9F3DF4B625F7689966430B11A4")
      FloatArrayBuffer(int capacity, float[] backingArray, int offset) {
        super(capacity);
        addTaint(capacity);
        this.backingArray = backingArray;
        this.offset = offset;
        // ---------- Original Method ----------
        //this.backingArray = backingArray;
        //this.offset = offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.988 -0400", hash_original_method = "27C2E9E0DC08E8F6369DBB2405A9C20A", hash_generated_method = "DEC670C32A9BE05BC24E9F872608887D")
    @Override
    public final float get() {
        if(position == limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1324148126 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1324148126.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1324148126;
        } //End block
        float varD1A88672373807059A15983DE4C2AC9F_921609652 = (backingArray[offset + position++]);
                float var546ADE640B6EDFBC8A086EF31347E768_387078846 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_387078846;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return backingArray[offset + position++];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.989 -0400", hash_original_method = "7B23CE1A9B110702665631EFEB3A42BD", hash_generated_method = "E75026ED255306B4AAC0B4B271C9B9C5")
    @Override
    public final float get(int index) {
        addTaint(index);
        checkIndex(index);
        float varF4617D5762E2F642102CBB5F4FA87F0A_1345104451 = (backingArray[offset + index]);
                float var546ADE640B6EDFBC8A086EF31347E768_235793178 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_235793178;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return backingArray[offset + index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.990 -0400", hash_original_method = "0E5CD729EA86ED4C8F1722765DDD0E33", hash_generated_method = "2073A9C153F8AD7838706912F9A0DA58")
    @Override
    public final FloatBuffer get(float[] dst, int dstOffset, int floatCount) {
        addTaint(floatCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        if(floatCount > remaining())        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_273426704 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_273426704.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_273426704;
        } //End block
        System.arraycopy(backingArray, offset + position, dst, dstOffset, floatCount);
        position += floatCount;
FloatBuffer var72A74007B2BE62B849F475C7BDA4658B_1972536779 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1972536779.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1972536779;
        // ---------- Original Method ----------
        //if (floatCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //System.arraycopy(backingArray, offset + position, dst, dstOffset, floatCount);
        //position += floatCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.992 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "B38CB7A1C3A8278D02BF5E2FECFDB5CB")
    @Override
    public final boolean isDirect() {
        boolean var68934A3E9455FA72420237EB05902327_1277726331 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1202193116 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1202193116;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.992 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "DBB7917192B244D348682D180F39939B")
    @Override
    public final ByteOrder order() {
ByteOrder var1B533639214E0AD13A9C318946B77D59_1347058929 =         ByteOrder.nativeOrder();
        var1B533639214E0AD13A9C318946B77D59_1347058929.addTaint(taint);
        return var1B533639214E0AD13A9C318946B77D59_1347058929;
        // ---------- Original Method ----------
        //return ByteOrder.nativeOrder();
    }

    
}

