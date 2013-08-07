package java.io;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;






public class InputStreamReader extends Reader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.110 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "9DA78E40E39AA56A72373CEA8B1326DF")

    private InputStream in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.110 -0400", hash_original_field = "1BD372EDACBB8876856A0324150C4E1B", hash_generated_field = "C1BD264EA71B8905202FEFE2EB6106E5")

    private boolean endOfInput = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.110 -0400", hash_original_field = "3A6BDBA8FB33A88CF7D52A1AF07A9C00", hash_generated_field = "E190C0DE068854E0E786DAC309DED1B8")

    private CharsetDecoder decoder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.110 -0400", hash_original_field = "50E41AB3FDB67E2442AFB04B480B97A2", hash_generated_field = "C7ACDD8E59EDFE2B06C91B0B5639E9AE")

    private final ByteBuffer bytes = ByteBuffer.allocate(8192);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.110 -0400", hash_original_method = "3590A2EED02D10C52AB0172AD4BE22C4", hash_generated_method = "C11E1C8740A43C21BC55AB18059CCFB4")
    public  InputStreamReader(InputStream in) {
        this(in, Charset.defaultCharset());
        addTaint(in.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.111 -0400", hash_original_method = "EBBB6FD529AC9BA283207DBA01D68764", hash_generated_method = "8BD7A404AB6716E807F4322DA252A54F")
    public  InputStreamReader(InputStream in, final String enc) throws UnsupportedEncodingException {
        super(in);
        if(enc == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_258736474 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_258736474.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_258736474;
        } //End block
        this.in = in;
        try 
        {
            decoder = Charset.forName(enc).newDecoder().onMalformedInput(
                    CodingErrorAction.REPLACE).onUnmappableCharacter(
                    CodingErrorAction.REPLACE);
        } //End block
        catch (IllegalArgumentException e)
        {
            UnsupportedEncodingException varDA8FCC63ED22BFE7F42A166818154BA3_339299954 = (UnsupportedEncodingException)
                    new UnsupportedEncodingException(enc).initCause(e);
            varDA8FCC63ED22BFE7F42A166818154BA3_339299954.addTaint(taint);
            throw varDA8FCC63ED22BFE7F42A166818154BA3_339299954;
        } //End block
        bytes.limit(0);
        // ---------- Original Method ----------
        //if (enc == null) {
            //throw new NullPointerException();
        //}
        //this.in = in;
        //try {
            //decoder = Charset.forName(enc).newDecoder().onMalformedInput(
                    //CodingErrorAction.REPLACE).onUnmappableCharacter(
                    //CodingErrorAction.REPLACE);
        //} catch (IllegalArgumentException e) {
            //throw (UnsupportedEncodingException)
                    //new UnsupportedEncodingException(enc).initCause(e);
        //}
        //bytes.limit(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.112 -0400", hash_original_method = "A7068E06FC6AB9497581BF79FF6884E3", hash_generated_method = "B08D041F736141AFFE6AB91E312D04A3")
    public  InputStreamReader(InputStream in, CharsetDecoder dec) {
        super(in);
        dec.averageCharsPerByte();
        this.in = in;
        decoder = dec;
        bytes.limit(0);
        // ---------- Original Method ----------
        //dec.averageCharsPerByte();
        //this.in = in;
        //decoder = dec;
        //bytes.limit(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.113 -0400", hash_original_method = "F689BDB30C937E91D3C146F93A07A4B9", hash_generated_method = "638E03BD1AF4CDE5E50D3D3938B8A100")
    public  InputStreamReader(InputStream in, Charset charset) {
        super(in);
        this.in = in;
        decoder = charset.newDecoder().onMalformedInput(
                CodingErrorAction.REPLACE).onUnmappableCharacter(
                CodingErrorAction.REPLACE);
        bytes.limit(0);
        // ---------- Original Method ----------
        //this.in = in;
        //decoder = charset.newDecoder().onMalformedInput(
                //CodingErrorAction.REPLACE).onUnmappableCharacter(
                //CodingErrorAction.REPLACE);
        //bytes.limit(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.113 -0400", hash_original_method = "FE46DA5B445A82E67613621D1604074D", hash_generated_method = "FD7FB0415BB06C755E2B8C451E4BC414")
    @Override
    public void close() throws IOException {
        synchronized
(lock)        {
            if(decoder != null)            
            {
                decoder.reset();
            } //End block
            decoder = null;
            if(in != null)            
            {
                in.close();
                in = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //if (decoder != null) {
                //decoder.reset();
            //}
            //decoder = null;
            //if (in != null) {
                //in.close();
                //in = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.113 -0400", hash_original_method = "4B46B0B3D8C39E950459FB803D7FD65D", hash_generated_method = "DBC8D67D124E424ABBC3028B403BDB5F")
    public String getEncoding() {
        if(!isOpen())        
        {
String var540C13E9E156B687226421B24F2DF178_1131526652 =             null;
            var540C13E9E156B687226421B24F2DF178_1131526652.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1131526652;
        } //End block
String var0CAEB9C5EE04F06514583664597031A5_2023730002 =         HistoricalCharsetNames.get(decoder.charset());
        var0CAEB9C5EE04F06514583664597031A5_2023730002.addTaint(taint);
        return var0CAEB9C5EE04F06514583664597031A5_2023730002;
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //return null;
        //}
        //return HistoricalCharsetNames.get(decoder.charset());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.114 -0400", hash_original_method = "42220754D208F7633D722D928E4FD163", hash_generated_method = "17B33CF98F9F83760EEDEA554DD1EA50")
    @Override
    public int read() throws IOException {
        synchronized
(lock)        {
            if(!isOpen())            
            {
                IOException varC10ADDF6EFCFF82B0AD0EE2A95AAB1A9_2069437578 = new IOException("InputStreamReader is closed");
                varC10ADDF6EFCFF82B0AD0EE2A95AAB1A9_2069437578.addTaint(taint);
                throw varC10ADDF6EFCFF82B0AD0EE2A95AAB1A9_2069437578;
            } //End block
            char[] buf = new char[1];
            int varA403D89C2CA6CC03C5AE994E3A0B4027_1877056443 = (read(buf, 0, 1) != -1 ? buf[0] : -1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_920250784 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_920250784;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //if (!isOpen()) {
                //throw new IOException("InputStreamReader is closed");
            //}
            //char[] buf = new char[1];
            //return read(buf, 0, 1) != -1 ? buf[0] : -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.116 -0400", hash_original_method = "610EEC39BC95175186F6D1B73FBDC240", hash_generated_method = "033061A0E1CAFDD8A4CC48A23C72B74C")
    @Override
    public int read(char[] buffer, int offset, int length) throws IOException {
        addTaint(length);
        addTaint(offset);
        addTaint(buffer[0]);
        synchronized
(lock)        {
            if(!isOpen())            
            {
                IOException varC10ADDF6EFCFF82B0AD0EE2A95AAB1A9_1691446603 = new IOException("InputStreamReader is closed");
                varC10ADDF6EFCFF82B0AD0EE2A95AAB1A9_1691446603.addTaint(taint);
                throw varC10ADDF6EFCFF82B0AD0EE2A95AAB1A9_1691446603;
            } //End block
            Arrays.checkOffsetAndCount(buffer.length, offset, length);
            if(length == 0)            
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_861306191 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1235103549 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1235103549;
            } //End block
            CharBuffer out = CharBuffer.wrap(buffer, offset, length);
            CoderResult result = CoderResult.UNDERFLOW;
            boolean needInput = !bytes.hasRemaining();
            while
(out.hasRemaining())            
            {
                if(needInput)                
                {
                    try 
                    {
                        if(in.available() == 0 && out.position() > offset)                        
                        {
                            break;
                        } //End block
                    } //End block
                    catch (IOException e)
                    {
                    } //End block
                    int desiredByteCount = bytes.capacity() - bytes.limit();
                    int off = bytes.arrayOffset() + bytes.limit();
                    int actualByteCount = in.read(bytes.array(), off, desiredByteCount);
                    if(actualByteCount == -1)                    
                    {
                        endOfInput = true;
                        break;
                    } //End block
                    else
                    if(actualByteCount == 0)                    
                    {
                        break;
                    } //End block
                    bytes.limit(bytes.limit() + actualByteCount);
                    needInput = false;
                } //End block
                result = decoder.decode(bytes, out, false);
                if(result.isUnderflow())                
                {
                    if(bytes.limit() == bytes.capacity())                    
                    {
                        bytes.compact();
                        bytes.limit(bytes.position());
                        bytes.position(0);
                    } //End block
                    needInput = true;
                } //End block
                else
                {
                    break;
                } //End block
            } //End block
            if(result == CoderResult.UNDERFLOW && endOfInput)            
            {
                result = decoder.decode(bytes, out, true);
                decoder.flush(out);
                decoder.reset();
            } //End block
            if(result.isMalformed() || result.isUnmappable())            
            {
                result.throwException();
            } //End block
            int var42025BE1D23AB7981C542C79B0CBFF55_1943362841 = (out.position() - offset == 0 ? -1 : out.position() - offset);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_221086353 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_221086353;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.117 -0400", hash_original_method = "2814A675517787CC2FFF66E2663BBAA6", hash_generated_method = "BDFFDC05FB1531294BFA8744512F705E")
    private boolean isOpen() {
        boolean var0756A9CF6E7FC23D4EDE35D48E0E460B_760606085 = (in != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_688323590 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_688323590;
        // ---------- Original Method ----------
        //return in != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.117 -0400", hash_original_method = "281B3CA6768822BAE894DB2D1EB23921", hash_generated_method = "2866075CC198AD6B58727C357BA8979D")
    @Override
    public boolean ready() throws IOException {
        synchronized
(lock)        {
            if(in == null)            
            {
                IOException varC10ADDF6EFCFF82B0AD0EE2A95AAB1A9_1253318934 = new IOException("InputStreamReader is closed");
                varC10ADDF6EFCFF82B0AD0EE2A95AAB1A9_1253318934.addTaint(taint);
                throw varC10ADDF6EFCFF82B0AD0EE2A95AAB1A9_1253318934;
            } //End block
            try 
            {
                boolean var3B3558484A377AC5313F52A7F104C4B4_1930481568 = (bytes.hasRemaining() || in.available() > 0);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1461221151 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1461221151;
            } //End block
            catch (IOException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_819932537 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2108632109 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2108632109;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //if (in == null) {
                //throw new IOException("InputStreamReader is closed");
            //}
            //try {
                //return bytes.hasRemaining() || in.available() > 0;
            //} catch (IOException e) {
                //return false;
            //}
        //}
    }

    
}

