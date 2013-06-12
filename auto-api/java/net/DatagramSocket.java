package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.517 -0400", hash_original_method = "600D2DC769AA1337C3E52515B77C9BA6", hash_generated_method = "BB78495BDEFC488D99D599D414CF4C4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DatagramSocket() throws SocketException {
        this(0);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.521 -0400", hash_original_method = "5C9F869A9F8E783507AEDF83BF8CB0B7", hash_generated_method = "5B12A812B46F5CA37353C2ECC549656E")
    @DSModeled(DSC.SAFE)
    public DatagramSocket(int aPort) throws SocketException {
        dsTaint.addTaint(aPort);
        checkPort(aPort);
        createSocket(aPort, Inet4Address.ANY);
        // ---------- Original Method ----------
        //checkPort(aPort);
        //createSocket(aPort, Inet4Address.ANY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.524 -0400", hash_original_method = "CB0AFEB195CAFC978B9076AC8691C2BF", hash_generated_method = "30C2F861C582632B134F271AC6DA64AC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.528 -0400", hash_original_method = "8791E60C190AA1CE5F0CD19BC0C9D10B", hash_generated_method = "704598E6D81977CD6E4A33CB3626B1DF")
    @DSModeled(DSC.SAFE)
    protected DatagramSocket(DatagramSocketImpl socketImpl) {
        dsTaint.addTaint(socketImpl.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        // ---------- Original Method ----------
        //if (socketImpl == null) {
            //throw new NullPointerException();
        //}
        //impl = socketImpl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.535 -0400", hash_original_method = "F9D705BC16951CA970DD006A85C9F283", hash_generated_method = "E60F9CC1A0B2465F84B5CB0665661D92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DatagramSocket(SocketAddress localAddr) throws SocketException {
        dsTaint.addTaint(localAddr.dsTaint);
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Local address not an InetSocketAddress: " +
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
                if (DroidSafeAndroidRuntime.control) throw e;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.543 -0400", hash_original_method = "70ACB9C2984CE075C85AFFAB4CC3F2C3", hash_generated_method = "B841F64BE09EF8D4C74691257D99D52F")
    @DSModeled(DSC.SAFE)
    private void checkPort(int aPort) {
        dsTaint.addTaint(aPort);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Port out of range: " + aPort);
        } //End block
        // ---------- Original Method ----------
        //if (aPort < 0 || aPort > 65535) {
            //throw new IllegalArgumentException("Port out of range: " + aPort);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.545 -0400", hash_original_method = "613628CBB35065AE6B36DA8B5C0D3152", hash_generated_method = "2ECF992A972832EC92E9692E2C928238")
    @DSModeled(DSC.SAFE)
    public void close() {
        isClosed = true;
        impl.close();
        // ---------- Original Method ----------
        //isClosed = true;
        //impl.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.548 -0400", hash_original_method = "53DC6FE247829A3F8E1E61F886EC8A69", hash_generated_method = "DA8B89B17010C299A14FDF2129238847")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void disconnect() {
        {
            boolean var7A0895E165322EB228A34E837EE13B5D_103229399 = (isClosed() || !isConnected());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.552 -0400", hash_original_method = "CDBEDFAF0027896E1E3D56B522D080D1", hash_generated_method = "543CD44E080EEAC623C5F40B9D02E22E")
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
            if (DroidSafeAndroidRuntime.control) throw e;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.554 -0400", hash_original_method = "9059089CB1C35AC3C53D636B58746A1E", hash_generated_method = "800B58DDC8600607D8EE651B474CDE1E")
    @DSModeled(DSC.SAFE)
    public InetAddress getInetAddress() {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.557 -0400", hash_original_method = "120EDBD12BFFA2CD78689E1CCCEFC0A6", hash_generated_method = "B27004C58DFAF5819016EF413769F43D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InetAddress getLocalAddress() {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_1241301534 = (isClosed());
        } //End collapsed parenthetic
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_124116077 = (!isBound());
        } //End collapsed parenthetic
        InetAddress var6357496FA1ECBD3F9D037674C1BDD418_735844599 = (impl.getLocalAddress());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.561 -0400", hash_original_method = "C20A7438B6018D8C8B6C316459831E1B", hash_generated_method = "664010C6886CFB1459B138FBBC0C2FEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLocalPort() {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_1699399042 = (isClosed());
        } //End collapsed parenthetic
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_359828186 = (!isBound());
        } //End collapsed parenthetic
        int var5201144B0B742B3A152781D672D1AA30_40836503 = (impl.getLocalPort());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.563 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "17AF8596D6B7DC38593E7C5BC3B81881")
    @DSModeled(DSC.SAFE)
    public int getPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.564 -0400", hash_original_method = "4991C56903C24C085B034589D2617CA7", hash_generated_method = "A7379A9DB59AB1B2F6DE1CFA05AF1CB6")
    @DSModeled(DSC.SAFE)
     boolean isMulticastSocket() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.566 -0400", hash_original_method = "1025A74ACDCA065D38BE1D18813D43DB", hash_generated_method = "B8FDE8807C54395080EB7999BC8702D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int getReceiveBufferSize() throws SocketException {
        checkOpen();
        int var879D57EDA18A262547327AC0C51A7315_777251582 = (((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.569 -0400", hash_original_method = "D220B9D2C157A98A9F2FC338F369BDAA", hash_generated_method = "97640D882524F0548810E1F9188058A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int getSendBufferSize() throws SocketException {
        checkOpen();
        int var3BBCE4DA0E6FB31CEB590594F23B0AFE_1439167247 = (((Integer) impl.getOption(SocketOptions.SO_SNDBUF)).intValue());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Integer) impl.getOption(SocketOptions.SO_SNDBUF)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.571 -0400", hash_original_method = "E87267C7B03A68795BE159270DE33B7D", hash_generated_method = "A6FE818758A18EA621036FFEAFB15CF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int getSoTimeout() throws SocketException {
        checkOpen();
        int var97D6E04E407212E66322CDB8618B167A_2040557772 = (((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.577 -0400", hash_original_method = "C2244B28A3A8977EAD72461E3F35998B", hash_generated_method = "9EAD7059663FD4F0A1EFF9C4B0A66164")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void receive(DatagramPacket pack) throws IOException {
        dsTaint.addTaint(pack.dsTaint);
        checkOpen();
        ensureBound();
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new SocketException("Pending connect failure", pendingConnectException);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.588 -0400", hash_original_method = "F0676E3BCA654DF56D2BFA1EDDBDFD76", hash_generated_method = "3A71C36293B764F9930CF65CB7E90BF0")
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
                    boolean varEDA02A2B6453C8934EEF171F4AFFA587_443694602 = (!address.equals(packAddr) || port != pack.getPort());
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Packet address mismatch with connected address");
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
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Destination address is null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.594 -0400", hash_original_method = "3874DFBADA775207309D591B6CC4D492", hash_generated_method = "5A666D5C932E52ED3CD676F165B851CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setNetworkInterface(NetworkInterface netInterface) throws SocketException {
        dsTaint.addTaint(netInterface.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("networkInterface == null");
        } //End block
        try 
        {
            Libcore.os.setsockoptIfreq(impl.fd, SOL_SOCKET, SO_BINDTODEVICE, netInterface.getName());
        } //End block
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsSocketException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.602 -0400", hash_original_method = "6C822EF02E72BD5A5151B1066B41A106", hash_generated_method = "F33E036573C1123AF26750A080494C6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setSendBufferSize(int size) throws SocketException {
        dsTaint.addTaint(size);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size < 1");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.606 -0400", hash_original_method = "568C48DC36A6A663E7303E35F30B9F65", hash_generated_method = "9E2A30E8ACCC68CCB134AD16461A7643")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setReceiveBufferSize(int size) throws SocketException {
        dsTaint.addTaint(size);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size < 1");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.608 -0400", hash_original_method = "FEB39AD74968ADEBB5E7B7804953C3DE", hash_generated_method = "A40C4C4C66EA0AE7EA172AFACD0D7F05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setSoTimeout(int timeout) throws SocketException {
        dsTaint.addTaint(timeout);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("timeout < 0");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.610 -0400", hash_original_method = "337B8C84F2B3E10DBD586CDE880C9EA3", hash_generated_method = "683BB4EB4831349482C70992DF5D1120")
    public static synchronized void setDatagramSocketImplFactory(DatagramSocketImplFactory fac) throws IOException {
        if (factory != null) {
            throw new SocketException("Factory already set");
        }
        factory = fac;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.611 -0400", hash_original_method = "8DC54C39C6445BAF3181407C830C5887", hash_generated_method = "64A943988C56AAC10B3E45A2C0FD0A75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void checkOpen() throws SocketException {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_2013780752 = (isClosed());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket is closed");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isClosed()) {
            //throw new SocketException("Socket is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.613 -0400", hash_original_method = "1B212BFD5D3AE863EDBC7C1325928232", hash_generated_method = "6AE39BD1E2AE140B45AF700D442AF0E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void ensureBound() throws SocketException {
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_245314139 = (!isBound());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.615 -0400", hash_original_method = "3D56D66452A7B2D7ED073824CEA46ED8", hash_generated_method = "C2AF04C6990B0944C223E65D12E5DB8B")
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
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Local address not an InetSocketAddress: " +
                        localAddr.getClass());
            } //End block
            InetSocketAddress inetAddr;
            inetAddr = (InetSocketAddress) localAddr;
            addr = inetAddr.getAddress();
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Host is unresolved: " + inetAddr.getHostName());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.618 -0400", hash_original_method = "3DB10BF2A6A48B73F2119F41843D9D33", hash_generated_method = "7CDBD2CE94723C1EE69B6FBAC5A9B45C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void connect(SocketAddress peer) throws SocketException {
        dsTaint.addTaint(peer.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("peer == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("peer not an InetSocketAddress: " + peer.getClass());
        } //End block
        InetSocketAddress isa;
        isa = (InetSocketAddress) peer;
        {
            boolean var94908F4406976F47F480E81F35A6256E_1254475056 = (isa.getAddress() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Host is unresolved: " + isa.getHostName());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.620 -0400", hash_original_method = "9E27C6FD502F0359DB781EB2FF7E2BA4", hash_generated_method = "D8CC6AD93619764CD630482FE3D3FF1B")
    @DSModeled(DSC.SAFE)
    public void connect(InetAddress address, int port) {
        dsTaint.addTaint(port);
        dsTaint.addTaint(address.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("address == null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.622 -0400", hash_original_method = "589AFDD4CA6BF38ABB5F59E26BB3DC6D", hash_generated_method = "71C24249871CE72B5BCEABAEC42F76D4")
    @DSModeled(DSC.SAFE)
    public boolean isBound() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isBound;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.623 -0400", hash_original_method = "B1255CDE181FFAAB8CB434FB98B99FFF", hash_generated_method = "5DC2781C54600BB4ADE7232F7B44C39C")
    @DSModeled(DSC.SAFE)
    public boolean isConnected() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isConnected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.624 -0400", hash_original_method = "7C698472BF26D61A7917F4B5238C5FF7", hash_generated_method = "CE954F05E2FDC6AD9736B4D509B3F621")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketAddress getRemoteSocketAddress() {
        {
            boolean var341AB6969DFD2927CA563855F9EEB77E_1678113012 = (!isConnected());
        } //End collapsed parenthetic
        SocketAddress varDB81ACDD6BC56209D58D7445A514F44A_674966286 = (new InetSocketAddress(getInetAddress(), getPort()));
        return (SocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!isConnected()) {
            //return null;
        //}
        //return new InetSocketAddress(getInetAddress(), getPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.626 -0400", hash_original_method = "AE126A441E32CF7358FEDD7A95BAD391", hash_generated_method = "15437DA93FB47A96453E9E8BC6C49EE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketAddress getLocalSocketAddress() {
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_167773981 = (!isBound());
        } //End collapsed parenthetic
        SocketAddress varE8973B81723F65BA3AFB4C0B26311430_1206203234 = (new InetSocketAddress(getLocalAddress(), getLocalPort()));
        return (SocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!isBound()) {
            //return null;
        //}
        //return new InetSocketAddress(getLocalAddress(), getLocalPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.627 -0400", hash_original_method = "D6CD69E67882E49578E557811A0FC457", hash_generated_method = "FE895CC7DF5341F874F3FB374349DD89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setReuseAddress(boolean reuse) throws SocketException {
        dsTaint.addTaint(reuse);
        checkOpen();
        impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
        // ---------- Original Method ----------
        //checkOpen();
        //impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.629 -0400", hash_original_method = "8920D58954E3583481E89192EF874E86", hash_generated_method = "F04D80097917E370E7B54C82BE4074AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getReuseAddress() throws SocketException {
        checkOpen();
        boolean var92F4A5EAF76459C680E3D19F2BDB3A81_362772650 = (((Boolean) impl.getOption(SocketOptions.SO_REUSEADDR)).booleanValue());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Boolean) impl.getOption(SocketOptions.SO_REUSEADDR)).booleanValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.630 -0400", hash_original_method = "16BACAE92585B22CC8D47D482CFB74B4", hash_generated_method = "12D5D4A09CB1E2C7C7035168269F1032")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBroadcast(boolean broadcast) throws SocketException {
        dsTaint.addTaint(broadcast);
        checkOpen();
        impl.setOption(SocketOptions.SO_BROADCAST, Boolean.valueOf(broadcast));
        // ---------- Original Method ----------
        //checkOpen();
        //impl.setOption(SocketOptions.SO_BROADCAST, Boolean.valueOf(broadcast));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.632 -0400", hash_original_method = "2CF01D838FE277D7A2E75EEBFE7DA27F", hash_generated_method = "D9124B4E9DD4655DEADA3BF26202D028")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getBroadcast() throws SocketException {
        checkOpen();
        boolean var9ED914C1E7DCBED1C7993433295C6E96_126561792 = (((Boolean) impl.getOption(SocketOptions.SO_BROADCAST)).booleanValue());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Boolean) impl.getOption(SocketOptions.SO_BROADCAST)).booleanValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.635 -0400", hash_original_method = "2EC80086B0B75FB75EFBAAF12E210751", hash_generated_method = "E4F69583386F75BFADB2579DE1F91493")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTrafficClass(int value) throws SocketException {
        dsTaint.addTaint(value);
        checkOpen();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        impl.setOption(SocketOptions.IP_TOS, Integer.valueOf(value));
        // ---------- Original Method ----------
        //checkOpen();
        //if (value < 0 || value > 255) {
            //throw new IllegalArgumentException();
        //}
        //impl.setOption(SocketOptions.IP_TOS, Integer.valueOf(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.637 -0400", hash_original_method = "2A65749565A2F95D7C49F3E7C9DCBDEC", hash_generated_method = "5516BFC90E684A981821B78FD2FA6E53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTrafficClass() throws SocketException {
        checkOpen();
        int var9C2568077066805EC4361C5C54BBCF61_1053457625 = ((Integer) impl.getOption(SocketOptions.IP_TOS));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpen();
        //return (Integer) impl.getOption(SocketOptions.IP_TOS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.642 -0400", hash_original_method = "2EEDDDEB8BA1CD500E3647BC397BF54F", hash_generated_method = "F57EE74D737F6E5DBA9F54953A0BCBE7")
    @DSModeled(DSC.SAFE)
    public boolean isClosed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isClosed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.643 -0400", hash_original_method = "4DA7A00C8A23C7197F09A02190FE9E45", hash_generated_method = "E7E2881663016014A0A5AA79A022E451")
    @DSModeled(DSC.SAFE)
    public DatagramChannel getChannel() {
        return (DatagramChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:42:21.644 -0400", hash_original_method = "90C19CEBA6BBC20B430C1F399D6443A6", hash_generated_method = "5B73BDF397916789ED2DC2E6F7669072")
    @DSModeled(DSC.SAFE)
    public final FileDescriptor getFileDescriptor$() {
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return impl.fd;
    }

    
}


