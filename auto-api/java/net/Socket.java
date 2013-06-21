package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.SocketChannel;
import libcore.io.IoBridge;

public class Socket {
    SocketImpl impl;
    private Proxy proxy;
    volatile boolean isCreated = false;
    private boolean isBound = false;
    private boolean isConnected = false;
    private boolean isClosed = false;
    private boolean isInputShutdown = false;
    private boolean isOutputShutdown = false;
    private InetAddress localAddress = Inet4Address.ANY;
    private Object connectLock = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.113 -0400", hash_original_method = "DE6B6B5588954C6A35AB00A23B1617FE", hash_generated_method = "F670CC532C7B774247714814201AF5CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Socket() {
        this.impl = factory != null ? factory.createSocketImpl() : new PlainSocketImpl();
        this.proxy = null;
        // ---------- Original Method ----------
        //this.impl = factory != null ? factory.createSocketImpl() : new PlainSocketImpl();
        //this.proxy = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.113 -0400", hash_original_method = "903F698227E2205A08AC4EC3E6D912C3", hash_generated_method = "0728F84BBB656337113A562F9DEBC8DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Socket(Proxy proxy) {
        dsTaint.addTaint(proxy.dsTaint);
        {
            boolean varE5CF7C9644D24DC30510FF113B6FA9F4_516216826 = (proxy == null || proxy.type() == Proxy.Type.HTTP);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid proxy: " + proxy);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.113 -0400", hash_original_method = "59B1F76D08717F2A7DB6178659D1BD4D", hash_generated_method = "56D8913AA0461A61FD06E196225D1EB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Socket(String dstName, int dstPort) throws UnknownHostException, IOException {
        this(dstName, dstPort, null, 0);
        dsTaint.addTaint(dstPort);
        dsTaint.addTaint(dstName);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.114 -0400", hash_original_method = "7A6ED28BC12F5ABFF2F2CE0F9C5717C0", hash_generated_method = "435CB6E93B86E4EECA082CEA5CB59A52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Socket(String dstName, int dstPort, InetAddress localAddress, int localPort) throws IOException {
        this();
        dsTaint.addTaint(localAddress.dsTaint);
        dsTaint.addTaint(dstPort);
        dsTaint.addTaint(localPort);
        dsTaint.addTaint(dstName);
        tryAllAddresses(dstName, dstPort, localAddress, localPort, true);
        // ---------- Original Method ----------
        //tryAllAddresses(dstName, dstPort, localAddress, localPort, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.114 -0400", hash_original_method = "1948ABC1DE3B1C37A63093E998C50FE7", hash_generated_method = "3B6D7BF00DC456DBFEE30B636DFB30EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public Socket(String hostName, int port, boolean streaming) throws IOException {
        this();
        dsTaint.addTaint(streaming);
        dsTaint.addTaint(port);
        dsTaint.addTaint(hostName);
        tryAllAddresses(hostName, port, null, 0, streaming);
        // ---------- Original Method ----------
        //tryAllAddresses(hostName, port, null, 0, streaming);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.114 -0400", hash_original_method = "A1767A7E1F84ED40BDB339014C4851EF", hash_generated_method = "70E7EF5AC7113E8E69C8A8C81D761769")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.114 -0400", hash_original_method = "BE0D4569A05DA3EF578449A5DA65F5E7", hash_generated_method = "5D04B753B11B89B1289863D6588F0B49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Socket(InetAddress dstAddress, int dstPort,
            InetAddress localAddress, int localPort) throws IOException {
        this();
        dsTaint.addTaint(localAddress.dsTaint);
        dsTaint.addTaint(dstPort);
        dsTaint.addTaint(dstAddress.dsTaint);
        dsTaint.addTaint(localPort);
        checkDestination(dstAddress, dstPort);
        startupSocket(dstAddress, dstPort, localAddress, localPort, true);
        // ---------- Original Method ----------
        //checkDestination(dstAddress, dstPort);
        //startupSocket(dstAddress, dstPort, localAddress, localPort, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.114 -0400", hash_original_method = "D85BA2D34027734E343FA152CA6CE177", hash_generated_method = "A92018320C7AD16FCA9C736FB2DCB907")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public Socket(InetAddress addr, int port, boolean streaming) throws IOException {
        this();
        dsTaint.addTaint(streaming);
        dsTaint.addTaint(port);
        dsTaint.addTaint(addr.dsTaint);
        checkDestination(addr, port);
        startupSocket(addr, port, null, 0, streaming);
        // ---------- Original Method ----------
        //checkDestination(addr, port);
        //startupSocket(addr, port, null, 0, streaming);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.115 -0400", hash_original_method = "3BE6817A95031499261EFB4432AAFCBF", hash_generated_method = "4C5072D1728B46CDECC80F94C941B067")
    @DSModeled(DSC.SAFE)
    protected Socket(SocketImpl impl) throws SocketException {
        dsTaint.addTaint(impl.dsTaint);
        this.proxy = null;
        // ---------- Original Method ----------
        //this.impl = impl;
        //this.proxy = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.115 -0400", hash_original_method = "FE893551BF445ECD0CF959494571F82D", hash_generated_method = "F6BB34B468E4870C383A8E44061BEA4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void tryAllAddresses(String dstName, int dstPort, InetAddress
            localAddress, int localPort, boolean streaming) throws IOException {
        dsTaint.addTaint(streaming);
        dsTaint.addTaint(localAddress.dsTaint);
        dsTaint.addTaint(dstPort);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.115 -0400", hash_original_method = "B238EF3FEB62ADA205D3F3298560A137", hash_generated_method = "5EAA54347E9E00535865176C1C9D94DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkDestination(InetAddress destAddr, int dstPort) {
        dsTaint.addTaint(dstPort);
        dsTaint.addTaint(destAddr.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Port out of range: " + dstPort);
        } //End block
        // ---------- Original Method ----------
        //if (dstPort < 0 || dstPort > 65535) {
            //throw new IllegalArgumentException("Port out of range: " + dstPort);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.115 -0400", hash_original_method = "6609A304DB40C6FFC8F6AC783F01FDAC", hash_generated_method = "BEF433D9A28470F041DB000F7F9A5B35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void close() throws IOException {
        isClosed = true;
        localAddress = Inet4Address.ANY;
        impl.close();
        // ---------- Original Method ----------
        //isClosed = true;
        //localAddress = Inet4Address.ANY;
        //impl.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.116 -0400", hash_original_method = "084821CC0A1E0331CE4D2BB5EC46E415", hash_generated_method = "A067E4F27BC914C98663D83A21A80BBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InetAddress getInetAddress() {
        {
            boolean var341AB6969DFD2927CA563855F9EEB77E_242295765 = (!isConnected());
        } //End collapsed parenthetic
        InetAddress var8655A4EE53FB8FBE3B9196FE317ADFA6_1785279000 = (impl.getInetAddress());
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!isConnected()) {
            //return null;
        //}
        //return impl.getInetAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.116 -0400", hash_original_method = "83F4AB21434B41B13879E1F39D268878", hash_generated_method = "3297348B091F4961A93F4998D638AC47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputStream getInputStream() throws IOException {
        checkOpenAndCreate(false);
        {
            boolean var899D12471AFC16D8818224BE7B57500A_857768893 = (isInputShutdown());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket input is shutdown");
            } //End block
        } //End collapsed parenthetic
        InputStream varF6270A204F6CBA0922B73BE390C94FA8_724946625 = (impl.getInputStream());
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkOpenAndCreate(false);
        //if (isInputShutdown()) {
            //throw new SocketException("Socket input is shutdown");
        //}
        //return impl.getInputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.116 -0400", hash_original_method = "CB6F12AE5628FD4A044BF4AD41BFB963", hash_generated_method = "C1096B7BEDDB0BD8A019BDB5A771794A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getKeepAlive() throws SocketException {
        checkOpenAndCreate(true);
        boolean var041E463ADEEF0C23B09546F75815EDF9_875287459 = ((Boolean) impl.getOption(SocketOptions.SO_KEEPALIVE));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Boolean) impl.getOption(SocketOptions.SO_KEEPALIVE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.116 -0400", hash_original_method = "B81D9B2A12700622583B88DBCF07EC2E", hash_generated_method = "282806391874D3ACDF19FB4011D867D7")
    @DSModeled(DSC.SAFE)
    public InetAddress getLocalAddress() {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return localAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.116 -0400", hash_original_method = "F5BB694DF3469EBFBD82064FFB1FEAE0", hash_generated_method = "FB013510E241D05B64A606070D44C4FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLocalPort() {
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_1175895766 = (!isBound());
        } //End collapsed parenthetic
        int var5201144B0B742B3A152781D672D1AA30_1714594766 = (impl.getLocalPort());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (!isBound()) {
            //return -1;
        //}
        //return impl.getLocalPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.116 -0400", hash_original_method = "0AB25EAA0774AA81766D4356986FC34F", hash_generated_method = "4478E325B31C05ADD82D307AFDDB3BD3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OutputStream getOutputStream() throws IOException {
        checkOpenAndCreate(false);
        {
            boolean var721D80F1B38A860A3B065E2E7DC6E012_1170683125 = (isOutputShutdown());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket output is shutdown");
            } //End block
        } //End collapsed parenthetic
        OutputStream var3644B8EF59184DA0E1B22959A80C9115_32662782 = (impl.getOutputStream());
        return (OutputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkOpenAndCreate(false);
        //if (isOutputShutdown()) {
            //throw new SocketException("Socket output is shutdown");
        //}
        //return impl.getOutputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.117 -0400", hash_original_method = "0A0FE55C893091E17125D546A7D59C8C", hash_generated_method = "D33CBD312EA407F674103B95AE59A42C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPort() {
        {
            boolean var341AB6969DFD2927CA563855F9EEB77E_74928757 = (!isConnected());
        } //End collapsed parenthetic
        int var804FC545E664230B0744C92D9C1FC410_1063828551 = (impl.getPort());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (!isConnected()) {
            //return 0;
        //}
        //return impl.getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.117 -0400", hash_original_method = "8044EC6E5CF2F698E1FE570A36824B05", hash_generated_method = "A9059FB387B57D85E6960C62613FD5CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.117 -0400", hash_original_method = "49326126DE06A7EC2CFFBD7B3A14AE31", hash_generated_method = "B02949F5545411A7E4A6A544BAA241BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int getReceiveBufferSize() throws SocketException {
        checkOpenAndCreate(true);
        int var79D1B084DDFD041B24FC1B745ABBA44B_1995605264 = ((Integer) impl.getOption(SocketOptions.SO_RCVBUF));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Integer) impl.getOption(SocketOptions.SO_RCVBUF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.117 -0400", hash_original_method = "9FF5297C2B145A55844611E68CB98459", hash_generated_method = "9C6E5A7553433D2B078B2FA90B74EE6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int getSendBufferSize() throws SocketException {
        checkOpenAndCreate(true);
        int varCFC5A7023F175F2036FA0F4CD488B13F_2104111026 = ((Integer) impl.getOption(SocketOptions.SO_SNDBUF));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Integer) impl.getOption(SocketOptions.SO_SNDBUF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.118 -0400", hash_original_method = "7DAE79431B5F9BEF40635CDD183C2B59", hash_generated_method = "95B907F4A2C128435173564944AA6941")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int getSoTimeout() throws SocketException {
        checkOpenAndCreate(true);
        int varD23880532528160F55707BB89A021C2D_617798469 = ((Integer) impl.getOption(SocketOptions.SO_TIMEOUT));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Integer) impl.getOption(SocketOptions.SO_TIMEOUT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.118 -0400", hash_original_method = "3F059C4060D675A8035CAA8B5017EE1E", hash_generated_method = "F2228D39B3C865ECD62C1D9EA22E1661")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getTcpNoDelay() throws SocketException {
        checkOpenAndCreate(true);
        boolean var084D0845B8F25EFFBF84F2C2204185DB_148382744 = ((Boolean) impl.getOption(SocketOptions.TCP_NODELAY));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Boolean) impl.getOption(SocketOptions.TCP_NODELAY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.118 -0400", hash_original_method = "B94B1A38E8CA82DAB010EC0768F89732", hash_generated_method = "6B34F2066412F24D27CD23E91A775063")
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

    
        public static synchronized void setSocketImplFactory(SocketImplFactory fac) throws IOException {
        if (factory != null) {
            throw new SocketException("Factory already set");
        }
        factory = fac;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.118 -0400", hash_original_method = "AEB667B5DBC425D73D37135566ECC286", hash_generated_method = "718DD137B8CA093AF77DFF6187610498")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setSendBufferSize(int size) throws SocketException {
        dsTaint.addTaint(size);
        checkOpenAndCreate(true);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size < 1");
        } //End block
        impl.setOption(SocketOptions.SO_SNDBUF, Integer.valueOf(size));
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //if (size < 1) {
            //throw new IllegalArgumentException("size < 1");
        //}
        //impl.setOption(SocketOptions.SO_SNDBUF, Integer.valueOf(size));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.119 -0400", hash_original_method = "1376DE896B8682F991877B7A17C5B3A4", hash_generated_method = "9FB8FDDA4B3CE7203582FCABEF14C72F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setReceiveBufferSize(int size) throws SocketException {
        dsTaint.addTaint(size);
        checkOpenAndCreate(true);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size < 1");
        } //End block
        impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //if (size < 1) {
            //throw new IllegalArgumentException("size < 1");
        //}
        //impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.119 -0400", hash_original_method = "89C38D96E5FBD4D1BD6CE4BD573A4473", hash_generated_method = "839A9B53AB8A71C11E8AEB3F0276D219")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSoLinger(boolean on, int timeout) throws SocketException {
        dsTaint.addTaint(on);
        dsTaint.addTaint(timeout);
        checkOpenAndCreate(true);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("timeout < 0");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.119 -0400", hash_original_method = "EA919996CC1899AC4E781314DA47161A", hash_generated_method = "633E01468FF5FD859FEE9E57453E77A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setSoTimeout(int timeout) throws SocketException {
        dsTaint.addTaint(timeout);
        checkOpenAndCreate(true);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("timeout < 0");
        } //End block
        impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(timeout));
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //if (timeout < 0) {
            //throw new IllegalArgumentException("timeout < 0");
        //}
        //impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.119 -0400", hash_original_method = "04E6A4AAAA03D3C2F3E4334A66D2F7A1", hash_generated_method = "EB72AD39B6E1138F4F588C3BEFC1693E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTcpNoDelay(boolean on) throws SocketException {
        dsTaint.addTaint(on);
        checkOpenAndCreate(true);
        impl.setOption(SocketOptions.TCP_NODELAY, Boolean.valueOf(on));
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //impl.setOption(SocketOptions.TCP_NODELAY, Boolean.valueOf(on));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.120 -0400", hash_original_method = "20DD1F1CA9EDC17BE2B90F2B7E5FF655", hash_generated_method = "FAF41806A3BCD30E9D5EF51A7A033CE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void startupSocket(InetAddress dstAddress, int dstPort,
            InetAddress localAddress, int localPort, boolean streaming) throws IOException {
        dsTaint.addTaint(streaming);
        dsTaint.addTaint(localAddress.dsTaint);
        dsTaint.addTaint(dstPort);
        dsTaint.addTaint(dstAddress.dsTaint);
        dsTaint.addTaint(localPort);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Local port out of range: " + localPort);
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
                    boolean var2212C8D76AB677AF4319CDF4B542D69A_1247562129 = (!streaming || !usingSocks());
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
                if (DroidSafeAndroidRuntime.control) throw e;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.120 -0400", hash_original_method = "933F73796CB698722A986AC13FC9BFF8", hash_generated_method = "7832275082534ABC105159EDA1DFB2AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean usingSocks() {
        boolean var78F22D973B8E4232A59324CAA691F0AB_780403758 = (proxy != null && proxy.type() == Proxy.Type.SOCKS);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return proxy != null && proxy.type() == Proxy.Type.SOCKS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.120 -0400", hash_original_method = "881D40A46B027F3EDC8B30A9F4F44097", hash_generated_method = "1009F8086CCAACE4AA3CF2AB49C9D6C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        {
            boolean var341AB6969DFD2927CA563855F9EEB77E_1888557133 = (!isConnected());
        } //End collapsed parenthetic
        String var67CB0748F4AF03F234B44A1D88B67149_634588161 = (impl.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (!isConnected()) {
            //return "Socket[unconnected]";
        //}
        //return impl.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.120 -0400", hash_original_method = "D21BBF88E7F4579ADC8933941E3433FA", hash_generated_method = "E3E136346419B825ABC29B4F8D8BF9C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void shutdownInput() throws IOException {
        {
            boolean var899D12471AFC16D8818224BE7B57500A_825273077 = (isInputShutdown());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket input is shutdown");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.120 -0400", hash_original_method = "1AECC9ACE476BBC93D823FC75BDACBC6", hash_generated_method = "6A0E3D24E4FA26FE2CA74A2AC94E5F7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void shutdownOutput() throws IOException {
        {
            boolean var721D80F1B38A860A3B065E2E7DC6E012_62752618 = (isOutputShutdown());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket output is shutdown");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.121 -0400", hash_original_method = "80C03A9E4F151BE4271ACE586291D7DE", hash_generated_method = "AF8B371FE5F4AE39A0FECE04ACB28086")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkOpenAndCreate(boolean create) throws SocketException {
        dsTaint.addTaint(create);
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_2027970541 = (isClosed());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket is closed");
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean varD001DA76880A087CD0A30FA1D399A199_594348891 = (!isConnected());
                {
                    if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket is not connected");
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
                if (DroidSafeAndroidRuntime.control) throw e;
            } //End block
            catch (IOException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException(e.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.121 -0400", hash_original_method = "AE126A441E32CF7358FEDD7A95BAD391", hash_generated_method = "0FEAEFAE51894160BF5AAFDC898F0C7E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketAddress getLocalSocketAddress() {
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_2017661671 = (!isBound());
        } //End collapsed parenthetic
        SocketAddress varE8973B81723F65BA3AFB4C0B26311430_1165152623 = (new InetSocketAddress(getLocalAddress(), getLocalPort()));
        return (SocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!isBound()) {
            //return null;
        //}
        //return new InetSocketAddress(getLocalAddress(), getLocalPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.121 -0400", hash_original_method = "7C698472BF26D61A7917F4B5238C5FF7", hash_generated_method = "066633D041743A4FF10BC59179422A53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketAddress getRemoteSocketAddress() {
        {
            boolean var341AB6969DFD2927CA563855F9EEB77E_1974986592 = (!isConnected());
        } //End collapsed parenthetic
        SocketAddress varDB81ACDD6BC56209D58D7445A514F44A_1405997907 = (new InetSocketAddress(getInetAddress(), getPort()));
        return (SocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!isConnected()) {
            //return null;
        //}
        //return new InetSocketAddress(getInetAddress(), getPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.121 -0400", hash_original_method = "589AFDD4CA6BF38ABB5F59E26BB3DC6D", hash_generated_method = "CCD3B76B3D7072F4B37ED141BE36FE94")
    @DSModeled(DSC.SAFE)
    public boolean isBound() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isBound;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.121 -0400", hash_original_method = "B1255CDE181FFAAB8CB434FB98B99FFF", hash_generated_method = "FBF3F6085398606557CE4F96E6FE21BB")
    @DSModeled(DSC.SAFE)
    public boolean isConnected() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isConnected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.122 -0400", hash_original_method = "2EEDDDEB8BA1CD500E3647BC397BF54F", hash_generated_method = "D8FADA936D54405ECC52CB2CA557F68D")
    @DSModeled(DSC.SAFE)
    public boolean isClosed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isClosed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.122 -0400", hash_original_method = "9E3C378994EF9A4091E39D0FA34770F8", hash_generated_method = "2B06E878D0C560B7A1B9106B26384056")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void bind(SocketAddress localAddr) throws IOException {
        dsTaint.addTaint(localAddr.dsTaint);
        checkOpenAndCreate(true);
        {
            boolean var508204320144CEB3F447DE9CCDB64480_1081857002 = (isBound());
            {
                if (DroidSafeAndroidRuntime.control) throw new BindException("Socket is already bound");
            } //End block
        } //End collapsed parenthetic
        int port;
        port = 0;
        InetAddress addr;
        addr = Inet4Address.ANY;
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Local address not an InetSocketAddress: " +
                        localAddr.getClass());
            } //End block
            InetSocketAddress inetAddr;
            inetAddr = (InetSocketAddress) localAddr;
            {
                boolean varC74AE0463916E813FB227E6D8242C56F_2671247 = ((addr = inetAddr.getAddress()) == null);
                {
                    if (DroidSafeAndroidRuntime.control) throw new UnknownHostException("Host is unresolved: " + inetAddr.getHostName());
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
                if (DroidSafeAndroidRuntime.control) throw e;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.122 -0400", hash_original_method = "B2F3815725658D73C0532A54E6C164BA", hash_generated_method = "53361481ADFD26EDD53B60435C7B316E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void connect(SocketAddress remoteAddr) throws IOException {
        dsTaint.addTaint(remoteAddr.dsTaint);
        connect(remoteAddr, 0);
        // ---------- Original Method ----------
        //connect(remoteAddr, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.123 -0400", hash_original_method = "45EED4DE787227F7BEC68E335C7AA6E7", hash_generated_method = "CC2C516BB3F77902A5CDAA3D55190332")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void connect(SocketAddress remoteAddr, int timeout) throws IOException {
        dsTaint.addTaint(timeout);
        dsTaint.addTaint(remoteAddr.dsTaint);
        checkOpenAndCreate(true);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("timeout < 0");
        } //End block
        {
            boolean var5153987C55DB41759ADC1D7527E9459D_1459568576 = (isConnected());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Already connected");
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("remoteAddr == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Remote address not an InetSocketAddress: " +
                    remoteAddr.getClass());
        } //End block
        InetSocketAddress inetAddr;
        inetAddr = (InetSocketAddress) remoteAddr;
        InetAddress addr;
        {
            boolean var3A90A8ECED80469E6C4DBC0D965BCC76_230594296 = ((addr = inetAddr.getAddress()) == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new UnknownHostException("Host is unresolved: " + inetAddr.getHostName());
            } //End block
        } //End collapsed parenthetic
        int port;
        port = inetAddr.getPort();
        checkDestination(addr, port);
        {
            try 
            {
                {
                    boolean var51251543F279E208469B7565700B7E80_714710266 = (!isBound());
                    {
                        {
                            boolean var24AE71A7EC560AD214D100F7850BDFF8_1357939806 = (!usingSocks());
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
                if (DroidSafeAndroidRuntime.control) throw e;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.123 -0400", hash_original_method = "2FA07403172C73A0B79A0DF7F37DEBFB", hash_generated_method = "41F311BED71D2BACA242B899CA6C1B0E")
    @DSModeled(DSC.SAFE)
    public boolean isInputShutdown() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isInputShutdown;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.123 -0400", hash_original_method = "C1B1C01C4973B5698673C5D09FA67185", hash_generated_method = "5D37500ECA289CCA0916BD14CFBC075C")
    @DSModeled(DSC.SAFE)
    public boolean isOutputShutdown() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isOutputShutdown;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.123 -0400", hash_original_method = "6CEA4E5A53899EBE8D1FD08F2FE40675", hash_generated_method = "01CDB0391B2DABB107A7E986B2ACF223")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setReuseAddress(boolean reuse) throws SocketException {
        dsTaint.addTaint(reuse);
        checkOpenAndCreate(true);
        impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.123 -0400", hash_original_method = "8D0919FD23B9A2472FC046E6B1704481", hash_generated_method = "996ACCC1785C9CF5627900708D0F6A91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getReuseAddress() throws SocketException {
        checkOpenAndCreate(true);
        boolean varCE142DF7D7C52AD31EFC3E546F2DD316_1973349515 = ((Boolean) impl.getOption(SocketOptions.SO_REUSEADDR));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Boolean) impl.getOption(SocketOptions.SO_REUSEADDR);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.123 -0400", hash_original_method = "8F9774180DF7F00524B2F69126E7F96E", hash_generated_method = "86F6938CA1294B37290A1C6CA5122FDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOOBInline(boolean oobinline) throws SocketException {
        dsTaint.addTaint(oobinline);
        checkOpenAndCreate(true);
        impl.setOption(SocketOptions.SO_OOBINLINE, Boolean.valueOf(oobinline));
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //impl.setOption(SocketOptions.SO_OOBINLINE, Boolean.valueOf(oobinline));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.124 -0400", hash_original_method = "A307BAC96AD0AD9185D724CFFBC60918", hash_generated_method = "BF988059064F8B1C75D636A1FAFFF332")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getOOBInline() throws SocketException {
        checkOpenAndCreate(true);
        boolean varCB6AA2E4A86BFAA8F54C6C5D29BB281D_46127610 = ((Boolean) impl.getOption(SocketOptions.SO_OOBINLINE));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Boolean) impl.getOption(SocketOptions.SO_OOBINLINE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.124 -0400", hash_original_method = "50A48D0E3EC8A723BC37542164C52A31", hash_generated_method = "5ACDF88A8935797DFBF4C61BA5F7B082")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTrafficClass(int value) throws SocketException {
        dsTaint.addTaint(value);
        checkOpenAndCreate(true);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        impl.setOption(SocketOptions.IP_TOS, Integer.valueOf(value));
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //if (value < 0 || value > 255) {
            //throw new IllegalArgumentException();
        //}
        //impl.setOption(SocketOptions.IP_TOS, Integer.valueOf(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.124 -0400", hash_original_method = "D7C7CF134B3FE725817BA2C07D220760", hash_generated_method = "885C861787BBC7C8A6F5F782B788FE43")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTrafficClass() throws SocketException {
        checkOpenAndCreate(true);
        int var9C2568077066805EC4361C5C54BBCF61_364563018 = ((Integer) impl.getOption(SocketOptions.IP_TOS));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Integer) impl.getOption(SocketOptions.IP_TOS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.124 -0400", hash_original_method = "CBFC447F34929AC991DFFA20015F8279", hash_generated_method = "8FA797D1AFF24C1A791AB8329B92B0BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendUrgentData(int value) throws IOException {
        dsTaint.addTaint(value);
        impl.sendUrgentData(value);
        // ---------- Original Method ----------
        //impl.sendUrgentData(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.124 -0400", hash_original_method = "21E3234EAE6C3F4479E6E7944641B8BE", hash_generated_method = "7AA833B05FB6D1983035B8C7720A9AD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void accepted() {
        isCreated = isBound = isConnected = true;
        cacheLocalAddress();
        // ---------- Original Method ----------
        //isCreated = isBound = isConnected = true;
        //cacheLocalAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.124 -0400", hash_original_method = "95A7BF302299AFCDED7970E2F7424717", hash_generated_method = "794BDF12835FAD96C22BC1E6B513ECB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void cacheLocalAddress() {
        this.localAddress = IoBridge.getSocketLocalAddress(impl.fd);
        // ---------- Original Method ----------
        //this.localAddress = IoBridge.getSocketLocalAddress(impl.fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.125 -0400", hash_original_method = "A7DB57A03C94477191BD1BBD8D530AC8", hash_generated_method = "8CEE1B37CDACC210206AF5456A18AAF2")
    @DSModeled(DSC.SAFE)
    public SocketChannel getChannel() {
        return (SocketChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.125 -0400", hash_original_method = "90C19CEBA6BBC20B430C1F399D6443A6", hash_generated_method = "47D52E78C52778AB2E4D037C8A697F9B")
    @DSModeled(DSC.SAFE)
    public FileDescriptor getFileDescriptor$() {
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return impl.fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.125 -0400", hash_original_method = "EE4DCDA11944F25F3B6AAA6A92D8AD2F", hash_generated_method = "7F88DEDF5F3C4CD498A7DDF91ACC9522")
    @DSModeled(DSC.SAFE)
    public void setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
        dsTaint.addTaint(latency);
        dsTaint.addTaint(connectionTime);
        dsTaint.addTaint(bandwidth);
        // ---------- Original Method ----------
    }

    
    private static SocketImplFactory factory;
}

