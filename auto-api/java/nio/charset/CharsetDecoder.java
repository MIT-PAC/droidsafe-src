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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.710 -0400", hash_original_field = "61628476CEFEE98E133C4A262D6104E7", hash_generated_field = "529EF1EB47EC503C08AD8590AE0F62F5")

    private float averageCharsPerByte;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.710 -0400", hash_original_field = "DD42591D3D06DC7ACEDEDF2FA8238654", hash_generated_field = "2DF37DC2E87CE8D294B5CF2F013FD634")

    private float maxCharsPerByte;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.710 -0400", hash_original_field = "95CC64DD2825F9DF13EC4AD683ECF339", hash_generated_field = "220BF257D2CCF23A35C6D1D35FB3F79C")

    private Charset cs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.710 -0400", hash_original_field = "E353C4A606D3E48C9BBB36EADD713EA4", hash_generated_field = "1214F64762553AD2B0BE51AAC36B64DE")

    private CodingErrorAction malformedInputAction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.710 -0400", hash_original_field = "F84ECDA294965F5911ABAE3B9702960C", hash_generated_field = "60F320659477DF0A50B0661AEB74E53F")

    private CodingErrorAction unmappableCharacterAction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.710 -0400", hash_original_field = "AC19AB15816945D4560ACC390132433E", hash_generated_field = "4FB9354D4FC1B3B8FECFC231454ED4BC")

    private String replacementChars;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.710 -0400", hash_original_field = "9ACB44549B41563697BB490144EC6258", hash_generated_field = "4BAC49709EDEAEFDD9E07400E0F02406")

    private int status;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.711 -0400", hash_original_method = "8CF9EF6BF1CF308B9A895B171C1AF9B5", hash_generated_method = "31B8C3374F1E8451A42D44216C37163E")
    protected  CharsetDecoder(Charset charset, float averageCharsPerByte, float maxCharsPerByte) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("averageCharsPerByte and maxCharsPerByte must be positive");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("averageCharsPerByte is greater than maxCharsPerByte");
        } //End block
        this.averageCharsPerByte = averageCharsPerByte;
        this.maxCharsPerByte = maxCharsPerByte;
        cs = charset;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.711 -0400", hash_original_method = "835453458CD254EFEDF140BA3E3A0055", hash_generated_method = "C9533922A4E216D50BF056788913DDDE")
    public final float averageCharsPerByte() {
        float var546ADE640B6EDFBC8A086EF31347E768_780671455 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_780671455;
        // ---------- Original Method ----------
        //return averageCharsPerByte;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.712 -0400", hash_original_method = "B98730A31745049759B27FC27542555A", hash_generated_method = "63596F2B1C9C1ED06BA4FAC62C1D70C3")
    public final Charset charset() {
        Charset varB4EAC82CA7396A68D541C85D26508E83_1037467231 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1037467231 = cs;
        varB4EAC82CA7396A68D541C85D26508E83_1037467231.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1037467231;
        // ---------- Original Method ----------
        //return cs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.720 -0400", hash_original_method = "0575B5D8A4FDBA875B2771D84C02D5E1", hash_generated_method = "C3A3201D5B8819B441FA73DB82A73C1F")
    public final CharBuffer decode(ByteBuffer in) throws CharacterCodingException {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1894597561 = null; //Variable for return #1
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
                boolean varF1DB9CE261DCF48645D6337FBFF24029_1623971800 = (result.isUnderflow());
                {
                    boolean varD20C9318A05139203F7B82FC87F4D343_84866209 = (result.isOverflow());
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
                boolean var2AAE7F5A955BA87C5F37AFB5998173CD_1332480056 = (result.isOverflow());
                {
                    output = allocateMore(output);
                } //End block
            } //End collapsed parenthetic
        } //End block
        output.flip();
        status = FLUSH;
        varB4EAC82CA7396A68D541C85D26508E83_1894597561 = output;
        addTaint(in.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1894597561.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1894597561;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.721 -0400", hash_original_method = "297219195E5B4473685A201861AC1DC3", hash_generated_method = "101086FCB4209B240E582E77398EE271")
    private void checkCoderResult(CoderResult result) throws CharacterCodingException {
        {
            boolean var504E9C7F7D7D0D8DA16970B2F44C89AA_84686910 = (result.isMalformed() && malformedInputAction == CodingErrorAction.REPORT);
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedInputException(result.length());
            } //End block
            {
                boolean varC1BF2F4D76DB2A66374D034187758580_1485130499 = (result.isUnmappable() && unmappableCharacterAction == CodingErrorAction.REPORT);
                {
                    if (DroidSafeAndroidRuntime.control) throw new UnmappableCharacterException(result.length());
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //if (result.isMalformed() && malformedInputAction == CodingErrorAction.REPORT) {
            //throw new MalformedInputException(result.length());
        //} else if (result.isUnmappable() && unmappableCharacterAction == CodingErrorAction.REPORT) {
            //throw new UnmappableCharacterException(result.length());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.734 -0400", hash_original_method = "D4DFBF2849FE3731857D4FDEE2ED4787", hash_generated_method = "788288AA975E0CE97F128364E99E306F")
    private CharBuffer allocateMore(CharBuffer output) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_191129233 = null; //Variable for return #1
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1980133593 = null; //Variable for return #2
        {
            boolean var3DEB4C124602AAD988E7A1D53669DF60_59329930 = (output.capacity() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_191129233 = CharBuffer.allocate(1);
            } //End block
        } //End collapsed parenthetic
        CharBuffer result;
        result = CharBuffer.allocate(output.capacity() * 2);
        output.flip();
        result.put(output);
        varB4EAC82CA7396A68D541C85D26508E83_1980133593 = result;
        addTaint(output.getTaint());
        CharBuffer varA7E53CE21691AB073D9660D615818899_812840050; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_812840050 = varB4EAC82CA7396A68D541C85D26508E83_191129233;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_812840050 = varB4EAC82CA7396A68D541C85D26508E83_1980133593;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_812840050.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_812840050;
        // ---------- Original Method ----------
        //if (output.capacity() == 0) {
            //return CharBuffer.allocate(1);
        //}
        //CharBuffer result = CharBuffer.allocate(output.capacity() * 2);
        //output.flip();
        //result.put(output);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.759 -0400", hash_original_method = "40037F62CA1EB410AEAF236C6BDF7EBA", hash_generated_method = "B70AFC380ACAD096CF5BBA0E1E3F2A43")
    public final CoderResult decode(ByteBuffer in, CharBuffer out,
            boolean endOfInput) {
        CoderResult varB4EAC82CA7396A68D541C85D26508E83_806716553 = null; //Variable for return #1
        CoderResult varB4EAC82CA7396A68D541C85D26508E83_874353355 = null; //Variable for return #2
        CoderResult varB4EAC82CA7396A68D541C85D26508E83_1314753613 = null; //Variable for return #3
        CoderResult varB4EAC82CA7396A68D541C85D26508E83_1789130811 = null; //Variable for return #4
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
                boolean varF1DB9CE261DCF48645D6337FBFF24029_1355859650 = (result.isUnderflow());
                {
                    int remaining;
                    remaining = in.remaining();
                    status = endOfInput ? END : ONGOING;
                    {
                        result = CoderResult.malformedForLength(remaining);
                    } //End block
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_806716553 = result;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                boolean var2AAE7F5A955BA87C5F37AFB5998173CD_1618513436 = (result.isOverflow());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_874353355 = result;
                } //End block
            } //End collapsed parenthetic
            action = malformedInputAction;
            {
                boolean var7C71B56CE29CA100AFEFFA537CA1E5FD_396306753 = (result.isUnmappable());
                {
                    action = unmappableCharacterAction;
                } //End block
            } //End collapsed parenthetic
            {
                {
                    boolean varDFA1CD40AE60C1A98AAF3B3E35C30958_850958310 = (out.remaining() < replacementChars.length());
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1314753613 = CoderResult.OVERFLOW;
                    } //End block
                } //End collapsed parenthetic
                out.put(replacementChars);
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1789130811 = result;
            } //End block
            in.position(in.position() + result.length());
        } //End block
        addTaint(in.getTaint());
        addTaint(out.getTaint());
        CoderResult varA7E53CE21691AB073D9660D615818899_373628637; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_373628637 = varB4EAC82CA7396A68D541C85D26508E83_806716553;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_373628637 = varB4EAC82CA7396A68D541C85D26508E83_874353355;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_373628637 = varB4EAC82CA7396A68D541C85D26508E83_1314753613;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_373628637 = varB4EAC82CA7396A68D541C85D26508E83_1789130811;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_373628637.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_373628637;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    protected abstract CoderResult decodeLoop(ByteBuffer in, CharBuffer out);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.760 -0400", hash_original_method = "FA8F0AC80549BCE47D29C328C4E0F049", hash_generated_method = "6B666B5F7C2908E4533B52A660EE9DEF")
    public Charset detectedCharset() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.761 -0400", hash_original_method = "5C3493C7F863D5F0BA88F45F364D1985", hash_generated_method = "E655E5977EF45C203F689796183300D0")
    public final CoderResult flush(CharBuffer out) {
        CoderResult varB4EAC82CA7396A68D541C85D26508E83_1480611392 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        CoderResult result;
        result = implFlush(out);
        {
            status = FLUSH;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1480611392 = result;
        addTaint(out.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1480611392.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1480611392;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.761 -0400", hash_original_method = "6025E36E88B99911562F9F8AEE21E28F", hash_generated_method = "43AB488B9AA4AF57B6D8655D4DCA4ED6")
    protected CoderResult implFlush(CharBuffer out) {
        CoderResult varB4EAC82CA7396A68D541C85D26508E83_902062779 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_902062779 = CoderResult.UNDERFLOW;
        addTaint(out.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_902062779.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_902062779;
        // ---------- Original Method ----------
        //return CoderResult.UNDERFLOW;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.761 -0400", hash_original_method = "E03D9D5B6C40FD58B1EEECF43C9BC127", hash_generated_method = "C3493E75D383B088DEBB94344366E9DE")
    protected void implOnMalformedInput(CodingErrorAction newAction) {
        addTaint(newAction.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.761 -0400", hash_original_method = "33D941D09604A3F698502AE892B2B2F1", hash_generated_method = "4B30141303236D37DE62574A267B9AF0")
    protected void implOnUnmappableCharacter(CodingErrorAction newAction) {
        addTaint(newAction.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.767 -0400", hash_original_method = "5014FF47E324504A21AF53F373310654", hash_generated_method = "0D2CAD8C717F6EA291AA5ACB527A4134")
    protected void implReplaceWith(String newReplacement) {
        addTaint(newReplacement.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.768 -0400", hash_original_method = "B1E265ECD4B779BE3343E27B901DC354", hash_generated_method = "2A58666B59F850117B41A249C7AD97D2")
    protected void implReset() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.769 -0400", hash_original_method = "0E3C677639C4DB544DC0D4E7955DC077", hash_generated_method = "4DD56434FBAAE5E17F50FC3BF81115E2")
    public boolean isAutoDetecting() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1362069355 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1362069355;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.769 -0400", hash_original_method = "EB764964ACE224C10D45E3B66AA00682", hash_generated_method = "AE8B4CE83F2F182E592B8BD0DA39F113")
    public boolean isCharsetDetected() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1021265451 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1021265451;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.770 -0400", hash_original_method = "14FFD5293B4145E0D4BC6D81F9598816", hash_generated_method = "ACBF94738477E4F631E46ACC03CE4F6D")
    public CodingErrorAction malformedInputAction() {
        CodingErrorAction varB4EAC82CA7396A68D541C85D26508E83_468748677 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_468748677 = malformedInputAction;
        varB4EAC82CA7396A68D541C85D26508E83_468748677.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_468748677;
        // ---------- Original Method ----------
        //return malformedInputAction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.770 -0400", hash_original_method = "1F4ECBF7B137C80889EF1BC2E2A0CCD1", hash_generated_method = "FB3AB1C507601E4DCCD44DB0D8E1D19E")
    public final float maxCharsPerByte() {
        float var546ADE640B6EDFBC8A086EF31347E768_1470902936 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1470902936;
        // ---------- Original Method ----------
        //return maxCharsPerByte;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.771 -0400", hash_original_method = "34F534C82C11F1FDAA0DD59455B931CF", hash_generated_method = "4EF3916D4FF92CEA51CABEB959C93120")
    public final CharsetDecoder onMalformedInput(CodingErrorAction newAction) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        CharsetDecoder varB4EAC82CA7396A68D541C85D26508E83_1997161550 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        malformedInputAction = newAction;
        implOnMalformedInput(newAction);
        varB4EAC82CA7396A68D541C85D26508E83_1997161550 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1997161550.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1997161550;
        // ---------- Original Method ----------
        //if (newAction == null) {
            //throw new IllegalArgumentException();
        //}
        //malformedInputAction = newAction;
        //implOnMalformedInput(newAction);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.775 -0400", hash_original_method = "652123D755D0FEE6B30AA61176E436F9", hash_generated_method = "D449AC3D20D3F1240F458AED64E31041")
    public final CharsetDecoder onUnmappableCharacter(CodingErrorAction newAction) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        CharsetDecoder varB4EAC82CA7396A68D541C85D26508E83_1278174772 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        unmappableCharacterAction = newAction;
        implOnUnmappableCharacter(newAction);
        varB4EAC82CA7396A68D541C85D26508E83_1278174772 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1278174772.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1278174772;
        // ---------- Original Method ----------
        //if (newAction == null) {
            //throw new IllegalArgumentException();
        //}
        //unmappableCharacterAction = newAction;
        //implOnUnmappableCharacter(newAction);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.775 -0400", hash_original_method = "30CB7E3F60490326C9B63C38EC65670E", hash_generated_method = "283AC4AEBCAF580164BA16960542F98C")
    public final String replacement() {
        String varB4EAC82CA7396A68D541C85D26508E83_352972248 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_352972248 = replacementChars;
        varB4EAC82CA7396A68D541C85D26508E83_352972248.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_352972248;
        // ---------- Original Method ----------
        //return replacementChars;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.782 -0400", hash_original_method = "B18C28BF3814F00BA79DEB9A20AA9835", hash_generated_method = "3ABA96B6708889152850648E67C337E2")
    public final CharsetDecoder replaceWith(String replacement) {
        CharsetDecoder varB4EAC82CA7396A68D541C85D26508E83_2046105242 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("replacement == null");
        } //End block
        {
            boolean var110F23C56874217B802EA4C936A6C3F7_1985800241 = (replacement.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("replacement.isEmpty()");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA67683A55B0774718D49E6408E276F05_1723517100 = (replacement.length() > maxCharsPerByte());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("replacement length > maxCharsPerByte: " +
                    replacement.length() + " > " + maxCharsPerByte());
            } //End block
        } //End collapsed parenthetic
        replacementChars = replacement;
        implReplaceWith(replacement);
        varB4EAC82CA7396A68D541C85D26508E83_2046105242 = this;
        varB4EAC82CA7396A68D541C85D26508E83_2046105242.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2046105242;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.783 -0400", hash_original_method = "81D7771694F65FD718A9EEA5159D0F76", hash_generated_method = "7A4E7F2F35F90BC72ECD91A39A93AA74")
    public final CharsetDecoder reset() {
        CharsetDecoder varB4EAC82CA7396A68D541C85D26508E83_1732085673 = null; //Variable for return #1
        status = INIT;
        implReset();
        varB4EAC82CA7396A68D541C85D26508E83_1732085673 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1732085673.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1732085673;
        // ---------- Original Method ----------
        //status = INIT;
        //implReset();
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.783 -0400", hash_original_method = "01254405DC3888434A269A87FF2AF4FB", hash_generated_method = "1E256C9CE8452A4A09F2A0BAC1591256")
    public CodingErrorAction unmappableCharacterAction() {
        CodingErrorAction varB4EAC82CA7396A68D541C85D26508E83_2022364350 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2022364350 = unmappableCharacterAction;
        varB4EAC82CA7396A68D541C85D26508E83_2022364350.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2022364350;
        // ---------- Original Method ----------
        //return unmappableCharacterAction;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.783 -0400", hash_original_field = "22C642B36ABBA5FB5FD0764AC15B85BC", hash_generated_field = "402CCF359B0219F2A8DF949E79C08357")

    private static int INIT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.783 -0400", hash_original_field = "9797141D8C8814884DC8AA4D2585CEAA", hash_generated_field = "EAC0FA94EAFC1CDDBC4D24F9C4564638")

    private static int ONGOING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.783 -0400", hash_original_field = "39A10DCE3FD12B5D178E5141CAEA7B2C", hash_generated_field = "8F29D63086DDC815074164B8E5527205")

    private static int END = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.783 -0400", hash_original_field = "95D88E1D3DF2D2D0836FCDAF6845B681", hash_generated_field = "8DA07DD2FAFFC496EAC780FE853895AF")

    private static int FLUSH = 3;
}

