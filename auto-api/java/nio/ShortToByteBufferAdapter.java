package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.io.SizeOf;

final class ShortToByteBufferAdapter extends ShortBuffer {
    private ByteBuffer byteBuffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.040 -0400", hash_original_method = "A7ACA037BB98388A15E54FB4598E481B", hash_generated_method = "DAAD0AD4B3542A4E945959698DDA4577")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ShortToByteBufferAdapter(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.SHORT);
        dsTaint.addTaint(byteBuffer.dsTaint);
        this.byteBuffer.clear();
        this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
        // ---------- Original Method ----------
        //this.byteBuffer = byteBuffer;
        //this.byteBuffer.clear();
        //this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
    }

    
        static ShortBuffer asShortBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new ShortToByteBufferAdapter(slice);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.041 -0400", hash_original_method = "D0F8AEC70CAA4378FE6A82AD4DA3E011", hash_generated_method = "5CBE3BB46E08032CA21D0E1E72BBCF99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ShortBuffer asReadOnlyBuffer() {
        ShortToByteBufferAdapter buf;
        buf = new ShortToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ShortToByteBufferAdapter buf = new ShortToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //buf.byteBuffer.order = byteBuffer.order;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.041 -0400", hash_original_method = "05DE7B6CED27ACAA0A9F6BF73EB6C673", hash_generated_method = "6EC7DA13F16516D71A599A0330E60C6D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ShortBuffer compact() {
        {
            boolean varD77B6130B34264A0EF448C4235FCDE48_590281050 = (byteBuffer.isReadOnly());
            {
                if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
            } //End block
        } //End collapsed parenthetic
        byteBuffer.limit(limit * SizeOf.SHORT);
        byteBuffer.position(position * SizeOf.SHORT);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (byteBuffer.isReadOnly()) {
            //throw new ReadOnlyBufferException();
        //}
        //byteBuffer.limit(limit * SizeOf.SHORT);
        //byteBuffer.position(position * SizeOf.SHORT);
        //byteBuffer.compact();
        //byteBuffer.clear();
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.041 -0400", hash_original_method = "D125FE991C052B0355B5B7F2D7D9870F", hash_generated_method = "81700D5BDF3D5F42E7275C5686A0D928")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ShortBuffer duplicate() {
        ByteBuffer bb;
        bb = byteBuffer.duplicate().order(byteBuffer.order());
        ShortToByteBufferAdapter buf;
        buf = new ShortToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        //ShortToByteBufferAdapter buf = new ShortToByteBufferAdapter(bb);
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.041 -0400", hash_original_method = "7C4E3224E8CBDBDF522D2B052ECE14D8", hash_generated_method = "E35216A9DEFF67CD8C7FEDC7D686FA10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public short get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        short varF4A707B1B20CA460D36B00B15C262335_955092744 = (byteBuffer.getShort(position++ * SizeOf.SHORT));
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return byteBuffer.getShort(position++ * SizeOf.SHORT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.042 -0400", hash_original_method = "99D353FC1689A601B3A3A0ABA15D7065", hash_generated_method = "FEA8C88C36320B4B2015ECFDD2B4CD7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public short get(int index) {
        dsTaint.addTaint(index);
        checkIndex(index);
        short varBE4C2F8B8B0709014E8FE2B3CF301305_343150916 = (byteBuffer.getShort(index * SizeOf.SHORT));
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //checkIndex(index);
        //return byteBuffer.getShort(index * SizeOf.SHORT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.042 -0400", hash_original_method = "01D384F7005F01D67D604B15B569F233", hash_generated_method = "F0C2ECA4AE5BCE95FCD42392D81C9EE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ShortBuffer get(short[] dst, int dstOffset, int shortCount) {
        dsTaint.addTaint(shortCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        byteBuffer.limit(limit * SizeOf.SHORT);
        byteBuffer.position(position * SizeOf.SHORT);
        {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, shortCount);
        } //End block
        {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, shortCount);
        } //End block
        this.position += shortCount;
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.SHORT);
        //byteBuffer.position(position * SizeOf.SHORT);
        //if (byteBuffer instanceof DirectByteBuffer) {
            //((DirectByteBuffer) byteBuffer).get(dst, dstOffset, shortCount);
        //} else {
            //((HeapByteBuffer) byteBuffer).get(dst, dstOffset, shortCount);
        //}
        //this.position += shortCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.042 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "1539B86D1E7F39997FDAC122BFB80213")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isDirect() {
        boolean var6A38F61B252C327C2F003ABEEAE77D3E_1370397782 = (byteBuffer.isDirect());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return byteBuffer.isDirect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.042 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "12DC33AFBC60AE01219014552BF82487")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isReadOnly() {
        boolean varB84E0A3CE12C63F21B1E15D856C3A969_1453485407 = (byteBuffer.isReadOnly());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return byteBuffer.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.042 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "7428EFF2CE60CFE100D0AF017E00E6A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteOrder order() {
        ByteOrder var19C5E1CA5343F3A40725401EF91DEFCC_849612407 = (byteBuffer.order());
        return (ByteOrder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return byteBuffer.order();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.042 -0400", hash_original_method = "797461B8F23A38201C61F803B025213F", hash_generated_method = "178947C7690374B303551501228CE847")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected short[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        short[] retVal = new short[1];
        retVal[0] = (short)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.043 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "C73FA96390820A77974587B22AF4696E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.043 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "ABBE1C4E781471842A6D95D790DBFBEE")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean protectedHasArray() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.043 -0400", hash_original_method = "BED9261A5E47204D4C26D68EDDB52578", hash_generated_method = "580DE0B4DBC54127966B6B9E27A477B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ShortBuffer put(short c) {
        dsTaint.addTaint(c);
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        byteBuffer.putShort(position++ * SizeOf.SHORT, c);
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //byteBuffer.putShort(position++ * SizeOf.SHORT, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.043 -0400", hash_original_method = "81BB381464177DAD01780ED6CBAA4133", hash_generated_method = "513797760AA8C49931DFC9EEBF248375")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ShortBuffer put(int index, short c) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(c);
        checkIndex(index);
        byteBuffer.putShort(index * SizeOf.SHORT, c);
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkIndex(index);
        //byteBuffer.putShort(index * SizeOf.SHORT, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.043 -0400", hash_original_method = "513A20FF10AFB87C25A95801BCBD1A6B", hash_generated_method = "33DA00212BEAE3420D30F62B5214250E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ShortBuffer put(short[] src, int srcOffset, int shortCount) {
        dsTaint.addTaint(shortCount);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        byteBuffer.limit(limit * SizeOf.SHORT);
        byteBuffer.position(position * SizeOf.SHORT);
        {
            ((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, shortCount);
        } //End block
        {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, shortCount);
        } //End block
        this.position += shortCount;
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.SHORT);
        //byteBuffer.position(position * SizeOf.SHORT);
        //if (byteBuffer instanceof ReadWriteDirectByteBuffer) {
            //((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, shortCount);
        //} else {
            //((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, shortCount);
        //}
        //this.position += shortCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.043 -0400", hash_original_method = "1D11F07A1825F4A6C771FB33ADDF613C", hash_generated_method = "7275AD40C6865EBA08790DDA68BB95E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ShortBuffer slice() {
        byteBuffer.limit(limit * SizeOf.SHORT);
        byteBuffer.position(position * SizeOf.SHORT);
        ByteBuffer bb;
        bb = byteBuffer.slice().order(byteBuffer.order());
        ShortBuffer result;
        result = new ShortToByteBufferAdapter(bb);
        byteBuffer.clear();
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.SHORT);
        //byteBuffer.position(position * SizeOf.SHORT);
        //ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        //ShortBuffer result = new ShortToByteBufferAdapter(bb);
        //byteBuffer.clear();
        //return result;
    }

    
}

