package java.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.DatagramChannel;
import libcore.io.ErrnoException;
import libcore.io.Libcore;
import static libcore.io.OsConstants.*;

public class DatagramSocket {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.110 -0400", hash_original_field = "86CCEC3D9FF0E9C0514506E982CDC08B", hash_generated_field = "0E47AFFF5CC1F2155F99BECA6A70C2D2")

    DatagramSocketImpl impl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.110 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "FDCE7272CFC91A6374FBF7F54D5CC8E4")

    InetAddress address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.110 -0400", hash_original_field = "CAB9CCA4AFFBFB7ECB540E3002763641", hash_generated_field = "BAF684EECB20D799A434AFCF1B13F01D")

    int port = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.110 -0400", hash_original_field = "1EA05BED8F3F3741889B40C4407A936D", hash_generated_field = "F9AB7682F64A4F93F6F4A7A435A5AA53")

    boolean isBound = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.110 -0400", hash_original_field = "F0F0EDCF28D811EA172AA0A0A89A5056", hash_generated_field = "058DE1E699A3B3D187FC9E15DB7EC3B5")

    private boolean isConnected = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.110 -0400", hash_original_field = "07C7CAC105556325A010A5AA708B362E", hash_generated_field = "BBB4D111812AF32431191097BEE30ACB")

    private SocketException pendingConnectException;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.110 -0400", hash_original_field = "7624DFAF468575D3B7DCE21DA2796711", hash_generated_field = "2CBEAC942D14DA48C324142BCB214C18")

    private boolean isClosed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.110 -0400", hash_original_field = "DD465B0839A70592931A97D99A9DB042", hash_generated_field = "B291AA80E80AF2EADD13F4FAD6374324")

    private Object lock = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.111 -0400", hash_original_method = "600D2DC769AA1337C3E52515B77C9BA6", hash_generated_method = "834126E5D9F38C7E6D68D7A94139CCD5")
    public  DatagramSocket() throws SocketException {
        this(0);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.111 -0400", hash_original_method = "5C9F869A9F8E783507AEDF83BF8CB0B7", hash_generated_method = "788C09794FDAB9E55E836748E5A680E8")
    public  DatagramSocket(int aPort) throws SocketException {
        checkPort(aPort);
        createSocket(aPort, Inet4Address.ANY);
        addTaint(aPort);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.111 -0400", hash_original_method = "CB0AFEB195CAFC978B9076AC8691C2BF", hash_generated_method = "6856810D7F9A9C74E0F6510A2C81A953")
    public  DatagramSocket(int aPort, InetAddress addr) throws SocketException {
        checkPort(aPort);
        createSocket(aPort, (addr == null) ? Inet4Address.ANY : addr);
        addTaint(aPort);
        addTaint(addr.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.112 -0400", hash_original_method = "8791E60C190AA1CE5F0CD19BC0C9D10B", hash_generated_method = "134B4F01DF9AD12FA03C559D3EAA2F74")
    protected  DatagramSocket(DatagramSocketImpl socketImpl) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        impl = socketImpl;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.112 -0400", hash_original_method = "F9D705BC16951CA970DD006A85C9F283", hash_generated_method = "C638960D97D55F3264A1081DEDC28D75")
    public  DatagramSocket(SocketAddress localAddr) throws SocketException {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Local address not an InetSocketAddress: " +
                        localAddr.getClass());
            } 
            checkPort(((InetSocketAddress) localAddr).getPort());
        } 
        impl = factory != null ? factory.createDatagramSocketImpl()
                : new PlainDatagramSocketImpl();
        impl.create();
        {
            try 
            {
                bind(localAddr);
            } 
            catch (SocketException e)
            {
                close();
                if (DroidSafeAndroidRuntime.control) throw e;
            } 
        } 
        setBroadcast(true);
        addTaint(localAddr.getTaint());
        
        
            
                
                        
            
            
        
        
                
        
        
            
                
            
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.113 -0400", hash_original_method = "70ACB9C2984CE075C85AFFAB4CC3F2C3", hash_generated_method = "90B78CBDB34B18A4414864713B5DA474")
    private void checkPort(int aPort) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Port out of range: " + aPort);
        } 
        addTaint(aPort);
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.113 -0400", hash_original_method = "613628CBB35065AE6B36DA8B5C0D3152", hash_generated_method = "CEB5A5E4301107E97D1EEC22C66FA42C")
    public void close() {
        isClosed = true;
        impl.close();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.113 -0400", hash_original_method = "53DC6FE247829A3F8E1E61F886EC8A69", hash_generated_method = "78BA600C24CE4C59A2EAED344B1E9D1C")
    public void disconnect() {
        {
            boolean var7A0895E165322EB228A34E837EE13B5D_1529082594 = (isClosed() || !isConnected());
        } 
        impl.disconnect();
        address = null;
        port = -1;
        isConnected = false;
        
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.114 -0400", hash_original_method = "CDBEDFAF0027896E1E3D56B522D080D1", hash_generated_method = "784F24AD771BC2278D405321C1A28EBB")
    synchronized void createSocket(int aPort, InetAddress addr) throws SocketException {
        impl = factory != null ? factory.createDatagramSocketImpl()
                : new PlainDatagramSocketImpl();
        impl.create();
        try 
        {
            impl.bind(aPort, addr);
            isBound = true;
        } 
        catch (SocketException e)
        {
            close();
            if (DroidSafeAndroidRuntime.control) throw e;
        } 
        addTaint(aPort);
        addTaint(addr.getTaint());
        
        
                
        
        
            
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.115 -0400", hash_original_method = "9059089CB1C35AC3C53D636B58746A1E", hash_generated_method = "B89513A7B024522C5391AF5AB6B68646")
    public InetAddress getInetAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1487697280 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1487697280 = address;
        varB4EAC82CA7396A68D541C85D26508E83_1487697280.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1487697280;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.116 -0400", hash_original_method = "120EDBD12BFFA2CD78689E1CCCEFC0A6", hash_generated_method = "529E27B48921F3BF766E449AC4CDF1CB")
    public InetAddress getLocalAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_295480332 = null; 
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_771089417 = null; 
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1739658918 = null; 
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_1460203632 = (isClosed());
            {
                varB4EAC82CA7396A68D541C85D26508E83_295480332 = null;
            } 
        } 
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_1815843298 = (!isBound());
            {
                varB4EAC82CA7396A68D541C85D26508E83_771089417 = Inet4Address.ANY;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1739658918 = impl.getLocalAddress();
        InetAddress varA7E53CE21691AB073D9660D615818899_1746703849; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1746703849 = varB4EAC82CA7396A68D541C85D26508E83_295480332;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1746703849 = varB4EAC82CA7396A68D541C85D26508E83_771089417;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1746703849 = varB4EAC82CA7396A68D541C85D26508E83_1739658918;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1746703849.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1746703849;
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.116 -0400", hash_original_method = "C20A7438B6018D8C8B6C316459831E1B", hash_generated_method = "EE1AAC5B5D9E0E637116AA97C87D88C6")
    public int getLocalPort() {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_1266689534 = (isClosed());
        } 
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_488225996 = (!isBound());
        } 
        int var5201144B0B742B3A152781D672D1AA30_2001879812 = (impl.getLocalPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1979702831 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1979702831;
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.117 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "73CA664571096DC888CD987FC14A68B5")
    public int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_694633207 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_694633207;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.117 -0400", hash_original_method = "4991C56903C24C085B034589D2617CA7", hash_generated_method = "39027CAB784DFC481397390069464BA9")
     boolean isMulticastSocket() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1070269038 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1070269038;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.117 -0400", hash_original_method = "1025A74ACDCA065D38BE1D18813D43DB", hash_generated_method = "BA6EE9F274C475F27690CFF231DA4739")
    public synchronized int getReceiveBufferSize() throws SocketException {
        checkOpen();
        int var879D57EDA18A262547327AC0C51A7315_1706574380 = (((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1270874584 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1270874584;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.117 -0400", hash_original_method = "D220B9D2C157A98A9F2FC338F369BDAA", hash_generated_method = "ECB52B28FCE55CFE53FBBFB771E2B9BC")
    public synchronized int getSendBufferSize() throws SocketException {
        checkOpen();
        int var3BBCE4DA0E6FB31CEB590594F23B0AFE_1154023045 = (((Integer) impl.getOption(SocketOptions.SO_SNDBUF)).intValue());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1935600415 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1935600415;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.118 -0400", hash_original_method = "E87267C7B03A68795BE159270DE33B7D", hash_generated_method = "4E949D2624163B561E3C23CFE65FE54F")
    public synchronized int getSoTimeout() throws SocketException {
        checkOpen();
        int var97D6E04E407212E66322CDB8618B167A_655771986 = (((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1862555451 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1862555451;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.118 -0400", hash_original_method = "C2244B28A3A8977EAD72461E3F35998B", hash_generated_method = "294549854FCCEF4D943874B79EB0E9F7")
    public synchronized void receive(DatagramPacket pack) throws IOException {
        checkOpen();
        ensureBound();
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new SocketException("Pending connect failure", pendingConnectException);
        } 
        pack.setLength(pack.getCapacity());
        impl.receive(pack);
        addTaint(pack.getTaint());
        
        
        
        
            
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.118 -0400", hash_original_method = "F0676E3BCA654DF56D2BFA1EDDBDFD76", hash_generated_method = "83BB308B3ABDBF3D502E341A6F6322B7")
    public void send(DatagramPacket pack) throws IOException {
        checkOpen();
        ensureBound();
        InetAddress packAddr = pack.getAddress();
        {
            {
                {
                    boolean varEDA02A2B6453C8934EEF171F4AFFA587_1448668855 = (!address.equals(packAddr) || port != pack.getPort());
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Packet address mismatch with connected address");
                    } 
                } 
            } 
            {
                pack.setAddress(address);
                pack.setPort(port);
            } 
        } 
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Destination address is null");
            } 
        } 
        impl.send(pack);
        addTaint(pack.getTaint());
        
        
        
        
        
            
                
                    
                
            
                
                
            
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.119 -0400", hash_original_method = "3874DFBADA775207309D591B6CC4D492", hash_generated_method = "0862A67D7029789FA95C2D46CE5973B5")
    public void setNetworkInterface(NetworkInterface netInterface) throws SocketException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("networkInterface == null");
        } 
        try 
        {
            Libcore.os.setsockoptIfreq(impl.fd, SOL_SOCKET, SO_BINDTODEVICE, netInterface.getName());
        } 
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsSocketException();
        } 
        addTaint(netInterface.getTaint());
        
        
            
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.119 -0400", hash_original_method = "6C822EF02E72BD5A5151B1066B41A106", hash_generated_method = "5FE67F7C8208D693EA57EFC59B76B37B")
    public synchronized void setSendBufferSize(int size) throws SocketException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size < 1");
        } 
        checkOpen();
        impl.setOption(SocketOptions.SO_SNDBUF, Integer.valueOf(size));
        addTaint(size);
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.120 -0400", hash_original_method = "568C48DC36A6A663E7303E35F30B9F65", hash_generated_method = "9900591CC9CEC4006B8310239A68DDF1")
    public synchronized void setReceiveBufferSize(int size) throws SocketException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size < 1");
        } 
        checkOpen();
        impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
        addTaint(size);
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.120 -0400", hash_original_method = "FEB39AD74968ADEBB5E7B7804953C3DE", hash_generated_method = "AC1045341F4D6EB4AD69331C48861D97")
    public synchronized void setSoTimeout(int timeout) throws SocketException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("timeout < 0");
        } 
        checkOpen();
        impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(timeout));
        addTaint(timeout);
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static synchronized void setDatagramSocketImplFactory(DatagramSocketImplFactory fac) throws IOException {
        if (factory != null) {
            throw new SocketException("Factory already set");
        }
        factory = fac;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.120 -0400", hash_original_method = "8DC54C39C6445BAF3181407C830C5887", hash_generated_method = "070449B35EF87E14207A4D885E8197A8")
     void checkOpen() throws SocketException {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_1924665524 = (isClosed());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket is closed");
            } 
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.121 -0400", hash_original_method = "1B212BFD5D3AE863EDBC7C1325928232", hash_generated_method = "EF26F52B1052289D873A4893313FD40E")
    private void ensureBound() throws SocketException {
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_1753152129 = (!isBound());
            {
                impl.bind(0, Inet4Address.ANY);
                isBound = true;
            } 
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.121 -0400", hash_original_method = "3D56D66452A7B2D7ED073824CEA46ED8", hash_generated_method = "AB14603FF79D278A26B236D6B89D875C")
    public void bind(SocketAddress localAddr) throws SocketException {
        checkOpen();
        int localPort = 0;
        InetAddress addr = Inet4Address.ANY;
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Local address not an InetSocketAddress: " +
                        localAddr.getClass());
            } 
            InetSocketAddress inetAddr = (InetSocketAddress) localAddr;
            addr = inetAddr.getAddress();
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Host is unresolved: " + inetAddr.getHostName());
            } 
            localPort = inetAddr.getPort();
            checkPort(localPort);
        } 
        impl.bind(localPort, addr);
        isBound = true;
        addTaint(localAddr.getTaint());
        
        
        
        
        
            
                
                        
            
            
            
            
                
            
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.122 -0400", hash_original_method = "3DB10BF2A6A48B73F2119F41843D9D33", hash_generated_method = "62FA5FD96CCE05E350D0DB4371690C15")
    public void connect(SocketAddress peer) throws SocketException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("peer == null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("peer not an InetSocketAddress: " + peer.getClass());
        } 
        InetSocketAddress isa = (InetSocketAddress) peer;
        {
            boolean var94908F4406976F47F480E81F35A6256E_70778380 = (isa.getAddress() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Host is unresolved: " + isa.getHostName());
            } 
        } 
        {
            checkOpen();
            ensureBound();
            this.address = isa.getAddress();
            this.port = isa.getPort();
            this.isConnected = true;
            impl.connect(address, port);
        } 
        addTaint(peer.getTaint());
        
        
            
        
        
            
        
        
        
            
        
        
            
            
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.122 -0400", hash_original_method = "9E27C6FD502F0359DB781EB2FF7E2BA4", hash_generated_method = "362FB567212D2CAF036DCCD9867C06A7")
    public void connect(InetAddress address, int port) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("address == null");
        } 
        try 
        {
            connect(new InetSocketAddress(address, port));
        } 
        catch (SocketException connectException)
        {
            pendingConnectException = connectException;
        } 
        addTaint(address.getTaint());
        addTaint(port);
        
        
            
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.122 -0400", hash_original_method = "589AFDD4CA6BF38ABB5F59E26BB3DC6D", hash_generated_method = "502D353DED2CD72F8C3537323E0DFB32")
    public boolean isBound() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1854796872 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1854796872;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.123 -0400", hash_original_method = "B1255CDE181FFAAB8CB434FB98B99FFF", hash_generated_method = "029230CF8E31DC63261B88E70D5FAD90")
    public boolean isConnected() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1423223560 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1423223560;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.123 -0400", hash_original_method = "7C698472BF26D61A7917F4B5238C5FF7", hash_generated_method = "5C2AD173005B9FA4E29631F80B517BBE")
    public SocketAddress getRemoteSocketAddress() {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_302294386 = null; 
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_412901676 = null; 
        {
            boolean var341AB6969DFD2927CA563855F9EEB77E_1809244459 = (!isConnected());
            {
                varB4EAC82CA7396A68D541C85D26508E83_302294386 = null;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_412901676 = new InetSocketAddress(getInetAddress(), getPort());
        SocketAddress varA7E53CE21691AB073D9660D615818899_182965772; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_182965772 = varB4EAC82CA7396A68D541C85D26508E83_302294386;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_182965772 = varB4EAC82CA7396A68D541C85D26508E83_412901676;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_182965772.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_182965772;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.124 -0400", hash_original_method = "AE126A441E32CF7358FEDD7A95BAD391", hash_generated_method = "797FBB1D17F5C56D7A8331917D19C139")
    public SocketAddress getLocalSocketAddress() {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_1816907973 = null; 
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_679196391 = null; 
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_64871853 = (!isBound());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1816907973 = null;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_679196391 = new InetSocketAddress(getLocalAddress(), getLocalPort());
        SocketAddress varA7E53CE21691AB073D9660D615818899_385297742; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_385297742 = varB4EAC82CA7396A68D541C85D26508E83_1816907973;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_385297742 = varB4EAC82CA7396A68D541C85D26508E83_679196391;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_385297742.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_385297742;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.125 -0400", hash_original_method = "D6CD69E67882E49578E557811A0FC457", hash_generated_method = "FC3E7A197DB1A0060F368E39CFC6FAA6")
    public void setReuseAddress(boolean reuse) throws SocketException {
        checkOpen();
        impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
        addTaint(reuse);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.126 -0400", hash_original_method = "8920D58954E3583481E89192EF874E86", hash_generated_method = "61B79BBFFD0645AA33A9B87EECBEEA7B")
    public boolean getReuseAddress() throws SocketException {
        checkOpen();
        boolean var92F4A5EAF76459C680E3D19F2BDB3A81_521904773 = (((Boolean) impl.getOption(SocketOptions.SO_REUSEADDR)).booleanValue());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_340684954 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_340684954;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.126 -0400", hash_original_method = "16BACAE92585B22CC8D47D482CFB74B4", hash_generated_method = "DE15DC4331E8FC145CA658D95B0AEE0C")
    public void setBroadcast(boolean broadcast) throws SocketException {
        checkOpen();
        impl.setOption(SocketOptions.SO_BROADCAST, Boolean.valueOf(broadcast));
        addTaint(broadcast);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.127 -0400", hash_original_method = "2CF01D838FE277D7A2E75EEBFE7DA27F", hash_generated_method = "21C07BA035151BEC2F194237FAFA0BD0")
    public boolean getBroadcast() throws SocketException {
        checkOpen();
        boolean var9ED914C1E7DCBED1C7993433295C6E96_2109136601 = (((Boolean) impl.getOption(SocketOptions.SO_BROADCAST)).booleanValue());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_460628985 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_460628985;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.127 -0400", hash_original_method = "2EC80086B0B75FB75EFBAAF12E210751", hash_generated_method = "A6CFFAADE55D1BEE691332236D1AB510")
    public void setTrafficClass(int value) throws SocketException {
        checkOpen();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        impl.setOption(SocketOptions.IP_TOS, Integer.valueOf(value));
        addTaint(value);
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.128 -0400", hash_original_method = "2A65749565A2F95D7C49F3E7C9DCBDEC", hash_generated_method = "39CE63BBB18787E995449CDAF7FD8671")
    public int getTrafficClass() throws SocketException {
        checkOpen();
        int var9C2568077066805EC4361C5C54BBCF61_1687551679 = ((Integer) impl.getOption(SocketOptions.IP_TOS));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_400300800 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_400300800;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.128 -0400", hash_original_method = "2EEDDDEB8BA1CD500E3647BC397BF54F", hash_generated_method = "FA72D3FA22B73472D2CF4C3F7DAB5701")
    public boolean isClosed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_138107484 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_138107484;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.129 -0400", hash_original_method = "4DA7A00C8A23C7197F09A02190FE9E45", hash_generated_method = "1C79FEA4F59644AA179C11ADC6D3198C")
    public DatagramChannel getChannel() {
        DatagramChannel varB4EAC82CA7396A68D541C85D26508E83_1285690631 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1285690631 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1285690631.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1285690631;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.129 -0400", hash_original_method = "90C19CEBA6BBC20B430C1F399D6443A6", hash_generated_method = "06881DB75AD824ABEDDDA564B81A2676")
    public final FileDescriptor getFileDescriptor$() {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1481019744 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1481019744 = impl.fd;
        varB4EAC82CA7396A68D541C85D26508E83_1481019744.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1481019744;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.129 -0400", hash_original_field = "9549DD6065D019211460C59A86DD6536", hash_generated_field = "E43EB19BC3390384071AA64E51712EB7")

    static DatagramSocketImplFactory factory;
}

