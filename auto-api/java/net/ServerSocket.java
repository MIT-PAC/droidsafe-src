package java.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.nio.channels.ServerSocketChannel;

public class ServerSocket {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.739 -0400", hash_original_field = "86CCEC3D9FF0E9C0514506E982CDC08B", hash_generated_field = "E5435F593B4B4C544AAC5D578CFF6639")

    private SocketImpl impl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.739 -0400", hash_original_field = "8E4D35088206920061AAF7F347854388", hash_generated_field = "C0B93BC213B673FF2E47783C561E2823")

    private boolean isBound;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.739 -0400", hash_original_field = "7587750400D3C39AEAD7C1489F6FE7F3", hash_generated_field = "61C76B683BBEFCB5006250611D355A94")

    private boolean isClosed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.739 -0400", hash_original_method = "31BB74D5896D397B1327C5B34E5CB836", hash_generated_method = "CC783DD97FFEF08036B1A4D90EFE45DF")
    public  ServerSocket() throws IOException {
        this.impl = factory != null ? factory.createSocketImpl()
                : new PlainServerSocketImpl();
        impl.create(true);
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.739 -0400", hash_original_method = "17E5A7EAB5FF74551872A5C22051BFB5", hash_generated_method = "8188B0E7B9ACD2CC1652950807628542")
    public  ServerSocket(int port) throws IOException {
        this(port, DEFAULT_BACKLOG, Inet4Address.ANY);
        addTaint(port);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.740 -0400", hash_original_method = "B81C30D251B31CAFF71CF07C7882EF32", hash_generated_method = "F0AE178AE604AD8B8649389E2A81D277")
    public  ServerSocket(int port, int backlog) throws IOException {
        this(port, backlog, Inet4Address.ANY);
        addTaint(port);
        addTaint(backlog);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.740 -0400", hash_original_method = "6BB36DC8E15E305D7407A47C7739996C", hash_generated_method = "8D2E13A6A82513C911966AE4610C2C7E")
    public  ServerSocket(int port, int backlog, InetAddress localAddress) throws IOException {
        checkListen(port);
        this.impl = factory != null ? factory.createSocketImpl()
                : new PlainServerSocketImpl();
        InetAddress addr;
        addr = Inet4Address.ANY;
        addr = localAddress;
        {
            impl.create(true);
            try 
            {
                impl.bind(addr, port);
                isBound = true;
                impl.listen(backlog > 0 ? backlog : DEFAULT_BACKLOG);
            } 
            catch (IOException e)
            {
                close();
                if (DroidSafeAndroidRuntime.control) throw e;
            } 
        } 
        addTaint(port);
        addTaint(backlog);
        addTaint(localAddress.getTaint());
        
        
        
                
        
        
            
            
                
                
                
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.741 -0400", hash_original_method = "847F07D140851DC7DF04F3DA230B7EED", hash_generated_method = "B155776CABA4580D7775D3A9B2EC3485")
    public SocketImpl getImpl$() {
        SocketImpl varB4EAC82CA7396A68D541C85D26508E83_1316014577 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1316014577 = impl;
        varB4EAC82CA7396A68D541C85D26508E83_1316014577.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1316014577;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.742 -0400", hash_original_method = "DE0153D2AABFEE83527E2EAC5D1F68DF", hash_generated_method = "AEA4ED584D3135959878D35659B56203")
    public Socket accept() throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_720255953 = null; 
        checkOpen();
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_1814287194 = (!isBound());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket is not bound");
            } 
        } 
        Socket aSocket = new Socket();
        try 
        {
            implAccept(aSocket);
        } 
        catch (IOException e)
        {
            aSocket.close();
            if (DroidSafeAndroidRuntime.control) throw e;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_720255953 = aSocket;
        varB4EAC82CA7396A68D541C85D26508E83_720255953.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_720255953;
        
        
        
            
        
        
        
            
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.742 -0400", hash_original_method = "C273B8F533783A3DE90657F5715801E0", hash_generated_method = "0C56E3FDAF8D797D3DCDEFE5047DA8AD")
    private void checkListen(int aPort) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Port out of range: " + aPort);
        } 
        addTaint(aPort);
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.742 -0400", hash_original_method = "8636C7CEC5FFD33F6CBF2C75F9E6A135", hash_generated_method = "09C692F3B9ABE75F75305B3C4044C0D5")
    public void close() throws IOException {
        isClosed = true;
        impl.close();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.743 -0400", hash_original_method = "0AAA019638F2B2CC41FFEEEB4E260F6C", hash_generated_method = "C0354FEFE8E834E72E59A24B825B7734")
    public InetAddress getInetAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_933834625 = null; 
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1145173221 = null; 
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_438511150 = (!isBound());
            {
                varB4EAC82CA7396A68D541C85D26508E83_933834625 = null;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1145173221 = impl.getInetAddress();
        InetAddress varA7E53CE21691AB073D9660D615818899_1242853975; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1242853975 = varB4EAC82CA7396A68D541C85D26508E83_933834625;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1242853975 = varB4EAC82CA7396A68D541C85D26508E83_1145173221;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1242853975.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1242853975;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.745 -0400", hash_original_method = "F5BB694DF3469EBFBD82064FFB1FEAE0", hash_generated_method = "BFFFA900C36371B4FAEEB233FEB89BB9")
    public int getLocalPort() {
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_644563732 = (!isBound());
        } 
        int var5201144B0B742B3A152781D672D1AA30_1529862831 = (impl.getLocalPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1149174321 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1149174321;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.747 -0400", hash_original_method = "37BE74568AC5DDD629C634B42E81BFFA", hash_generated_method = "432F4811CBFD7D10AD9F86350A05C81A")
    public synchronized int getSoTimeout() throws IOException {
        checkOpen();
        int var97D6E04E407212E66322CDB8618B167A_463598314 = (((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_126484466 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_126484466;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.748 -0400", hash_original_method = "BFFC5C44CB4D0AB53035D05D9EAC93F6", hash_generated_method = "6CC5BC16237DC902354AC0A460666FF0")
    protected final void implAccept(Socket aSocket) throws IOException {
        {
            impl.accept(aSocket.impl);
            aSocket.accepted();
        } 
        addTaint(aSocket.getTaint());
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    public static synchronized void setSocketFactory(SocketImplFactory aFactory) throws IOException {
        if (factory != null) {
            throw new SocketException("Factory already set");
        }
        factory = aFactory;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.749 -0400", hash_original_method = "E2A5F03981AB4BF932E59A553E83FA6F", hash_generated_method = "715987126166DD9C37EE215B53FACCCF")
    public synchronized void setSoTimeout(int timeout) throws SocketException {
        checkOpen();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("timeout < 0");
        } 
        impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(timeout));
        addTaint(timeout);
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.750 -0400", hash_original_method = "577ACC2D572353EA5861EB3648159EF5", hash_generated_method = "904D9ACE03276086C1994EA2B6820B4F")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1134311169 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_172057747 = null; 
        StringBuilder result = new StringBuilder(64);
        result.append("ServerSocket[");
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_668358009 = (!isBound());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1134311169 = result.append("unbound]").toString();
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_172057747 = result.append("addr=")
                .append(getInetAddress().getHostName()).append("/")
                .append(getInetAddress().getHostAddress()).append(
                        ",port=0,localport=")
                .append(getLocalPort()).append("]")
                .toString();
        String varA7E53CE21691AB073D9660D615818899_2047910392; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2047910392 = varB4EAC82CA7396A68D541C85D26508E83_1134311169;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2047910392 = varB4EAC82CA7396A68D541C85D26508E83_172057747;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2047910392.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2047910392;
        
        
        
        
            
        
        
                
                
                        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.751 -0400", hash_original_method = "AB1F91AE5F8F2B3C00C4EDCF73D5B4D1", hash_generated_method = "2CAD37934CCBAF068B5EDB43E7CA5E1C")
    public void bind(SocketAddress localAddr) throws IOException {
        bind(localAddr, DEFAULT_BACKLOG);
        addTaint(localAddr.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.751 -0400", hash_original_method = "684D242B2EA0BE4D55F437B908E9CC5D", hash_generated_method = "062C8E9841EBC39F9A5753955E414676")
    public void bind(SocketAddress localAddr, int backlog) throws IOException {
        checkOpen();
        {
            boolean var508204320144CEB3F447DE9CCDB64480_122820774 = (isBound());
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
                boolean varC74AE0463916E813FB227E6D8242C56F_976863219 = ((addr = inetAddr.getAddress()) == null);
                {
                    if (DroidSafeAndroidRuntime.control) throw new SocketException("Host is unresolved: " + inetAddr.getHostName());
                } 
            } 
            port = inetAddr.getPort();
        } 
        {
            try 
            {
                impl.bind(addr, port);
                isBound = true;
                impl.listen(backlog > 0 ? backlog : DEFAULT_BACKLOG);
            } 
            catch (IOException e)
            {
                close();
                if (DroidSafeAndroidRuntime.control) throw e;
            } 
        } 
        addTaint(localAddr.getTaint());
        addTaint(backlog);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.753 -0400", hash_original_method = "7AD76537AA5A3220834213189640F2E9", hash_generated_method = "07B9DD4B357F4CB05CF3FA05B51F9291")
    public SocketAddress getLocalSocketAddress() {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_441093208 = null; 
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_14257958 = null; 
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_44582030 = (!isBound());
            {
                varB4EAC82CA7396A68D541C85D26508E83_441093208 = null;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_14257958 = new InetSocketAddress(getInetAddress(), getLocalPort());
        SocketAddress varA7E53CE21691AB073D9660D615818899_1002364545; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1002364545 = varB4EAC82CA7396A68D541C85D26508E83_441093208;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1002364545 = varB4EAC82CA7396A68D541C85D26508E83_14257958;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1002364545.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1002364545;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.753 -0400", hash_original_method = "589AFDD4CA6BF38ABB5F59E26BB3DC6D", hash_generated_method = "3465E11F0F4BE51D7DF199E93A4456EA")
    public boolean isBound() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_101753087 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_101753087;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.754 -0400", hash_original_method = "2EEDDDEB8BA1CD500E3647BC397BF54F", hash_generated_method = "58519B4790B59DA47D9D9ADB2B77CAE4")
    public boolean isClosed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1492444945 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1492444945;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.754 -0400", hash_original_method = "8DC54C39C6445BAF3181407C830C5887", hash_generated_method = "3BF9F647260CAD949BE15CA687F832F4")
    private void checkOpen() throws SocketException {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_1075057210 = (isClosed());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket is closed");
            } 
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.755 -0400", hash_original_method = "D6CD69E67882E49578E557811A0FC457", hash_generated_method = "FC3E7A197DB1A0060F368E39CFC6FAA6")
    public void setReuseAddress(boolean reuse) throws SocketException {
        checkOpen();
        impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
        addTaint(reuse);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.756 -0400", hash_original_method = "8920D58954E3583481E89192EF874E86", hash_generated_method = "308A85C528859641D88B55B0AB88D4A9")
    public boolean getReuseAddress() throws SocketException {
        checkOpen();
        boolean var92F4A5EAF76459C680E3D19F2BDB3A81_603396747 = (((Boolean) impl.getOption(SocketOptions.SO_REUSEADDR)).booleanValue());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1256893876 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1256893876;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.756 -0400", hash_original_method = "4A5F0E88940F2B7162C81724AB1FDFE4", hash_generated_method = "A9C53F0A23EF3A99BACC3D6A19C71CF7")
    public void setReceiveBufferSize(int size) throws SocketException {
        checkOpen();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size < 1");
        } 
        impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
        addTaint(size);
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.757 -0400", hash_original_method = "1025A74ACDCA065D38BE1D18813D43DB", hash_generated_method = "C23F3B180F528AB7446BD8949DD0E680")
    public int getReceiveBufferSize() throws SocketException {
        checkOpen();
        int var879D57EDA18A262547327AC0C51A7315_352758119 = (((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_84046626 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_84046626;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.757 -0400", hash_original_method = "3D28E6253835634FC7711C1CE3F0C48B", hash_generated_method = "48C3635551DC6AFC2606B0EA90054CF4")
    public ServerSocketChannel getChannel() {
        ServerSocketChannel varB4EAC82CA7396A68D541C85D26508E83_1619111911 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1619111911 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1619111911.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1619111911;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.758 -0400", hash_original_method = "EE4DCDA11944F25F3B6AAA6A92D8AD2F", hash_generated_method = "5BDBFA2FBDAEAD861B5CE7312955EF38")
    public void setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
        addTaint(connectionTime);
        addTaint(latency);
        addTaint(bandwidth);
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.758 -0400", hash_original_field = "4E99CD0551993624E0E83995EFF618A2", hash_generated_field = "0D50DA6800F2DE564A61761F3E32E3F7")

    private static final int DEFAULT_BACKLOG = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.758 -0400", hash_original_field = "9549DD6065D019211460C59A86DD6536", hash_generated_field = "10D4EEC45D11B59A6B6543CD9427385B")

    static SocketImplFactory factory;
}

