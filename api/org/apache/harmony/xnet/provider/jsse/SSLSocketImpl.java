package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.521 -0500", hash_original_field = "DD39B534563266F04E2B935538054204", hash_generated_field = "43A471CC626A390C3F42C96A293CE4F3")

    private boolean handshake_started = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.524 -0500", hash_original_field = "450F49BACBC7E7E38A182C4284626ACE", hash_generated_field = "EDC147518BA686E3DAEAF859EB64368C")

    protected SSLRecordProtocol recordProtocol;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.526 -0500", hash_original_field = "C657785F6A0EDCF13D6ABCC66DA9658A", hash_generated_field = "1032E45BD599BACD8B5F207A3C5A48C0")

    private HandshakeProtocol handshakeProtocol;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.528 -0500", hash_original_field = "36D0D0F3C543230F133CC70A25806808", hash_generated_field = "7F98BE8FCC656C783F586E8BC58013DC")

    private AlertProtocol alertProtocol;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.530 -0500", hash_original_field = "C7E3A3FD3C246E691BCC0EDB5CE62A3C", hash_generated_field = "1890B16FD79B3D58ED0866BB395F4C0D")

    // ssl socket as an input stream. Additionally this object is a
    // place where application data will be stored by record protocol
    private SSLSocketInputStream appDataIS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.532 -0500", hash_original_field = "BA53905A27FBC5226F70905CEDB2AA2A", hash_generated_field = "F04547F05FBC3550B4832B6EFAD5429B")

    private SSLSocketOutputStream appDataOS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.535 -0500", hash_original_field = "2FEA9607120FF1F874D7A8B19B248896", hash_generated_field = "14A9356888CCC2F5828130712AD7BEEF")

    private SSLSessionImpl session;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.537 -0500", hash_original_field = "E750AD196A1678C76301EB87A36D17D5", hash_generated_field = "45E3FC29C212ED74F873A281D50900AB")

    private boolean socket_was_closed = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.539 -0500", hash_original_field = "8EC89ADA2574F1DBC3DD4508F1BBC0BF", hash_generated_field = "04F8E3EB3EE7E0CB408AFC33E7A72359")

    // about supported and enabled cipher suites and protocols,
    // as well as the information about client/server mode of
    // ssl socket, whether it require/want client authentication or not,
    // and controls whether new SSL sessions may be established by this
    // socket or not.
    protected SSLParametersImpl sslParameters;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.541 -0500", hash_original_field = "7E31439956010383C009CD8F9D1171C9", hash_generated_field = "D316EEE6844FE498763EB8295772C4A2")

    protected InputStream input;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.544 -0500", hash_original_field = "FAE7C74574174D6344D6E09AD843B317", hash_generated_field = "0E6723CD0F1F5210EC010C59DA7A47E7")

    protected OutputStream output;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.546 -0500", hash_original_field = "62277C468EB34D88444F90B52C9C2418", hash_generated_field = "18AE5B2EA1E4D2608E5F816AEC3235B3")

    private ArrayList<HandshakeCompletedListener> listeners;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.548 -0500", hash_original_field = "DA51F0597BCD8FCD44A7B0CE5978547E", hash_generated_field = "0327D000C0AB01CB97996B4D95743A26")

    private Logger.Stream logger = Logger.getStream("socket");

    // ----------------- Constructors and initializers --------------------

    /**
     * Constructor
     * @param   sslParameters:  SSLParametersImpl
     * @see javax.net.ssl.SSLSocket#SSLSocket() method documentation
     * for more information.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.550 -0500", hash_original_method = "7B6D79A24FC469186EEF1935CCE0FAAE", hash_generated_method = "711FE1E8447AE5EE89CE997108A20791")
    
protected SSLSocketImpl(SSLParametersImpl sslParameters) {
        this.sslParameters = sslParameters;
        // init should be called after creation!
    }

    /**
     * Constructor
     * @param   host:   String
     * @param   port:   int
     * @param   sslParameters:  SSLParametersImpl
     * @throws  IOException
     * @throws  UnknownHostException
     * @see javax.net.ssl.SSLSocket#SSLSocket(String,int)
     * method documentation for more information.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.553 -0500", hash_original_method = "B90B14697CA53EAAAF818AFF9DD06A34", hash_generated_method = "F5C31F5F37E8515A9609CE04C71658E7")
    
protected SSLSocketImpl(String host, int port, SSLParametersImpl sslParameters)
            throws IOException, UnknownHostException {
        super(host, port);
        this.sslParameters = sslParameters;
        init();
    }

    /**
     * Constructor
     * @param   host:   String
     * @param   port:   int
     * @param   localHost:  InetAddress
     * @param   localPort:  int
     * @param   sslParameters:  SSLParametersImpl
     * @throws  IOException
     * @throws  UnknownHostException
     * @see javax.net.ssl.SSLSocket#SSLSocket(String,int,InetAddress,int)
     * method documentation for more information.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.556 -0500", hash_original_method = "A894226ED2FD2304A12A4E08266BE71A", hash_generated_method = "739DCAACA80EE1E83D48A0D805CCAB4F")
    
protected SSLSocketImpl(String host, int port,
            InetAddress localHost, int localPort,
            SSLParametersImpl sslParameters) throws IOException,
            UnknownHostException {
        super(host, port, localHost, localPort);
        this.sslParameters = sslParameters;
        init();
    }

    /**
     * Constructor
     * @param   host:   InetAddress
     * @param   port:   int
     * @param   sslParameters:  SSLParametersImpl
     * @return
     * @throws  IOException
     * @see javax.net.ssl.SSLSocket#SSLSocket(InetAddress,int)
     * method documentation for more information.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.559 -0500", hash_original_method = "21D48E905F577E64713F2C7CA9B1B030", hash_generated_method = "B3F4627E9AD5F48F2BBFEC62042D4E64")
    
protected SSLSocketImpl(InetAddress host, int port,
            SSLParametersImpl sslParameters) throws IOException {
        super(host, port);
        this.sslParameters = sslParameters;
        init();
    }

    /**
     * Constructor
     * @param   address:    InetAddress
     * @param   port:   int
     * @param   localAddress:   InetAddress
     * @param   localPort:  int
     * @param   sslParameters:  SSLParametersImpl
     * @return
     * @throws  IOException
     * @see javax.net.ssl.SSLSocket#SSLSocket(InetAddress,int,InetAddress,int)
     * method documentation for more information.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.561 -0500", hash_original_method = "6C5671217798C1BD7239CC8FEB7B883B", hash_generated_method = "98E2B3AADEC093B212C17CA7240D6368")
    
protected SSLSocketImpl(InetAddress address, int port,
            InetAddress localAddress, int localPort,
            SSLParametersImpl sslParameters) throws IOException {
        super(address, port, localAddress, localPort);
        this.sslParameters = sslParameters;
        init();
    }

    /**
     * Initialize the SSL socket.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.564 -0500", hash_original_method = "FD845B5AAD012D6985E0ADCD6A0F1286", hash_generated_method = "6AC59E1019471B8D4B6D15BF0D0252FC")
    
protected void init() throws IOException {
        if (appDataIS != null) {
            // already initialized
            return;
        }
        initTransportLayer();
        appDataIS = new SSLSocketInputStream(this);
        appDataOS = new SSLSocketOutputStream(this);
    }

    /**
     * Initialize the transport data streams.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.567 -0500", hash_original_method = "F1A82616FFDC8899DB87D416AB14644B", hash_generated_method = "D6AF9C14735C8B9884C35F7D7B605D3C")
    
protected void initTransportLayer() throws IOException {
        input = super.getInputStream();
        output = super.getOutputStream();
    }

    /**
     * Closes the transport data streams.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.569 -0500", hash_original_method = "651677798FC4CE70FB09611DD37A5D23", hash_generated_method = "D199AD0CE30B5F38BCBCD3D91E9021E0")
    
protected void closeTransportLayer() throws IOException {
        super.close();
        if (input != null) {
            input.close();
            output.close();
        }
    }

    // --------------- SSLParameters based methods ---------------------

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLSocket#getSupportedCipherSuites()
     * method documentation for more information
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.571 -0500", hash_original_method = "12BE90119F3183109C9DE5DBB63B352A", hash_generated_method = "0E9DEB7FA21717EA39000930983C1B84")
    
@Override
    public String[] getSupportedCipherSuites() {
        return CipherSuite.getSupportedCipherSuiteNames();
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLSocket#getEnabledCipherSuites()
     * method documentation for more information
     */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.573 -0500", hash_original_method = "80B545F2398A25060AECB1A23E821DD5", hash_generated_method = "9743EBAEBACB48E752148548CBED207E")
    
@Override
    public String[] getEnabledCipherSuites() {
        return sslParameters.getEnabledCipherSuites();
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLSocket#setEnabledCipherSuites(String[])
     * method documentation for more information
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.576 -0500", hash_original_method = "7C4ABDE66C2DD67AB299013913F9BF06", hash_generated_method = "C5557FA44AA989E23B0178177369FD5D")
    
@Override
    public void setEnabledCipherSuites(String[] suites) {
        sslParameters.setEnabledCipherSuites(suites);
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLSocket#getSupportedProtocols()
     * method documentation for more information
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.578 -0500", hash_original_method = "9A36300B3497119D0180A59D3E72D371", hash_generated_method = "0336F8759C7C42688A7C93D456C43BA3")
    
@Override
    public String[] getSupportedProtocols() {
        return ProtocolVersion.supportedProtocols.clone();
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLSocket#getEnabledProtocols()
     * method documentation for more information
     */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.580 -0500", hash_original_method = "9376751549A6436575C0783CA6C3A4A0", hash_generated_method = "33350DCBA69002691B7A369DC97FFA9B")
    
@Override
    public String[] getEnabledProtocols() {
        return sslParameters.getEnabledProtocols();
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLSocket#setEnabledProtocols(String[])
     * method documentation for more information
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.583 -0500", hash_original_method = "1CAC4BB68A222585D834DF0E7DBBD0B9", hash_generated_method = "5199FC3D60A4E4583B057C0623C822F9")
    
@Override
    public void setEnabledProtocols(String[] protocols) {
        sslParameters.setEnabledProtocols(protocols);
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLSocket#setUseClientMode(boolean)
     * method documentation for more information
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.585 -0500", hash_original_method = "3BB959BD0875F4D150E69C54372A8DCB", hash_generated_method = "9CA8AE73464BF134D0D3AFC6623315FF")
    
@Override
    public void setUseClientMode(boolean mode) {
        if (handshake_started) {
            throw new IllegalArgumentException(
            "Could not change the mode after the initial handshake has begun.");
        }
        sslParameters.setUseClientMode(mode);
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLSocket#getUseClientMode()
     * method documentation for more information
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.588 -0500", hash_original_method = "01F03276D647357C499C358366605A7A", hash_generated_method = "C189C4A91AE7529C93E5FE1A68636F7D")
    
@Override
    public boolean getUseClientMode() {
        return sslParameters.getUseClientMode();
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLSocket#setNeedClientAuth(boolean)
     * method documentation for more information
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.590 -0500", hash_original_method = "87B99BB5E16802D75B8230FD21E2413F", hash_generated_method = "C446CA4D04BF46EBA63D06A750C2C8C1")
    
@Override
    public void setNeedClientAuth(boolean need) {
        sslParameters.setNeedClientAuth(need);
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLSocket#getNeedClientAuth()
     * method documentation for more information
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.592 -0500", hash_original_method = "01CDFCACAD6C113BE18D967A4C320F8F", hash_generated_method = "1AC7C5FF07516804848811840A468A8B")
    
@Override
    public boolean getNeedClientAuth() {
        return sslParameters.getNeedClientAuth();
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLSocket#setWantClientAuth(boolean)
     * method documentation for more information
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.594 -0500", hash_original_method = "C4BE9213AE4AE3AE8B3FD470CA7DBEA1", hash_generated_method = "21E8FF7B7CE0E4FB146B4F3F0EE91E86")
    
@Override
    public void setWantClientAuth(boolean want) {
        sslParameters.setWantClientAuth(want);
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLSocket#getWantClientAuth()
     * method documentation for more information
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.596 -0500", hash_original_method = "BFCFACF4683D2DA63944456ACA1AFE4C", hash_generated_method = "C498EFFB7EA33937BE58E3D8E2A82C77")
    
@Override
    public boolean getWantClientAuth() {
        return sslParameters.getWantClientAuth();
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLSocket#setEnableSessionCreation(boolean)
     * method documentation for more information
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.598 -0500", hash_original_method = "CCC6382646A49B02E626A26467D69493", hash_generated_method = "3DEA9628617E70F67E1471694350041C")
    
@Override
    public void setEnableSessionCreation(boolean flag) {
        sslParameters.setEnableSessionCreation(flag);
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLSocket#getEnableSessionCreation()
     * method documentation for more information
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.601 -0500", hash_original_method = "67C983FA387520F5F3AF315C719B29E4", hash_generated_method = "F0850E2B8F230278D1EE6575AFA464E6")
    
@Override
    public boolean getEnableSessionCreation() {
        return sslParameters.getEnableSessionCreation();
    }

    // -----------------------------------------------------------------

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLSocket#getSession()
     * method documentation for more information
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.604 -0500", hash_original_method = "8713059613609B55626747E74A63D7AE", hash_generated_method = "7E4C1E86E24FC80D331FAE75DCB37CF2")
    
@Override
    public SSLSession getSession() {
        if (!handshake_started) {
            try {
                startHandshake();
            } catch (IOException e) {
                // return an invalid session with
                // invalid cipher suite of "SSL_NULL_WITH_NULL_NULL"
                return SSLSessionImpl.NULL_SESSION;
            }
        }
        return session;
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLSocket#addHandshakeCompletedListener(HandshakeCompletedListener)
     * method documentation for more information
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.607 -0500", hash_original_method = "F46B9A73766B8D71CEE8B005CFE82615", hash_generated_method = "7933A4C77A4CFD3C8964936A38D20F91")
    
@Override
    public void addHandshakeCompletedListener(
            HandshakeCompletedListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("Provided listener is null");
        }
        if (listeners == null) {
            listeners = new ArrayList<HandshakeCompletedListener>();
        }
        listeners.add(listener);
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLSocket#removeHandshakeCompletedListener(HandshakeCompletedListener)
     * method documentation for more information
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.609 -0500", hash_original_method = "AD8204C7E0D7DFC602B3A996AAF9AC40", hash_generated_method = "9ACD4602144599915DF0E9850F80A4D8")
    
@Override
    public void removeHandshakeCompletedListener(
            HandshakeCompletedListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("Provided listener is null");
        }
        if (listeners == null) {
            throw new IllegalArgumentException(
                    "Provided listener is not registered");
        }
        if (!listeners.remove(listener)) {
            throw new IllegalArgumentException(
                    "Provided listener is not registered");
        }
    }

    /**
     * Performs the handshake process over the SSL/TLS connection
     * as described in rfc 2246, TLS v1 specification
     * http://www.ietf.org/rfc/rfc2246.txt. If the initial handshake
     * has been already done, this method initiates rehandshake.
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLSocket#startHandshake()
     * method documentation for more information
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.612 -0500", hash_original_method = "765B8FA015660A1850228BA85BA4D2EA", hash_generated_method = "CA6ED245EC0E0A57425C294E408499EF")
    
@Override
    public void startHandshake() throws IOException {
        if (appDataIS == null) {
            throw new IOException("Socket is not connected.");
        }
        if (socket_was_closed) {
            throw new IOException("Socket has already been closed.");
        }

        if (!handshake_started) {
            handshake_started = true;
            if (sslParameters.getUseClientMode()) {
                if (logger != null) {
                    logger.println("SSLSocketImpl: CLIENT");
                }
                handshakeProtocol = new ClientHandshakeImpl(this);
            } else {
                if (logger != null) {
                    logger.println("SSLSocketImpl: SERVER");
                }
                handshakeProtocol = new ServerHandshakeImpl(this);
            }

            alertProtocol = new AlertProtocol();
            recordProtocol = new SSLRecordProtocol(handshakeProtocol,
                    alertProtocol, new SSLStreamedInput(input),
                    appDataIS.dataPoint);
        }

        if (logger != null) {
            logger.println("SSLSocketImpl.startHandshake");
        }

        handshakeProtocol.start();

        doHandshake();

        if (logger != null) {
            logger.println("SSLSocketImpl.startHandshake: END");
        }
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLSocket#getInputStream()
     * method documentation for more information
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.615 -0500", hash_original_method = "9F4C1AA967218079AF1BF56E431987CC", hash_generated_method = "A9AB11770AD56F04CBE49204BDB5EA30")
    
@Override
    public InputStream getInputStream() throws IOException {
        if (socket_was_closed) {
            throw new IOException("Socket has already been closed.");
        }
        return appDataIS;
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLSocket#getOutputStream()
     * method documentation for more information
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.617 -0500", hash_original_method = "E9E36047983E43D9B4652427AFC0EE2E", hash_generated_method = "349BE1051F6E996FDADC54EFE69E1809")
    
@Override
    public OutputStream getOutputStream() throws IOException {
        if (socket_was_closed) {
            throw new IOException("Socket has already been closed.");
        }
        return appDataOS;
    }

    /**
     * This method works according to the specification of implemented class.
     * @see java.net.Socket#connect(SocketAddress)
     * method documentation for more information
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.619 -0500", hash_original_method = "9C6F28F8DBD161E857A3A3894EC60A85", hash_generated_method = "D7D8C3012B2E8229BBDDE272C9BE3C3D")
    
@Override
    public void connect(SocketAddress endpoint) throws IOException {
        super.connect(endpoint);
        init();
    }

    /**
     * This method works according to the specification of implemented class.
     * @see java.net.Socket#connect(SocketAddress,int)
     * method documentation for more information
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.622 -0500", hash_original_method = "E1471735BF64AF2EDFAE20D8138E7876", hash_generated_method = "FDB570B2CBC178F03F604F889C186F51")
    
@Override
    public void connect(SocketAddress endpoint, int timeout)
            throws IOException {
        super.connect(endpoint, timeout);
        init();
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLSocket#close()
     * method documentation for more information
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.624 -0500", hash_original_method = "1C7BF244CDBA20FEDEE01D71D2117BF2", hash_generated_method = "BFBAC2E8A613A9A2D709CDE13C3A173B")
    
@Override
    public void close() throws IOException {
        if (logger != null) {
            logger.println("SSLSocket.close "+socket_was_closed);
        }
        if (!socket_was_closed) {
            if (handshake_started) {
                alertProtocol.alert(AlertProtocol.WARNING,
                        AlertProtocol.CLOSE_NOTIFY);
                try {
                    output.write(alertProtocol.wrap());
                } catch (IOException ex) { }
                alertProtocol.setProcessed();
            }
            shutdown();
            closeTransportLayer();
            socket_was_closed = true;
        }
    }

    /**
     * This method is not supported for SSLSocket implementation.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.627 -0500", hash_original_method = "76A321423E9827230577FC78A6A38E86", hash_generated_method = "B7DDBD1D342472346CC4D037D1CE3585")
    
@Override
    public void sendUrgentData(int data) throws IOException {
        throw new SocketException(
                "Method sendUrgentData() is not supported.");
    }

    /**
     * This method is not supported for SSLSocket implementation.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.629 -0500", hash_original_method = "274CE2EF30305C6385D88E550D3E79A6", hash_generated_method = "B9FF049CD8864259C2E7D0184D2DD414")
    
@Override
    public void setOOBInline(boolean on) throws SocketException {
        throw new SocketException(
                "Methods sendUrgentData, setOOBInline are not supported.");
    }

    // -----------------------------------------------------------------

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.632 -0500", hash_original_method = "14168DA1E68DB132A0DACBB007EAD125", hash_generated_method = "FCC0FBF4DFF5A546932E59AFF697EF35")
    
private void shutdown() {
        if (handshake_started) {
            alertProtocol.shutdown();
            alertProtocol = null;
            handshakeProtocol.shutdown();
            handshakeProtocol = null;
            recordProtocol.shutdown();
            recordProtocol = null;
        }
        socket_was_closed = true;
    }

    /**
     * This method is called by SSLSocketInputStream class
     * when client application tries to read application data from
     * the stream, but there is no data in its underlying buffer.
     * @throws  IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.635 -0500", hash_original_method = "9F181DA813C5E35277B72423F9B4689F", hash_generated_method = "E55E6F09FFD1A2C94BDE35A848616422")
    
protected void needAppData() throws IOException {
        if (!handshake_started) {
            startHandshake();
        }
        int type;
        if (logger != null) {
            logger.println("SSLSocket.needAppData..");
        }
        try {
            while(appDataIS.available() == 0) {
                // read and unwrap the record contained in the transport
                // input stream (SSLStreamedInput), pass it
                // to appropriate client protocol (alert, handshake, or app)
                // and retrieve the type of unwrapped data
                switch (type = recordProtocol.unwrap()) {
                    case ContentType.HANDSHAKE:
                        if (!handshakeProtocol.getStatus().equals(
                                SSLEngineResult.HandshakeStatus
                                .NOT_HANDSHAKING)) {
                            // handshake protocol got addressed to it message
                            // and did not ignore it, so it's a rehandshake
                            doHandshake();
                        }
                        break;
                    case ContentType.ALERT:
                        processAlert();
                        if (socket_was_closed) {
                            return;
                        }
                        break;
                    case ContentType.APPLICATION_DATA:
                        if (logger != null) {
                            logger.println(
                                    "SSLSocket.needAppData: got the data");
                        }
                        break;
                    default:
                        // will throw exception
                        reportFatalAlert(AlertProtocol.UNEXPECTED_MESSAGE,
                                new SSLException("Unexpected message of type "
                                    + type + " has been got"));
                }
                if (alertProtocol.hasAlert()) {
                    // warning alert occurred during wrap or unwrap
                    // (note: fatal alert causes AlertException
                    // to be thrown)
                    output.write(alertProtocol.wrap());
                    alertProtocol.setProcessed();
                }
                if (socket_was_closed) {
                    appDataIS.setEnd();
                    return;
                }
            }
        } catch (AlertException e) {
            // will throw exception
            reportFatalAlert(e.getDescriptionCode(), e.getReason());
        } catch (EndOfSourceException e) {
            // end of socket's input stream has been reached
            appDataIS.setEnd();
        }
        if (logger != null) {
            logger.println("SSLSocket.needAppData: app data len: "
                    + appDataIS.available());
        }
    }

    /**
     * This method is called by SSLSocketOutputStream when a client application
     * tries to send the data over ssl protocol.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.637 -0500", hash_original_method = "BD84CA3E70E7330B95C89C209BCE2D56", hash_generated_method = "73DFF748A323543548830A7D2DB94C80")
    
protected void writeAppData(byte[] data, int offset, int len) throws IOException {
        if (!handshake_started) {
            startHandshake();
        }
        if (logger != null) {
            logger.println("SSLSocket.writeAppData: " +
                    len + " " + SSLRecordProtocol.MAX_DATA_LENGTH);
            //logger.println(new String(data, offset, len));
        }
        try {
            if (len < SSLRecordProtocol.MAX_DATA_LENGTH) {
                output.write(recordProtocol.wrap(ContentType.APPLICATION_DATA,
                            data, offset, len));
            } else {
                while (len >= SSLRecordProtocol.MAX_DATA_LENGTH) {
                    output.write(recordProtocol.wrap(
                                ContentType.APPLICATION_DATA, data, offset,
                                SSLRecordProtocol.MAX_DATA_LENGTH));
                    offset += SSLRecordProtocol.MAX_DATA_LENGTH;
                    len -= SSLRecordProtocol.MAX_DATA_LENGTH;
                }
                if (len > 0) {
                    output.write(
                        recordProtocol.wrap(ContentType.APPLICATION_DATA,
                                            data, offset, len));
                }
            }
        } catch (AlertException e) {
            // will throw exception
            reportFatalAlert(e.getDescriptionCode(), e.getReason());
        }
    }

    /*
     * Performs handshake process over this connection. The handshake
     * process is directed by the handshake status code provided by
     * handshake protocol. If this status is NEED_WRAP, method retrieves
     * handshake message from handshake protocol and sends it to another peer.
     * If this status is NEED_UNWRAP, method receives and processes handshake
     * message from another peer. Each of this stages (wrap/unwrap) change
     * the state of handshake protocol and this process is performed
     * until handshake status is FINISHED. After handshake process is finished
     * handshake completed event are sent to the registered listeners.
     * For more information about the handshake process see
     * TLS v1 specification (http://www.ietf.org/rfc/rfc2246.txt) p 7.3.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.641 -0500", hash_original_method = "B11A6FC07E880C42041746EA2FD3607A", hash_generated_method = "B390D30128F47F32DFD6FAC34A8553D2")
    
private void doHandshake() throws IOException {
        SSLEngineResult.HandshakeStatus status;
        int type;
        try {
            while (!(status = handshakeProtocol.getStatus()).equals(
                        SSLEngineResult.HandshakeStatus.FINISHED)) {
                if (logger != null) {
                    String s = (status.equals(
                                SSLEngineResult.HandshakeStatus.NEED_WRAP))
                        ? "NEED_WRAP"
                        : (status.equals(
                                SSLEngineResult.HandshakeStatus.NEED_UNWRAP))
                            ? "NEED_UNWRAP"
                            : "STATUS: OTHER!";
                    logger.println("SSLSocketImpl: HS status: "+s+" "+status);
                }
                if (status.equals(SSLEngineResult.HandshakeStatus.NEED_WRAP)) {
                    output.write(handshakeProtocol.wrap());
                } else if (status.equals(
                            SSLEngineResult.HandshakeStatus.NEED_UNWRAP)) {
                    // read and unwrap the record contained in the transport
                    // input stream (SSLStreamedInput), pass it
                    // to appropriate client protocol (alert, handshake, or app)
                    // and retrieve the type of unwrapped data
                    switch (type = recordProtocol.unwrap()) {
                        case ContentType.HANDSHAKE:
                        case ContentType.CHANGE_CIPHER_SPEC:
                            break;
                        case ContentType.APPLICATION_DATA:
                            // So it's rehandshake and
                            // if app data buffer will be overloaded
                            // it will throw alert exception.
                            // Probably we should count the number of
                            // not handshaking data and make additional
                            // constraints (do not expect buffer overflow).
                            break;
                        case ContentType.ALERT:
                            processAlert();
                            if (socket_was_closed) {
                                return;
                            }
                            break;
                        default:
                            // will throw exception
                            reportFatalAlert(AlertProtocol.UNEXPECTED_MESSAGE,
                                    new SSLException(
                                        "Unexpected message of type "
                                        + type + " has been got"));
                    }
                } else {
                    // will throw exception
                    reportFatalAlert(AlertProtocol.INTERNAL_ERROR,
                        new SSLException(
                            "Handshake passed unexpected status: "+status));
                }
                if (alertProtocol.hasAlert()) {
                    // warning alert occurred during wrap or unwrap
                    // (note: fatal alert causes AlertException
                    // to be thrown)
                    output.write(alertProtocol.wrap());
                    alertProtocol.setProcessed();
                }
            }
        } catch (EndOfSourceException e) {
            appDataIS.setEnd();
            throw new IOException("Connection was closed");
        } catch (AlertException e) {
            // will throw exception
            reportFatalAlert(e.getDescriptionCode(), e.getReason());
        }

        session = recordProtocol.getSession();
        if (listeners != null) {
            // notify the listeners
            HandshakeCompletedEvent event =
                new HandshakeCompletedEvent(this, session);
            int size = listeners.size();
            for (int i=0; i<size; i++) {
                listeners.get(i)
                    .handshakeCompleted(event);
            }
        }
    }

    /*
     * Process received alert message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.643 -0500", hash_original_method = "1DCA961CD2F2BCD453967A97232AAFC6", hash_generated_method = "A8B7062F8367F20FC4580E74BE3759BF")
    
private void processAlert() throws IOException {
        if (!alertProtocol.hasAlert()) {
            return;
        }
        if (alertProtocol.isFatalAlert()) {
            alertProtocol.setProcessed();
            String description = "Fatal alert received "
                + alertProtocol.getAlertDescription();
            shutdown();
            throw new SSLException(description);
        }

        if (logger != null) {
            logger.println("Warning alert received: "
                + alertProtocol.getAlertDescription());
        }
        switch(alertProtocol.getDescriptionCode()) {
            case AlertProtocol.CLOSE_NOTIFY:
                alertProtocol.setProcessed();
                appDataIS.setEnd();
                close();
                return;
            default:
                alertProtocol.setProcessed();
            // TODO: process other warning messages
        }
    }

    /*
     * Sends fatal alert message and throws exception
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.646 -0500", hash_original_method = "716B8ABB2A0B730F9297C2C81BE3F29D", hash_generated_method = "6E69DEE0413F82146C20AEC1FA818168")
    
private void reportFatalAlert(byte description_code,
            SSLException reason) throws IOException {
        alertProtocol.alert(AlertProtocol.FATAL, description_code);
        try {
            // the output stream can be closed
            output.write(alertProtocol.wrap());
        } catch (IOException ex) { }
        alertProtocol.setProcessed();
        shutdown();
        throw reason;
    }
    
}

