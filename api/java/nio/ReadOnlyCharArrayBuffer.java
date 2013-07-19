package java.nio;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

final class ReadOnlyCharArrayBuffer extends CharArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.471 -0400", hash_original_method = "45CC985A35F0F1494520573D6ACE292A", hash_generated_method = "E0CD24D707F7BE3AA0365D9E8B599616")
      ReadOnlyCharArrayBuffer(int capacity, char[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(arrayOffset);
        addTaint(backingArray[0]);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    static ReadOnlyCharArrayBuffer copy(CharArrayBuffer other, int markOfOther) {
        ReadOnlyCharArrayBuffer buf =
                new ReadOnlyCharArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.472 -0400", hash_original_method = "6272265C933D4E168CAF2033C47ED968", hash_generated_method = "20A7977BFCB85E00569684B7966BC659")
    @Override
    public CharBuffer asReadOnlyBuffer() {
CharBuffer var398C146492D42068C7FF67EDC7FA3DFF_1789876660 =         duplicate();
        var398C146492D42068C7FF67EDC7FA3DFF_1789876660.addTaint(taint);
        return var398C146492D42068C7FF67EDC7FA3DFF_1789876660;
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.472 -0400", hash_original_method = "B36182A594E1794791B93E3BECF5B149", hash_generated_method = "28E689D0E53E7D5022346170C73CAC49")
    @Override
    public CharBuffer compact() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_592950900 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_592950900.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_592950900;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.473 -0400", hash_original_method = "CC31CA0A52E7075216F6C304954E7B50", hash_generated_method = "04364E0BCF60018EE559370226E3D8A9")
    @Override
    public CharBuffer duplicate() {
CharBuffer var6ED4708F04CD11720ECFFDBFD927116F_621700245 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_621700245.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_621700245;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.473 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "932FA987C8FE21D4B1294EA1D95D476F")
    @Override
    public boolean isReadOnly() {
        boolean varB326B5062B2F0E69046810717534CB09_668180182 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_509427299 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_509427299;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.473 -0400", hash_original_method = "0F9E5668E984B4901FBF78711C9DAE7C", hash_generated_method = "4871F8F5A4999A63EC66E14ED2BBC856")
    @Override
    protected char[] protectedArray() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1575583592 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1575583592.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1575583592;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.474 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "7CA483A918302E6CC7C6CB954BCBD1C0")
    @Override
    protected int protectedArrayOffset() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1786491461 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1786491461.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1786491461;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.474 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "9A9E4BC01871F7B7736AB71F65A467E7")
    @Override
    protected boolean protectedHasArray() {
        boolean var68934A3E9455FA72420237EB05902327_70808084 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_186119347 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_186119347;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.474 -0400", hash_original_method = "AA890865E828C97A020097D7CDA5EE73", hash_generated_method = "AA704A440772C0B142F479B7152505AD")
    @Override
    public CharBuffer put(char c) {
        addTaint(c);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1179930461 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1179930461.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1179930461;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.475 -0400", hash_original_method = "4BB5828CEE96E76B6DAC9C0855ABDDFD", hash_generated_method = "2453AE334B24C908B86C95984FCB56A1")
    @Override
    public CharBuffer put(int index, char c) {
        addTaint(c);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1510443714 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1510443714.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1510443714;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.475 -0400", hash_original_method = "456A915B3249AF3B6DBAB08ACEE5755D", hash_generated_method = "F6AA0397F3F900A1DA99EDE2C77926AD")
    @Override
    public final CharBuffer put(char[] src, int srcOffset, int charCount) {
        addTaint(charCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1724250854 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1724250854.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1724250854;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.475 -0400", hash_original_method = "FB6FEA0A32E7A03D5D90CE6B495DAC9B", hash_generated_method = "303115E6A423C9C2B8E7ABB4C2B0C334")
    @Override
    public final CharBuffer put(CharBuffer src) {
        addTaint(src.getTaint());
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1552580467 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1552580467.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1552580467;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.476 -0400", hash_original_method = "4A99CE8F005D81D8D8D69EFF935B4E86", hash_generated_method = "7D17C3C0B58A64F72B06FAACB9D9D4A5")
    @Override
    public CharBuffer put(String src, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(src.getTaint());
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1639208782 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1639208782.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1639208782;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.476 -0400", hash_original_method = "B45CBDD156981DE98E6537855A7A214E", hash_generated_method = "71559D14C73E28338D2F2C072F295E78")
    @Override
    public CharBuffer slice() {
CharBuffer var83A8D9BE696A37F5C9CEEB6F3374C658_709147157 =         new ReadOnlyCharArrayBuffer(remaining(), backingArray, offset + position);
        var83A8D9BE696A37F5C9CEEB6F3374C658_709147157.addTaint(taint);
        return var83A8D9BE696A37F5C9CEEB6F3374C658_709147157;
        // ---------- Original Method ----------
        //return new ReadOnlyCharArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

