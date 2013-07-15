package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

final class ReadOnlyCharArrayBuffer extends CharArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.928 -0400", hash_original_method = "45CC985A35F0F1494520573D6ACE292A", hash_generated_method = "E0CD24D707F7BE3AA0365D9E8B599616")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.929 -0400", hash_original_method = "6272265C933D4E168CAF2033C47ED968", hash_generated_method = "448E6F5042D30BFC8F18CEE14ECF2551")
    @Override
    public CharBuffer asReadOnlyBuffer() {
CharBuffer var398C146492D42068C7FF67EDC7FA3DFF_2140550315 =         duplicate();
        var398C146492D42068C7FF67EDC7FA3DFF_2140550315.addTaint(taint);
        return var398C146492D42068C7FF67EDC7FA3DFF_2140550315;
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.929 -0400", hash_original_method = "B36182A594E1794791B93E3BECF5B149", hash_generated_method = "6682C3E69BB44008514E831F84AF41EA")
    @Override
    public CharBuffer compact() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1581022522 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1581022522.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1581022522;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.929 -0400", hash_original_method = "CC31CA0A52E7075216F6C304954E7B50", hash_generated_method = "91915E03CE2CA3682D79A31CA36F0329")
    @Override
    public CharBuffer duplicate() {
CharBuffer var6ED4708F04CD11720ECFFDBFD927116F_2082343904 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_2082343904.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_2082343904;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.930 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "E2C566EAE858ADB8DE3FFEB7F599E30D")
    @Override
    public boolean isReadOnly() {
        boolean varB326B5062B2F0E69046810717534CB09_594269440 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1005699976 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1005699976;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.930 -0400", hash_original_method = "0F9E5668E984B4901FBF78711C9DAE7C", hash_generated_method = "B56AE4FE28452F46EFA065A64F02B8B4")
    @Override
    protected char[] protectedArray() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_607900795 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_607900795.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_607900795;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.930 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "95A68F183B4CDB8A3B4CD4FCA9077243")
    @Override
    protected int protectedArrayOffset() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1538342614 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1538342614.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1538342614;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.931 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "83AC8B91353B55E1852CF5F9B229F465")
    @Override
    protected boolean protectedHasArray() {
        boolean var68934A3E9455FA72420237EB05902327_1350129003 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_750677607 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_750677607;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.931 -0400", hash_original_method = "AA890865E828C97A020097D7CDA5EE73", hash_generated_method = "79DA3BCC68171D9603C432115F3F086E")
    @Override
    public CharBuffer put(char c) {
        addTaint(c);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1225230476 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1225230476.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1225230476;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.932 -0400", hash_original_method = "4BB5828CEE96E76B6DAC9C0855ABDDFD", hash_generated_method = "66E2B5BEAD209579F2325C6EA54AEC2E")
    @Override
    public CharBuffer put(int index, char c) {
        addTaint(c);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1241990562 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1241990562.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1241990562;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.932 -0400", hash_original_method = "456A915B3249AF3B6DBAB08ACEE5755D", hash_generated_method = "65749FCF57DE3851561DB09144090920")
    @Override
    public final CharBuffer put(char[] src, int srcOffset, int charCount) {
        addTaint(charCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1719009728 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1719009728.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1719009728;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.932 -0400", hash_original_method = "FB6FEA0A32E7A03D5D90CE6B495DAC9B", hash_generated_method = "8AA55E6044F8AB12205278799DC4E913")
    @Override
    public final CharBuffer put(CharBuffer src) {
        addTaint(src.getTaint());
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1868791818 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1868791818.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1868791818;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.933 -0400", hash_original_method = "4A99CE8F005D81D8D8D69EFF935B4E86", hash_generated_method = "84EBF24DE62ED723A42DF30B7865E578")
    @Override
    public CharBuffer put(String src, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(src.getTaint());
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1012596441 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1012596441.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1012596441;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.933 -0400", hash_original_method = "B45CBDD156981DE98E6537855A7A214E", hash_generated_method = "8A93C9BF338E23FD14523E3F65AFA4E3")
    @Override
    public CharBuffer slice() {
CharBuffer var83A8D9BE696A37F5C9CEEB6F3374C658_19649317 =         new ReadOnlyCharArrayBuffer(remaining(), backingArray, offset + position);
        var83A8D9BE696A37F5C9CEEB6F3374C658_19649317.addTaint(taint);
        return var83A8D9BE696A37F5C9CEEB6F3374C658_19649317;
        // ---------- Original Method ----------
        //return new ReadOnlyCharArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

