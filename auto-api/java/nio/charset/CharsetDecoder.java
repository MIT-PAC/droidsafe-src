package java.nio.charset;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public abstract class CharsetDecoder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.874 -0400", hash_original_field = "61628476CEFEE98E133C4A262D6104E7", hash_generated_field = "529EF1EB47EC503C08AD8590AE0F62F5")

    private float averageCharsPerByte;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.874 -0400", hash_original_field = "DD42591D3D06DC7ACEDEDF2FA8238654", hash_generated_field = "2DF37DC2E87CE8D294B5CF2F013FD634")

    private float maxCharsPerByte;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.874 -0400", hash_original_field = "95CC64DD2825F9DF13EC4AD683ECF339", hash_generated_field = "220BF257D2CCF23A35C6D1D35FB3F79C")

    private Charset cs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.874 -0400", hash_original_field = "E353C4A606D3E48C9BBB36EADD713EA4", hash_generated_field = "1214F64762553AD2B0BE51AAC36B64DE")

    private CodingErrorAction malformedInputAction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.874 -0400", hash_original_field = "F84ECDA294965F5911ABAE3B9702960C", hash_generated_field = "60F320659477DF0A50B0661AEB74E53F")

    private CodingErrorAction unmappableCharacterAction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.874 -0400", hash_original_field = "AC19AB15816945D4560ACC390132433E", hash_generated_field = "4FB9354D4FC1B3B8FECFC231454ED4BC")

    private String replacementChars;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.874 -0400", hash_original_field = "9ACB44549B41563697BB490144EC6258", hash_generated_field = "4BAC49709EDEAEFDD9E07400E0F02406")

    private int status;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.875 -0400", hash_original_method = "8CF9EF6BF1CF308B9A895B171C1AF9B5", hash_generated_method = "31B8C3374F1E8451A42D44216C37163E")
    protected  CharsetDecoder(Charset charset, float averageCharsPerByte, float maxCharsPerByte) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("averageCharsPerByte and maxCharsPerByte must be positive");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("averageCharsPerByte is greater than maxCharsPerByte");
        } 
        this.averageCharsPerByte = averageCharsPerByte;
        this.maxCharsPerByte = maxCharsPerByte;
        cs = charset;
        status = INIT;
        malformedInputAction = CodingErrorAction.REPORT;
        unmappableCharacterAction = CodingErrorAction.REPORT;
        replacementChars = "\ufffd";
        
        
            
        
        
            
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.875 -0400", hash_original_method = "835453458CD254EFEDF140BA3E3A0055", hash_generated_method = "C881EE8E1EFBA306433BD6A4D105E31B")
    public final float averageCharsPerByte() {
        float var546ADE640B6EDFBC8A086EF31347E768_1033227943 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1033227943;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.875 -0400", hash_original_method = "B98730A31745049759B27FC27542555A", hash_generated_method = "DA9D2FC315AF34E540D8FD6797BA89F3")
    public final Charset charset() {
        Charset varB4EAC82CA7396A68D541C85D26508E83_2030131793 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2030131793 = cs;
        varB4EAC82CA7396A68D541C85D26508E83_2030131793.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2030131793;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.876 -0400", hash_original_method = "0575B5D8A4FDBA875B2771D84C02D5E1", hash_generated_method = "884B612CE528978886D0075A38BC0A76")
    public final CharBuffer decode(ByteBuffer in) throws CharacterCodingException {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1690669232 = null; 
        reset();
        int length = (int) (in.remaining() * averageCharsPerByte);
        CharBuffer output = CharBuffer.allocate(length);
        CoderResult result = null;
        {
            result = decode(in, output, false);
            checkCoderResult(result);
            {
                boolean varF1DB9CE261DCF48645D6337FBFF24029_1676693068 = (result.isUnderflow());
                {
                    boolean varD20C9318A05139203F7B82FC87F4D343_471851677 = (result.isOverflow());
                    {
                        output = allocateMore(output);
                    } 
                } 
            } 
        } 
        result = decode(in, output, true);
        checkCoderResult(result);
        {
            result = flush(output);
            checkCoderResult(result);
            {
                boolean var2AAE7F5A955BA87C5F37AFB5998173CD_648600587 = (result.isOverflow());
                {
                    output = allocateMore(output);
                } 
            } 
        } 
        output.flip();
        status = FLUSH;
        varB4EAC82CA7396A68D541C85D26508E83_1690669232 = output;
        addTaint(in.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1690669232.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1690669232;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.876 -0400", hash_original_method = "297219195E5B4473685A201861AC1DC3", hash_generated_method = "D2342A7F08EE4A72FA98BC17630D7E0A")
    private void checkCoderResult(CoderResult result) throws CharacterCodingException {
        {
            boolean var504E9C7F7D7D0D8DA16970B2F44C89AA_61788463 = (result.isMalformed() && malformedInputAction == CodingErrorAction.REPORT);
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedInputException(result.length());
            } 
            {
                boolean varC1BF2F4D76DB2A66374D034187758580_479079593 = (result.isUnmappable() && unmappableCharacterAction == CodingErrorAction.REPORT);
                {
                    if (DroidSafeAndroidRuntime.control) throw new UnmappableCharacterException(result.length());
                } 
            } 
        } 
        addTaint(result.getTaint());
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.878 -0400", hash_original_method = "D4DFBF2849FE3731857D4FDEE2ED4787", hash_generated_method = "9B61B1AA169FFB2F11F122670A49E4A6")
    private CharBuffer allocateMore(CharBuffer output) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1388361479 = null; 
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_472862047 = null; 
        {
            boolean var3DEB4C124602AAD988E7A1D53669DF60_1643586436 = (output.capacity() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1388361479 = CharBuffer.allocate(1);
            } 
        } 
        CharBuffer result = CharBuffer.allocate(output.capacity() * 2);
        output.flip();
        result.put(output);
        varB4EAC82CA7396A68D541C85D26508E83_472862047 = result;
        addTaint(output.getTaint());
        CharBuffer varA7E53CE21691AB073D9660D615818899_1105133410; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1105133410 = varB4EAC82CA7396A68D541C85D26508E83_1388361479;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1105133410 = varB4EAC82CA7396A68D541C85D26508E83_472862047;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1105133410.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1105133410;
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.880 -0400", hash_original_method = "40037F62CA1EB410AEAF236C6BDF7EBA", hash_generated_method = "29FBA6CEC92DBEA7D7BB4FDEAE251381")
    public final CoderResult decode(ByteBuffer in, CharBuffer out,
            boolean endOfInput) {
        CoderResult varB4EAC82CA7396A68D541C85D26508E83_2035583308 = null; 
        CoderResult varB4EAC82CA7396A68D541C85D26508E83_248792620 = null; 
        CoderResult varB4EAC82CA7396A68D541C85D26508E83_296633537 = null; 
        CoderResult varB4EAC82CA7396A68D541C85D26508E83_1713068881 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } 
        CoderResult result = null;
        {
            CodingErrorAction action = null;
            try 
            {
                result = decodeLoop(in, out);
            } 
            catch (BufferOverflowException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new CoderMalfunctionError(ex);
            } 
            catch (BufferUnderflowException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new CoderMalfunctionError(ex);
            } 
            {
                boolean varF1DB9CE261DCF48645D6337FBFF24029_1069535650 = (result.isUnderflow());
                {
                    int remaining = in.remaining();
                    status = endOfInput ? END : ONGOING;
                    {
                        result = CoderResult.malformedForLength(remaining);
                    } 
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_2035583308 = result;
                    } 
                } 
            } 
            {
                boolean var2AAE7F5A955BA87C5F37AFB5998173CD_1644512372 = (result.isOverflow());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_248792620 = result;
                } 
            } 
            action = malformedInputAction;
            {
                boolean var7C71B56CE29CA100AFEFFA537CA1E5FD_1356248629 = (result.isUnmappable());
                {
                    action = unmappableCharacterAction;
                } 
            } 
            {
                {
                    boolean varDFA1CD40AE60C1A98AAF3B3E35C30958_756505922 = (out.remaining() < replacementChars.length());
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_296633537 = CoderResult.OVERFLOW;
                    } 
                } 
                out.put(replacementChars);
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1713068881 = result;
            } 
            in.position(in.position() + result.length());
        } 
        addTaint(in.getTaint());
        addTaint(out.getTaint());
        CoderResult varA7E53CE21691AB073D9660D615818899_1556502529; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1556502529 = varB4EAC82CA7396A68D541C85D26508E83_2035583308;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1556502529 = varB4EAC82CA7396A68D541C85D26508E83_248792620;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1556502529 = varB4EAC82CA7396A68D541C85D26508E83_296633537;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1556502529 = varB4EAC82CA7396A68D541C85D26508E83_1713068881;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1556502529.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1556502529;
        
        
    }

    
    protected abstract CoderResult decodeLoop(ByteBuffer in, CharBuffer out);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.881 -0400", hash_original_method = "FA8F0AC80549BCE47D29C328C4E0F049", hash_generated_method = "6B666B5F7C2908E4533B52A660EE9DEF")
    public Charset detectedCharset() {
        throw new UnsupportedOperationException();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.881 -0400", hash_original_method = "5C3493C7F863D5F0BA88F45F364D1985", hash_generated_method = "C9291DC8E3091ED7C68AFE7AAE5296DE")
    public final CoderResult flush(CharBuffer out) {
        CoderResult varB4EAC82CA7396A68D541C85D26508E83_1941557434 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } 
        CoderResult result = implFlush(out);
        {
            status = FLUSH;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1941557434 = result;
        addTaint(out.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1941557434.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1941557434;
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.882 -0400", hash_original_method = "6025E36E88B99911562F9F8AEE21E28F", hash_generated_method = "A1FD7B22B5D9C9953AE1EBB23826ED8D")
    protected CoderResult implFlush(CharBuffer out) {
        CoderResult varB4EAC82CA7396A68D541C85D26508E83_609549776 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_609549776 = CoderResult.UNDERFLOW;
        addTaint(out.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_609549776.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_609549776;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.882 -0400", hash_original_method = "E03D9D5B6C40FD58B1EEECF43C9BC127", hash_generated_method = "C3493E75D383B088DEBB94344366E9DE")
    protected void implOnMalformedInput(CodingErrorAction newAction) {
        addTaint(newAction.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.883 -0400", hash_original_method = "33D941D09604A3F698502AE892B2B2F1", hash_generated_method = "4B30141303236D37DE62574A267B9AF0")
    protected void implOnUnmappableCharacter(CodingErrorAction newAction) {
        addTaint(newAction.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.883 -0400", hash_original_method = "5014FF47E324504A21AF53F373310654", hash_generated_method = "0D2CAD8C717F6EA291AA5ACB527A4134")
    protected void implReplaceWith(String newReplacement) {
        addTaint(newReplacement.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.883 -0400", hash_original_method = "B1E265ECD4B779BE3343E27B901DC354", hash_generated_method = "2A58666B59F850117B41A249C7AD97D2")
    protected void implReset() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.883 -0400", hash_original_method = "0E3C677639C4DB544DC0D4E7955DC077", hash_generated_method = "79D06EF09785C5FADA4E5BE342BF27D5")
    public boolean isAutoDetecting() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1414864430 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1414864430;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.884 -0400", hash_original_method = "EB764964ACE224C10D45E3B66AA00682", hash_generated_method = "570A4EA27FC385AB6C1E9DBA73AADE66")
    public boolean isCharsetDetected() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1973294486 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1973294486;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.884 -0400", hash_original_method = "14FFD5293B4145E0D4BC6D81F9598816", hash_generated_method = "F48EE1FF4FEE287EBE4DBE4CA754FF84")
    public CodingErrorAction malformedInputAction() {
        CodingErrorAction varB4EAC82CA7396A68D541C85D26508E83_1566929904 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1566929904 = malformedInputAction;
        varB4EAC82CA7396A68D541C85D26508E83_1566929904.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1566929904;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.884 -0400", hash_original_method = "1F4ECBF7B137C80889EF1BC2E2A0CCD1", hash_generated_method = "6B8C61C9E96F3193E000B24CDE3CCA14")
    public final float maxCharsPerByte() {
        float var546ADE640B6EDFBC8A086EF31347E768_1041141418 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1041141418;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.886 -0400", hash_original_method = "34F534C82C11F1FDAA0DD59455B931CF", hash_generated_method = "A1A41E61105D0F11CC8735E1A6A5DCAE")
    public final CharsetDecoder onMalformedInput(CodingErrorAction newAction) {
        
        CharsetDecoder varB4EAC82CA7396A68D541C85D26508E83_227077145 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        malformedInputAction = newAction;
        implOnMalformedInput(newAction);
        varB4EAC82CA7396A68D541C85D26508E83_227077145 = this;
        varB4EAC82CA7396A68D541C85D26508E83_227077145.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_227077145;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.888 -0400", hash_original_method = "652123D755D0FEE6B30AA61176E436F9", hash_generated_method = "39F001EEC4F7018597501C24875E215D")
    public final CharsetDecoder onUnmappableCharacter(CodingErrorAction newAction) {
        
        CharsetDecoder varB4EAC82CA7396A68D541C85D26508E83_1366218053 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        unmappableCharacterAction = newAction;
        implOnUnmappableCharacter(newAction);
        varB4EAC82CA7396A68D541C85D26508E83_1366218053 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1366218053.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1366218053;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.889 -0400", hash_original_method = "30CB7E3F60490326C9B63C38EC65670E", hash_generated_method = "46B38CC079D535F6904D400F82DCB3EE")
    public final String replacement() {
        String varB4EAC82CA7396A68D541C85D26508E83_1681350211 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1681350211 = replacementChars;
        varB4EAC82CA7396A68D541C85D26508E83_1681350211.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1681350211;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.891 -0400", hash_original_method = "B18C28BF3814F00BA79DEB9A20AA9835", hash_generated_method = "41A301A47D80D7743A12087BDE88BB88")
    public final CharsetDecoder replaceWith(String replacement) {
        CharsetDecoder varB4EAC82CA7396A68D541C85D26508E83_353293991 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("replacement == null");
        } 
        {
            boolean var110F23C56874217B802EA4C936A6C3F7_1961955631 = (replacement.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("replacement.isEmpty()");
            } 
        } 
        {
            boolean varA67683A55B0774718D49E6408E276F05_2050468769 = (replacement.length() > maxCharsPerByte());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("replacement length > maxCharsPerByte: " +
                    replacement.length() + " > " + maxCharsPerByte());
            } 
        } 
        replacementChars = replacement;
        implReplaceWith(replacement);
        varB4EAC82CA7396A68D541C85D26508E83_353293991 = this;
        varB4EAC82CA7396A68D541C85D26508E83_353293991.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_353293991;
        
        
            
        
        
            
        
        
            
                    
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.893 -0400", hash_original_method = "81D7771694F65FD718A9EEA5159D0F76", hash_generated_method = "5707F0EDCCC0656F7D88EC88584F0B7B")
    public final CharsetDecoder reset() {
        CharsetDecoder varB4EAC82CA7396A68D541C85D26508E83_1350509257 = null; 
        status = INIT;
        implReset();
        varB4EAC82CA7396A68D541C85D26508E83_1350509257 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1350509257.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1350509257;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.894 -0400", hash_original_method = "01254405DC3888434A269A87FF2AF4FB", hash_generated_method = "2E3716F181AD0FD333C5D369A00D488F")
    public CodingErrorAction unmappableCharacterAction() {
        CodingErrorAction varB4EAC82CA7396A68D541C85D26508E83_898344604 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_898344604 = unmappableCharacterAction;
        varB4EAC82CA7396A68D541C85D26508E83_898344604.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_898344604;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.894 -0400", hash_original_field = "22C642B36ABBA5FB5FD0764AC15B85BC", hash_generated_field = "9EA234AF8E19378FF28F64776BC1B1AC")

    private static final int INIT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.894 -0400", hash_original_field = "9797141D8C8814884DC8AA4D2585CEAA", hash_generated_field = "BE844086D377CEB871B6E1DD59844EB0")

    private static final int ONGOING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.894 -0400", hash_original_field = "39A10DCE3FD12B5D178E5141CAEA7B2C", hash_generated_field = "B476F4C7146F42E47055EAC44A214B2C")

    private static final int END = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.894 -0400", hash_original_field = "95D88E1D3DF2D2D0836FCDAF6845B681", hash_generated_field = "D345F0B97A5F86F7808649FE9032B485")

    private static final int FLUSH = 3;
}

