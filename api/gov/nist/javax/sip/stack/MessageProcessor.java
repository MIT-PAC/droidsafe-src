package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

    /**
     * Get the defalt port for the message processor.
     *
     * @param transport
     * @return -- the default port for the message processor.
     */

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.340 -0500", hash_original_method = "CEB44D65B48928437F2F9165DF46B2EE", hash_generated_method = "52AC30657166B77505FDDD66C3BBEB30")
    
public static int getDefaultPort(String transport) {

        return transport.equalsIgnoreCase("TLS")?5061:5060;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.237 -0500", hash_original_field = "E77F599D412730F7E89A35BDDF26B766", hash_generated_field = "EC70EA924951C1DB4898C0AB2F7FC7E1")

    protected static final String IN_ADDR_ANY = "0.0.0.0";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.240 -0500", hash_original_field = "3E13EA3A3AA8CC4DBCB79791EC08A63A", hash_generated_field = "6A0F9C0A61039F0F0A3EF8778E00F960")

    protected static final String IN6_ADDR_ANY = "::0";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.243 -0500", hash_original_field = "5710AD87D31089AC11A4787E69579931", hash_generated_field = "3DC51267A61BBDF8C5A7E9BDABF1462E")

    private  String sentBy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.246 -0500", hash_original_field = "AA28DDF9D08AB1F93F93F5CFD4ACD412", hash_generated_field = "0389863D34D171A4FDB6F6AEC7FB1BFE")

    private HostPort sentByHostPort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.249 -0500", hash_original_field = "39D45BA15FCBEA8F598563FEEBD46668", hash_generated_field = "D4689216E9776FCD51A7A7F5BD10FEB0")

    private String savedIpAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.252 -0500", hash_original_field = "BC151397D94B861E0C2BD62E73C6EFD9", hash_generated_field = "1D1E2A819197300B0531B8BCDEEDBEFB")

    private InetAddress ipAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.254 -0500", hash_original_field = "5A948EF636511EF149269A68FE278AED", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private int port;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.257 -0500", hash_original_field = "852FD1938B4FCA59C0635E9D670A8D0B", hash_generated_field = "B1CF55BB145913C3C7A70130704FABEE")

    protected String transport;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.260 -0500", hash_original_field = "886D2BC0241587EE779F16016F69799C", hash_generated_field = "D878E56BB6776849EDE70D4AD8553243")

    private ListeningPointImpl listeningPoint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.263 -0500", hash_original_field = "C4FB79304611630FA5226732F4B73A23", hash_generated_field = "050A6FCEE8F9152C4D50D2695C900579")

    private boolean sentBySet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.266 -0500", hash_original_field = "A4B05DD1A2BDFAA2E8FCD10E8D1815B6", hash_generated_field = "3233C5012C49C796F9D6BBC8E02EAB41")

    protected SIPTransactionStack sipStack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.269 -0500", hash_original_method = "BC8F7D4E4A2ED3DFF02CD99DF0273205", hash_generated_method = "14958796E868E3A5D70275B5E883C23E")
    
protected MessageProcessor( String transport ) {
    	this.transport = transport;
    }
    
    /**
     * Constructor
     *
     * @param ipAddress -- ip address where I am listening for incoming requests.
     * @param port -- port where i am listening for incoming requests.
     * @param transport -- transport to use for the message processor (UDP/TCP/TLS).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.272 -0500", hash_original_method = "2C4312BB27594DAC5B53740BCE61F76F", hash_generated_method = "B2CBCE925B8BEE5C36F3A978DF99167C")
    
protected MessageProcessor( InetAddress ipAddress, int port, String transport,
    							SIPTransactionStack transactionStack ) {
    	this( transport );
    	this.initialize(ipAddress, port, transactionStack);
    }

    /**
     * Initializes this MessageProcessor. Needed for extensions
     * that use classloading
     * 
     * @param ipAddress2
     * @param transactionStack
     * @param port2
     */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.276 -0500", hash_original_method = "BB334E9937075E417D8A338E6797F33B", hash_generated_method = "17B6466788C24A6DB52DDFBF58D6844B")
    
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
    
    /**
     * Get the transport string.
     *
     * @return A string that indicates the transport. (i.e. "tcp" or "udp")
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.278 -0500", hash_original_method = "22854860B4C916CC2FA65D60880C8F3F", hash_generated_method = "C7D1390C22AED7EDC4ABACA60A1EB850")
    
public String getTransport() {
        return this.transport;
    }

    /**
     * Get the port identifier.
     *
     * @return the port for this message processor. This is where you receive
     *         messages.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.281 -0500", hash_original_method = "1804D4B8ED6914D43C8BF926A65BA4F9", hash_generated_method = "2827709310D4A6354CC4E0B95B5C1D5F")
    
public int getPort() {
        return this.port;
    }

    /**
     * Get the Via header to assign for this message processor. The topmost via
     * header of the outoging messages use this.
     *
     * @return the ViaHeader to be used by the messages sent via this message processor.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.284 -0500", hash_original_method = "AEC88A1D2F84DB1C070CC4830A163BA9", hash_generated_method = "0B76E0D1C27BE633B3BAB70BC1580C7F")
    
public Via getViaHeader() {
        try {
            Via via = new Via();
            if (this.sentByHostPort != null) {
                via.setSentBy(sentByHostPort);
                via.setTransport(this.getTransport());
            } else {
                Host host = new Host();
                host.setHostname(this.getIpAddress().getHostAddress());
                via.setHost(host);
                via.setPort(this.getPort());
                via.setTransport(this.getTransport());
            }
            return via;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        } catch (InvalidArgumentException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.287 -0500", hash_original_method = "07B7078D968B938E9AAFF4E32CB3E487", hash_generated_method = "CAF6A0E6AC7FE8490CA9689348E13F17")
    
public ListeningPointImpl getListeningPoint() {
        if ( listeningPoint == null )  {
            if ( this.getSIPStack().isLoggingEnabled()) {
                this.getSIPStack().getStackLogger().logError("getListeningPoint" + this +
                        " returning null listeningpoint");

            }
        }
        return listeningPoint;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.290 -0500", hash_original_method = "0844D1EB645D6FF4A4D65C631732D7AB", hash_generated_method = "9B96ED759641275E8540E03A741109C9")
    
public void setListeningPoint(ListeningPointImpl lp) {
        if ( this.getSIPStack().isLoggingEnabled()) {
            this.getSIPStack().getStackLogger().logDebug("setListeningPoint" + this +
                    " listeningPoint = " + lp);

        }
        if ( lp.getPort() != this.getPort())
            InternalErrorHandler.handleException
            ("lp mismatch with provider",getSIPStack().getStackLogger());
        this.listeningPoint = lp;

    }

    /**
     * Get the saved IP Address.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.293 -0500", hash_original_method = "63BE272C790EA048A7B52BA4EDD2764B", hash_generated_method = "06F54A15A50154BFDA2C4FEF9307261E")
    
public String getSavedIpAddress() {
        return this.savedIpAddress;
    }
    /**
     * @return the ip address for this message processor.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.296 -0500", hash_original_method = "884B07577FCFC9DD806F4641FDB0A38E", hash_generated_method = "C966304EEF88C7E37832487A5C9F8F88")
    
public InetAddress getIpAddress() {
          return this.ipAddress;
    }
    /**
     * @param ipAddress the ipAddress to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.299 -0500", hash_original_method = "B4AF9626210C81D85EEE89A64933E4EF", hash_generated_method = "48A7494BB6FCB327D961F4C43AB2F92B")
    
protected void setIpAddress(InetAddress ipAddress) {
        this.sentByHostPort.setHost( new Host(ipAddress.getHostAddress()));
        this.ipAddress = ipAddress;
    }

    /**
     * Set the sentby string. This is used for stamping outgoing messages sent
     * from this listening point.
     *
     * @param sentBy
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.302 -0500", hash_original_method = "032529AF3B126F26B3B81544F7F95DEA", hash_generated_method = "769E0C1D781C18C381510844CBF9D548")
    
public void setSentBy(String sentBy) throws ParseException {

        int ind = sentBy.indexOf(":");
        if (ind == -1) {
            this.sentByHostPort = new HostPort();
            this.sentByHostPort.setHost(new Host(sentBy));
        } else {
            this.sentByHostPort = new HostPort();
            this.sentByHostPort.setHost(new Host(sentBy.substring(0, ind)));
            String portStr = sentBy.substring(ind + 1);
            try {
                int port = Integer.parseInt(portStr);
                this.sentByHostPort.setPort(port);
            } catch (NumberFormatException ex) {
                throw new ParseException("Bad format encountered at ", ind);
            }
        }
        this.sentBySet = true;
        this.sentBy = sentBy;

    }

    /**
     * Get the sentby string.
     *
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.305 -0500", hash_original_method = "F9F985C0AF39EB878B850CABB152BA50", hash_generated_method = "884018CDB2BC8CA6D89CD8F3B98FAB32")
    
public String getSentBy() {
        if ( this.sentBy == null && this.sentByHostPort != null) {
            this.sentBy = this.sentByHostPort.toString();
        }
        return this.sentBy;
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    // Abstract methods
    ///////////////////////////////////////////////////////////////////////////////////////
    /**
     * Get the SIP Stack.
     *
     * @return the sip stack.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.308 -0500", hash_original_method = "A1A00F5C2BF3E0AFD608A46FA340D257", hash_generated_method = "D186E97C3F23BE4B3601C73C20E07F79")
    
public abstract SIPTransactionStack getSIPStack();

    /**
     * Create a message channel for the specified host/port.
     *
     * @return New MessageChannel for this processor.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.311 -0500", hash_original_method = "ABB3A4B745EF0C3016E695FB2D61AE96", hash_generated_method = "47E9CBB5255A0EFB39F44A2FBAB94009")
    
public abstract MessageChannel createMessageChannel(HostPort targetHostPort)
            throws IOException;

    /**
     * Create a message channel for the specified host/port.
     *
     * @return New MessageChannel for this processor.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.314 -0500", hash_original_method = "B99FCAE3A3388F00CA4B0651ECF766FB", hash_generated_method = "D7991912A0F0FDB275D8BA9E0EEEB60A")
    
public abstract MessageChannel createMessageChannel(InetAddress targetHost,
            int port) throws IOException;

    /**
     * Start our thread.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.317 -0500", hash_original_method = "81FFB20F89E8D0B587445E4BF7DBE6A4", hash_generated_method = "AD7D25BA42F7D94247153AF8D82CFE0B")
    
public abstract void start() throws IOException;

    /**
     * Stop method.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.320 -0500", hash_original_method = "702270B81E0A152F42E95B594CBF6271", hash_generated_method = "83BF6F52E4E13B269491279EF09CDA29")
    
public abstract void stop();

    /**
     * Default target port used by this processor. This is 5060 for TCP / UDP
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.323 -0500", hash_original_method = "6BCD8DD5D3EE6B672607E7D0637058E2", hash_generated_method = "D01BA1A4072A6C1EE8BD4DB0B80FCB74")
    
public abstract int getDefaultTargetPort();

    /**
     * Flags whether this processor is secure or not.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.326 -0500", hash_original_method = "C0F4ED7F29E54AD75430386669D6EE3C", hash_generated_method = "3756A60CD212E039C9DCF60D85147293")
    
public abstract boolean isSecure();

    /**
     * Maximum number of bytes that this processor can handle.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.328 -0500", hash_original_method = "D1034F159FF316937B32787299F2166A", hash_generated_method = "B7E4AD3E8AD39377BA8B23BBB7CB43F6")
    
public abstract int getMaximumMessageSize();

    /**
     * Return true if there are pending messages to be processed (which prevents
     * the message channel from being closed).
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.331 -0500", hash_original_method = "FB9F59146EEE6CC40C0613775AE45CBB", hash_generated_method = "3617B8DFC66E3EDDAD2C17D7560F8126")
    
public abstract boolean inUse();

    /**
     * Run method.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.334 -0500", hash_original_method = "2C6A443C83148E86AAD705D9EE784F75", hash_generated_method = "5BBE1BCB74D1FAFBB58FE7F038D48F66")
    
public abstract void run();

    /**
     * @return Returns the sentBySet.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.336 -0500", hash_original_method = "7D85FA3843A3F240694BBADD6AC174E2", hash_generated_method = "582D6DC1A3D6FA6E469AA081EDF3A23E")
    
public boolean isSentBySet() {
        return sentBySet;
    }
}

