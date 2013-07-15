package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.SocketChannel;
import libcore.io.IoBridge;

public class Socket {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.253 -0400", hash_original_field = "86CCEC3D9FF0E9C0514506E982CDC08B", hash_generated_field = "76382137C184A183F2BF2D8583A90AEC")

    SocketImpl impl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.253 -0400", hash_original_field = "431387EB7262E1CFC79B125EB8A67C60", hash_generated_field = "EE0BB8F1739D62A5A5C8EDF7D478A66B")

    private Proxy proxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.253 -0400", hash_original_field = "13A225F92ADD388C574A88D897639BF0", hash_generated_field = "FEFE85DE55A57D0EBA9EA9B6592B8458")

    volatile boolean isCreated = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.254 -0400", hash_original_field = "1EA05BED8F3F3741889B40C4407A936D", hash_generated_field = "AD4F2B698EC37BEC9EEE873CE57E921D")

    private boolean isBound = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.254 -0400", hash_original_field = "F0F0EDCF28D811EA172AA0A0A89A5056", hash_generated_field = "058DE1E699A3B3D187FC9E15DB7EC3B5")

    private boolean isConnected = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.254 -0400", hash_original_field = "7624DFAF468575D3B7DCE21DA2796711", hash_generated_field = "2CBEAC942D14DA48C324142BCB214C18")

    private boolean isClosed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.254 -0400", hash_original_field = "0053D23938B36B6B0E64039CAC6D2249", hash_generated_field = "7BF3C47813946CC98E6B4F51776BE0B2")

    private boolean isInputShutdown = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.254 -0400", hash_original_field = "6C6248A8DD1927E15E037A0AC6FBF72E", hash_generated_field = "155847C1017F44FA011CC3F03B209D80")

    private boolean isOutputShutdown = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.254 -0400", hash_original_field = "F3693398E061FDE89394A9CA0324D131", hash_generated_field = "A8E9D68398963C6A7BD51AC2BEC0E3CA")

    private InetAddress localAddress = Inet4Address.ANY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.254 -0400", hash_original_field = "D8DB2CE733667EE503E654EFAFD74F2D", hash_generated_field = "574736669071BAC15E2D1E76082A2D20")

    private final Object connectLock = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.255 -0400", hash_original_method = "DE6B6B5588954C6A35AB00A23B1617FE", hash_generated_method = "F670CC532C7B774247714814201AF5CC")
    public  Socket() {
        this.impl = factory != null ? factory.createSocketImpl() : new PlainSocketImpl();
        this.proxy = null;
        // ---------- Original Method ----------
        //this.impl = factory != null ? factory.createSocketImpl() : new PlainSocketImpl();
        //this.proxy = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.255 -0400", hash_original_method = "903F698227E2205A08AC4EC3E6D912C3", hash_generated_method = "A7CA6E8295A1496822CE1DE1D9995A57")
    public  Socket(Proxy proxy) {
    if(proxy == null || proxy.type() == Proxy.Type.HTTP)        
        {
            IllegalArgumentException varF647B68D548B20A9539DD38E2EBC6BE8_840099755 = new IllegalArgumentException("Invalid proxy: " + proxy);
            varF647B68D548B20A9539DD38E2EBC6BE8_840099755.addTaint(taint);
            throw varF647B68D548B20A9539DD38E2EBC6BE8_840099755;
        } //End block
        this.proxy = proxy;
        this.impl = factory != null ? factory.createSocketImpl() : new PlainSocketImpl(proxy);
        // ---------- Original Method ----------
        //if (proxy == null || proxy.type() == Proxy.Type.HTTP) {
            //throw new IllegalArgumentException("Invalid proxy: " + proxy);
        //}
        //this.proxy = proxy;
        //this.impl = factory != null ? factory.createSocketImpl() : new PlainSocketImpl(proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.256 -0400", hash_original_method = "59B1F76D08717F2A7DB6178659D1BD4D", hash_generated_method = "F3B2D501721DE8FE5EA2786B18ADA3C5")
    public  Socket(String dstName, int dstPort) throws UnknownHostException, IOException {
        this(dstName, dstPort, null, 0);
        addTaint(dstPort);
        addTaint(dstName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.256 -0400", hash_original_method = "7A6ED28BC12F5ABFF2F2CE0F9C5717C0", hash_generated_method = "2E961402B0D45E1203024B2E1C51ABF0")
    public  Socket(String dstName, int dstPort, InetAddress localAddress, int localPort) throws IOException {
        this();
        addTaint(localPort);
        addTaint(localAddress.getTaint());
        addTaint(dstPort);
        addTaint(dstName.getTaint());
        tryAllAddresses(dstName, dstPort, localAddress, localPort, true);
        // ---------- Original Method ----------
        //tryAllAddresses(dstName, dstPort, localAddress, localPort, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.257 -0400", hash_original_method = "1948ABC1DE3B1C37A63093E998C50FE7", hash_generated_method = "BFEE34723A2B62901289553B56658AE3")
    @Deprecated
    public  Socket(String hostName, int port, boolean streaming) throws IOException {
        this();
        addTaint(streaming);
        addTaint(port);
        addTaint(hostName.getTaint());
        tryAllAddresses(hostName, port, null, 0, streaming);
        // ---------- Original Method ----------
        //tryAllAddresses(hostName, port, null, 0, streaming);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.257 -0400", hash_original_method = "A1767A7E1F84ED40BDB339014C4851EF", hash_generated_method = "7528775DDA063CE60C4AFFFDC2A71FD0")
    public  Socket(InetAddress dstAddress, int dstPort) throws IOException {
        this();
        addTaint(dstPort);
        addTaint(dstAddress.getTaint());
        checkDestination(dstAddress, dstPort);
        startupSocket(dstAddress, dstPort, null, 0, true);
        // ---------- Original Method ----------
        //checkDestination(dstAddress, dstPort);
        //startupSocket(dstAddress, dstPort, null, 0, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.258 -0400", hash_original_method = "BE0D4569A05DA3EF578449A5DA65F5E7", hash_generated_method = "D98B95F3B1C3E0D35EE3E3F6EF515E29")
    public  Socket(InetAddress dstAddress, int dstPort,
            InetAddress localAddress, int localPort) throws IOException {
        this();
        addTaint(localPort);
        addTaint(localAddress.getTaint());
        addTaint(dstPort);
        addTaint(dstAddress.getTaint());
        checkDestination(dstAddress, dstPort);
        startupSocket(dstAddress, dstPort, localAddress, localPort, true);
        // ---------- Original Method ----------
        //checkDestination(dstAddress, dstPort);
        //startupSocket(dstAddress, dstPort, localAddress, localPort, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.258 -0400", hash_original_method = "D85BA2D34027734E343FA152CA6CE177", hash_generated_method = "CFA82289880DB80B9F8D994284C77D4E")
    @Deprecated
    public  Socket(InetAddress addr, int port, boolean streaming) throws IOException {
        this();
        addTaint(streaming);
        addTaint(port);
        addTaint(addr.getTaint());
        checkDestination(addr, port);
        startupSocket(addr, port, null, 0, streaming);
        // ---------- Original Method ----------
        //checkDestination(addr, port);
        //startupSocket(addr, port, null, 0, streaming);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.259 -0400", hash_original_method = "3BE6817A95031499261EFB4432AAFCBF", hash_generated_method = "79C2133882AE5B1F458B3CC625641B92")
    protected  Socket(SocketImpl impl) throws SocketException {
        this.impl = impl;
        this.proxy = null;
        // ---------- Original Method ----------
        //this.impl = impl;
        //this.proxy = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.260 -0400", hash_original_method = "FE893551BF445ECD0CF959494571F82D", hash_generated_method = "8189DBE7B95240EE8F3E61437F204202")
    private void tryAllAddresses(String dstName, int dstPort, InetAddress
            localAddress, int localPort, boolean streaming) throws IOException {
        addTaint(streaming);
        addTaint(localPort);
        addTaint(localAddress.getTaint());
        addTaint(dstPort);
        addTaint(dstName.getTaint());
        InetAddress[] dstAddresses = InetAddress.getAllByName(dstName);
        InetAddress dstAddress;
for(int i = 0;i < dstAddresses.length - 1;i++)
        {
            dstAddress = dstAddresses[i];
            try 
            {
                checkDestination(dstAddress, dstPort);
                startupSocket(dstAddress, dstPort, localAddress, localPort, streaming);
                return;
            } //End block
            catch (IOException ex)
            {
            } //End block
        } //End block
        dstAddress = dstAddresses[dstAddresses.length - 1];
        checkDestination(dstAddress, dstPort);
        startupSocket(dstAddress, dstPort, localAddress, localPort, streaming);
        // ---------- Original Method ----------
        //InetAddress[] dstAddresses = InetAddress.getAllByName(dstName);
        //InetAddress dstAddress;
        //for (int i = 0; i < dstAddresses.length - 1; i++) {
            //dstAddress = dstAddresses[i];
            //try {
                //checkDestination(dstAddress, dstPort);
                //startupSocket(dstAddress, dstPort, localAddress, localPort, streaming);
                //return;
            //} catch (IOException ex) {
            //}
        //}
        //dstAddress = dstAddresses[dstAddresses.length - 1];
        //checkDestination(dstAddress, dstPort);
        //startupSocket(dstAddress, dstPort, localAddress, localPort, streaming);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.260 -0400", hash_original_method = "B238EF3FEB62ADA205D3F3298560A137", hash_generated_method = "A917F0E9F015F68116FD1565722635ED")
    private void checkDestination(InetAddress destAddr, int dstPort) {
        addTaint(dstPort);
        addTaint(destAddr.getTaint());
    if(dstPort < 0 || dstPort > 65535)        
        {
            IllegalArgumentException varA04B33636DE07A8B3339337D98761728_1698646434 = new IllegalArgumentException("Port out of range: " + dstPort);
            varA04B33636DE07A8B3339337D98761728_1698646434.addTaint(taint);
            throw varA04B33636DE07A8B3339337D98761728_1698646434;
        } //End block
        // ---------- Original Method ----------
        //if (dstPort < 0 || dstPort > 65535) {
            //throw new IllegalArgumentException("Port out of range: " + dstPort);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.261 -0400", hash_original_method = "6609A304DB40C6FFC8F6AC783F01FDAC", hash_generated_method = "BEF433D9A28470F041DB000F7F9A5B35")
    public synchronized void close() throws IOException {
        isClosed = true;
        localAddress = Inet4Address.ANY;
        impl.close();
        // ---------- Original Method ----------
        //isClosed = true;
        //localAddress = Inet4Address.ANY;
        //impl.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.261 -0400", hash_original_method = "084821CC0A1E0331CE4D2BB5EC46E415", hash_generated_method = "459F92291061913159E50CF369B31DB9")
    public InetAddress getInetAddress() {
    if(!isConnected())        
        {
InetAddress var540C13E9E156B687226421B24F2DF178_508114752 =             null;
            var540C13E9E156B687226421B24F2DF178_508114752.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_508114752;
        } //End block
InetAddress var521AFCEA60D8F5BBF63C4443E3C3E08B_1294966977 =         impl.getInetAddress();
        var521AFCEA60D8F5BBF63C4443E3C3E08B_1294966977.addTaint(taint);
        return var521AFCEA60D8F5BBF63C4443E3C3E08B_1294966977;
        // ---------- Original Method ----------
        //if (!isConnected()) {
            //return null;
        //}
        //return impl.getInetAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.262 -0400", hash_original_method = "83F4AB21434B41B13879E1F39D268878", hash_generated_method = "4C47A61AAD20E29B5830471D6E0C48A1")
    public InputStream getInputStream() throws IOException {
        checkOpenAndCreate(false);
    if(isInputShutdown())        
        {
            SocketException var7F56FCFB5848FA2F7798A02081088E95_1852370677 = new SocketException("Socket input is shutdown");
            var7F56FCFB5848FA2F7798A02081088E95_1852370677.addTaint(taint);
            throw var7F56FCFB5848FA2F7798A02081088E95_1852370677;
        } //End block
InputStream varA0C6C26B40703E7D9482EAE0B79E45D2_1141016750 =         impl.getInputStream();
        varA0C6C26B40703E7D9482EAE0B79E45D2_1141016750.addTaint(taint);
        return varA0C6C26B40703E7D9482EAE0B79E45D2_1141016750;
        // ---------- Original Method ----------
        //checkOpenAndCreate(false);
        //if (isInputShutdown()) {
            //throw new SocketException("Socket input is shutdown");
        //}
        //return impl.getInputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.262 -0400", hash_original_method = "CB6F12AE5628FD4A044BF4AD41BFB963", hash_generated_method = "F0C6797980E3CF880CF9932B86CA17EB")
    public boolean getKeepAlive() throws SocketException {
        checkOpenAndCreate(true);
        boolean varD3A178BC19B2F0C7D8759200182C19DD_980991749 = ((Boolean) impl.getOption(SocketOptions.SO_KEEPALIVE));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_652176352 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_652176352;
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Boolean) impl.getOption(SocketOptions.SO_KEEPALIVE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.263 -0400", hash_original_method = "B81D9B2A12700622583B88DBCF07EC2E", hash_generated_method = "1A748F3248CCBD9246A0CC16A09DBD89")
    public InetAddress getLocalAddress() {
InetAddress varAD2ECC3D59386A6CEBDBFE5B70B7F72A_1619344915 =         localAddress;
        varAD2ECC3D59386A6CEBDBFE5B70B7F72A_1619344915.addTaint(taint);
        return varAD2ECC3D59386A6CEBDBFE5B70B7F72A_1619344915;
        // ---------- Original Method ----------
        //return localAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.264 -0400", hash_original_method = "F5BB694DF3469EBFBD82064FFB1FEAE0", hash_generated_method = "E0DDC0611943809AA67ED746EA788C5B")
    public int getLocalPort() {
    if(!isBound())        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1979755240 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_791758020 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_791758020;
        } //End block
        int var141B5401A04AE23DB4012052769AA414_1044930568 = (impl.getLocalPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_818582017 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_818582017;
        // ---------- Original Method ----------
        //if (!isBound()) {
            //return -1;
        //}
        //return impl.getLocalPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.264 -0400", hash_original_method = "0AB25EAA0774AA81766D4356986FC34F", hash_generated_method = "35BC4A45A6949F5D4967074C8CD4DA34")
    public OutputStream getOutputStream() throws IOException {
        checkOpenAndCreate(false);
    if(isOutputShutdown())        
        {
            SocketException varAEED29E2676080AAAF1B3CDFF0042316_247567454 = new SocketException("Socket output is shutdown");
            varAEED29E2676080AAAF1B3CDFF0042316_247567454.addTaint(taint);
            throw varAEED29E2676080AAAF1B3CDFF0042316_247567454;
        } //End block
OutputStream var8CC2DA174DA31DFA9BB5041834194E8D_1435732048 =         impl.getOutputStream();
        var8CC2DA174DA31DFA9BB5041834194E8D_1435732048.addTaint(taint);
        return var8CC2DA174DA31DFA9BB5041834194E8D_1435732048;
        // ---------- Original Method ----------
        //checkOpenAndCreate(false);
        //if (isOutputShutdown()) {
            //throw new SocketException("Socket output is shutdown");
        //}
        //return impl.getOutputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.264 -0400", hash_original_method = "0A0FE55C893091E17125D546A7D59C8C", hash_generated_method = "F140539C3F035BF3A83633E21CBA6E2F")
    public int getPort() {
    if(!isConnected())        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_550634219 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_5083949 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_5083949;
        } //End block
        int varDB8FA7D078228A2C77800473B874DFC2_598510081 = (impl.getPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1951798394 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1951798394;
        // ---------- Original Method ----------
        //if (!isConnected()) {
            //return 0;
        //}
        //return impl.getPort();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.265 -0400", hash_original_method = "8044EC6E5CF2F698E1FE570A36824B05", hash_generated_method = "35387D5F63F532D56E85EEBC7291C37C")
    public int getSoLinger() throws SocketException {
        checkOpenAndCreate(true);
        Object value = impl.getOption(SocketOptions.SO_LINGER);
    if(value instanceof Integer)        
        {
            int varE944F3A84184F5F0A96D04F7F8C0D2C1_1576255175 = ((Integer) value);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1183414086 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1183414086;
        } //End block
        else
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1099926095 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1521573232 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1521573232;
        } //End block
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //Object value = impl.getOption(SocketOptions.SO_LINGER);
        //if (value instanceof Integer) {
            //return (Integer) value;
        //} else {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.266 -0400", hash_original_method = "49326126DE06A7EC2CFFBD7B3A14AE31", hash_generated_method = "C3562E8FCEA91DA4EDF1337F16C64B69")
    public synchronized int getReceiveBufferSize() throws SocketException {
        checkOpenAndCreate(true);
        int varE69D6029B6F5B17DB394682D44B25AF4_868160414 = ((Integer) impl.getOption(SocketOptions.SO_RCVBUF));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_532388831 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_532388831;
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Integer) impl.getOption(SocketOptions.SO_RCVBUF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.266 -0400", hash_original_method = "9FF5297C2B145A55844611E68CB98459", hash_generated_method = "53727C1113643FAD4EA90987AAB4FD83")
    public synchronized int getSendBufferSize() throws SocketException {
        checkOpenAndCreate(true);
        int varB66F46BAAC81777B6AEEA242DAA2AEA8_126029173 = ((Integer) impl.getOption(SocketOptions.SO_SNDBUF));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1057891432 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1057891432;
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Integer) impl.getOption(SocketOptions.SO_SNDBUF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.266 -0400", hash_original_method = "7DAE79431B5F9BEF40635CDD183C2B59", hash_generated_method = "E22953FE3628942A5B04FD14DA523DDF")
    public synchronized int getSoTimeout() throws SocketException {
        checkOpenAndCreate(true);
        int var57D19CE39F17CED789B7768F349AD316_1394278127 = ((Integer) impl.getOption(SocketOptions.SO_TIMEOUT));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_863499145 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_863499145;
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Integer) impl.getOption(SocketOptions.SO_TIMEOUT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.267 -0400", hash_original_method = "3F059C4060D675A8035CAA8B5017EE1E", hash_generated_method = "D0F86C0F9ED0459B84AED8B66B3423A2")
    public boolean getTcpNoDelay() throws SocketException {
        checkOpenAndCreate(true);
        boolean var9EECA72364D39FA4391C9D06C06D6951_2008415788 = ((Boolean) impl.getOption(SocketOptions.TCP_NODELAY));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2040635291 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2040635291;
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Boolean) impl.getOption(SocketOptions.TCP_NODELAY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.267 -0400", hash_original_method = "B94B1A38E8CA82DAB010EC0768F89732", hash_generated_method = "6E1BFC748F2A931AAA24713077C37C35")
    public void setKeepAlive(boolean keepAlive) throws SocketException {
        addTaint(keepAlive);
    if(impl != null)        
        {
            checkOpenAndCreate(true);
            impl.setOption(SocketOptions.SO_KEEPALIVE, Boolean.valueOf(keepAlive));
        } //End block
        // ---------- Original Method ----------
        //if (impl != null) {
            //checkOpenAndCreate(true);
            //impl.setOption(SocketOptions.SO_KEEPALIVE, Boolean.valueOf(keepAlive));
        //}
    }

    
        public static synchronized void setSocketImplFactory(SocketImplFactory fac) throws IOException {
        if (factory != null) {
            throw new SocketException("Factory already set");
        }
        factory = fac;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.268 -0400", hash_original_method = "AEB667B5DBC425D73D37135566ECC286", hash_generated_method = "BB7CBFDBC444B06EDFF5A768BD468473")
    public synchronized void setSendBufferSize(int size) throws SocketException {
        addTaint(size);
        checkOpenAndCreate(true);
    if(size < 1)        
        {
            IllegalArgumentException varE382BBE48942C4B3FA87CFD84F21DF8E_42671201 = new IllegalArgumentException("size < 1");
            varE382BBE48942C4B3FA87CFD84F21DF8E_42671201.addTaint(taint);
            throw varE382BBE48942C4B3FA87CFD84F21DF8E_42671201;
        } //End block
        impl.setOption(SocketOptions.SO_SNDBUF, Integer.valueOf(size));
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //if (size < 1) {
            //throw new IllegalArgumentException("size < 1");
        //}
        //impl.setOption(SocketOptions.SO_SNDBUF, Integer.valueOf(size));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.269 -0400", hash_original_method = "1376DE896B8682F991877B7A17C5B3A4", hash_generated_method = "6D514809969F799FB12C58A4993A7BD3")
    public synchronized void setReceiveBufferSize(int size) throws SocketException {
        addTaint(size);
        checkOpenAndCreate(true);
    if(size < 1)        
        {
            IllegalArgumentException varE382BBE48942C4B3FA87CFD84F21DF8E_1750209829 = new IllegalArgumentException("size < 1");
            varE382BBE48942C4B3FA87CFD84F21DF8E_1750209829.addTaint(taint);
            throw varE382BBE48942C4B3FA87CFD84F21DF8E_1750209829;
        } //End block
        impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //if (size < 1) {
            //throw new IllegalArgumentException("size < 1");
        //}
        //impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.270 -0400", hash_original_method = "89C38D96E5FBD4D1BD6CE4BD573A4473", hash_generated_method = "FE540F873941A49AC9DE61E3CFD758CE")
    public void setSoLinger(boolean on, int timeout) throws SocketException {
        addTaint(timeout);
        addTaint(on);
        checkOpenAndCreate(true);
    if(on && timeout < 0)        
        {
            IllegalArgumentException varBA4E54C08633B7FB6474427FE4B69BA6_2062890625 = new IllegalArgumentException("timeout < 0");
            varBA4E54C08633B7FB6474427FE4B69BA6_2062890625.addTaint(taint);
            throw varBA4E54C08633B7FB6474427FE4B69BA6_2062890625;
        } //End block
    if(on)        
        {
            impl.setOption(SocketOptions.SO_LINGER, Integer.valueOf(timeout));
        } //End block
        else
        {
            impl.setOption(SocketOptions.SO_LINGER, Boolean.FALSE);
        } //End block
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //if (on && timeout < 0) {
            //throw new IllegalArgumentException("timeout < 0");
        //}
        //if (on) {
            //impl.setOption(SocketOptions.SO_LINGER, Integer.valueOf(timeout));
        //} else {
            //impl.setOption(SocketOptions.SO_LINGER, Boolean.FALSE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.271 -0400", hash_original_method = "EA919996CC1899AC4E781314DA47161A", hash_generated_method = "D9D0CCEFCF508D22DCA8E62ACB55CC26")
    public synchronized void setSoTimeout(int timeout) throws SocketException {
        addTaint(timeout);
        checkOpenAndCreate(true);
    if(timeout < 0)        
        {
            IllegalArgumentException varBA4E54C08633B7FB6474427FE4B69BA6_202733391 = new IllegalArgumentException("timeout < 0");
            varBA4E54C08633B7FB6474427FE4B69BA6_202733391.addTaint(taint);
            throw varBA4E54C08633B7FB6474427FE4B69BA6_202733391;
        } //End block
        impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(timeout));
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //if (timeout < 0) {
            //throw new IllegalArgumentException("timeout < 0");
        //}
        //impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.271 -0400", hash_original_method = "04E6A4AAAA03D3C2F3E4334A66D2F7A1", hash_generated_method = "623FE2E860A2B3D10272660F1FFA63E0")
    public void setTcpNoDelay(boolean on) throws SocketException {
        addTaint(on);
        checkOpenAndCreate(true);
        impl.setOption(SocketOptions.TCP_NODELAY, Boolean.valueOf(on));
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //impl.setOption(SocketOptions.TCP_NODELAY, Boolean.valueOf(on));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.272 -0400", hash_original_method = "20DD1F1CA9EDC17BE2B90F2B7E5FF655", hash_generated_method = "C48CAE27DDAE2837DE831DD8ED865216")
    private void startupSocket(InetAddress dstAddress, int dstPort,
            InetAddress localAddress, int localPort, boolean streaming) throws IOException {
        addTaint(streaming);
        addTaint(localPort);
        addTaint(localAddress.getTaint());
        addTaint(dstPort);
        addTaint(dstAddress.getTaint());
    if(localPort < 0 || localPort > 65535)        
        {
            IllegalArgumentException varB07D409980ACA6697DBCC916992EA34A_1230319497 = new IllegalArgumentException("Local port out of range: " + localPort);
            varB07D409980ACA6697DBCC916992EA34A_1230319497.addTaint(taint);
            throw varB07D409980ACA6697DBCC916992EA34A_1230319497;
        } //End block
        InetAddress addr = localAddress == null ? Inet4Address.ANY : localAddress;
        synchronized
(this)        {
            impl.create(streaming);
            isCreated = true;
            try 
            {
    if(!streaming || !usingSocks())                
                {
                    impl.bind(addr, localPort);
                } //End block
                isBound = true;
                impl.connect(dstAddress, dstPort);
                isConnected = true;
                cacheLocalAddress();
            } //End block
            catch (IOException e)
            {
                impl.close();
                e.addTaint(taint);
                throw e;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (localPort < 0 || localPort > 65535) {
            //throw new IllegalArgumentException("Local port out of range: " + localPort);
        //}
        //InetAddress addr = localAddress == null ? Inet4Address.ANY : localAddress;
        //synchronized (this) {
            //impl.create(streaming);
            //isCreated = true;
            //try {
                //if (!streaming || !usingSocks()) {
                    //impl.bind(addr, localPort);
                //}
                //isBound = true;
                //impl.connect(dstAddress, dstPort);
                //isConnected = true;
                //cacheLocalAddress();
            //} catch (IOException e) {
                //impl.close();
                //throw e;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.273 -0400", hash_original_method = "933F73796CB698722A986AC13FC9BFF8", hash_generated_method = "4319CF17B60C6926F940A77D053ACF2E")
    private boolean usingSocks() {
        boolean var5E1E555BE0AAD4134390E5A70C27656D_1486270837 = (proxy != null && proxy.type() == Proxy.Type.SOCKS);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_426511495 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_426511495;
        // ---------- Original Method ----------
        //return proxy != null && proxy.type() == Proxy.Type.SOCKS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.273 -0400", hash_original_method = "881D40A46B027F3EDC8B30A9F4F44097", hash_generated_method = "1E3DCD3CC498FE636850E2F3EB319242")
    @Override
    public String toString() {
    if(!isConnected())        
        {
String varCFFD4F7E5A3618E92EF1B20EDC6F1A9F_1123470470 =             "Socket[unconnected]";
            varCFFD4F7E5A3618E92EF1B20EDC6F1A9F_1123470470.addTaint(taint);
            return varCFFD4F7E5A3618E92EF1B20EDC6F1A9F_1123470470;
        } //End block
String varB034AC56C48F7BEF9DF09FF96FD67CC5_1619281374 =         impl.toString();
        varB034AC56C48F7BEF9DF09FF96FD67CC5_1619281374.addTaint(taint);
        return varB034AC56C48F7BEF9DF09FF96FD67CC5_1619281374;
        // ---------- Original Method ----------
        //if (!isConnected()) {
            //return "Socket[unconnected]";
        //}
        //return impl.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.274 -0400", hash_original_method = "D21BBF88E7F4579ADC8933941E3433FA", hash_generated_method = "09BA91ED401CAEB4E6662C81DB29DD8B")
    public void shutdownInput() throws IOException {
    if(isInputShutdown())        
        {
            SocketException var7F56FCFB5848FA2F7798A02081088E95_1536733367 = new SocketException("Socket input is shutdown");
            var7F56FCFB5848FA2F7798A02081088E95_1536733367.addTaint(taint);
            throw var7F56FCFB5848FA2F7798A02081088E95_1536733367;
        } //End block
        checkOpenAndCreate(false);
        impl.shutdownInput();
        isInputShutdown = true;
        // ---------- Original Method ----------
        //if (isInputShutdown()) {
            //throw new SocketException("Socket input is shutdown");
        //}
        //checkOpenAndCreate(false);
        //impl.shutdownInput();
        //isInputShutdown = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.274 -0400", hash_original_method = "1AECC9ACE476BBC93D823FC75BDACBC6", hash_generated_method = "D038109D63DE0BE77A599756F6C272E7")
    public void shutdownOutput() throws IOException {
    if(isOutputShutdown())        
        {
            SocketException varAEED29E2676080AAAF1B3CDFF0042316_53651548 = new SocketException("Socket output is shutdown");
            varAEED29E2676080AAAF1B3CDFF0042316_53651548.addTaint(taint);
            throw varAEED29E2676080AAAF1B3CDFF0042316_53651548;
        } //End block
        checkOpenAndCreate(false);
        impl.shutdownOutput();
        isOutputShutdown = true;
        // ---------- Original Method ----------
        //if (isOutputShutdown()) {
            //throw new SocketException("Socket output is shutdown");
        //}
        //checkOpenAndCreate(false);
        //impl.shutdownOutput();
        //isOutputShutdown = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.275 -0400", hash_original_method = "80C03A9E4F151BE4271ACE586291D7DE", hash_generated_method = "CCDB88580F6F5FBEB71BAE9AE720456D")
    private void checkOpenAndCreate(boolean create) throws SocketException {
        addTaint(create);
    if(isClosed())        
        {
            SocketException var5AD72407DD9337ABED4666C49A30EC41_1490013269 = new SocketException("Socket is closed");
            var5AD72407DD9337ABED4666C49A30EC41_1490013269.addTaint(taint);
            throw var5AD72407DD9337ABED4666C49A30EC41_1490013269;
        } //End block
    if(!create)        
        {
    if(!isConnected())            
            {
                SocketException var56B6B46DDA80C85C37F76D6551ACB00C_662461602 = new SocketException("Socket is not connected");
                var56B6B46DDA80C85C37F76D6551ACB00C_662461602.addTaint(taint);
                throw var56B6B46DDA80C85C37F76D6551ACB00C_662461602;
            } //End block
            return;
        } //End block
    if(isCreated)        
        {
            return;
        } //End block
        synchronized
(this)        {
    if(isCreated)            
            {
                return;
            } //End block
            try 
            {
                impl.create(true);
            } //End block
            catch (SocketException e)
            {
                e.addTaint(taint);
                throw e;
            } //End block
            catch (IOException e)
            {
                SocketException varCAB13102AD73DDE091DCEE7F9E32F861_1096291886 = new SocketException(e.toString());
                varCAB13102AD73DDE091DCEE7F9E32F861_1096291886.addTaint(taint);
                throw varCAB13102AD73DDE091DCEE7F9E32F861_1096291886;
            } //End block
            isCreated = true;
        } //End block
        // ---------- Original Method ----------
        //if (isClosed()) {
            //throw new SocketException("Socket is closed");
        //}
        //if (!create) {
            //if (!isConnected()) {
                //throw new SocketException("Socket is not connected");
            //}
            //return;
        //}
        //if (isCreated) {
            //return;
        //}
        //synchronized (this) {
            //if (isCreated) {
                //return;
            //}
            //try {
                //impl.create(true);
            //} catch (SocketException e) {
                //throw e;
            //} catch (IOException e) {
                //throw new SocketException(e.toString());
            //}
            //isCreated = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.276 -0400", hash_original_method = "AE126A441E32CF7358FEDD7A95BAD391", hash_generated_method = "F349C3E44F45CD989A60743BBAC6CC20")
    public SocketAddress getLocalSocketAddress() {
    if(!isBound())        
        {
SocketAddress var540C13E9E156B687226421B24F2DF178_1019758175 =             null;
            var540C13E9E156B687226421B24F2DF178_1019758175.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1019758175;
        } //End block
SocketAddress varEBCBCBDD65488C840B5324120D3690AE_1719116295 =         new InetSocketAddress(getLocalAddress(), getLocalPort());
        varEBCBCBDD65488C840B5324120D3690AE_1719116295.addTaint(taint);
        return varEBCBCBDD65488C840B5324120D3690AE_1719116295;
        // ---------- Original Method ----------
        //if (!isBound()) {
            //return null;
        //}
        //return new InetSocketAddress(getLocalAddress(), getLocalPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.276 -0400", hash_original_method = "7C698472BF26D61A7917F4B5238C5FF7", hash_generated_method = "CD305B3F49169EDD8960039268EB82ED")
    public SocketAddress getRemoteSocketAddress() {
    if(!isConnected())        
        {
SocketAddress var540C13E9E156B687226421B24F2DF178_1308662880 =             null;
            var540C13E9E156B687226421B24F2DF178_1308662880.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1308662880;
        } //End block
SocketAddress var45C38FDA41326B49D763EA0783025015_1330540332 =         new InetSocketAddress(getInetAddress(), getPort());
        var45C38FDA41326B49D763EA0783025015_1330540332.addTaint(taint);
        return var45C38FDA41326B49D763EA0783025015_1330540332;
        // ---------- Original Method ----------
        //if (!isConnected()) {
            //return null;
        //}
        //return new InetSocketAddress(getInetAddress(), getPort());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.277 -0400", hash_original_method = "589AFDD4CA6BF38ABB5F59E26BB3DC6D", hash_generated_method = "6177552155E297AB4F376CE7B02850BC")
    public boolean isBound() {
        boolean var8E4D35088206920061AAF7F347854388_610081471 = (isBound);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_394869756 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_394869756;
        // ---------- Original Method ----------
        //return isBound;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.277 -0400", hash_original_method = "B1255CDE181FFAAB8CB434FB98B99FFF", hash_generated_method = "880DE7101935228C124053C8FD5F18CA")
    public boolean isConnected() {
        boolean var8CADFAB0F66545464EF713B1AEC0C7DD_1149274003 = (isConnected);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1984086607 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1984086607;
        // ---------- Original Method ----------
        //return isConnected;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.277 -0400", hash_original_method = "2EEDDDEB8BA1CD500E3647BC397BF54F", hash_generated_method = "3529F9988631EB25B5D8479E6366A385")
    public boolean isClosed() {
        boolean var7587750400D3C39AEAD7C1489F6FE7F3_211730987 = (isClosed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_559731622 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_559731622;
        // ---------- Original Method ----------
        //return isClosed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.278 -0400", hash_original_method = "9E3C378994EF9A4091E39D0FA34770F8", hash_generated_method = "3B90C4628CF14D253C503CDAB9AB6122")
    public void bind(SocketAddress localAddr) throws IOException {
        addTaint(localAddr.getTaint());
        checkOpenAndCreate(true);
    if(isBound())        
        {
            BindException varF1BB61747164E86D14B4203A7B687A13_1120944571 = new BindException("Socket is already bound");
            varF1BB61747164E86D14B4203A7B687A13_1120944571.addTaint(taint);
            throw varF1BB61747164E86D14B4203A7B687A13_1120944571;
        } //End block
        int port = 0;
        InetAddress addr = Inet4Address.ANY;
    if(localAddr != null)        
        {
    if(!(localAddr instanceof InetSocketAddress))            
            {
                IllegalArgumentException varC26B139CE5269510432F181AB5FE9596_944389424 = new IllegalArgumentException("Local address not an InetSocketAddress: " +
                        localAddr.getClass());
                varC26B139CE5269510432F181AB5FE9596_944389424.addTaint(taint);
                throw varC26B139CE5269510432F181AB5FE9596_944389424;
            } //End block
            InetSocketAddress inetAddr = (InetSocketAddress) localAddr;
    if((addr = inetAddr.getAddress()) == null)            
            {
                UnknownHostException var3C4F598ABE9529E4B9600A6F4669E225_1103755296 = new UnknownHostException("Host is unresolved: " + inetAddr.getHostName());
                var3C4F598ABE9529E4B9600A6F4669E225_1103755296.addTaint(taint);
                throw var3C4F598ABE9529E4B9600A6F4669E225_1103755296;
            } //End block
            port = inetAddr.getPort();
        } //End block
        synchronized
(this)        {
            try 
            {
                impl.bind(addr, port);
                isBound = true;
                cacheLocalAddress();
            } //End block
            catch (IOException e)
            {
                impl.close();
                e.addTaint(taint);
                throw e;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.279 -0400", hash_original_method = "B2F3815725658D73C0532A54E6C164BA", hash_generated_method = "E2CF869A775878B13C5BF4C2378A45CC")
    public void connect(SocketAddress remoteAddr) throws IOException {
        addTaint(remoteAddr.getTaint());
        connect(remoteAddr, 0);
        // ---------- Original Method ----------
        //connect(remoteAddr, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.280 -0400", hash_original_method = "45EED4DE787227F7BEC68E335C7AA6E7", hash_generated_method = "08B1F7906D8347CA89D3C4E8CC9BBFC4")
    public void connect(SocketAddress remoteAddr, int timeout) throws IOException {
        addTaint(timeout);
        addTaint(remoteAddr.getTaint());
        checkOpenAndCreate(true);
    if(timeout < 0)        
        {
            IllegalArgumentException varBA4E54C08633B7FB6474427FE4B69BA6_745610943 = new IllegalArgumentException("timeout < 0");
            varBA4E54C08633B7FB6474427FE4B69BA6_745610943.addTaint(taint);
            throw varBA4E54C08633B7FB6474427FE4B69BA6_745610943;
        } //End block
    if(isConnected())        
        {
            SocketException var057298146ADCA0A0A0A096E3D44F13A8_311091982 = new SocketException("Already connected");
            var057298146ADCA0A0A0A096E3D44F13A8_311091982.addTaint(taint);
            throw var057298146ADCA0A0A0A096E3D44F13A8_311091982;
        } //End block
    if(remoteAddr == null)        
        {
            IllegalArgumentException varDC6AED11B8056B4C6A4C4E6AF2920AB9_1954829406 = new IllegalArgumentException("remoteAddr == null");
            varDC6AED11B8056B4C6A4C4E6AF2920AB9_1954829406.addTaint(taint);
            throw varDC6AED11B8056B4C6A4C4E6AF2920AB9_1954829406;
        } //End block
    if(!(remoteAddr instanceof InetSocketAddress))        
        {
            IllegalArgumentException var34256ACC73F10A6C5882EDD2575B9284_1812602304 = new IllegalArgumentException("Remote address not an InetSocketAddress: " +
                    remoteAddr.getClass());
            var34256ACC73F10A6C5882EDD2575B9284_1812602304.addTaint(taint);
            throw var34256ACC73F10A6C5882EDD2575B9284_1812602304;
        } //End block
        InetSocketAddress inetAddr = (InetSocketAddress) remoteAddr;
        InetAddress addr;
    if((addr = inetAddr.getAddress()) == null)        
        {
            UnknownHostException var3C4F598ABE9529E4B9600A6F4669E225_1254736610 = new UnknownHostException("Host is unresolved: " + inetAddr.getHostName());
            var3C4F598ABE9529E4B9600A6F4669E225_1254736610.addTaint(taint);
            throw var3C4F598ABE9529E4B9600A6F4669E225_1254736610;
        } //End block
        int port = inetAddr.getPort();
        checkDestination(addr, port);
        synchronized
(connectLock)        {
            try 
            {
    if(!isBound())                
                {
    if(!usingSocks())                    
                    {
                        impl.bind(Inet4Address.ANY, 0);
                    } //End block
                    isBound = true;
                } //End block
                impl.connect(remoteAddr, timeout);
                isConnected = true;
                cacheLocalAddress();
            } //End block
            catch (IOException e)
            {
                impl.close();
                e.addTaint(taint);
                throw e;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.280 -0400", hash_original_method = "2FA07403172C73A0B79A0DF7F37DEBFB", hash_generated_method = "5EA44B2E63433601D942F480F4FA3019")
    public boolean isInputShutdown() {
        boolean var9258EF3F2889DB3AFCC9F028A10B247C_339441769 = (isInputShutdown);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_719528826 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_719528826;
        // ---------- Original Method ----------
        //return isInputShutdown;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.281 -0400", hash_original_method = "C1B1C01C4973B5698673C5D09FA67185", hash_generated_method = "346876FC3A24FF32447DB5954A7B536E")
    public boolean isOutputShutdown() {
        boolean var16CA59BF2EA6FD0D585BF0BE01D21C5E_1349027523 = (isOutputShutdown);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_936655640 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_936655640;
        // ---------- Original Method ----------
        //return isOutputShutdown;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.281 -0400", hash_original_method = "6CEA4E5A53899EBE8D1FD08F2FE40675", hash_generated_method = "5439EA4547C42C8A6322F5AD2E1F9299")
    public void setReuseAddress(boolean reuse) throws SocketException {
        addTaint(reuse);
        checkOpenAndCreate(true);
        impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.281 -0400", hash_original_method = "8D0919FD23B9A2472FC046E6B1704481", hash_generated_method = "ABC35CFC9A00A2EB9EC8B17DF180ECD7")
    public boolean getReuseAddress() throws SocketException {
        checkOpenAndCreate(true);
        boolean varC47C46B27A013F37B3B2BAE29DAED84B_515190627 = ((Boolean) impl.getOption(SocketOptions.SO_REUSEADDR));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1787738629 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1787738629;
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Boolean) impl.getOption(SocketOptions.SO_REUSEADDR);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.282 -0400", hash_original_method = "8F9774180DF7F00524B2F69126E7F96E", hash_generated_method = "F02D802F1E52B39AD1204D8895D139C9")
    public void setOOBInline(boolean oobinline) throws SocketException {
        addTaint(oobinline);
        checkOpenAndCreate(true);
        impl.setOption(SocketOptions.SO_OOBINLINE, Boolean.valueOf(oobinline));
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //impl.setOption(SocketOptions.SO_OOBINLINE, Boolean.valueOf(oobinline));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.282 -0400", hash_original_method = "A307BAC96AD0AD9185D724CFFBC60918", hash_generated_method = "BEEB093D5952613195644B2173F36FEE")
    public boolean getOOBInline() throws SocketException {
        checkOpenAndCreate(true);
        boolean var2435A1C19880E3586F972D54F26820D9_1382672142 = ((Boolean) impl.getOption(SocketOptions.SO_OOBINLINE));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_920916614 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_920916614;
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Boolean) impl.getOption(SocketOptions.SO_OOBINLINE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.283 -0400", hash_original_method = "50A48D0E3EC8A723BC37542164C52A31", hash_generated_method = "8D3069828E6D869A3ED18989CF492200")
    public void setTrafficClass(int value) throws SocketException {
        addTaint(value);
        checkOpenAndCreate(true);
    if(value < 0 || value > 255)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_212044426 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_212044426.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_212044426;
        } //End block
        impl.setOption(SocketOptions.IP_TOS, Integer.valueOf(value));
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //if (value < 0 || value > 255) {
            //throw new IllegalArgumentException();
        //}
        //impl.setOption(SocketOptions.IP_TOS, Integer.valueOf(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.283 -0400", hash_original_method = "D7C7CF134B3FE725817BA2C07D220760", hash_generated_method = "1F583682D7E753595A77165BCA7E6F24")
    public int getTrafficClass() throws SocketException {
        checkOpenAndCreate(true);
        int varB7446D545DBE11135A3678EF4F7ECC87_2008531371 = ((Integer) impl.getOption(SocketOptions.IP_TOS));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_990550173 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_990550173;
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Integer) impl.getOption(SocketOptions.IP_TOS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.283 -0400", hash_original_method = "CBFC447F34929AC991DFFA20015F8279", hash_generated_method = "A51E14DD4E2EE096CAED93EC84042B7F")
    public void sendUrgentData(int value) throws IOException {
        addTaint(value);
        impl.sendUrgentData(value);
        // ---------- Original Method ----------
        //impl.sendUrgentData(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.284 -0400", hash_original_method = "21E3234EAE6C3F4479E6E7944641B8BE", hash_generated_method = "7AA833B05FB6D1983035B8C7720A9AD2")
     void accepted() {
        isCreated = isBound = isConnected = true;
        cacheLocalAddress();
        // ---------- Original Method ----------
        //isCreated = isBound = isConnected = true;
        //cacheLocalAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.284 -0400", hash_original_method = "95A7BF302299AFCDED7970E2F7424717", hash_generated_method = "794BDF12835FAD96C22BC1E6B513ECB3")
    private void cacheLocalAddress() {
        this.localAddress = IoBridge.getSocketLocalAddress(impl.fd);
        // ---------- Original Method ----------
        //this.localAddress = IoBridge.getSocketLocalAddress(impl.fd);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.284 -0400", hash_original_method = "A7DB57A03C94477191BD1BBD8D530AC8", hash_generated_method = "0544181E0153111117884C50A945CECB")
    public SocketChannel getChannel() {
SocketChannel var540C13E9E156B687226421B24F2DF178_197594865 =         null;
        var540C13E9E156B687226421B24F2DF178_197594865.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_197594865;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.285 -0400", hash_original_method = "90C19CEBA6BBC20B430C1F399D6443A6", hash_generated_method = "AB8757C2CC24FE74D723E6DE767318E4")
    public FileDescriptor getFileDescriptor$() {
FileDescriptor var90D0CD7641DADE7AC7C643EE2F281FD7_1530794477 =         impl.fd;
        var90D0CD7641DADE7AC7C643EE2F281FD7_1530794477.addTaint(taint);
        return var90D0CD7641DADE7AC7C643EE2F281FD7_1530794477;
        // ---------- Original Method ----------
        //return impl.fd;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.285 -0400", hash_original_method = "EE4DCDA11944F25F3B6AAA6A92D8AD2F", hash_generated_method = "2EE8865BF17B91491774A6BE2B19EEC0")
    public void setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
        addTaint(bandwidth);
        addTaint(latency);
        addTaint(connectionTime);
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.285 -0400", hash_original_field = "9549DD6065D019211460C59A86DD6536", hash_generated_field = "ABE875F9FF8F88D9D548D2F2A5A13861")

    private static SocketImplFactory factory;
}

