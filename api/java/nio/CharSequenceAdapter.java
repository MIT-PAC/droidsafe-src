package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

final class CharSequenceAdapter extends CharBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.054 -0400", hash_original_field = "FA1C731EAD93E333A9180E16F968C01E", hash_generated_field = "FC0228967C2CDD8E28E9C839DAD10434")

    CharSequence sequence;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.054 -0400", hash_original_method = "206685F1A3CB58D97E4CC4183E9D2DA8", hash_generated_method = "19C08A1FEB8CEF30A4B0B354687B89DC")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.055 -0400", hash_original_method = "6272265C933D4E168CAF2033C47ED968", hash_generated_method = "A9B321760D7B41D4842EB1D6C0F4AF49")
    @Override
    public CharBuffer asReadOnlyBuffer() {
CharBuffer var398C146492D42068C7FF67EDC7FA3DFF_652583381 =         duplicate();
        var398C146492D42068C7FF67EDC7FA3DFF_652583381.addTaint(taint);
        return var398C146492D42068C7FF67EDC7FA3DFF_652583381;
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.055 -0400", hash_original_method = "B36182A594E1794791B93E3BECF5B149", hash_generated_method = "423892B0F2488B31CAD5B3808589E9F3")
    @Override
    public CharBuffer compact() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_111519326 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_111519326.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_111519326;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.055 -0400", hash_original_method = "3B532E92A9E534AB72A0D7B6E50ABF8A", hash_generated_method = "2F0F9A2DDCC95EA4638E5BC62F9C78FC")
    @Override
    public CharBuffer duplicate() {
CharBuffer var965D66642EAD7AFBE0072E15599E3F83_1983904258 =         copy(this);
        var965D66642EAD7AFBE0072E15599E3F83_1983904258.addTaint(taint);
        return var965D66642EAD7AFBE0072E15599E3F83_1983904258;
        // ---------- Original Method ----------
        //return copy(this);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.056 -0400", hash_original_method = "2E35B46EACC27C03AFC8C4DE9C6A2F1C", hash_generated_method = "AA2994375995F75A24EFF56F886B1444")
    @Override
    public char get() {
    if(position == limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1133431093 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1133431093.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1133431093;
        } //End block
        char varBEE718100952C651DF86BF6E6F0F1572_634339082 = (sequence.charAt(position++));
                char varA87DEB01C5F539E6BDA34829C8EF2368_615557449 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_615557449;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return sequence.charAt(position++);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.056 -0400", hash_original_method = "0A3A9E7F0D00C569C240E619540C538B", hash_generated_method = "9EDFD79263BF59E18C3E7A192C5A6F69")
    @Override
    public char get(int index) {
        addTaint(index);
        checkIndex(index);
        char var42A709BEAE205361BD0518C297967B5E_262257134 = (sequence.charAt(index));
                char varA87DEB01C5F539E6BDA34829C8EF2368_183176826 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_183176826;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return sequence.charAt(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.057 -0400", hash_original_method = "B46220E47C2CF78231CB9172DECC2B72", hash_generated_method = "F4FEDC09F66EE2F32DAA1ACEAB355BCE")
    @Override
    public final CharBuffer get(char[] dst, int dstOffset, int charCount) {
        addTaint(charCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        Arrays.checkOffsetAndCount(dst.length, dstOffset, charCount);
    if(charCount > remaining())        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_176953912 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_176953912.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_176953912;
        } //End block
        int newPosition = position + charCount;
        sequence.toString().getChars(position, newPosition, dst, dstOffset);
        position = newPosition;
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_1324760627 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1324760627.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1324760627;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.057 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "7A2FF67159A3DFCCE9C1D2CA02D1E0F0")
    @Override
    public boolean isDirect() {
        boolean var68934A3E9455FA72420237EB05902327_1002126073 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1041371811 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1041371811;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.058 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "DCD47E4398C8A6A0B3DAB6D5D823D01F")
    @Override
    public boolean isReadOnly() {
        boolean varB326B5062B2F0E69046810717534CB09_334020946 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1234208643 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1234208643;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.058 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "8E924DB522C58AF04F422520CBBEBB17")
    @Override
    public ByteOrder order() {
ByteOrder var1B533639214E0AD13A9C318946B77D59_1559606087 =         ByteOrder.nativeOrder();
        var1B533639214E0AD13A9C318946B77D59_1559606087.addTaint(taint);
        return var1B533639214E0AD13A9C318946B77D59_1559606087;
        // ---------- Original Method ----------
        //return ByteOrder.nativeOrder();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.058 -0400", hash_original_method = "5163488AC40767F8F030E728692C8A7E", hash_generated_method = "94C7C4BC21DA696DFB14219580E64DAE")
    @Override
    protected char[] protectedArray() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_313148994 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_313148994.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_313148994;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.059 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "709159514F2EB89EA473163B09F09056")
    @Override
    protected int protectedArrayOffset() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1352932787 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1352932787.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1352932787;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.059 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "8FBDCBFF4B156060F8BFA678A17909A9")
    @Override
    protected boolean protectedHasArray() {
        boolean var68934A3E9455FA72420237EB05902327_1434342221 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1100730891 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1100730891;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.059 -0400", hash_original_method = "AA890865E828C97A020097D7CDA5EE73", hash_generated_method = "372F66485A9CE533441185C6537D7119")
    @Override
    public CharBuffer put(char c) {
        addTaint(c);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_544374488 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_544374488.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_544374488;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.060 -0400", hash_original_method = "4BB5828CEE96E76B6DAC9C0855ABDDFD", hash_generated_method = "2E0F3F058EED95F92A307AE413FEEDF0")
    @Override
    public CharBuffer put(int index, char c) {
        addTaint(c);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1632845030 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1632845030.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1632845030;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.060 -0400", hash_original_method = "456A915B3249AF3B6DBAB08ACEE5755D", hash_generated_method = "5A2975D8338E334AD743133E7AAFD3FB")
    @Override
    public final CharBuffer put(char[] src, int srcOffset, int charCount) {
        addTaint(charCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1973576788 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1973576788.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1973576788;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.061 -0400", hash_original_method = "4A99CE8F005D81D8D8D69EFF935B4E86", hash_generated_method = "D8B1CE3A4564038CAE448AA6FA1CAB0C")
    @Override
    public CharBuffer put(String src, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(src.getTaint());
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_529649543 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_529649543.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_529649543;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.061 -0400", hash_original_method = "BB736FDD5368DDDE2159755BA70731E0", hash_generated_method = "9725D4C25603610C7EB6773EE2B8F61D")
    @Override
    public CharBuffer slice() {
CharBuffer varF34F14547C6001CCAD65B14263B2DA92_390573374 =         new CharSequenceAdapter(sequence.subSequence(position, limit));
        varF34F14547C6001CCAD65B14263B2DA92_390573374.addTaint(taint);
        return varF34F14547C6001CCAD65B14263B2DA92_390573374;
        // ---------- Original Method ----------
        //return new CharSequenceAdapter(sequence.subSequence(position, limit));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.062 -0400", hash_original_method = "60F18802DACBE929591976E5523A2B99", hash_generated_method = "91CF1B34806C92039A717D627242EAF5")
    @Override
    public CharSequence subSequence(int start, int end) {
        addTaint(end);
        addTaint(start);
        checkStartEndRemaining(start, end);
        CharSequenceAdapter result = copy(this);
        result.position = position + start;
        result.limit = position + end;
CharSequence varDC838461EE2FA0CA4C9BBB70A15456B0_1735191670 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1735191670.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1735191670;
        // ---------- Original Method ----------
        //checkStartEndRemaining(start, end);
        //CharSequenceAdapter result = copy(this);
        //result.position = position + start;
        //result.limit = position + end;
        //return result;
    }

    
}

