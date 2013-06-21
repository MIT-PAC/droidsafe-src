package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

public class SSLSocketImpl extends SSLSocket {
    private boolean handshake_started = false;
    protected SSLRecordProtocol recordProtocol;
    private HandshakeProtocol handshakeProtocol;
    private AlertProtocol alertProtocol;
    private SSLSocketInputStream appDataIS;
    private SSLSocketOutputStream appDataOS;
    private SSLSessionImpl session;
    private boolean socket_was_closed = false;
    protected SSLParametersImpl sslParameters;
    protected InputStream input;
    protected OutputStream output;
    private ArrayList<HandshakeCompletedListener> listeners;
    private Logger.Stream logger = Logger.getStream("socket");
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.253 -0400", hash_original_method = "7B6D79A24FC469186EEF1935CCE0FAAE", hash_generated_method = "6757A8D61DC8CEA8C2A7BD2512BD1EB8")
    @DSModeled(DSC.SAFE)
    protected SSLSocketImpl(SSLParametersImpl sslParameters) {
        dsTaint.addTaint(sslParameters.dsTaint);
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.253 -0400", hash_original_method = "B90B14697CA53EAAAF818AFF9DD06A34", hash_generated_method = "C4394AE7F9720DE775B62632BEAEBB68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SSLSocketImpl(String host, int port, SSLParametersImpl sslParameters) throws IOException, UnknownHostException {
        super(host, port);
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        dsTaint.addTaint(sslParameters.dsTaint);
        init();
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
        //init();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.253 -0400", hash_original_method = "A894226ED2FD2304A12A4E08266BE71A", hash_generated_method = "1AD38072B7E9201F1D4F359B00349DEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SSLSocketImpl(String host, int port,
            InetAddress localHost, int localPort,
            SSLParametersImpl sslParameters) throws IOException,
            UnknownHostException {
        super(host, port, localHost, localPort);
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        dsTaint.addTaint(localPort);
        dsTaint.addTaint(localHost.dsTaint);
        dsTaint.addTaint(sslParameters.dsTaint);
        init();
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
        //init();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.254 -0400", hash_original_method = "21D48E905F577E64713F2C7CA9B1B030", hash_generated_method = "5A7BC0A5F00DE461BC5E66471579F6B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SSLSocketImpl(InetAddress host, int port,
            SSLParametersImpl sslParameters) throws IOException {
        super(host, port);
        dsTaint.addTaint(port);
        dsTaint.addTaint(host.dsTaint);
        dsTaint.addTaint(sslParameters.dsTaint);
        init();
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
        //init();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.254 -0400", hash_original_method = "6C5671217798C1BD7239CC8FEB7B883B", hash_generated_method = "F240DF2E31FD69E6F291E55F65870726")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SSLSocketImpl(InetAddress address, int port,
            InetAddress localAddress, int localPort,
            SSLParametersImpl sslParameters) throws IOException {
        super(address, port, localAddress, localPort);
        dsTaint.addTaint(port);
        dsTaint.addTaint(address.dsTaint);
        dsTaint.addTaint(localAddress.dsTaint);
        dsTaint.addTaint(localPort);
        dsTaint.addTaint(sslParameters.dsTaint);
        init();
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
        //init();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.254 -0400", hash_original_method = "FD845B5AAD012D6985E0ADCD6A0F1286", hash_generated_method = "C7053FCD0C2CAC7A8ED711746999121C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void init() throws IOException {
        initTransportLayer();
        appDataIS = new SSLSocketInputStream(this);
        appDataOS = new SSLSocketOutputStream(this);
        // ---------- Original Method ----------
        //if (appDataIS != null) {
            //return;
        //}
        //initTransportLayer();
        //appDataIS = new SSLSocketInputStream(this);
        //appDataOS = new SSLSocketOutputStream(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.254 -0400", hash_original_method = "F1A82616FFDC8899DB87D416AB14644B", hash_generated_method = "A4E325529E24EA029F3DA105A3FC705E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void initTransportLayer() throws IOException {
        input = super.getInputStream();
        output = super.getOutputStream();
        // ---------- Original Method ----------
        //input = super.getInputStream();
        //output = super.getOutputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.254 -0400", hash_original_method = "651677798FC4CE70FB09611DD37A5D23", hash_generated_method = "DC71033D6F8C0E546CC132184F0576C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void closeTransportLayer() throws IOException {
        super.close();
        {
            input.close();
            output.close();
        } //End block
        // ---------- Original Method ----------
        //super.close();
        //if (input != null) {
            //input.close();
            //output.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.255 -0400", hash_original_method = "12BE90119F3183109C9DE5DBB63B352A", hash_generated_method = "FFED93EDC7E7297924551F3BDD89A5FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getSupportedCipherSuites() {
        String[] var7538431C68A39BDF527B3279B9F226C5_1160089447 = (CipherSuite.getSupportedCipherSuiteNames());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return CipherSuite.getSupportedCipherSuiteNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.255 -0400", hash_original_method = "80B545F2398A25060AECB1A23E821DD5", hash_generated_method = "58332705B6C5EBB0E75271C92AFBA0F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getEnabledCipherSuites() {
        String[] varC3ED4EB907904E69984EFC846C8D14D7_1739764894 = (sslParameters.getEnabledCipherSuites());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return sslParameters.getEnabledCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.255 -0400", hash_original_method = "7C4ABDE66C2DD67AB299013913F9BF06", hash_generated_method = "9E1BD0F36B086A8B521F2689941AD1AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setEnabledCipherSuites(String[] suites) {
        dsTaint.addTaint(suites[0]);
        sslParameters.setEnabledCipherSuites(suites);
        // ---------- Original Method ----------
        //sslParameters.setEnabledCipherSuites(suites);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.255 -0400", hash_original_method = "9A36300B3497119D0180A59D3E72D371", hash_generated_method = "EEE0631A6B043F90CAA2F9BF3F35C53C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getSupportedProtocols() {
        String[] var783FADE499BFC8C3457949EAB555903E_1587335481 = (ProtocolVersion.supportedProtocols.clone());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return ProtocolVersion.supportedProtocols.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.255 -0400", hash_original_method = "9376751549A6436575C0783CA6C3A4A0", hash_generated_method = "5E102862818F27C8468F3DE4A22BD064")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getEnabledProtocols() {
        String[] varA33B229DEE35C74B9811610CA888B1B5_1920368823 = (sslParameters.getEnabledProtocols());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return sslParameters.getEnabledProtocols();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.255 -0400", hash_original_method = "1CAC4BB68A222585D834DF0E7DBBD0B9", hash_generated_method = "98EB9B5352B74ED52E4191B5D05D71C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setEnabledProtocols(String[] protocols) {
        dsTaint.addTaint(protocols[0]);
        sslParameters.setEnabledProtocols(protocols);
        // ---------- Original Method ----------
        //sslParameters.setEnabledProtocols(protocols);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.256 -0400", hash_original_method = "3BB959BD0875F4D150E69C54372A8DCB", hash_generated_method = "62EEDFCBCDFD5D4206FF7D8A757B7E3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setUseClientMode(boolean mode) {
        dsTaint.addTaint(mode);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
            "Could not change the mode after the initial handshake has begun.");
        } //End block
        sslParameters.setUseClientMode(mode);
        // ---------- Original Method ----------
        //if (handshake_started) {
            //throw new IllegalArgumentException(
            //"Could not change the mode after the initial handshake has begun.");
        //}
        //sslParameters.setUseClientMode(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.256 -0400", hash_original_method = "01F03276D647357C499C358366605A7A", hash_generated_method = "ADC231F305DE50298B6537B0494CE30C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getUseClientMode() {
        boolean var5D6C317C7C34AA34FED4DDA3BFA46DAC_1966834168 = (sslParameters.getUseClientMode());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sslParameters.getUseClientMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.256 -0400", hash_original_method = "87B99BB5E16802D75B8230FD21E2413F", hash_generated_method = "6CC5B77D04C22EF0B7C8D76FE3C5FE68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setNeedClientAuth(boolean need) {
        dsTaint.addTaint(need);
        sslParameters.setNeedClientAuth(need);
        // ---------- Original Method ----------
        //sslParameters.setNeedClientAuth(need);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.256 -0400", hash_original_method = "01CDFCACAD6C113BE18D967A4C320F8F", hash_generated_method = "B57FBDD58CDCB4A03CFFCE23CDED9E0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getNeedClientAuth() {
        boolean var666666A183221FEF9E4AC429A4F2FC13_1317640530 = (sslParameters.getNeedClientAuth());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sslParameters.getNeedClientAuth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.256 -0400", hash_original_method = "C4BE9213AE4AE3AE8B3FD470CA7DBEA1", hash_generated_method = "3CF93375E2EDE097483BB86B9A2A6364")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setWantClientAuth(boolean want) {
        dsTaint.addTaint(want);
        sslParameters.setWantClientAuth(want);
        // ---------- Original Method ----------
        //sslParameters.setWantClientAuth(want);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.257 -0400", hash_original_method = "BFCFACF4683D2DA63944456ACA1AFE4C", hash_generated_method = "E1D62B7176A23F03870787C6CB1D9DF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getWantClientAuth() {
        boolean var1F88322EA2F28C29D3EC82222D21AA46_1784161951 = (sslParameters.getWantClientAuth());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sslParameters.getWantClientAuth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.257 -0400", hash_original_method = "CCC6382646A49B02E626A26467D69493", hash_generated_method = "1CEC5C88A393CCF6951D2A9AC29A0DA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setEnableSessionCreation(boolean flag) {
        dsTaint.addTaint(flag);
        sslParameters.setEnableSessionCreation(flag);
        // ---------- Original Method ----------
        //sslParameters.setEnableSessionCreation(flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.257 -0400", hash_original_method = "67C983FA387520F5F3AF315C719B29E4", hash_generated_method = "40BEFA0F52A34143CB5C64E3E40B1A3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getEnableSessionCreation() {
        boolean varAFF7A8ADF82548D8DE353C67D9576F3E_1840797515 = (sslParameters.getEnableSessionCreation());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sslParameters.getEnableSessionCreation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.257 -0400", hash_original_method = "8713059613609B55626747E74A63D7AE", hash_generated_method = "E557330638A378F9AD1833BF26013C8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public SSLSession getSession() {
        {
            try 
            {
                startHandshake();
            } //End block
            catch (IOException e)
            { }
        } //End block
        return (SSLSession)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!handshake_started) {
            //try {
                //startHandshake();
            //} catch (IOException e) {
                //return SSLSessionImpl.NULL_SESSION;
            //}
        //}
        //return session;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.258 -0400", hash_original_method = "F46B9A73766B8D71CEE8B005CFE82615", hash_generated_method = "88BFBA2E5BC98914C897F62C1854DD1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void addHandshakeCompletedListener(
            HandshakeCompletedListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Provided listener is null");
        } //End block
        {
            listeners = new ArrayList<HandshakeCompletedListener>();
        } //End block
        listeners.add(listener);
        // ---------- Original Method ----------
        //if (listener == null) {
            //throw new IllegalArgumentException("Provided listener is null");
        //}
        //if (listeners == null) {
            //listeners = new ArrayList<HandshakeCompletedListener>();
        //}
        //listeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.258 -0400", hash_original_method = "AD8204C7E0D7DFC602B3A996AAF9AC40", hash_generated_method = "0D5B3AC82DCF396D18A7B3BE4F88285A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void removeHandshakeCompletedListener(
            HandshakeCompletedListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Provided listener is null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Provided listener is not registered");
        } //End block
        {
            boolean var170C22586EF26335003A8446D4D19EBD_1007249061 = (!listeners.remove(listener));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Provided listener is not registered");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (listener == null) {
            //throw new IllegalArgumentException("Provided listener is null");
        //}
        //if (listeners == null) {
            //throw new IllegalArgumentException(
                    //"Provided listener is not registered");
        //}
        //if (!listeners.remove(listener)) {
            //throw new IllegalArgumentException(
                    //"Provided listener is not registered");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.258 -0400", hash_original_method = "765B8FA015660A1850228BA85BA4D2EA", hash_generated_method = "B7D308647B706662831773D56169FB2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void startHandshake() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Socket is not connected.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Socket has already been closed.");
        } //End block
        {
            handshake_started = true;
            {
                boolean varA4B0927CB35036900884EAFB51864759_250447111 = (sslParameters.getUseClientMode());
                {
                    {
                        logger.println("SSLSocketImpl: CLIENT");
                    } //End block
                    handshakeProtocol = new ClientHandshakeImpl(this);
                } //End block
                {
                    {
                        logger.println("SSLSocketImpl: SERVER");
                    } //End block
                    handshakeProtocol = new ServerHandshakeImpl(this);
                } //End block
            } //End collapsed parenthetic
            alertProtocol = new AlertProtocol();
            recordProtocol = new SSLRecordProtocol(handshakeProtocol,
                    alertProtocol, new SSLStreamedInput(input),
                    appDataIS.dataPoint);
        } //End block
        {
            logger.println("SSLSocketImpl.startHandshake");
        } //End block
        handshakeProtocol.start();
        doHandshake();
        {
            logger.println("SSLSocketImpl.startHandshake: END");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.259 -0400", hash_original_method = "9F4C1AA967218079AF1BF56E431987CC", hash_generated_method = "10AF3AF3872088C0716B431ABBAE619E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public InputStream getInputStream() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Socket has already been closed.");
        } //End block
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (socket_was_closed) {
            //throw new IOException("Socket has already been closed.");
        //}
        //return appDataIS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.260 -0400", hash_original_method = "E9E36047983E43D9B4652427AFC0EE2E", hash_generated_method = "AF790D6A9E0CBB49651B25B6F76CB886")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public OutputStream getOutputStream() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Socket has already been closed.");
        } //End block
        return (OutputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (socket_was_closed) {
            //throw new IOException("Socket has already been closed.");
        //}
        //return appDataOS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.260 -0400", hash_original_method = "9C6F28F8DBD161E857A3A3894EC60A85", hash_generated_method = "07167E039687077FD9A658DD094287A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void connect(SocketAddress endpoint) throws IOException {
        dsTaint.addTaint(endpoint.dsTaint);
        super.connect(endpoint);
        init();
        // ---------- Original Method ----------
        //super.connect(endpoint);
        //init();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.261 -0400", hash_original_method = "E1471735BF64AF2EDFAE20D8138E7876", hash_generated_method = "03DABC584B1315EE49B61DEEAABB8ACF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void connect(SocketAddress endpoint, int timeout) throws IOException {
        dsTaint.addTaint(timeout);
        dsTaint.addTaint(endpoint.dsTaint);
        super.connect(endpoint, timeout);
        init();
        // ---------- Original Method ----------
        //super.connect(endpoint, timeout);
        //init();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.261 -0400", hash_original_method = "1C7BF244CDBA20FEDEE01D71D2117BF2", hash_generated_method = "83948190E2B7DC21DA321310F3C8C5F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void close() throws IOException {
        {
            logger.println("SSLSocket.close "+socket_was_closed);
        } //End block
        {
            {
                alertProtocol.alert(AlertProtocol.WARNING,
                        AlertProtocol.CLOSE_NOTIFY);
                try 
                {
                    output.write(alertProtocol.wrap());
                } //End block
                catch (IOException ex)
                { }
                alertProtocol.setProcessed();
            } //End block
            shutdown();
            closeTransportLayer();
            socket_was_closed = true;
        } //End block
        // ---------- Original Method ----------
        //if (logger != null) {
            //logger.println("SSLSocket.close "+socket_was_closed);
        //}
        //if (!socket_was_closed) {
            //if (handshake_started) {
                //alertProtocol.alert(AlertProtocol.WARNING,
                        //AlertProtocol.CLOSE_NOTIFY);
                //try {
                    //output.write(alertProtocol.wrap());
                //} catch (IOException ex) { }
                //alertProtocol.setProcessed();
            //}
            //shutdown();
            //closeTransportLayer();
            //socket_was_closed = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.261 -0400", hash_original_method = "76A321423E9827230577FC78A6A38E86", hash_generated_method = "BFDECB5A4A7D91502E56AAE088CD6C82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void sendUrgentData(int data) throws IOException {
        dsTaint.addTaint(data);
        if (DroidSafeAndroidRuntime.control) throw new SocketException(
                "Method sendUrgentData() is not supported.");
        // ---------- Original Method ----------
        //throw new SocketException(
                //"Method sendUrgentData() is not supported.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.262 -0400", hash_original_method = "274CE2EF30305C6385D88E550D3E79A6", hash_generated_method = "2190961E085D7B72935D8C8387ED7907")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setOOBInline(boolean on) throws SocketException {
        dsTaint.addTaint(on);
        if (DroidSafeAndroidRuntime.control) throw new SocketException(
                "Methods sendUrgentData, setOOBInline are not supported.");
        // ---------- Original Method ----------
        //throw new SocketException(
                //"Methods sendUrgentData, setOOBInline are not supported.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.262 -0400", hash_original_method = "14168DA1E68DB132A0DACBB007EAD125", hash_generated_method = "DB8DA0A7842533BECD37164A9F914EE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void shutdown() {
        {
            alertProtocol.shutdown();
            alertProtocol = null;
            handshakeProtocol.shutdown();
            handshakeProtocol = null;
            recordProtocol.shutdown();
            recordProtocol = null;
        } //End block
        socket_was_closed = true;
        // ---------- Original Method ----------
        //if (handshake_started) {
            //alertProtocol.shutdown();
            //alertProtocol = null;
            //handshakeProtocol.shutdown();
            //handshakeProtocol = null;
            //recordProtocol.shutdown();
            //recordProtocol = null;
        //}
        //socket_was_closed = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.262 -0400", hash_original_method = "9F181DA813C5E35277B72423F9B4689F", hash_generated_method = "5AB299FFAD66547DB4E4E516E9547A49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void needAppData() throws IOException {
        {
            startHandshake();
        } //End block
        int type;
        {
            logger.println("SSLSocket.needAppData..");
        } //End block
        try 
        {
            {
                boolean varBAB188DECDCD630F3A5A2ED7BA622EDE_234002393 = (appDataIS.available() == 0);
                {
                    {
                        Object var4E37FE4E1A81B3E2D3D944D08C05A90F_418391455 = (type = recordProtocol.unwrap());
                        //Begin case ContentType.HANDSHAKE 
                        {
                            boolean var001467BA25544030FCEB8131CBC2B509_746831916 = (!handshakeProtocol.getStatus().equals(
                                SSLEngineResult.HandshakeStatus
                                .NOT_HANDSHAKING));
                            {
                                doHandshake();
                            } //End block
                        } //End collapsed parenthetic
                        //End case ContentType.HANDSHAKE 
                        //Begin case ContentType.ALERT 
                        processAlert();
                        //End case ContentType.ALERT 
                        //Begin case ContentType.APPLICATION_DATA 
                        {
                            logger.println(
                                    "SSLSocket.needAppData: got the data");
                        } //End block
                        //End case ContentType.APPLICATION_DATA 
                        //Begin case default 
                        reportFatalAlert(AlertProtocol.UNEXPECTED_MESSAGE,
                                new SSLException("Unexpected message of type "
                                    + type + " has been got"));
                        //End case default 
                    } //End collapsed parenthetic
                    {
                        boolean var2403FF9531EBD6D17D981C2B0AA326B1_2088292280 = (alertProtocol.hasAlert());
                        {
                            output.write(alertProtocol.wrap());
                            alertProtocol.setProcessed();
                        } //End block
                    } //End collapsed parenthetic
                    {
                        appDataIS.setEnd();
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (AlertException e)
        {
            reportFatalAlert(e.getDescriptionCode(), e.getReason());
        } //End block
        catch (EndOfSourceException e)
        {
            appDataIS.setEnd();
        } //End block
        {
            logger.println("SSLSocket.needAppData: app data len: "
                    + appDataIS.available());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.263 -0400", hash_original_method = "BD84CA3E70E7330B95C89C209BCE2D56", hash_generated_method = "27B0FE714D943218E3AB3CDD7C24FC55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void writeAppData(byte[] data, int offset, int len) throws IOException {
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(len);
        dsTaint.addTaint(offset);
        {
            startHandshake();
        } //End block
        {
            logger.println("SSLSocket.writeAppData: " +
                    len + " " + SSLRecordProtocol.MAX_DATA_LENGTH);
        } //End block
        try 
        {
            {
                output.write(recordProtocol.wrap(ContentType.APPLICATION_DATA,
                            data, offset, len));
            } //End block
            {
                {
                    output.write(recordProtocol.wrap(
                                ContentType.APPLICATION_DATA, data, offset,
                                SSLRecordProtocol.MAX_DATA_LENGTH));
                    offset += SSLRecordProtocol.MAX_DATA_LENGTH;
                    len -= SSLRecordProtocol.MAX_DATA_LENGTH;
                } //End block
                {
                    output.write(
                        recordProtocol.wrap(ContentType.APPLICATION_DATA,
                                            data, offset, len));
                } //End block
            } //End block
        } //End block
        catch (AlertException e)
        {
            reportFatalAlert(e.getDescriptionCode(), e.getReason());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.264 -0400", hash_original_method = "B11A6FC07E880C42041746EA2FD3607A", hash_generated_method = "06C723FC40002EAB456F66748445D0B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void doHandshake() throws IOException {
        SSLEngineResult.HandshakeStatus status;
        int type;
        try 
        {
            {
                boolean var9D4BC6F5F4D389C19EE66E8CF9079905_341108263 = (!(status = handshakeProtocol.getStatus()).equals(
                        SSLEngineResult.HandshakeStatus.FINISHED));
                {
                    {
                        String s;
                                                {
                            boolean var1EBF21E1C1E39DB6188A852D126567A9_1108038740 = ((status.equals(
                                SSLEngineResult.HandshakeStatus.NEED_WRAP)));
                            Object var0C0A9498B08BB4C776E5FCE33FD86930_882569291 = ((status.equals(
                                SSLEngineResult.HandshakeStatus.NEED_UNWRAP)));
                        } //End flattened ternary
                        s = "NEED_UNWRAP";
                        s = "STATUS: OTHER!";
                        logger.println("SSLSocketImpl: HS status: "+s+" "+status);
                    } //End block
                    {
                        boolean varA794CBC77B92A94782D7BB220928EB7E_929422207 = (status.equals(SSLEngineResult.HandshakeStatus.NEED_WRAP));
                        {
                            output.write(handshakeProtocol.wrap());
                        } //End block
                        {
                            boolean varA4C4CAA5C31A47911ED74B3CF47C970B_422144964 = (status.equals(
                            SSLEngineResult.HandshakeStatus.NEED_UNWRAP));
                            {
                                {
                                    Object varE51AE817664D86FB975B92A5A0C84BF6_1165832558 = (type = recordProtocol.unwrap());
                                    //Begin case ContentType.ALERT 
                                    processAlert();
                                    //End case ContentType.ALERT 
                                    //Begin case default 
                                    reportFatalAlert(AlertProtocol.UNEXPECTED_MESSAGE,
                                    new SSLException(
                                        "Unexpected message of type "
                                        + type + " has been got"));
                                    //End case default 
                                } //End collapsed parenthetic
                            } //End block
                            {
                                reportFatalAlert(AlertProtocol.INTERNAL_ERROR,
                        new SSLException(
                            "Handshake passed unexpected status: "+status));
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                    {
                        boolean var2403FF9531EBD6D17D981C2B0AA326B1_1660119577 = (alertProtocol.hasAlert());
                        {
                            output.write(alertProtocol.wrap());
                            alertProtocol.setProcessed();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (EndOfSourceException e)
        {
            appDataIS.setEnd();
            if (DroidSafeAndroidRuntime.control) throw new IOException("Connection was closed");
        } //End block
        catch (AlertException e)
        {
            reportFatalAlert(e.getDescriptionCode(), e.getReason());
        } //End block
        session = recordProtocol.getSession();
        {
            HandshakeCompletedEvent event;
            event = new HandshakeCompletedEvent(this, session);
            int size;
            size = listeners.size();
            {
                int i;
                i = 0;
                {
                    listeners.get(i)
                    .handshakeCompleted(event);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.264 -0400", hash_original_method = "1DCA961CD2F2BCD453967A97232AAFC6", hash_generated_method = "6708BA371B102D3B9E19D618ED980D8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void processAlert() throws IOException {
        {
            boolean varBA114C5BBB68A4964579B65C6677BE54_786496324 = (!alertProtocol.hasAlert());
        } //End collapsed parenthetic
        {
            boolean var4D069DF686D20BBCD8851C3E216CBC3C_1712045447 = (alertProtocol.isFatalAlert());
            {
                alertProtocol.setProcessed();
                String description;
                description = "Fatal alert received "
                + alertProtocol.getAlertDescription();
                shutdown();
                if (DroidSafeAndroidRuntime.control) throw new SSLException(description);
            } //End block
        } //End collapsed parenthetic
        {
            logger.println("Warning alert received: "
                + alertProtocol.getAlertDescription());
        } //End block
        {
            Object var182D8DDEF223C10A221BDC17A7C27715_817876132 = (alertProtocol.getDescriptionCode());
            //Begin case AlertProtocol.CLOSE_NOTIFY 
            alertProtocol.setProcessed();
            //End case AlertProtocol.CLOSE_NOTIFY 
            //Begin case AlertProtocol.CLOSE_NOTIFY 
            appDataIS.setEnd();
            //End case AlertProtocol.CLOSE_NOTIFY 
            //Begin case AlertProtocol.CLOSE_NOTIFY 
            close();
            //End case AlertProtocol.CLOSE_NOTIFY 
            //Begin case default 
            alertProtocol.setProcessed();
            //End case default 
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.264 -0400", hash_original_method = "716B8ABB2A0B730F9297C2C81BE3F29D", hash_generated_method = "2C0F90EA88FFBD7F9FAF7FB6EA2919AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void reportFatalAlert(byte description_code,
            SSLException reason) throws IOException {
        dsTaint.addTaint(reason.dsTaint);
        dsTaint.addTaint(description_code);
        alertProtocol.alert(AlertProtocol.FATAL, description_code);
        try 
        {
            output.write(alertProtocol.wrap());
        } //End block
        catch (IOException ex)
        { }
        alertProtocol.setProcessed();
        shutdown();
        if (DroidSafeAndroidRuntime.control) throw reason;
        // ---------- Original Method ----------
        //alertProtocol.alert(AlertProtocol.FATAL, description_code);
        //try {
            //output.write(alertProtocol.wrap());
        //} catch (IOException ex) { }
        //alertProtocol.setProcessed();
        //shutdown();
        //throw reason;
    }

    
}

