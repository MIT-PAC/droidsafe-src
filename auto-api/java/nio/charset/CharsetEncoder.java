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
import java.util.Arrays;

public abstract class CharsetEncoder {
    private static int READY = 0;
    private static int ONGOING = 1;
    private static int END = 2;
    private static int FLUSH = 3;
    private static int INIT = 4;
    private Charset cs;
    private float averageBytesPerChar;
    private float maxBytesPerChar;
    private byte[] replacementBytes;
    private int status;
    private boolean finished;
    private CodingErrorAction malformedInputAction;
    private CodingErrorAction unmappableCharacterAction;
    private CharsetDecoder decoder;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:55:50.698 -0400", hash_original_method = "5E9CA4841A80C315BA24674061FE2949", hash_generated_method = "7A5ABDCF25C3E4279EF4611265E71371")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected CharsetEncoder(Charset cs, float averageBytesPerChar, float maxBytesPerChar) {
        this(cs, averageBytesPerChar, maxBytesPerChar, new byte[] { (byte) '?' });
        dsTaint.addTaint(averageBytesPerChar);
        dsTaint.addTaint(cs.dsTaint);
        dsTaint.addTaint(maxBytesPerChar);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:55:50.700 -0400", hash_original_method = "33500150E00A96E14E2810282423268E", hash_generated_method = "AB4072D241F6121C7853A43D32738822")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected CharsetEncoder(Charset cs, float averageBytesPerChar, float maxBytesPerChar, byte[] replacement) {
        this(cs, averageBytesPerChar, maxBytesPerChar, replacement, false);
        dsTaint.addTaint(replacement);
        dsTaint.addTaint(averageBytesPerChar);
        dsTaint.addTaint(cs.dsTaint);
        dsTaint.addTaint(maxBytesPerChar);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:55:50.707 -0400", hash_original_method = "173A83611BD70B9738420414876CE0BB", hash_generated_method = "26CF5BB81B62C76FFF8742535452A285")
    @DSModeled(DSC.SAFE)
     CharsetEncoder(Charset cs, float averageBytesPerChar, float maxBytesPerChar, byte[] replacement, boolean trusted) {
        dsTaint.addTaint(replacement);
        dsTaint.addTaint(trusted);
        dsTaint.addTaint(averageBytesPerChar);
        dsTaint.addTaint(cs.dsTaint);
        dsTaint.addTaint(maxBytesPerChar);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("averageBytesPerChar and maxBytesPerChar must both be positive");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("averageBytesPerChar is greater than maxBytesPerChar");
        } //End block
        status = INIT;
        malformedInputAction = CodingErrorAction.REPORT;
        unmappableCharacterAction = CodingErrorAction.REPORT;
        {
            replaceWith(replacement);
        } //End block
        // ---------- Original Method ----------
        //if (averageBytesPerChar <= 0 || maxBytesPerChar <= 0) {
            //throw new IllegalArgumentException("averageBytesPerChar and maxBytesPerChar must both be positive");
        //}
        //if (averageBytesPerChar > maxBytesPerChar) {
            //throw new IllegalArgumentException("averageBytesPerChar is greater than maxBytesPerChar");
        //}
        //this.cs = cs;
        //this.averageBytesPerChar = averageBytesPerChar;
        //this.maxBytesPerChar = maxBytesPerChar;
        //status = INIT;
        //malformedInputAction = CodingErrorAction.REPORT;
        //unmappableCharacterAction = CodingErrorAction.REPORT;
        //if (trusted) {
            //this.replacementBytes = replacement;
        //} else {
            //replaceWith(replacement);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:55:50.711 -0400", hash_original_method = "A746602428AC27FECC8176A57B5A2933", hash_generated_method = "0795B4315DA716E11EF8F9B93297F6F8")
    @DSModeled(DSC.SAFE)
    public final float averageBytesPerChar() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return averageBytesPerChar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:55:50.714 -0400", hash_original_method = "DF8D80CA8C09E77634765D8D414FAE26", hash_generated_method = "EA610234A451DE2F5D1214AC31C3BC47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canEncode(char c) {
        dsTaint.addTaint(c);
        boolean varA7FD43173EF46EB747DE5BC527CFC0F0_2118730490 = (implCanEncode(CharBuffer.wrap(new char[] { c })));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return implCanEncode(CharBuffer.wrap(new char[] { c }));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:55:50.721 -0400", hash_original_method = "8FE38300B66D2E408C3C937D4188B910", hash_generated_method = "69229E36A5A4EC807BFA356EB5954755")
    @DSModeled(DSC.SAFE)
    private boolean implCanEncode(CharBuffer cb) {
        dsTaint.addTaint(cb.dsTaint);
        {
            status = READY;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("encoding already in progress");
        } //End block
        CodingErrorAction malformBak;
        malformBak = malformedInputAction;
        CodingErrorAction unmapBak;
        unmapBak = unmappableCharacterAction;
        onMalformedInput(CodingErrorAction.REPORT);
        onUnmappableCharacter(CodingErrorAction.REPORT);
        boolean result;
        result = true;
        try 
        {
            this.encode(cb);
        } //End block
        catch (CharacterCodingException e)
        {
            result = false;
        } //End block
        onMalformedInput(malformBak);
        onUnmappableCharacter(unmapBak);
        reset();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (status == FLUSH || status == INIT) {
            //status = READY;
        //}
        //if (status != READY) {
            //throw new IllegalStateException("encoding already in progress");
        //}
        //CodingErrorAction malformBak = malformedInputAction;
        //CodingErrorAction unmapBak = unmappableCharacterAction;
        //onMalformedInput(CodingErrorAction.REPORT);
        //onUnmappableCharacter(CodingErrorAction.REPORT);
        //boolean result = true;
        //try {
            //this.encode(cb);
        //} catch (CharacterCodingException e) {
            //result = false;
        //}
        //onMalformedInput(malformBak);
        //onUnmappableCharacter(unmapBak);
        //reset();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:55:50.725 -0400", hash_original_method = "54A1B7BF9180636CA7E06E09FE414A09", hash_generated_method = "2BDEDF290ED52AE9A32ADAF64BC9564A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canEncode(CharSequence sequence) {
        dsTaint.addTaint(sequence);
        CharBuffer cb;
        {
            cb = ((CharBuffer) sequence).duplicate();
        } //End block
        {
            cb = CharBuffer.wrap(sequence);
        } //End block
        boolean var023A5CE57CF042FFBBA2A26CD7409D7D_213650853 = (implCanEncode(cb));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //CharBuffer cb;
        //if (sequence instanceof CharBuffer) {
            //cb = ((CharBuffer) sequence).duplicate();
        //} else {
            //cb = CharBuffer.wrap(sequence);
        //}
        //return implCanEncode(cb);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:55:50.728 -0400", hash_original_method = "B98730A31745049759B27FC27542555A", hash_generated_method = "96304F68498177FF4282F41BE723127D")
    @DSModeled(DSC.SAFE)
    public final Charset charset() {
        return (Charset)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return cs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:55:50.736 -0400", hash_original_method = "6617ED92398FABBB6F1186A03F59422C", hash_generated_method = "FD9D7072B16ED8CC0BE0935EDB577F91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final ByteBuffer encode(CharBuffer in) throws CharacterCodingException {
        dsTaint.addTaint(in.dsTaint);
        {
            boolean varB71CC61526E00AC9D330BA9C6FAE6AF4_1032320810 = (in.remaining() == 0);
            {
                ByteBuffer var91DE5DD03B091BCE3CD93B1DE0F7EB98_394644123 = (ByteBuffer.allocate(0));
            } //End block
        } //End collapsed parenthetic
        reset();
        int length;
        length = (int) (in.remaining() * averageBytesPerChar);
        ByteBuffer output;
        output = ByteBuffer.allocate(length);
        CoderResult result;
        result = null;
        {
            result = encode(in, output, false);
            {
                output = allocateMore(output);
            } //End block
            checkCoderResult(result);
        } //End block
        result = encode(in, output, true);
        checkCoderResult(result);
        {
            result = flush(output);
            {
                output.flip();
            } //End block
            {
                output = allocateMore(output);
            } //End block
            checkCoderResult(result);
            output.flip();
            {
                boolean var8469AFDE58F4B5BD8D7E58A7D8589BFA_17486910 = (result.isMalformed());
                {
                    if (DroidSafeAndroidRuntime.control) throw new MalformedInputException(result.length());
                } //End block
                {
                    boolean var196B10A57454E4B497B11983F4E91B5B_1694523578 = (result.isUnmappable());
                    {
                        if (DroidSafeAndroidRuntime.control) throw new UnmappableCharacterException(result.length());
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        status = READY;
        finished = true;
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:55:50.745 -0400", hash_original_method = "AAF7B17852C8827C6D375001E4EF8669", hash_generated_method = "F637E1D3D333170B87A9822B329633D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkCoderResult(CoderResult result) throws CharacterCodingException {
        dsTaint.addTaint(result.dsTaint);
        {
            boolean varBC2698A81CD65EBF00573A40EB4CCB31_1200578332 = (malformedInputAction == CodingErrorAction.REPORT && result.isMalformed());
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedInputException(result.length());
            } //End block
            {
                boolean var81194D29E7906F799C148A511B4F0E68_1025286210 = (unmappableCharacterAction == CodingErrorAction.REPORT && result.isUnmappable());
                {
                    if (DroidSafeAndroidRuntime.control) throw new UnmappableCharacterException(result.length());
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (malformedInputAction == CodingErrorAction.REPORT && result.isMalformed() ) {
            //throw new MalformedInputException(result.length());
        //} else if (unmappableCharacterAction == CodingErrorAction.REPORT && result.isUnmappable()) {
            //throw new UnmappableCharacterException(result.length());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:55:50.750 -0400", hash_original_method = "46B614F003BDECDBAF0C028FA8A61DD7", hash_generated_method = "08D002E954D8447E093EB8EA451AC12D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ByteBuffer allocateMore(ByteBuffer output) {
        dsTaint.addTaint(output.dsTaint);
        {
            boolean var3DEB4C124602AAD988E7A1D53669DF60_1833307224 = (output.capacity() == 0);
            {
                ByteBuffer var1D767F93D81FECE0FFC52D5845E03A47_1392984782 = (ByteBuffer.allocate(1));
            } //End block
        } //End collapsed parenthetic
        ByteBuffer result;
        result = ByteBuffer.allocate(output.capacity() * 2);
        output.flip();
        result.put(output);
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (output.capacity() == 0) {
            //return ByteBuffer.allocate(1);
        //}
        //ByteBuffer result = ByteBuffer.allocate(output.capacity() * 2);
        //output.flip();
        //result.put(output);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:55:50.764 -0400", hash_original_method = "F53B4856D46D71BB987D9EC6F2ED08EE", hash_generated_method = "02E4C8E2F6B895EFAD59F482FB602D2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CoderResult encode(CharBuffer in, ByteBuffer out, boolean endOfInput) {
        dsTaint.addTaint(endOfInput);
        dsTaint.addTaint(in.dsTaint);
        dsTaint.addTaint(out.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        CoderResult result;
        {
            try 
            {
                result = encodeLoop(in, out);
            } //End block
            catch (BufferOverflowException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new CoderMalfunctionError(e);
            } //End block
            catch (BufferUnderflowException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new CoderMalfunctionError(e);
            } //End block
            {
                status = endOfInput ? END : ONGOING;
                {
                    int remaining;
                    remaining = in.remaining();
                    {
                        result = CoderResult.malformedForLength(remaining);
                    } //End block
                } //End block
            } //End block
            {
                status = endOfInput ? END : ONGOING;
            } //End block
            CodingErrorAction action;
            action = malformedInputAction;
            {
                boolean var7C71B56CE29CA100AFEFFA537CA1E5FD_1130144960 = (result.isUnmappable());
                {
                    action = unmappableCharacterAction;
                } //End block
            } //End collapsed parenthetic
            {
                {
                    boolean varD5123830D1882C75C40901CDBD4F3A20_1473431212 = (out.remaining() < replacementBytes.length);
                } //End collapsed parenthetic
                out.put(replacementBytes);
            } //End block
            in.position(in.position() + result.length());
        } //End block
        return (CoderResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    protected abstract CoderResult encodeLoop(CharBuffer in, ByteBuffer out);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:55:50.770 -0400", hash_original_method = "7DF66453B2225F37798DBF2842A3A344", hash_generated_method = "CDF33BB1EEC79E4DA8166ADDB37753A6")
    @DSModeled(DSC.SAFE)
    public final CoderResult flush(ByteBuffer out) {
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
        //if (status != END && status != READY) {
            //throw new IllegalStateException();
        //}
        //CoderResult result = implFlush(out);
        //if (result == CoderResult.UNDERFLOW) {
            //status = FLUSH;
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:55:50.773 -0400", hash_original_method = "A9BF2BD565E7966B3C6B16D11959F2CA", hash_generated_method = "0ECE0DBF3CEEEB9F4F6493DAD100104D")
    @DSModeled(DSC.SAFE)
    protected CoderResult implFlush(ByteBuffer out) {
        dsTaint.addTaint(out.dsTaint);
        return (CoderResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return CoderResult.UNDERFLOW;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:55:50.778 -0400", hash_original_method = "E03D9D5B6C40FD58B1EEECF43C9BC127", hash_generated_method = "E247BDD25C5A10AE7E022CE556AF0638")
    @DSModeled(DSC.SAFE)
    protected void implOnMalformedInput(CodingErrorAction newAction) {
        dsTaint.addTaint(newAction.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:55:50.781 -0400", hash_original_method = "33D941D09604A3F698502AE892B2B2F1", hash_generated_method = "966FDD7601F50FC1BCEA9BA931754569")
    @DSModeled(DSC.SAFE)
    protected void implOnUnmappableCharacter(CodingErrorAction newAction) {
        dsTaint.addTaint(newAction.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:55:50.782 -0400", hash_original_method = "BBBD9A68869312EDB40CCAE9146777D7", hash_generated_method = "D438F97BF7AC3B98DF6B9A76B144F477")
    @DSModeled(DSC.SAFE)
    protected void implReplaceWith(byte[] newReplacement) {
        dsTaint.addTaint(newReplacement);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:55:50.783 -0400", hash_original_method = "B1E265ECD4B779BE3343E27B901DC354", hash_generated_method = "1ACB90FF5D97A1B7D3F0186C5D6A46D3")
    @DSModeled(DSC.SAFE)
    protected void implReset() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:55:50.786 -0400", hash_original_method = "0E6BADBD5D3BB826133FA0CE0CAA8F2B", hash_generated_method = "499C09EC870D28E56F779F0F751B7775")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isLegalReplacement(byte[] replacement) {
        dsTaint.addTaint(replacement);
        {
            decoder = cs.newDecoder();
            decoder.onMalformedInput(CodingErrorAction.REPORT);
            decoder.onUnmappableCharacter(CodingErrorAction.REPORT);
        } //End block
        ByteBuffer in;
        in = ByteBuffer.wrap(replacement);
        CharBuffer out;
        out = CharBuffer.allocate((int) (replacement.length * decoder.maxCharsPerByte()));
        CoderResult result;
        result = decoder.decode(in, out, true);
        boolean var5C456402861126D9E9CB5325CADC138C_794508023 = (!result.isError());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (decoder == null) {
            //decoder = cs.newDecoder();
            //decoder.onMalformedInput(CodingErrorAction.REPORT);
            //decoder.onUnmappableCharacter(CodingErrorAction.REPORT);
        //}
        //ByteBuffer in = ByteBuffer.wrap(replacement);
        //CharBuffer out = CharBuffer.allocate((int) (replacement.length * decoder.maxCharsPerByte()));
        //CoderResult result = decoder.decode(in, out, true);
        //return !result.isError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:55:50.787 -0400", hash_original_method = "14FFD5293B4145E0D4BC6D81F9598816", hash_generated_method = "386FE7759423FD14A97595A177F69642")
    @DSModeled(DSC.SAFE)
    public CodingErrorAction malformedInputAction() {
        return (CodingErrorAction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return malformedInputAction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:55:50.788 -0400", hash_original_method = "F4624CD8E2F5B5C085387046C0856D44", hash_generated_method = "2CE8D4D35F00B1A598E6473E48271803")
    @DSModeled(DSC.SAFE)
    public final float maxBytesPerChar() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return maxBytesPerChar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:55:50.790 -0400", hash_original_method = "9AA0403DB22EF3A510B565026DCE2424", hash_generated_method = "CC042233CAD1D1D712E3A3B62D18F191")
    @DSModeled(DSC.SAFE)
    public final CharsetEncoder onMalformedInput(CodingErrorAction newAction) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newAction.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("newAction == null");
        } //End block
        implOnMalformedInput(newAction);
        return (CharsetEncoder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (newAction == null) {
            //throw new IllegalArgumentException("newAction == null");
        //}
        //malformedInputAction = newAction;
        //implOnMalformedInput(newAction);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:55:50.791 -0400", hash_original_method = "8F9E9A5BA6AED0663F62AB88ADE1A1B8", hash_generated_method = "136A3B8E8EF03998F788C109789F807D")
    @DSModeled(DSC.SAFE)
    public final CharsetEncoder onUnmappableCharacter(CodingErrorAction newAction) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newAction.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("newAction == null");
        } //End block
        implOnUnmappableCharacter(newAction);
        return (CharsetEncoder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (newAction == null) {
            //throw new IllegalArgumentException("newAction == null");
        //}
        //unmappableCharacterAction = newAction;
        //implOnUnmappableCharacter(newAction);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:55:50.793 -0400", hash_original_method = "D4DB6E703F0B5C3D24041A00F1C8C203", hash_generated_method = "987000FD2849633BEA60E584E1FBD82E")
    @DSModeled(DSC.SAFE)
    public final byte[] replacement() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return replacementBytes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:55:50.795 -0400", hash_original_method = "267C7D54312382305679F98E9AD49DA0", hash_generated_method = "426AC376A4DDC9ED0A188880E4C8A835")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CharsetEncoder replaceWith(byte[] replacement) {
        dsTaint.addTaint(replacement);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("replacement == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("replacement.length == 0");
        } //End block
        {
            boolean varB376EDDCE96EE6241256C0F96C9F4DFD_962782646 = (replacement.length > maxBytesPerChar());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("replacement length > maxBytesPerChar: " +
                    replacement.length + " > " + maxBytesPerChar());
            } //End block
        } //End collapsed parenthetic
        {
            boolean var2BA55E348EDBBB6A73AD018C9E6D1F0A_802958022 = (!isLegalReplacement(replacement));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("bad replacement: " + Arrays.toString(replacement));
            } //End block
        } //End collapsed parenthetic
        implReplaceWith(replacementBytes);
        return (CharsetEncoder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (replacement == null) {
            //throw new IllegalArgumentException("replacement == null");
        //}
        //if (replacement.length == 0) {
            //throw new IllegalArgumentException("replacement.length == 0");
        //}
        //if (replacement.length > maxBytesPerChar()) {
            //throw new IllegalArgumentException("replacement length > maxBytesPerChar: " +
                    //replacement.length + " > " + maxBytesPerChar());
        //}
        //if (!isLegalReplacement(replacement)) {
            //throw new IllegalArgumentException("bad replacement: " + Arrays.toString(replacement));
        //}
        //this.replacementBytes = replacement;
        //implReplaceWith(replacementBytes);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:55:50.797 -0400", hash_original_method = "939E78B196C94EAC65CBC7206A9E1DD0", hash_generated_method = "AEBC7CD041C3FE281533F38A28D807F6")
    @DSModeled(DSC.SAFE)
    public final CharsetEncoder reset() {
        status = INIT;
        implReset();
        return (CharsetEncoder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //status = INIT;
        //implReset();
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:55:50.798 -0400", hash_original_method = "01254405DC3888434A269A87FF2AF4FB", hash_generated_method = "345C0678DB3142B924747B5F0C4BBF5F")
    @DSModeled(DSC.SAFE)
    public CodingErrorAction unmappableCharacterAction() {
        return (CodingErrorAction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return unmappableCharacterAction;
    }

    
}


