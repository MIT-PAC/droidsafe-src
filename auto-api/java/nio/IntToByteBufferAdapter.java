package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.io.SizeOf;

final class IntToByteBufferAdapter extends IntBuffer {
    private ByteBuffer byteBuffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.770 -0400", hash_original_method = "0E7C7C86CACD977D9C0D85465EADD9B5", hash_generated_method = "F77E56B80ADB35A9E1CBDBC93FE5054F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private IntToByteBufferAdapter(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.INT);
        dsTaint.addTaint(byteBuffer.dsTaint);
        this.byteBuffer.clear();
        this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
        // ---------- Original Method ----------
        //this.byteBuffer = byteBuffer;
        //this.byteBuffer.clear();
        //this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
    }

    
        static IntBuffer asIntBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new IntToByteBufferAdapter(slice);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.770 -0400", hash_original_method = "3B6C20C87137502BB674F780046CDA86", hash_generated_method = "A2942EE76FCD5946528369EC550D35F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public IntBuffer asReadOnlyBuffer() {
        IntToByteBufferAdapter buf;
        buf = new IntToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
        return (IntBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //IntToByteBufferAdapter buf = new IntToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //buf.byteBuffer.order = byteBuffer.order;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.770 -0400", hash_original_method = "D18BA662CC63D97B7B456C28811B5740", hash_generated_method = "021C40286DBB56023ED64BC823D78918")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public IntBuffer compact() {
        {
            boolean varD77B6130B34264A0EF448C4235FCDE48_231164686 = (byteBuffer.isReadOnly());
            {
                if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
            } //End block
        } //End collapsed parenthetic
        byteBuffer.limit(limit * SizeOf.INT);
        byteBuffer.position(position * SizeOf.INT);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return (IntBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (byteBuffer.isReadOnly()) {
            //throw new ReadOnlyBufferException();
        //}
        //byteBuffer.limit(limit * SizeOf.INT);
        //byteBuffer.position(position * SizeOf.INT);
        //byteBuffer.compact();
        //byteBuffer.clear();
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.770 -0400", hash_original_method = "E4BE94C048430920FB1F32A36A3DD508", hash_generated_method = "689DC034CB5A47BEB4D14750195C3F63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public IntBuffer duplicate() {
        ByteBuffer bb;
        bb = byteBuffer.duplicate().order(byteBuffer.order());
        IntToByteBufferAdapter buf;
        buf = new IntToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        return (IntBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        //IntToByteBufferAdapter buf = new IntToByteBufferAdapter(bb);
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.771 -0400", hash_original_method = "B6C265DA3B3DAD372E7C00DDFF580FE2", hash_generated_method = "641F05CD850CC0D59DFEDEB22F173ABF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        int varD18E1B8FE9CD97C8C6275F7ADEF444F4_1204142106 = (byteBuffer.getInt(position++ * SizeOf.INT));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return byteBuffer.getInt(position++ * SizeOf.INT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.771 -0400", hash_original_method = "A308FF9E693AF460AC240055AB8B4E4F", hash_generated_method = "98F0FC5AEA11D471D7ADF14286A84D37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int get(int index) {
        dsTaint.addTaint(index);
        checkIndex(index);
        int var027D604C62CC9C19A1201FADEFFBEA6F_586036366 = (byteBuffer.getInt(index * SizeOf.INT));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkIndex(index);
        //return byteBuffer.getInt(index * SizeOf.INT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.771 -0400", hash_original_method = "C677A64CEDCCE4923055860B8C2E3944", hash_generated_method = "76270F0D828D742449A06CCA56152F7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public IntBuffer get(int[] dst, int dstOffset, int intCount) {
        dsTaint.addTaint(intCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        byteBuffer.limit(limit * SizeOf.INT);
        byteBuffer.position(position * SizeOf.INT);
        {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, intCount);
        } //End block
        {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, intCount);
        } //End block
        this.position += intCount;
        return (IntBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.INT);
        //byteBuffer.position(position * SizeOf.INT);
        //if (byteBuffer instanceof DirectByteBuffer) {
            //((DirectByteBuffer) byteBuffer).get(dst, dstOffset, intCount);
        //} else {
            //((HeapByteBuffer) byteBuffer).get(dst, dstOffset, intCount);
        //}
        //this.position += intCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.771 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "49589133EBF9D5BC2E38F968939AD42F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isDirect() {
        boolean var6A38F61B252C327C2F003ABEEAE77D3E_1491179388 = (byteBuffer.isDirect());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return byteBuffer.isDirect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.771 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "B3A3CAD06AA63D4F2BDCCE027F3E6AAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isReadOnly() {
        boolean varB84E0A3CE12C63F21B1E15D856C3A969_1508256764 = (byteBuffer.isReadOnly());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return byteBuffer.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.772 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "C3B6F1AD91ABA73202A93BC4294369C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteOrder order() {
        ByteOrder var19C5E1CA5343F3A40725401EF91DEFCC_669417439 = (byteBuffer.order());
        return (ByteOrder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return byteBuffer.order();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.772 -0400", hash_original_method = "B5E68F6CE1B6AAF4D730BB4F773E288A", hash_generated_method = "58CC00689DB885D320F6E81AFBA511CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.772 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "C73FA96390820A77974587B22AF4696E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.772 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "ABBE1C4E781471842A6D95D790DBFBEE")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean protectedHasArray() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.772 -0400", hash_original_method = "3F86EA2C1F796EC91605CF34A16A44E5", hash_generated_method = "4519416EE6C9370480740FEA9885F494")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public IntBuffer put(int c) {
        dsTaint.addTaint(c);
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        byteBuffer.putInt(position++ * SizeOf.INT, c);
        return (IntBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //byteBuffer.putInt(position++ * SizeOf.INT, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.772 -0400", hash_original_method = "3231AAB5D18FCEA9F424FA8559AECE08", hash_generated_method = "B05B0707743B4F6CB0699C1DDA1B3D88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public IntBuffer put(int index, int c) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(c);
        checkIndex(index);
        byteBuffer.putInt(index * SizeOf.INT, c);
        return (IntBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkIndex(index);
        //byteBuffer.putInt(index * SizeOf.INT, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.773 -0400", hash_original_method = "DC03F153D09213907F9D5CD0A27C6001", hash_generated_method = "932F99B568CB759BFBB8FF296301DAE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public IntBuffer put(int[] src, int srcOffset, int intCount) {
        dsTaint.addTaint(intCount);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        byteBuffer.limit(limit * SizeOf.INT);
        byteBuffer.position(position * SizeOf.INT);
        {
            ((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, intCount);
        } //End block
        {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, intCount);
        } //End block
        this.position += intCount;
        return (IntBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.INT);
        //byteBuffer.position(position * SizeOf.INT);
        //if (byteBuffer instanceof ReadWriteDirectByteBuffer) {
            //((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, intCount);
        //} else {
            //((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, intCount);
        //}
        //this.position += intCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.773 -0400", hash_original_method = "9FAC3500FD67AB6DCB59E60DAE965917", hash_generated_method = "4EECBED0D554C6F1E79995ECF1F789E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public IntBuffer slice() {
        byteBuffer.limit(limit * SizeOf.INT);
        byteBuffer.position(position * SizeOf.INT);
        ByteBuffer bb;
        bb = byteBuffer.slice().order(byteBuffer.order());
        IntBuffer result;
        result = new IntToByteBufferAdapter(bb);
        byteBuffer.clear();
        return (IntBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.INT);
        //byteBuffer.position(position * SizeOf.INT);
        //ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        //IntBuffer result = new IntToByteBufferAdapter(bb);
        //byteBuffer.clear();
        //return result;
    }

    
}

