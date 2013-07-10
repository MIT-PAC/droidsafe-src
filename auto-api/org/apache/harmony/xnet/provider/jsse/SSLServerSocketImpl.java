package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;

public class SSLServerSocketImpl extends SSLServerSocket {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.913 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "D3BEC3280BC0116C55BDEA33933A255E")

    private SSLParametersImpl sslParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.913 -0400", hash_original_field = "893A6B544A0709B811A0135F54D39993", hash_generated_field = "9B2AF06FBD36AF1B19FC02AD8414FDA5")

    private Logger.Stream logger = Logger.getStream("ssocket");
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.914 -0400", hash_original_method = "3C51E4D29638B27E77C8772382B20970", hash_generated_method = "AB423B53F5AF7A4672F9839BA4880FF7")
    protected  SSLServerSocketImpl(SSLParametersImpl sslParameters) throws IOException {
        this.sslParameters = sslParameters;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.914 -0400", hash_original_method = "964D36D73A9D78EC878BB4C8C1192330", hash_generated_method = "106F722BF875C4EC317C15C0A52E5FAA")
    protected  SSLServerSocketImpl(int port, SSLParametersImpl sslParameters) throws IOException {
        super(port);
        this.sslParameters = sslParameters;
        addTaint(port);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.915 -0400", hash_original_method = "99AA71D25BC131720F5627E787888583", hash_generated_method = "587480779228BF09C050E73940E07283")
    protected  SSLServerSocketImpl(int port, int backlog,
            SSLParametersImpl sslParameters) throws IOException {
        super(port, backlog);
        this.sslParameters = sslParameters;
        addTaint(port);
        addTaint(backlog);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.915 -0400", hash_original_method = "02A799087F98193615A0535EAB6C7699", hash_generated_method = "80D36CDB32B458B5CB3831BBB5627D04")
    protected  SSLServerSocketImpl(int port, int backlog,
                                InetAddress iAddress,
                                SSLParametersImpl sslParameters) throws IOException {
        super(port, backlog, iAddress);
        this.sslParameters = sslParameters;
        addTaint(port);
        addTaint(backlog);
        addTaint(iAddress.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.916 -0400", hash_original_method = "12BE90119F3183109C9DE5DBB63B352A", hash_generated_method = "56C0A71BCF2FE45D18011F2B734ECEE0")
    @Override
    public String[] getSupportedCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1076374774 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1076374774 = CipherSuite.getSupportedCipherSuiteNames();
        varB4EAC82CA7396A68D541C85D26508E83_1076374774.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1076374774;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.916 -0400", hash_original_method = "80B545F2398A25060AECB1A23E821DD5", hash_generated_method = "CEC306CCBC0D0654340D7BC308B71632")
    @Override
    public String[] getEnabledCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_335777483 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_335777483 = sslParameters.getEnabledCipherSuites();
        varB4EAC82CA7396A68D541C85D26508E83_335777483.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_335777483;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.916 -0400", hash_original_method = "7C4ABDE66C2DD67AB299013913F9BF06", hash_generated_method = "7F545A6EF3038CFCC5D5B349DF2D820E")
    @Override
    public void setEnabledCipherSuites(String[] suites) {
        sslParameters.setEnabledCipherSuites(suites);
        addTaint(suites[0].getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.917 -0400", hash_original_method = "9A36300B3497119D0180A59D3E72D371", hash_generated_method = "1A72EFB8C4DEC85501C38371095E14B1")
    @Override
    public String[] getSupportedProtocols() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_2055015334 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2055015334 = ProtocolVersion.supportedProtocols.clone();
        varB4EAC82CA7396A68D541C85D26508E83_2055015334.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2055015334;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.917 -0400", hash_original_method = "9376751549A6436575C0783CA6C3A4A0", hash_generated_method = "CA659534FE43F5B3FFA25B049FFF9DB6")
    @Override
    public String[] getEnabledProtocols() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_818407447 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_818407447 = sslParameters.getEnabledProtocols();
        varB4EAC82CA7396A68D541C85D26508E83_818407447.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_818407447;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.918 -0400", hash_original_method = "1CAC4BB68A222585D834DF0E7DBBD0B9", hash_generated_method = "24B3390D4A5DB4328E68855FDA4E4FA9")
    @Override
    public void setEnabledProtocols(String[] protocols) {
        sslParameters.setEnabledProtocols(protocols);
        addTaint(protocols[0].getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.918 -0400", hash_original_method = "433F9F6F1671E88E2914017CCCE9CE51", hash_generated_method = "B53D1E1AA2CE361BFDB5ACAD024F9619")
    @Override
    public void setUseClientMode(boolean mode) {
        sslParameters.setUseClientMode(mode);
        addTaint(mode);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.918 -0400", hash_original_method = "01F03276D647357C499C358366605A7A", hash_generated_method = "E3FAD112FB8A47BC9F451F55DED0337C")
    @Override
    public boolean getUseClientMode() {
        boolean var5D6C317C7C34AA34FED4DDA3BFA46DAC_656040037 = (sslParameters.getUseClientMode());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1902693121 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1902693121;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.918 -0400", hash_original_method = "87B99BB5E16802D75B8230FD21E2413F", hash_generated_method = "0546B005C61E39ED72A709422B43B69F")
    @Override
    public void setNeedClientAuth(boolean need) {
        sslParameters.setNeedClientAuth(need);
        addTaint(need);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.919 -0400", hash_original_method = "01CDFCACAD6C113BE18D967A4C320F8F", hash_generated_method = "2AD9598A423C55613222EEE423F8556C")
    @Override
    public boolean getNeedClientAuth() {
        boolean var666666A183221FEF9E4AC429A4F2FC13_846319239 = (sslParameters.getNeedClientAuth());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_45305140 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_45305140;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.919 -0400", hash_original_method = "C4BE9213AE4AE3AE8B3FD470CA7DBEA1", hash_generated_method = "36D0D50995337D2D75DCB0482721034F")
    @Override
    public void setWantClientAuth(boolean want) {
        sslParameters.setWantClientAuth(want);
        addTaint(want);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.919 -0400", hash_original_method = "BFCFACF4683D2DA63944456ACA1AFE4C", hash_generated_method = "734FB649F0DE6F0406B1AF0609DFE4E9")
    @Override
    public boolean getWantClientAuth() {
        boolean var1F88322EA2F28C29D3EC82222D21AA46_335471023 = (sslParameters.getWantClientAuth());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1591824317 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1591824317;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.919 -0400", hash_original_method = "CCC6382646A49B02E626A26467D69493", hash_generated_method = "781712039B284C5CB7B48D72B261E886")
    @Override
    public void setEnableSessionCreation(boolean flag) {
        sslParameters.setEnableSessionCreation(flag);
        addTaint(flag);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.920 -0400", hash_original_method = "67C983FA387520F5F3AF315C719B29E4", hash_generated_method = "C02CB783AD46328E569D1B379E45CEF7")
    @Override
    public boolean getEnableSessionCreation() {
        boolean varAFF7A8ADF82548D8DE353C67D9576F3E_2071122771 = (sslParameters.getEnableSessionCreation());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1481121907 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1481121907;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.920 -0400", hash_original_method = "E95178BAD1AB83F5F7B2A543005EDE81", hash_generated_method = "4E9941DA668E6D3FE4628B24CC47E07C")
    @Override
    public Socket accept() throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_106878257 = null; 
        {
            logger.println("SSLServerSocketImpl.accept ..");
        } 
        SSLSocketImpl s = new SSLSocketImpl(
                (SSLParametersImpl) sslParameters.clone());
        implAccept(s);
        s.init();
        {
            logger.println("SSLServerSocketImpl: accepted, initialized");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_106878257 = s;
        varB4EAC82CA7396A68D541C85D26508E83_106878257.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_106878257;
        
        
            
        
        
                
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.921 -0400", hash_original_method = "2BD2C11E492A0926A3928FBE6062AA1A", hash_generated_method = "DB521F2EC0819DED76B423D5797B338F")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_674496323 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_674496323 = "[SSLServerSocketImpl]";
        varB4EAC82CA7396A68D541C85D26508E83_674496323.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_674496323;
        
        
    }

    
}

