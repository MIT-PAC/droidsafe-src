package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import javax.net.ssl.SSLServerSocket;

public class SSLServerSocketImpl extends SSLServerSocket {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.890 -0500", hash_original_field = "8EC89ADA2574F1DBC3DD4508F1BBC0BF", hash_generated_field = "AC5C8E3DAC2E9F1A1DA44B231474BF8D")

    // about supported and enabled cipher suites and protocols,
    // as well as the information about client/server mode of
    // ssl socket, whether it require/want client authentication or not,
    // and controls whether new SSL sessions may be established by this
    // socket or not.
    private  SSLParametersImpl sslParameters;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.892 -0500", hash_original_field = "0F69A01F76F8A90C102ACB0CD73A72F4", hash_generated_field = "9B2AF06FBD36AF1B19FC02AD8414FDA5")

    private Logger.Stream logger = Logger.getStream("ssocket");

    /**
     * Ctor
     * @param   sslParameters:  SSLParameters
     * @throws  IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.895 -0500", hash_original_method = "3C51E4D29638B27E77C8772382B20970", hash_generated_method = "2E5833073A0D2EB1A2710A8323EF19D7")
    
protected SSLServerSocketImpl(SSLParametersImpl sslParameters) throws IOException {
        this.sslParameters = sslParameters;
    }

    /**
     * Ctor
     * @param   port:   int
     * @param   sslParameters:  SSLParameters
     * @throws  IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.898 -0500", hash_original_method = "964D36D73A9D78EC878BB4C8C1192330", hash_generated_method = "16C62BC047D9378D5E6AE9F09E6E34BC")
    
protected SSLServerSocketImpl(int port, SSLParametersImpl sslParameters)
        throws IOException {
        super(port);
        this.sslParameters = sslParameters;
    }

    /**
     * Ctor
     * @param   port:   int
     * @param   backlog:    int
     * @param   sslParameters:  SSLParameters
     * @throws  IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.901 -0500", hash_original_method = "99AA71D25BC131720F5627E787888583", hash_generated_method = "5F7C0B1454935E0311A667FE088C7D31")
    
protected SSLServerSocketImpl(int port, int backlog,
            SSLParametersImpl sslParameters) throws IOException {
        super(port, backlog);
        this.sslParameters = sslParameters;
    }

    /**
     * Ctor
     * @param   port:   int
     * @param   backlog:    int
     * @param   iAddress:   InetAddress
     * @param   sslParameters:  SSLParameters
     * @throws  IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.903 -0500", hash_original_method = "02A799087F98193615A0535EAB6C7699", hash_generated_method = "43A60EAA61D3D56161E66C24476373D2")
    
protected SSLServerSocketImpl(int port, int backlog,
                                InetAddress iAddress,
                                SSLParametersImpl sslParameters)
        throws IOException {
        super(port, backlog, iAddress);
        this.sslParameters = sslParameters;
    }

    // --------------- SSLParameters based methods ---------------------

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLServerSocket#getSupportedCipherSuites()
     * method documentation for more information
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.905 -0500", hash_original_method = "12BE90119F3183109C9DE5DBB63B352A", hash_generated_method = "0E9DEB7FA21717EA39000930983C1B84")
    
@Override
    public String[] getSupportedCipherSuites() {
        return CipherSuite.getSupportedCipherSuiteNames();
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLServerSocket#getEnabledCipherSuites()
     * method documentation for more information
     */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.907 -0500", hash_original_method = "80B545F2398A25060AECB1A23E821DD5", hash_generated_method = "9743EBAEBACB48E752148548CBED207E")
    
@Override
    public String[] getEnabledCipherSuites() {
        return sslParameters.getEnabledCipherSuites();
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLServerSocket#setEnabledCipherSuites(String[])
     * method documentation for more information
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.909 -0500", hash_original_method = "7C4ABDE66C2DD67AB299013913F9BF06", hash_generated_method = "C5557FA44AA989E23B0178177369FD5D")
    
@Override
    public void setEnabledCipherSuites(String[] suites) {
        sslParameters.setEnabledCipherSuites(suites);
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLServerSocket#getSupportedProtocols()
     * method documentation for more information
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.912 -0500", hash_original_method = "9A36300B3497119D0180A59D3E72D371", hash_generated_method = "0336F8759C7C42688A7C93D456C43BA3")
    
@Override
    public String[] getSupportedProtocols() {
        return ProtocolVersion.supportedProtocols.clone();
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLServerSocket#getEnabledProtocols()
     * method documentation for more information
     */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.914 -0500", hash_original_method = "9376751549A6436575C0783CA6C3A4A0", hash_generated_method = "33350DCBA69002691B7A369DC97FFA9B")
    
@Override
    public String[] getEnabledProtocols() {
        return sslParameters.getEnabledProtocols();
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLServerSocket#setEnabledProtocols(String[])
     * method documentation for more information
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.917 -0500", hash_original_method = "1CAC4BB68A222585D834DF0E7DBBD0B9", hash_generated_method = "5199FC3D60A4E4583B057C0623C822F9")
    
@Override
    public void setEnabledProtocols(String[] protocols) {
        sslParameters.setEnabledProtocols(protocols);
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLServerSocket#setUseClientMode(boolean)
     * method documentation for more information
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.919 -0500", hash_original_method = "433F9F6F1671E88E2914017CCCE9CE51", hash_generated_method = "ED0148AE7F6FFE9B057DEA60FFD079FA")
    
@Override
    public void setUseClientMode(boolean mode) {
        sslParameters.setUseClientMode(mode);
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLServerSocket#getUseClientMode()
     * method documentation for more information
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.921 -0500", hash_original_method = "01F03276D647357C499C358366605A7A", hash_generated_method = "C189C4A91AE7529C93E5FE1A68636F7D")
    
@Override
    public boolean getUseClientMode() {
        return sslParameters.getUseClientMode();
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLServerSocket#setNeedClientAuth(boolean)
     * method documentation for more information
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.924 -0500", hash_original_method = "87B99BB5E16802D75B8230FD21E2413F", hash_generated_method = "C446CA4D04BF46EBA63D06A750C2C8C1")
    
@Override
    public void setNeedClientAuth(boolean need) {
        sslParameters.setNeedClientAuth(need);
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLServerSocket#getNeedClientAuth()
     * method documentation for more information
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.927 -0500", hash_original_method = "01CDFCACAD6C113BE18D967A4C320F8F", hash_generated_method = "1AC7C5FF07516804848811840A468A8B")
    
@Override
    public boolean getNeedClientAuth() {
        return sslParameters.getNeedClientAuth();
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLServerSocket#setWantClientAuth(boolean)
     * method documentation for more information
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.929 -0500", hash_original_method = "C4BE9213AE4AE3AE8B3FD470CA7DBEA1", hash_generated_method = "21E8FF7B7CE0E4FB146B4F3F0EE91E86")
    
@Override
    public void setWantClientAuth(boolean want) {
        sslParameters.setWantClientAuth(want);
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLServerSocket#getWantClientAuth()
     * method documentation for more information
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.931 -0500", hash_original_method = "BFCFACF4683D2DA63944456ACA1AFE4C", hash_generated_method = "C498EFFB7EA33937BE58E3D8E2A82C77")
    
@Override
    public boolean getWantClientAuth() {
        return sslParameters.getWantClientAuth();
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLServerSocket#setEnableSessionCreation(boolean)
     * method documentation for more information
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.933 -0500", hash_original_method = "CCC6382646A49B02E626A26467D69493", hash_generated_method = "3DEA9628617E70F67E1471694350041C")
    
@Override
    public void setEnableSessionCreation(boolean flag) {
        sslParameters.setEnableSessionCreation(flag);
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLServerSocket#getEnableSessionCreation()
     * method documentation for more information
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.936 -0500", hash_original_method = "67C983FA387520F5F3AF315C719B29E4", hash_generated_method = "F0850E2B8F230278D1EE6575AFA464E6")
    
@Override
    public boolean getEnableSessionCreation() {
        return sslParameters.getEnableSessionCreation();
    }

    // ------------- ServerSocket's methods overridings ----------------

    /**
     * This method works according to the specification of implemented class.
     * @see java.net.ServerSocket#accept()
     * method documentation for more information
     */
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.938 -0500", hash_original_method = "E95178BAD1AB83F5F7B2A543005EDE81", hash_generated_method = "17712134355116B68147B90F3DC24856")
    
@Override
    public Socket accept() throws IOException {
        if (logger != null) {
            logger.println("SSLServerSocketImpl.accept ..");
        }
        SSLSocketImpl s = new SSLSocketImpl(
                (SSLParametersImpl) sslParameters.clone());
        implAccept(s);
        s.init();
        if (logger != null) {
            logger.println("SSLServerSocketImpl: accepted, initialized");
        }
        return s;
    }

    /**
     * Returns the string representation of the object.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.940 -0500", hash_original_method = "2BD2C11E492A0926A3928FBE6062AA1A", hash_generated_method = "432462BB27832EACC9C5D0D13F532176")
    
@Override
    public String toString() {
        return "[SSLServerSocketImpl]";
    }
    
}

