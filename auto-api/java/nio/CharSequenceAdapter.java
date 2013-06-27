package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

final class CharSequenceAdapter extends CharBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.936 -0400", hash_original_field = "FA1C731EAD93E333A9180E16F968C01E", hash_generated_field = "FC0228967C2CDD8E28E9C839DAD10434")

    CharSequence sequence;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.940 -0400", hash_original_method = "206685F1A3CB58D97E4CC4183E9D2DA8", hash_generated_method = "19C08A1FEB8CEF30A4B0B354687B89DC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.942 -0400", hash_original_method = "6272265C933D4E168CAF2033C47ED968", hash_generated_method = "2F774763F29CFA8080CFEE58599D53BD")
    @Override
    public CharBuffer asReadOnlyBuffer() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_704639667 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_704639667 = duplicate();
        varB4EAC82CA7396A68D541C85D26508E83_704639667.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_704639667;
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.953 -0400", hash_original_method = "B36182A594E1794791B93E3BECF5B149", hash_generated_method = "FDB048D4EFBE0B834B0B887336BCFF0E")
    @Override
    public CharBuffer compact() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.954 -0400", hash_original_method = "3B532E92A9E534AB72A0D7B6E50ABF8A", hash_generated_method = "01A61FB5E25F0B99100AFC6B33C1FA63")
    @Override
    public CharBuffer duplicate() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_217728727 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_217728727 = copy(this);
        varB4EAC82CA7396A68D541C85D26508E83_217728727.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_217728727;
        // ---------- Original Method ----------
        //return copy(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.954 -0400", hash_original_method = "2E35B46EACC27C03AFC8C4DE9C6A2F1C", hash_generated_method = "FF471F07594BB48038149BA63B73E721")
    @Override
    public char get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        char var654684F156C9B7591F260CB2EFD8E371_1854324935 = (sequence.charAt(position++));
        char varA87DEB01C5F539E6BDA34829C8EF2368_531894595 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_531894595;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return sequence.charAt(position++);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.974 -0400", hash_original_method = "0A3A9E7F0D00C569C240E619540C538B", hash_generated_method = "2B42E8548E7C1C23A14EBDDBF353BCED")
    @Override
    public char get(int index) {
        checkIndex(index);
        char varC9D047DE2AE351E8DC97E1E25A63F27D_521005746 = (sequence.charAt(index));
        addTaint(index);
        char varA87DEB01C5F539E6BDA34829C8EF2368_1858989549 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1858989549;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return sequence.charAt(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.976 -0400", hash_original_method = "B46220E47C2CF78231CB9172DECC2B72", hash_generated_method = "03E46752BCB8C9F4DB9352C662F1243E")
    @Override
    public final CharBuffer get(char[] dst, int dstOffset, int charCount) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1416355092 = null; //Variable for return #1
        Arrays.checkOffsetAndCount(dst.length, dstOffset, charCount);
        {
            boolean varD6CE167C3592D038C7B14F59C84C4F0D_908743218 = (charCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
            } //End block
        } //End collapsed parenthetic
        int newPosition;
        newPosition = position + charCount;
        sequence.toString().getChars(position, newPosition, dst, dstOffset);
        position = newPosition;
        varB4EAC82CA7396A68D541C85D26508E83_1416355092 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(charCount);
        varB4EAC82CA7396A68D541C85D26508E83_1416355092.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1416355092;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.976 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "A6B1B057C33F9A2B45CB86454AD93F57")
    @Override
    public boolean isDirect() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_480136483 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_480136483;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.977 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "967E1776147C62F157DC621338E296CB")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1807204043 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1807204043;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.977 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "8E1C6203059BF2A1851C402A6A350019")
    @Override
    public ByteOrder order() {
        ByteOrder varB4EAC82CA7396A68D541C85D26508E83_1170547765 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1170547765 = ByteOrder.nativeOrder();
        varB4EAC82CA7396A68D541C85D26508E83_1170547765.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1170547765;
        // ---------- Original Method ----------
        //return ByteOrder.nativeOrder();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.978 -0400", hash_original_method = "5163488AC40767F8F030E728692C8A7E", hash_generated_method = "C1CECE5A2590FF22E5D413E48045BC76")
    @Override
    protected char[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1840542557 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1840542557;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.978 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "19E72AA862CF9479E822C090B54907B9")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1094937054 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1094937054;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.979 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "5A43F1FB8B52CCB1FEC4621871496007")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1161883812 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1161883812;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.979 -0400", hash_original_method = "AA890865E828C97A020097D7CDA5EE73", hash_generated_method = "3A85A20458CD46C3155C147F6F048806")
    @Override
    public CharBuffer put(char c) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(c);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.999 -0400", hash_original_method = "4BB5828CEE96E76B6DAC9C0855ABDDFD", hash_generated_method = "E150AA8DCB8978B57C618C5428A755CD")
    @Override
    public CharBuffer put(int index, char c) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(index);
        addTaint(c);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.004 -0400", hash_original_method = "456A915B3249AF3B6DBAB08ACEE5755D", hash_generated_method = "18EBBD5FFFA53649B304121971BF9CEA")
    @Override
    public final CharBuffer put(char[] src, int srcOffset, int charCount) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(charCount);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.005 -0400", hash_original_method = "4A99CE8F005D81D8D8D69EFF935B4E86", hash_generated_method = "29F4042A72DFAB1AB12EB8C658A3318C")
    @Override
    public CharBuffer put(String src, int start, int end) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(src.getTaint());
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.006 -0400", hash_original_method = "BB736FDD5368DDDE2159755BA70731E0", hash_generated_method = "94C69AABABA04AB9D68234C6561E8B2C")
    @Override
    public CharBuffer slice() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_456014847 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_456014847 = new CharSequenceAdapter(sequence.subSequence(position, limit));
        varB4EAC82CA7396A68D541C85D26508E83_456014847.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_456014847;
        // ---------- Original Method ----------
        //return new CharSequenceAdapter(sequence.subSequence(position, limit));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.007 -0400", hash_original_method = "60F18802DACBE929591976E5523A2B99", hash_generated_method = "342354A69CFC28C60403C2F64B8867C5")
    @Override
    public CharSequence subSequence(int start, int end) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_622823408 = null; //Variable for return #1
        checkStartEndRemaining(start, end);
        CharSequenceAdapter result;
        result = copy(this);
        result.position = position + start;
        result.limit = position + end;
        varB4EAC82CA7396A68D541C85D26508E83_622823408 = result;
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_622823408.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_622823408;
        // ---------- Original Method ----------
        //checkStartEndRemaining(start, end);
        //CharSequenceAdapter result = copy(this);
        //result.position = position + start;
        //result.limit = position + end;
        //return result;
    }

    
}

