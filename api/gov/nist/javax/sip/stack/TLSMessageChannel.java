package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.InternalErrorHandler;
import gov.nist.core.ServerLogger;
import gov.nist.javax.sip.header.CSeq;
import gov.nist.javax.sip.header.CallID;
import gov.nist.javax.sip.header.From;
import gov.nist.javax.sip.header.RequestLine;
import gov.nist.javax.sip.header.RetryAfter;
import gov.nist.javax.sip.header.StatusLine;
import gov.nist.javax.sip.header.To;
import gov.nist.javax.sip.header.Via;
import gov.nist.javax.sip.header.ViaList;
import gov.nist.javax.sip.message.SIPMessage;
import gov.nist.javax.sip.message.SIPRequest;
import gov.nist.javax.sip.message.SIPResponse;
import gov.nist.javax.sip.parser.Pipeline;
import gov.nist.javax.sip.parser.PipelinedMsgParser;
import gov.nist.javax.sip.parser.SIPMessageListener;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.text.ParseException;

import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSocket;
import javax.sip.address.Hop;
import javax.sip.message.Response;

public final class TLSMessageChannel extends MessageChannel implements SIPMessageListener, Runnable, RawMessageChannel {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.326 -0500", hash_original_field = "006AACAB5CA0A59B60C0698E11256579", hash_generated_field = "F3B00F7E70704D963CC4197CD003FB94")

    private Socket mySock;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.328 -0500", hash_original_field = "EE9A4E61A45003F22C7BC5B410BBB21B", hash_generated_field = "152EC54D2111EF26096DF65FC2003536")

    private PipelinedMsgParser myParser;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.330 -0500", hash_original_field = "C33F72CD488CC5F94B8A9826AF3A10FA", hash_generated_field = "E9FA88EF5BFDD4D9156AADE5BC087A4C")

    private InputStream myClientInputStream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.333 -0500", hash_original_field = "FFE7EE17DFA37A68070A0F0495753B29", hash_generated_field = "2E3018221E30480EB0F957E72002C7D8")

    private String key;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.336 -0500", hash_original_field = "BD96B1F139C8EA198B3A1B2CA97B93E5", hash_generated_field = "F8E96F7362B3E7CD3DE3A2778DC87A58")

    protected boolean isCached;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.339 -0500", hash_original_field = "5EBE085FDB38216257993802E75ABBBF", hash_generated_field = "911E18F9BE05473489F5F21C894DF579")

    protected boolean isRunning;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.341 -0500", hash_original_field = "4AB983356694FB1E44D4AE16E3897B0E", hash_generated_field = "8890F3B68DD2F65EEDEBEEF6284B3EE1")

    private Thread mythread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.344 -0500", hash_original_field = "95EABD5ABD88E35E559B3906991D12AE", hash_generated_field = "DEE18A414D72F7D580E73EF519B5B75F")

    private String myAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.346 -0500", hash_original_field = "05A0D771A4A24E58EF91191716865F5C", hash_generated_field = "1FBEE69CBCB5E71F900C5C964DA7ADBD")

    private int myPort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.349 -0500", hash_original_field = "366B1D4629185E73902FFD7D04A7B174", hash_generated_field = "DB2440387A41D5016778DA700632E003")

    private InetAddress peerAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.351 -0500", hash_original_field = "A714E58FF483C2E33F156CBA7BFCD38B", hash_generated_field = "FE74A5BA5CFBB5B6DC2B68FEFA76ECFC")

    private int peerPort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.354 -0500", hash_original_field = "D89E736D3DD25A80B53E476FF3F84027", hash_generated_field = "EB665B7537D07145A6FCAD2DB460EADC")

    private String peerProtocol;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.357 -0500", hash_original_field = "8C9C66875AA77DCCEA8FD6E102FFE9B0", hash_generated_field = "22DB078A43570EA85ED1A7B10A8E17F9")

    // to the message channel and decremented when
    // a transaction gets freed from the message channel.
    // protected int useCount = 0;

    private TLSMessageProcessor tlsMessageProcessor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.359 -0500", hash_original_field = "A4B05DD1A2BDFAA2E8FCD10E8D1815B6", hash_generated_field = "ABE627693A01BDDC6597F9AB66B3018E")

    private SIPTransactionStack sipStack;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.362 -0500", hash_original_field = "F04B5F27AF029E00FAA2AA5974D7257C", hash_generated_field = "12E7910E7EDE55EAF4A3D89EE23A6BC7")

    private HandshakeCompletedListener handshakeCompletedListener;

    /**
     * Constructor - gets called from the SIPStack class with a socket on accepting a new client.
     * All the processing of the message is done here with the sipStack being freed up to handle
     * new connections. The sock input is the socket that is returned from the accept. Global data
     * that is shared by all threads is accessible in the Server structure.
     *
     * @param sock Socket from which to read and write messages. The socket is already connected
     *        (was created as a result of an accept).
     *
     * @param sipStack Ptr to SIP Stack
     *
     * @param msgProcessor -- the message processor that created us.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.367 -0500", hash_original_method = "358EB7732CC002B4969C64CA3912C6FF", hash_generated_method = "9EA640E9C7F0BDE75781AC5E9EFDC9B2")
    
protected TLSMessageChannel(Socket sock, SIPTransactionStack sipStack,
            TLSMessageProcessor msgProcessor) throws IOException {
        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug("creating new TLSMessageChannel (incoming)");
            sipStack.getStackLogger().logStackTrace();
        }

        mySock = (SSLSocket) sock;
        if ( sock instanceof SSLSocket ) {
            
            SSLSocket sslSock = (SSLSocket) sock;
            sslSock.setNeedClientAuth(true);
            this.handshakeCompletedListener = new HandshakeCompletedListenerImpl(this);
            sslSock.addHandshakeCompletedListener(this.handshakeCompletedListener);
            sslSock.startHandshake();
       
        }
        
        peerAddress = mySock.getInetAddress();
        myAddress = msgProcessor.getIpAddress().getHostAddress();
        myClientInputStream = mySock.getInputStream();

        mythread = new Thread(this);
        mythread.setDaemon(true);
        mythread.setName("TLSMessageChannelThread");
        // Stash away a pointer to our sipStack structure.
        this.sipStack = sipStack;

        this.tlsMessageProcessor = msgProcessor;
        this.myPort = this.tlsMessageProcessor.getPort();
        this.peerPort = mySock.getPort();
        // Bug report by Vishwashanti Raj Kadiayl
        super.messageProcessor = msgProcessor;
        // Can drop this after response is sent potentially.
        mythread.start();
    }

    /**
     * Constructor - connects to the given inet address.
     *
     * @param inetAddr inet address to connect to.
     * @param sipStack is the sip sipStack from which we are created.
     * @param messageProcessor -- the message processor that created us.
     * @throws IOException if we cannot connect.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.370 -0500", hash_original_method = "36AC589476275C6F111789614D727487", hash_generated_method = "5733A5E81926360CEA3A659E8D6B4332")
    
protected TLSMessageChannel(InetAddress inetAddr, int port, SIPTransactionStack sipStack,
            TLSMessageProcessor messageProcessor) throws IOException {
        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug("creating new TLSMessageChannel (outgoing)");
            sipStack.getStackLogger().logStackTrace();
        }
        this.peerAddress = inetAddr;
        this.peerPort = port;
        this.myPort = messageProcessor.getPort();
        this.peerProtocol = "TLS";
        this.sipStack = sipStack;
        this.tlsMessageProcessor = messageProcessor;
        this.myAddress = messageProcessor.getIpAddress().getHostAddress();
        this.key = MessageChannel.getKey(peerAddress, peerPort, "TLS");
        super.messageProcessor = messageProcessor;

    }

    /**
     * Returns "true" as this is a reliable transport.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.372 -0500", hash_original_method = "16D0E6CF226A4618D75D1B422CC8FCDF", hash_generated_method = "4164740904B2F8F392B631D8C36F225E")
    
public boolean isReliable() {
        return true;
    }

    /**
     * Close the message channel.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.375 -0500", hash_original_method = "9757D034E975DAF9D22BACDE50FF4335", hash_generated_method = "CC8A4E04469C48B2A80B08B87C5C380B")
    
public void close() {
        try {
            if (mySock != null)
                mySock.close();
            if (sipStack.isLoggingEnabled())
                sipStack.getStackLogger().logDebug("Closing message Channel " + this);
        } catch (IOException ex) {
            if (sipStack.isLoggingEnabled())
                sipStack.getStackLogger().logDebug("Error closing socket " + ex);
        }
    }

    /**
     * Get my SIP Stack.
     *
     * @return The SIP Stack for this message channel.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.377 -0500", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "7DFF2B9EFB272B5F349D68AD73E9A18C")
    
public SIPTransactionStack getSIPStack() {
        return sipStack;
    }

    /**
     * get the transport string.
     *
     * @return "tcp" in this case.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.379 -0500", hash_original_method = "00B4B3FBB10028B216605159EFB81D52", hash_generated_method = "782F593E0573BE6260C2A2ABBB36D468")
    
public String getTransport() {
        return "tls";
    }

    /**
     * get the address of the client that sent the data to us.
     *
     * @return Address of the client that sent us data that resulted in this channel being
     *         created.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.383 -0500", hash_original_method = "59CC467573DB54CDCEF540AE63F43735", hash_generated_method = "9F2133D4C6FB347F7422205058E5FC27")
    
public String getPeerAddress() {
        if (peerAddress != null) {
            return peerAddress.getHostAddress();
        } else
            return getHost();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.385 -0500", hash_original_method = "1F29EC3BC94C3E0863F530FCD37A61F3", hash_generated_method = "5D52F16A6CD419A72363BEE2FA3651BF")
    
protected InetAddress getPeerInetAddress() {
        return peerAddress;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.388 -0500", hash_original_method = "DB79607DA3ACB5FA2D24428DF2713F98", hash_generated_method = "9EF71D175A0EFE47AE567BEC7BFAC16F")
    
public String getPeerProtocol() {
        return this.peerProtocol;
    }

    /**
     * Send message to whoever is connected to us. Uses the topmost via address to send to.
     *
     * @param msg is the message to send.
     * @param retry
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.391 -0500", hash_original_method = "769119032395AFB8B9E88BC54405133A", hash_generated_method = "4B6E1E27D98E77409B64EB34497F78A1")
    
private void sendMessage(byte[] msg, boolean retry) throws IOException {
        Socket sock = this.sipStack.ioHandler.sendBytes(
                this.getMessageProcessor().getIpAddress(), this.peerAddress, this.peerPort,
                this.peerProtocol, msg, retry,this);
        // Created a new socket so close the old one and stick the new
        // one in its place but dont do this if it is a datagram socket.
        // (could have replied via udp but received via tcp!).
        if (sock != mySock && sock != null) {
            try {
                if (mySock != null)
                    mySock.close();
            } catch (IOException ex) {
            }
            mySock = sock;
            this.myClientInputStream = mySock.getInputStream();

            Thread thread = new Thread(this);
            thread.setDaemon(true);
            thread.setName("TLSMessageChannelThread");
            thread.start();
        }

    }

    /**
     * Return a formatted message to the client. We try to re-connect with the peer on the other
     * end if possible.
     *
     * @param sipMessage Message to send.
     * @throws IOException If there is an error sending the message
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.393 -0500", hash_original_method = "99193C77E68A5ABE715A7A9AC8040C34", hash_generated_method = "78FECFA4560A366D127A1848EDF5547E")
    
public void sendMessage(SIPMessage sipMessage) throws IOException {
        byte[] msg = sipMessage.encodeAsBytes(this.getTransport());

        long time = System.currentTimeMillis();

        this.sendMessage(msg, sipMessage instanceof SIPRequest);

        if (this.sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES))
            logMessage(sipMessage, peerAddress, peerPort, time);
    }

    /**
     * Send a message to a specified address.
     *
     * @param message Pre-formatted message to send.
     * @param receiverAddress Address to send it to.
     * @param receiverPort Receiver port.
     * @throws IOException If there is a problem connecting or sending.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.397 -0500", hash_original_method = "C6D6B3579ACFAA2466286D67BFFE3003", hash_generated_method = "3EA9DA78911A0C5DA2BC654CEF310065")
    
public void sendMessage(byte message[], InetAddress receiverAddress, int receiverPort,
            boolean retry) throws IOException {
        if (message == null || receiverAddress == null)
            throw new IllegalArgumentException("Null argument");
        Socket sock = this.sipStack.ioHandler.sendBytes(this.messageProcessor.getIpAddress(),
                receiverAddress, receiverPort, "TLS", message, retry, this);
        //
        // Created a new socket so close the old one and s
        // Check for null (bug fix sent in by Christophe)
        if (sock != mySock && sock != null) {
            try {
                if (mySock != null)
                    mySock.close();
            } catch (IOException ex) {
                /* ignore */
            }
            mySock = sock;
            this.myClientInputStream = mySock.getInputStream();

            // start a new reader on this end of the pipe.
            Thread mythread = new Thread(this);
            mythread.setDaemon(true);
            mythread.setName("TLSMessageChannelThread");
            mythread.start();
        }

    }

    /**
     * Exception processor for exceptions detected from the parser. (This is invoked by the parser
     * when an error is detected).
     *
     * @param sipMessage -- the message that incurred the error.
     * @param ex -- parse exception detected by the parser.
     * @param header -- header that caused the error.
     * @throws ParseException Thrown if we want to reject the message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.400 -0500", hash_original_method = "F10EA794C47048E710B5CED57C611CE1", hash_generated_method = "8B97BEA59BFAC404F3B3E7E378DE5766")
    
public void handleException(ParseException ex, SIPMessage sipMessage, Class hdrClass,
            String header, String message) throws ParseException {
        if (sipStack.isLoggingEnabled())
            sipStack.getStackLogger().logException(ex);
        // Log the bad message for later reference.
        if ((hdrClass != null)
                && (hdrClass.equals(From.class) || hdrClass.equals(To.class)
                        || hdrClass.equals(CSeq.class) || hdrClass.equals(Via.class)
                        || hdrClass.equals(CallID.class) || hdrClass.equals(RequestLine.class) || hdrClass
                        .equals(StatusLine.class))) {
        	if (sipStack.isLoggingEnabled())
        		sipStack.getStackLogger().logDebug("Encountered bad message \n" + message);
            // JvB: send a 400 response for requests (except ACK)
            String msgString = sipMessage.toString();
            if (!msgString.startsWith("SIP/") && !msgString.startsWith("ACK ")) {

                String badReqRes = createBadReqRes(msgString, ex);
                if (badReqRes != null) {
                    if (sipStack.isLoggingEnabled()) {
                        sipStack.getStackLogger().logDebug("Sending automatic 400 Bad Request:");
                        sipStack.getStackLogger().logDebug(badReqRes);
                    }
                    try {
                        this.sendMessage(badReqRes.getBytes(), this.getPeerInetAddress(), this
                                .getPeerPort(), false);
                    } catch (IOException e) {
                        this.sipStack.getStackLogger().logException(e);
                    }
                } else {
                    if (sipStack.isLoggingEnabled()) {
                        sipStack.getStackLogger().logDebug(
                                "Could not formulate automatic 400 Bad Request");
                    }
                }
            }
            throw ex;
        } else {
            sipMessage.addUnparsed(header);
        }
    }

    /**
     * Gets invoked by the parser as a callback on successful message parsing (i.e. no parser
     * errors).
     *
     * @param sipMessage Message to process (this calls the application for processing the
     *        message).
     *
     * Jvb: note that this code is identical to TCPMessageChannel, refactor some day
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.407 -0500", hash_original_method = "0B661C1775BD5742177C9AA146CAD19A", hash_generated_method = "91A6F2C697F8646D37959F5B88D7E471")
    
public void processMessage(SIPMessage sipMessage) throws Exception {
        try {
            if (sipMessage.getFrom() == null || sipMessage.getTo() == null
                    || sipMessage.getCallId() == null || sipMessage.getCSeq() == null
                    || sipMessage.getViaHeaders() == null) {
                String badmsg = sipMessage.encode();
                if (sipStack.isLoggingEnabled()) {
                    sipStack.getStackLogger().logError("bad message " + badmsg);
                    sipStack.getStackLogger().logError(">>> Dropped Bad Msg");
                }
                return;
            }

            ViaList viaList = sipMessage.getViaHeaders();
            // For a request
            // first via header tells where the message is coming from.
            // For response, this has already been recorded in the outgoing
            // message.

            if (sipMessage instanceof SIPRequest) {
                Via v = (Via) viaList.getFirst();
                // the peer address and tag it appropriately.
                Hop hop = sipStack.addressResolver.resolveAddress(v.getHop());
                this.peerProtocol = v.getTransport();
                try {
                    this.peerAddress = mySock.getInetAddress();
                    // Check to see if the received parameter matches
                    // JvB: dont do this. It is both costly and incorrect
                    // Must set received also when it is a FQDN, regardless whether
                    // it resolves to the correct IP address
                    // InetAddress sentByAddress = InetAddress.getByName(hop.getHost());
                    // JvB: if sender added 'rport', must always set received
                    if (v.hasParameter(Via.RPORT)
                            || !hop.getHost().equals(this.peerAddress.getHostAddress())) {
                        v.setParameter(Via.RECEIVED, this.peerAddress.getHostAddress());
                    }
                    // @@@ hagai
                    // JvB: technically, may only do this when Via already contains
                    // rport
                    v.setParameter(Via.RPORT, Integer.toString(this.peerPort));
                } catch (java.text.ParseException ex) {
                    InternalErrorHandler.handleException(ex);
                }
                // Use this for outgoing messages as well.
                if (!this.isCached) {
                    ((TLSMessageProcessor) this.messageProcessor).cacheMessageChannel(this);
                    this.isCached = true;
                    String key = IOHandler.makeKey(mySock.getInetAddress(), this.peerPort);
                    sipStack.ioHandler.putSocket(key, mySock);
                }
            }

            // Foreach part of the request header, fetch it and process it

            long receptionTime = System.currentTimeMillis();
            //

            if (sipMessage instanceof SIPRequest) {
                // This is a request - process the request.
                SIPRequest sipRequest = (SIPRequest) sipMessage;
                // Create a new sever side request processor for this
                // message and let it handle the rest.

                if (sipStack.isLoggingEnabled()) {
                    sipStack.getStackLogger().logDebug("----Processing Message---");
                }
                if (this.sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES)) {

                    sipStack.serverLogger.logMessage(sipMessage, this.getPeerHostPort().toString(),
                            this.messageProcessor.getIpAddress().getHostAddress() + ":"
                                    + this.messageProcessor.getPort(), false, receptionTime);

                }
                // Check for reasonable size - reject message
                // if it is too long.
                if (sipStack.getMaxMessageSize() > 0
                        && sipRequest.getSize()
                                + (sipRequest.getContentLength() == null ? 0 : sipRequest
                                        .getContentLength().getContentLength()) > sipStack
                                .getMaxMessageSize()) {
                    SIPResponse sipResponse = sipRequest
                            .createResponse(SIPResponse.MESSAGE_TOO_LARGE);
                    byte[] resp = sipResponse.encodeAsBytes(this.getTransport());
                    this.sendMessage(resp, false);
                    throw new Exception("Message size exceeded");
                }

                // Stack could not create a new server request interface.
                // maybe not enough resources.
                ServerRequestInterface sipServerRequest = sipStack.newSIPServerRequest(
                        sipRequest, this);
                if (sipServerRequest != null) {
                    try {
                        sipServerRequest.processRequest(sipRequest, this);
                    } finally {
                        if (sipServerRequest instanceof SIPTransaction) {
                            SIPServerTransaction sipServerTx = (SIPServerTransaction) sipServerRequest;
                            if (!sipServerTx.passToListener())
                                ((SIPTransaction) sipServerRequest).releaseSem();
                        }
                    }
                } else {
                    SIPResponse response = sipRequest
                            .createResponse(Response.SERVICE_UNAVAILABLE);

                    RetryAfter retryAfter = new RetryAfter();

                    // Be a good citizen and send a decent response code back.
                    try {
                        retryAfter.setRetryAfter((int) (10 * (Math.random())));
                        response.setHeader(retryAfter);
                        this.sendMessage(response);
                    } catch (Exception e) {
                        // IGNore
                    }
                    if (sipStack.isLoggingEnabled())
                    	sipStack.getStackLogger()
                            .logWarning("Dropping message -- could not acquire semaphore");
                }
            } else {
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
                // This is a response message - process it.
                // Check the size of the response.
                // If it is too large dump it silently.
                if (sipStack.getMaxMessageSize() > 0
                        && sipResponse.getSize()
                                + (sipResponse.getContentLength() == null ? 0 : sipResponse
                                        .getContentLength().getContentLength()) > sipStack
                                .getMaxMessageSize()) {
                    if (sipStack.isLoggingEnabled())
                        this.sipStack.getStackLogger().logDebug("Message size exceeded");
                    return;

                }
                ServerResponseInterface sipServerResponse = sipStack.newSIPServerResponse(
                        sipResponse, this);
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
                                && !((SIPTransaction) sipServerResponse).passToListener()) {
                            // Note that the semaphore is released in event
                            // scanner if the
                            // request is actually processed by the Listener.
                            ((SIPTransaction) sipServerResponse).releaseSem();
                        }
                    }
                } else {
                    sipStack.getStackLogger().logWarning("Could not get semaphore... dropping response");
                }
            }
        } finally {
        }
    }

    /**
     * This gets invoked when thread.start is called from the constructor. Implements a message
     * loop - reading the tcp connection and processing messages until we are done or the other
     * end has closed.
     */
    @DSSpec(DSCat.THREADING)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.412 -0500", hash_original_method = "F77124F9292782877CB3E3F72C9E9606", hash_generated_method = "F1609395238F2771DE73F4C4A5FE02DB")
    
public void run() {
        Pipeline hispipe = null;
        // Create a pipeline to connect to our message parser.
        hispipe = new Pipeline(myClientInputStream, sipStack.readTimeout,
                ((SIPTransactionStack) sipStack).getTimer());
        // Create a pipelined message parser to read and parse
        // messages that we write out to him.
        myParser = new PipelinedMsgParser(this, hispipe, this.sipStack.getMaxMessageSize());
        // Start running the parser thread.
        myParser.processInput();
        // bug fix by Emmanuel Proulx
        int bufferSize = 4096;
        this.tlsMessageProcessor.useCount++;
        this.isRunning = true;
        try {
            while (true) {
                try {
                    byte[] msg = new byte[bufferSize];
                    int nbytes = myClientInputStream.read(msg, 0, bufferSize);
                    // no more bytes to read...
                    if (nbytes == -1) {
                        hispipe.write("\r\n\r\n".getBytes("UTF-8"));
                        try {
                            if (sipStack.maxConnections != -1) {
                                synchronized (tlsMessageProcessor) {
                                    tlsMessageProcessor.nConnections--;
                                    tlsMessageProcessor.notify();
                                }
                            }
                            hispipe.close();
                            mySock.close();
                        } catch (IOException ioex) {
                        }
                        return;
                    }
                    hispipe.write(msg, 0, nbytes);

                } catch (IOException ex) {
                    // Terminate the message.
                    try {
                        hispipe.write("\r\n\r\n".getBytes("UTF-8"));
                    } catch (Exception e) {
                        // InternalErrorHandler.handleException(e);
                    }

                    try {
                        if (sipStack.isLoggingEnabled())
                            sipStack.getStackLogger().logDebug("IOException  closing sock " + ex);
                        try {
                            if (sipStack.maxConnections != -1) {
                                synchronized (tlsMessageProcessor) {
                                    tlsMessageProcessor.nConnections--;
                                    tlsMessageProcessor.notify();
                                }
                            }
                            mySock.close();
                            hispipe.close();
                        } catch (IOException ioex) {
                        }
                    } catch (Exception ex1) {
                        // Do nothing.
                    }
                    return;
                } catch (Exception ex) {
                    InternalErrorHandler.handleException(ex);
                }
            }
        } finally {
            this.isRunning = false;
            this.tlsMessageProcessor.remove(this);
            this.tlsMessageProcessor.useCount--;
            this.myParser.close();
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.415 -0500", hash_original_method = "C5292C7D09796AA7B556BAA154B95B16", hash_generated_method = "BD93551E34D7C47609C6DBF3A3ED8ECE")
    
protected void uncache() {
    	if (isCached && !isRunning) {    	
    		this.tlsMessageProcessor.remove(this);
    	}
    }

    /**
     * Equals predicate.
     *
     * @param other is the other object to compare ourselves to for equals
     */

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.418 -0500", hash_original_method = "DA67C78A7E91B7C25B2E6DD841A2A96C", hash_generated_method = "3A2F7DCB6D495BDAC75EAF9113B49DE4")
    
public boolean equals(Object other) {

        if (!this.getClass().equals(other.getClass()))
            return false;
        else {
            TLSMessageChannel that = (TLSMessageChannel) other;
            if (this.mySock != that.mySock)
                return false;
            else
                return true;
        }
    }

    /**
     * Get an identifying key. This key is used to cache the connection and re-use it if
     * necessary.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.421 -0500", hash_original_method = "1173AC840F0483E84550BBD280ADF1B8", hash_generated_method = "9B7CA0AFCF8E3F67D3100F3FE613CAB5")
    
public String getKey() {
        if (this.key != null) {
            return this.key;
        } else {
            this.key = MessageChannel.getKey(this.peerAddress, this.peerPort, "TLS");
            return this.key;
        }
    }

    /**
     * Get the host to assign to outgoing messages.
     *
     * @return the host to assign to the via header.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.424 -0500", hash_original_method = "11E5C6A8F9691D7C5E18B4FE0A22A301", hash_generated_method = "A32908C6F29B2EE33FC97F7538D4E3FD")
    
public String getViaHost() {
        return myAddress;
    }

    /**
     * Get the port for outgoing messages sent from the channel.
     *
     * @return the port to assign to the via header.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.426 -0500", hash_original_method = "97574FAF366AF2CA74D034931ECBD71B", hash_generated_method = "8533896DB431C404012D38DE1B352FB2")
    
public int getViaPort() {
        return myPort;
    }

    /**
     * Get the port of the peer to whom we are sending messages.
     *
     * @return the peer port.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.429 -0500", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "0A13911FE5FD34A377B4DEB23C492969")
    
public int getPeerPort() {
        return peerPort;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.432 -0500", hash_original_method = "B210BD4A713B5B982D229CB138437A53", hash_generated_method = "AB9F04CA8BBEA5303DDE8F8F43FD108C")
    
public int getPeerPacketSourcePort() {
        return this.peerPort;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.434 -0500", hash_original_method = "97EAFF51EEE94208DA244D522468157C", hash_generated_method = "7DCFF16CB125E09C777FD38FD05E4A92")
    
public InetAddress getPeerPacketSourceAddress() {
        return this.peerAddress;
    }

    /**
     * TLS Is a secure protocol.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.436 -0500", hash_original_method = "57D47F2F9FCDF87C613C3BEA50BCDEDC", hash_generated_method = "DDFD1156A672B3D06EE42F0698E0914D")
    
public boolean isSecure() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.439 -0500", hash_original_method = "17DB109E74C9C419B95A49BDAE918BA7", hash_generated_method = "F4A83D18E58AADCA71ADD8F2EC0F3DCB")
    
public void setHandshakeCompletedListener(
            HandshakeCompletedListener handshakeCompletedListenerImpl) {
        this.handshakeCompletedListener = handshakeCompletedListenerImpl;
    }

    /**
     * @return the handshakeCompletedListener
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.442 -0500", hash_original_method = "6CFE0616A7B6D8A833DC048924F270CA", hash_generated_method = "3D505FC49DE0E7335C077C4492D926AF")
    
public HandshakeCompletedListenerImpl getHandshakeCompletedListener() {
        return (HandshakeCompletedListenerImpl) handshakeCompletedListener;
    }
    
}

