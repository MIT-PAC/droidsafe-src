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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.990 -0400", hash_original_field = "95CC64DD2825F9DF13EC4AD683ECF339", hash_generated_field = "220BF257D2CCF23A35C6D1D35FB3F79C")

    private Charset cs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.990 -0400", hash_original_field = "692DC57502FA0F1ADE68D2F2AECF7494", hash_generated_field = "5C783D0D8B0013302A29C9244F7615B3")

    private float averageBytesPerChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.990 -0400", hash_original_field = "C6086AD8B30BBFB38F0CCB4A5C59689F", hash_generated_field = "B19FD23ACD0442A467073D3E6F98A95A")

    private float maxBytesPerChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.990 -0400", hash_original_field = "F9CC17F581C3F36A520F3F5943689734", hash_generated_field = "A0C8011AEB0BF78979EBADE417E449F0")

    private byte[] replacementBytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.990 -0400", hash_original_field = "9ACB44549B41563697BB490144EC6258", hash_generated_field = "4BAC49709EDEAEFDD9E07400E0F02406")

    private int status;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.990 -0400", hash_original_field = "A5D7CEB2C59B8CEE46C2953FEC9ABC19", hash_generated_field = "3E2B0E3E2E572DECE0B20D77E19B79CF")

    private boolean finished;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.990 -0400", hash_original_field = "E353C4A606D3E48C9BBB36EADD713EA4", hash_generated_field = "1214F64762553AD2B0BE51AAC36B64DE")

    private CodingErrorAction malformedInputAction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.990 -0400", hash_original_field = "F84ECDA294965F5911ABAE3B9702960C", hash_generated_field = "60F320659477DF0A50B0661AEB74E53F")

    private CodingErrorAction unmappableCharacterAction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.991 -0400", hash_original_field = "3A6BDBA8FB33A88CF7D52A1AF07A9C00", hash_generated_field = "E190C0DE068854E0E786DAC309DED1B8")

    private CharsetDecoder decoder;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.991 -0400", hash_original_method = "5E9CA4841A80C315BA24674061FE2949", hash_generated_method = "AB673120CF966E87AB770CBFB9340F38")
    protected  CharsetEncoder(Charset cs, float averageBytesPerChar, float maxBytesPerChar) {
        this(cs, averageBytesPerChar, maxBytesPerChar, new byte[] { (byte) '?' });
        addTaint(cs.getTaint());
        addTaint(averageBytesPerChar);
        addTaint(maxBytesPerChar);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.991 -0400", hash_original_method = "33500150E00A96E14E2810282423268E", hash_generated_method = "4B37B9F2B9C7057E8B19629251946346")
    protected  CharsetEncoder(Charset cs, float averageBytesPerChar, float maxBytesPerChar, byte[] replacement) {
        this(cs, averageBytesPerChar, maxBytesPerChar, replacement, false);
        addTaint(cs.getTaint());
        addTaint(averageBytesPerChar);
        addTaint(maxBytesPerChar);
        addTaint(replacement[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.992 -0400", hash_original_method = "173A83611BD70B9738420414876CE0BB", hash_generated_method = "0AA5407F07A7EF8D099EA348CDCAB7E6")
      CharsetEncoder(Charset cs, float averageBytesPerChar, float maxBytesPerChar, byte[] replacement, boolean trusted) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("averageBytesPerChar and maxBytesPerChar must both be positive");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("averageBytesPerChar is greater than maxBytesPerChar");
        } //End block
        this.cs = cs;
        this.averageBytesPerChar = averageBytesPerChar;
        this.maxBytesPerChar = maxBytesPerChar;
        status = INIT;
        malformedInputAction = CodingErrorAction.REPORT;
        unmappableCharacterAction = CodingErrorAction.REPORT;
        {
            this.replacementBytes = replacement;
        } //End block
        {
            replaceWith(replacement);
        } //End block
        addTaint(trusted);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.004 -0400", hash_original_method = "A746602428AC27FECC8176A57B5A2933", hash_generated_method = "8C0978FBBD510457BF76F5497E10A113")
    public final float averageBytesPerChar() {
        float var546ADE640B6EDFBC8A086EF31347E768_1944340694 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1944340694;
        // ---------- Original Method ----------
        //return averageBytesPerChar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.005 -0400", hash_original_method = "DF8D80CA8C09E77634765D8D414FAE26", hash_generated_method = "D897090DB4C07563D565EA9112F4CB1D")
    public boolean canEncode(char c) {
        boolean varA7FD43173EF46EB747DE5BC527CFC0F0_1008608588 = (implCanEncode(CharBuffer.wrap(new char[] { c })));
        addTaint(c);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1088723256 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1088723256;
        // ---------- Original Method ----------
        //return implCanEncode(CharBuffer.wrap(new char[] { c }));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.016 -0400", hash_original_method = "8FE38300B66D2E408C3C937D4188B910", hash_generated_method = "264C646B278DC73C318C4301E1547A36")
    private boolean implCanEncode(CharBuffer cb) {
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
        addTaint(cb.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2009628650 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2009628650;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.016 -0400", hash_original_method = "54A1B7BF9180636CA7E06E09FE414A09", hash_generated_method = "37E14433F8DABF96A8A368B95BA340BA")
    public boolean canEncode(CharSequence sequence) {
        CharBuffer cb;
        {
            cb = ((CharBuffer) sequence).duplicate();
        } //End block
        {
            cb = CharBuffer.wrap(sequence);
        } //End block
        boolean var023A5CE57CF042FFBBA2A26CD7409D7D_939867526 = (implCanEncode(cb));
        addTaint(sequence.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_778795055 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_778795055;
        // ---------- Original Method ----------
        //CharBuffer cb;
        //if (sequence instanceof CharBuffer) {
            //cb = ((CharBuffer) sequence).duplicate();
        //} else {
            //cb = CharBuffer.wrap(sequence);
        //}
        //return implCanEncode(cb);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.018 -0400", hash_original_method = "B98730A31745049759B27FC27542555A", hash_generated_method = "9072EBFC6E8530A038B43C7D69DE611E")
    public final Charset charset() {
        Charset varB4EAC82CA7396A68D541C85D26508E83_2086567301 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2086567301 = cs;
        varB4EAC82CA7396A68D541C85D26508E83_2086567301.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2086567301;
        // ---------- Original Method ----------
        //return cs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.028 -0400", hash_original_method = "6617ED92398FABBB6F1186A03F59422C", hash_generated_method = "6A80BCA0E30DB8F9FB83A2C2E98A712C")
    public final ByteBuffer encode(CharBuffer in) throws CharacterCodingException {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1091450924 = null; //Variable for return #1
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_881447815 = null; //Variable for return #2
        {
            boolean varB71CC61526E00AC9D330BA9C6FAE6AF4_212659758 = (in.remaining() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1091450924 = ByteBuffer.allocate(0);
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
                boolean var8469AFDE58F4B5BD8D7E58A7D8589BFA_1195966439 = (result.isMalformed());
                {
                    if (DroidSafeAndroidRuntime.control) throw new MalformedInputException(result.length());
                } //End block
                {
                    boolean var196B10A57454E4B497B11983F4E91B5B_257111568 = (result.isUnmappable());
                    {
                        if (DroidSafeAndroidRuntime.control) throw new UnmappableCharacterException(result.length());
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        status = READY;
        finished = true;
        varB4EAC82CA7396A68D541C85D26508E83_881447815 = output;
        addTaint(in.getTaint());
        ByteBuffer varA7E53CE21691AB073D9660D615818899_363924042; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_363924042 = varB4EAC82CA7396A68D541C85D26508E83_1091450924;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_363924042 = varB4EAC82CA7396A68D541C85D26508E83_881447815;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_363924042.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_363924042;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.029 -0400", hash_original_method = "AAF7B17852C8827C6D375001E4EF8669", hash_generated_method = "4D3E36D5DB145F7C71FF03F98A8A33B5")
    private void checkCoderResult(CoderResult result) throws CharacterCodingException {
        {
            boolean varBC2698A81CD65EBF00573A40EB4CCB31_1713696221 = (malformedInputAction == CodingErrorAction.REPORT && result.isMalformed());
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedInputException(result.length());
            } //End block
            {
                boolean var81194D29E7906F799C148A511B4F0E68_1759682521 = (unmappableCharacterAction == CodingErrorAction.REPORT && result.isUnmappable());
                {
                    if (DroidSafeAndroidRuntime.control) throw new UnmappableCharacterException(result.length());
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //if (malformedInputAction == CodingErrorAction.REPORT && result.isMalformed() ) {
            //throw new MalformedInputException(result.length());
        //} else if (unmappableCharacterAction == CodingErrorAction.REPORT && result.isUnmappable()) {
            //throw new UnmappableCharacterException(result.length());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.029 -0400", hash_original_method = "46B614F003BDECDBAF0C028FA8A61DD7", hash_generated_method = "BD96FDA7E930BF92C5B25E7A9AA30DBA")
    private ByteBuffer allocateMore(ByteBuffer output) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_891573147 = null; //Variable for return #1
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1044275503 = null; //Variable for return #2
        {
            boolean var3DEB4C124602AAD988E7A1D53669DF60_2092065219 = (output.capacity() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_891573147 = ByteBuffer.allocate(1);
            } //End block
        } //End collapsed parenthetic
        ByteBuffer result;
        result = ByteBuffer.allocate(output.capacity() * 2);
        output.flip();
        result.put(output);
        varB4EAC82CA7396A68D541C85D26508E83_1044275503 = result;
        addTaint(output.getTaint());
        ByteBuffer varA7E53CE21691AB073D9660D615818899_1580107968; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1580107968 = varB4EAC82CA7396A68D541C85D26508E83_891573147;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1580107968 = varB4EAC82CA7396A68D541C85D26508E83_1044275503;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1580107968.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1580107968;
        // ---------- Original Method ----------
        //if (output.capacity() == 0) {
            //return ByteBuffer.allocate(1);
        //}
        //ByteBuffer result = ByteBuffer.allocate(output.capacity() * 2);
        //output.flip();
        //result.put(output);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.041 -0400", hash_original_method = "F53B4856D46D71BB987D9EC6F2ED08EE", hash_generated_method = "1FBE46CFCE9778C8519A48371317C2A6")
    public final CoderResult encode(CharBuffer in, ByteBuffer out, boolean endOfInput) {
        CoderResult varB4EAC82CA7396A68D541C85D26508E83_1001198909 = null; //Variable for return #1
        CoderResult varB4EAC82CA7396A68D541C85D26508E83_444073913 = null; //Variable for return #2
        CoderResult varB4EAC82CA7396A68D541C85D26508E83_1862473066 = null; //Variable for return #3
        CoderResult varB4EAC82CA7396A68D541C85D26508E83_392159024 = null; //Variable for return #4
        CoderResult varB4EAC82CA7396A68D541C85D26508E83_1292513810 = null; //Variable for return #5
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
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1001198909 = result;
                    } //End block
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_444073913 = result;
                } //End block
            } //End block
            {
                status = endOfInput ? END : ONGOING;
                varB4EAC82CA7396A68D541C85D26508E83_1862473066 = result;
            } //End block
            CodingErrorAction action;
            action = malformedInputAction;
            {
                boolean var7C71B56CE29CA100AFEFFA537CA1E5FD_384286497 = (result.isUnmappable());
                {
                    action = unmappableCharacterAction;
                } //End block
            } //End collapsed parenthetic
            {
                {
                    boolean varD5123830D1882C75C40901CDBD4F3A20_1059449300 = (out.remaining() < replacementBytes.length);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_392159024 = CoderResult.OVERFLOW;
                    } //End block
                } //End collapsed parenthetic
                out.put(replacementBytes);
            } //End block
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1292513810 = result;
                } //End block
            } //End block
            in.position(in.position() + result.length());
        } //End block
        addTaint(in.getTaint());
        addTaint(out.getTaint());
        CoderResult varA7E53CE21691AB073D9660D615818899_1355138811; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1355138811 = varB4EAC82CA7396A68D541C85D26508E83_1001198909;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1355138811 = varB4EAC82CA7396A68D541C85D26508E83_444073913;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1355138811 = varB4EAC82CA7396A68D541C85D26508E83_1862473066;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1355138811 = varB4EAC82CA7396A68D541C85D26508E83_392159024;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1355138811 = varB4EAC82CA7396A68D541C85D26508E83_1292513810;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1355138811.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1355138811;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    protected abstract CoderResult encodeLoop(CharBuffer in, ByteBuffer out);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.057 -0400", hash_original_method = "7DF66453B2225F37798DBF2842A3A344", hash_generated_method = "BD04D24471999BD30E7630FC10C45BE5")
    public final CoderResult flush(ByteBuffer out) {
        CoderResult varB4EAC82CA7396A68D541C85D26508E83_1103459848 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        CoderResult result;
        result = implFlush(out);
        {
            status = FLUSH;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1103459848 = result;
        addTaint(out.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1103459848.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1103459848;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.057 -0400", hash_original_method = "A9BF2BD565E7966B3C6B16D11959F2CA", hash_generated_method = "D684868FE4F52C3CB96A87CF3C1CB182")
    protected CoderResult implFlush(ByteBuffer out) {
        CoderResult varB4EAC82CA7396A68D541C85D26508E83_242498481 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_242498481 = CoderResult.UNDERFLOW;
        addTaint(out.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_242498481.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_242498481;
        // ---------- Original Method ----------
        //return CoderResult.UNDERFLOW;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.057 -0400", hash_original_method = "E03D9D5B6C40FD58B1EEECF43C9BC127", hash_generated_method = "C3493E75D383B088DEBB94344366E9DE")
    protected void implOnMalformedInput(CodingErrorAction newAction) {
        addTaint(newAction.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.058 -0400", hash_original_method = "33D941D09604A3F698502AE892B2B2F1", hash_generated_method = "4B30141303236D37DE62574A267B9AF0")
    protected void implOnUnmappableCharacter(CodingErrorAction newAction) {
        addTaint(newAction.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.058 -0400", hash_original_method = "BBBD9A68869312EDB40CCAE9146777D7", hash_generated_method = "C9C5333A73F363FD625EC04BC5CF9C82")
    protected void implReplaceWith(byte[] newReplacement) {
        addTaint(newReplacement[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.059 -0400", hash_original_method = "B1E265ECD4B779BE3343E27B901DC354", hash_generated_method = "2A58666B59F850117B41A249C7AD97D2")
    protected void implReset() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.069 -0400", hash_original_method = "0E6BADBD5D3BB826133FA0CE0CAA8F2B", hash_generated_method = "82D64B84EC49FD226224A320123E933B")
    public boolean isLegalReplacement(byte[] replacement) {
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
        boolean var5C456402861126D9E9CB5325CADC138C_660284484 = (!result.isError());
        addTaint(replacement[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1589085480 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1589085480;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.070 -0400", hash_original_method = "14FFD5293B4145E0D4BC6D81F9598816", hash_generated_method = "8BBAC61ECC46C399A80C7F195240C8D1")
    public CodingErrorAction malformedInputAction() {
        CodingErrorAction varB4EAC82CA7396A68D541C85D26508E83_59318163 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_59318163 = malformedInputAction;
        varB4EAC82CA7396A68D541C85D26508E83_59318163.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_59318163;
        // ---------- Original Method ----------
        //return malformedInputAction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.070 -0400", hash_original_method = "F4624CD8E2F5B5C085387046C0856D44", hash_generated_method = "68F8EFBBE6D827E25EDEE304E540F9DB")
    public final float maxBytesPerChar() {
        float var546ADE640B6EDFBC8A086EF31347E768_101112479 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_101112479;
        // ---------- Original Method ----------
        //return maxBytesPerChar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.074 -0400", hash_original_method = "9AA0403DB22EF3A510B565026DCE2424", hash_generated_method = "327396C6C99DBA5CD5DF03E8A496D206")
    public final CharsetEncoder onMalformedInput(CodingErrorAction newAction) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        CharsetEncoder varB4EAC82CA7396A68D541C85D26508E83_1702566221 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("newAction == null");
        } //End block
        malformedInputAction = newAction;
        implOnMalformedInput(newAction);
        varB4EAC82CA7396A68D541C85D26508E83_1702566221 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1702566221.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1702566221;
        // ---------- Original Method ----------
        //if (newAction == null) {
            //throw new IllegalArgumentException("newAction == null");
        //}
        //malformedInputAction = newAction;
        //implOnMalformedInput(newAction);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.085 -0400", hash_original_method = "8F9E9A5BA6AED0663F62AB88ADE1A1B8", hash_generated_method = "D26C44C434DC93BB99347FDABEDF497C")
    public final CharsetEncoder onUnmappableCharacter(CodingErrorAction newAction) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        CharsetEncoder varB4EAC82CA7396A68D541C85D26508E83_495532361 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("newAction == null");
        } //End block
        unmappableCharacterAction = newAction;
        implOnUnmappableCharacter(newAction);
        varB4EAC82CA7396A68D541C85D26508E83_495532361 = this;
        varB4EAC82CA7396A68D541C85D26508E83_495532361.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_495532361;
        // ---------- Original Method ----------
        //if (newAction == null) {
            //throw new IllegalArgumentException("newAction == null");
        //}
        //unmappableCharacterAction = newAction;
        //implOnUnmappableCharacter(newAction);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.085 -0400", hash_original_method = "D4DB6E703F0B5C3D24041A00F1C8C203", hash_generated_method = "83DF5022F2AFFBBCC1C0CA6409727E8A")
    public final byte[] replacement() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1953528214 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1953528214;
        // ---------- Original Method ----------
        //return replacementBytes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.086 -0400", hash_original_method = "267C7D54312382305679F98E9AD49DA0", hash_generated_method = "808A3CC3B9BFA22A93091CE4AA0B1455")
    public final CharsetEncoder replaceWith(byte[] replacement) {
        CharsetEncoder varB4EAC82CA7396A68D541C85D26508E83_2049639180 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("replacement == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("replacement.length == 0");
        } //End block
        {
            boolean varB376EDDCE96EE6241256C0F96C9F4DFD_552289199 = (replacement.length > maxBytesPerChar());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("replacement length > maxBytesPerChar: " +
                    replacement.length + " > " + maxBytesPerChar());
            } //End block
        } //End collapsed parenthetic
        {
            boolean var2BA55E348EDBBB6A73AD018C9E6D1F0A_1993768958 = (!isLegalReplacement(replacement));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("bad replacement: " + Arrays.toString(replacement));
            } //End block
        } //End collapsed parenthetic
        this.replacementBytes = replacement;
        implReplaceWith(replacementBytes);
        varB4EAC82CA7396A68D541C85D26508E83_2049639180 = this;
        varB4EAC82CA7396A68D541C85D26508E83_2049639180.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2049639180;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.100 -0400", hash_original_method = "939E78B196C94EAC65CBC7206A9E1DD0", hash_generated_method = "A421965D0024AF891AB92C59122A5A5E")
    public final CharsetEncoder reset() {
        CharsetEncoder varB4EAC82CA7396A68D541C85D26508E83_1386697304 = null; //Variable for return #1
        status = INIT;
        implReset();
        varB4EAC82CA7396A68D541C85D26508E83_1386697304 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1386697304.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1386697304;
        // ---------- Original Method ----------
        //status = INIT;
        //implReset();
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.108 -0400", hash_original_method = "01254405DC3888434A269A87FF2AF4FB", hash_generated_method = "3BCE9C3967DF9225D8DB881C5BC455A7")
    public CodingErrorAction unmappableCharacterAction() {
        CodingErrorAction varB4EAC82CA7396A68D541C85D26508E83_1705541918 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1705541918 = unmappableCharacterAction;
        varB4EAC82CA7396A68D541C85D26508E83_1705541918.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1705541918;
        // ---------- Original Method ----------
        //return unmappableCharacterAction;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.108 -0400", hash_original_field = "C7C7980D5941588A0F784DFB73417B5E", hash_generated_field = "E810EA9B3A19B18D0D8775390287EE54")

    private static int READY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.108 -0400", hash_original_field = "9797141D8C8814884DC8AA4D2585CEAA", hash_generated_field = "EAC0FA94EAFC1CDDBC4D24F9C4564638")

    private static int ONGOING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.108 -0400", hash_original_field = "39A10DCE3FD12B5D178E5141CAEA7B2C", hash_generated_field = "8F29D63086DDC815074164B8E5527205")

    private static int END = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.108 -0400", hash_original_field = "95D88E1D3DF2D2D0836FCDAF6845B681", hash_generated_field = "8DA07DD2FAFFC496EAC780FE853895AF")

    private static int FLUSH = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.108 -0400", hash_original_field = "330661C2C2C5D0F2A7100203DE762459", hash_generated_field = "7ACE63A6DEC217E49258E4569E8D58AD")

    private static int INIT = 4;
}

