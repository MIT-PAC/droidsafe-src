package libcore.net.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import libcore.io.IoUtils;
import libcore.util.Objects;
import org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl;

final class HttpConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.162 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "8E0ACE0F30850C9F1F71EFC5F985F46E")

    private Address address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.162 -0400", hash_original_field = "61F2529360AEC54F5DC9804B842CF3FA", hash_generated_field = "8626E3C3C4BFCB66E8863775B28E01CC")

    private Socket socket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.162 -0400", hash_original_field = "267171E6BFB2A04E5670F3CE06C59060", hash_generated_field = "92444C781A1F5D159CDAA9528EFB69D8")

    private InputStream inputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.162 -0400", hash_original_field = "BE2DEEC210B01069983CFC5912275FFC", hash_generated_field = "765C7DA707EC84D85188E77508C6D245")

    private OutputStream outputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.163 -0400", hash_original_field = "35A6B86135C918691DB6BDDEEDC40F5D", hash_generated_field = "649CC3E68690FE0D5C49F1CB1C97C793")

    private SSLSocket unverifiedSocket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.163 -0400", hash_original_field = "57145BE2C615DF714549C7E2CB75DFBA", hash_generated_field = "CE8322B162FF12735FB871E7AA8B8BA9")

    private SSLSocket sslSocket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.163 -0400", hash_original_field = "7F29EFC37D2FAB75329714E35FF0FA41", hash_generated_field = "1135E3111E26F3F567DE353BD59C3E31")

    private InputStream sslInputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.163 -0400", hash_original_field = "9849A86BF3DB5860C860E92D92CF41D0", hash_generated_field = "A6FD5A356329B1E885E1D97B809AB43D")

    private OutputStream sslOutputStream;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.164 -0400", hash_original_method = "02721492ABE8A93C98AFD47B69F8145D", hash_generated_method = "8B5A41DCE4287AB5E9EE389E3BB7C358")
    private  HttpConnection(Address config, int connectTimeout) throws IOException {
        addTaint(connectTimeout);
        this.address = config;
        Socket socketCandidate = null;
        InetAddress[] addresses = InetAddress.getAllByName(config.socketHost);
for(int i = 0;i < addresses.length;i++)
        {
            socketCandidate = (config.proxy != null && config.proxy.type() != Proxy.Type.HTTP)
                    ? new Socket(config.proxy)
                    : new Socket();
            try 
            {
                socketCandidate.connect(
                        new InetSocketAddress(addresses[i], config.socketPort), connectTimeout);
                break;
            } 
            catch (IOException e)
            {
    if(i == addresses.length - 1)                
                {
                    e.addTaint(taint);
                    throw e;
                } 
            } 
        } 
        this.socket = socketCandidate;
        
        
        
        
        
            
                    
                    
            
                
                        
                
            
                
                    
                
            
        
        
    }

    
        @DSModeled(DSC.SPEC)
    public static HttpConnection connect(URI uri, Proxy proxy, boolean requiresTunnel,
            int connectTimeout) throws IOException {
        if (proxy != null) {
            Address address = (proxy.type() == Proxy.Type.DIRECT)
                    ? new Address(uri)
                    : new Address(uri, proxy, requiresTunnel);
            return HttpConnectionPool.INSTANCE.get(address, connectTimeout);
        }
        ProxySelector selector = ProxySelector.getDefault();
        List<Proxy> proxyList = selector.select(uri);
        if (proxyList != null) {
            for (Proxy selectedProxy : proxyList) {
                if (selectedProxy.type() == Proxy.Type.DIRECT) {
                    continue;
                }
                try {
                    Address address = new Address(uri, selectedProxy, requiresTunnel);
                    return HttpConnectionPool.INSTANCE.get(address, connectTimeout);
                } catch (IOException e) {
                    selector.connectFailed(uri, selectedProxy.address(), e);
                }
            }
        }
        return HttpConnectionPool.INSTANCE.get(new Address(uri), connectTimeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.165 -0400", hash_original_method = "50D4F2062BD74B4850A586FC88599309", hash_generated_method = "B63879B3617FE401C7B93A2945C0011E")
    public void closeSocketAndStreams() {
        IoUtils.closeQuietly(sslOutputStream);
        IoUtils.closeQuietly(sslInputStream);
        IoUtils.closeQuietly(sslSocket);
        IoUtils.closeQuietly(outputStream);
        IoUtils.closeQuietly(inputStream);
        IoUtils.closeQuietly(socket);
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.166 -0400", hash_original_method = "8353DEF033DB8B4F652D08F1BE7D5FB2", hash_generated_method = "A82B590F32C47AA40176D8DE6DF154BE")
    public void setSoTimeout(int readTimeout) throws SocketException {
        addTaint(readTimeout);
        socket.setSoTimeout(readTimeout);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.166 -0400", hash_original_method = "97D9B93978E46D1095C2BFB6FD92F6AE", hash_generated_method = "0A146B81A7D3A444D1BA805DA3473D47")
    public OutputStream getOutputStream() throws IOException {
    if(sslSocket != null)        
        {
    if(sslOutputStream == null)            
            {
                sslOutputStream = sslSocket.getOutputStream();
            } 
OutputStream var7B5142EB61F03E732FF06E13D3F423AA_1673138871 =             sslOutputStream;
            var7B5142EB61F03E732FF06E13D3F423AA_1673138871.addTaint(taint);
            return var7B5142EB61F03E732FF06E13D3F423AA_1673138871;
        } 
        else
    if(outputStream == null)        
        {
            outputStream = socket.getOutputStream();
        } 
OutputStream var864D919353B9AF56DB2472A4EBA3E730_1137061226 =         outputStream;
        var864D919353B9AF56DB2472A4EBA3E730_1137061226.addTaint(taint);
        return var864D919353B9AF56DB2472A4EBA3E730_1137061226;
        
        
            
                
            
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.167 -0400", hash_original_method = "1360CB9715FEE0D075363C3EF21DD92C", hash_generated_method = "F8549FBD93A27AD2B8BB3EFCCB5BE548")
    public InputStream getInputStream() throws IOException {
    if(sslSocket != null)        
        {
    if(sslInputStream == null)            
            {
                sslInputStream = sslSocket.getInputStream();
            } 
InputStream var07CB6F88FDC48DE9052B515D7A2AE8F3_1582222208 =             sslInputStream;
            var07CB6F88FDC48DE9052B515D7A2AE8F3_1582222208.addTaint(taint);
            return var07CB6F88FDC48DE9052B515D7A2AE8F3_1582222208;
        } 
        else
    if(inputStream == null)        
        {
            int bufferSize = 128;
            inputStream = address.requiresTunnel
                    ? socket.getInputStream()
                    : new BufferedInputStream(socket.getInputStream(), bufferSize);
        } 
InputStream var6D6AA0B6E97941129A02DB042FF8CF68_447948005 =         inputStream;
        var6D6AA0B6E97941129A02DB042FF8CF68_447948005.addTaint(taint);
        return var6D6AA0B6E97941129A02DB042FF8CF68_447948005;
        
        
            
                
            
            
        
            
            
                    
                    
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.168 -0400", hash_original_method = "EA9CBC15CAAA468AF10BBF1CD02918CF", hash_generated_method = "41FBE1BA04C0F533B97B2C0DD56A880D")
    protected Socket getSocket() {
Socket varC212647F359587E811E8677EDC2BCF85_693779556 =         sslSocket != null ? sslSocket : socket;
        varC212647F359587E811E8677EDC2BCF85_693779556.addTaint(taint);
        return varC212647F359587E811E8677EDC2BCF85_693779556;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.168 -0400", hash_original_method = "9472CD13980FF331A1EC2B82F4638C6F", hash_generated_method = "ECE67E5792974A73E05CADACA98BE7DE")
    public Address getAddress() {
Address var814577DDD37BAFB17E08CBEFDB411BAE_1855245961 =         address;
        var814577DDD37BAFB17E08CBEFDB411BAE_1855245961.addTaint(taint);
        return var814577DDD37BAFB17E08CBEFDB411BAE_1855245961;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.169 -0400", hash_original_method = "15C1B21595200C1DF5857AC28380107D", hash_generated_method = "27A65744B31750F4886100F50B65BF2E")
    public void setupSecureSocket(SSLSocketFactory sslSocketFactory, boolean tlsTolerant) throws IOException {
        addTaint(tlsTolerant);
        unverifiedSocket = (SSLSocket) sslSocketFactory.createSocket(socket,
                address.uriHost, address.uriPort, true );
    if(tlsTolerant && unverifiedSocket instanceof OpenSSLSocketImpl)        
        {
            OpenSSLSocketImpl openSslSocket = (OpenSSLSocketImpl) unverifiedSocket;
            openSslSocket.setEnabledCompressionMethods(new String[] { "ZLIB"});
            openSslSocket.setUseSessionTickets(true);
            openSslSocket.setHostname(address.socketHost);
        } 
        else
        {
            unverifiedSocket.setEnabledProtocols(new String [] { "SSLv3" });
        } 
        unverifiedSocket.startHandshake();
        
        
                
        
            
            
            
            
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.169 -0400", hash_original_method = "E313A7AB78F75EDB07568DFA09A3BF60", hash_generated_method = "6F29BBD3E8946A567E2AF8E4251A40E4")
    public SSLSocket verifySecureSocketHostname(HostnameVerifier hostnameVerifier) throws IOException {
        addTaint(hostnameVerifier.getTaint());
    if(!hostnameVerifier.verify(address.uriHost, unverifiedSocket.getSession()))        
        {
            IOException var5BFC50F4CD50FCD50287EBAE7E101E24_1259581331 = new IOException("Hostname '" + address.uriHost + "' was not verified");
            var5BFC50F4CD50FCD50287EBAE7E101E24_1259581331.addTaint(taint);
            throw var5BFC50F4CD50FCD50287EBAE7E101E24_1259581331;
        } 
        sslSocket = unverifiedSocket;
SSLSocket var483A6DFBDF2AF13A3CF8A0177BC684A5_378070476 =         sslSocket;
        var483A6DFBDF2AF13A3CF8A0177BC684A5_378070476.addTaint(taint);
        return var483A6DFBDF2AF13A3CF8A0177BC684A5_378070476;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.170 -0400", hash_original_method = "0390CC00C23D2289E08AFB9047DDDB88", hash_generated_method = "4374FBD1BB6F222C062C373C3808ACD6")
    public SSLSocket getSecureSocketIfConnected() {
SSLSocket var483A6DFBDF2AF13A3CF8A0177BC684A5_643544812 =         sslSocket;
        var483A6DFBDF2AF13A3CF8A0177BC684A5_643544812.addTaint(taint);
        return var483A6DFBDF2AF13A3CF8A0177BC684A5_643544812;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.170 -0400", hash_original_method = "197418179C71EABCF647B3FA4C9F9D3C", hash_generated_method = "D3A60C4B780B47232FFAE6B5A974FFDE")
     boolean isStale() throws IOException {
    if(!isEligibleForRecycling())        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1810236191 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1449401000 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1449401000;
        } 
        InputStream in = getInputStream();
    if(in.available() > 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_771575099 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1342461397 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1342461397;
        } 
        Socket socket = getSocket();
        int soTimeout = socket.getSoTimeout();
        try 
        {
            socket.setSoTimeout(1);
            in.mark(1);
            int byteRead = in.read();
    if(byteRead != -1)            
            {
                in.reset();
                boolean var68934A3E9455FA72420237EB05902327_1986094501 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2123485500 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2123485500;
            } 
            boolean varB326B5062B2F0E69046810717534CB09_707789161 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_696070719 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_696070719;
        } 
        catch (SocketTimeoutException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1429470718 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_244981334 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_244981334;
        } 
        catch (IOException e)
        {
            boolean varB326B5062B2F0E69046810717534CB09_1777105181 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1695645378 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1695645378;
        } 
        finally 
        {
            socket.setSoTimeout(soTimeout);
        } 
        
        
            
        
        
        
            
        
        
        
        
            
            
            
            
                
                
            
            
        
            
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.171 -0400", hash_original_method = "10486D7D4909022462833E73661236C1", hash_generated_method = "684A514C08D5020542E92DD1DC564E23")
    protected boolean isEligibleForRecycling() {
        boolean var69C69396EB6626A84180EE6B19182F45_1962127286 = (!socket.isClosed()
                && !socket.isInputShutdown()
                && !socket.isOutputShutdown());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2074295671 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2074295671;
        
        
                
                
    }

    
    public static final class Address {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.172 -0400", hash_original_field = "431387EB7262E1CFC79B125EB8A67C60", hash_generated_field = "EE0BB8F1739D62A5A5C8EDF7D478A66B")

        private Proxy proxy;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.172 -0400", hash_original_field = "CC28AE9251E6147BF76E0CB323DC3286", hash_generated_field = "07AEE931A3DB127ADD85468783C7312B")

        private boolean requiresTunnel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.172 -0400", hash_original_field = "A73597CDD217965CB3BDD6F840530FA2", hash_generated_field = "2E25E6A02EC1EA9F050C57679AE98E79")

        private String uriHost;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.172 -0400", hash_original_field = "E303D03FFD439EEA6DF993A2BD678A7D", hash_generated_field = "E82B694E22483837DC8A7FA45AAFFD3E")

        private int uriPort;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.172 -0400", hash_original_field = "44D85B9165E3687DE1B20F831C8ACC96", hash_generated_field = "B2FB257AF7E44452ADEDE39DC00B96E5")

        private String socketHost;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.172 -0400", hash_original_field = "29CB723510D405BDECD2AB1AE955037B", hash_generated_field = "B6CE69B75628186CDBBBC00DA03652CE")

        private int socketPort;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.173 -0400", hash_original_method = "56C3F1DA7938694CED60FE34095C0213", hash_generated_method = "2090EDCF2F749D57DB0C828E6D058B86")
        public  Address(URI uri) {
            this.proxy = null;
            this.requiresTunnel = false;
            this.uriHost = uri.getHost();
            this.uriPort = uri.getEffectivePort();
            this.socketHost = uriHost;
            this.socketPort = uriPort;
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.174 -0400", hash_original_method = "A6C9CB15451FF69F0D42BB48C7372F2F", hash_generated_method = "C9F78A91F8BA40A4A360389BE7C526FD")
        public  Address(URI uri, Proxy proxy, boolean requiresTunnel) {
            this.proxy = proxy;
            this.requiresTunnel = requiresTunnel;
            this.uriHost = uri.getHost();
            this.uriPort = uri.getEffectivePort();
            SocketAddress proxyAddress = proxy.address();
    if(!(proxyAddress instanceof InetSocketAddress))            
            {
                IllegalArgumentException var1F52054C8BC1E59292A12BEABE1E9089_1137587571 = new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: "
                        + proxyAddress.getClass());
                var1F52054C8BC1E59292A12BEABE1E9089_1137587571.addTaint(taint);
                throw var1F52054C8BC1E59292A12BEABE1E9089_1137587571;
            } 
            InetSocketAddress proxySocketAddress = (InetSocketAddress) proxyAddress;
            this.socketHost = proxySocketAddress.getHostName();
            this.socketPort = proxySocketAddress.getPort();
            
            
            
            
            
            
            
                
                        
            
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.174 -0400", hash_original_method = "19AE87D83FEEE8E799F844F8A7A84495", hash_generated_method = "3FC7B383839AE6742611A69BBF2EE404")
        public Proxy getProxy() {
Proxy var60FC9F22F7E863EBFD33B2ADB8462743_173573983 =             proxy;
            var60FC9F22F7E863EBFD33B2ADB8462743_173573983.addTaint(taint);
            return var60FC9F22F7E863EBFD33B2ADB8462743_173573983;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.175 -0400", hash_original_method = "104FF09B2C80755ABB27A6E9EA994C0B", hash_generated_method = "2272071EFF6E1077A7F4A1792049675B")
        @Override
        public boolean equals(Object other) {
            addTaint(other.getTaint());
    if(other instanceof Address)            
            {
                Address that = (Address) other;
                boolean var8F068D1C58AF4742374233BC1D4E4289_2115590778 = (Objects.equal(this.proxy, that.proxy)
                        && this.uriHost.equals(that.uriHost)
                        && this.uriPort == that.uriPort
                        && this.requiresTunnel == that.requiresTunnel);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_383930358 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_383930358;
            } 
            boolean var68934A3E9455FA72420237EB05902327_1284661527 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_762301129 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_762301129;
            
            
                
                
                        
                        
                        
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.176 -0400", hash_original_method = "03AAE27C923B9ECFDFA09DAEE6900F4B", hash_generated_method = "853116991B03D35B04167759491EBD0A")
        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + uriHost.hashCode();
            result = 31 * result + uriPort;
            result = 31 * result + (proxy != null ? proxy.hashCode() : 0);
            result = 31 * result + (requiresTunnel ? 1 : 0);
            int varB4A88417B3D0170D754C647C30B7216A_382678924 = (result);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_590318792 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_590318792;
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.176 -0400", hash_original_method = "D7960E9C2008885C55D097BA1D2C0C2A", hash_generated_method = "FF979273AEDB10E266A124305163FB90")
        public HttpConnection connect(int connectTimeout) throws IOException {
            addTaint(connectTimeout);
HttpConnection var15B1551A9B509FD6847E854F6B8CB9B1_1001603007 =             new HttpConnection(this, connectTimeout);
            var15B1551A9B509FD6847E854F6B8CB9B1_1001603007.addTaint(taint);
            return var15B1551A9B509FD6847E854F6B8CB9B1_1001603007;
            
            
        }

        
    }


    
}

