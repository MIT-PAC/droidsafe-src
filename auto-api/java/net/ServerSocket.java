package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.nio.channels.ServerSocketChannel;

public class ServerSocket {
    private static final int DEFAULT_BACKLOG = 50;
    private final SocketImpl impl;
    static SocketImplFactory factory;
    private boolean isBound;
    private boolean isClosed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.273 -0400", hash_original_method = "31BB74D5896D397B1327C5B34E5CB836", hash_generated_method = "860AC910A0FA06FC0528C06090779A01")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.273 -0400", hash_original_method = "17E5A7EAB5FF74551872A5C22051BFB5", hash_generated_method = "4341AD4E10C4161EB3383305768C494C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServerSocket(int port) throws IOException {
        this(port, DEFAULT_BACKLOG, Inet4Address.ANY);
        dsTaint.addTaint(port);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.273 -0400", hash_original_method = "B81C30D251B31CAFF71CF07C7882EF32", hash_generated_method = "28CEEE42DDED5F77AD2FB69C8937BFFF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServerSocket(int port, int backlog) throws IOException {
        this(port, backlog, Inet4Address.ANY);
        dsTaint.addTaint(port);
        dsTaint.addTaint(backlog);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.273 -0400", hash_original_method = "6BB36DC8E15E305D7407A47C7739996C", hash_generated_method = "6E52A0249EEE2BFBB7A95435FC459FF4")
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
                throw e;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.273 -0400", hash_original_method = "847F07D140851DC7DF04F3DA230B7EED", hash_generated_method = "FB2033CF82AC0B02C664C0FDB8DC5B3B")
    @DSModeled(DSC.SAFE)
    public SocketImpl getImpl$() {
        return (SocketImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return impl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.273 -0400", hash_original_method = "DE0153D2AABFEE83527E2EAC5D1F68DF", hash_generated_method = "8C2FE8235F092D88557A18DAA075DBCD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Socket accept() throws IOException {
        checkOpen();
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_505689618 = (!isBound());
            {
                throw new SocketException("Socket is not bound");
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
            throw e;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.273 -0400", hash_original_method = "C273B8F533783A3DE90657F5715801E0", hash_generated_method = "837F2021FD49BE5BD8E7D87E46560B7D")
    @DSModeled(DSC.SAFE)
    private void checkListen(int aPort) {
        dsTaint.addTaint(aPort);
        {
            throw new IllegalArgumentException("Port out of range: " + aPort);
        } //End block
        // ---------- Original Method ----------
        //if (aPort < 0 || aPort > 65535) {
            //throw new IllegalArgumentException("Port out of range: " + aPort);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.273 -0400", hash_original_method = "8636C7CEC5FFD33F6CBF2C75F9E6A135", hash_generated_method = "BC0938093FD7CEA69A900EDDBC9D4208")
    @DSModeled(DSC.SAFE)
    public void close() throws IOException {
        isClosed = true;
        impl.close();
        // ---------- Original Method ----------
        //isClosed = true;
        //impl.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.273 -0400", hash_original_method = "0AAA019638F2B2CC41FFEEEB4E260F6C", hash_generated_method = "A8C9E9CA4AC8C7352A3B186602CA58EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InetAddress getInetAddress() {
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_696693821 = (!isBound());
        } //End collapsed parenthetic
        InetAddress var8655A4EE53FB8FBE3B9196FE317ADFA6_814913403 = (impl.getInetAddress());
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!isBound()) {
            //return null;
        //}
        //return impl.getInetAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.273 -0400", hash_original_method = "F5BB694DF3469EBFBD82064FFB1FEAE0", hash_generated_method = "5A891FB2A32AE45887EE109FA6E495B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLocalPort() {
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_588933331 = (!isBound());
        } //End collapsed parenthetic
        int var5201144B0B742B3A152781D672D1AA30_2020824714 = (impl.getLocalPort());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (!isBound()) {
            //return -1;
        //}
        //return impl.getLocalPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.273 -0400", hash_original_method = "37BE74568AC5DDD629C634B42E81BFFA", hash_generated_method = "36E2F8DD1CAD2CDE5DF1497C5AB2CBBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int getSoTimeout() throws IOException {
        checkOpen();
        int var97D6E04E407212E66322CDB8618B167A_1408141041 = (((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.273 -0400", hash_original_method = "BFFC5C44CB4D0AB53035D05D9EAC93F6", hash_generated_method = "C0B7EBFB45EB573BDD39B99CB096A4DE")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.274 -0400", hash_original_method = "AD596D4AF4B8C0F4CC7CCD1314618053", hash_generated_method = "A0F82496A72050EBD804B93C615C7799")
    public static synchronized void setSocketFactory(SocketImplFactory aFactory) throws IOException {
        if (factory != null) {
            throw new SocketException("Factory already set");
        }
        factory = aFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.274 -0400", hash_original_method = "E2A5F03981AB4BF932E59A553E83FA6F", hash_generated_method = "84D4D01E87071630BA1D7080CD98EE9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setSoTimeout(int timeout) throws SocketException {
        dsTaint.addTaint(timeout);
        checkOpen();
        {
            throw new IllegalArgumentException("timeout < 0");
        } //End block
        impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(timeout));
        // ---------- Original Method ----------
        //checkOpen();
        //if (timeout < 0) {
            //throw new IllegalArgumentException("timeout < 0");
        //}
        //impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.274 -0400", hash_original_method = "577ACC2D572353EA5861EB3648159EF5", hash_generated_method = "1E65F856261087C662D3FA0A61A02715")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder result;
        result = new StringBuilder(64);
        result.append("ServerSocket[");
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_573240041 = (!isBound());
            {
                String var69511D4645BCAB730FF5BC75190F418D_684434241 = (result.append("unbound]").toString());
            } //End block
        } //End collapsed parenthetic
        String var23BFA7FA936085D92F57EFEE5EB62CDB_1260138898 = (result.append("addr=")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.274 -0400", hash_original_method = "AB1F91AE5F8F2B3C00C4EDCF73D5B4D1", hash_generated_method = "E60E73A0D5AE0EA089894BF572BBA1E9")
    @DSModeled(DSC.SAFE)
    public void bind(SocketAddress localAddr) throws IOException {
        dsTaint.addTaint(localAddr.dsTaint);
        bind(localAddr, DEFAULT_BACKLOG);
        // ---------- Original Method ----------
        //bind(localAddr, DEFAULT_BACKLOG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.274 -0400", hash_original_method = "684D242B2EA0BE4D55F437B908E9CC5D", hash_generated_method = "99C5DB299F3A51E059E30BCF16685C57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void bind(SocketAddress localAddr, int backlog) throws IOException {
        dsTaint.addTaint(backlog);
        dsTaint.addTaint(localAddr.dsTaint);
        checkOpen();
        {
            boolean var508204320144CEB3F447DE9CCDB64480_469206079 = (isBound());
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
                boolean varC74AE0463916E813FB227E6D8242C56F_618935435 = ((addr = inetAddr.getAddress()) == null);
                {
                    throw new SocketException("Host is unresolved: " + inetAddr.getHostName());
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
                throw e;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.274 -0400", hash_original_method = "7AD76537AA5A3220834213189640F2E9", hash_generated_method = "CE57444B4A943EAB2840ECDBEAA1BDA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketAddress getLocalSocketAddress() {
        {
            boolean var13C5778A8A7AC802C9965161944F9D76_1345720130 = (!isBound());
        } //End collapsed parenthetic
        SocketAddress var06DDF77B9872AAD14EEF94CC7935F976_1192744130 = (new InetSocketAddress(getInetAddress(), getLocalPort()));
        return (SocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!isBound()) {
            //return null;
        //}
        //return new InetSocketAddress(getInetAddress(), getLocalPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.274 -0400", hash_original_method = "589AFDD4CA6BF38ABB5F59E26BB3DC6D", hash_generated_method = "71C24249871CE72B5BCEABAEC42F76D4")
    @DSModeled(DSC.SAFE)
    public boolean isBound() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isBound;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.274 -0400", hash_original_method = "2EEDDDEB8BA1CD500E3647BC397BF54F", hash_generated_method = "F57EE74D737F6E5DBA9F54953A0BCBE7")
    @DSModeled(DSC.SAFE)
    public boolean isClosed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isClosed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.274 -0400", hash_original_method = "8DC54C39C6445BAF3181407C830C5887", hash_generated_method = "65F4AA136752D9867107BA14271BA738")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkOpen() throws SocketException {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_318889999 = (isClosed());
            {
                throw new SocketException("Socket is closed");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isClosed()) {
            //throw new SocketException("Socket is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.274 -0400", hash_original_method = "D6CD69E67882E49578E557811A0FC457", hash_generated_method = "FE895CC7DF5341F874F3FB374349DD89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setReuseAddress(boolean reuse) throws SocketException {
        dsTaint.addTaint(reuse);
        checkOpen();
        impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
        // ---------- Original Method ----------
        //checkOpen();
        //impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.274 -0400", hash_original_method = "8920D58954E3583481E89192EF874E86", hash_generated_method = "7D1DF7FE6517218D3EE9D1EB54909BFF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getReuseAddress() throws SocketException {
        checkOpen();
        boolean var92F4A5EAF76459C680E3D19F2BDB3A81_1792005278 = (((Boolean) impl.getOption(SocketOptions.SO_REUSEADDR)).booleanValue());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Boolean) impl.getOption(SocketOptions.SO_REUSEADDR)).booleanValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.275 -0400", hash_original_method = "4A5F0E88940F2B7162C81724AB1FDFE4", hash_generated_method = "315213ACBD4FD76061262984E390AC38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setReceiveBufferSize(int size) throws SocketException {
        dsTaint.addTaint(size);
        checkOpen();
        {
            throw new IllegalArgumentException("size < 1");
        } //End block
        impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
        // ---------- Original Method ----------
        //checkOpen();
        //if (size < 1) {
            //throw new IllegalArgumentException("size < 1");
        //}
        //impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.275 -0400", hash_original_method = "1025A74ACDCA065D38BE1D18813D43DB", hash_generated_method = "F7C0BA78478DFF589C0883D209F3ADDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getReceiveBufferSize() throws SocketException {
        checkOpen();
        int var879D57EDA18A262547327AC0C51A7315_816080507 = (((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.275 -0400", hash_original_method = "3D28E6253835634FC7711C1CE3F0C48B", hash_generated_method = "9F9684F41225ADA20A661BB43FC18814")
    @DSModeled(DSC.SAFE)
    public ServerSocketChannel getChannel() {
        return (ServerSocketChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.275 -0400", hash_original_method = "EE4DCDA11944F25F3B6AAA6A92D8AD2F", hash_generated_method = "381FE2FA3234C0D77531C5FD7148371B")
    @DSModeled(DSC.SAFE)
    public void setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
        dsTaint.addTaint(latency);
        dsTaint.addTaint(connectionTime);
        dsTaint.addTaint(bandwidth);
        // ---------- Original Method ----------
    }

    
}


