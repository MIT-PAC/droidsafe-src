package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.io.SizeOf;

final class FloatToByteBufferAdapter extends FloatBuffer {
    private ByteBuffer byteBuffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.726 -0400", hash_original_method = "810EBC63174C0FA8B04ABE1EAC99DA74", hash_generated_method = "E9243FC22C0257C23365A1B52133A87B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     FloatToByteBufferAdapter(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.FLOAT);
        dsTaint.addTaint(byteBuffer.dsTaint);
        this.byteBuffer.clear();
        this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
        // ---------- Original Method ----------
        //this.byteBuffer = byteBuffer;
        //this.byteBuffer.clear();
        //this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
    }

    
        static FloatBuffer asFloatBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new FloatToByteBufferAdapter(slice);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.727 -0400", hash_original_method = "3FF4AF57EF2BE2D13954C1B0FC09E489", hash_generated_method = "DBA93A15F80E86D0999F3D20022CBE82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FloatBuffer asReadOnlyBuffer() {
        FloatToByteBufferAdapter buf;
        buf = new FloatToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //FloatToByteBufferAdapter buf = new FloatToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //buf.byteBuffer.order = byteBuffer.order;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.728 -0400", hash_original_method = "FBAC0D7CFE3E15F2BC0CE6753022B0DD", hash_generated_method = "DBEB6A13941C6363E6157F1866D81D92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FloatBuffer compact() {
        {
            boolean varD77B6130B34264A0EF448C4235FCDE48_568809192 = (byteBuffer.isReadOnly());
            {
                if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
            } //End block
        } //End collapsed parenthetic
        byteBuffer.limit(limit * SizeOf.FLOAT);
        byteBuffer.position(position * SizeOf.FLOAT);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (byteBuffer.isReadOnly()) {
            //throw new ReadOnlyBufferException();
        //}
        //byteBuffer.limit(limit * SizeOf.FLOAT);
        //byteBuffer.position(position * SizeOf.FLOAT);
        //byteBuffer.compact();
        //byteBuffer.clear();
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.729 -0400", hash_original_method = "2336A0F3EA16333D5C7B2B5772DB119B", hash_generated_method = "5CC6277F1C5537C8B94072AAC0FACBFF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FloatBuffer duplicate() {
        ByteBuffer bb;
        bb = byteBuffer.duplicate().order(byteBuffer.order());
        FloatToByteBufferAdapter buf;
        buf = new FloatToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        //FloatToByteBufferAdapter buf = new FloatToByteBufferAdapter(bb);
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.729 -0400", hash_original_method = "B6EAE0A3183D6C7B7623279A287B061F", hash_generated_method = "C59FEA8981F197948544A36F9A8918D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public float get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        float varB42DF50547C1CBA17136619660C28C11_569501995 = (byteBuffer.getFloat(position++ * SizeOf.FLOAT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return byteBuffer.getFloat(position++ * SizeOf.FLOAT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.729 -0400", hash_original_method = "230A68E38935998751EB725110E55452", hash_generated_method = "91D6B7F7C44BCA2312C076ED0B813758")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public float get(int index) {
        dsTaint.addTaint(index);
        checkIndex(index);
        float var0D7D6C5512E2A5EF31892DD80FA65589_1681789852 = (byteBuffer.getFloat(index * SizeOf.FLOAT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //checkIndex(index);
        //return byteBuffer.getFloat(index * SizeOf.FLOAT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.729 -0400", hash_original_method = "D58B2A76A0F3A395BA7B6FFCBE67E2EB", hash_generated_method = "0954D7B5C6B877098FD2AF4BA2420612")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FloatBuffer get(float[] dst, int dstOffset, int floatCount) {
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        dsTaint.addTaint(floatCount);
        byteBuffer.limit(limit * SizeOf.FLOAT);
        byteBuffer.position(position * SizeOf.FLOAT);
        {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, floatCount);
        } //End block
        {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, floatCount);
        } //End block
        this.position += floatCount;
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.FLOAT);
        //byteBuffer.position(position * SizeOf.FLOAT);
        //if (byteBuffer instanceof DirectByteBuffer) {
            //((DirectByteBuffer) byteBuffer).get(dst, dstOffset, floatCount);
        //} else {
            //((HeapByteBuffer) byteBuffer).get(dst, dstOffset, floatCount);
        //}
        //this.position += floatCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.730 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "2B2E3A041014D2B5D67702D5C12684DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isDirect() {
        boolean var6A38F61B252C327C2F003ABEEAE77D3E_1752145109 = (byteBuffer.isDirect());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return byteBuffer.isDirect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.730 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "31D5A09CCA1D1AFA3708204A4CBE48FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isReadOnly() {
        boolean varB84E0A3CE12C63F21B1E15D856C3A969_1400126951 = (byteBuffer.isReadOnly());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return byteBuffer.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.730 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "90EB45A9120B5F38E0AA27C7B1A3D103")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteOrder order() {
        ByteOrder var19C5E1CA5343F3A40725401EF91DEFCC_1726499083 = (byteBuffer.order());
        return (ByteOrder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return byteBuffer.order();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.730 -0400", hash_original_method = "B84097C1EE35CBEC4451B3A83458D5FB", hash_generated_method = "C8F1264F32377EEA127A4577D77B5618")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected float[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        float[] retVal = new float[1];
        retVal[0] = dsTaint.getTaintFloat();
        return retVal;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.730 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "C73FA96390820A77974587B22AF4696E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.730 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "ABBE1C4E781471842A6D95D790DBFBEE")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean protectedHasArray() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.731 -0400", hash_original_method = "BFCE73D0BEC9C4C5044FD718D90FCD3E", hash_generated_method = "9F281948268485740083E618B6175F35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FloatBuffer put(float c) {
        dsTaint.addTaint(c);
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        byteBuffer.putFloat(position++ * SizeOf.FLOAT, c);
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //byteBuffer.putFloat(position++ * SizeOf.FLOAT, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.731 -0400", hash_original_method = "031128B9243B4CE1487F7A32DBB76678", hash_generated_method = "FAE0125E38BB2CA93CCDA5F242EB4D9E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FloatBuffer put(int index, float c) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(c);
        checkIndex(index);
        byteBuffer.putFloat(index * SizeOf.FLOAT, c);
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkIndex(index);
        //byteBuffer.putFloat(index * SizeOf.FLOAT, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.731 -0400", hash_original_method = "3BDFA2137C718F8287015587FF612D27", hash_generated_method = "CAB6404C57A7910ABA043B46E941D0FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FloatBuffer put(float[] src, int srcOffset, int floatCount) {
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        dsTaint.addTaint(floatCount);
        byteBuffer.limit(limit * SizeOf.FLOAT);
        byteBuffer.position(position * SizeOf.FLOAT);
        {
            ((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, floatCount);
        } //End block
        {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, floatCount);
        } //End block
        this.position += floatCount;
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.FLOAT);
        //byteBuffer.position(position * SizeOf.FLOAT);
        //if (byteBuffer instanceof ReadWriteDirectByteBuffer) {
            //((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, floatCount);
        //} else {
            //((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, floatCount);
        //}
        //this.position += floatCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.731 -0400", hash_original_method = "72D0D38C2A2E773EAB91888933B787B4", hash_generated_method = "B92E77680DCAE1D060D7EC2F0B5155C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FloatBuffer slice() {
        byteBuffer.limit(limit * SizeOf.FLOAT);
        byteBuffer.position(position * SizeOf.FLOAT);
        ByteBuffer bb;
        bb = byteBuffer.slice().order(byteBuffer.order());
        FloatBuffer result;
        result = new FloatToByteBufferAdapter(bb);
        byteBuffer.clear();
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.FLOAT);
        //byteBuffer.position(position * SizeOf.FLOAT);
        //ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        //FloatBuffer result = new FloatToByteBufferAdapter(bb);
        //byteBuffer.clear();
        //return result;
    }

    
}

