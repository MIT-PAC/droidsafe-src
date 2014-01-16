package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;

final class CharSequenceAdapter extends CharBuffer {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.116 -0500", hash_original_method = "CE7638F70CEF8967E908481EECFBBCC4", hash_generated_method = "11D8B2801D052D618D81829E5684F0D2")
    
static CharSequenceAdapter copy(CharSequenceAdapter other) {
        CharSequenceAdapter buf = new CharSequenceAdapter(other.sequence);
        buf.limit = other.limit;
        buf.position = other.position;
        buf.mark = other.mark;
        return buf;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.118 -0500", hash_original_field = "FC0228967C2CDD8E28E9C839DAD10434", hash_generated_field = "FC0228967C2CDD8E28E9C839DAD10434")

     CharSequence sequence;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.121 -0500", hash_original_method = "206685F1A3CB58D97E4CC4183E9D2DA8", hash_generated_method = "206685F1A3CB58D97E4CC4183E9D2DA8")
    
CharSequenceAdapter(CharSequence chseq) {
        super(chseq.length());
        sequence = chseq;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.123 -0500", hash_original_method = "6272265C933D4E168CAF2033C47ED968", hash_generated_method = "A9D0BE229F30B3716C8CDFCA80787DB7")
    
@Override
    public CharBuffer asReadOnlyBuffer() {
        return duplicate();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.125 -0500", hash_original_method = "B36182A594E1794791B93E3BECF5B149", hash_generated_method = "2593C5B1B74EAD2E7E6B37DB5FD97A42")
    
@Override
    public CharBuffer compact() {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.128 -0500", hash_original_method = "3B532E92A9E534AB72A0D7B6E50ABF8A", hash_generated_method = "00931827F3796201A96D66B48D8CEC04")
    
@Override
    public CharBuffer duplicate() {
        return copy(this);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.131 -0500", hash_original_method = "2E35B46EACC27C03AFC8C4DE9C6A2F1C", hash_generated_method = "377928340EC4EBB9308C38A26F30A48A")
    
@Override
    public char get() {
        if (position == limit) {
            throw new BufferUnderflowException();
        }
        return sequence.charAt(position++);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.133 -0500", hash_original_method = "0A3A9E7F0D00C569C240E619540C538B", hash_generated_method = "35D0D77D062428D22952ECB7DB718A2D")
    
@Override
    public char get(int index) {
        checkIndex(index);
        return sequence.charAt(index);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.137 -0500", hash_original_method = "B46220E47C2CF78231CB9172DECC2B72", hash_generated_method = "565346D738A74AE71F95515AC71B6DD3")
    
@Override
    public final CharBuffer get(char[] dst, int dstOffset, int charCount) {
        Arrays.checkOffsetAndCount(dst.length, dstOffset, charCount);
        if (charCount > remaining()) {
            throw new BufferUnderflowException();
        }
        int newPosition = position + charCount;
        sequence.toString().getChars(position, newPosition, dst, dstOffset);
        position = newPosition;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.139 -0500", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "B17CE879E3F64605E958F6512100FECF")
    
@Override
    public boolean isDirect() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.142 -0500", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "E930BFBB15BF0F3A3E2A714B41BC0488")
    
@Override
    public boolean isReadOnly() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.144 -0500", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "56BD43ED746CCD826477C9BC99208FCA")
    
@Override
    public ByteOrder order() {
        return ByteOrder.nativeOrder();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.146 -0500", hash_original_method = "5163488AC40767F8F030E728692C8A7E", hash_generated_method = "A5273F2C6BE04EE0F772333FB1D75282")
    
@Override
    protected char[] protectedArray() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.149 -0500", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "06D077D8B128869B8EAFBB3C6DF9114F")
    
@Override
    protected int protectedArrayOffset() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.151 -0500", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "4DE1ADBFC1C0BCD2FC8429D8307DD9AC")
    
@Override
    protected boolean protectedHasArray() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.154 -0500", hash_original_method = "AA890865E828C97A020097D7CDA5EE73", hash_generated_method = "CA0F24469F2A1A92B0C086F3C3BFE249")
    
@Override
    public CharBuffer put(char c) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.156 -0500", hash_original_method = "4BB5828CEE96E76B6DAC9C0855ABDDFD", hash_generated_method = "8EF03B178409CB5ACD391B77A43BDF8E")
    
@Override
    public CharBuffer put(int index, char c) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.159 -0500", hash_original_method = "456A915B3249AF3B6DBAB08ACEE5755D", hash_generated_method = "923BD9694955DF4557C0EFE16A5FA1CD")
    
@Override
    public final CharBuffer put(char[] src, int srcOffset, int charCount) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.161 -0500", hash_original_method = "4A99CE8F005D81D8D8D69EFF935B4E86", hash_generated_method = "8B3A388C3F691526F5A4A008E9F71CD1")
    
@Override
    public CharBuffer put(String src, int start, int end) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.164 -0500", hash_original_method = "BB736FDD5368DDDE2159755BA70731E0", hash_generated_method = "CB6B18808A4D9A5F7877E17DB02EF862")
    
@Override
    public CharBuffer slice() {
        return new CharSequenceAdapter(sequence.subSequence(position, limit));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.166 -0500", hash_original_method = "60F18802DACBE929591976E5523A2B99", hash_generated_method = "80523EF32BA990CE2D3B7E51FF50F0CE")
    
@Override
    public CharSequence subSequence(int start, int end) {
        checkStartEndRemaining(start, end);
        CharSequenceAdapter result = copy(this);
        result.position = position + start;
        result.limit = position + end;
        return result;
    }
    
}

