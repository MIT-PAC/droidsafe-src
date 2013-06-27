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
import javax.net.ssl.SSLServerSocket;

public class SSLServerSocketImpl extends SSLServerSocket {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.809 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "D3BEC3280BC0116C55BDEA33933A255E")

    private SSLParametersImpl sslParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.809 -0400", hash_original_field = "893A6B544A0709B811A0135F54D39993", hash_generated_field = "9B2AF06FBD36AF1B19FC02AD8414FDA5")

    private Logger.Stream logger = Logger.getStream("ssocket");
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.809 -0400", hash_original_method = "3C51E4D29638B27E77C8772382B20970", hash_generated_method = "AB423B53F5AF7A4672F9839BA4880FF7")
    protected  SSLServerSocketImpl(SSLParametersImpl sslParameters) throws IOException {
        this.sslParameters = sslParameters;
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.809 -0400", hash_original_method = "964D36D73A9D78EC878BB4C8C1192330", hash_generated_method = "106F722BF875C4EC317C15C0A52E5FAA")
    protected  SSLServerSocketImpl(int port, SSLParametersImpl sslParameters) throws IOException {
        super(port);
        this.sslParameters = sslParameters;
        addTaint(port);
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.810 -0400", hash_original_method = "99AA71D25BC131720F5627E787888583", hash_generated_method = "587480779228BF09C050E73940E07283")
    protected  SSLServerSocketImpl(int port, int backlog,
            SSLParametersImpl sslParameters) throws IOException {
        super(port, backlog);
        this.sslParameters = sslParameters;
        addTaint(port);
        addTaint(backlog);
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.810 -0400", hash_original_method = "02A799087F98193615A0535EAB6C7699", hash_generated_method = "80D36CDB32B458B5CB3831BBB5627D04")
    protected  SSLServerSocketImpl(int port, int backlog,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.819 -0400", hash_original_method = "12BE90119F3183109C9DE5DBB63B352A", hash_generated_method = "717AAA11174299EE23EF2DDDDAA309B8")
    @Override
    public String[] getSupportedCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_489092546 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_489092546 = CipherSuite.getSupportedCipherSuiteNames();
        varB4EAC82CA7396A68D541C85D26508E83_489092546.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_489092546;
        // ---------- Original Method ----------
        //return CipherSuite.getSupportedCipherSuiteNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.820 -0400", hash_original_method = "80B545F2398A25060AECB1A23E821DD5", hash_generated_method = "AEA8C2F7359D82116B652B614BDA6BD4")
    @Override
    public String[] getEnabledCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1081791524 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1081791524 = sslParameters.getEnabledCipherSuites();
        varB4EAC82CA7396A68D541C85D26508E83_1081791524.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1081791524;
        // ---------- Original Method ----------
        //return sslParameters.getEnabledCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.821 -0400", hash_original_method = "7C4ABDE66C2DD67AB299013913F9BF06", hash_generated_method = "7F545A6EF3038CFCC5D5B349DF2D820E")
    @Override
    public void setEnabledCipherSuites(String[] suites) {
        sslParameters.setEnabledCipherSuites(suites);
        addTaint(suites[0].getTaint());
        // ---------- Original Method ----------
        //sslParameters.setEnabledCipherSuites(suites);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.821 -0400", hash_original_method = "9A36300B3497119D0180A59D3E72D371", hash_generated_method = "02C84C27185DD099A50A1143F1C35D8A")
    @Override
    public String[] getSupportedProtocols() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1993544210 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1993544210 = ProtocolVersion.supportedProtocols.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1993544210.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1993544210;
        // ---------- Original Method ----------
        //return ProtocolVersion.supportedProtocols.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.827 -0400", hash_original_method = "9376751549A6436575C0783CA6C3A4A0", hash_generated_method = "EA826FC18316CC5433ECA12CB589DC73")
    @Override
    public String[] getEnabledProtocols() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1637004942 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1637004942 = sslParameters.getEnabledProtocols();
        varB4EAC82CA7396A68D541C85D26508E83_1637004942.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1637004942;
        // ---------- Original Method ----------
        //return sslParameters.getEnabledProtocols();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.827 -0400", hash_original_method = "1CAC4BB68A222585D834DF0E7DBBD0B9", hash_generated_method = "24B3390D4A5DB4328E68855FDA4E4FA9")
    @Override
    public void setEnabledProtocols(String[] protocols) {
        sslParameters.setEnabledProtocols(protocols);
        addTaint(protocols[0].getTaint());
        // ---------- Original Method ----------
        //sslParameters.setEnabledProtocols(protocols);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.827 -0400", hash_original_method = "433F9F6F1671E88E2914017CCCE9CE51", hash_generated_method = "B53D1E1AA2CE361BFDB5ACAD024F9619")
    @Override
    public void setUseClientMode(boolean mode) {
        sslParameters.setUseClientMode(mode);
        addTaint(mode);
        // ---------- Original Method ----------
        //sslParameters.setUseClientMode(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.828 -0400", hash_original_method = "01F03276D647357C499C358366605A7A", hash_generated_method = "40949FF5C129A4F5FDCC5067D5035557")
    @Override
    public boolean getUseClientMode() {
        boolean var5D6C317C7C34AA34FED4DDA3BFA46DAC_1094406007 = (sslParameters.getUseClientMode());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1736470446 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1736470446;
        // ---------- Original Method ----------
        //return sslParameters.getUseClientMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.834 -0400", hash_original_method = "87B99BB5E16802D75B8230FD21E2413F", hash_generated_method = "0546B005C61E39ED72A709422B43B69F")
    @Override
    public void setNeedClientAuth(boolean need) {
        sslParameters.setNeedClientAuth(need);
        addTaint(need);
        // ---------- Original Method ----------
        //sslParameters.setNeedClientAuth(need);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.834 -0400", hash_original_method = "01CDFCACAD6C113BE18D967A4C320F8F", hash_generated_method = "3AF491B779DE530F4FDA3976FC84F1CF")
    @Override
    public boolean getNeedClientAuth() {
        boolean var666666A183221FEF9E4AC429A4F2FC13_2102951159 = (sslParameters.getNeedClientAuth());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_204920811 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_204920811;
        // ---------- Original Method ----------
        //return sslParameters.getNeedClientAuth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.834 -0400", hash_original_method = "C4BE9213AE4AE3AE8B3FD470CA7DBEA1", hash_generated_method = "36D0D50995337D2D75DCB0482721034F")
    @Override
    public void setWantClientAuth(boolean want) {
        sslParameters.setWantClientAuth(want);
        addTaint(want);
        // ---------- Original Method ----------
        //sslParameters.setWantClientAuth(want);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.834 -0400", hash_original_method = "BFCFACF4683D2DA63944456ACA1AFE4C", hash_generated_method = "DD328880D97D4B2ED101BE787E576498")
    @Override
    public boolean getWantClientAuth() {
        boolean var1F88322EA2F28C29D3EC82222D21AA46_1220596766 = (sslParameters.getWantClientAuth());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1182121723 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1182121723;
        // ---------- Original Method ----------
        //return sslParameters.getWantClientAuth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.839 -0400", hash_original_method = "CCC6382646A49B02E626A26467D69493", hash_generated_method = "781712039B284C5CB7B48D72B261E886")
    @Override
    public void setEnableSessionCreation(boolean flag) {
        sslParameters.setEnableSessionCreation(flag);
        addTaint(flag);
        // ---------- Original Method ----------
        //sslParameters.setEnableSessionCreation(flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.840 -0400", hash_original_method = "67C983FA387520F5F3AF315C719B29E4", hash_generated_method = "D45E511F0544732DF7055DD9AF075297")
    @Override
    public boolean getEnableSessionCreation() {
        boolean varAFF7A8ADF82548D8DE353C67D9576F3E_111954189 = (sslParameters.getEnableSessionCreation());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1923361578 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1923361578;
        // ---------- Original Method ----------
        //return sslParameters.getEnableSessionCreation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.845 -0400", hash_original_method = "E95178BAD1AB83F5F7B2A543005EDE81", hash_generated_method = "5D6B2458F6C46D6157FEB7B3C2644F68")
    @Override
    public Socket accept() throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1280865417 = null; //Variable for return #1
        {
            logger.println("SSLServerSocketImpl.accept ..");
        } //End block
        SSLSocketImpl s;
        s = new SSLSocketImpl(
                (SSLParametersImpl) sslParameters.clone());
        implAccept(s);
        s.init();
        {
            logger.println("SSLServerSocketImpl: accepted, initialized");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1280865417 = s;
        varB4EAC82CA7396A68D541C85D26508E83_1280865417.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1280865417;
        // ---------- Original Method ----------
        //if (logger != null) {
            //logger.println("SSLServerSocketImpl.accept ..");
        //}
        //SSLSocketImpl s = new SSLSocketImpl(
                //(SSLParametersImpl) sslParameters.clone());
        //implAccept(s);
        //s.init();
        //if (logger != null) {
            //logger.println("SSLServerSocketImpl: accepted, initialized");
        //}
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.846 -0400", hash_original_method = "2BD2C11E492A0926A3928FBE6062AA1A", hash_generated_method = "D642A9F9E687D282474CAA6A0EE8A8EC")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_559302038 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_559302038 = "[SSLServerSocketImpl]";
        varB4EAC82CA7396A68D541C85D26508E83_559302038.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_559302038;
        // ---------- Original Method ----------
        //return "[SSLServerSocketImpl]";
    }

    
}

