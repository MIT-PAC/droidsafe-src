package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.PrivateKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.RSAPrivateKey;
import javax.net.ssl.SSLException;

public class OpenSSLServerSocketImpl extends javax.net.ssl.SSLServerSocket {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.267 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "D3BEC3280BC0116C55BDEA33933A255E")

    private SSLParametersImpl sslParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.268 -0400", hash_original_field = "58A40B900DAEA3C6B7D5DD4A12BD7A24", hash_generated_field = "FBCBD52754741D7438A5F0626E230C0A")

    private String[] enabledProtocols = NativeCrypto.getSupportedProtocols();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.268 -0400", hash_original_field = "EE48808D4C8FD73BEECC54F5760958ED", hash_generated_field = "0F74E643B9EF4BBD2405C9C1F6E6B316")

    private String[] enabledCipherSuites = NativeCrypto.getDefaultCipherSuites();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.268 -0400", hash_original_field = "619581E16C646CFFEDCD04037998AB99", hash_generated_field = "801901FD9A6E6592B7BE17AD2DCDCDAF")

    private String[] enabledCompressionMethods = NativeCrypto.getDefaultCompressionMethods();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.269 -0400", hash_original_method = "E4A94FB7C9239842E6393D001A5B9FB9", hash_generated_method = "431E5CD9106B1EC78566243984CF3B1A")
    protected  OpenSSLServerSocketImpl(SSLParametersImpl sslParameters) throws IOException {
        this.sslParameters = sslParameters;
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.269 -0400", hash_original_method = "312A77FCAC868BCFB6F2606DB60F4B03", hash_generated_method = "9118074490BC03A594133149D7AE5E27")
    protected  OpenSSLServerSocketImpl(int port, SSLParametersImpl sslParameters) throws IOException {
        super(port);
        this.sslParameters = sslParameters;
        addTaint(port);
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.281 -0400", hash_original_method = "630526CC73F2D17479EBF6EBA8A0B0BE", hash_generated_method = "7350B23A6ED8DFD879602EF6AD1430CE")
    protected  OpenSSLServerSocketImpl(int port, int backlog, SSLParametersImpl sslParameters) throws IOException {
        super(port, backlog);
        this.sslParameters = sslParameters;
        addTaint(port);
        addTaint(backlog);
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.282 -0400", hash_original_method = "2424C79CDC16004A7D4C41CEACBD5654", hash_generated_method = "E45BBE50CE144CD57A9C3801B731ED5F")
    protected  OpenSSLServerSocketImpl(int port,
                                      int backlog,
                                      InetAddress iAddress,
                                      SSLParametersImpl sslParameters) throws IOException {
        super(port, backlog, iAddress);
        this.sslParameters = sslParameters;
        addTaint(port);
        addTaint(backlog);
        addTaint(iAddress.getTaint());
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.282 -0400", hash_original_method = "67C983FA387520F5F3AF315C719B29E4", hash_generated_method = "560CD450E6ABABDD5AB4AC65E0A093E3")
    @Override
    public boolean getEnableSessionCreation() {
        boolean varAFF7A8ADF82548D8DE353C67D9576F3E_921093998 = (sslParameters.getEnableSessionCreation());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_149497686 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_149497686;
        // ---------- Original Method ----------
        //return sslParameters.getEnableSessionCreation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.282 -0400", hash_original_method = "CCC6382646A49B02E626A26467D69493", hash_generated_method = "781712039B284C5CB7B48D72B261E886")
    @Override
    public void setEnableSessionCreation(boolean flag) {
        sslParameters.setEnableSessionCreation(flag);
        addTaint(flag);
        // ---------- Original Method ----------
        //sslParameters.setEnableSessionCreation(flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.283 -0400", hash_original_method = "B10F1AAC80A139AD997D0D8B0338DD89", hash_generated_method = "DF3897599C60104738F604FE9EF8D414")
    @Override
    public String[] getSupportedProtocols() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_395383029 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_395383029 = NativeCrypto.getSupportedProtocols();
        varB4EAC82CA7396A68D541C85D26508E83_395383029.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_395383029;
        // ---------- Original Method ----------
        //return NativeCrypto.getSupportedProtocols();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.283 -0400", hash_original_method = "26510D7872AB5791B4C2075CD3368FCD", hash_generated_method = "1B5A9E50882EC0F3D8A45ED477E0FE8E")
    @Override
    public String[] getEnabledProtocols() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1333997507 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1333997507 = enabledProtocols.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1333997507.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1333997507;
        // ---------- Original Method ----------
        //return enabledProtocols.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.284 -0400", hash_original_method = "4F25266A0ABB18E1CEC5E2893BCF6C12", hash_generated_method = "3A7DB44E7B143D29605895C639B518A6")
    @Override
    public void setEnabledProtocols(String[] protocols) {
        enabledProtocols = NativeCrypto.checkEnabledProtocols(protocols);
        // ---------- Original Method ----------
        //enabledProtocols = NativeCrypto.checkEnabledProtocols(protocols);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.300 -0400", hash_original_method = "1B8AAFC0DA0BD632205C9BB94F36BE40", hash_generated_method = "2141AF2804F64CC76BA5182CBF036839")
    @Override
    public String[] getSupportedCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1087455516 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1087455516 = NativeCrypto.getSupportedCipherSuites();
        varB4EAC82CA7396A68D541C85D26508E83_1087455516.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1087455516;
        // ---------- Original Method ----------
        //return NativeCrypto.getSupportedCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.300 -0400", hash_original_method = "5CCACD4A046B80B9464615B5EFBE522F", hash_generated_method = "86CE90218830E2BC99B54484E6353785")
    @Override
    public String[] getEnabledCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1236586393 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1236586393 = enabledCipherSuites.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1236586393.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1236586393;
        // ---------- Original Method ----------
        //return enabledCipherSuites.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.301 -0400", hash_original_method = "A8F29A0117C2056BB4F12EE1D48F5595", hash_generated_method = "3FB2F096A8758F371B7BAF38AC6E6A62")
    @Override
    public void setEnabledCipherSuites(String[] suites) {
        enabledCipherSuites = NativeCrypto.checkEnabledCipherSuites(suites);
        // ---------- Original Method ----------
        //enabledCipherSuites = NativeCrypto.checkEnabledCipherSuites(suites);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.301 -0400", hash_original_method = "375DD2648264EE3CAE4788D31A756EC5", hash_generated_method = "4D532CF6B5CBDA37322F03F84FD0072D")
    public String[] getSupportedCompressionMethods() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_722749850 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_722749850 = NativeCrypto.getSupportedCompressionMethods();
        varB4EAC82CA7396A68D541C85D26508E83_722749850.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_722749850;
        // ---------- Original Method ----------
        //return NativeCrypto.getSupportedCompressionMethods();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.310 -0400", hash_original_method = "1BCE54E87A889265E8FA0E0B8689F62E", hash_generated_method = "C687B35D7E0CCE74A1B8C159FD858D3D")
    public String[] getEnabledCompressionMethods() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_649979313 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_649979313 = enabledCompressionMethods.clone();
        varB4EAC82CA7396A68D541C85D26508E83_649979313.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_649979313;
        // ---------- Original Method ----------
        //return enabledCompressionMethods.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.311 -0400", hash_original_method = "8EA4CA69B5E5586515E70C8BB15F1DC8", hash_generated_method = "F6E8AD11719A044F802E33A113589650")
    public void setEnabledCompressionMethods(String[] methods) {
        enabledCompressionMethods = NativeCrypto.checkEnabledCompressionMethods(methods);
        // ---------- Original Method ----------
        //enabledCompressionMethods = NativeCrypto.checkEnabledCompressionMethods(methods);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.311 -0400", hash_original_method = "BFCFACF4683D2DA63944456ACA1AFE4C", hash_generated_method = "E7169BE49CEBC625F09279FCCDF4C4E0")
    @Override
    public boolean getWantClientAuth() {
        boolean var1F88322EA2F28C29D3EC82222D21AA46_171830116 = (sslParameters.getWantClientAuth());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_367669518 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_367669518;
        // ---------- Original Method ----------
        //return sslParameters.getWantClientAuth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.311 -0400", hash_original_method = "C4BE9213AE4AE3AE8B3FD470CA7DBEA1", hash_generated_method = "36D0D50995337D2D75DCB0482721034F")
    @Override
    public void setWantClientAuth(boolean want) {
        sslParameters.setWantClientAuth(want);
        addTaint(want);
        // ---------- Original Method ----------
        //sslParameters.setWantClientAuth(want);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.312 -0400", hash_original_method = "01CDFCACAD6C113BE18D967A4C320F8F", hash_generated_method = "74584FF4A501461986FD566433D01F09")
    @Override
    public boolean getNeedClientAuth() {
        boolean var666666A183221FEF9E4AC429A4F2FC13_1027214227 = (sslParameters.getNeedClientAuth());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_104230769 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_104230769;
        // ---------- Original Method ----------
        //return sslParameters.getNeedClientAuth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.312 -0400", hash_original_method = "87B99BB5E16802D75B8230FD21E2413F", hash_generated_method = "0546B005C61E39ED72A709422B43B69F")
    @Override
    public void setNeedClientAuth(boolean need) {
        sslParameters.setNeedClientAuth(need);
        addTaint(need);
        // ---------- Original Method ----------
        //sslParameters.setNeedClientAuth(need);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.312 -0400", hash_original_method = "433F9F6F1671E88E2914017CCCE9CE51", hash_generated_method = "B53D1E1AA2CE361BFDB5ACAD024F9619")
    @Override
    public void setUseClientMode(boolean mode) {
        sslParameters.setUseClientMode(mode);
        addTaint(mode);
        // ---------- Original Method ----------
        //sslParameters.setUseClientMode(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.312 -0400", hash_original_method = "01F03276D647357C499C358366605A7A", hash_generated_method = "1CF895213E8FB41757838A1B3B60F3EA")
    @Override
    public boolean getUseClientMode() {
        boolean var5D6C317C7C34AA34FED4DDA3BFA46DAC_1958650731 = (sslParameters.getUseClientMode());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2008047626 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2008047626;
        // ---------- Original Method ----------
        //return sslParameters.getUseClientMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.313 -0400", hash_original_method = "99974EADFE56BC36D8DB1EC28EC422DC", hash_generated_method = "68EEE853C691C91E40093B7173840A14")
    @Override
    public Socket accept() throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_6234639 = null; //Variable for return #1
        {
            boolean varAC7C523728C9F1CC5BE4FE21E1F0D4C1_1659634078 = (!sslParameters.getUseClientMode());
            {
                checkEnabledCipherSuites();
            } //End block
        } //End collapsed parenthetic
        OpenSSLSocketImpl socket;
        socket = new OpenSSLSocketImpl(sslParameters,
                                                         enabledProtocols.clone(),
                                                         enabledCipherSuites.clone(),
                                                         enabledCompressionMethods.clone());
        implAccept(socket);
        varB4EAC82CA7396A68D541C85D26508E83_6234639 = socket;
        varB4EAC82CA7396A68D541C85D26508E83_6234639.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_6234639;
        // ---------- Original Method ----------
        //if (!sslParameters.getUseClientMode()) {
            //checkEnabledCipherSuites();
        //}
        //OpenSSLSocketImpl socket = new OpenSSLSocketImpl(sslParameters,
                                                         //enabledProtocols.clone(),
                                                         //enabledCipherSuites.clone(),
                                                         //enabledCompressionMethods.clone());
        //implAccept(socket);
        //return socket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.384 -0400", hash_original_method = "8DBC4EF4AD92DA8E96BA5DD8978DFCC3", hash_generated_method = "CEE95B00C9E31D06C6D1F80757840429")
    private void checkEnabledCipherSuites() throws SSLException {
        {
            String enabledCipherSuite = enabledCipherSuites[0];
            {
                {
                    boolean varB3BC14F9C93AFA3D477E982A8F3E6060_1377050802 = (enabledCipherSuite.equals(NativeCrypto.TLS_EMPTY_RENEGOTIATION_INFO_SCSV));
                } //End collapsed parenthetic
                String keyType;
                keyType = CipherSuite.getByName(enabledCipherSuite).getServerKeyType();
                {
                    boolean varE884AADF8E0EB3E5E66550573C10CEC6_1720228299 = (keyType.equals(CipherSuite.KEY_TYPE_RSA)
                    || keyType.equals(CipherSuite.KEY_TYPE_DH_RSA));
                    {
                        {
                            boolean var82EF97457778FA5ED834DAA75162789A_329097031 = (checkForPrivateKey(keyType, RSAPrivateKey.class));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varF6B16B5105D8DDB3BA7A652D88262BCA_874499304 = (keyType.equals(CipherSuite.KEY_TYPE_DSA)
                    || keyType.equals(CipherSuite.KEY_TYPE_DH_DSA));
                    {
                        {
                            boolean var15FCD53AF88B2203B7976A86D1CA529F_2130139693 = (checkForPrivateKey(keyType, DSAPrivateKey.class));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var2C4971471B7B6171C9F02A5B0F362377_2089223576 = (keyType.equals(CipherSuite.KEY_TYPE_EC)
                    || keyType.equals(CipherSuite.KEY_TYPE_EC_RSA)
                    || keyType.equals(CipherSuite.KEY_TYPE_EC_EC));
                    {
                        {
                            boolean var77194DD73047D5D66C88B03941DED2B5_620105121 = (checkForPrivateKey(keyType, ECPrivateKey.class));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Unknown key type " + keyType);
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new SSLException("Could not find any key store entries "
                               + "to support the enabled cipher suites.");
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.398 -0400", hash_original_method = "23192C3ABD6FAD935D4B733BEA5E6735", hash_generated_method = "3147F2B395F7033411954B6F45F04DE7")
    private boolean checkForPrivateKey(String keyType, Class keyClass) {
        String alias;
        alias = sslParameters.getKeyManager().chooseServerAlias(keyType, null, null);
        PrivateKey key;
        key = sslParameters.getKeyManager().getPrivateKey(alias);
        boolean var3AF56F496F4E4185604FBFFB3470A57E_819953500 = ((key != null && keyClass.isAssignableFrom(key.getClass())));
        addTaint(keyType.getTaint());
        addTaint(keyClass.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_704543732 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_704543732;
        // ---------- Original Method ----------
        //String alias = sslParameters.getKeyManager().chooseServerAlias(keyType, null, null);
        //if (alias == null) {
            //return false;
        //}
        //PrivateKey key = sslParameters.getKeyManager().getPrivateKey(alias);
        //return (key != null && keyClass.isAssignableFrom(key.getClass()));
    }

    
}

