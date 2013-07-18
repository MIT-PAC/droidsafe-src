package org.apache.http.impl.io;

// Droidsafe Imports
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.CharArrayBuffer;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class AbstractSessionInputBuffer implements SessionInputBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.424 -0400", hash_original_field = "02CC731E1E3C3F77A09E03A9FC603C18", hash_generated_field = "9B0F52B8C31A449A2E624B8847C753E5")

    private InputStream instream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.424 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "67DBC7965A32AEE1CAB7B25294021930")

    private byte[] buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.424 -0400", hash_original_field = "5D7FCA0A7C90E911DFFF5A1B20AD46DF", hash_generated_field = "C38A316D53C22723B1202376C6917B3F")

    private int bufferpos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.424 -0400", hash_original_field = "83B3BB8A1D8CBB47A5D96A13240DA9D8", hash_generated_field = "296206540354C2045FC39BBE1B298B67")

    private int bufferlen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.424 -0400", hash_original_field = "B2C5177846F78CF14F2FAE7CA0C86EEB", hash_generated_field = "0CC6340E9144F7E622BCBFBE8F5F5CB5")

    private ByteArrayBuffer linebuffer = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.424 -0400", hash_original_field = "6AF027F2A1AB832A1E028F7C18CA5687", hash_generated_field = "76BAEB11C3552BFB23E0B4B99A533DB1")

    private String charset = HTTP.US_ASCII;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.424 -0400", hash_original_field = "EF253EBC8AB611F3735C35E53DC2547D", hash_generated_field = "9303ABFC1EF5CEEB446DE036D38A5721")

    private boolean ascii = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.424 -0400", hash_original_field = "E5CE8744D71F278EA7C2031220AD2484", hash_generated_field = "5CA0E4EE0481DA70634C383CF4BE2DA3")

    private int maxLineLen = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.425 -0400", hash_original_field = "AA59D67C2123F094D0D6798FFE651C4D", hash_generated_field = "D608E8E883C0ADFB9BB241D869189B8C")

    private HttpTransportMetricsImpl metrics;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.425 -0400", hash_original_method = "C27F370149363385AD6F9F81753F4445", hash_generated_method = "C27F370149363385AD6F9F81753F4445")
    public AbstractSessionInputBuffer ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.427 -0400", hash_original_method = "9ACC7C380ECF9A2AF3368BF4FBEC1DC4", hash_generated_method = "39DC86AF7751BB2548C6800AA17B639A")
    protected void init(final InputStream instream, int buffersize, final HttpParams params) {
        if(instream == null)        
        {
            IllegalArgumentException var6634DF518EA4C41A5618DC0E4E5C5981_1760465808 = new IllegalArgumentException("Input stream may not be null");
            var6634DF518EA4C41A5618DC0E4E5C5981_1760465808.addTaint(taint);
            throw var6634DF518EA4C41A5618DC0E4E5C5981_1760465808;
        } //End block
        if(buffersize <= 0)        
        {
            IllegalArgumentException varCD9999C5706CD4D5205C93CCF978BDB6_889319570 = new IllegalArgumentException("Buffer size may not be negative or zero");
            varCD9999C5706CD4D5205C93CCF978BDB6_889319570.addTaint(taint);
            throw varCD9999C5706CD4D5205C93CCF978BDB6_889319570;
        } //End block
        if(params == null)        
        {
            IllegalArgumentException var497CCC27A43EDD6EE25BEEC5507E2BE2_704510326 = new IllegalArgumentException("HTTP parameters may not be null");
            var497CCC27A43EDD6EE25BEEC5507E2BE2_704510326.addTaint(taint);
            throw var497CCC27A43EDD6EE25BEEC5507E2BE2_704510326;
        } //End block
        this.instream = instream;
        this.buffer = new byte[buffersize];
        this.bufferpos = 0;
        this.bufferlen = 0;
        this.linebuffer = new ByteArrayBuffer(buffersize);
        this.charset = HttpProtocolParams.getHttpElementCharset(params);
        this.ascii = this.charset.equalsIgnoreCase(HTTP.US_ASCII)
                     || this.charset.equalsIgnoreCase(HTTP.ASCII);
        this.maxLineLen = params.getIntParameter(CoreConnectionPNames.MAX_LINE_LENGTH, -1);
        this.metrics = new HttpTransportMetricsImpl();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.428 -0400", hash_original_method = "AED6430DDF1A78B7022960A54C9608D3", hash_generated_method = "4C2767061D115B2C6DB2A008B121B1D2")
    protected int fillBuffer() throws IOException {
        if(this.bufferpos > 0)        
        {
            int len = this.bufferlen - this.bufferpos;
            if(len > 0)            
            {
                System.arraycopy(this.buffer, this.bufferpos, this.buffer, 0, len);
            } //End block
            this.bufferpos = 0;
            this.bufferlen = len;
        } //End block
        int l;
        int off = this.bufferlen;
        int len = this.buffer.length - off;
        l = this.instream.read(this.buffer, off, len);
        if(l == -1)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_974326366 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1096476306 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1096476306;
        } //End block
        else
        {
            this.bufferlen = off + l;
            this.metrics.incrementBytesTransferred(l);
            int var2DB95E8E1A9267B7A1188556B2013B33_873363770 = (l);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1919772037 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1919772037;
        } //End block
        // ---------- Original Method ----------
        //if (this.bufferpos > 0) {
            //int len = this.bufferlen - this.bufferpos;
            //if (len > 0) {
                //System.arraycopy(this.buffer, this.bufferpos, this.buffer, 0, len);
            //}
            //this.bufferpos = 0;
            //this.bufferlen = len;
        //}
        //int l;
        //int off = this.bufferlen;
        //int len = this.buffer.length - off;
        //l = this.instream.read(this.buffer, off, len);
        //if (l == -1) {
            //return -1;
        //} else {
            //this.bufferlen = off + l;
            //this.metrics.incrementBytesTransferred(l);
            //return l;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.428 -0400", hash_original_method = "BAC6DE94AA32B94037307F5D6F9840B7", hash_generated_method = "17862D15A71A19C41F61386187EEDF0F")
    protected boolean hasBufferedData() {
        boolean var4DBACA06678F2A41B609BA83A6C52DF8_365409340 = (this.bufferpos < this.bufferlen);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_300184309 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_300184309;
        // ---------- Original Method ----------
        //return this.bufferpos < this.bufferlen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.429 -0400", hash_original_method = "E463AA34023422AC03B9513A2E94EA6B", hash_generated_method = "5FA4EC31AA5DEB6FCFF4557F376EE5EB")
    public int read() throws IOException {
        int noRead = 0;
        while
(!hasBufferedData())        
        {
            noRead = fillBuffer();
            if(noRead == -1)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_943954925 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_134987165 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_134987165;
            } //End block
        } //End block
        int varAAC17BB528ECD4E08FF5FB8BB61C371C_932258773 = (this.buffer[this.bufferpos++] & 0xff);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1582172069 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1582172069;
        // ---------- Original Method ----------
        //int noRead = 0;
        //while (!hasBufferedData()) {
            //noRead = fillBuffer();
            //if (noRead == -1) {
                //return -1;
            //}
        //}
        //return this.buffer[this.bufferpos++] & 0xff;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.430 -0400", hash_original_method = "5A83C8A4FAF4774EC1C7C0472F5C75E8", hash_generated_method = "6A373C976F0A79F277B2576E0FA6F3E4")
    public int read(final byte[] b, int off, int len) throws IOException {
        addTaint(len);
        addTaint(off);
        addTaint(b[0]);
        if(b == null)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1224322947 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_347568376 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_347568376;
        } //End block
        int noRead = 0;
        while
(!hasBufferedData())        
        {
            noRead = fillBuffer();
            if(noRead == -1)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1273766442 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_918268200 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_918268200;
            } //End block
        } //End block
        int chunk = this.bufferlen - this.bufferpos;
        if(chunk > len)        
        {
            chunk = len;
        } //End block
        System.arraycopy(this.buffer, this.bufferpos, b, off, chunk);
        this.bufferpos += chunk;
        int var5A8F4FA2AEAB5431888EE8A18CE3BCEA_33932159 = (chunk);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1302174356 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1302174356;
        // ---------- Original Method ----------
        //if (b == null) {
            //return 0;
        //}
        //int noRead = 0;
        //while (!hasBufferedData()) {
            //noRead = fillBuffer();
            //if (noRead == -1) {
                //return -1;
            //}
        //}
        //int chunk = this.bufferlen - this.bufferpos;
        //if (chunk > len) {
            //chunk = len;
        //}
        //System.arraycopy(this.buffer, this.bufferpos, b, off, chunk);
        //this.bufferpos += chunk;
        //return chunk;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.431 -0400", hash_original_method = "EA19DAA67F217B43FC33D4721E7544D2", hash_generated_method = "B228F671E37E9D97CA246C529DF741ED")
    public int read(final byte[] b) throws IOException {
        addTaint(b[0]);
        if(b == null)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_23753733 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_299224072 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_299224072;
        } //End block
        int var3AE1B8835719D1E8BA9C297EF156E04B_1396533279 = (read(b, 0, b.length));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_959978181 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_959978181;
        // ---------- Original Method ----------
        //if (b == null) {
            //return 0;
        //}
        //return read(b, 0, b.length);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.431 -0400", hash_original_method = "25E4831B40662E7C69D1371A042407AC", hash_generated_method = "80A0B8BD728F2332D9B8CE0730E75299")
    private int locateLF() {
for(int i = this.bufferpos;i < this.bufferlen;i++)
        {
            if(this.buffer[i] == HTTP.LF)            
            {
                int var865C0C0B4AB0E063E5CAA3387C1A8741_699596269 = (i);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_131746785 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_131746785;
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_617400623 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1502363877 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1502363877;
        // ---------- Original Method ----------
        //for (int i = this.bufferpos; i < this.bufferlen; i++) {
            //if (this.buffer[i] == HTTP.LF) {
                //return i;
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.433 -0400", hash_original_method = "473C0DD8FF067FE4EC2BE597B4124765", hash_generated_method = "E98C7263481D961D1AAA2E835B4D9036")
    public int readLine(final CharArrayBuffer charbuffer) throws IOException {
        addTaint(charbuffer.getTaint());
        if(charbuffer == null)        
        {
            IllegalArgumentException var11B13FD12A76A3F0F811AB9F5E5EE296_274190341 = new IllegalArgumentException("Char array buffer may not be null");
            var11B13FD12A76A3F0F811AB9F5E5EE296_274190341.addTaint(taint);
            throw var11B13FD12A76A3F0F811AB9F5E5EE296_274190341;
        } //End block
        this.linebuffer.clear();
        int noRead = 0;
        boolean retry = true;
        while
(retry)        
        {
            int i = locateLF();
            if(i != -1)            
            {
                if(this.linebuffer.isEmpty())                
                {
                    int var1B43DD53E37A409E5FDD8776DFE8965F_1948991465 = (lineFromReadBuffer(charbuffer, i));
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1146023397 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1146023397;
                } //End block
                retry = false;
                int len = i + 1 - this.bufferpos;
                this.linebuffer.append(this.buffer, this.bufferpos, len);
                this.bufferpos = i + 1;
            } //End block
            else
            {
                if(hasBufferedData())                
                {
                    int len = this.bufferlen - this.bufferpos;
                    this.linebuffer.append(this.buffer, this.bufferpos, len);
                    this.bufferpos = this.bufferlen;
                } //End block
                noRead = fillBuffer();
                if(noRead == -1)                
                {
                    retry = false;
                } //End block
            } //End block
            if(this.maxLineLen > 0 && this.linebuffer.length() >= this.maxLineLen)            
            {
                IOException var12ACD845FE59D4DF91577F545067D44A_922398240 = new IOException("Maximum line length limit exceeded");
                var12ACD845FE59D4DF91577F545067D44A_922398240.addTaint(taint);
                throw var12ACD845FE59D4DF91577F545067D44A_922398240;
            } //End block
        } //End block
        if(noRead == -1 && this.linebuffer.isEmpty())        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_501628848 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1194586487 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1194586487;
        } //End block
        int varDE6D34CD34CA5AF9EF6CFDE35F0615AC_727772285 = (lineFromLineBuffer(charbuffer));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2126987761 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2126987761;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.434 -0400", hash_original_method = "729842E116E7795B9747338D0779180E", hash_generated_method = "35DA7303FBFECA164F4F191E13D32ECF")
    private int lineFromLineBuffer(final CharArrayBuffer charbuffer) throws IOException {
        addTaint(charbuffer.getTaint());
        int l = this.linebuffer.length();
        if(l > 0)        
        {
            if(this.linebuffer.byteAt(l - 1) == HTTP.LF)            
            {
                l--;
                this.linebuffer.setLength(l);
            } //End block
            if(l > 0)            
            {
                if(this.linebuffer.byteAt(l - 1) == HTTP.CR)                
                {
                    l--;
                    this.linebuffer.setLength(l);
                } //End block
            } //End block
        } //End block
        l = this.linebuffer.length();
        if(this.ascii)        
        {
            charbuffer.append(this.linebuffer, 0, l);
        } //End block
        else
        {
            String s = new String(this.linebuffer.buffer(), 0, l, this.charset);
            charbuffer.append(s);
        } //End block
        int var2DB95E8E1A9267B7A1188556B2013B33_885376215 = (l);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2108086547 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2108086547;
        // ---------- Original Method ----------
        //int l = this.linebuffer.length();
        //if (l > 0) {
            //if (this.linebuffer.byteAt(l - 1) == HTTP.LF) {
                //l--;
                //this.linebuffer.setLength(l);
            //}
            //if (l > 0) {
                //if (this.linebuffer.byteAt(l - 1) == HTTP.CR) {
                    //l--;
                    //this.linebuffer.setLength(l);
                //}
            //}
        //}
        //l = this.linebuffer.length();
        //if (this.ascii) {
            //charbuffer.append(this.linebuffer, 0, l);
        //} else {
            //String s = new String(this.linebuffer.buffer(), 0, l, this.charset);
            //charbuffer.append(s);
        //}
        //return l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.435 -0400", hash_original_method = "E6FBFD5C83985C7D6E27D18B8C3822A9", hash_generated_method = "D76672085F36E909944C122C23392E89")
    private int lineFromReadBuffer(final CharArrayBuffer charbuffer, int pos) throws IOException {
        addTaint(charbuffer.getTaint());
        int off = this.bufferpos;
        int len;
        this.bufferpos = pos + 1;
        if(pos > off && this.buffer[pos - 1] == HTTP.CR)        
        {
            pos--;
        } //End block
        len = pos - off;
        if(this.ascii)        
        {
            charbuffer.append(this.buffer, off, len);
        } //End block
        else
        {
            String s = new String(this.buffer, off, len, this.charset);
            charbuffer.append(s);
        } //End block
        int varF5A8E923F8CD24B56B3BAB32358CC58A_875385822 = (len);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_504212579 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_504212579;
        // ---------- Original Method ----------
        //int off = this.bufferpos;
        //int len;
        //this.bufferpos = pos + 1;
        //if (pos > off && this.buffer[pos - 1] == HTTP.CR) {
            //pos--;
        //}
        //len = pos - off;
        //if (this.ascii) {
            //charbuffer.append(this.buffer, off, len);
        //} else {
            //String s = new String(this.buffer, off, len, this.charset);
            //charbuffer.append(s);
        //}
        //return len;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.435 -0400", hash_original_method = "40CE76C5D842CFEF27650CABF8F97946", hash_generated_method = "00550DBA5C129E1263CF0D4AFB304A33")
    public String readLine() throws IOException {
        CharArrayBuffer charbuffer = new CharArrayBuffer(64);
        int l = readLine(charbuffer);
        if(l != -1)        
        {
String varE9F5B5099F22490179F0CC31E1E62DC2_1210146458 =             charbuffer.toString();
            varE9F5B5099F22490179F0CC31E1E62DC2_1210146458.addTaint(taint);
            return varE9F5B5099F22490179F0CC31E1E62DC2_1210146458;
        } //End block
        else
        {
String var540C13E9E156B687226421B24F2DF178_851479827 =             null;
            var540C13E9E156B687226421B24F2DF178_851479827.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_851479827;
        } //End block
        // ---------- Original Method ----------
        //CharArrayBuffer charbuffer = new CharArrayBuffer(64);
        //int l = readLine(charbuffer);
        //if (l != -1) {
            //return charbuffer.toString();
        //} else {
            //return null;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.435 -0400", hash_original_method = "E82E77AA369AC2B118042C614F644F5C", hash_generated_method = "42F730A79EF9DFCA9AEAEE1984B4746D")
    public HttpTransportMetrics getMetrics() {
HttpTransportMetrics varFC1AE2E8C2526EA66FBB8E6B024A2CB6_1149111977 =         this.metrics;
        varFC1AE2E8C2526EA66FBB8E6B024A2CB6_1149111977.addTaint(taint);
        return varFC1AE2E8C2526EA66FBB8E6B024A2CB6_1149111977;
        // ---------- Original Method ----------
        //return this.metrics;
    }

    
}

