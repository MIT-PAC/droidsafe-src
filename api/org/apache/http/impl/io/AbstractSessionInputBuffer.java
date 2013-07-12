package org.apache.http.impl.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.CharArrayBuffer;

public abstract class AbstractSessionInputBuffer implements SessionInputBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.075 -0400", hash_original_field = "02CC731E1E3C3F77A09E03A9FC603C18", hash_generated_field = "9B0F52B8C31A449A2E624B8847C753E5")

    private InputStream instream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.075 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "67DBC7965A32AEE1CAB7B25294021930")

    private byte[] buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.075 -0400", hash_original_field = "5D7FCA0A7C90E911DFFF5A1B20AD46DF", hash_generated_field = "C38A316D53C22723B1202376C6917B3F")

    private int bufferpos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.076 -0400", hash_original_field = "83B3BB8A1D8CBB47A5D96A13240DA9D8", hash_generated_field = "296206540354C2045FC39BBE1B298B67")

    private int bufferlen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.076 -0400", hash_original_field = "B2C5177846F78CF14F2FAE7CA0C86EEB", hash_generated_field = "0CC6340E9144F7E622BCBFBE8F5F5CB5")

    private ByteArrayBuffer linebuffer = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.076 -0400", hash_original_field = "6AF027F2A1AB832A1E028F7C18CA5687", hash_generated_field = "76BAEB11C3552BFB23E0B4B99A533DB1")

    private String charset = HTTP.US_ASCII;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.076 -0400", hash_original_field = "EF253EBC8AB611F3735C35E53DC2547D", hash_generated_field = "9303ABFC1EF5CEEB446DE036D38A5721")

    private boolean ascii = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.076 -0400", hash_original_field = "E5CE8744D71F278EA7C2031220AD2484", hash_generated_field = "5CA0E4EE0481DA70634C383CF4BE2DA3")

    private int maxLineLen = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.076 -0400", hash_original_field = "AA59D67C2123F094D0D6798FFE651C4D", hash_generated_field = "D608E8E883C0ADFB9BB241D869189B8C")

    private HttpTransportMetricsImpl metrics;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.076 -0400", hash_original_method = "C27F370149363385AD6F9F81753F4445", hash_generated_method = "C27F370149363385AD6F9F81753F4445")
    public AbstractSessionInputBuffer ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.078 -0400", hash_original_method = "9ACC7C380ECF9A2AF3368BF4FBEC1DC4", hash_generated_method = "F7F0789C2D8D558A3D2573C2BA22C948")
    protected void init(final InputStream instream, int buffersize, final HttpParams params) {
    if(instream == null)        
        {
            IllegalArgumentException var6634DF518EA4C41A5618DC0E4E5C5981_1914078264 = new IllegalArgumentException("Input stream may not be null");
            var6634DF518EA4C41A5618DC0E4E5C5981_1914078264.addTaint(taint);
            throw var6634DF518EA4C41A5618DC0E4E5C5981_1914078264;
        } 
    if(buffersize <= 0)        
        {
            IllegalArgumentException varCD9999C5706CD4D5205C93CCF978BDB6_1199367761 = new IllegalArgumentException("Buffer size may not be negative or zero");
            varCD9999C5706CD4D5205C93CCF978BDB6_1199367761.addTaint(taint);
            throw varCD9999C5706CD4D5205C93CCF978BDB6_1199367761;
        } 
    if(params == null)        
        {
            IllegalArgumentException var497CCC27A43EDD6EE25BEEC5507E2BE2_1563395319 = new IllegalArgumentException("HTTP parameters may not be null");
            var497CCC27A43EDD6EE25BEEC5507E2BE2_1563395319.addTaint(taint);
            throw var497CCC27A43EDD6EE25BEEC5507E2BE2_1563395319;
        } 
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
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.080 -0400", hash_original_method = "AED6430DDF1A78B7022960A54C9608D3", hash_generated_method = "B34A3BD1F670F98594821A09ECB9E77E")
    protected int fillBuffer() throws IOException {
    if(this.bufferpos > 0)        
        {
            int len = this.bufferlen - this.bufferpos;
    if(len > 0)            
            {
                System.arraycopy(this.buffer, this.bufferpos, this.buffer, 0, len);
            } 
            this.bufferpos = 0;
            this.bufferlen = len;
        } 
        int l;
        int off = this.bufferlen;
        int len = this.buffer.length - off;
        l = this.instream.read(this.buffer, off, len);
    if(l == -1)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_132239990 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_618615605 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_618615605;
        } 
        else
        {
            this.bufferlen = off + l;
            this.metrics.incrementBytesTransferred(l);
            int var2DB95E8E1A9267B7A1188556B2013B33_1226933070 = (l);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1387467463 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1387467463;
        } 
        
        
            
            
                
            
            
            
        
        
        
        
        
        
            
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.080 -0400", hash_original_method = "BAC6DE94AA32B94037307F5D6F9840B7", hash_generated_method = "1E1508E4C991211F10D6765B2D9AC33E")
    protected boolean hasBufferedData() {
        boolean var4DBACA06678F2A41B609BA83A6C52DF8_1477219273 = (this.bufferpos < this.bufferlen);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1968324812 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1968324812;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.081 -0400", hash_original_method = "E463AA34023422AC03B9513A2E94EA6B", hash_generated_method = "0EAE7FBA01DECC8AFAE800B28D0E3356")
    public int read() throws IOException {
        int noRead = 0;
        while
(!hasBufferedData())        
        {
            noRead = fillBuffer();
    if(noRead == -1)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_577201540 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_211586068 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_211586068;
            } 
        } 
        int varAAC17BB528ECD4E08FF5FB8BB61C371C_1507178442 = (this.buffer[this.bufferpos++] & 0xff);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1495279863 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1495279863;
        
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.082 -0400", hash_original_method = "5A83C8A4FAF4774EC1C7C0472F5C75E8", hash_generated_method = "F147B25AD1115936E312657BAB65A997")
    public int read(final byte[] b, int off, int len) throws IOException {
        addTaint(len);
        addTaint(off);
        addTaint(b[0]);
    if(b == null)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_521080159 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_757622269 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_757622269;
        } 
        int noRead = 0;
        while
(!hasBufferedData())        
        {
            noRead = fillBuffer();
    if(noRead == -1)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1991996682 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_215920786 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_215920786;
            } 
        } 
        int chunk = this.bufferlen - this.bufferpos;
    if(chunk > len)        
        {
            chunk = len;
        } 
        System.arraycopy(this.buffer, this.bufferpos, b, off, chunk);
        this.bufferpos += chunk;
        int var5A8F4FA2AEAB5431888EE8A18CE3BCEA_2017525237 = (chunk);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1801610898 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1801610898;
        
        
            
        
        
        
            
            
                
            
        
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.082 -0400", hash_original_method = "EA19DAA67F217B43FC33D4721E7544D2", hash_generated_method = "CC4ED55D41F18576DC002D861A93FC02")
    public int read(final byte[] b) throws IOException {
        addTaint(b[0]);
    if(b == null)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_361917833 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_909796733 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_909796733;
        } 
        int var3AE1B8835719D1E8BA9C297EF156E04B_1281074558 = (read(b, 0, b.length));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1816553444 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1816553444;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.083 -0400", hash_original_method = "25E4831B40662E7C69D1371A042407AC", hash_generated_method = "D958E97901B2E2C8324BB2040939DD5F")
    private int locateLF() {
for(int i = this.bufferpos;i < this.bufferlen;i++)
        {
    if(this.buffer[i] == HTTP.LF)            
            {
                int var865C0C0B4AB0E063E5CAA3387C1A8741_815054758 = (i);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_522775787 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_522775787;
            } 
        } 
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1430107122 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_670365784 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_670365784;
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.084 -0400", hash_original_method = "473C0DD8FF067FE4EC2BE597B4124765", hash_generated_method = "05C4BFA14C33E5283FCD20F1529694C3")
    public int readLine(final CharArrayBuffer charbuffer) throws IOException {
        addTaint(charbuffer.getTaint());
    if(charbuffer == null)        
        {
            IllegalArgumentException var11B13FD12A76A3F0F811AB9F5E5EE296_1984940938 = new IllegalArgumentException("Char array buffer may not be null");
            var11B13FD12A76A3F0F811AB9F5E5EE296_1984940938.addTaint(taint);
            throw var11B13FD12A76A3F0F811AB9F5E5EE296_1984940938;
        } 
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
                    int var1B43DD53E37A409E5FDD8776DFE8965F_878872069 = (lineFromReadBuffer(charbuffer, i));
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_149967660 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_149967660;
                } 
                retry = false;
                int len = i + 1 - this.bufferpos;
                this.linebuffer.append(this.buffer, this.bufferpos, len);
                this.bufferpos = i + 1;
            } 
            else
            {
    if(hasBufferedData())                
                {
                    int len = this.bufferlen - this.bufferpos;
                    this.linebuffer.append(this.buffer, this.bufferpos, len);
                    this.bufferpos = this.bufferlen;
                } 
                noRead = fillBuffer();
    if(noRead == -1)                
                {
                    retry = false;
                } 
            } 
    if(this.maxLineLen > 0 && this.linebuffer.length() >= this.maxLineLen)            
            {
                IOException var12ACD845FE59D4DF91577F545067D44A_725649225 = new IOException("Maximum line length limit exceeded");
                var12ACD845FE59D4DF91577F545067D44A_725649225.addTaint(taint);
                throw var12ACD845FE59D4DF91577F545067D44A_725649225;
            } 
        } 
    if(noRead == -1 && this.linebuffer.isEmpty())        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_103290025 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1265453204 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1265453204;
        } 
        int varDE6D34CD34CA5AF9EF6CFDE35F0615AC_645255976 = (lineFromLineBuffer(charbuffer));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_839260661 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_839260661;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.084 -0400", hash_original_method = "729842E116E7795B9747338D0779180E", hash_generated_method = "5C514B86F8E637DDCC911D5FC6CE80EB")
    private int lineFromLineBuffer(final CharArrayBuffer charbuffer) throws IOException {
        addTaint(charbuffer.getTaint());
        int l = this.linebuffer.length();
    if(l > 0)        
        {
    if(this.linebuffer.byteAt(l - 1) == HTTP.LF)            
            {
                l--;
                this.linebuffer.setLength(l);
            } 
    if(l > 0)            
            {
    if(this.linebuffer.byteAt(l - 1) == HTTP.CR)                
                {
                    l--;
                    this.linebuffer.setLength(l);
                } 
            } 
        } 
        l = this.linebuffer.length();
    if(this.ascii)        
        {
            charbuffer.append(this.linebuffer, 0, l);
        } 
        else
        {
            String s = new String(this.linebuffer.buffer(), 0, l, this.charset);
            charbuffer.append(s);
        } 
        int var2DB95E8E1A9267B7A1188556B2013B33_1334281252 = (l);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_552114288 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_552114288;
        
        
        
            
                
                
            
            
                
                    
                    
                
            
        
        
        
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.085 -0400", hash_original_method = "E6FBFD5C83985C7D6E27D18B8C3822A9", hash_generated_method = "45D49D3D505F59B8FE050F25065BA962")
    private int lineFromReadBuffer(final CharArrayBuffer charbuffer, int pos) throws IOException {
        addTaint(charbuffer.getTaint());
        int off = this.bufferpos;
        int len;
        this.bufferpos = pos + 1;
    if(pos > off && this.buffer[pos - 1] == HTTP.CR)        
        {
            pos--;
        } 
        len = pos - off;
    if(this.ascii)        
        {
            charbuffer.append(this.buffer, off, len);
        } 
        else
        {
            String s = new String(this.buffer, off, len, this.charset);
            charbuffer.append(s);
        } 
        int varF5A8E923F8CD24B56B3BAB32358CC58A_130859946 = (len);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1780059370 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1780059370;
        
        
        
        
        
            
        
        
        
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.086 -0400", hash_original_method = "40CE76C5D842CFEF27650CABF8F97946", hash_generated_method = "8621FD159A5E9C8114F50054938BBB07")
    public String readLine() throws IOException {
        CharArrayBuffer charbuffer = new CharArrayBuffer(64);
        int l = readLine(charbuffer);
    if(l != -1)        
        {
String varE9F5B5099F22490179F0CC31E1E62DC2_190106239 =             charbuffer.toString();
            varE9F5B5099F22490179F0CC31E1E62DC2_190106239.addTaint(taint);
            return varE9F5B5099F22490179F0CC31E1E62DC2_190106239;
        } 
        else
        {
String var540C13E9E156B687226421B24F2DF178_2057957870 =             null;
            var540C13E9E156B687226421B24F2DF178_2057957870.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2057957870;
        } 
        
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.086 -0400", hash_original_method = "E82E77AA369AC2B118042C614F644F5C", hash_generated_method = "BDEA1EFA4B67E3D2B0B539EF7DE5BF34")
    public HttpTransportMetrics getMetrics() {
HttpTransportMetrics varFC1AE2E8C2526EA66FBB8E6B024A2CB6_806041044 =         this.metrics;
        varFC1AE2E8C2526EA66FBB8E6B024A2CB6_806041044.addTaint(taint);
        return varFC1AE2E8C2526EA66FBB8E6B024A2CB6_806041044;
        
        
    }

    
}

