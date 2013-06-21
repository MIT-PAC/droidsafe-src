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
    boolean isBound = false;
    private boolean isConnected = false;
    private SocketException pendingConnectException;
    private boolean isClosed = false;
    private Object lock = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.778 -0400", hash_original_method = "600D2DC769AA1337C3E52515B77C9BA6", hash_generated_method = "834126E5D9F38C7E6D68D7A94139CCD5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DatagramSocket() throws SocketException {
        this(0);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.778 -0400", hash_original_method = "5C9F869A9F8E783507AEDF83BF8CB0B7", hash_generated_method = "E6607731195BA136E3A3E0233BF3A200")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DatagramSocket(int aPort) throws SocketException {
        dsTaint.addTaint(aPort);
        checkPort(aPort);
        createSocket(aPort, Inet4Address.ANY);
        // ---------- Original Method ----------
        //checkPort(aPort);
        //createSocket(aPort, Inet4Address.ANY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.778 -0400", hash_original_method = "CB0AFEB195CAFC978B9076AC8691C2BF", hash_generated_method = "29E3AD22F3A789B4BB72402B8C17B4A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DatagramSocket(int aPort, InetAddress addr) throws SocketException {
        dsTaint.addTaint(addr.dsTaint);
        dsTaint.addTaint(aPort);
        checkPort(aPort);
        createSocket(aPort, (addr == null) ? Inet4Address.ANY : addr);
        // ---------- Original Method ----------
        //checkPort(aPort);
        //createSocket(aPort, (addr == null) ? Inet4Address.ANY : addr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.778 -0400", hash_original_method = "8791E60C190AA1CE5F0CD19BC0C9D10B", hash_generated_method = "7F5DFC4582CE75C5EB7A1DBA3CDA0E4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.779 -0400", hash_original_method = "F9D705BC16951CA970DD006A85C9F283", hash_generated_method = "F9D0CBCC7E41E9DBFB4405CA2477E065")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.779 -0400", hash_original_method = "70ACB9C2984CE075C85AFFAB4CC3F2C3", hash_generated_method = "D6A363A31CB73952AD1A512C76CAB878")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.779 -0400", hash_original_method = "613628CBB35065AE6B36DA8B5C0D3152", hash_generated_method = "CEB5A5E4301107E97D1EEC22C66FA42C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() {
        isClosed = true;
        impl.close();
        // ---------- Original Method ----------
        //isClosed = true;
        //impl.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.779 -0400", hash_original_method = "53DC6FE247829A3F8E1E61F886EC8A69", hash_generated_method = "4E3C3648E4C854D8B194F2C43842A158")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void disconnect() {
        {
            boolean var7A0895E165322EB228A34E837EE13B5D_385289595 = (isClosed() || !isConnected());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.780 -0400", hash_original_method = "CDBEDFAF0027896E1E3D56B522D080D1", hash_generated_method = "A1CE51E532CB63F981D5BB24EDDB181B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.780 -0400", hash_original_method = "9059089CB1C35AC3C53D636B58746A1E", hash_generated_method = "86F4A0B1320B6FA35D6E3FEABC88044D")
    @DSModeled(DSC.SAFE)
    public InetAddress getInetAddress() {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.780 -0400", hash_original_method = "120EDBD12BFFA2CD78689E1CCCEFC0A6", hash_generated_method = "162EC0F12C8229633457581D8612C9D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InetAddress getLocalAddress() {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_1079457448 = (isClosed());
        } //End collapsed parenthetic
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_2088447283 = (!isBound());
        } //End collapsed parenthetic
        InetAddress var6357496FA1ECBD3F9D037674C1BDD418_1119554832 = (impl.getLocalAddress());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.780 -0400", hash_original_method = "C20A7438B6018D8C8B6C316459831E1B", hash_generated_method = "A7637784ACB0B00029043E0634D42269")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLocalPort() {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_11111252 = (isClosed());
        } //End collapsed parenthetic
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_1539725412 = (!isBound());
        } //End collapsed parenthetic
        int var5201144B0B742B3A152781D672D1AA30_1862411122 = (impl.getLocalPort());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.780 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "8BF4A6FA909B3C248D759F576AC567CD")
    @DSModeled(DSC.SAFE)
    public int getPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.781 -0400", hash_original_method = "4991C56903C24C085B034589D2617CA7", hash_generated_method = "BE3F27545C79AE58FF31FD6104FFB7FB")
    @DSModeled(DSC.SAFE)
     boolean isMulticastSocket() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.781 -0400", hash_original_method = "1025A74ACDCA065D38BE1D18813D43DB", hash_generated_method = "0DF98B881BA3F895BD68B7C3C47B34BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int getReceiveBufferSize() throws SocketException {
        checkOpen();
        int var879D57EDA18A262547327AC0C51A7315_251366330 = (((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.781 -0400", hash_original_method = "D220B9D2C157A98A9F2FC338F369BDAA", hash_generated_method = "FB8520ECEB85268C9793B5D485340315")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int getSendBufferSize() throws SocketException {
        checkOpen();
        int var3BBCE4DA0E6FB31CEB590594F23B0AFE_177861958 = (((Integer) impl.getOption(SocketOptions.SO_SNDBUF)).intValue());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Integer) impl.getOption(SocketOptions.SO_SNDBUF)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.781 -0400", hash_original_method = "E87267C7B03A68795BE159270DE33B7D", hash_generated_method = "47D4728D75733CCE5217CA9852772112")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int getSoTimeout() throws SocketException {
        checkOpen();
        int var97D6E04E407212E66322CDB8618B167A_141169556 = (((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.781 -0400", hash_original_method = "C2244B28A3A8977EAD72461E3F35998B", hash_generated_method = "789F0FB249821FCF970B1395F9CC8BA7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.782 -0400", hash_original_method = "F0676E3BCA654DF56D2BFA1EDDBDFD76", hash_generated_method = "5FC2969DEA349BC1A36D030D349DA5AE")
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
                    boolean varEDA02A2B6453C8934EEF171F4AFFA587_1466601767 = (!address.equals(packAddr) || port != pack.getPort());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.782 -0400", hash_original_method = "3874DFBADA775207309D591B6CC4D492", hash_generated_method = "EBB4F4B280B1E023606780DA746C18B5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.782 -0400", hash_original_method = "6C822EF02E72BD5A5151B1066B41A106", hash_generated_method = "053BE149B0BE1A61F08245AC21D8571C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.782 -0400", hash_original_method = "568C48DC36A6A663E7303E35F30B9F65", hash_generated_method = "9757B2F5EA72B33D43A57779E5DA51F9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.783 -0400", hash_original_method = "FEB39AD74968ADEBB5E7B7804953C3DE", hash_generated_method = "1E088F37FCCB474275A8E484E4B88424")
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

    
        public static synchronized void setDatagramSocketImplFactory(DatagramSocketImplFactory fac) throws IOException {
        if (factory != null) {
            throw new SocketException("Factory already set");
        }
        factory = fac;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.783 -0400", hash_original_method = "8DC54C39C6445BAF3181407C830C5887", hash_generated_method = "CD731EE71A955C7D1429CB95B86410DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void checkOpen() throws SocketException {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_1662353580 = (isClosed());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket is closed");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isClosed()) {
            //throw new SocketException("Socket is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.783 -0400", hash_original_method = "1B212BFD5D3AE863EDBC7C1325928232", hash_generated_method = "0A99442A0E61AD514E66CDDF1FF6EB4E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void ensureBound() throws SocketException {
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_259915877 = (!isBound());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.784 -0400", hash_original_method = "3D56D66452A7B2D7ED073824CEA46ED8", hash_generated_method = "20A5E51DC374412C7C6C1FEF34D6B6F0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.784 -0400", hash_original_method = "3DB10BF2A6A48B73F2119F41843D9D33", hash_generated_method = "C60EA909FEB6D09A2CF5A8DDD169C0A0")
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
            boolean var94908F4406976F47F480E81F35A6256E_348534559 = (isa.getAddress() == null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.785 -0400", hash_original_method = "9E27C6FD502F0359DB781EB2FF7E2BA4", hash_generated_method = "ABD21D53F0BF9197A9F005ADC9BD3A3B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.785 -0400", hash_original_method = "589AFDD4CA6BF38ABB5F59E26BB3DC6D", hash_generated_method = "CCD3B76B3D7072F4B37ED141BE36FE94")
    @DSModeled(DSC.SAFE)
    public boolean isBound() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isBound;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.785 -0400", hash_original_method = "B1255CDE181FFAAB8CB434FB98B99FFF", hash_generated_method = "FBF3F6085398606557CE4F96E6FE21BB")
    @DSModeled(DSC.SAFE)
    public boolean isConnected() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isConnected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.785 -0400", hash_original_method = "7C698472BF26D61A7917F4B5238C5FF7", hash_generated_method = "D377F44514F7FE2F6138F2336E0A4EB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketAddress getRemoteSocketAddress() {
        {
            boolean var341AB6969DFD2927CA563855F9EEB77E_1947773133 = (!isConnected());
        } //End collapsed parenthetic
        SocketAddress varDB81ACDD6BC56209D58D7445A514F44A_1377469605 = (new InetSocketAddress(getInetAddress(), getPort()));
        return (SocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!isConnected()) {
            //return null;
        //}
        //return new InetSocketAddress(getInetAddress(), getPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.785 -0400", hash_original_method = "AE126A441E32CF7358FEDD7A95BAD391", hash_generated_method = "97435B6EBC3B0459968ECDB63A9250BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketAddress getLocalSocketAddress() {
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_1306574633 = (!isBound());
        } //End collapsed parenthetic
        SocketAddress varE8973B81723F65BA3AFB4C0B26311430_113355941 = (new InetSocketAddress(getLocalAddress(), getLocalPort()));
        return (SocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!isBound()) {
            //return null;
        //}
        //return new InetSocketAddress(getLocalAddress(), getLocalPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.786 -0400", hash_original_method = "D6CD69E67882E49578E557811A0FC457", hash_generated_method = "58C6D809023590A20F1495459057AD04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setReuseAddress(boolean reuse) throws SocketException {
        dsTaint.addTaint(reuse);
        checkOpen();
        impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
        // ---------- Original Method ----------
        //checkOpen();
        //impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.786 -0400", hash_original_method = "8920D58954E3583481E89192EF874E86", hash_generated_method = "FDB4A1C4EBCD4FC16687EA7BE40D2198")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getReuseAddress() throws SocketException {
        checkOpen();
        boolean var92F4A5EAF76459C680E3D19F2BDB3A81_2132055134 = (((Boolean) impl.getOption(SocketOptions.SO_REUSEADDR)).booleanValue());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Boolean) impl.getOption(SocketOptions.SO_REUSEADDR)).booleanValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.786 -0400", hash_original_method = "16BACAE92585B22CC8D47D482CFB74B4", hash_generated_method = "D3CBD677D53E323DA4FCCBD2D3783D49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBroadcast(boolean broadcast) throws SocketException {
        dsTaint.addTaint(broadcast);
        checkOpen();
        impl.setOption(SocketOptions.SO_BROADCAST, Boolean.valueOf(broadcast));
        // ---------- Original Method ----------
        //checkOpen();
        //impl.setOption(SocketOptions.SO_BROADCAST, Boolean.valueOf(broadcast));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.786 -0400", hash_original_method = "2CF01D838FE277D7A2E75EEBFE7DA27F", hash_generated_method = "71DC4CCF81CE152A1A95C09A270BFAFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getBroadcast() throws SocketException {
        checkOpen();
        boolean var9ED914C1E7DCBED1C7993433295C6E96_817466272 = (((Boolean) impl.getOption(SocketOptions.SO_BROADCAST)).booleanValue());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Boolean) impl.getOption(SocketOptions.SO_BROADCAST)).booleanValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.786 -0400", hash_original_method = "2EC80086B0B75FB75EFBAAF12E210751", hash_generated_method = "97EAA1AA170F765B82703EAD2F982046")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.786 -0400", hash_original_method = "2A65749565A2F95D7C49F3E7C9DCBDEC", hash_generated_method = "EA6BB6D6D3F41B152CAD328A61921F1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTrafficClass() throws SocketException {
        checkOpen();
        int var9C2568077066805EC4361C5C54BBCF61_181696106 = ((Integer) impl.getOption(SocketOptions.IP_TOS));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpen();
        //return (Integer) impl.getOption(SocketOptions.IP_TOS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.787 -0400", hash_original_method = "2EEDDDEB8BA1CD500E3647BC397BF54F", hash_generated_method = "D8FADA936D54405ECC52CB2CA557F68D")
    @DSModeled(DSC.SAFE)
    public boolean isClosed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isClosed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.787 -0400", hash_original_method = "4DA7A00C8A23C7197F09A02190FE9E45", hash_generated_method = "B0E444DF25D872F72682A48974FB5252")
    @DSModeled(DSC.SAFE)
    public DatagramChannel getChannel() {
        return (DatagramChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.787 -0400", hash_original_method = "90C19CEBA6BBC20B430C1F399D6443A6", hash_generated_method = "E7B1F81EFC1F3CC647B4FF4B9FDA195F")
    @DSModeled(DSC.SAFE)
    public final FileDescriptor getFileDescriptor$() {
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return impl.fd;
    }

    
    static DatagramSocketImplFactory factory;
}

