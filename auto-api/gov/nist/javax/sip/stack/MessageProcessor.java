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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.945 -0400", hash_original_field = "93843F38363D24DFE376CC298A9F7B78", hash_generated_field = "3DC51267A61BBDF8C5A7E9BDABF1462E")

    private String sentBy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.945 -0400", hash_original_field = "F9560AA6AB99BBF0332940DD7B663FD3", hash_generated_field = "0389863D34D171A4FDB6F6AEC7FB1BFE")

    private HostPort sentByHostPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.945 -0400", hash_original_field = "E9A198A7A8EACAE094D3A3B40B88E396", hash_generated_field = "D4689216E9776FCD51A7A7F5BD10FEB0")

    private String savedIpAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.945 -0400", hash_original_field = "9D0DE3EE8DA929F164DA3D6942A26C0E", hash_generated_field = "1D1E2A819197300B0531B8BCDEEDBEFB")

    private InetAddress ipAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.945 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.945 -0400", hash_original_field = "7B334B7260361141659FA9862E803476", hash_generated_field = "B1CF55BB145913C3C7A70130704FABEE")

    protected String transport;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.950 -0400", hash_original_field = "8464C05A1C71DC453DF2370A527F688F", hash_generated_field = "D878E56BB6776849EDE70D4AD8553243")

    private ListeningPointImpl listeningPoint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.951 -0400", hash_original_field = "D15D2ED694D19F8DC9203DA930128F7F", hash_generated_field = "050A6FCEE8F9152C4D50D2695C900579")

    private boolean sentBySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.951 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "3233C5012C49C796F9D6BBC8E02EAB41")

    protected SIPTransactionStack sipStack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.954 -0400", hash_original_method = "BC8F7D4E4A2ED3DFF02CD99DF0273205", hash_generated_method = "BE2224366E62DB88B879A0C9A552860C")
    protected  MessageProcessor( String transport ) {
        this.transport = transport;
        // ---------- Original Method ----------
        //this.transport = transport;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.962 -0400", hash_original_method = "2C4312BB27594DAC5B53740BCE61F76F", hash_generated_method = "2DB3EFDB8B8F3873191B368235F9B1A8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.963 -0400", hash_original_method = "BB334E9937075E417D8A338E6797F33B", hash_generated_method = "ED29D178453B86BC05795D284108548D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.964 -0400", hash_original_method = "22854860B4C916CC2FA65D60880C8F3F", hash_generated_method = "BFC7DA83AE8BAF33F4B7B61610D7D0DA")
    public String getTransport() {
        String varB4EAC82CA7396A68D541C85D26508E83_504266537 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_504266537 = this.transport;
        varB4EAC82CA7396A68D541C85D26508E83_504266537.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_504266537;
        // ---------- Original Method ----------
        //return this.transport;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.964 -0400", hash_original_method = "1804D4B8ED6914D43C8BF926A65BA4F9", hash_generated_method = "6F8BD65A766950238E192C23AE792764")
    public int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_552049265 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_552049265;
        // ---------- Original Method ----------
        //return this.port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.968 -0400", hash_original_method = "AEC88A1D2F84DB1C070CC4830A163BA9", hash_generated_method = "4846AA390A0D9B38296F66D6EA8417A6")
    public Via getViaHeader() {
        Via varB4EAC82CA7396A68D541C85D26508E83_1631900273 = null; //Variable for return #1
        Via varB4EAC82CA7396A68D541C85D26508E83_1909309347 = null; //Variable for return #2
        Via varB4EAC82CA7396A68D541C85D26508E83_10383643 = null; //Variable for return #3
        try 
        {
            Via via;
            via = new Via();
            {
                via.setSentBy(sentByHostPort);
                via.setTransport(this.getTransport());
            } //End block
            {
                Host host;
                host = new Host();
                host.setHostname(this.getIpAddress().getHostAddress());
                via.setHost(host);
                via.setPort(this.getPort());
                via.setTransport(this.getTransport());
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1631900273 = via;
        } //End block
        catch (ParseException ex)
        {
            ex.printStackTrace();
            varB4EAC82CA7396A68D541C85D26508E83_1909309347 = null;
        } //End block
        catch (InvalidArgumentException ex)
        {
            ex.printStackTrace();
            varB4EAC82CA7396A68D541C85D26508E83_10383643 = null;
        } //End block
        Via varA7E53CE21691AB073D9660D615818899_1132568398; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1132568398 = varB4EAC82CA7396A68D541C85D26508E83_1631900273;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1132568398 = varB4EAC82CA7396A68D541C85D26508E83_1909309347;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1132568398 = varB4EAC82CA7396A68D541C85D26508E83_10383643;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1132568398.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1132568398;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.976 -0400", hash_original_method = "07B7078D968B938E9AAFF4E32CB3E487", hash_generated_method = "06F28D8289936A93F1D7E76D990B81F1")
    public ListeningPointImpl getListeningPoint() {
        ListeningPointImpl varB4EAC82CA7396A68D541C85D26508E83_1277773923 = null; //Variable for return #1
        {
            {
                boolean var0D00EEF072457D493B1AF18D44D9D0D0_1940063486 = (this.getSIPStack().isLoggingEnabled());
                {
                    this.getSIPStack().getStackLogger().logError("getListeningPoint" + this +
                        " returning null listeningpoint");
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1277773923 = listeningPoint;
        varB4EAC82CA7396A68D541C85D26508E83_1277773923.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1277773923;
        // ---------- Original Method ----------
        //if ( listeningPoint == null )  {
            //if ( this.getSIPStack().isLoggingEnabled()) {
                //this.getSIPStack().getStackLogger().logError("getListeningPoint" + this +
                        //" returning null listeningpoint");
            //}
        //}
        //return listeningPoint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.976 -0400", hash_original_method = "0844D1EB645D6FF4A4D65C631732D7AB", hash_generated_method = "93DBDCA2F817E322774ADA9633BF859D")
    public void setListeningPoint(ListeningPointImpl lp) {
        {
            boolean varED9690FEDB0936871D62D9A315BD1F48_1595894853 = (this.getSIPStack().isLoggingEnabled());
            {
                this.getSIPStack().getStackLogger().logDebug("setListeningPoint" + this +
                    " listeningPoint = " + lp);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varE557EE28FD2D56D7B63D62844AE72AAC_370122975 = (lp.getPort() != this.getPort());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.991 -0400", hash_original_method = "63BE272C790EA048A7B52BA4EDD2764B", hash_generated_method = "7BFAE4F6CF6765F07559CBB1F80780C7")
    public String getSavedIpAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_1324487199 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1324487199 = this.savedIpAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1324487199.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1324487199;
        // ---------- Original Method ----------
        //return this.savedIpAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.991 -0400", hash_original_method = "884B07577FCFC9DD806F4641FDB0A38E", hash_generated_method = "D265453EABE2BA01124D510B08D8E3E7")
    public InetAddress getIpAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_723101049 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_723101049 = this.ipAddress;
        varB4EAC82CA7396A68D541C85D26508E83_723101049.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_723101049;
        // ---------- Original Method ----------
        //return this.ipAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.992 -0400", hash_original_method = "B4AF9626210C81D85EEE89A64933E4EF", hash_generated_method = "C9A7808E9D2B0ECBB7A42CAB1AE9EBBB")
    protected void setIpAddress(InetAddress ipAddress) {
        this.sentByHostPort.setHost( new Host(ipAddress.getHostAddress()));
        this.ipAddress = ipAddress;
        // ---------- Original Method ----------
        //this.sentByHostPort.setHost( new Host(ipAddress.getHostAddress()));
        //this.ipAddress = ipAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.993 -0400", hash_original_method = "032529AF3B126F26B3B81544F7F95DEA", hash_generated_method = "BC6FF5F6BA4E24CB98CE66B400566DA4")
    public void setSentBy(String sentBy) throws ParseException {
        int ind;
        ind = sentBy.indexOf(":");
        {
            this.sentByHostPort = new HostPort();
            this.sentByHostPort.setHost(new Host(sentBy));
        } //End block
        {
            this.sentByHostPort = new HostPort();
            this.sentByHostPort.setHost(new Host(sentBy.substring(0, ind)));
            String portStr;
            portStr = sentBy.substring(ind + 1);
            try 
            {
                int port;
                port = Integer.parseInt(portStr);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.009 -0400", hash_original_method = "F9F985C0AF39EB878B850CABB152BA50", hash_generated_method = "ED0FBB50DE432D38645298FA8F770E3F")
    public String getSentBy() {
        String varB4EAC82CA7396A68D541C85D26508E83_1963430879 = null; //Variable for return #1
        {
            this.sentBy = this.sentByHostPort.toString();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1963430879 = this.sentBy;
        varB4EAC82CA7396A68D541C85D26508E83_1963430879.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1963430879;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.011 -0400", hash_original_method = "7D85FA3843A3F240694BBADD6AC174E2", hash_generated_method = "C77DEFCAD1B99AEDD5CFB486ACAD60B1")
    public boolean isSentBySet() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_711659814 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_711659814;
        // ---------- Original Method ----------
        //return sentBySet;
    }

    
        public static int getDefaultPort(String transport) {
        return transport.equalsIgnoreCase("TLS")?5061:5060;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.011 -0400", hash_original_field = "B00F9FADF4204970C84368C656AF77CC", hash_generated_field = "38CB931B2F71F8E34C6A7D3131B0B0F7")

    protected static String IN_ADDR_ANY = "0.0.0.0";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.011 -0400", hash_original_field = "648F89EB1D64275F1AF190105C1418E4", hash_generated_field = "8137CDB94411B9BC98AF9EBD474D2933")

    protected static String IN6_ADDR_ANY = "::0";
}

