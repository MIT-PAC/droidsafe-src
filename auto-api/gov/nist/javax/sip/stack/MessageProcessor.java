package gov.nist.javax.sip.stack;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.570 -0400", hash_original_field = "93843F38363D24DFE376CC298A9F7B78", hash_generated_field = "3DC51267A61BBDF8C5A7E9BDABF1462E")

    private String sentBy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.570 -0400", hash_original_field = "F9560AA6AB99BBF0332940DD7B663FD3", hash_generated_field = "0389863D34D171A4FDB6F6AEC7FB1BFE")

    private HostPort sentByHostPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.570 -0400", hash_original_field = "E9A198A7A8EACAE094D3A3B40B88E396", hash_generated_field = "D4689216E9776FCD51A7A7F5BD10FEB0")

    private String savedIpAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.570 -0400", hash_original_field = "9D0DE3EE8DA929F164DA3D6942A26C0E", hash_generated_field = "1D1E2A819197300B0531B8BCDEEDBEFB")

    private InetAddress ipAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.570 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.570 -0400", hash_original_field = "7B334B7260361141659FA9862E803476", hash_generated_field = "B1CF55BB145913C3C7A70130704FABEE")

    protected String transport;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.570 -0400", hash_original_field = "8464C05A1C71DC453DF2370A527F688F", hash_generated_field = "D878E56BB6776849EDE70D4AD8553243")

    private ListeningPointImpl listeningPoint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.570 -0400", hash_original_field = "D15D2ED694D19F8DC9203DA930128F7F", hash_generated_field = "050A6FCEE8F9152C4D50D2695C900579")

    private boolean sentBySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.570 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "3233C5012C49C796F9D6BBC8E02EAB41")

    protected SIPTransactionStack sipStack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.571 -0400", hash_original_method = "BC8F7D4E4A2ED3DFF02CD99DF0273205", hash_generated_method = "BE2224366E62DB88B879A0C9A552860C")
    protected  MessageProcessor( String transport ) {
        this.transport = transport;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.572 -0400", hash_original_method = "2C4312BB27594DAC5B53740BCE61F76F", hash_generated_method = "2DB3EFDB8B8F3873191B368235F9B1A8")
    protected  MessageProcessor( InetAddress ipAddress, int port, String transport,
    							SIPTransactionStack transactionStack ) {
        this( transport );
        this.initialize(ipAddress, port, transactionStack);
        addTaint(ipAddress.getTaint());
        addTaint(port);
        addTaint(transport.getTaint());
        addTaint(transactionStack.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.572 -0400", hash_original_method = "BB334E9937075E417D8A338E6797F33B", hash_generated_method = "ED29D178453B86BC05795D284108548D")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.573 -0400", hash_original_method = "22854860B4C916CC2FA65D60880C8F3F", hash_generated_method = "EF20F41FE2E68D9576042D0A0357DCD3")
    public String getTransport() {
        String varB4EAC82CA7396A68D541C85D26508E83_2099073110 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2099073110 = this.transport;
        varB4EAC82CA7396A68D541C85D26508E83_2099073110.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2099073110;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.576 -0400", hash_original_method = "1804D4B8ED6914D43C8BF926A65BA4F9", hash_generated_method = "7B533E91F80DD36260B09CD44598E7AB")
    public int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1259533268 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1259533268;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.579 -0400", hash_original_method = "AEC88A1D2F84DB1C070CC4830A163BA9", hash_generated_method = "3AE5D6E863F0559961ECF91E86A1B36B")
    public Via getViaHeader() {
        Via varB4EAC82CA7396A68D541C85D26508E83_1144981846 = null; 
        Via varB4EAC82CA7396A68D541C85D26508E83_1705055286 = null; 
        Via varB4EAC82CA7396A68D541C85D26508E83_1462656579 = null; 
        try 
        {
            Via via = new Via();
            {
                via.setSentBy(sentByHostPort);
                via.setTransport(this.getTransport());
            } 
            {
                Host host = new Host();
                host.setHostname(this.getIpAddress().getHostAddress());
                via.setHost(host);
                via.setPort(this.getPort());
                via.setTransport(this.getTransport());
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1144981846 = via;
        } 
        catch (ParseException ex)
        {
            ex.printStackTrace();
            varB4EAC82CA7396A68D541C85D26508E83_1705055286 = null;
        } 
        catch (InvalidArgumentException ex)
        {
            ex.printStackTrace();
            varB4EAC82CA7396A68D541C85D26508E83_1462656579 = null;
        } 
        Via varA7E53CE21691AB073D9660D615818899_375048728; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_375048728 = varB4EAC82CA7396A68D541C85D26508E83_1144981846;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_375048728 = varB4EAC82CA7396A68D541C85D26508E83_1705055286;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_375048728 = varB4EAC82CA7396A68D541C85D26508E83_1462656579;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_375048728.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_375048728;
        
        
            
            
                
                
            
                
                
                
                
                
            
            
        
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.580 -0400", hash_original_method = "07B7078D968B938E9AAFF4E32CB3E487", hash_generated_method = "CB5245AE089F9E9F1E176AA697946CB7")
    public ListeningPointImpl getListeningPoint() {
        ListeningPointImpl varB4EAC82CA7396A68D541C85D26508E83_1005609165 = null; 
        {
            {
                boolean var0D00EEF072457D493B1AF18D44D9D0D0_371306497 = (this.getSIPStack().isLoggingEnabled());
                {
                    this.getSIPStack().getStackLogger().logError("getListeningPoint" + this +
                        " returning null listeningpoint");
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1005609165 = listeningPoint;
        varB4EAC82CA7396A68D541C85D26508E83_1005609165.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1005609165;
        
        
            
                
                        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.581 -0400", hash_original_method = "0844D1EB645D6FF4A4D65C631732D7AB", hash_generated_method = "FE19C076DEE429DBB870D9387E43CB58")
    public void setListeningPoint(ListeningPointImpl lp) {
        {
            boolean varED9690FEDB0936871D62D9A315BD1F48_1703506607 = (this.getSIPStack().isLoggingEnabled());
            {
                this.getSIPStack().getStackLogger().logDebug("setListeningPoint" + this +
                    " listeningPoint = " + lp);
            } 
        } 
        {
            boolean varE557EE28FD2D56D7B63D62844AE72AAC_671279770 = (lp.getPort() != this.getPort());
            InternalErrorHandler.handleException
            ("lp mismatch with provider",getSIPStack().getStackLogger());
        } 
        this.listeningPoint = lp;
        
        
            
                    
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.582 -0400", hash_original_method = "63BE272C790EA048A7B52BA4EDD2764B", hash_generated_method = "42765B08A49AEA0A023926274286EC3C")
    public String getSavedIpAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_1084748205 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1084748205 = this.savedIpAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1084748205.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1084748205;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.582 -0400", hash_original_method = "884B07577FCFC9DD806F4641FDB0A38E", hash_generated_method = "1CEA4493752A0F78BDABF691B89D951C")
    public InetAddress getIpAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_80861339 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_80861339 = this.ipAddress;
        varB4EAC82CA7396A68D541C85D26508E83_80861339.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_80861339;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.583 -0400", hash_original_method = "B4AF9626210C81D85EEE89A64933E4EF", hash_generated_method = "C9A7808E9D2B0ECBB7A42CAB1AE9EBBB")
    protected void setIpAddress(InetAddress ipAddress) {
        this.sentByHostPort.setHost( new Host(ipAddress.getHostAddress()));
        this.ipAddress = ipAddress;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.584 -0400", hash_original_method = "032529AF3B126F26B3B81544F7F95DEA", hash_generated_method = "3575B5222439DC04FE0F0F9E65A432BA")
    public void setSentBy(String sentBy) throws ParseException {
        int ind = sentBy.indexOf(":");
        {
            this.sentByHostPort = new HostPort();
            this.sentByHostPort.setHost(new Host(sentBy));
        } 
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
                if (DroidSafeAndroidRuntime.control) throw new ParseException("Bad format encountered at ", ind);
            } 
        } 
        this.sentBySet = true;
        this.sentBy = sentBy;
        
        
        
            
            
        
            
            
            
            
                
                
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.586 -0400", hash_original_method = "F9F985C0AF39EB878B850CABB152BA50", hash_generated_method = "47897552066F8C323875F19CBABBEC4D")
    public String getSentBy() {
        String varB4EAC82CA7396A68D541C85D26508E83_314673085 = null; 
        {
            this.sentBy = this.sentByHostPort.toString();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_314673085 = this.sentBy;
        varB4EAC82CA7396A68D541C85D26508E83_314673085.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_314673085;
        
        
            
        
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.588 -0400", hash_original_method = "7D85FA3843A3F240694BBADD6AC174E2", hash_generated_method = "E9B7934991A7E77E343867E3CCF4E7ED")
    public boolean isSentBySet() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_273130917 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_273130917;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static int getDefaultPort(String transport) {
        return transport.equalsIgnoreCase("TLS")?5061:5060;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.588 -0400", hash_original_field = "B00F9FADF4204970C84368C656AF77CC", hash_generated_field = "EC70EA924951C1DB4898C0AB2F7FC7E1")

    protected static final String IN_ADDR_ANY = "0.0.0.0";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.588 -0400", hash_original_field = "648F89EB1D64275F1AF190105C1418E4", hash_generated_field = "6A0F9C0A61039F0F0A3EF8778E00F960")

    protected static final String IN6_ADDR_ANY = "::0";
}

