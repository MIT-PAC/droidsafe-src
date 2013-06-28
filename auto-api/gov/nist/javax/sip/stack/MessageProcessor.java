package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
        // ---------- Original Method ----------
        //this.transport = transport;
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
        // ---------- Original Method ----------
        //this.initialize(ipAddress, port, transactionStack);
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
        // ---------- Original Method ----------
        //this.sipStack = transactionStack;
        //this.savedIpAddress = ipAddress.getHostAddress();
        //this.ipAddress = ipAddress;
        //this.port = port;
        //this.sentByHostPort = new HostPort();
        //this.sentByHostPort.setHost(new Host(ipAddress.getHostAddress()));
        //this.sentByHostPort.setPort(port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.573 -0400", hash_original_method = "22854860B4C916CC2FA65D60880C8F3F", hash_generated_method = "EF20F41FE2E68D9576042D0A0357DCD3")
    public String getTransport() {
        String varB4EAC82CA7396A68D541C85D26508E83_2099073110 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2099073110 = this.transport;
        varB4EAC82CA7396A68D541C85D26508E83_2099073110.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2099073110;
        // ---------- Original Method ----------
        //return this.transport;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.576 -0400", hash_original_method = "1804D4B8ED6914D43C8BF926A65BA4F9", hash_generated_method = "7B533E91F80DD36260B09CD44598E7AB")
    public int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1259533268 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1259533268;
        // ---------- Original Method ----------
        //return this.port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.579 -0400", hash_original_method = "AEC88A1D2F84DB1C070CC4830A163BA9", hash_generated_method = "3AE5D6E863F0559961ECF91E86A1B36B")
    public Via getViaHeader() {
        Via varB4EAC82CA7396A68D541C85D26508E83_1144981846 = null; //Variable for return #1
        Via varB4EAC82CA7396A68D541C85D26508E83_1705055286 = null; //Variable for return #2
        Via varB4EAC82CA7396A68D541C85D26508E83_1462656579 = null; //Variable for return #3
        try 
        {
            Via via = new Via();
            {
                via.setSentBy(sentByHostPort);
                via.setTransport(this.getTransport());
            } //End block
            {
                Host host = new Host();
                host.setHostname(this.getIpAddress().getHostAddress());
                via.setHost(host);
                via.setPort(this.getPort());
                via.setTransport(this.getTransport());
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1144981846 = via;
        } //End block
        catch (ParseException ex)
        {
            ex.printStackTrace();
            varB4EAC82CA7396A68D541C85D26508E83_1705055286 = null;
        } //End block
        catch (InvalidArgumentException ex)
        {
            ex.printStackTrace();
            varB4EAC82CA7396A68D541C85D26508E83_1462656579 = null;
        } //End block
        Via varA7E53CE21691AB073D9660D615818899_375048728; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_375048728 = varB4EAC82CA7396A68D541C85D26508E83_1144981846;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_375048728 = varB4EAC82CA7396A68D541C85D26508E83_1705055286;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_375048728 = varB4EAC82CA7396A68D541C85D26508E83_1462656579;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_375048728.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_375048728;
        // ---------- Original Method ----------
        //try {
            //Via via = new Via();
            //if (this.sentByHostPort != null) {
                //via.setSentBy(sentByHostPort);
                //via.setTransport(this.getTransport());
            //} else {
                //Host host = new Host();
                //host.setHostname(this.getIpAddress().getHostAddress());
                //via.setHost(host);
                //via.setPort(this.getPort());
                //via.setTransport(this.getTransport());
            //}
            //return via;
        //} catch (ParseException ex) {
            //ex.printStackTrace();
            //return null;
        //} catch (InvalidArgumentException ex) {
            //ex.printStackTrace();
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.580 -0400", hash_original_method = "07B7078D968B938E9AAFF4E32CB3E487", hash_generated_method = "CB5245AE089F9E9F1E176AA697946CB7")
    public ListeningPointImpl getListeningPoint() {
        ListeningPointImpl varB4EAC82CA7396A68D541C85D26508E83_1005609165 = null; //Variable for return #1
        {
            {
                boolean var0D00EEF072457D493B1AF18D44D9D0D0_371306497 = (this.getSIPStack().isLoggingEnabled());
                {
                    this.getSIPStack().getStackLogger().logError("getListeningPoint" + this +
                        " returning null listeningpoint");
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1005609165 = listeningPoint;
        varB4EAC82CA7396A68D541C85D26508E83_1005609165.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1005609165;
        // ---------- Original Method ----------
        //if ( listeningPoint == null )  {
            //if ( this.getSIPStack().isLoggingEnabled()) {
                //this.getSIPStack().getStackLogger().logError("getListeningPoint" + this +
                        //" returning null listeningpoint");
            //}
        //}
        //return listeningPoint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.581 -0400", hash_original_method = "0844D1EB645D6FF4A4D65C631732D7AB", hash_generated_method = "FE19C076DEE429DBB870D9387E43CB58")
    public void setListeningPoint(ListeningPointImpl lp) {
        {
            boolean varED9690FEDB0936871D62D9A315BD1F48_1703506607 = (this.getSIPStack().isLoggingEnabled());
            {
                this.getSIPStack().getStackLogger().logDebug("setListeningPoint" + this +
                    " listeningPoint = " + lp);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varE557EE28FD2D56D7B63D62844AE72AAC_671279770 = (lp.getPort() != this.getPort());
            InternalErrorHandler.handleException
            ("lp mismatch with provider",getSIPStack().getStackLogger());
        } //End collapsed parenthetic
        this.listeningPoint = lp;
        // ---------- Original Method ----------
        //if ( this.getSIPStack().isLoggingEnabled()) {
            //this.getSIPStack().getStackLogger().logDebug("setListeningPoint" + this +
                    //" listeningPoint = " + lp);
        //}
        //if ( lp.getPort() != this.getPort())
            //InternalErrorHandler.handleException
            //("lp mismatch with provider",getSIPStack().getStackLogger());
        //this.listeningPoint = lp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.582 -0400", hash_original_method = "63BE272C790EA048A7B52BA4EDD2764B", hash_generated_method = "42765B08A49AEA0A023926274286EC3C")
    public String getSavedIpAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_1084748205 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1084748205 = this.savedIpAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1084748205.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1084748205;
        // ---------- Original Method ----------
        //return this.savedIpAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.582 -0400", hash_original_method = "884B07577FCFC9DD806F4641FDB0A38E", hash_generated_method = "1CEA4493752A0F78BDABF691B89D951C")
    public InetAddress getIpAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_80861339 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_80861339 = this.ipAddress;
        varB4EAC82CA7396A68D541C85D26508E83_80861339.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_80861339;
        // ---------- Original Method ----------
        //return this.ipAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.583 -0400", hash_original_method = "B4AF9626210C81D85EEE89A64933E4EF", hash_generated_method = "C9A7808E9D2B0ECBB7A42CAB1AE9EBBB")
    protected void setIpAddress(InetAddress ipAddress) {
        this.sentByHostPort.setHost( new Host(ipAddress.getHostAddress()));
        this.ipAddress = ipAddress;
        // ---------- Original Method ----------
        //this.sentByHostPort.setHost( new Host(ipAddress.getHostAddress()));
        //this.ipAddress = ipAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.584 -0400", hash_original_method = "032529AF3B126F26B3B81544F7F95DEA", hash_generated_method = "3575B5222439DC04FE0F0F9E65A432BA")
    public void setSentBy(String sentBy) throws ParseException {
        int ind = sentBy.indexOf(":");
        {
            this.sentByHostPort = new HostPort();
            this.sentByHostPort.setHost(new Host(sentBy));
        } //End block
        {
            this.sentByHostPort = new HostPort();
            this.sentByHostPort.setHost(new Host(sentBy.substring(0, ind)));
            String portStr = sentBy.substring(ind + 1);
            try 
            {
                int port = Integer.parseInt(portStr);
                this.sentByHostPort.setPort(port);
            } //End block
            catch (NumberFormatException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException("Bad format encountered at ", ind);
            } //End block
        } //End block
        this.sentBySet = true;
        this.sentBy = sentBy;
        // ---------- Original Method ----------
        //int ind = sentBy.indexOf(":");
        //if (ind == -1) {
            //this.sentByHostPort = new HostPort();
            //this.sentByHostPort.setHost(new Host(sentBy));
        //} else {
            //this.sentByHostPort = new HostPort();
            //this.sentByHostPort.setHost(new Host(sentBy.substring(0, ind)));
            //String portStr = sentBy.substring(ind + 1);
            //try {
                //int port = Integer.parseInt(portStr);
                //this.sentByHostPort.setPort(port);
            //} catch (NumberFormatException ex) {
                //throw new ParseException("Bad format encountered at ", ind);
            //}
        //}
        //this.sentBySet = true;
        //this.sentBy = sentBy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.586 -0400", hash_original_method = "F9F985C0AF39EB878B850CABB152BA50", hash_generated_method = "47897552066F8C323875F19CBABBEC4D")
    public String getSentBy() {
        String varB4EAC82CA7396A68D541C85D26508E83_314673085 = null; //Variable for return #1
        {
            this.sentBy = this.sentByHostPort.toString();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_314673085 = this.sentBy;
        varB4EAC82CA7396A68D541C85D26508E83_314673085.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_314673085;
        // ---------- Original Method ----------
        //if ( this.sentBy == null && this.sentByHostPort != null) {
            //this.sentBy = this.sentByHostPort.toString();
        //}
        //return this.sentBy;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.588 -0400", hash_original_method = "7D85FA3843A3F240694BBADD6AC174E2", hash_generated_method = "E9B7934991A7E77E343867E3CCF4E7ED")
    public boolean isSentBySet() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_273130917 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_273130917;
        // ---------- Original Method ----------
        //return sentBySet;
    }

    
    public static int getDefaultPort(String transport) {
        return transport.equalsIgnoreCase("TLS")?5061:5060;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.588 -0400", hash_original_field = "B00F9FADF4204970C84368C656AF77CC", hash_generated_field = "EC70EA924951C1DB4898C0AB2F7FC7E1")

    protected static final String IN_ADDR_ANY = "0.0.0.0";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.588 -0400", hash_original_field = "648F89EB1D64275F1AF190105C1418E4", hash_generated_field = "6A0F9C0A61039F0F0A3EF8778E00F960")

    protected static final String IN6_ADDR_ANY = "::0";
}

