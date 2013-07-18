package java.nio.charset;

// Droidsafe Imports
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class CharsetDecoder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.509 -0400", hash_original_field = "61628476CEFEE98E133C4A262D6104E7", hash_generated_field = "529EF1EB47EC503C08AD8590AE0F62F5")

    private float averageCharsPerByte;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.509 -0400", hash_original_field = "DD42591D3D06DC7ACEDEDF2FA8238654", hash_generated_field = "2DF37DC2E87CE8D294B5CF2F013FD634")

    private float maxCharsPerByte;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.509 -0400", hash_original_field = "95CC64DD2825F9DF13EC4AD683ECF339", hash_generated_field = "220BF257D2CCF23A35C6D1D35FB3F79C")

    private Charset cs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.509 -0400", hash_original_field = "E353C4A606D3E48C9BBB36EADD713EA4", hash_generated_field = "1214F64762553AD2B0BE51AAC36B64DE")

    private CodingErrorAction malformedInputAction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.509 -0400", hash_original_field = "F84ECDA294965F5911ABAE3B9702960C", hash_generated_field = "60F320659477DF0A50B0661AEB74E53F")

    private CodingErrorAction unmappableCharacterAction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.509 -0400", hash_original_field = "AC19AB15816945D4560ACC390132433E", hash_generated_field = "4FB9354D4FC1B3B8FECFC231454ED4BC")

    private String replacementChars;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.509 -0400", hash_original_field = "9ACB44549B41563697BB490144EC6258", hash_generated_field = "4BAC49709EDEAEFDD9E07400E0F02406")

    private int status;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.511 -0400", hash_original_method = "8CF9EF6BF1CF308B9A895B171C1AF9B5", hash_generated_method = "E8B59658B3E5007A56E6966CC9AD0161")
    protected  CharsetDecoder(Charset charset, float averageCharsPerByte, float maxCharsPerByte) {
        if(averageCharsPerByte <= 0 || maxCharsPerByte <= 0)        
        {
            IllegalArgumentException varEB58E99F5BFBD8586DE8E992B2ED6DA7_1325626405 = new IllegalArgumentException("averageCharsPerByte and maxCharsPerByte must be positive");
            varEB58E99F5BFBD8586DE8E992B2ED6DA7_1325626405.addTaint(taint);
            throw varEB58E99F5BFBD8586DE8E992B2ED6DA7_1325626405;
        } //End block
        if(averageCharsPerByte > maxCharsPerByte)        
        {
            IllegalArgumentException var84C0C01131D068485D81563C07CC4F54_1163134159 = new IllegalArgumentException("averageCharsPerByte is greater than maxCharsPerByte");
            var84C0C01131D068485D81563C07CC4F54_1163134159.addTaint(taint);
            throw var84C0C01131D068485D81563C07CC4F54_1163134159;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.512 -0400", hash_original_method = "835453458CD254EFEDF140BA3E3A0055", hash_generated_method = "B0E5DF1EAB03660AC24B441CBB1B6041")
    public final float averageCharsPerByte() {
        float var61628476CEFEE98E133C4A262D6104E7_731792729 = (averageCharsPerByte);
                float var546ADE640B6EDFBC8A086EF31347E768_163108974 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_163108974;
        // ---------- Original Method ----------
        //return averageCharsPerByte;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.512 -0400", hash_original_method = "B98730A31745049759B27FC27542555A", hash_generated_method = "A1E4B8A2D8DE12B3E19E7D6D33B0A97F")
    public final Charset charset() {
Charset varE661418CFE0D2CECDB5DF6FE0739403D_435231190 =         cs;
        varE661418CFE0D2CECDB5DF6FE0739403D_435231190.addTaint(taint);
        return varE661418CFE0D2CECDB5DF6FE0739403D_435231190;
        // ---------- Original Method ----------
        //return cs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.513 -0400", hash_original_method = "0575B5D8A4FDBA875B2771D84C02D5E1", hash_generated_method = "D9EA38C9AA603762D9AB8B1386363C77")
    public final CharBuffer decode(ByteBuffer in) throws CharacterCodingException {
        addTaint(in.getTaint());
        reset();
        int length = (int) (in.remaining() * averageCharsPerByte);
        CharBuffer output = CharBuffer.allocate(length);
        CoderResult result = null;
        while
(true)        
        {
            result = decode(in, output, false);
            checkCoderResult(result);
            if(result.isUnderflow())            
            {
                break;
            } //End block
            else
            if(result.isOverflow())            
            {
                output = allocateMore(output);
            } //End block
        } //End block
        result = decode(in, output, true);
        checkCoderResult(result);
        while
(true)        
        {
            result = flush(output);
            checkCoderResult(result);
            if(result.isOverflow())            
            {
                output = allocateMore(output);
            } //End block
            else
            {
                break;
            } //End block
        } //End block
        output.flip();
        status = FLUSH;
CharBuffer varEB0B99CD62B23D2DD9E149CA2A9860B9_163917115 =         output;
        varEB0B99CD62B23D2DD9E149CA2A9860B9_163917115.addTaint(taint);
        return varEB0B99CD62B23D2DD9E149CA2A9860B9_163917115;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.514 -0400", hash_original_method = "297219195E5B4473685A201861AC1DC3", hash_generated_method = "5A8EC11F5198E95956BA645C9AEFD9E2")
    private void checkCoderResult(CoderResult result) throws CharacterCodingException {
        addTaint(result.getTaint());
        if(result.isMalformed() && malformedInputAction == CodingErrorAction.REPORT)        
        {
            MalformedInputException var8FA4E56DDF9AB0C4EE65F8C493EF8A64_832211701 = new MalformedInputException(result.length());
            var8FA4E56DDF9AB0C4EE65F8C493EF8A64_832211701.addTaint(taint);
            throw var8FA4E56DDF9AB0C4EE65F8C493EF8A64_832211701;
        } //End block
        else
        if(result.isUnmappable() && unmappableCharacterAction == CodingErrorAction.REPORT)        
        {
            UnmappableCharacterException var6421AD8EFB043FAF5135AEE922347817_423462808 = new UnmappableCharacterException(result.length());
            var6421AD8EFB043FAF5135AEE922347817_423462808.addTaint(taint);
            throw var6421AD8EFB043FAF5135AEE922347817_423462808;
        } //End block
        // ---------- Original Method ----------
        //if (result.isMalformed() && malformedInputAction == CodingErrorAction.REPORT) {
            //throw new MalformedInputException(result.length());
        //} else if (result.isUnmappable() && unmappableCharacterAction == CodingErrorAction.REPORT) {
            //throw new UnmappableCharacterException(result.length());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.519 -0400", hash_original_method = "D4DFBF2849FE3731857D4FDEE2ED4787", hash_generated_method = "E41C87AC35041D530E6F8B95172A519A")
    private CharBuffer allocateMore(CharBuffer output) {
        addTaint(output.getTaint());
        if(output.capacity() == 0)        
        {
CharBuffer var5CF2BCC8491086EA62744A71E10FF335_1880807551 =             CharBuffer.allocate(1);
            var5CF2BCC8491086EA62744A71E10FF335_1880807551.addTaint(taint);
            return var5CF2BCC8491086EA62744A71E10FF335_1880807551;
        } //End block
        CharBuffer result = CharBuffer.allocate(output.capacity() * 2);
        output.flip();
        result.put(output);
CharBuffer varDC838461EE2FA0CA4C9BBB70A15456B0_1781581702 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1781581702.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1781581702;
        // ---------- Original Method ----------
        //if (output.capacity() == 0) {
            //return CharBuffer.allocate(1);
        //}
        //CharBuffer result = CharBuffer.allocate(output.capacity() * 2);
        //output.flip();
        //result.put(output);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.521 -0400", hash_original_method = "40037F62CA1EB410AEAF236C6BDF7EBA", hash_generated_method = "200223906A33A3390EF0C00103C567BD")
    public final CoderResult decode(ByteBuffer in, CharBuffer out,
            boolean endOfInput) {
        addTaint(out.getTaint());
        addTaint(in.getTaint());
        if((status == FLUSH) || (!endOfInput && status == END))        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_953626875 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_953626875.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_953626875;
        } //End block
        CoderResult result = null;
        while
(true)        
        {
            CodingErrorAction action = null;
            try 
            {
                result = decodeLoop(in, out);
            } //End block
            catch (BufferOverflowException ex)
            {
                CoderMalfunctionError varA8732E0EC6C2C5F2D47F2E3F6D48DE2D_2105259633 = new CoderMalfunctionError(ex);
                varA8732E0EC6C2C5F2D47F2E3F6D48DE2D_2105259633.addTaint(taint);
                throw varA8732E0EC6C2C5F2D47F2E3F6D48DE2D_2105259633;
            } //End block
            catch (BufferUnderflowException ex)
            {
                CoderMalfunctionError varA8732E0EC6C2C5F2D47F2E3F6D48DE2D_1989046424 = new CoderMalfunctionError(ex);
                varA8732E0EC6C2C5F2D47F2E3F6D48DE2D_1989046424.addTaint(taint);
                throw varA8732E0EC6C2C5F2D47F2E3F6D48DE2D_1989046424;
            } //End block
            if(result.isUnderflow())            
            {
                int remaining = in.remaining();
                status = endOfInput ? END : ONGOING;
                if(endOfInput && remaining > 0)                
                {
                    result = CoderResult.malformedForLength(remaining);
                } //End block
                else
                {
CoderResult varDC838461EE2FA0CA4C9BBB70A15456B0_372279237 =                     result;
                    varDC838461EE2FA0CA4C9BBB70A15456B0_372279237.addTaint(taint);
                    return varDC838461EE2FA0CA4C9BBB70A15456B0_372279237;
                } //End block
            } //End block
            if(result.isOverflow())            
            {
CoderResult varDC838461EE2FA0CA4C9BBB70A15456B0_960435362 =                 result;
                varDC838461EE2FA0CA4C9BBB70A15456B0_960435362.addTaint(taint);
                return varDC838461EE2FA0CA4C9BBB70A15456B0_960435362;
            } //End block
            action = malformedInputAction;
            if(result.isUnmappable())            
            {
                action = unmappableCharacterAction;
            } //End block
            if(action == CodingErrorAction.REPLACE)            
            {
                if(out.remaining() < replacementChars.length())                
                {
CoderResult varABB0206BF3597B3CDE0E8CB2CF4DF79C_1628812784 =                     CoderResult.OVERFLOW;
                    varABB0206BF3597B3CDE0E8CB2CF4DF79C_1628812784.addTaint(taint);
                    return varABB0206BF3597B3CDE0E8CB2CF4DF79C_1628812784;
                } //End block
                out.put(replacementChars);
            } //End block
            else
            {
                if(action != CodingErrorAction.IGNORE)                
                {
CoderResult varDC838461EE2FA0CA4C9BBB70A15456B0_1550925742 =                 result;
                varDC838461EE2FA0CA4C9BBB70A15456B0_1550925742.addTaint(taint);
                return varDC838461EE2FA0CA4C9BBB70A15456B0_1550925742;
                }
            } //End block
            in.position(in.position() + result.length());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract CoderResult decodeLoop(ByteBuffer in, CharBuffer out);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.523 -0400", hash_original_method = "FA8F0AC80549BCE47D29C328C4E0F049", hash_generated_method = "7BF7D90EA1B08E33D4FBC936BB0C0E3B")
    public Charset detectedCharset() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_870615231 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_870615231.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_870615231;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.524 -0400", hash_original_method = "5C3493C7F863D5F0BA88F45F364D1985", hash_generated_method = "F730F5906C8EDEC574156455F54FCDF4")
    public final CoderResult flush(CharBuffer out) {
        addTaint(out.getTaint());
        if(status != END && status != INIT)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_536765126 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_536765126.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_536765126;
        } //End block
        CoderResult result = implFlush(out);
        if(result == CoderResult.UNDERFLOW)        
        {
            status = FLUSH;
        } //End block
CoderResult varDC838461EE2FA0CA4C9BBB70A15456B0_307861078 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_307861078.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_307861078;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.524 -0400", hash_original_method = "6025E36E88B99911562F9F8AEE21E28F", hash_generated_method = "AF4690A6712A13ABDD333FA75DFD5C46")
    protected CoderResult implFlush(CharBuffer out) {
        addTaint(out.getTaint());
CoderResult var4757652C33DAD6EF5B43FF5968DA807C_1635127337 =         CoderResult.UNDERFLOW;
        var4757652C33DAD6EF5B43FF5968DA807C_1635127337.addTaint(taint);
        return var4757652C33DAD6EF5B43FF5968DA807C_1635127337;
        // ---------- Original Method ----------
        //return CoderResult.UNDERFLOW;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.524 -0400", hash_original_method = "E03D9D5B6C40FD58B1EEECF43C9BC127", hash_generated_method = "C3493E75D383B088DEBB94344366E9DE")
    protected void implOnMalformedInput(CodingErrorAction newAction) {
        addTaint(newAction.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.525 -0400", hash_original_method = "33D941D09604A3F698502AE892B2B2F1", hash_generated_method = "4B30141303236D37DE62574A267B9AF0")
    protected void implOnUnmappableCharacter(CodingErrorAction newAction) {
        addTaint(newAction.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.525 -0400", hash_original_method = "5014FF47E324504A21AF53F373310654", hash_generated_method = "0D2CAD8C717F6EA291AA5ACB527A4134")
    protected void implReplaceWith(String newReplacement) {
        addTaint(newReplacement.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.525 -0400", hash_original_method = "B1E265ECD4B779BE3343E27B901DC354", hash_generated_method = "2A58666B59F850117B41A249C7AD97D2")
    protected void implReset() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.526 -0400", hash_original_method = "0E3C677639C4DB544DC0D4E7955DC077", hash_generated_method = "BD1FDC9CE82F688D65DB4043C9891CD6")
    public boolean isAutoDetecting() {
        boolean var68934A3E9455FA72420237EB05902327_1945140265 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1303999515 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1303999515;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.526 -0400", hash_original_method = "EB764964ACE224C10D45E3B66AA00682", hash_generated_method = "27AE00374AB555FA81F3E146E95E8CB4")
    public boolean isCharsetDetected() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1890231814 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1890231814.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1890231814;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.527 -0400", hash_original_method = "14FFD5293B4145E0D4BC6D81F9598816", hash_generated_method = "C7EA1DC10037117AC1B083ACE09D1E5B")
    public CodingErrorAction malformedInputAction() {
CodingErrorAction var84571F1E1ACF9C5432CDAA5F78A66531_1350743125 =         malformedInputAction;
        var84571F1E1ACF9C5432CDAA5F78A66531_1350743125.addTaint(taint);
        return var84571F1E1ACF9C5432CDAA5F78A66531_1350743125;
        // ---------- Original Method ----------
        //return malformedInputAction;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.527 -0400", hash_original_method = "1F4ECBF7B137C80889EF1BC2E2A0CCD1", hash_generated_method = "AA6587A712BED76CCBE8C3E92C754CFD")
    public final float maxCharsPerByte() {
        float varDD42591D3D06DC7ACEDEDF2FA8238654_1406144353 = (maxCharsPerByte);
                float var546ADE640B6EDFBC8A086EF31347E768_233017436 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_233017436;
        // ---------- Original Method ----------
        //return maxCharsPerByte;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.533 -0400", hash_original_method = "34F534C82C11F1FDAA0DD59455B931CF", hash_generated_method = "AF89D66F30D2A0A7DC8860D55BBE36B4")
    public final CharsetDecoder onMalformedInput(CodingErrorAction newAction) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(newAction == null)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1330419585 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1330419585.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1330419585;
        } //End block
        malformedInputAction = newAction;
        implOnMalformedInput(newAction);
CharsetDecoder var72A74007B2BE62B849F475C7BDA4658B_1511810006 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1511810006.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1511810006;
        // ---------- Original Method ----------
        //if (newAction == null) {
            //throw new IllegalArgumentException();
        //}
        //malformedInputAction = newAction;
        //implOnMalformedInput(newAction);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.534 -0400", hash_original_method = "652123D755D0FEE6B30AA61176E436F9", hash_generated_method = "3FF5E27AFC5B1265E2699C7B046BC39A")
    public final CharsetDecoder onUnmappableCharacter(CodingErrorAction newAction) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(newAction == null)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1002147651 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1002147651.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1002147651;
        } //End block
        unmappableCharacterAction = newAction;
        implOnUnmappableCharacter(newAction);
CharsetDecoder var72A74007B2BE62B849F475C7BDA4658B_289886739 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_289886739.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_289886739;
        // ---------- Original Method ----------
        //if (newAction == null) {
            //throw new IllegalArgumentException();
        //}
        //unmappableCharacterAction = newAction;
        //implOnUnmappableCharacter(newAction);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.534 -0400", hash_original_method = "30CB7E3F60490326C9B63C38EC65670E", hash_generated_method = "C501E310C5A83D5B6D24DCD4FA43D71D")
    public final String replacement() {
String var31BB01A272C4115B7C3C56058BC775C3_867465083 =         replacementChars;
        var31BB01A272C4115B7C3C56058BC775C3_867465083.addTaint(taint);
        return var31BB01A272C4115B7C3C56058BC775C3_867465083;
        // ---------- Original Method ----------
        //return replacementChars;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.535 -0400", hash_original_method = "B18C28BF3814F00BA79DEB9A20AA9835", hash_generated_method = "34EB86A02682F0E3163C55D9A58B836A")
    public final CharsetDecoder replaceWith(String replacement) {
        if(replacement == null)        
        {
            IllegalArgumentException varDF52115D206E0F02FB9C53979C024970_658800419 = new IllegalArgumentException("replacement == null");
            varDF52115D206E0F02FB9C53979C024970_658800419.addTaint(taint);
            throw varDF52115D206E0F02FB9C53979C024970_658800419;
        } //End block
        if(replacement.isEmpty())        
        {
            IllegalArgumentException var651723D95B4E05BE8D928CCED1EA8183_1590754216 = new IllegalArgumentException("replacement.isEmpty()");
            var651723D95B4E05BE8D928CCED1EA8183_1590754216.addTaint(taint);
            throw var651723D95B4E05BE8D928CCED1EA8183_1590754216;
        } //End block
        if(replacement.length() > maxCharsPerByte())        
        {
            IllegalArgumentException var06A55291546D34F7D9BF89DFEDCD3910_159617383 = new IllegalArgumentException("replacement length > maxCharsPerByte: " +
                    replacement.length() + " > " + maxCharsPerByte());
            var06A55291546D34F7D9BF89DFEDCD3910_159617383.addTaint(taint);
            throw var06A55291546D34F7D9BF89DFEDCD3910_159617383;
        } //End block
        replacementChars = replacement;
        implReplaceWith(replacement);
CharsetDecoder var72A74007B2BE62B849F475C7BDA4658B_311310753 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_311310753.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_311310753;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.535 -0400", hash_original_method = "81D7771694F65FD718A9EEA5159D0F76", hash_generated_method = "96150E4CB3DE25A214A82B32352EF781")
    public final CharsetDecoder reset() {
        status = INIT;
        implReset();
CharsetDecoder var72A74007B2BE62B849F475C7BDA4658B_1016093126 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1016093126.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1016093126;
        // ---------- Original Method ----------
        //status = INIT;
        //implReset();
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.535 -0400", hash_original_method = "01254405DC3888434A269A87FF2AF4FB", hash_generated_method = "5090C2079D5E44D41B14EBDB619DD668")
    public CodingErrorAction unmappableCharacterAction() {
CodingErrorAction varD37AD0A7D4A43E25B855A6935DCC834A_27038414 =         unmappableCharacterAction;
        varD37AD0A7D4A43E25B855A6935DCC834A_27038414.addTaint(taint);
        return varD37AD0A7D4A43E25B855A6935DCC834A_27038414;
        // ---------- Original Method ----------
        //return unmappableCharacterAction;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.535 -0400", hash_original_field = "22C642B36ABBA5FB5FD0764AC15B85BC", hash_generated_field = "9EA234AF8E19378FF28F64776BC1B1AC")

    private static final int INIT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.536 -0400", hash_original_field = "9797141D8C8814884DC8AA4D2585CEAA", hash_generated_field = "BE844086D377CEB871B6E1DD59844EB0")

    private static final int ONGOING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.536 -0400", hash_original_field = "39A10DCE3FD12B5D178E5141CAEA7B2C", hash_generated_field = "B476F4C7146F42E47055EAC44A214B2C")

    private static final int END = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.536 -0400", hash_original_field = "95D88E1D3DF2D2D0836FCDAF6845B681", hash_generated_field = "D345F0B97A5F86F7808649FE9032B485")

    private static final int FLUSH = 3;
}

