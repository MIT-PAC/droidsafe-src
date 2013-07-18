package java.net;

// Droidsafe Imports
import static libcore.io.OsConstants.SOL_SOCKET;
import static libcore.io.OsConstants.SO_BINDTODEVICE;

import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.DatagramChannel;

import libcore.io.ErrnoException;
import libcore.io.Libcore;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class DatagramSocket {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.404 -0400", hash_original_field = "86CCEC3D9FF0E9C0514506E982CDC08B", hash_generated_field = "0E47AFFF5CC1F2155F99BECA6A70C2D2")

    DatagramSocketImpl impl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.404 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "FDCE7272CFC91A6374FBF7F54D5CC8E4")

    InetAddress address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.404 -0400", hash_original_field = "CAB9CCA4AFFBFB7ECB540E3002763641", hash_generated_field = "BAF684EECB20D799A434AFCF1B13F01D")

    int port = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.405 -0400", hash_original_field = "1EA05BED8F3F3741889B40C4407A936D", hash_generated_field = "F9AB7682F64A4F93F6F4A7A435A5AA53")

    boolean isBound = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.405 -0400", hash_original_field = "F0F0EDCF28D811EA172AA0A0A89A5056", hash_generated_field = "058DE1E699A3B3D187FC9E15DB7EC3B5")

    private boolean isConnected = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.405 -0400", hash_original_field = "07C7CAC105556325A010A5AA708B362E", hash_generated_field = "BBB4D111812AF32431191097BEE30ACB")

    private SocketException pendingConnectException;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.405 -0400", hash_original_field = "7624DFAF468575D3B7DCE21DA2796711", hash_generated_field = "2CBEAC942D14DA48C324142BCB214C18")

    private boolean isClosed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.405 -0400", hash_original_field = "DD465B0839A70592931A97D99A9DB042", hash_generated_field = "B291AA80E80AF2EADD13F4FAD6374324")

    private Object lock = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.405 -0400", hash_original_method = "600D2DC769AA1337C3E52515B77C9BA6", hash_generated_method = "834126E5D9F38C7E6D68D7A94139CCD5")
    public  DatagramSocket() throws SocketException {
        this(0);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.405 -0400", hash_original_method = "5C9F869A9F8E783507AEDF83BF8CB0B7", hash_generated_method = "A56421B17935075E2630669E154EDB6C")
    public  DatagramSocket(int aPort) throws SocketException {
        addTaint(aPort);
        checkPort(aPort);
        createSocket(aPort, Inet4Address.ANY);
        // ---------- Original Method ----------
        //checkPort(aPort);
        //createSocket(aPort, Inet4Address.ANY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.405 -0400", hash_original_method = "CB0AFEB195CAFC978B9076AC8691C2BF", hash_generated_method = "72852EB2165E30DA4284374F7CB66F9B")
    public  DatagramSocket(int aPort, InetAddress addr) throws SocketException {
        addTaint(addr.getTaint());
        addTaint(aPort);
        checkPort(aPort);
        createSocket(aPort, (addr == null) ? Inet4Address.ANY : addr);
        // ---------- Original Method ----------
        //checkPort(aPort);
        //createSocket(aPort, (addr == null) ? Inet4Address.ANY : addr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.406 -0400", hash_original_method = "8791E60C190AA1CE5F0CD19BC0C9D10B", hash_generated_method = "F38FEA2AA406FECE06807C38BF2660E3")
    protected  DatagramSocket(DatagramSocketImpl socketImpl) {
        if(socketImpl == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1412432058 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1412432058.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1412432058;
        } //End block
        impl = socketImpl;
        // ---------- Original Method ----------
        //if (socketImpl == null) {
            //throw new NullPointerException();
        //}
        //impl = socketImpl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.406 -0400", hash_original_method = "F9D705BC16951CA970DD006A85C9F283", hash_generated_method = "E00F8B21721B1E5E76DE9323AB6819FC")
    public  DatagramSocket(SocketAddress localAddr) throws SocketException {
        addTaint(localAddr.getTaint());
        if(localAddr != null)        
        {
            if(!(localAddr instanceof InetSocketAddress))            
            {
                IllegalArgumentException varC26B139CE5269510432F181AB5FE9596_920188364 = new IllegalArgumentException("Local address not an InetSocketAddress: " +
                        localAddr.getClass());
                varC26B139CE5269510432F181AB5FE9596_920188364.addTaint(taint);
                throw varC26B139CE5269510432F181AB5FE9596_920188364;
            } //End block
            checkPort(((InetSocketAddress) localAddr).getPort());
        } //End block
        impl = factory != null ? factory.createDatagramSocketImpl()
                : new PlainDatagramSocketImpl();
        impl.create();
        if(localAddr != null)        
        {
            try 
            {
                bind(localAddr);
            } //End block
            catch (SocketException e)
            {
                close();
                e.addTaint(taint);
                throw e;
            } //End block
        } //End block
        setBroadcast(true);
        // ---------- Original Method ----------
        //if (localAddr != null) {
            //if (!(localAddr instanceof InetSocketAddress)) {
                //throw new IllegalArgumentException("Local address not an InetSocketAddress: " +
                        //localAddr.getClass());
            //}
            //checkPort(((InetSocketAddress) localAddr).getPort());
        //}
        //impl = factory != null ? factory.createDatagramSocketImpl()
                //: new PlainDatagramSocketImpl();
        //impl.create();
        //if (localAddr != null) {
            //try {
                //bind(localAddr);
            //} catch (SocketException e) {
                //close();
                //throw e;
            //}
        //}
        //setBroadcast(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.407 -0400", hash_original_method = "70ACB9C2984CE075C85AFFAB4CC3F2C3", hash_generated_method = "59D2D1D291BDE3026B369DE7BD559C0C")
    private void checkPort(int aPort) {
        addTaint(aPort);
        if(aPort < 0 || aPort > 65535)        
        {
            IllegalArgumentException varBD3B2D468FFD082696C46A032ABFAA1F_1013899556 = new IllegalArgumentException("Port out of range: " + aPort);
            varBD3B2D468FFD082696C46A032ABFAA1F_1013899556.addTaint(taint);
            throw varBD3B2D468FFD082696C46A032ABFAA1F_1013899556;
        } //End block
        // ---------- Original Method ----------
        //if (aPort < 0 || aPort > 65535) {
            //throw new IllegalArgumentException("Port out of range: " + aPort);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.407 -0400", hash_original_method = "613628CBB35065AE6B36DA8B5C0D3152", hash_generated_method = "CEB5A5E4301107E97D1EEC22C66FA42C")
    public void close() {
        isClosed = true;
        impl.close();
        // ---------- Original Method ----------
        //isClosed = true;
        //impl.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.408 -0400", hash_original_method = "53DC6FE247829A3F8E1E61F886EC8A69", hash_generated_method = "2A54A4B6AD6CC335DAF907B77596B4C6")
    public void disconnect() {
        if(isClosed() || !isConnected())        
        {
            return;
        } //End block
        impl.disconnect();
        address = null;
        port = -1;
        isConnected = false;
        // ---------- Original Method ----------
        //if (isClosed() || !isConnected()) {
            //return;
        //}
        //impl.disconnect();
        //address = null;
        //port = -1;
        //isConnected = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.409 -0400", hash_original_method = "CDBEDFAF0027896E1E3D56B522D080D1", hash_generated_method = "7EF1284502115D5CDF7EFF0127052EE8")
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
        } //End block
        catch (SocketException e)
        {
            close();
            e.addTaint(taint);
            throw e;
        } //End block
        // ---------- Original Method ----------
        //impl = factory != null ? factory.createDatagramSocketImpl()
                //: new PlainDatagramSocketImpl();
        //impl.create();
        //try {
            //impl.bind(aPort, addr);
            //isBound = true;
        //} catch (SocketException e) {
            //close();
            //throw e;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.409 -0400", hash_original_method = "9059089CB1C35AC3C53D636B58746A1E", hash_generated_method = "2EFB39666C5162631C16DDBC1C6476D5")
    public InetAddress getInetAddress() {
InetAddress var814577DDD37BAFB17E08CBEFDB411BAE_834714064 =         address;
        var814577DDD37BAFB17E08CBEFDB411BAE_834714064.addTaint(taint);
        return var814577DDD37BAFB17E08CBEFDB411BAE_834714064;
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.409 -0400", hash_original_method = "120EDBD12BFFA2CD78689E1CCCEFC0A6", hash_generated_method = "D34B2F501A73FC84D729EFAF507B2200")
    public InetAddress getLocalAddress() {
        if(isClosed())        
        {
InetAddress var540C13E9E156B687226421B24F2DF178_2105925939 =             null;
            var540C13E9E156B687226421B24F2DF178_2105925939.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2105925939;
        } //End block
        if(!isBound())        
        {
InetAddress var160D7036E6F25C22E9DA4C92DCFE57EF_301353120 =             Inet4Address.ANY;
            var160D7036E6F25C22E9DA4C92DCFE57EF_301353120.addTaint(taint);
            return var160D7036E6F25C22E9DA4C92DCFE57EF_301353120;
        } //End block
InetAddress var55E28B9EA17D108D0EBB47134171DC93_1713415942 =         impl.getLocalAddress();
        var55E28B9EA17D108D0EBB47134171DC93_1713415942.addTaint(taint);
        return var55E28B9EA17D108D0EBB47134171DC93_1713415942;
        // ---------- Original Method ----------
        //if (isClosed()) {
            //return null;
        //}
        //if (!isBound()) {
            //return Inet4Address.ANY;
        //}
        //return impl.getLocalAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.410 -0400", hash_original_method = "C20A7438B6018D8C8B6C316459831E1B", hash_generated_method = "50D804E7D3E9266EB3152E2B281EBFF1")
    public int getLocalPort() {
        if(isClosed())        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_613191087 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_979150691 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_979150691;
        } //End block
        if(!isBound())        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_422358611 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_390915987 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_390915987;
        } //End block
        int var141B5401A04AE23DB4012052769AA414_857120720 = (impl.getLocalPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1319957184 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1319957184;
        // ---------- Original Method ----------
        //if (isClosed()) {
            //return -1;
        //}
        //if (!isBound()) {
            //return 0;
        //}
        //return impl.getLocalPort();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.410 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "41A0D9BFF19837557F9C42EE27319205")
    public int getPort() {
        int var901555FB06E346CB065CEB9808DCFC25_1941275590 = (port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_863602534 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_863602534;
        // ---------- Original Method ----------
        //return port;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.410 -0400", hash_original_method = "4991C56903C24C085B034589D2617CA7", hash_generated_method = "BCF7C8F67009519749AE17693EF1CE90")
     boolean isMulticastSocket() {
        boolean var68934A3E9455FA72420237EB05902327_1663802925 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_158752134 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_158752134;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.410 -0400", hash_original_method = "1025A74ACDCA065D38BE1D18813D43DB", hash_generated_method = "D2E8B1E62453D3E4E0196D0E958ABDCC")
    public synchronized int getReceiveBufferSize() throws SocketException {
        checkOpen();
        int varE81451D5C828E046B43EDC22DB07479E_1677976762 = (((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_660419458 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_660419458;
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.411 -0400", hash_original_method = "D220B9D2C157A98A9F2FC338F369BDAA", hash_generated_method = "C435669F7FCA0A32900A3E52DC8BF174")
    public synchronized int getSendBufferSize() throws SocketException {
        checkOpen();
        int var30D2E319E9C2929AD28B20E6E58446D9_1257800597 = (((Integer) impl.getOption(SocketOptions.SO_SNDBUF)).intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_522660814 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_522660814;
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Integer) impl.getOption(SocketOptions.SO_SNDBUF)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.411 -0400", hash_original_method = "E87267C7B03A68795BE159270DE33B7D", hash_generated_method = "58FFE739FD28D031ABCDB3184149D533")
    public synchronized int getSoTimeout() throws SocketException {
        checkOpen();
        int varD9ED706581E59D8A02AABC09446C91B3_1956452067 = (((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1933045780 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1933045780;
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.411 -0400", hash_original_method = "C2244B28A3A8977EAD72461E3F35998B", hash_generated_method = "26A00A29E17ED1AADFFBB78BEF3A8CB7")
    public synchronized void receive(DatagramPacket pack) throws IOException {
        addTaint(pack.getTaint());
        checkOpen();
        ensureBound();
        if(pack == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1883356942 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1883356942.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1883356942;
        } //End block
        if(pendingConnectException != null)        
        {
            SocketException varB1BB7E004655EB0C0C04A842A6C33F35_1402103917 = new SocketException("Pending connect failure", pendingConnectException);
            varB1BB7E004655EB0C0C04A842A6C33F35_1402103917.addTaint(taint);
            throw varB1BB7E004655EB0C0C04A842A6C33F35_1402103917;
        } //End block
        pack.setLength(pack.getCapacity());
        impl.receive(pack);
        // ---------- Original Method ----------
        //checkOpen();
        //ensureBound();
        //if (pack == null) {
            //throw new NullPointerException();
        //}
        //if (pendingConnectException != null) {
            //throw new SocketException("Pending connect failure", pendingConnectException);
        //}
        //pack.setLength(pack.getCapacity());
        //impl.receive(pack);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.411 -0400", hash_original_method = "F0676E3BCA654DF56D2BFA1EDDBDFD76", hash_generated_method = "E6D5F9D5E57CBC34FEE981CC574BD8DC")
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
                    IllegalArgumentException var7EB419C25158EBE15F047183830C1EFC_354335583 = new IllegalArgumentException("Packet address mismatch with connected address");
                    var7EB419C25158EBE15F047183830C1EFC_354335583.addTaint(taint);
                    throw var7EB419C25158EBE15F047183830C1EFC_354335583;
                } //End block
            } //End block
            else
            {
                pack.setAddress(address);
                pack.setPort(port);
            } //End block
        } //End block
        else
        {
            if(packAddr == null)            
            {
                NullPointerException var45653EF25EE326504CB0A60A0E4D78D6_398825953 = new NullPointerException("Destination address is null");
                var45653EF25EE326504CB0A60A0E4D78D6_398825953.addTaint(taint);
                throw var45653EF25EE326504CB0A60A0E4D78D6_398825953;
            } //End block
        } //End block
        impl.send(pack);
        // ---------- Original Method ----------
        //checkOpen();
        //ensureBound();
        //InetAddress packAddr = pack.getAddress();
        //if (address != null) { 
            //if (packAddr != null) {
                //if (!address.equals(packAddr) || port != pack.getPort()) {
                    //throw new IllegalArgumentException("Packet address mismatch with connected address");
                //}
            //} else {
                //pack.setAddress(address);
                //pack.setPort(port);
            //}
        //} else {
            //if (packAddr == null) {
                //throw new NullPointerException("Destination address is null");
            //}
        //}
        //impl.send(pack);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.418 -0400", hash_original_method = "3874DFBADA775207309D591B6CC4D492", hash_generated_method = "6CEC83495089E16C4FA7452702DF2E7A")
    public void setNetworkInterface(NetworkInterface netInterface) throws SocketException {
        addTaint(netInterface.getTaint());
        if(netInterface == null)        
        {
            NullPointerException varAF2C3524B834479E4E22F237838485DE_1917551310 = new NullPointerException("networkInterface == null");
            varAF2C3524B834479E4E22F237838485DE_1917551310.addTaint(taint);
            throw varAF2C3524B834479E4E22F237838485DE_1917551310;
        } //End block
        try 
        {
            Libcore.os.setsockoptIfreq(impl.fd, SOL_SOCKET, SO_BINDTODEVICE, netInterface.getName());
        } //End block
        catch (ErrnoException errnoException)
        {
            java.net.SocketException var01308AFBB38F93C29B87C84FA2A5ED65_250000862 = errnoException.rethrowAsSocketException();
            var01308AFBB38F93C29B87C84FA2A5ED65_250000862.addTaint(taint);
            throw var01308AFBB38F93C29B87C84FA2A5ED65_250000862;
        } //End block
        // ---------- Original Method ----------
        //if (netInterface == null) {
            //throw new NullPointerException("networkInterface == null");
        //}
        //try {
            //Libcore.os.setsockoptIfreq(impl.fd, SOL_SOCKET, SO_BINDTODEVICE, netInterface.getName());
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsSocketException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.418 -0400", hash_original_method = "6C822EF02E72BD5A5151B1066B41A106", hash_generated_method = "5BFC54E5C755556BADA49547084AF22F")
    public synchronized void setSendBufferSize(int size) throws SocketException {
        addTaint(size);
        if(size < 1)        
        {
            IllegalArgumentException varE382BBE48942C4B3FA87CFD84F21DF8E_98096670 = new IllegalArgumentException("size < 1");
            varE382BBE48942C4B3FA87CFD84F21DF8E_98096670.addTaint(taint);
            throw varE382BBE48942C4B3FA87CFD84F21DF8E_98096670;
        } //End block
        checkOpen();
        impl.setOption(SocketOptions.SO_SNDBUF, Integer.valueOf(size));
        // ---------- Original Method ----------
        //if (size < 1) {
            //throw new IllegalArgumentException("size < 1");
        //}
        //checkOpen();
        //impl.setOption(SocketOptions.SO_SNDBUF, Integer.valueOf(size));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.419 -0400", hash_original_method = "568C48DC36A6A663E7303E35F30B9F65", hash_generated_method = "C358A38094757FCB85BCE4DA6EFDE7BE")
    public synchronized void setReceiveBufferSize(int size) throws SocketException {
        addTaint(size);
        if(size < 1)        
        {
            IllegalArgumentException varE382BBE48942C4B3FA87CFD84F21DF8E_1514790305 = new IllegalArgumentException("size < 1");
            varE382BBE48942C4B3FA87CFD84F21DF8E_1514790305.addTaint(taint);
            throw varE382BBE48942C4B3FA87CFD84F21DF8E_1514790305;
        } //End block
        checkOpen();
        impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
        // ---------- Original Method ----------
        //if (size < 1) {
            //throw new IllegalArgumentException("size < 1");
        //}
        //checkOpen();
        //impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.419 -0400", hash_original_method = "FEB39AD74968ADEBB5E7B7804953C3DE", hash_generated_method = "1CACC83D237C4C4F130A42B4F4058217")
    public synchronized void setSoTimeout(int timeout) throws SocketException {
        addTaint(timeout);
        if(timeout < 0)        
        {
            IllegalArgumentException varBA4E54C08633B7FB6474427FE4B69BA6_867333293 = new IllegalArgumentException("timeout < 0");
            varBA4E54C08633B7FB6474427FE4B69BA6_867333293.addTaint(taint);
            throw varBA4E54C08633B7FB6474427FE4B69BA6_867333293;
        } //End block
        checkOpen();
        impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(timeout));
        // ---------- Original Method ----------
        //if (timeout < 0) {
            //throw new IllegalArgumentException("timeout < 0");
        //}
        //checkOpen();
        //impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(timeout));
    }

    
    public static synchronized void setDatagramSocketImplFactory(DatagramSocketImplFactory fac) throws IOException {
        if (factory != null) {
            throw new SocketException("Factory already set");
        }
        factory = fac;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.420 -0400", hash_original_method = "8DC54C39C6445BAF3181407C830C5887", hash_generated_method = "84F26E54E3084DBD1E4CFC0288D060D8")
     void checkOpen() throws SocketException {
        if(isClosed())        
        {
            SocketException var5AD72407DD9337ABED4666C49A30EC41_1059857616 = new SocketException("Socket is closed");
            var5AD72407DD9337ABED4666C49A30EC41_1059857616.addTaint(taint);
            throw var5AD72407DD9337ABED4666C49A30EC41_1059857616;
        } //End block
        // ---------- Original Method ----------
        //if (isClosed()) {
            //throw new SocketException("Socket is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.420 -0400", hash_original_method = "1B212BFD5D3AE863EDBC7C1325928232", hash_generated_method = "063325BC5A9F022E91A3EC84CD5D09EE")
    private void ensureBound() throws SocketException {
        if(!isBound())        
        {
            impl.bind(0, Inet4Address.ANY);
            isBound = true;
        } //End block
        // ---------- Original Method ----------
        //if (!isBound()) {
            //impl.bind(0, Inet4Address.ANY);
            //isBound = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.420 -0400", hash_original_method = "3D56D66452A7B2D7ED073824CEA46ED8", hash_generated_method = "2ECCADD9B2FC35AE5FD31375AF4C6D22")
    public void bind(SocketAddress localAddr) throws SocketException {
        addTaint(localAddr.getTaint());
        checkOpen();
        int localPort = 0;
        InetAddress addr = Inet4Address.ANY;
        if(localAddr != null)        
        {
            if(!(localAddr instanceof InetSocketAddress))            
            {
                IllegalArgumentException varC26B139CE5269510432F181AB5FE9596_1838185843 = new IllegalArgumentException("Local address not an InetSocketAddress: " +
                        localAddr.getClass());
                varC26B139CE5269510432F181AB5FE9596_1838185843.addTaint(taint);
                throw varC26B139CE5269510432F181AB5FE9596_1838185843;
            } //End block
            InetSocketAddress inetAddr = (InetSocketAddress) localAddr;
            addr = inetAddr.getAddress();
            if(addr == null)            
            {
                SocketException var815C915B1B299CF5E8808EFB2314BEE5_897613596 = new SocketException("Host is unresolved: " + inetAddr.getHostName());
                var815C915B1B299CF5E8808EFB2314BEE5_897613596.addTaint(taint);
                throw var815C915B1B299CF5E8808EFB2314BEE5_897613596;
            } //End block
            localPort = inetAddr.getPort();
            checkPort(localPort);
        } //End block
        impl.bind(localPort, addr);
        isBound = true;
        // ---------- Original Method ----------
        //checkOpen();
        //int localPort = 0;
        //InetAddress addr = Inet4Address.ANY;
        //if (localAddr != null) {
            //if (!(localAddr instanceof InetSocketAddress)) {
                //throw new IllegalArgumentException("Local address not an InetSocketAddress: " +
                        //localAddr.getClass());
            //}
            //InetSocketAddress inetAddr = (InetSocketAddress) localAddr;
            //addr = inetAddr.getAddress();
            //if (addr == null) {
                //throw new SocketException("Host is unresolved: " + inetAddr.getHostName());
            //}
            //localPort = inetAddr.getPort();
            //checkPort(localPort);
        //}
        //impl.bind(localPort, addr);
        //isBound = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.421 -0400", hash_original_method = "3DB10BF2A6A48B73F2119F41843D9D33", hash_generated_method = "E6568B0F19692FB0575A6A24F46CB058")
    public void connect(SocketAddress peer) throws SocketException {
        addTaint(peer.getTaint());
        if(peer == null)        
        {
            IllegalArgumentException var9F5934E24575FF787ECA296EFE437398_459522609 = new IllegalArgumentException("peer == null");
            var9F5934E24575FF787ECA296EFE437398_459522609.addTaint(taint);
            throw var9F5934E24575FF787ECA296EFE437398_459522609;
        } //End block
        if(!(peer instanceof InetSocketAddress))        
        {
            IllegalArgumentException varE9CCA80D8D91180719BA3618D4D9B763_1654471584 = new IllegalArgumentException("peer not an InetSocketAddress: " + peer.getClass());
            varE9CCA80D8D91180719BA3618D4D9B763_1654471584.addTaint(taint);
            throw varE9CCA80D8D91180719BA3618D4D9B763_1654471584;
        } //End block
        InetSocketAddress isa = (InetSocketAddress) peer;
        if(isa.getAddress() == null)        
        {
            SocketException varE8A11D462907C6DEF5226026056C0870_1628157397 = new SocketException("Host is unresolved: " + isa.getHostName());
            varE8A11D462907C6DEF5226026056C0870_1628157397.addTaint(taint);
            throw varE8A11D462907C6DEF5226026056C0870_1628157397;
        } //End block
        synchronized
(lock)        {
            checkOpen();
            ensureBound();
            this.address = isa.getAddress();
            this.port = isa.getPort();
            this.isConnected = true;
            impl.connect(address, port);
        } //End block
        // ---------- Original Method ----------
        //if (peer == null) {
            //throw new IllegalArgumentException("peer == null");
        //}
        //if (!(peer instanceof InetSocketAddress)) {
            //throw new IllegalArgumentException("peer not an InetSocketAddress: " + peer.getClass());
        //}
        //InetSocketAddress isa = (InetSocketAddress) peer;
        //if (isa.getAddress() == null) {
            //throw new SocketException("Host is unresolved: " + isa.getHostName());
        //}
        //synchronized (lock) {
            //checkOpen();
            //ensureBound();
            //this.address = isa.getAddress();
            //this.port = isa.getPort();
            //this.isConnected = true;
            //impl.connect(address, port);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.421 -0400", hash_original_method = "9E27C6FD502F0359DB781EB2FF7E2BA4", hash_generated_method = "AB6D05E4F4CB3D501B7915FEB54BD39E")
    public void connect(InetAddress address, int port) {
        addTaint(port);
        addTaint(address.getTaint());
        if(address == null)        
        {
            IllegalArgumentException var97E1753900078CCFFFE3026FDB988F71_1451665735 = new IllegalArgumentException("address == null");
            var97E1753900078CCFFFE3026FDB988F71_1451665735.addTaint(taint);
            throw var97E1753900078CCFFFE3026FDB988F71_1451665735;
        } //End block
        try 
        {
            connect(new InetSocketAddress(address, port));
        } //End block
        catch (SocketException connectException)
        {
            pendingConnectException = connectException;
        } //End block
        // ---------- Original Method ----------
        //if (address == null) {
            //throw new IllegalArgumentException("address == null");
        //}
        //try {
            //connect(new InetSocketAddress(address, port));
        //} catch (SocketException connectException) {
            //pendingConnectException = connectException;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.421 -0400", hash_original_method = "589AFDD4CA6BF38ABB5F59E26BB3DC6D", hash_generated_method = "B8AAF9DA6C47DE2EDE64A90D50673F0A")
    public boolean isBound() {
        boolean var8E4D35088206920061AAF7F347854388_922869444 = (isBound);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_743787847 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_743787847;
        // ---------- Original Method ----------
        //return isBound;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.421 -0400", hash_original_method = "B1255CDE181FFAAB8CB434FB98B99FFF", hash_generated_method = "D589E5CF60FE17BF65CC14B9C7197235")
    public boolean isConnected() {
        boolean var8CADFAB0F66545464EF713B1AEC0C7DD_1592195195 = (isConnected);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1040810953 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1040810953;
        // ---------- Original Method ----------
        //return isConnected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.421 -0400", hash_original_method = "7C698472BF26D61A7917F4B5238C5FF7", hash_generated_method = "2A53775D49CA7E19A405AD1DAE949A89")
    public SocketAddress getRemoteSocketAddress() {
        if(!isConnected())        
        {
SocketAddress var540C13E9E156B687226421B24F2DF178_1279791220 =             null;
            var540C13E9E156B687226421B24F2DF178_1279791220.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1279791220;
        } //End block
SocketAddress var45C38FDA41326B49D763EA0783025015_1048471085 =         new InetSocketAddress(getInetAddress(), getPort());
        var45C38FDA41326B49D763EA0783025015_1048471085.addTaint(taint);
        return var45C38FDA41326B49D763EA0783025015_1048471085;
        // ---------- Original Method ----------
        //if (!isConnected()) {
            //return null;
        //}
        //return new InetSocketAddress(getInetAddress(), getPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.422 -0400", hash_original_method = "AE126A441E32CF7358FEDD7A95BAD391", hash_generated_method = "A65438B85C66FDD9DD4FFE9CFDFC660C")
    public SocketAddress getLocalSocketAddress() {
        if(!isBound())        
        {
SocketAddress var540C13E9E156B687226421B24F2DF178_2021296061 =             null;
            var540C13E9E156B687226421B24F2DF178_2021296061.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2021296061;
        } //End block
SocketAddress varEBCBCBDD65488C840B5324120D3690AE_335023530 =         new InetSocketAddress(getLocalAddress(), getLocalPort());
        varEBCBCBDD65488C840B5324120D3690AE_335023530.addTaint(taint);
        return varEBCBCBDD65488C840B5324120D3690AE_335023530;
        // ---------- Original Method ----------
        //if (!isBound()) {
            //return null;
        //}
        //return new InetSocketAddress(getLocalAddress(), getLocalPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.422 -0400", hash_original_method = "D6CD69E67882E49578E557811A0FC457", hash_generated_method = "EB45E1C9E38CA5AD9C7AF6489F52E899")
    public void setReuseAddress(boolean reuse) throws SocketException {
        addTaint(reuse);
        checkOpen();
        impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
        // ---------- Original Method ----------
        //checkOpen();
        //impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.422 -0400", hash_original_method = "8920D58954E3583481E89192EF874E86", hash_generated_method = "475CB3BC0D16F8C48AAD502EC7DB3463")
    public boolean getReuseAddress() throws SocketException {
        checkOpen();
        boolean var5F25B35A5AB65D3270A0F9B4238F8C8D_998951263 = (((Boolean) impl.getOption(SocketOptions.SO_REUSEADDR)).booleanValue());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_330396662 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_330396662;
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Boolean) impl.getOption(SocketOptions.SO_REUSEADDR)).booleanValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.422 -0400", hash_original_method = "16BACAE92585B22CC8D47D482CFB74B4", hash_generated_method = "09AEA3D486FDBEBF3556DF4BA6569999")
    public void setBroadcast(boolean broadcast) throws SocketException {
        addTaint(broadcast);
        checkOpen();
        impl.setOption(SocketOptions.SO_BROADCAST, Boolean.valueOf(broadcast));
        // ---------- Original Method ----------
        //checkOpen();
        //impl.setOption(SocketOptions.SO_BROADCAST, Boolean.valueOf(broadcast));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.422 -0400", hash_original_method = "2CF01D838FE277D7A2E75EEBFE7DA27F", hash_generated_method = "6C03B9409255FB6C408F8FDDEE89BB22")
    public boolean getBroadcast() throws SocketException {
        checkOpen();
        boolean var97CED1D4C57C42B4E25AA2B3B70C1417_269117380 = (((Boolean) impl.getOption(SocketOptions.SO_BROADCAST)).booleanValue());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_532171307 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_532171307;
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Boolean) impl.getOption(SocketOptions.SO_BROADCAST)).booleanValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.422 -0400", hash_original_method = "2EC80086B0B75FB75EFBAAF12E210751", hash_generated_method = "BA075B3E2F27A2ECB29A4AF191F23318")
    public void setTrafficClass(int value) throws SocketException {
        addTaint(value);
        checkOpen();
        if(value < 0 || value > 255)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1119489845 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1119489845.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1119489845;
        } //End block
        impl.setOption(SocketOptions.IP_TOS, Integer.valueOf(value));
        // ---------- Original Method ----------
        //checkOpen();
        //if (value < 0 || value > 255) {
            //throw new IllegalArgumentException();
        //}
        //impl.setOption(SocketOptions.IP_TOS, Integer.valueOf(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.422 -0400", hash_original_method = "2A65749565A2F95D7C49F3E7C9DCBDEC", hash_generated_method = "344E1E797E025B5D207E022641D93669")
    public int getTrafficClass() throws SocketException {
        checkOpen();
        int varB7446D545DBE11135A3678EF4F7ECC87_1343748340 = ((Integer) impl.getOption(SocketOptions.IP_TOS));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2042953247 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2042953247;
        // ---------- Original Method ----------
        //checkOpen();
        //return (Integer) impl.getOption(SocketOptions.IP_TOS);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.423 -0400", hash_original_method = "2EEDDDEB8BA1CD500E3647BC397BF54F", hash_generated_method = "9680CF90A74923DAE3297696484FC937")
    public boolean isClosed() {
        boolean var7587750400D3C39AEAD7C1489F6FE7F3_1653494546 = (isClosed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2005764508 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2005764508;
        // ---------- Original Method ----------
        //return isClosed;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.423 -0400", hash_original_method = "4DA7A00C8A23C7197F09A02190FE9E45", hash_generated_method = "AB801F1DAC0E61C9C268BDF20654AC01")
    public DatagramChannel getChannel() {
DatagramChannel var540C13E9E156B687226421B24F2DF178_1506503413 =         null;
        var540C13E9E156B687226421B24F2DF178_1506503413.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1506503413;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.423 -0400", hash_original_method = "90C19CEBA6BBC20B430C1F399D6443A6", hash_generated_method = "3EF8543353E5D764A4E6932613DE0250")
    public final FileDescriptor getFileDescriptor$() {
FileDescriptor var90D0CD7641DADE7AC7C643EE2F281FD7_1630363246 =         impl.fd;
        var90D0CD7641DADE7AC7C643EE2F281FD7_1630363246.addTaint(taint);
        return var90D0CD7641DADE7AC7C643EE2F281FD7_1630363246;
        // ---------- Original Method ----------
        //return impl.fd;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.423 -0400", hash_original_field = "9549DD6065D019211460C59A86DD6536", hash_generated_field = "E43EB19BC3390384071AA64E51712EB7")

    static DatagramSocketImplFactory factory;
}

