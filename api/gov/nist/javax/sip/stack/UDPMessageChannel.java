package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.InternalErrorHandler;
import gov.nist.core.ServerLogger;
import gov.nist.core.StackLogger;
import gov.nist.core.ThreadAuditor;
import gov.nist.javax.sip.SIPConstants;
import gov.nist.javax.sip.header.CSeq;
import gov.nist.javax.sip.header.CallID;
import gov.nist.javax.sip.header.From;
import gov.nist.javax.sip.header.RequestLine;
import gov.nist.javax.sip.header.StatusLine;
import gov.nist.javax.sip.header.To;
import gov.nist.javax.sip.header.Via;
import gov.nist.javax.sip.header.ViaList;
import gov.nist.javax.sip.message.SIPMessage;
import gov.nist.javax.sip.message.SIPRequest;
import gov.nist.javax.sip.message.SIPResponse;
import gov.nist.javax.sip.parser.ParseExceptionListener;
import gov.nist.javax.sip.parser.StringMsgParser;

import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.text.ParseException;
import java.util.Hashtable;
import java.util.TimerTask;

import javax.sip.address.Hop;

public class UDPMessageChannel extends MessageChannel implements ParseExceptionListener, Runnable, RawMessageChannel {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.368 -0500", hash_original_field = "A4B05DD1A2BDFAA2E8FCD10E8D1815B6", hash_generated_field = "3233C5012C49C796F9D6BBC8E02EAB41")

    protected SIPTransactionStack sipStack;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.371 -0500", hash_original_field = "E2A480FE405F8276F1EFBE824E1FF2A5", hash_generated_field = "0A43681EE1A6E215BE82E39AC59DFE7C")

    protected StringMsgParser myParser;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.374 -0500", hash_original_field = "366B1D4629185E73902FFD7D04A7B174", hash_generated_field = "DB2440387A41D5016778DA700632E003")

    private InetAddress peerAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.377 -0500", hash_original_field = "95EABD5ABD88E35E559B3906991D12AE", hash_generated_field = "DEE18A414D72F7D580E73EF519B5B75F")

    private String myAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.380 -0500", hash_original_field = "8AEBC2998B5E75EE998FC822539710AC", hash_generated_field = "917EBAB90EE3EF0904EF1CC7129F7C3B")

    private int peerPacketSourcePort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.383 -0500", hash_original_field = "21FBD1F3C626244BE5AA333519378971", hash_generated_field = "31AFBD6F92700654B3E6CD25C4BAE79B")

    private InetAddress peerPacketSourceAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.386 -0500", hash_original_field = "A714E58FF483C2E33F156CBA7BFCD38B", hash_generated_field = "FE74A5BA5CFBB5B6DC2B68FEFA76ECFC")

    private int peerPort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.388 -0500", hash_original_field = "D89E736D3DD25A80B53E476FF3F84027", hash_generated_field = "EB665B7537D07145A6FCAD2DB460EADC")

    private String peerProtocol;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.391 -0500", hash_original_field = "05A0D771A4A24E58EF91191716865F5C", hash_generated_field = "AD61806C610E09EDA888D5EC477B22F2")

    protected int myPort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.394 -0500", hash_original_field = "E54462E997B322B09DD0125AB641B35D", hash_generated_field = "5DCE0469450ABB74FDB5A37D9DFDF23A")

    private DatagramPacket incomingPacket;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.398 -0500", hash_original_field = "F237DE63057BE39BEE7D4F09606ACEC6", hash_generated_field = "FDC149166FA9FE14388FB5695DD3C00D")

    private long receptionTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.401 -0500", hash_original_field = "29BFA636248D06F96C75EB4382FADC8E", hash_generated_field = "DE4903FFD06AF3966ED05EEB79D4D38C")

    private Hashtable<String,PingBackTimerTask> pingBackRecord = new Hashtable<String,PingBackTimerTask>();

    /**
     * Constructor - takes a datagram packet and a stack structure Extracts the
     * address of the other from the datagram packet and stashes away the
     * pointer to the passed stack structure.
     *
     * @param stack
     *            is the shared SIPStack structure
     * @param messageProcessor
     *            is the creating message processor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.421 -0500", hash_original_method = "03A64681434F0E8B0C9121AC8F1C5237", hash_generated_method = "19DBE9E2C64D275D739DC191502C8FA6")
    
protected UDPMessageChannel(SIPTransactionStack stack,
            UDPMessageProcessor messageProcessor) {
        super.messageProcessor = messageProcessor;
        this.sipStack = stack;

        Thread mythread = new Thread(this);

        this.myAddress = messageProcessor.getIpAddress().getHostAddress();
        this.myPort = messageProcessor.getPort();

        mythread.setName("UDPMessageChannelThread");
        mythread.setDaemon(true);
        mythread.start();

    }

    /**
     * Constructor. We create one of these in order to process an incoming
     * message.
     *
     * @param stack
     *            is the SIP sipStack.
     * @param messageProcessor
     *            is the creating message processor.
     * @param packet
     *            is the incoming datagram packet.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.426 -0500", hash_original_method = "1756885BA9DE2BFD3C0F236D276D29E7", hash_generated_method = "320648BCE35C505AE51358F4E7EA9A25")
    
protected UDPMessageChannel(SIPTransactionStack stack,
            UDPMessageProcessor messageProcessor, DatagramPacket packet) {

        this.incomingPacket = packet;
        super.messageProcessor = messageProcessor;
        this.sipStack = stack;

        this.myAddress = messageProcessor.getIpAddress().getHostAddress();
        this.myPort = messageProcessor.getPort();
        Thread mythread = new Thread(this);
        mythread.setDaemon(true);
        mythread.setName("UDPMessageChannelThread");

        mythread.start();

    }

    /**
     * Constructor. We create one of these when we send out a message.
     *
     * @param targetAddr
     *            INET address of the place where we want to send messages.
     * @param port
     *            target port (where we want to send the message).
     * @param sipStack
     *            our SIP Stack.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.429 -0500", hash_original_method = "776DD93072EC88FB0665477FC0515605", hash_generated_method = "0588306C663F5E0F317AA5BDA696CBD0")
    
protected UDPMessageChannel(InetAddress targetAddr, int port,
            SIPTransactionStack sipStack, UDPMessageProcessor messageProcessor) {
        peerAddress = targetAddr;
        peerPort = port;
        peerProtocol = "UDP";
        super.messageProcessor = messageProcessor;
        this.myAddress = messageProcessor.getIpAddress().getHostAddress();
        this.myPort = messageProcessor.getPort();
        this.sipStack = sipStack;
        if (sipStack.isLoggingEnabled()) {
            this.sipStack.getStackLogger().logDebug("Creating message channel "
                    + targetAddr.getHostAddress() + "/" + port);
        }
    }

    /**
     * Run method specified by runnnable.
     */
    @DSSpec(DSCat.THREADING)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.433 -0500", hash_original_method = "E6EA1046257028C8ED28AF4C13B7A731", hash_generated_method = "BE404AD3B81220A0192E0E3AEA67BFF9")
    
public void run() {
        // Assume no thread pooling (bug fix by spierhj)
        ThreadAuditor.ThreadHandle threadHandle = null;

        while (true) {
            // Create a new string message parser to parse the list of messages.
            if (myParser == null) {
                myParser = new StringMsgParser();
                myParser.setParseExceptionListener(this);
            }
            // messages that we write out to him.
            DatagramPacket packet;

            if (sipStack.threadPoolSize != -1) {
                synchronized (((UDPMessageProcessor) messageProcessor).messageQueue) {
                    while (((UDPMessageProcessor) messageProcessor).messageQueue
                            .isEmpty()) {
                        // Check to see if we need to exit.
                        if (!((UDPMessageProcessor) messageProcessor).isRunning)
                            return;
                        try {
                            // We're part of a thread pool. Ask the auditor to
                            // monitor this thread.
                            if (threadHandle == null) {
                                threadHandle = sipStack.getThreadAuditor()
                                        .addCurrentThread();
                            }

                            // Send a heartbeat to the thread auditor
                            threadHandle.ping();

                            // Wait for packets
                            // Note: getPingInterval returns 0 (infinite) if the
                            // thread auditor is disabled.
                            ((UDPMessageProcessor) messageProcessor).messageQueue
                                    .wait(threadHandle
                                            .getPingIntervalInMillisecs());
                        } catch (InterruptedException ex) {
                            if (!((UDPMessageProcessor) messageProcessor).isRunning)
                                return;
                        }
                    }
                    packet = (DatagramPacket) ((UDPMessageProcessor) messageProcessor).messageQueue
                            .removeFirst();

                }
                this.incomingPacket = packet;
            } else {
                packet = this.incomingPacket;
            }

            // Process the packet. Catch and log any exception we may throw.
            try {
                processIncomingDataPacket(packet);
            } catch (Exception e) {

                sipStack.getStackLogger().logError(
                        "Error while processing incoming UDP packet", e);
            }

            if (sipStack.threadPoolSize == -1) {
                return;
            }
        }
    }

    /**
     * Process an incoming datagram
     *
     * @param packet
     *            is the incoming datagram packet.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.439 -0500", hash_original_method = "2D23A147968127857F47AE9C2F0B0301", hash_generated_method = "6B719ED1CA7C5621A0C4F218A60E7CA7")
    
private void processIncomingDataPacket(DatagramPacket packet)
            throws Exception {
        this.peerAddress = packet.getAddress();
        int packetLength = packet.getLength();
        // Read bytes and put it in a eueue.
        byte[] bytes = packet.getData();
        byte[] msgBytes = new byte[packetLength];
        System.arraycopy(bytes, 0, msgBytes, 0, packetLength);

        // Do debug logging.
        if (sipStack.isLoggingEnabled()) {
            this.sipStack.getStackLogger()
                    .logDebug("UDPMessageChannel: processIncomingDataPacket : peerAddress = "
                            + peerAddress.getHostAddress() + "/"
                            + packet.getPort() + " Length = " + packetLength);

        }

        SIPMessage sipMessage = null;
        try {
            this.receptionTime = System.currentTimeMillis();
            sipMessage = myParser.parseSIPMessage(msgBytes);
            myParser = null;
        } catch (ParseException ex) {
            myParser = null; // let go of the parser reference.
            if (sipStack.isLoggingEnabled()) {
                this.sipStack.getStackLogger().logDebug("Rejecting message !  "
                        + new String(msgBytes));
                this.sipStack.getStackLogger().logDebug("error message "
                        + ex.getMessage());
                this.sipStack.getStackLogger().logException(ex);
            }

            // JvB: send a 400 response for requests (except ACK)
            // Currently only UDP, @todo also other transports
            String msgString = new String(msgBytes, 0, packetLength);
            if (!msgString.startsWith("SIP/") && !msgString.startsWith("ACK ")) {

                String badReqRes = createBadReqRes(msgString, ex);
                if (badReqRes != null) {
                    if (sipStack.isLoggingEnabled()) {
                        sipStack.getStackLogger().logDebug(
                                "Sending automatic 400 Bad Request:");
                        sipStack.getStackLogger().logDebug(badReqRes);
                    }
                    try {
                        this.sendMessage(badReqRes.getBytes(), peerAddress,
                                packet.getPort(), "UDP", false);
                    } catch (IOException e) {
                        this.sipStack.getStackLogger().logException(e);
                    }
                } else {
                    if (sipStack.isLoggingEnabled()) {
                        sipStack
                                .getStackLogger()
                                .logDebug(
                                        "Could not formulate automatic 400 Bad Request");
                    }
                }
            }

            return;
        }
        // No parse exception but null message - reject it and
        // march on (or return).
        // exit this message processor if the message did not parse.

        if (sipMessage == null) {
            if (sipStack.isLoggingEnabled()) {
                this.sipStack.getStackLogger().logDebug("Rejecting message !  + Null message parsed.");
            }
            if (pingBackRecord.get(packet.getAddress().getHostAddress() + ":" + packet.getPort()) == null ) {
                byte[] retval = "\r\n\r\n".getBytes();
                DatagramPacket keepalive = new DatagramPacket(retval,0,retval.length,packet.getAddress(),packet.getPort());
                ((UDPMessageProcessor)this.messageProcessor).sock.send(keepalive);
                this.sipStack.getTimer().schedule(new PingBackTimerTask(packet.getAddress().getHostAddress(), 
                            packet.getPort()), 1000);                
            }
            return;
        }
        ViaList viaList = sipMessage.getViaHeaders();
        // Check for the required headers.
        if (sipMessage.getFrom() == null || sipMessage.getTo() == null
                || sipMessage.getCallId() == null
                || sipMessage.getCSeq() == null
                || sipMessage.getViaHeaders() == null) {
            String badmsg = new String(msgBytes);
            if (sipStack.isLoggingEnabled()) {
                this.sipStack.getStackLogger().logError("bad message " + badmsg);
                this.sipStack.getStackLogger().logError(">>> Dropped Bad Msg "
                        + "From = " + sipMessage.getFrom() + "To = "
                        + sipMessage.getTo() + "CallId = "
                        + sipMessage.getCallId() + "CSeq = "
                        + sipMessage.getCSeq() + "Via = "
                        + sipMessage.getViaHeaders());
            }
            return;
        }
        // For a request first via header tells where the message
        // is coming from.
        // For response, just get the port from the packet.
        if (sipMessage instanceof SIPRequest) {
            Via v = (Via) viaList.getFirst();
            Hop hop = sipStack.addressResolver.resolveAddress(v.getHop());
            this.peerPort = hop.getPort();
            this.peerProtocol = v.getTransport();

            this.peerPacketSourceAddress = packet.getAddress();
            this.peerPacketSourcePort = packet.getPort();
            try {
                this.peerAddress = packet.getAddress();
                // Check to see if the received parameter matches
                // the peer address and tag it appropriately.

                boolean hasRPort = v.hasParameter(Via.RPORT);
                if (hasRPort
                        || !hop.getHost().equals(
                                this.peerAddress.getHostAddress())) {
                    v.setParameter(Via.RECEIVED, this.peerAddress
                            .getHostAddress());
                }

                if (hasRPort) {
                    v.setParameter(Via.RPORT, Integer
                            .toString(this.peerPacketSourcePort));
                }
            } catch (java.text.ParseException ex1) {
                InternalErrorHandler.handleException(ex1);
            }

        } else {

            this.peerPacketSourceAddress = packet.getAddress();
            this.peerPacketSourcePort = packet.getPort();
            this.peerAddress = packet.getAddress();
            this.peerPort = packet.getPort();
            this.peerProtocol = ((Via) viaList.getFirst()).getTransport();
        }

        this.processMessage(sipMessage);

    }

    /**
     * Actually proces the parsed message.
     *
     * @param sipMessage
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.443 -0500", hash_original_method = "DCEA2882E2241B5A52F15EAA80B8F270", hash_generated_method = "2CA44E47C5C5FAEA4907F1E6D36A559C")
    
public void processMessage(SIPMessage sipMessage) {

        if (sipMessage instanceof SIPRequest) {
            SIPRequest sipRequest = (SIPRequest) sipMessage;

            // This is a request - process it.
            // So far so good -- we will commit this message if
            // all processing is OK.
            if (sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES)) {

                this.sipStack.serverLogger.logMessage(sipMessage, this
                        .getPeerHostPort().toString(), this.getHost() + ":"
                        + this.myPort, false, receptionTime);

            }
            ServerRequestInterface sipServerRequest = sipStack
                    .newSIPServerRequest(sipRequest, this);
            // Drop it if there is no request returned
            if (sipServerRequest == null) {
                if (sipStack.isLoggingEnabled()) {
                    this.sipStack.getStackLogger()
                            .logWarning("Null request interface returned -- dropping request");
                }

                return;
            }
            if (sipStack.isLoggingEnabled())
                this.sipStack.getStackLogger().logDebug("About to process "
                        + sipRequest.getFirstLine() + "/" + sipServerRequest);
            try {
                sipServerRequest.processRequest(sipRequest, this);
            } finally {
                if (sipServerRequest instanceof SIPTransaction) {
                    SIPServerTransaction sipServerTx = (SIPServerTransaction) sipServerRequest;
                    if (!sipServerTx.passToListener()) {
                        ((SIPTransaction) sipServerRequest).releaseSem();
                    }
                }
            }
            if (sipStack.isLoggingEnabled())
                this.sipStack.getStackLogger().logDebug("Done processing "
                        + sipRequest.getFirstLine() + "/" + sipServerRequest);

            // So far so good -- we will commit this message if
            // all processing is OK.

        } else {
            // Handle a SIP Reply message.
            SIPResponse sipResponse = (SIPResponse) sipMessage;
            try {
                sipResponse.checkHeaders();
            } catch (ParseException ex) {
                if (sipStack.isLoggingEnabled())
                    sipStack.getStackLogger()
                            .logError("Dropping Badly formatted response message >>> "
                                    + sipResponse);
                return;
            }
            ServerResponseInterface sipServerResponse = sipStack
                    .newSIPServerResponse(sipResponse, this);
            if (sipServerResponse != null) {
                try {
                    if (sipServerResponse instanceof SIPClientTransaction
                            && !((SIPClientTransaction) sipServerResponse)
                                    .checkFromTag(sipResponse)) {
                        if (sipStack.isLoggingEnabled())
                            sipStack.getStackLogger()
                                    .logError("Dropping response message with invalid tag >>> "
                                            + sipResponse);
                        return;
                    }

                    sipServerResponse.processResponse(sipResponse, this);
                } finally {
                    if (sipServerResponse instanceof SIPTransaction
                            && !((SIPTransaction) sipServerResponse)
                                    .passToListener())
                        ((SIPTransaction) sipServerResponse).releaseSem();
                }

                // Normal processing of message.
            } else {
                if (sipStack.isLoggingEnabled()) {
                    this.sipStack.getStackLogger().logDebug("null sipServerResponse!");
                }
            }

        }
    }

    /**
     * JvB: added method to check for known buggy clients (Windows Messenger) to
     * fix the port to which responses are sent
     *
     * checks for User-Agent: RTC/1.3.5470 (Messenger 5.1.0701)
     *
     * JvB 22/7/2006 better to take this out for the moment, it is only a
     * problem in rare cases (unregister)
     *
     * private final boolean isBuggyClient( SIPRequest r ) { UserAgent uah =
     * (UserAgent) r.getHeader( UserAgent.NAME ); if (uah!=null) {
     * java.util.ListIterator i = uah.getProduct(); if (i.hasNext()) { String p =
     * (String) uah.getProduct().next(); return p.startsWith( "RTC" ); } }
     * return false; }
     */

    /**
     * Implementation of the ParseExceptionListener interface.
     *
     * @param ex
     *            Exception that is given to us by the parser.
     * @throws ParseException
     *             If we choose to reject the header or message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.447 -0500", hash_original_method = "148F3D833D327E61A5116C1FE99BCAC0", hash_generated_method = "1DCC4F339640A2676A62F39974DC3ED7")
    
public void handleException(ParseException ex, SIPMessage sipMessage,
            Class hdrClass, String header, String message)
            throws ParseException {
        if (sipStack.isLoggingEnabled())
            this.sipStack.getStackLogger().logException(ex);
        // Log the bad message for later reference.
        if ((hdrClass != null)
                && (hdrClass.equals(From.class) || hdrClass.equals(To.class)
                        || hdrClass.equals(CSeq.class)
                        || hdrClass.equals(Via.class)
                        || hdrClass.equals(CallID.class)
                        || hdrClass.equals(RequestLine.class) || hdrClass
                        .equals(StatusLine.class))) {
        	if (sipStack.isLoggingEnabled()) {
        		sipStack.getStackLogger().logError("BAD MESSAGE!");
            	sipStack.getStackLogger().logError(message);
        	}
            throw ex;
        } else {
            sipMessage.addUnparsed(header);
        }
    }

    /**
     * Return a reply from a pre-constructed reply. This sends the message back
     * to the entity who caused us to create this channel in the first place.
     *
     * @param sipMessage
     *            Message string to send.
     * @throws IOException
     *             If there is a problem with sending the message.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.450 -0500", hash_original_method = "5949601888B92CAB7F6BB9E6373E9083", hash_generated_method = "CA5DED15EEDBEE2F93349DDF45384D85")
    
public void sendMessage(SIPMessage sipMessage) throws IOException {
        if (sipStack.isLoggingEnabled() && this.sipStack.isLogStackTraceOnMessageSend()) {
            if ( sipMessage instanceof SIPRequest &&
                    ((SIPRequest)sipMessage).getRequestLine() != null) {
                /*
                 * We dont want to log empty trace messages.
                 */
                this.sipStack.getStackLogger().logStackTrace(StackLogger.TRACE_INFO);
            } else {
                this.sipStack.getStackLogger().logStackTrace(StackLogger.TRACE_INFO);
            }
        }

        // Test and see where we are going to send the messsage. If the message
        // is sent back to oursleves, just
        // shortcircuit processing.
        long time = System.currentTimeMillis();
        try {
            for (MessageProcessor messageProcessor : sipStack
                    .getMessageProcessors()) {
                if (messageProcessor.getIpAddress().equals(this.peerAddress)
                        && messageProcessor.getPort() == this.peerPort
                        && messageProcessor.getTransport().equals(
                                this.peerProtocol)) {
                    MessageChannel messageChannel = messageProcessor
                            .createMessageChannel(this.peerAddress,
                                    this.peerPort);
                    if (messageChannel instanceof RawMessageChannel) {
                        ((RawMessageChannel) messageChannel)
                                .processMessage(sipMessage);
                        if (sipStack.isLoggingEnabled())
                        	sipStack.getStackLogger().logDebug("Self routing message");
                        return;
                    }

                }
            }

            byte[] msg = sipMessage.encodeAsBytes( this.getTransport() );

            sendMessage(msg, peerAddress, peerPort, peerProtocol,
                    sipMessage instanceof SIPRequest);

        } catch (IOException ex) {
            throw ex;
        } catch (Exception ex) {
            sipStack.getStackLogger().logError("An exception occured while sending message",ex);
            throw new IOException(
                    "An exception occured while sending message");
        } finally {
            if (sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES) && !sipMessage.isNullRequest())
                logMessage(sipMessage, peerAddress, peerPort, time);
            else if (sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_DEBUG))
                sipStack.getStackLogger().logDebug("Sent EMPTY Message");
        }
    }

    /**
     * Send a message to a specified receiver address.
     *
     * @param msg
     *            string to send.
     * @param peerAddress
     *            Address of the place to send it to.
     * @param peerPort
     *            the port to send it to.
     * @throws IOException
     *             If there is trouble sending this message.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.455 -0500", hash_original_method = "E29573D85212414C15B5600ED44221C0", hash_generated_method = "45AB3E76A33739E95CE9CE6CD6FCDA89")
    
protected void sendMessage(byte[] msg, InetAddress peerAddress,
            int peerPort, boolean reConnect) throws IOException {
        // Via is not included in the request so silently drop the reply.
        if (sipStack.isLoggingEnabled() && this.sipStack.isLogStackTraceOnMessageSend() ) {
            this.sipStack.getStackLogger().logStackTrace(StackLogger.TRACE_INFO);
        }
        if (peerPort == -1) {
            if (sipStack.isLoggingEnabled()) {
                this.sipStack.getStackLogger().logDebug(getClass().getName()
                        + ":sendMessage: Dropping reply!");
            }
            throw new IOException("Receiver port not set ");
        } else {
            if (sipStack.isLoggingEnabled()) {
                this.sipStack.getStackLogger().logDebug("sendMessage " + peerAddress.getHostAddress() + "/"
                        + peerPort + "\n" + "messageSize =  "  + msg.length + " message = " + new String(msg)) ;
                this.sipStack.getStackLogger().logDebug("*******************\n");
            }

        }
        DatagramPacket reply = new DatagramPacket(msg, msg.length, peerAddress,
                peerPort);
        try {
            DatagramSocket sock;
            boolean created = false;

            if (sipStack.udpFlag) {
                // Use the socket from the message processor (for firewall
                // support use the same socket as the message processor
                // socket -- feature request # 18 from java.net). This also
                // makes the whole thing run faster!
                sock = ((UDPMessageProcessor) messageProcessor).sock;

                // Bind the socket to the stack address in case there
                // are multiple interfaces on the machine (feature reqeust
                // by Will Scullin) 0 binds to an ephemeral port.
                // sock = new DatagramSocket(0,sipStack.stackInetAddress);
            } else {
                // bind to any interface and port.
                sock = new DatagramSocket();
                created = true;
            }
            sock.send(reply);
            if (created)
                sock.close();
        } catch (IOException ex) {
            throw ex;
        } catch (Exception ex) {
            InternalErrorHandler.handleException(ex);
        }
    }

    /**
     * Send a message to a specified receiver address.
     *
     * @param msg
     *            message string to send.
     * @param peerAddress
     *            Address of the place to send it to.
     * @param peerPort
     *            the port to send it to.
     * @param peerProtocol
     *            protocol to use to send.
     * @throws IOException
     *             If there is trouble sending this message.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.459 -0500", hash_original_method = "38908DF8BAD797C5C3B9904DFAB1ABDF", hash_generated_method = "59B899B6291A4C7B230D2ED5A9CCDA94")
    
protected void sendMessage(byte[] msg, InetAddress peerAddress,
            int peerPort, String peerProtocol, boolean retry)
            throws IOException {
        // Via is not included in the request so silently drop the reply.
        if (peerPort == -1) {
            if (sipStack.isLoggingEnabled()) {
                this.sipStack.getStackLogger().logDebug(getClass().getName()
                        + ":sendMessage: Dropping reply!");
            }
            throw new IOException("Receiver port not set ");
        } else {
            if (sipStack.isLoggingEnabled()) {
                this.sipStack.getStackLogger().logDebug( ":sendMessage " + peerAddress.getHostAddress() + "/"
                        + peerPort + "\n" + " messageSize = " + msg.length);
            }
        }
        if (peerProtocol.compareToIgnoreCase("UDP") == 0) {
            DatagramPacket reply = new DatagramPacket(msg, msg.length,
                    peerAddress, peerPort);

            try {
                DatagramSocket sock;
                if (sipStack.udpFlag) {
                    sock = ((UDPMessageProcessor) messageProcessor).sock;

                } else {
                    // bind to any interface and port.
                    sock = sipStack.getNetworkLayer().createDatagramSocket();
                }
                if (sipStack.isLoggingEnabled()) {
                    this.sipStack.getStackLogger().logDebug("sendMessage "
                            + peerAddress.getHostAddress() + "/" + peerPort
                            + "\n" + new String(msg));
                }
                sock.send(reply);
                if (!sipStack.udpFlag)
                    sock.close();
            } catch (IOException ex) {
                throw ex;
            } catch (Exception ex) {
                InternalErrorHandler.handleException(ex);
            }

        } else {
            // Use TCP to talk back to the sender.
            Socket outputSocket = sipStack.ioHandler.sendBytes(
                    this.messageProcessor.getIpAddress(), peerAddress,
                    peerPort, "tcp", msg, retry,this);
            OutputStream myOutputStream = outputSocket.getOutputStream();
            myOutputStream.write(msg, 0, msg.length);
            myOutputStream.flush();
            // The socket is cached (dont close it!);
        }
    }

    /**
     * get the stack pointer.
     *
     * @return The sip stack for this channel.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.462 -0500", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "7DFF2B9EFB272B5F349D68AD73E9A18C")
    
public SIPTransactionStack getSIPStack() {
        return sipStack;
    }

    /**
     * Return a transport string.
     *
     * @return the string "udp" in this case.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.464 -0500", hash_original_method = "B7A5D479C43293000A9EAFE6F93DF6D0", hash_generated_method = "B57FF53F26536E4C501842CE5287A618")
    
public String getTransport() {
        return SIPConstants.UDP;
    }

    /**
     * get the stack address for the stack that received this message.
     *
     * @return The stack address for our sipStack.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.467 -0500", hash_original_method = "EA072AA1AE1B409D48E6BC6990EBDEC5", hash_generated_method = "EE16D1D8C9AE581ED2CCA97AC6535DF6")
    
public String getHost() {
        return messageProcessor.getIpAddress().getHostAddress();
    }

    /**
     * get the port.
     *
     * @return Our port (on which we are getting datagram packets).
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.469 -0500", hash_original_method = "891FD85C4A46ECEDCCE8E5933BDC3ADD", hash_generated_method = "DCC1945BA7447A8694B492C43AC047C1")
    
public int getPort() {
        return ((UDPMessageProcessor) messageProcessor).getPort();
    }

    /**
     * get the name (address) of the host that sent me the message
     *
     * @return The name of the sender (from the datagram packet).
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.473 -0500", hash_original_method = "86CAA293F63DFC3CC87A4ACD6BC27DDA", hash_generated_method = "CEEABD187B992E552A2F75ABEE69FD52")
    
public String getPeerName() {
        return peerAddress.getHostName();
    }

    /**
     * get the address of the host that sent me the message
     *
     * @return The senders ip address.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.476 -0500", hash_original_method = "A07C7EAAB254DF7A2A64ECDA7F650470", hash_generated_method = "85684F6812C32531656E4D13F9F6C173")
    
public String getPeerAddress() {
        return peerAddress.getHostAddress();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.479 -0500", hash_original_method = "1F29EC3BC94C3E0863F530FCD37A61F3", hash_generated_method = "5D52F16A6CD419A72363BEE2FA3651BF")
    
protected InetAddress getPeerInetAddress() {
        return peerAddress;
    }

    /**
     * Compare two UDP Message channels for equality.
     *
     * @param other
     *            The other message channel with which to compare oursleves.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.482 -0500", hash_original_method = "3F01B3F60F79E6CB5C3DF3B66FDD88DE", hash_generated_method = "943E61EA1E8D9909869C845CB85685D1")
    
public boolean equals(Object other) {

        if (other == null)
            return false;
        boolean retval;
        if (!this.getClass().equals(other.getClass())) {
            retval = false;
        } else {
            UDPMessageChannel that = (UDPMessageChannel) other;
            retval = this.getKey().equals(that.getKey());
        }

        return retval;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.484 -0500", hash_original_method = "8A0A97143B2090B701AABAA2A97E73FB", hash_generated_method = "59F690BF8E95F42C1CA01C43B567E0DD")
    
public String getKey() {
        return getKey(peerAddress, peerPort, "UDP");
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.487 -0500", hash_original_method = "66F44212C04D4B032E5D57BC9126F4FF", hash_generated_method = "F40B7BBDADE2EDD9E4FFD8062E730749")
    
public int getPeerPacketSourcePort() {
        return peerPacketSourcePort;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.490 -0500", hash_original_method = "DC065FB3DE06142DBC04F100FD01BCF3", hash_generated_method = "701FF88A1C843AC53C75CCA208A2C7BF")
    
public InetAddress getPeerPacketSourceAddress() {
        return peerPacketSourceAddress;
    }

    /**
     * Get the logical originator of the message (from the top via header).
     *
     * @return topmost via header sentby field
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.493 -0500", hash_original_method = "B7C8CBECE48532207EA3107C3752BABB", hash_generated_method = "23B273ABD579FDAD40680D771CF63201")
    
public String getViaHost() {
        return this.myAddress;
    }

    /**
     * Get the logical port of the message orginator (from the top via hdr).
     *
     * @return the via port from the topmost via header.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.495 -0500", hash_original_method = "F69C682C43E3A7CF8FCB14E212CB7049", hash_generated_method = "98003D137B978019D797CBA84B76EDD8")
    
public int getViaPort() {
        return this.myPort;
    }

    /**
     * Returns "false" as this is an unreliable transport.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.498 -0500", hash_original_method = "457243F9D7A1AB9FD34866D85709C85D", hash_generated_method = "A39955CCDB637DC031D6F4E12755F242")
    
public boolean isReliable() {
        return false;
    }

    /**
     * UDP is not a secure protocol.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.501 -0500", hash_original_method = "51201694E0EE76265BF39848EF10BE9C", hash_generated_method = "49E6B3D175AEB85C0CC035D6E473FA9A")
    
public boolean isSecure() {
        return false;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.504 -0500", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "0A13911FE5FD34A377B4DEB23C492969")
    
public int getPeerPort() {
        return peerPort;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.507 -0500", hash_original_method = "DB79607DA3ACB5FA2D24428DF2713F98", hash_generated_method = "9EF71D175A0EFE47AE567BEC7BFAC16F")
    
public String getPeerProtocol() {
        return this.peerProtocol;
    }

    /**
     * Close the message channel.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.510 -0500", hash_original_method = "B96EF178F3ED1A0DFACDA94649407E5C", hash_generated_method = "388BFD43642BF851D61AF8A45943A910")
    
public void close() {
    }
    
    class PingBackTimerTask extends TimerTask {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.404 -0500", hash_original_field = "902291576A6EA4536D6C9669E1B1BFD7", hash_generated_field = "902291576A6EA4536D6C9669E1B1BFD7")

        String ipAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.407 -0500", hash_original_field = "5A948EF636511EF149269A68FE278AED", hash_generated_field = "5A948EF636511EF149269A68FE278AED")

        int port;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.410 -0500", hash_original_method = "041AEFB77EA8D7413831FA09D8E7E5F2", hash_generated_method = "B55AEF49B20D581977398E040DF00CAB")
        
public PingBackTimerTask(String ipAddress, int port) {
            this.ipAddress = ipAddress;
            this.port = port;
            pingBackRecord.put(ipAddress + ":" + port, this);
        }
        @DSSpec(DSCat.THREADING)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.413 -0500", hash_original_method = "6BA8F9798D5715ABDAD288256921D45A", hash_generated_method = "EF37FFA55F8CCCD46D3860DFA16198BB")
        
@Override
        public void run() {
           pingBackRecord.remove(ipAddress + ":" + port);
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.416 -0500", hash_original_method = "E214E7BC5755C758A91BCF58AAE3832E", hash_generated_method = "63F2CBC1B172A8153F23BBA3081A9BCD")
        
@Override
        public int hashCode() {
            return (ipAddress + ":" + port).hashCode();
        }
        
    }
    
}

