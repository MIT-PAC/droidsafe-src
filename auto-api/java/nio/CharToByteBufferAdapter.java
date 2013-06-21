package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.io.SizeOf;

final class CharToByteBufferAdapter extends CharBuffer {
    private ByteBuffer byteBuffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.570 -0400", hash_original_method = "20CC34DEF3812E72CBA72992E239D17C", hash_generated_method = "83A1D5F87D418DF74036A06CB2999F86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharToByteBufferAdapter(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.CHAR);
        dsTaint.addTaint(byteBuffer.dsTaint);
        this.byteBuffer.clear();
        this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
        // ---------- Original Method ----------
        //this.byteBuffer = byteBuffer;
        //this.byteBuffer.clear();
        //this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
    }

    
        static CharBuffer asCharBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new CharToByteBufferAdapter(slice);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.571 -0400", hash_original_method = "38E7AC500E9C1BA37DDE4BE628E69019", hash_generated_method = "CF6C27E9B4DBD0B6B4D552401977F0E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer asReadOnlyBuffer() {
        CharToByteBufferAdapter buf;
        buf = new CharToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //CharToByteBufferAdapter buf = new CharToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //buf.byteBuffer.order = byteBuffer.order;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.572 -0400", hash_original_method = "2B216932B774F9FB3B903B024B1F44DD", hash_generated_method = "75FB0074C7E3FAC4B9EAD96CA0B18496")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer compact() {
        {
            boolean varD77B6130B34264A0EF448C4235FCDE48_1969567264 = (byteBuffer.isReadOnly());
            {
                if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
            } //End block
        } //End collapsed parenthetic
        byteBuffer.limit(limit * SizeOf.CHAR);
        byteBuffer.position(position * SizeOf.CHAR);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (byteBuffer.isReadOnly()) {
            //throw new ReadOnlyBufferException();
        //}
        //byteBuffer.limit(limit * SizeOf.CHAR);
        //byteBuffer.position(position * SizeOf.CHAR);
        //byteBuffer.compact();
        //byteBuffer.clear();
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.572 -0400", hash_original_method = "D6132370D2375183CB2B2E07203B0DEF", hash_generated_method = "29D1CEFFBEC37CE890233012E1A086CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer duplicate() {
        ByteBuffer bb;
        bb = byteBuffer.duplicate().order(byteBuffer.order());
        CharToByteBufferAdapter buf;
        buf = new CharToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        //CharToByteBufferAdapter buf = new CharToByteBufferAdapter(bb);
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.572 -0400", hash_original_method = "E3B7C628ECBF1BA157CEBCB59E54138B", hash_generated_method = "D95AB9D386FB10FA758391BF4EC21B50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public char get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        char varA3995E5AEF4DE9E279E678289D32918E_273127135 = (byteBuffer.getChar(position++ * SizeOf.CHAR));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return byteBuffer.getChar(position++ * SizeOf.CHAR);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.573 -0400", hash_original_method = "2E9BB5D57AAEB3C216C710BA88C55EF9", hash_generated_method = "EF88533A78EC74FE1FF42999C111C89F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public char get(int index) {
        dsTaint.addTaint(index);
        checkIndex(index);
        char var0C79692AD26E6EBE72EB349871353E9E_727386640 = (byteBuffer.getChar(index * SizeOf.CHAR));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //checkIndex(index);
        //return byteBuffer.getChar(index * SizeOf.CHAR);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.573 -0400", hash_original_method = "CD7E402824D81A34C6B45148A4A0EA7C", hash_generated_method = "6B7A6754A1294C3246375F68AF823B9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer get(char[] dst, int dstOffset, int charCount) {
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        dsTaint.addTaint(charCount);
        byteBuffer.limit(limit * SizeOf.CHAR);
        byteBuffer.position(position * SizeOf.CHAR);
        {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, charCount);
        } //End block
        {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, charCount);
        } //End block
        this.position += charCount;
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.CHAR);
        //byteBuffer.position(position * SizeOf.CHAR);
        //if (byteBuffer instanceof DirectByteBuffer) {
            //((DirectByteBuffer) byteBuffer).get(dst, dstOffset, charCount);
        //} else {
            //((HeapByteBuffer) byteBuffer).get(dst, dstOffset, charCount);
        //}
        //this.position += charCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.574 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "D0C7A6EF039111E627C8B2ABD1AF6907")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isDirect() {
        boolean var6A38F61B252C327C2F003ABEEAE77D3E_334997157 = (byteBuffer.isDirect());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return byteBuffer.isDirect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.574 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "825C01D5B06BE67E37FE7D5F95B8DB50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isReadOnly() {
        boolean varB84E0A3CE12C63F21B1E15D856C3A969_1449664416 = (byteBuffer.isReadOnly());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return byteBuffer.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.575 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "56CBF2453453DF4D23DBDF0A9D4A4010")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteOrder order() {
        ByteOrder var19C5E1CA5343F3A40725401EF91DEFCC_1509309475 = (byteBuffer.order());
        return (ByteOrder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return byteBuffer.order();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.575 -0400", hash_original_method = "5163488AC40767F8F030E728692C8A7E", hash_generated_method = "C7759C44523814371222AB3CC8591A41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected char[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.575 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "C73FA96390820A77974587B22AF4696E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.575 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "ABBE1C4E781471842A6D95D790DBFBEE")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean protectedHasArray() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.575 -0400", hash_original_method = "A46BC55FC455B05EF747C70552AAC069", hash_generated_method = "5B4938DCE7A88B2821237CF86E205BBB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer put(char c) {
        dsTaint.addTaint(c);
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        byteBuffer.putChar(position++ * SizeOf.CHAR, c);
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //byteBuffer.putChar(position++ * SizeOf.CHAR, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.576 -0400", hash_original_method = "3E41BE4D2E49CC352D854BBBF4557ADA", hash_generated_method = "4F685F639A6F128224BA85DA409DDEBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer put(int index, char c) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(c);
        checkIndex(index);
        byteBuffer.putChar(index * SizeOf.CHAR, c);
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkIndex(index);
        //byteBuffer.putChar(index * SizeOf.CHAR, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.576 -0400", hash_original_method = "25F0118CCA8CBA4D22EEA9D027B39A5B", hash_generated_method = "477E0CEE1AA4D737383824ECE9E26ED3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer put(char[] src, int srcOffset, int charCount) {
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        dsTaint.addTaint(charCount);
        byteBuffer.limit(limit * SizeOf.CHAR);
        byteBuffer.position(position * SizeOf.CHAR);
        {
            ((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, charCount);
        } //End block
        {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, charCount);
        } //End block
        this.position += charCount;
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.CHAR);
        //byteBuffer.position(position * SizeOf.CHAR);
        //if (byteBuffer instanceof ReadWriteDirectByteBuffer) {
            //((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, charCount);
        //} else {
            //((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, charCount);
        //}
        //this.position += charCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.576 -0400", hash_original_method = "990BBC721EFE340A5DC5CE5D5661B284", hash_generated_method = "08F69EBE74EB388E94B27FA9393459AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer slice() {
        byteBuffer.limit(limit * SizeOf.CHAR);
        byteBuffer.position(position * SizeOf.CHAR);
        ByteBuffer bb;
        bb = byteBuffer.slice().order(byteBuffer.order());
        CharBuffer result;
        result = new CharToByteBufferAdapter(bb);
        byteBuffer.clear();
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.CHAR);
        //byteBuffer.position(position * SizeOf.CHAR);
        //ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        //CharBuffer result = new CharToByteBufferAdapter(bb);
        //byteBuffer.clear();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.576 -0400", hash_original_method = "4B1929E0A98D3F3896D7290A74598BEB", hash_generated_method = "B7C5838013EA3E682B2E256E6AFDFCD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharSequence subSequence(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        checkStartEndRemaining(start, end);
        CharBuffer result;
        result = duplicate();
        result.limit(position + end);
        result.position(position + start);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //checkStartEndRemaining(start, end);
        //CharBuffer result = duplicate();
        //result.limit(position + end);
        //result.position(position + start);
        //return result;
    }

    
}

