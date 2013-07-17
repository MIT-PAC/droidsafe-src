package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

final class CharSequenceAdapter extends CharBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.365 -0400", hash_original_field = "FA1C731EAD93E333A9180E16F968C01E", hash_generated_field = "FC0228967C2CDD8E28E9C839DAD10434")

    CharSequence sequence;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.366 -0400", hash_original_method = "206685F1A3CB58D97E4CC4183E9D2DA8", hash_generated_method = "19C08A1FEB8CEF30A4B0B354687B89DC")
      CharSequenceAdapter(CharSequence chseq) {
        super(chseq.length());
        sequence = chseq;
        // ---------- Original Method ----------
        //sequence = chseq;
    }

    
    @DSModeled(DSC.SAFE)
    static CharSequenceAdapter copy(CharSequenceAdapter other) {
        CharSequenceAdapter buf = new CharSequenceAdapter(other.sequence);
        buf.limit = other.limit;
        buf.position = other.position;
        buf.mark = other.mark;
        return buf;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.367 -0400", hash_original_method = "6272265C933D4E168CAF2033C47ED968", hash_generated_method = "C1642F4AB1630F1581F6B39A7305D8CA")
    @Override
    public CharBuffer asReadOnlyBuffer() {
CharBuffer var398C146492D42068C7FF67EDC7FA3DFF_1007247819 =         duplicate();
        var398C146492D42068C7FF67EDC7FA3DFF_1007247819.addTaint(taint);
        return var398C146492D42068C7FF67EDC7FA3DFF_1007247819;
        // ---------- Original Method ----------
        //return duplicate();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.367 -0400", hash_original_method = "B36182A594E1794791B93E3BECF5B149", hash_generated_method = "14DE10FF74EEF45ED451A7374501B090")
    @Override
    public CharBuffer compact() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1515857453 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1515857453.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1515857453;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.368 -0400", hash_original_method = "3B532E92A9E534AB72A0D7B6E50ABF8A", hash_generated_method = "B44915D8C6C4FF70508A6754EC6198C6")
    @Override
    public CharBuffer duplicate() {
CharBuffer var965D66642EAD7AFBE0072E15599E3F83_833277131 =         copy(this);
        var965D66642EAD7AFBE0072E15599E3F83_833277131.addTaint(taint);
        return var965D66642EAD7AFBE0072E15599E3F83_833277131;
        // ---------- Original Method ----------
        //return copy(this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.368 -0400", hash_original_method = "2E35B46EACC27C03AFC8C4DE9C6A2F1C", hash_generated_method = "BA30E083F998F4DF5E1ED2F1B6A03ACE")
    @Override
    public char get() {
        if(position == limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1153853991 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1153853991.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1153853991;
        } //End block
        char varBEE718100952C651DF86BF6E6F0F1572_415348105 = (sequence.charAt(position++));
                char varA87DEB01C5F539E6BDA34829C8EF2368_1050434372 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1050434372;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return sequence.charAt(position++);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.368 -0400", hash_original_method = "0A3A9E7F0D00C569C240E619540C538B", hash_generated_method = "A02751AC64ED1B3ABA063298B73784CB")
    @Override
    public char get(int index) {
        addTaint(index);
        checkIndex(index);
        char var42A709BEAE205361BD0518C297967B5E_173084174 = (sequence.charAt(index));
                char varA87DEB01C5F539E6BDA34829C8EF2368_1154808856 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1154808856;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return sequence.charAt(index);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.369 -0400", hash_original_method = "B46220E47C2CF78231CB9172DECC2B72", hash_generated_method = "F55D6C42FEDF06BB1F6AFA77D25A4D5B")
    @Override
    public final CharBuffer get(char[] dst, int dstOffset, int charCount) {
        addTaint(charCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        Arrays.checkOffsetAndCount(dst.length, dstOffset, charCount);
        if(charCount > remaining())        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1340047273 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1340047273.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1340047273;
        } //End block
        int newPosition = position + charCount;
        sequence.toString().getChars(position, newPosition, dst, dstOffset);
        position = newPosition;
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_1075214123 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1075214123.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1075214123;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.369 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "DF55D80A071C1485ACAF363B8BBDD9DE")
    @Override
    public boolean isDirect() {
        boolean var68934A3E9455FA72420237EB05902327_314945647 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1707974046 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1707974046;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.369 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "D4C2905E0BCC4CD6BCA604962283FECD")
    @Override
    public boolean isReadOnly() {
        boolean varB326B5062B2F0E69046810717534CB09_1763230184 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1941747767 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1941747767;
        // ---------- Original Method ----------
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.370 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "61BFB858494F0E6B9A4B6E3FD21023AF")
    @Override
    public ByteOrder order() {
ByteOrder var1B533639214E0AD13A9C318946B77D59_179984031 =         ByteOrder.nativeOrder();
        var1B533639214E0AD13A9C318946B77D59_179984031.addTaint(taint);
        return var1B533639214E0AD13A9C318946B77D59_179984031;
        // ---------- Original Method ----------
        //return ByteOrder.nativeOrder();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.370 -0400", hash_original_method = "5163488AC40767F8F030E728692C8A7E", hash_generated_method = "E7C64DD795E58C20E678A697FC4DB1DF")
    @Override
    protected char[] protectedArray() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_173003688 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_173003688.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_173003688;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.370 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "F2B326A78829A42FD18C461E79EA545D")
    @Override
    protected int protectedArrayOffset() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1968819468 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1968819468.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1968819468;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.371 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "18313A7BD205066B700837D8CC3B3BFE")
    @Override
    protected boolean protectedHasArray() {
        boolean var68934A3E9455FA72420237EB05902327_927099554 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1886848497 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1886848497;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.371 -0400", hash_original_method = "AA890865E828C97A020097D7CDA5EE73", hash_generated_method = "6A9B9A7CA2A3C01E7FD50BF4D56C7E78")
    @Override
    public CharBuffer put(char c) {
        addTaint(c);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1198476994 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1198476994.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1198476994;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.371 -0400", hash_original_method = "4BB5828CEE96E76B6DAC9C0855ABDDFD", hash_generated_method = "A3A5346AE873858DD5E2ACB30415C249")
    @Override
    public CharBuffer put(int index, char c) {
        addTaint(c);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_81315715 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_81315715.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_81315715;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.372 -0400", hash_original_method = "456A915B3249AF3B6DBAB08ACEE5755D", hash_generated_method = "221F42B51CB95DB01B24AFAC9302AD21")
    @Override
    public final CharBuffer put(char[] src, int srcOffset, int charCount) {
        addTaint(charCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_40305300 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_40305300.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_40305300;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.372 -0400", hash_original_method = "4A99CE8F005D81D8D8D69EFF935B4E86", hash_generated_method = "D00B7EA27A86541DC5BDFBFFC6986018")
    @Override
    public CharBuffer put(String src, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(src.getTaint());
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_336836041 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_336836041.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_336836041;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.372 -0400", hash_original_method = "BB736FDD5368DDDE2159755BA70731E0", hash_generated_method = "38EE942F3667D98640D88768730AD3F2")
    @Override
    public CharBuffer slice() {
CharBuffer varF34F14547C6001CCAD65B14263B2DA92_1430879809 =         new CharSequenceAdapter(sequence.subSequence(position, limit));
        varF34F14547C6001CCAD65B14263B2DA92_1430879809.addTaint(taint);
        return varF34F14547C6001CCAD65B14263B2DA92_1430879809;
        // ---------- Original Method ----------
        //return new CharSequenceAdapter(sequence.subSequence(position, limit));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.373 -0400", hash_original_method = "60F18802DACBE929591976E5523A2B99", hash_generated_method = "6D906CAE2381E610F1B33977C790EBA3")
    @Override
    public CharSequence subSequence(int start, int end) {
        addTaint(end);
        addTaint(start);
        checkStartEndRemaining(start, end);
        CharSequenceAdapter result = copy(this);
        result.position = position + start;
        result.limit = position + end;
CharSequence varDC838461EE2FA0CA4C9BBB70A15456B0_1710797011 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1710797011.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1710797011;
        // ---------- Original Method ----------
        //checkStartEndRemaining(start, end);
        //CharSequenceAdapter result = copy(this);
        //result.position = position + start;
        //result.limit = position + end;
        //return result;
    }

    
}

