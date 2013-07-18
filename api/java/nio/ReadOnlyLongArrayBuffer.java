package java.nio;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

final class ReadOnlyLongArrayBuffer extends LongArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.587 -0400", hash_original_method = "C217C684C5DFBD85DAC953DA8CC4F355", hash_generated_method = "A27125D7AB0ABDAB65A1C28DBD5CE9F0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.588 -0400", hash_original_method = "9283ADC80310F7E479295F96D960F17D", hash_generated_method = "ABBBDE6907BF314708B502F0104CBE76")
    @Override
    public LongBuffer asReadOnlyBuffer() {
LongBuffer var398C146492D42068C7FF67EDC7FA3DFF_1678154275 =         duplicate();
        var398C146492D42068C7FF67EDC7FA3DFF_1678154275.addTaint(taint);
        return var398C146492D42068C7FF67EDC7FA3DFF_1678154275;
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.588 -0400", hash_original_method = "0AF2CD05C541DF81A768714F9C7047F3", hash_generated_method = "15ACCCB24CA1C225977AAE2E18935F03")
    @Override
    public LongBuffer compact() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1369767168 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1369767168.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1369767168;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.588 -0400", hash_original_method = "BCAEF14AE65D2F213653B4CB45E8B265", hash_generated_method = "178A26283F508F270BCA93BD28CCC6A2")
    @Override
    public LongBuffer duplicate() {
LongBuffer var6ED4708F04CD11720ECFFDBFD927116F_751932522 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_751932522.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_751932522;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.589 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "85A441932DEFAB5169A0E8B585119E7F")
    @Override
    public boolean isReadOnly() {
        boolean varB326B5062B2F0E69046810717534CB09_1586787406 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1327911071 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1327911071;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.589 -0400", hash_original_method = "4182362C5B9492F840FDEB2D9E41E07C", hash_generated_method = "D2BB7750D990F469A4DB6D7670E0003C")
    @Override
    protected long[] protectedArray() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_209733822 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_209733822.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_209733822;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.589 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "7F899F0DAEBC49A79FDE48ADE9754202")
    @Override
    protected int protectedArrayOffset() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_79983376 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_79983376.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_79983376;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.590 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "409AB9A90C917FE37EDED320E8202362")
    @Override
    protected boolean protectedHasArray() {
        boolean var68934A3E9455FA72420237EB05902327_832465759 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_704762081 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_704762081;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.590 -0400", hash_original_method = "7393DFCF52569FCC2605F08F020574B2", hash_generated_method = "384EC918E1E673EDC73752F692B55A1A")
    @Override
    public LongBuffer put(long c) {
        addTaint(c);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_995728474 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_995728474.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_995728474;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.590 -0400", hash_original_method = "E5FA3278A640CB37396E7D9BDEEA6C53", hash_generated_method = "DA7B6D5ADD3EEFCE16AFCEC6CEA40817")
    @Override
    public LongBuffer put(int index, long c) {
        addTaint(c);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_596780941 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_596780941.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_596780941;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.590 -0400", hash_original_method = "30B5D6EAC290C108C17070B0EA497381", hash_generated_method = "B20200AB8EF83C90F1F11091A1D35C3F")
    @Override
    public LongBuffer put(LongBuffer buf) {
        addTaint(buf.getTaint());
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1197989714 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1197989714.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1197989714;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.591 -0400", hash_original_method = "216FEF8EB820A47DE670615020EB98B3", hash_generated_method = "37DEF84C0D9F9FD41F8B603321A36E02")
    @Override
    public final LongBuffer put(long[] src, int srcOffset, int longCount) {
        addTaint(longCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_2010542507 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_2010542507.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_2010542507;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.591 -0400", hash_original_method = "B55D734F8AFBBB86296CAB7433B17B3B", hash_generated_method = "E45A5F909A0C9FA742096A92D71761A8")
    @Override
    public LongBuffer slice() {
LongBuffer var80DCC9D4E13F3D0C96DAEA6E500F9901_960615566 =         new ReadOnlyLongArrayBuffer(remaining(), backingArray, offset + position);
        var80DCC9D4E13F3D0C96DAEA6E500F9901_960615566.addTaint(taint);
        return var80DCC9D4E13F3D0C96DAEA6E500F9901_960615566;
        // ---------- Original Method ----------
        //return new ReadOnlyLongArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

