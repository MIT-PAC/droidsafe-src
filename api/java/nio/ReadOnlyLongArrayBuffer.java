package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

final class ReadOnlyLongArrayBuffer extends LongArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.017 -0400", hash_original_method = "C217C684C5DFBD85DAC953DA8CC4F355", hash_generated_method = "A27125D7AB0ABDAB65A1C28DBD5CE9F0")
      ReadOnlyLongArrayBuffer(int capacity, long[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(arrayOffset);
        addTaint(backingArray[0]);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
        static ReadOnlyLongArrayBuffer copy(LongArrayBuffer other, int markOfOther) {
        ReadOnlyLongArrayBuffer buf =
                new ReadOnlyLongArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.017 -0400", hash_original_method = "9283ADC80310F7E479295F96D960F17D", hash_generated_method = "ED4F52996858E292F88BD7B63E3F0808")
    @Override
    public LongBuffer asReadOnlyBuffer() {
LongBuffer var398C146492D42068C7FF67EDC7FA3DFF_224051570 =         duplicate();
        var398C146492D42068C7FF67EDC7FA3DFF_224051570.addTaint(taint);
        return var398C146492D42068C7FF67EDC7FA3DFF_224051570;
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.017 -0400", hash_original_method = "0AF2CD05C541DF81A768714F9C7047F3", hash_generated_method = "DB4C1B0278417C436773810F700784BF")
    @Override
    public LongBuffer compact() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1074089481 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1074089481.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1074089481;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.018 -0400", hash_original_method = "BCAEF14AE65D2F213653B4CB45E8B265", hash_generated_method = "0ED9809FB6245FFBB48CD23FCA82A92B")
    @Override
    public LongBuffer duplicate() {
LongBuffer var6ED4708F04CD11720ECFFDBFD927116F_1340754567 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_1340754567.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_1340754567;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.018 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "864D757E7C42A60FDE888DBA6B489547")
    @Override
    public boolean isReadOnly() {
        boolean varB326B5062B2F0E69046810717534CB09_404988497 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1065481638 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1065481638;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.018 -0400", hash_original_method = "4182362C5B9492F840FDEB2D9E41E07C", hash_generated_method = "2BA79245D3BF4698B27B05494B2986FE")
    @Override
    protected long[] protectedArray() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1586856295 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1586856295.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1586856295;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.019 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "A3E7CE02D366F42FA953E155FE2390D2")
    @Override
    protected int protectedArrayOffset() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1047972925 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1047972925.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1047972925;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.019 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "529FAC541AD917691873AF9878E82E42")
    @Override
    protected boolean protectedHasArray() {
        boolean var68934A3E9455FA72420237EB05902327_2092432834 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_14393244 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_14393244;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.019 -0400", hash_original_method = "7393DFCF52569FCC2605F08F020574B2", hash_generated_method = "5C7D327B962E11BE652927FA2830607A")
    @Override
    public LongBuffer put(long c) {
        addTaint(c);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1422969569 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1422969569.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1422969569;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.020 -0400", hash_original_method = "E5FA3278A640CB37396E7D9BDEEA6C53", hash_generated_method = "DAB5D9B3ACF6420665D7ABADF17225A3")
    @Override
    public LongBuffer put(int index, long c) {
        addTaint(c);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_691841666 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_691841666.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_691841666;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.020 -0400", hash_original_method = "30B5D6EAC290C108C17070B0EA497381", hash_generated_method = "0289FE39B1F40E3B5539FC5C72A43892")
    @Override
    public LongBuffer put(LongBuffer buf) {
        addTaint(buf.getTaint());
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_692346444 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_692346444.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_692346444;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.021 -0400", hash_original_method = "216FEF8EB820A47DE670615020EB98B3", hash_generated_method = "C43C23D5F5834898D5B7D48D3DBBF724")
    @Override
    public final LongBuffer put(long[] src, int srcOffset, int longCount) {
        addTaint(longCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1578908597 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1578908597.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1578908597;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.021 -0400", hash_original_method = "B55D734F8AFBBB86296CAB7433B17B3B", hash_generated_method = "7A6EB0FF9F49A815930A928DE89927C1")
    @Override
    public LongBuffer slice() {
LongBuffer var80DCC9D4E13F3D0C96DAEA6E500F9901_1193668956 =         new ReadOnlyLongArrayBuffer(remaining(), backingArray, offset + position);
        var80DCC9D4E13F3D0C96DAEA6E500F9901_1193668956.addTaint(taint);
        return var80DCC9D4E13F3D0C96DAEA6E500F9901_1193668956;
        // ---------- Original Method ----------
        //return new ReadOnlyLongArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

