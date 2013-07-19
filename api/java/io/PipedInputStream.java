package java.io;

// Droidsafe Imports
import java.util.Arrays;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class PipedInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.150 -0400", hash_original_field = "231D9796F07169E79A8FE9CAFA5AE69C", hash_generated_field = "F5A62F451E05D22096D6EE6BA212D601")

    private Thread lastReader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.150 -0400", hash_original_field = "E1009AE69BA1CE27303C8FCB7B3693F1", hash_generated_field = "276A7969C85F5DE4B1F84464F2E355FA")

    private Thread lastWriter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.150 -0400", hash_original_field = "7587750400D3C39AEAD7C1489F6FE7F3", hash_generated_field = "61C76B683BBEFCB5006250611D355A94")

    private boolean isClosed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.150 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "FBA3E90E1AEF84B9DE40F7F93AE8B84B")

    protected byte[] buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.150 -0400", hash_original_field = "9AE8C0B11714442FC9030E9DA4B97E4C", hash_generated_field = "58862AB4E2B0CB5FD1377E7AA508B6BA")

    protected int in = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.150 -0400", hash_original_field = "C68271A63DDBC431C307BEB7D2918275", hash_generated_field = "B9DAD1FC7D32BD3FCCD6EA20CBE64C1B")

    protected int out;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.150 -0400", hash_original_field = "8CADFAB0F66545464EF713B1AEC0C7DD", hash_generated_field = "63EA3415F69DFBAE1E285FCFD4110E54")

    boolean isConnected;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.150 -0400", hash_original_method = "EAE18C87236155EAE738625B0EE95D6C", hash_generated_method = "D3E67D51FFBABB34996E2D70DC239248")
    public  PipedInputStream() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.151 -0400", hash_original_method = "5C6A295DEF226D787CAB21BFAF549F52", hash_generated_method = "FF70040C8E3B850B9D161B1AC6867330")
    public  PipedInputStream(PipedOutputStream out) throws IOException {
        addTaint(out.getTaint());
        connect(out);
        // ---------- Original Method ----------
        //connect(out);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.151 -0400", hash_original_method = "E71321ED2FFA70E9F11724EE1BE224BC", hash_generated_method = "F9B244DCB21A45148F8093B41DE071DB")
    public  PipedInputStream(int pipeSize) {
        if(pipeSize <= 0)        
        {
            IllegalArgumentException var14B56B7417000A6322DBDC3AD243C74B_1001318054 = new IllegalArgumentException("pipe size " + pipeSize + " too small");
            var14B56B7417000A6322DBDC3AD243C74B_1001318054.addTaint(taint);
            throw var14B56B7417000A6322DBDC3AD243C74B_1001318054;
        } //End block
        buffer = new byte[pipeSize];
        // ---------- Original Method ----------
        //if (pipeSize <= 0) {
            //throw new IllegalArgumentException("pipe size " + pipeSize + " too small");
        //}
        //buffer = new byte[pipeSize];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.151 -0400", hash_original_method = "A3EF9AC77ADE8608AA265A4D24E9A500", hash_generated_method = "BDAD7C2C5CDCD39A076E9FFB309624E4")
    public  PipedInputStream(PipedOutputStream out, int pipeSize) throws IOException {
        this(pipeSize);
        addTaint(pipeSize);
        addTaint(out.getTaint());
        connect(out);
        // ---------- Original Method ----------
        //connect(out);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.152 -0400", hash_original_method = "2A98E1CFDF4B9A3EC436EF3BA87395EB", hash_generated_method = "97AFC47CEC93EF396B0CA84AD44AF319")
    @Override
    public synchronized int available() throws IOException {
        if(buffer == null || in == -1)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_286036567 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2108388664 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2108388664;
        } //End block
        int var66A5CA4646F3D9C506DDD7A718627107_425030598 = (in <= out ? buffer.length - out + in : in - out);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1678164809 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1678164809;
        // ---------- Original Method ----------
        //if (buffer == null || in == -1) {
            //return 0;
        //}
        //return in <= out ? buffer.length - out + in : in - out;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.153 -0400", hash_original_method = "3F663E82A2EB3C95CA9BF0AFC9912DC8", hash_generated_method = "9C54C673D55F64DD4AC0EE092DC7D204")
    @Override
    public synchronized void close() throws IOException {
        buffer = null;
        notifyAll();
        // ---------- Original Method ----------
        //buffer = null;
        //notifyAll();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.153 -0400", hash_original_method = "577007FA4B30A526722BCCB2926E190B", hash_generated_method = "CF0C2237C89D95FEE3360BC8ED26CA9F")
    public void connect(PipedOutputStream src) throws IOException {
        addTaint(src.getTaint());
        src.connect(this);
        // ---------- Original Method ----------
        //src.connect(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.154 -0400", hash_original_method = "5C9219C47AC485F782454E337FD705F5", hash_generated_method = "B673961F827DD2979B3B9D3B8D9AFC6D")
    synchronized void establishConnection() throws IOException {
        if(isConnected)        
        {
            IOException var59E3110525112AD12A0795267BCC8DC7_1827469950 = new IOException("Pipe already connected");
            var59E3110525112AD12A0795267BCC8DC7_1827469950.addTaint(taint);
            throw var59E3110525112AD12A0795267BCC8DC7_1827469950;
        } //End block
        if(buffer == null)        
        {
            buffer = new byte[PipedInputStream.PIPE_SIZE];
        } //End block
        isConnected = true;
        // ---------- Original Method ----------
        //if (isConnected) {
            //throw new IOException("Pipe already connected");
        //}
        //if (buffer == null) { 
            //buffer = new byte[PipedInputStream.PIPE_SIZE];
        //}
        //isConnected = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.155 -0400", hash_original_method = "2CE52A22634017D3B9A1E29444B8338A", hash_generated_method = "B0E8026E3CCE6004E2894AE2CBDCDB09")
    @Override
    public synchronized int read() throws IOException {
        if(!isConnected)        
        {
            IOException var5ACBC0578C8271E4B1FBA9054656F0A9_1528456416 = new IOException("Not connected");
            var5ACBC0578C8271E4B1FBA9054656F0A9_1528456416.addTaint(taint);
            throw var5ACBC0578C8271E4B1FBA9054656F0A9_1528456416;
        } //End block
        if(buffer == null)        
        {
            IOException var49FC1A6C11DB0A4BE9BF7960D4D933DF_1784527205 = new IOException("InputStream is closed");
            var49FC1A6C11DB0A4BE9BF7960D4D933DF_1784527205.addTaint(taint);
            throw var49FC1A6C11DB0A4BE9BF7960D4D933DF_1784527205;
        } //End block
        lastReader = Thread.currentThread();
        try 
        {
            int attempts = 3;
            while
(in == -1)            
            {
                if(isClosed)                
                {
                    int var6BB61E3B7BCE0931DA574D19D1D82C88_815518033 = (-1);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_164662458 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_164662458;
                } //End block
                if((attempts-- <= 0) && lastWriter != null && !lastWriter.isAlive())                
                {
                    IOException var21F067B593CB8DB6DCADD1F25439FAC6_1726107566 = new IOException("Pipe broken");
                    var21F067B593CB8DB6DCADD1F25439FAC6_1726107566.addTaint(taint);
                    throw var21F067B593CB8DB6DCADD1F25439FAC6_1726107566;
                } //End block
                notifyAll();
                wait(1000);
            } //End block
        } //End block
        catch (InterruptedException e)
        {
            InterruptedIOException var46B941F497A45BD71FFF5B2BE2F4FCEC_1642562278 = new InterruptedIOException();
            var46B941F497A45BD71FFF5B2BE2F4FCEC_1642562278.addTaint(taint);
            throw var46B941F497A45BD71FFF5B2BE2F4FCEC_1642562278;
        } //End block
        int result = buffer[out++] & 0xff;
        if(out == buffer.length)        
        {
            out = 0;
        } //End block
        if(out == in)        
        {
            in = -1;
            out = 0;
        } //End block
        notifyAll();
        int varB4A88417B3D0170D754C647C30B7216A_1552701844 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_485178524 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_485178524;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.159 -0400", hash_original_method = "D28D662CAD3AC901637BA85FDFEE5B3E", hash_generated_method = "2F1CBCF09B284FB2E2167D2520A3AA4B")
    @Override
    public synchronized int read(byte[] bytes, int offset, int byteCount) throws IOException {
        addTaint(byteCount);
        addTaint(offset);
        addTaint(bytes[0]);
        Arrays.checkOffsetAndCount(bytes.length, offset, byteCount);
        if(byteCount == 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1281771833 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_548084693 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_548084693;
        } //End block
        if(!isConnected)        
        {
            IOException var5ACBC0578C8271E4B1FBA9054656F0A9_216208241 = new IOException("Not connected");
            var5ACBC0578C8271E4B1FBA9054656F0A9_216208241.addTaint(taint);
            throw var5ACBC0578C8271E4B1FBA9054656F0A9_216208241;
        } //End block
        if(buffer == null)        
        {
            IOException var49FC1A6C11DB0A4BE9BF7960D4D933DF_48655115 = new IOException("InputStream is closed");
            var49FC1A6C11DB0A4BE9BF7960D4D933DF_48655115.addTaint(taint);
            throw var49FC1A6C11DB0A4BE9BF7960D4D933DF_48655115;
        } //End block
        lastReader = Thread.currentThread();
        try 
        {
            int attempts = 3;
            while
(in == -1)            
            {
                if(isClosed)                
                {
                    int var6BB61E3B7BCE0931DA574D19D1D82C88_259373980 = (-1);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1081178276 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1081178276;
                } //End block
                if((attempts-- <= 0) && lastWriter != null && !lastWriter.isAlive())                
                {
                    IOException var21F067B593CB8DB6DCADD1F25439FAC6_971691700 = new IOException("Pipe broken");
                    var21F067B593CB8DB6DCADD1F25439FAC6_971691700.addTaint(taint);
                    throw var21F067B593CB8DB6DCADD1F25439FAC6_971691700;
                } //End block
                notifyAll();
                wait(1000);
            } //End block
        } //End block
        catch (InterruptedException e)
        {
            InterruptedIOException var46B941F497A45BD71FFF5B2BE2F4FCEC_511548753 = new InterruptedIOException();
            var46B941F497A45BD71FFF5B2BE2F4FCEC_511548753.addTaint(taint);
            throw var46B941F497A45BD71FFF5B2BE2F4FCEC_511548753;
        } //End block
        int totalCopied = 0;
        if(out >= in)        
        {
            int leftInBuffer = buffer.length - out;
            int length = leftInBuffer < byteCount ? leftInBuffer : byteCount;
            System.arraycopy(buffer, out, bytes, offset, length);
            out += length;
            if(out == buffer.length)            
            {
                out = 0;
            } //End block
            if(out == in)            
            {
                in = -1;
                out = 0;
            } //End block
            totalCopied += length;
        } //End block
        if(totalCopied < byteCount && in != -1)        
        {
            int leftInBuffer = in - out;
            int leftToCopy = byteCount - totalCopied;
            int length = leftToCopy < leftInBuffer ? leftToCopy : leftInBuffer;
            System.arraycopy(buffer, out, bytes, offset + totalCopied, length);
            out += length;
            if(out == in)            
            {
                in = -1;
                out = 0;
            } //End block
            totalCopied += length;
        } //End block
        notifyAll();
        int varB401FFFD57D1F4ACC4CA5F4F04A9D9A7_1099220902 = (totalCopied);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2105476567 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2105476567;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.161 -0400", hash_original_method = "F1DDF844B79F62E2699AFB2EF26553A3", hash_generated_method = "32238708859EFF4E9B4F5152ED4E0B86")
    protected synchronized void receive(int oneByte) throws IOException {
        if(buffer == null || isClosed)        
        {
            IOException var1000524CAB3836FE6B4154A68C06F70C_666959142 = new IOException("Pipe is closed");
            var1000524CAB3836FE6B4154A68C06F70C_666959142.addTaint(taint);
            throw var1000524CAB3836FE6B4154A68C06F70C_666959142;
        } //End block
        lastWriter = Thread.currentThread();
        try 
        {
            while
(buffer != null && out == in)            
            {
                if(lastReader != null && !lastReader.isAlive())                
                {
                    IOException var21F067B593CB8DB6DCADD1F25439FAC6_1898428633 = new IOException("Pipe broken");
                    var21F067B593CB8DB6DCADD1F25439FAC6_1898428633.addTaint(taint);
                    throw var21F067B593CB8DB6DCADD1F25439FAC6_1898428633;
                } //End block
                notifyAll();
                wait(1000);
            } //End block
        } //End block
        catch (InterruptedException e)
        {
            InterruptedIOException var46B941F497A45BD71FFF5B2BE2F4FCEC_1985153882 = new InterruptedIOException();
            var46B941F497A45BD71FFF5B2BE2F4FCEC_1985153882.addTaint(taint);
            throw var46B941F497A45BD71FFF5B2BE2F4FCEC_1985153882;
        } //End block
        if(buffer == null)        
        {
            IOException var1000524CAB3836FE6B4154A68C06F70C_1446403172 = new IOException("Pipe is closed");
            var1000524CAB3836FE6B4154A68C06F70C_1446403172.addTaint(taint);
            throw var1000524CAB3836FE6B4154A68C06F70C_1446403172;
        } //End block
        if(in == -1)        
        {
            in = 0;
        } //End block
        buffer[in++] = (byte) oneByte;
        if(in == buffer.length)        
        {
            in = 0;
        } //End block
        notifyAll();
        // ---------- Original Method ----------
        //if (buffer == null || isClosed) {
            //throw new IOException("Pipe is closed");
        //}
        //lastWriter = Thread.currentThread();
        //try {
            //while (buffer != null && out == in) {
                //if (lastReader != null && !lastReader.isAlive()) {
                    //throw new IOException("Pipe broken");
                //}
                //notifyAll();
                //wait(1000);
            //}
        //} catch (InterruptedException e) {
            //throw new InterruptedIOException();
        //}
        //if (buffer == null) {
            //throw new IOException("Pipe is closed");
        //}
        //if (in == -1) {
            //in = 0;
        //}
        //buffer[in++] = (byte) oneByte;
        //if (in == buffer.length) {
            //in = 0;
        //}
        //notifyAll();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.162 -0400", hash_original_method = "19BFAB2AD4E1A13AD9CB12419968F5AB", hash_generated_method = "0196391A7590C9F432C6D9A3A742BE34")
    synchronized void done() {
        isClosed = true;
        notifyAll();
        // ---------- Original Method ----------
        //isClosed = true;
        //notifyAll();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.162 -0400", hash_original_field = "DD1669F2E42B518F13205231CA7F8736", hash_generated_field = "98981E77F477BF5BC6052D8850C465A7")

    protected static final int PIPE_SIZE = 1024;
}

