package android.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileDescriptor;
import java.net.SocketOptions;

class LocalSocketImpl {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.245 -0400", hash_original_field = "37AB815C056B5C5F600F6AC93E486A78", hash_generated_field = "355E2A769FEE7E54D6F0256760F338B6")

    private SocketInputStream fis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.245 -0400", hash_original_field = "E571B045697D6C923B7E4487896BC777", hash_generated_field = "8156E266B6831DBC7B3771E7C35EF804")

    private SocketOutputStream fos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.245 -0400", hash_original_field = "98A1C2694E60856C3A255575198C7FAC", hash_generated_field = "201F2893E6616F00DF8FC16933452C93")

    private Object readMonitor = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.245 -0400", hash_original_field = "14AF2371FED66FD8E7EA1FDDEA86200F", hash_generated_field = "3AEEFF96894C6EA6FF9C01F76A902604")

    private Object writeMonitor = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.245 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

    private FileDescriptor fd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.245 -0400", hash_original_field = "91BAD7D60B635067305F0AA2C6DB835F", hash_generated_field = "9CF2319FEDB29C1E6FE6830C6EF0FC50")

    FileDescriptor[] inboundFileDescriptors;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.245 -0400", hash_original_field = "F5B8F5BA74B58179A54A9DC552D2C1C9", hash_generated_field = "5C2DA72A39F5E44715644D1AB34D0887")

    FileDescriptor[] outboundFileDescriptors;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.246 -0400", hash_original_method = "EB46FEA2FE489ABD86FB64E17870F7D5", hash_generated_method = "CD8997B5BBD288454729017F9D0FB34B")
      LocalSocketImpl() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.246 -0400", hash_original_method = "D456C6C1E42DF15F5B9AFA3DF483BFD5", hash_generated_method = "B8BE2A9636FAA52F24039EE3D67E5778")
      LocalSocketImpl(FileDescriptor fd) throws IOException {
        this.fd = fd;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.246 -0400", hash_original_method = "2758981D1030A8FDA90CA71A02304595", hash_generated_method = "1BB7548DFB5EFBC1703BE2C4DAE731B5")
    private int available_native(FileDescriptor fd) throws IOException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_222978302 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_222978302;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.246 -0400", hash_original_method = "C4F1C4509B0A008CEB1A520A33B1432C", hash_generated_method = "65052700D9C4973B893CD8795118A216")
    private void close_native(FileDescriptor fd) throws IOException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.246 -0400", hash_original_method = "C5E1B2BCA848D2C54F079D7825712FAA", hash_generated_method = "43F6D4369AA41ABC28E9F8205E734EA1")
    private int read_native(FileDescriptor fd) throws IOException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_392115993 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_392115993;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.247 -0400", hash_original_method = "6C0CD8F9940E6252A80F192C7FCEF247", hash_generated_method = "1FFFBC54FDA789875042CEBE44D200D0")
    private int readba_native(byte[] b, int off, int len,
            FileDescriptor fd) throws IOException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1430934568 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1430934568;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.247 -0400", hash_original_method = "411B6D80F43D59E374103A18918D197B", hash_generated_method = "FD1B0D2DA87E5E80BACB15431ECDA287")
    private void writeba_native(byte[] b, int off, int len,
            FileDescriptor fd) throws IOException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.247 -0400", hash_original_method = "EC6860394B0EC0B22E9CA8C353E6B2CD", hash_generated_method = "835004AB0F491C4E0A07CDC42E7C75E8")
    private void write_native(int b, FileDescriptor fd) throws IOException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.247 -0400", hash_original_method = "FB81706A2E5D939365DC1E11BB4FE7D5", hash_generated_method = "8D9BD02ECD0E57124CC839B8088FFC25")
    private void connectLocal(FileDescriptor fd, String name,
            int namespace) throws IOException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.248 -0400", hash_original_method = "62C617B37F715EB0C7D8B05FC6062D1C", hash_generated_method = "D330883423CE48AEB21D6EDBB834187E")
    private void bindLocal(FileDescriptor fd, String name, int namespace) throws IOException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.248 -0400", hash_original_method = "91E7A83B201CCE6F03E99B6B97993D3C", hash_generated_method = "BF4DB921189260FDA30B994461CFCF87")
    private FileDescriptor create_native(boolean stream) throws IOException {
        FileDescriptor fd = new FileDescriptor();
        fd.addTaint(this.taint);
        return fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.248 -0400", hash_original_method = "565F45EE1777149341C55D43CF68422B", hash_generated_method = "2AF7CD29BD9A03ADED92A7A2D76B8EE6")
    private void listen_native(FileDescriptor fd, int backlog) throws IOException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.248 -0400", hash_original_method = "AE79C436903413982C1AAE7FD29B4B48", hash_generated_method = "92ADCFCA446C23326021228A20115975")
    private void shutdown(FileDescriptor fd, boolean shutdownInput) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.248 -0400", hash_original_method = "0137F99D53D5E10D02D5A211BB31B969", hash_generated_method = "5F1B13E48615D9E4FD0789735B8F4C85")
    private Credentials getPeerCredentials_native(
            FileDescriptor fd) throws IOException {
    	Credentials creds = new Credentials(0, 0, 0);
    	creds.addTaint(this.taint);
    	return creds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.249 -0400", hash_original_method = "57547C3595B23A135CCDE37FD7052F1D", hash_generated_method = "52F8F80ED5C37535C2BFCD88E5C5517C")
    private int getOption_native(FileDescriptor fd, int optID) throws IOException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1672428563 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1672428563;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.249 -0400", hash_original_method = "DE678D0521D206818FAC33E612ECDEF9", hash_generated_method = "9958FF02EB38A803062C9BF2F8520BBE")
    private void setOption_native(FileDescriptor fd, int optID,
            int b, int value) throws IOException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.249 -0400", hash_original_method = "AD93B21D07861EA052C26EC40030E4DA", hash_generated_method = "0BA24B5688D235E53CBDA81423459803")
    private FileDescriptor accept(FileDescriptor fd, LocalSocketImpl s) throws IOException {
        FileDescriptor fd2 = new FileDescriptor();
        fd2.addTaint(this.taint);
        return fd2;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.250 -0400", hash_original_method = "910906868F2A4F19B7D2844E1F779346", hash_generated_method = "6C8DB1E2B3F6194E056041013B0F24C4")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_907363891 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_907363891 = super.toString() + " fd:" + fd;
        varB4EAC82CA7396A68D541C85D26508E83_907363891.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_907363891;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.250 -0400", hash_original_method = "C69FBA5615AE4C555A8E605188FC5D70", hash_generated_method = "45032C995429A20F55746FBCC209456D")
    public void create(boolean stream) throws IOException {
        {
            fd = create_native(stream);
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.250 -0400", hash_original_method = "ABF18B5E6666C8F5D8A2BB5F41F5792B", hash_generated_method = "701284D7C5FB4A15D5E291283469FB31")
    public void close() throws IOException {
        {
            Object varE19B0DA50F6EB975A9A155685A0B3663_1672553631 = (LocalSocketImpl.this);
            {
                close_native(fd);
                fd = null;
            } 
        } 
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.250 -0400", hash_original_method = "425C245C15643B6C00C58E49D6A6C651", hash_generated_method = "2D43E8C98874BFA1225A0EC406E38910")
    protected void connect(LocalSocketAddress address, int timeout) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("socket not created");
        } 
        connectLocal(fd, address.getName(), address.getNamespace().getId());
        addTaint(address.getTaint());
        addTaint(timeout);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.251 -0400", hash_original_method = "D301FBD428349B466ACCB27339A08D2F", hash_generated_method = "3F88F8FA7EABCD5991EFE439A8AC62A7")
    public void bind(LocalSocketAddress endpoint) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("socket not created");
        } 
        bindLocal(fd, endpoint.getName(), endpoint.getNamespace().getId());
        addTaint(endpoint.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.251 -0400", hash_original_method = "A6DEE76A07DA4242CC30FE3245F17D51", hash_generated_method = "96A9FFDD3301826AA487EDA06DCD2AAA")
    protected void listen(int backlog) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("socket not created");
        } 
        listen_native(fd, backlog);
        addTaint(backlog);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.251 -0400", hash_original_method = "E2D863498299C9CF5B0AE6150A21C675", hash_generated_method = "61AD33514E33FCDDDECCD1F852E1AE2A")
    protected void accept(LocalSocketImpl s) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("socket not created");
        } 
        s.fd = accept(fd, s);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.252 -0400", hash_original_method = "D37322C17A1B9B191A9C32D9BD81E000", hash_generated_method = "D86B20F67402AB81E32AD26C20333BBA")
    protected InputStream getInputStream() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1770058223 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("socket not created");
        } 
        {
            {
                fis = new SocketInputStream();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1770058223 = fis;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1770058223.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1770058223;
        
        
            
        
        
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.253 -0400", hash_original_method = "2E8F2E95CF2F6CF40AEA3B38F9B68B34", hash_generated_method = "1D3FB051768280BFE9679783FF54DA9F")
    protected OutputStream getOutputStream() throws IOException {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_1347717995 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("socket not created");
        } 
        {
            {
                fos = new SocketOutputStream();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1347717995 = fos;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1347717995.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1347717995;
        
        
            
        
        
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.254 -0400", hash_original_method = "A7CC818E7F384DAEC54D76069E9C5019", hash_generated_method = "952C44BFFBE8563EF9D2303A90493066")
    protected int available() throws IOException {
        int var6B9EBF6BA37A6BD9983DF13805FEE2B0_823059475 = (getInputStream().available());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1663535399 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1663535399;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.255 -0400", hash_original_method = "CED8C1FFBDBF9F9E7A40EC2B2E6DD909", hash_generated_method = "B9E9E1065BD5DCF9B6CDD30A30C64630")
    protected void shutdownInput() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("socket not created");
        } 
        shutdown(fd, true);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.256 -0400", hash_original_method = "DE98B1F2C9FD8DEEFDCE620E4EB90078", hash_generated_method = "88FE1B1AA32A8F5AC8F548BD316D929E")
    protected void shutdownOutput() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("socket not created");
        } 
        shutdown(fd, false);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.256 -0400", hash_original_method = "C1B4172ED9A628993584DE4384B8AF55", hash_generated_method = "0E1F71E4BFDADB1D126612B2D650F0A1")
    protected FileDescriptor getFileDescriptor() {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_60909670 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_60909670 = fd;
        varB4EAC82CA7396A68D541C85D26508E83_60909670.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_60909670;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.257 -0400", hash_original_method = "84442B2358C6BD30716C7D72481FD8C4", hash_generated_method = "1F8A824A7D7EE683582B56E43164A4F1")
    protected boolean supportsUrgentData() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1661885370 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1661885370;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.257 -0400", hash_original_method = "EC21D6BA9A1DE1709D242100460B4B8C", hash_generated_method = "DEAE1695C18EDB78E6FEF40947B7A743")
    protected void sendUrgentData(int data) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException ("not impled");
        addTaint(data);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.258 -0400", hash_original_method = "02CEF5E6368D2209C8707863BE147BD2", hash_generated_method = "B5C1DEFE9BAD65DC9F8FD1DDEAA0508D")
    public Object getOption(int optID) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_825821881 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1735152365 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1415723083 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("socket not created");
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_825821881 = 0;
        } 
        int value = getOption_native(fd, optID);
        
        varB4EAC82CA7396A68D541C85D26508E83_1735152365 = value;
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1415723083 = value;
        
        addTaint(optID);
        Object varA7E53CE21691AB073D9660D615818899_1081672273; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1081672273 = varB4EAC82CA7396A68D541C85D26508E83_825821881;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1081672273 = varB4EAC82CA7396A68D541C85D26508E83_1735152365;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1081672273 = varB4EAC82CA7396A68D541C85D26508E83_1415723083;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1081672273.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1081672273;
        
        
            
        
        
            
        
        
        
        
            
            
                
            
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.259 -0400", hash_original_method = "A0313708A2FB484B7104FAC62F0E39B4", hash_generated_method = "745A53C1D489859C765C0630618D32A9")
    public void setOption(int optID, Object value) throws IOException {
        int boolValue = -1;
        int intValue = 0;
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("socket not created");
        } 
        {
            intValue = (Integer)value;
        } 
        {
            boolValue = ((Boolean) value)? 1 : 0;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("bad value: " + value);
        } 
        setOption_native(fd, optID, boolValue, intValue);
        addTaint(optID);
        addTaint(value.getTaint());
        
        
        
        
            
        
        
            
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.259 -0400", hash_original_method = "AEC4AD692525702323537BC369199B7F", hash_generated_method = "53FC49ECF2BC362A403D0542CC0D5DCE")
    public void setFileDescriptorsForSend(FileDescriptor[] fds) {
        {
            outboundFileDescriptors = fds;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.260 -0400", hash_original_method = "D444308F286D853D2E5F97ACF37B86DF", hash_generated_method = "84D0163DED5959B27F95C10B26F0D71B")
    public FileDescriptor[] getAncillaryFileDescriptors() throws IOException {
        FileDescriptor[] varB4EAC82CA7396A68D541C85D26508E83_127782783 = null; 
        {
            FileDescriptor[] result = inboundFileDescriptors;
            inboundFileDescriptors = null;
            varB4EAC82CA7396A68D541C85D26508E83_127782783 = result;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_127782783.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_127782783;
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.261 -0400", hash_original_method = "3E3240E544229F6BEFF619755963B808", hash_generated_method = "80D7156D0E98EDBA1B19F914FDD7DF8F")
    public Credentials getPeerCredentials() throws IOException {
        Credentials varB4EAC82CA7396A68D541C85D26508E83_803162559 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_803162559 = getPeerCredentials_native(fd);
        varB4EAC82CA7396A68D541C85D26508E83_803162559.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_803162559;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.262 -0400", hash_original_method = "C6AD39B00524B9355CA4153DB07C4B13", hash_generated_method = "898F4B51747E656EAB3D973F60559D66")
    public LocalSocketAddress getSockAddress() throws IOException {
        LocalSocketAddress varB4EAC82CA7396A68D541C85D26508E83_417911330 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_417911330 = null;
        varB4EAC82CA7396A68D541C85D26508E83_417911330.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_417911330;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.263 -0400", hash_original_method = "CA22E17CA63436350E75BC7DD678FC6C", hash_generated_method = "EE7B698A5C5971F84CA5AA51E8CB3380")
    @Override
    protected void finalize() throws IOException {
        close();
        
        
    }

    
    class SocketInputStream extends InputStream {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.263 -0400", hash_original_method = "AF927FBDB8352BCBCFDDC9969A694B0C", hash_generated_method = "AF927FBDB8352BCBCFDDC9969A694B0C")
        public SocketInputStream ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.264 -0400", hash_original_method = "8F92B1C37F1E7B064EB55148DFA3D6F8", hash_generated_method = "ABAA14E5948B662A944A887BDDB38391")
        @Override
        public int available() throws IOException {
            int varE70871DEC74DFE680005AAB58E0DA61C_263323136 = (available_native(fd));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_771175285 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_771175285;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.264 -0400", hash_original_method = "C23E504E812AF14B0F4062FED57A7B1E", hash_generated_method = "ECE646958EE00D511DDB45A2F54ADA78")
        @Override
        public void close() throws IOException {
            LocalSocketImpl.this.close();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.265 -0400", hash_original_method = "395E06403A9BB7E16A5F2E3FCA2C1758", hash_generated_method = "5560B700377F99BE1965C184F06F2FA3")
        @Override
        public int read() throws IOException {
            int ret;
            {
                FileDescriptor myFd = fd;
                if (DroidSafeAndroidRuntime.control) throw new IOException("socket closed");
                ret = read_native(myFd);
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_859961583 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_859961583;
            
            
            
                
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.265 -0400", hash_original_method = "03121A7AC3B4E7519E88953F37DA485C", hash_generated_method = "D6DFF3DE83B11AD286D5076CD8FEE9C3")
        @Override
        public int read(byte[] b) throws IOException {
            int var622F29548219192F8BB382FD386339B9_1456602575 = (read(b, 0, b.length));
            addTaint(b[0]);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_538999145 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_538999145;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.266 -0400", hash_original_method = "554DCEA621C79251D4E71F6BA8C4411B", hash_generated_method = "04DF030FDB94B1B311FAD4904D9CBE0D")
        @Override
        public int read(byte[] b, int off, int len) throws IOException {
            {
                FileDescriptor myFd = fd;
                if (DroidSafeAndroidRuntime.control) throw new IOException("socket closed");
                {
                    if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
                } 
                int ret = readba_native(b, off, len, myFd);
            } 
            addTaint(b[0]);
            addTaint(off);
            addTaint(len);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1718094675 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1718094675;
            
            
                
                
                
                    
                
                
                
            
        }

        
    }


    
    class SocketOutputStream extends OutputStream {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.266 -0400", hash_original_method = "9DAA385F4ED568E05EE1F0223FEA6D4A", hash_generated_method = "9DAA385F4ED568E05EE1F0223FEA6D4A")
        public SocketOutputStream ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.267 -0400", hash_original_method = "C23E504E812AF14B0F4062FED57A7B1E", hash_generated_method = "ECE646958EE00D511DDB45A2F54ADA78")
        @Override
        public void close() throws IOException {
            LocalSocketImpl.this.close();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.267 -0400", hash_original_method = "E1D4EA7BC5A1A039095C078064FA6BD5", hash_generated_method = "65527CB182AA774108E3787F67952FBA")
        @Override
        public void write(byte[] b) throws IOException {
            write(b, 0, b.length);
            addTaint(b[0]);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.267 -0400", hash_original_method = "EBF729639A281DEC85F834E9B1299F05", hash_generated_method = "55D9ACD8FF2672DD5455107FB1F86357")
        @Override
        public void write(byte[] b, int off, int len) throws IOException {
            {
                FileDescriptor myFd = fd;
                if (DroidSafeAndroidRuntime.control) throw new IOException("socket closed");
                {
                    if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
                } 
                writeba_native(b, off, len, myFd);
            } 
            addTaint(b[0]);
            addTaint(off);
            addTaint(len);
            
            
                
                
                
                    
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.268 -0400", hash_original_method = "0B4435377A393210C076C48249BA83BB", hash_generated_method = "F9C531978067712FC735E7B5FA0D6275")
        @Override
        public void write(int b) throws IOException {
            {
                FileDescriptor myFd = fd;
                if (DroidSafeAndroidRuntime.control) throw new IOException("socket closed");
                write_native(b, myFd);
            } 
            addTaint(b);
            
            
                
                
                
            
        }

        
    }


    
}

