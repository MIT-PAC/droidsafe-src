package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.javax.sip.message.*;
import gov.nist.javax.sip.parser.*;
import gov.nist.core.*;
import java.net.*;
import java.io.*;
import java.text.ParseException;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSocket;
import javax.sip.address.Hop;
import javax.sip.message.Response;

public final class TLSMessageChannel extends MessageChannel implements SIPMessageListener, Runnable, RawMessageChannel {
    private Socket mySock;
    private PipelinedMsgParser myParser;
    private InputStream myClientInputStream;
    private String key;
    protected boolean isCached;
    protected boolean isRunning;
    private Thread mythread;
    private String myAddress;
    private int myPort;
    private InetAddress peerAddress;
    private int peerPort;
    private String peerProtocol;
    private TLSMessageProcessor tlsMessageProcessor;
    private SIPTransactionStack sipStack;
    private HandshakeCompletedListener handshakeCompletedListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.160 -0400", hash_original_method = "358EB7732CC002B4969C64CA3912C6FF", hash_generated_method = "B1793FEC4E731D1885B31764EF873193")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected TLSMessageChannel(Socket sock, SIPTransactionStack sipStack,
            TLSMessageProcessor msgProcessor) throws IOException {
        dsTaint.addTaint(sock.dsTaint);
        dsTaint.addTaint(msgProcessor.dsTaint);
        dsTaint.addTaint(sipStack.dsTaint);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1188803788 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("creating new TLSMessageChannel (incoming)");
                sipStack.getStackLogger().logStackTrace();
            } //End block
        } //End collapsed parenthetic
        mySock = (SSLSocket) sock;
        {
            SSLSocket sslSock;
            sslSock = (SSLSocket) sock;
            sslSock.setNeedClientAuth(true);
            this.handshakeCompletedListener = new HandshakeCompletedListenerImpl(this);
            sslSock.addHandshakeCompletedListener(this.handshakeCompletedListener);
            sslSock.startHandshake();
        } //End block
        peerAddress = mySock.getInetAddress();
        myAddress = msgProcessor.getIpAddress().getHostAddress();
        myClientInputStream = mySock.getInputStream();
        mythread = new Thread(this);
        mythread.setDaemon(true);
        mythread.setName("TLSMessageChannelThread");
        this.myPort = this.tlsMessageProcessor.getPort();
        this.peerPort = mySock.getPort();
        super.messageProcessor = msgProcessor;
        mythread.start();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.160 -0400", hash_original_method = "36AC589476275C6F111789614D727487", hash_generated_method = "7BE54EDD72A2D9E4C7371D92E3E6A443")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected TLSMessageChannel(InetAddress inetAddr, int port, SIPTransactionStack sipStack,
            TLSMessageProcessor messageProcessor) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(inetAddr.dsTaint);
        dsTaint.addTaint(sipStack.dsTaint);
        dsTaint.addTaint(messageProcessor.dsTaint);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1326906798 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("creating new TLSMessageChannel (outgoing)");
                sipStack.getStackLogger().logStackTrace();
            } //End block
        } //End collapsed parenthetic
        this.myPort = messageProcessor.getPort();
        this.peerProtocol = "TLS";
        this.myAddress = messageProcessor.getIpAddress().getHostAddress();
        this.key = MessageChannel.getKey(peerAddress, peerPort, "TLS");
        super.messageProcessor = messageProcessor;
        // ---------- Original Method ----------
        //if (sipStack.isLoggingEnabled()) {
            //sipStack.getStackLogger().logDebug("creating new TLSMessageChannel (outgoing)");
            //sipStack.getStackLogger().logStackTrace();
        //}
        //this.peerAddress = inetAddr;
        //this.peerPort = port;
        //this.myPort = messageProcessor.getPort();
        //this.peerProtocol = "TLS";
        //this.sipStack = sipStack;
        //this.tlsMessageProcessor = messageProcessor;
        //this.myAddress = messageProcessor.getIpAddress().getHostAddress();
        //this.key = MessageChannel.getKey(peerAddress, peerPort, "TLS");
        //super.messageProcessor = messageProcessor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.161 -0400", hash_original_method = "16D0E6CF226A4618D75D1B422CC8FCDF", hash_generated_method = "3402C047D92FBCBD47B67C6B7B93404F")
    @DSModeled(DSC.SAFE)
    public boolean isReliable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.161 -0400", hash_original_method = "9757D034E975DAF9D22BACDE50FF4335", hash_generated_method = "1F6DA1BF23461476E90ED3F0BCD7479D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() {
        try 
        {
            mySock.close();
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_488486853 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Closing message Channel " + this);
            } //End collapsed parenthetic
        } //End block
        catch (IOException ex)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1421441875 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Error closing socket " + ex);
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //try {
            //if (mySock != null)
                //mySock.close();
            //if (sipStack.isLoggingEnabled())
                //sipStack.getStackLogger().logDebug("Closing message Channel " + this);
        //} catch (IOException ex) {
            //if (sipStack.isLoggingEnabled())
                //sipStack.getStackLogger().logDebug("Error closing socket " + ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.161 -0400", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "0AAC993F2B0EE288482DFA16632D8269")
    @DSModeled(DSC.SAFE)
    public SIPTransactionStack getSIPStack() {
        return (SIPTransactionStack)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sipStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.161 -0400", hash_original_method = "00B4B3FBB10028B216605159EFB81D52", hash_generated_method = "7663319EC6263895951D21B871A4F5ED")
    @DSModeled(DSC.SAFE)
    public String getTransport() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "tls";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.161 -0400", hash_original_method = "59CC467573DB54CDCEF540AE63F43735", hash_generated_method = "4A8BFF146CB95361C880B7FB03156A53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPeerAddress() {
        {
            String var6586A9971E467EF6AB4CB80701FED203_312381881 = (peerAddress.getHostAddress());
        } //End block
        String var1515745D10A6856EE7A2CDC1F62734D4_1087359332 = (getHost());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (peerAddress != null) {
            //return peerAddress.getHostAddress();
        //} else
            //return getHost();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.162 -0400", hash_original_method = "1F29EC3BC94C3E0863F530FCD37A61F3", hash_generated_method = "B75EA17B15223DF670C4300DF5D740DC")
    @DSModeled(DSC.SAFE)
    protected InetAddress getPeerInetAddress() {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return peerAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.162 -0400", hash_original_method = "DB79607DA3ACB5FA2D24428DF2713F98", hash_generated_method = "B04499CEAABB7F00BDAEC74FE715B53A")
    @DSModeled(DSC.SAFE)
    public String getPeerProtocol() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.peerProtocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.162 -0400", hash_original_method = "769119032395AFB8B9E88BC54405133A", hash_generated_method = "475CF047AC19C076CC88EAE659976434")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendMessage(byte[] msg, boolean retry) throws IOException {
        dsTaint.addTaint(retry);
        dsTaint.addTaint(msg[0]);
        Socket sock;
        sock = this.sipStack.ioHandler.sendBytes(
                this.getMessageProcessor().getIpAddress(), this.peerAddress, this.peerPort,
                this.peerProtocol, msg, retry,this);
        {
            try 
            {
                mySock.close();
            } //End block
            catch (IOException ex)
            { }
            mySock = sock;
            this.myClientInputStream = mySock.getInputStream();
            Thread thread;
            thread = new Thread(this);
            thread.setDaemon(true);
            thread.setName("TLSMessageChannelThread");
            thread.start();
        } //End block
        // ---------- Original Method ----------
        //Socket sock = this.sipStack.ioHandler.sendBytes(
                //this.getMessageProcessor().getIpAddress(), this.peerAddress, this.peerPort,
                //this.peerProtocol, msg, retry,this);
        //if (sock != mySock && sock != null) {
            //try {
                //if (mySock != null)
                    //mySock.close();
            //} catch (IOException ex) {
            //}
            //mySock = sock;
            //this.myClientInputStream = mySock.getInputStream();
            //Thread thread = new Thread(this);
            //thread.setDaemon(true);
            //thread.setName("TLSMessageChannelThread");
            //thread.start();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.162 -0400", hash_original_method = "99193C77E68A5ABE715A7A9AC8040C34", hash_generated_method = "9EB4CE2D498B7C909915CB5EFF0D9DB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendMessage(SIPMessage sipMessage) throws IOException {
        dsTaint.addTaint(sipMessage.dsTaint);
        byte[] msg;
        msg = sipMessage.encodeAsBytes(this.getTransport());
        long time;
        time = System.currentTimeMillis();
        this.sendMessage(msg, sipMessage instanceof SIPRequest);
        {
            boolean var53DEB6CBCADF9510253D9D22204998C3_751764289 = (this.sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES));
            logMessage(sipMessage, peerAddress, peerPort, time);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //byte[] msg = sipMessage.encodeAsBytes(this.getTransport());
        //long time = System.currentTimeMillis();
        //this.sendMessage(msg, sipMessage instanceof SIPRequest);
        //if (this.sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES))
            //logMessage(sipMessage, peerAddress, peerPort, time);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.163 -0400", hash_original_method = "C6D6B3579ACFAA2466286D67BFFE3003", hash_generated_method = "F5025CDB8404627CD943B3291EDF76C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendMessage(byte message[], InetAddress receiverAddress, int receiverPort,
            boolean retry) throws IOException {
        dsTaint.addTaint(message);
        dsTaint.addTaint(retry);
        dsTaint.addTaint(receiverPort);
        dsTaint.addTaint(receiverAddress.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Null argument");
        Socket sock;
        sock = this.sipStack.ioHandler.sendBytes(this.messageProcessor.getIpAddress(),
                receiverAddress, receiverPort, "TLS", message, retry, this);
        {
            try 
            {
                mySock.close();
            } //End block
            catch (IOException ex)
            { }
            mySock = sock;
            this.myClientInputStream = mySock.getInputStream();
            Thread mythread;
            mythread = new Thread(this);
            mythread.setDaemon(true);
            mythread.setName("TLSMessageChannelThread");
            mythread.start();
        } //End block
        // ---------- Original Method ----------
        //if (message == null || receiverAddress == null)
            //throw new IllegalArgumentException("Null argument");
        //Socket sock = this.sipStack.ioHandler.sendBytes(this.messageProcessor.getIpAddress(),
                //receiverAddress, receiverPort, "TLS", message, retry, this);
        //if (sock != mySock && sock != null) {
            //try {
                //if (mySock != null)
                    //mySock.close();
            //} catch (IOException ex) {
            //}
            //mySock = sock;
            //this.myClientInputStream = mySock.getInputStream();
            //Thread mythread = new Thread(this);
            //mythread.setDaemon(true);
            //mythread.setName("TLSMessageChannelThread");
            //mythread.start();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.163 -0400", hash_original_method = "F10EA794C47048E710B5CED57C611CE1", hash_generated_method = "94E7D609C972CD9B3169DAAC4C690971")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void handleException(ParseException ex, SIPMessage sipMessage, Class hdrClass,
            String header, String message) throws ParseException {
        dsTaint.addTaint(message);
        dsTaint.addTaint(ex.dsTaint);
        dsTaint.addTaint(sipMessage.dsTaint);
        dsTaint.addTaint(hdrClass.dsTaint);
        dsTaint.addTaint(header);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_447972191 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logException(ex);
        } //End collapsed parenthetic
        {
            boolean var4AF4DF15E5A9AA725DAB2E0A6B114A9C_1474171129 = ((hdrClass != null)
                && (hdrClass.equals(From.class) || hdrClass.equals(To.class)
                        || hdrClass.equals(CSeq.class) || hdrClass.equals(Via.class)
                        || hdrClass.equals(CallID.class) || hdrClass.equals(RequestLine.class) || hdrClass
                        .equals(StatusLine.class)));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_831200282 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logDebug("Encountered bad message \n" + message);
                } //End collapsed parenthetic
                String msgString;
                msgString = sipMessage.toString();
                {
                    boolean varD14AB56EAEC4527AFDDBDB5F15852E6F_713090535 = (!msgString.startsWith("SIP/") && !msgString.startsWith("ACK "));
                    {
                        String badReqRes;
                        badReqRes = createBadReqRes(msgString, ex);
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_914759072 = (sipStack.isLoggingEnabled());
                                {
                                    sipStack.getStackLogger().logDebug("Sending automatic 400 Bad Request:");
                                    sipStack.getStackLogger().logDebug(badReqRes);
                                } //End block
                            } //End collapsed parenthetic
                            try 
                            {
                                this.sendMessage(badReqRes.getBytes(), this.getPeerInetAddress(), this
                                .getPeerPort(), false);
                            } //End block
                            catch (IOException e)
                            {
                                this.sipStack.getStackLogger().logException(e);
                            } //End block
                        } //End block
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1914991706 = (sipStack.isLoggingEnabled());
                                {
                                    sipStack.getStackLogger().logDebug(
                                "Could not formulate automatic 400 Bad Request");
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw ex;
            } //End block
            {
                sipMessage.addUnparsed(header);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.165 -0400", hash_original_method = "0B661C1775BD5742177C9AA146CAD19A", hash_generated_method = "58A71A8B45E2512C105CF1BDACCC265F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void processMessage(SIPMessage sipMessage) throws Exception {
        dsTaint.addTaint(sipMessage.dsTaint);
        try 
        {
            {
                boolean var75ACC6F471BB1A68962D9AE1797FBD7B_156377309 = (sipMessage.getFrom() == null || sipMessage.getTo() == null
                    || sipMessage.getCallId() == null || sipMessage.getCSeq() == null
                    || sipMessage.getViaHeaders() == null);
                {
                    String badmsg;
                    badmsg = sipMessage.encode();
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_153814895 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logError("bad message " + badmsg);
                            sipStack.getStackLogger().logError(">>> Dropped Bad Msg");
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            ViaList viaList;
            viaList = sipMessage.getViaHeaders();
            {
                Via v;
                v = (Via) viaList.getFirst();
                Hop hop;
                hop = sipStack.addressResolver.resolveAddress(v.getHop());
                this.peerProtocol = v.getTransport();
                try 
                {
                    this.peerAddress = mySock.getInetAddress();
                    {
                        boolean var07142A8EFF3EF4AD30BCBC85CFE5B232_84007548 = (v.hasParameter(Via.RPORT)
                            || !hop.getHost().equals(this.peerAddress.getHostAddress()));
                        {
                            v.setParameter(Via.RECEIVED, this.peerAddress.getHostAddress());
                        } //End block
                    } //End collapsed parenthetic
                    v.setParameter(Via.RPORT, Integer.toString(this.peerPort));
                } //End block
                catch (java.text.ParseException ex)
                {
                    InternalErrorHandler.handleException(ex);
                } //End block
                {
                    ((TLSMessageProcessor) this.messageProcessor).cacheMessageChannel(this);
                    this.isCached = true;
                    String key;
                    key = IOHandler.makeKey(mySock.getInetAddress(), this.peerPort);
                    sipStack.ioHandler.putSocket(key, mySock);
                } //End block
            } //End block
            long receptionTime;
            receptionTime = System.currentTimeMillis();
            {
                SIPRequest sipRequest;
                sipRequest = (SIPRequest) sipMessage;
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1142391359 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug("----Processing Message---");
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var329151020C352D7210D49BED1EED92B4_723768296 = (this.sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES));
                    {
                        sipStack.serverLogger.logMessage(sipMessage, this.getPeerHostPort().toString(),
                            this.messageProcessor.getIpAddress().getHostAddress() + ":"
                                    + this.messageProcessor.getPort(), false, receptionTime);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varBFE4F5560E1DAE5D9C4B756065954E9B_1003901212 = (sipStack.getMaxMessageSize() > 0
                        && sipRequest.getSize()
                                + (sipRequest.getContentLength() == null ? 0 : sipRequest
                                        .getContentLength().getContentLength()) > sipStack
                                .getMaxMessageSize()); //DSFIXME:  CODE0008: Nested ternary operator in expression
                    {
                        SIPResponse sipResponse;
                        sipResponse = sipRequest
                            .createResponse(SIPResponse.MESSAGE_TOO_LARGE);
                        byte[] resp;
                        resp = sipResponse.encodeAsBytes(this.getTransport());
                        this.sendMessage(resp, false);
                        if (DroidSafeAndroidRuntime.control) throw new Exception("Message size exceeded");
                    } //End block
                } //End collapsed parenthetic
                ServerRequestInterface sipServerRequest;
                sipServerRequest = sipStack.newSIPServerRequest(
                        sipRequest, this);
                {
                    try 
                    {
                        sipServerRequest.processRequest(sipRequest, this);
                    } //End block
                    finally 
                    {
                        {
                            SIPServerTransaction sipServerTx;
                            sipServerTx = (SIPServerTransaction) sipServerRequest;
                            {
                                boolean varD802744989A665132B75B392ADE40209_651741694 = (!sipServerTx.passToListener());
                                ((SIPTransaction) sipServerRequest).releaseSem();
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End block
                {
                    SIPResponse response;
                    response = sipRequest
                            .createResponse(Response.SERVICE_UNAVAILABLE);
                    RetryAfter retryAfter;
                    retryAfter = new RetryAfter();
                    try 
                    {
                        retryAfter.setRetryAfter((int) (10 * (Math.random())));
                        response.setHeader(retryAfter);
                        this.sendMessage(response);
                    } //End block
                    catch (Exception e)
                    { }
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_16310931 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger()
                            .logWarning("Dropping message -- could not acquire semaphore");
                    } //End collapsed parenthetic
                } //End block
            } //End block
            {
                SIPResponse sipResponse;
                sipResponse = (SIPResponse) sipMessage;
                try 
                {
                    sipResponse.checkHeaders();
                } //End block
                catch (ParseException ex)
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_284263974 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger()
                                .logError("Dropping Badly formatted response message >>> "
                                        + sipResponse);
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var13C0D42D19654498AAF89BA284743FD1_1740053829 = (sipStack.getMaxMessageSize() > 0
                        && sipResponse.getSize()
                                + (sipResponse.getContentLength() == null ? 0 : sipResponse
                                        .getContentLength().getContentLength()) > sipStack
                                .getMaxMessageSize()); //DSFIXME:  CODE0008: Nested ternary operator in expression
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_1971965410 = (sipStack.isLoggingEnabled());
                            this.sipStack.getStackLogger().logDebug("Message size exceeded");
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                ServerResponseInterface sipServerResponse;
                sipServerResponse = sipStack.newSIPServerResponse(
                        sipResponse, this);
                {
                    try 
                    {
                        {
                            boolean var7B7EDCF7240C6ECDC5603DF13532F268_2038094512 = (sipServerResponse instanceof SIPClientTransaction
                                && !((SIPClientTransaction) sipServerResponse)
                                        .checkFromTag(sipResponse));
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_144806536 = (sipStack.isLoggingEnabled());
                                    sipStack.getStackLogger()
                                        .logError("Dropping response message with invalid tag >>> "
                                                + sipResponse);
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                        sipServerResponse.processResponse(sipResponse, this);
                    } //End block
                    finally 
                    {
                        {
                            boolean varDB4FC2DFFC674AF9290D5BD5A8705AB9_1940577116 = (sipServerResponse instanceof SIPTransaction
                                && !((SIPTransaction) sipServerResponse).passToListener());
                            {
                                ((SIPTransaction) sipServerResponse).releaseSem();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
                {
                    sipStack.getStackLogger().logWarning("Could not get semaphore... dropping response");
                } //End block
            } //End block
        } //End block
        finally 
        { }
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.166 -0400", hash_original_method = "F77124F9292782877CB3E3F72C9E9606", hash_generated_method = "8944F7D96FECB43AA588A193E2A6EBC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void run() {
        Pipeline hispipe;
        hispipe = null;
        hispipe = new Pipeline(myClientInputStream, sipStack.readTimeout,
                ((SIPTransactionStack) sipStack).getTimer());
        myParser = new PipelinedMsgParser(this, hispipe, this.sipStack.getMaxMessageSize());
        myParser.processInput();
        int bufferSize;
        bufferSize = 4096;
        this.isRunning = true;
        try 
        {
            {
                try 
                {
                    byte[] msg;
                    msg = new byte[bufferSize];
                    int nbytes;
                    nbytes = myClientInputStream.read(msg, 0, bufferSize);
                    {
                        hispipe.write("\r\n\r\n".getBytes("UTF-8"));
                        try 
                        {
                            {
                                {
                                    tlsMessageProcessor.notify();
                                } //End block
                            } //End block
                            hispipe.close();
                            mySock.close();
                        } //End block
                        catch (IOException ioex)
                        { }
                    } //End block
                    hispipe.write(msg, 0, nbytes);
                } //End block
                catch (IOException ex)
                {
                    try 
                    {
                        hispipe.write("\r\n\r\n".getBytes("UTF-8"));
                    } //End block
                    catch (Exception e)
                    { }
                    try 
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_1349633650 = (sipStack.isLoggingEnabled());
                            sipStack.getStackLogger().logDebug("IOException  closing sock " + ex);
                        } //End collapsed parenthetic
                        try 
                        {
                            {
                                {
                                    tlsMessageProcessor.notify();
                                } //End block
                            } //End block
                            mySock.close();
                            hispipe.close();
                        } //End block
                        catch (IOException ioex)
                        { }
                    } //End block
                    catch (Exception ex1)
                    { }
                } //End block
                catch (Exception ex)
                {
                    InternalErrorHandler.handleException(ex);
                } //End block
            } //End block
        } //End block
        finally 
        {
            this.isRunning = false;
            this.tlsMessageProcessor.remove(this);
            this.myParser.close();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.166 -0400", hash_original_method = "C5292C7D09796AA7B556BAA154B95B16", hash_generated_method = "4846BBE21700A1CEFFBC05D2CDF13274")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void uncache() {
        {
            this.tlsMessageProcessor.remove(this);
        } //End block
        // ---------- Original Method ----------
        //if (isCached && !isRunning) {    	
    		//this.tlsMessageProcessor.remove(this);
    	//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.166 -0400", hash_original_method = "DA67C78A7E91B7C25B2E6DD841A2A96C", hash_generated_method = "E0B37769697F95C28F1706763D8B3A3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_21962950 = (!this.getClass().equals(other.getClass()));
            {
                TLSMessageChannel that;
                that = (TLSMessageChannel) other;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!this.getClass().equals(other.getClass()))
            //return false;
        //else {
            //TLSMessageChannel that = (TLSMessageChannel) other;
            //if (this.mySock != that.mySock)
                //return false;
            //else
                //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.167 -0400", hash_original_method = "1173AC840F0483E84550BBD280ADF1B8", hash_generated_method = "81FA777DA8B909ECD1202B4E04A1DFD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getKey() {
        {
            this.key = MessageChannel.getKey(this.peerAddress, this.peerPort, "TLS");
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (this.key != null) {
            //return this.key;
        //} else {
            //this.key = MessageChannel.getKey(this.peerAddress, this.peerPort, "TLS");
            //return this.key;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.167 -0400", hash_original_method = "11E5C6A8F9691D7C5E18B4FE0A22A301", hash_generated_method = "920B683A8C58316DA05AA021EE3CF91F")
    @DSModeled(DSC.SAFE)
    public String getViaHost() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return myAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.167 -0400", hash_original_method = "97574FAF366AF2CA74D034931ECBD71B", hash_generated_method = "F3A772E88F5816E9F0434E98DC05D330")
    @DSModeled(DSC.SAFE)
    public int getViaPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return myPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.167 -0400", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "AEBA702D6111FFED2D7D8A1EFD0D8FC1")
    @DSModeled(DSC.SAFE)
    public int getPeerPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return peerPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.167 -0400", hash_original_method = "B210BD4A713B5B982D229CB138437A53", hash_generated_method = "F180FFB8B6CC3A256CE55D06D42BE0D7")
    @DSModeled(DSC.SAFE)
    public int getPeerPacketSourcePort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.peerPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.167 -0400", hash_original_method = "97EAFF51EEE94208DA244D522468157C", hash_generated_method = "922814000EC0EE306451A6EDD8B61D7E")
    @DSModeled(DSC.SAFE)
    public InetAddress getPeerPacketSourceAddress() {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.peerAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.168 -0400", hash_original_method = "57D47F2F9FCDF87C613C3BEA50BCDEDC", hash_generated_method = "67C0E42DCF50A0B25E27F2905154C352")
    @DSModeled(DSC.SAFE)
    public boolean isSecure() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.168 -0400", hash_original_method = "17DB109E74C9C419B95A49BDAE918BA7", hash_generated_method = "E84DECF8C7B71876CA20C207F3DC0C4A")
    @DSModeled(DSC.SAFE)
    public void setHandshakeCompletedListener(
            HandshakeCompletedListener handshakeCompletedListenerImpl) {
        dsTaint.addTaint(handshakeCompletedListenerImpl.dsTaint);
        // ---------- Original Method ----------
        //this.handshakeCompletedListener = handshakeCompletedListenerImpl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.168 -0400", hash_original_method = "6CFE0616A7B6D8A833DC048924F270CA", hash_generated_method = "34DBDA2F4BBE4837AE9767D1C8AE95E4")
    @DSModeled(DSC.SAFE)
    public HandshakeCompletedListenerImpl getHandshakeCompletedListener() {
        return (HandshakeCompletedListenerImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (HandshakeCompletedListenerImpl) handshakeCompletedListener;
    }

    
}

