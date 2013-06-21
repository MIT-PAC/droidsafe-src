package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

abstract class LongArrayBuffer extends LongBuffer {
    protected long[] backingArray;
    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.788 -0400", hash_original_method = "D20A97F337BC1EF41CF62C2D80A010BB", hash_generated_method = "E561DD84154A5EB86DA443A55079E4C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     LongArrayBuffer(long[] array) {
        this(array.length, array, 0);
        dsTaint.addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.789 -0400", hash_original_method = "EE894B007B87BC6BD13255E42716BBF0", hash_generated_method = "65C7A2A9C581C19A7D415738B1E4AD45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     LongArrayBuffer(int capacity) {
        this(capacity, new long[capacity], 0);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.790 -0400", hash_original_method = "C693B30298FFAD9EFA29C4595321A1EB", hash_generated_method = "38827D5A782C5952581B683B7E67728C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     LongArrayBuffer(int capacity, long[] backingArray, int offset) {
        super(capacity);
        dsTaint.addTaint(backingArray[0]);
        dsTaint.addTaint(capacity);
        dsTaint.addTaint(offset);
        // ---------- Original Method ----------
        //this.backingArray = backingArray;
        //this.offset = offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.790 -0400", hash_original_method = "E2FF30257BFFCB6B65D7425E7B88C7B2", hash_generated_method = "071F6218DBA6D17433CCD1A440C0469C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final long get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return backingArray[offset + position++];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.790 -0400", hash_original_method = "E501A733A2C96D5405AAE01CF07D222B", hash_generated_method = "371EDD9D7D6D1045C36889C4CE353880")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final long get(int index) {
        dsTaint.addTaint(index);
        checkIndex(index);
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //checkIndex(index);
        //return backingArray[offset + index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.790 -0400", hash_original_method = "E85CBDF91AD45B8A94165F7B57575CBE", hash_generated_method = "8D6B797E448A90521E8885653ECA3895")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final LongBuffer get(long[] dst, int dstOffset, int longCount) {
        dsTaint.addTaint(longCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        {
            boolean var689C4001D724360528D46748438966DA_1399770277 = (longCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(backingArray, offset + position, dst, dstOffset, longCount);
        position += longCount;
        return (LongBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (longCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //System.arraycopy(backingArray, offset + position, dst, dstOffset, longCount);
        //position += longCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.791 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "7E7C9B3B0EC5D6CFC1C636F6242D264A")
    @DSModeled(DSC.SAFE)
    @Override
    public final boolean isDirect() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.791 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "6CE187D23A129121D11BA1814ED7BDDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final ByteOrder order() {
        ByteOrder var65FB841C6DEFAE151AADF2CD2F0C0FB5_260360946 = (ByteOrder.nativeOrder());
        return (ByteOrder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ByteOrder.nativeOrder();
    }

    
}

