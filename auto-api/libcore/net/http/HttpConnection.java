package libcore.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.761 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "8E0ACE0F30850C9F1F71EFC5F985F46E")

    private Address address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.761 -0400", hash_original_field = "61F2529360AEC54F5DC9804B842CF3FA", hash_generated_field = "8626E3C3C4BFCB66E8863775B28E01CC")

    private Socket socket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.761 -0400", hash_original_field = "267171E6BFB2A04E5670F3CE06C59060", hash_generated_field = "92444C781A1F5D159CDAA9528EFB69D8")

    private InputStream inputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.761 -0400", hash_original_field = "BE2DEEC210B01069983CFC5912275FFC", hash_generated_field = "765C7DA707EC84D85188E77508C6D245")

    private OutputStream outputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.761 -0400", hash_original_field = "35A6B86135C918691DB6BDDEEDC40F5D", hash_generated_field = "649CC3E68690FE0D5C49F1CB1C97C793")

    private SSLSocket unverifiedSocket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.761 -0400", hash_original_field = "57145BE2C615DF714549C7E2CB75DFBA", hash_generated_field = "CE8322B162FF12735FB871E7AA8B8BA9")

    private SSLSocket sslSocket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.761 -0400", hash_original_field = "7F29EFC37D2FAB75329714E35FF0FA41", hash_generated_field = "1135E3111E26F3F567DE353BD59C3E31")

    private InputStream sslInputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.761 -0400", hash_original_field = "9849A86BF3DB5860C860E92D92CF41D0", hash_generated_field = "A6FD5A356329B1E885E1D97B809AB43D")

    private OutputStream sslOutputStream;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.763 -0400", hash_original_method = "02721492ABE8A93C98AFD47B69F8145D", hash_generated_method = "23BC0DB339B654D19E94B8D045C7E607")
    private  HttpConnection(Address config, int connectTimeout) throws IOException {
        this.address = config;
        Socket socketCandidate;
        socketCandidate = null;
        InetAddress[] addresses;
        addresses = InetAddress.getAllByName(config.socketHost);
        {
            int i;
            i = 0;
            {
                socketCandidate = (config.proxy != null && config.proxy.type() != Proxy.Type.HTTP)
                    ? new Socket(config.proxy)
                    : new Socket();
                try 
                {
                    socketCandidate.connect(
                        new InetSocketAddress(addresses[i], config.socketPort), connectTimeout);
                } //End block
                catch (IOException e)
                {
                    {
                        if (DroidSafeAndroidRuntime.control) throw e;
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        this.socket = socketCandidate;
        addTaint(connectTimeout);
        // ---------- Original Method ----------
        //this.address = config;
        //Socket socketCandidate = null;
        //InetAddress[] addresses = InetAddress.getAllByName(config.socketHost);
        //for (int i = 0; i < addresses.length; i++) {
            //socketCandidate = (config.proxy != null && config.proxy.type() != Proxy.Type.HTTP)
                    //? new Socket(config.proxy)
                    //: new Socket();
            //try {
                //socketCandidate.connect(
                        //new InetSocketAddress(addresses[i], config.socketPort), connectTimeout);
                //break;
            //} catch (IOException e) {
                //if (i == addresses.length - 1) {
                    //throw e;
                //}
            //}
        //}
        //this.socket = socketCandidate;
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.769 -0400", hash_original_method = "50D4F2062BD74B4850A586FC88599309", hash_generated_method = "B63879B3617FE401C7B93A2945C0011E")
    public void closeSocketAndStreams() {
        IoUtils.closeQuietly(sslOutputStream);
        IoUtils.closeQuietly(sslInputStream);
        IoUtils.closeQuietly(sslSocket);
        IoUtils.closeQuietly(outputStream);
        IoUtils.closeQuietly(inputStream);
        IoUtils.closeQuietly(socket);
        // ---------- Original Method ----------
        //IoUtils.closeQuietly(sslOutputStream);
        //IoUtils.closeQuietly(sslInputStream);
        //IoUtils.closeQuietly(sslSocket);
        //IoUtils.closeQuietly(outputStream);
        //IoUtils.closeQuietly(inputStream);
        //IoUtils.closeQuietly(socket);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.770 -0400", hash_original_method = "8353DEF033DB8B4F652D08F1BE7D5FB2", hash_generated_method = "3222FA7BE8872A3008DD55002BF382F5")
    public void setSoTimeout(int readTimeout) throws SocketException {
        socket.setSoTimeout(readTimeout);
        addTaint(readTimeout);
        // ---------- Original Method ----------
        //socket.setSoTimeout(readTimeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.782 -0400", hash_original_method = "97D9B93978E46D1095C2BFB6FD92F6AE", hash_generated_method = "DCDB824E6AFA5AE325E151DD7A9FB67F")
    public OutputStream getOutputStream() throws IOException {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_892255305 = null; //Variable for return #1
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_520624434 = null; //Variable for return #2
        {
            {
                sslOutputStream = sslSocket.getOutputStream();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_892255305 = sslOutputStream;
        } //End block
        {
            outputStream = socket.getOutputStream();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_520624434 = outputStream;
        OutputStream varA7E53CE21691AB073D9660D615818899_120226992; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_120226992 = varB4EAC82CA7396A68D541C85D26508E83_892255305;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_120226992 = varB4EAC82CA7396A68D541C85D26508E83_520624434;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_120226992.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_120226992;
        // ---------- Original Method ----------
        //if (sslSocket != null) {
            //if (sslOutputStream == null) {
                //sslOutputStream = sslSocket.getOutputStream();
            //}
            //return sslOutputStream;
        //} else if(outputStream == null) {
            //outputStream = socket.getOutputStream();
        //}
        //return outputStream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.797 -0400", hash_original_method = "1360CB9715FEE0D075363C3EF21DD92C", hash_generated_method = "570E5C28157F5A7ADCF3095483587290")
    public InputStream getInputStream() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1487025854 = null; //Variable for return #1
        InputStream varB4EAC82CA7396A68D541C85D26508E83_175867084 = null; //Variable for return #2
        {
            {
                sslInputStream = sslSocket.getInputStream();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1487025854 = sslInputStream;
        } //End block
        {
            int bufferSize;
            bufferSize = 128;
            inputStream = address.requiresTunnel
                    ? socket.getInputStream()
                    : new BufferedInputStream(socket.getInputStream(), bufferSize);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_175867084 = inputStream;
        InputStream varA7E53CE21691AB073D9660D615818899_1415498896; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1415498896 = varB4EAC82CA7396A68D541C85D26508E83_1487025854;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1415498896 = varB4EAC82CA7396A68D541C85D26508E83_175867084;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1415498896.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1415498896;
        // ---------- Original Method ----------
        //if (sslSocket != null) {
            //if (sslInputStream == null) {
                //sslInputStream = sslSocket.getInputStream();
            //}
            //return sslInputStream;
        //} else if (inputStream == null) {
            //int bufferSize = 128;
            //inputStream = address.requiresTunnel
                    //? socket.getInputStream()
                    //: new BufferedInputStream(socket.getInputStream(), bufferSize);
        //}
        //return inputStream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.797 -0400", hash_original_method = "EA9CBC15CAAA468AF10BBF1CD02918CF", hash_generated_method = "4ACA7270C49EC81699707F03E41F4AEF")
    protected Socket getSocket() {
        Socket varB4EAC82CA7396A68D541C85D26508E83_794458496 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_794458496 = sslSocket != null ? sslSocket : socket;
        varB4EAC82CA7396A68D541C85D26508E83_794458496.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_794458496;
        // ---------- Original Method ----------
        //return sslSocket != null ? sslSocket : socket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.798 -0400", hash_original_method = "9472CD13980FF331A1EC2B82F4638C6F", hash_generated_method = "F5F9630A5FD06132BBE17BB92A2F1542")
    public Address getAddress() {
        Address varB4EAC82CA7396A68D541C85D26508E83_716457833 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_716457833 = address;
        varB4EAC82CA7396A68D541C85D26508E83_716457833.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_716457833;
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.798 -0400", hash_original_method = "15C1B21595200C1DF5857AC28380107D", hash_generated_method = "DB4CF08725D179D0BFB55C6ED479E89F")
    public void setupSecureSocket(SSLSocketFactory sslSocketFactory, boolean tlsTolerant) throws IOException {
        unverifiedSocket = (SSLSocket) sslSocketFactory.createSocket(socket,
                address.uriHost, address.uriPort, true );
        {
            OpenSSLSocketImpl openSslSocket;
            openSslSocket = (OpenSSLSocketImpl) unverifiedSocket;
            openSslSocket.setEnabledCompressionMethods(new String[] { "ZLIB"});
            openSslSocket.setUseSessionTickets(true);
            openSslSocket.setHostname(address.socketHost);
        } //End block
        {
            unverifiedSocket.setEnabledProtocols(new String [] { "SSLv3" });
        } //End block
        unverifiedSocket.startHandshake();
        addTaint(tlsTolerant);
        // ---------- Original Method ----------
        //unverifiedSocket = (SSLSocket) sslSocketFactory.createSocket(socket,
                //address.uriHost, address.uriPort, true );
        //if (tlsTolerant && unverifiedSocket instanceof OpenSSLSocketImpl) {
            //OpenSSLSocketImpl openSslSocket = (OpenSSLSocketImpl) unverifiedSocket;
            //openSslSocket.setEnabledCompressionMethods(new String[] { "ZLIB"});
            //openSslSocket.setUseSessionTickets(true);
            //openSslSocket.setHostname(address.socketHost);
        //} else {
            //unverifiedSocket.setEnabledProtocols(new String [] { "SSLv3" });
        //}
        //unverifiedSocket.startHandshake();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.799 -0400", hash_original_method = "E313A7AB78F75EDB07568DFA09A3BF60", hash_generated_method = "F6BD7B8D2174CFA6400C879EC833EDA3")
    public SSLSocket verifySecureSocketHostname(HostnameVerifier hostnameVerifier) throws IOException {
        SSLSocket varB4EAC82CA7396A68D541C85D26508E83_2006966763 = null; //Variable for return #1
        {
            boolean varCDF545EAAED9B38C453E5D9476E6ADD6_537453644 = (!hostnameVerifier.verify(address.uriHost, unverifiedSocket.getSession()));
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Hostname '" + address.uriHost + "' was not verified");
            } //End block
        } //End collapsed parenthetic
        sslSocket = unverifiedSocket;
        varB4EAC82CA7396A68D541C85D26508E83_2006966763 = sslSocket;
        addTaint(hostnameVerifier.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2006966763.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2006966763;
        // ---------- Original Method ----------
        //if (!hostnameVerifier.verify(address.uriHost, unverifiedSocket.getSession())) {
            //throw new IOException("Hostname '" + address.uriHost + "' was not verified");
        //}
        //sslSocket = unverifiedSocket;
        //return sslSocket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.799 -0400", hash_original_method = "0390CC00C23D2289E08AFB9047DDDB88", hash_generated_method = "21BD895365FB449AF5FB0D700D341DE3")
    public SSLSocket getSecureSocketIfConnected() {
        SSLSocket varB4EAC82CA7396A68D541C85D26508E83_1763841533 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1763841533 = sslSocket;
        varB4EAC82CA7396A68D541C85D26508E83_1763841533.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1763841533;
        // ---------- Original Method ----------
        //return sslSocket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.800 -0400", hash_original_method = "197418179C71EABCF647B3FA4C9F9D3C", hash_generated_method = "3906E1C6D7FB879233D6814636874948")
     boolean isStale() throws IOException {
        {
            boolean var2BDB1C5DA0DBD4955C884B844F21F17B_1410210778 = (!isEligibleForRecycling());
        } //End collapsed parenthetic
        InputStream in;
        in = getInputStream();
        {
            boolean varE684FF4D92AACF44A45D4FF9CA23ABC5_21198720 = (in.available() > 0);
        } //End collapsed parenthetic
        Socket socket;
        socket = getSocket();
        int soTimeout;
        soTimeout = socket.getSoTimeout();
        try 
        {
            socket.setSoTimeout(1);
            in.mark(1);
            int byteRead;
            byteRead = in.read();
            {
                in.reset();
            } //End block
        } //End block
        catch (SocketTimeoutException e)
        { }
        catch (IOException e)
        { }
        finally 
        {
            socket.setSoTimeout(soTimeout);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_63116914 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_63116914;
        // ---------- Original Method ----------
        //if (!isEligibleForRecycling()) {
            //return true;
        //}
        //InputStream in = getInputStream();
        //if (in.available() > 0) {
            //return false;
        //}
        //Socket socket = getSocket();
        //int soTimeout = socket.getSoTimeout();
        //try {
            //socket.setSoTimeout(1);
            //in.mark(1);
            //int byteRead = in.read();
            //if (byteRead != -1) {
                //in.reset();
                //return false;
            //}
            //return true; 
        //} catch (SocketTimeoutException e) {
            //return false; 
        //} catch (IOException e) {
            //return true; 
        //} finally {
            //socket.setSoTimeout(soTimeout);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.817 -0400", hash_original_method = "10486D7D4909022462833E73661236C1", hash_generated_method = "F0BC7ED9E0BF477EBEFD58846F5CDCE8")
    protected boolean isEligibleForRecycling() {
        boolean varAABC120FA4E0F230A6E6A152DA4E58E8_1650946876 = (!socket.isClosed()
                && !socket.isInputShutdown()
                && !socket.isOutputShutdown());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_50534001 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_50534001;
        // ---------- Original Method ----------
        //return !socket.isClosed()
                //&& !socket.isInputShutdown()
                //&& !socket.isOutputShutdown();
    }

    
    public static final class Address {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.817 -0400", hash_original_field = "431387EB7262E1CFC79B125EB8A67C60", hash_generated_field = "EE0BB8F1739D62A5A5C8EDF7D478A66B")

        private Proxy proxy;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.817 -0400", hash_original_field = "CC28AE9251E6147BF76E0CB323DC3286", hash_generated_field = "07AEE931A3DB127ADD85468783C7312B")

        private boolean requiresTunnel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.817 -0400", hash_original_field = "A73597CDD217965CB3BDD6F840530FA2", hash_generated_field = "2E25E6A02EC1EA9F050C57679AE98E79")

        private String uriHost;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.817 -0400", hash_original_field = "E303D03FFD439EEA6DF993A2BD678A7D", hash_generated_field = "E82B694E22483837DC8A7FA45AAFFD3E")

        private int uriPort;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.817 -0400", hash_original_field = "44D85B9165E3687DE1B20F831C8ACC96", hash_generated_field = "B2FB257AF7E44452ADEDE39DC00B96E5")

        private String socketHost;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.818 -0400", hash_original_field = "29CB723510D405BDECD2AB1AE955037B", hash_generated_field = "B6CE69B75628186CDBBBC00DA03652CE")

        private int socketPort;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.818 -0400", hash_original_method = "56C3F1DA7938694CED60FE34095C0213", hash_generated_method = "2090EDCF2F749D57DB0C828E6D058B86")
        public  Address(URI uri) {
            this.proxy = null;
            this.requiresTunnel = false;
            this.uriHost = uri.getHost();
            this.uriPort = uri.getEffectivePort();
            this.socketHost = uriHost;
            this.socketPort = uriPort;
            // ---------- Original Method ----------
            //this.proxy = null;
            //this.requiresTunnel = false;
            //this.uriHost = uri.getHost();
            //this.uriPort = uri.getEffectivePort();
            //this.socketHost = uriHost;
            //this.socketPort = uriPort;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.819 -0400", hash_original_method = "A6C9CB15451FF69F0D42BB48C7372F2F", hash_generated_method = "5A248B8CB69ADCC79488E64780625913")
        public  Address(URI uri, Proxy proxy, boolean requiresTunnel) {
            this.proxy = proxy;
            this.requiresTunnel = requiresTunnel;
            this.uriHost = uri.getHost();
            this.uriPort = uri.getEffectivePort();
            SocketAddress proxyAddress;
            proxyAddress = proxy.address();
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: "
                        + proxyAddress.getClass());
            } //End block
            InetSocketAddress proxySocketAddress;
            proxySocketAddress = (InetSocketAddress) proxyAddress;
            this.socketHost = proxySocketAddress.getHostName();
            this.socketPort = proxySocketAddress.getPort();
            // ---------- Original Method ----------
            //this.proxy = proxy;
            //this.requiresTunnel = requiresTunnel;
            //this.uriHost = uri.getHost();
            //this.uriPort = uri.getEffectivePort();
            //SocketAddress proxyAddress = proxy.address();
            //if (!(proxyAddress instanceof InetSocketAddress)) {
                //throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: "
                        //+ proxyAddress.getClass());
            //}
            //InetSocketAddress proxySocketAddress = (InetSocketAddress) proxyAddress;
            //this.socketHost = proxySocketAddress.getHostName();
            //this.socketPort = proxySocketAddress.getPort();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.819 -0400", hash_original_method = "19AE87D83FEEE8E799F844F8A7A84495", hash_generated_method = "323F48E5C6AAA690AA2149D5153F62A1")
        public Proxy getProxy() {
            Proxy varB4EAC82CA7396A68D541C85D26508E83_140807790 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_140807790 = proxy;
            varB4EAC82CA7396A68D541C85D26508E83_140807790.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_140807790;
            // ---------- Original Method ----------
            //return proxy;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.820 -0400", hash_original_method = "104FF09B2C80755ABB27A6E9EA994C0B", hash_generated_method = "643346398E3E8D60345072BD568C31B0")
        @Override
        public boolean equals(Object other) {
            {
                Address that;
                that = (Address) other;
                boolean varCCBC1779637276BBD0AC744EE215BB93_560685787 = (Objects.equal(this.proxy, that.proxy)
                        && this.uriHost.equals(that.uriHost)
                        && this.uriPort == that.uriPort
                        && this.requiresTunnel == that.requiresTunnel);
            } //End block
            addTaint(other.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1327969673 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1327969673;
            // ---------- Original Method ----------
            //if (other instanceof Address) {
                //Address that = (Address) other;
                //return Objects.equal(this.proxy, that.proxy)
                        //&& this.uriHost.equals(that.uriHost)
                        //&& this.uriPort == that.uriPort
                        //&& this.requiresTunnel == that.requiresTunnel;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.837 -0400", hash_original_method = "03AAE27C923B9ECFDFA09DAEE6900F4B", hash_generated_method = "30C7AC108B73D2ED5B12A0DCF4343111")
        @Override
        public int hashCode() {
            int result;
            result = 17;
            result = 31 * result + uriHost.hashCode();
            result = 31 * result + uriPort;
            result = 31 * result + (proxy != null ? proxy.hashCode() : 0);
            result = 31 * result + (requiresTunnel ? 1 : 0);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_36245846 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_36245846;
            // ---------- Original Method ----------
            //int result = 17;
            //result = 31 * result + uriHost.hashCode();
            //result = 31 * result + uriPort;
            //result = 31 * result + (proxy != null ? proxy.hashCode() : 0);
            //result = 31 * result + (requiresTunnel ? 1 : 0);
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.838 -0400", hash_original_method = "D7960E9C2008885C55D097BA1D2C0C2A", hash_generated_method = "9C89BE700ED87A92AA7C4AC1E899716C")
        public HttpConnection connect(int connectTimeout) throws IOException {
            HttpConnection varB4EAC82CA7396A68D541C85D26508E83_1987586181 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1987586181 = new HttpConnection(this, connectTimeout);
            addTaint(connectTimeout);
            varB4EAC82CA7396A68D541C85D26508E83_1987586181.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1987586181;
            // ---------- Original Method ----------
            //return new HttpConnection(this, connectTimeout);
        }

        
    }


    
}

