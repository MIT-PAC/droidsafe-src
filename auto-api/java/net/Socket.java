package java.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.SocketChannel;
import libcore.io.IoBridge;

public class Socket {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.818 -0400", hash_original_field = "86CCEC3D9FF0E9C0514506E982CDC08B", hash_generated_field = "76382137C184A183F2BF2D8583A90AEC")

    SocketImpl impl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.818 -0400", hash_original_field = "431387EB7262E1CFC79B125EB8A67C60", hash_generated_field = "EE0BB8F1739D62A5A5C8EDF7D478A66B")

    private Proxy proxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.818 -0400", hash_original_field = "13A225F92ADD388C574A88D897639BF0", hash_generated_field = "FEFE85DE55A57D0EBA9EA9B6592B8458")

    volatile boolean isCreated = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.818 -0400", hash_original_field = "1EA05BED8F3F3741889B40C4407A936D", hash_generated_field = "AD4F2B698EC37BEC9EEE873CE57E921D")

    private boolean isBound = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.818 -0400", hash_original_field = "F0F0EDCF28D811EA172AA0A0A89A5056", hash_generated_field = "058DE1E699A3B3D187FC9E15DB7EC3B5")

    private boolean isConnected = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.818 -0400", hash_original_field = "7624DFAF468575D3B7DCE21DA2796711", hash_generated_field = "2CBEAC942D14DA48C324142BCB214C18")

    private boolean isClosed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.818 -0400", hash_original_field = "0053D23938B36B6B0E64039CAC6D2249", hash_generated_field = "7BF3C47813946CC98E6B4F51776BE0B2")

    private boolean isInputShutdown = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.818 -0400", hash_original_field = "6C6248A8DD1927E15E037A0AC6FBF72E", hash_generated_field = "155847C1017F44FA011CC3F03B209D80")

    private boolean isOutputShutdown = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.818 -0400", hash_original_field = "F3693398E061FDE89394A9CA0324D131", hash_generated_field = "A8E9D68398963C6A7BD51AC2BEC0E3CA")

    private InetAddress localAddress = Inet4Address.ANY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.818 -0400", hash_original_field = "D8DB2CE733667EE503E654EFAFD74F2D", hash_generated_field = "574736669071BAC15E2D1E76082A2D20")

    private final Object connectLock = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.818 -0400", hash_original_method = "DE6B6B5588954C6A35AB00A23B1617FE", hash_generated_method = "F670CC532C7B774247714814201AF5CC")
    public  Socket() {
        this.impl = factory != null ? factory.createSocketImpl() : new PlainSocketImpl();
        this.proxy = null;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.819 -0400", hash_original_method = "903F698227E2205A08AC4EC3E6D912C3", hash_generated_method = "CD2724B588D6FE16CE9AF8D6A9C28C9D")
    public  Socket(Proxy proxy) {
        {
            boolean varE5CF7C9644D24DC30510FF113B6FA9F4_1285697741 = (proxy == null || proxy.type() == Proxy.Type.HTTP);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid proxy: " + proxy);
            } 
        } 
        this.proxy = proxy;
        this.impl = factory != null ? factory.createSocketImpl() : new PlainSocketImpl(proxy);
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.819 -0400", hash_original_method = "59B1F76D08717F2A7DB6178659D1BD4D", hash_generated_method = "AADABF6745F6C5D22552775E7610A6F8")
    public  Socket(String dstName, int dstPort) throws UnknownHostException, IOException {
        this(dstName, dstPort, null, 0);
        addTaint(dstName.getTaint());
        addTaint(dstPort);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.819 -0400", hash_original_method = "7A6ED28BC12F5ABFF2F2CE0F9C5717C0", hash_generated_method = "E4F2AFA2FC83A5E81D1404EC0F71C06F")
    public  Socket(String dstName, int dstPort, InetAddress localAddress, int localPort) throws IOException {
        this();
        tryAllAddresses(dstName, dstPort, localAddress, localPort, true);
        addTaint(dstName.getTaint());
        addTaint(dstPort);
        addTaint(localAddress.getTaint());
        addTaint(localPort);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.819 -0400", hash_original_method = "1948ABC1DE3B1C37A63093E998C50FE7", hash_generated_method = "CADDDF35FAF5C5BEEC2A7FC7A5CA3E22")
    @Deprecated
    public  Socket(String hostName, int port, boolean streaming) throws IOException {
        this();
        tryAllAddresses(hostName, port, null, 0, streaming);
        addTaint(hostName.getTaint());
        addTaint(port);
        addTaint(streaming);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.820 -0400", hash_original_method = "A1767A7E1F84ED40BDB339014C4851EF", hash_generated_method = "1D6848D5716D426BF6BC1F43CC8F380D")
    public  Socket(InetAddress dstAddress, int dstPort) throws IOException {
        this();
        checkDestination(dstAddress, dstPort);
        startupSocket(dstAddress, dstPort, null, 0, true);
        addTaint(dstAddress.getTaint());
        addTaint(dstPort);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.820 -0400", hash_original_method = "BE0D4569A05DA3EF578449A5DA65F5E7", hash_generated_method = "A9549D4A380BFE595E1EACCC92A8B863")
    public  Socket(InetAddress dstAddress, int dstPort,
            InetAddress localAddress, int localPort) throws IOException {
        this();
        checkDestination(dstAddress, dstPort);
        startupSocket(dstAddress, dstPort, localAddress, localPort, true);
        addTaint(dstAddress.getTaint());
        addTaint(dstPort);
        addTaint(localAddress.getTaint());
        addTaint(localPort);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.820 -0400", hash_original_method = "D85BA2D34027734E343FA152CA6CE177", hash_generated_method = "223751D3E50BA5186914A4C53138EE0D")
    @Deprecated
    public  Socket(InetAddress addr, int port, boolean streaming) throws IOException {
        this();
        checkDestination(addr, port);
        startupSocket(addr, port, null, 0, streaming);
        addTaint(addr.getTaint());
        addTaint(port);
        addTaint(streaming);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.820 -0400", hash_original_method = "3BE6817A95031499261EFB4432AAFCBF", hash_generated_method = "79C2133882AE5B1F458B3CC625641B92")
    protected  Socket(SocketImpl impl) throws SocketException {
        this.impl = impl;
        this.proxy = null;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.822 -0400", hash_original_method = "FE893551BF445ECD0CF959494571F82D", hash_generated_method = "C189D441E2CE564A3820104FFFEC276B")
    private void tryAllAddresses(String dstName, int dstPort, InetAddress
            localAddress, int localPort, boolean streaming) throws IOException {
        InetAddress[] dstAddresses = InetAddress.getAllByName(dstName);
        InetAddress dstAddress;
        {
            int i = 0;
            {
                dstAddress = dstAddresses[i];
                try 
                {
                    checkDestination(dstAddress, dstPort);
                    startupSocket(dstAddress, dstPort, localAddress, localPort, streaming);
                } 
                catch (IOException ex)
                { }
            } 
        } 
        dstAddress = dstAddresses[dstAddresses.length - 1];
        checkDestination(dstAddress, dstPort);
        startupSocket(dstAddress, dstPort, localAddress, localPort, streaming);
        addTaint(dstName.getTaint());
        addTaint(dstPort);
        addTaint(localAddress.getTaint());
        addTaint(localPort);
        addTaint(streaming);
        
        
        
        
            
            
                
                
                
            
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.822 -0400", hash_original_method = "B238EF3FEB62ADA205D3F3298560A137", hash_generated_method = "CCD1F3E72DDE675BBB40BE0FF11DA93A")
    private void checkDestination(InetAddress destAddr, int dstPort) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Port out of range: " + dstPort);
        } 
        addTaint(destAddr.getTaint());
        addTaint(dstPort);
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.823 -0400", hash_original_method = "6609A304DB40C6FFC8F6AC783F01FDAC", hash_generated_method = "BEF433D9A28470F041DB000F7F9A5B35")
    public synchronized void close() throws IOException {
        isClosed = true;
        localAddress = Inet4Address.ANY;
        impl.close();
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.823 -0400", hash_original_method = "084821CC0A1E0331CE4D2BB5EC46E415", hash_generated_method = "819608A34BB9B87A4D561AD011AB3D4A")
    public InetAddress getInetAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_646358729 = null; 
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_2013553780 = null; 
        {
            boolean var341AB6969DFD2927CA563855F9EEB77E_843928130 = (!isConnected());
            {
                varB4EAC82CA7396A68D541C85D26508E83_646358729 = null;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2013553780 = impl.getInetAddress();
        InetAddress varA7E53CE21691AB073D9660D615818899_1587223312; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1587223312 = varB4EAC82CA7396A68D541C85D26508E83_646358729;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1587223312 = varB4EAC82CA7396A68D541C85D26508E83_2013553780;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1587223312.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1587223312;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.824 -0400", hash_original_method = "83F4AB21434B41B13879E1F39D268878", hash_generated_method = "56DA78669FFCD6B90095B77E4824BFAF")
    public InputStream getInputStream() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1660361124 = null; 
        checkOpenAndCreate(false);
        {
            boolean var899D12471AFC16D8818224BE7B57500A_1284409614 = (isInputShutdown());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket input is shutdown");
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1660361124 = impl.getInputStream();
        varB4EAC82CA7396A68D541C85D26508E83_1660361124.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1660361124;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.824 -0400", hash_original_method = "CB6F12AE5628FD4A044BF4AD41BFB963", hash_generated_method = "3DF476FE56A8AE2392804AFCB47B67AB")
    public boolean getKeepAlive() throws SocketException {
        checkOpenAndCreate(true);
        boolean var041E463ADEEF0C23B09546F75815EDF9_903176704 = ((Boolean) impl.getOption(SocketOptions.SO_KEEPALIVE));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2048765511 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2048765511;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.825 -0400", hash_original_method = "B81D9B2A12700622583B88DBCF07EC2E", hash_generated_method = "4385FADEDF2A73C862185219F1F422F0")
    public InetAddress getLocalAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1663642467 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1663642467 = localAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1663642467.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1663642467;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.825 -0400", hash_original_method = "F5BB694DF3469EBFBD82064FFB1FEAE0", hash_generated_method = "EFEED064787AA3B2AD20C2E7935F90AD")
    public int getLocalPort() {
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_2113334742 = (!isBound());
        } 
        int var5201144B0B742B3A152781D672D1AA30_17466197 = (impl.getLocalPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1401502391 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1401502391;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.826 -0400", hash_original_method = "0AB25EAA0774AA81766D4356986FC34F", hash_generated_method = "3609FC5343FB4BAED078BBDE34B81675")
    public OutputStream getOutputStream() throws IOException {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_921421690 = null; 
        checkOpenAndCreate(false);
        {
            boolean var721D80F1B38A860A3B065E2E7DC6E012_895600788 = (isOutputShutdown());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket output is shutdown");
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_921421690 = impl.getOutputStream();
        varB4EAC82CA7396A68D541C85D26508E83_921421690.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_921421690;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.826 -0400", hash_original_method = "0A0FE55C893091E17125D546A7D59C8C", hash_generated_method = "DC40B1615330F888227899C06245C4A8")
    public int getPort() {
        {
            boolean var341AB6969DFD2927CA563855F9EEB77E_893431238 = (!isConnected());
        } 
        int var804FC545E664230B0744C92D9C1FC410_408311532 = (impl.getPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_890165756 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_890165756;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.826 -0400", hash_original_method = "8044EC6E5CF2F698E1FE570A36824B05", hash_generated_method = "3BC5F16AB53D9EC79894C08651942723")
    public int getSoLinger() throws SocketException {
        checkOpenAndCreate(true);
        Object value = impl.getOption(SocketOptions.SO_LINGER);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1293621770 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1293621770;
        
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.826 -0400", hash_original_method = "49326126DE06A7EC2CFFBD7B3A14AE31", hash_generated_method = "A94A48D873CDE50D955DCCE6E062672D")
    public synchronized int getReceiveBufferSize() throws SocketException {
        checkOpenAndCreate(true);
        int var79D1B084DDFD041B24FC1B745ABBA44B_2110919480 = ((Integer) impl.getOption(SocketOptions.SO_RCVBUF));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2033129353 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2033129353;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.827 -0400", hash_original_method = "9FF5297C2B145A55844611E68CB98459", hash_generated_method = "D442CEE6369FFAAC18E1516246112B47")
    public synchronized int getSendBufferSize() throws SocketException {
        checkOpenAndCreate(true);
        int varCFC5A7023F175F2036FA0F4CD488B13F_899748669 = ((Integer) impl.getOption(SocketOptions.SO_SNDBUF));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1400814005 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1400814005;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.827 -0400", hash_original_method = "7DAE79431B5F9BEF40635CDD183C2B59", hash_generated_method = "08EF3BCD35321F78C5D0A7B3E3F27465")
    public synchronized int getSoTimeout() throws SocketException {
        checkOpenAndCreate(true);
        int varD23880532528160F55707BB89A021C2D_1003053433 = ((Integer) impl.getOption(SocketOptions.SO_TIMEOUT));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1623118016 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1623118016;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.827 -0400", hash_original_method = "3F059C4060D675A8035CAA8B5017EE1E", hash_generated_method = "D6B977E5973553769FD173C7E964200F")
    public boolean getTcpNoDelay() throws SocketException {
        checkOpenAndCreate(true);
        boolean var084D0845B8F25EFFBF84F2C2204185DB_936624568 = ((Boolean) impl.getOption(SocketOptions.TCP_NODELAY));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1790068474 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1790068474;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.827 -0400", hash_original_method = "B94B1A38E8CA82DAB010EC0768F89732", hash_generated_method = "2ECB8E5B368654CE5CB90AA57E928B6A")
    public void setKeepAlive(boolean keepAlive) throws SocketException {
        {
            checkOpenAndCreate(true);
            impl.setOption(SocketOptions.SO_KEEPALIVE, Boolean.valueOf(keepAlive));
        } 
        addTaint(keepAlive);
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    public static synchronized void setSocketImplFactory(SocketImplFactory fac) throws IOException {
        if (factory != null) {
            throw new SocketException("Factory already set");
        }
        factory = fac;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.828 -0400", hash_original_method = "AEB667B5DBC425D73D37135566ECC286", hash_generated_method = "3226E4F55935F478BB9C23241D5204C7")
    public synchronized void setSendBufferSize(int size) throws SocketException {
        checkOpenAndCreate(true);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size < 1");
        } 
        impl.setOption(SocketOptions.SO_SNDBUF, Integer.valueOf(size));
        addTaint(size);
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.828 -0400", hash_original_method = "1376DE896B8682F991877B7A17C5B3A4", hash_generated_method = "BD0796149356530A6893DDB730000696")
    public synchronized void setReceiveBufferSize(int size) throws SocketException {
        checkOpenAndCreate(true);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size < 1");
        } 
        impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
        addTaint(size);
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.828 -0400", hash_original_method = "89C38D96E5FBD4D1BD6CE4BD573A4473", hash_generated_method = "BBE5721672DE1C18771AE847E3BE7BF1")
    public void setSoLinger(boolean on, int timeout) throws SocketException {
        checkOpenAndCreate(true);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("timeout < 0");
        } 
        {
            impl.setOption(SocketOptions.SO_LINGER, Integer.valueOf(timeout));
        } 
        {
            impl.setOption(SocketOptions.SO_LINGER, Boolean.FALSE);
        } 
        addTaint(on);
        addTaint(timeout);
        
        
        
            
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.829 -0400", hash_original_method = "EA919996CC1899AC4E781314DA47161A", hash_generated_method = "D718A6FF920C18A510F9A3EC3592B4C0")
    public synchronized void setSoTimeout(int timeout) throws SocketException {
        checkOpenAndCreate(true);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("timeout < 0");
        } 
        impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(timeout));
        addTaint(timeout);
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.829 -0400", hash_original_method = "04E6A4AAAA03D3C2F3E4334A66D2F7A1", hash_generated_method = "89173C7096F663DF9419936480F4F53F")
    public void setTcpNoDelay(boolean on) throws SocketException {
        checkOpenAndCreate(true);
        impl.setOption(SocketOptions.TCP_NODELAY, Boolean.valueOf(on));
        addTaint(on);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.829 -0400", hash_original_method = "20DD1F1CA9EDC17BE2B90F2B7E5FF655", hash_generated_method = "D631D2BCD4D34A36E457C5D4A13F0C2A")
    private void startupSocket(InetAddress dstAddress, int dstPort,
            InetAddress localAddress, int localPort, boolean streaming) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Local port out of range: " + localPort);
        } 
        InetAddress addr;
        addr = Inet4Address.ANY;
        addr = localAddress;
        {
            impl.create(streaming);
            isCreated = true;
            try 
            {
                {
                    boolean var2212C8D76AB677AF4319CDF4B542D69A_1354926376 = (!streaming || !usingSocks());
                    {
                        impl.bind(addr, localPort);
                    } 
                } 
                isBound = true;
                impl.connect(dstAddress, dstPort);
                isConnected = true;
                cacheLocalAddress();
            } 
            catch (IOException e)
            {
                impl.close();
                if (DroidSafeAndroidRuntime.control) throw e;
            } 
        } 
        addTaint(dstAddress.getTaint());
        addTaint(dstPort);
        addTaint(localAddress.getTaint());
        addTaint(localPort);
        addTaint(streaming);
        
        
            
        
        
        
            
            
            
                
                    
                
                
                
                
                
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.830 -0400", hash_original_method = "933F73796CB698722A986AC13FC9BFF8", hash_generated_method = "DB593CF300B9692F4980358ECF6CDA62")
    private boolean usingSocks() {
        boolean var78F22D973B8E4232A59324CAA691F0AB_13399238 = (proxy != null && proxy.type() == Proxy.Type.SOCKS);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1663559219 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1663559219;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.831 -0400", hash_original_method = "881D40A46B027F3EDC8B30A9F4F44097", hash_generated_method = "38170CE7C5702DE6868162EBED2CAA8E")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_269692942 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1715988507 = null; 
        {
            boolean var341AB6969DFD2927CA563855F9EEB77E_138607321 = (!isConnected());
            {
                varB4EAC82CA7396A68D541C85D26508E83_269692942 = "Socket[unconnected]";
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1715988507 = impl.toString();
        String varA7E53CE21691AB073D9660D615818899_135652896; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_135652896 = varB4EAC82CA7396A68D541C85D26508E83_269692942;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_135652896 = varB4EAC82CA7396A68D541C85D26508E83_1715988507;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_135652896.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_135652896;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.831 -0400", hash_original_method = "D21BBF88E7F4579ADC8933941E3433FA", hash_generated_method = "CD4CBDB6FEEE348B3D48395F65CA80D4")
    public void shutdownInput() throws IOException {
        {
            boolean var899D12471AFC16D8818224BE7B57500A_1025671914 = (isInputShutdown());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket input is shutdown");
            } 
        } 
        checkOpenAndCreate(false);
        impl.shutdownInput();
        isInputShutdown = true;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.832 -0400", hash_original_method = "1AECC9ACE476BBC93D823FC75BDACBC6", hash_generated_method = "53F40A5AB046690C3BADFF369DE3E67F")
    public void shutdownOutput() throws IOException {
        {
            boolean var721D80F1B38A860A3B065E2E7DC6E012_548987765 = (isOutputShutdown());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket output is shutdown");
            } 
        } 
        checkOpenAndCreate(false);
        impl.shutdownOutput();
        isOutputShutdown = true;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.834 -0400", hash_original_method = "80C03A9E4F151BE4271ACE586291D7DE", hash_generated_method = "414FCAED7F183FB5A3FABAC8A89026ED")
    private void checkOpenAndCreate(boolean create) throws SocketException {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_370088641 = (isClosed());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket is closed");
            } 
        } 
        {
            {
                boolean varD001DA76880A087CD0A30FA1D399A199_194216006 = (!isConnected());
                {
                    if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket is not connected");
                } 
            } 
        } 
        {
            try 
            {
                impl.create(true);
            } 
            catch (SocketException e)
            {
                if (DroidSafeAndroidRuntime.control) throw e;
            } 
            catch (IOException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException(e.toString());
            } 
            isCreated = true;
        } 
        addTaint(create);
        
        
            
        
        
            
                
            
            
        
        
            
        
        
            
                
            
            
                
            
                
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.835 -0400", hash_original_method = "AE126A441E32CF7358FEDD7A95BAD391", hash_generated_method = "A6067815E84715E440228663709B48BC")
    public SocketAddress getLocalSocketAddress() {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_1370277106 = null; 
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_1064082931 = null; 
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_298613185 = (!isBound());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1370277106 = null;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1064082931 = new InetSocketAddress(getLocalAddress(), getLocalPort());
        SocketAddress varA7E53CE21691AB073D9660D615818899_150071200; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_150071200 = varB4EAC82CA7396A68D541C85D26508E83_1370277106;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_150071200 = varB4EAC82CA7396A68D541C85D26508E83_1064082931;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_150071200.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_150071200;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.836 -0400", hash_original_method = "7C698472BF26D61A7917F4B5238C5FF7", hash_generated_method = "25BF78662D3638BA2E70E8DA3ED7B496")
    public SocketAddress getRemoteSocketAddress() {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_1559530641 = null; 
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_566865033 = null; 
        {
            boolean var341AB6969DFD2927CA563855F9EEB77E_515044356 = (!isConnected());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1559530641 = null;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_566865033 = new InetSocketAddress(getInetAddress(), getPort());
        SocketAddress varA7E53CE21691AB073D9660D615818899_1731712891; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1731712891 = varB4EAC82CA7396A68D541C85D26508E83_1559530641;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1731712891 = varB4EAC82CA7396A68D541C85D26508E83_566865033;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1731712891.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1731712891;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.836 -0400", hash_original_method = "589AFDD4CA6BF38ABB5F59E26BB3DC6D", hash_generated_method = "4CD3E1CE720811AF06D86AE88FEC4959")
    public boolean isBound() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1123201927 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1123201927;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.837 -0400", hash_original_method = "B1255CDE181FFAAB8CB434FB98B99FFF", hash_generated_method = "4E080CE2FFF71BDB04021DF8AEE0EAB3")
    public boolean isConnected() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1268042484 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1268042484;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.837 -0400", hash_original_method = "2EEDDDEB8BA1CD500E3647BC397BF54F", hash_generated_method = "5623A9507DD24DCB4293BEA9541B8BBD")
    public boolean isClosed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_343228305 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_343228305;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.838 -0400", hash_original_method = "9E3C378994EF9A4091E39D0FA34770F8", hash_generated_method = "34F1DFB37B7C12CB3DBE762D96E5D2FF")
    public void bind(SocketAddress localAddr) throws IOException {
        checkOpenAndCreate(true);
        {
            boolean var508204320144CEB3F447DE9CCDB64480_540818440 = (isBound());
            {
                if (DroidSafeAndroidRuntime.control) throw new BindException("Socket is already bound");
            } 
        } 
        int port = 0;
        InetAddress addr = Inet4Address.ANY;
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Local address not an InetSocketAddress: " +
                        localAddr.getClass());
            } 
            InetSocketAddress inetAddr = (InetSocketAddress) localAddr;
            {
                boolean varC74AE0463916E813FB227E6D8242C56F_1058343500 = ((addr = inetAddr.getAddress()) == null);
                {
                    if (DroidSafeAndroidRuntime.control) throw new UnknownHostException("Host is unresolved: " + inetAddr.getHostName());
                } 
            } 
            port = inetAddr.getPort();
        } 
        {
            try 
            {
                impl.bind(addr, port);
                isBound = true;
                cacheLocalAddress();
            } 
            catch (IOException e)
            {
                impl.close();
                if (DroidSafeAndroidRuntime.control) throw e;
            } 
        } 
        addTaint(localAddr.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.839 -0400", hash_original_method = "B2F3815725658D73C0532A54E6C164BA", hash_generated_method = "BB337763E900750F306DD7ECDCF2158C")
    public void connect(SocketAddress remoteAddr) throws IOException {
        connect(remoteAddr, 0);
        addTaint(remoteAddr.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.839 -0400", hash_original_method = "45EED4DE787227F7BEC68E335C7AA6E7", hash_generated_method = "6C6B95F083A792D0828A1C90E3367CF4")
    public void connect(SocketAddress remoteAddr, int timeout) throws IOException {
        checkOpenAndCreate(true);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("timeout < 0");
        } 
        {
            boolean var5153987C55DB41759ADC1D7527E9459D_764718272 = (isConnected());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Already connected");
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("remoteAddr == null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Remote address not an InetSocketAddress: " +
                    remoteAddr.getClass());
        } 
        InetSocketAddress inetAddr = (InetSocketAddress) remoteAddr;
        InetAddress addr;
        {
            boolean var3A90A8ECED80469E6C4DBC0D965BCC76_870759533 = ((addr = inetAddr.getAddress()) == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new UnknownHostException("Host is unresolved: " + inetAddr.getHostName());
            } 
        } 
        int port = inetAddr.getPort();
        checkDestination(addr, port);
        {
            try 
            {
                {
                    boolean var51251543F279E208469B7565700B7E80_2076217951 = (!isBound());
                    {
                        {
                            boolean var24AE71A7EC560AD214D100F7850BDFF8_819155226 = (!usingSocks());
                            {
                                impl.bind(Inet4Address.ANY, 0);
                            } 
                        } 
                        isBound = true;
                    } 
                } 
                impl.connect(remoteAddr, timeout);
                isConnected = true;
                cacheLocalAddress();
            } 
            catch (IOException e)
            {
                impl.close();
                if (DroidSafeAndroidRuntime.control) throw e;
            } 
        } 
        addTaint(remoteAddr.getTaint());
        addTaint(timeout);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.840 -0400", hash_original_method = "2FA07403172C73A0B79A0DF7F37DEBFB", hash_generated_method = "A003A427559CFD69A88F750743D2D328")
    public boolean isInputShutdown() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_419310006 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_419310006;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.840 -0400", hash_original_method = "C1B1C01C4973B5698673C5D09FA67185", hash_generated_method = "4672E0409F1132EEF9AB42507E09FD32")
    public boolean isOutputShutdown() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_152055258 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_152055258;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.841 -0400", hash_original_method = "6CEA4E5A53899EBE8D1FD08F2FE40675", hash_generated_method = "39B146F11D856CC9843D732D4E2061C0")
    public void setReuseAddress(boolean reuse) throws SocketException {
        checkOpenAndCreate(true);
        impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
        addTaint(reuse);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.842 -0400", hash_original_method = "8D0919FD23B9A2472FC046E6B1704481", hash_generated_method = "E9F52A0FA01934469B49C9056B8DEA1E")
    public boolean getReuseAddress() throws SocketException {
        checkOpenAndCreate(true);
        boolean varCE142DF7D7C52AD31EFC3E546F2DD316_779679500 = ((Boolean) impl.getOption(SocketOptions.SO_REUSEADDR));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_591508621 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_591508621;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.842 -0400", hash_original_method = "8F9774180DF7F00524B2F69126E7F96E", hash_generated_method = "9D3EFD096926A8E155DEF836A7789736")
    public void setOOBInline(boolean oobinline) throws SocketException {
        checkOpenAndCreate(true);
        impl.setOption(SocketOptions.SO_OOBINLINE, Boolean.valueOf(oobinline));
        addTaint(oobinline);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.843 -0400", hash_original_method = "A307BAC96AD0AD9185D724CFFBC60918", hash_generated_method = "CC96D068F75DF75B6AB8C82CFC4F05EF")
    public boolean getOOBInline() throws SocketException {
        checkOpenAndCreate(true);
        boolean varCB6AA2E4A86BFAA8F54C6C5D29BB281D_1269119825 = ((Boolean) impl.getOption(SocketOptions.SO_OOBINLINE));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1939134560 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1939134560;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.843 -0400", hash_original_method = "50A48D0E3EC8A723BC37542164C52A31", hash_generated_method = "C3B01BF49AE1D06CFCA39558D136DF48")
    public void setTrafficClass(int value) throws SocketException {
        checkOpenAndCreate(true);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        impl.setOption(SocketOptions.IP_TOS, Integer.valueOf(value));
        addTaint(value);
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.844 -0400", hash_original_method = "D7C7CF134B3FE725817BA2C07D220760", hash_generated_method = "06105528B490B1CEBB8120FD5A2366A0")
    public int getTrafficClass() throws SocketException {
        checkOpenAndCreate(true);
        int var9C2568077066805EC4361C5C54BBCF61_937686641 = ((Integer) impl.getOption(SocketOptions.IP_TOS));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_324776894 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_324776894;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.845 -0400", hash_original_method = "CBFC447F34929AC991DFFA20015F8279", hash_generated_method = "9439B775AB4C29CDB458DB7934DF9254")
    public void sendUrgentData(int value) throws IOException {
        impl.sendUrgentData(value);
        addTaint(value);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.847 -0400", hash_original_method = "21E3234EAE6C3F4479E6E7944641B8BE", hash_generated_method = "7AA833B05FB6D1983035B8C7720A9AD2")
     void accepted() {
        isCreated = isBound = isConnected = true;
        cacheLocalAddress();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.848 -0400", hash_original_method = "95A7BF302299AFCDED7970E2F7424717", hash_generated_method = "794BDF12835FAD96C22BC1E6B513ECB3")
    private void cacheLocalAddress() {
        this.localAddress = IoBridge.getSocketLocalAddress(impl.fd);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.850 -0400", hash_original_method = "A7DB57A03C94477191BD1BBD8D530AC8", hash_generated_method = "7C488EF41A025CD045DBC27C72D6C1EB")
    public SocketChannel getChannel() {
        SocketChannel varB4EAC82CA7396A68D541C85D26508E83_666126084 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_666126084 = null;
        varB4EAC82CA7396A68D541C85D26508E83_666126084.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_666126084;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.851 -0400", hash_original_method = "90C19CEBA6BBC20B430C1F399D6443A6", hash_generated_method = "A0ECF1F035BA5BA122965E620432D62C")
    public FileDescriptor getFileDescriptor$() {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1801778275 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1801778275 = impl.fd;
        varB4EAC82CA7396A68D541C85D26508E83_1801778275.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1801778275;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.851 -0400", hash_original_method = "EE4DCDA11944F25F3B6AAA6A92D8AD2F", hash_generated_method = "5BDBFA2FBDAEAD861B5CE7312955EF38")
    public void setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
        addTaint(connectionTime);
        addTaint(latency);
        addTaint(bandwidth);
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.851 -0400", hash_original_field = "9549DD6065D019211460C59A86DD6536", hash_generated_field = "ABE875F9FF8F88D9D548D2F2A5A13861")

    private static SocketImplFactory factory;
}

