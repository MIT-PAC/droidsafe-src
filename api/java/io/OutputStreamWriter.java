package java.io;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.107 -0400", hash_original_field = "C68271A63DDBC431C307BEB7D2918275", hash_generated_field = "FAC7CE5410064D378AF9E7B2309C5BE9")

    private OutputStream out;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.107 -0400", hash_original_field = "724A00E315992B82D662231EA0DCBE50", hash_generated_field = "A07B3C678B690A0A298B0184B628874A")

    private CharsetEncoder encoder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.107 -0400", hash_original_field = "50E41AB3FDB67E2442AFB04B480B97A2", hash_generated_field = "A3FC74598F816F44A8E790B9843EEF7E")

    private ByteBuffer bytes = ByteBuffer.allocate(8192);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.107 -0400", hash_original_method = "8C206CCA706FC5574C37E56D894D8687", hash_generated_method = "A65923CB537A3E6CFE8AB882E44ABF1A")
    public  OutputStreamWriter(OutputStream out) {
        this(out, Charset.defaultCharset());
        addTaint(out.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.109 -0400", hash_original_method = "FE2D64915F756E150E2359224C906A4F", hash_generated_method = "63D2923CE9B7F28B13D73EC2B8780F28")
    public  OutputStreamWriter(OutputStream out, final String enc) throws UnsupportedEncodingException {
        super(out);
        if(enc == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_511506548 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_511506548.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_511506548;
        } //End block
        this.out = out;
        try 
        {
            encoder = Charset.forName(enc).newEncoder();
        } //End block
        catch (Exception e)
        {
            UnsupportedEncodingException var397991C29CD3376A5C5B3BD1C2DA8637_702128069 = new UnsupportedEncodingException(enc);
            var397991C29CD3376A5C5B3BD1C2DA8637_702128069.addTaint(taint);
            throw var397991C29CD3376A5C5B3BD1C2DA8637_702128069;
        } //End block
        encoder.onMalformedInput(CodingErrorAction.REPLACE);
        encoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
        // ---------- Original Method ----------
        //if (enc == null) {
            //throw new NullPointerException();
        //}
        //this.out = out;
        //try {
            //encoder = Charset.forName(enc).newEncoder();
        //} catch (Exception e) {
            //throw new UnsupportedEncodingException(enc);
        //}
        //encoder.onMalformedInput(CodingErrorAction.REPLACE);
        //encoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.110 -0400", hash_original_method = "8F31DE887FC24410EE09434FBA44CA21", hash_generated_method = "B1E3E8C23C37F25FE6C0A3EDCFDF5EE6")
    public  OutputStreamWriter(OutputStream out, Charset cs) {
        super(out);
        this.out = out;
        encoder = cs.newEncoder();
        encoder.onMalformedInput(CodingErrorAction.REPLACE);
        encoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
        // ---------- Original Method ----------
        //this.out = out;
        //encoder = cs.newEncoder();
        //encoder.onMalformedInput(CodingErrorAction.REPLACE);
        //encoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.111 -0400", hash_original_method = "C5AFC76AE8F04EED9C657E07A65429EA", hash_generated_method = "626EF98BAB75BECB16EB0021472230A0")
    public  OutputStreamWriter(OutputStream out, CharsetEncoder enc) {
        super(out);
        enc.charset();
        this.out = out;
        encoder = enc;
        // ---------- Original Method ----------
        //enc.charset();
        //this.out = out;
        //encoder = enc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.111 -0400", hash_original_method = "348EDF61477AE4A3DCAC4870D899F874", hash_generated_method = "9BB6B78E0078247D5B602E80254488F7")
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
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //if (encoder != null) {
                //drainEncoder();
                //flushBytes(false);
                //out.close();
                //encoder = null;
                //bytes = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.112 -0400", hash_original_method = "E89503CD667F6DF7A02E3D218DF666E8", hash_generated_method = "27D5E48695D4DA71C3C79EED49114041")
    @Override
    public void flush() throws IOException {
        flushBytes(true);
        // ---------- Original Method ----------
        //flushBytes(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.112 -0400", hash_original_method = "0B376EED04C0EE48C2109F7445B1F9FC", hash_generated_method = "9B8F3591AAECFA2B0C088EDC2C48457E")
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
            } //End block
            if(flushUnderlyingStream)            
            {
                out.flush();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkStatus();
            //int position = bytes.position();
            //if (position > 0) {
                //bytes.flip();
                //out.write(bytes.array(), bytes.arrayOffset(), position);
                //bytes.clear();
            //}
            //if (flushUnderlyingStream) {
                //out.flush();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.113 -0400", hash_original_method = "5FDBBBBEF70B98878F7238A71245F3A5", hash_generated_method = "43E7C827D181E1D6E169D5039562AB44")
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
            } //End block
            else
            if(result.isError())            
            {
                result.throwException();
            } //End block
            break;
        } //End block
        // ---------- Original Method ----------
        //while (true) {
            //CoderResult result = encoder.encode(chars, bytes, false);
            //if (result.isOverflow()) {
                //flushBytes(false);
                //continue;
            //} else if (result.isError()) {
                //result.throwException();
            //}
            //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.115 -0400", hash_original_method = "17AF81F5CD218F57FFE1053C07491E0D", hash_generated_method = "D789BA1EA2F1AEFA7AD2BA6661A8D5B2")
    private void drainEncoder() throws IOException {
        CharBuffer chars = CharBuffer.allocate(0);
        while
(true)        
        {
            CoderResult result = encoder.encode(chars, bytes, true);
            if(result.isError())            
            {
                result.throwException();
            } //End block
            else
            if(result.isOverflow())            
            {
                flushBytes(false);
                continue;
            } //End block
            break;
        } //End block
        CoderResult result = encoder.flush(bytes);
        while
(!result.isUnderflow())        
        {
            if(result.isOverflow())            
            {
                flushBytes(false);
                result = encoder.flush(bytes);
            } //End block
            else
            {
                result.throwException();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //CharBuffer chars = CharBuffer.allocate(0);
        //while (true) {
            //CoderResult result = encoder.encode(chars, bytes, true);
            //if (result.isError()) {
                //result.throwException();
            //} else if (result.isOverflow()) {
                //flushBytes(false);
                //continue;
            //}
            //break;
        //}
        //CoderResult result = encoder.flush(bytes);
        //while (!result.isUnderflow()) {
            //if (result.isOverflow()) {
                //flushBytes(false);
                //result = encoder.flush(bytes);
            //} else {
                //result.throwException();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.116 -0400", hash_original_method = "75BDF3BC8D58179DECD9AB14C1C7F3EE", hash_generated_method = "E2652E8AED0EF44CFD1E8F419F72C9C6")
    private void checkStatus() throws IOException {
        if(encoder == null)        
        {
            IOException var93A2469A2C365C12CFE77B4A013993F3_118862908 = new IOException("OutputStreamWriter is closed");
            var93A2469A2C365C12CFE77B4A013993F3_118862908.addTaint(taint);
            throw var93A2469A2C365C12CFE77B4A013993F3_118862908;
        } //End block
        // ---------- Original Method ----------
        //if (encoder == null) {
            //throw new IOException("OutputStreamWriter is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.116 -0400", hash_original_method = "A69A1F1EB2BFDD0474AAD9460630967D", hash_generated_method = "A9D9F06ACF866CB1767FD599B418D922")
    public String getEncoding() {
        if(encoder == null)        
        {
String var540C13E9E156B687226421B24F2DF178_110987764 =             null;
            var540C13E9E156B687226421B24F2DF178_110987764.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_110987764;
        } //End block
String var4A583A09AA1C94B97CFEDE3A84E886D4_2117172348 =         HistoricalCharsetNames.get(encoder.charset());
        var4A583A09AA1C94B97CFEDE3A84E886D4_2117172348.addTaint(taint);
        return var4A583A09AA1C94B97CFEDE3A84E886D4_2117172348;
        // ---------- Original Method ----------
        //if (encoder == null) {
            //return null;
        //}
        //return HistoricalCharsetNames.get(encoder.charset());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.117 -0400", hash_original_method = "A1014AE81A36DB02C830992F3B254644", hash_generated_method = "E11BE7F2D0470029EFFE44EFB15AEC03")
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
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkStatus();
            //Arrays.checkOffsetAndCount(buffer.length, offset, count);
            //CharBuffer chars = CharBuffer.wrap(buffer, offset, count);
            //convert(chars);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.117 -0400", hash_original_method = "9F78C67C90A8F7A084F2E3084DB157FE", hash_generated_method = "BE6B916A0A42986838300D21100AB7C7")
    @Override
    public void write(int oneChar) throws IOException {
        addTaint(oneChar);
        synchronized
(lock)        {
            checkStatus();
            CharBuffer chars = CharBuffer.wrap(new char[] { (char) oneChar });
            convert(chars);
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkStatus();
            //CharBuffer chars = CharBuffer.wrap(new char[] { (char) oneChar });
            //convert(chars);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.118 -0400", hash_original_method = "720362548945B36884470AD2C6B99C23", hash_generated_method = "7D84CD7B853928DE4C859B2F858FF82F")
    @Override
    public void write(String str, int offset, int count) throws IOException {
        addTaint(count);
        addTaint(offset);
        addTaint(str.getTaint());
        synchronized
(lock)        {
            if(count < 0)            
            {
                StringIndexOutOfBoundsException varDD6466A465572C8C2EC4C6C733FC9AF8_224943350 = new StringIndexOutOfBoundsException(str, offset, count);
                varDD6466A465572C8C2EC4C6C733FC9AF8_224943350.addTaint(taint);
                throw varDD6466A465572C8C2EC4C6C733FC9AF8_224943350;
            } //End block
            if(str == null)            
            {
                NullPointerException varBAAB5D2ADD4C016ACB92A2133697155C_569397328 = new NullPointerException("str == null");
                varBAAB5D2ADD4C016ACB92A2133697155C_569397328.addTaint(taint);
                throw varBAAB5D2ADD4C016ACB92A2133697155C_569397328;
            } //End block
            if((offset | count) < 0 || offset > str.length() - count)            
            {
                StringIndexOutOfBoundsException varDD6466A465572C8C2EC4C6C733FC9AF8_549098079 = new StringIndexOutOfBoundsException(str, offset, count);
                varDD6466A465572C8C2EC4C6C733FC9AF8_549098079.addTaint(taint);
                throw varDD6466A465572C8C2EC4C6C733FC9AF8_549098079;
            } //End block
            checkStatus();
            CharBuffer chars = CharBuffer.wrap(str, offset, count + offset);
            convert(chars);
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //if (count < 0) {
                //throw new StringIndexOutOfBoundsException(str, offset, count);
            //}
            //if (str == null) {
                //throw new NullPointerException("str == null");
            //}
            //if ((offset | count) < 0 || offset > str.length() - count) {
                //throw new StringIndexOutOfBoundsException(str, offset, count);
            //}
            //checkStatus();
            //CharBuffer chars = CharBuffer.wrap(str, offset, count + offset);
            //convert(chars);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.118 -0400", hash_original_method = "E279B5931B3E4ADEA2A691FE75B2536D", hash_generated_method = "83F612CAE56821D092CFCA14D6A8B523")
    @Override
     boolean checkError() {
        boolean var07ACD71AC6574277636F8AF67D4AA28C_1018164704 = (out.checkError());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1094663500 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1094663500;
        // ---------- Original Method ----------
        //return out.checkError();
    }

    
}

