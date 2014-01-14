package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Host;
import gov.nist.core.HostPort;
import gov.nist.core.InternalErrorHandler;
import gov.nist.core.ServerLogger;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.ContentLength;
import gov.nist.javax.sip.header.ContentType;
import gov.nist.javax.sip.header.Via;
import gov.nist.javax.sip.message.MessageFactoryImpl;
import gov.nist.javax.sip.message.SIPMessage;
import gov.nist.javax.sip.message.SIPRequest;
import gov.nist.javax.sip.message.SIPResponse;

import java.io.IOException;
import java.net.InetAddress;
import java.text.ParseException;

import javax.sip.address.Hop;
import javax.sip.header.CSeqHeader;
import javax.sip.header.CallIdHeader;
import javax.sip.header.ContactHeader;
import javax.sip.header.ContentLengthHeader;
import javax.sip.header.ContentTypeHeader;
import javax.sip.header.FromHeader;
import javax.sip.header.ServerHeader;
import javax.sip.header.ToHeader;
import javax.sip.header.ViaHeader;

public abstract class MessageChannel {

    /**
     * generate a key given the inet address port and transport.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.447 -0500", hash_original_method = "846DF853619BEDF1EEA7976F91CB26E5", hash_generated_method = "0F7F6100DD11D9A006C5A2CBCFA80CA1")
    
public static String getKey(InetAddress inetAddr, int port, String transport) {
        return (transport + ":" + inetAddr.getHostAddress() + ":" + port).toLowerCase();
    }

    /**
     * Generate a key given host and port.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.449 -0500", hash_original_method = "7E056F650A5C33E8E0BFC2C195483B34", hash_generated_method = "A7F73DE8F0070D54CC5E10AAA2BC3388")
    
public static String getKey(HostPort hostPort, String transport) {
        return (transport + ":" + hostPort.getHost().getHostname() + ":" + hostPort.getPort())
                .toLowerCase();
    }

    /**
     * Copies a header from a request
     * 
     * @param name
     * @param fromReq
     * @param buf
     * @return
     * 
     * Note: some limitations here: does not work for short forms of headers, or continuations;
     * problems when header names appear in other parts of the request
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.473 -0500", hash_original_method = "D45D00399FFC9017933279EE021E88CF", hash_generated_method = "95B9892AF4A09203DAB0A0A8C0714F47")
    
private static final boolean copyHeader(String name, String fromReq, StringBuffer buf) {
        int start = fromReq.indexOf(name);
        if (start != -1) {
            int end = fromReq.indexOf("\r\n", start);
            if (end != -1) {
                // XX Assumes no continuation here...
                buf.append(fromReq.subSequence(start - 2, end)); // incl CRLF
                // in front
                return true;
            }
        }
        return false;
    }

    /**
     * Copies all via headers from a request
     * 
     * @param fromReq
     * @param buf
     * @return
     * 
     * Note: some limitations here: does not work for short forms of headers, or continuations
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.476 -0500", hash_original_method = "B0ED81FBE57D6EDF5E6EF56B95DE27A2", hash_generated_method = "1F4282D39445E7864FFB9CBBCF5B0988")
    
private static final boolean copyViaHeaders(String fromReq, StringBuffer buf) {
        int start = fromReq.indexOf(ViaHeader.NAME);
        boolean found = false;
        while (start != -1) {
            int end = fromReq.indexOf("\r\n", start);
            if (end != -1) {
                // XX Assumes no continuation here...
                buf.append(fromReq.subSequence(start - 2, end)); // incl CRLF
                // in front
                found = true;
                start = fromReq.indexOf(ViaHeader.NAME, end);
            } else {
                return false;
            }
        }
        return found;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.381 -0500", hash_original_field = "43A0963BA6DFAE0550944671844C16DD", hash_generated_field = "B2DBC7FA9F7848B8CAE76A2522557111")

    // to the message channel and decremented when
    // a transaction gets freed from the message channel.
	protected int useCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.386 -0500", hash_original_field = "E4941A6D5D11F7097BE49F2BB415489B", hash_generated_field = "F67739B8CB8B1CB4F97395041389F37A")

    protected transient MessageProcessor messageProcessor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.466 -0400", hash_original_method = "1B1EF2D32056DF45EB39273AF108BD8B", hash_generated_method = "1B1EF2D32056DF45EB39273AF108BD8B")
    public MessageChannel ()
    {
        //Synthesized constructor
    }
	
	/**
	 * Hook method, overridden by subclasses
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.383 -0500", hash_original_method = "B5543AC884E160C74E00608F95C390A3", hash_generated_method = "025D709C617EE859D259AC0531A0D747")
    
protected void uncache() {}

    /**
     * Close the message channel.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.388 -0500", hash_original_method = "D50D7BA65C2BEB3EB436584B5735F108", hash_generated_method = "01CBB4D2860961B039FF408E6402870A")
    
public abstract void close();

    /**
     * Get the SIPStack object from this message channel.
     * 
     * @return SIPStack object of this message channel
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.391 -0500", hash_original_method = "A1A00F5C2BF3E0AFD608A46FA340D257", hash_generated_method = "D186E97C3F23BE4B3601C73C20E07F79")
    
public abstract SIPTransactionStack getSIPStack();

    /**
     * Get transport string of this message channel.
     * 
     * @return Transport string of this message channel.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.393 -0500", hash_original_method = "6F76800A66F29254B58644281757D834", hash_generated_method = "472D1D05977661EE7869F1DAA4C9C0C0")
    
public abstract String getTransport();

    /**
     * Get whether this channel is reliable or not.
     * 
     * @return True if reliable, false if not.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.396 -0500", hash_original_method = "67BE63CE08C0852FBF4D8607122F2A3E", hash_generated_method = "E2CACDD0CC36195BEC0290C7422D469E")
    
public abstract boolean isReliable();

    /**
     * Return true if this is a secure channel.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.399 -0500", hash_original_method = "C0F4ED7F29E54AD75430386669D6EE3C", hash_generated_method = "3756A60CD212E039C9DCF60D85147293")
    
public abstract boolean isSecure();

    /**
     * Send the message (after it has been formatted)
     * 
     * @param sipMessage Message to send.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.402 -0500", hash_original_method = "943107E40C7061CF61FBA545BB2DDBDE", hash_generated_method = "D8ADE5FC39BB1D960ABCF93CEBD4BCD5")
    
public abstract void sendMessage(SIPMessage sipMessage) throws IOException;

    /**
     * Get the peer address of the machine that sent us this message.
     * 
     * @return a string contianing the ip address or host name of the sender of the message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.405 -0500", hash_original_method = "8E3B76240BF5A106DB76C05900EB6F70", hash_generated_method = "B9650ED22688B12CEEA0C8A72EC69EC1")
    
public abstract String getPeerAddress();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.407 -0500", hash_original_method = "86105B048E596AFFC776E1756936570D", hash_generated_method = "F2B085EDDA5E350636D217D4DB67E704")
    
protected abstract InetAddress getPeerInetAddress();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.410 -0500", hash_original_method = "E138929571C60A253985A230B3A22A80", hash_generated_method = "031B1A27CA071B7A60A3D12FDD6F3BF0")
    
protected abstract String getPeerProtocol();

    /**
     * Get the sender port ( the port of the other end that sent me the message).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.412 -0500", hash_original_method = "5E659664C7E6B37A546815996C8F8ACA", hash_generated_method = "B04118E67000106659EF5EC33B839DF6")
    
public abstract int getPeerPort();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.415 -0500", hash_original_method = "F346C9CFC7FFB3BFA4246F8E943E387C", hash_generated_method = "9348460B3581B6B4E2076709D506AF42")
    
public abstract int getPeerPacketSourcePort();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.417 -0500", hash_original_method = "599CD8B9ADF0C8C8BFCAE40B505B1A24", hash_generated_method = "F2E46F7EE0A7199720237741C63636DF")
    
public abstract InetAddress getPeerPacketSourceAddress();

    /**
     * Generate a key which identifies the message channel. This allows us to cache the message
     * channel.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.420 -0500", hash_original_method = "BE0D92A3F953565F6F18B17B1C3A43CD", hash_generated_method = "5F8C15F3F00BB78C1D45433F5F8B9C3E")
    
public abstract String getKey();

    /**
     * Get the host to assign for an outgoing Request via header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.423 -0500", hash_original_method = "3BEA3EEFE4CD9B076F0D5912037EECED", hash_generated_method = "3BED50FEEBA9481B3672C193F7B51E6C")
    
public abstract String getViaHost();

    /**
     * Get the port to assign for the via header of an outgoing message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.425 -0500", hash_original_method = "D492DD42AEC73A3D3ECA27C6E0A2D4F3", hash_generated_method = "8DD347D7A63DAAD2346B9B2FEE94238A")
    
public abstract int getViaPort();

    /**
     * Send the message (after it has been formatted), to a specified address and a specified port
     * 
     * @param message Message to send.
     * @param receiverAddress Address of the receiver.
     * @param receiverPort Port of the receiver.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.428 -0500", hash_original_method = "3BF971AACA60A2EF636E81CFE73449CD", hash_generated_method = "2D6B5960D2A75CAD335A07035026E1F5")
    
protected abstract void sendMessage(byte[] message, InetAddress receiverAddress,
            int receiverPort, boolean reconnectFlag) throws IOException;

    /**
     * Get the host of this message channel.
     * 
     * @return host of this messsage channel.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.431 -0500", hash_original_method = "CA1BACEAFC0549F0AA4E82303BA5F480", hash_generated_method = "E2ED1FC5C7CAEBA67EDAA2DB9C0D6E4E")
    
public String getHost() {
        return this.getMessageProcessor().getIpAddress().getHostAddress();
    }

    /**
     * Get port of this message channel.
     * 
     * @return Port of this message channel.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.433 -0500", hash_original_method = "D12E0B39D0A0A3DBD8096F94437302A2", hash_generated_method = "0C20C5FBA7CBC21223438E53D56E4085")
    
public int getPort() {
        if (this.messageProcessor != null)
            return messageProcessor.getPort();
        else
            return -1;
    }

    /**
     * Send a formatted message to the specified target.
     * 
     * @param sipMessage Message to send.
     * @param hop hop to send it to.
     * @throws IOException If there is an error sending the message
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.437 -0500", hash_original_method = "6965EB337B784D47DD1B6D5165D2FBD3", hash_generated_method = "49C0500EDAB2421417EBD8E5E986BA4B")
    
public void sendMessage(SIPMessage sipMessage, Hop hop) throws IOException {
        long time = System.currentTimeMillis();
        InetAddress hopAddr = InetAddress.getByName(hop.getHost());

        try {

            for (MessageProcessor messageProcessor : getSIPStack().getMessageProcessors()) {
                if (messageProcessor.getIpAddress().equals(hopAddr)
                        && messageProcessor.getPort() == hop.getPort()
                        && messageProcessor.getTransport().equals(hop.getTransport())) {
                    MessageChannel messageChannel = messageProcessor.createMessageChannel(
                            hopAddr, hop.getPort());
                    if (messageChannel instanceof RawMessageChannel) {
                        ((RawMessageChannel) messageChannel).processMessage(sipMessage);
                        if (getSIPStack().isLoggingEnabled())
                        	getSIPStack().getStackLogger().logDebug("Self routing message");
                        return;
                    }

                }
            }
            byte[] msg = sipMessage.encodeAsBytes(this.getTransport());

            this.sendMessage(msg, hopAddr, hop.getPort(), sipMessage instanceof SIPRequest);

        } catch (IOException ioe) {
            throw ioe;
        } catch (Exception ex) {
        	if (this.getSIPStack().getStackLogger().isLoggingEnabled(ServerLogger.TRACE_ERROR)) {
        		this.getSIPStack().getStackLogger().logError("Error self routing message cause by: ", ex);
        	}
        	// TODO: When moving to Java 6, use the IOExcpetion(message, exception) constructor
            throw new IOException("Error self routing message");
        } finally {

            if (this.getSIPStack().getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES))
                logMessage(sipMessage, hopAddr, hop.getPort(), time);
        }
    }

    /**
     * Send a message given SIP message.
     * 
     * @param sipMessage is the messge to send.
     * @param receiverAddress is the address to which we want to send
     * @param receiverPort is the port to which we want to send
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.441 -0500", hash_original_method = "4AF33D1C82235ED60B6E3DD0D1967C25", hash_generated_method = "B1FD74C7B598A73CE43B5AD1FC17421B")
    
public void sendMessage(SIPMessage sipMessage, InetAddress receiverAddress, int receiverPort)
            throws IOException {
        long time = System.currentTimeMillis();
        byte[] bytes = sipMessage.encodeAsBytes(this.getTransport());
        sendMessage(bytes, receiverAddress, receiverPort, sipMessage instanceof SIPRequest);
        logMessage(sipMessage, receiverAddress, receiverPort, time);
    }

    /**
     * Convenience function to get the raw IP source address of a SIP message as a String.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.444 -0500", hash_original_method = "BC100C85F7EEF6C9116B6E540185BCE8", hash_generated_method = "5934AC6ECFB9531EEB4FDD8E1EBD3717")
    
public String getRawIpSourceAddress() {
        String sourceAddress = getPeerAddress();
        String rawIpSourceAddress = null;
        try {
            InetAddress sourceInetAddress = InetAddress.getByName(sourceAddress);
            rawIpSourceAddress = sourceInetAddress.getHostAddress();
        } catch (Exception ex) {
            InternalErrorHandler.handleException(ex);
        }
        return rawIpSourceAddress;
    }

    /**
     * Get the hostport structure of this message channel.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.453 -0500", hash_original_method = "A44FE176AC0185A0737BBEE3031992DB", hash_generated_method = "EB79704D147D1C6B4FBBBAF57EB273B3")
    
public HostPort getHostPort() {
        HostPort retval = new HostPort();
        retval.setHost(new Host(this.getHost()));
        retval.setPort(this.getPort());
        return retval;
    }

    /**
     * Get the peer host and port.
     * 
     * @return a HostPort structure for the peer.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.455 -0500", hash_original_method = "B86C07836DB50334479A6BD4BF7381CC", hash_generated_method = "E206406A536DAE8CDB7C90FC2BF5C367")
    
public HostPort getPeerHostPort() {
        HostPort retval = new HostPort();
        retval.setHost(new Host(this.getPeerAddress()));
        retval.setPort(this.getPeerPort());
        return retval;
    }

    /**
     * Get the Via header for this transport. Note that this does not set a branch identifier.
     * 
     * @return a via header for outgoing messages sent from this channel.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.457 -0500", hash_original_method = "31F63348466D8C31B05195508CA771AE", hash_generated_method = "96814D86743CF9D8E60C2ECE7580AEF8")
    
public Via getViaHeader() {
        Via channelViaHeader;

        channelViaHeader = new Via();
        try {
            channelViaHeader.setTransport(getTransport());
        } catch (ParseException ex) {
        }
        channelViaHeader.setSentBy(getHostPort());
        return channelViaHeader;
    }

    /**
     * Get the via header host:port structure. This is extracted from the topmost via header of
     * the request.
     * 
     * @return a host:port structure
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.460 -0500", hash_original_method = "8AF1560686CCA72CFE111D9FA9C1ECDE", hash_generated_method = "74E673E076433DD4973390B7FA041989")
    
public HostPort getViaHostPort() {
        HostPort retval = new HostPort();
        retval.setHost(new Host(this.getViaHost()));
        retval.setPort(this.getViaPort());
        return retval;
    }

    /**
     * Log a message sent to an address and port via the default interface.
     * 
     * @param sipMessage is the message to log.
     * @param address is the inet address to which the message is sent.
     * @param port is the port to which the message is directed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.463 -0500", hash_original_method = "C068429579A247F633492130419A4C88", hash_generated_method = "70089D08E162A1242C38DE91E8CBAE38")
    
protected void logMessage(SIPMessage sipMessage, InetAddress address, int port, long time) {
        if (!getSIPStack().getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES))
            return;

        // Default port.
        if (port == -1)
            port = 5060;
        getSIPStack().serverLogger.logMessage(sipMessage, this.getHost() + ":" + this.getPort(),
                address.getHostAddress().toString() + ":" + port, true, time);
    }

    /**
     * Log a response received at this message channel. This is used for processing incoming
     * responses to a client transaction.
     * 
     * @param receptionTime is the time at which the response was received.
     * @param status is the processing status of the message.
     * 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.466 -0500", hash_original_method = "F3D4D9112F2E8581D299D1D033206DF5", hash_generated_method = "F16AB55D28A31485DEA507C51DB3A5A7")
    
public void logResponse(SIPResponse sipResponse, long receptionTime, String status) {
        int peerport = getPeerPort();
        if (peerport == 0 && sipResponse.getContactHeaders() != null) {
            ContactHeader contact = (ContactHeader) sipResponse.getContactHeaders().getFirst();
            peerport = ((AddressImpl) contact.getAddress()).getPort();

        }
        String from = getPeerAddress().toString() + ":" + peerport;
        String to = this.getHost() + ":" + getPort();
        this.getSIPStack().serverLogger.logMessage(sipResponse, from, to, status, false,
                receptionTime);
    }

    /**
     * Creates a response to a bad request (ie one that causes a ParseException)
     * 
     * @param badReq
     * @return message bytes, null if unable to formulate response
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.470 -0500", hash_original_method = "FECBC10325F07301270E33C64C8E0AD0", hash_generated_method = "ADF2BD53B71499F406D186045BF7FF39")
    
protected final String createBadReqRes(String badReq, ParseException pe) {

        StringBuffer buf = new StringBuffer(512);
        buf.append("SIP/2.0 400 Bad Request (" + pe.getLocalizedMessage() + ')');

        // We need the following headers: all Vias, CSeq, Call-ID, From, To
        if (!copyViaHeaders(badReq, buf))
            return null;
        if (!copyHeader(CSeqHeader.NAME, badReq, buf))
            return null;
        if (!copyHeader(CallIdHeader.NAME, badReq, buf))
            return null;
        if (!copyHeader(FromHeader.NAME, badReq, buf))
            return null;
        if (!copyHeader(ToHeader.NAME, badReq, buf))
            return null;

        // Should add a to-tag if not already present...
        int toStart = buf.indexOf(ToHeader.NAME);
        if (toStart != -1 && buf.indexOf("tag", toStart) == -1) {
            buf.append(";tag=badreq");
        }

        // Let's add a Server header too..
        ServerHeader s = MessageFactoryImpl.getDefaultServerHeader();
        if ( s != null ) {
            buf.append("\r\n" + s.toString());
        }
        int clength = badReq.length();
        if (! (this instanceof UDPMessageChannel) ||
                clength + buf.length() + ContentTypeHeader.NAME.length()
                + ": message/sipfrag\r\n".length() +
                ContentLengthHeader.NAME.length()  < 1300) {
            
            /*
             * Check to see we are within one UDP packet.
             */
            ContentTypeHeader cth = new ContentType("message", "sipfrag");
            buf.append("\r\n" + cth.toString());
            ContentLength clengthHeader = new ContentLength(clength);
            buf.append("\r\n" + clengthHeader.toString());
            buf.append("\r\n\r\n" + badReq);
        } else {
            ContentLength clengthHeader = new ContentLength(0);
            buf.append("\r\n" + clengthHeader.toString());
        }
        
        return buf.toString();
    }

    /**
     * Get the message processor.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.478 -0500", hash_original_method = "B369445AF3BB32430CE637694E76219B", hash_generated_method = "4B0F0A9B7F50969861BE18EA82A66E74")
    
public MessageProcessor getMessageProcessor() {
        return this.messageProcessor;
    }
    
}

