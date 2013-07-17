package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Arrays;

public abstract class CharsetEncoder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.579 -0400", hash_original_field = "95CC64DD2825F9DF13EC4AD683ECF339", hash_generated_field = "220BF257D2CCF23A35C6D1D35FB3F79C")

    private Charset cs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.579 -0400", hash_original_field = "692DC57502FA0F1ADE68D2F2AECF7494", hash_generated_field = "5C783D0D8B0013302A29C9244F7615B3")

    private float averageBytesPerChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.579 -0400", hash_original_field = "C6086AD8B30BBFB38F0CCB4A5C59689F", hash_generated_field = "B19FD23ACD0442A467073D3E6F98A95A")

    private float maxBytesPerChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.579 -0400", hash_original_field = "F9CC17F581C3F36A520F3F5943689734", hash_generated_field = "A0C8011AEB0BF78979EBADE417E449F0")

    private byte[] replacementBytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.579 -0400", hash_original_field = "9ACB44549B41563697BB490144EC6258", hash_generated_field = "4BAC49709EDEAEFDD9E07400E0F02406")

    private int status;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.579 -0400", hash_original_field = "A5D7CEB2C59B8CEE46C2953FEC9ABC19", hash_generated_field = "3E2B0E3E2E572DECE0B20D77E19B79CF")

    private boolean finished;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.579 -0400", hash_original_field = "E353C4A606D3E48C9BBB36EADD713EA4", hash_generated_field = "1214F64762553AD2B0BE51AAC36B64DE")

    private CodingErrorAction malformedInputAction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.579 -0400", hash_original_field = "F84ECDA294965F5911ABAE3B9702960C", hash_generated_field = "60F320659477DF0A50B0661AEB74E53F")

    private CodingErrorAction unmappableCharacterAction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.579 -0400", hash_original_field = "3A6BDBA8FB33A88CF7D52A1AF07A9C00", hash_generated_field = "E190C0DE068854E0E786DAC309DED1B8")

    private CharsetDecoder decoder;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.579 -0400", hash_original_method = "5E9CA4841A80C315BA24674061FE2949", hash_generated_method = "1FEA4E4A4F77EE54BC584F94561FDC37")
    protected  CharsetEncoder(Charset cs, float averageBytesPerChar, float maxBytesPerChar) {
        this(cs, averageBytesPerChar, maxBytesPerChar, new byte[] { (byte) '?' });
        addTaint(maxBytesPerChar);
        addTaint(averageBytesPerChar);
        addTaint(cs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.580 -0400", hash_original_method = "33500150E00A96E14E2810282423268E", hash_generated_method = "B90E8851D4DB976E8E3D3DF4119BA4DF")
    protected  CharsetEncoder(Charset cs, float averageBytesPerChar, float maxBytesPerChar, byte[] replacement) {
        this(cs, averageBytesPerChar, maxBytesPerChar, replacement, false);
        addTaint(replacement[0]);
        addTaint(maxBytesPerChar);
        addTaint(averageBytesPerChar);
        addTaint(cs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.582 -0400", hash_original_method = "173A83611BD70B9738420414876CE0BB", hash_generated_method = "64DDCBF6D5127DFC9B8D082FC5A94D61")
      CharsetEncoder(Charset cs, float averageBytesPerChar, float maxBytesPerChar, byte[] replacement, boolean trusted) {
        addTaint(trusted);
        if(averageBytesPerChar <= 0 || maxBytesPerChar <= 0)        
        {
            IllegalArgumentException var0F46B615CA4C53B650385A8806CFA290_722469105 = new IllegalArgumentException("averageBytesPerChar and maxBytesPerChar must both be positive");
            var0F46B615CA4C53B650385A8806CFA290_722469105.addTaint(taint);
            throw var0F46B615CA4C53B650385A8806CFA290_722469105;
        } //End block
        if(averageBytesPerChar > maxBytesPerChar)        
        {
            IllegalArgumentException varDD092DA2499E95CF681D1C7FD7004B27_1284457268 = new IllegalArgumentException("averageBytesPerChar is greater than maxBytesPerChar");
            varDD092DA2499E95CF681D1C7FD7004B27_1284457268.addTaint(taint);
            throw varDD092DA2499E95CF681D1C7FD7004B27_1284457268;
        } //End block
        this.cs = cs;
        this.averageBytesPerChar = averageBytesPerChar;
        this.maxBytesPerChar = maxBytesPerChar;
        status = INIT;
        malformedInputAction = CodingErrorAction.REPORT;
        unmappableCharacterAction = CodingErrorAction.REPORT;
        if(trusted)        
        {
            this.replacementBytes = replacement;
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.582 -0400", hash_original_method = "A746602428AC27FECC8176A57B5A2933", hash_generated_method = "A8131B1231438749A25A52B066E8AF26")
    public final float averageBytesPerChar() {
        float var692DC57502FA0F1ADE68D2F2AECF7494_504823372 = (averageBytesPerChar);
                float var546ADE640B6EDFBC8A086EF31347E768_1560026530 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1560026530;
        // ---------- Original Method ----------
        //return averageBytesPerChar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.583 -0400", hash_original_method = "DF8D80CA8C09E77634765D8D414FAE26", hash_generated_method = "45B1A68DC48064407D417DD7CA2E5B76")
    public boolean canEncode(char c) {
        addTaint(c);
        boolean var4551CB427266BC59F214535A4C542E3A_987159832 = (implCanEncode(CharBuffer.wrap(new char[] { c })));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1525677158 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1525677158;
        // ---------- Original Method ----------
        //return implCanEncode(CharBuffer.wrap(new char[] { c }));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.583 -0400", hash_original_method = "8FE38300B66D2E408C3C937D4188B910", hash_generated_method = "DFE2542FA3D78A71C84D06535545D5D3")
    private boolean implCanEncode(CharBuffer cb) {
        addTaint(cb.getTaint());
        if(status == FLUSH || status == INIT)        
        {
            status = READY;
        } //End block
        if(status != READY)        
        {
            IllegalStateException var2233C5742D45B8FB0E83D181222C3962_1189961619 = new IllegalStateException("encoding already in progress");
            var2233C5742D45B8FB0E83D181222C3962_1189961619.addTaint(taint);
            throw var2233C5742D45B8FB0E83D181222C3962_1189961619;
        } //End block
        CodingErrorAction malformBak = malformedInputAction;
        CodingErrorAction unmapBak = unmappableCharacterAction;
        onMalformedInput(CodingErrorAction.REPORT);
        onUnmappableCharacter(CodingErrorAction.REPORT);
        boolean result = true;
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
        boolean varB4A88417B3D0170D754C647C30B7216A_1824458610 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1325371223 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1325371223;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.584 -0400", hash_original_method = "54A1B7BF9180636CA7E06E09FE414A09", hash_generated_method = "D6C2DEBF9E10DEFD0E783CE0666CDEE2")
    public boolean canEncode(CharSequence sequence) {
        addTaint(sequence.getTaint());
        CharBuffer cb;
        if(sequence instanceof CharBuffer)        
        {
            cb = ((CharBuffer) sequence).duplicate();
        } //End block
        else
        {
            cb = CharBuffer.wrap(sequence);
        } //End block
        boolean var54464B6948BCB027723D6B8DDEB0E7FC_1511558291 = (implCanEncode(cb));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1367125544 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1367125544;
        // ---------- Original Method ----------
        //CharBuffer cb;
        //if (sequence instanceof CharBuffer) {
            //cb = ((CharBuffer) sequence).duplicate();
        //} else {
            //cb = CharBuffer.wrap(sequence);
        //}
        //return implCanEncode(cb);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.585 -0400", hash_original_method = "B98730A31745049759B27FC27542555A", hash_generated_method = "F4AC1382D6BDD78668181B90896888ED")
    public final Charset charset() {
Charset varE661418CFE0D2CECDB5DF6FE0739403D_215751605 =         cs;
        varE661418CFE0D2CECDB5DF6FE0739403D_215751605.addTaint(taint);
        return varE661418CFE0D2CECDB5DF6FE0739403D_215751605;
        // ---------- Original Method ----------
        //return cs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.586 -0400", hash_original_method = "6617ED92398FABBB6F1186A03F59422C", hash_generated_method = "6AACBD5A05E0FE2CCFBC5D41EBFD8A04")
    public final ByteBuffer encode(CharBuffer in) throws CharacterCodingException {
        addTaint(in.getTaint());
        if(in.remaining() == 0)        
        {
ByteBuffer var93152E1B6A1AB0EFBC2AC9286CE0E021_1070924204 =             ByteBuffer.allocate(0);
            var93152E1B6A1AB0EFBC2AC9286CE0E021_1070924204.addTaint(taint);
            return var93152E1B6A1AB0EFBC2AC9286CE0E021_1070924204;
        } //End block
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
            } //End block
            else
            if(result==CoderResult.OVERFLOW)            
            {
                output = allocateMore(output);
                continue;
            } //End block
            checkCoderResult(result);
        } //End block
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
            } //End block
            else
            if(result==CoderResult.OVERFLOW)            
            {
                output = allocateMore(output);
                continue;
            } //End block
            checkCoderResult(result);
            output.flip();
            if(result.isMalformed())            
            {
                MalformedInputException var8FA4E56DDF9AB0C4EE65F8C493EF8A64_1928145942 = new MalformedInputException(result.length());
                var8FA4E56DDF9AB0C4EE65F8C493EF8A64_1928145942.addTaint(taint);
                throw var8FA4E56DDF9AB0C4EE65F8C493EF8A64_1928145942;
            } //End block
            else
            if(result.isUnmappable())            
            {
                UnmappableCharacterException var6421AD8EFB043FAF5135AEE922347817_483193636 = new UnmappableCharacterException(result.length());
                var6421AD8EFB043FAF5135AEE922347817_483193636.addTaint(taint);
                throw var6421AD8EFB043FAF5135AEE922347817_483193636;
            } //End block
            break;
        } //End block
        status = READY;
        finished = true;
ByteBuffer varEB0B99CD62B23D2DD9E149CA2A9860B9_383822937 =         output;
        varEB0B99CD62B23D2DD9E149CA2A9860B9_383822937.addTaint(taint);
        return varEB0B99CD62B23D2DD9E149CA2A9860B9_383822937;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.586 -0400", hash_original_method = "AAF7B17852C8827C6D375001E4EF8669", hash_generated_method = "5DF2108BB45D3910757D0C884F125EAF")
    private void checkCoderResult(CoderResult result) throws CharacterCodingException {
        addTaint(result.getTaint());
        if(malformedInputAction == CodingErrorAction.REPORT && result.isMalformed())        
        {
            MalformedInputException var8FA4E56DDF9AB0C4EE65F8C493EF8A64_859505965 = new MalformedInputException(result.length());
            var8FA4E56DDF9AB0C4EE65F8C493EF8A64_859505965.addTaint(taint);
            throw var8FA4E56DDF9AB0C4EE65F8C493EF8A64_859505965;
        } //End block
        else
        if(unmappableCharacterAction == CodingErrorAction.REPORT && result.isUnmappable())        
        {
            UnmappableCharacterException var6421AD8EFB043FAF5135AEE922347817_1528880978 = new UnmappableCharacterException(result.length());
            var6421AD8EFB043FAF5135AEE922347817_1528880978.addTaint(taint);
            throw var6421AD8EFB043FAF5135AEE922347817_1528880978;
        } //End block
        // ---------- Original Method ----------
        //if (malformedInputAction == CodingErrorAction.REPORT && result.isMalformed() ) {
            //throw new MalformedInputException(result.length());
        //} else if (unmappableCharacterAction == CodingErrorAction.REPORT && result.isUnmappable()) {
            //throw new UnmappableCharacterException(result.length());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.587 -0400", hash_original_method = "46B614F003BDECDBAF0C028FA8A61DD7", hash_generated_method = "8DDBB17C34A936C6C9E576BB5EB1F5FE")
    private ByteBuffer allocateMore(ByteBuffer output) {
        addTaint(output.getTaint());
        if(output.capacity() == 0)        
        {
ByteBuffer var775DDCE7026DA2EEE84D7C6654D118C9_645137986 =             ByteBuffer.allocate(1);
            var775DDCE7026DA2EEE84D7C6654D118C9_645137986.addTaint(taint);
            return var775DDCE7026DA2EEE84D7C6654D118C9_645137986;
        } //End block
        ByteBuffer result = ByteBuffer.allocate(output.capacity() * 2);
        output.flip();
        result.put(output);
ByteBuffer varDC838461EE2FA0CA4C9BBB70A15456B0_141453591 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_141453591.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_141453591;
        // ---------- Original Method ----------
        //if (output.capacity() == 0) {
            //return ByteBuffer.allocate(1);
        //}
        //ByteBuffer result = ByteBuffer.allocate(output.capacity() * 2);
        //output.flip();
        //result.put(output);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.588 -0400", hash_original_method = "F53B4856D46D71BB987D9EC6F2ED08EE", hash_generated_method = "FA3DEB636F82E3CBC28BB17B4D9DD5B9")
    public final CoderResult encode(CharBuffer in, ByteBuffer out, boolean endOfInput) {
        addTaint(out.getTaint());
        addTaint(in.getTaint());
        if(status == READY && finished && !endOfInput)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_721507302 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_721507302.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_721507302;
        } //End block
        if((status == FLUSH) || (!endOfInput && status == END))        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_164048446 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_164048446.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_164048446;
        } //End block
        CoderResult result;
        while
(true)        
        {
            try 
            {
                result = encodeLoop(in, out);
            } //End block
            catch (BufferOverflowException e)
            {
                CoderMalfunctionError var8EAD6035EB0BDDFDBCD21E6489E2B914_1027363389 = new CoderMalfunctionError(e);
                var8EAD6035EB0BDDFDBCD21E6489E2B914_1027363389.addTaint(taint);
                throw var8EAD6035EB0BDDFDBCD21E6489E2B914_1027363389;
            } //End block
            catch (BufferUnderflowException e)
            {
                CoderMalfunctionError var8EAD6035EB0BDDFDBCD21E6489E2B914_1195590271 = new CoderMalfunctionError(e);
                var8EAD6035EB0BDDFDBCD21E6489E2B914_1195590271.addTaint(taint);
                throw var8EAD6035EB0BDDFDBCD21E6489E2B914_1195590271;
            } //End block
            if(result==CoderResult.UNDERFLOW)            
            {
                status = endOfInput ? END : ONGOING;
                if(endOfInput)                
                {
                    int remaining = in.remaining();
                    if(remaining > 0)                    
                    {
                        result = CoderResult.malformedForLength(remaining);
                    } //End block
                    else
                    {
CoderResult varDC838461EE2FA0CA4C9BBB70A15456B0_415656879 =                         result;
                        varDC838461EE2FA0CA4C9BBB70A15456B0_415656879.addTaint(taint);
                        return varDC838461EE2FA0CA4C9BBB70A15456B0_415656879;
                    } //End block
                } //End block
                else
                {
CoderResult varDC838461EE2FA0CA4C9BBB70A15456B0_62734581 =                     result;
                    varDC838461EE2FA0CA4C9BBB70A15456B0_62734581.addTaint(taint);
                    return varDC838461EE2FA0CA4C9BBB70A15456B0_62734581;
                } //End block
            } //End block
            else
            if(result==CoderResult.OVERFLOW)            
            {
                status = endOfInput ? END : ONGOING;
CoderResult varDC838461EE2FA0CA4C9BBB70A15456B0_1826576529 =                 result;
                varDC838461EE2FA0CA4C9BBB70A15456B0_1826576529.addTaint(taint);
                return varDC838461EE2FA0CA4C9BBB70A15456B0_1826576529;
            } //End block
            CodingErrorAction action = malformedInputAction;
            if(result.isUnmappable())            
            {
                action = unmappableCharacterAction;
            } //End block
            if(action == CodingErrorAction.REPLACE)            
            {
                if(out.remaining() < replacementBytes.length)                
                {
CoderResult varABB0206BF3597B3CDE0E8CB2CF4DF79C_950498219 =                     CoderResult.OVERFLOW;
                    varABB0206BF3597B3CDE0E8CB2CF4DF79C_950498219.addTaint(taint);
                    return varABB0206BF3597B3CDE0E8CB2CF4DF79C_950498219;
                } //End block
                out.put(replacementBytes);
            } //End block
            else
            {
                if(action != CodingErrorAction.IGNORE)                
                {
CoderResult varDC838461EE2FA0CA4C9BBB70A15456B0_378050707 =                     result;
                    varDC838461EE2FA0CA4C9BBB70A15456B0_378050707.addTaint(taint);
                    return varDC838461EE2FA0CA4C9BBB70A15456B0_378050707;
                } //End block
            } //End block
            in.position(in.position() + result.length());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    protected abstract CoderResult encodeLoop(CharBuffer in, ByteBuffer out);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.590 -0400", hash_original_method = "7DF66453B2225F37798DBF2842A3A344", hash_generated_method = "BF5707D3BB2E0138A7D8E51840B7B2FC")
    public final CoderResult flush(ByteBuffer out) {
        addTaint(out.getTaint());
        if(status != END && status != READY)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_66146586 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_66146586.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_66146586;
        } //End block
        CoderResult result = implFlush(out);
        if(result == CoderResult.UNDERFLOW)        
        {
            status = FLUSH;
        } //End block
CoderResult varDC838461EE2FA0CA4C9BBB70A15456B0_495921497 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_495921497.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_495921497;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.590 -0400", hash_original_method = "A9BF2BD565E7966B3C6B16D11959F2CA", hash_generated_method = "93F8D05FD410552DE235F092A91B2852")
    protected CoderResult implFlush(ByteBuffer out) {
        addTaint(out.getTaint());
CoderResult var4757652C33DAD6EF5B43FF5968DA807C_847899744 =         CoderResult.UNDERFLOW;
        var4757652C33DAD6EF5B43FF5968DA807C_847899744.addTaint(taint);
        return var4757652C33DAD6EF5B43FF5968DA807C_847899744;
        // ---------- Original Method ----------
        //return CoderResult.UNDERFLOW;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.590 -0400", hash_original_method = "E03D9D5B6C40FD58B1EEECF43C9BC127", hash_generated_method = "C3493E75D383B088DEBB94344366E9DE")
    protected void implOnMalformedInput(CodingErrorAction newAction) {
        addTaint(newAction.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.590 -0400", hash_original_method = "33D941D09604A3F698502AE892B2B2F1", hash_generated_method = "4B30141303236D37DE62574A267B9AF0")
    protected void implOnUnmappableCharacter(CodingErrorAction newAction) {
        addTaint(newAction.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.590 -0400", hash_original_method = "BBBD9A68869312EDB40CCAE9146777D7", hash_generated_method = "C9C5333A73F363FD625EC04BC5CF9C82")
    protected void implReplaceWith(byte[] newReplacement) {
        addTaint(newReplacement[0]);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.591 -0400", hash_original_method = "B1E265ECD4B779BE3343E27B901DC354", hash_generated_method = "2A58666B59F850117B41A249C7AD97D2")
    protected void implReset() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.591 -0400", hash_original_method = "0E6BADBD5D3BB826133FA0CE0CAA8F2B", hash_generated_method = "DE57A9CFF36E2EAD284C69FA559D7B6F")
    public boolean isLegalReplacement(byte[] replacement) {
        addTaint(replacement[0]);
        if(decoder == null)        
        {
            decoder = cs.newDecoder();
            decoder.onMalformedInput(CodingErrorAction.REPORT);
            decoder.onUnmappableCharacter(CodingErrorAction.REPORT);
        } //End block
        ByteBuffer in = ByteBuffer.wrap(replacement);
        CharBuffer out = CharBuffer.allocate((int) (replacement.length * decoder.maxCharsPerByte()));
        CoderResult result = decoder.decode(in, out, true);
        boolean var3C30AC09DC2A255CE917B1E9442FEDC1_1951585660 = (!result.isError());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1006116430 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1006116430;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.591 -0400", hash_original_method = "14FFD5293B4145E0D4BC6D81F9598816", hash_generated_method = "937525348E4329133D19A26A36EF741C")
    public CodingErrorAction malformedInputAction() {
CodingErrorAction var84571F1E1ACF9C5432CDAA5F78A66531_944092079 =         malformedInputAction;
        var84571F1E1ACF9C5432CDAA5F78A66531_944092079.addTaint(taint);
        return var84571F1E1ACF9C5432CDAA5F78A66531_944092079;
        // ---------- Original Method ----------
        //return malformedInputAction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.591 -0400", hash_original_method = "F4624CD8E2F5B5C085387046C0856D44", hash_generated_method = "4F9328747D98813249626DDBD2A01093")
    public final float maxBytesPerChar() {
        float varC6086AD8B30BBFB38F0CCB4A5C59689F_1357924915 = (maxBytesPerChar);
                float var546ADE640B6EDFBC8A086EF31347E768_517485251 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_517485251;
        // ---------- Original Method ----------
        //return maxBytesPerChar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.592 -0400", hash_original_method = "9AA0403DB22EF3A510B565026DCE2424", hash_generated_method = "1044ECB5288FF3117BC69E2EDD7A0385")
    public final CharsetEncoder onMalformedInput(CodingErrorAction newAction) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(newAction == null)        
        {
            IllegalArgumentException var0F3670EF1C09F47E316E2640B340CF8A_180754086 = new IllegalArgumentException("newAction == null");
            var0F3670EF1C09F47E316E2640B340CF8A_180754086.addTaint(taint);
            throw var0F3670EF1C09F47E316E2640B340CF8A_180754086;
        } //End block
        malformedInputAction = newAction;
        implOnMalformedInput(newAction);
CharsetEncoder var72A74007B2BE62B849F475C7BDA4658B_1838487532 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1838487532.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1838487532;
        // ---------- Original Method ----------
        //if (newAction == null) {
            //throw new IllegalArgumentException("newAction == null");
        //}
        //malformedInputAction = newAction;
        //implOnMalformedInput(newAction);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.592 -0400", hash_original_method = "8F9E9A5BA6AED0663F62AB88ADE1A1B8", hash_generated_method = "072425FD11797DEA310885FAF26CDAC3")
    public final CharsetEncoder onUnmappableCharacter(CodingErrorAction newAction) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(newAction == null)        
        {
            IllegalArgumentException var0F3670EF1C09F47E316E2640B340CF8A_1497561538 = new IllegalArgumentException("newAction == null");
            var0F3670EF1C09F47E316E2640B340CF8A_1497561538.addTaint(taint);
            throw var0F3670EF1C09F47E316E2640B340CF8A_1497561538;
        } //End block
        unmappableCharacterAction = newAction;
        implOnUnmappableCharacter(newAction);
CharsetEncoder var72A74007B2BE62B849F475C7BDA4658B_1697650201 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1697650201.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1697650201;
        // ---------- Original Method ----------
        //if (newAction == null) {
            //throw new IllegalArgumentException("newAction == null");
        //}
        //unmappableCharacterAction = newAction;
        //implOnUnmappableCharacter(newAction);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.593 -0400", hash_original_method = "D4DB6E703F0B5C3D24041A00F1C8C203", hash_generated_method = "52C5E001243603B28AFC086BCFBC39B0")
    public final byte[] replacement() {
        byte[] varF9CC17F581C3F36A520F3F5943689734_732063995 = (replacementBytes);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_985115814 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_985115814;
        // ---------- Original Method ----------
        //return replacementBytes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.593 -0400", hash_original_method = "267C7D54312382305679F98E9AD49DA0", hash_generated_method = "9B05131CA52EBC3A631E8C6494686C52")
    public final CharsetEncoder replaceWith(byte[] replacement) {
        if(replacement == null)        
        {
            IllegalArgumentException varDF52115D206E0F02FB9C53979C024970_18045389 = new IllegalArgumentException("replacement == null");
            varDF52115D206E0F02FB9C53979C024970_18045389.addTaint(taint);
            throw varDF52115D206E0F02FB9C53979C024970_18045389;
        } //End block
        if(replacement.length == 0)        
        {
            IllegalArgumentException var058B11E07A12DF2F2E9FE4E0B3D0458F_1251738536 = new IllegalArgumentException("replacement.length == 0");
            var058B11E07A12DF2F2E9FE4E0B3D0458F_1251738536.addTaint(taint);
            throw var058B11E07A12DF2F2E9FE4E0B3D0458F_1251738536;
        } //End block
        if(replacement.length > maxBytesPerChar())        
        {
            IllegalArgumentException var9D0D08533E730034369EB5AC94D840BB_132977784 = new IllegalArgumentException("replacement length > maxBytesPerChar: " +
                    replacement.length + " > " + maxBytesPerChar());
            var9D0D08533E730034369EB5AC94D840BB_132977784.addTaint(taint);
            throw var9D0D08533E730034369EB5AC94D840BB_132977784;
        } //End block
        if(!isLegalReplacement(replacement))        
        {
            IllegalArgumentException var3D1B7EC98CE5C7B0F8C601E2578C32FA_1168013075 = new IllegalArgumentException("bad replacement: " + Arrays.toString(replacement));
            var3D1B7EC98CE5C7B0F8C601E2578C32FA_1168013075.addTaint(taint);
            throw var3D1B7EC98CE5C7B0F8C601E2578C32FA_1168013075;
        } //End block
        this.replacementBytes = replacement;
        implReplaceWith(replacementBytes);
CharsetEncoder var72A74007B2BE62B849F475C7BDA4658B_1924077259 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1924077259.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1924077259;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.594 -0400", hash_original_method = "939E78B196C94EAC65CBC7206A9E1DD0", hash_generated_method = "FDBAE3F76301D706B1EBD93B2C441533")
    public final CharsetEncoder reset() {
        status = INIT;
        implReset();
CharsetEncoder var72A74007B2BE62B849F475C7BDA4658B_1909296836 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1909296836.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1909296836;
        // ---------- Original Method ----------
        //status = INIT;
        //implReset();
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.594 -0400", hash_original_method = "01254405DC3888434A269A87FF2AF4FB", hash_generated_method = "9F52F2620A1554B1F8DBD3760ED94CE1")
    public CodingErrorAction unmappableCharacterAction() {
CodingErrorAction varD37AD0A7D4A43E25B855A6935DCC834A_1696261348 =         unmappableCharacterAction;
        varD37AD0A7D4A43E25B855A6935DCC834A_1696261348.addTaint(taint);
        return varD37AD0A7D4A43E25B855A6935DCC834A_1696261348;
        // ---------- Original Method ----------
        //return unmappableCharacterAction;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.594 -0400", hash_original_field = "C7C7980D5941588A0F784DFB73417B5E", hash_generated_field = "13F9744A97D618343432AF93BBD9D480")

    private static final int READY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.594 -0400", hash_original_field = "9797141D8C8814884DC8AA4D2585CEAA", hash_generated_field = "BE844086D377CEB871B6E1DD59844EB0")

    private static final int ONGOING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.594 -0400", hash_original_field = "39A10DCE3FD12B5D178E5141CAEA7B2C", hash_generated_field = "B476F4C7146F42E47055EAC44A214B2C")

    private static final int END = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.594 -0400", hash_original_field = "95D88E1D3DF2D2D0836FCDAF6845B681", hash_generated_field = "D345F0B97A5F86F7808649FE9032B485")

    private static final int FLUSH = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.594 -0400", hash_original_field = "330661C2C2C5D0F2A7100203DE762459", hash_generated_field = "A23FBDE5837AE7A8AD8DDC6F0A5E686A")

    private static final int INIT = 4;
}

