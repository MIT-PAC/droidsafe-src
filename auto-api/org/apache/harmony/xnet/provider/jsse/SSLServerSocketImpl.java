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
    private SSLParametersImpl sslParameters;
    private Logger.Stream logger = Logger.getStream("ssocket");
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.181 -0400", hash_original_method = "3C51E4D29638B27E77C8772382B20970", hash_generated_method = "D0BF8410ECD738099414030A98B64E15")
    @DSModeled(DSC.SAFE)
    protected SSLServerSocketImpl(SSLParametersImpl sslParameters) throws IOException {
        dsTaint.addTaint(sslParameters.dsTaint);
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.181 -0400", hash_original_method = "964D36D73A9D78EC878BB4C8C1192330", hash_generated_method = "63FB3714854A804F7F770D11D6537CA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SSLServerSocketImpl(int port, SSLParametersImpl sslParameters) throws IOException {
        super(port);
        dsTaint.addTaint(port);
        dsTaint.addTaint(sslParameters.dsTaint);
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.181 -0400", hash_original_method = "99AA71D25BC131720F5627E787888583", hash_generated_method = "7B900ECFFCF232418362BECD94C27437")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SSLServerSocketImpl(int port, int backlog,
            SSLParametersImpl sslParameters) throws IOException {
        super(port, backlog);
        dsTaint.addTaint(port);
        dsTaint.addTaint(backlog);
        dsTaint.addTaint(sslParameters.dsTaint);
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.182 -0400", hash_original_method = "02A799087F98193615A0535EAB6C7699", hash_generated_method = "78F112579EA14A83381FADBE3A5C5B9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SSLServerSocketImpl(int port, int backlog,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.182 -0400", hash_original_method = "12BE90119F3183109C9DE5DBB63B352A", hash_generated_method = "59484CB2D021CF5C9587FC7656F79F50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getSupportedCipherSuites() {
        String[] var7538431C68A39BDF527B3279B9F226C5_173038531 = (CipherSuite.getSupportedCipherSuiteNames());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return CipherSuite.getSupportedCipherSuiteNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.182 -0400", hash_original_method = "80B545F2398A25060AECB1A23E821DD5", hash_generated_method = "12A564C2E42FE91BFA02A2973A8AD418")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getEnabledCipherSuites() {
        String[] varC3ED4EB907904E69984EFC846C8D14D7_528196438 = (sslParameters.getEnabledCipherSuites());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return sslParameters.getEnabledCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.182 -0400", hash_original_method = "7C4ABDE66C2DD67AB299013913F9BF06", hash_generated_method = "9E1BD0F36B086A8B521F2689941AD1AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setEnabledCipherSuites(String[] suites) {
        dsTaint.addTaint(suites[0]);
        sslParameters.setEnabledCipherSuites(suites);
        // ---------- Original Method ----------
        //sslParameters.setEnabledCipherSuites(suites);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.182 -0400", hash_original_method = "9A36300B3497119D0180A59D3E72D371", hash_generated_method = "9E5EDE71B9A9ADCA4E6A0FDF3A636310")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getSupportedProtocols() {
        String[] var783FADE499BFC8C3457949EAB555903E_2118526276 = (ProtocolVersion.supportedProtocols.clone());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return ProtocolVersion.supportedProtocols.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.183 -0400", hash_original_method = "9376751549A6436575C0783CA6C3A4A0", hash_generated_method = "8EF8D2A16B1DC39C6A9BC665EB58C16C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getEnabledProtocols() {
        String[] varA33B229DEE35C74B9811610CA888B1B5_1727800651 = (sslParameters.getEnabledProtocols());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return sslParameters.getEnabledProtocols();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.183 -0400", hash_original_method = "1CAC4BB68A222585D834DF0E7DBBD0B9", hash_generated_method = "98EB9B5352B74ED52E4191B5D05D71C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setEnabledProtocols(String[] protocols) {
        dsTaint.addTaint(protocols[0]);
        sslParameters.setEnabledProtocols(protocols);
        // ---------- Original Method ----------
        //sslParameters.setEnabledProtocols(protocols);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.183 -0400", hash_original_method = "433F9F6F1671E88E2914017CCCE9CE51", hash_generated_method = "5F6D288C13B7631A67FD74A23F2165F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setUseClientMode(boolean mode) {
        dsTaint.addTaint(mode);
        sslParameters.setUseClientMode(mode);
        // ---------- Original Method ----------
        //sslParameters.setUseClientMode(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.183 -0400", hash_original_method = "01F03276D647357C499C358366605A7A", hash_generated_method = "4A166808D3B7C3990C7D2431945CC383")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getUseClientMode() {
        boolean var5D6C317C7C34AA34FED4DDA3BFA46DAC_1549789016 = (sslParameters.getUseClientMode());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sslParameters.getUseClientMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.183 -0400", hash_original_method = "87B99BB5E16802D75B8230FD21E2413F", hash_generated_method = "6CC5B77D04C22EF0B7C8D76FE3C5FE68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setNeedClientAuth(boolean need) {
        dsTaint.addTaint(need);
        sslParameters.setNeedClientAuth(need);
        // ---------- Original Method ----------
        //sslParameters.setNeedClientAuth(need);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.184 -0400", hash_original_method = "01CDFCACAD6C113BE18D967A4C320F8F", hash_generated_method = "D11F125E02C788CB14406598C14F9F96")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getNeedClientAuth() {
        boolean var666666A183221FEF9E4AC429A4F2FC13_1183430368 = (sslParameters.getNeedClientAuth());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sslParameters.getNeedClientAuth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.184 -0400", hash_original_method = "C4BE9213AE4AE3AE8B3FD470CA7DBEA1", hash_generated_method = "3CF93375E2EDE097483BB86B9A2A6364")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setWantClientAuth(boolean want) {
        dsTaint.addTaint(want);
        sslParameters.setWantClientAuth(want);
        // ---------- Original Method ----------
        //sslParameters.setWantClientAuth(want);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.184 -0400", hash_original_method = "BFCFACF4683D2DA63944456ACA1AFE4C", hash_generated_method = "7E3CB57A4ECD1796CEDE45CAB9B7ED9E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getWantClientAuth() {
        boolean var1F88322EA2F28C29D3EC82222D21AA46_45093587 = (sslParameters.getWantClientAuth());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sslParameters.getWantClientAuth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.184 -0400", hash_original_method = "CCC6382646A49B02E626A26467D69493", hash_generated_method = "1CEC5C88A393CCF6951D2A9AC29A0DA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setEnableSessionCreation(boolean flag) {
        dsTaint.addTaint(flag);
        sslParameters.setEnableSessionCreation(flag);
        // ---------- Original Method ----------
        //sslParameters.setEnableSessionCreation(flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.184 -0400", hash_original_method = "67C983FA387520F5F3AF315C719B29E4", hash_generated_method = "33EB10DEBF135C9F324C13B44576EDA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getEnableSessionCreation() {
        boolean varAFF7A8ADF82548D8DE353C67D9576F3E_713685944 = (sslParameters.getEnableSessionCreation());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sslParameters.getEnableSessionCreation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.185 -0400", hash_original_method = "E95178BAD1AB83F5F7B2A543005EDE81", hash_generated_method = "54A04163A2F470FE8E41F5B187C0BCA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Socket accept() throws IOException {
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
        return (Socket)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.185 -0400", hash_original_method = "2BD2C11E492A0926A3928FBE6062AA1A", hash_generated_method = "1072D8584B4131E0637FF43B190139DD")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "[SSLServerSocketImpl]";
    }

    
}

