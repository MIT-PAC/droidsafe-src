package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

final class CharSequenceAdapter extends CharBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.931 -0400", hash_original_field = "FA1C731EAD93E333A9180E16F968C01E", hash_generated_field = "FC0228967C2CDD8E28E9C839DAD10434")

    CharSequence sequence;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.932 -0400", hash_original_method = "206685F1A3CB58D97E4CC4183E9D2DA8", hash_generated_method = "19C08A1FEB8CEF30A4B0B354687B89DC")
      CharSequenceAdapter(CharSequence chseq) {
        super(chseq.length());
        sequence = chseq;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.933 -0400", hash_original_method = "6272265C933D4E168CAF2033C47ED968", hash_generated_method = "855B6DAEBDDE9831A1D8F399A1082E8D")
    @Override
    public CharBuffer asReadOnlyBuffer() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1524605172 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1524605172 = duplicate();
        varB4EAC82CA7396A68D541C85D26508E83_1524605172.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1524605172;
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.933 -0400", hash_original_method = "B36182A594E1794791B93E3BECF5B149", hash_generated_method = "FDB048D4EFBE0B834B0B887336BCFF0E")
    @Override
    public CharBuffer compact() {
    	throw new ReadOnlyBufferException();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.934 -0400", hash_original_method = "3B532E92A9E534AB72A0D7B6E50ABF8A", hash_generated_method = "E47867D29C8518A712226379DEEDDAF9")
    @Override
    public CharBuffer duplicate() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_418070394 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_418070394 = copy(this);
        varB4EAC82CA7396A68D541C85D26508E83_418070394.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_418070394;
        // ---------- Original Method ----------
        //return copy(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.935 -0400", hash_original_method = "2E35B46EACC27C03AFC8C4DE9C6A2F1C", hash_generated_method = "D3D08E28E31FA713DA2C25B3462C4823")
    @Override
    public char get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        char var654684F156C9B7591F260CB2EFD8E371_1419440668 = (sequence.charAt(position++));
        char varA87DEB01C5F539E6BDA34829C8EF2368_1524411514 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1524411514;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return sequence.charAt(position++);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.935 -0400", hash_original_method = "0A3A9E7F0D00C569C240E619540C538B", hash_generated_method = "7FD119728C1F4EB287D61361173D1157")
    @Override
    public char get(int index) {
        checkIndex(index);
        char varC9D047DE2AE351E8DC97E1E25A63F27D_432991022 = (sequence.charAt(index));
        addTaint(index);
        char varA87DEB01C5F539E6BDA34829C8EF2368_280604374 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_280604374;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return sequence.charAt(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.936 -0400", hash_original_method = "B46220E47C2CF78231CB9172DECC2B72", hash_generated_method = "6A98C753F545B736919C9F711FDB5D7E")
    @Override
    public final CharBuffer get(char[] dst, int dstOffset, int charCount) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1464259302 = null; //Variable for return #1
        Arrays.checkOffsetAndCount(dst.length, dstOffset, charCount);
        {
            boolean varD6CE167C3592D038C7B14F59C84C4F0D_497906229 = (charCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
            } //End block
        } //End collapsed parenthetic
        int newPosition = position + charCount;
        sequence.toString().getChars(position, newPosition, dst, dstOffset);
        position = newPosition;
        varB4EAC82CA7396A68D541C85D26508E83_1464259302 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(charCount);
        varB4EAC82CA7396A68D541C85D26508E83_1464259302.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1464259302;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.936 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "31B4CDD043BD122CD33B2F180548B140")
    @Override
    public boolean isDirect() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_7270915 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_7270915;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.937 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "EFAE219194ADC2DD329F6ACF9F28FB01")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_705764358 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_705764358;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.938 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "5B97BFD132C753F88D198B1F3C495C74")
    @Override
    public ByteOrder order() {
        ByteOrder varB4EAC82CA7396A68D541C85D26508E83_212602470 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_212602470 = ByteOrder.nativeOrder();
        varB4EAC82CA7396A68D541C85D26508E83_212602470.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_212602470;
        // ---------- Original Method ----------
        //return ByteOrder.nativeOrder();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.938 -0400", hash_original_method = "5163488AC40767F8F030E728692C8A7E", hash_generated_method = "D0E706EA8F67DBC212EAB762AFA0DF84")
    @Override
    protected char[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_143952720 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_143952720;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.939 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "68407A9BA092927BCB8F9AE522D7E002")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_94868742 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_94868742;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.939 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "7DEB5630D20E73688E73C77A037E1D19")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1609060992 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1609060992;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.940 -0400", hash_original_method = "AA890865E828C97A020097D7CDA5EE73", hash_generated_method = "3A85A20458CD46C3155C147F6F048806")
    @Override
    public CharBuffer put(char c) {
        throw new ReadOnlyBufferException();
        
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.940 -0400", hash_original_method = "4BB5828CEE96E76B6DAC9C0855ABDDFD", hash_generated_method = "E150AA8DCB8978B57C618C5428A755CD")
    @Override
    public CharBuffer put(int index, char c) {
        throw new ReadOnlyBufferException();
        
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.941 -0400", hash_original_method = "456A915B3249AF3B6DBAB08ACEE5755D", hash_generated_method = "18EBBD5FFFA53649B304121971BF9CEA")
    @Override
    public final CharBuffer put(char[] src, int srcOffset, int charCount) {
         throw new ReadOnlyBufferException();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.941 -0400", hash_original_method = "4A99CE8F005D81D8D8D69EFF935B4E86", hash_generated_method = "29F4042A72DFAB1AB12EB8C658A3318C")
    @Override
    public CharBuffer put(String src, int start, int end) {
        throw new ReadOnlyBufferException();
        
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.941 -0400", hash_original_method = "BB736FDD5368DDDE2159755BA70731E0", hash_generated_method = "3486F6A29F52CBBECCF94A4BDF986213")
    @Override
    public CharBuffer slice() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_797394684 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_797394684 = new CharSequenceAdapter(sequence.subSequence(position, limit));
        varB4EAC82CA7396A68D541C85D26508E83_797394684.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_797394684;
        // ---------- Original Method ----------
        //return new CharSequenceAdapter(sequence.subSequence(position, limit));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.942 -0400", hash_original_method = "60F18802DACBE929591976E5523A2B99", hash_generated_method = "AFA0D1D061E0A1EE21963B2D8A35D99C")
    @Override
    public CharSequence subSequence(int start, int end) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1575198618 = null; //Variable for return #1
        checkStartEndRemaining(start, end);
        CharSequenceAdapter result = copy(this);
        result.position = position + start;
        result.limit = position + end;
        varB4EAC82CA7396A68D541C85D26508E83_1575198618 = result;
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_1575198618.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1575198618;
        // ---------- Original Method ----------
        //checkStartEndRemaining(start, end);
        //CharSequenceAdapter result = copy(this);
        //result.position = position + start;
        //result.limit = position + end;
        //return result;
    }

    
}

