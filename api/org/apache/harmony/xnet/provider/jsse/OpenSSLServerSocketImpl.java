package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.PrivateKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.RSAPrivateKey;
import javax.net.ssl.SSLException;

public class OpenSSLServerSocketImpl extends javax.net.ssl.SSLServerSocket {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.580 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "D3BEC3280BC0116C55BDEA33933A255E")

    private SSLParametersImpl sslParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.580 -0400", hash_original_field = "58A40B900DAEA3C6B7D5DD4A12BD7A24", hash_generated_field = "FBCBD52754741D7438A5F0626E230C0A")

    private String[] enabledProtocols = NativeCrypto.getSupportedProtocols();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.580 -0400", hash_original_field = "EE48808D4C8FD73BEECC54F5760958ED", hash_generated_field = "0F74E643B9EF4BBD2405C9C1F6E6B316")

    private String[] enabledCipherSuites = NativeCrypto.getDefaultCipherSuites();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.580 -0400", hash_original_field = "619581E16C646CFFEDCD04037998AB99", hash_generated_field = "801901FD9A6E6592B7BE17AD2DCDCDAF")

    private String[] enabledCompressionMethods = NativeCrypto.getDefaultCompressionMethods();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.580 -0400", hash_original_method = "E4A94FB7C9239842E6393D001A5B9FB9", hash_generated_method = "431E5CD9106B1EC78566243984CF3B1A")
    protected  OpenSSLServerSocketImpl(SSLParametersImpl sslParameters) throws IOException {
        this.sslParameters = sslParameters;
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.581 -0400", hash_original_method = "312A77FCAC868BCFB6F2606DB60F4B03", hash_generated_method = "52F01F7D8E6A3C45AE4A12A700961A1E")
    protected  OpenSSLServerSocketImpl(int port, SSLParametersImpl sslParameters) throws IOException {
        super(port);
        addTaint(port);
        this.sslParameters = sslParameters;
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.581 -0400", hash_original_method = "630526CC73F2D17479EBF6EBA8A0B0BE", hash_generated_method = "9D5BB4C17DFA4D1955C42800A74E3E2C")
    protected  OpenSSLServerSocketImpl(int port, int backlog, SSLParametersImpl sslParameters) throws IOException {
        super(port, backlog);
        addTaint(backlog);
        addTaint(port);
        this.sslParameters = sslParameters;
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.581 -0400", hash_original_method = "2424C79CDC16004A7D4C41CEACBD5654", hash_generated_method = "570A35236CCDF8A161293C81982AF20B")
    protected  OpenSSLServerSocketImpl(int port,
                                      int backlog,
                                      InetAddress iAddress,
                                      SSLParametersImpl sslParameters) throws IOException {
        super(port, backlog, iAddress);
        addTaint(iAddress.getTaint());
        addTaint(backlog);
        addTaint(port);
        this.sslParameters = sslParameters;
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.582 -0400", hash_original_method = "67C983FA387520F5F3AF315C719B29E4", hash_generated_method = "2F19B5DEABF37717FB2A0B50F814233F")
    @Override
    public boolean getEnableSessionCreation() {
        boolean var6A496EF2CB1B11366741370C45064742_14288703 = (sslParameters.getEnableSessionCreation());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_618563916 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_618563916;
        // ---------- Original Method ----------
        //return sslParameters.getEnableSessionCreation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.582 -0400", hash_original_method = "CCC6382646A49B02E626A26467D69493", hash_generated_method = "85CCF52EB3F74FECC3630ABAAC720430")
    @Override
    public void setEnableSessionCreation(boolean flag) {
        addTaint(flag);
        sslParameters.setEnableSessionCreation(flag);
        // ---------- Original Method ----------
        //sslParameters.setEnableSessionCreation(flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.582 -0400", hash_original_method = "B10F1AAC80A139AD997D0D8B0338DD89", hash_generated_method = "6FAB1B4CE5993A4E1A76B204E2EDCE3A")
    @Override
    public String[] getSupportedProtocols() {
String[] varA2CB83838D3C3E6CB428AFD2FA549124_1868264597 =         NativeCrypto.getSupportedProtocols();
        varA2CB83838D3C3E6CB428AFD2FA549124_1868264597.addTaint(taint);
        return varA2CB83838D3C3E6CB428AFD2FA549124_1868264597;
        // ---------- Original Method ----------
        //return NativeCrypto.getSupportedProtocols();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.582 -0400", hash_original_method = "26510D7872AB5791B4C2075CD3368FCD", hash_generated_method = "A7F1CE004D2B62D2EE114CF0275DBCB9")
    @Override
    public String[] getEnabledProtocols() {
String[] var7F784EE3631AE57BC482259F3F556633_1396603336 =         enabledProtocols.clone();
        var7F784EE3631AE57BC482259F3F556633_1396603336.addTaint(taint);
        return var7F784EE3631AE57BC482259F3F556633_1396603336;
        // ---------- Original Method ----------
        //return enabledProtocols.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.583 -0400", hash_original_method = "4F25266A0ABB18E1CEC5E2893BCF6C12", hash_generated_method = "3A7DB44E7B143D29605895C639B518A6")
    @Override
    public void setEnabledProtocols(String[] protocols) {
        enabledProtocols = NativeCrypto.checkEnabledProtocols(protocols);
        // ---------- Original Method ----------
        //enabledProtocols = NativeCrypto.checkEnabledProtocols(protocols);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.583 -0400", hash_original_method = "1B8AAFC0DA0BD632205C9BB94F36BE40", hash_generated_method = "78A79046F5B5C3A0C98471C2404F24E5")
    @Override
    public String[] getSupportedCipherSuites() {
String[] var0633111015CD199BA68A1C170162F6EA_664524882 =         NativeCrypto.getSupportedCipherSuites();
        var0633111015CD199BA68A1C170162F6EA_664524882.addTaint(taint);
        return var0633111015CD199BA68A1C170162F6EA_664524882;
        // ---------- Original Method ----------
        //return NativeCrypto.getSupportedCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.583 -0400", hash_original_method = "5CCACD4A046B80B9464615B5EFBE522F", hash_generated_method = "A8C5CB77BF3A8D2936144E1DC535D2B6")
    @Override
    public String[] getEnabledCipherSuites() {
String[] var45BDDDD9D941A372292490884D2E3BF9_1604069154 =         enabledCipherSuites.clone();
        var45BDDDD9D941A372292490884D2E3BF9_1604069154.addTaint(taint);
        return var45BDDDD9D941A372292490884D2E3BF9_1604069154;
        // ---------- Original Method ----------
        //return enabledCipherSuites.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.583 -0400", hash_original_method = "A8F29A0117C2056BB4F12EE1D48F5595", hash_generated_method = "3FB2F096A8758F371B7BAF38AC6E6A62")
    @Override
    public void setEnabledCipherSuites(String[] suites) {
        enabledCipherSuites = NativeCrypto.checkEnabledCipherSuites(suites);
        // ---------- Original Method ----------
        //enabledCipherSuites = NativeCrypto.checkEnabledCipherSuites(suites);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.584 -0400", hash_original_method = "375DD2648264EE3CAE4788D31A756EC5", hash_generated_method = "B5E5F9617E49C00C5EF793A66F9E910A")
    public String[] getSupportedCompressionMethods() {
String[] varBE8CCF8BFA8321AAC102544B2EEE72A0_572700467 =         NativeCrypto.getSupportedCompressionMethods();
        varBE8CCF8BFA8321AAC102544B2EEE72A0_572700467.addTaint(taint);
        return varBE8CCF8BFA8321AAC102544B2EEE72A0_572700467;
        // ---------- Original Method ----------
        //return NativeCrypto.getSupportedCompressionMethods();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.584 -0400", hash_original_method = "1BCE54E87A889265E8FA0E0B8689F62E", hash_generated_method = "5EB7AAD8B3E38A75D30FA4FE7289AC3E")
    public String[] getEnabledCompressionMethods() {
String[] varB18894ACCABD95AE01B6F73BD5F6D994_988509863 =         enabledCompressionMethods.clone();
        varB18894ACCABD95AE01B6F73BD5F6D994_988509863.addTaint(taint);
        return varB18894ACCABD95AE01B6F73BD5F6D994_988509863;
        // ---------- Original Method ----------
        //return enabledCompressionMethods.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.584 -0400", hash_original_method = "8EA4CA69B5E5586515E70C8BB15F1DC8", hash_generated_method = "F6E8AD11719A044F802E33A113589650")
    public void setEnabledCompressionMethods(String[] methods) {
        enabledCompressionMethods = NativeCrypto.checkEnabledCompressionMethods(methods);
        // ---------- Original Method ----------
        //enabledCompressionMethods = NativeCrypto.checkEnabledCompressionMethods(methods);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.584 -0400", hash_original_method = "BFCFACF4683D2DA63944456ACA1AFE4C", hash_generated_method = "7B726E62410AD343F1EAEE02ED4EDEB2")
    @Override
    public boolean getWantClientAuth() {
        boolean var49776A2797A76D9AE0E32B9F61634A24_290578177 = (sslParameters.getWantClientAuth());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1685692110 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1685692110;
        // ---------- Original Method ----------
        //return sslParameters.getWantClientAuth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.584 -0400", hash_original_method = "C4BE9213AE4AE3AE8B3FD470CA7DBEA1", hash_generated_method = "09030FB81E24A5D701A15381DB305A48")
    @Override
    public void setWantClientAuth(boolean want) {
        addTaint(want);
        sslParameters.setWantClientAuth(want);
        // ---------- Original Method ----------
        //sslParameters.setWantClientAuth(want);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.585 -0400", hash_original_method = "01CDFCACAD6C113BE18D967A4C320F8F", hash_generated_method = "D13B71EDF8691602F2F3807CAB56D641")
    @Override
    public boolean getNeedClientAuth() {
        boolean var8775D3F02F22101BF43E8B27516BBE95_377036951 = (sslParameters.getNeedClientAuth());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_325933216 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_325933216;
        // ---------- Original Method ----------
        //return sslParameters.getNeedClientAuth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.585 -0400", hash_original_method = "87B99BB5E16802D75B8230FD21E2413F", hash_generated_method = "BA7C72106D7ACD8A3990718038741929")
    @Override
    public void setNeedClientAuth(boolean need) {
        addTaint(need);
        sslParameters.setNeedClientAuth(need);
        // ---------- Original Method ----------
        //sslParameters.setNeedClientAuth(need);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.585 -0400", hash_original_method = "433F9F6F1671E88E2914017CCCE9CE51", hash_generated_method = "C946F9CB0470135AAAA0DD5A6F76D022")
    @Override
    public void setUseClientMode(boolean mode) {
        addTaint(mode);
        sslParameters.setUseClientMode(mode);
        // ---------- Original Method ----------
        //sslParameters.setUseClientMode(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.585 -0400", hash_original_method = "01F03276D647357C499C358366605A7A", hash_generated_method = "D7EC1D68ACE05A02F965B5316857A179")
    @Override
    public boolean getUseClientMode() {
        boolean var264C485BBAEC609C8CEC6E380F554AB0_859784725 = (sslParameters.getUseClientMode());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1978990745 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1978990745;
        // ---------- Original Method ----------
        //return sslParameters.getUseClientMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.585 -0400", hash_original_method = "99974EADFE56BC36D8DB1EC28EC422DC", hash_generated_method = "BC543B1B7FA4A2C234E2A769D3EF4B96")
    @Override
    public Socket accept() throws IOException {
    if(!sslParameters.getUseClientMode())        
        {
            checkEnabledCipherSuites();
        } //End block
        OpenSSLSocketImpl socket = new OpenSSLSocketImpl(sslParameters,
                                                         enabledProtocols.clone(),
                                                         enabledCipherSuites.clone(),
                                                         enabledCompressionMethods.clone());
        implAccept(socket);
Socket varA63412D4E099639C1BBCBDC8D705186B_1355331973 =         socket;
        varA63412D4E099639C1BBCBDC8D705186B_1355331973.addTaint(taint);
        return varA63412D4E099639C1BBCBDC8D705186B_1355331973;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.586 -0400", hash_original_method = "8DBC4EF4AD92DA8E96BA5DD8978DFCC3", hash_generated_method = "F8E499297540646DD114D6FB1EB6528A")
    private void checkEnabledCipherSuites() throws SSLException {
for(String enabledCipherSuite : enabledCipherSuites)
        {
    if(enabledCipherSuite.equals(NativeCrypto.TLS_EMPTY_RENEGOTIATION_INFO_SCSV))            
            {
                continue;
            } //End block
            String keyType = CipherSuite.getByName(enabledCipherSuite).getServerKeyType();
    if(keyType == null)            
            {
                return;
            } //End block
    if(keyType.equals(CipherSuite.KEY_TYPE_RSA)
                    || keyType.equals(CipherSuite.KEY_TYPE_DH_RSA))            
            {
    if(checkForPrivateKey(keyType, RSAPrivateKey.class))                
                {
                    return;
                } //End block
                continue;
            } //End block
    if(keyType.equals(CipherSuite.KEY_TYPE_DSA)
                    || keyType.equals(CipherSuite.KEY_TYPE_DH_DSA))            
            {
    if(checkForPrivateKey(keyType, DSAPrivateKey.class))                
                {
                    return;
                } //End block
                continue;
            } //End block
    if(keyType.equals(CipherSuite.KEY_TYPE_EC)
                    || keyType.equals(CipherSuite.KEY_TYPE_EC_RSA)
                    || keyType.equals(CipherSuite.KEY_TYPE_EC_EC))            
            {
    if(checkForPrivateKey(keyType, ECPrivateKey.class))                
                {
                    return;
                } //End block
                continue;
            } //End block
            IllegalStateException var0B9CC4384477B0BE55A8EDD602F30530_167303387 = new IllegalStateException("Unknown key type " + keyType);
            var0B9CC4384477B0BE55A8EDD602F30530_167303387.addTaint(taint);
            throw var0B9CC4384477B0BE55A8EDD602F30530_167303387;
        } //End block
        SSLException varEE3EF93FCDE76103BB8CE4480E0A9788_1934721707 = new SSLException("Could not find any key store entries "
                               + "to support the enabled cipher suites.");
        varEE3EF93FCDE76103BB8CE4480E0A9788_1934721707.addTaint(taint);
        throw varEE3EF93FCDE76103BB8CE4480E0A9788_1934721707;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.586 -0400", hash_original_method = "23192C3ABD6FAD935D4B733BEA5E6735", hash_generated_method = "D2D302A0329E0AD284753E04242E160E")
    private boolean checkForPrivateKey(String keyType, Class keyClass) {
        addTaint(keyClass.getTaint());
        addTaint(keyType.getTaint());
        String alias = sslParameters.getKeyManager().chooseServerAlias(keyType, null, null);
    if(alias == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_2020500454 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_520668037 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_520668037;
        } //End block
        PrivateKey key = sslParameters.getKeyManager().getPrivateKey(alias);
        boolean varF9249D6157316753CA621B7E1C257C01_154133593 = ((key != null && keyClass.isAssignableFrom(key.getClass())));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_920448921 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_920448921;
        // ---------- Original Method ----------
        //String alias = sslParameters.getKeyManager().chooseServerAlias(keyType, null, null);
        //if (alias == null) {
            //return false;
        //}
        //PrivateKey key = sslParameters.getKeyManager().getPrivateKey(alias);
        //return (key != null && keyClass.isAssignableFrom(key.getClass()));
    }

    
}

