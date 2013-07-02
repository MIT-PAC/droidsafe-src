package java.nio.charset;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Arrays;

public abstract class CharsetEncoder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.941 -0400", hash_original_field = "95CC64DD2825F9DF13EC4AD683ECF339", hash_generated_field = "220BF257D2CCF23A35C6D1D35FB3F79C")

    private Charset cs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.941 -0400", hash_original_field = "692DC57502FA0F1ADE68D2F2AECF7494", hash_generated_field = "5C783D0D8B0013302A29C9244F7615B3")

    private float averageBytesPerChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.941 -0400", hash_original_field = "C6086AD8B30BBFB38F0CCB4A5C59689F", hash_generated_field = "B19FD23ACD0442A467073D3E6F98A95A")

    private float maxBytesPerChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.941 -0400", hash_original_field = "F9CC17F581C3F36A520F3F5943689734", hash_generated_field = "A0C8011AEB0BF78979EBADE417E449F0")

    private byte[] replacementBytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.941 -0400", hash_original_field = "9ACB44549B41563697BB490144EC6258", hash_generated_field = "4BAC49709EDEAEFDD9E07400E0F02406")

    private int status;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.941 -0400", hash_original_field = "A5D7CEB2C59B8CEE46C2953FEC9ABC19", hash_generated_field = "3E2B0E3E2E572DECE0B20D77E19B79CF")

    private boolean finished;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.941 -0400", hash_original_field = "E353C4A606D3E48C9BBB36EADD713EA4", hash_generated_field = "1214F64762553AD2B0BE51AAC36B64DE")

    private CodingErrorAction malformedInputAction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.941 -0400", hash_original_field = "F84ECDA294965F5911ABAE3B9702960C", hash_generated_field = "60F320659477DF0A50B0661AEB74E53F")

    private CodingErrorAction unmappableCharacterAction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.941 -0400", hash_original_field = "3A6BDBA8FB33A88CF7D52A1AF07A9C00", hash_generated_field = "E190C0DE068854E0E786DAC309DED1B8")

    private CharsetDecoder decoder;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.942 -0400", hash_original_method = "5E9CA4841A80C315BA24674061FE2949", hash_generated_method = "AB673120CF966E87AB770CBFB9340F38")
    protected  CharsetEncoder(Charset cs, float averageBytesPerChar, float maxBytesPerChar) {
        this(cs, averageBytesPerChar, maxBytesPerChar, new byte[] { (byte) '?' });
        addTaint(cs.getTaint());
        addTaint(averageBytesPerChar);
        addTaint(maxBytesPerChar);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.942 -0400", hash_original_method = "33500150E00A96E14E2810282423268E", hash_generated_method = "4B37B9F2B9C7057E8B19629251946346")
    protected  CharsetEncoder(Charset cs, float averageBytesPerChar, float maxBytesPerChar, byte[] replacement) {
        this(cs, averageBytesPerChar, maxBytesPerChar, replacement, false);
        addTaint(cs.getTaint());
        addTaint(averageBytesPerChar);
        addTaint(maxBytesPerChar);
        addTaint(replacement[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.942 -0400", hash_original_method = "173A83611BD70B9738420414876CE0BB", hash_generated_method = "0AA5407F07A7EF8D099EA348CDCAB7E6")
      CharsetEncoder(Charset cs, float averageBytesPerChar, float maxBytesPerChar, byte[] replacement, boolean trusted) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("averageBytesPerChar and maxBytesPerChar must both be positive");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("averageBytesPerChar is greater than maxBytesPerChar");
        } 
        this.cs = cs;
        this.averageBytesPerChar = averageBytesPerChar;
        this.maxBytesPerChar = maxBytesPerChar;
        status = INIT;
        malformedInputAction = CodingErrorAction.REPORT;
        unmappableCharacterAction = CodingErrorAction.REPORT;
        {
            this.replacementBytes = replacement;
        } 
        {
            replaceWith(replacement);
        } 
        addTaint(trusted);
        
        
            
        
        
            
        
        
        
        
        
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.943 -0400", hash_original_method = "A746602428AC27FECC8176A57B5A2933", hash_generated_method = "820C4921DFD08FF459BC632F76256240")
    public final float averageBytesPerChar() {
        float var546ADE640B6EDFBC8A086EF31347E768_1544349856 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1544349856;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.943 -0400", hash_original_method = "DF8D80CA8C09E77634765D8D414FAE26", hash_generated_method = "0DE490FB4A31B5D51A2B4A2FA9284F1E")
    public boolean canEncode(char c) {
        boolean varA7FD43173EF46EB747DE5BC527CFC0F0_2139367243 = (implCanEncode(CharBuffer.wrap(new char[] { c })));
        addTaint(c);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1399643061 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1399643061;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.944 -0400", hash_original_method = "8FE38300B66D2E408C3C937D4188B910", hash_generated_method = "71A018DBAD07800EA5C3097B7E18AE23")
    private boolean implCanEncode(CharBuffer cb) {
        {
            status = READY;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("encoding already in progress");
        } 
        CodingErrorAction malformBak = malformedInputAction;
        CodingErrorAction unmapBak = unmappableCharacterAction;
        onMalformedInput(CodingErrorAction.REPORT);
        onUnmappableCharacter(CodingErrorAction.REPORT);
        boolean result = true;
        try 
        {
            this.encode(cb);
        } 
        catch (CharacterCodingException e)
        {
            result = false;
        } 
        onMalformedInput(malformBak);
        onUnmappableCharacter(unmapBak);
        reset();
        addTaint(cb.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_584785216 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_584785216;
        
        
            
        
        
            
        
        
        
        
        
        
        
            
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.945 -0400", hash_original_method = "54A1B7BF9180636CA7E06E09FE414A09", hash_generated_method = "0D3C5B183EECF1F71B93E9DE9DC142EB")
    public boolean canEncode(CharSequence sequence) {
        CharBuffer cb;
        {
            cb = ((CharBuffer) sequence).duplicate();
        } 
        {
            cb = CharBuffer.wrap(sequence);
        } 
        boolean var023A5CE57CF042FFBBA2A26CD7409D7D_1630730411 = (implCanEncode(cb));
        addTaint(sequence.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_928268044 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_928268044;
        
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.946 -0400", hash_original_method = "B98730A31745049759B27FC27542555A", hash_generated_method = "F33A9586754006ACBCFF772BF5FFE027")
    public final Charset charset() {
        Charset varB4EAC82CA7396A68D541C85D26508E83_1541620048 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1541620048 = cs;
        varB4EAC82CA7396A68D541C85D26508E83_1541620048.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1541620048;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.947 -0400", hash_original_method = "6617ED92398FABBB6F1186A03F59422C", hash_generated_method = "AFC947D4813A10EEAC4E6B334B049D01")
    public final ByteBuffer encode(CharBuffer in) throws CharacterCodingException {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1054564426 = null; 
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_955939511 = null; 
        {
            boolean varB71CC61526E00AC9D330BA9C6FAE6AF4_1307700432 = (in.remaining() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1054564426 = ByteBuffer.allocate(0);
            } 
        } 
        reset();
        int length = (int) (in.remaining() * averageBytesPerChar);
        ByteBuffer output = ByteBuffer.allocate(length);
        CoderResult result = null;
        {
            result = encode(in, output, false);
            {
                output = allocateMore(output);
            } 
            checkCoderResult(result);
        } 
        result = encode(in, output, true);
        checkCoderResult(result);
        {
            result = flush(output);
            {
                output.flip();
            } 
            {
                output = allocateMore(output);
            } 
            checkCoderResult(result);
            output.flip();
            {
                boolean var8469AFDE58F4B5BD8D7E58A7D8589BFA_931642073 = (result.isMalformed());
                {
                    if (DroidSafeAndroidRuntime.control) throw new MalformedInputException(result.length());
                } 
                {
                    boolean var196B10A57454E4B497B11983F4E91B5B_1949284501 = (result.isUnmappable());
                    {
                        if (DroidSafeAndroidRuntime.control) throw new UnmappableCharacterException(result.length());
                    } 
                } 
            } 
        } 
        status = READY;
        finished = true;
        varB4EAC82CA7396A68D541C85D26508E83_955939511 = output;
        addTaint(in.getTaint());
        ByteBuffer varA7E53CE21691AB073D9660D615818899_704590995; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_704590995 = varB4EAC82CA7396A68D541C85D26508E83_1054564426;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_704590995 = varB4EAC82CA7396A68D541C85D26508E83_955939511;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_704590995.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_704590995;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.947 -0400", hash_original_method = "AAF7B17852C8827C6D375001E4EF8669", hash_generated_method = "47FA5337AB8C72CDC5A0E01817B35DD6")
    private void checkCoderResult(CoderResult result) throws CharacterCodingException {
        {
            boolean varBC2698A81CD65EBF00573A40EB4CCB31_483998729 = (malformedInputAction == CodingErrorAction.REPORT && result.isMalformed());
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedInputException(result.length());
            } 
            {
                boolean var81194D29E7906F799C148A511B4F0E68_1559086424 = (unmappableCharacterAction == CodingErrorAction.REPORT && result.isUnmappable());
                {
                    if (DroidSafeAndroidRuntime.control) throw new UnmappableCharacterException(result.length());
                } 
            } 
        } 
        addTaint(result.getTaint());
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.948 -0400", hash_original_method = "46B614F003BDECDBAF0C028FA8A61DD7", hash_generated_method = "2555091FDE9E9458132E854F832BF473")
    private ByteBuffer allocateMore(ByteBuffer output) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_115418846 = null; 
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_358929268 = null; 
        {
            boolean var3DEB4C124602AAD988E7A1D53669DF60_1205722210 = (output.capacity() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_115418846 = ByteBuffer.allocate(1);
            } 
        } 
        ByteBuffer result = ByteBuffer.allocate(output.capacity() * 2);
        output.flip();
        result.put(output);
        varB4EAC82CA7396A68D541C85D26508E83_358929268 = result;
        addTaint(output.getTaint());
        ByteBuffer varA7E53CE21691AB073D9660D615818899_1888430021; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1888430021 = varB4EAC82CA7396A68D541C85D26508E83_115418846;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1888430021 = varB4EAC82CA7396A68D541C85D26508E83_358929268;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1888430021.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1888430021;
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.949 -0400", hash_original_method = "F53B4856D46D71BB987D9EC6F2ED08EE", hash_generated_method = "F42DCED7A17D26F926EE3BDA48FF38C5")
    public final CoderResult encode(CharBuffer in, ByteBuffer out, boolean endOfInput) {
        CoderResult varB4EAC82CA7396A68D541C85D26508E83_1063360844 = null; 
        CoderResult varB4EAC82CA7396A68D541C85D26508E83_742264414 = null; 
        CoderResult varB4EAC82CA7396A68D541C85D26508E83_443878279 = null; 
        CoderResult varB4EAC82CA7396A68D541C85D26508E83_138181870 = null; 
        CoderResult varB4EAC82CA7396A68D541C85D26508E83_1343581796 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } 
        CoderResult result;
        {
            try 
            {
                result = encodeLoop(in, out);
            } 
            catch (BufferOverflowException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new CoderMalfunctionError(e);
            } 
            catch (BufferUnderflowException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new CoderMalfunctionError(e);
            } 
            {
                status = endOfInput ? END : ONGOING;
                {
                    int remaining = in.remaining();
                    {
                        result = CoderResult.malformedForLength(remaining);
                    } 
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1063360844 = result;
                    } 
                } 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_742264414 = result;
                } 
            } 
            {
                status = endOfInput ? END : ONGOING;
                varB4EAC82CA7396A68D541C85D26508E83_443878279 = result;
            } 
            CodingErrorAction action = malformedInputAction;
            {
                boolean var7C71B56CE29CA100AFEFFA537CA1E5FD_1601801498 = (result.isUnmappable());
                {
                    action = unmappableCharacterAction;
                } 
            } 
            {
                {
                    boolean varD5123830D1882C75C40901CDBD4F3A20_1278078906 = (out.remaining() < replacementBytes.length);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_138181870 = CoderResult.OVERFLOW;
                    } 
                } 
                out.put(replacementBytes);
            } 
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1343581796 = result;
                } 
            } 
            in.position(in.position() + result.length());
        } 
        addTaint(in.getTaint());
        addTaint(out.getTaint());
        CoderResult varA7E53CE21691AB073D9660D615818899_792357193; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_792357193 = varB4EAC82CA7396A68D541C85D26508E83_1063360844;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_792357193 = varB4EAC82CA7396A68D541C85D26508E83_742264414;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_792357193 = varB4EAC82CA7396A68D541C85D26508E83_443878279;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_792357193 = varB4EAC82CA7396A68D541C85D26508E83_138181870;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_792357193 = varB4EAC82CA7396A68D541C85D26508E83_1343581796;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_792357193.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_792357193;
        
        
    }

    
    protected abstract CoderResult encodeLoop(CharBuffer in, ByteBuffer out);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.950 -0400", hash_original_method = "7DF66453B2225F37798DBF2842A3A344", hash_generated_method = "95F2FE4AFA956FF52A6D7DA59420F670")
    public final CoderResult flush(ByteBuffer out) {
        CoderResult varB4EAC82CA7396A68D541C85D26508E83_1404888101 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } 
        CoderResult result = implFlush(out);
        {
            status = FLUSH;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1404888101 = result;
        addTaint(out.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1404888101.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1404888101;
        
        
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.951 -0400", hash_original_method = "A9BF2BD565E7966B3C6B16D11959F2CA", hash_generated_method = "E525C3DE9EE3F07285FA14432C97553A")
    protected CoderResult implFlush(ByteBuffer out) {
        CoderResult varB4EAC82CA7396A68D541C85D26508E83_1739099312 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1739099312 = CoderResult.UNDERFLOW;
        addTaint(out.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1739099312.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1739099312;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.951 -0400", hash_original_method = "E03D9D5B6C40FD58B1EEECF43C9BC127", hash_generated_method = "C3493E75D383B088DEBB94344366E9DE")
    protected void implOnMalformedInput(CodingErrorAction newAction) {
        addTaint(newAction.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.951 -0400", hash_original_method = "33D941D09604A3F698502AE892B2B2F1", hash_generated_method = "4B30141303236D37DE62574A267B9AF0")
    protected void implOnUnmappableCharacter(CodingErrorAction newAction) {
        addTaint(newAction.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.952 -0400", hash_original_method = "BBBD9A68869312EDB40CCAE9146777D7", hash_generated_method = "C9C5333A73F363FD625EC04BC5CF9C82")
    protected void implReplaceWith(byte[] newReplacement) {
        addTaint(newReplacement[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.952 -0400", hash_original_method = "B1E265ECD4B779BE3343E27B901DC354", hash_generated_method = "2A58666B59F850117B41A249C7AD97D2")
    protected void implReset() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.952 -0400", hash_original_method = "0E6BADBD5D3BB826133FA0CE0CAA8F2B", hash_generated_method = "A9FA8DCA3C76E063FBD49BC0F4052FA3")
    public boolean isLegalReplacement(byte[] replacement) {
        {
            decoder = cs.newDecoder();
            decoder.onMalformedInput(CodingErrorAction.REPORT);
            decoder.onUnmappableCharacter(CodingErrorAction.REPORT);
        } 
        ByteBuffer in = ByteBuffer.wrap(replacement);
        CharBuffer out = CharBuffer.allocate((int) (replacement.length * decoder.maxCharsPerByte()));
        CoderResult result = decoder.decode(in, out, true);
        boolean var5C456402861126D9E9CB5325CADC138C_1478750581 = (!result.isError());
        addTaint(replacement[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_766102088 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_766102088;
        
        
            
            
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.953 -0400", hash_original_method = "14FFD5293B4145E0D4BC6D81F9598816", hash_generated_method = "0E8756548871145894F95708FFD131E3")
    public CodingErrorAction malformedInputAction() {
        CodingErrorAction varB4EAC82CA7396A68D541C85D26508E83_1799371272 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1799371272 = malformedInputAction;
        varB4EAC82CA7396A68D541C85D26508E83_1799371272.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1799371272;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.953 -0400", hash_original_method = "F4624CD8E2F5B5C085387046C0856D44", hash_generated_method = "01F4027F90977DB72C68260405A8F895")
    public final float maxBytesPerChar() {
        float var546ADE640B6EDFBC8A086EF31347E768_893267111 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_893267111;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.953 -0400", hash_original_method = "9AA0403DB22EF3A510B565026DCE2424", hash_generated_method = "9C6BB1F497D3B8152DE75724A9FA0D8B")
    public final CharsetEncoder onMalformedInput(CodingErrorAction newAction) {
        
        CharsetEncoder varB4EAC82CA7396A68D541C85D26508E83_1258828640 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("newAction == null");
        } 
        malformedInputAction = newAction;
        implOnMalformedInput(newAction);
        varB4EAC82CA7396A68D541C85D26508E83_1258828640 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1258828640.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1258828640;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.954 -0400", hash_original_method = "8F9E9A5BA6AED0663F62AB88ADE1A1B8", hash_generated_method = "746F977B5C7754B86A9330C83FA55444")
    public final CharsetEncoder onUnmappableCharacter(CodingErrorAction newAction) {
        
        CharsetEncoder varB4EAC82CA7396A68D541C85D26508E83_1284640948 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("newAction == null");
        } 
        unmappableCharacterAction = newAction;
        implOnUnmappableCharacter(newAction);
        varB4EAC82CA7396A68D541C85D26508E83_1284640948 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1284640948.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1284640948;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.954 -0400", hash_original_method = "D4DB6E703F0B5C3D24041A00F1C8C203", hash_generated_method = "99C1885AC3842A682A40301663BD338B")
    public final byte[] replacement() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_23454562 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_23454562;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.955 -0400", hash_original_method = "267C7D54312382305679F98E9AD49DA0", hash_generated_method = "8136485CBDF3292C04B733630126C149")
    public final CharsetEncoder replaceWith(byte[] replacement) {
        CharsetEncoder varB4EAC82CA7396A68D541C85D26508E83_2019992492 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("replacement == null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("replacement.length == 0");
        } 
        {
            boolean varB376EDDCE96EE6241256C0F96C9F4DFD_280739076 = (replacement.length > maxBytesPerChar());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("replacement length > maxBytesPerChar: " +
                    replacement.length + " > " + maxBytesPerChar());
            } 
        } 
        {
            boolean var2BA55E348EDBBB6A73AD018C9E6D1F0A_1701897469 = (!isLegalReplacement(replacement));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("bad replacement: " + Arrays.toString(replacement));
            } 
        } 
        this.replacementBytes = replacement;
        implReplaceWith(replacementBytes);
        varB4EAC82CA7396A68D541C85D26508E83_2019992492 = this;
        varB4EAC82CA7396A68D541C85D26508E83_2019992492.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2019992492;
        
        
            
        
        
            
        
        
            
                    
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.956 -0400", hash_original_method = "939E78B196C94EAC65CBC7206A9E1DD0", hash_generated_method = "CF465A4436D79740BE5D3914196D88FE")
    public final CharsetEncoder reset() {
        CharsetEncoder varB4EAC82CA7396A68D541C85D26508E83_1064804454 = null; 
        status = INIT;
        implReset();
        varB4EAC82CA7396A68D541C85D26508E83_1064804454 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1064804454.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1064804454;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.957 -0400", hash_original_method = "01254405DC3888434A269A87FF2AF4FB", hash_generated_method = "FA898BF704CBFF227B0D7BDB230ECF9B")
    public CodingErrorAction unmappableCharacterAction() {
        CodingErrorAction varB4EAC82CA7396A68D541C85D26508E83_1761182742 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1761182742 = unmappableCharacterAction;
        varB4EAC82CA7396A68D541C85D26508E83_1761182742.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1761182742;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.957 -0400", hash_original_field = "C7C7980D5941588A0F784DFB73417B5E", hash_generated_field = "13F9744A97D618343432AF93BBD9D480")

    private static final int READY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.957 -0400", hash_original_field = "9797141D8C8814884DC8AA4D2585CEAA", hash_generated_field = "BE844086D377CEB871B6E1DD59844EB0")

    private static final int ONGOING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.957 -0400", hash_original_field = "39A10DCE3FD12B5D178E5141CAEA7B2C", hash_generated_field = "B476F4C7146F42E47055EAC44A214B2C")

    private static final int END = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.957 -0400", hash_original_field = "95D88E1D3DF2D2D0836FCDAF6845B681", hash_generated_field = "D345F0B97A5F86F7808649FE9032B485")

    private static final int FLUSH = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.957 -0400", hash_original_field = "330661C2C2C5D0F2A7100203DE762459", hash_generated_field = "A23FBDE5837AE7A8AD8DDC6F0A5E686A")

    private static final int INIT = 4;
}

