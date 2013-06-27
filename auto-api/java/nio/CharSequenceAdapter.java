package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

final class CharSequenceAdapter extends CharBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.001 -0400", hash_original_field = "FA1C731EAD93E333A9180E16F968C01E", hash_generated_field = "FC0228967C2CDD8E28E9C839DAD10434")

    CharSequence sequence;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.001 -0400", hash_original_method = "206685F1A3CB58D97E4CC4183E9D2DA8", hash_generated_method = "19C08A1FEB8CEF30A4B0B354687B89DC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.002 -0400", hash_original_method = "6272265C933D4E168CAF2033C47ED968", hash_generated_method = "3AEA40AF74C087F22334EFF9101714E8")
    @Override
    public CharBuffer asReadOnlyBuffer() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1959679028 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1959679028 = duplicate();
        varB4EAC82CA7396A68D541C85D26508E83_1959679028.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1959679028;
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.009 -0400", hash_original_method = "B36182A594E1794791B93E3BECF5B149", hash_generated_method = "FDB048D4EFBE0B834B0B887336BCFF0E")
    @Override
    public CharBuffer compact() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.009 -0400", hash_original_method = "3B532E92A9E534AB72A0D7B6E50ABF8A", hash_generated_method = "D70CF5713A2A70E1562B38C349AE6295")
    @Override
    public CharBuffer duplicate() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_465930432 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_465930432 = copy(this);
        varB4EAC82CA7396A68D541C85D26508E83_465930432.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_465930432;
        // ---------- Original Method ----------
        //return copy(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.010 -0400", hash_original_method = "2E35B46EACC27C03AFC8C4DE9C6A2F1C", hash_generated_method = "F1DEC4797BF455C74A685DBBF29077CF")
    @Override
    public char get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        char var654684F156C9B7591F260CB2EFD8E371_1770319880 = (sequence.charAt(position++));
        char varA87DEB01C5F539E6BDA34829C8EF2368_1442776610 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1442776610;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return sequence.charAt(position++);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.010 -0400", hash_original_method = "0A3A9E7F0D00C569C240E619540C538B", hash_generated_method = "EFF165D4BB28230C5A7FF83946958FC1")
    @Override
    public char get(int index) {
        checkIndex(index);
        char varC9D047DE2AE351E8DC97E1E25A63F27D_1597506843 = (sequence.charAt(index));
        addTaint(index);
        char varA87DEB01C5F539E6BDA34829C8EF2368_1312004822 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1312004822;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return sequence.charAt(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.014 -0400", hash_original_method = "B46220E47C2CF78231CB9172DECC2B72", hash_generated_method = "CF53B305A52091823BB4FA6F0AA37DCC")
    @Override
    public final CharBuffer get(char[] dst, int dstOffset, int charCount) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_558024234 = null; //Variable for return #1
        Arrays.checkOffsetAndCount(dst.length, dstOffset, charCount);
        {
            boolean varD6CE167C3592D038C7B14F59C84C4F0D_1290114104 = (charCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
            } //End block
        } //End collapsed parenthetic
        int newPosition;
        newPosition = position + charCount;
        sequence.toString().getChars(position, newPosition, dst, dstOffset);
        position = newPosition;
        varB4EAC82CA7396A68D541C85D26508E83_558024234 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(charCount);
        varB4EAC82CA7396A68D541C85D26508E83_558024234.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_558024234;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.014 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "41D20D394934E79F6FCF55879FA5F69C")
    @Override
    public boolean isDirect() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1342761908 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1342761908;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.015 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "2C35EFE88D04D80DC6A1D271DC6158EB")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2000377280 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2000377280;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.015 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "08649207389F7E39734D9EE3FEE6E023")
    @Override
    public ByteOrder order() {
        ByteOrder varB4EAC82CA7396A68D541C85D26508E83_742698935 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_742698935 = ByteOrder.nativeOrder();
        varB4EAC82CA7396A68D541C85D26508E83_742698935.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_742698935;
        // ---------- Original Method ----------
        //return ByteOrder.nativeOrder();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.022 -0400", hash_original_method = "5163488AC40767F8F030E728692C8A7E", hash_generated_method = "B7FA8954D47640A8A3B4A4F57C30A218")
    @Override
    protected char[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_2120450643 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_2120450643;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.025 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "C0C0BD679F6B20411E3BF8797BC2D18A")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_733242115 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_733242115;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.026 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "2F9E3453C50E99A52ED9A316493FA693")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1179577053 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1179577053;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.026 -0400", hash_original_method = "AA890865E828C97A020097D7CDA5EE73", hash_generated_method = "3A85A20458CD46C3155C147F6F048806")
    @Override
    public CharBuffer put(char c) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(c);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.027 -0400", hash_original_method = "4BB5828CEE96E76B6DAC9C0855ABDDFD", hash_generated_method = "E150AA8DCB8978B57C618C5428A755CD")
    @Override
    public CharBuffer put(int index, char c) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(index);
        addTaint(c);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.027 -0400", hash_original_method = "456A915B3249AF3B6DBAB08ACEE5755D", hash_generated_method = "18EBBD5FFFA53649B304121971BF9CEA")
    @Override
    public final CharBuffer put(char[] src, int srcOffset, int charCount) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(charCount);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.031 -0400", hash_original_method = "4A99CE8F005D81D8D8D69EFF935B4E86", hash_generated_method = "29F4042A72DFAB1AB12EB8C658A3318C")
    @Override
    public CharBuffer put(String src, int start, int end) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(src.getTaint());
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.035 -0400", hash_original_method = "BB736FDD5368DDDE2159755BA70731E0", hash_generated_method = "CDE8C38220AE3911076D4A9F4FB59DA0")
    @Override
    public CharBuffer slice() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_984463502 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_984463502 = new CharSequenceAdapter(sequence.subSequence(position, limit));
        varB4EAC82CA7396A68D541C85D26508E83_984463502.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_984463502;
        // ---------- Original Method ----------
        //return new CharSequenceAdapter(sequence.subSequence(position, limit));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.045 -0400", hash_original_method = "60F18802DACBE929591976E5523A2B99", hash_generated_method = "3ADEF1E691C4F4775BA73FD4395B698A")
    @Override
    public CharSequence subSequence(int start, int end) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_405402287 = null; //Variable for return #1
        checkStartEndRemaining(start, end);
        CharSequenceAdapter result;
        result = copy(this);
        result.position = position + start;
        result.limit = position + end;
        varB4EAC82CA7396A68D541C85D26508E83_405402287 = result;
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_405402287.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_405402287;
        // ---------- Original Method ----------
        //checkStartEndRemaining(start, end);
        //CharSequenceAdapter result = copy(this);
        //result.position = position + start;
        //result.limit = position + end;
        //return result;
    }

    
}

