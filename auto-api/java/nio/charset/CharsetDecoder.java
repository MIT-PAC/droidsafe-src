package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public abstract class CharsetDecoder {
    private static final int INIT = 0;
    private static final int ONGOING = 1;
    private static final int END = 2;
    private static final int FLUSH = 3;
    private final float averageCharsPerByte;
    private final float maxCharsPerByte;
    private final Charset cs;
    private CodingErrorAction malformedInputAction;
    private CodingErrorAction unmappableCharacterAction;
    private String replacementChars;
    private int status;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.535 -0400", hash_original_method = "8CF9EF6BF1CF308B9A895B171C1AF9B5", hash_generated_method = "944A46E9EC81D066E1313CE1736A38AD")
    @DSModeled(DSC.SAFE)
    protected CharsetDecoder(Charset charset, float averageCharsPerByte, float maxCharsPerByte) {
        dsTaint.addTaint(maxCharsPerByte);
        dsTaint.addTaint(charset.dsTaint);
        dsTaint.addTaint(averageCharsPerByte);
        {
            throw new IllegalArgumentException("averageCharsPerByte and maxCharsPerByte must be positive");
        } //End block
        {
            throw new IllegalArgumentException("averageCharsPerByte is greater than maxCharsPerByte");
        } //End block
        status = INIT;
        malformedInputAction = CodingErrorAction.REPORT;
        unmappableCharacterAction = CodingErrorAction.REPORT;
        replacementChars = "\ufffd";
        // ---------- Original Method ----------
        //if (averageCharsPerByte <= 0 || maxCharsPerByte <= 0) {
            //throw new IllegalArgumentException("averageCharsPerByte and maxCharsPerByte must be positive");
        //}
        //if (averageCharsPerByte > maxCharsPerByte) {
            //throw new IllegalArgumentException("averageCharsPerByte is greater than maxCharsPerByte");
        //}
        //this.averageCharsPerByte = averageCharsPerByte;
        //this.maxCharsPerByte = maxCharsPerByte;
        //cs = charset;
        //status = INIT;
        //malformedInputAction = CodingErrorAction.REPORT;
        //unmappableCharacterAction = CodingErrorAction.REPORT;
        //replacementChars = "\ufffd";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.535 -0400", hash_original_method = "835453458CD254EFEDF140BA3E3A0055", hash_generated_method = "4E3646E36377F0CD1D8A003FDB8C955F")
    @DSModeled(DSC.SAFE)
    public final float averageCharsPerByte() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return averageCharsPerByte;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.535 -0400", hash_original_method = "B98730A31745049759B27FC27542555A", hash_generated_method = "96304F68498177FF4282F41BE723127D")
    @DSModeled(DSC.SAFE)
    public final Charset charset() {
        return (Charset)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return cs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.535 -0400", hash_original_method = "0575B5D8A4FDBA875B2771D84C02D5E1", hash_generated_method = "54B4C4095916382FB6E40E0A347CF180")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CharBuffer decode(ByteBuffer in) throws CharacterCodingException {
        dsTaint.addTaint(in.dsTaint);
        reset();
        int length;
        length = (int) (in.remaining() * averageCharsPerByte);
        CharBuffer output;
        output = CharBuffer.allocate(length);
        CoderResult result;
        result = null;
        {
            result = decode(in, output, false);
            checkCoderResult(result);
            {
                boolean varF1DB9CE261DCF48645D6337FBFF24029_2005596671 = (result.isUnderflow());
                {
                    boolean varD20C9318A05139203F7B82FC87F4D343_64017770 = (result.isOverflow());
                    {
                        output = allocateMore(output);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        result = decode(in, output, true);
        checkCoderResult(result);
        {
            result = flush(output);
            checkCoderResult(result);
            {
                boolean var2AAE7F5A955BA87C5F37AFB5998173CD_1283444934 = (result.isOverflow());
                {
                    output = allocateMore(output);
                } //End block
            } //End collapsed parenthetic
        } //End block
        output.flip();
        status = FLUSH;
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.535 -0400", hash_original_method = "297219195E5B4473685A201861AC1DC3", hash_generated_method = "BF8527BAC7FD18278DB729799718C170")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkCoderResult(CoderResult result) throws CharacterCodingException {
        dsTaint.addTaint(result.dsTaint);
        {
            boolean var504E9C7F7D7D0D8DA16970B2F44C89AA_8338124 = (result.isMalformed() && malformedInputAction == CodingErrorAction.REPORT);
            {
                throw new MalformedInputException(result.length());
            } //End block
            {
                boolean varC1BF2F4D76DB2A66374D034187758580_1128439858 = (result.isUnmappable() && unmappableCharacterAction == CodingErrorAction.REPORT);
                {
                    throw new UnmappableCharacterException(result.length());
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (result.isMalformed() && malformedInputAction == CodingErrorAction.REPORT) {
            //throw new MalformedInputException(result.length());
        //} else if (result.isUnmappable() && unmappableCharacterAction == CodingErrorAction.REPORT) {
            //throw new UnmappableCharacterException(result.length());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.535 -0400", hash_original_method = "D4DFBF2849FE3731857D4FDEE2ED4787", hash_generated_method = "58BBE4079616E1BF1F37F7DF0D3526D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharBuffer allocateMore(CharBuffer output) {
        dsTaint.addTaint(output.dsTaint);
        {
            boolean var3DEB4C124602AAD988E7A1D53669DF60_261219670 = (output.capacity() == 0);
            {
                CharBuffer var3AF3C264ECC74B130C8C1E5941B5EBBF_297559119 = (CharBuffer.allocate(1));
            } //End block
        } //End collapsed parenthetic
        CharBuffer result;
        result = CharBuffer.allocate(output.capacity() * 2);
        output.flip();
        result.put(output);
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (output.capacity() == 0) {
            //return CharBuffer.allocate(1);
        //}
        //CharBuffer result = CharBuffer.allocate(output.capacity() * 2);
        //output.flip();
        //result.put(output);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.536 -0400", hash_original_method = "40037F62CA1EB410AEAF236C6BDF7EBA", hash_generated_method = "526684A07F869F993D8D50CA310488DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CoderResult decode(ByteBuffer in, CharBuffer out,
            boolean endOfInput) {
        dsTaint.addTaint(endOfInput);
        dsTaint.addTaint(in.dsTaint);
        dsTaint.addTaint(out.dsTaint);
        {
            throw new IllegalStateException();
        } //End block
        CoderResult result;
        result = null;
        {
            CodingErrorAction action;
            action = null;
            try 
            {
                result = decodeLoop(in, out);
            } //End block
            catch (BufferOverflowException ex)
            {
                throw new CoderMalfunctionError(ex);
            } //End block
            catch (BufferUnderflowException ex)
            {
                throw new CoderMalfunctionError(ex);
            } //End block
            {
                boolean varF1DB9CE261DCF48645D6337FBFF24029_1874588037 = (result.isUnderflow());
                {
                    int remaining;
                    remaining = in.remaining();
                    status = endOfInput ? END : ONGOING;
                    {
                        result = CoderResult.malformedForLength(remaining);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                boolean var2AAE7F5A955BA87C5F37AFB5998173CD_1898622254 = (result.isOverflow());
            } //End collapsed parenthetic
            action = malformedInputAction;
            {
                boolean var7C71B56CE29CA100AFEFFA537CA1E5FD_1952342555 = (result.isUnmappable());
                {
                    action = unmappableCharacterAction;
                } //End block
            } //End collapsed parenthetic
            {
                {
                    boolean varDFA1CD40AE60C1A98AAF3B3E35C30958_641995582 = (out.remaining() < replacementChars.length());
                } //End collapsed parenthetic
                out.put(replacementChars);
            } //End block
            in.position(in.position() + result.length());
        } //End block
        return (CoderResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    protected abstract CoderResult decodeLoop(ByteBuffer in, CharBuffer out);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.536 -0400", hash_original_method = "FA8F0AC80549BCE47D29C328C4E0F049", hash_generated_method = "188E0C1195FE1391EE580CE4A88DA7AE")
    @DSModeled(DSC.SAFE)
    public Charset detectedCharset() {
        throw new UnsupportedOperationException();
        return (Charset)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.536 -0400", hash_original_method = "5C3493C7F863D5F0BA88F45F364D1985", hash_generated_method = "3A0267D3647E46758748702DB039DDBD")
    @DSModeled(DSC.SAFE)
    public final CoderResult flush(CharBuffer out) {
        dsTaint.addTaint(out.dsTaint);
        {
            throw new IllegalStateException();
        } //End block
        CoderResult result;
        result = implFlush(out);
        {
            status = FLUSH;
        } //End block
        return (CoderResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (status != END && status != INIT) {
            //throw new IllegalStateException();
        //}
        //CoderResult result = implFlush(out);
        //if (result == CoderResult.UNDERFLOW) {
            //status = FLUSH;
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.536 -0400", hash_original_method = "6025E36E88B99911562F9F8AEE21E28F", hash_generated_method = "A065E0535EF10979084B752053A097E0")
    @DSModeled(DSC.SAFE)
    protected CoderResult implFlush(CharBuffer out) {
        dsTaint.addTaint(out.dsTaint);
        return (CoderResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return CoderResult.UNDERFLOW;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.536 -0400", hash_original_method = "E03D9D5B6C40FD58B1EEECF43C9BC127", hash_generated_method = "E247BDD25C5A10AE7E022CE556AF0638")
    @DSModeled(DSC.SAFE)
    protected void implOnMalformedInput(CodingErrorAction newAction) {
        dsTaint.addTaint(newAction.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.536 -0400", hash_original_method = "33D941D09604A3F698502AE892B2B2F1", hash_generated_method = "966FDD7601F50FC1BCEA9BA931754569")
    @DSModeled(DSC.SAFE)
    protected void implOnUnmappableCharacter(CodingErrorAction newAction) {
        dsTaint.addTaint(newAction.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.536 -0400", hash_original_method = "5014FF47E324504A21AF53F373310654", hash_generated_method = "8D81D3018991C5228E54DA74259101CF")
    @DSModeled(DSC.SAFE)
    protected void implReplaceWith(String newReplacement) {
        dsTaint.addTaint(newReplacement);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.536 -0400", hash_original_method = "B1E265ECD4B779BE3343E27B901DC354", hash_generated_method = "1ACB90FF5D97A1B7D3F0186C5D6A46D3")
    @DSModeled(DSC.SAFE)
    protected void implReset() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.536 -0400", hash_original_method = "0E3C677639C4DB544DC0D4E7955DC077", hash_generated_method = "4AB91C60BB582E74D98D4E3E5AC27774")
    @DSModeled(DSC.SAFE)
    public boolean isAutoDetecting() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.536 -0400", hash_original_method = "EB764964ACE224C10D45E3B66AA00682", hash_generated_method = "7F123652E266B3077419326E3D044072")
    @DSModeled(DSC.SAFE)
    public boolean isCharsetDetected() {
        throw new UnsupportedOperationException();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.536 -0400", hash_original_method = "14FFD5293B4145E0D4BC6D81F9598816", hash_generated_method = "386FE7759423FD14A97595A177F69642")
    @DSModeled(DSC.SAFE)
    public CodingErrorAction malformedInputAction() {
        return (CodingErrorAction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return malformedInputAction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.536 -0400", hash_original_method = "1F4ECBF7B137C80889EF1BC2E2A0CCD1", hash_generated_method = "2350F41187CB943E987C449D9387C724")
    @DSModeled(DSC.SAFE)
    public final float maxCharsPerByte() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return maxCharsPerByte;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.536 -0400", hash_original_method = "34F534C82C11F1FDAA0DD59455B931CF", hash_generated_method = "4F6587C6638D7F743C3A4390A9420E36")
    @DSModeled(DSC.SAFE)
    public final CharsetDecoder onMalformedInput(CodingErrorAction newAction) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newAction.dsTaint);
        {
            throw new IllegalArgumentException();
        } //End block
        implOnMalformedInput(newAction);
        return (CharsetDecoder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (newAction == null) {
            //throw new IllegalArgumentException();
        //}
        //malformedInputAction = newAction;
        //implOnMalformedInput(newAction);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.536 -0400", hash_original_method = "652123D755D0FEE6B30AA61176E436F9", hash_generated_method = "EF241B4A5B518001C0E1DADF6057D3CF")
    @DSModeled(DSC.SAFE)
    public final CharsetDecoder onUnmappableCharacter(CodingErrorAction newAction) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newAction.dsTaint);
        {
            throw new IllegalArgumentException();
        } //End block
        implOnUnmappableCharacter(newAction);
        return (CharsetDecoder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (newAction == null) {
            //throw new IllegalArgumentException();
        //}
        //unmappableCharacterAction = newAction;
        //implOnUnmappableCharacter(newAction);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.536 -0400", hash_original_method = "30CB7E3F60490326C9B63C38EC65670E", hash_generated_method = "518ECC4AE019CA3B63E71A3FBD3DF488")
    @DSModeled(DSC.SAFE)
    public final String replacement() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return replacementChars;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.537 -0400", hash_original_method = "B18C28BF3814F00BA79DEB9A20AA9835", hash_generated_method = "6C655F11A3C14B3321B7F5315EC8AE5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CharsetDecoder replaceWith(String replacement) {
        dsTaint.addTaint(replacement);
        {
            throw new IllegalArgumentException("replacement == null");
        } //End block
        {
            boolean var110F23C56874217B802EA4C936A6C3F7_1081612472 = (replacement.isEmpty());
            {
                throw new IllegalArgumentException("replacement.isEmpty()");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA67683A55B0774718D49E6408E276F05_1220032466 = (replacement.length() > maxCharsPerByte());
            {
                throw new IllegalArgumentException("replacement length > maxCharsPerByte: " +
                    replacement.length() + " > " + maxCharsPerByte());
            } //End block
        } //End collapsed parenthetic
        implReplaceWith(replacement);
        return (CharsetDecoder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (replacement == null) {
            //throw new IllegalArgumentException("replacement == null");
        //}
        //if (replacement.isEmpty()) {
            //throw new IllegalArgumentException("replacement.isEmpty()");
        //}
        //if (replacement.length() > maxCharsPerByte()) {
            //throw new IllegalArgumentException("replacement length > maxCharsPerByte: " +
                    //replacement.length() + " > " + maxCharsPerByte());
        //}
        //replacementChars = replacement;
        //implReplaceWith(replacement);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.537 -0400", hash_original_method = "81D7771694F65FD718A9EEA5159D0F76", hash_generated_method = "D2EFEA4C5F555F4B3C5860B3C0DEE800")
    @DSModeled(DSC.SAFE)
    public final CharsetDecoder reset() {
        status = INIT;
        implReset();
        return (CharsetDecoder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //status = INIT;
        //implReset();
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.537 -0400", hash_original_method = "01254405DC3888434A269A87FF2AF4FB", hash_generated_method = "345C0678DB3142B924747B5F0C4BBF5F")
    @DSModeled(DSC.SAFE)
    public CodingErrorAction unmappableCharacterAction() {
        return (CodingErrorAction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return unmappableCharacterAction;
    }

    
}


