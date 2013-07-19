package java.net;

// Droidsafe Imports
import java.io.IOException;
import java.nio.channels.ServerSocketChannel;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ServerSocket {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.397 -0400", hash_original_field = "86CCEC3D9FF0E9C0514506E982CDC08B", hash_generated_field = "E5435F593B4B4C544AAC5D578CFF6639")

    private SocketImpl impl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.397 -0400", hash_original_field = "8E4D35088206920061AAF7F347854388", hash_generated_field = "C0B93BC213B673FF2E47783C561E2823")

    private boolean isBound;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.397 -0400", hash_original_field = "7587750400D3C39AEAD7C1489F6FE7F3", hash_generated_field = "61C76B683BBEFCB5006250611D355A94")

    private boolean isClosed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.398 -0400", hash_original_method = "31BB74D5896D397B1327C5B34E5CB836", hash_generated_method = "CC783DD97FFEF08036B1A4D90EFE45DF")
    public  ServerSocket() throws IOException {
        this.impl = factory != null ? factory.createSocketImpl()
                : new PlainServerSocketImpl();
        impl.create(true);
        // ---------- Original Method ----------
        //this.impl = factory != null ? factory.createSocketImpl()
                //: new PlainServerSocketImpl();
        //impl.create(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.398 -0400", hash_original_method = "17E5A7EAB5FF74551872A5C22051BFB5", hash_generated_method = "8188B0E7B9ACD2CC1652950807628542")
    public  ServerSocket(int port) throws IOException {
        this(port, DEFAULT_BACKLOG, Inet4Address.ANY);
        addTaint(port);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.399 -0400", hash_original_method = "B81C30D251B31CAFF71CF07C7882EF32", hash_generated_method = "5E60D2AA7E8E24F5C7A4E8B8BC5853C8")
    public  ServerSocket(int port, int backlog) throws IOException {
        this(port, backlog, Inet4Address.ANY);
        addTaint(backlog);
        addTaint(port);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.400 -0400", hash_original_method = "6BB36DC8E15E305D7407A47C7739996C", hash_generated_method = "8B35ED605D06BC9EBDBD3C7169A90016")
    public  ServerSocket(int port, int backlog, InetAddress localAddress) throws IOException {
        addTaint(localAddress.getTaint());
        addTaint(backlog);
        addTaint(port);
        checkListen(port);
        this.impl = factory != null ? factory.createSocketImpl()
                : new PlainServerSocketImpl();
        InetAddress addr = (localAddress == null) ? Inet4Address.ANY : localAddress;
        synchronized
(this)        {
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
                e.addTaint(taint);
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.400 -0400", hash_original_method = "847F07D140851DC7DF04F3DA230B7EED", hash_generated_method = "A201778D2E5385B4A76F7006FAAAB8D9")
    public SocketImpl getImpl$() {
SocketImpl var74FA8C26D7EF8FBF7B1B8FAD3221C166_1570641916 =         impl;
        var74FA8C26D7EF8FBF7B1B8FAD3221C166_1570641916.addTaint(taint);
        return var74FA8C26D7EF8FBF7B1B8FAD3221C166_1570641916;
        // ---------- Original Method ----------
        //return impl;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.401 -0400", hash_original_method = "DE0153D2AABFEE83527E2EAC5D1F68DF", hash_generated_method = "9362F6BF7D3C193603412ED288315C6B")
    public Socket accept() throws IOException {
        checkOpen();
        if(!isBound())        
        {
            SocketException var1E7AB0F97C6ADCF4441C35280C53EC43_1564841570 = new SocketException("Socket is not bound");
            var1E7AB0F97C6ADCF4441C35280C53EC43_1564841570.addTaint(taint);
            throw var1E7AB0F97C6ADCF4441C35280C53EC43_1564841570;
        } //End block
        Socket aSocket = new Socket();
        try 
        {
            implAccept(aSocket);
        } //End block
        catch (IOException e)
        {
            aSocket.close();
            e.addTaint(taint);
            throw e;
        } //End block
Socket varDBA8EAD1551D6943828EF63869B4FDF3_605925506 =         aSocket;
        varDBA8EAD1551D6943828EF63869B4FDF3_605925506.addTaint(taint);
        return varDBA8EAD1551D6943828EF63869B4FDF3_605925506;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.401 -0400", hash_original_method = "C273B8F533783A3DE90657F5715801E0", hash_generated_method = "7AC3B5B4DE9FBD5303205AD6FB6F5CEA")
    private void checkListen(int aPort) {
        addTaint(aPort);
        if(aPort < 0 || aPort > 65535)        
        {
            IllegalArgumentException varBD3B2D468FFD082696C46A032ABFAA1F_2087966055 = new IllegalArgumentException("Port out of range: " + aPort);
            varBD3B2D468FFD082696C46A032ABFAA1F_2087966055.addTaint(taint);
            throw varBD3B2D468FFD082696C46A032ABFAA1F_2087966055;
        } //End block
        // ---------- Original Method ----------
        //if (aPort < 0 || aPort > 65535) {
            //throw new IllegalArgumentException("Port out of range: " + aPort);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.402 -0400", hash_original_method = "8636C7CEC5FFD33F6CBF2C75F9E6A135", hash_generated_method = "09C692F3B9ABE75F75305B3C4044C0D5")
    public void close() throws IOException {
        isClosed = true;
        impl.close();
        // ---------- Original Method ----------
        //isClosed = true;
        //impl.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.402 -0400", hash_original_method = "0AAA019638F2B2CC41FFEEEB4E260F6C", hash_generated_method = "D2A1CBFF888748412C426E678E23160B")
    public InetAddress getInetAddress() {
        if(!isBound())        
        {
InetAddress var540C13E9E156B687226421B24F2DF178_1948301781 =             null;
            var540C13E9E156B687226421B24F2DF178_1948301781.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1948301781;
        } //End block
InetAddress var521AFCEA60D8F5BBF63C4443E3C3E08B_405509798 =         impl.getInetAddress();
        var521AFCEA60D8F5BBF63C4443E3C3E08B_405509798.addTaint(taint);
        return var521AFCEA60D8F5BBF63C4443E3C3E08B_405509798;
        // ---------- Original Method ----------
        //if (!isBound()) {
            //return null;
        //}
        //return impl.getInetAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.402 -0400", hash_original_method = "F5BB694DF3469EBFBD82064FFB1FEAE0", hash_generated_method = "DFB6974D60386D379D24FCEA4A317BD2")
    public int getLocalPort() {
        if(!isBound())        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1794982293 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1215881949 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1215881949;
        } //End block
        int var141B5401A04AE23DB4012052769AA414_209051120 = (impl.getLocalPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1264281177 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1264281177;
        // ---------- Original Method ----------
        //if (!isBound()) {
            //return -1;
        //}
        //return impl.getLocalPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.403 -0400", hash_original_method = "37BE74568AC5DDD629C634B42E81BFFA", hash_generated_method = "DF865B340AFBB937748CD96D4C240B3A")
    public synchronized int getSoTimeout() throws IOException {
        checkOpen();
        int varD9ED706581E59D8A02AABC09446C91B3_1252326013 = (((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_138005201 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_138005201;
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.403 -0400", hash_original_method = "BFFC5C44CB4D0AB53035D05D9EAC93F6", hash_generated_method = "66192A66A7FE198BC1B4269386344D92")
    protected final void implAccept(Socket aSocket) throws IOException {
        addTaint(aSocket.getTaint());
        synchronized
(this)        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.403 -0400", hash_original_method = "E2A5F03981AB4BF932E59A553E83FA6F", hash_generated_method = "900719D57DB285EA0B463FBF3D9662CB")
    public synchronized void setSoTimeout(int timeout) throws SocketException {
        addTaint(timeout);
        checkOpen();
        if(timeout < 0)        
        {
            IllegalArgumentException varBA4E54C08633B7FB6474427FE4B69BA6_1055992914 = new IllegalArgumentException("timeout < 0");
            varBA4E54C08633B7FB6474427FE4B69BA6_1055992914.addTaint(taint);
            throw varBA4E54C08633B7FB6474427FE4B69BA6_1055992914;
        } //End block
        impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(timeout));
        // ---------- Original Method ----------
        //checkOpen();
        //if (timeout < 0) {
            //throw new IllegalArgumentException("timeout < 0");
        //}
        //impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.404 -0400", hash_original_method = "577ACC2D572353EA5861EB3648159EF5", hash_generated_method = "8822CB0EC787CE2BF6AC5FF138C64779")
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(64);
        result.append("ServerSocket[");
        if(!isBound())        
        {
String varA50A73BC8360CB52B406F01D7893C2EC_273851706 =             result.append("unbound]").toString();
            varA50A73BC8360CB52B406F01D7893C2EC_273851706.addTaint(taint);
            return varA50A73BC8360CB52B406F01D7893C2EC_273851706;
        } //End block
String var66C5C98E53F4F49C00EC8B0EB3A70AF2_1400548384 =         result.append("addr=")
                .append(getInetAddress().getHostName()).append("/")
                .append(getInetAddress().getHostAddress()).append(
                        ",port=0,localport=")
                .append(getLocalPort()).append("]")
                .toString();
        var66C5C98E53F4F49C00EC8B0EB3A70AF2_1400548384.addTaint(taint);
        return var66C5C98E53F4F49C00EC8B0EB3A70AF2_1400548384;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.404 -0400", hash_original_method = "AB1F91AE5F8F2B3C00C4EDCF73D5B4D1", hash_generated_method = "721C96CC97176C1FBB7892E4FB13B468")
    public void bind(SocketAddress localAddr) throws IOException {
        addTaint(localAddr.getTaint());
        bind(localAddr, DEFAULT_BACKLOG);
        // ---------- Original Method ----------
        //bind(localAddr, DEFAULT_BACKLOG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.405 -0400", hash_original_method = "684D242B2EA0BE4D55F437B908E9CC5D", hash_generated_method = "4BE8A57F27C1CC4A495407623AF93AFE")
    public void bind(SocketAddress localAddr, int backlog) throws IOException {
        addTaint(backlog);
        addTaint(localAddr.getTaint());
        checkOpen();
        if(isBound())        
        {
            BindException varF1BB61747164E86D14B4203A7B687A13_707590734 = new BindException("Socket is already bound");
            varF1BB61747164E86D14B4203A7B687A13_707590734.addTaint(taint);
            throw varF1BB61747164E86D14B4203A7B687A13_707590734;
        } //End block
        int port = 0;
        InetAddress addr = Inet4Address.ANY;
        if(localAddr != null)        
        {
            if(!(localAddr instanceof InetSocketAddress))            
            {
                IllegalArgumentException varC26B139CE5269510432F181AB5FE9596_263661608 = new IllegalArgumentException("Local address not an InetSocketAddress: " +
                        localAddr.getClass());
                varC26B139CE5269510432F181AB5FE9596_263661608.addTaint(taint);
                throw varC26B139CE5269510432F181AB5FE9596_263661608;
            } //End block
            InetSocketAddress inetAddr = (InetSocketAddress) localAddr;
            if((addr = inetAddr.getAddress()) == null)            
            {
                SocketException var815C915B1B299CF5E8808EFB2314BEE5_1849052175 = new SocketException("Host is unresolved: " + inetAddr.getHostName());
                var815C915B1B299CF5E8808EFB2314BEE5_1849052175.addTaint(taint);
                throw var815C915B1B299CF5E8808EFB2314BEE5_1849052175;
            } //End block
            port = inetAddr.getPort();
        } //End block
        synchronized
(this)        {
            try 
            {
                impl.bind(addr, port);
                isBound = true;
                impl.listen(backlog > 0 ? backlog : DEFAULT_BACKLOG);
            } //End block
            catch (IOException e)
            {
                close();
                e.addTaint(taint);
                throw e;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.406 -0400", hash_original_method = "7AD76537AA5A3220834213189640F2E9", hash_generated_method = "0250FD692F69A71EC2A8E863CFCD377E")
    public SocketAddress getLocalSocketAddress() {
        if(!isBound())        
        {
SocketAddress var540C13E9E156B687226421B24F2DF178_337947069 =             null;
            var540C13E9E156B687226421B24F2DF178_337947069.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_337947069;
        } //End block
SocketAddress var71FAAB01987C8CA7A40E22DA9ADD06A6_549007986 =         new InetSocketAddress(getInetAddress(), getLocalPort());
        var71FAAB01987C8CA7A40E22DA9ADD06A6_549007986.addTaint(taint);
        return var71FAAB01987C8CA7A40E22DA9ADD06A6_549007986;
        // ---------- Original Method ----------
        //if (!isBound()) {
            //return null;
        //}
        //return new InetSocketAddress(getInetAddress(), getLocalPort());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.407 -0400", hash_original_method = "589AFDD4CA6BF38ABB5F59E26BB3DC6D", hash_generated_method = "C5DBF84A44E7C89AD45A31B9CCC99C2D")
    public boolean isBound() {
        boolean var8E4D35088206920061AAF7F347854388_1098304559 = (isBound);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1015884895 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1015884895;
        // ---------- Original Method ----------
        //return isBound;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.407 -0400", hash_original_method = "2EEDDDEB8BA1CD500E3647BC397BF54F", hash_generated_method = "0093EADA4766ECAD4841C240B8176CB6")
    public boolean isClosed() {
        boolean var7587750400D3C39AEAD7C1489F6FE7F3_44984111 = (isClosed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2052782859 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2052782859;
        // ---------- Original Method ----------
        //return isClosed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.408 -0400", hash_original_method = "8DC54C39C6445BAF3181407C830C5887", hash_generated_method = "F90C8ADFD3E758F9CE8E995684A96197")
    private void checkOpen() throws SocketException {
        if(isClosed())        
        {
            SocketException var5AD72407DD9337ABED4666C49A30EC41_1022952508 = new SocketException("Socket is closed");
            var5AD72407DD9337ABED4666C49A30EC41_1022952508.addTaint(taint);
            throw var5AD72407DD9337ABED4666C49A30EC41_1022952508;
        } //End block
        // ---------- Original Method ----------
        //if (isClosed()) {
            //throw new SocketException("Socket is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.409 -0400", hash_original_method = "D6CD69E67882E49578E557811A0FC457", hash_generated_method = "EB45E1C9E38CA5AD9C7AF6489F52E899")
    public void setReuseAddress(boolean reuse) throws SocketException {
        addTaint(reuse);
        checkOpen();
        impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
        // ---------- Original Method ----------
        //checkOpen();
        //impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.409 -0400", hash_original_method = "8920D58954E3583481E89192EF874E86", hash_generated_method = "D29473AEDC7AEF66DA528D1479A16A31")
    public boolean getReuseAddress() throws SocketException {
        checkOpen();
        boolean var5F25B35A5AB65D3270A0F9B4238F8C8D_1384162017 = (((Boolean) impl.getOption(SocketOptions.SO_REUSEADDR)).booleanValue());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1355191441 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1355191441;
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Boolean) impl.getOption(SocketOptions.SO_REUSEADDR)).booleanValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.410 -0400", hash_original_method = "4A5F0E88940F2B7162C81724AB1FDFE4", hash_generated_method = "84D583EE12BB7D57E358D23D28CBAC04")
    public void setReceiveBufferSize(int size) throws SocketException {
        addTaint(size);
        checkOpen();
        if(size < 1)        
        {
            IllegalArgumentException varE382BBE48942C4B3FA87CFD84F21DF8E_498921426 = new IllegalArgumentException("size < 1");
            varE382BBE48942C4B3FA87CFD84F21DF8E_498921426.addTaint(taint);
            throw varE382BBE48942C4B3FA87CFD84F21DF8E_498921426;
        } //End block
        impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
        // ---------- Original Method ----------
        //checkOpen();
        //if (size < 1) {
            //throw new IllegalArgumentException("size < 1");
        //}
        //impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.410 -0400", hash_original_method = "1025A74ACDCA065D38BE1D18813D43DB", hash_generated_method = "40DA1253402F74303E83982116DD1B9D")
    public int getReceiveBufferSize() throws SocketException {
        checkOpen();
        int varE81451D5C828E046B43EDC22DB07479E_2020040212 = (((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1590586548 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1590586548;
        // ---------- Original Method ----------
        //checkOpen();
        //return ((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.411 -0400", hash_original_method = "3D28E6253835634FC7711C1CE3F0C48B", hash_generated_method = "B1623D250017865E5E50BEB1518AE532")
    public ServerSocketChannel getChannel() {
ServerSocketChannel var540C13E9E156B687226421B24F2DF178_1746233473 =         null;
        var540C13E9E156B687226421B24F2DF178_1746233473.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1746233473;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.411 -0400", hash_original_method = "EE4DCDA11944F25F3B6AAA6A92D8AD2F", hash_generated_method = "2EE8865BF17B91491774A6BE2B19EEC0")
    public void setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
        addTaint(bandwidth);
        addTaint(latency);
        addTaint(connectionTime);
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.411 -0400", hash_original_field = "4E99CD0551993624E0E83995EFF618A2", hash_generated_field = "0D50DA6800F2DE564A61761F3E32E3F7")

    private static final int DEFAULT_BACKLOG = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.411 -0400", hash_original_field = "9549DD6065D019211460C59A86DD6536", hash_generated_field = "10D4EEC45D11B59A6B6543CD9427385B")

    static SocketImplFactory factory;
}

