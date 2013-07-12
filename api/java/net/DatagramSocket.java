package java.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.DatagramChannel;
import libcore.io.ErrnoException;
import libcore.io.Libcore;
import static libcore.io.OsConstants.*;

public class DatagramSocket {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.561 -0400", hash_original_field = "86CCEC3D9FF0E9C0514506E982CDC08B", hash_generated_field = "0E47AFFF5CC1F2155F99BECA6A70C2D2")

    DatagramSocketImpl impl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.561 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "FDCE7272CFC91A6374FBF7F54D5CC8E4")

    InetAddress address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.561 -0400", hash_original_field = "CAB9CCA4AFFBFB7ECB540E3002763641", hash_generated_field = "BAF684EECB20D799A434AFCF1B13F01D")

    int port = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.561 -0400", hash_original_field = "1EA05BED8F3F3741889B40C4407A936D", hash_generated_field = "F9AB7682F64A4F93F6F4A7A435A5AA53")

    boolean isBound = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.562 -0400", hash_original_field = "F0F0EDCF28D811EA172AA0A0A89A5056", hash_generated_field = "058DE1E699A3B3D187FC9E15DB7EC3B5")

    private boolean isConnected = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.562 -0400", hash_original_field = "07C7CAC105556325A010A5AA708B362E", hash_generated_field = "BBB4D111812AF32431191097BEE30ACB")

    private SocketException pendingConnectException;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.562 -0400", hash_original_field = "7624DFAF468575D3B7DCE21DA2796711", hash_generated_field = "2CBEAC942D14DA48C324142BCB214C18")

    private boolean isClosed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.562 -0400", hash_original_field = "DD465B0839A70592931A97D99A9DB042", hash_generated_field = "B291AA80E80AF2EADD13F4FAD6374324")

    private Object lock = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.562 -0400", hash_original_method = "600D2DC769AA1337C3E52515B77C9BA6", hash_generated_method = "834126E5D9F38C7E6D68D7A94139CCD5")
    public  DatagramSocket() throws SocketException {
        this(0);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.563 -0400", hash_original_method = "5C9F869A9F8E783507AEDF83BF8CB0B7", hash_generated_method = "A56421B17935075E2630669E154EDB6C")
    public  DatagramSocket(int aPort) throws SocketException {
        addTaint(aPort);
        checkPort(aPort);
        createSocket(aPort, Inet4Address.ANY);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.563 -0400", hash_original_method = "CB0AFEB195CAFC978B9076AC8691C2BF", hash_generated_method = "72852EB2165E30DA4284374F7CB66F9B")
    public  DatagramSocket(int aPort, InetAddress addr) throws SocketException {
        addTaint(addr.getTaint());
        addTaint(aPort);
        checkPort(aPort);
        createSocket(aPort, (addr == null) ? Inet4Address.ANY : addr);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.564 -0400", hash_original_method = "8791E60C190AA1CE5F0CD19BC0C9D10B", hash_generated_method = "608A181B3FCA20E56C0C7236D38160BC")
    protected  DatagramSocket(DatagramSocketImpl socketImpl) {
    if(socketImpl == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_953690480 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_953690480.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_953690480;
        } 
        impl = socketImpl;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.564 -0400", hash_original_method = "F9D705BC16951CA970DD006A85C9F283", hash_generated_method = "ED457D8D2817038B3370639F2EBD1C5B")
    public  DatagramSocket(SocketAddress localAddr) throws SocketException {
        addTaint(localAddr.getTaint());
    if(localAddr != null)        
        {
    if(!(localAddr instanceof InetSocketAddress))            
            {
                IllegalArgumentException varC26B139CE5269510432F181AB5FE9596_1635095137 = new IllegalArgumentException("Local address not an InetSocketAddress: " +
                        localAddr.getClass());
                varC26B139CE5269510432F181AB5FE9596_1635095137.addTaint(taint);
                throw varC26B139CE5269510432F181AB5FE9596_1635095137;
            } 
            checkPort(((InetSocketAddress) localAddr).getPort());
        } 
        impl = factory != null ? factory.createDatagramSocketImpl()
                : new PlainDatagramSocketImpl();
        impl.create();
    if(localAddr != null)        
        {
            try 
            {
                bind(localAddr);
            } 
            catch (SocketException e)
            {
                close();
                e.addTaint(taint);
                throw e;
            } 
        } 
        setBroadcast(true);
        
        
            
                
                        
            
            
        
        
                
        
        
            
                
            
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.565 -0400", hash_original_method = "70ACB9C2984CE075C85AFFAB4CC3F2C3", hash_generated_method = "64B1213070A9E3006768F5A96E2A11FB")
    private void checkPort(int aPort) {
        addTaint(aPort);
    if(aPort < 0 || aPort > 65535)        
        {
            IllegalArgumentException varBD3B2D468FFD082696C46A032ABFAA1F_1032058830 = new IllegalArgumentException("Port out of range: " + aPort);
            varBD3B2D468FFD082696C46A032ABFAA1F_1032058830.addTaint(taint);
            throw varBD3B2D468FFD082696C46A032ABFAA1F_1032058830;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.565 -0400", hash_original_method = "613628CBB35065AE6B36DA8B5C0D3152", hash_generated_method = "CEB5A5E4301107E97D1EEC22C66FA42C")
    public void close() {
        isClosed = true;
        impl.close();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.566 -0400", hash_original_method = "53DC6FE247829A3F8E1E61F886EC8A69", hash_generated_method = "2A54A4B6AD6CC335DAF907B77596B4C6")
    public void disconnect() {
    if(isClosed() || !isConnected())        
        {
            return;
        } 
        impl.disconnect();
        address = null;
        port = -1;
        isConnected = false;
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.567 -0400", hash_original_method = "CDBEDFAF0027896E1E3D56B522D080D1", hash_generated_method = "7EF1284502115D5CDF7EFF0127052EE8")
    synchronized void createSocket(int aPort, InetAddress addr) throws SocketException {
        addTaint(addr.getTaint());
        addTaint(aPort);
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
            e.addTaint(taint);
            throw e;
        } 
        
        
                
        
        
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.567 -0400", hash_original_method = "9059089CB1C35AC3C53D636B58746A1E", hash_generated_method = "5DA1E73348B3C83DD7287C4CF5BC0BA9")
    public InetAddress getInetAddress() {
InetAddress var814577DDD37BAFB17E08CBEFDB411BAE_1175862985 =         address;
        var814577DDD37BAFB17E08CBEFDB411BAE_1175862985.addTaint(taint);
        return var814577DDD37BAFB17E08CBEFDB411BAE_1175862985;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.568 -0400", hash_original_method = "120EDBD12BFFA2CD78689E1CCCEFC0A6", hash_generated_method = "026D5D4AD9320AF5DC5A7BC946F4C69D")
    public InetAddress getLocalAddress() {
    if(isClosed())        
        {
InetAddress var540C13E9E156B687226421B24F2DF178_43652282 =             null;
            var540C13E9E156B687226421B24F2DF178_43652282.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_43652282;
        } 
    if(!isBound())        
        {
InetAddress var160D7036E6F25C22E9DA4C92DCFE57EF_852147959 =             Inet4Address.ANY;
            var160D7036E6F25C22E9DA4C92DCFE57EF_852147959.addTaint(taint);
            return var160D7036E6F25C22E9DA4C92DCFE57EF_852147959;
        } 
InetAddress var55E28B9EA17D108D0EBB47134171DC93_1994043261 =         impl.getLocalAddress();
        var55E28B9EA17D108D0EBB47134171DC93_1994043261.addTaint(taint);
        return var55E28B9EA17D108D0EBB47134171DC93_1994043261;
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.568 -0400", hash_original_method = "C20A7438B6018D8C8B6C316459831E1B", hash_generated_method = "2B058F7AC53562D782E7C5A10A4C171E")
    public int getLocalPort() {
    if(isClosed())        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_431475315 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2035339569 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2035339569;
        } 
    if(!isBound())        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_378147498 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1692282462 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1692282462;
        } 
        int var141B5401A04AE23DB4012052769AA414_938738651 = (impl.getLocalPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1505169734 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1505169734;
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.569 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "1AF5001FF23DD9E7E2DF993FF7187953")
    public int getPort() {
        int var901555FB06E346CB065CEB9808DCFC25_714980951 = (port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_465441020 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_465441020;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.569 -0400", hash_original_method = "4991C56903C24C085B034589D2617CA7", hash_generated_method = "4A28F51EE6F38727CB9C5BD8056DC4BE")
     boolean isMulticastSocket() {
        boolean var68934A3E9455FA72420237EB05902327_64654220 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1392168389 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1392168389;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.570 -0400", hash_original_method = "1025A74ACDCA065D38BE1D18813D43DB", hash_generated_method = "37344F0233177855CC339D1B9C363CF3")
    public synchronized int getReceiveBufferSize() throws SocketException {
        checkOpen();
        int varE81451D5C828E046B43EDC22DB07479E_2041216634 = (((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_126719935 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_126719935;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.570 -0400", hash_original_method = "D220B9D2C157A98A9F2FC338F369BDAA", hash_generated_method = "99B33EDAEFA07E3253191BA2C3805D52")
    public synchronized int getSendBufferSize() throws SocketException {
        checkOpen();
        int var30D2E319E9C2929AD28B20E6E58446D9_1443311346 = (((Integer) impl.getOption(SocketOptions.SO_SNDBUF)).intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_108165855 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_108165855;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.570 -0400", hash_original_method = "E87267C7B03A68795BE159270DE33B7D", hash_generated_method = "414C22106F1D5BAFD96896699B3FF969")
    public synchronized int getSoTimeout() throws SocketException {
        checkOpen();
        int varD9ED706581E59D8A02AABC09446C91B3_1521406705 = (((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_543211817 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_543211817;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.571 -0400", hash_original_method = "C2244B28A3A8977EAD72461E3F35998B", hash_generated_method = "826670C380FDA32D5C164803AEEF1A25")
    public synchronized void receive(DatagramPacket pack) throws IOException {
        addTaint(pack.getTaint());
        checkOpen();
        ensureBound();
    if(pack == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_92491056 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_92491056.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_92491056;
        } 
    if(pendingConnectException != null)        
        {
            SocketException varB1BB7E004655EB0C0C04A842A6C33F35_1684312459 = new SocketException("Pending connect failure", pendingConnectException);
            varB1BB7E004655EB0C0C04A842A6C33F35_1684312459.addTaint(taint);
            throw varB1BB7E004655EB0C0C04A842A6C33F35_1684312459;
        } 
        pack.setLength(pack.getCapacity());
        impl.receive(pack);
        
        
        
        
            
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.572 -0400", hash_original_method = "F0676E3BCA654DF56D2BFA1EDDBDFD76", hash_generated_method = "AF3F6CCD547F087E5C463662ACE8BD91")
    public void send(DatagramPacket pack) throws IOException {
        addTaint(pack.getTaint());
        checkOpen();
        ensureBound();
        InetAddress packAddr = pack.getAddress();
    if(address != null)        
        {
    if(packAddr != null)            
            {
    if(!address.equals(packAddr) || port != pack.getPort())                
                {
                    IllegalArgumentException var7EB419C25158EBE15F047183830C1EFC_870359358 = new IllegalArgumentException("Packet address mismatch with connected address");
                    var7EB419C25158EBE15F047183830C1EFC_870359358.addTaint(taint);
                    throw var7EB419C25158EBE15F047183830C1EFC_870359358;
                } 
            } 
            else
            {
                pack.setAddress(address);
                pack.setPort(port);
            } 
        } 
        else
        {
    if(packAddr == null)            
            {
                NullPointerException var45653EF25EE326504CB0A60A0E4D78D6_593062647 = new NullPointerException("Destination address is null");
                var45653EF25EE326504CB0A60A0E4D78D6_593062647.addTaint(taint);
                throw var45653EF25EE326504CB0A60A0E4D78D6_593062647;
            } 
        } 
        impl.send(pack);
        
        
        
        
        
            
                
                    
                
            
                
                
            
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.578 -0400", hash_original_method = "3874DFBADA775207309D591B6CC4D492", hash_generated_method = "1A5E505C1B71523020553BBA5D0998B1")
    public void setNetworkInterface(NetworkInterface netInterface) throws SocketException {
        addTaint(netInterface.getTaint());
    if(netInterface == null)        
        {
            NullPointerException varAF2C3524B834479E4E22F237838485DE_2087176911 = new NullPointerException("networkInterface == null");
            varAF2C3524B834479E4E22F237838485DE_2087176911.addTaint(taint);
            throw varAF2C3524B834479E4E22F237838485DE_2087176911;
        } 
        try 
        {
            Libcore.os.setsockoptIfreq(impl.fd, SOL_SOCKET, SO_BINDTODEVICE, netInterface.getName());
        } 
        catch (ErrnoException errnoException)
        {
            java.net.SocketException var01308AFBB38F93C29B87C84FA2A5ED65_732030613 = errnoException.rethrowAsSocketException();
            var01308AFBB38F93C29B87C84FA2A5ED65_732030613.addTaint(taint);
            throw var01308AFBB38F93C29B87C84FA2A5ED65_732030613;
        } 
        
        
            
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.579 -0400", hash_original_method = "6C822EF02E72BD5A5151B1066B41A106", hash_generated_method = "31DA682F57209732B917FA6A5A8D287A")
    public synchronized void setSendBufferSize(int size) throws SocketException {
        addTaint(size);
    if(size < 1)        
        {
            IllegalArgumentException varE382BBE48942C4B3FA87CFD84F21DF8E_608769990 = new IllegalArgumentException("size < 1");
            varE382BBE48942C4B3FA87CFD84F21DF8E_608769990.addTaint(taint);
            throw varE382BBE48942C4B3FA87CFD84F21DF8E_608769990;
        } 
        checkOpen();
        impl.setOption(SocketOptions.SO_SNDBUF, Integer.valueOf(size));
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.579 -0400", hash_original_method = "568C48DC36A6A663E7303E35F30B9F65", hash_generated_method = "B64442CF5F944296864A131F8340BBB5")
    public synchronized void setReceiveBufferSize(int size) throws SocketException {
        addTaint(size);
    if(size < 1)        
        {
            IllegalArgumentException varE382BBE48942C4B3FA87CFD84F21DF8E_1114639056 = new IllegalArgumentException("size < 1");
            varE382BBE48942C4B3FA87CFD84F21DF8E_1114639056.addTaint(taint);
            throw varE382BBE48942C4B3FA87CFD84F21DF8E_1114639056;
        } 
        checkOpen();
        impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.580 -0400", hash_original_method = "FEB39AD74968ADEBB5E7B7804953C3DE", hash_generated_method = "7899442B25D884E2314C99C5EAA09BA2")
    public synchronized void setSoTimeout(int timeout) throws SocketException {
        addTaint(timeout);
    if(timeout < 0)        
        {
            IllegalArgumentException varBA4E54C08633B7FB6474427FE4B69BA6_1121922819 = new IllegalArgumentException("timeout < 0");
            varBA4E54C08633B7FB6474427FE4B69BA6_1121922819.addTaint(taint);
            throw varBA4E54C08633B7FB6474427FE4B69BA6_1121922819;
        } 
        checkOpen();
        impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(timeout));
        
        
            
        
        
        
    }

    
        public static synchronized void setDatagramSocketImplFactory(DatagramSocketImplFactory fac) throws IOException {
        if (factory != null) {
            throw new SocketException("Factory already set");
        }
        factory = fac;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.581 -0400", hash_original_method = "8DC54C39C6445BAF3181407C830C5887", hash_generated_method = "13BE0599A7ECB7729685E8CF2864C8D8")
     void checkOpen() throws SocketException {
    if(isClosed())        
        {
            SocketException var5AD72407DD9337ABED4666C49A30EC41_628853692 = new SocketException("Socket is closed");
            var5AD72407DD9337ABED4666C49A30EC41_628853692.addTaint(taint);
            throw var5AD72407DD9337ABED4666C49A30EC41_628853692;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.581 -0400", hash_original_method = "1B212BFD5D3AE863EDBC7C1325928232", hash_generated_method = "063325BC5A9F022E91A3EC84CD5D09EE")
    private void ensureBound() throws SocketException {
    if(!isBound())        
        {
            impl.bind(0, Inet4Address.ANY);
            isBound = true;
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.582 -0400", hash_original_method = "3D56D66452A7B2D7ED073824CEA46ED8", hash_generated_method = "18817F41C31F89645CD7FB5E0A0A6C05")
    public void bind(SocketAddress localAddr) throws SocketException {
        addTaint(localAddr.getTaint());
        checkOpen();
        int localPort = 0;
        InetAddress addr = Inet4Address.ANY;
    if(localAddr != null)        
        {
    if(!(localAddr instanceof InetSocketAddress))            
            {
                IllegalArgumentException varC26B139CE5269510432F181AB5FE9596_1844564662 = new IllegalArgumentException("Local address not an InetSocketAddress: " +
                        localAddr.getClass());
                varC26B139CE5269510432F181AB5FE9596_1844564662.addTaint(taint);
                throw varC26B139CE5269510432F181AB5FE9596_1844564662;
            } 
            InetSocketAddress inetAddr = (InetSocketAddress) localAddr;
            addr = inetAddr.getAddress();
    if(addr == null)            
            {
                SocketException var815C915B1B299CF5E8808EFB2314BEE5_726761480 = new SocketException("Host is unresolved: " + inetAddr.getHostName());
                var815C915B1B299CF5E8808EFB2314BEE5_726761480.addTaint(taint);
                throw var815C915B1B299CF5E8808EFB2314BEE5_726761480;
            } 
            localPort = inetAddr.getPort();
            checkPort(localPort);
        } 
        impl.bind(localPort, addr);
        isBound = true;
        
        
        
        
        
            
                
                        
            
            
            
            
                
            
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.583 -0400", hash_original_method = "3DB10BF2A6A48B73F2119F41843D9D33", hash_generated_method = "241BEAC67E52883EA34955E6406BBD74")
    public void connect(SocketAddress peer) throws SocketException {
        addTaint(peer.getTaint());
    if(peer == null)        
        {
            IllegalArgumentException var9F5934E24575FF787ECA296EFE437398_570805683 = new IllegalArgumentException("peer == null");
            var9F5934E24575FF787ECA296EFE437398_570805683.addTaint(taint);
            throw var9F5934E24575FF787ECA296EFE437398_570805683;
        } 
    if(!(peer instanceof InetSocketAddress))        
        {
            IllegalArgumentException varE9CCA80D8D91180719BA3618D4D9B763_482135677 = new IllegalArgumentException("peer not an InetSocketAddress: " + peer.getClass());
            varE9CCA80D8D91180719BA3618D4D9B763_482135677.addTaint(taint);
            throw varE9CCA80D8D91180719BA3618D4D9B763_482135677;
        } 
        InetSocketAddress isa = (InetSocketAddress) peer;
    if(isa.getAddress() == null)        
        {
            SocketException varE8A11D462907C6DEF5226026056C0870_748053912 = new SocketException("Host is unresolved: " + isa.getHostName());
            varE8A11D462907C6DEF5226026056C0870_748053912.addTaint(taint);
            throw varE8A11D462907C6DEF5226026056C0870_748053912;
        } 
        synchronized
(lock)        {
            checkOpen();
            ensureBound();
            this.address = isa.getAddress();
            this.port = isa.getPort();
            this.isConnected = true;
            impl.connect(address, port);
        } 
        
        
            
        
        
            
        
        
        
            
        
        
            
            
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.584 -0400", hash_original_method = "9E27C6FD502F0359DB781EB2FF7E2BA4", hash_generated_method = "431694B8D5E1753D0C6F73BD23B95863")
    public void connect(InetAddress address, int port) {
        addTaint(port);
        addTaint(address.getTaint());
    if(address == null)        
        {
            IllegalArgumentException var97E1753900078CCFFFE3026FDB988F71_1157722373 = new IllegalArgumentException("address == null");
            var97E1753900078CCFFFE3026FDB988F71_1157722373.addTaint(taint);
            throw var97E1753900078CCFFFE3026FDB988F71_1157722373;
        } 
        try 
        {
            connect(new InetSocketAddress(address, port));
        } 
        catch (SocketException connectException)
        {
            pendingConnectException = connectException;
        } 
        
        
            
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.585 -0400", hash_original_method = "589AFDD4CA6BF38ABB5F59E26BB3DC6D", hash_generated_method = "6919F3B2559432522C20D0EBFB2E55BE")
    public boolean isBound() {
        boolean var8E4D35088206920061AAF7F347854388_85447776 = (isBound);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_510939513 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_510939513;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.585 -0400", hash_original_method = "B1255CDE181FFAAB8CB434FB98B99FFF", hash_generated_method = "BFA889AD2940D1B1312E2F79A5E5DBC9")
    public boolean isConnected() {
        boolean var8CADFAB0F66545464EF713B1AEC0C7DD_821174764 = (isConnected);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1780108770 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1780108770;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.586 -0400", hash_original_method = "7C698472BF26D61A7917F4B5238C5FF7", hash_generated_method = "B59BFA2D7075853D2AD0DD840708FBF2")
    public SocketAddress getRemoteSocketAddress() {
    if(!isConnected())        
        {
SocketAddress var540C13E9E156B687226421B24F2DF178_1699109105 =             null;
            var540C13E9E156B687226421B24F2DF178_1699109105.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1699109105;
        } 
SocketAddress var45C38FDA41326B49D763EA0783025015_1796559311 =         new InetSocketAddress(getInetAddress(), getPort());
        var45C38FDA41326B49D763EA0783025015_1796559311.addTaint(taint);
        return var45C38FDA41326B49D763EA0783025015_1796559311;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.586 -0400", hash_original_method = "AE126A441E32CF7358FEDD7A95BAD391", hash_generated_method = "AF26D29B78F926F6ED1A928FD30E1BE7")
    public SocketAddress getLocalSocketAddress() {
    if(!isBound())        
        {
SocketAddress var540C13E9E156B687226421B24F2DF178_464803866 =             null;
            var540C13E9E156B687226421B24F2DF178_464803866.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_464803866;
        } 
SocketAddress varEBCBCBDD65488C840B5324120D3690AE_145154485 =         new InetSocketAddress(getLocalAddress(), getLocalPort());
        varEBCBCBDD65488C840B5324120D3690AE_145154485.addTaint(taint);
        return varEBCBCBDD65488C840B5324120D3690AE_145154485;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.586 -0400", hash_original_method = "D6CD69E67882E49578E557811A0FC457", hash_generated_method = "EB45E1C9E38CA5AD9C7AF6489F52E899")
    public void setReuseAddress(boolean reuse) throws SocketException {
        addTaint(reuse);
        checkOpen();
        impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.587 -0400", hash_original_method = "8920D58954E3583481E89192EF874E86", hash_generated_method = "6BD8D092E548FD97324D660B19CA5F6B")
    public boolean getReuseAddress() throws SocketException {
        checkOpen();
        boolean var5F25B35A5AB65D3270A0F9B4238F8C8D_1267676959 = (((Boolean) impl.getOption(SocketOptions.SO_REUSEADDR)).booleanValue());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1209634337 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1209634337;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.587 -0400", hash_original_method = "16BACAE92585B22CC8D47D482CFB74B4", hash_generated_method = "09AEA3D486FDBEBF3556DF4BA6569999")
    public void setBroadcast(boolean broadcast) throws SocketException {
        addTaint(broadcast);
        checkOpen();
        impl.setOption(SocketOptions.SO_BROADCAST, Boolean.valueOf(broadcast));
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.588 -0400", hash_original_method = "2CF01D838FE277D7A2E75EEBFE7DA27F", hash_generated_method = "13B9A295B4EAAAD5C56CE34CE27AEC4A")
    public boolean getBroadcast() throws SocketException {
        checkOpen();
        boolean var97CED1D4C57C42B4E25AA2B3B70C1417_1519584677 = (((Boolean) impl.getOption(SocketOptions.SO_BROADCAST)).booleanValue());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1354362797 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1354362797;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.588 -0400", hash_original_method = "2EC80086B0B75FB75EFBAAF12E210751", hash_generated_method = "40B655319E29DCECE8C370D202F0C447")
    public void setTrafficClass(int value) throws SocketException {
        addTaint(value);
        checkOpen();
    if(value < 0 || value > 255)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1133213738 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1133213738.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1133213738;
        } 
        impl.setOption(SocketOptions.IP_TOS, Integer.valueOf(value));
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.588 -0400", hash_original_method = "2A65749565A2F95D7C49F3E7C9DCBDEC", hash_generated_method = "13A50A8608703611F1DE21065EE825B6")
    public int getTrafficClass() throws SocketException {
        checkOpen();
        int varB7446D545DBE11135A3678EF4F7ECC87_839397197 = ((Integer) impl.getOption(SocketOptions.IP_TOS));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1593942633 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1593942633;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.589 -0400", hash_original_method = "2EEDDDEB8BA1CD500E3647BC397BF54F", hash_generated_method = "1B9C9F1AA270D160155609ADC5184792")
    public boolean isClosed() {
        boolean var7587750400D3C39AEAD7C1489F6FE7F3_2081291251 = (isClosed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1070960176 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1070960176;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.589 -0400", hash_original_method = "4DA7A00C8A23C7197F09A02190FE9E45", hash_generated_method = "18CC6F07A664A02C82E545463377EB11")
    public DatagramChannel getChannel() {
DatagramChannel var540C13E9E156B687226421B24F2DF178_1190018184 =         null;
        var540C13E9E156B687226421B24F2DF178_1190018184.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1190018184;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.590 -0400", hash_original_method = "90C19CEBA6BBC20B430C1F399D6443A6", hash_generated_method = "A035C925804A8A0E803DF9142F915D27")
    public final FileDescriptor getFileDescriptor$() {
FileDescriptor var90D0CD7641DADE7AC7C643EE2F281FD7_1920942475 =         impl.fd;
        var90D0CD7641DADE7AC7C643EE2F281FD7_1920942475.addTaint(taint);
        return var90D0CD7641DADE7AC7C643EE2F281FD7_1920942475;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.590 -0400", hash_original_field = "9549DD6065D019211460C59A86DD6536", hash_generated_field = "E43EB19BC3390384071AA64E51712EB7")

    static DatagramSocketImplFactory factory;
}

