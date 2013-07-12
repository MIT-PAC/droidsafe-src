package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public abstract class CharsetDecoder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.777 -0400", hash_original_field = "61628476CEFEE98E133C4A262D6104E7", hash_generated_field = "529EF1EB47EC503C08AD8590AE0F62F5")

    private float averageCharsPerByte;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.777 -0400", hash_original_field = "DD42591D3D06DC7ACEDEDF2FA8238654", hash_generated_field = "2DF37DC2E87CE8D294B5CF2F013FD634")

    private float maxCharsPerByte;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.777 -0400", hash_original_field = "95CC64DD2825F9DF13EC4AD683ECF339", hash_generated_field = "220BF257D2CCF23A35C6D1D35FB3F79C")

    private Charset cs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.777 -0400", hash_original_field = "E353C4A606D3E48C9BBB36EADD713EA4", hash_generated_field = "1214F64762553AD2B0BE51AAC36B64DE")

    private CodingErrorAction malformedInputAction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.777 -0400", hash_original_field = "F84ECDA294965F5911ABAE3B9702960C", hash_generated_field = "60F320659477DF0A50B0661AEB74E53F")

    private CodingErrorAction unmappableCharacterAction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.777 -0400", hash_original_field = "AC19AB15816945D4560ACC390132433E", hash_generated_field = "4FB9354D4FC1B3B8FECFC231454ED4BC")

    private String replacementChars;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.777 -0400", hash_original_field = "9ACB44549B41563697BB490144EC6258", hash_generated_field = "4BAC49709EDEAEFDD9E07400E0F02406")

    private int status;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.778 -0400", hash_original_method = "8CF9EF6BF1CF308B9A895B171C1AF9B5", hash_generated_method = "877EAF724640DF83D3CDFF04947ABF87")
    protected  CharsetDecoder(Charset charset, float averageCharsPerByte, float maxCharsPerByte) {
    if(averageCharsPerByte <= 0 || maxCharsPerByte <= 0)        
        {
            IllegalArgumentException varEB58E99F5BFBD8586DE8E992B2ED6DA7_1564674436 = new IllegalArgumentException("averageCharsPerByte and maxCharsPerByte must be positive");
            varEB58E99F5BFBD8586DE8E992B2ED6DA7_1564674436.addTaint(taint);
            throw varEB58E99F5BFBD8586DE8E992B2ED6DA7_1564674436;
        } //End block
    if(averageCharsPerByte > maxCharsPerByte)        
        {
            IllegalArgumentException var84C0C01131D068485D81563C07CC4F54_1281698457 = new IllegalArgumentException("averageCharsPerByte is greater than maxCharsPerByte");
            var84C0C01131D068485D81563C07CC4F54_1281698457.addTaint(taint);
            throw var84C0C01131D068485D81563C07CC4F54_1281698457;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.779 -0400", hash_original_method = "835453458CD254EFEDF140BA3E3A0055", hash_generated_method = "63F9CC05D429F1ED0A02BE03D5D9BA26")
    public final float averageCharsPerByte() {
        float var61628476CEFEE98E133C4A262D6104E7_405488680 = (averageCharsPerByte);
                float var546ADE640B6EDFBC8A086EF31347E768_905907766 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_905907766;
        // ---------- Original Method ----------
        //return averageCharsPerByte;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.779 -0400", hash_original_method = "B98730A31745049759B27FC27542555A", hash_generated_method = "780EA25C74E25084B030157DA11D61A7")
    public final Charset charset() {
Charset varE661418CFE0D2CECDB5DF6FE0739403D_942765588 =         cs;
        varE661418CFE0D2CECDB5DF6FE0739403D_942765588.addTaint(taint);
        return varE661418CFE0D2CECDB5DF6FE0739403D_942765588;
        // ---------- Original Method ----------
        //return cs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.780 -0400", hash_original_method = "0575B5D8A4FDBA875B2771D84C02D5E1", hash_generated_method = "11CC8920FE33F3A8C869E326DD219C6C")
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
CharBuffer varEB0B99CD62B23D2DD9E149CA2A9860B9_1241640566 =         output;
        varEB0B99CD62B23D2DD9E149CA2A9860B9_1241640566.addTaint(taint);
        return varEB0B99CD62B23D2DD9E149CA2A9860B9_1241640566;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.781 -0400", hash_original_method = "297219195E5B4473685A201861AC1DC3", hash_generated_method = "5382CEB9C26A7EB2E31F941492E2493A")
    private void checkCoderResult(CoderResult result) throws CharacterCodingException {
        addTaint(result.getTaint());
    if(result.isMalformed() && malformedInputAction == CodingErrorAction.REPORT)        
        {
            MalformedInputException var8FA4E56DDF9AB0C4EE65F8C493EF8A64_792715289 = new MalformedInputException(result.length());
            var8FA4E56DDF9AB0C4EE65F8C493EF8A64_792715289.addTaint(taint);
            throw var8FA4E56DDF9AB0C4EE65F8C493EF8A64_792715289;
        } //End block
        else
    if(result.isUnmappable() && unmappableCharacterAction == CodingErrorAction.REPORT)        
        {
            UnmappableCharacterException var6421AD8EFB043FAF5135AEE922347817_882718856 = new UnmappableCharacterException(result.length());
            var6421AD8EFB043FAF5135AEE922347817_882718856.addTaint(taint);
            throw var6421AD8EFB043FAF5135AEE922347817_882718856;
        } //End block
        // ---------- Original Method ----------
        //if (result.isMalformed() && malformedInputAction == CodingErrorAction.REPORT) {
            //throw new MalformedInputException(result.length());
        //} else if (result.isUnmappable() && unmappableCharacterAction == CodingErrorAction.REPORT) {
            //throw new UnmappableCharacterException(result.length());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.781 -0400", hash_original_method = "D4DFBF2849FE3731857D4FDEE2ED4787", hash_generated_method = "3166C9EB29BBBF848F6CB59980263618")
    private CharBuffer allocateMore(CharBuffer output) {
        addTaint(output.getTaint());
    if(output.capacity() == 0)        
        {
CharBuffer var5CF2BCC8491086EA62744A71E10FF335_521234383 =             CharBuffer.allocate(1);
            var5CF2BCC8491086EA62744A71E10FF335_521234383.addTaint(taint);
            return var5CF2BCC8491086EA62744A71E10FF335_521234383;
        } //End block
        CharBuffer result = CharBuffer.allocate(output.capacity() * 2);
        output.flip();
        result.put(output);
CharBuffer varDC838461EE2FA0CA4C9BBB70A15456B0_1585836894 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1585836894.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1585836894;
        // ---------- Original Method ----------
        //if (output.capacity() == 0) {
            //return CharBuffer.allocate(1);
        //}
        //CharBuffer result = CharBuffer.allocate(output.capacity() * 2);
        //output.flip();
        //result.put(output);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.783 -0400", hash_original_method = "40037F62CA1EB410AEAF236C6BDF7EBA", hash_generated_method = "F890FED7B3DFD01142DA43FCBA1642D8")
    public final CoderResult decode(ByteBuffer in, CharBuffer out,
            boolean endOfInput) {
        addTaint(out.getTaint());
        addTaint(in.getTaint());
    if((status == FLUSH) || (!endOfInput && status == END))        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_989287763 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_989287763.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_989287763;
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
                CoderMalfunctionError varA8732E0EC6C2C5F2D47F2E3F6D48DE2D_1387513256 = new CoderMalfunctionError(ex);
                varA8732E0EC6C2C5F2D47F2E3F6D48DE2D_1387513256.addTaint(taint);
                throw varA8732E0EC6C2C5F2D47F2E3F6D48DE2D_1387513256;
            } //End block
            catch (BufferUnderflowException ex)
            {
                CoderMalfunctionError varA8732E0EC6C2C5F2D47F2E3F6D48DE2D_1461138324 = new CoderMalfunctionError(ex);
                varA8732E0EC6C2C5F2D47F2E3F6D48DE2D_1461138324.addTaint(taint);
                throw varA8732E0EC6C2C5F2D47F2E3F6D48DE2D_1461138324;
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
CoderResult varDC838461EE2FA0CA4C9BBB70A15456B0_433512218 =                     result;
                    varDC838461EE2FA0CA4C9BBB70A15456B0_433512218.addTaint(taint);
                    return varDC838461EE2FA0CA4C9BBB70A15456B0_433512218;
                } //End block
            } //End block
    if(result.isOverflow())            
            {
CoderResult varDC838461EE2FA0CA4C9BBB70A15456B0_582040377 =                 result;
                varDC838461EE2FA0CA4C9BBB70A15456B0_582040377.addTaint(taint);
                return varDC838461EE2FA0CA4C9BBB70A15456B0_582040377;
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
CoderResult varABB0206BF3597B3CDE0E8CB2CF4DF79C_524889789 =                     CoderResult.OVERFLOW;
                    varABB0206BF3597B3CDE0E8CB2CF4DF79C_524889789.addTaint(taint);
                    return varABB0206BF3597B3CDE0E8CB2CF4DF79C_524889789;
                } //End block
                out.put(replacementChars);
            } //End block
            else
            {
    if(action != CodingErrorAction.IGNORE)                
                {
CoderResult varDC838461EE2FA0CA4C9BBB70A15456B0_1905312125 =                 result;
                varDC838461EE2FA0CA4C9BBB70A15456B0_1905312125.addTaint(taint);
                return varDC838461EE2FA0CA4C9BBB70A15456B0_1905312125;
                }
            } //End block
            in.position(in.position() + result.length());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    protected abstract CoderResult decodeLoop(ByteBuffer in, CharBuffer out);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.784 -0400", hash_original_method = "FA8F0AC80549BCE47D29C328C4E0F049", hash_generated_method = "599A49EC93FDD4551386ABC505264FEC")
    public Charset detectedCharset() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_2097269824 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_2097269824.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_2097269824;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.784 -0400", hash_original_method = "5C3493C7F863D5F0BA88F45F364D1985", hash_generated_method = "CDA098EE87DA8F6730051B63428091B4")
    public final CoderResult flush(CharBuffer out) {
        addTaint(out.getTaint());
    if(status != END && status != INIT)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_657142186 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_657142186.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_657142186;
        } //End block
        CoderResult result = implFlush(out);
    if(result == CoderResult.UNDERFLOW)        
        {
            status = FLUSH;
        } //End block
CoderResult varDC838461EE2FA0CA4C9BBB70A15456B0_2028543262 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_2028543262.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_2028543262;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.785 -0400", hash_original_method = "6025E36E88B99911562F9F8AEE21E28F", hash_generated_method = "1B479806F416E0603DC9AB83F51A31D7")
    protected CoderResult implFlush(CharBuffer out) {
        addTaint(out.getTaint());
CoderResult var4757652C33DAD6EF5B43FF5968DA807C_2033257046 =         CoderResult.UNDERFLOW;
        var4757652C33DAD6EF5B43FF5968DA807C_2033257046.addTaint(taint);
        return var4757652C33DAD6EF5B43FF5968DA807C_2033257046;
        // ---------- Original Method ----------
        //return CoderResult.UNDERFLOW;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.785 -0400", hash_original_method = "E03D9D5B6C40FD58B1EEECF43C9BC127", hash_generated_method = "C3493E75D383B088DEBB94344366E9DE")
    protected void implOnMalformedInput(CodingErrorAction newAction) {
        addTaint(newAction.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.785 -0400", hash_original_method = "33D941D09604A3F698502AE892B2B2F1", hash_generated_method = "4B30141303236D37DE62574A267B9AF0")
    protected void implOnUnmappableCharacter(CodingErrorAction newAction) {
        addTaint(newAction.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.786 -0400", hash_original_method = "5014FF47E324504A21AF53F373310654", hash_generated_method = "0D2CAD8C717F6EA291AA5ACB527A4134")
    protected void implReplaceWith(String newReplacement) {
        addTaint(newReplacement.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.786 -0400", hash_original_method = "B1E265ECD4B779BE3343E27B901DC354", hash_generated_method = "2A58666B59F850117B41A249C7AD97D2")
    protected void implReset() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.786 -0400", hash_original_method = "0E3C677639C4DB544DC0D4E7955DC077", hash_generated_method = "5D2301474909A094AF38C88C972173FC")
    public boolean isAutoDetecting() {
        boolean var68934A3E9455FA72420237EB05902327_1289911725 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1668325884 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1668325884;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.786 -0400", hash_original_method = "EB764964ACE224C10D45E3B66AA00682", hash_generated_method = "E98A2C23C14F72067E4807D37D06B425")
    public boolean isCharsetDetected() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1645426662 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1645426662.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1645426662;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.787 -0400", hash_original_method = "14FFD5293B4145E0D4BC6D81F9598816", hash_generated_method = "65B6B17181F014549C6FAA388C446F28")
    public CodingErrorAction malformedInputAction() {
CodingErrorAction var84571F1E1ACF9C5432CDAA5F78A66531_1956697154 =         malformedInputAction;
        var84571F1E1ACF9C5432CDAA5F78A66531_1956697154.addTaint(taint);
        return var84571F1E1ACF9C5432CDAA5F78A66531_1956697154;
        // ---------- Original Method ----------
        //return malformedInputAction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.787 -0400", hash_original_method = "1F4ECBF7B137C80889EF1BC2E2A0CCD1", hash_generated_method = "2299C6D201237C0E1877F1C211A42513")
    public final float maxCharsPerByte() {
        float varDD42591D3D06DC7ACEDEDF2FA8238654_1281407422 = (maxCharsPerByte);
                float var546ADE640B6EDFBC8A086EF31347E768_972082003 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_972082003;
        // ---------- Original Method ----------
        //return maxCharsPerByte;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.788 -0400", hash_original_method = "34F534C82C11F1FDAA0DD59455B931CF", hash_generated_method = "164FC29038A9F3FC759B2FF22F32DEE1")
    public final CharsetDecoder onMalformedInput(CodingErrorAction newAction) {
        //DSFIXME:  CODE0009: Possible callback target function detected
    if(newAction == null)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1082838716 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1082838716.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1082838716;
        } //End block
        malformedInputAction = newAction;
        implOnMalformedInput(newAction);
CharsetDecoder var72A74007B2BE62B849F475C7BDA4658B_427367384 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_427367384.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_427367384;
        // ---------- Original Method ----------
        //if (newAction == null) {
            //throw new IllegalArgumentException();
        //}
        //malformedInputAction = newAction;
        //implOnMalformedInput(newAction);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.788 -0400", hash_original_method = "652123D755D0FEE6B30AA61176E436F9", hash_generated_method = "622BE680EF00B7B564E61F410931306A")
    public final CharsetDecoder onUnmappableCharacter(CodingErrorAction newAction) {
        //DSFIXME:  CODE0009: Possible callback target function detected
    if(newAction == null)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_31177158 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_31177158.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_31177158;
        } //End block
        unmappableCharacterAction = newAction;
        implOnUnmappableCharacter(newAction);
CharsetDecoder var72A74007B2BE62B849F475C7BDA4658B_1185467233 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1185467233.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1185467233;
        // ---------- Original Method ----------
        //if (newAction == null) {
            //throw new IllegalArgumentException();
        //}
        //unmappableCharacterAction = newAction;
        //implOnUnmappableCharacter(newAction);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.789 -0400", hash_original_method = "30CB7E3F60490326C9B63C38EC65670E", hash_generated_method = "F1C912CA8B0CE625535FF86C94373A49")
    public final String replacement() {
String var31BB01A272C4115B7C3C56058BC775C3_2046074623 =         replacementChars;
        var31BB01A272C4115B7C3C56058BC775C3_2046074623.addTaint(taint);
        return var31BB01A272C4115B7C3C56058BC775C3_2046074623;
        // ---------- Original Method ----------
        //return replacementChars;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.789 -0400", hash_original_method = "B18C28BF3814F00BA79DEB9A20AA9835", hash_generated_method = "ED651010E98D6DD530B98F4A81483BD0")
    public final CharsetDecoder replaceWith(String replacement) {
    if(replacement == null)        
        {
            IllegalArgumentException varDF52115D206E0F02FB9C53979C024970_330473995 = new IllegalArgumentException("replacement == null");
            varDF52115D206E0F02FB9C53979C024970_330473995.addTaint(taint);
            throw varDF52115D206E0F02FB9C53979C024970_330473995;
        } //End block
    if(replacement.isEmpty())        
        {
            IllegalArgumentException var651723D95B4E05BE8D928CCED1EA8183_306923403 = new IllegalArgumentException("replacement.isEmpty()");
            var651723D95B4E05BE8D928CCED1EA8183_306923403.addTaint(taint);
            throw var651723D95B4E05BE8D928CCED1EA8183_306923403;
        } //End block
    if(replacement.length() > maxCharsPerByte())        
        {
            IllegalArgumentException var06A55291546D34F7D9BF89DFEDCD3910_523310540 = new IllegalArgumentException("replacement length > maxCharsPerByte: " +
                    replacement.length() + " > " + maxCharsPerByte());
            var06A55291546D34F7D9BF89DFEDCD3910_523310540.addTaint(taint);
            throw var06A55291546D34F7D9BF89DFEDCD3910_523310540;
        } //End block
        replacementChars = replacement;
        implReplaceWith(replacement);
CharsetDecoder var72A74007B2BE62B849F475C7BDA4658B_1272548500 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1272548500.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1272548500;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.790 -0400", hash_original_method = "81D7771694F65FD718A9EEA5159D0F76", hash_generated_method = "416CA4B98112AD1CDDD9B8C6A7C337F0")
    public final CharsetDecoder reset() {
        status = INIT;
        implReset();
CharsetDecoder var72A74007B2BE62B849F475C7BDA4658B_1627698727 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1627698727.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1627698727;
        // ---------- Original Method ----------
        //status = INIT;
        //implReset();
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.790 -0400", hash_original_method = "01254405DC3888434A269A87FF2AF4FB", hash_generated_method = "C1EA1208E739165121078AA1701BF237")
    public CodingErrorAction unmappableCharacterAction() {
CodingErrorAction varD37AD0A7D4A43E25B855A6935DCC834A_422207410 =         unmappableCharacterAction;
        varD37AD0A7D4A43E25B855A6935DCC834A_422207410.addTaint(taint);
        return varD37AD0A7D4A43E25B855A6935DCC834A_422207410;
        // ---------- Original Method ----------
        //return unmappableCharacterAction;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.790 -0400", hash_original_field = "22C642B36ABBA5FB5FD0764AC15B85BC", hash_generated_field = "9EA234AF8E19378FF28F64776BC1B1AC")

    private static final int INIT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.790 -0400", hash_original_field = "9797141D8C8814884DC8AA4D2585CEAA", hash_generated_field = "BE844086D377CEB871B6E1DD59844EB0")

    private static final int ONGOING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.791 -0400", hash_original_field = "39A10DCE3FD12B5D178E5141CAEA7B2C", hash_generated_field = "B476F4C7146F42E47055EAC44A214B2C")

    private static final int END = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.791 -0400", hash_original_field = "95D88E1D3DF2D2D0836FCDAF6845B681", hash_generated_field = "D345F0B97A5F86F7808649FE9032B485")

    private static final int FLUSH = 3;
}

