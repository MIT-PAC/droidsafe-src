package libcore.net.http;

// Droidsafe Imports
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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

final class HttpConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.054 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "8E0ACE0F30850C9F1F71EFC5F985F46E")

    private Address address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.054 -0400", hash_original_field = "61F2529360AEC54F5DC9804B842CF3FA", hash_generated_field = "8626E3C3C4BFCB66E8863775B28E01CC")

    private Socket socket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.054 -0400", hash_original_field = "267171E6BFB2A04E5670F3CE06C59060", hash_generated_field = "92444C781A1F5D159CDAA9528EFB69D8")

    private InputStream inputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.054 -0400", hash_original_field = "BE2DEEC210B01069983CFC5912275FFC", hash_generated_field = "765C7DA707EC84D85188E77508C6D245")

    private OutputStream outputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.054 -0400", hash_original_field = "35A6B86135C918691DB6BDDEEDC40F5D", hash_generated_field = "649CC3E68690FE0D5C49F1CB1C97C793")

    private SSLSocket unverifiedSocket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.054 -0400", hash_original_field = "57145BE2C615DF714549C7E2CB75DFBA", hash_generated_field = "CE8322B162FF12735FB871E7AA8B8BA9")

    private SSLSocket sslSocket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.054 -0400", hash_original_field = "7F29EFC37D2FAB75329714E35FF0FA41", hash_generated_field = "1135E3111E26F3F567DE353BD59C3E31")

    private InputStream sslInputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.054 -0400", hash_original_field = "9849A86BF3DB5860C860E92D92CF41D0", hash_generated_field = "A6FD5A356329B1E885E1D97B809AB43D")

    private OutputStream sslOutputStream;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.055 -0400", hash_original_method = "02721492ABE8A93C98AFD47B69F8145D", hash_generated_method = "8B5A41DCE4287AB5E9EE389E3BB7C358")
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
            } //End block
            catch (IOException e)
            {
                if(i == addresses.length - 1)                
                {
                    e.addTaint(taint);
                    throw e;
                } //End block
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.056 -0400", hash_original_method = "50D4F2062BD74B4850A586FC88599309", hash_generated_method = "B63879B3617FE401C7B93A2945C0011E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.056 -0400", hash_original_method = "8353DEF033DB8B4F652D08F1BE7D5FB2", hash_generated_method = "A82B590F32C47AA40176D8DE6DF154BE")
    public void setSoTimeout(int readTimeout) throws SocketException {
        addTaint(readTimeout);
        socket.setSoTimeout(readTimeout);
        // ---------- Original Method ----------
        //socket.setSoTimeout(readTimeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.057 -0400", hash_original_method = "97D9B93978E46D1095C2BFB6FD92F6AE", hash_generated_method = "6243C455A95F7D557F1691DF0CEC3675")
    public OutputStream getOutputStream() throws IOException {
        if(sslSocket != null)        
        {
            if(sslOutputStream == null)            
            {
                sslOutputStream = sslSocket.getOutputStream();
            } //End block
OutputStream var7B5142EB61F03E732FF06E13D3F423AA_484602939 =             sslOutputStream;
            var7B5142EB61F03E732FF06E13D3F423AA_484602939.addTaint(taint);
            return var7B5142EB61F03E732FF06E13D3F423AA_484602939;
        } //End block
        else
        if(outputStream == null)        
        {
            outputStream = socket.getOutputStream();
        } //End block
OutputStream var864D919353B9AF56DB2472A4EBA3E730_1521542894 =         outputStream;
        var864D919353B9AF56DB2472A4EBA3E730_1521542894.addTaint(taint);
        return var864D919353B9AF56DB2472A4EBA3E730_1521542894;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.058 -0400", hash_original_method = "1360CB9715FEE0D075363C3EF21DD92C", hash_generated_method = "8A681DE61204B0FDCD851D230BE6F165")
    public InputStream getInputStream() throws IOException {
        if(sslSocket != null)        
        {
            if(sslInputStream == null)            
            {
                sslInputStream = sslSocket.getInputStream();
            } //End block
InputStream var07CB6F88FDC48DE9052B515D7A2AE8F3_1758408635 =             sslInputStream;
            var07CB6F88FDC48DE9052B515D7A2AE8F3_1758408635.addTaint(taint);
            return var07CB6F88FDC48DE9052B515D7A2AE8F3_1758408635;
        } //End block
        else
        if(inputStream == null)        
        {
            int bufferSize = 128;
            inputStream = address.requiresTunnel
                    ? socket.getInputStream()
                    : new BufferedInputStream(socket.getInputStream(), bufferSize);
        } //End block
InputStream var6D6AA0B6E97941129A02DB042FF8CF68_313534830 =         inputStream;
        var6D6AA0B6E97941129A02DB042FF8CF68_313534830.addTaint(taint);
        return var6D6AA0B6E97941129A02DB042FF8CF68_313534830;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.058 -0400", hash_original_method = "EA9CBC15CAAA468AF10BBF1CD02918CF", hash_generated_method = "B7077A1A7D812FF126A7D480CB275D23")
    protected Socket getSocket() {
Socket varC212647F359587E811E8677EDC2BCF85_981140988 =         sslSocket != null ? sslSocket : socket;
        varC212647F359587E811E8677EDC2BCF85_981140988.addTaint(taint);
        return varC212647F359587E811E8677EDC2BCF85_981140988;
        // ---------- Original Method ----------
        //return sslSocket != null ? sslSocket : socket;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.058 -0400", hash_original_method = "9472CD13980FF331A1EC2B82F4638C6F", hash_generated_method = "3289B1547106995AE81A2536B29756E6")
    public Address getAddress() {
Address var814577DDD37BAFB17E08CBEFDB411BAE_1472473947 =         address;
        var814577DDD37BAFB17E08CBEFDB411BAE_1472473947.addTaint(taint);
        return var814577DDD37BAFB17E08CBEFDB411BAE_1472473947;
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.059 -0400", hash_original_method = "15C1B21595200C1DF5857AC28380107D", hash_generated_method = "27A65744B31750F4886100F50B65BF2E")
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
        } //End block
        else
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.060 -0400", hash_original_method = "E313A7AB78F75EDB07568DFA09A3BF60", hash_generated_method = "A754E8DC0EA6C96ED666B23C4EEAA3A1")
    public SSLSocket verifySecureSocketHostname(HostnameVerifier hostnameVerifier) throws IOException {
        addTaint(hostnameVerifier.getTaint());
        if(!hostnameVerifier.verify(address.uriHost, unverifiedSocket.getSession()))        
        {
            IOException var5BFC50F4CD50FCD50287EBAE7E101E24_2056435878 = new IOException("Hostname '" + address.uriHost + "' was not verified");
            var5BFC50F4CD50FCD50287EBAE7E101E24_2056435878.addTaint(taint);
            throw var5BFC50F4CD50FCD50287EBAE7E101E24_2056435878;
        } //End block
        sslSocket = unverifiedSocket;
SSLSocket var483A6DFBDF2AF13A3CF8A0177BC684A5_381547085 =         sslSocket;
        var483A6DFBDF2AF13A3CF8A0177BC684A5_381547085.addTaint(taint);
        return var483A6DFBDF2AF13A3CF8A0177BC684A5_381547085;
        // ---------- Original Method ----------
        //if (!hostnameVerifier.verify(address.uriHost, unverifiedSocket.getSession())) {
            //throw new IOException("Hostname '" + address.uriHost + "' was not verified");
        //}
        //sslSocket = unverifiedSocket;
        //return sslSocket;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.060 -0400", hash_original_method = "0390CC00C23D2289E08AFB9047DDDB88", hash_generated_method = "7E8F13B382CEE75ED84D479A4D062E66")
    public SSLSocket getSecureSocketIfConnected() {
SSLSocket var483A6DFBDF2AF13A3CF8A0177BC684A5_1898224470 =         sslSocket;
        var483A6DFBDF2AF13A3CF8A0177BC684A5_1898224470.addTaint(taint);
        return var483A6DFBDF2AF13A3CF8A0177BC684A5_1898224470;
        // ---------- Original Method ----------
        //return sslSocket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.061 -0400", hash_original_method = "197418179C71EABCF647B3FA4C9F9D3C", hash_generated_method = "83A97AD7B1D1D8A6EAFD61ED055C433D")
     boolean isStale() throws IOException {
        if(!isEligibleForRecycling())        
        {
            boolean varB326B5062B2F0E69046810717534CB09_831517474 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_67128073 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_67128073;
        } //End block
        InputStream in = getInputStream();
        if(in.available() > 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_10608387 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1609282816 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1609282816;
        } //End block
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
                boolean var68934A3E9455FA72420237EB05902327_1510314595 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1433921931 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1433921931;
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_171124942 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_464681440 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_464681440;
        } //End block
        catch (SocketTimeoutException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1825751624 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_414029007 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_414029007;
        } //End block
        catch (IOException e)
        {
            boolean varB326B5062B2F0E69046810717534CB09_1406685267 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_620886677 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_620886677;
        } //End block
        finally 
        {
            socket.setSoTimeout(soTimeout);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.062 -0400", hash_original_method = "10486D7D4909022462833E73661236C1", hash_generated_method = "60178B2D7712052FE0A0169A471187A2")
    protected boolean isEligibleForRecycling() {
        boolean var69C69396EB6626A84180EE6B19182F45_861827237 = (!socket.isClosed()
                && !socket.isInputShutdown()
                && !socket.isOutputShutdown());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1503780644 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1503780644;
        // ---------- Original Method ----------
        //return !socket.isClosed()
                //&& !socket.isInputShutdown()
                //&& !socket.isOutputShutdown();
    }

    
    public static final class Address {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.062 -0400", hash_original_field = "431387EB7262E1CFC79B125EB8A67C60", hash_generated_field = "EE0BB8F1739D62A5A5C8EDF7D478A66B")

        private Proxy proxy;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.062 -0400", hash_original_field = "CC28AE9251E6147BF76E0CB323DC3286", hash_generated_field = "07AEE931A3DB127ADD85468783C7312B")

        private boolean requiresTunnel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.062 -0400", hash_original_field = "A73597CDD217965CB3BDD6F840530FA2", hash_generated_field = "2E25E6A02EC1EA9F050C57679AE98E79")

        private String uriHost;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.062 -0400", hash_original_field = "E303D03FFD439EEA6DF993A2BD678A7D", hash_generated_field = "E82B694E22483837DC8A7FA45AAFFD3E")

        private int uriPort;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.062 -0400", hash_original_field = "44D85B9165E3687DE1B20F831C8ACC96", hash_generated_field = "B2FB257AF7E44452ADEDE39DC00B96E5")

        private String socketHost;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.062 -0400", hash_original_field = "29CB723510D405BDECD2AB1AE955037B", hash_generated_field = "B6CE69B75628186CDBBBC00DA03652CE")

        private int socketPort;
        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.063 -0400", hash_original_method = "56C3F1DA7938694CED60FE34095C0213", hash_generated_method = "2090EDCF2F749D57DB0C828E6D058B86")
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

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.064 -0400", hash_original_method = "A6C9CB15451FF69F0D42BB48C7372F2F", hash_generated_method = "BA8AD5EA22137A580D00BEDD23548387")
        public  Address(URI uri, Proxy proxy, boolean requiresTunnel) {
            this.proxy = proxy;
            this.requiresTunnel = requiresTunnel;
            this.uriHost = uri.getHost();
            this.uriPort = uri.getEffectivePort();
            SocketAddress proxyAddress = proxy.address();
            if(!(proxyAddress instanceof InetSocketAddress))            
            {
                IllegalArgumentException var1F52054C8BC1E59292A12BEABE1E9089_2117395403 = new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: "
                        + proxyAddress.getClass());
                var1F52054C8BC1E59292A12BEABE1E9089_2117395403.addTaint(taint);
                throw var1F52054C8BC1E59292A12BEABE1E9089_2117395403;
            } //End block
            InetSocketAddress proxySocketAddress = (InetSocketAddress) proxyAddress;
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.064 -0400", hash_original_method = "19AE87D83FEEE8E799F844F8A7A84495", hash_generated_method = "FF53AE103BE369A1A659DFD35A9EFD65")
        public Proxy getProxy() {
Proxy var60FC9F22F7E863EBFD33B2ADB8462743_2016208590 =             proxy;
            var60FC9F22F7E863EBFD33B2ADB8462743_2016208590.addTaint(taint);
            return var60FC9F22F7E863EBFD33B2ADB8462743_2016208590;
            // ---------- Original Method ----------
            //return proxy;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.064 -0400", hash_original_method = "104FF09B2C80755ABB27A6E9EA994C0B", hash_generated_method = "4F5CA80BED764562E46CAD5AF5A86FD5")
        @Override
        public boolean equals(Object other) {
            addTaint(other.getTaint());
            if(other instanceof Address)            
            {
                Address that = (Address) other;
                boolean var8F068D1C58AF4742374233BC1D4E4289_1510005155 = (Objects.equal(this.proxy, that.proxy)
                        && this.uriHost.equals(that.uriHost)
                        && this.uriPort == that.uriPort
                        && this.requiresTunnel == that.requiresTunnel);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1543726202 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1543726202;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1845488829 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1976706745 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1976706745;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.065 -0400", hash_original_method = "03AAE27C923B9ECFDFA09DAEE6900F4B", hash_generated_method = "A569881A9C9F55CDEA6518A93724E4A7")
        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + uriHost.hashCode();
            result = 31 * result + uriPort;
            result = 31 * result + (proxy != null ? proxy.hashCode() : 0);
            result = 31 * result + (requiresTunnel ? 1 : 0);
            int varB4A88417B3D0170D754C647C30B7216A_38933274 = (result);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_624429136 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_624429136;
            // ---------- Original Method ----------
            //int result = 17;
            //result = 31 * result + uriHost.hashCode();
            //result = 31 * result + uriPort;
            //result = 31 * result + (proxy != null ? proxy.hashCode() : 0);
            //result = 31 * result + (requiresTunnel ? 1 : 0);
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.065 -0400", hash_original_method = "D7960E9C2008885C55D097BA1D2C0C2A", hash_generated_method = "F1740999DF04BF7AAA5DB58701CF9A56")
        public HttpConnection connect(int connectTimeout) throws IOException {
            addTaint(connectTimeout);
HttpConnection var15B1551A9B509FD6847E854F6B8CB9B1_671666228 =             new HttpConnection(this, connectTimeout);
            var15B1551A9B509FD6847E854F6B8CB9B1_671666228.addTaint(taint);
            return var15B1551A9B509FD6847E854F6B8CB9B1_671666228;
            // ---------- Original Method ----------
            //return new HttpConnection(this, connectTimeout);
        }

        
    }


    
}

