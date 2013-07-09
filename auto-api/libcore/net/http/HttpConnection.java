package libcore.net.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.747 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "8E0ACE0F30850C9F1F71EFC5F985F46E")

    private Address address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.747 -0400", hash_original_field = "61F2529360AEC54F5DC9804B842CF3FA", hash_generated_field = "8626E3C3C4BFCB66E8863775B28E01CC")

    private Socket socket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.748 -0400", hash_original_field = "267171E6BFB2A04E5670F3CE06C59060", hash_generated_field = "92444C781A1F5D159CDAA9528EFB69D8")

    private InputStream inputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.748 -0400", hash_original_field = "BE2DEEC210B01069983CFC5912275FFC", hash_generated_field = "765C7DA707EC84D85188E77508C6D245")

    private OutputStream outputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.748 -0400", hash_original_field = "35A6B86135C918691DB6BDDEEDC40F5D", hash_generated_field = "649CC3E68690FE0D5C49F1CB1C97C793")

    private SSLSocket unverifiedSocket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.748 -0400", hash_original_field = "57145BE2C615DF714549C7E2CB75DFBA", hash_generated_field = "CE8322B162FF12735FB871E7AA8B8BA9")

    private SSLSocket sslSocket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.748 -0400", hash_original_field = "7F29EFC37D2FAB75329714E35FF0FA41", hash_generated_field = "1135E3111E26F3F567DE353BD59C3E31")

    private InputStream sslInputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.748 -0400", hash_original_field = "9849A86BF3DB5860C860E92D92CF41D0", hash_generated_field = "A6FD5A356329B1E885E1D97B809AB43D")

    private OutputStream sslOutputStream;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.748 -0400", hash_original_method = "02721492ABE8A93C98AFD47B69F8145D", hash_generated_method = "A503A02BD1A6E5C24E1098B5E604E3E6")
    private  HttpConnection(Address config, int connectTimeout) throws IOException {
        this.address = config;
        Socket socketCandidate = null;
        InetAddress[] addresses = InetAddress.getAllByName(config.socketHost);
        {
            int i = 0;
            {
                socketCandidate = (config.proxy != null && config.proxy.type() != Proxy.Type.HTTP)
                    ? new Socket(config.proxy)
                    : new Socket();
                try 
                {
                    socketCandidate.connect(
                        new InetSocketAddress(addresses[i], config.socketPort), connectTimeout);
                } 
                catch (IOException e)
                {
                    {
                        if (DroidSafeAndroidRuntime.control) throw e;
                    } 
                } 
            } 
        } 
        this.socket = socketCandidate;
        addTaint(connectTimeout);
        
        
        
        
        
            
                    
                    
            
                
                        
                
            
                
                    
                
            
        
        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.749 -0400", hash_original_method = "50D4F2062BD74B4850A586FC88599309", hash_generated_method = "B63879B3617FE401C7B93A2945C0011E")
    public void closeSocketAndStreams() {
        IoUtils.closeQuietly(sslOutputStream);
        IoUtils.closeQuietly(sslInputStream);
        IoUtils.closeQuietly(sslSocket);
        IoUtils.closeQuietly(outputStream);
        IoUtils.closeQuietly(inputStream);
        IoUtils.closeQuietly(socket);
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.749 -0400", hash_original_method = "8353DEF033DB8B4F652D08F1BE7D5FB2", hash_generated_method = "3222FA7BE8872A3008DD55002BF382F5")
    public void setSoTimeout(int readTimeout) throws SocketException {
        socket.setSoTimeout(readTimeout);
        addTaint(readTimeout);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.750 -0400", hash_original_method = "97D9B93978E46D1095C2BFB6FD92F6AE", hash_generated_method = "EF8BA228E6CD5A2F7E7DC7EA246BD962")
    public OutputStream getOutputStream() throws IOException {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_837450453 = null; 
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_1872855585 = null; 
        {
            {
                sslOutputStream = sslSocket.getOutputStream();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_837450453 = sslOutputStream;
        } 
        {
            outputStream = socket.getOutputStream();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1872855585 = outputStream;
        OutputStream varA7E53CE21691AB073D9660D615818899_1319093045; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1319093045 = varB4EAC82CA7396A68D541C85D26508E83_837450453;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1319093045 = varB4EAC82CA7396A68D541C85D26508E83_1872855585;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1319093045.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1319093045;
        
        
            
                
            
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.750 -0400", hash_original_method = "1360CB9715FEE0D075363C3EF21DD92C", hash_generated_method = "33E11705751170BC7EDE469E10B57885")
    public InputStream getInputStream() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_897155673 = null; 
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1879896022 = null; 
        {
            {
                sslInputStream = sslSocket.getInputStream();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_897155673 = sslInputStream;
        } 
        {
            int bufferSize = 128;
            inputStream = address.requiresTunnel
                    ? socket.getInputStream()
                    : new BufferedInputStream(socket.getInputStream(), bufferSize);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1879896022 = inputStream;
        InputStream varA7E53CE21691AB073D9660D615818899_1368190583; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1368190583 = varB4EAC82CA7396A68D541C85D26508E83_897155673;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1368190583 = varB4EAC82CA7396A68D541C85D26508E83_1879896022;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1368190583.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1368190583;
        
        
            
                
            
            
        
            
            
                    
                    
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.752 -0400", hash_original_method = "EA9CBC15CAAA468AF10BBF1CD02918CF", hash_generated_method = "EAE6F8E0BC100F7D81EEFD29DB066B91")
    protected Socket getSocket() {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1735774312 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1735774312 = sslSocket != null ? sslSocket : socket;
        varB4EAC82CA7396A68D541C85D26508E83_1735774312.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1735774312;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.753 -0400", hash_original_method = "9472CD13980FF331A1EC2B82F4638C6F", hash_generated_method = "788D749080DE44C543F79BFF29EF7750")
    public Address getAddress() {
        Address varB4EAC82CA7396A68D541C85D26508E83_1632602147 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1632602147 = address;
        varB4EAC82CA7396A68D541C85D26508E83_1632602147.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1632602147;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.753 -0400", hash_original_method = "15C1B21595200C1DF5857AC28380107D", hash_generated_method = "48FF9329A932256F21C5A37931DC329D")
    public void setupSecureSocket(SSLSocketFactory sslSocketFactory, boolean tlsTolerant) throws IOException {
        unverifiedSocket = (SSLSocket) sslSocketFactory.createSocket(socket,
                address.uriHost, address.uriPort, true );
        {
            OpenSSLSocketImpl openSslSocket = (OpenSSLSocketImpl) unverifiedSocket;
            openSslSocket.setEnabledCompressionMethods(new String[] { "ZLIB"});
            openSslSocket.setUseSessionTickets(true);
            openSslSocket.setHostname(address.socketHost);
        } 
        {
            unverifiedSocket.setEnabledProtocols(new String [] { "SSLv3" });
        } 
        unverifiedSocket.startHandshake();
        addTaint(tlsTolerant);
        
        
                
        
            
            
            
            
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.754 -0400", hash_original_method = "E313A7AB78F75EDB07568DFA09A3BF60", hash_generated_method = "DD3402DC3B7F2293FE7263CC45C40463")
    public SSLSocket verifySecureSocketHostname(HostnameVerifier hostnameVerifier) throws IOException {
        SSLSocket varB4EAC82CA7396A68D541C85D26508E83_7221574 = null; 
        {
            boolean varCDF545EAAED9B38C453E5D9476E6ADD6_562363257 = (!hostnameVerifier.verify(address.uriHost, unverifiedSocket.getSession()));
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Hostname '" + address.uriHost + "' was not verified");
            } 
        } 
        sslSocket = unverifiedSocket;
        varB4EAC82CA7396A68D541C85D26508E83_7221574 = sslSocket;
        addTaint(hostnameVerifier.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_7221574.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_7221574;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.754 -0400", hash_original_method = "0390CC00C23D2289E08AFB9047DDDB88", hash_generated_method = "A7DD2692D206724AD558D2E64CE37894")
    public SSLSocket getSecureSocketIfConnected() {
        SSLSocket varB4EAC82CA7396A68D541C85D26508E83_1329045118 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1329045118 = sslSocket;
        varB4EAC82CA7396A68D541C85D26508E83_1329045118.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1329045118;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.755 -0400", hash_original_method = "197418179C71EABCF647B3FA4C9F9D3C", hash_generated_method = "88A083480B27EDB37F7E331C03A8C7C8")
     boolean isStale() throws IOException {
        {
            boolean var2BDB1C5DA0DBD4955C884B844F21F17B_1872801364 = (!isEligibleForRecycling());
        } 
        InputStream in = getInputStream();
        {
            boolean varE684FF4D92AACF44A45D4FF9CA23ABC5_1500183851 = (in.available() > 0);
        } 
        Socket socket = getSocket();
        int soTimeout = socket.getSoTimeout();
        try 
        {
            socket.setSoTimeout(1);
            in.mark(1);
            int byteRead = in.read();
            {
                in.reset();
            } 
        } 
        catch (SocketTimeoutException e)
        { }
        catch (IOException e)
        { }
        finally 
        {
            socket.setSoTimeout(soTimeout);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2121427203 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2121427203;
        
        
            
        
        
        
            
        
        
        
        
            
            
            
            
                
                
            
            
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.755 -0400", hash_original_method = "10486D7D4909022462833E73661236C1", hash_generated_method = "C722BBB7BD464AE2CC1F564120C438A8")
    protected boolean isEligibleForRecycling() {
        boolean varAABC120FA4E0F230A6E6A152DA4E58E8_174098721 = (!socket.isClosed()
                && !socket.isInputShutdown()
                && !socket.isOutputShutdown());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_188777892 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_188777892;
        
        
                
                
    }

    
    public static final class Address {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.755 -0400", hash_original_field = "431387EB7262E1CFC79B125EB8A67C60", hash_generated_field = "EE0BB8F1739D62A5A5C8EDF7D478A66B")

        private Proxy proxy;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.755 -0400", hash_original_field = "CC28AE9251E6147BF76E0CB323DC3286", hash_generated_field = "07AEE931A3DB127ADD85468783C7312B")

        private boolean requiresTunnel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.755 -0400", hash_original_field = "A73597CDD217965CB3BDD6F840530FA2", hash_generated_field = "2E25E6A02EC1EA9F050C57679AE98E79")

        private String uriHost;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.755 -0400", hash_original_field = "E303D03FFD439EEA6DF993A2BD678A7D", hash_generated_field = "E82B694E22483837DC8A7FA45AAFFD3E")

        private int uriPort;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.755 -0400", hash_original_field = "44D85B9165E3687DE1B20F831C8ACC96", hash_generated_field = "B2FB257AF7E44452ADEDE39DC00B96E5")

        private String socketHost;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.755 -0400", hash_original_field = "29CB723510D405BDECD2AB1AE955037B", hash_generated_field = "B6CE69B75628186CDBBBC00DA03652CE")

        private int socketPort;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.756 -0400", hash_original_method = "56C3F1DA7938694CED60FE34095C0213", hash_generated_method = "2090EDCF2F749D57DB0C828E6D058B86")
        public  Address(URI uri) {
            this.proxy = null;
            this.requiresTunnel = false;
            this.uriHost = uri.getHost();
            this.uriPort = uri.getEffectivePort();
            this.socketHost = uriHost;
            this.socketPort = uriPort;
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.757 -0400", hash_original_method = "A6C9CB15451FF69F0D42BB48C7372F2F", hash_generated_method = "0864B1D94FDE79AB75C0B131C2E08A41")
        public  Address(URI uri, Proxy proxy, boolean requiresTunnel) {
            this.proxy = proxy;
            this.requiresTunnel = requiresTunnel;
            this.uriHost = uri.getHost();
            this.uriPort = uri.getEffectivePort();
            SocketAddress proxyAddress = proxy.address();
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: "
                        + proxyAddress.getClass());
            } 
            InetSocketAddress proxySocketAddress = (InetSocketAddress) proxyAddress;
            this.socketHost = proxySocketAddress.getHostName();
            this.socketPort = proxySocketAddress.getPort();
            
            
            
            
            
            
            
                
                        
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.757 -0400", hash_original_method = "19AE87D83FEEE8E799F844F8A7A84495", hash_generated_method = "980D6F9F4F0BD1B8828495FFA711217E")
        public Proxy getProxy() {
            Proxy varB4EAC82CA7396A68D541C85D26508E83_1138909235 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1138909235 = proxy;
            varB4EAC82CA7396A68D541C85D26508E83_1138909235.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1138909235;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.758 -0400", hash_original_method = "104FF09B2C80755ABB27A6E9EA994C0B", hash_generated_method = "DBEF1BC9AE39C27694BF4F90D673114C")
        @Override
        public boolean equals(Object other) {
            {
                Address that = (Address) other;
                boolean varCCBC1779637276BBD0AC744EE215BB93_2131630362 = (Objects.equal(this.proxy, that.proxy)
                        && this.uriHost.equals(that.uriHost)
                        && this.uriPort == that.uriPort
                        && this.requiresTunnel == that.requiresTunnel);
            } 
            addTaint(other.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1411120394 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1411120394;
            
            
                
                
                        
                        
                        
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.758 -0400", hash_original_method = "03AAE27C923B9ECFDFA09DAEE6900F4B", hash_generated_method = "A83BD62BE5659D3E66473D78D2A1F62D")
        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + uriHost.hashCode();
            result = 31 * result + uriPort;
            result = 31 * result + (proxy != null ? proxy.hashCode() : 0);
            result = 31 * result + (requiresTunnel ? 1 : 0);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1443203641 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1443203641;
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.759 -0400", hash_original_method = "D7960E9C2008885C55D097BA1D2C0C2A", hash_generated_method = "FB1ED9899482476DCF99FE8982E39042")
        public HttpConnection connect(int connectTimeout) throws IOException {
            HttpConnection varB4EAC82CA7396A68D541C85D26508E83_623272396 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_623272396 = new HttpConnection(this, connectTimeout);
            addTaint(connectTimeout);
            varB4EAC82CA7396A68D541C85D26508E83_623272396.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_623272396;
            
            
        }

        
    }


    
}

