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
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.text.ParseException;
import java.util.TimerTask;

import javax.sip.address.Hop;






public class TCPMessageChannel extends MessageChannel implements SIPMessageListener, Runnable, RawMessageChannel {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.037 -0500", hash_original_field = "006AACAB5CA0A59B60C0698E11256579", hash_generated_field = "F3B00F7E70704D963CC4197CD003FB94")


    private Socket mySock;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.039 -0500", hash_original_field = "EE9A4E61A45003F22C7BC5B410BBB21B", hash_generated_field = "152EC54D2111EF26096DF65FC2003536")


    private PipelinedMsgParser myParser;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.042 -0500", hash_original_field = "C33F72CD488CC5F94B8A9826AF3A10FA", hash_generated_field = "5631DED65C3B5D9167CB9D9A47D5D03A")


    protected InputStream myClientInputStream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.045 -0500", hash_original_field = "4B28321D1FF1639C509C56A90A4999E3", hash_generated_field = "7FAB60C2DCAEF3BF5FBD0260A9FAB955")


    protected OutputStream myClientOutputStream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.047 -0500", hash_original_field = "FFE7EE17DFA37A68070A0F0495753B29", hash_generated_field = "32361AD5112AD88D374E45078833A152")


    protected String key;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.051 -0500", hash_original_field = "BD96B1F139C8EA198B3A1B2CA97B93E5", hash_generated_field = "F8E96F7362B3E7CD3DE3A2778DC87A58")


    protected boolean isCached;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.053 -0500", hash_original_field = "5EBE085FDB38216257993802E75ABBBF", hash_generated_field = "911E18F9BE05473489F5F21C894DF579")


    protected boolean isRunning;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.056 -0500", hash_original_field = "4AB983356694FB1E44D4AE16E3897B0E", hash_generated_field = "8890F3B68DD2F65EEDEBEEF6284B3EE1")


    private Thread mythread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.059 -0500", hash_original_field = "A4B05DD1A2BDFAA2E8FCD10E8D1815B6", hash_generated_field = "3233C5012C49C796F9D6BBC8E02EAB41")


    protected SIPTransactionStack sipStack;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.062 -0500", hash_original_field = "95EABD5ABD88E35E559B3906991D12AE", hash_generated_field = "52302EBB56B387342DED9EB749307DE1")


    protected String myAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.065 -0500", hash_original_field = "05A0D771A4A24E58EF91191716865F5C", hash_generated_field = "AD61806C610E09EDA888D5EC477B22F2")


    protected int myPort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.067 -0500", hash_original_field = "366B1D4629185E73902FFD7D04A7B174", hash_generated_field = "5F6E05F1C4EB951C3527127A288505CA")


    protected InetAddress peerAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.070 -0500", hash_original_field = "A714E58FF483C2E33F156CBA7BFCD38B", hash_generated_field = "6A69B321E52130622ADD35A2A3F00BA6")


    protected int peerPort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.073 -0500", hash_original_field = "D89E736D3DD25A80B53E476FF3F84027", hash_generated_field = "FBF73E4EC3FC246E9E63B41E9D9708E4")


    protected String peerProtocol;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.076 -0500", hash_original_field = "2A83245B93DFA8ECE7918F284096BA09", hash_generated_field = "DD392AF0D4972ACB9F10857C1DDE0D47")

    // to the message channel and decremented when
    // a transaction gets freed from the message channel.
    // protected int useCount;

    private TCPMessageProcessor tcpMessageProcessor;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.079 -0500", hash_original_method = "A2B275A41CF549D2A1285292B7E5107C", hash_generated_method = "49C346726553FA6CD43C03698B902CFE")
    
protected TCPMessageChannel(SIPTransactionStack sipStack) {
        this.sipStack = sipStack;

    }

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
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.082 -0500", hash_original_method = "5A50CDCBFA2341437DDE39E7C9C5EE35", hash_generated_method = "15700E13652FC18AF29252E3D4E29A97")
    
protected TCPMessageChannel(Socket sock, SIPTransactionStack sipStack,
            TCPMessageProcessor msgProcessor) throws IOException {

        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug("creating new TCPMessageChannel ");
            sipStack.getStackLogger().logStackTrace();
        }
        mySock = sock;
        peerAddress = mySock.getInetAddress();
        myAddress = msgProcessor.getIpAddress().getHostAddress();
        myClientInputStream = mySock.getInputStream();
        myClientOutputStream = mySock.getOutputStream();
        mythread = new Thread(this);
        mythread.setDaemon(true);
        mythread.setName("TCPMessageChannelThread");
        // Stash away a pointer to our sipStack structure.
        this.sipStack = sipStack;
        this.peerPort = mySock.getPort();

        this.tcpMessageProcessor = msgProcessor;
        this.myPort = this.tcpMessageProcessor.getPort();
        // Bug report by Vishwashanti Raj Kadiayl
        super.messageProcessor = msgProcessor;
        // Can drop this after response is sent potentially.
        mythread.start();
    }

    /**
     * Constructor - connects to the given inet address. Acknowledgement -- Lamine Brahimi (IBM
     * Zurich) sent in a bug fix for this method. A thread was being uncessarily created.
     * 
     * @param inetAddr inet address to connect to.
     * @param sipStack is the sip sipStack from which we are created.
     * @throws IOException if we cannot connect.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.086 -0500", hash_original_method = "C53C1DE79ECD9DAACE8708608E931C74", hash_generated_method = "F817246726EEB81B97482C67AC59CE14")
    
protected TCPMessageChannel(InetAddress inetAddr, int port, SIPTransactionStack sipStack,
            TCPMessageProcessor messageProcessor) throws IOException {
        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug("creating new TCPMessageChannel ");
            sipStack.getStackLogger().logStackTrace();
        }
        this.peerAddress = inetAddr;
        this.peerPort = port;
        this.myPort = messageProcessor.getPort();
        this.peerProtocol = "TCP";
        this.sipStack = sipStack;
        this.tcpMessageProcessor = messageProcessor;
        this.myAddress = messageProcessor.getIpAddress().getHostAddress();
        // Bug report by Vishwashanti Raj Kadiayl
        this.key = MessageChannel.getKey(peerAddress, peerPort, "TCP");
        super.messageProcessor = messageProcessor;

    }

    /**
     * Returns "true" as this is a reliable transport.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.088 -0500", hash_original_method = "16D0E6CF226A4618D75D1B422CC8FCDF", hash_generated_method = "4164740904B2F8F392B631D8C36F225E")
    
public boolean isReliable() {
        return true;
    }

    /**
     * Close the message channel.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.091 -0500", hash_original_method = "D9B233459FD7A72AC548D3BF0383246D", hash_generated_method = "CDA42B6FAB87B8BB16F41AF58F74C0B3")
    
public void close() {
        try {
            if (mySock != null) {
                mySock.close();
                mySock = null;
            }
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.094 -0500", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "7DFF2B9EFB272B5F349D68AD73E9A18C")
    
public SIPTransactionStack getSIPStack() {
        return sipStack;
    }

    /**
     * get the transport string.
     * 
     * @return "tcp" in this case.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.097 -0500", hash_original_method = "0D1837A773C1185791E8B7504B01CB2E", hash_generated_method = "1005EB85E00A3CEC104B2FA3A6E24B3A")
    
public String getTransport() {
        return "TCP";
    }

    /**
     * get the address of the client that sent the data to us.
     * 
     * @return Address of the client that sent us data that resulted in this channel being
     *         created.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.099 -0500", hash_original_method = "59CC467573DB54CDCEF540AE63F43735", hash_generated_method = "9F2133D4C6FB347F7422205058E5FC27")
    
public String getPeerAddress() {
        if (peerAddress != null) {
            return peerAddress.getHostAddress();
        } else
            return getHost();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.103 -0500", hash_original_method = "1F29EC3BC94C3E0863F530FCD37A61F3", hash_generated_method = "5D52F16A6CD419A72363BEE2FA3651BF")
    
protected InetAddress getPeerInetAddress() {
        return peerAddress;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.106 -0500", hash_original_method = "DB79607DA3ACB5FA2D24428DF2713F98", hash_generated_method = "9EF71D175A0EFE47AE567BEC7BFAC16F")
    
public String getPeerProtocol() {
        return this.peerProtocol;
    }

    /**
     * Send message to whoever is connected to us. Uses the topmost via address to send to.
     * 
     * @param msg is the message to send.
     * @param retry
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.109 -0500", hash_original_method = "3044E621F64D9746C61861BC2D15D7B8", hash_generated_method = "55D3BEE5320ADD2D9AB948841488DEF3")
    
private void sendMessage(byte[] msg, boolean retry) throws IOException {

        /*
         * Patch from kircuv@dev.java.net (Issue 119 ) This patch avoids the case where two
         * TCPMessageChannels are now pointing to the same socket.getInputStream().
         * 
         * JvB 22/5 removed
         */
       // Socket s = this.sipStack.ioHandler.getSocket(IOHandler.makeKey(
       // this.peerAddress, this.peerPort));
        Socket sock = this.sipStack.ioHandler.sendBytes(this.messageProcessor.getIpAddress(),
                this.peerAddress, this.peerPort, this.peerProtocol, msg, retry, this);

        // Created a new socket so close the old one and stick the new
        // one in its place but dont do this if it is a datagram socket.
        // (could have replied via udp but received via tcp!).
        // if (mySock == null && s != null) {
        // this.uncache();
        // } else
        if (sock != mySock && sock != null) {
            try {
                if (mySock != null)
                    mySock.close();
            } catch (IOException ex) {
            }
            mySock = sock;
            this.myClientInputStream = mySock.getInputStream();
            this.myClientOutputStream = mySock.getOutputStream();
            Thread thread = new Thread(this);
            thread.setDaemon(true);
            thread.setName("TCPMessageChannelThread");
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.112 -0500", hash_original_method = "05F3A695AC32E3040A89EFF8F81F947F", hash_generated_method = "44C4EAF8F805AD8A16BDEAF474184EDB")
    
public void sendMessage(SIPMessage sipMessage) throws IOException {
        byte[] msg = sipMessage.encodeAsBytes(this.getTransport());

        long time = System.currentTimeMillis();

        // JvB: also retry for responses, if the connection is gone we should
        // try to reconnect
        this.sendMessage(msg, /* sipMessage instanceof SIPRequest */true);

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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.123 -0500", hash_original_method = "089EEE36759D74C41252D6311E4E6671", hash_generated_method = "09F8F18F1FA7D8ABABDB67B36C91C51D")
    
public void sendMessage(byte message[], InetAddress receiverAddress, int receiverPort,
            boolean retry) throws IOException {
        if (message == null || receiverAddress == null)
            throw new IllegalArgumentException("Null argument");
         Socket sock = this.sipStack.ioHandler.sendBytes(this.messageProcessor.getIpAddress(),
                receiverAddress, receiverPort, "TCP", message, retry, this);
        if (sock != mySock && sock != null) {
            if (mySock != null) {
                /*
                 * Delay the close of the socket for some time in case it is being used.
                 */
                sipStack.getTimer().schedule(new TimerTask() {
                    @Override
                    public boolean cancel() {
                        try {
                            mySock.close();
                            super.cancel();
                        } catch (IOException ex) {

                        }
                        return true;
                    }

                    @Override
                    public void run() {
                        try {
                            mySock.close();
                        } catch (IOException ex) {

                        }
                    }
                }, 8000);
            }

            mySock = sock;
            this.myClientInputStream = mySock.getInputStream();
            this.myClientOutputStream = mySock.getOutputStream();
            // start a new reader on this end of the pipe.
            Thread mythread = new Thread(this);
            mythread.setDaemon(true);
            mythread.setName("TCPMessageChannelThread");
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.127 -0500", hash_original_method = "10E78FE9041FD1B7C26A106A739E4ED8", hash_generated_method = "FA5BDD36BBD6F981379766CBEB85AF89")
    
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
            if (sipStack.isLoggingEnabled()) {
                sipStack.getStackLogger().logDebug(
                        "Encountered Bad Message \n" + sipMessage.toString());
            }

            // JvB: send a 400 response for requests (except ACK)
            // Currently only UDP, @todo also other transports
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
     * @param sipMessage Mesage to process (this calls the application for processing the
     *        message).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.133 -0500", hash_original_method = "688E2F52AD2D71AD93C4E5B7CEC68AD5", hash_generated_method = "EC38FB290B862CD0782E2581BAE78C9F")
    
public void processMessage(SIPMessage sipMessage) throws Exception {
        try {
            if (sipMessage.getFrom() == null
                    || // sipMessage.getFrom().getTag()
                    // == null ||
                    sipMessage.getTo() == null || sipMessage.getCallId() == null
                    || sipMessage.getCSeq() == null || sipMessage.getViaHeaders() == null) {
                String badmsg = sipMessage.encode();
                if (sipStack.isLoggingEnabled()) {
                    sipStack.getStackLogger().logDebug(">>> Dropped Bad Msg");
                    sipStack.getStackLogger().logDebug(badmsg);
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
                Hop hop = sipStack.addressResolver.resolveAddress(v.getHop());
                this.peerProtocol = v.getTransport();
                try {
                    this.peerAddress = mySock.getInetAddress();
                    // Check to see if the received parameter matches
                    // the peer address and tag it appropriately.

                    // JvB: dont do this. It is both costly and incorrect
                    // Must set received also when it is a FQDN, regardless
                    // whether
                    // it resolves to the correct IP address
                    // InetAddress sentByAddress =
                    // InetAddress.getByName(hop.getHost());
                    // JvB: if sender added 'rport', must always set received
                    if (v.hasParameter(Via.RPORT)
                            || !hop.getHost().equals(this.peerAddress.getHostAddress())) {
                        v.setParameter(Via.RECEIVED, this.peerAddress.getHostAddress());
                    }
                    // @@@ hagai
                    // JvB: technically, may only do this when Via already
                    // contains
                    // rport
                    v.setParameter(Via.RPORT, Integer.toString(this.peerPort));
                } catch (java.text.ParseException ex) {
                    InternalErrorHandler.handleException(ex, sipStack.getStackLogger());
                }
                // Use this for outgoing messages as well.
                if (!this.isCached) {
                    ((TCPMessageProcessor) this.messageProcessor).cacheMessageChannel(this);
                    this.isCached = true;
                    int remotePort = ((java.net.InetSocketAddress) mySock.getRemoteSocketAddress()).getPort();
                    String key = IOHandler.makeKey(mySock.getInetAddress(), remotePort);
                    sipStack.ioHandler.putSocket(key, mySock);
                }
            }

         
            // Foreach part of the request header, fetch it and process it

            long receptionTime = System.currentTimeMillis();

            if (sipMessage instanceof SIPRequest) {
                // This is a request - process the request.
                SIPRequest sipRequest = (SIPRequest) sipMessage;
                // Create a new sever side request processor for this
                // message and let it handle the rest.

                if (sipStack.isLoggingEnabled()) {
                    sipStack.getStackLogger().logDebug("----Processing Message---");
                }

                // Check for reasonable size - reject message
                // if it is too long.
                if (this.sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES)) {
                    sipStack.serverLogger.logMessage(sipMessage, this.getPeerHostPort().toString(),
                            this.getMessageProcessor().getIpAddress().getHostAddress() + ":"
                                    + this.getMessageProcessor().getPort(), false, receptionTime);

                }

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
                	if (sipStack.isLoggingEnabled())
                		this.sipStack.getStackLogger()
                            .logWarning("Dropping request -- could not acquire semaphore in 10 sec");
                }

            } else {
                SIPResponse sipResponse = (SIPResponse) sipMessage;
                // JvB: dont do this
                // if (sipResponse.getStatusCode() == 100)
                // sipResponse.getTo().removeParameter("tag");
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
                                && !((SIPTransaction) sipServerResponse).passToListener())
                            ((SIPTransaction) sipServerResponse).releaseSem();
                    }
                } else {
                    sipStack
                            .getStackLogger()
                            .logWarning(
                                    "Application is blocked -- could not acquire semaphore -- dropping response");
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.136 -0500", hash_original_method = "D4E0A0BC15B98D38AEFE5154BA5871D0", hash_generated_method = "84159D385806E06AB908E13801177E1F")
    
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
        this.tcpMessageProcessor.useCount++;
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
                                synchronized (tcpMessageProcessor) {
                                    tcpMessageProcessor.nConnections--;
                                    tcpMessageProcessor.notify();
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
                                synchronized (tcpMessageProcessor) {
                                    tcpMessageProcessor.nConnections--;
                                    // System.out.println("Notifying!");
                                    tcpMessageProcessor.notify();
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
                    InternalErrorHandler.handleException(ex, sipStack.getStackLogger());
                }
            }
        } finally {
            this.isRunning = false;
            this.tcpMessageProcessor.remove(this);
            this.tcpMessageProcessor.useCount--;
            myParser.close();
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.139 -0500", hash_original_method = "588DDE9A59AB3DB90B101694890D3C99", hash_generated_method = "A899BB79E5576CB311D7ED8248F7E4CC")
    
protected void uncache() {
    	if (isCached && !isRunning) {
    		this.tcpMessageProcessor.remove(this);
    	}
    }

    /**
     * Equals predicate.
     * 
     * @param other is the other object to compare ourselves to for equals
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.142 -0500", hash_original_method = "A3550F5A4A6E2000221840888A01CA8A", hash_generated_method = "B0AB0966AE8662F58756095580BB5ED9")
    
public boolean equals(Object other) {

        if (!this.getClass().equals(other.getClass()))
            return false;
        else {
            TCPMessageChannel that = (TCPMessageChannel) other;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.145 -0500", hash_original_method = "2DA7D0C3A567190913C90FAF0FAC7F20", hash_generated_method = "5491386BAEA47A3A981CB752EDA9815E")
    
public String getKey() {
        if (this.key != null) {
            return this.key;
        } else {
            this.key = MessageChannel.getKey(this.peerAddress, this.peerPort, "TCP");
            return this.key;
        }
    }

    /**
     * Get the host to assign to outgoing messages.
     * 
     * @return the host to assign to the via header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.148 -0500", hash_original_method = "11E5C6A8F9691D7C5E18B4FE0A22A301", hash_generated_method = "A32908C6F29B2EE33FC97F7538D4E3FD")
    
public String getViaHost() {
        return myAddress;
    }

    /**
     * Get the port for outgoing messages sent from the channel.
     * 
     * @return the port to assign to the via header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.151 -0500", hash_original_method = "97574FAF366AF2CA74D034931ECBD71B", hash_generated_method = "8533896DB431C404012D38DE1B352FB2")
    
public int getViaPort() {
        return myPort;
    }

    /**
     * Get the port of the peer to whom we are sending messages.
     * 
     * @return the peer port.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.153 -0500", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "0A13911FE5FD34A377B4DEB23C492969")
    
public int getPeerPort() {
        return peerPort;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.157 -0500", hash_original_method = "B210BD4A713B5B982D229CB138437A53", hash_generated_method = "AB9F04CA8BBEA5303DDE8F8F43FD108C")
    
public int getPeerPacketSourcePort() {
        return this.peerPort;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.159 -0500", hash_original_method = "97EAFF51EEE94208DA244D522468157C", hash_generated_method = "7DCFF16CB125E09C777FD38FD05E4A92")
    
public InetAddress getPeerPacketSourceAddress() {
        return this.peerAddress;
    }

    /**
     * TCP Is not a secure protocol.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:22.162 -0500", hash_original_method = "51201694E0EE76265BF39848EF10BE9C", hash_generated_method = "49E6B3D175AEB85C0CC035D6E473FA9A")
    
public boolean isSecure() {
        return false;
    }

    
}

