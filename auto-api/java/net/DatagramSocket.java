package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.DatagramChannel;
import libcore.io.ErrnoException;
import libcore.io.Libcore;
import static libcore.io.OsConstants.*;

public class DatagramSocket {
    DatagramSocketImpl impl;
    InetAddress address;
    int port = -1;
    static DatagramSocketImplFactory factory;
    boolean isBound = false;
    private boolean isConnected = false;
    private SocketException pendingConnectException;
    private boolean isClosed = false;
    private Object lock = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.195 -0400", hash_original_method = "600D2DC769AA1337C3E52515B77C9BA6", hash_generated_method = "BB78495BDEFC488D99D599D414CF4C4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DatagramSocket() throws SocketException {
        this(0);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.195 -0400", hash_original_method = "5C9F869A9F8E783507AEDF83BF8CB0B7", hash_generated_method = "5B12A812B46F5CA37353C2ECC549656E")
    @DSModeled(DSC.SAFE)
    public DatagramSocket(int aPort) throws SocketException {
        dsTaint.addTaint(aPort);
        checkPort(aPort);
        createSocket(aPort, Inet4Address.ANY);
        // ---------- Original Method ----------
        //checkPort(aPort);
        //createSocket(aPort, Inet4Address.ANY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.195 -0400", hash_original_method = "CB0AFEB195CAFC978B9076AC8691C2BF", hash_generated_method = "30C2F861C582632B134F271AC6DA64AC")
    @DSModeled(DSC.SAFE)
    public DatagramSocket(int aPort, InetAddress addr) throws SocketException {
        dsTaint.addTaint(addr.dsTaint);
        dsTaint.addTaint(aPort);
        checkPort(aPort);
        createSocket(aPort, (addr == null) ? Inet4Address.ANY : addr);
        // ---------- Original Method ----------
        //checkPort(aPort);
        //createSocket(aPort, (addr == null) ? Inet4Address.ANY : addr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.195 -0400", hash_original_method = "8791E60C190AA1CE5F0CD19BC0C9D10B", hash_generated_method = "30EDE10F21A1C465CECE0ABBDA65044B")
    @DSModeled(DSC.SAFE)
    protected DatagramSocket(DatagramSocketImpl socketImpl) {
        dsTaint.addTaint(socketImpl.dsTaint);
        {
            throw new NullPointerException();
        } //End block
        // ---------- Original Method ----------
        //if (socketImpl == null) {
            //throw new NullPointerException();
        //}
        //impl = socketImpl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.195 -0400", hash_original_method = "F9D705BC16951CA970DD006A85C9F283", hash_generated_method = "B461E32334D705ED103013DBE64CF8B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DatagramSocket(SocketAddress localAddr) throws SocketException {
        dsTaint.addTaint(localAddr.dsTaint);
        {
            {
                throw new IllegalArgumentException("Local address not an InetSocketAddress: " +
                        localAddr.getClass());
            } //End block
            checkPort(((InetSocketAddress) localAddr).getPort());
        } //End block
        impl = factory != null ? factory.createDatagramSocketImpl()
                : new PlainDatagramSocketImpl();
        impl.create();
        {
            try 
            {
                bind(localAddr);
            } //End block
            catch (SocketException e)
            {
                close();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.195 -0400", hash_original_method = "70ACB9C2984CE075C85AFFAB4CC3F2C3", hash_generated_method = "91DE07787792725107AC6CF644D821DD")
    @DSModeled(DSC.SAFE)
    private void checkPort(int aPort) {
        dsTaint.addTaint(aPort);
        {
            throw new IllegalArgumentException("Port out of range: " + aPort);
        } //End block
        // ---------- Original Method ----------
        //if (aPort < 0 || aPort > 65535) {
            //throw new IllegalArgumentException("Port out of range: " + aPort);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.195 -0400", hash_original_method = "613628CBB35065AE6B36DA8B5C0D3152", hash_generated_method = "2ECF992A972832EC92E9692E2C928238")
    @DSModeled(DSC.SAFE)
    public void close() {
        isClosed = true;
        impl.close();
        // ---------- Original Method ----------
        //isClosed = true;
        //impl.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.195 -0400", hash_original_method = "53DC6FE247829A3F8E1E61F886EC8A69", hash_generated_method = "2F397EE439821083CE74D6519EA08AF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void disconnect() {
        {
            boolean var7A0895E165322EB228A34E837EE13B5D_935317516 = (isClosed() || !isConnected());
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.195 -0400", hash_original_method = "CDBEDFAF0027896E1E3D56B522D080D1", hash_generated_method = "F8F4AFD3294D27130AAC74FB950832E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void createSocket(int aPort, InetAddress addr) throws SocketException {
        dsTaint.addTaint(addr.dsTaint);
        dsTaint.addTaint(aPort);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.195 -0400", hash_original_method = "9059089CB1C35AC3C53D636B58746A1E", hash_generated_method = "800B58DDC8600607D8EE651B474CDE1E")
    @DSModeled(DSC.SAFE)
    public InetAddress getInetAddress() {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.195 -0400", hash_original_method = "120EDBD12BFFA2CD78689E1CCCEFC0A6", hash_generated_method = "28323E85BEFEB8C727AC6D188FCB3EC9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InetAddress getLocalAddress() {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_1575362029 = (isClosed());
        } //End collapsed parenthetic
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_2111531553 = (!isBound());
        } //End collapsed parenthetic
        InetAddress var6357496FA1ECBD3F9D037674C1BDD418_1750124339 = (impl.getLocalAddress());
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (isClosed()) {
            //return null;
        //}
        //if (!isBound()) {
            //return Inet4Address.ANY;
        //}
        //return impl.getLocalAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.196 -0400", hash_original_method = "C20A7438B6018D8C8B6C316459831E1B", hash_generated_method = "2679BB3BD310F435B6E503C4F0F966EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLocalPort() {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_279201826 = (isClosed());
        } //End collapsed parenthetic
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_1216675569 = (!isBound());
        } //End collapsed parenthetic
        int var5201144B0B742B3A152781D672D1AA30_300135048 = (impl.getLocalPort());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (isClosed()) {
            //return -1;
        //}
        //if (!isBound()) {
            //return 0;
        //}
        //return impl.getLocalPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.196 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "17AF8596D6B7DC38593E7C5BC3B81881")
    @DSModeled(DSC.SAFE)
    public int getPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.196 -0400", hash_original_method = "4991C56903C24C085B034589D2617CA7", hash_generated_method = "A7379A9DB59AB1B2F6DE1CFA05AF1CB6")
    @DSModeled(DSC.SAFE)
     boolean isMulticastSocket() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.196 -0400", hash_original_method = "1025A74ACDCA065D38BE1D18813D43DB", hash_generated_method = "7BB77F11C01E0482491824ECDBC85C2A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int getReceiveBufferSize() throws SocketException {
        checkOpen();
        int var879D57EDA18A262547327AC0C51A7315_715219519 = (((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.196 -0400", hash_original_method = "D220B9D2C157A98A9F2FC338F369BDAA", hash_generated_method = "418E5498F398175A623FFB67820BF9D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int getSendBufferSize() throws SocketException {
        checkOpen();
        int var3BBCE4DA0E6FB31CEB590594F23B0AFE_1063572994 = (((Integer) impl.getOption(SocketOptions.SO_SNDBUF)).intValue());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Integer) impl.getOption(SocketOptions.SO_SNDBUF)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.196 -0400", hash_original_method = "E87267C7B03A68795BE159270DE33B7D", hash_generated_method = "8D40E2217745BAB94D29473A21A48978")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int getSoTimeout() throws SocketException {
        checkOpen();
        int var97D6E04E407212E66322CDB8618B167A_244146763 = (((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.196 -0400", hash_original_method = "C2244B28A3A8977EAD72461E3F35998B", hash_generated_method = "BCCFA2D0A77668F3674D6F29C41533F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void receive(DatagramPacket pack) throws IOException {
        dsTaint.addTaint(pack.dsTaint);
        checkOpen();
        ensureBound();
        {
            throw new NullPointerException();
        } //End block
        {
            throw new SocketException("Pending connect failure", pendingConnectException);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.196 -0400", hash_original_method = "F0676E3BCA654DF56D2BFA1EDDBDFD76", hash_generated_method = "ED8E4C98F61869D461E4D3D9A24E09D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void send(DatagramPacket pack) throws IOException {
        dsTaint.addTaint(pack.dsTaint);
        checkOpen();
        ensureBound();
        InetAddress packAddr;
        packAddr = pack.getAddress();
        {
            {
                {
                    boolean varEDA02A2B6453C8934EEF171F4AFFA587_1325986923 = (!address.equals(packAddr) || port != pack.getPort());
                    {
                        throw new IllegalArgumentException("Packet address mismatch with connected address");
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                pack.setAddress(address);
                pack.setPort(port);
            } //End block
        } //End block
        {
            {
                throw new NullPointerException("Destination address is null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.196 -0400", hash_original_method = "3874DFBADA775207309D591B6CC4D492", hash_generated_method = "AEA220FF8FD57DFF31F1037495D0B9B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setNetworkInterface(NetworkInterface netInterface) throws SocketException {
        dsTaint.addTaint(netInterface.dsTaint);
        {
            throw new NullPointerException("networkInterface == null");
        } //End block
        try 
        {
            Libcore.os.setsockoptIfreq(impl.fd, SOL_SOCKET, SO_BINDTODEVICE, netInterface.getName());
        } //End block
        catch (ErrnoException errnoException)
        {
            throw errnoException.rethrowAsSocketException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.196 -0400", hash_original_method = "6C822EF02E72BD5A5151B1066B41A106", hash_generated_method = "985321D7E5697A487CE2A160DA0DE475")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setSendBufferSize(int size) throws SocketException {
        dsTaint.addTaint(size);
        {
            throw new IllegalArgumentException("size < 1");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.196 -0400", hash_original_method = "568C48DC36A6A663E7303E35F30B9F65", hash_generated_method = "7C900F4C98267887DF420189C794FB13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setReceiveBufferSize(int size) throws SocketException {
        dsTaint.addTaint(size);
        {
            throw new IllegalArgumentException("size < 1");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.197 -0400", hash_original_method = "FEB39AD74968ADEBB5E7B7804953C3DE", hash_generated_method = "57F472974B4CB0A2F55E900FE90EC99A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setSoTimeout(int timeout) throws SocketException {
        dsTaint.addTaint(timeout);
        {
            throw new IllegalArgumentException("timeout < 0");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.197 -0400", hash_original_method = "337B8C84F2B3E10DBD586CDE880C9EA3", hash_generated_method = "683BB4EB4831349482C70992DF5D1120")
    public static synchronized void setDatagramSocketImplFactory(DatagramSocketImplFactory fac) throws IOException {
        if (factory != null) {
            throw new SocketException("Factory already set");
        }
        factory = fac;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.197 -0400", hash_original_method = "8DC54C39C6445BAF3181407C830C5887", hash_generated_method = "AEDADEDAFBB0017761D916B6B572B3AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void checkOpen() throws SocketException {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_1709669163 = (isClosed());
            {
                throw new SocketException("Socket is closed");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isClosed()) {
            //throw new SocketException("Socket is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.197 -0400", hash_original_method = "1B212BFD5D3AE863EDBC7C1325928232", hash_generated_method = "B2CC2FDD5D0FFA28600D6525265B81BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void ensureBound() throws SocketException {
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_635636872 = (!isBound());
            {
                impl.bind(0, Inet4Address.ANY);
                isBound = true;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isBound()) {
            //impl.bind(0, Inet4Address.ANY);
            //isBound = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.197 -0400", hash_original_method = "3D56D66452A7B2D7ED073824CEA46ED8", hash_generated_method = "D8AD87EEFF6EE3EB91A0C3B4CE94F221")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void bind(SocketAddress localAddr) throws SocketException {
        dsTaint.addTaint(localAddr.dsTaint);
        checkOpen();
        int localPort;
        localPort = 0;
        InetAddress addr;
        addr = Inet4Address.ANY;
        {
            {
                throw new IllegalArgumentException("Local address not an InetSocketAddress: " +
                        localAddr.getClass());
            } //End block
            InetSocketAddress inetAddr;
            inetAddr = (InetSocketAddress) localAddr;
            addr = inetAddr.getAddress();
            {
                throw new SocketException("Host is unresolved: " + inetAddr.getHostName());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.197 -0400", hash_original_method = "3DB10BF2A6A48B73F2119F41843D9D33", hash_generated_method = "AE4F018AF490D3A9F76BB831E996B12B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void connect(SocketAddress peer) throws SocketException {
        dsTaint.addTaint(peer.dsTaint);
        {
            throw new IllegalArgumentException("peer == null");
        } //End block
        {
            throw new IllegalArgumentException("peer not an InetSocketAddress: " + peer.getClass());
        } //End block
        InetSocketAddress isa;
        isa = (InetSocketAddress) peer;
        {
            boolean var94908F4406976F47F480E81F35A6256E_1218751175 = (isa.getAddress() == null);
            {
                throw new SocketException("Host is unresolved: " + isa.getHostName());
            } //End block
        } //End collapsed parenthetic
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.197 -0400", hash_original_method = "9E27C6FD502F0359DB781EB2FF7E2BA4", hash_generated_method = "8B5ABAE46102AC0190D61F3A11D7D233")
    @DSModeled(DSC.SAFE)
    public void connect(InetAddress address, int port) {
        dsTaint.addTaint(port);
        dsTaint.addTaint(address.dsTaint);
        {
            throw new IllegalArgumentException("address == null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.197 -0400", hash_original_method = "589AFDD4CA6BF38ABB5F59E26BB3DC6D", hash_generated_method = "71C24249871CE72B5BCEABAEC42F76D4")
    @DSModeled(DSC.SAFE)
    public boolean isBound() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isBound;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.197 -0400", hash_original_method = "B1255CDE181FFAAB8CB434FB98B99FFF", hash_generated_method = "5DC2781C54600BB4ADE7232F7B44C39C")
    @DSModeled(DSC.SAFE)
    public boolean isConnected() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isConnected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.197 -0400", hash_original_method = "7C698472BF26D61A7917F4B5238C5FF7", hash_generated_method = "B032EE72A8FE13124D031DB67A88C41E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketAddress getRemoteSocketAddress() {
        {
            boolean var341AB6969DFD2927CA563855F9EEB77E_559048415 = (!isConnected());
        } //End collapsed parenthetic
        SocketAddress varDB81ACDD6BC56209D58D7445A514F44A_272970288 = (new InetSocketAddress(getInetAddress(), getPort()));
        return (SocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!isConnected()) {
            //return null;
        //}
        //return new InetSocketAddress(getInetAddress(), getPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.197 -0400", hash_original_method = "AE126A441E32CF7358FEDD7A95BAD391", hash_generated_method = "E709C8975483617DA7760A9CAB18F662")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketAddress getLocalSocketAddress() {
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_1629711443 = (!isBound());
        } //End collapsed parenthetic
        SocketAddress varE8973B81723F65BA3AFB4C0B26311430_159203497 = (new InetSocketAddress(getLocalAddress(), getLocalPort()));
        return (SocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!isBound()) {
            //return null;
        //}
        //return new InetSocketAddress(getLocalAddress(), getLocalPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.197 -0400", hash_original_method = "D6CD69E67882E49578E557811A0FC457", hash_generated_method = "FE895CC7DF5341F874F3FB374349DD89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setReuseAddress(boolean reuse) throws SocketException {
        dsTaint.addTaint(reuse);
        checkOpen();
        impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
        // ---------- Original Method ----------
        //checkOpen();
        //impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.198 -0400", hash_original_method = "8920D58954E3583481E89192EF874E86", hash_generated_method = "38334CAD5FDC88AE0F688A4BB317D8B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getReuseAddress() throws SocketException {
        checkOpen();
        boolean var92F4A5EAF76459C680E3D19F2BDB3A81_867124188 = (((Boolean) impl.getOption(SocketOptions.SO_REUSEADDR)).booleanValue());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Boolean) impl.getOption(SocketOptions.SO_REUSEADDR)).booleanValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.198 -0400", hash_original_method = "16BACAE92585B22CC8D47D482CFB74B4", hash_generated_method = "12D5D4A09CB1E2C7C7035168269F1032")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBroadcast(boolean broadcast) throws SocketException {
        dsTaint.addTaint(broadcast);
        checkOpen();
        impl.setOption(SocketOptions.SO_BROADCAST, Boolean.valueOf(broadcast));
        // ---------- Original Method ----------
        //checkOpen();
        //impl.setOption(SocketOptions.SO_BROADCAST, Boolean.valueOf(broadcast));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.198 -0400", hash_original_method = "2CF01D838FE277D7A2E75EEBFE7DA27F", hash_generated_method = "DE5DCD19442E59633770AE2D224564B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getBroadcast() throws SocketException {
        checkOpen();
        boolean var9ED914C1E7DCBED1C7993433295C6E96_748335731 = (((Boolean) impl.getOption(SocketOptions.SO_BROADCAST)).booleanValue());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Boolean) impl.getOption(SocketOptions.SO_BROADCAST)).booleanValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.198 -0400", hash_original_method = "2EC80086B0B75FB75EFBAAF12E210751", hash_generated_method = "162CE6EEBB46AF8BD81B65F2B87ED7CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTrafficClass(int value) throws SocketException {
        dsTaint.addTaint(value);
        checkOpen();
        {
            throw new IllegalArgumentException();
        } //End block
        impl.setOption(SocketOptions.IP_TOS, Integer.valueOf(value));
        // ---------- Original Method ----------
        //checkOpen();
        //if (value < 0 || value > 255) {
            //throw new IllegalArgumentException();
        //}
        //impl.setOption(SocketOptions.IP_TOS, Integer.valueOf(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.198 -0400", hash_original_method = "2A65749565A2F95D7C49F3E7C9DCBDEC", hash_generated_method = "546D8D478D1A6B1C98E3E09144B16B19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTrafficClass() throws SocketException {
        checkOpen();
        int var9C2568077066805EC4361C5C54BBCF61_1830151568 = ((Integer) impl.getOption(SocketOptions.IP_TOS));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpen();
        //return (Integer) impl.getOption(SocketOptions.IP_TOS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.198 -0400", hash_original_method = "2EEDDDEB8BA1CD500E3647BC397BF54F", hash_generated_method = "F57EE74D737F6E5DBA9F54953A0BCBE7")
    @DSModeled(DSC.SAFE)
    public boolean isClosed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isClosed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.198 -0400", hash_original_method = "4DA7A00C8A23C7197F09A02190FE9E45", hash_generated_method = "E7E2881663016014A0A5AA79A022E451")
    @DSModeled(DSC.SAFE)
    public DatagramChannel getChannel() {
        return (DatagramChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.198 -0400", hash_original_method = "90C19CEBA6BBC20B430C1F399D6443A6", hash_generated_method = "5B73BDF397916789ED2DC2E6F7669072")
    @DSModeled(DSC.SAFE)
    public final FileDescriptor getFileDescriptor$() {
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return impl.fd;
    }

    
}


