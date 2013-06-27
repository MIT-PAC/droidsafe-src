package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.918 -0400", hash_original_field = "02CC731E1E3C3F77A09E03A9FC603C18", hash_generated_field = "9B0F52B8C31A449A2E624B8847C753E5")

    private InputStream instream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.918 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "67DBC7965A32AEE1CAB7B25294021930")

    private byte[] buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.918 -0400", hash_original_field = "5D7FCA0A7C90E911DFFF5A1B20AD46DF", hash_generated_field = "C38A316D53C22723B1202376C6917B3F")

    private int bufferpos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.918 -0400", hash_original_field = "83B3BB8A1D8CBB47A5D96A13240DA9D8", hash_generated_field = "296206540354C2045FC39BBE1B298B67")

    private int bufferlen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.918 -0400", hash_original_field = "B2C5177846F78CF14F2FAE7CA0C86EEB", hash_generated_field = "0CC6340E9144F7E622BCBFBE8F5F5CB5")

    private ByteArrayBuffer linebuffer = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.918 -0400", hash_original_field = "6AF027F2A1AB832A1E028F7C18CA5687", hash_generated_field = "76BAEB11C3552BFB23E0B4B99A533DB1")

    private String charset = HTTP.US_ASCII;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.918 -0400", hash_original_field = "EF253EBC8AB611F3735C35E53DC2547D", hash_generated_field = "9303ABFC1EF5CEEB446DE036D38A5721")

    private boolean ascii = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.918 -0400", hash_original_field = "E5CE8744D71F278EA7C2031220AD2484", hash_generated_field = "5CA0E4EE0481DA70634C383CF4BE2DA3")

    private int maxLineLen = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.918 -0400", hash_original_field = "AA59D67C2123F094D0D6798FFE651C4D", hash_generated_field = "D608E8E883C0ADFB9BB241D869189B8C")

    private HttpTransportMetricsImpl metrics;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.918 -0400", hash_original_method = "C27F370149363385AD6F9F81753F4445", hash_generated_method = "C27F370149363385AD6F9F81753F4445")
    public AbstractSessionInputBuffer ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.962 -0400", hash_original_method = "9ACC7C380ECF9A2AF3368BF4FBEC1DC4", hash_generated_method = "D39B636707B50749483D162D68D5B637")
    protected void init(final InputStream instream, int buffersize, final HttpParams params) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Input stream may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Buffer size may not be negative or zero");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP parameters may not be null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.969 -0400", hash_original_method = "AED6430DDF1A78B7022960A54C9608D3", hash_generated_method = "036AC0A3A7FCC4E84EF3E045D9D5431D")
    protected int fillBuffer() throws IOException {
        {
            int len;
            len = this.bufferlen - this.bufferpos;
            {
                System.arraycopy(this.buffer, this.bufferpos, this.buffer, 0, len);
            } //End block
            this.bufferpos = 0;
            this.bufferlen = len;
        } //End block
        int l;
        int off;
        off = this.bufferlen;
        int len;
        len = this.buffer.length - off;
        l = this.instream.read(this.buffer, off, len);
        {
            this.bufferlen = off + l;
            this.metrics.incrementBytesTransferred(l);
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1503822809 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1503822809;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.970 -0400", hash_original_method = "BAC6DE94AA32B94037307F5D6F9840B7", hash_generated_method = "7A7D4271C4873CCE13FBF4B31760A764")
    protected boolean hasBufferedData() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_895448798 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_895448798;
        // ---------- Original Method ----------
        //return this.bufferpos < this.bufferlen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.970 -0400", hash_original_method = "E463AA34023422AC03B9513A2E94EA6B", hash_generated_method = "7B73FD3A1C807F1DAB999840B7C12C83")
    public int read() throws IOException {
        int noRead;
        noRead = 0;
        {
            boolean varD210C1373B6FBB590F5BF990F9119C91_816005458 = (!hasBufferedData());
            {
                noRead = fillBuffer();
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_647650579 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_647650579;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.971 -0400", hash_original_method = "5A83C8A4FAF4774EC1C7C0472F5C75E8", hash_generated_method = "62C1FD231C1B9C4D12408DDA53305F8A")
    public int read(final byte[] b, int off, int len) throws IOException {
        int noRead;
        noRead = 0;
        {
            boolean varD210C1373B6FBB590F5BF990F9119C91_1490304121 = (!hasBufferedData());
            {
                noRead = fillBuffer();
            } //End block
        } //End collapsed parenthetic
        int chunk;
        chunk = this.bufferlen - this.bufferpos;
        {
            chunk = len;
        } //End block
        System.arraycopy(this.buffer, this.bufferpos, b, off, chunk);
        this.bufferpos += chunk;
        addTaint(b[0]);
        addTaint(off);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_795898169 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_795898169;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.971 -0400", hash_original_method = "EA19DAA67F217B43FC33D4721E7544D2", hash_generated_method = "2CA3011506D039C298F5D52C5CC2ABBC")
    public int read(final byte[] b) throws IOException {
        int var38A74F3EE8B05A9B738F2B8C0F60B1F0_467767108 = (read(b, 0, b.length));
        addTaint(b[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_29469121 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_29469121;
        // ---------- Original Method ----------
        //if (b == null) {
            //return 0;
        //}
        //return read(b, 0, b.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.972 -0400", hash_original_method = "25E4831B40662E7C69D1371A042407AC", hash_generated_method = "63B61F3C50F2B50E704EE292131FC1C6")
    private int locateLF() {
        {
            int i;
            i = this.bufferpos;
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1378867400 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1378867400;
        // ---------- Original Method ----------
        //for (int i = this.bufferpos; i < this.bufferlen; i++) {
            //if (this.buffer[i] == HTTP.LF) {
                //return i;
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.982 -0400", hash_original_method = "473C0DD8FF067FE4EC2BE597B4124765", hash_generated_method = "CC4D4761808EBA8491D19E825492A0CE")
    public int readLine(final CharArrayBuffer charbuffer) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Char array buffer may not be null");
        } //End block
        this.linebuffer.clear();
        int noRead;
        noRead = 0;
        boolean retry;
        retry = true;
        {
            int i;
            i = locateLF();
            {
                {
                    boolean varEBE8EA489B47F8DB0AE71744DD2E6C95_248144545 = (this.linebuffer.isEmpty());
                    {
                        int var297CA58D99A61AD49D3A628841BFAD8C_521076783 = (lineFromReadBuffer(charbuffer, i));
                    } //End block
                } //End collapsed parenthetic
                retry = false;
                int len;
                len = i + 1 - this.bufferpos;
                this.linebuffer.append(this.buffer, this.bufferpos, len);
                this.bufferpos = i + 1;
            } //End block
            {
                {
                    boolean varAEA5FA52AEDB2545ECF9D26B26ACDD70_793397532 = (hasBufferedData());
                    {
                        int len;
                        len = this.bufferlen - this.bufferpos;
                        this.linebuffer.append(this.buffer, this.bufferpos, len);
                        this.bufferpos = this.bufferlen;
                    } //End block
                } //End collapsed parenthetic
                noRead = fillBuffer();
                {
                    retry = false;
                } //End block
            } //End block
            {
                boolean var7235849E2B0B7AC365A0707BE1ACD937_564987619 = (this.maxLineLen > 0 && this.linebuffer.length() >= this.maxLineLen);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("Maximum line length limit exceeded");
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var7DF2E4704BE4B8408E4250829EA440A6_970097642 = (noRead == -1 && this.linebuffer.isEmpty());
        } //End collapsed parenthetic
        int varCEC600CF2A719499A0A9466F62AF2872_409560393 = (lineFromLineBuffer(charbuffer));
        addTaint(charbuffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1728962071 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1728962071;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.983 -0400", hash_original_method = "729842E116E7795B9747338D0779180E", hash_generated_method = "774F1FE01F57ABC732996489C0B2DD1F")
    private int lineFromLineBuffer(final CharArrayBuffer charbuffer) throws IOException {
        int l;
        l = this.linebuffer.length();
        {
            {
                boolean varC90433BDC295BDA0712C663BFE02ABD2_748798531 = (this.linebuffer.byteAt(l - 1) == HTTP.LF);
                {
                    this.linebuffer.setLength(l);
                } //End block
            } //End collapsed parenthetic
            {
                {
                    boolean var4AD0E6932E39BC4F55122F4276BA041B_244613239 = (this.linebuffer.byteAt(l - 1) == HTTP.CR);
                    {
                        this.linebuffer.setLength(l);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        l = this.linebuffer.length();
        {
            charbuffer.append(this.linebuffer, 0, l);
        } //End block
        {
            String s;
            s = new String(this.linebuffer.buffer(), 0, l, this.charset);
            charbuffer.append(s);
        } //End block
        addTaint(charbuffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_46902614 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_46902614;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.985 -0400", hash_original_method = "E6FBFD5C83985C7D6E27D18B8C3822A9", hash_generated_method = "CE0FEAC1BB53645487DD6894F0C6C87A")
    private int lineFromReadBuffer(final CharArrayBuffer charbuffer, int pos) throws IOException {
        int off;
        off = this.bufferpos;
        int len;
        this.bufferpos = pos + 1;
        len = pos - off;
        {
            charbuffer.append(this.buffer, off, len);
        } //End block
        {
            String s;
            s = new String(this.buffer, off, len, this.charset);
            charbuffer.append(s);
        } //End block
        addTaint(charbuffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_389469121 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_389469121;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.987 -0400", hash_original_method = "40CE76C5D842CFEF27650CABF8F97946", hash_generated_method = "E4B037C2C9FAAE3DA7D280A48A333211")
    public String readLine() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_452728121 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_297762057 = null; //Variable for return #2
        CharArrayBuffer charbuffer;
        charbuffer = new CharArrayBuffer(64);
        int l;
        l = readLine(charbuffer);
        {
            varB4EAC82CA7396A68D541C85D26508E83_452728121 = charbuffer.toString();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_297762057 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1270513681; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1270513681 = varB4EAC82CA7396A68D541C85D26508E83_452728121;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1270513681 = varB4EAC82CA7396A68D541C85D26508E83_297762057;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1270513681.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1270513681;
        // ---------- Original Method ----------
        //CharArrayBuffer charbuffer = new CharArrayBuffer(64);
        //int l = readLine(charbuffer);
        //if (l != -1) {
            //return charbuffer.toString();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.991 -0400", hash_original_method = "E82E77AA369AC2B118042C614F644F5C", hash_generated_method = "FC6476EEDAF55CFBEA6644001978F3A4")
    public HttpTransportMetrics getMetrics() {
        HttpTransportMetrics varB4EAC82CA7396A68D541C85D26508E83_618536221 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_618536221 = this.metrics;
        varB4EAC82CA7396A68D541C85D26508E83_618536221.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_618536221;
        // ---------- Original Method ----------
        //return this.metrics;
    }

    
}

