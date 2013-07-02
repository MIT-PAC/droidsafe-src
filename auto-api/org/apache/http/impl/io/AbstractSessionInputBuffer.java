package org.apache.http.impl.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.645 -0400", hash_original_field = "02CC731E1E3C3F77A09E03A9FC603C18", hash_generated_field = "9B0F52B8C31A449A2E624B8847C753E5")

    private InputStream instream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.645 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "67DBC7965A32AEE1CAB7B25294021930")

    private byte[] buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.645 -0400", hash_original_field = "5D7FCA0A7C90E911DFFF5A1B20AD46DF", hash_generated_field = "C38A316D53C22723B1202376C6917B3F")

    private int bufferpos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.645 -0400", hash_original_field = "83B3BB8A1D8CBB47A5D96A13240DA9D8", hash_generated_field = "296206540354C2045FC39BBE1B298B67")

    private int bufferlen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.645 -0400", hash_original_field = "B2C5177846F78CF14F2FAE7CA0C86EEB", hash_generated_field = "0CC6340E9144F7E622BCBFBE8F5F5CB5")

    private ByteArrayBuffer linebuffer = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.645 -0400", hash_original_field = "6AF027F2A1AB832A1E028F7C18CA5687", hash_generated_field = "76BAEB11C3552BFB23E0B4B99A533DB1")

    private String charset = HTTP.US_ASCII;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.645 -0400", hash_original_field = "EF253EBC8AB611F3735C35E53DC2547D", hash_generated_field = "9303ABFC1EF5CEEB446DE036D38A5721")

    private boolean ascii = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.645 -0400", hash_original_field = "E5CE8744D71F278EA7C2031220AD2484", hash_generated_field = "5CA0E4EE0481DA70634C383CF4BE2DA3")

    private int maxLineLen = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.645 -0400", hash_original_field = "AA59D67C2123F094D0D6798FFE651C4D", hash_generated_field = "D608E8E883C0ADFB9BB241D869189B8C")

    private HttpTransportMetricsImpl metrics;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.645 -0400", hash_original_method = "C27F370149363385AD6F9F81753F4445", hash_generated_method = "C27F370149363385AD6F9F81753F4445")
    public AbstractSessionInputBuffer ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.646 -0400", hash_original_method = "9ACC7C380ECF9A2AF3368BF4FBEC1DC4", hash_generated_method = "D39B636707B50749483D162D68D5B637")
    protected void init(final InputStream instream, int buffersize, final HttpParams params) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Input stream may not be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Buffer size may not be negative or zero");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP parameters may not be null");
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.646 -0400", hash_original_method = "AED6430DDF1A78B7022960A54C9608D3", hash_generated_method = "86EE911669ED9E9D1802FB75B2B0E6CF")
    protected int fillBuffer() throws IOException {
        {
            int len = this.bufferlen - this.bufferpos;
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
        {
            this.bufferlen = off + l;
            this.metrics.incrementBytesTransferred(l);
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_595221142 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_595221142;
        
        
            
            
                
            
            
            
        
        
        
        
        
        
            
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.647 -0400", hash_original_method = "BAC6DE94AA32B94037307F5D6F9840B7", hash_generated_method = "EE566FA564BA7E0AC06602EAD1D1892F")
    protected boolean hasBufferedData() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_241729260 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_241729260;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.647 -0400", hash_original_method = "E463AA34023422AC03B9513A2E94EA6B", hash_generated_method = "BD4D885A9AD4F83D143C008012C20E9C")
    public int read() throws IOException {
        int noRead = 0;
        {
            boolean varD210C1373B6FBB590F5BF990F9119C91_30848444 = (!hasBufferedData());
            {
                noRead = fillBuffer();
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1852517607 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1852517607;
        
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.648 -0400", hash_original_method = "5A83C8A4FAF4774EC1C7C0472F5C75E8", hash_generated_method = "2C1FBC08CC28124BBB9C37AA7BFA5759")
    public int read(final byte[] b, int off, int len) throws IOException {
        int noRead = 0;
        {
            boolean varD210C1373B6FBB590F5BF990F9119C91_1779457293 = (!hasBufferedData());
            {
                noRead = fillBuffer();
            } 
        } 
        int chunk = this.bufferlen - this.bufferpos;
        {
            chunk = len;
        } 
        System.arraycopy(this.buffer, this.bufferpos, b, off, chunk);
        this.bufferpos += chunk;
        addTaint(b[0]);
        addTaint(off);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1220121799 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1220121799;
        
        
            
        
        
        
            
            
                
            
        
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.649 -0400", hash_original_method = "EA19DAA67F217B43FC33D4721E7544D2", hash_generated_method = "6D928C42DAF89916507BEBEE0C78BD42")
    public int read(final byte[] b) throws IOException {
        int var38A74F3EE8B05A9B738F2B8C0F60B1F0_264812185 = (read(b, 0, b.length));
        addTaint(b[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1868233542 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1868233542;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.650 -0400", hash_original_method = "25E4831B40662E7C69D1371A042407AC", hash_generated_method = "CA8538EB471BF327B416B4D0C68302AC")
    private int locateLF() {
        {
            int i = this.bufferpos;
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_681113163 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_681113163;
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.652 -0400", hash_original_method = "473C0DD8FF067FE4EC2BE597B4124765", hash_generated_method = "E1A3F1E59CFA5CE4A0157D4487C13C74")
    public int readLine(final CharArrayBuffer charbuffer) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Char array buffer may not be null");
        } 
        this.linebuffer.clear();
        int noRead = 0;
        boolean retry = true;
        {
            int i = locateLF();
            {
                {
                    boolean varEBE8EA489B47F8DB0AE71744DD2E6C95_431643264 = (this.linebuffer.isEmpty());
                    {
                        int var297CA58D99A61AD49D3A628841BFAD8C_1617769705 = (lineFromReadBuffer(charbuffer, i));
                    } 
                } 
                retry = false;
                int len = i + 1 - this.bufferpos;
                this.linebuffer.append(this.buffer, this.bufferpos, len);
                this.bufferpos = i + 1;
            } 
            {
                {
                    boolean varAEA5FA52AEDB2545ECF9D26B26ACDD70_1073426752 = (hasBufferedData());
                    {
                        int len = this.bufferlen - this.bufferpos;
                        this.linebuffer.append(this.buffer, this.bufferpos, len);
                        this.bufferpos = this.bufferlen;
                    } 
                } 
                noRead = fillBuffer();
                {
                    retry = false;
                } 
            } 
            {
                boolean var7235849E2B0B7AC365A0707BE1ACD937_1124864759 = (this.maxLineLen > 0 && this.linebuffer.length() >= this.maxLineLen);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("Maximum line length limit exceeded");
                } 
            } 
        } 
        {
            boolean var7DF2E4704BE4B8408E4250829EA440A6_309551367 = (noRead == -1 && this.linebuffer.isEmpty());
        } 
        int varCEC600CF2A719499A0A9466F62AF2872_1321331095 = (lineFromLineBuffer(charbuffer));
        addTaint(charbuffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1808340555 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1808340555;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.654 -0400", hash_original_method = "729842E116E7795B9747338D0779180E", hash_generated_method = "6E99E2A66067A0F36125C5CE7B7F19D8")
    private int lineFromLineBuffer(final CharArrayBuffer charbuffer) throws IOException {
        int l = this.linebuffer.length();
        {
            {
                boolean varC90433BDC295BDA0712C663BFE02ABD2_2025705470 = (this.linebuffer.byteAt(l - 1) == HTTP.LF);
                {
                    this.linebuffer.setLength(l);
                } 
            } 
            {
                {
                    boolean var4AD0E6932E39BC4F55122F4276BA041B_43184543 = (this.linebuffer.byteAt(l - 1) == HTTP.CR);
                    {
                        this.linebuffer.setLength(l);
                    } 
                } 
            } 
        } 
        l = this.linebuffer.length();
        {
            charbuffer.append(this.linebuffer, 0, l);
        } 
        {
            String s = new String(this.linebuffer.buffer(), 0, l, this.charset);
            charbuffer.append(s);
        } 
        addTaint(charbuffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1949129694 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1949129694;
        
        
        
            
                
                
            
            
                
                    
                    
                
            
        
        
        
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.655 -0400", hash_original_method = "E6FBFD5C83985C7D6E27D18B8C3822A9", hash_generated_method = "62BCEF0AA9D542756C487DE8C23BC61B")
    private int lineFromReadBuffer(final CharArrayBuffer charbuffer, int pos) throws IOException {
        int off = this.bufferpos;
        int len;
        this.bufferpos = pos + 1;
        len = pos - off;
        {
            charbuffer.append(this.buffer, off, len);
        } 
        {
            String s = new String(this.buffer, off, len, this.charset);
            charbuffer.append(s);
        } 
        addTaint(charbuffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1541581784 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1541581784;
        
        
        
        
        
            
        
        
        
            
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.656 -0400", hash_original_method = "40CE76C5D842CFEF27650CABF8F97946", hash_generated_method = "86C2B4E5CDEA30CE113CFC41679E6120")
    public String readLine() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_1125912682 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1048572541 = null; 
        CharArrayBuffer charbuffer = new CharArrayBuffer(64);
        int l = readLine(charbuffer);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1125912682 = charbuffer.toString();
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1048572541 = null;
        } 
        String varA7E53CE21691AB073D9660D615818899_1806876120; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1806876120 = varB4EAC82CA7396A68D541C85D26508E83_1125912682;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1806876120 = varB4EAC82CA7396A68D541C85D26508E83_1048572541;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1806876120.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1806876120;
        
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.656 -0400", hash_original_method = "E82E77AA369AC2B118042C614F644F5C", hash_generated_method = "9178ED0A38597F636C9DD7F2949C743A")
    public HttpTransportMetrics getMetrics() {
        HttpTransportMetrics varB4EAC82CA7396A68D541C85D26508E83_263375463 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_263375463 = this.metrics;
        varB4EAC82CA7396A68D541C85D26508E83_263375463.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_263375463;
        
        
    }

    
}

