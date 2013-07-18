package gov.nist.javax.sip.stack;

// Droidsafe Imports
import gov.nist.core.Host;
import gov.nist.core.HostPort;
import gov.nist.core.InternalErrorHandler;
import gov.nist.javax.sip.ListeningPointImpl;
import gov.nist.javax.sip.header.Via;

import java.io.IOException;
import java.net.InetAddress;
import java.text.ParseException;

import javax.sip.InvalidArgumentException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class MessageProcessor implements Runnable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.610 -0400", hash_original_field = "93843F38363D24DFE376CC298A9F7B78", hash_generated_field = "3DC51267A61BBDF8C5A7E9BDABF1462E")

    private String sentBy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.610 -0400", hash_original_field = "F9560AA6AB99BBF0332940DD7B663FD3", hash_generated_field = "0389863D34D171A4FDB6F6AEC7FB1BFE")

    private HostPort sentByHostPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.611 -0400", hash_original_field = "E9A198A7A8EACAE094D3A3B40B88E396", hash_generated_field = "D4689216E9776FCD51A7A7F5BD10FEB0")

    private String savedIpAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.611 -0400", hash_original_field = "9D0DE3EE8DA929F164DA3D6942A26C0E", hash_generated_field = "1D1E2A819197300B0531B8BCDEEDBEFB")

    private InetAddress ipAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.611 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.611 -0400", hash_original_field = "7B334B7260361141659FA9862E803476", hash_generated_field = "B1CF55BB145913C3C7A70130704FABEE")

    protected String transport;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.611 -0400", hash_original_field = "8464C05A1C71DC453DF2370A527F688F", hash_generated_field = "D878E56BB6776849EDE70D4AD8553243")

    private ListeningPointImpl listeningPoint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.611 -0400", hash_original_field = "D15D2ED694D19F8DC9203DA930128F7F", hash_generated_field = "050A6FCEE8F9152C4D50D2695C900579")

    private boolean sentBySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.611 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "3233C5012C49C796F9D6BBC8E02EAB41")

    protected SIPTransactionStack sipStack;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.612 -0400", hash_original_method = "BC8F7D4E4A2ED3DFF02CD99DF0273205", hash_generated_method = "BE2224366E62DB88B879A0C9A552860C")
    protected  MessageProcessor( String transport ) {
        this.transport = transport;
        // ---------- Original Method ----------
        //this.transport = transport;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.613 -0400", hash_original_method = "2C4312BB27594DAC5B53740BCE61F76F", hash_generated_method = "96439D7A800DDD503CCF1F8D7FC1A559")
    protected  MessageProcessor( InetAddress ipAddress, int port, String transport,
    							SIPTransactionStack transactionStack ) {
        this( transport );
        addTaint(transactionStack.getTaint());
        addTaint(transport.getTaint());
        addTaint(port);
        addTaint(ipAddress.getTaint());
        this.initialize(ipAddress, port, transactionStack);
        // ---------- Original Method ----------
        //this.initialize(ipAddress, port, transactionStack);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.616 -0400", hash_original_method = "BB334E9937075E417D8A338E6797F33B", hash_generated_method = "ED29D178453B86BC05795D284108548D")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.616 -0400", hash_original_method = "22854860B4C916CC2FA65D60880C8F3F", hash_generated_method = "534748EDBA91896EDCE1E35203BA0F8C")
    public String getTransport() {
String var555A7CA0390490B84966DAB12A131C9F_340275504 =         this.transport;
        var555A7CA0390490B84966DAB12A131C9F_340275504.addTaint(taint);
        return var555A7CA0390490B84966DAB12A131C9F_340275504;
        // ---------- Original Method ----------
        //return this.transport;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.617 -0400", hash_original_method = "1804D4B8ED6914D43C8BF926A65BA4F9", hash_generated_method = "62CD3B8F8A2C0F4E3BE0ACFC7833ED3C")
    public int getPort() {
        int var02075052AFB1BA5EC4413B52BC401B14_1274702193 = (this.port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_70428190 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_70428190;
        // ---------- Original Method ----------
        //return this.port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.617 -0400", hash_original_method = "AEC88A1D2F84DB1C070CC4830A163BA9", hash_generated_method = "2C74B6F85A6F8B87301AD80925E20443")
    public Via getViaHeader() {
        try 
        {
            Via via = new Via();
            if(this.sentByHostPort != null)            
            {
                via.setSentBy(sentByHostPort);
                via.setTransport(this.getTransport());
            } //End block
            else
            {
                Host host = new Host();
                host.setHostname(this.getIpAddress().getHostAddress());
                via.setHost(host);
                via.setPort(this.getPort());
                via.setTransport(this.getTransport());
            } //End block
Via var744F9AD2C48AA2D9C877F464ADEF2D12_655432411 =             via;
            var744F9AD2C48AA2D9C877F464ADEF2D12_655432411.addTaint(taint);
            return var744F9AD2C48AA2D9C877F464ADEF2D12_655432411;
        } //End block
        catch (ParseException ex)
        {
            ex.printStackTrace();
Via var540C13E9E156B687226421B24F2DF178_1994139274 =             null;
            var540C13E9E156B687226421B24F2DF178_1994139274.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1994139274;
        } //End block
        catch (InvalidArgumentException ex)
        {
            ex.printStackTrace();
Via var540C13E9E156B687226421B24F2DF178_281996730 =             null;
            var540C13E9E156B687226421B24F2DF178_281996730.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_281996730;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.618 -0400", hash_original_method = "07B7078D968B938E9AAFF4E32CB3E487", hash_generated_method = "9D23B16034B1A13585DDAADAA7662021")
    public ListeningPointImpl getListeningPoint() {
        if(listeningPoint == null)        
        {
            if(this.getSIPStack().isLoggingEnabled())            
            {
                this.getSIPStack().getStackLogger().logError("getListeningPoint" + this +
                        " returning null listeningpoint");
            } //End block
        } //End block
ListeningPointImpl var28610F0C322E41C5E84A3628D8BE13E8_1466069242 =         listeningPoint;
        var28610F0C322E41C5E84A3628D8BE13E8_1466069242.addTaint(taint);
        return var28610F0C322E41C5E84A3628D8BE13E8_1466069242;
        // ---------- Original Method ----------
        //if ( listeningPoint == null )  {
            //if ( this.getSIPStack().isLoggingEnabled()) {
                //this.getSIPStack().getStackLogger().logError("getListeningPoint" + this +
                        //" returning null listeningpoint");
            //}
        //}
        //return listeningPoint;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.619 -0400", hash_original_method = "0844D1EB645D6FF4A4D65C631732D7AB", hash_generated_method = "BE7D682CAF040C429C211A38D46F6EF5")
    public void setListeningPoint(ListeningPointImpl lp) {
        if(this.getSIPStack().isLoggingEnabled())        
        {
            this.getSIPStack().getStackLogger().logDebug("setListeningPoint" + this +
                    " listeningPoint = " + lp);
        } //End block
        if(lp.getPort() != this.getPort())        
        InternalErrorHandler.handleException
            ("lp mismatch with provider",getSIPStack().getStackLogger());
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.620 -0400", hash_original_method = "63BE272C790EA048A7B52BA4EDD2764B", hash_generated_method = "7169447BED71E9DA674D675D6CE0043E")
    public String getSavedIpAddress() {
String var72F771F0BAA193F21ED628CB549B7B74_428899429 =         this.savedIpAddress;
        var72F771F0BAA193F21ED628CB549B7B74_428899429.addTaint(taint);
        return var72F771F0BAA193F21ED628CB549B7B74_428899429;
        // ---------- Original Method ----------
        //return this.savedIpAddress;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.620 -0400", hash_original_method = "884B07577FCFC9DD806F4641FDB0A38E", hash_generated_method = "18502A2157DDE9B85DC86C226AFA1A27")
    public InetAddress getIpAddress() {
InetAddress var021FE4BB5A9347AB07122A06261B0E87_372313169 =         this.ipAddress;
        var021FE4BB5A9347AB07122A06261B0E87_372313169.addTaint(taint);
        return var021FE4BB5A9347AB07122A06261B0E87_372313169;
        // ---------- Original Method ----------
        //return this.ipAddress;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.621 -0400", hash_original_method = "B4AF9626210C81D85EEE89A64933E4EF", hash_generated_method = "C9A7808E9D2B0ECBB7A42CAB1AE9EBBB")
    protected void setIpAddress(InetAddress ipAddress) {
        this.sentByHostPort.setHost( new Host(ipAddress.getHostAddress()));
        this.ipAddress = ipAddress;
        // ---------- Original Method ----------
        //this.sentByHostPort.setHost( new Host(ipAddress.getHostAddress()));
        //this.ipAddress = ipAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.623 -0400", hash_original_method = "032529AF3B126F26B3B81544F7F95DEA", hash_generated_method = "D6A0D5C44801FC1CFAB02F966CC1B13F")
    public void setSentBy(String sentBy) throws ParseException {
        int ind = sentBy.indexOf(":");
        if(ind == -1)        
        {
            this.sentByHostPort = new HostPort();
            this.sentByHostPort.setHost(new Host(sentBy));
        } //End block
        else
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
                ParseException var27520CD594AB9B9D41EE218A7505B68E_1489333813 = new ParseException("Bad format encountered at ", ind);
                var27520CD594AB9B9D41EE218A7505B68E_1489333813.addTaint(taint);
                throw var27520CD594AB9B9D41EE218A7505B68E_1489333813;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.624 -0400", hash_original_method = "F9F985C0AF39EB878B850CABB152BA50", hash_generated_method = "7FF7DC86B479AD086171E2F60DD492D8")
    public String getSentBy() {
        if(this.sentBy == null && this.sentByHostPort != null)        
        {
            this.sentBy = this.sentByHostPort.toString();
        } //End block
String varD51D88094686E0D480B6E2DDA4DFBAA7_1285420835 =         this.sentBy;
        varD51D88094686E0D480B6E2DDA4DFBAA7_1285420835.addTaint(taint);
        return varD51D88094686E0D480B6E2DDA4DFBAA7_1285420835;
        // ---------- Original Method ----------
        //if ( this.sentBy == null && this.sentByHostPort != null) {
            //this.sentBy = this.sentByHostPort.toString();
        //}
        //return this.sentBy;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract SIPTransactionStack getSIPStack();

    
    @DSModeled(DSC.SAFE)
    public abstract MessageChannel createMessageChannel(HostPort targetHostPort)
            throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract MessageChannel createMessageChannel(InetAddress targetHost,
            int port) throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract void start() throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract void stop();

    
    @DSModeled(DSC.SAFE)
    public abstract int getDefaultTargetPort();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isSecure();

    
    @DSModeled(DSC.SAFE)
    public abstract int getMaximumMessageSize();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean inUse();

    
    @DSModeled(DSC.SAFE)
    public abstract void run();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.628 -0400", hash_original_method = "7D85FA3843A3F240694BBADD6AC174E2", hash_generated_method = "574FA06C518884675E7629808E79F1A2")
    public boolean isSentBySet() {
        boolean varD15D2ED694D19F8DC9203DA930128F7F_90649449 = (sentBySet);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2119382856 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2119382856;
        // ---------- Original Method ----------
        //return sentBySet;
    }

    
    @DSModeled(DSC.SAFE)
    public static int getDefaultPort(String transport) {
        return transport.equalsIgnoreCase("TLS")?5061:5060;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.628 -0400", hash_original_field = "B00F9FADF4204970C84368C656AF77CC", hash_generated_field = "EC70EA924951C1DB4898C0AB2F7FC7E1")

    protected static final String IN_ADDR_ANY = "0.0.0.0";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.628 -0400", hash_original_field = "648F89EB1D64275F1AF190105C1418E4", hash_generated_field = "6A0F9C0A61039F0F0A3EF8778E00F960")

    protected static final String IN6_ADDR_ANY = "::0";
}

