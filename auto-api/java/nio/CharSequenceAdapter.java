package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

final class CharSequenceAdapter extends CharBuffer {
    CharSequence sequence;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.557 -0400", hash_original_method = "206685F1A3CB58D97E4CC4183E9D2DA8", hash_generated_method = "42A5281485B1FDA700CAEF64A61FC121")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     CharSequenceAdapter(CharSequence chseq) {
        super(chseq.length());
        dsTaint.addTaint(chseq);
        // ---------- Original Method ----------
        //sequence = chseq;
    }

    
        static CharSequenceAdapter copy(CharSequenceAdapter other) {
        CharSequenceAdapter buf = new CharSequenceAdapter(other.sequence);
        buf.limit = other.limit;
        buf.position = other.position;
        buf.mark = other.mark;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.557 -0400", hash_original_method = "6272265C933D4E168CAF2033C47ED968", hash_generated_method = "4874AA4A00524C98F06134D2DA8BD7EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer asReadOnlyBuffer() {
        CharBuffer var92CA36B72AD8E4E9D1F46737F34CE751_504032665 = (duplicate());
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.558 -0400", hash_original_method = "B36182A594E1794791B93E3BECF5B149", hash_generated_method = "6475C24754098F78DC94F2B3FFD444C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer compact() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.558 -0400", hash_original_method = "3B532E92A9E534AB72A0D7B6E50ABF8A", hash_generated_method = "F6AB4AE95E22013B64288B62CA0D99B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer duplicate() {
        CharBuffer var64767E6DF0D656E6AB5EF17FCC08F773_917099750 = (copy(this));
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return copy(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.558 -0400", hash_original_method = "2E35B46EACC27C03AFC8C4DE9C6A2F1C", hash_generated_method = "B5ED4B9ED0A5217987525C0BBAC365F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public char get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        char var654684F156C9B7591F260CB2EFD8E371_2080295634 = (sequence.charAt(position++));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return sequence.charAt(position++);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.558 -0400", hash_original_method = "0A3A9E7F0D00C569C240E619540C538B", hash_generated_method = "BC34ABDC9D378094CA4663BB691CEA4A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public char get(int index) {
        dsTaint.addTaint(index);
        checkIndex(index);
        char varC9D047DE2AE351E8DC97E1E25A63F27D_1517058283 = (sequence.charAt(index));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //checkIndex(index);
        //return sequence.charAt(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.558 -0400", hash_original_method = "B46220E47C2CF78231CB9172DECC2B72", hash_generated_method = "2B035BDF2F1672D5979B1049EF739356")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final CharBuffer get(char[] dst, int dstOffset, int charCount) {
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        dsTaint.addTaint(charCount);
        Arrays.checkOffsetAndCount(dst.length, dstOffset, charCount);
        {
            boolean varD6CE167C3592D038C7B14F59C84C4F0D_1238673811 = (charCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
            } //End block
        } //End collapsed parenthetic
        int newPosition;
        newPosition = position + charCount;
        sequence.toString().getChars(position, newPosition, dst, dstOffset);
        position = newPosition;
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(dst.length, dstOffset, charCount);
        //if (charCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //int newPosition = position + charCount;
        //sequence.toString().getChars(position, newPosition, dst, dstOffset);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.559 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "D98D5126BECCF43FE7840E1F5EF7DD92")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isDirect() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.559 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "1F37B5B4451C181C67CEF1957DF5BE74")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isReadOnly() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.559 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "502952F097CA1B83C5436B2E20E0CD6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteOrder order() {
        ByteOrder var65FB841C6DEFAE151AADF2CD2F0C0FB5_14783779 = (ByteOrder.nativeOrder());
        return (ByteOrder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ByteOrder.nativeOrder();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.559 -0400", hash_original_method = "5163488AC40767F8F030E728692C8A7E", hash_generated_method = "C7759C44523814371222AB3CC8591A41")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.559 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "C73FA96390820A77974587B22AF4696E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.559 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "ABBE1C4E781471842A6D95D790DBFBEE")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean protectedHasArray() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.559 -0400", hash_original_method = "AA890865E828C97A020097D7CDA5EE73", hash_generated_method = "C2B14B0F3712C764313649EA2AB3614F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer put(char c) {
        dsTaint.addTaint(c);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.560 -0400", hash_original_method = "4BB5828CEE96E76B6DAC9C0855ABDDFD", hash_generated_method = "A802840441A2EEF83BFFAD3B83041131")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer put(int index, char c) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(c);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.560 -0400", hash_original_method = "456A915B3249AF3B6DBAB08ACEE5755D", hash_generated_method = "01904E93363197DD8B5ED66C2B8F8979")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final CharBuffer put(char[] src, int srcOffset, int charCount) {
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        dsTaint.addTaint(charCount);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.560 -0400", hash_original_method = "4A99CE8F005D81D8D8D69EFF935B4E86", hash_generated_method = "AF13B7FF22AD982E9DE2112A316F7A24")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer put(String src, int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(src);
        dsTaint.addTaint(end);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.560 -0400", hash_original_method = "BB736FDD5368DDDE2159755BA70731E0", hash_generated_method = "9C6A58388369D1656D3D6AD91476CE4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer slice() {
        CharBuffer varCF05E4FA2DB724EB6D55873C64FA0BAF_813286981 = (new CharSequenceAdapter(sequence.subSequence(position, limit)));
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new CharSequenceAdapter(sequence.subSequence(position, limit));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.560 -0400", hash_original_method = "60F18802DACBE929591976E5523A2B99", hash_generated_method = "238549725BE318B8FCE0594353A759B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharSequence subSequence(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        checkStartEndRemaining(start, end);
        CharSequenceAdapter result;
        result = copy(this);
        result.position = position + start;
        result.limit = position + end;
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //checkStartEndRemaining(start, end);
        //CharSequenceAdapter result = copy(this);
        //result.position = position + start;
        //result.limit = position + end;
        //return result;
    }

    
}

