package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.SocketChannel;
import libcore.io.IoBridge;

public class Socket {
    private static SocketImplFactory factory;
    final SocketImpl impl;
    private final Proxy proxy;
    volatile boolean isCreated = false;
    private boolean isBound = false;
    private boolean isConnected = false;
    private boolean isClosed = false;
    private boolean isInputShutdown = false;
    private boolean isOutputShutdown = false;
    private InetAddress localAddress = Inet4Address.ANY;
    private final Object connectLock = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.292 -0400", hash_original_method = "DE6B6B5588954C6A35AB00A23B1617FE", hash_generated_method = "F2DC3950F6D7B3B6B3335432B45014C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Socket() {
        this.impl = factory != null ? factory.createSocketImpl() : new PlainSocketImpl();
        this.proxy = null;
        // ---------- Original Method ----------
        //this.impl = factory != null ? factory.createSocketImpl() : new PlainSocketImpl();
        //this.proxy = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.292 -0400", hash_original_method = "903F698227E2205A08AC4EC3E6D912C3", hash_generated_method = "9F45A2CB49E41562BF8454DC81BE13B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Socket(Proxy proxy) {
        dsTaint.addTaint(proxy.dsTaint);
        {
            boolean varE5CF7C9644D24DC30510FF113B6FA9F4_286839205 = (proxy == null || proxy.type() == Proxy.Type.HTTP);
            {
                throw new IllegalArgumentException("Invalid proxy: " + proxy);
            } //End block
        } //End collapsed parenthetic
        this.impl = factory != null ? factory.createSocketImpl() : new PlainSocketImpl(proxy);
        // ---------- Original Method ----------
        //if (proxy == null || proxy.type() == Proxy.Type.HTTP) {
            //throw new IllegalArgumentException("Invalid proxy: " + proxy);
        //}
        //this.proxy = proxy;
        //this.impl = factory != null ? factory.createSocketImpl() : new PlainSocketImpl(proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.292 -0400", hash_original_method = "59B1F76D08717F2A7DB6178659D1BD4D", hash_generated_method = "A93105E717438C254614C9443BC39202")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Socket(String dstName, int dstPort) throws UnknownHostException, IOException {
        this(dstName, dstPort, null, 0);
        dsTaint.addTaint(dstPort);
        dsTaint.addTaint(dstName);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.292 -0400", hash_original_method = "7A6ED28BC12F5ABFF2F2CE0F9C5717C0", hash_generated_method = "8C20E38BE6EB931C83DA7F373CCBDC64")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Socket(String dstName, int dstPort, InetAddress localAddress, int localPort) throws IOException {
        this();
        dsTaint.addTaint(dstPort);
        dsTaint.addTaint(localAddress.dsTaint);
        dsTaint.addTaint(localPort);
        dsTaint.addTaint(dstName);
        tryAllAddresses(dstName, dstPort, localAddress, localPort, true);
        // ---------- Original Method ----------
        //tryAllAddresses(dstName, dstPort, localAddress, localPort, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.292 -0400", hash_original_method = "1948ABC1DE3B1C37A63093E998C50FE7", hash_generated_method = "AE904B7F52AE5A4E37573D6AAF100366")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public Socket(String hostName, int port, boolean streaming) throws IOException {
        this();
        dsTaint.addTaint(port);
        dsTaint.addTaint(streaming);
        dsTaint.addTaint(hostName);
        tryAllAddresses(hostName, port, null, 0, streaming);
        // ---------- Original Method ----------
        //tryAllAddresses(hostName, port, null, 0, streaming);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.293 -0400", hash_original_method = "A1767A7E1F84ED40BDB339014C4851EF", hash_generated_method = "CEA3751A5C8A3AD43DB5D3373CC52EB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Socket(InetAddress dstAddress, int dstPort) throws IOException {
        this();
        dsTaint.addTaint(dstPort);
        dsTaint.addTaint(dstAddress.dsTaint);
        checkDestination(dstAddress, dstPort);
        startupSocket(dstAddress, dstPort, null, 0, true);
        // ---------- Original Method ----------
        //checkDestination(dstAddress, dstPort);
        //startupSocket(dstAddress, dstPort, null, 0, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.293 -0400", hash_original_method = "BE0D4569A05DA3EF578449A5DA65F5E7", hash_generated_method = "ADB3D90DACC36D1FA589C80DE710159A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Socket(InetAddress dstAddress, int dstPort,
            InetAddress localAddress, int localPort) throws IOException {
        this();
        dsTaint.addTaint(dstPort);
        dsTaint.addTaint(localAddress.dsTaint);
        dsTaint.addTaint(dstAddress.dsTaint);
        dsTaint.addTaint(localPort);
        checkDestination(dstAddress, dstPort);
        startupSocket(dstAddress, dstPort, localAddress, localPort, true);
        // ---------- Original Method ----------
        //checkDestination(dstAddress, dstPort);
        //startupSocket(dstAddress, dstPort, localAddress, localPort, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.293 -0400", hash_original_method = "D85BA2D34027734E343FA152CA6CE177", hash_generated_method = "FADF1B68E79CA818BBD98C3F639E9D70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public Socket(InetAddress addr, int port, boolean streaming) throws IOException {
        this();
        dsTaint.addTaint(port);
        dsTaint.addTaint(streaming);
        dsTaint.addTaint(addr.dsTaint);
        checkDestination(addr, port);
        startupSocket(addr, port, null, 0, streaming);
        // ---------- Original Method ----------
        //checkDestination(addr, port);
        //startupSocket(addr, port, null, 0, streaming);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.293 -0400", hash_original_method = "3BE6817A95031499261EFB4432AAFCBF", hash_generated_method = "CBE9A6904A0AEBCD97B1F16D83396D9F")
    @DSModeled(DSC.SAFE)
    protected Socket(SocketImpl impl) throws SocketException {
        dsTaint.addTaint(impl.dsTaint);
        this.proxy = null;
        // ---------- Original Method ----------
        //this.impl = impl;
        //this.proxy = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.293 -0400", hash_original_method = "FE893551BF445ECD0CF959494571F82D", hash_generated_method = "CC72F42F9E0FD11946EC5AF4BED6B891")
    @DSModeled(DSC.SAFE)
    private void tryAllAddresses(String dstName, int dstPort, InetAddress
            localAddress, int localPort, boolean streaming) throws IOException {
        dsTaint.addTaint(streaming);
        dsTaint.addTaint(dstPort);
        dsTaint.addTaint(localAddress.dsTaint);
        dsTaint.addTaint(localPort);
        dsTaint.addTaint(dstName);
        InetAddress[] dstAddresses;
        dstAddresses = InetAddress.getAllByName(dstName);
        InetAddress dstAddress;
        {
            int i;
            i = 0;
            {
                dstAddress = dstAddresses[i];
                try 
                {
                    checkDestination(dstAddress, dstPort);
                    startupSocket(dstAddress, dstPort, localAddress, localPort, streaming);
                } //End block
                catch (IOException ex)
                { }
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.293 -0400", hash_original_method = "B238EF3FEB62ADA205D3F3298560A137", hash_generated_method = "A59F04AAE795C6A08A5C70D6139F166D")
    @DSModeled(DSC.SAFE)
    private void checkDestination(InetAddress destAddr, int dstPort) {
        dsTaint.addTaint(destAddr.dsTaint);
        dsTaint.addTaint(dstPort);
        {
            throw new IllegalArgumentException("Port out of range: " + dstPort);
        } //End block
        // ---------- Original Method ----------
        //if (dstPort < 0 || dstPort > 65535) {
            //throw new IllegalArgumentException("Port out of range: " + dstPort);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.293 -0400", hash_original_method = "6609A304DB40C6FFC8F6AC783F01FDAC", hash_generated_method = "37B042D992F0CC1CD8D48D535072C803")
    @DSModeled(DSC.SAFE)
    public synchronized void close() throws IOException {
        isClosed = true;
        localAddress = Inet4Address.ANY;
        impl.close();
        // ---------- Original Method ----------
        //isClosed = true;
        //localAddress = Inet4Address.ANY;
        //impl.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.293 -0400", hash_original_method = "084821CC0A1E0331CE4D2BB5EC46E415", hash_generated_method = "8737D28D2F55234C2D43D61818ED871E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InetAddress getInetAddress() {
        {
            boolean var341AB6969DFD2927CA563855F9EEB77E_731986093 = (!isConnected());
        } //End collapsed parenthetic
        InetAddress var8655A4EE53FB8FBE3B9196FE317ADFA6_1203593984 = (impl.getInetAddress());
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!isConnected()) {
            //return null;
        //}
        //return impl.getInetAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.293 -0400", hash_original_method = "83F4AB21434B41B13879E1F39D268878", hash_generated_method = "358EDE419B5666240CFF8734CCABC733")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputStream getInputStream() throws IOException {
        checkOpenAndCreate(false);
        {
            boolean var899D12471AFC16D8818224BE7B57500A_1518069349 = (isInputShutdown());
            {
                throw new SocketException("Socket input is shutdown");
            } //End block
        } //End collapsed parenthetic
        InputStream varF6270A204F6CBA0922B73BE390C94FA8_781644989 = (impl.getInputStream());
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkOpenAndCreate(false);
        //if (isInputShutdown()) {
            //throw new SocketException("Socket input is shutdown");
        //}
        //return impl.getInputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.293 -0400", hash_original_method = "CB6F12AE5628FD4A044BF4AD41BFB963", hash_generated_method = "E59B29885FFE8343BB744EA4BB958F16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getKeepAlive() throws SocketException {
        checkOpenAndCreate(true);
        boolean var041E463ADEEF0C23B09546F75815EDF9_2102067600 = ((Boolean) impl.getOption(SocketOptions.SO_KEEPALIVE));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Boolean) impl.getOption(SocketOptions.SO_KEEPALIVE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.293 -0400", hash_original_method = "B81D9B2A12700622583B88DBCF07EC2E", hash_generated_method = "C2E314D899972CC091A2B2233A04BF93")
    @DSModeled(DSC.SAFE)
    public InetAddress getLocalAddress() {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return localAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.293 -0400", hash_original_method = "F5BB694DF3469EBFBD82064FFB1FEAE0", hash_generated_method = "E766CA84B65C6EF9ADDEF1C19C4E57CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLocalPort() {
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_1594877362 = (!isBound());
        } //End collapsed parenthetic
        int var5201144B0B742B3A152781D672D1AA30_1263380764 = (impl.getLocalPort());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (!isBound()) {
            //return -1;
        //}
        //return impl.getLocalPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.294 -0400", hash_original_method = "0AB25EAA0774AA81766D4356986FC34F", hash_generated_method = "F39441BDC2DE909198E9D9F91353EFDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OutputStream getOutputStream() throws IOException {
        checkOpenAndCreate(false);
        {
            boolean var721D80F1B38A860A3B065E2E7DC6E012_1610838350 = (isOutputShutdown());
            {
                throw new SocketException("Socket output is shutdown");
            } //End block
        } //End collapsed parenthetic
        OutputStream var3644B8EF59184DA0E1B22959A80C9115_513395518 = (impl.getOutputStream());
        return (OutputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkOpenAndCreate(false);
        //if (isOutputShutdown()) {
            //throw new SocketException("Socket output is shutdown");
        //}
        //return impl.getOutputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.294 -0400", hash_original_method = "0A0FE55C893091E17125D546A7D59C8C", hash_generated_method = "BD860D97866780028A735F5D50A961DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPort() {
        {
            boolean var341AB6969DFD2927CA563855F9EEB77E_156551069 = (!isConnected());
        } //End collapsed parenthetic
        int var804FC545E664230B0744C92D9C1FC410_475283045 = (impl.getPort());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (!isConnected()) {
            //return 0;
        //}
        //return impl.getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.294 -0400", hash_original_method = "8044EC6E5CF2F698E1FE570A36824B05", hash_generated_method = "85E3C8082001435C8B2A91B92D4CBB7F")
    @DSModeled(DSC.SAFE)
    public int getSoLinger() throws SocketException {
        checkOpenAndCreate(true);
        Object value;
        value = impl.getOption(SocketOptions.SO_LINGER);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //Object value = impl.getOption(SocketOptions.SO_LINGER);
        //if (value instanceof Integer) {
            //return (Integer) value;
        //} else {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.294 -0400", hash_original_method = "49326126DE06A7EC2CFFBD7B3A14AE31", hash_generated_method = "147497DDA3C0596B7D0534FE10562520")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int getReceiveBufferSize() throws SocketException {
        checkOpenAndCreate(true);
        int var79D1B084DDFD041B24FC1B745ABBA44B_1617831490 = ((Integer) impl.getOption(SocketOptions.SO_RCVBUF));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Integer) impl.getOption(SocketOptions.SO_RCVBUF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.294 -0400", hash_original_method = "9FF5297C2B145A55844611E68CB98459", hash_generated_method = "AF67123599A75472ED6C69C89DCA8EC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int getSendBufferSize() throws SocketException {
        checkOpenAndCreate(true);
        int varCFC5A7023F175F2036FA0F4CD488B13F_2096247651 = ((Integer) impl.getOption(SocketOptions.SO_SNDBUF));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Integer) impl.getOption(SocketOptions.SO_SNDBUF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.294 -0400", hash_original_method = "7DAE79431B5F9BEF40635CDD183C2B59", hash_generated_method = "F95B0BC5637A0B1F7D04CBB700A0D5C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int getSoTimeout() throws SocketException {
        checkOpenAndCreate(true);
        int varD23880532528160F55707BB89A021C2D_195853117 = ((Integer) impl.getOption(SocketOptions.SO_TIMEOUT));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Integer) impl.getOption(SocketOptions.SO_TIMEOUT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.294 -0400", hash_original_method = "3F059C4060D675A8035CAA8B5017EE1E", hash_generated_method = "55AD9E8955C244929607F1AEA533109B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getTcpNoDelay() throws SocketException {
        checkOpenAndCreate(true);
        boolean var084D0845B8F25EFFBF84F2C2204185DB_25349451 = ((Boolean) impl.getOption(SocketOptions.TCP_NODELAY));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Boolean) impl.getOption(SocketOptions.TCP_NODELAY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.294 -0400", hash_original_method = "B94B1A38E8CA82DAB010EC0768F89732", hash_generated_method = "D8AC1A19BC048DA3B4C2792763666696")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setKeepAlive(boolean keepAlive) throws SocketException {
        dsTaint.addTaint(keepAlive);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.294 -0400", hash_original_method = "7DC30A2B7ED25A0941F90DF00E383A5A", hash_generated_method = "BAB4AF5A16325664A126C9AF8B2CAB2E")
    public static synchronized void setSocketImplFactory(SocketImplFactory fac) throws IOException {
        if (factory != null) {
            throw new SocketException("Factory already set");
        }
        factory = fac;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.294 -0400", hash_original_method = "AEB667B5DBC425D73D37135566ECC286", hash_generated_method = "E315FF47CB35080CC3FE61B26E32D780")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setSendBufferSize(int size) throws SocketException {
        dsTaint.addTaint(size);
        checkOpenAndCreate(true);
        {
            throw new IllegalArgumentException("size < 1");
        } //End block
        impl.setOption(SocketOptions.SO_SNDBUF, Integer.valueOf(size));
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //if (size < 1) {
            //throw new IllegalArgumentException("size < 1");
        //}
        //impl.setOption(SocketOptions.SO_SNDBUF, Integer.valueOf(size));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.294 -0400", hash_original_method = "1376DE896B8682F991877B7A17C5B3A4", hash_generated_method = "390F822044E71D6B7F421C0B1E5787F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setReceiveBufferSize(int size) throws SocketException {
        dsTaint.addTaint(size);
        checkOpenAndCreate(true);
        {
            throw new IllegalArgumentException("size < 1");
        } //End block
        impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //if (size < 1) {
            //throw new IllegalArgumentException("size < 1");
        //}
        //impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.294 -0400", hash_original_method = "89C38D96E5FBD4D1BD6CE4BD573A4473", hash_generated_method = "B189DD4C01C07FC401179D529F62CD5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSoLinger(boolean on, int timeout) throws SocketException {
        dsTaint.addTaint(on);
        dsTaint.addTaint(timeout);
        checkOpenAndCreate(true);
        {
            throw new IllegalArgumentException("timeout < 0");
        } //End block
        {
            impl.setOption(SocketOptions.SO_LINGER, Integer.valueOf(timeout));
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.294 -0400", hash_original_method = "EA919996CC1899AC4E781314DA47161A", hash_generated_method = "7854B573FED4D7C992C469D8B7E39281")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setSoTimeout(int timeout) throws SocketException {
        dsTaint.addTaint(timeout);
        checkOpenAndCreate(true);
        {
            throw new IllegalArgumentException("timeout < 0");
        } //End block
        impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(timeout));
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //if (timeout < 0) {
            //throw new IllegalArgumentException("timeout < 0");
        //}
        //impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.294 -0400", hash_original_method = "04E6A4AAAA03D3C2F3E4334A66D2F7A1", hash_generated_method = "DCCAC64F0D2E0EDAC80DED6AB28AA524")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTcpNoDelay(boolean on) throws SocketException {
        dsTaint.addTaint(on);
        checkOpenAndCreate(true);
        impl.setOption(SocketOptions.TCP_NODELAY, Boolean.valueOf(on));
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //impl.setOption(SocketOptions.TCP_NODELAY, Boolean.valueOf(on));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.295 -0400", hash_original_method = "20DD1F1CA9EDC17BE2B90F2B7E5FF655", hash_generated_method = "DD8E49C45469CC4DD2667977CFC67498")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void startupSocket(InetAddress dstAddress, int dstPort,
            InetAddress localAddress, int localPort, boolean streaming) throws IOException {
        dsTaint.addTaint(streaming);
        dsTaint.addTaint(dstPort);
        dsTaint.addTaint(localAddress.dsTaint);
        dsTaint.addTaint(dstAddress.dsTaint);
        dsTaint.addTaint(localPort);
        {
            throw new IllegalArgumentException("Local port out of range: " + localPort);
        } //End block
        InetAddress addr;
        addr = Inet4Address.ANY;
        addr = localAddress;
        {
            impl.create(streaming);
            isCreated = true;
            try 
            {
                {
                    boolean var2212C8D76AB677AF4319CDF4B542D69A_1164046323 = (!streaming || !usingSocks());
                    {
                        impl.bind(addr, localPort);
                    } //End block
                } //End collapsed parenthetic
                isBound = true;
                impl.connect(dstAddress, dstPort);
                isConnected = true;
                cacheLocalAddress();
            } //End block
            catch (IOException e)
            {
                impl.close();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.295 -0400", hash_original_method = "933F73796CB698722A986AC13FC9BFF8", hash_generated_method = "204A72BFBF5D733E6DC205C31A1336ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean usingSocks() {
        boolean var78F22D973B8E4232A59324CAA691F0AB_1910786763 = (proxy != null && proxy.type() == Proxy.Type.SOCKS);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return proxy != null && proxy.type() == Proxy.Type.SOCKS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.295 -0400", hash_original_method = "881D40A46B027F3EDC8B30A9F4F44097", hash_generated_method = "33EBAB91770A57929F37649F26ED69B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        {
            boolean var341AB6969DFD2927CA563855F9EEB77E_958198666 = (!isConnected());
        } //End collapsed parenthetic
        String var67CB0748F4AF03F234B44A1D88B67149_1396479598 = (impl.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (!isConnected()) {
            //return "Socket[unconnected]";
        //}
        //return impl.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.295 -0400", hash_original_method = "D21BBF88E7F4579ADC8933941E3433FA", hash_generated_method = "87C3A85FA0D95603E528679334074984")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void shutdownInput() throws IOException {
        {
            boolean var899D12471AFC16D8818224BE7B57500A_931248361 = (isInputShutdown());
            {
                throw new SocketException("Socket input is shutdown");
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.295 -0400", hash_original_method = "1AECC9ACE476BBC93D823FC75BDACBC6", hash_generated_method = "99D496473077DDF5A8CC0BDD15A822F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void shutdownOutput() throws IOException {
        {
            boolean var721D80F1B38A860A3B065E2E7DC6E012_1248649494 = (isOutputShutdown());
            {
                throw new SocketException("Socket output is shutdown");
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.295 -0400", hash_original_method = "80C03A9E4F151BE4271ACE586291D7DE", hash_generated_method = "35461E5017D8DBD2C8A7C4FE630F1DD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkOpenAndCreate(boolean create) throws SocketException {
        dsTaint.addTaint(create);
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_2008416331 = (isClosed());
            {
                throw new SocketException("Socket is closed");
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean varD001DA76880A087CD0A30FA1D399A199_2005713281 = (!isConnected());
                {
                    throw new SocketException("Socket is not connected");
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            try 
            {
                impl.create(true);
            } //End block
            catch (SocketException e)
            {
                throw e;
            } //End block
            catch (IOException e)
            {
                throw new SocketException(e.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.295 -0400", hash_original_method = "AE126A441E32CF7358FEDD7A95BAD391", hash_generated_method = "E60A82BC46A715E50484F10DBEF7B65A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketAddress getLocalSocketAddress() {
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_308987263 = (!isBound());
        } //End collapsed parenthetic
        SocketAddress varE8973B81723F65BA3AFB4C0B26311430_1778742575 = (new InetSocketAddress(getLocalAddress(), getLocalPort()));
        return (SocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!isBound()) {
            //return null;
        //}
        //return new InetSocketAddress(getLocalAddress(), getLocalPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.295 -0400", hash_original_method = "7C698472BF26D61A7917F4B5238C5FF7", hash_generated_method = "59AEDFDD39AFF9A0B5C6B63FB52C5FD6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketAddress getRemoteSocketAddress() {
        {
            boolean var341AB6969DFD2927CA563855F9EEB77E_87306027 = (!isConnected());
        } //End collapsed parenthetic
        SocketAddress varDB81ACDD6BC56209D58D7445A514F44A_2070101544 = (new InetSocketAddress(getInetAddress(), getPort()));
        return (SocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!isConnected()) {
            //return null;
        //}
        //return new InetSocketAddress(getInetAddress(), getPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.295 -0400", hash_original_method = "589AFDD4CA6BF38ABB5F59E26BB3DC6D", hash_generated_method = "71C24249871CE72B5BCEABAEC42F76D4")
    @DSModeled(DSC.SAFE)
    public boolean isBound() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isBound;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.295 -0400", hash_original_method = "B1255CDE181FFAAB8CB434FB98B99FFF", hash_generated_method = "5DC2781C54600BB4ADE7232F7B44C39C")
    @DSModeled(DSC.SAFE)
    public boolean isConnected() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isConnected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.295 -0400", hash_original_method = "2EEDDDEB8BA1CD500E3647BC397BF54F", hash_generated_method = "F57EE74D737F6E5DBA9F54953A0BCBE7")
    @DSModeled(DSC.SAFE)
    public boolean isClosed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isClosed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.296 -0400", hash_original_method = "9E3C378994EF9A4091E39D0FA34770F8", hash_generated_method = "E3401FA0BCB6CBD485EA69EDDB0F6EE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void bind(SocketAddress localAddr) throws IOException {
        dsTaint.addTaint(localAddr.dsTaint);
        checkOpenAndCreate(true);
        {
            boolean var508204320144CEB3F447DE9CCDB64480_1977788677 = (isBound());
            {
                throw new BindException("Socket is already bound");
            } //End block
        } //End collapsed parenthetic
        int port;
        port = 0;
        InetAddress addr;
        addr = Inet4Address.ANY;
        {
            {
                throw new IllegalArgumentException("Local address not an InetSocketAddress: " +
                        localAddr.getClass());
            } //End block
            InetSocketAddress inetAddr;
            inetAddr = (InetSocketAddress) localAddr;
            {
                boolean varC74AE0463916E813FB227E6D8242C56F_1615380468 = ((addr = inetAddr.getAddress()) == null);
                {
                    throw new UnknownHostException("Host is unresolved: " + inetAddr.getHostName());
                } //End block
            } //End collapsed parenthetic
            port = inetAddr.getPort();
        } //End block
        {
            try 
            {
                impl.bind(addr, port);
                isBound = true;
                cacheLocalAddress();
            } //End block
            catch (IOException e)
            {
                impl.close();
                throw e;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.296 -0400", hash_original_method = "B2F3815725658D73C0532A54E6C164BA", hash_generated_method = "99273FFAA547118BE57902691F45E90B")
    @DSModeled(DSC.SAFE)
    public void connect(SocketAddress remoteAddr) throws IOException {
        dsTaint.addTaint(remoteAddr.dsTaint);
        connect(remoteAddr, 0);
        // ---------- Original Method ----------
        //connect(remoteAddr, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.296 -0400", hash_original_method = "45EED4DE787227F7BEC68E335C7AA6E7", hash_generated_method = "CE5BB03BA4DBD5FD2EAAE66B8AF42EC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void connect(SocketAddress remoteAddr, int timeout) throws IOException {
        dsTaint.addTaint(timeout);
        dsTaint.addTaint(remoteAddr.dsTaint);
        checkOpenAndCreate(true);
        {
            throw new IllegalArgumentException("timeout < 0");
        } //End block
        {
            boolean var5153987C55DB41759ADC1D7527E9459D_1738358162 = (isConnected());
            {
                throw new SocketException("Already connected");
            } //End block
        } //End collapsed parenthetic
        {
            throw new IllegalArgumentException("remoteAddr == null");
        } //End block
        {
            throw new IllegalArgumentException("Remote address not an InetSocketAddress: " +
                    remoteAddr.getClass());
        } //End block
        InetSocketAddress inetAddr;
        inetAddr = (InetSocketAddress) remoteAddr;
        InetAddress addr;
        {
            boolean var3A90A8ECED80469E6C4DBC0D965BCC76_1266506459 = ((addr = inetAddr.getAddress()) == null);
            {
                throw new UnknownHostException("Host is unresolved: " + inetAddr.getHostName());
            } //End block
        } //End collapsed parenthetic
        int port;
        port = inetAddr.getPort();
        checkDestination(addr, port);
        {
            try 
            {
                {
                    boolean var51251543F279E208469B7565700B7E80_586274383 = (!isBound());
                    {
                        {
                            boolean var24AE71A7EC560AD214D100F7850BDFF8_257683531 = (!usingSocks());
                            {
                                impl.bind(Inet4Address.ANY, 0);
                            } //End block
                        } //End collapsed parenthetic
                        isBound = true;
                    } //End block
                } //End collapsed parenthetic
                impl.connect(remoteAddr, timeout);
                isConnected = true;
                cacheLocalAddress();
            } //End block
            catch (IOException e)
            {
                impl.close();
                throw e;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.296 -0400", hash_original_method = "2FA07403172C73A0B79A0DF7F37DEBFB", hash_generated_method = "CFD889822D2DD45372599729AC9BB962")
    @DSModeled(DSC.SAFE)
    public boolean isInputShutdown() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isInputShutdown;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.296 -0400", hash_original_method = "C1B1C01C4973B5698673C5D09FA67185", hash_generated_method = "AFA507D53E9CCE7769FA1F9FB83C0F68")
    @DSModeled(DSC.SAFE)
    public boolean isOutputShutdown() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isOutputShutdown;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.296 -0400", hash_original_method = "6CEA4E5A53899EBE8D1FD08F2FE40675", hash_generated_method = "87EE710B4DB8935C3BBBE523207E7CCD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setReuseAddress(boolean reuse) throws SocketException {
        dsTaint.addTaint(reuse);
        checkOpenAndCreate(true);
        impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.296 -0400", hash_original_method = "8D0919FD23B9A2472FC046E6B1704481", hash_generated_method = "22B8EFA4C21DD20A187FCE3D5E47DFF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getReuseAddress() throws SocketException {
        checkOpenAndCreate(true);
        boolean varCE142DF7D7C52AD31EFC3E546F2DD316_1633666836 = ((Boolean) impl.getOption(SocketOptions.SO_REUSEADDR));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Boolean) impl.getOption(SocketOptions.SO_REUSEADDR);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.296 -0400", hash_original_method = "8F9774180DF7F00524B2F69126E7F96E", hash_generated_method = "C0040B5732F51C952D73C057BB4F96BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOOBInline(boolean oobinline) throws SocketException {
        dsTaint.addTaint(oobinline);
        checkOpenAndCreate(true);
        impl.setOption(SocketOptions.SO_OOBINLINE, Boolean.valueOf(oobinline));
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //impl.setOption(SocketOptions.SO_OOBINLINE, Boolean.valueOf(oobinline));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.296 -0400", hash_original_method = "A307BAC96AD0AD9185D724CFFBC60918", hash_generated_method = "663776CF0BA5F52CA231B351C084D882")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getOOBInline() throws SocketException {
        checkOpenAndCreate(true);
        boolean varCB6AA2E4A86BFAA8F54C6C5D29BB281D_1793386318 = ((Boolean) impl.getOption(SocketOptions.SO_OOBINLINE));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Boolean) impl.getOption(SocketOptions.SO_OOBINLINE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.296 -0400", hash_original_method = "50A48D0E3EC8A723BC37542164C52A31", hash_generated_method = "BF634A97D1C58DC4F36FF2283C3C30CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTrafficClass(int value) throws SocketException {
        dsTaint.addTaint(value);
        checkOpenAndCreate(true);
        {
            throw new IllegalArgumentException();
        } //End block
        impl.setOption(SocketOptions.IP_TOS, Integer.valueOf(value));
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //if (value < 0 || value > 255) {
            //throw new IllegalArgumentException();
        //}
        //impl.setOption(SocketOptions.IP_TOS, Integer.valueOf(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.297 -0400", hash_original_method = "D7C7CF134B3FE725817BA2C07D220760", hash_generated_method = "E5E3A1C44495010E9A6C2571ABFC5E75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTrafficClass() throws SocketException {
        checkOpenAndCreate(true);
        int var9C2568077066805EC4361C5C54BBCF61_1446396980 = ((Integer) impl.getOption(SocketOptions.IP_TOS));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Integer) impl.getOption(SocketOptions.IP_TOS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.297 -0400", hash_original_method = "CBFC447F34929AC991DFFA20015F8279", hash_generated_method = "5B573AA9B86D8BC580EAA251B3606CAE")
    @DSModeled(DSC.SAFE)
    public void sendUrgentData(int value) throws IOException {
        dsTaint.addTaint(value);
        impl.sendUrgentData(value);
        // ---------- Original Method ----------
        //impl.sendUrgentData(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.297 -0400", hash_original_method = "21E3234EAE6C3F4479E6E7944641B8BE", hash_generated_method = "6AAE9CA9BEF341563D6C52D7C73A9F35")
    @DSModeled(DSC.SAFE)
     void accepted() {
        isCreated = isBound = isConnected = true;
        cacheLocalAddress();
        // ---------- Original Method ----------
        //isCreated = isBound = isConnected = true;
        //cacheLocalAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.297 -0400", hash_original_method = "95A7BF302299AFCDED7970E2F7424717", hash_generated_method = "1EBCB03E60ACD3FE3DC1E941B7D54E34")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void cacheLocalAddress() {
        this.localAddress = IoBridge.getSocketLocalAddress(impl.fd);
        // ---------- Original Method ----------
        //this.localAddress = IoBridge.getSocketLocalAddress(impl.fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.297 -0400", hash_original_method = "A7DB57A03C94477191BD1BBD8D530AC8", hash_generated_method = "B587A834250EC594368F7A9B2FF808D0")
    @DSModeled(DSC.SAFE)
    public SocketChannel getChannel() {
        return (SocketChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.297 -0400", hash_original_method = "90C19CEBA6BBC20B430C1F399D6443A6", hash_generated_method = "D6114CBE52C90CB90A9AC3950C7F82DB")
    @DSModeled(DSC.SAFE)
    public FileDescriptor getFileDescriptor$() {
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return impl.fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.297 -0400", hash_original_method = "EE4DCDA11944F25F3B6AAA6A92D8AD2F", hash_generated_method = "381FE2FA3234C0D77531C5FD7148371B")
    @DSModeled(DSC.SAFE)
    public void setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
        dsTaint.addTaint(latency);
        dsTaint.addTaint(connectionTime);
        dsTaint.addTaint(bandwidth);
        // ---------- Original Method ----------
    }

    
}


