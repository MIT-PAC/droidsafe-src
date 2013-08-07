package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.537 -0400", hash_original_field = "3AE81331685336BDF4905577358403FE", hash_generated_field = "43A471CC626A390C3F42C96A293CE4F3")

    private boolean handshake_started = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.537 -0400", hash_original_field = "398E3ACF063793A09BD262C5C522B1DE", hash_generated_field = "EDC147518BA686E3DAEAF859EB64368C")

    protected SSLRecordProtocol recordProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.538 -0400", hash_original_field = "C8D4E1C676644CE99FCC63554749D588", hash_generated_field = "1032E45BD599BACD8B5F207A3C5A48C0")

    private HandshakeProtocol handshakeProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.538 -0400", hash_original_field = "81D2B0D9B2A75D6611E459D125528CA5", hash_generated_field = "7F98BE8FCC656C783F586E8BC58013DC")

    private AlertProtocol alertProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.538 -0400", hash_original_field = "B833D39B605EBB2737927AB5B4154643", hash_generated_field = "525094C3FC63278C6116C6DEB230FC51")

    private SSLSocketInputStream appDataIS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.538 -0400", hash_original_field = "D95015CADC11FD2EE735FEB5B8CFBC64", hash_generated_field = "F04547F05FBC3550B4832B6EFAD5429B")

    private SSLSocketOutputStream appDataOS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.538 -0400", hash_original_field = "21D6F40CFB511982E4424E0E250A9557", hash_generated_field = "14A9356888CCC2F5828130712AD7BEEF")

    private SSLSessionImpl session;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.538 -0400", hash_original_field = "2B2C58BD2F67680893D7D8171D248B07", hash_generated_field = "45E3FC29C212ED74F873A281D50900AB")

    private boolean socket_was_closed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.538 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "193A05E0CE57E1D6165874B1C5DC807D")

    protected SSLParametersImpl sslParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.538 -0400", hash_original_field = "A43C1B0AA53A0C908810C06AB1FF3967", hash_generated_field = "D316EEE6844FE498763EB8295772C4A2")

    protected InputStream input;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.538 -0400", hash_original_field = "78E6221F6393D1356681DB398F14CE6D", hash_generated_field = "0E6723CD0F1F5210EC010C59DA7A47E7")

    protected OutputStream output;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.538 -0400", hash_original_field = "9F99697C78E088CB04E67AFD7A9D1068", hash_generated_field = "18AE5B2EA1E4D2608E5F816AEC3235B3")

    private ArrayList<HandshakeCompletedListener> listeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.538 -0400", hash_original_field = "54B84D2B1AE03DCCAE40C4858357B92A", hash_generated_field = "0327D000C0AB01CB97996B4D95743A26")

    private Logger.Stream logger = Logger.getStream("socket");
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.539 -0400", hash_original_method = "7B6D79A24FC469186EEF1935CCE0FAAE", hash_generated_method = "76D8E06FA8235152D346BA475221EC7E")
    protected  SSLSocketImpl(SSLParametersImpl sslParameters) {
        this.sslParameters = sslParameters;
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.539 -0400", hash_original_method = "B90B14697CA53EAAAF818AFF9DD06A34", hash_generated_method = "3261414DF2F3A19C31EFB8993DEF27A9")
    protected  SSLSocketImpl(String host, int port, SSLParametersImpl sslParameters) throws IOException, UnknownHostException {
        super(host, port);
        addTaint(port);
        addTaint(host.getTaint());
        this.sslParameters = sslParameters;
        init();
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
        //init();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.540 -0400", hash_original_method = "A894226ED2FD2304A12A4E08266BE71A", hash_generated_method = "55CDA01F1466479C682388625FDC2D4C")
    protected  SSLSocketImpl(String host, int port,
            InetAddress localHost, int localPort,
            SSLParametersImpl sslParameters) throws IOException,
            UnknownHostException {
        super(host, port, localHost, localPort);
        addTaint(localPort);
        addTaint(localHost.getTaint());
        addTaint(port);
        addTaint(host.getTaint());
        this.sslParameters = sslParameters;
        init();
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
        //init();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.541 -0400", hash_original_method = "21D48E905F577E64713F2C7CA9B1B030", hash_generated_method = "E3692836413BEBD6771E68ED95F56D31")
    protected  SSLSocketImpl(InetAddress host, int port,
            SSLParametersImpl sslParameters) throws IOException {
        super(host, port);
        addTaint(port);
        addTaint(host.getTaint());
        this.sslParameters = sslParameters;
        init();
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
        //init();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.542 -0400", hash_original_method = "6C5671217798C1BD7239CC8FEB7B883B", hash_generated_method = "52F0C48883003DCEEE9B66342298C5C1")
    protected  SSLSocketImpl(InetAddress address, int port,
            InetAddress localAddress, int localPort,
            SSLParametersImpl sslParameters) throws IOException {
        super(address, port, localAddress, localPort);
        addTaint(localPort);
        addTaint(localAddress.getTaint());
        addTaint(port);
        addTaint(address.getTaint());
        this.sslParameters = sslParameters;
        init();
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
        //init();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.543 -0400", hash_original_method = "FD845B5AAD012D6985E0ADCD6A0F1286", hash_generated_method = "23311DA94F2D63FDDE3C6664CB30B326")
    protected void init() throws IOException {
        if(appDataIS != null)        
        {
            return;
        } //End block
        initTransportLayer();
        appDataIS = new SSLSocketInputStream(this);
        appDataOS = new SSLSocketOutputStream(this);
        // ---------- Original Method ----------
        //if (appDataIS != null) {
            //return;
        //}
        //initTransportLayer();
        //appDataIS = new SSLSocketInputStream(this);
        //appDataOS = new SSLSocketOutputStream(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.544 -0400", hash_original_method = "F1A82616FFDC8899DB87D416AB14644B", hash_generated_method = "A4E325529E24EA029F3DA105A3FC705E")
    protected void initTransportLayer() throws IOException {
        input = super.getInputStream();
        output = super.getOutputStream();
        // ---------- Original Method ----------
        //input = super.getInputStream();
        //output = super.getOutputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.544 -0400", hash_original_method = "651677798FC4CE70FB09611DD37A5D23", hash_generated_method = "1B0BF1F5AEE7A50951CD03EBFFE849C6")
    protected void closeTransportLayer() throws IOException {
        super.close();
        if(input != null)        
        {
            input.close();
            output.close();
        } //End block
        // ---------- Original Method ----------
        //super.close();
        //if (input != null) {
            //input.close();
            //output.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.545 -0400", hash_original_method = "12BE90119F3183109C9DE5DBB63B352A", hash_generated_method = "8F42F17A97037D3A4CDDD14B2C9B5623")
    @Override
    public String[] getSupportedCipherSuites() {
String[] varF6F3ABBB205DDE294417F777EFDFB1AB_1965951898 =         CipherSuite.getSupportedCipherSuiteNames();
        varF6F3ABBB205DDE294417F777EFDFB1AB_1965951898.addTaint(taint);
        return varF6F3ABBB205DDE294417F777EFDFB1AB_1965951898;
        // ---------- Original Method ----------
        //return CipherSuite.getSupportedCipherSuiteNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.545 -0400", hash_original_method = "80B545F2398A25060AECB1A23E821DD5", hash_generated_method = "39DE7FF1FF1C2F8B08CC328B05989B7A")
    @Override
    public String[] getEnabledCipherSuites() {
String[] varE73CF5FBDF510EEFDF00C7E4AF85C310_625958179 =         sslParameters.getEnabledCipherSuites();
        varE73CF5FBDF510EEFDF00C7E4AF85C310_625958179.addTaint(taint);
        return varE73CF5FBDF510EEFDF00C7E4AF85C310_625958179;
        // ---------- Original Method ----------
        //return sslParameters.getEnabledCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.545 -0400", hash_original_method = "7C4ABDE66C2DD67AB299013913F9BF06", hash_generated_method = "A502E0EAAECE8396CE85A55C0A04C6E0")
    @Override
    public void setEnabledCipherSuites(String[] suites) {
        addTaint(suites[0].getTaint());
        sslParameters.setEnabledCipherSuites(suites);
        // ---------- Original Method ----------
        //sslParameters.setEnabledCipherSuites(suites);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.546 -0400", hash_original_method = "9A36300B3497119D0180A59D3E72D371", hash_generated_method = "6C69739DE1E98D06D111998283F4D52F")
    @Override
    public String[] getSupportedProtocols() {
String[] varCE68CF4030A908DFE590B8EDFA039BDD_1412884927 =         ProtocolVersion.supportedProtocols.clone();
        varCE68CF4030A908DFE590B8EDFA039BDD_1412884927.addTaint(taint);
        return varCE68CF4030A908DFE590B8EDFA039BDD_1412884927;
        // ---------- Original Method ----------
        //return ProtocolVersion.supportedProtocols.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.546 -0400", hash_original_method = "9376751549A6436575C0783CA6C3A4A0", hash_generated_method = "A17664D1A9FCD1EBB959CB9B537B21B5")
    @Override
    public String[] getEnabledProtocols() {
String[] var845A46B817F78B5E0728F82AD0FF52E6_499471581 =         sslParameters.getEnabledProtocols();
        var845A46B817F78B5E0728F82AD0FF52E6_499471581.addTaint(taint);
        return var845A46B817F78B5E0728F82AD0FF52E6_499471581;
        // ---------- Original Method ----------
        //return sslParameters.getEnabledProtocols();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.546 -0400", hash_original_method = "1CAC4BB68A222585D834DF0E7DBBD0B9", hash_generated_method = "CCBC6F8DD000D5739B00A3E9F868DB1C")
    @Override
    public void setEnabledProtocols(String[] protocols) {
        addTaint(protocols[0].getTaint());
        sslParameters.setEnabledProtocols(protocols);
        // ---------- Original Method ----------
        //sslParameters.setEnabledProtocols(protocols);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.547 -0400", hash_original_method = "3BB959BD0875F4D150E69C54372A8DCB", hash_generated_method = "A4DAE812727CF8539314EC0531C87068")
    @Override
    public void setUseClientMode(boolean mode) {
        addTaint(mode);
        if(handshake_started)        
        {
            IllegalArgumentException var090A9C2074D1C9D942FE5C4CFD7155B6_703164340 = new IllegalArgumentException(
            "Could not change the mode after the initial handshake has begun.");
            var090A9C2074D1C9D942FE5C4CFD7155B6_703164340.addTaint(taint);
            throw var090A9C2074D1C9D942FE5C4CFD7155B6_703164340;
        } //End block
        sslParameters.setUseClientMode(mode);
        // ---------- Original Method ----------
        //if (handshake_started) {
            //throw new IllegalArgumentException(
            //"Could not change the mode after the initial handshake has begun.");
        //}
        //sslParameters.setUseClientMode(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.547 -0400", hash_original_method = "01F03276D647357C499C358366605A7A", hash_generated_method = "44092ECFCE357DC0BA48AE8E0F4A5BC8")
    @Override
    public boolean getUseClientMode() {
        boolean var264C485BBAEC609C8CEC6E380F554AB0_1233932025 = (sslParameters.getUseClientMode());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1480298109 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1480298109;
        // ---------- Original Method ----------
        //return sslParameters.getUseClientMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.547 -0400", hash_original_method = "87B99BB5E16802D75B8230FD21E2413F", hash_generated_method = "BA7C72106D7ACD8A3990718038741929")
    @Override
    public void setNeedClientAuth(boolean need) {
        addTaint(need);
        sslParameters.setNeedClientAuth(need);
        // ---------- Original Method ----------
        //sslParameters.setNeedClientAuth(need);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.548 -0400", hash_original_method = "01CDFCACAD6C113BE18D967A4C320F8F", hash_generated_method = "813177EA1080C831195AA8AB2685CB66")
    @Override
    public boolean getNeedClientAuth() {
        boolean var8775D3F02F22101BF43E8B27516BBE95_1382079291 = (sslParameters.getNeedClientAuth());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1264735981 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1264735981;
        // ---------- Original Method ----------
        //return sslParameters.getNeedClientAuth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.548 -0400", hash_original_method = "C4BE9213AE4AE3AE8B3FD470CA7DBEA1", hash_generated_method = "09030FB81E24A5D701A15381DB305A48")
    @Override
    public void setWantClientAuth(boolean want) {
        addTaint(want);
        sslParameters.setWantClientAuth(want);
        // ---------- Original Method ----------
        //sslParameters.setWantClientAuth(want);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.548 -0400", hash_original_method = "BFCFACF4683D2DA63944456ACA1AFE4C", hash_generated_method = "BCA81B139567B4C3211302C5614C1ED0")
    @Override
    public boolean getWantClientAuth() {
        boolean var49776A2797A76D9AE0E32B9F61634A24_1057282716 = (sslParameters.getWantClientAuth());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_474765043 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_474765043;
        // ---------- Original Method ----------
        //return sslParameters.getWantClientAuth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.549 -0400", hash_original_method = "CCC6382646A49B02E626A26467D69493", hash_generated_method = "85CCF52EB3F74FECC3630ABAAC720430")
    @Override
    public void setEnableSessionCreation(boolean flag) {
        addTaint(flag);
        sslParameters.setEnableSessionCreation(flag);
        // ---------- Original Method ----------
        //sslParameters.setEnableSessionCreation(flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.549 -0400", hash_original_method = "67C983FA387520F5F3AF315C719B29E4", hash_generated_method = "6BB1804F77A938F1ECA1F6625D77EB3D")
    @Override
    public boolean getEnableSessionCreation() {
        boolean var6A496EF2CB1B11366741370C45064742_705847243 = (sslParameters.getEnableSessionCreation());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1846937046 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1846937046;
        // ---------- Original Method ----------
        //return sslParameters.getEnableSessionCreation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.549 -0400", hash_original_method = "8713059613609B55626747E74A63D7AE", hash_generated_method = "8FAB776F5F11E9E0B31449B61DA5D75F")
    @Override
    public SSLSession getSession() {
        if(!handshake_started)        
        {
            try 
            {
                startHandshake();
            } //End block
            catch (IOException e)
            {
SSLSession var33266EACB2455415ED08B160E2815F03_1262612018 =                 SSLSessionImpl.NULL_SESSION;
                var33266EACB2455415ED08B160E2815F03_1262612018.addTaint(taint);
                return var33266EACB2455415ED08B160E2815F03_1262612018;
            } //End block
        } //End block
SSLSession varD555E544A66E0F97DA6BCDE940E3E79C_1224664420 =         session;
        varD555E544A66E0F97DA6BCDE940E3E79C_1224664420.addTaint(taint);
        return varD555E544A66E0F97DA6BCDE940E3E79C_1224664420;
        // ---------- Original Method ----------
        //if (!handshake_started) {
            //try {
                //startHandshake();
            //} catch (IOException e) {
                //return SSLSessionImpl.NULL_SESSION;
            //}
        //}
        //return session;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.550 -0400", hash_original_method = "F46B9A73766B8D71CEE8B005CFE82615", hash_generated_method = "49DE989294F6B7AFFDA95CB8542C0B53")
    @Override
    public void addHandshakeCompletedListener(
            HandshakeCompletedListener listener) {
        addTaint(listener.getTaint());
        if(listener == null)        
        {
            IllegalArgumentException varB02095FE0265340AABD25383D7376280_390974081 = new IllegalArgumentException("Provided listener is null");
            varB02095FE0265340AABD25383D7376280_390974081.addTaint(taint);
            throw varB02095FE0265340AABD25383D7376280_390974081;
        } //End block
        if(listeners == null)        
        {
            listeners = new ArrayList<HandshakeCompletedListener>();
        } //End block
        listeners.add(listener);
        // ---------- Original Method ----------
        //if (listener == null) {
            //throw new IllegalArgumentException("Provided listener is null");
        //}
        //if (listeners == null) {
            //listeners = new ArrayList<HandshakeCompletedListener>();
        //}
        //listeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.551 -0400", hash_original_method = "AD8204C7E0D7DFC602B3A996AAF9AC40", hash_generated_method = "7F2D6AE7E61E32D5AFF4830BE0EBD7AD")
    @Override
    public void removeHandshakeCompletedListener(
            HandshakeCompletedListener listener) {
        addTaint(listener.getTaint());
        if(listener == null)        
        {
            IllegalArgumentException varB02095FE0265340AABD25383D7376280_1069345180 = new IllegalArgumentException("Provided listener is null");
            varB02095FE0265340AABD25383D7376280_1069345180.addTaint(taint);
            throw varB02095FE0265340AABD25383D7376280_1069345180;
        } //End block
        if(listeners == null)        
        {
            IllegalArgumentException var10FDB35631F14D25CC68C0C86726BCA4_1844752986 = new IllegalArgumentException(
                    "Provided listener is not registered");
            var10FDB35631F14D25CC68C0C86726BCA4_1844752986.addTaint(taint);
            throw var10FDB35631F14D25CC68C0C86726BCA4_1844752986;
        } //End block
        if(!listeners.remove(listener))        
        {
            IllegalArgumentException var10FDB35631F14D25CC68C0C86726BCA4_436940001 = new IllegalArgumentException(
                    "Provided listener is not registered");
            var10FDB35631F14D25CC68C0C86726BCA4_436940001.addTaint(taint);
            throw var10FDB35631F14D25CC68C0C86726BCA4_436940001;
        } //End block
        // ---------- Original Method ----------
        //if (listener == null) {
            //throw new IllegalArgumentException("Provided listener is null");
        //}
        //if (listeners == null) {
            //throw new IllegalArgumentException(
                    //"Provided listener is not registered");
        //}
        //if (!listeners.remove(listener)) {
            //throw new IllegalArgumentException(
                    //"Provided listener is not registered");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.553 -0400", hash_original_method = "765B8FA015660A1850228BA85BA4D2EA", hash_generated_method = "451B00E9C4C74E76D5057BC0E7260548")
    @Override
    public void startHandshake() throws IOException {
        if(appDataIS == null)        
        {
            IOException var99A85DDF1243551359017D19FA2DBF3F_1213246125 = new IOException("Socket is not connected.");
            var99A85DDF1243551359017D19FA2DBF3F_1213246125.addTaint(taint);
            throw var99A85DDF1243551359017D19FA2DBF3F_1213246125;
        } //End block
        if(socket_was_closed)        
        {
            IOException varEBBB0E65BA2598B9856A65403EB38C96_1806310800 = new IOException("Socket has already been closed.");
            varEBBB0E65BA2598B9856A65403EB38C96_1806310800.addTaint(taint);
            throw varEBBB0E65BA2598B9856A65403EB38C96_1806310800;
        } //End block
        if(!handshake_started)        
        {
            handshake_started = true;
            if(sslParameters.getUseClientMode())            
            {
                if(logger != null)                
                {
                    logger.println("SSLSocketImpl: CLIENT");
                } //End block
                handshakeProtocol = new ClientHandshakeImpl(this);
            } //End block
            else
            {
                if(logger != null)                
                {
                    logger.println("SSLSocketImpl: SERVER");
                } //End block
                handshakeProtocol = new ServerHandshakeImpl(this);
            } //End block
            alertProtocol = new AlertProtocol();
            recordProtocol = new SSLRecordProtocol(handshakeProtocol,
                    alertProtocol, new SSLStreamedInput(input),
                    appDataIS.dataPoint);
        } //End block
        if(logger != null)        
        {
            logger.println("SSLSocketImpl.startHandshake");
        } //End block
        handshakeProtocol.start();
        doHandshake();
        if(logger != null)        
        {
            logger.println("SSLSocketImpl.startHandshake: END");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.555 -0400", hash_original_method = "9F4C1AA967218079AF1BF56E431987CC", hash_generated_method = "9796AB1773F7CED5F1C54309094E750D")
    @Override
    public InputStream getInputStream() throws IOException {
        if(socket_was_closed)        
        {
            IOException varEBBB0E65BA2598B9856A65403EB38C96_563243193 = new IOException("Socket has already been closed.");
            varEBBB0E65BA2598B9856A65403EB38C96_563243193.addTaint(taint);
            throw varEBBB0E65BA2598B9856A65403EB38C96_563243193;
        } //End block
InputStream var397DC1305100C24326D91594B7E88366_529548505 =         appDataIS;
        var397DC1305100C24326D91594B7E88366_529548505.addTaint(taint);
        return var397DC1305100C24326D91594B7E88366_529548505;
        // ---------- Original Method ----------
        //if (socket_was_closed) {
            //throw new IOException("Socket has already been closed.");
        //}
        //return appDataIS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.556 -0400", hash_original_method = "E9E36047983E43D9B4652427AFC0EE2E", hash_generated_method = "E21D81A8D33E106820D7794E6F18A0F8")
    @Override
    public OutputStream getOutputStream() throws IOException {
        if(socket_was_closed)        
        {
            IOException varEBBB0E65BA2598B9856A65403EB38C96_397765661 = new IOException("Socket has already been closed.");
            varEBBB0E65BA2598B9856A65403EB38C96_397765661.addTaint(taint);
            throw varEBBB0E65BA2598B9856A65403EB38C96_397765661;
        } //End block
OutputStream var7C35464E15AF057D033B64BB3C503DA0_2040576798 =         appDataOS;
        var7C35464E15AF057D033B64BB3C503DA0_2040576798.addTaint(taint);
        return var7C35464E15AF057D033B64BB3C503DA0_2040576798;
        // ---------- Original Method ----------
        //if (socket_was_closed) {
            //throw new IOException("Socket has already been closed.");
        //}
        //return appDataOS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.557 -0400", hash_original_method = "9C6F28F8DBD161E857A3A3894EC60A85", hash_generated_method = "D11D17292EA0E60281AC06E5333F6B4E")
    @Override
    public void connect(SocketAddress endpoint) throws IOException {
        addTaint(endpoint.getTaint());
        super.connect(endpoint);
        init();
        // ---------- Original Method ----------
        //super.connect(endpoint);
        //init();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.557 -0400", hash_original_method = "E1471735BF64AF2EDFAE20D8138E7876", hash_generated_method = "582FFF7FF5631DE43D5A93184E537A73")
    @Override
    public void connect(SocketAddress endpoint, int timeout) throws IOException {
        addTaint(timeout);
        addTaint(endpoint.getTaint());
        super.connect(endpoint, timeout);
        init();
        // ---------- Original Method ----------
        //super.connect(endpoint, timeout);
        //init();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.558 -0400", hash_original_method = "1C7BF244CDBA20FEDEE01D71D2117BF2", hash_generated_method = "4347C581CE5303DABD4BC43EEB2BC58E")
    @Override
    public void close() throws IOException {
        if(logger != null)        
        {
            logger.println("SSLSocket.close "+socket_was_closed);
        } //End block
        if(!socket_was_closed)        
        {
            if(handshake_started)            
            {
                alertProtocol.alert(AlertProtocol.WARNING,
                        AlertProtocol.CLOSE_NOTIFY);
                try 
                {
                    output.write(alertProtocol.wrap());
                } //End block
                catch (IOException ex)
                {
                } //End block
                alertProtocol.setProcessed();
            } //End block
            shutdown();
            closeTransportLayer();
            socket_was_closed = true;
        } //End block
        // ---------- Original Method ----------
        //if (logger != null) {
            //logger.println("SSLSocket.close "+socket_was_closed);
        //}
        //if (!socket_was_closed) {
            //if (handshake_started) {
                //alertProtocol.alert(AlertProtocol.WARNING,
                        //AlertProtocol.CLOSE_NOTIFY);
                //try {
                    //output.write(alertProtocol.wrap());
                //} catch (IOException ex) { }
                //alertProtocol.setProcessed();
            //}
            //shutdown();
            //closeTransportLayer();
            //socket_was_closed = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.558 -0400", hash_original_method = "76A321423E9827230577FC78A6A38E86", hash_generated_method = "F74358B7C5D77AA36AB038EC8B4EAFE6")
    @Override
    public void sendUrgentData(int data) throws IOException {
        addTaint(data);
        SocketException var50B8BFCDC6E8315B913207C5748AC53B_113215818 = new SocketException(
                "Method sendUrgentData() is not supported.");
        var50B8BFCDC6E8315B913207C5748AC53B_113215818.addTaint(taint);
        throw var50B8BFCDC6E8315B913207C5748AC53B_113215818;
        // ---------- Original Method ----------
        //throw new SocketException(
                //"Method sendUrgentData() is not supported.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.559 -0400", hash_original_method = "274CE2EF30305C6385D88E550D3E79A6", hash_generated_method = "416EFCD6C6BE02255E5510958739ED10")
    @Override
    public void setOOBInline(boolean on) throws SocketException {
        addTaint(on);
        SocketException var88B0E59078F2F2FADE721829F824BF94_1036461244 = new SocketException(
                "Methods sendUrgentData, setOOBInline are not supported.");
        var88B0E59078F2F2FADE721829F824BF94_1036461244.addTaint(taint);
        throw var88B0E59078F2F2FADE721829F824BF94_1036461244;
        // ---------- Original Method ----------
        //throw new SocketException(
                //"Methods sendUrgentData, setOOBInline are not supported.");
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.559 -0400", hash_original_method = "14168DA1E68DB132A0DACBB007EAD125", hash_generated_method = "4A6C7BCC0141DA74C0F581BCD76FE06E")
    private void shutdown() {
        if(handshake_started)        
        {
            alertProtocol.shutdown();
            alertProtocol = null;
            handshakeProtocol.shutdown();
            handshakeProtocol = null;
            recordProtocol.shutdown();
            recordProtocol = null;
        } //End block
        socket_was_closed = true;
        // ---------- Original Method ----------
        //if (handshake_started) {
            //alertProtocol.shutdown();
            //alertProtocol = null;
            //handshakeProtocol.shutdown();
            //handshakeProtocol = null;
            //recordProtocol.shutdown();
            //recordProtocol = null;
        //}
        //socket_was_closed = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.560 -0400", hash_original_method = "9F181DA813C5E35277B72423F9B4689F", hash_generated_method = "60A60E6FE8575FE188AFC15EF9EB08BA")
    protected void needAppData() throws IOException {
        if(!handshake_started)        
        {
            startHandshake();
        } //End block
        int type;
        if(logger != null)        
        {
            logger.println("SSLSocket.needAppData..");
        } //End block
        try 
        {
            while
(appDataIS.available() == 0)            
            {
switch(type = recordProtocol.unwrap()){
                case ContentType.HANDSHAKE:
                if(!handshakeProtocol.getStatus().equals(
                                SSLEngineResult.HandshakeStatus
                                .NOT_HANDSHAKING))                
                {
                    doHandshake();
                } //End block
                break;
                case ContentType.ALERT:
                processAlert();
                if(socket_was_closed)                
                {
                    return;
                } //End block
                break;
                case ContentType.APPLICATION_DATA:
                if(logger != null)                
                {
                    logger.println(
                                    "SSLSocket.needAppData: got the data");
                } //End block
                break;
                default:
                reportFatalAlert(AlertProtocol.UNEXPECTED_MESSAGE,
                                new SSLException("Unexpected message of type "
                                    + type + " has been got"));
}                if(alertProtocol.hasAlert())                
                {
                    output.write(alertProtocol.wrap());
                    alertProtocol.setProcessed();
                } //End block
                if(socket_was_closed)                
                {
                    appDataIS.setEnd();
                    return;
                } //End block
            } //End block
        } //End block
        catch (AlertException e)
        {
            reportFatalAlert(e.getDescriptionCode(), e.getReason());
        } //End block
        catch (EndOfSourceException e)
        {
            appDataIS.setEnd();
        } //End block
        if(logger != null)        
        {
            logger.println("SSLSocket.needAppData: app data len: "
                    + appDataIS.available());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.561 -0400", hash_original_method = "BD84CA3E70E7330B95C89C209BCE2D56", hash_generated_method = "FEB0CD9497014F7487B145C8E95167A5")
    protected void writeAppData(byte[] data, int offset, int len) throws IOException {
        addTaint(len);
        addTaint(offset);
        addTaint(data[0]);
        if(!handshake_started)        
        {
            startHandshake();
        } //End block
        if(logger != null)        
        {
            logger.println("SSLSocket.writeAppData: " +
                    len + " " + SSLRecordProtocol.MAX_DATA_LENGTH);
        } //End block
        try 
        {
            if(len < SSLRecordProtocol.MAX_DATA_LENGTH)            
            {
                output.write(recordProtocol.wrap(ContentType.APPLICATION_DATA,
                            data, offset, len));
            } //End block
            else
            {
                while
(len >= SSLRecordProtocol.MAX_DATA_LENGTH)                
                {
                    output.write(recordProtocol.wrap(
                                ContentType.APPLICATION_DATA, data, offset,
                                SSLRecordProtocol.MAX_DATA_LENGTH));
                    offset += SSLRecordProtocol.MAX_DATA_LENGTH;
                    len -= SSLRecordProtocol.MAX_DATA_LENGTH;
                } //End block
                if(len > 0)                
                {
                    output.write(
                        recordProtocol.wrap(ContentType.APPLICATION_DATA,
                                            data, offset, len));
                } //End block
            } //End block
        } //End block
        catch (AlertException e)
        {
            reportFatalAlert(e.getDescriptionCode(), e.getReason());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.562 -0400", hash_original_method = "B11A6FC07E880C42041746EA2FD3607A", hash_generated_method = "0890397EA3AC763A30A556831EB1CD54")
    private void doHandshake() throws IOException {
        SSLEngineResult.HandshakeStatus status;
        int type;
        try 
        {
            while
(!(status = handshakeProtocol.getStatus()).equals(
                        SSLEngineResult.HandshakeStatus.FINISHED))            
            {
                if(logger != null)                
                {
                    String s = (status.equals(
                                SSLEngineResult.HandshakeStatus.NEED_WRAP))
                        ? "NEED_WRAP"
                        : (status.equals(
                                SSLEngineResult.HandshakeStatus.NEED_UNWRAP))
                            ? "NEED_UNWRAP"
                            : "STATUS: OTHER!";
                    logger.println("SSLSocketImpl: HS status: "+s+" "+status);
                } //End block
                if(status.equals(SSLEngineResult.HandshakeStatus.NEED_WRAP))                
                {
                    output.write(handshakeProtocol.wrap());
                } //End block
                else
                if(status.equals(
                            SSLEngineResult.HandshakeStatus.NEED_UNWRAP))                
                {
switch(type = recordProtocol.unwrap()){
                    case ContentType.HANDSHAKE:
                    case ContentType.CHANGE_CIPHER_SPEC:
                    break;
                    case ContentType.APPLICATION_DATA:
                    break;
                    case ContentType.ALERT:
                    processAlert();
                    if(socket_was_closed)                    
                    {
                        return;
                    } //End block
                    break;
                    default:
                    reportFatalAlert(AlertProtocol.UNEXPECTED_MESSAGE,
                                    new SSLException(
                                        "Unexpected message of type "
                                        + type + " has been got"));
}
                } //End block
                else
                {
                    reportFatalAlert(AlertProtocol.INTERNAL_ERROR,
                        new SSLException(
                            "Handshake passed unexpected status: "+status));
                } //End block
                if(alertProtocol.hasAlert())                
                {
                    output.write(alertProtocol.wrap());
                    alertProtocol.setProcessed();
                } //End block
            } //End block
        } //End block
        catch (EndOfSourceException e)
        {
            appDataIS.setEnd();
            IOException var2C376D28D3F113EFF1565DB5EFCF58E6_1921412888 = new IOException("Connection was closed");
            var2C376D28D3F113EFF1565DB5EFCF58E6_1921412888.addTaint(taint);
            throw var2C376D28D3F113EFF1565DB5EFCF58E6_1921412888;
        } //End block
        catch (AlertException e)
        {
            reportFatalAlert(e.getDescriptionCode(), e.getReason());
        } //End block
        session = recordProtocol.getSession();
        if(listeners != null)        
        {
            HandshakeCompletedEvent event = new HandshakeCompletedEvent(this, session);
            int size = listeners.size();
for(int i=0;i<size;i++)
            {
                listeners.get(i)
                    .handshakeCompleted(event);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.562 -0400", hash_original_method = "1DCA961CD2F2BCD453967A97232AAFC6", hash_generated_method = "B3D04C5865EB60CA318C08AC4BF6AFC9")
    private void processAlert() throws IOException {
        if(!alertProtocol.hasAlert())        
        {
            return;
        } //End block
        if(alertProtocol.isFatalAlert())        
        {
            alertProtocol.setProcessed();
            String description = "Fatal alert received "
                + alertProtocol.getAlertDescription();
            shutdown();
            SSLException var30A4E97391385D7A4E772B8C367E9DCB_433962160 = new SSLException(description);
            var30A4E97391385D7A4E772B8C367E9DCB_433962160.addTaint(taint);
            throw var30A4E97391385D7A4E772B8C367E9DCB_433962160;
        } //End block
        if(logger != null)        
        {
            logger.println("Warning alert received: "
                + alertProtocol.getAlertDescription());
        } //End block
switch(alertProtocol.getDescriptionCode()){
        case AlertProtocol.CLOSE_NOTIFY:
        alertProtocol.setProcessed();
        appDataIS.setEnd();
        close();
        return;
        default:
        alertProtocol.setProcessed();
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.563 -0400", hash_original_method = "716B8ABB2A0B730F9297C2C81BE3F29D", hash_generated_method = "B93E3A59AAFB02D7ECF8E3BD24C7E8AD")
    private void reportFatalAlert(byte description_code,
            SSLException reason) throws IOException {
        addTaint(reason.getTaint());
        addTaint(description_code);
        alertProtocol.alert(AlertProtocol.FATAL, description_code);
        try 
        {
            output.write(alertProtocol.wrap());
        } //End block
        catch (IOException ex)
        {
        } //End block
        alertProtocol.setProcessed();
        shutdown();
        reason.addTaint(taint);
        throw reason;
        // ---------- Original Method ----------
        //alertProtocol.alert(AlertProtocol.FATAL, description_code);
        //try {
            //output.write(alertProtocol.wrap());
        //} catch (IOException ex) { }
        //alertProtocol.setProcessed();
        //shutdown();
        //throw reason;
    }

    
}

