package android.net;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketOptions;






class LocalSocketImpl {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.274 -0400", hash_original_field = "37AB815C056B5C5F600F6AC93E486A78", hash_generated_field = "355E2A769FEE7E54D6F0256760F338B6")

    private SocketInputStream fis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.274 -0400", hash_original_field = "E571B045697D6C923B7E4487896BC777", hash_generated_field = "8156E266B6831DBC7B3771E7C35EF804")

    private SocketOutputStream fos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.274 -0400", hash_original_field = "98A1C2694E60856C3A255575198C7FAC", hash_generated_field = "201F2893E6616F00DF8FC16933452C93")

    private Object readMonitor = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.274 -0400", hash_original_field = "14AF2371FED66FD8E7EA1FDDEA86200F", hash_generated_field = "3AEEFF96894C6EA6FF9C01F76A902604")

    private Object writeMonitor = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.274 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

    private FileDescriptor fd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.274 -0400", hash_original_field = "91BAD7D60B635067305F0AA2C6DB835F", hash_generated_field = "9CF2319FEDB29C1E6FE6830C6EF0FC50")

    FileDescriptor[] inboundFileDescriptors;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.275 -0400", hash_original_field = "F5B8F5BA74B58179A54A9DC552D2C1C9", hash_generated_field = "5C2DA72A39F5E44715644D1AB34D0887")

    FileDescriptor[] outboundFileDescriptors;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.275 -0400", hash_original_method = "EB46FEA2FE489ABD86FB64E17870F7D5", hash_generated_method = "CD8997B5BBD288454729017F9D0FB34B")
      LocalSocketImpl() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.275 -0400", hash_original_method = "D456C6C1E42DF15F5B9AFA3DF483BFD5", hash_generated_method = "B8BE2A9636FAA52F24039EE3D67E5778")
      LocalSocketImpl(FileDescriptor fd) throws IOException {
        this.fd = fd;
        // ---------- Original Method ----------
        //this.fd = fd;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.288 -0400", hash_original_method = "2758981D1030A8FDA90CA71A02304595", hash_generated_method = "755E5F20E9DB55D53B815346ACBFAB2A")
    private int available_native(FileDescriptor fd) throws IOException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1892960729 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1892960729;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.288 -0400", hash_original_method = "C4F1C4509B0A008CEB1A520A33B1432C", hash_generated_method = "65052700D9C4973B893CD8795118A216")
    private void close_native(FileDescriptor fd) throws IOException {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.288 -0400", hash_original_method = "C5E1B2BCA848D2C54F079D7825712FAA", hash_generated_method = "CFE95F26B486B9A816B3E4557DCFD284")
    private int read_native(FileDescriptor fd) throws IOException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1971810701 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1971810701;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.288 -0400", hash_original_method = "6C0CD8F9940E6252A80F192C7FCEF247", hash_generated_method = "DF39E7525E3733510A2EB6E370728F0B")
    private int readba_native(byte[] b, int off, int len,
            FileDescriptor fd) throws IOException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2103883808 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2103883808;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.288 -0400", hash_original_method = "411B6D80F43D59E374103A18918D197B", hash_generated_method = "FD1B0D2DA87E5E80BACB15431ECDA287")
    private void writeba_native(byte[] b, int off, int len,
            FileDescriptor fd) throws IOException {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.288 -0400", hash_original_method = "EC6860394B0EC0B22E9CA8C353E6B2CD", hash_generated_method = "835004AB0F491C4E0A07CDC42E7C75E8")
    private void write_native(int b, FileDescriptor fd) throws IOException {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.288 -0400", hash_original_method = "FB81706A2E5D939365DC1E11BB4FE7D5", hash_generated_method = "8D9BD02ECD0E57124CC839B8088FFC25")
    private void connectLocal(FileDescriptor fd, String name,
            int namespace) throws IOException {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.288 -0400", hash_original_method = "62C617B37F715EB0C7D8B05FC6062D1C", hash_generated_method = "D330883423CE48AEB21D6EDBB834187E")
    private void bindLocal(FileDescriptor fd, String name, int namespace) throws IOException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.248 -0400", hash_original_method = "91E7A83B201CCE6F03E99B6B97993D3C", hash_generated_method = "BF4DB921189260FDA30B994461CFCF87")
    private FileDescriptor create_native(boolean stream) throws IOException {
        FileDescriptor fd = new FileDescriptor();
        fd.addTaint(this.taint);
        return fd;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.289 -0400", hash_original_method = "565F45EE1777149341C55D43CF68422B", hash_generated_method = "2AF7CD29BD9A03ADED92A7A2D76B8EE6")
    private void listen_native(FileDescriptor fd, int backlog) throws IOException {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.289 -0400", hash_original_method = "AE79C436903413982C1AAE7FD29B4B48", hash_generated_method = "92ADCFCA446C23326021228A20115975")
    private void shutdown(FileDescriptor fd, boolean shutdownInput) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.248 -0400", hash_original_method = "0137F99D53D5E10D02D5A211BB31B969", hash_generated_method = "5F1B13E48615D9E4FD0789735B8F4C85")
    private Credentials getPeerCredentials_native(
            FileDescriptor fd) throws IOException {
    	Credentials creds = new Credentials(0, 0, 0);
    	creds.addTaint(this.taint);
    	return creds;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.289 -0400", hash_original_method = "57547C3595B23A135CCDE37FD7052F1D", hash_generated_method = "00A52F16301BC4E06FFF256FC3D8F983")
    private int getOption_native(FileDescriptor fd, int optID) throws IOException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_531425282 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_531425282;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.289 -0400", hash_original_method = "DE678D0521D206818FAC33E612ECDEF9", hash_generated_method = "9958FF02EB38A803062C9BF2F8520BBE")
    private void setOption_native(FileDescriptor fd, int optID,
            int b, int value) throws IOException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.249 -0400", hash_original_method = "AD93B21D07861EA052C26EC40030E4DA", hash_generated_method = "0BA24B5688D235E53CBDA81423459803")
    private FileDescriptor accept(FileDescriptor fd, LocalSocketImpl s) throws IOException {
        FileDescriptor fd2 = new FileDescriptor();
        fd2.addTaint(this.taint);
        return fd2;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.289 -0400", hash_original_method = "910906868F2A4F19B7D2844E1F779346", hash_generated_method = "FF4C18BB2A0EB53E08443A077A9982B2")
    public String toString() {
String varBBD38A3C72C38F43F51C318DEB0F7748_1511748788 =         super.toString() + " fd:" + fd;
        varBBD38A3C72C38F43F51C318DEB0F7748_1511748788.addTaint(taint);
        return varBBD38A3C72C38F43F51C318DEB0F7748_1511748788;
        // ---------- Original Method ----------
        //return super.toString() + " fd:" + fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.289 -0400", hash_original_method = "C69FBA5615AE4C555A8E605188FC5D70", hash_generated_method = "C22F029603B3F0814C57D1F60D6F7436")
    public void create(boolean stream) throws IOException {
        if(fd == null)        
        {
            fd = create_native(stream);
        } //End block
        // ---------- Original Method ----------
        //if (fd == null) {
            //fd = create_native(stream);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.290 -0400", hash_original_method = "ABF18B5E6666C8F5D8A2BB5F41F5792B", hash_generated_method = "94AB9414F9996A7C53DD1FDF39E90B20")
    public void close() throws IOException {
        synchronized
(LocalSocketImpl.this)        {
            if(fd == null)            
            return;
            close_native(fd);
            fd = null;
        } //End block
        // ---------- Original Method ----------
        //synchronized (LocalSocketImpl.this) {
            //if (fd == null) return;
            //close_native(fd);
            //fd = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.290 -0400", hash_original_method = "425C245C15643B6C00C58E49D6A6C651", hash_generated_method = "A7DC54F0D374361ADC09928C14E6CAB2")
    protected void connect(LocalSocketAddress address, int timeout) throws IOException {
        addTaint(timeout);
        addTaint(address.getTaint());
        if(fd == null)        
        {
            IOException varD7C4099B93ACF61FB97254FAACA9EEB7_553271073 = new IOException("socket not created");
            varD7C4099B93ACF61FB97254FAACA9EEB7_553271073.addTaint(taint);
            throw varD7C4099B93ACF61FB97254FAACA9EEB7_553271073;
        } //End block
        connectLocal(fd, address.getName(), address.getNamespace().getId());
        // ---------- Original Method ----------
        //if (fd == null) {
            //throw new IOException("socket not created");
        //}
        //connectLocal(fd, address.getName(), address.getNamespace().getId());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.290 -0400", hash_original_method = "D301FBD428349B466ACCB27339A08D2F", hash_generated_method = "D72A523D7DE5E582FCD8B8618424BC8B")
    public void bind(LocalSocketAddress endpoint) throws IOException {
        addTaint(endpoint.getTaint());
        if(fd == null)        
        {
            IOException varD7C4099B93ACF61FB97254FAACA9EEB7_2138470097 = new IOException("socket not created");
            varD7C4099B93ACF61FB97254FAACA9EEB7_2138470097.addTaint(taint);
            throw varD7C4099B93ACF61FB97254FAACA9EEB7_2138470097;
        } //End block
        bindLocal(fd, endpoint.getName(), endpoint.getNamespace().getId());
        // ---------- Original Method ----------
        //if (fd == null) {
            //throw new IOException("socket not created");
        //}
        //bindLocal(fd, endpoint.getName(), endpoint.getNamespace().getId());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.290 -0400", hash_original_method = "A6DEE76A07DA4242CC30FE3245F17D51", hash_generated_method = "864C6D3905D5F43009A76E6829A7841E")
    protected void listen(int backlog) throws IOException {
        addTaint(backlog);
        if(fd == null)        
        {
            IOException varD7C4099B93ACF61FB97254FAACA9EEB7_678920576 = new IOException("socket not created");
            varD7C4099B93ACF61FB97254FAACA9EEB7_678920576.addTaint(taint);
            throw varD7C4099B93ACF61FB97254FAACA9EEB7_678920576;
        } //End block
        listen_native(fd, backlog);
        // ---------- Original Method ----------
        //if (fd == null) {
            //throw new IOException("socket not created");
        //}
        //listen_native(fd, backlog);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.290 -0400", hash_original_method = "E2D863498299C9CF5B0AE6150A21C675", hash_generated_method = "858E3B86BDFF6929BC2848C53CB560EA")
    protected void accept(LocalSocketImpl s) throws IOException {
        if(fd == null)        
        {
            IOException varD7C4099B93ACF61FB97254FAACA9EEB7_537830910 = new IOException("socket not created");
            varD7C4099B93ACF61FB97254FAACA9EEB7_537830910.addTaint(taint);
            throw varD7C4099B93ACF61FB97254FAACA9EEB7_537830910;
        } //End block
        s.fd = accept(fd, s);
        // ---------- Original Method ----------
        //if (fd == null) {
            //throw new IOException("socket not created");
        //}
        //s.fd = accept(fd, s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.290 -0400", hash_original_method = "D37322C17A1B9B191A9C32D9BD81E000", hash_generated_method = "BC49FB741B556BC2FDC7C7969DB3F522")
    protected InputStream getInputStream() throws IOException {
        if(fd == null)        
        {
            IOException varD7C4099B93ACF61FB97254FAACA9EEB7_1670996758 = new IOException("socket not created");
            varD7C4099B93ACF61FB97254FAACA9EEB7_1670996758.addTaint(taint);
            throw varD7C4099B93ACF61FB97254FAACA9EEB7_1670996758;
        } //End block
        synchronized
(this)        {
            if(fis == null)            
            {
                fis = new SocketInputStream();
            } //End block
InputStream var52B0B71450302D727BC240B0D6CCA213_1584991739 =             fis;
            var52B0B71450302D727BC240B0D6CCA213_1584991739.addTaint(taint);
            return var52B0B71450302D727BC240B0D6CCA213_1584991739;
        } //End block
        // ---------- Original Method ----------
        //if (fd == null) {
            //throw new IOException("socket not created");
        //}
        //synchronized (this) {
            //if (fis == null) {
                //fis = new SocketInputStream();
            //}
            //return fis;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.291 -0400", hash_original_method = "2E8F2E95CF2F6CF40AEA3B38F9B68B34", hash_generated_method = "F2DBFBCE397A2BD282461B29C0062523")
    protected OutputStream getOutputStream() throws IOException {
        if(fd == null)        
        {
            IOException varD7C4099B93ACF61FB97254FAACA9EEB7_672036303 = new IOException("socket not created");
            varD7C4099B93ACF61FB97254FAACA9EEB7_672036303.addTaint(taint);
            throw varD7C4099B93ACF61FB97254FAACA9EEB7_672036303;
        } //End block
        synchronized
(this)        {
            if(fos == null)            
            {
                fos = new SocketOutputStream();
            } //End block
OutputStream varEF20B018C31FD4204B36935D484B0EEF_84075811 =             fos;
            varEF20B018C31FD4204B36935D484B0EEF_84075811.addTaint(taint);
            return varEF20B018C31FD4204B36935D484B0EEF_84075811;
        } //End block
        // ---------- Original Method ----------
        //if (fd == null) {
            //throw new IOException("socket not created");
        //}
        //synchronized (this) {
            //if (fos == null) {
                //fos = new SocketOutputStream();
            //}
            //return fos;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.291 -0400", hash_original_method = "A7CC818E7F384DAEC54D76069E9C5019", hash_generated_method = "CBDB54AED1DE812598EC39253A842182")
    protected int available() throws IOException {
        int varA225F5703EE5C9EEBF4FCC434C121F39_574312982 = (getInputStream().available());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1854177719 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1854177719;
        // ---------- Original Method ----------
        //return getInputStream().available();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.291 -0400", hash_original_method = "CED8C1FFBDBF9F9E7A40EC2B2E6DD909", hash_generated_method = "AE7B09422B402BEE1CD737B39BFD50EF")
    protected void shutdownInput() throws IOException {
        if(fd == null)        
        {
            IOException varD7C4099B93ACF61FB97254FAACA9EEB7_1868510976 = new IOException("socket not created");
            varD7C4099B93ACF61FB97254FAACA9EEB7_1868510976.addTaint(taint);
            throw varD7C4099B93ACF61FB97254FAACA9EEB7_1868510976;
        } //End block
        shutdown(fd, true);
        // ---------- Original Method ----------
        //if (fd == null) {
            //throw new IOException("socket not created");
        //}
        //shutdown(fd, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.291 -0400", hash_original_method = "DE98B1F2C9FD8DEEFDCE620E4EB90078", hash_generated_method = "228A42812693F4884171A8B3E0834C08")
    protected void shutdownOutput() throws IOException {
        if(fd == null)        
        {
            IOException varD7C4099B93ACF61FB97254FAACA9EEB7_399573486 = new IOException("socket not created");
            varD7C4099B93ACF61FB97254FAACA9EEB7_399573486.addTaint(taint);
            throw varD7C4099B93ACF61FB97254FAACA9EEB7_399573486;
        } //End block
        shutdown(fd, false);
        // ---------- Original Method ----------
        //if (fd == null) {
            //throw new IOException("socket not created");
        //}
        //shutdown(fd, false);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.291 -0400", hash_original_method = "C1B4172ED9A628993584DE4384B8AF55", hash_generated_method = "FB53E7CEE935463A393B7328630A7917")
    protected FileDescriptor getFileDescriptor() {
FileDescriptor var020F72FC5D1BB0511CAD11CC0AA674A0_1270879398 =         fd;
        var020F72FC5D1BB0511CAD11CC0AA674A0_1270879398.addTaint(taint);
        return var020F72FC5D1BB0511CAD11CC0AA674A0_1270879398;
        // ---------- Original Method ----------
        //return fd;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.291 -0400", hash_original_method = "84442B2358C6BD30716C7D72481FD8C4", hash_generated_method = "45EE662505A9C3AF91115EFCAE20E42C")
    protected boolean supportsUrgentData() {
        boolean var68934A3E9455FA72420237EB05902327_426744132 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_854868791 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_854868791;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.291 -0400", hash_original_method = "EC21D6BA9A1DE1709D242100460B4B8C", hash_generated_method = "5376D2944174F4883BA583AEC9F29783")
    protected void sendUrgentData(int data) throws IOException {
        addTaint(data);
        RuntimeException varD5DEB5F8DD6120C266C98497281BDBF0_1480368253 = new RuntimeException ("not impled");
        varD5DEB5F8DD6120C266C98497281BDBF0_1480368253.addTaint(taint);
        throw varD5DEB5F8DD6120C266C98497281BDBF0_1480368253;
        // ---------- Original Method ----------
        //throw new RuntimeException ("not impled");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.292 -0400", hash_original_method = "02CEF5E6368D2209C8707863BE147BD2", hash_generated_method = "E2C4349B0C50237CF47CAEC02CE53FC8")
    public Object getOption(int optID) throws IOException {
        addTaint(optID);
        if(fd == null)        
        {
            IOException varD7C4099B93ACF61FB97254FAACA9EEB7_2135866307 = new IOException("socket not created");
            varD7C4099B93ACF61FB97254FAACA9EEB7_2135866307.addTaint(taint);
            throw varD7C4099B93ACF61FB97254FAACA9EEB7_2135866307;
        } //End block
        if(optID == SocketOptions.SO_TIMEOUT)        
        {
Object varBB30BA0B277E7E114796D8BD84617021_1962462109 =             0;
            varBB30BA0B277E7E114796D8BD84617021_1962462109.addTaint(taint);
            return varBB30BA0B277E7E114796D8BD84617021_1962462109;
        } //End block
        int value = getOption_native(fd, optID);
switch(optID){
        case SocketOptions.SO_RCVBUF:
        case SocketOptions.SO_SNDBUF:
Object varAF280DA2BC37D8BE783D8499160168DE_1795387136 =         value;
        varAF280DA2BC37D8BE783D8499160168DE_1795387136.addTaint(taint);
        return varAF280DA2BC37D8BE783D8499160168DE_1795387136;
        case SocketOptions.SO_REUSEADDR:
        default:
Object varAF280DA2BC37D8BE783D8499160168DE_216741926 =         value;
        varAF280DA2BC37D8BE783D8499160168DE_216741926.addTaint(taint);
        return varAF280DA2BC37D8BE783D8499160168DE_216741926;
}
        // ---------- Original Method ----------
        //if (fd == null) {
            //throw new IOException("socket not created");
        //}
        //if (optID == SocketOptions.SO_TIMEOUT) {
            //return 0;
        //}
        //int value = getOption_native(fd, optID);
        //switch (optID)
        //{
            //case SocketOptions.SO_RCVBUF:
            //case SocketOptions.SO_SNDBUF:
                //return value;
            //case SocketOptions.SO_REUSEADDR:
            //default:
                //return value;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.292 -0400", hash_original_method = "A0313708A2FB484B7104FAC62F0E39B4", hash_generated_method = "D3078AAC700F49A15F2217950BBC828E")
    public void setOption(int optID, Object value) throws IOException {
        addTaint(value.getTaint());
        addTaint(optID);
        int boolValue = -1;
        int intValue = 0;
        if(fd == null)        
        {
            IOException varD7C4099B93ACF61FB97254FAACA9EEB7_1991300794 = new IOException("socket not created");
            varD7C4099B93ACF61FB97254FAACA9EEB7_1991300794.addTaint(taint);
            throw varD7C4099B93ACF61FB97254FAACA9EEB7_1991300794;
        } //End block
        if(value instanceof Integer)        
        {
            intValue = (Integer)value;
        } //End block
        else
        if(value instanceof Boolean)        
        {
            boolValue = ((Boolean) value)? 1 : 0;
        } //End block
        else
        {
            IOException var375460487CF2255639281BC3FBCF008C_1683337865 = new IOException("bad value: " + value);
            var375460487CF2255639281BC3FBCF008C_1683337865.addTaint(taint);
            throw var375460487CF2255639281BC3FBCF008C_1683337865;
        } //End block
        setOption_native(fd, optID, boolValue, intValue);
        // ---------- Original Method ----------
        //int boolValue = -1;
        //int intValue = 0;
        //if (fd == null) {
            //throw new IOException("socket not created");
        //}
        //if (value instanceof Integer) {
            //intValue = (Integer)value;
        //} else if (value instanceof Boolean) {
            //boolValue = ((Boolean) value)? 1 : 0;
        //} else {
            //throw new IOException("bad value: " + value);
        //}
        //setOption_native(fd, optID, boolValue, intValue);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.292 -0400", hash_original_method = "AEC4AD692525702323537BC369199B7F", hash_generated_method = "0145A2A90FD2F3AE28D0747645172228")
    public void setFileDescriptorsForSend(FileDescriptor[] fds) {
        synchronized
(writeMonitor)        {
            outboundFileDescriptors = fds;
        } //End block
        // ---------- Original Method ----------
        //synchronized(writeMonitor) {
            //outboundFileDescriptors = fds;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.292 -0400", hash_original_method = "D444308F286D853D2E5F97ACF37B86DF", hash_generated_method = "63B37F1CF701B0966C4AD58F37A66767")
    public FileDescriptor[] getAncillaryFileDescriptors() throws IOException {
        synchronized
(readMonitor)        {
            FileDescriptor[] result = inboundFileDescriptors;
            inboundFileDescriptors = null;
FileDescriptor[] varDC838461EE2FA0CA4C9BBB70A15456B0_605723690 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_605723690.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_605723690;
        } //End block
        // ---------- Original Method ----------
        //synchronized(readMonitor) {
            //FileDescriptor[] result = inboundFileDescriptors;
            //inboundFileDescriptors = null;
            //return result;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.292 -0400", hash_original_method = "3E3240E544229F6BEFF619755963B808", hash_generated_method = "E5610BCC61E2C16CEA6A1386A8A04E94")
    public Credentials getPeerCredentials() throws IOException {
Credentials var151C0AB12006F1E3EA87BF5023251DA7_312849182 =         getPeerCredentials_native(fd);
        var151C0AB12006F1E3EA87BF5023251DA7_312849182.addTaint(taint);
        return var151C0AB12006F1E3EA87BF5023251DA7_312849182;
        // ---------- Original Method ----------
        //return getPeerCredentials_native(fd);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.293 -0400", hash_original_method = "C6AD39B00524B9355CA4153DB07C4B13", hash_generated_method = "22AE204226B720AA32C12A1825BD7C50")
    public LocalSocketAddress getSockAddress() throws IOException {
LocalSocketAddress var540C13E9E156B687226421B24F2DF178_1905385672 =         null;
        var540C13E9E156B687226421B24F2DF178_1905385672.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1905385672;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.293 -0400", hash_original_method = "CA22E17CA63436350E75BC7DD678FC6C", hash_generated_method = "EE7B698A5C5971F84CA5AA51E8CB3380")
    @Override
    protected void finalize() throws IOException {
        close();
        // ---------- Original Method ----------
        //close();
    }

    
    class SocketInputStream extends InputStream {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.293 -0400", hash_original_method = "AF927FBDB8352BCBCFDDC9969A694B0C", hash_generated_method = "AF927FBDB8352BCBCFDDC9969A694B0C")
        public SocketInputStream ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.293 -0400", hash_original_method = "8F92B1C37F1E7B064EB55148DFA3D6F8", hash_generated_method = "D41B615604C0D73F43CD63A919E56333")
        @Override
        public int available() throws IOException {
            int varC5D231F9AEF85849D71CE1501FCAA953_1998089100 = (available_native(fd));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_173012947 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_173012947;
            // ---------- Original Method ----------
            //return available_native(fd);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.293 -0400", hash_original_method = "C23E504E812AF14B0F4062FED57A7B1E", hash_generated_method = "ECE646958EE00D511DDB45A2F54ADA78")
        @Override
        public void close() throws IOException {
            LocalSocketImpl.this.close();
            // ---------- Original Method ----------
            //LocalSocketImpl.this.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.293 -0400", hash_original_method = "395E06403A9BB7E16A5F2E3FCA2C1758", hash_generated_method = "5AE1DDDE01A8F8E74CE52721B7AF4BD2")
        @Override
        public int read() throws IOException {
            int ret;
            synchronized
(readMonitor)            {
                FileDescriptor myFd = fd;
                if(myFd == null)                
                {
                IOException var5459B998E5CC9DF81A064696FBF5CD9C_2020472912 = new IOException("socket closed");
                var5459B998E5CC9DF81A064696FBF5CD9C_2020472912.addTaint(taint);
                throw var5459B998E5CC9DF81A064696FBF5CD9C_2020472912;
                }
                ret = read_native(myFd);
                int var2CB9DF9898E55FD0AD829DC202DDBD1C_1594992628 = (ret);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2029191149 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2029191149;
            } //End block
            // ---------- Original Method ----------
            //int ret;
            //synchronized (readMonitor) {
                //FileDescriptor myFd = fd;
                //if (myFd == null) throw new IOException("socket closed");
                //ret = read_native(myFd);
                //return ret;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.293 -0400", hash_original_method = "03121A7AC3B4E7519E88953F37DA485C", hash_generated_method = "AEBAEB2B6E7EB8CCF18A351A5EBC0736")
        @Override
        public int read(byte[] b) throws IOException {
            addTaint(b[0]);
            int var3AE1B8835719D1E8BA9C297EF156E04B_936211861 = (read(b, 0, b.length));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_448769993 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_448769993;
            // ---------- Original Method ----------
            //return read(b, 0, b.length);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.294 -0400", hash_original_method = "554DCEA621C79251D4E71F6BA8C4411B", hash_generated_method = "DDFD121CD96DC69722E02A7BB61E348A")
        @Override
        public int read(byte[] b, int off, int len) throws IOException {
            addTaint(len);
            addTaint(off);
            addTaint(b[0]);
            synchronized
(readMonitor)            {
                FileDescriptor myFd = fd;
                if(myFd == null)                
                {
                IOException var5459B998E5CC9DF81A064696FBF5CD9C_919168480 = new IOException("socket closed");
                var5459B998E5CC9DF81A064696FBF5CD9C_919168480.addTaint(taint);
                throw var5459B998E5CC9DF81A064696FBF5CD9C_919168480;
                }
                if(off < 0 || len < 0 || (off + len) > b.length)                
                {
                    ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_1387655753 = new ArrayIndexOutOfBoundsException();
                    var37DB57B1FEB1C9FBA644A093BFA8B678_1387655753.addTaint(taint);
                    throw var37DB57B1FEB1C9FBA644A093BFA8B678_1387655753;
                } //End block
                int ret = readba_native(b, off, len, myFd);
                int var2CB9DF9898E55FD0AD829DC202DDBD1C_1385253704 = (ret);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_96183205 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_96183205;
            } //End block
            // ---------- Original Method ----------
            //synchronized (readMonitor) {
                //FileDescriptor myFd = fd;
                //if (myFd == null) throw new IOException("socket closed");
                //if (off < 0 || len < 0 || (off + len) > b.length ) {
                    //throw new ArrayIndexOutOfBoundsException();
                //}
                //int ret = readba_native(b, off, len, myFd);
                //return ret;
            //}
        }

        
    }


    
    class SocketOutputStream extends OutputStream {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.294 -0400", hash_original_method = "9DAA385F4ED568E05EE1F0223FEA6D4A", hash_generated_method = "9DAA385F4ED568E05EE1F0223FEA6D4A")
        public SocketOutputStream ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.294 -0400", hash_original_method = "C23E504E812AF14B0F4062FED57A7B1E", hash_generated_method = "ECE646958EE00D511DDB45A2F54ADA78")
        @Override
        public void close() throws IOException {
            LocalSocketImpl.this.close();
            // ---------- Original Method ----------
            //LocalSocketImpl.this.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.294 -0400", hash_original_method = "E1D4EA7BC5A1A039095C078064FA6BD5", hash_generated_method = "B3568086ADE3BAD84D120E59E69344D7")
        @Override
        public void write(byte[] b) throws IOException {
            addTaint(b[0]);
            write(b, 0, b.length);
            // ---------- Original Method ----------
            //write(b, 0, b.length);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.294 -0400", hash_original_method = "EBF729639A281DEC85F834E9B1299F05", hash_generated_method = "52CF140E29A9D11B2219EED79B211530")
        @Override
        public void write(byte[] b, int off, int len) throws IOException {
            addTaint(len);
            addTaint(off);
            addTaint(b[0]);
            synchronized
(writeMonitor)            {
                FileDescriptor myFd = fd;
                if(myFd == null)                
                {
                IOException var5459B998E5CC9DF81A064696FBF5CD9C_973240414 = new IOException("socket closed");
                var5459B998E5CC9DF81A064696FBF5CD9C_973240414.addTaint(taint);
                throw var5459B998E5CC9DF81A064696FBF5CD9C_973240414;
                }
                if(off < 0 || len < 0 || (off + len) > b.length)                
                {
                    ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_1242789323 = new ArrayIndexOutOfBoundsException();
                    var37DB57B1FEB1C9FBA644A093BFA8B678_1242789323.addTaint(taint);
                    throw var37DB57B1FEB1C9FBA644A093BFA8B678_1242789323;
                } //End block
                writeba_native(b, off, len, myFd);
            } //End block
            // ---------- Original Method ----------
            //synchronized (writeMonitor) {
                //FileDescriptor myFd = fd;
                //if (myFd == null) throw new IOException("socket closed");
                //if (off < 0 || len < 0 || (off + len) > b.length ) {
                    //throw new ArrayIndexOutOfBoundsException();
                //}
                //writeba_native(b, off, len, myFd);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.294 -0400", hash_original_method = "0B4435377A393210C076C48249BA83BB", hash_generated_method = "2DCF8BB39FFF3A3966EFD41C8AF4C1CA")
        @Override
        public void write(int b) throws IOException {
            addTaint(b);
            synchronized
(writeMonitor)            {
                FileDescriptor myFd = fd;
                if(myFd == null)                
                {
                IOException var5459B998E5CC9DF81A064696FBF5CD9C_1288594460 = new IOException("socket closed");
                var5459B998E5CC9DF81A064696FBF5CD9C_1288594460.addTaint(taint);
                throw var5459B998E5CC9DF81A064696FBF5CD9C_1288594460;
                }
                write_native(b, myFd);
            } //End block
            // ---------- Original Method ----------
            //synchronized (writeMonitor) {
                //FileDescriptor myFd = fd;
                //if (myFd == null) throw new IOException("socket closed");
                //write_native(b, myFd);
            //}
        }

        
    }


    
}

