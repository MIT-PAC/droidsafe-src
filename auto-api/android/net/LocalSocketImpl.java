package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileDescriptor;
import java.net.SocketOptions;

class LocalSocketImpl {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.916 -0400", hash_original_field = "37AB815C056B5C5F600F6AC93E486A78", hash_generated_field = "355E2A769FEE7E54D6F0256760F338B6")

    private SocketInputStream fis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.916 -0400", hash_original_field = "E571B045697D6C923B7E4487896BC777", hash_generated_field = "8156E266B6831DBC7B3771E7C35EF804")

    private SocketOutputStream fos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.916 -0400", hash_original_field = "98A1C2694E60856C3A255575198C7FAC", hash_generated_field = "201F2893E6616F00DF8FC16933452C93")

    private Object readMonitor = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.916 -0400", hash_original_field = "14AF2371FED66FD8E7EA1FDDEA86200F", hash_generated_field = "3AEEFF96894C6EA6FF9C01F76A902604")

    private Object writeMonitor = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.916 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

    private FileDescriptor fd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.916 -0400", hash_original_field = "91BAD7D60B635067305F0AA2C6DB835F", hash_generated_field = "9CF2319FEDB29C1E6FE6830C6EF0FC50")

    FileDescriptor[] inboundFileDescriptors;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.916 -0400", hash_original_field = "F5B8F5BA74B58179A54A9DC552D2C1C9", hash_generated_field = "5C2DA72A39F5E44715644D1AB34D0887")

    FileDescriptor[] outboundFileDescriptors;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.923 -0400", hash_original_method = "EB46FEA2FE489ABD86FB64E17870F7D5", hash_generated_method = "CD8997B5BBD288454729017F9D0FB34B")
      LocalSocketImpl() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.924 -0400", hash_original_method = "D456C6C1E42DF15F5B9AFA3DF483BFD5", hash_generated_method = "B8BE2A9636FAA52F24039EE3D67E5778")
      LocalSocketImpl(FileDescriptor fd) throws IOException {
        this.fd = fd;
        // ---------- Original Method ----------
        //this.fd = fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.924 -0400", hash_original_method = "2758981D1030A8FDA90CA71A02304595", hash_generated_method = "FF439D08F620EA40E2E6D7C46CC0DA7D")
    private int available_native(FileDescriptor fd) throws IOException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_755324432 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_755324432;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.926 -0400", hash_original_method = "C4F1C4509B0A008CEB1A520A33B1432C", hash_generated_method = "65052700D9C4973B893CD8795118A216")
    private void close_native(FileDescriptor fd) throws IOException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.935 -0400", hash_original_method = "C5E1B2BCA848D2C54F079D7825712FAA", hash_generated_method = "5299B489E8F78C58E10B473FF09E1C41")
    private int read_native(FileDescriptor fd) throws IOException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1345040552 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1345040552;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.935 -0400", hash_original_method = "6C0CD8F9940E6252A80F192C7FCEF247", hash_generated_method = "5E74FBA75B3EA3D33DA5F70860015051")
    private int readba_native(byte[] b, int off, int len,
            FileDescriptor fd) throws IOException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_194940956 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_194940956;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.936 -0400", hash_original_method = "411B6D80F43D59E374103A18918D197B", hash_generated_method = "FD1B0D2DA87E5E80BACB15431ECDA287")
    private void writeba_native(byte[] b, int off, int len,
            FileDescriptor fd) throws IOException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.953 -0400", hash_original_method = "EC6860394B0EC0B22E9CA8C353E6B2CD", hash_generated_method = "835004AB0F491C4E0A07CDC42E7C75E8")
    private void write_native(int b, FileDescriptor fd) throws IOException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.954 -0400", hash_original_method = "FB81706A2E5D939365DC1E11BB4FE7D5", hash_generated_method = "8D9BD02ECD0E57124CC839B8088FFC25")
    private void connectLocal(FileDescriptor fd, String name,
            int namespace) throws IOException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.955 -0400", hash_original_method = "62C617B37F715EB0C7D8B05FC6062D1C", hash_generated_method = "D330883423CE48AEB21D6EDBB834187E")
    private void bindLocal(FileDescriptor fd, String name, int namespace) throws IOException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.955 -0400", hash_original_method = "91E7A83B201CCE6F03E99B6B97993D3C", hash_generated_method = "BF4DB921189260FDA30B994461CFCF87")
    private FileDescriptor create_native(boolean stream) throws IOException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.956 -0400", hash_original_method = "565F45EE1777149341C55D43CF68422B", hash_generated_method = "2AF7CD29BD9A03ADED92A7A2D76B8EE6")
    private void listen_native(FileDescriptor fd, int backlog) throws IOException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.956 -0400", hash_original_method = "AE79C436903413982C1AAE7FD29B4B48", hash_generated_method = "92ADCFCA446C23326021228A20115975")
    private void shutdown(FileDescriptor fd, boolean shutdownInput) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.957 -0400", hash_original_method = "0137F99D53D5E10D02D5A211BB31B969", hash_generated_method = "5F1B13E48615D9E4FD0789735B8F4C85")
    private Credentials getPeerCredentials_native(
            FileDescriptor fd) throws IOException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.977 -0400", hash_original_method = "57547C3595B23A135CCDE37FD7052F1D", hash_generated_method = "8D871694BB3DF3A7A920F0DBD2072A7B")
    private int getOption_native(FileDescriptor fd, int optID) throws IOException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1705308399 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1705308399;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.977 -0400", hash_original_method = "DE678D0521D206818FAC33E612ECDEF9", hash_generated_method = "9958FF02EB38A803062C9BF2F8520BBE")
    private void setOption_native(FileDescriptor fd, int optID,
            int b, int value) throws IOException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.978 -0400", hash_original_method = "AD93B21D07861EA052C26EC40030E4DA", hash_generated_method = "0BA24B5688D235E53CBDA81423459803")
    private FileDescriptor accept(FileDescriptor fd, LocalSocketImpl s) throws IOException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.979 -0400", hash_original_method = "910906868F2A4F19B7D2844E1F779346", hash_generated_method = "9253B53D60F379C35C5514DCE2A90775")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_924063216 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_924063216 = super.toString() + " fd:" + fd;
        varB4EAC82CA7396A68D541C85D26508E83_924063216.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_924063216;
        // ---------- Original Method ----------
        //return super.toString() + " fd:" + fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.983 -0400", hash_original_method = "C69FBA5615AE4C555A8E605188FC5D70", hash_generated_method = "45032C995429A20F55746FBCC209456D")
    public void create(boolean stream) throws IOException {
        {
            fd = create_native(stream);
        } //End block
        // ---------- Original Method ----------
        //if (fd == null) {
            //fd = create_native(stream);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.986 -0400", hash_original_method = "ABF18B5E6666C8F5D8A2BB5F41F5792B", hash_generated_method = "F27AF145D3CF1C0A5845442FB24941EB")
    public void close() throws IOException {
        {
            Object varE19B0DA50F6EB975A9A155685A0B3663_494739835 = (LocalSocketImpl.this);
            {
                close_native(fd);
                fd = null;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //synchronized (LocalSocketImpl.this) {
            //if (fd == null) return;
            //close_native(fd);
            //fd = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.995 -0400", hash_original_method = "425C245C15643B6C00C58E49D6A6C651", hash_generated_method = "2D43E8C98874BFA1225A0EC406E38910")
    protected void connect(LocalSocketAddress address, int timeout) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("socket not created");
        } //End block
        connectLocal(fd, address.getName(), address.getNamespace().getId());
        addTaint(address.getTaint());
        addTaint(timeout);
        // ---------- Original Method ----------
        //if (fd == null) {
            //throw new IOException("socket not created");
        //}
        //connectLocal(fd, address.getName(), address.getNamespace().getId());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.997 -0400", hash_original_method = "D301FBD428349B466ACCB27339A08D2F", hash_generated_method = "3F88F8FA7EABCD5991EFE439A8AC62A7")
    public void bind(LocalSocketAddress endpoint) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("socket not created");
        } //End block
        bindLocal(fd, endpoint.getName(), endpoint.getNamespace().getId());
        addTaint(endpoint.getTaint());
        // ---------- Original Method ----------
        //if (fd == null) {
            //throw new IOException("socket not created");
        //}
        //bindLocal(fd, endpoint.getName(), endpoint.getNamespace().getId());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.998 -0400", hash_original_method = "A6DEE76A07DA4242CC30FE3245F17D51", hash_generated_method = "96A9FFDD3301826AA487EDA06DCD2AAA")
    protected void listen(int backlog) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("socket not created");
        } //End block
        listen_native(fd, backlog);
        addTaint(backlog);
        // ---------- Original Method ----------
        //if (fd == null) {
            //throw new IOException("socket not created");
        //}
        //listen_native(fd, backlog);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.013 -0400", hash_original_method = "E2D863498299C9CF5B0AE6150A21C675", hash_generated_method = "61AD33514E33FCDDDECCD1F852E1AE2A")
    protected void accept(LocalSocketImpl s) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("socket not created");
        } //End block
        s.fd = accept(fd, s);
        // ---------- Original Method ----------
        //if (fd == null) {
            //throw new IOException("socket not created");
        //}
        //s.fd = accept(fd, s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.025 -0400", hash_original_method = "D37322C17A1B9B191A9C32D9BD81E000", hash_generated_method = "3C27DE566A4BF558E5717438A9F302EC")
    protected InputStream getInputStream() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_110993450 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("socket not created");
        } //End block
        {
            {
                fis = new SocketInputStream();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_110993450 = fis;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_110993450.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_110993450;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.041 -0400", hash_original_method = "2E8F2E95CF2F6CF40AEA3B38F9B68B34", hash_generated_method = "F452D3A5358A5E8B2057C1CDE77198B3")
    protected OutputStream getOutputStream() throws IOException {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_1678611224 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("socket not created");
        } //End block
        {
            {
                fos = new SocketOutputStream();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1678611224 = fos;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1678611224.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1678611224;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.042 -0400", hash_original_method = "A7CC818E7F384DAEC54D76069E9C5019", hash_generated_method = "E5327230583E5350FC09B5F450FE0655")
    protected int available() throws IOException {
        int var6B9EBF6BA37A6BD9983DF13805FEE2B0_34708899 = (getInputStream().available());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_371604053 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_371604053;
        // ---------- Original Method ----------
        //return getInputStream().available();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.043 -0400", hash_original_method = "CED8C1FFBDBF9F9E7A40EC2B2E6DD909", hash_generated_method = "B9E9E1065BD5DCF9B6CDD30A30C64630")
    protected void shutdownInput() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("socket not created");
        } //End block
        shutdown(fd, true);
        // ---------- Original Method ----------
        //if (fd == null) {
            //throw new IOException("socket not created");
        //}
        //shutdown(fd, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.058 -0400", hash_original_method = "DE98B1F2C9FD8DEEFDCE620E4EB90078", hash_generated_method = "88FE1B1AA32A8F5AC8F548BD316D929E")
    protected void shutdownOutput() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("socket not created");
        } //End block
        shutdown(fd, false);
        // ---------- Original Method ----------
        //if (fd == null) {
            //throw new IOException("socket not created");
        //}
        //shutdown(fd, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.060 -0400", hash_original_method = "C1B4172ED9A628993584DE4384B8AF55", hash_generated_method = "3CB527126AFF6DE756D58CF73EA30C2E")
    protected FileDescriptor getFileDescriptor() {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1078710519 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1078710519 = fd;
        varB4EAC82CA7396A68D541C85D26508E83_1078710519.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1078710519;
        // ---------- Original Method ----------
        //return fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.061 -0400", hash_original_method = "84442B2358C6BD30716C7D72481FD8C4", hash_generated_method = "4EE23FF27797DE3493C2056302A8C452")
    protected boolean supportsUrgentData() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_601358873 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_601358873;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.061 -0400", hash_original_method = "EC21D6BA9A1DE1709D242100460B4B8C", hash_generated_method = "DEAE1695C18EDB78E6FEF40947B7A743")
    protected void sendUrgentData(int data) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException ("not impled");
        addTaint(data);
        // ---------- Original Method ----------
        //throw new RuntimeException ("not impled");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.075 -0400", hash_original_method = "02CEF5E6368D2209C8707863BE147BD2", hash_generated_method = "A9C894D9ECDEBD2C08341DA54688C4D7")
    public Object getOption(int optID) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_2091558078 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1011137508 = null; //Variable for return #2
        Object varB4EAC82CA7396A68D541C85D26508E83_450864192 = null; //Variable for return #3
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("socket not created");
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_2091558078 = 0;
        } //End block
        int value;
        value = getOption_native(fd, optID);
        //Begin case SocketOptions.SO_RCVBUF SocketOptions.SO_SNDBUF 
        varB4EAC82CA7396A68D541C85D26508E83_1011137508 = value;
        //End case SocketOptions.SO_RCVBUF SocketOptions.SO_SNDBUF 
        //Begin case SocketOptions.SO_REUSEADDR default 
        varB4EAC82CA7396A68D541C85D26508E83_450864192 = value;
        //End case SocketOptions.SO_REUSEADDR default 
        addTaint(optID);
        Object varA7E53CE21691AB073D9660D615818899_862180466; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_862180466 = varB4EAC82CA7396A68D541C85D26508E83_2091558078;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_862180466 = varB4EAC82CA7396A68D541C85D26508E83_1011137508;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_862180466 = varB4EAC82CA7396A68D541C85D26508E83_450864192;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_862180466.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_862180466;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.130 -0400", hash_original_method = "A0313708A2FB484B7104FAC62F0E39B4", hash_generated_method = "37043953152B2F469D496E4950609981")
    public void setOption(int optID, Object value) throws IOException {
        int boolValue;
        boolValue = -1;
        int intValue;
        intValue = 0;
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("socket not created");
        } //End block
        {
            intValue = (Integer)value;
        } //End block
        {
            boolValue = ((Boolean) value)? 1 : 0;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("bad value: " + value);
        } //End block
        setOption_native(fd, optID, boolValue, intValue);
        addTaint(optID);
        addTaint(value.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.132 -0400", hash_original_method = "AEC4AD692525702323537BC369199B7F", hash_generated_method = "53FC49ECF2BC362A403D0542CC0D5DCE")
    public void setFileDescriptorsForSend(FileDescriptor[] fds) {
        {
            outboundFileDescriptors = fds;
        } //End block
        // ---------- Original Method ----------
        //synchronized(writeMonitor) {
            //outboundFileDescriptors = fds;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.142 -0400", hash_original_method = "D444308F286D853D2E5F97ACF37B86DF", hash_generated_method = "10F7B1707B997EAEC5065CC1AA2F8DB2")
    public FileDescriptor[] getAncillaryFileDescriptors() throws IOException {
        FileDescriptor[] varB4EAC82CA7396A68D541C85D26508E83_835070799 = null; //Variable for return #1
        {
            FileDescriptor[] result;
            result = inboundFileDescriptors;
            inboundFileDescriptors = null;
            varB4EAC82CA7396A68D541C85D26508E83_835070799 = result;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_835070799.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_835070799;
        // ---------- Original Method ----------
        //synchronized(readMonitor) {
            //FileDescriptor[] result = inboundFileDescriptors;
            //inboundFileDescriptors = null;
            //return result;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.143 -0400", hash_original_method = "3E3240E544229F6BEFF619755963B808", hash_generated_method = "165984E834398616CBDF3431AC20591C")
    public Credentials getPeerCredentials() throws IOException {
        Credentials varB4EAC82CA7396A68D541C85D26508E83_1972479321 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1972479321 = getPeerCredentials_native(fd);
        varB4EAC82CA7396A68D541C85D26508E83_1972479321.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1972479321;
        // ---------- Original Method ----------
        //return getPeerCredentials_native(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.144 -0400", hash_original_method = "C6AD39B00524B9355CA4153DB07C4B13", hash_generated_method = "6AF6D052484CE93125499BC3A59ADAA1")
    public LocalSocketAddress getSockAddress() throws IOException {
        LocalSocketAddress varB4EAC82CA7396A68D541C85D26508E83_1212947064 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1212947064 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1212947064.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1212947064;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.144 -0400", hash_original_method = "CA22E17CA63436350E75BC7DD678FC6C", hash_generated_method = "EE7B698A5C5971F84CA5AA51E8CB3380")
    @Override
    protected void finalize() throws IOException {
        close();
        // ---------- Original Method ----------
        //close();
    }

    
    class SocketInputStream extends InputStream {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.145 -0400", hash_original_method = "AF927FBDB8352BCBCFDDC9969A694B0C", hash_generated_method = "AF927FBDB8352BCBCFDDC9969A694B0C")
        public SocketInputStream ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.164 -0400", hash_original_method = "8F92B1C37F1E7B064EB55148DFA3D6F8", hash_generated_method = "B568E983B5D1999DD4C2336D9E307436")
        @Override
        public int available() throws IOException {
            int varE70871DEC74DFE680005AAB58E0DA61C_1074660174 = (available_native(fd));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2000135573 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2000135573;
            // ---------- Original Method ----------
            //return available_native(fd);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.168 -0400", hash_original_method = "C23E504E812AF14B0F4062FED57A7B1E", hash_generated_method = "ECE646958EE00D511DDB45A2F54ADA78")
        @Override
        public void close() throws IOException {
            LocalSocketImpl.this.close();
            // ---------- Original Method ----------
            //LocalSocketImpl.this.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.170 -0400", hash_original_method = "395E06403A9BB7E16A5F2E3FCA2C1758", hash_generated_method = "85EAED938D60C89D064DFF76F31DCC1E")
        @Override
        public int read() throws IOException {
            int ret;
            {
                FileDescriptor myFd;
                myFd = fd;
                if (DroidSafeAndroidRuntime.control) throw new IOException("socket closed");
                ret = read_native(myFd);
            } //End block
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2059199383 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2059199383;
            // ---------- Original Method ----------
            //int ret;
            //synchronized (readMonitor) {
                //FileDescriptor myFd = fd;
                //if (myFd == null) throw new IOException("socket closed");
                //ret = read_native(myFd);
                //return ret;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.170 -0400", hash_original_method = "03121A7AC3B4E7519E88953F37DA485C", hash_generated_method = "7427DBEB5DD3181450177E1DF61336A1")
        @Override
        public int read(byte[] b) throws IOException {
            int var622F29548219192F8BB382FD386339B9_1288108698 = (read(b, 0, b.length));
            addTaint(b[0]);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_443920196 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_443920196;
            // ---------- Original Method ----------
            //return read(b, 0, b.length);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.188 -0400", hash_original_method = "554DCEA621C79251D4E71F6BA8C4411B", hash_generated_method = "72B8756F228C1C7E20679F6F1556B693")
        @Override
        public int read(byte[] b, int off, int len) throws IOException {
            {
                FileDescriptor myFd;
                myFd = fd;
                if (DroidSafeAndroidRuntime.control) throw new IOException("socket closed");
                {
                    if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
                } //End block
                int ret;
                ret = readba_native(b, off, len, myFd);
            } //End block
            addTaint(b[0]);
            addTaint(off);
            addTaint(len);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1487523388 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1487523388;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.188 -0400", hash_original_method = "9DAA385F4ED568E05EE1F0223FEA6D4A", hash_generated_method = "9DAA385F4ED568E05EE1F0223FEA6D4A")
        public SocketOutputStream ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.189 -0400", hash_original_method = "C23E504E812AF14B0F4062FED57A7B1E", hash_generated_method = "ECE646958EE00D511DDB45A2F54ADA78")
        @Override
        public void close() throws IOException {
            LocalSocketImpl.this.close();
            // ---------- Original Method ----------
            //LocalSocketImpl.this.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.193 -0400", hash_original_method = "E1D4EA7BC5A1A039095C078064FA6BD5", hash_generated_method = "65527CB182AA774108E3787F67952FBA")
        @Override
        public void write(byte[] b) throws IOException {
            write(b, 0, b.length);
            addTaint(b[0]);
            // ---------- Original Method ----------
            //write(b, 0, b.length);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.205 -0400", hash_original_method = "EBF729639A281DEC85F834E9B1299F05", hash_generated_method = "9778DBDFD4F6430A1848843C50C263CC")
        @Override
        public void write(byte[] b, int off, int len) throws IOException {
            {
                FileDescriptor myFd;
                myFd = fd;
                if (DroidSafeAndroidRuntime.control) throw new IOException("socket closed");
                {
                    if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
                } //End block
                writeba_native(b, off, len, myFd);
            } //End block
            addTaint(b[0]);
            addTaint(off);
            addTaint(len);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.206 -0400", hash_original_method = "0B4435377A393210C076C48249BA83BB", hash_generated_method = "000F32C8FE304A12A8F68C480F94CB8E")
        @Override
        public void write(int b) throws IOException {
            {
                FileDescriptor myFd;
                myFd = fd;
                if (DroidSafeAndroidRuntime.control) throw new IOException("socket closed");
                write_native(b, myFd);
            } //End block
            addTaint(b);
            // ---------- Original Method ----------
            //synchronized (writeMonitor) {
                //FileDescriptor myFd = fd;
                //if (myFd == null) throw new IOException("socket closed");
                //write_native(b, myFd);
            //}
        }

        
    }


    
}

