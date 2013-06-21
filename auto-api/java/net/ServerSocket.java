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
    private SocketImpl impl;
    private boolean isBound;
    private boolean isClosed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.086 -0400", hash_original_method = "31BB74D5896D397B1327C5B34E5CB836", hash_generated_method = "CC783DD97FFEF08036B1A4D90EFE45DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServerSocket() throws IOException {
        this.impl = factory != null ? factory.createSocketImpl()
                : new PlainServerSocketImpl();
        impl.create(true);
        // ---------- Original Method ----------
        //this.impl = factory != null ? factory.createSocketImpl()
                //: new PlainServerSocketImpl();
        //impl.create(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.086 -0400", hash_original_method = "17E5A7EAB5FF74551872A5C22051BFB5", hash_generated_method = "6EC0697E13BD3F56864C8F88279268B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServerSocket(int port) throws IOException {
        this(port, DEFAULT_BACKLOG, Inet4Address.ANY);
        dsTaint.addTaint(port);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.086 -0400", hash_original_method = "B81C30D251B31CAFF71CF07C7882EF32", hash_generated_method = "F07D33D19ECE8AC7C5531349853CA6F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServerSocket(int port, int backlog) throws IOException {
        this(port, backlog, Inet4Address.ANY);
        dsTaint.addTaint(port);
        dsTaint.addTaint(backlog);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.086 -0400", hash_original_method = "6BB36DC8E15E305D7407A47C7739996C", hash_generated_method = "A5EE4F13A3AE178C1690E4CFCA5BCE30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServerSocket(int port, int backlog, InetAddress localAddress) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(backlog);
        dsTaint.addTaint(localAddress.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.086 -0400", hash_original_method = "847F07D140851DC7DF04F3DA230B7EED", hash_generated_method = "40E891868575A6FDA9BA6F9CDB4B3EA6")
    @DSModeled(DSC.SAFE)
    public SocketImpl getImpl$() {
        return (SocketImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return impl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.087 -0400", hash_original_method = "DE0153D2AABFEE83527E2EAC5D1F68DF", hash_generated_method = "8046DCBFA9A0680C488D2D819757A7A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Socket accept() throws IOException {
        checkOpen();
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_2067685644 = (!isBound());
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
        return (Socket)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.087 -0400", hash_original_method = "C273B8F533783A3DE90657F5715801E0", hash_generated_method = "C3A8CB96691A7F647126192BE559AE23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkListen(int aPort) {
        dsTaint.addTaint(aPort);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Port out of range: " + aPort);
        } //End block
        // ---------- Original Method ----------
        //if (aPort < 0 || aPort > 65535) {
            //throw new IllegalArgumentException("Port out of range: " + aPort);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.087 -0400", hash_original_method = "8636C7CEC5FFD33F6CBF2C75F9E6A135", hash_generated_method = "09C692F3B9ABE75F75305B3C4044C0D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() throws IOException {
        isClosed = true;
        impl.close();
        // ---------- Original Method ----------
        //isClosed = true;
        //impl.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.087 -0400", hash_original_method = "0AAA019638F2B2CC41FFEEEB4E260F6C", hash_generated_method = "0633814E2A92042A303D681A879AFBB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InetAddress getInetAddress() {
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_1557280114 = (!isBound());
        } //End collapsed parenthetic
        InetAddress var8655A4EE53FB8FBE3B9196FE317ADFA6_2103231392 = (impl.getInetAddress());
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!isBound()) {
            //return null;
        //}
        //return impl.getInetAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.087 -0400", hash_original_method = "F5BB694DF3469EBFBD82064FFB1FEAE0", hash_generated_method = "F3966C6F47A29AFF8F1256D2F656EA5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLocalPort() {
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_378302891 = (!isBound());
        } //End collapsed parenthetic
        int var5201144B0B742B3A152781D672D1AA30_1699372374 = (impl.getLocalPort());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (!isBound()) {
            //return -1;
        //}
        //return impl.getLocalPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.088 -0400", hash_original_method = "37BE74568AC5DDD629C634B42E81BFFA", hash_generated_method = "59ECBD492877C50B045171812ED37FC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int getSoTimeout() throws IOException {
        checkOpen();
        int var97D6E04E407212E66322CDB8618B167A_1618424803 = (((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.088 -0400", hash_original_method = "BFFC5C44CB4D0AB53035D05D9EAC93F6", hash_generated_method = "C8897BFD190648DAEABFD252023199C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void implAccept(Socket aSocket) throws IOException {
        dsTaint.addTaint(aSocket.dsTaint);
        {
            impl.accept(aSocket.impl);
            aSocket.accepted();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.088 -0400", hash_original_method = "E2A5F03981AB4BF932E59A553E83FA6F", hash_generated_method = "FD535C82DB2107D3737DB2FA14A88956")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setSoTimeout(int timeout) throws SocketException {
        dsTaint.addTaint(timeout);
        checkOpen();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("timeout < 0");
        } //End block
        impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(timeout));
        // ---------- Original Method ----------
        //checkOpen();
        //if (timeout < 0) {
            //throw new IllegalArgumentException("timeout < 0");
        //}
        //impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.088 -0400", hash_original_method = "577ACC2D572353EA5861EB3648159EF5", hash_generated_method = "81E1FC04BF5B5512969323D949BFB5B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder result;
        result = new StringBuilder(64);
        result.append("ServerSocket[");
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_903175701 = (!isBound());
            {
                String var69511D4645BCAB730FF5BC75190F418D_1813023849 = (result.append("unbound]").toString());
            } //End block
        } //End collapsed parenthetic
        String var23BFA7FA936085D92F57EFEE5EB62CDB_1118965145 = (result.append("addr=")
                .append(getInetAddress().getHostName()).append("/")
                .append(getInetAddress().getHostAddress()).append(
                        ",port=0,localport=")
                .append(getLocalPort()).append("]")
                .toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.089 -0400", hash_original_method = "AB1F91AE5F8F2B3C00C4EDCF73D5B4D1", hash_generated_method = "E2F061E517AEAE5383F0D914D4EED870")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void bind(SocketAddress localAddr) throws IOException {
        dsTaint.addTaint(localAddr.dsTaint);
        bind(localAddr, DEFAULT_BACKLOG);
        // ---------- Original Method ----------
        //bind(localAddr, DEFAULT_BACKLOG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.089 -0400", hash_original_method = "684D242B2EA0BE4D55F437B908E9CC5D", hash_generated_method = "A81065AF6E85A5E89F32E08D28F83C5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void bind(SocketAddress localAddr, int backlog) throws IOException {
        dsTaint.addTaint(backlog);
        dsTaint.addTaint(localAddr.dsTaint);
        checkOpen();
        {
            boolean var508204320144CEB3F447DE9CCDB64480_1491857296 = (isBound());
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
                boolean varC74AE0463916E813FB227E6D8242C56F_14597166 = ((addr = inetAddr.getAddress()) == null);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.089 -0400", hash_original_method = "7AD76537AA5A3220834213189640F2E9", hash_generated_method = "F7C708263621ECA3FBF4507FC6731A59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketAddress getLocalSocketAddress() {
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_1958663765 = (!isBound());
        } //End collapsed parenthetic
        SocketAddress var06DDF77B9872AAD14EEF94CC7935F976_1956311649 = (new InetSocketAddress(getInetAddress(), getLocalPort()));
        return (SocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!isBound()) {
            //return null;
        //}
        //return new InetSocketAddress(getInetAddress(), getLocalPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.089 -0400", hash_original_method = "589AFDD4CA6BF38ABB5F59E26BB3DC6D", hash_generated_method = "CCD3B76B3D7072F4B37ED141BE36FE94")
    @DSModeled(DSC.SAFE)
    public boolean isBound() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isBound;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.090 -0400", hash_original_method = "2EEDDDEB8BA1CD500E3647BC397BF54F", hash_generated_method = "D8FADA936D54405ECC52CB2CA557F68D")
    @DSModeled(DSC.SAFE)
    public boolean isClosed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isClosed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.090 -0400", hash_original_method = "8DC54C39C6445BAF3181407C830C5887", hash_generated_method = "F64FF216AAF93B4433984994560C4812")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkOpen() throws SocketException {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_1930102301 = (isClosed());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket is closed");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isClosed()) {
            //throw new SocketException("Socket is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.090 -0400", hash_original_method = "D6CD69E67882E49578E557811A0FC457", hash_generated_method = "58C6D809023590A20F1495459057AD04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setReuseAddress(boolean reuse) throws SocketException {
        dsTaint.addTaint(reuse);
        checkOpen();
        impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
        // ---------- Original Method ----------
        //checkOpen();
        //impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.090 -0400", hash_original_method = "8920D58954E3583481E89192EF874E86", hash_generated_method = "35CB016C5818204A71EF31B675634A3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getReuseAddress() throws SocketException {
        checkOpen();
        boolean var92F4A5EAF76459C680E3D19F2BDB3A81_1738950518 = (((Boolean) impl.getOption(SocketOptions.SO_REUSEADDR)).booleanValue());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Boolean) impl.getOption(SocketOptions.SO_REUSEADDR)).booleanValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.090 -0400", hash_original_method = "4A5F0E88940F2B7162C81724AB1FDFE4", hash_generated_method = "4196D4F8D31123C8D3E8CB3592B6A2F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setReceiveBufferSize(int size) throws SocketException {
        dsTaint.addTaint(size);
        checkOpen();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size < 1");
        } //End block
        impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
        // ---------- Original Method ----------
        //checkOpen();
        //if (size < 1) {
            //throw new IllegalArgumentException("size < 1");
        //}
        //impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.090 -0400", hash_original_method = "1025A74ACDCA065D38BE1D18813D43DB", hash_generated_method = "DD96DEEFC4A8F60703D5BC439408BA53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getReceiveBufferSize() throws SocketException {
        checkOpen();
        int var879D57EDA18A262547327AC0C51A7315_890273503 = (((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.091 -0400", hash_original_method = "3D28E6253835634FC7711C1CE3F0C48B", hash_generated_method = "EC6AD3F7691D89FFC34F03CFC7F7B79F")
    @DSModeled(DSC.SAFE)
    public ServerSocketChannel getChannel() {
        return (ServerSocketChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.091 -0400", hash_original_method = "EE4DCDA11944F25F3B6AAA6A92D8AD2F", hash_generated_method = "7F88DEDF5F3C4CD498A7DDF91ACC9522")
    @DSModeled(DSC.SAFE)
    public void setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
        dsTaint.addTaint(latency);
        dsTaint.addTaint(connectionTime);
        dsTaint.addTaint(bandwidth);
        // ---------- Original Method ----------
    }

    
    private static final int DEFAULT_BACKLOG = 50;
    static SocketImplFactory factory;
}

