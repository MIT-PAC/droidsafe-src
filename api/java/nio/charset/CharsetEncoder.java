package java.nio.charset;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Arrays;

public abstract class CharsetEncoder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.824 -0400", hash_original_field = "95CC64DD2825F9DF13EC4AD683ECF339", hash_generated_field = "220BF257D2CCF23A35C6D1D35FB3F79C")

    private Charset cs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.824 -0400", hash_original_field = "692DC57502FA0F1ADE68D2F2AECF7494", hash_generated_field = "5C783D0D8B0013302A29C9244F7615B3")

    private float averageBytesPerChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.824 -0400", hash_original_field = "C6086AD8B30BBFB38F0CCB4A5C59689F", hash_generated_field = "B19FD23ACD0442A467073D3E6F98A95A")

    private float maxBytesPerChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.824 -0400", hash_original_field = "F9CC17F581C3F36A520F3F5943689734", hash_generated_field = "A0C8011AEB0BF78979EBADE417E449F0")

    private byte[] replacementBytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.824 -0400", hash_original_field = "9ACB44549B41563697BB490144EC6258", hash_generated_field = "4BAC49709EDEAEFDD9E07400E0F02406")

    private int status;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.825 -0400", hash_original_field = "A5D7CEB2C59B8CEE46C2953FEC9ABC19", hash_generated_field = "3E2B0E3E2E572DECE0B20D77E19B79CF")

    private boolean finished;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.825 -0400", hash_original_field = "E353C4A606D3E48C9BBB36EADD713EA4", hash_generated_field = "1214F64762553AD2B0BE51AAC36B64DE")

    private CodingErrorAction malformedInputAction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.825 -0400", hash_original_field = "F84ECDA294965F5911ABAE3B9702960C", hash_generated_field = "60F320659477DF0A50B0661AEB74E53F")

    private CodingErrorAction unmappableCharacterAction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.825 -0400", hash_original_field = "3A6BDBA8FB33A88CF7D52A1AF07A9C00", hash_generated_field = "E190C0DE068854E0E786DAC309DED1B8")

    private CharsetDecoder decoder;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.825 -0400", hash_original_method = "5E9CA4841A80C315BA24674061FE2949", hash_generated_method = "1FEA4E4A4F77EE54BC584F94561FDC37")
    protected  CharsetEncoder(Charset cs, float averageBytesPerChar, float maxBytesPerChar) {
        this(cs, averageBytesPerChar, maxBytesPerChar, new byte[] { (byte) '?' });
        addTaint(maxBytesPerChar);
        addTaint(averageBytesPerChar);
        addTaint(cs.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.826 -0400", hash_original_method = "33500150E00A96E14E2810282423268E", hash_generated_method = "B90E8851D4DB976E8E3D3DF4119BA4DF")
    protected  CharsetEncoder(Charset cs, float averageBytesPerChar, float maxBytesPerChar, byte[] replacement) {
        this(cs, averageBytesPerChar, maxBytesPerChar, replacement, false);
        addTaint(replacement[0]);
        addTaint(maxBytesPerChar);
        addTaint(averageBytesPerChar);
        addTaint(cs.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.827 -0400", hash_original_method = "173A83611BD70B9738420414876CE0BB", hash_generated_method = "080A7FB89864FCA7EC3C8CDC76AD8FF3")
      CharsetEncoder(Charset cs, float averageBytesPerChar, float maxBytesPerChar, byte[] replacement, boolean trusted) {
        addTaint(trusted);
    if(averageBytesPerChar <= 0 || maxBytesPerChar <= 0)        
        {
            IllegalArgumentException var0F46B615CA4C53B650385A8806CFA290_1092146222 = new IllegalArgumentException("averageBytesPerChar and maxBytesPerChar must both be positive");
            var0F46B615CA4C53B650385A8806CFA290_1092146222.addTaint(taint);
            throw var0F46B615CA4C53B650385A8806CFA290_1092146222;
        } 
    if(averageBytesPerChar > maxBytesPerChar)        
        {
            IllegalArgumentException varDD092DA2499E95CF681D1C7FD7004B27_448917534 = new IllegalArgumentException("averageBytesPerChar is greater than maxBytesPerChar");
            varDD092DA2499E95CF681D1C7FD7004B27_448917534.addTaint(taint);
            throw varDD092DA2499E95CF681D1C7FD7004B27_448917534;
        } 
        this.cs = cs;
        this.averageBytesPerChar = averageBytesPerChar;
        this.maxBytesPerChar = maxBytesPerChar;
        status = INIT;
        malformedInputAction = CodingErrorAction.REPORT;
        unmappableCharacterAction = CodingErrorAction.REPORT;
    if(trusted)        
        {
            this.replacementBytes = replacement;
        } 
        else
        {
            replaceWith(replacement);
        } 
        
        
            
        
        
            
        
        
        
        
        
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.828 -0400", hash_original_method = "A746602428AC27FECC8176A57B5A2933", hash_generated_method = "EB1D5B2589DF45F3FFAC600CEDC3F80D")
    public final float averageBytesPerChar() {
        float var692DC57502FA0F1ADE68D2F2AECF7494_657374348 = (averageBytesPerChar);
                float var546ADE640B6EDFBC8A086EF31347E768_1093290269 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1093290269;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.828 -0400", hash_original_method = "DF8D80CA8C09E77634765D8D414FAE26", hash_generated_method = "B9F2E032E74F1969C5C825744D47FF0D")
    public boolean canEncode(char c) {
        addTaint(c);
        boolean var4551CB427266BC59F214535A4C542E3A_1469359006 = (implCanEncode(CharBuffer.wrap(new char[] { c })));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_975605427 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_975605427;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.829 -0400", hash_original_method = "8FE38300B66D2E408C3C937D4188B910", hash_generated_method = "82F010B3BE44C1E71B840787D9E73D51")
    private boolean implCanEncode(CharBuffer cb) {
        addTaint(cb.getTaint());
    if(status == FLUSH || status == INIT)        
        {
            status = READY;
        } 
    if(status != READY)        
        {
            IllegalStateException var2233C5742D45B8FB0E83D181222C3962_793827674 = new IllegalStateException("encoding already in progress");
            var2233C5742D45B8FB0E83D181222C3962_793827674.addTaint(taint);
            throw var2233C5742D45B8FB0E83D181222C3962_793827674;
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
        boolean varB4A88417B3D0170D754C647C30B7216A_1253418769 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_793397595 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_793397595;
        
        
            
        
        
            
        
        
        
        
        
        
        
            
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.830 -0400", hash_original_method = "54A1B7BF9180636CA7E06E09FE414A09", hash_generated_method = "F149CAC5D93E1E5A36017FEA7BEFC35A")
    public boolean canEncode(CharSequence sequence) {
        addTaint(sequence.getTaint());
        CharBuffer cb;
    if(sequence instanceof CharBuffer)        
        {
            cb = ((CharBuffer) sequence).duplicate();
        } 
        else
        {
            cb = CharBuffer.wrap(sequence);
        } 
        boolean var54464B6948BCB027723D6B8DDEB0E7FC_443784006 = (implCanEncode(cb));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2013099438 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2013099438;
        
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.830 -0400", hash_original_method = "B98730A31745049759B27FC27542555A", hash_generated_method = "9FBB20DA5E082DF65A2E48DC76A89FD4")
    public final Charset charset() {
Charset varE661418CFE0D2CECDB5DF6FE0739403D_1624791366 =         cs;
        varE661418CFE0D2CECDB5DF6FE0739403D_1624791366.addTaint(taint);
        return varE661418CFE0D2CECDB5DF6FE0739403D_1624791366;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.832 -0400", hash_original_method = "6617ED92398FABBB6F1186A03F59422C", hash_generated_method = "31F15F6BBC66979C0AE7AAE5CECCBCBE")
    public final ByteBuffer encode(CharBuffer in) throws CharacterCodingException {
        addTaint(in.getTaint());
    if(in.remaining() == 0)        
        {
ByteBuffer var93152E1B6A1AB0EFBC2AC9286CE0E021_1035004091 =             ByteBuffer.allocate(0);
            var93152E1B6A1AB0EFBC2AC9286CE0E021_1035004091.addTaint(taint);
            return var93152E1B6A1AB0EFBC2AC9286CE0E021_1035004091;
        } 
        reset();
        int length = (int) (in.remaining() * averageBytesPerChar);
        ByteBuffer output = ByteBuffer.allocate(length);
        CoderResult result = null;
        while
(true)        
        {
            result = encode(in, output, false);
    if(result==CoderResult.UNDERFLOW)            
            {
                break;
            } 
            else
    if(result==CoderResult.OVERFLOW)            
            {
                output = allocateMore(output);
                continue;
            } 
            checkCoderResult(result);
        } 
        result = encode(in, output, true);
        checkCoderResult(result);
        while
(true)        
        {
            result = flush(output);
    if(result==CoderResult.UNDERFLOW)            
            {
                output.flip();
                break;
            } 
            else
    if(result==CoderResult.OVERFLOW)            
            {
                output = allocateMore(output);
                continue;
            } 
            checkCoderResult(result);
            output.flip();
    if(result.isMalformed())            
            {
                MalformedInputException var8FA4E56DDF9AB0C4EE65F8C493EF8A64_1839683923 = new MalformedInputException(result.length());
                var8FA4E56DDF9AB0C4EE65F8C493EF8A64_1839683923.addTaint(taint);
                throw var8FA4E56DDF9AB0C4EE65F8C493EF8A64_1839683923;
            } 
            else
    if(result.isUnmappable())            
            {
                UnmappableCharacterException var6421AD8EFB043FAF5135AEE922347817_2122968339 = new UnmappableCharacterException(result.length());
                var6421AD8EFB043FAF5135AEE922347817_2122968339.addTaint(taint);
                throw var6421AD8EFB043FAF5135AEE922347817_2122968339;
            } 
            break;
        } 
        status = READY;
        finished = true;
ByteBuffer varEB0B99CD62B23D2DD9E149CA2A9860B9_1415944897 =         output;
        varEB0B99CD62B23D2DD9E149CA2A9860B9_1415944897.addTaint(taint);
        return varEB0B99CD62B23D2DD9E149CA2A9860B9_1415944897;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.832 -0400", hash_original_method = "AAF7B17852C8827C6D375001E4EF8669", hash_generated_method = "D96AD47E708727A99D35BC8DCBD08913")
    private void checkCoderResult(CoderResult result) throws CharacterCodingException {
        addTaint(result.getTaint());
    if(malformedInputAction == CodingErrorAction.REPORT && result.isMalformed())        
        {
            MalformedInputException var8FA4E56DDF9AB0C4EE65F8C493EF8A64_1860481123 = new MalformedInputException(result.length());
            var8FA4E56DDF9AB0C4EE65F8C493EF8A64_1860481123.addTaint(taint);
            throw var8FA4E56DDF9AB0C4EE65F8C493EF8A64_1860481123;
        } 
        else
    if(unmappableCharacterAction == CodingErrorAction.REPORT && result.isUnmappable())        
        {
            UnmappableCharacterException var6421AD8EFB043FAF5135AEE922347817_270564985 = new UnmappableCharacterException(result.length());
            var6421AD8EFB043FAF5135AEE922347817_270564985.addTaint(taint);
            throw var6421AD8EFB043FAF5135AEE922347817_270564985;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.833 -0400", hash_original_method = "46B614F003BDECDBAF0C028FA8A61DD7", hash_generated_method = "78362CFF9D8AA3E435203CC61D66F5C5")
    private ByteBuffer allocateMore(ByteBuffer output) {
        addTaint(output.getTaint());
    if(output.capacity() == 0)        
        {
ByteBuffer var775DDCE7026DA2EEE84D7C6654D118C9_673805355 =             ByteBuffer.allocate(1);
            var775DDCE7026DA2EEE84D7C6654D118C9_673805355.addTaint(taint);
            return var775DDCE7026DA2EEE84D7C6654D118C9_673805355;
        } 
        ByteBuffer result = ByteBuffer.allocate(output.capacity() * 2);
        output.flip();
        result.put(output);
ByteBuffer varDC838461EE2FA0CA4C9BBB70A15456B0_680099106 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_680099106.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_680099106;
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.834 -0400", hash_original_method = "F53B4856D46D71BB987D9EC6F2ED08EE", hash_generated_method = "99F162AEBDF3277DDDECE5EC57E7300A")
    public final CoderResult encode(CharBuffer in, ByteBuffer out, boolean endOfInput) {
        addTaint(out.getTaint());
        addTaint(in.getTaint());
    if(status == READY && finished && !endOfInput)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1258223949 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1258223949.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1258223949;
        } 
    if((status == FLUSH) || (!endOfInput && status == END))        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_926799700 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_926799700.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_926799700;
        } 
        CoderResult result;
        while
(true)        
        {
            try 
            {
                result = encodeLoop(in, out);
            } 
            catch (BufferOverflowException e)
            {
                CoderMalfunctionError var8EAD6035EB0BDDFDBCD21E6489E2B914_1778080252 = new CoderMalfunctionError(e);
                var8EAD6035EB0BDDFDBCD21E6489E2B914_1778080252.addTaint(taint);
                throw var8EAD6035EB0BDDFDBCD21E6489E2B914_1778080252;
            } 
            catch (BufferUnderflowException e)
            {
                CoderMalfunctionError var8EAD6035EB0BDDFDBCD21E6489E2B914_154196972 = new CoderMalfunctionError(e);
                var8EAD6035EB0BDDFDBCD21E6489E2B914_154196972.addTaint(taint);
                throw var8EAD6035EB0BDDFDBCD21E6489E2B914_154196972;
            } 
    if(result==CoderResult.UNDERFLOW)            
            {
                status = endOfInput ? END : ONGOING;
    if(endOfInput)                
                {
                    int remaining = in.remaining();
    if(remaining > 0)                    
                    {
                        result = CoderResult.malformedForLength(remaining);
                    } 
                    else
                    {
CoderResult varDC838461EE2FA0CA4C9BBB70A15456B0_1574376344 =                         result;
                        varDC838461EE2FA0CA4C9BBB70A15456B0_1574376344.addTaint(taint);
                        return varDC838461EE2FA0CA4C9BBB70A15456B0_1574376344;
                    } 
                } 
                else
                {
CoderResult varDC838461EE2FA0CA4C9BBB70A15456B0_843292872 =                     result;
                    varDC838461EE2FA0CA4C9BBB70A15456B0_843292872.addTaint(taint);
                    return varDC838461EE2FA0CA4C9BBB70A15456B0_843292872;
                } 
            } 
            else
    if(result==CoderResult.OVERFLOW)            
            {
                status = endOfInput ? END : ONGOING;
CoderResult varDC838461EE2FA0CA4C9BBB70A15456B0_640389959 =                 result;
                varDC838461EE2FA0CA4C9BBB70A15456B0_640389959.addTaint(taint);
                return varDC838461EE2FA0CA4C9BBB70A15456B0_640389959;
            } 
            CodingErrorAction action = malformedInputAction;
    if(result.isUnmappable())            
            {
                action = unmappableCharacterAction;
            } 
    if(action == CodingErrorAction.REPLACE)            
            {
    if(out.remaining() < replacementBytes.length)                
                {
CoderResult varABB0206BF3597B3CDE0E8CB2CF4DF79C_1932805200 =                     CoderResult.OVERFLOW;
                    varABB0206BF3597B3CDE0E8CB2CF4DF79C_1932805200.addTaint(taint);
                    return varABB0206BF3597B3CDE0E8CB2CF4DF79C_1932805200;
                } 
                out.put(replacementBytes);
            } 
            else
            {
    if(action != CodingErrorAction.IGNORE)                
                {
CoderResult varDC838461EE2FA0CA4C9BBB70A15456B0_1500579812 =                     result;
                    varDC838461EE2FA0CA4C9BBB70A15456B0_1500579812.addTaint(taint);
                    return varDC838461EE2FA0CA4C9BBB70A15456B0_1500579812;
                } 
            } 
            in.position(in.position() + result.length());
        } 
        
        
    }

    
    protected abstract CoderResult encodeLoop(CharBuffer in, ByteBuffer out);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.836 -0400", hash_original_method = "7DF66453B2225F37798DBF2842A3A344", hash_generated_method = "53C55056ECAAFA0B371165567BF1BCBF")
    public final CoderResult flush(ByteBuffer out) {
        addTaint(out.getTaint());
    if(status != END && status != READY)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_791951556 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_791951556.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_791951556;
        } 
        CoderResult result = implFlush(out);
    if(result == CoderResult.UNDERFLOW)        
        {
            status = FLUSH;
        } 
CoderResult varDC838461EE2FA0CA4C9BBB70A15456B0_1306401638 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1306401638.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1306401638;
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.836 -0400", hash_original_method = "A9BF2BD565E7966B3C6B16D11959F2CA", hash_generated_method = "3C88571D6DC14D39828C907D93DFB2C2")
    protected CoderResult implFlush(ByteBuffer out) {
        addTaint(out.getTaint());
CoderResult var4757652C33DAD6EF5B43FF5968DA807C_1949978256 =         CoderResult.UNDERFLOW;
        var4757652C33DAD6EF5B43FF5968DA807C_1949978256.addTaint(taint);
        return var4757652C33DAD6EF5B43FF5968DA807C_1949978256;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.836 -0400", hash_original_method = "E03D9D5B6C40FD58B1EEECF43C9BC127", hash_generated_method = "C3493E75D383B088DEBB94344366E9DE")
    protected void implOnMalformedInput(CodingErrorAction newAction) {
        addTaint(newAction.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.837 -0400", hash_original_method = "33D941D09604A3F698502AE892B2B2F1", hash_generated_method = "4B30141303236D37DE62574A267B9AF0")
    protected void implOnUnmappableCharacter(CodingErrorAction newAction) {
        addTaint(newAction.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.837 -0400", hash_original_method = "BBBD9A68869312EDB40CCAE9146777D7", hash_generated_method = "C9C5333A73F363FD625EC04BC5CF9C82")
    protected void implReplaceWith(byte[] newReplacement) {
        addTaint(newReplacement[0]);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.837 -0400", hash_original_method = "B1E265ECD4B779BE3343E27B901DC354", hash_generated_method = "2A58666B59F850117B41A249C7AD97D2")
    protected void implReset() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.838 -0400", hash_original_method = "0E6BADBD5D3BB826133FA0CE0CAA8F2B", hash_generated_method = "2D7C9C96000D663E668E428F658B8108")
    public boolean isLegalReplacement(byte[] replacement) {
        addTaint(replacement[0]);
    if(decoder == null)        
        {
            decoder = cs.newDecoder();
            decoder.onMalformedInput(CodingErrorAction.REPORT);
            decoder.onUnmappableCharacter(CodingErrorAction.REPORT);
        } 
        ByteBuffer in = ByteBuffer.wrap(replacement);
        CharBuffer out = CharBuffer.allocate((int) (replacement.length * decoder.maxCharsPerByte()));
        CoderResult result = decoder.decode(in, out, true);
        boolean var3C30AC09DC2A255CE917B1E9442FEDC1_1081697824 = (!result.isError());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_601087997 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_601087997;
        
        
            
            
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.838 -0400", hash_original_method = "14FFD5293B4145E0D4BC6D81F9598816", hash_generated_method = "3BA92B90CC65F905BCAC9B7B86FE1B83")
    public CodingErrorAction malformedInputAction() {
CodingErrorAction var84571F1E1ACF9C5432CDAA5F78A66531_1079943060 =         malformedInputAction;
        var84571F1E1ACF9C5432CDAA5F78A66531_1079943060.addTaint(taint);
        return var84571F1E1ACF9C5432CDAA5F78A66531_1079943060;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.838 -0400", hash_original_method = "F4624CD8E2F5B5C085387046C0856D44", hash_generated_method = "3A65C22A93471B40430FA8CAD23F0940")
    public final float maxBytesPerChar() {
        float varC6086AD8B30BBFB38F0CCB4A5C59689F_596413215 = (maxBytesPerChar);
                float var546ADE640B6EDFBC8A086EF31347E768_956653600 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_956653600;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.839 -0400", hash_original_method = "9AA0403DB22EF3A510B565026DCE2424", hash_generated_method = "63C02AED933F99E7B4680C1D78F604C6")
    public final CharsetEncoder onMalformedInput(CodingErrorAction newAction) {
        
    if(newAction == null)        
        {
            IllegalArgumentException var0F3670EF1C09F47E316E2640B340CF8A_1599497638 = new IllegalArgumentException("newAction == null");
            var0F3670EF1C09F47E316E2640B340CF8A_1599497638.addTaint(taint);
            throw var0F3670EF1C09F47E316E2640B340CF8A_1599497638;
        } 
        malformedInputAction = newAction;
        implOnMalformedInput(newAction);
CharsetEncoder var72A74007B2BE62B849F475C7BDA4658B_814150527 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_814150527.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_814150527;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.840 -0400", hash_original_method = "8F9E9A5BA6AED0663F62AB88ADE1A1B8", hash_generated_method = "8D98D2191D59ED0D42F0D3454459F3AC")
    public final CharsetEncoder onUnmappableCharacter(CodingErrorAction newAction) {
        
    if(newAction == null)        
        {
            IllegalArgumentException var0F3670EF1C09F47E316E2640B340CF8A_2059709319 = new IllegalArgumentException("newAction == null");
            var0F3670EF1C09F47E316E2640B340CF8A_2059709319.addTaint(taint);
            throw var0F3670EF1C09F47E316E2640B340CF8A_2059709319;
        } 
        unmappableCharacterAction = newAction;
        implOnUnmappableCharacter(newAction);
CharsetEncoder var72A74007B2BE62B849F475C7BDA4658B_726268621 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_726268621.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_726268621;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.840 -0400", hash_original_method = "D4DB6E703F0B5C3D24041A00F1C8C203", hash_generated_method = "1078F0284BBD1B6667B15C717F2F5DF4")
    public final byte[] replacement() {
        byte[] varF9CC17F581C3F36A520F3F5943689734_441754559 = (replacementBytes);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1193385700 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1193385700;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.841 -0400", hash_original_method = "267C7D54312382305679F98E9AD49DA0", hash_generated_method = "EC574CACB69EC0EBF62EB503D4FA3012")
    public final CharsetEncoder replaceWith(byte[] replacement) {
    if(replacement == null)        
        {
            IllegalArgumentException varDF52115D206E0F02FB9C53979C024970_22489716 = new IllegalArgumentException("replacement == null");
            varDF52115D206E0F02FB9C53979C024970_22489716.addTaint(taint);
            throw varDF52115D206E0F02FB9C53979C024970_22489716;
        } 
    if(replacement.length == 0)        
        {
            IllegalArgumentException var058B11E07A12DF2F2E9FE4E0B3D0458F_1125251596 = new IllegalArgumentException("replacement.length == 0");
            var058B11E07A12DF2F2E9FE4E0B3D0458F_1125251596.addTaint(taint);
            throw var058B11E07A12DF2F2E9FE4E0B3D0458F_1125251596;
        } 
    if(replacement.length > maxBytesPerChar())        
        {
            IllegalArgumentException var9D0D08533E730034369EB5AC94D840BB_1892551825 = new IllegalArgumentException("replacement length > maxBytesPerChar: " +
                    replacement.length + " > " + maxBytesPerChar());
            var9D0D08533E730034369EB5AC94D840BB_1892551825.addTaint(taint);
            throw var9D0D08533E730034369EB5AC94D840BB_1892551825;
        } 
    if(!isLegalReplacement(replacement))        
        {
            IllegalArgumentException var3D1B7EC98CE5C7B0F8C601E2578C32FA_1085385176 = new IllegalArgumentException("bad replacement: " + Arrays.toString(replacement));
            var3D1B7EC98CE5C7B0F8C601E2578C32FA_1085385176.addTaint(taint);
            throw var3D1B7EC98CE5C7B0F8C601E2578C32FA_1085385176;
        } 
        this.replacementBytes = replacement;
        implReplaceWith(replacementBytes);
CharsetEncoder var72A74007B2BE62B849F475C7BDA4658B_1093172079 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1093172079.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1093172079;
        
        
            
        
        
            
        
        
            
                    
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.841 -0400", hash_original_method = "939E78B196C94EAC65CBC7206A9E1DD0", hash_generated_method = "015FDBAE43FC1B6007980D46D51521F6")
    public final CharsetEncoder reset() {
        status = INIT;
        implReset();
CharsetEncoder var72A74007B2BE62B849F475C7BDA4658B_7242016 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_7242016.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_7242016;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.842 -0400", hash_original_method = "01254405DC3888434A269A87FF2AF4FB", hash_generated_method = "992FCC03D32521224C58815BD6D2BBCE")
    public CodingErrorAction unmappableCharacterAction() {
CodingErrorAction varD37AD0A7D4A43E25B855A6935DCC834A_837181810 =         unmappableCharacterAction;
        varD37AD0A7D4A43E25B855A6935DCC834A_837181810.addTaint(taint);
        return varD37AD0A7D4A43E25B855A6935DCC834A_837181810;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.842 -0400", hash_original_field = "C7C7980D5941588A0F784DFB73417B5E", hash_generated_field = "13F9744A97D618343432AF93BBD9D480")

    private static final int READY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.842 -0400", hash_original_field = "9797141D8C8814884DC8AA4D2585CEAA", hash_generated_field = "BE844086D377CEB871B6E1DD59844EB0")

    private static final int ONGOING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.842 -0400", hash_original_field = "39A10DCE3FD12B5D178E5141CAEA7B2C", hash_generated_field = "B476F4C7146F42E47055EAC44A214B2C")

    private static final int END = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.842 -0400", hash_original_field = "95D88E1D3DF2D2D0836FCDAF6845B681", hash_generated_field = "D345F0B97A5F86F7808649FE9032B485")

    private static final int FLUSH = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.842 -0400", hash_original_field = "330661C2C2C5D0F2A7100203DE762459", hash_generated_field = "A23FBDE5837AE7A8AD8DDC6F0A5E686A")

    private static final int INIT = 4;
}

