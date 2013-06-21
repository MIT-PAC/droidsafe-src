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
    private SSLParametersImpl sslParameters;
    private String[] enabledProtocols = NativeCrypto.getSupportedProtocols();
    private String[] enabledCipherSuites = NativeCrypto.getDefaultCipherSuites();
    private String[] enabledCompressionMethods = NativeCrypto.getDefaultCompressionMethods();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.848 -0400", hash_original_method = "E4A94FB7C9239842E6393D001A5B9FB9", hash_generated_method = "3521C75047F703D90074BABE7E0325D4")
    @DSModeled(DSC.SAFE)
    protected OpenSSLServerSocketImpl(SSLParametersImpl sslParameters) throws IOException {
        dsTaint.addTaint(sslParameters.dsTaint);
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.848 -0400", hash_original_method = "312A77FCAC868BCFB6F2606DB60F4B03", hash_generated_method = "B3C46E969AF1910B9E7865333ED102E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected OpenSSLServerSocketImpl(int port, SSLParametersImpl sslParameters) throws IOException {
        super(port);
        dsTaint.addTaint(port);
        dsTaint.addTaint(sslParameters.dsTaint);
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.848 -0400", hash_original_method = "630526CC73F2D17479EBF6EBA8A0B0BE", hash_generated_method = "E8E023FA524DF9834F5616042F6330B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected OpenSSLServerSocketImpl(int port, int backlog, SSLParametersImpl sslParameters) throws IOException {
        super(port, backlog);
        dsTaint.addTaint(port);
        dsTaint.addTaint(backlog);
        dsTaint.addTaint(sslParameters.dsTaint);
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.849 -0400", hash_original_method = "2424C79CDC16004A7D4C41CEACBD5654", hash_generated_method = "A0408DFFE2239FC4094E01537626B9A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected OpenSSLServerSocketImpl(int port,
                                      int backlog,
                                      InetAddress iAddress,
                                      SSLParametersImpl sslParameters) throws IOException {
        super(port, backlog, iAddress);
        dsTaint.addTaint(port);
        dsTaint.addTaint(iAddress.dsTaint);
        dsTaint.addTaint(backlog);
        dsTaint.addTaint(sslParameters.dsTaint);
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.849 -0400", hash_original_method = "67C983FA387520F5F3AF315C719B29E4", hash_generated_method = "CF0E61323EEEB6798C3AB7419DE6F2C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getEnableSessionCreation() {
        boolean varAFF7A8ADF82548D8DE353C67D9576F3E_302255235 = (sslParameters.getEnableSessionCreation());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sslParameters.getEnableSessionCreation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.850 -0400", hash_original_method = "CCC6382646A49B02E626A26467D69493", hash_generated_method = "1CEC5C88A393CCF6951D2A9AC29A0DA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setEnableSessionCreation(boolean flag) {
        dsTaint.addTaint(flag);
        sslParameters.setEnableSessionCreation(flag);
        // ---------- Original Method ----------
        //sslParameters.setEnableSessionCreation(flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.850 -0400", hash_original_method = "B10F1AAC80A139AD997D0D8B0338DD89", hash_generated_method = "CFCC569057ECFDF253EBB81986E7B46B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getSupportedProtocols() {
        String[] var644D168EA6200BD046A33E3868ED2683_1417009821 = (NativeCrypto.getSupportedProtocols());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return NativeCrypto.getSupportedProtocols();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.850 -0400", hash_original_method = "26510D7872AB5791B4C2075CD3368FCD", hash_generated_method = "DC329643CC16BEF73EDC760C60AD90D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getEnabledProtocols() {
        String[] varAD12450170E712D0CFE20B0157A51EDE_370528557 = (enabledProtocols.clone());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return enabledProtocols.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.851 -0400", hash_original_method = "4F25266A0ABB18E1CEC5E2893BCF6C12", hash_generated_method = "D74BFC69D669C73A46232CE079340F09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setEnabledProtocols(String[] protocols) {
        dsTaint.addTaint(protocols[0]);
        enabledProtocols = NativeCrypto.checkEnabledProtocols(protocols);
        // ---------- Original Method ----------
        //enabledProtocols = NativeCrypto.checkEnabledProtocols(protocols);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.851 -0400", hash_original_method = "1B8AAFC0DA0BD632205C9BB94F36BE40", hash_generated_method = "06600449B6528093073719BDE54B03A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getSupportedCipherSuites() {
        String[] var4A8488CAA4D902DCFD3A82F559450276_1971491131 = (NativeCrypto.getSupportedCipherSuites());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return NativeCrypto.getSupportedCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.851 -0400", hash_original_method = "5CCACD4A046B80B9464615B5EFBE522F", hash_generated_method = "0D79CF57B0B971587394E1F3CD56FA33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getEnabledCipherSuites() {
        String[] var6F42AFA5FD643B83B573586346D8E86A_1146782871 = (enabledCipherSuites.clone());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return enabledCipherSuites.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.851 -0400", hash_original_method = "A8F29A0117C2056BB4F12EE1D48F5595", hash_generated_method = "6EFA05368FEC584295C1E317F7C71F07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setEnabledCipherSuites(String[] suites) {
        dsTaint.addTaint(suites[0]);
        enabledCipherSuites = NativeCrypto.checkEnabledCipherSuites(suites);
        // ---------- Original Method ----------
        //enabledCipherSuites = NativeCrypto.checkEnabledCipherSuites(suites);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.852 -0400", hash_original_method = "375DD2648264EE3CAE4788D31A756EC5", hash_generated_method = "30A6F98AAF6E036D7618F228E9A48BAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getSupportedCompressionMethods() {
        String[] varDD380EB21716E47043AAADCB4639E6B1_230056478 = (NativeCrypto.getSupportedCompressionMethods());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return NativeCrypto.getSupportedCompressionMethods();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.852 -0400", hash_original_method = "1BCE54E87A889265E8FA0E0B8689F62E", hash_generated_method = "A2559DB0EBC606C4B1BD9C2E4A32850D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getEnabledCompressionMethods() {
        String[] varA2C89B41543A38571294C4D8AC488193_366165449 = (enabledCompressionMethods.clone());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return enabledCompressionMethods.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.852 -0400", hash_original_method = "8EA4CA69B5E5586515E70C8BB15F1DC8", hash_generated_method = "895803C555AC7D50E6CE49E3EE4B26F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setEnabledCompressionMethods(String[] methods) {
        dsTaint.addTaint(methods[0]);
        enabledCompressionMethods = NativeCrypto.checkEnabledCompressionMethods(methods);
        // ---------- Original Method ----------
        //enabledCompressionMethods = NativeCrypto.checkEnabledCompressionMethods(methods);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.852 -0400", hash_original_method = "BFCFACF4683D2DA63944456ACA1AFE4C", hash_generated_method = "9527FA720AA37B7B2BBEFC7C4A5DBC31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getWantClientAuth() {
        boolean var1F88322EA2F28C29D3EC82222D21AA46_124822378 = (sslParameters.getWantClientAuth());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sslParameters.getWantClientAuth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.852 -0400", hash_original_method = "C4BE9213AE4AE3AE8B3FD470CA7DBEA1", hash_generated_method = "3CF93375E2EDE097483BB86B9A2A6364")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setWantClientAuth(boolean want) {
        dsTaint.addTaint(want);
        sslParameters.setWantClientAuth(want);
        // ---------- Original Method ----------
        //sslParameters.setWantClientAuth(want);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.853 -0400", hash_original_method = "01CDFCACAD6C113BE18D967A4C320F8F", hash_generated_method = "0D1E3EDDA2E491E4AA0217858CF40D3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getNeedClientAuth() {
        boolean var666666A183221FEF9E4AC429A4F2FC13_2086806653 = (sslParameters.getNeedClientAuth());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sslParameters.getNeedClientAuth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.853 -0400", hash_original_method = "87B99BB5E16802D75B8230FD21E2413F", hash_generated_method = "6CC5B77D04C22EF0B7C8D76FE3C5FE68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setNeedClientAuth(boolean need) {
        dsTaint.addTaint(need);
        sslParameters.setNeedClientAuth(need);
        // ---------- Original Method ----------
        //sslParameters.setNeedClientAuth(need);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.853 -0400", hash_original_method = "433F9F6F1671E88E2914017CCCE9CE51", hash_generated_method = "5F6D288C13B7631A67FD74A23F2165F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setUseClientMode(boolean mode) {
        dsTaint.addTaint(mode);
        sslParameters.setUseClientMode(mode);
        // ---------- Original Method ----------
        //sslParameters.setUseClientMode(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.853 -0400", hash_original_method = "01F03276D647357C499C358366605A7A", hash_generated_method = "A6FEE9CCC5A39A516E336C55C1E432D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getUseClientMode() {
        boolean var5D6C317C7C34AA34FED4DDA3BFA46DAC_737108378 = (sslParameters.getUseClientMode());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sslParameters.getUseClientMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.853 -0400", hash_original_method = "99974EADFE56BC36D8DB1EC28EC422DC", hash_generated_method = "D440C70DE65DE4F5085393EA20AA3DE5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Socket accept() throws IOException {
        {
            boolean varAC7C523728C9F1CC5BE4FE21E1F0D4C1_659739120 = (!sslParameters.getUseClientMode());
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
        return (Socket)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.861 -0400", hash_original_method = "8DBC4EF4AD92DA8E96BA5DD8978DFCC3", hash_generated_method = "32229B0A615D818D2BA7E283F3F186A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkEnabledCipherSuites() throws SSLException {
        {
            String enabledCipherSuite = enabledCipherSuites[0];
            {
                {
                    boolean varB3BC14F9C93AFA3D477E982A8F3E6060_1386391548 = (enabledCipherSuite.equals(NativeCrypto.TLS_EMPTY_RENEGOTIATION_INFO_SCSV));
                } //End collapsed parenthetic
                String keyType;
                keyType = CipherSuite.getByName(enabledCipherSuite).getServerKeyType();
                {
                    boolean varE884AADF8E0EB3E5E66550573C10CEC6_453775033 = (keyType.equals(CipherSuite.KEY_TYPE_RSA)
                    || keyType.equals(CipherSuite.KEY_TYPE_DH_RSA));
                    {
                        {
                            boolean var82EF97457778FA5ED834DAA75162789A_703867522 = (checkForPrivateKey(keyType, RSAPrivateKey.class));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varF6B16B5105D8DDB3BA7A652D88262BCA_2099340610 = (keyType.equals(CipherSuite.KEY_TYPE_DSA)
                    || keyType.equals(CipherSuite.KEY_TYPE_DH_DSA));
                    {
                        {
                            boolean var15FCD53AF88B2203B7976A86D1CA529F_1723785342 = (checkForPrivateKey(keyType, DSAPrivateKey.class));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var2C4971471B7B6171C9F02A5B0F362377_652556091 = (keyType.equals(CipherSuite.KEY_TYPE_EC)
                    || keyType.equals(CipherSuite.KEY_TYPE_EC_RSA)
                    || keyType.equals(CipherSuite.KEY_TYPE_EC_EC));
                    {
                        {
                            boolean var77194DD73047D5D66C88B03941DED2B5_958685377 = (checkForPrivateKey(keyType, ECPrivateKey.class));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.861 -0400", hash_original_method = "23192C3ABD6FAD935D4B733BEA5E6735", hash_generated_method = "65F210AC722127C840B503213D8201EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean checkForPrivateKey(String keyType, Class keyClass) {
        dsTaint.addTaint(keyType);
        dsTaint.addTaint(keyClass.dsTaint);
        String alias;
        alias = sslParameters.getKeyManager().chooseServerAlias(keyType, null, null);
        PrivateKey key;
        key = sslParameters.getKeyManager().getPrivateKey(alias);
        boolean var3AF56F496F4E4185604FBFFB3470A57E_2005994887 = ((key != null && keyClass.isAssignableFrom(key.getClass())));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //String alias = sslParameters.getKeyManager().chooseServerAlias(keyType, null, null);
        //if (alias == null) {
            //return false;
        //}
        //PrivateKey key = sslParameters.getKeyManager().getPrivateKey(alias);
        //return (key != null && keyClass.isAssignableFrom(key.getClass()));
    }

    
}

