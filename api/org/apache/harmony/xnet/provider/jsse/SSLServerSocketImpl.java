package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import javax.net.ssl.SSLServerSocket;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class SSLServerSocketImpl extends SSLServerSocket {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.412 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "D3BEC3280BC0116C55BDEA33933A255E")

    private SSLParametersImpl sslParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.413 -0400", hash_original_field = "893A6B544A0709B811A0135F54D39993", hash_generated_field = "9B2AF06FBD36AF1B19FC02AD8414FDA5")

    private Logger.Stream logger = Logger.getStream("ssocket");
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.413 -0400", hash_original_method = "3C51E4D29638B27E77C8772382B20970", hash_generated_method = "AB423B53F5AF7A4672F9839BA4880FF7")
    protected  SSLServerSocketImpl(SSLParametersImpl sslParameters) throws IOException {
        this.sslParameters = sslParameters;
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.414 -0400", hash_original_method = "964D36D73A9D78EC878BB4C8C1192330", hash_generated_method = "2101F5025F74702B239F5CC2B36D24C1")
    protected  SSLServerSocketImpl(int port, SSLParametersImpl sslParameters) throws IOException {
        super(port);
        addTaint(port);
        this.sslParameters = sslParameters;
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.414 -0400", hash_original_method = "99AA71D25BC131720F5627E787888583", hash_generated_method = "6044E5E99751C64B2B954068FC56796A")
    protected  SSLServerSocketImpl(int port, int backlog,
            SSLParametersImpl sslParameters) throws IOException {
        super(port, backlog);
        addTaint(backlog);
        addTaint(port);
        this.sslParameters = sslParameters;
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.415 -0400", hash_original_method = "02A799087F98193615A0535EAB6C7699", hash_generated_method = "EC589A0057E1C7F02D4AD1F37FB1D949")
    protected  SSLServerSocketImpl(int port, int backlog,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.415 -0400", hash_original_method = "12BE90119F3183109C9DE5DBB63B352A", hash_generated_method = "D3C95C6FB5322D3926297BEF263A8736")
    @Override
    public String[] getSupportedCipherSuites() {
String[] varF6F3ABBB205DDE294417F777EFDFB1AB_1478218204 =         CipherSuite.getSupportedCipherSuiteNames();
        varF6F3ABBB205DDE294417F777EFDFB1AB_1478218204.addTaint(taint);
        return varF6F3ABBB205DDE294417F777EFDFB1AB_1478218204;
        // ---------- Original Method ----------
        //return CipherSuite.getSupportedCipherSuiteNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.416 -0400", hash_original_method = "80B545F2398A25060AECB1A23E821DD5", hash_generated_method = "24E90CD7EE19994607B925F200066A65")
    @Override
    public String[] getEnabledCipherSuites() {
String[] varE73CF5FBDF510EEFDF00C7E4AF85C310_332997983 =         sslParameters.getEnabledCipherSuites();
        varE73CF5FBDF510EEFDF00C7E4AF85C310_332997983.addTaint(taint);
        return varE73CF5FBDF510EEFDF00C7E4AF85C310_332997983;
        // ---------- Original Method ----------
        //return sslParameters.getEnabledCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.416 -0400", hash_original_method = "7C4ABDE66C2DD67AB299013913F9BF06", hash_generated_method = "A502E0EAAECE8396CE85A55C0A04C6E0")
    @Override
    public void setEnabledCipherSuites(String[] suites) {
        addTaint(suites[0].getTaint());
        sslParameters.setEnabledCipherSuites(suites);
        // ---------- Original Method ----------
        //sslParameters.setEnabledCipherSuites(suites);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.416 -0400", hash_original_method = "9A36300B3497119D0180A59D3E72D371", hash_generated_method = "736EF08E6B9F61001031435D9298E18D")
    @Override
    public String[] getSupportedProtocols() {
String[] varCE68CF4030A908DFE590B8EDFA039BDD_1373460077 =         ProtocolVersion.supportedProtocols.clone();
        varCE68CF4030A908DFE590B8EDFA039BDD_1373460077.addTaint(taint);
        return varCE68CF4030A908DFE590B8EDFA039BDD_1373460077;
        // ---------- Original Method ----------
        //return ProtocolVersion.supportedProtocols.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.416 -0400", hash_original_method = "9376751549A6436575C0783CA6C3A4A0", hash_generated_method = "D3B0E0C9D026EB06227FE55F01A6E2CC")
    @Override
    public String[] getEnabledProtocols() {
String[] var845A46B817F78B5E0728F82AD0FF52E6_1807771791 =         sslParameters.getEnabledProtocols();
        var845A46B817F78B5E0728F82AD0FF52E6_1807771791.addTaint(taint);
        return var845A46B817F78B5E0728F82AD0FF52E6_1807771791;
        // ---------- Original Method ----------
        //return sslParameters.getEnabledProtocols();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.417 -0400", hash_original_method = "1CAC4BB68A222585D834DF0E7DBBD0B9", hash_generated_method = "CCBC6F8DD000D5739B00A3E9F868DB1C")
    @Override
    public void setEnabledProtocols(String[] protocols) {
        addTaint(protocols[0].getTaint());
        sslParameters.setEnabledProtocols(protocols);
        // ---------- Original Method ----------
        //sslParameters.setEnabledProtocols(protocols);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.417 -0400", hash_original_method = "433F9F6F1671E88E2914017CCCE9CE51", hash_generated_method = "C946F9CB0470135AAAA0DD5A6F76D022")
    @Override
    public void setUseClientMode(boolean mode) {
        addTaint(mode);
        sslParameters.setUseClientMode(mode);
        // ---------- Original Method ----------
        //sslParameters.setUseClientMode(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.417 -0400", hash_original_method = "01F03276D647357C499C358366605A7A", hash_generated_method = "A1F647F8788DC6533BE97237AEA38D3C")
    @Override
    public boolean getUseClientMode() {
        boolean var264C485BBAEC609C8CEC6E380F554AB0_611384879 = (sslParameters.getUseClientMode());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1761145880 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1761145880;
        // ---------- Original Method ----------
        //return sslParameters.getUseClientMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.418 -0400", hash_original_method = "87B99BB5E16802D75B8230FD21E2413F", hash_generated_method = "BA7C72106D7ACD8A3990718038741929")
    @Override
    public void setNeedClientAuth(boolean need) {
        addTaint(need);
        sslParameters.setNeedClientAuth(need);
        // ---------- Original Method ----------
        //sslParameters.setNeedClientAuth(need);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.418 -0400", hash_original_method = "01CDFCACAD6C113BE18D967A4C320F8F", hash_generated_method = "504125053ABF172C0C9ACE9D80749EA2")
    @Override
    public boolean getNeedClientAuth() {
        boolean var8775D3F02F22101BF43E8B27516BBE95_900059735 = (sslParameters.getNeedClientAuth());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2084830466 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2084830466;
        // ---------- Original Method ----------
        //return sslParameters.getNeedClientAuth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.418 -0400", hash_original_method = "C4BE9213AE4AE3AE8B3FD470CA7DBEA1", hash_generated_method = "09030FB81E24A5D701A15381DB305A48")
    @Override
    public void setWantClientAuth(boolean want) {
        addTaint(want);
        sslParameters.setWantClientAuth(want);
        // ---------- Original Method ----------
        //sslParameters.setWantClientAuth(want);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.419 -0400", hash_original_method = "BFCFACF4683D2DA63944456ACA1AFE4C", hash_generated_method = "6D1CFBE4F589F6651062EF49D5A2345D")
    @Override
    public boolean getWantClientAuth() {
        boolean var49776A2797A76D9AE0E32B9F61634A24_1028307905 = (sslParameters.getWantClientAuth());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1026764250 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1026764250;
        // ---------- Original Method ----------
        //return sslParameters.getWantClientAuth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.419 -0400", hash_original_method = "CCC6382646A49B02E626A26467D69493", hash_generated_method = "85CCF52EB3F74FECC3630ABAAC720430")
    @Override
    public void setEnableSessionCreation(boolean flag) {
        addTaint(flag);
        sslParameters.setEnableSessionCreation(flag);
        // ---------- Original Method ----------
        //sslParameters.setEnableSessionCreation(flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.419 -0400", hash_original_method = "67C983FA387520F5F3AF315C719B29E4", hash_generated_method = "4B1F782C0032825FEF8C9BBC22503660")
    @Override
    public boolean getEnableSessionCreation() {
        boolean var6A496EF2CB1B11366741370C45064742_863001952 = (sslParameters.getEnableSessionCreation());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_737638611 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_737638611;
        // ---------- Original Method ----------
        //return sslParameters.getEnableSessionCreation();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.420 -0400", hash_original_method = "E95178BAD1AB83F5F7B2A543005EDE81", hash_generated_method = "76EB403C93B749D1213D8513404CED35")
    @Override
    public Socket accept() throws IOException {
        if(logger != null)        
        {
            logger.println("SSLServerSocketImpl.accept ..");
        } //End block
        SSLSocketImpl s = new SSLSocketImpl(
                (SSLParametersImpl) sslParameters.clone());
        implAccept(s);
        s.init();
        if(logger != null)        
        {
            logger.println("SSLServerSocketImpl: accepted, initialized");
        } //End block
Socket var0478718F0636FB61899C13801CE9FE09_1877129089 =         s;
        var0478718F0636FB61899C13801CE9FE09_1877129089.addTaint(taint);
        return var0478718F0636FB61899C13801CE9FE09_1877129089;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.420 -0400", hash_original_method = "2BD2C11E492A0926A3928FBE6062AA1A", hash_generated_method = "E5CF0B843EEB1B434D6864958B1F8997")
    @Override
    public String toString() {
String var612488F0B8D11C8599432F1B979E9024_126129818 =         "[SSLServerSocketImpl]";
        var612488F0B8D11C8599432F1B979E9024_126129818.addTaint(taint);
        return var612488F0B8D11C8599432F1B979E9024_126129818;
        // ---------- Original Method ----------
        //return "[SSLServerSocketImpl]";
    }

    
}

