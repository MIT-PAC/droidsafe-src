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
    private String sentBy;
    private HostPort sentByHostPort;
    private String savedIpAddress;
    private InetAddress ipAddress;
    private int port;
    protected String transport;
    private ListeningPointImpl listeningPoint;
    private boolean sentBySet;
    protected SIPTransactionStack sipStack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.968 -0400", hash_original_method = "BC8F7D4E4A2ED3DFF02CD99DF0273205", hash_generated_method = "2EC6BF3CD29544C2A89DEB32CA641318")
    @DSModeled(DSC.SAFE)
    protected MessageProcessor( String transport ) {
        dsTaint.addTaint(transport);
        // ---------- Original Method ----------
        //this.transport = transport;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.968 -0400", hash_original_method = "2C4312BB27594DAC5B53740BCE61F76F", hash_generated_method = "F4C0ABD3E7389C0E97B3D1D882507632")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected MessageProcessor( InetAddress ipAddress, int port, String transport,
    							SIPTransactionStack transactionStack ) {
        this( transport );
        dsTaint.addTaint(port);
        dsTaint.addTaint(transactionStack.dsTaint);
        dsTaint.addTaint(transport);
        dsTaint.addTaint(ipAddress.dsTaint);
        this.initialize(ipAddress, port, transactionStack);
        // ---------- Original Method ----------
        //this.initialize(ipAddress, port, transactionStack);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.969 -0400", hash_original_method = "BB334E9937075E417D8A338E6797F33B", hash_generated_method = "F3F95115628B80B77F1C05A557C0950F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void initialize( InetAddress ipAddress, int port,
			SIPTransactionStack transactionStack ) {
        dsTaint.addTaint(port);
        dsTaint.addTaint(transactionStack.dsTaint);
        dsTaint.addTaint(ipAddress.dsTaint);
        this.savedIpAddress = ipAddress.getHostAddress();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.969 -0400", hash_original_method = "22854860B4C916CC2FA65D60880C8F3F", hash_generated_method = "72C24F49D81FA1CF533E0F7E947A1969")
    @DSModeled(DSC.SAFE)
    public String getTransport() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.transport;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.969 -0400", hash_original_method = "1804D4B8ED6914D43C8BF926A65BA4F9", hash_generated_method = "4021B087F2BB6C57EEDF3334B742310D")
    @DSModeled(DSC.SAFE)
    public int getPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.969 -0400", hash_original_method = "AEC88A1D2F84DB1C070CC4830A163BA9", hash_generated_method = "DFAF0730BADD374FC11DC30D9A544E0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Via getViaHeader() {
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
        } //End block
        catch (ParseException ex)
        {
            ex.printStackTrace();
        } //End block
        catch (InvalidArgumentException ex)
        {
            ex.printStackTrace();
        } //End block
        return (Via)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.970 -0400", hash_original_method = "07B7078D968B938E9AAFF4E32CB3E487", hash_generated_method = "C94DB976DDD10671A255E6AFEA18F8E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ListeningPointImpl getListeningPoint() {
        {
            {
                boolean var0D00EEF072457D493B1AF18D44D9D0D0_1059400456 = (this.getSIPStack().isLoggingEnabled());
                {
                    this.getSIPStack().getStackLogger().logError("getListeningPoint" + this +
                        " returning null listeningpoint");
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (ListeningPointImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if ( listeningPoint == null )  {
            //if ( this.getSIPStack().isLoggingEnabled()) {
                //this.getSIPStack().getStackLogger().logError("getListeningPoint" + this +
                        //" returning null listeningpoint");
            //}
        //}
        //return listeningPoint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.970 -0400", hash_original_method = "0844D1EB645D6FF4A4D65C631732D7AB", hash_generated_method = "14BD2A662B4B18148B7238F75A0CFC64")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setListeningPoint(ListeningPointImpl lp) {
        dsTaint.addTaint(lp.dsTaint);
        {
            boolean varED9690FEDB0936871D62D9A315BD1F48_1613710942 = (this.getSIPStack().isLoggingEnabled());
            {
                this.getSIPStack().getStackLogger().logDebug("setListeningPoint" + this +
                    " listeningPoint = " + lp);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varE557EE28FD2D56D7B63D62844AE72AAC_774449103 = (lp.getPort() != this.getPort());
            InternalErrorHandler.handleException
            ("lp mismatch with provider",getSIPStack().getStackLogger());
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.970 -0400", hash_original_method = "63BE272C790EA048A7B52BA4EDD2764B", hash_generated_method = "27BF22120128B925784099922A3492F7")
    @DSModeled(DSC.SAFE)
    public String getSavedIpAddress() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.savedIpAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.970 -0400", hash_original_method = "884B07577FCFC9DD806F4641FDB0A38E", hash_generated_method = "02016CF4CC3284F61678503B2AEEC6F2")
    @DSModeled(DSC.SAFE)
    public InetAddress getIpAddress() {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.ipAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.970 -0400", hash_original_method = "B4AF9626210C81D85EEE89A64933E4EF", hash_generated_method = "CE9D013C99C253A7EDBD8D0CAC4617CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void setIpAddress(InetAddress ipAddress) {
        dsTaint.addTaint(ipAddress.dsTaint);
        this.sentByHostPort.setHost( new Host(ipAddress.getHostAddress()));
        // ---------- Original Method ----------
        //this.sentByHostPort.setHost( new Host(ipAddress.getHostAddress()));
        //this.ipAddress = ipAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.971 -0400", hash_original_method = "032529AF3B126F26B3B81544F7F95DEA", hash_generated_method = "6D9F4A75CC770670C9E2EBD5563DC33D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSentBy(String sentBy) throws ParseException {
        dsTaint.addTaint(sentBy);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.971 -0400", hash_original_method = "F9F985C0AF39EB878B850CABB152BA50", hash_generated_method = "46C217B6BACF7303B0E8E848E1A03E3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSentBy() {
        {
            this.sentBy = this.sentByHostPort.toString();
        } //End block
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.972 -0400", hash_original_method = "7D85FA3843A3F240694BBADD6AC174E2", hash_generated_method = "77F30671E86B2364B1074EE2D35C8C3D")
    @DSModeled(DSC.SAFE)
    public boolean isSentBySet() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sentBySet;
    }

    
        public static int getDefaultPort(String transport) {
        return transport.equalsIgnoreCase("TLS")?5061:5060;
    }

    
    protected static final String IN_ADDR_ANY = "0.0.0.0";
    protected static final String IN6_ADDR_ANY = "::0";
}

