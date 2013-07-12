package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

public class OutputStreamWriter extends Writer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.529 -0400", hash_original_field = "C68271A63DDBC431C307BEB7D2918275", hash_generated_field = "FAC7CE5410064D378AF9E7B2309C5BE9")

    private OutputStream out;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.529 -0400", hash_original_field = "724A00E315992B82D662231EA0DCBE50", hash_generated_field = "A07B3C678B690A0A298B0184B628874A")

    private CharsetEncoder encoder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.530 -0400", hash_original_field = "50E41AB3FDB67E2442AFB04B480B97A2", hash_generated_field = "A3FC74598F816F44A8E790B9843EEF7E")

    private ByteBuffer bytes = ByteBuffer.allocate(8192);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.532 -0400", hash_original_method = "8C206CCA706FC5574C37E56D894D8687", hash_generated_method = "A65923CB537A3E6CFE8AB882E44ABF1A")
    public  OutputStreamWriter(OutputStream out) {
        this(out, Charset.defaultCharset());
        addTaint(out.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.534 -0400", hash_original_method = "FE2D64915F756E150E2359224C906A4F", hash_generated_method = "0D370A774E199EED9425A8CAB6C55BD8")
    public  OutputStreamWriter(OutputStream out, final String enc) throws UnsupportedEncodingException {
        super(out);
    if(enc == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1841103583 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1841103583.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1841103583;
        } 
        this.out = out;
        try 
        {
            encoder = Charset.forName(enc).newEncoder();
        } 
        catch (Exception e)
        {
            UnsupportedEncodingException var397991C29CD3376A5C5B3BD1C2DA8637_2110927722 = new UnsupportedEncodingException(enc);
            var397991C29CD3376A5C5B3BD1C2DA8637_2110927722.addTaint(taint);
            throw var397991C29CD3376A5C5B3BD1C2DA8637_2110927722;
        } 
        encoder.onMalformedInput(CodingErrorAction.REPLACE);
        encoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
        
        
            
        
        
        
            
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.535 -0400", hash_original_method = "8F31DE887FC24410EE09434FBA44CA21", hash_generated_method = "B1E3E8C23C37F25FE6C0A3EDCFDF5EE6")
    public  OutputStreamWriter(OutputStream out, Charset cs) {
        super(out);
        this.out = out;
        encoder = cs.newEncoder();
        encoder.onMalformedInput(CodingErrorAction.REPLACE);
        encoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.536 -0400", hash_original_method = "C5AFC76AE8F04EED9C657E07A65429EA", hash_generated_method = "626EF98BAB75BECB16EB0021472230A0")
    public  OutputStreamWriter(OutputStream out, CharsetEncoder enc) {
        super(out);
        enc.charset();
        this.out = out;
        encoder = enc;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.537 -0400", hash_original_method = "348EDF61477AE4A3DCAC4870D899F874", hash_generated_method = "9BB6B78E0078247D5B602E80254488F7")
    @Override
    public void close() throws IOException {
        synchronized
(lock)        {
    if(encoder != null)            
            {
                drainEncoder();
                flushBytes(false);
                out.close();
                encoder = null;
                bytes = null;
            } 
        } 
        
        
            
                
                
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.538 -0400", hash_original_method = "E89503CD667F6DF7A02E3D218DF666E8", hash_generated_method = "27D5E48695D4DA71C3C79EED49114041")
    @Override
    public void flush() throws IOException {
        flushBytes(true);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.538 -0400", hash_original_method = "0B376EED04C0EE48C2109F7445B1F9FC", hash_generated_method = "9B8F3591AAECFA2B0C088EDC2C48457E")
    private void flushBytes(boolean flushUnderlyingStream) throws IOException {
        addTaint(flushUnderlyingStream);
        synchronized
(lock)        {
            checkStatus();
            int position = bytes.position();
    if(position > 0)            
            {
                bytes.flip();
                out.write(bytes.array(), bytes.arrayOffset(), position);
                bytes.clear();
            } 
    if(flushUnderlyingStream)            
            {
                out.flush();
            } 
        } 
        
        
            
            
            
                
                
                
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.539 -0400", hash_original_method = "5FDBBBBEF70B98878F7238A71245F3A5", hash_generated_method = "43E7C827D181E1D6E169D5039562AB44")
    private void convert(CharBuffer chars) throws IOException {
        addTaint(chars.getTaint());
        while
(true)        
        {
            CoderResult result = encoder.encode(chars, bytes, false);
    if(result.isOverflow())            
            {
                flushBytes(false);
                continue;
            } 
            else
    if(result.isError())            
            {
                result.throwException();
            } 
            break;
        } 
        
        
            
            
                
                
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.540 -0400", hash_original_method = "17AF81F5CD218F57FFE1053C07491E0D", hash_generated_method = "D789BA1EA2F1AEFA7AD2BA6661A8D5B2")
    private void drainEncoder() throws IOException {
        CharBuffer chars = CharBuffer.allocate(0);
        while
(true)        
        {
            CoderResult result = encoder.encode(chars, bytes, true);
    if(result.isError())            
            {
                result.throwException();
            } 
            else
    if(result.isOverflow())            
            {
                flushBytes(false);
                continue;
            } 
            break;
        } 
        CoderResult result = encoder.flush(bytes);
        while
(!result.isUnderflow())        
        {
    if(result.isOverflow())            
            {
                flushBytes(false);
                result = encoder.flush(bytes);
            } 
            else
            {
                result.throwException();
            } 
        } 
        
        
        
            
            
                
            
                
                
            
            
        
        
        
            
                
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.541 -0400", hash_original_method = "75BDF3BC8D58179DECD9AB14C1C7F3EE", hash_generated_method = "95F8A461CAC3C6AEEC5801370AF4208F")
    private void checkStatus() throws IOException {
    if(encoder == null)        
        {
            IOException var93A2469A2C365C12CFE77B4A013993F3_1247704282 = new IOException("OutputStreamWriter is closed");
            var93A2469A2C365C12CFE77B4A013993F3_1247704282.addTaint(taint);
            throw var93A2469A2C365C12CFE77B4A013993F3_1247704282;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.542 -0400", hash_original_method = "A69A1F1EB2BFDD0474AAD9460630967D", hash_generated_method = "5EF8631688B3D395D16230D44FAB80BF")
    public String getEncoding() {
    if(encoder == null)        
        {
String var540C13E9E156B687226421B24F2DF178_2120575749 =             null;
            var540C13E9E156B687226421B24F2DF178_2120575749.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2120575749;
        } 
String var4A583A09AA1C94B97CFEDE3A84E886D4_1928902582 =         HistoricalCharsetNames.get(encoder.charset());
        var4A583A09AA1C94B97CFEDE3A84E886D4_1928902582.addTaint(taint);
        return var4A583A09AA1C94B97CFEDE3A84E886D4_1928902582;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.542 -0400", hash_original_method = "A1014AE81A36DB02C830992F3B254644", hash_generated_method = "E11BE7F2D0470029EFFE44EFB15AEC03")
    @Override
    public void write(char[] buffer, int offset, int count) throws IOException {
        addTaint(count);
        addTaint(offset);
        addTaint(buffer[0]);
        synchronized
(lock)        {
            checkStatus();
            Arrays.checkOffsetAndCount(buffer.length, offset, count);
            CharBuffer chars = CharBuffer.wrap(buffer, offset, count);
            convert(chars);
        } 
        
        
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.543 -0400", hash_original_method = "9F78C67C90A8F7A084F2E3084DB157FE", hash_generated_method = "BE6B916A0A42986838300D21100AB7C7")
    @Override
    public void write(int oneChar) throws IOException {
        addTaint(oneChar);
        synchronized
(lock)        {
            checkStatus();
            CharBuffer chars = CharBuffer.wrap(new char[] { (char) oneChar });
            convert(chars);
        } 
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.544 -0400", hash_original_method = "720362548945B36884470AD2C6B99C23", hash_generated_method = "B3946429A90B7BD59EC0CA2ED8271A7F")
    @Override
    public void write(String str, int offset, int count) throws IOException {
        addTaint(count);
        addTaint(offset);
        addTaint(str.getTaint());
        synchronized
(lock)        {
    if(count < 0)            
            {
                StringIndexOutOfBoundsException varDD6466A465572C8C2EC4C6C733FC9AF8_1771335282 = new StringIndexOutOfBoundsException(str, offset, count);
                varDD6466A465572C8C2EC4C6C733FC9AF8_1771335282.addTaint(taint);
                throw varDD6466A465572C8C2EC4C6C733FC9AF8_1771335282;
            } 
    if(str == null)            
            {
                NullPointerException varBAAB5D2ADD4C016ACB92A2133697155C_158189080 = new NullPointerException("str == null");
                varBAAB5D2ADD4C016ACB92A2133697155C_158189080.addTaint(taint);
                throw varBAAB5D2ADD4C016ACB92A2133697155C_158189080;
            } 
    if((offset | count) < 0 || offset > str.length() - count)            
            {
                StringIndexOutOfBoundsException varDD6466A465572C8C2EC4C6C733FC9AF8_1652843454 = new StringIndexOutOfBoundsException(str, offset, count);
                varDD6466A465572C8C2EC4C6C733FC9AF8_1652843454.addTaint(taint);
                throw varDD6466A465572C8C2EC4C6C733FC9AF8_1652843454;
            } 
            checkStatus();
            CharBuffer chars = CharBuffer.wrap(str, offset, count + offset);
            convert(chars);
        } 
        
        
            
                
            
            
                
            
            
                
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.545 -0400", hash_original_method = "E279B5931B3E4ADEA2A691FE75B2536D", hash_generated_method = "D0B8D2B4D8E8C742C374A68C3F8A6223")
    @Override
     boolean checkError() {
        boolean var07ACD71AC6574277636F8AF67D4AA28C_596474924 = (out.checkError());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1059742399 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1059742399;
        
        
    }

    
}

