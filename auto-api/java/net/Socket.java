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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.015 -0400", hash_original_field = "86CCEC3D9FF0E9C0514506E982CDC08B", hash_generated_field = "76382137C184A183F2BF2D8583A90AEC")

    SocketImpl impl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.015 -0400", hash_original_field = "431387EB7262E1CFC79B125EB8A67C60", hash_generated_field = "EE0BB8F1739D62A5A5C8EDF7D478A66B")

    private Proxy proxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.015 -0400", hash_original_field = "13A225F92ADD388C574A88D897639BF0", hash_generated_field = "FEFE85DE55A57D0EBA9EA9B6592B8458")

    volatile boolean isCreated = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.015 -0400", hash_original_field = "1EA05BED8F3F3741889B40C4407A936D", hash_generated_field = "AD4F2B698EC37BEC9EEE873CE57E921D")

    private boolean isBound = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.015 -0400", hash_original_field = "F0F0EDCF28D811EA172AA0A0A89A5056", hash_generated_field = "058DE1E699A3B3D187FC9E15DB7EC3B5")

    private boolean isConnected = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.015 -0400", hash_original_field = "7624DFAF468575D3B7DCE21DA2796711", hash_generated_field = "2CBEAC942D14DA48C324142BCB214C18")

    private boolean isClosed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.015 -0400", hash_original_field = "0053D23938B36B6B0E64039CAC6D2249", hash_generated_field = "7BF3C47813946CC98E6B4F51776BE0B2")

    private boolean isInputShutdown = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.015 -0400", hash_original_field = "6C6248A8DD1927E15E037A0AC6FBF72E", hash_generated_field = "155847C1017F44FA011CC3F03B209D80")

    private boolean isOutputShutdown = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.015 -0400", hash_original_field = "F3693398E061FDE89394A9CA0324D131", hash_generated_field = "A8E9D68398963C6A7BD51AC2BEC0E3CA")

    private InetAddress localAddress = Inet4Address.ANY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.015 -0400", hash_original_field = "D8DB2CE733667EE503E654EFAFD74F2D", hash_generated_field = "E2D69D0AB0B204CA044B48B69D7865B1")

    private Object connectLock = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.029 -0400", hash_original_method = "DE6B6B5588954C6A35AB00A23B1617FE", hash_generated_method = "F670CC532C7B774247714814201AF5CC")
    public  Socket() {
        this.impl = factory != null ? factory.createSocketImpl() : new PlainSocketImpl();
        this.proxy = null;
        // ---------- Original Method ----------
        //this.impl = factory != null ? factory.createSocketImpl() : new PlainSocketImpl();
        //this.proxy = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.029 -0400", hash_original_method = "903F698227E2205A08AC4EC3E6D912C3", hash_generated_method = "0604535BE77D7923A66A4863D996EE3B")
    public  Socket(Proxy proxy) {
        {
            boolean varE5CF7C9644D24DC30510FF113B6FA9F4_1452862659 = (proxy == null || proxy.type() == Proxy.Type.HTTP);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid proxy: " + proxy);
            } //End block
        } //End collapsed parenthetic
        this.proxy = proxy;
        this.impl = factory != null ? factory.createSocketImpl() : new PlainSocketImpl(proxy);
        // ---------- Original Method ----------
        //if (proxy == null || proxy.type() == Proxy.Type.HTTP) {
            //throw new IllegalArgumentException("Invalid proxy: " + proxy);
        //}
        //this.proxy = proxy;
        //this.impl = factory != null ? factory.createSocketImpl() : new PlainSocketImpl(proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.029 -0400", hash_original_method = "59B1F76D08717F2A7DB6178659D1BD4D", hash_generated_method = "AADABF6745F6C5D22552775E7610A6F8")
    public  Socket(String dstName, int dstPort) throws UnknownHostException, IOException {
        this(dstName, dstPort, null, 0);
        addTaint(dstName.getTaint());
        addTaint(dstPort);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.030 -0400", hash_original_method = "7A6ED28BC12F5ABFF2F2CE0F9C5717C0", hash_generated_method = "E4F2AFA2FC83A5E81D1404EC0F71C06F")
    public  Socket(String dstName, int dstPort, InetAddress localAddress, int localPort) throws IOException {
        this();
        tryAllAddresses(dstName, dstPort, localAddress, localPort, true);
        addTaint(dstName.getTaint());
        addTaint(dstPort);
        addTaint(localAddress.getTaint());
        addTaint(localPort);
        // ---------- Original Method ----------
        //tryAllAddresses(dstName, dstPort, localAddress, localPort, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.030 -0400", hash_original_method = "1948ABC1DE3B1C37A63093E998C50FE7", hash_generated_method = "CADDDF35FAF5C5BEEC2A7FC7A5CA3E22")
    @Deprecated
    public  Socket(String hostName, int port, boolean streaming) throws IOException {
        this();
        tryAllAddresses(hostName, port, null, 0, streaming);
        addTaint(hostName.getTaint());
        addTaint(port);
        addTaint(streaming);
        // ---------- Original Method ----------
        //tryAllAddresses(hostName, port, null, 0, streaming);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.030 -0400", hash_original_method = "A1767A7E1F84ED40BDB339014C4851EF", hash_generated_method = "1D6848D5716D426BF6BC1F43CC8F380D")
    public  Socket(InetAddress dstAddress, int dstPort) throws IOException {
        this();
        checkDestination(dstAddress, dstPort);
        startupSocket(dstAddress, dstPort, null, 0, true);
        addTaint(dstAddress.getTaint());
        addTaint(dstPort);
        // ---------- Original Method ----------
        //checkDestination(dstAddress, dstPort);
        //startupSocket(dstAddress, dstPort, null, 0, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.030 -0400", hash_original_method = "BE0D4569A05DA3EF578449A5DA65F5E7", hash_generated_method = "A9549D4A380BFE595E1EACCC92A8B863")
    public  Socket(InetAddress dstAddress, int dstPort,
            InetAddress localAddress, int localPort) throws IOException {
        this();
        checkDestination(dstAddress, dstPort);
        startupSocket(dstAddress, dstPort, localAddress, localPort, true);
        addTaint(dstAddress.getTaint());
        addTaint(dstPort);
        addTaint(localAddress.getTaint());
        addTaint(localPort);
        // ---------- Original Method ----------
        //checkDestination(dstAddress, dstPort);
        //startupSocket(dstAddress, dstPort, localAddress, localPort, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.031 -0400", hash_original_method = "D85BA2D34027734E343FA152CA6CE177", hash_generated_method = "223751D3E50BA5186914A4C53138EE0D")
    @Deprecated
    public  Socket(InetAddress addr, int port, boolean streaming) throws IOException {
        this();
        checkDestination(addr, port);
        startupSocket(addr, port, null, 0, streaming);
        addTaint(addr.getTaint());
        addTaint(port);
        addTaint(streaming);
        // ---------- Original Method ----------
        //checkDestination(addr, port);
        //startupSocket(addr, port, null, 0, streaming);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.031 -0400", hash_original_method = "3BE6817A95031499261EFB4432AAFCBF", hash_generated_method = "79C2133882AE5B1F458B3CC625641B92")
    protected  Socket(SocketImpl impl) throws SocketException {
        this.impl = impl;
        this.proxy = null;
        // ---------- Original Method ----------
        //this.impl = impl;
        //this.proxy = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.032 -0400", hash_original_method = "FE893551BF445ECD0CF959494571F82D", hash_generated_method = "CD3ED9A5BC9E05FF6A7BC6D03BB4717A")
    private void tryAllAddresses(String dstName, int dstPort, InetAddress
            localAddress, int localPort, boolean streaming) throws IOException {
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
        addTaint(dstName.getTaint());
        addTaint(dstPort);
        addTaint(localAddress.getTaint());
        addTaint(localPort);
        addTaint(streaming);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.033 -0400", hash_original_method = "B238EF3FEB62ADA205D3F3298560A137", hash_generated_method = "CCD1F3E72DDE675BBB40BE0FF11DA93A")
    private void checkDestination(InetAddress destAddr, int dstPort) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Port out of range: " + dstPort);
        } //End block
        addTaint(destAddr.getTaint());
        addTaint(dstPort);
        // ---------- Original Method ----------
        //if (dstPort < 0 || dstPort > 65535) {
            //throw new IllegalArgumentException("Port out of range: " + dstPort);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.037 -0400", hash_original_method = "6609A304DB40C6FFC8F6AC783F01FDAC", hash_generated_method = "BEF433D9A28470F041DB000F7F9A5B35")
    public synchronized void close() throws IOException {
        isClosed = true;
        localAddress = Inet4Address.ANY;
        impl.close();
        // ---------- Original Method ----------
        //isClosed = true;
        //localAddress = Inet4Address.ANY;
        //impl.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.054 -0400", hash_original_method = "084821CC0A1E0331CE4D2BB5EC46E415", hash_generated_method = "62E4B01E74E9D04DCF699B905ACD1A5F")
    public InetAddress getInetAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_187762328 = null; //Variable for return #1
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_2009462016 = null; //Variable for return #2
        {
            boolean var341AB6969DFD2927CA563855F9EEB77E_616096878 = (!isConnected());
            {
                varB4EAC82CA7396A68D541C85D26508E83_187762328 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2009462016 = impl.getInetAddress();
        InetAddress varA7E53CE21691AB073D9660D615818899_2018702886; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2018702886 = varB4EAC82CA7396A68D541C85D26508E83_187762328;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2018702886 = varB4EAC82CA7396A68D541C85D26508E83_2009462016;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2018702886.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2018702886;
        // ---------- Original Method ----------
        //if (!isConnected()) {
            //return null;
        //}
        //return impl.getInetAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.055 -0400", hash_original_method = "83F4AB21434B41B13879E1F39D268878", hash_generated_method = "B36F8627D958F465AD6E68B9E1341F92")
    public InputStream getInputStream() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1388281551 = null; //Variable for return #1
        checkOpenAndCreate(false);
        {
            boolean var899D12471AFC16D8818224BE7B57500A_1329815282 = (isInputShutdown());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket input is shutdown");
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1388281551 = impl.getInputStream();
        varB4EAC82CA7396A68D541C85D26508E83_1388281551.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1388281551;
        // ---------- Original Method ----------
        //checkOpenAndCreate(false);
        //if (isInputShutdown()) {
            //throw new SocketException("Socket input is shutdown");
        //}
        //return impl.getInputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.055 -0400", hash_original_method = "CB6F12AE5628FD4A044BF4AD41BFB963", hash_generated_method = "131CAF65BC88D11CBD23CED25EEA3A42")
    public boolean getKeepAlive() throws SocketException {
        checkOpenAndCreate(true);
        boolean var041E463ADEEF0C23B09546F75815EDF9_1762400850 = ((Boolean) impl.getOption(SocketOptions.SO_KEEPALIVE));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1474797505 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1474797505;
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Boolean) impl.getOption(SocketOptions.SO_KEEPALIVE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.056 -0400", hash_original_method = "B81D9B2A12700622583B88DBCF07EC2E", hash_generated_method = "0A2FBACE2AD745AF1D0D8677161A4746")
    public InetAddress getLocalAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1870025214 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1870025214 = localAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1870025214.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1870025214;
        // ---------- Original Method ----------
        //return localAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.057 -0400", hash_original_method = "F5BB694DF3469EBFBD82064FFB1FEAE0", hash_generated_method = "80CB388E8F11DDE136C78AF5700FF766")
    public int getLocalPort() {
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_2111036215 = (!isBound());
        } //End collapsed parenthetic
        int var5201144B0B742B3A152781D672D1AA30_1225320503 = (impl.getLocalPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_75492029 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_75492029;
        // ---------- Original Method ----------
        //if (!isBound()) {
            //return -1;
        //}
        //return impl.getLocalPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.076 -0400", hash_original_method = "0AB25EAA0774AA81766D4356986FC34F", hash_generated_method = "5E9AB2C34C0B24C92ED42DC19D6161E4")
    public OutputStream getOutputStream() throws IOException {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_829647614 = null; //Variable for return #1
        checkOpenAndCreate(false);
        {
            boolean var721D80F1B38A860A3B065E2E7DC6E012_219156369 = (isOutputShutdown());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket output is shutdown");
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_829647614 = impl.getOutputStream();
        varB4EAC82CA7396A68D541C85D26508E83_829647614.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_829647614;
        // ---------- Original Method ----------
        //checkOpenAndCreate(false);
        //if (isOutputShutdown()) {
            //throw new SocketException("Socket output is shutdown");
        //}
        //return impl.getOutputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.076 -0400", hash_original_method = "0A0FE55C893091E17125D546A7D59C8C", hash_generated_method = "0ACE7E7939610F9C419893F20089460B")
    public int getPort() {
        {
            boolean var341AB6969DFD2927CA563855F9EEB77E_193687767 = (!isConnected());
        } //End collapsed parenthetic
        int var804FC545E664230B0744C92D9C1FC410_223543890 = (impl.getPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_85939241 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_85939241;
        // ---------- Original Method ----------
        //if (!isConnected()) {
            //return 0;
        //}
        //return impl.getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.076 -0400", hash_original_method = "8044EC6E5CF2F698E1FE570A36824B05", hash_generated_method = "D8460D86B1F9854725D28DADA6A66363")
    public int getSoLinger() throws SocketException {
        checkOpenAndCreate(true);
        Object value;
        value = impl.getOption(SocketOptions.SO_LINGER);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1540349191 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1540349191;
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //Object value = impl.getOption(SocketOptions.SO_LINGER);
        //if (value instanceof Integer) {
            //return (Integer) value;
        //} else {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.077 -0400", hash_original_method = "49326126DE06A7EC2CFFBD7B3A14AE31", hash_generated_method = "CB4F5BFCFDFA04031496895903A52D6D")
    public synchronized int getReceiveBufferSize() throws SocketException {
        checkOpenAndCreate(true);
        int var79D1B084DDFD041B24FC1B745ABBA44B_1554528651 = ((Integer) impl.getOption(SocketOptions.SO_RCVBUF));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1756552484 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1756552484;
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Integer) impl.getOption(SocketOptions.SO_RCVBUF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.077 -0400", hash_original_method = "9FF5297C2B145A55844611E68CB98459", hash_generated_method = "76C0A655FFECE4B0CAE5B0D7166BDE3A")
    public synchronized int getSendBufferSize() throws SocketException {
        checkOpenAndCreate(true);
        int varCFC5A7023F175F2036FA0F4CD488B13F_1311984524 = ((Integer) impl.getOption(SocketOptions.SO_SNDBUF));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_980591435 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_980591435;
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Integer) impl.getOption(SocketOptions.SO_SNDBUF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.077 -0400", hash_original_method = "7DAE79431B5F9BEF40635CDD183C2B59", hash_generated_method = "CA5E8797A79838DC260A248308E43660")
    public synchronized int getSoTimeout() throws SocketException {
        checkOpenAndCreate(true);
        int varD23880532528160F55707BB89A021C2D_896809957 = ((Integer) impl.getOption(SocketOptions.SO_TIMEOUT));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2090337060 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2090337060;
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Integer) impl.getOption(SocketOptions.SO_TIMEOUT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.078 -0400", hash_original_method = "3F059C4060D675A8035CAA8B5017EE1E", hash_generated_method = "CB1B68536FF1D9D6ADB04FB86F4C1B3E")
    public boolean getTcpNoDelay() throws SocketException {
        checkOpenAndCreate(true);
        boolean var084D0845B8F25EFFBF84F2C2204185DB_1156826990 = ((Boolean) impl.getOption(SocketOptions.TCP_NODELAY));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_289749551 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_289749551;
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Boolean) impl.getOption(SocketOptions.TCP_NODELAY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.078 -0400", hash_original_method = "B94B1A38E8CA82DAB010EC0768F89732", hash_generated_method = "2ECB8E5B368654CE5CB90AA57E928B6A")
    public void setKeepAlive(boolean keepAlive) throws SocketException {
        {
            checkOpenAndCreate(true);
            impl.setOption(SocketOptions.SO_KEEPALIVE, Boolean.valueOf(keepAlive));
        } //End block
        addTaint(keepAlive);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.084 -0400", hash_original_method = "AEB667B5DBC425D73D37135566ECC286", hash_generated_method = "3226E4F55935F478BB9C23241D5204C7")
    public synchronized void setSendBufferSize(int size) throws SocketException {
        checkOpenAndCreate(true);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size < 1");
        } //End block
        impl.setOption(SocketOptions.SO_SNDBUF, Integer.valueOf(size));
        addTaint(size);
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //if (size < 1) {
            //throw new IllegalArgumentException("size < 1");
        //}
        //impl.setOption(SocketOptions.SO_SNDBUF, Integer.valueOf(size));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.084 -0400", hash_original_method = "1376DE896B8682F991877B7A17C5B3A4", hash_generated_method = "BD0796149356530A6893DDB730000696")
    public synchronized void setReceiveBufferSize(int size) throws SocketException {
        checkOpenAndCreate(true);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size < 1");
        } //End block
        impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
        addTaint(size);
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //if (size < 1) {
            //throw new IllegalArgumentException("size < 1");
        //}
        //impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.099 -0400", hash_original_method = "89C38D96E5FBD4D1BD6CE4BD573A4473", hash_generated_method = "BBE5721672DE1C18771AE847E3BE7BF1")
    public void setSoLinger(boolean on, int timeout) throws SocketException {
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
        addTaint(on);
        addTaint(timeout);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.100 -0400", hash_original_method = "EA919996CC1899AC4E781314DA47161A", hash_generated_method = "D718A6FF920C18A510F9A3EC3592B4C0")
    public synchronized void setSoTimeout(int timeout) throws SocketException {
        checkOpenAndCreate(true);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("timeout < 0");
        } //End block
        impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(timeout));
        addTaint(timeout);
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //if (timeout < 0) {
            //throw new IllegalArgumentException("timeout < 0");
        //}
        //impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.113 -0400", hash_original_method = "04E6A4AAAA03D3C2F3E4334A66D2F7A1", hash_generated_method = "89173C7096F663DF9419936480F4F53F")
    public void setTcpNoDelay(boolean on) throws SocketException {
        checkOpenAndCreate(true);
        impl.setOption(SocketOptions.TCP_NODELAY, Boolean.valueOf(on));
        addTaint(on);
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //impl.setOption(SocketOptions.TCP_NODELAY, Boolean.valueOf(on));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.114 -0400", hash_original_method = "20DD1F1CA9EDC17BE2B90F2B7E5FF655", hash_generated_method = "D1BE2DA7893B53B45EFC2BA0DF4A1112")
    private void startupSocket(InetAddress dstAddress, int dstPort,
            InetAddress localAddress, int localPort, boolean streaming) throws IOException {
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
                    boolean var2212C8D76AB677AF4319CDF4B542D69A_1964107726 = (!streaming || !usingSocks());
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
        addTaint(dstAddress.getTaint());
        addTaint(dstPort);
        addTaint(localAddress.getTaint());
        addTaint(localPort);
        addTaint(streaming);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.115 -0400", hash_original_method = "933F73796CB698722A986AC13FC9BFF8", hash_generated_method = "EE5F87EA48041D4F8F350F33B2C734D6")
    private boolean usingSocks() {
        boolean var78F22D973B8E4232A59324CAA691F0AB_1792575374 = (proxy != null && proxy.type() == Proxy.Type.SOCKS);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_158490235 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_158490235;
        // ---------- Original Method ----------
        //return proxy != null && proxy.type() == Proxy.Type.SOCKS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.134 -0400", hash_original_method = "881D40A46B027F3EDC8B30A9F4F44097", hash_generated_method = "C78627373406809506A6B318F56D51B5")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1035874400 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2066552002 = null; //Variable for return #2
        {
            boolean var341AB6969DFD2927CA563855F9EEB77E_1143082199 = (!isConnected());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1035874400 = "Socket[unconnected]";
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2066552002 = impl.toString();
        String varA7E53CE21691AB073D9660D615818899_624169796; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_624169796 = varB4EAC82CA7396A68D541C85D26508E83_1035874400;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_624169796 = varB4EAC82CA7396A68D541C85D26508E83_2066552002;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_624169796.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_624169796;
        // ---------- Original Method ----------
        //if (!isConnected()) {
            //return "Socket[unconnected]";
        //}
        //return impl.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.138 -0400", hash_original_method = "D21BBF88E7F4579ADC8933941E3433FA", hash_generated_method = "910CF83A807C9932CCEE99FABACBB7BF")
    public void shutdownInput() throws IOException {
        {
            boolean var899D12471AFC16D8818224BE7B57500A_1318352327 = (isInputShutdown());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.139 -0400", hash_original_method = "1AECC9ACE476BBC93D823FC75BDACBC6", hash_generated_method = "91479B6B58A5FB8E2124A02254549E43")
    public void shutdownOutput() throws IOException {
        {
            boolean var721D80F1B38A860A3B065E2E7DC6E012_1008718042 = (isOutputShutdown());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.150 -0400", hash_original_method = "80C03A9E4F151BE4271ACE586291D7DE", hash_generated_method = "8E65AADBBF44DBED3F81FD8909A0A46F")
    private void checkOpenAndCreate(boolean create) throws SocketException {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_892817889 = (isClosed());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket is closed");
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean varD001DA76880A087CD0A30FA1D399A199_175709758 = (!isConnected());
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
        addTaint(create);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.157 -0400", hash_original_method = "AE126A441E32CF7358FEDD7A95BAD391", hash_generated_method = "24A14E0E142CF7F671CD83CFF4ACC8D4")
    public SocketAddress getLocalSocketAddress() {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_1905040787 = null; //Variable for return #1
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_182895112 = null; //Variable for return #2
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_118347594 = (!isBound());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1905040787 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_182895112 = new InetSocketAddress(getLocalAddress(), getLocalPort());
        SocketAddress varA7E53CE21691AB073D9660D615818899_245990919; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_245990919 = varB4EAC82CA7396A68D541C85D26508E83_1905040787;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_245990919 = varB4EAC82CA7396A68D541C85D26508E83_182895112;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_245990919.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_245990919;
        // ---------- Original Method ----------
        //if (!isBound()) {
            //return null;
        //}
        //return new InetSocketAddress(getLocalAddress(), getLocalPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.168 -0400", hash_original_method = "7C698472BF26D61A7917F4B5238C5FF7", hash_generated_method = "7E8631CCA9EF5C41270A569F88C756CF")
    public SocketAddress getRemoteSocketAddress() {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_1940811055 = null; //Variable for return #1
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_857667210 = null; //Variable for return #2
        {
            boolean var341AB6969DFD2927CA563855F9EEB77E_1745476815 = (!isConnected());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1940811055 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_857667210 = new InetSocketAddress(getInetAddress(), getPort());
        SocketAddress varA7E53CE21691AB073D9660D615818899_94584557; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_94584557 = varB4EAC82CA7396A68D541C85D26508E83_1940811055;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_94584557 = varB4EAC82CA7396A68D541C85D26508E83_857667210;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_94584557.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_94584557;
        // ---------- Original Method ----------
        //if (!isConnected()) {
            //return null;
        //}
        //return new InetSocketAddress(getInetAddress(), getPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.169 -0400", hash_original_method = "589AFDD4CA6BF38ABB5F59E26BB3DC6D", hash_generated_method = "009BFFCF4A521A0EF2F09B5B23FCBDF2")
    public boolean isBound() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1124901080 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1124901080;
        // ---------- Original Method ----------
        //return isBound;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.169 -0400", hash_original_method = "B1255CDE181FFAAB8CB434FB98B99FFF", hash_generated_method = "262962611DA48041DBE1EA3BCA0CFC72")
    public boolean isConnected() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_284979868 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_284979868;
        // ---------- Original Method ----------
        //return isConnected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.186 -0400", hash_original_method = "2EEDDDEB8BA1CD500E3647BC397BF54F", hash_generated_method = "D772963E994F92B847FAD73BF8567F38")
    public boolean isClosed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1785191947 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1785191947;
        // ---------- Original Method ----------
        //return isClosed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.188 -0400", hash_original_method = "9E3C378994EF9A4091E39D0FA34770F8", hash_generated_method = "62485B716BFE89DCBD13834EB175E79F")
    public void bind(SocketAddress localAddr) throws IOException {
        checkOpenAndCreate(true);
        {
            boolean var508204320144CEB3F447DE9CCDB64480_1955635492 = (isBound());
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
                boolean varC74AE0463916E813FB227E6D8242C56F_846355797 = ((addr = inetAddr.getAddress()) == null);
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
        addTaint(localAddr.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.188 -0400", hash_original_method = "B2F3815725658D73C0532A54E6C164BA", hash_generated_method = "BB337763E900750F306DD7ECDCF2158C")
    public void connect(SocketAddress remoteAddr) throws IOException {
        connect(remoteAddr, 0);
        addTaint(remoteAddr.getTaint());
        // ---------- Original Method ----------
        //connect(remoteAddr, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.197 -0400", hash_original_method = "45EED4DE787227F7BEC68E335C7AA6E7", hash_generated_method = "6B97540BABE179ED3C37949F57C596E2")
    public void connect(SocketAddress remoteAddr, int timeout) throws IOException {
        checkOpenAndCreate(true);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("timeout < 0");
        } //End block
        {
            boolean var5153987C55DB41759ADC1D7527E9459D_1492817487 = (isConnected());
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
            boolean var3A90A8ECED80469E6C4DBC0D965BCC76_1450206807 = ((addr = inetAddr.getAddress()) == null);
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
                    boolean var51251543F279E208469B7565700B7E80_1496599746 = (!isBound());
                    {
                        {
                            boolean var24AE71A7EC560AD214D100F7850BDFF8_1833473626 = (!usingSocks());
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
        addTaint(remoteAddr.getTaint());
        addTaint(timeout);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.198 -0400", hash_original_method = "2FA07403172C73A0B79A0DF7F37DEBFB", hash_generated_method = "3150B82B4EB57D67021F6206EF656AB3")
    public boolean isInputShutdown() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1204664741 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1204664741;
        // ---------- Original Method ----------
        //return isInputShutdown;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.217 -0400", hash_original_method = "C1B1C01C4973B5698673C5D09FA67185", hash_generated_method = "9E60DFC74AB7D1B2E5670C9CF1B389C0")
    public boolean isOutputShutdown() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_821509213 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_821509213;
        // ---------- Original Method ----------
        //return isOutputShutdown;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.218 -0400", hash_original_method = "6CEA4E5A53899EBE8D1FD08F2FE40675", hash_generated_method = "39B146F11D856CC9843D732D4E2061C0")
    public void setReuseAddress(boolean reuse) throws SocketException {
        checkOpenAndCreate(true);
        impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
        addTaint(reuse);
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.218 -0400", hash_original_method = "8D0919FD23B9A2472FC046E6B1704481", hash_generated_method = "419C15E0931CBABF9469628EB3360534")
    public boolean getReuseAddress() throws SocketException {
        checkOpenAndCreate(true);
        boolean varCE142DF7D7C52AD31EFC3E546F2DD316_18949245 = ((Boolean) impl.getOption(SocketOptions.SO_REUSEADDR));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_747145663 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_747145663;
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Boolean) impl.getOption(SocketOptions.SO_REUSEADDR);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.219 -0400", hash_original_method = "8F9774180DF7F00524B2F69126E7F96E", hash_generated_method = "9D3EFD096926A8E155DEF836A7789736")
    public void setOOBInline(boolean oobinline) throws SocketException {
        checkOpenAndCreate(true);
        impl.setOption(SocketOptions.SO_OOBINLINE, Boolean.valueOf(oobinline));
        addTaint(oobinline);
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //impl.setOption(SocketOptions.SO_OOBINLINE, Boolean.valueOf(oobinline));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.219 -0400", hash_original_method = "A307BAC96AD0AD9185D724CFFBC60918", hash_generated_method = "6C734ECBDBEE811D86C0D76FE1C324C4")
    public boolean getOOBInline() throws SocketException {
        checkOpenAndCreate(true);
        boolean varCB6AA2E4A86BFAA8F54C6C5D29BB281D_1915418696 = ((Boolean) impl.getOption(SocketOptions.SO_OOBINLINE));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_974885513 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_974885513;
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Boolean) impl.getOption(SocketOptions.SO_OOBINLINE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.226 -0400", hash_original_method = "50A48D0E3EC8A723BC37542164C52A31", hash_generated_method = "C3B01BF49AE1D06CFCA39558D136DF48")
    public void setTrafficClass(int value) throws SocketException {
        checkOpenAndCreate(true);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        impl.setOption(SocketOptions.IP_TOS, Integer.valueOf(value));
        addTaint(value);
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //if (value < 0 || value > 255) {
            //throw new IllegalArgumentException();
        //}
        //impl.setOption(SocketOptions.IP_TOS, Integer.valueOf(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.232 -0400", hash_original_method = "D7C7CF134B3FE725817BA2C07D220760", hash_generated_method = "70E233599E737E944C56E797C22FBACF")
    public int getTrafficClass() throws SocketException {
        checkOpenAndCreate(true);
        int var9C2568077066805EC4361C5C54BBCF61_329052812 = ((Integer) impl.getOption(SocketOptions.IP_TOS));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1842395271 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1842395271;
        // ---------- Original Method ----------
        //checkOpenAndCreate(true);
        //return (Integer) impl.getOption(SocketOptions.IP_TOS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.232 -0400", hash_original_method = "CBFC447F34929AC991DFFA20015F8279", hash_generated_method = "9439B775AB4C29CDB458DB7934DF9254")
    public void sendUrgentData(int value) throws IOException {
        impl.sendUrgentData(value);
        addTaint(value);
        // ---------- Original Method ----------
        //impl.sendUrgentData(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.235 -0400", hash_original_method = "21E3234EAE6C3F4479E6E7944641B8BE", hash_generated_method = "7AA833B05FB6D1983035B8C7720A9AD2")
     void accepted() {
        isCreated = isBound = isConnected = true;
        cacheLocalAddress();
        // ---------- Original Method ----------
        //isCreated = isBound = isConnected = true;
        //cacheLocalAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.236 -0400", hash_original_method = "95A7BF302299AFCDED7970E2F7424717", hash_generated_method = "794BDF12835FAD96C22BC1E6B513ECB3")
    private void cacheLocalAddress() {
        this.localAddress = IoBridge.getSocketLocalAddress(impl.fd);
        // ---------- Original Method ----------
        //this.localAddress = IoBridge.getSocketLocalAddress(impl.fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.260 -0400", hash_original_method = "A7DB57A03C94477191BD1BBD8D530AC8", hash_generated_method = "049AE841DD4D80F8DE62B72C0C67E619")
    public SocketChannel getChannel() {
        SocketChannel varB4EAC82CA7396A68D541C85D26508E83_2003368509 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2003368509 = null;
        varB4EAC82CA7396A68D541C85D26508E83_2003368509.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2003368509;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.261 -0400", hash_original_method = "90C19CEBA6BBC20B430C1F399D6443A6", hash_generated_method = "50CB410A428E5FDE5FEF48EE95F07DBE")
    public FileDescriptor getFileDescriptor$() {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_621447265 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_621447265 = impl.fd;
        varB4EAC82CA7396A68D541C85D26508E83_621447265.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_621447265;
        // ---------- Original Method ----------
        //return impl.fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.261 -0400", hash_original_method = "EE4DCDA11944F25F3B6AAA6A92D8AD2F", hash_generated_method = "5BDBFA2FBDAEAD861B5CE7312955EF38")
    public void setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
        addTaint(connectionTime);
        addTaint(latency);
        addTaint(bandwidth);
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.261 -0400", hash_original_field = "9549DD6065D019211460C59A86DD6536", hash_generated_field = "ABE875F9FF8F88D9D548D2F2A5A13861")

    private static SocketImplFactory factory;
}

