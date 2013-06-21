package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public abstract class CharsetDecoder {
    private float averageCharsPerByte;
    private float maxCharsPerByte;
    private Charset cs;
    private CodingErrorAction malformedInputAction;
    private CodingErrorAction unmappableCharacterAction;
    private String replacementChars;
    private int status;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.203 -0400", hash_original_method = "8CF9EF6BF1CF308B9A895B171C1AF9B5", hash_generated_method = "6351471676AED388942959BD6CDCBB7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected CharsetDecoder(Charset charset, float averageCharsPerByte, float maxCharsPerByte) {
        dsTaint.addTaint(maxCharsPerByte);
        dsTaint.addTaint(charset.dsTaint);
        dsTaint.addTaint(averageCharsPerByte);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("averageCharsPerByte and maxCharsPerByte must be positive");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("averageCharsPerByte is greater than maxCharsPerByte");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.203 -0400", hash_original_method = "835453458CD254EFEDF140BA3E3A0055", hash_generated_method = "2F98CB2C420C1058E6B29DCD0316E6E9")
    @DSModeled(DSC.SAFE)
    public final float averageCharsPerByte() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return averageCharsPerByte;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.203 -0400", hash_original_method = "B98730A31745049759B27FC27542555A", hash_generated_method = "D0207AB548C5EF80DAD15B7235758A89")
    @DSModeled(DSC.SAFE)
    public final Charset charset() {
        return (Charset)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return cs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.204 -0400", hash_original_method = "0575B5D8A4FDBA875B2771D84C02D5E1", hash_generated_method = "257F788D6683AF3EC1079D3B1AD3E697")
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
                boolean varF1DB9CE261DCF48645D6337FBFF24029_1603023802 = (result.isUnderflow());
                {
                    boolean varD20C9318A05139203F7B82FC87F4D343_1198433758 = (result.isOverflow());
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
                boolean var2AAE7F5A955BA87C5F37AFB5998173CD_883665959 = (result.isOverflow());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.204 -0400", hash_original_method = "297219195E5B4473685A201861AC1DC3", hash_generated_method = "356F0DFBA01C8A6D7989EB29ABF974E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkCoderResult(CoderResult result) throws CharacterCodingException {
        dsTaint.addTaint(result.dsTaint);
        {
            boolean var504E9C7F7D7D0D8DA16970B2F44C89AA_947979861 = (result.isMalformed() && malformedInputAction == CodingErrorAction.REPORT);
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedInputException(result.length());
            } //End block
            {
                boolean varC1BF2F4D76DB2A66374D034187758580_1207022083 = (result.isUnmappable() && unmappableCharacterAction == CodingErrorAction.REPORT);
                {
                    if (DroidSafeAndroidRuntime.control) throw new UnmappableCharacterException(result.length());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.204 -0400", hash_original_method = "D4DFBF2849FE3731857D4FDEE2ED4787", hash_generated_method = "3F0D933B61D8F7F2332DA65889C314E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharBuffer allocateMore(CharBuffer output) {
        dsTaint.addTaint(output.dsTaint);
        {
            boolean var3DEB4C124602AAD988E7A1D53669DF60_1449573268 = (output.capacity() == 0);
            {
                CharBuffer var3AF3C264ECC74B130C8C1E5941B5EBBF_85963786 = (CharBuffer.allocate(1));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.205 -0400", hash_original_method = "40037F62CA1EB410AEAF236C6BDF7EBA", hash_generated_method = "DC208C7553E408128CD8582885C657A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CoderResult decode(ByteBuffer in, CharBuffer out,
            boolean endOfInput) {
        dsTaint.addTaint(endOfInput);
        dsTaint.addTaint(in.dsTaint);
        dsTaint.addTaint(out.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
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
                if (DroidSafeAndroidRuntime.control) throw new CoderMalfunctionError(ex);
            } //End block
            catch (BufferUnderflowException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new CoderMalfunctionError(ex);
            } //End block
            {
                boolean varF1DB9CE261DCF48645D6337FBFF24029_2136697923 = (result.isUnderflow());
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
                boolean var2AAE7F5A955BA87C5F37AFB5998173CD_402002772 = (result.isOverflow());
            } //End collapsed parenthetic
            action = malformedInputAction;
            {
                boolean var7C71B56CE29CA100AFEFFA537CA1E5FD_1128253110 = (result.isUnmappable());
                {
                    action = unmappableCharacterAction;
                } //End block
            } //End collapsed parenthetic
            {
                {
                    boolean varDFA1CD40AE60C1A98AAF3B3E35C30958_1931074348 = (out.remaining() < replacementChars.length());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.207 -0400", hash_original_method = "FA8F0AC80549BCE47D29C328C4E0F049", hash_generated_method = "59BFE7E2FD43C9509ABD807272A84307")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Charset detectedCharset() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return (Charset)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.207 -0400", hash_original_method = "5C3493C7F863D5F0BA88F45F364D1985", hash_generated_method = "3D36D8E28A448E865FF154ADB11A07B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CoderResult flush(CharBuffer out) {
        dsTaint.addTaint(out.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.207 -0400", hash_original_method = "6025E36E88B99911562F9F8AEE21E28F", hash_generated_method = "8EE56BED40C9A3312111E6645624140D")
    @DSModeled(DSC.SAFE)
    protected CoderResult implFlush(CharBuffer out) {
        dsTaint.addTaint(out.dsTaint);
        return (CoderResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return CoderResult.UNDERFLOW;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.207 -0400", hash_original_method = "E03D9D5B6C40FD58B1EEECF43C9BC127", hash_generated_method = "8DC46AA9588D560D3FFAEDE5063DC30D")
    @DSModeled(DSC.SAFE)
    protected void implOnMalformedInput(CodingErrorAction newAction) {
        dsTaint.addTaint(newAction.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.208 -0400", hash_original_method = "33D941D09604A3F698502AE892B2B2F1", hash_generated_method = "2ABF678D190FF5B284667E54AB76354B")
    @DSModeled(DSC.SAFE)
    protected void implOnUnmappableCharacter(CodingErrorAction newAction) {
        dsTaint.addTaint(newAction.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.208 -0400", hash_original_method = "5014FF47E324504A21AF53F373310654", hash_generated_method = "44131D9626282B49FC8B95C57DFDD9C3")
    @DSModeled(DSC.SAFE)
    protected void implReplaceWith(String newReplacement) {
        dsTaint.addTaint(newReplacement);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.208 -0400", hash_original_method = "B1E265ECD4B779BE3343E27B901DC354", hash_generated_method = "2A58666B59F850117B41A249C7AD97D2")
    @DSModeled(DSC.SAFE)
    protected void implReset() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.208 -0400", hash_original_method = "0E3C677639C4DB544DC0D4E7955DC077", hash_generated_method = "45EBE5D5FDD4BF2ED607DEE6B9C931D9")
    @DSModeled(DSC.SAFE)
    public boolean isAutoDetecting() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.208 -0400", hash_original_method = "EB764964ACE224C10D45E3B66AA00682", hash_generated_method = "45FFF442AC9752A399D50AFD12A73F3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isCharsetDetected() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.208 -0400", hash_original_method = "14FFD5293B4145E0D4BC6D81F9598816", hash_generated_method = "1D6BC4D71E4472429EE9D29156DA9DF8")
    @DSModeled(DSC.SAFE)
    public CodingErrorAction malformedInputAction() {
        return (CodingErrorAction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return malformedInputAction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.209 -0400", hash_original_method = "1F4ECBF7B137C80889EF1BC2E2A0CCD1", hash_generated_method = "0B462287AED82FE8DEC77C15DEFEEB08")
    @DSModeled(DSC.SAFE)
    public final float maxCharsPerByte() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return maxCharsPerByte;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.209 -0400", hash_original_method = "34F534C82C11F1FDAA0DD59455B931CF", hash_generated_method = "C4B08D62E00FAB355E293B5DB09A2D5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CharsetDecoder onMalformedInput(CodingErrorAction newAction) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newAction.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.209 -0400", hash_original_method = "652123D755D0FEE6B30AA61176E436F9", hash_generated_method = "2BCCAC57E6D4C44A45CACFE465186CD5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CharsetDecoder onUnmappableCharacter(CodingErrorAction newAction) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newAction.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.209 -0400", hash_original_method = "30CB7E3F60490326C9B63C38EC65670E", hash_generated_method = "7B8C71EA589574177DAC073EC0BF8648")
    @DSModeled(DSC.SAFE)
    public final String replacement() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return replacementChars;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.210 -0400", hash_original_method = "B18C28BF3814F00BA79DEB9A20AA9835", hash_generated_method = "FF397334A7A497FD7F8A4B472D99765C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CharsetDecoder replaceWith(String replacement) {
        dsTaint.addTaint(replacement);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("replacement == null");
        } //End block
        {
            boolean var110F23C56874217B802EA4C936A6C3F7_874314407 = (replacement.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("replacement.isEmpty()");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA67683A55B0774718D49E6408E276F05_1003542515 = (replacement.length() > maxCharsPerByte());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("replacement length > maxCharsPerByte: " +
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.210 -0400", hash_original_method = "81D7771694F65FD718A9EEA5159D0F76", hash_generated_method = "CCEC0383664C861A97053B78ABFC8B21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CharsetDecoder reset() {
        status = INIT;
        implReset();
        return (CharsetDecoder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //status = INIT;
        //implReset();
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.210 -0400", hash_original_method = "01254405DC3888434A269A87FF2AF4FB", hash_generated_method = "764782FE086AE3CFC7FC0F5DEEF4FFFB")
    @DSModeled(DSC.SAFE)
    public CodingErrorAction unmappableCharacterAction() {
        return (CodingErrorAction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return unmappableCharacterAction;
    }

    
    private static final int INIT = 0;
    private static final int ONGOING = 1;
    private static final int END = 2;
    private static final int FLUSH = 3;
}

