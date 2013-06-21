package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadOnlyHeapByteBuffer extends HeapByteBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.888 -0400", hash_original_method = "2F2ACF3B9ABB2D0DAB5827DF665B4EAD", hash_generated_method = "829E2469CBA8E2268C301FA8A86AE19B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadOnlyHeapByteBuffer(byte[] backingArray, int capacity, int arrayOffset) {
        super(backingArray, capacity, arrayOffset);
        dsTaint.addTaint(backingArray[0]);
        dsTaint.addTaint(arrayOffset);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
        static ReadOnlyHeapByteBuffer copy(HeapByteBuffer other, int markOfOther) {
        ReadOnlyHeapByteBuffer buf =
                new ReadOnlyHeapByteBuffer(other.backingArray, other.capacity(), other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.888 -0400", hash_original_method = "DAFC57596AF38F7142398219C2B48840", hash_generated_method = "1B43198D3211702756D759821B14B0CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer asReadOnlyBuffer() {
        ByteBuffer var836CC2C6F807A1CF0BF7584D216D298F_959154907 = (ReadOnlyHeapByteBuffer.copy(this, mark));
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ReadOnlyHeapByteBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.888 -0400", hash_original_method = "E9BD68C2A3E399E8B6F437AA7B03F4EC", hash_generated_method = "E3FF7BF5DC8E9E7221C6689CC1669D09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer compact() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.888 -0400", hash_original_method = "C2883EB2B7E86A704D76356E1AAB194F", hash_generated_method = "218A3861B0A9D3D9817C990933948DD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer duplicate() {
        ByteBuffer var8C82ED9E4FDE12C9486E1252174918B6_502367943 = (copy(this, mark));
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.888 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "1F37B5B4451C181C67CEF1957DF5BE74")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isReadOnly() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.889 -0400", hash_original_method = "722C56C70277A2AF29EF09DE3FC2E957", hash_generated_method = "1EB2E03DB1324DE34CCDA91798308B08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected byte[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.889 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "E33577BEEC5DADCAF68823E6F78877A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.889 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "ABBE1C4E781471842A6D95D790DBFBEE")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean protectedHasArray() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.889 -0400", hash_original_method = "F6BE9BC005619EB0DCAA2A874D1401FC", hash_generated_method = "690DD361A5C93187E6988C4B82C59AA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer put(byte b) {
        dsTaint.addTaint(b);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.889 -0400", hash_original_method = "3C5952D8FAADE293E2AA7CAEA3FBDFDE", hash_generated_method = "4260B4A5E5B21AD3E4F4679E6A41B413")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer put(int index, byte b) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(b);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.889 -0400", hash_original_method = "951D4EAC88501D9206E4E1A989B35D3E", hash_generated_method = "9C2230412229FE6454FA6DCBBD39E997")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.889 -0400", hash_original_method = "A805DD85D5AD0B04A08295FCAF525294", hash_generated_method = "C40314AF9B314342FAA0ABD63A72100D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putDouble(double value) {
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.890 -0400", hash_original_method = "B21C449764944752357064F64E16A04C", hash_generated_method = "8C6C750942A9E0153CED08ACA79ABB21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putDouble(int index, double value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.890 -0400", hash_original_method = "0936EB19B88AD6A1540E67EF21842269", hash_generated_method = "30BBD4C345F36E89EA94302566596370")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putFloat(float value) {
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.890 -0400", hash_original_method = "6EDCFEA9CE18908F355474CE24EE73F3", hash_generated_method = "5B2BC3567124CD2C8605D47C82D488EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putFloat(int index, float value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.890 -0400", hash_original_method = "6D4DC7AF194DC54CDF161D65F1FDDEA8", hash_generated_method = "3D7693EAE321D9DDB588402205685D5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putInt(int value) {
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.890 -0400", hash_original_method = "596A6D4589A1478BD0E76A52D09F2DF6", hash_generated_method = "69DDDAF0C45BE32EC24BE4D4BD64AACF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putInt(int index, int value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.890 -0400", hash_original_method = "6CDC02834F940A2320A4AB5E7F512207", hash_generated_method = "2BAA7982BFCF34C5D52CDBE714182933")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putLong(int index, long value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.890 -0400", hash_original_method = "4935387395F1528D3182F7E3202284B4", hash_generated_method = "78E012495582D172A168AEE4EC07DFE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putLong(long value) {
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.891 -0400", hash_original_method = "3FFCBC2284BD734FFA5002B7F6F7C258", hash_generated_method = "775B080229527C78AA5E7D1A769E1E91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putShort(int index, short value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.891 -0400", hash_original_method = "1212B9E4C2EAD5C33D73EC873813CB4B", hash_generated_method = "469527F7F325914A30126F59B7BA8175")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putShort(short value) {
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.891 -0400", hash_original_method = "927CD040BA02D17CD9D13CDD471B3CCF", hash_generated_method = "8915511B8BD896914A3E3686B26200E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer put(ByteBuffer buf) {
        dsTaint.addTaint(buf.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.891 -0400", hash_original_method = "6FE9FDD30B055D5D0C17F2FBAA978884", hash_generated_method = "7A668CBBE962DD44C92855F8637CBE19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer slice() {
        ByteBuffer var7FF1E8504ABD4B07DA19E6EECACBD494_352444899 = (new ReadOnlyHeapByteBuffer(backingArray, remaining(), offset + position));
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ReadOnlyHeapByteBuffer(backingArray, remaining(), offset + position);
    }

    
}

