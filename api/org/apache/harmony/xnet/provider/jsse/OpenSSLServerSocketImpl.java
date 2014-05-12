package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.PrivateKey;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.RSAPrivateKey;

import javax.net.ssl.SSLException;

public class OpenSSLServerSocketImpl extends javax.net.ssl.SSLServerSocket {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.860 -0500", hash_original_field = "8EC89ADA2574F1DBC3DD4508F1BBC0BF", hash_generated_field = "D3BEC3280BC0116C55BDEA33933A255E")

    private  SSLParametersImpl sslParameters;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.862 -0500", hash_original_field = "BD0F69E0AE6832E2DA7DFFF53D0864B1", hash_generated_field = "FBCBD52754741D7438A5F0626E230C0A")

    private String[] enabledProtocols = NativeCrypto.getSupportedProtocols();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.864 -0500", hash_original_field = "BBC945E23F326D21C0C811ACEB30EF2A", hash_generated_field = "0F74E643B9EF4BBD2405C9C1F6E6B316")

    private String[] enabledCipherSuites = NativeCrypto.getDefaultCipherSuites();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.867 -0500", hash_original_field = "7D973B9A0DABD47A526B011EEFA01293", hash_generated_field = "801901FD9A6E6592B7BE17AD2DCDCDAF")

    private String[] enabledCompressionMethods = NativeCrypto.getDefaultCompressionMethods();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.870 -0500", hash_original_method = "E4A94FB7C9239842E6393D001A5B9FB9", hash_generated_method = "A61CFB5DF3CD773054908D0CE987614A")
    
protected OpenSSLServerSocketImpl(SSLParametersImpl sslParameters) throws IOException {
        this.sslParameters = sslParameters;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.873 -0500", hash_original_method = "312A77FCAC868BCFB6F2606DB60F4B03", hash_generated_method = "B98C238D5D264BF8418675FDE5DAC87C")
    
protected OpenSSLServerSocketImpl(int port, SSLParametersImpl sslParameters)
        throws IOException {
        super(port);
        this.sslParameters = sslParameters;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.875 -0500", hash_original_method = "630526CC73F2D17479EBF6EBA8A0B0BE", hash_generated_method = "FBCE39AC6FAF07E33F97620BC727410C")
    
protected OpenSSLServerSocketImpl(int port, int backlog, SSLParametersImpl sslParameters)
        throws IOException {
        super(port, backlog);
        this.sslParameters = sslParameters;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.878 -0500", hash_original_method = "2424C79CDC16004A7D4C41CEACBD5654", hash_generated_method = "3F1B04DD6D90F2086C52450C0412320F")
    
protected OpenSSLServerSocketImpl(int port,
                                      int backlog,
                                      InetAddress iAddress,
                                      SSLParametersImpl sslParameters)
        throws IOException {
        super(port, backlog, iAddress);
        this.sslParameters = sslParameters;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.880 -0500", hash_original_method = "67C983FA387520F5F3AF315C719B29E4", hash_generated_method = "F0850E2B8F230278D1EE6575AFA464E6")
    
@Override
    public boolean getEnableSessionCreation() {
        return sslParameters.getEnableSessionCreation();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.882 -0500", hash_original_method = "CCC6382646A49B02E626A26467D69493", hash_generated_method = "3DEA9628617E70F67E1471694350041C")
    
@Override
    public void setEnableSessionCreation(boolean flag) {
        sslParameters.setEnableSessionCreation(flag);
    }

    /**
     * The names of the protocols' versions that may be used on this SSL
     * connection.
     * @return an array of protocols names
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.885 -0500", hash_original_method = "B10F1AAC80A139AD997D0D8B0338DD89", hash_generated_method = "AC03A33ED96900A1F6F22E082B4D218D")
    
@Override
    public String[] getSupportedProtocols() {
        return NativeCrypto.getSupportedProtocols();
    }

    /**
     * The names of the protocols' versions that in use on this SSL connection.
     *
     * @return an array of protocols names
     */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.887 -0500", hash_original_method = "26510D7872AB5791B4C2075CD3368FCD", hash_generated_method = "F66B93BEA1257A9D34745668F1A12518")
    
@Override
    public String[] getEnabledProtocols() {
        return enabledProtocols.clone();
    }

    /**
     * This method enables the protocols' versions listed by
     * getSupportedProtocols().
     *
     * @param protocols names of all the protocols to enable.
     *
     * @throws IllegalArgumentException when one or more of the names in the
     *             array are not supported, or when the array is null.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.889 -0500", hash_original_method = "4F25266A0ABB18E1CEC5E2893BCF6C12", hash_generated_method = "1247E6E288197D24DA3BC8CBC688F7CB")
    
@Override
    public void setEnabledProtocols(String[] protocols) {
        enabledProtocols = NativeCrypto.checkEnabledProtocols(protocols);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.892 -0500", hash_original_method = "1B8AAFC0DA0BD632205C9BB94F36BE40", hash_generated_method = "FC9C3F1BC74E6756C08730F8099184A3")
    
@Override
    public String[] getSupportedCipherSuites() {
        return NativeCrypto.getSupportedCipherSuites();
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.894 -0500", hash_original_method = "5CCACD4A046B80B9464615B5EFBE522F", hash_generated_method = "9609D63D06C0561070F00E8FC5B0E108")
    
@Override
    public String[] getEnabledCipherSuites() {
        return enabledCipherSuites.clone();
    }

    /**
     * This method enables the cipher suites listed by
     * getSupportedCipherSuites().
     *
     * @param suites the names of all the cipher suites to enable
     * @throws IllegalArgumentException when one or more of the ciphers in array
     *         suites are not supported, or when the array is null.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.896 -0500", hash_original_method = "A8F29A0117C2056BB4F12EE1D48F5595", hash_generated_method = "7334BD36327A5C0E4641C62AF79624D8")
    
@Override
    public void setEnabledCipherSuites(String[] suites) {
        enabledCipherSuites = NativeCrypto.checkEnabledCipherSuites(suites);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.899 -0500", hash_original_method = "375DD2648264EE3CAE4788D31A756EC5", hash_generated_method = "2000058BEAA332AE77D61F063BCEA525")
    
public String[] getSupportedCompressionMethods() {
        return NativeCrypto.getSupportedCompressionMethods();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.901 -0500", hash_original_method = "1BCE54E87A889265E8FA0E0B8689F62E", hash_generated_method = "10DC971DCE29DCF3C55D4ADAA3DDF81D")
    
public String[] getEnabledCompressionMethods() {
        return enabledCompressionMethods.clone();
    }

    /**
     * This method enables the compression methods listed by
     * getSupportedCompressionMethods().
     *
     * @param suites the names of all the compression methods to enable
     * @throws IllegalArgumentException when one or more of the ciphers in array
     *         suites are not supported, or when the array is null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.903 -0500", hash_original_method = "8EA4CA69B5E5586515E70C8BB15F1DC8", hash_generated_method = "0DCC27219D70BDB0B9608EAB28F41BF8")
    
public void setEnabledCompressionMethods(String[] methods) {
        enabledCompressionMethods = NativeCrypto.checkEnabledCompressionMethods(methods);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.905 -0500", hash_original_method = "BFCFACF4683D2DA63944456ACA1AFE4C", hash_generated_method = "C498EFFB7EA33937BE58E3D8E2A82C77")
    
@Override
    public boolean getWantClientAuth() {
        return sslParameters.getWantClientAuth();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.908 -0500", hash_original_method = "C4BE9213AE4AE3AE8B3FD470CA7DBEA1", hash_generated_method = "21E8FF7B7CE0E4FB146B4F3F0EE91E86")
    
@Override
    public void setWantClientAuth(boolean want) {
        sslParameters.setWantClientAuth(want);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.910 -0500", hash_original_method = "01CDFCACAD6C113BE18D967A4C320F8F", hash_generated_method = "1AC7C5FF07516804848811840A468A8B")
    
@Override
    public boolean getNeedClientAuth() {
        return sslParameters.getNeedClientAuth();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.912 -0500", hash_original_method = "87B99BB5E16802D75B8230FD21E2413F", hash_generated_method = "C446CA4D04BF46EBA63D06A750C2C8C1")
    
@Override
    public void setNeedClientAuth(boolean need) {
        sslParameters.setNeedClientAuth(need);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.915 -0500", hash_original_method = "433F9F6F1671E88E2914017CCCE9CE51", hash_generated_method = "ED0148AE7F6FFE9B057DEA60FFD079FA")
    
@Override
    public void setUseClientMode(boolean mode) {
        sslParameters.setUseClientMode(mode);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.917 -0500", hash_original_method = "01F03276D647357C499C358366605A7A", hash_generated_method = "C189C4A91AE7529C93E5FE1A68636F7D")
    
@Override
    public boolean getUseClientMode() {
        return sslParameters.getUseClientMode();
    }

    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.919 -0500", hash_original_method = "99974EADFE56BC36D8DB1EC28EC422DC", hash_generated_method = "99EF77F3105C5D5B8A0321C96B886399")
    
@Override
    public Socket accept() throws IOException {

        if (!sslParameters.getUseClientMode()) {
            checkEnabledCipherSuites();
        }

        OpenSSLSocketImpl socket = new OpenSSLSocketImpl(sslParameters,
                                                         enabledProtocols.clone(),
                                                         enabledCipherSuites.clone(),
                                                         enabledCompressionMethods.clone());
        implAccept(socket);
        return socket;
    }

    /**
     * Check if any of the enabled cipher suites has a chance to work.
     * Not 100% accurate, just a useful diagnostic that the RI does.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.922 -0500", hash_original_method = "8DBC4EF4AD92DA8E96BA5DD8978DFCC3", hash_generated_method = "CD1D77D9A778F7D82D8B86B86F8CEF90")
    
private void checkEnabledCipherSuites() throws SSLException {
        /* Loop over all enabled cipher suites. If we find a problem,
         * we just continue to the next one. If we find one that could
         * work, we return. This basically makes sure the caller has
         * configured some appropriate certificate/key unless
         * an anonymous cipher is picked.
         */
        for (String enabledCipherSuite : enabledCipherSuites) {
            if (enabledCipherSuite.equals(NativeCrypto.TLS_EMPTY_RENEGOTIATION_INFO_SCSV)) {
                continue;
            }
            String keyType = CipherSuite.getByName(enabledCipherSuite).getServerKeyType();
            if (keyType == null) {
                // anonymous always work
                return;
            }
            if (keyType.equals(CipherSuite.KEY_TYPE_RSA)
                    || keyType.equals(CipherSuite.KEY_TYPE_DH_RSA)) {
                if (checkForPrivateKey(keyType, RSAPrivateKey.class)) {
                    return;
                }
                continue;
            }
            if (keyType.equals(CipherSuite.KEY_TYPE_DSA)
                    || keyType.equals(CipherSuite.KEY_TYPE_DH_DSA)) {
                if (checkForPrivateKey(keyType, DSAPrivateKey.class)) {
                    return;
                }
                continue;
            }
            if (keyType.equals(CipherSuite.KEY_TYPE_EC)
                    || keyType.equals(CipherSuite.KEY_TYPE_EC_RSA)
                    || keyType.equals(CipherSuite.KEY_TYPE_EC_EC)) {
                if (checkForPrivateKey(keyType, ECPrivateKey.class)) {
                    return;
                }
                continue;
            }
            throw new IllegalStateException("Unknown key type " + keyType);
        }
        throw new SSLException("Could not find any key store entries "
                               + "to support the enabled cipher suites.");
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.925 -0500", hash_original_method = "23192C3ABD6FAD935D4B733BEA5E6735", hash_generated_method = "3454A90EE543E820D00A7F276E193966")
    
private boolean checkForPrivateKey(String keyType, Class keyClass) {
        String alias = sslParameters.getKeyManager().chooseServerAlias(keyType, null, null);
        if (alias == null) {
            return false;
        }
        PrivateKey key = sslParameters.getKeyManager().getPrivateKey(alias);
        return (key != null && keyClass.isAssignableFrom(key.getClass()));
    }
    
}

