package gov.nist.javax.sip.stack;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.Host;
import gov.nist.core.HostPort;
import gov.nist.core.InternalErrorHandler;
import gov.nist.javax.sip.ListeningPointImpl;
import gov.nist.javax.sip.header.Via;
import java.io.IOException;
import java.net.InetAddress;
import java.text.ParseException;
import javax.sip.InvalidArgumentException;

public abstract class MessageProcessor implements Runnable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.788 -0400", hash_original_field = "93843F38363D24DFE376CC298A9F7B78", hash_generated_field = "3DC51267A61BBDF8C5A7E9BDABF1462E")

    private String sentBy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.788 -0400", hash_original_field = "F9560AA6AB99BBF0332940DD7B663FD3", hash_generated_field = "0389863D34D171A4FDB6F6AEC7FB1BFE")

    private HostPort sentByHostPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.788 -0400", hash_original_field = "E9A198A7A8EACAE094D3A3B40B88E396", hash_generated_field = "D4689216E9776FCD51A7A7F5BD10FEB0")

    private String savedIpAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.788 -0400", hash_original_field = "9D0DE3EE8DA929F164DA3D6942A26C0E", hash_generated_field = "1D1E2A819197300B0531B8BCDEEDBEFB")

    private InetAddress ipAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.788 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.789 -0400", hash_original_field = "7B334B7260361141659FA9862E803476", hash_generated_field = "B1CF55BB145913C3C7A70130704FABEE")

    protected String transport;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.789 -0400", hash_original_field = "8464C05A1C71DC453DF2370A527F688F", hash_generated_field = "D878E56BB6776849EDE70D4AD8553243")

    private ListeningPointImpl listeningPoint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.789 -0400", hash_original_field = "D15D2ED694D19F8DC9203DA930128F7F", hash_generated_field = "050A6FCEE8F9152C4D50D2695C900579")

    private boolean sentBySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.789 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "3233C5012C49C796F9D6BBC8E02EAB41")

    protected SIPTransactionStack sipStack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.790 -0400", hash_original_method = "BC8F7D4E4A2ED3DFF02CD99DF0273205", hash_generated_method = "BE2224366E62DB88B879A0C9A552860C")
    protected  MessageProcessor( String transport ) {
        this.transport = transport;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.790 -0400", hash_original_method = "2C4312BB27594DAC5B53740BCE61F76F", hash_generated_method = "96439D7A800DDD503CCF1F8D7FC1A559")
    protected  MessageProcessor( InetAddress ipAddress, int port, String transport,
    							SIPTransactionStack transactionStack ) {
        this( transport );
        addTaint(transactionStack.getTaint());
        addTaint(transport.getTaint());
        addTaint(port);
        addTaint(ipAddress.getTaint());
        this.initialize(ipAddress, port, transactionStack);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.792 -0400", hash_original_method = "BB334E9937075E417D8A338E6797F33B", hash_generated_method = "ED29D178453B86BC05795D284108548D")
    public final void initialize( InetAddress ipAddress, int port,
			SIPTransactionStack transactionStack ) {
        this.sipStack = transactionStack;
        this.savedIpAddress = ipAddress.getHostAddress();
        this.ipAddress = ipAddress;
        this.port = port;
        this.sentByHostPort = new HostPort();
        this.sentByHostPort.setHost(new Host(ipAddress.getHostAddress()));
        this.sentByHostPort.setPort(port);
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.793 -0400", hash_original_method = "22854860B4C916CC2FA65D60880C8F3F", hash_generated_method = "564DB85A4C244446A395DD5B7785AE9A")
    public String getTransport() {
String var555A7CA0390490B84966DAB12A131C9F_1923936223 =         this.transport;
        var555A7CA0390490B84966DAB12A131C9F_1923936223.addTaint(taint);
        return var555A7CA0390490B84966DAB12A131C9F_1923936223;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.794 -0400", hash_original_method = "1804D4B8ED6914D43C8BF926A65BA4F9", hash_generated_method = "C921892BA0CF1FD35DB4A7EB141AB231")
    public int getPort() {
        int var02075052AFB1BA5EC4413B52BC401B14_560797678 = (this.port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2034927064 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2034927064;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.794 -0400", hash_original_method = "AEC88A1D2F84DB1C070CC4830A163BA9", hash_generated_method = "3C3A7B84BC87DF10601069A9827F9E5D")
    public Via getViaHeader() {
        try 
        {
            Via via = new Via();
    if(this.sentByHostPort != null)            
            {
                via.setSentBy(sentByHostPort);
                via.setTransport(this.getTransport());
            } 
            else
            {
                Host host = new Host();
                host.setHostname(this.getIpAddress().getHostAddress());
                via.setHost(host);
                via.setPort(this.getPort());
                via.setTransport(this.getTransport());
            } 
Via var744F9AD2C48AA2D9C877F464ADEF2D12_78244418 =             via;
            var744F9AD2C48AA2D9C877F464ADEF2D12_78244418.addTaint(taint);
            return var744F9AD2C48AA2D9C877F464ADEF2D12_78244418;
        } 
        catch (ParseException ex)
        {
            ex.printStackTrace();
Via var540C13E9E156B687226421B24F2DF178_1100558363 =             null;
            var540C13E9E156B687226421B24F2DF178_1100558363.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1100558363;
        } 
        catch (InvalidArgumentException ex)
        {
            ex.printStackTrace();
Via var540C13E9E156B687226421B24F2DF178_1701257404 =             null;
            var540C13E9E156B687226421B24F2DF178_1701257404.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1701257404;
        } 
        
        
            
            
                
                
            
                
                
                
                
                
            
            
        
            
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.796 -0400", hash_original_method = "07B7078D968B938E9AAFF4E32CB3E487", hash_generated_method = "093B809364592CDAC8EB002DCD4DA50C")
    public ListeningPointImpl getListeningPoint() {
    if(listeningPoint == null)        
        {
    if(this.getSIPStack().isLoggingEnabled())            
            {
                this.getSIPStack().getStackLogger().logError("getListeningPoint" + this +
                        " returning null listeningpoint");
            } 
        } 
ListeningPointImpl var28610F0C322E41C5E84A3628D8BE13E8_1711802144 =         listeningPoint;
        var28610F0C322E41C5E84A3628D8BE13E8_1711802144.addTaint(taint);
        return var28610F0C322E41C5E84A3628D8BE13E8_1711802144;
        
        
            
                
                        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.798 -0400", hash_original_method = "0844D1EB645D6FF4A4D65C631732D7AB", hash_generated_method = "BE7D682CAF040C429C211A38D46F6EF5")
    public void setListeningPoint(ListeningPointImpl lp) {
    if(this.getSIPStack().isLoggingEnabled())        
        {
            this.getSIPStack().getStackLogger().logDebug("setListeningPoint" + this +
                    " listeningPoint = " + lp);
        } 
    if(lp.getPort() != this.getPort())        
        InternalErrorHandler.handleException
            ("lp mismatch with provider",getSIPStack().getStackLogger());
        this.listeningPoint = lp;
        
        
            
                    
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.798 -0400", hash_original_method = "63BE272C790EA048A7B52BA4EDD2764B", hash_generated_method = "858EFBF5019013BDA61B1D46ED01BC8C")
    public String getSavedIpAddress() {
String var72F771F0BAA193F21ED628CB549B7B74_749933115 =         this.savedIpAddress;
        var72F771F0BAA193F21ED628CB549B7B74_749933115.addTaint(taint);
        return var72F771F0BAA193F21ED628CB549B7B74_749933115;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.799 -0400", hash_original_method = "884B07577FCFC9DD806F4641FDB0A38E", hash_generated_method = "8881B564CBA6F3CC9F76DDCE1A81CFC7")
    public InetAddress getIpAddress() {
InetAddress var021FE4BB5A9347AB07122A06261B0E87_924582487 =         this.ipAddress;
        var021FE4BB5A9347AB07122A06261B0E87_924582487.addTaint(taint);
        return var021FE4BB5A9347AB07122A06261B0E87_924582487;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.799 -0400", hash_original_method = "B4AF9626210C81D85EEE89A64933E4EF", hash_generated_method = "C9A7808E9D2B0ECBB7A42CAB1AE9EBBB")
    protected void setIpAddress(InetAddress ipAddress) {
        this.sentByHostPort.setHost( new Host(ipAddress.getHostAddress()));
        this.ipAddress = ipAddress;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.800 -0400", hash_original_method = "032529AF3B126F26B3B81544F7F95DEA", hash_generated_method = "299C10EAC6CD8A0E63122FAF44D5875F")
    public void setSentBy(String sentBy) throws ParseException {
        int ind = sentBy.indexOf(":");
    if(ind == -1)        
        {
            this.sentByHostPort = new HostPort();
            this.sentByHostPort.setHost(new Host(sentBy));
        } 
        else
        {
            this.sentByHostPort = new HostPort();
            this.sentByHostPort.setHost(new Host(sentBy.substring(0, ind)));
            String portStr = sentBy.substring(ind + 1);
            try 
            {
                int port = Integer.parseInt(portStr);
                this.sentByHostPort.setPort(port);
            } 
            catch (NumberFormatException ex)
            {
                ParseException var27520CD594AB9B9D41EE218A7505B68E_1080833194 = new ParseException("Bad format encountered at ", ind);
                var27520CD594AB9B9D41EE218A7505B68E_1080833194.addTaint(taint);
                throw var27520CD594AB9B9D41EE218A7505B68E_1080833194;
            } 
        } 
        this.sentBySet = true;
        this.sentBy = sentBy;
        
        
        
            
            
        
            
            
            
            
                
                
            
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.801 -0400", hash_original_method = "F9F985C0AF39EB878B850CABB152BA50", hash_generated_method = "7903FDAD2561FF4CB6E0420080F258C4")
    public String getSentBy() {
    if(this.sentBy == null && this.sentByHostPort != null)        
        {
            this.sentBy = this.sentByHostPort.toString();
        } 
String varD51D88094686E0D480B6E2DDA4DFBAA7_1578934438 =         this.sentBy;
        varD51D88094686E0D480B6E2DDA4DFBAA7_1578934438.addTaint(taint);
        return varD51D88094686E0D480B6E2DDA4DFBAA7_1578934438;
        
        
            
        
        
    }

    
    public abstract SIPTransactionStack getSIPStack();

    
    public abstract MessageChannel createMessageChannel(HostPort targetHostPort)
            throws IOException;

    
    public abstract MessageChannel createMessageChannel(InetAddress targetHost,
            int port) throws IOException;

    
    public abstract void start() throws IOException;

    
    public abstract void stop();

    
    public abstract int getDefaultTargetPort();

    
    public abstract boolean isSecure();

    
    public abstract int getMaximumMessageSize();

    
    public abstract boolean inUse();

    
    public abstract void run();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.803 -0400", hash_original_method = "7D85FA3843A3F240694BBADD6AC174E2", hash_generated_method = "39538BF8E17ADCF708AC73B594F5866B")
    public boolean isSentBySet() {
        boolean varD15D2ED694D19F8DC9203DA930128F7F_548914074 = (sentBySet);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_955770480 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_955770480;
        
        
    }

    
        public static int getDefaultPort(String transport) {
        return transport.equalsIgnoreCase("TLS")?5061:5060;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.804 -0400", hash_original_field = "B00F9FADF4204970C84368C656AF77CC", hash_generated_field = "EC70EA924951C1DB4898C0AB2F7FC7E1")

    protected static final String IN_ADDR_ANY = "0.0.0.0";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.804 -0400", hash_original_field = "648F89EB1D64275F1AF190105C1418E4", hash_generated_field = "6A0F9C0A61039F0F0A3EF8778E00F960")

    protected static final String IN6_ADDR_ANY = "::0";
}

