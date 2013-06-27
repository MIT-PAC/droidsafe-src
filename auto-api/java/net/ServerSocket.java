package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.nio.channels.ServerSocketChannel;

public class ServerSocket {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.876 -0400", hash_original_field = "86CCEC3D9FF0E9C0514506E982CDC08B", hash_generated_field = "E5435F593B4B4C544AAC5D578CFF6639")

    private SocketImpl impl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.876 -0400", hash_original_field = "8E4D35088206920061AAF7F347854388", hash_generated_field = "C0B93BC213B673FF2E47783C561E2823")

    private boolean isBound;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.876 -0400", hash_original_field = "7587750400D3C39AEAD7C1489F6FE7F3", hash_generated_field = "61C76B683BBEFCB5006250611D355A94")

    private boolean isClosed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.881 -0400", hash_original_method = "31BB74D5896D397B1327C5B34E5CB836", hash_generated_method = "CC783DD97FFEF08036B1A4D90EFE45DF")
    public  ServerSocket() throws IOException {
        this.impl = factory != null ? factory.createSocketImpl()
                : new PlainServerSocketImpl();
        impl.create(true);
        // ---------- Original Method ----------
        //this.impl = factory != null ? factory.createSocketImpl()
                //: new PlainServerSocketImpl();
        //impl.create(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.881 -0400", hash_original_method = "17E5A7EAB5FF74551872A5C22051BFB5", hash_generated_method = "8188B0E7B9ACD2CC1652950807628542")
    public  ServerSocket(int port) throws IOException {
        this(port, DEFAULT_BACKLOG, Inet4Address.ANY);
        addTaint(port);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.881 -0400", hash_original_method = "B81C30D251B31CAFF71CF07C7882EF32", hash_generated_method = "F0AE178AE604AD8B8649389E2A81D277")
    public  ServerSocket(int port, int backlog) throws IOException {
        this(port, backlog, Inet4Address.ANY);
        addTaint(port);
        addTaint(backlog);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.888 -0400", hash_original_method = "6BB36DC8E15E305D7407A47C7739996C", hash_generated_method = "8D2E13A6A82513C911966AE4610C2C7E")
    public  ServerSocket(int port, int backlog, InetAddress localAddress) throws IOException {
        checkListen(port);
        this.impl = factory != null ? factory.createSocketImpl()
                : new PlainServerSocketImpl();
        InetAddress addr;
        addr = Inet4Address.ANY;
        addr = localAddress;
        {
            impl.create(true);
            try 
            {
                impl.bind(addr, port);
                isBound = true;
                impl.listen(backlog > 0 ? backlog : DEFAULT_BACKLOG);
            } //End block
            catch (IOException e)
            {
                close();
                if (DroidSafeAndroidRuntime.control) throw e;
            } //End block
        } //End block
        addTaint(port);
        addTaint(backlog);
        addTaint(localAddress.getTaint());
        // ---------- Original Method ----------
        //checkListen(port);
        //this.impl = factory != null ? factory.createSocketImpl()
                //: new PlainServerSocketImpl();
        //InetAddress addr = (localAddress == null) ? Inet4Address.ANY : localAddress;
        //synchronized (this) {
            //impl.create(true);
            //try {
                //impl.bind(addr, port);
                //isBound = true;
                //impl.listen(backlog > 0 ? backlog : DEFAULT_BACKLOG);
            //} catch (IOException e) {
                //close();
                //throw e;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.888 -0400", hash_original_method = "847F07D140851DC7DF04F3DA230B7EED", hash_generated_method = "5CE6EBAE1E07318B1B3BB874328D790B")
    public SocketImpl getImpl$() {
        SocketImpl varB4EAC82CA7396A68D541C85D26508E83_642036444 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_642036444 = impl;
        varB4EAC82CA7396A68D541C85D26508E83_642036444.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_642036444;
        // ---------- Original Method ----------
        //return impl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.891 -0400", hash_original_method = "DE0153D2AABFEE83527E2EAC5D1F68DF", hash_generated_method = "272239E063391CCD8F7C845B80525872")
    public Socket accept() throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1389771659 = null; //Variable for return #1
        checkOpen();
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_779786282 = (!isBound());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket is not bound");
            } //End block
        } //End collapsed parenthetic
        Socket aSocket;
        aSocket = new Socket();
        try 
        {
            implAccept(aSocket);
        } //End block
        catch (IOException e)
        {
            aSocket.close();
            if (DroidSafeAndroidRuntime.control) throw e;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1389771659 = aSocket;
        varB4EAC82CA7396A68D541C85D26508E83_1389771659.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1389771659;
        // ---------- Original Method ----------
        //checkOpen();
        //if (!isBound()) {
            //throw new SocketException("Socket is not bound");
        //}
        //Socket aSocket = new Socket();
        //try {
            //implAccept(aSocket);
        //} catch (IOException e) {
            //aSocket.close();
            //throw e;
        //}
        //return aSocket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.894 -0400", hash_original_method = "C273B8F533783A3DE90657F5715801E0", hash_generated_method = "0C56E3FDAF8D797D3DCDEFE5047DA8AD")
    private void checkListen(int aPort) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Port out of range: " + aPort);
        } //End block
        addTaint(aPort);
        // ---------- Original Method ----------
        //if (aPort < 0 || aPort > 65535) {
            //throw new IllegalArgumentException("Port out of range: " + aPort);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.906 -0400", hash_original_method = "8636C7CEC5FFD33F6CBF2C75F9E6A135", hash_generated_method = "09C692F3B9ABE75F75305B3C4044C0D5")
    public void close() throws IOException {
        isClosed = true;
        impl.close();
        // ---------- Original Method ----------
        //isClosed = true;
        //impl.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.908 -0400", hash_original_method = "0AAA019638F2B2CC41FFEEEB4E260F6C", hash_generated_method = "5A439F0C711C6D33B4307EAF23561AAE")
    public InetAddress getInetAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_455662433 = null; //Variable for return #1
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1257754800 = null; //Variable for return #2
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_387431944 = (!isBound());
            {
                varB4EAC82CA7396A68D541C85D26508E83_455662433 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1257754800 = impl.getInetAddress();
        InetAddress varA7E53CE21691AB073D9660D615818899_1850578669; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1850578669 = varB4EAC82CA7396A68D541C85D26508E83_455662433;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1850578669 = varB4EAC82CA7396A68D541C85D26508E83_1257754800;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1850578669.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1850578669;
        // ---------- Original Method ----------
        //if (!isBound()) {
            //return null;
        //}
        //return impl.getInetAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.908 -0400", hash_original_method = "F5BB694DF3469EBFBD82064FFB1FEAE0", hash_generated_method = "1588FC52D9B9563ED4CF91B17E00B30B")
    public int getLocalPort() {
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_2145644633 = (!isBound());
        } //End collapsed parenthetic
        int var5201144B0B742B3A152781D672D1AA30_1649253634 = (impl.getLocalPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_469091576 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_469091576;
        // ---------- Original Method ----------
        //if (!isBound()) {
            //return -1;
        //}
        //return impl.getLocalPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.917 -0400", hash_original_method = "37BE74568AC5DDD629C634B42E81BFFA", hash_generated_method = "B027BB2F2C09532399CF9C0B53B6E3D0")
    public synchronized int getSoTimeout() throws IOException {
        checkOpen();
        int var97D6E04E407212E66322CDB8618B167A_581770311 = (((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1254801345 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1254801345;
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.918 -0400", hash_original_method = "BFFC5C44CB4D0AB53035D05D9EAC93F6", hash_generated_method = "6CC5BC16237DC902354AC0A460666FF0")
    protected final void implAccept(Socket aSocket) throws IOException {
        {
            impl.accept(aSocket.impl);
            aSocket.accepted();
        } //End block
        addTaint(aSocket.getTaint());
        // ---------- Original Method ----------
        //synchronized (this) {
            //impl.accept(aSocket.impl);
            //aSocket.accepted();
        //}
    }

    
        public static synchronized void setSocketFactory(SocketImplFactory aFactory) throws IOException {
        if (factory != null) {
            throw new SocketException("Factory already set");
        }
        factory = aFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.947 -0400", hash_original_method = "E2A5F03981AB4BF932E59A553E83FA6F", hash_generated_method = "715987126166DD9C37EE215B53FACCCF")
    public synchronized void setSoTimeout(int timeout) throws SocketException {
        checkOpen();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("timeout < 0");
        } //End block
        impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(timeout));
        addTaint(timeout);
        // ---------- Original Method ----------
        //checkOpen();
        //if (timeout < 0) {
            //throw new IllegalArgumentException("timeout < 0");
        //}
        //impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.948 -0400", hash_original_method = "577ACC2D572353EA5861EB3648159EF5", hash_generated_method = "AF725967C0B711A82F8342E6451571BC")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1111110471 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_956521988 = null; //Variable for return #2
        StringBuilder result;
        result = new StringBuilder(64);
        result.append("ServerSocket[");
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_1137130623 = (!isBound());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1111110471 = result.append("unbound]").toString();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_956521988 = result.append("addr=")
                .append(getInetAddress().getHostName()).append("/")
                .append(getInetAddress().getHostAddress()).append(
                        ",port=0,localport=")
                .append(getLocalPort()).append("]")
                .toString();
        String varA7E53CE21691AB073D9660D615818899_2054715177; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2054715177 = varB4EAC82CA7396A68D541C85D26508E83_1111110471;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2054715177 = varB4EAC82CA7396A68D541C85D26508E83_956521988;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2054715177.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2054715177;
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder(64);
        //result.append("ServerSocket[");
        //if (!isBound()) {
            //return result.append("unbound]").toString();
        //}
        //return result.append("addr=")
                //.append(getInetAddress().getHostName()).append("/")
                //.append(getInetAddress().getHostAddress()).append(
                        //",port=0,localport=")
                //.append(getLocalPort()).append("]")
                //.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.950 -0400", hash_original_method = "AB1F91AE5F8F2B3C00C4EDCF73D5B4D1", hash_generated_method = "2CAD37934CCBAF068B5EDB43E7CA5E1C")
    public void bind(SocketAddress localAddr) throws IOException {
        bind(localAddr, DEFAULT_BACKLOG);
        addTaint(localAddr.getTaint());
        // ---------- Original Method ----------
        //bind(localAddr, DEFAULT_BACKLOG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.952 -0400", hash_original_method = "684D242B2EA0BE4D55F437B908E9CC5D", hash_generated_method = "43EB802066A5A84BB9BEC249BAEF616A")
    public void bind(SocketAddress localAddr, int backlog) throws IOException {
        checkOpen();
        {
            boolean var508204320144CEB3F447DE9CCDB64480_262908751 = (isBound());
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
                boolean varC74AE0463916E813FB227E6D8242C56F_2087973963 = ((addr = inetAddr.getAddress()) == null);
                {
                    if (DroidSafeAndroidRuntime.control) throw new SocketException("Host is unresolved: " + inetAddr.getHostName());
                } //End block
            } //End collapsed parenthetic
            port = inetAddr.getPort();
        } //End block
        {
            try 
            {
                impl.bind(addr, port);
                isBound = true;
                impl.listen(backlog > 0 ? backlog : DEFAULT_BACKLOG);
            } //End block
            catch (IOException e)
            {
                close();
                if (DroidSafeAndroidRuntime.control) throw e;
            } //End block
        } //End block
        addTaint(localAddr.getTaint());
        addTaint(backlog);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.972 -0400", hash_original_method = "7AD76537AA5A3220834213189640F2E9", hash_generated_method = "48568B50E8BF4F1A792EF0F2F82B35A0")
    public SocketAddress getLocalSocketAddress() {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_2071871675 = null; //Variable for return #1
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_1990457709 = null; //Variable for return #2
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_1956530410 = (!isBound());
            {
                varB4EAC82CA7396A68D541C85D26508E83_2071871675 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1990457709 = new InetSocketAddress(getInetAddress(), getLocalPort());
        SocketAddress varA7E53CE21691AB073D9660D615818899_946770728; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_946770728 = varB4EAC82CA7396A68D541C85D26508E83_2071871675;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_946770728 = varB4EAC82CA7396A68D541C85D26508E83_1990457709;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_946770728.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_946770728;
        // ---------- Original Method ----------
        //if (!isBound()) {
            //return null;
        //}
        //return new InetSocketAddress(getInetAddress(), getLocalPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.973 -0400", hash_original_method = "589AFDD4CA6BF38ABB5F59E26BB3DC6D", hash_generated_method = "C482D90A40F1170EBFBF225EA3AE57A5")
    public boolean isBound() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_601920842 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_601920842;
        // ---------- Original Method ----------
        //return isBound;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.973 -0400", hash_original_method = "2EEDDDEB8BA1CD500E3647BC397BF54F", hash_generated_method = "CA7371FC3CA6DD30705E4FACB0068B22")
    public boolean isClosed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_417770802 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_417770802;
        // ---------- Original Method ----------
        //return isClosed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.973 -0400", hash_original_method = "8DC54C39C6445BAF3181407C830C5887", hash_generated_method = "1E5DD48AA8D1B11491E54411F168FDC6")
    private void checkOpen() throws SocketException {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_1755173110 = (isClosed());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket is closed");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isClosed()) {
            //throw new SocketException("Socket is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.974 -0400", hash_original_method = "D6CD69E67882E49578E557811A0FC457", hash_generated_method = "FC3E7A197DB1A0060F368E39CFC6FAA6")
    public void setReuseAddress(boolean reuse) throws SocketException {
        checkOpen();
        impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
        addTaint(reuse);
        // ---------- Original Method ----------
        //checkOpen();
        //impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.974 -0400", hash_original_method = "8920D58954E3583481E89192EF874E86", hash_generated_method = "90CAB5EA551100AF1BE53E9369D1500D")
    public boolean getReuseAddress() throws SocketException {
        checkOpen();
        boolean var92F4A5EAF76459C680E3D19F2BDB3A81_37071284 = (((Boolean) impl.getOption(SocketOptions.SO_REUSEADDR)).booleanValue());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1770700309 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1770700309;
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Boolean) impl.getOption(SocketOptions.SO_REUSEADDR)).booleanValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.974 -0400", hash_original_method = "4A5F0E88940F2B7162C81724AB1FDFE4", hash_generated_method = "A9C53F0A23EF3A99BACC3D6A19C71CF7")
    public void setReceiveBufferSize(int size) throws SocketException {
        checkOpen();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size < 1");
        } //End block
        impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
        addTaint(size);
        // ---------- Original Method ----------
        //checkOpen();
        //if (size < 1) {
            //throw new IllegalArgumentException("size < 1");
        //}
        //impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.977 -0400", hash_original_method = "1025A74ACDCA065D38BE1D18813D43DB", hash_generated_method = "919F694A7E7920133CD76347C4F53B8F")
    public int getReceiveBufferSize() throws SocketException {
        checkOpen();
        int var879D57EDA18A262547327AC0C51A7315_1124224456 = (((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1071823207 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1071823207;
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.987 -0400", hash_original_method = "3D28E6253835634FC7711C1CE3F0C48B", hash_generated_method = "E64FF1467FAF5C7B62D641EC845CB7AF")
    public ServerSocketChannel getChannel() {
        ServerSocketChannel varB4EAC82CA7396A68D541C85D26508E83_1486917224 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1486917224 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1486917224.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1486917224;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.987 -0400", hash_original_method = "EE4DCDA11944F25F3B6AAA6A92D8AD2F", hash_generated_method = "5BDBFA2FBDAEAD861B5CE7312955EF38")
    public void setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
        addTaint(connectionTime);
        addTaint(latency);
        addTaint(bandwidth);
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.987 -0400", hash_original_field = "4E99CD0551993624E0E83995EFF618A2", hash_generated_field = "5BFDC68C88DD2978F3BF4EE614A2091B")

    private static int DEFAULT_BACKLOG = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.987 -0400", hash_original_field = "9549DD6065D019211460C59A86DD6536", hash_generated_field = "10D4EEC45D11B59A6B6543CD9427385B")

    static SocketImplFactory factory;
}

