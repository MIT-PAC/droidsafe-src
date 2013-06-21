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
    private Address address;
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private SSLSocket unverifiedSocket;
    private SSLSocket sslSocket;
    private InputStream sslInputStream;
    private OutputStream sslOutputStream;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.117 -0400", hash_original_method = "02721492ABE8A93C98AFD47B69F8145D", hash_generated_method = "A99C570F134F7ECC0FB61680AD91D2CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private HttpConnection(Address config, int connectTimeout) throws IOException {
        dsTaint.addTaint(connectTimeout);
        dsTaint.addTaint(config.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.117 -0400", hash_original_method = "50D4F2062BD74B4850A586FC88599309", hash_generated_method = "B63879B3617FE401C7B93A2945C0011E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.118 -0400", hash_original_method = "8353DEF033DB8B4F652D08F1BE7D5FB2", hash_generated_method = "5CE5A3C62D342142C7FADD562BDFA877")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSoTimeout(int readTimeout) throws SocketException {
        dsTaint.addTaint(readTimeout);
        socket.setSoTimeout(readTimeout);
        // ---------- Original Method ----------
        //socket.setSoTimeout(readTimeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.118 -0400", hash_original_method = "97D9B93978E46D1095C2BFB6FD92F6AE", hash_generated_method = "B07E806BE1CF56118B14D044947AF0CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OutputStream getOutputStream() throws IOException {
        {
            {
                sslOutputStream = sslSocket.getOutputStream();
            } //End block
        } //End block
        {
            outputStream = socket.getOutputStream();
        } //End block
        return (OutputStream)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.118 -0400", hash_original_method = "1360CB9715FEE0D075363C3EF21DD92C", hash_generated_method = "C04904E5D22BDF9A10B350E7467B5C2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputStream getInputStream() throws IOException {
        {
            {
                sslInputStream = sslSocket.getInputStream();
            } //End block
        } //End block
        {
            int bufferSize;
            bufferSize = 128;
            inputStream = address.requiresTunnel
                    ? socket.getInputStream()
                    : new BufferedInputStream(socket.getInputStream(), bufferSize);
        } //End block
        return (InputStream)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.118 -0400", hash_original_method = "EA9CBC15CAAA468AF10BBF1CD02918CF", hash_generated_method = "3E4F569F6F9D903F3225D9AFB4025134")
    @DSModeled(DSC.SAFE)
    protected Socket getSocket() {
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sslSocket != null ? sslSocket : socket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.119 -0400", hash_original_method = "9472CD13980FF331A1EC2B82F4638C6F", hash_generated_method = "81C8979A4D6DB0ABC4C18B41D0F67A43")
    @DSModeled(DSC.SAFE)
    public Address getAddress() {
        return (Address)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.119 -0400", hash_original_method = "15C1B21595200C1DF5857AC28380107D", hash_generated_method = "817E6A1C4B3AF3BF798B536BB33ACFA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setupSecureSocket(SSLSocketFactory sslSocketFactory, boolean tlsTolerant) throws IOException {
        dsTaint.addTaint(sslSocketFactory.dsTaint);
        dsTaint.addTaint(tlsTolerant);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.119 -0400", hash_original_method = "E313A7AB78F75EDB07568DFA09A3BF60", hash_generated_method = "14F60C80A9FE2A0D88EC93BA7956F001")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLSocket verifySecureSocketHostname(HostnameVerifier hostnameVerifier) throws IOException {
        dsTaint.addTaint(hostnameVerifier.dsTaint);
        {
            boolean varCDF545EAAED9B38C453E5D9476E6ADD6_1467943200 = (!hostnameVerifier.verify(address.uriHost, unverifiedSocket.getSession()));
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Hostname '" + address.uriHost + "' was not verified");
            } //End block
        } //End collapsed parenthetic
        sslSocket = unverifiedSocket;
        return (SSLSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!hostnameVerifier.verify(address.uriHost, unverifiedSocket.getSession())) {
            //throw new IOException("Hostname '" + address.uriHost + "' was not verified");
        //}
        //sslSocket = unverifiedSocket;
        //return sslSocket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.119 -0400", hash_original_method = "0390CC00C23D2289E08AFB9047DDDB88", hash_generated_method = "F2C1F99E892D2911E5A1875090CC000A")
    @DSModeled(DSC.SAFE)
    public SSLSocket getSecureSocketIfConnected() {
        return (SSLSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sslSocket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.120 -0400", hash_original_method = "197418179C71EABCF647B3FA4C9F9D3C", hash_generated_method = "8C9920299C69FF6BC34420E8C0B88173")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isStale() throws IOException {
        {
            boolean var2BDB1C5DA0DBD4955C884B844F21F17B_1747093645 = (!isEligibleForRecycling());
        } //End collapsed parenthetic
        InputStream in;
        in = getInputStream();
        {
            boolean varE684FF4D92AACF44A45D4FF9CA23ABC5_147874624 = (in.available() > 0);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.120 -0400", hash_original_method = "10486D7D4909022462833E73661236C1", hash_generated_method = "6A55FA81EE5E25AE3F0E486A845819B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean isEligibleForRecycling() {
        boolean varAABC120FA4E0F230A6E6A152DA4E58E8_866712044 = (!socket.isClosed()
                && !socket.isInputShutdown()
                && !socket.isOutputShutdown());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return !socket.isClosed()
                //&& !socket.isInputShutdown()
                //&& !socket.isOutputShutdown();
    }

    
    public static final class Address {
        private Proxy proxy;
        private boolean requiresTunnel;
        private String uriHost;
        private int uriPort;
        private String socketHost;
        private int socketPort;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.120 -0400", hash_original_method = "56C3F1DA7938694CED60FE34095C0213", hash_generated_method = "F2D0BAE65C415042F68617D5C76582E6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Address(URI uri) {
            dsTaint.addTaint(uri.dsTaint);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.120 -0400", hash_original_method = "A6C9CB15451FF69F0D42BB48C7372F2F", hash_generated_method = "D580E2A8DEB33B31C83595AF6E2FFF0A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Address(URI uri, Proxy proxy, boolean requiresTunnel) {
            dsTaint.addTaint(proxy.dsTaint);
            dsTaint.addTaint(uri.dsTaint);
            dsTaint.addTaint(requiresTunnel);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.121 -0400", hash_original_method = "19AE87D83FEEE8E799F844F8A7A84495", hash_generated_method = "CBE746D2E3F84D54A452173FF44FF115")
        @DSModeled(DSC.SAFE)
        public Proxy getProxy() {
            return (Proxy)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return proxy;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.121 -0400", hash_original_method = "104FF09B2C80755ABB27A6E9EA994C0B", hash_generated_method = "FD7999198FE0292CDFF3ACF9058F81D3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object other) {
            dsTaint.addTaint(other.dsTaint);
            {
                Address that;
                that = (Address) other;
                boolean varCCBC1779637276BBD0AC744EE215BB93_389659586 = (Objects.equal(this.proxy, that.proxy)
                        && this.uriHost.equals(that.uriHost)
                        && this.uriPort == that.uriPort
                        && this.requiresTunnel == that.requiresTunnel);
            } //End block
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.121 -0400", hash_original_method = "03AAE27C923B9ECFDFA09DAEE6900F4B", hash_generated_method = "AD785195A75DCD7036D188D3B28FFBFB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int result;
            result = 17;
            result = 31 * result + uriHost.hashCode();
            result = 31 * result + uriPort;
            result = 31 * result + (proxy != null ? proxy.hashCode() : 0);
            result = 31 * result + (requiresTunnel ? 1 : 0);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int result = 17;
            //result = 31 * result + uriHost.hashCode();
            //result = 31 * result + uriPort;
            //result = 31 * result + (proxy != null ? proxy.hashCode() : 0);
            //result = 31 * result + (requiresTunnel ? 1 : 0);
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.121 -0400", hash_original_method = "D7960E9C2008885C55D097BA1D2C0C2A", hash_generated_method = "312AF56F4842CED7FC4E97793674C91C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public HttpConnection connect(int connectTimeout) throws IOException {
            dsTaint.addTaint(connectTimeout);
            HttpConnection var4757B962B70538854D4D2DC0A72CBAA0_374552920 = (new HttpConnection(this, connectTimeout));
            return (HttpConnection)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new HttpConnection(this, connectTimeout);
        }

        
    }


    
}

