package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.io.SizeOf;

final class DoubleToByteBufferAdapter extends DoubleBuffer {
    private ByteBuffer byteBuffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.653 -0400", hash_original_method = "3C3F64E3DFEA19E69D83DE032CD69444", hash_generated_method = "6D7963BFFD9C543F3355190A8D0A92FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private DoubleToByteBufferAdapter(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.DOUBLE);
        dsTaint.addTaint(byteBuffer.dsTaint);
        this.byteBuffer.clear();
        this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
        // ---------- Original Method ----------
        //this.byteBuffer = byteBuffer;
        //this.byteBuffer.clear();
        //this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
    }

    
        static DoubleBuffer asDoubleBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new DoubleToByteBufferAdapter(slice);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.653 -0400", hash_original_method = "66F1F6EEFF46B34AB7A86EE28CB8A669", hash_generated_method = "81871D00C8205C2B217ABBEC026085DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public DoubleBuffer asReadOnlyBuffer() {
        DoubleToByteBufferAdapter buf;
        buf = new DoubleToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
        return (DoubleBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //DoubleToByteBufferAdapter buf = new DoubleToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //buf.byteBuffer.order = byteBuffer.order;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.654 -0400", hash_original_method = "A0960685ED8E4B90630D067C0149A7A7", hash_generated_method = "141512CD3DC77FC4A1804C726A75C69C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public DoubleBuffer compact() {
        {
            boolean varD77B6130B34264A0EF448C4235FCDE48_1827098347 = (byteBuffer.isReadOnly());
            {
                if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
            } //End block
        } //End collapsed parenthetic
        byteBuffer.limit(limit * SizeOf.DOUBLE);
        byteBuffer.position(position * SizeOf.DOUBLE);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return (DoubleBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (byteBuffer.isReadOnly()) {
            //throw new ReadOnlyBufferException();
        //}
        //byteBuffer.limit(limit * SizeOf.DOUBLE);
        //byteBuffer.position(position * SizeOf.DOUBLE);
        //byteBuffer.compact();
        //byteBuffer.clear();
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.654 -0400", hash_original_method = "FD4932C207B542FC04D0525E47AC3161", hash_generated_method = "28F094A22376D2FB3160261B8C0EE690")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public DoubleBuffer duplicate() {
        ByteBuffer bb;
        bb = byteBuffer.duplicate().order(byteBuffer.order());
        DoubleToByteBufferAdapter buf;
        buf = new DoubleToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        return (DoubleBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        //DoubleToByteBufferAdapter buf = new DoubleToByteBufferAdapter(bb);
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.654 -0400", hash_original_method = "0C75853E3C2CF6732FFCF6E98F870BD4", hash_generated_method = "CE3DCD28286753F16F3AF9F143259E5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public double get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        double var0C8B152D8EEFE99D31FF9D209276D190_1932222982 = (byteBuffer.getDouble(position++ * SizeOf.DOUBLE));
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return byteBuffer.getDouble(position++ * SizeOf.DOUBLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.654 -0400", hash_original_method = "E6FEAF9DCFF95E07F26C5202FDF2E7B8", hash_generated_method = "1CC366D1F22DBCBEFDCB2FD3D6972851")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public double get(int index) {
        dsTaint.addTaint(index);
        checkIndex(index);
        double var436C03F06107CC79B199B8289700FA67_1187616 = (byteBuffer.getDouble(index * SizeOf.DOUBLE));
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //checkIndex(index);
        //return byteBuffer.getDouble(index * SizeOf.DOUBLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.655 -0400", hash_original_method = "D37CED54394BDE1310F07C3D0EF5D332", hash_generated_method = "BD75D43AE7C251E488C56466C275C3D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public DoubleBuffer get(double[] dst, int dstOffset, int doubleCount) {
        dsTaint.addTaint(doubleCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        byteBuffer.limit(limit * SizeOf.DOUBLE);
        byteBuffer.position(position * SizeOf.DOUBLE);
        {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, doubleCount);
        } //End block
        {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, doubleCount);
        } //End block
        this.position += doubleCount;
        return (DoubleBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.DOUBLE);
        //byteBuffer.position(position * SizeOf.DOUBLE);
        //if (byteBuffer instanceof DirectByteBuffer) {
            //((DirectByteBuffer) byteBuffer).get(dst, dstOffset, doubleCount);
        //} else {
            //((HeapByteBuffer) byteBuffer).get(dst, dstOffset, doubleCount);
        //}
        //this.position += doubleCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.655 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "A4CDE18025BD6DEC94DBE2FF5B79EBCF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isDirect() {
        boolean var6A38F61B252C327C2F003ABEEAE77D3E_1833543009 = (byteBuffer.isDirect());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return byteBuffer.isDirect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.655 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "606D478F832FB654738D1ECEEE12D223")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isReadOnly() {
        boolean varB84E0A3CE12C63F21B1E15D856C3A969_1163188321 = (byteBuffer.isReadOnly());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return byteBuffer.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.655 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "F3C6B8B51FBB26812195591B48684FF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteOrder order() {
        ByteOrder var19C5E1CA5343F3A40725401EF91DEFCC_1893180910 = (byteBuffer.order());
        return (ByteOrder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return byteBuffer.order();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.655 -0400", hash_original_method = "74B676FF851868B6C558CA9DCC9A472E", hash_generated_method = "4179858326DAC7530EA42CFB58A54A31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected double[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        double[] retVal = new double[1];
        retVal[0] = dsTaint.getTaintFloat();
        return retVal;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.655 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "C73FA96390820A77974587B22AF4696E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.655 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "ABBE1C4E781471842A6D95D790DBFBEE")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean protectedHasArray() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.656 -0400", hash_original_method = "40AF4DBB8CAF825D560827D27834F61A", hash_generated_method = "B0E2C6F828C14F76947DA60D994F2DD7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public DoubleBuffer put(double c) {
        dsTaint.addTaint(c);
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        byteBuffer.putDouble(position++ * SizeOf.DOUBLE, c);
        return (DoubleBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //byteBuffer.putDouble(position++ * SizeOf.DOUBLE, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.656 -0400", hash_original_method = "86E534F052F254A7B02EA4C07E94BFA8", hash_generated_method = "BDB8A7F84D3E98AFBE8409485837B787")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public DoubleBuffer put(int index, double c) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(c);
        checkIndex(index);
        byteBuffer.putDouble(index * SizeOf.DOUBLE, c);
        return (DoubleBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkIndex(index);
        //byteBuffer.putDouble(index * SizeOf.DOUBLE, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.656 -0400", hash_original_method = "9EEEA82F785CE6D4D72E12428428FA8D", hash_generated_method = "C6F2A4A6333B06B0CAE962A51C36D757")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public DoubleBuffer put(double[] src, int srcOffset, int doubleCount) {
        dsTaint.addTaint(doubleCount);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        byteBuffer.limit(limit * SizeOf.DOUBLE);
        byteBuffer.position(position * SizeOf.DOUBLE);
        {
            ((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, doubleCount);
        } //End block
        {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, doubleCount);
        } //End block
        this.position += doubleCount;
        return (DoubleBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.DOUBLE);
        //byteBuffer.position(position * SizeOf.DOUBLE);
        //if (byteBuffer instanceof ReadWriteDirectByteBuffer) {
            //((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, doubleCount);
        //} else {
            //((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, doubleCount);
        //}
        //this.position += doubleCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.656 -0400", hash_original_method = "22A6C9D0B842A6C5A7761EE0E7412B6B", hash_generated_method = "812867D0599D19D64C146F26024E01E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public DoubleBuffer slice() {
        byteBuffer.limit(limit * SizeOf.DOUBLE);
        byteBuffer.position(position * SizeOf.DOUBLE);
        ByteBuffer bb;
        bb = byteBuffer.slice().order(byteBuffer.order());
        DoubleBuffer result;
        result = new DoubleToByteBufferAdapter(bb);
        byteBuffer.clear();
        return (DoubleBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.DOUBLE);
        //byteBuffer.position(position * SizeOf.DOUBLE);
        //ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        //DoubleBuffer result = new DoubleToByteBufferAdapter(bb);
        //byteBuffer.clear();
        //return result;
    }

    
}

