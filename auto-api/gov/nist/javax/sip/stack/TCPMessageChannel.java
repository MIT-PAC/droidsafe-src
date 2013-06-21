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
import java.util.TimerTask;
import javax.sip.address.Hop;

public class TCPMessageChannel extends MessageChannel implements SIPMessageListener, Runnable, RawMessageChannel {
    private Socket mySock;
    private PipelinedMsgParser myParser;
    protected InputStream myClientInputStream;
    protected OutputStream myClientOutputStream;
    protected String key;
    protected boolean isCached;
    protected boolean isRunning;
    private Thread mythread;
    protected SIPTransactionStack sipStack;
    protected String myAddress;
    protected int myPort;
    protected InetAddress peerAddress;
    protected int peerPort;
    protected String peerProtocol;
    private TCPMessageProcessor tcpMessageProcessor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.065 -0400", hash_original_method = "A2B275A41CF549D2A1285292B7E5107C", hash_generated_method = "0FE916ED21BB2D4E64B8079AF0FFDE2B")
    @DSModeled(DSC.SAFE)
    protected TCPMessageChannel(SIPTransactionStack sipStack) {
        dsTaint.addTaint(sipStack.dsTaint);
        // ---------- Original Method ----------
        //this.sipStack = sipStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.065 -0400", hash_original_method = "5A50CDCBFA2341437DDE39E7C9C5EE35", hash_generated_method = "C45E64A92EF1AEE660A1F24DA05DC64D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected TCPMessageChannel(Socket sock, SIPTransactionStack sipStack,
            TCPMessageProcessor msgProcessor) throws IOException {
        dsTaint.addTaint(sock.dsTaint);
        dsTaint.addTaint(msgProcessor.dsTaint);
        dsTaint.addTaint(sipStack.dsTaint);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_182912364 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("creating new TCPMessageChannel ");
                sipStack.getStackLogger().logStackTrace();
            } //End block
        } //End collapsed parenthetic
        peerAddress = mySock.getInetAddress();
        myAddress = msgProcessor.getIpAddress().getHostAddress();
        myClientInputStream = mySock.getInputStream();
        myClientOutputStream = mySock.getOutputStream();
        mythread = new Thread(this);
        mythread.setDaemon(true);
        mythread.setName("TCPMessageChannelThread");
        this.peerPort = mySock.getPort();
        this.myPort = this.tcpMessageProcessor.getPort();
        super.messageProcessor = msgProcessor;
        mythread.start();
        // ---------- Original Method ----------
        //if (sipStack.isLoggingEnabled()) {
            //sipStack.getStackLogger().logDebug("creating new TCPMessageChannel ");
            //sipStack.getStackLogger().logStackTrace();
        //}
        //mySock = sock;
        //peerAddress = mySock.getInetAddress();
        //myAddress = msgProcessor.getIpAddress().getHostAddress();
        //myClientInputStream = mySock.getInputStream();
        //myClientOutputStream = mySock.getOutputStream();
        //mythread = new Thread(this);
        //mythread.setDaemon(true);
        //mythread.setName("TCPMessageChannelThread");
        //this.sipStack = sipStack;
        //this.peerPort = mySock.getPort();
        //this.tcpMessageProcessor = msgProcessor;
        //this.myPort = this.tcpMessageProcessor.getPort();
        //super.messageProcessor = msgProcessor;
        //mythread.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.066 -0400", hash_original_method = "C53C1DE79ECD9DAACE8708608E931C74", hash_generated_method = "535A94347FA2D5CBBA43D70036ED6371")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected TCPMessageChannel(InetAddress inetAddr, int port, SIPTransactionStack sipStack,
            TCPMessageProcessor messageProcessor) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(inetAddr.dsTaint);
        dsTaint.addTaint(sipStack.dsTaint);
        dsTaint.addTaint(messageProcessor.dsTaint);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1832223493 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("creating new TCPMessageChannel ");
                sipStack.getStackLogger().logStackTrace();
            } //End block
        } //End collapsed parenthetic
        this.myPort = messageProcessor.getPort();
        this.peerProtocol = "TCP";
        this.myAddress = messageProcessor.getIpAddress().getHostAddress();
        this.key = MessageChannel.getKey(peerAddress, peerPort, "TCP");
        super.messageProcessor = messageProcessor;
        // ---------- Original Method ----------
        //if (sipStack.isLoggingEnabled()) {
            //sipStack.getStackLogger().logDebug("creating new TCPMessageChannel ");
            //sipStack.getStackLogger().logStackTrace();
        //}
        //this.peerAddress = inetAddr;
        //this.peerPort = port;
        //this.myPort = messageProcessor.getPort();
        //this.peerProtocol = "TCP";
        //this.sipStack = sipStack;
        //this.tcpMessageProcessor = messageProcessor;
        //this.myAddress = messageProcessor.getIpAddress().getHostAddress();
        //this.key = MessageChannel.getKey(peerAddress, peerPort, "TCP");
        //super.messageProcessor = messageProcessor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.066 -0400", hash_original_method = "16D0E6CF226A4618D75D1B422CC8FCDF", hash_generated_method = "3402C047D92FBCBD47B67C6B7B93404F")
    @DSModeled(DSC.SAFE)
    public boolean isReliable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.066 -0400", hash_original_method = "D9B233459FD7A72AC548D3BF0383246D", hash_generated_method = "879BDB503756E6967EBF4722877D0721")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() {
        try 
        {
            {
                mySock.close();
                mySock = null;
            } //End block
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1545616557 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Closing message Channel " + this);
            } //End collapsed parenthetic
        } //End block
        catch (IOException ex)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_455602138 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Error closing socket " + ex);
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //try {
            //if (mySock != null) {
                //mySock.close();
                //mySock = null;
            //}
            //if (sipStack.isLoggingEnabled())
                //sipStack.getStackLogger().logDebug("Closing message Channel " + this);
        //} catch (IOException ex) {
            //if (sipStack.isLoggingEnabled())
                //sipStack.getStackLogger().logDebug("Error closing socket " + ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.066 -0400", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "0AAC993F2B0EE288482DFA16632D8269")
    @DSModeled(DSC.SAFE)
    public SIPTransactionStack getSIPStack() {
        return (SIPTransactionStack)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sipStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.066 -0400", hash_original_method = "0D1837A773C1185791E8B7504B01CB2E", hash_generated_method = "D003434BAF4242B41B83CC6E34558E28")
    @DSModeled(DSC.SAFE)
    public String getTransport() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "TCP";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.067 -0400", hash_original_method = "59CC467573DB54CDCEF540AE63F43735", hash_generated_method = "D874461DDEFDCC710BF20F1D8DDCB958")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPeerAddress() {
        {
            String var6586A9971E467EF6AB4CB80701FED203_375720063 = (peerAddress.getHostAddress());
        } //End block
        String var1515745D10A6856EE7A2CDC1F62734D4_1199936434 = (getHost());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (peerAddress != null) {
            //return peerAddress.getHostAddress();
        //} else
            //return getHost();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.067 -0400", hash_original_method = "1F29EC3BC94C3E0863F530FCD37A61F3", hash_generated_method = "B75EA17B15223DF670C4300DF5D740DC")
    @DSModeled(DSC.SAFE)
    protected InetAddress getPeerInetAddress() {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return peerAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.067 -0400", hash_original_method = "DB79607DA3ACB5FA2D24428DF2713F98", hash_generated_method = "B04499CEAABB7F00BDAEC74FE715B53A")
    @DSModeled(DSC.SAFE)
    public String getPeerProtocol() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.peerProtocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.067 -0400", hash_original_method = "3044E621F64D9746C61861BC2D15D7B8", hash_generated_method = "C42200236BF050A9214F46C5889CC024")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendMessage(byte[] msg, boolean retry) throws IOException {
        dsTaint.addTaint(retry);
        dsTaint.addTaint(msg[0]);
        Socket sock;
        sock = this.sipStack.ioHandler.sendBytes(this.messageProcessor.getIpAddress(),
                this.peerAddress, this.peerPort, this.peerProtocol, msg, retry, this);
        {
            try 
            {
                mySock.close();
            } //End block
            catch (IOException ex)
            { }
            mySock = sock;
            this.myClientInputStream = mySock.getInputStream();
            this.myClientOutputStream = mySock.getOutputStream();
            Thread thread;
            thread = new Thread(this);
            thread.setDaemon(true);
            thread.setName("TCPMessageChannelThread");
            thread.start();
        } //End block
        // ---------- Original Method ----------
        //Socket sock = this.sipStack.ioHandler.sendBytes(this.messageProcessor.getIpAddress(),
                //this.peerAddress, this.peerPort, this.peerProtocol, msg, retry, this);
        //if (sock != mySock && sock != null) {
            //try {
                //if (mySock != null)
                    //mySock.close();
            //} catch (IOException ex) {
            //}
            //mySock = sock;
            //this.myClientInputStream = mySock.getInputStream();
            //this.myClientOutputStream = mySock.getOutputStream();
            //Thread thread = new Thread(this);
            //thread.setDaemon(true);
            //thread.setName("TCPMessageChannelThread");
            //thread.start();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.067 -0400", hash_original_method = "05F3A695AC32E3040A89EFF8F81F947F", hash_generated_method = "3BA9FEAB18A8B5F9A878790C49202C71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendMessage(SIPMessage sipMessage) throws IOException {
        dsTaint.addTaint(sipMessage.dsTaint);
        byte[] msg;
        msg = sipMessage.encodeAsBytes(this.getTransport());
        long time;
        time = System.currentTimeMillis();
        this.sendMessage(msg, true);
        {
            boolean var53DEB6CBCADF9510253D9D22204998C3_1958114197 = (this.sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES));
            logMessage(sipMessage, peerAddress, peerPort, time);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //byte[] msg = sipMessage.encodeAsBytes(this.getTransport());
        //long time = System.currentTimeMillis();
        //this.sendMessage(msg, true);
        //if (this.sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES))
            //logMessage(sipMessage, peerAddress, peerPort, time);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.068 -0400", hash_original_method = "089EEE36759D74C41252D6311E4E6671", hash_generated_method = "F6C6185F94D7C004AB44F7B9587EF273")
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
                receiverAddress, receiverPort, "TCP", message, retry, this);
        {
            {
                sipStack.getTimer().schedule(new TimerTask() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.068 -0400", hash_original_method = "73BB2678B4D3B10E0EB61D0433282932", hash_generated_method = "E3FF1FECBF3759790A15ED9E4FFEC485")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
                    @Override
                    public boolean cancel() {
                        try 
                        {
                            mySock.close();
                            super.cancel();
                        } //End block
                        catch (IOException ex)
                        { }
                        return dsTaint.getTaintBoolean();
                        // ---------- Original Method ----------
                        //try {
                            //mySock.close();
                            //super.cancel();
                        //} catch (IOException ex) {
                        //}
                        //return true;
                    }
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.068 -0400", hash_original_method = "1800F2338CC81B9692B7DA0DF6DF5AE0", hash_generated_method = "387B19C1830DE243C8CB852FA2680BDB")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
                    @Override
                    public void run() {
                        try 
                        {
                            mySock.close();
                        } //End block
                        catch (IOException ex)
                        { }
                        // ---------- Original Method ----------
                        //try {
                            //mySock.close();
                        //} catch (IOException ex) {
                        //}
                    }
}, 8000);
            } //End block
            mySock = sock;
            this.myClientInputStream = mySock.getInputStream();
            this.myClientOutputStream = mySock.getOutputStream();
            Thread mythread;
            mythread = new Thread(this);
            mythread.setDaemon(true);
            mythread.setName("TCPMessageChannelThread");
            mythread.start();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.069 -0400", hash_original_method = "10E78FE9041FD1B7C26A106A739E4ED8", hash_generated_method = "392DA3C60ED4D5330A889FAE32853E86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void handleException(ParseException ex, SIPMessage sipMessage, Class hdrClass,
            String header, String message) throws ParseException {
        dsTaint.addTaint(message);
        dsTaint.addTaint(ex.dsTaint);
        dsTaint.addTaint(sipMessage.dsTaint);
        dsTaint.addTaint(hdrClass.dsTaint);
        dsTaint.addTaint(header);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_2099613561 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logException(ex);
        } //End collapsed parenthetic
        {
            boolean var4AF4DF15E5A9AA725DAB2E0A6B114A9C_1239424474 = ((hdrClass != null)
                && (hdrClass.equals(From.class) || hdrClass.equals(To.class)
                        || hdrClass.equals(CSeq.class) || hdrClass.equals(Via.class)
                        || hdrClass.equals(CallID.class) || hdrClass.equals(RequestLine.class) || hdrClass
                        .equals(StatusLine.class)));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1989365161 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug(
                        "Encountered Bad Message \n" + sipMessage.toString());
                    } //End block
                } //End collapsed parenthetic
                String msgString;
                msgString = sipMessage.toString();
                {
                    boolean varD14AB56EAEC4527AFDDBDB5F15852E6F_673636270 = (!msgString.startsWith("SIP/") && !msgString.startsWith("ACK "));
                    {
                        String badReqRes;
                        badReqRes = createBadReqRes(msgString, ex);
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1966202153 = (sipStack.isLoggingEnabled());
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
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_658471988 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.071 -0400", hash_original_method = "688E2F52AD2D71AD93C4E5B7CEC68AD5", hash_generated_method = "886CAE6C90289ABCFC13706AD5E5E7E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void processMessage(SIPMessage sipMessage) throws Exception {
        dsTaint.addTaint(sipMessage.dsTaint);
        try 
        {
            {
                boolean varB9F954BFA525F3DD48043E6E9EFACC67_1694750220 = (sipMessage.getFrom() == null
                    || 
                    sipMessage.getTo() == null || sipMessage.getCallId() == null
                    || sipMessage.getCSeq() == null || sipMessage.getViaHeaders() == null);
                {
                    String badmsg;
                    badmsg = sipMessage.encode();
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_2282683 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logDebug(">>> Dropped Bad Msg");
                            sipStack.getStackLogger().logDebug(badmsg);
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
                        boolean var07142A8EFF3EF4AD30BCBC85CFE5B232_686704444 = (v.hasParameter(Via.RPORT)
                            || !hop.getHost().equals(this.peerAddress.getHostAddress()));
                        {
                            v.setParameter(Via.RECEIVED, this.peerAddress.getHostAddress());
                        } //End block
                    } //End collapsed parenthetic
                    v.setParameter(Via.RPORT, Integer.toString(this.peerPort));
                } //End block
                catch (java.text.ParseException ex)
                {
                    InternalErrorHandler.handleException(ex, sipStack.getStackLogger());
                } //End block
                {
                    ((TCPMessageProcessor) this.messageProcessor).cacheMessageChannel(this);
                    this.isCached = true;
                    int remotePort;
                    remotePort = ((java.net.InetSocketAddress) mySock.getRemoteSocketAddress()).getPort();
                    String key;
                    key = IOHandler.makeKey(mySock.getInetAddress(), remotePort);
                    sipStack.ioHandler.putSocket(key, mySock);
                } //End block
            } //End block
            long receptionTime;
            receptionTime = System.currentTimeMillis();
            {
                SIPRequest sipRequest;
                sipRequest = (SIPRequest) sipMessage;
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_11604547 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug("----Processing Message---");
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var329151020C352D7210D49BED1EED92B4_1297322730 = (this.sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES));
                    {
                        sipStack.serverLogger.logMessage(sipMessage, this.getPeerHostPort().toString(),
                            this.getMessageProcessor().getIpAddress().getHostAddress() + ":"
                                    + this.getMessageProcessor().getPort(), false, receptionTime);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varBFE4F5560E1DAE5D9C4B756065954E9B_1941428684 = (sipStack.getMaxMessageSize() > 0
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
                                boolean varD802744989A665132B75B392ADE40209_1863349914 = (!sipServerTx.passToListener());
                                ((SIPTransaction) sipServerRequest).releaseSem();
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End block
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_336941794 = (sipStack.isLoggingEnabled());
                        this.sipStack.getStackLogger()
                            .logWarning("Dropping request -- could not acquire semaphore in 10 sec");
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
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_2084840630 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger()
                                .logError("Dropping Badly formatted response message >>> "
                                        + sipResponse);
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var13C0D42D19654498AAF89BA284743FD1_359692262 = (sipStack.getMaxMessageSize() > 0
                        && sipResponse.getSize()
                                + (sipResponse.getContentLength() == null ? 0 : sipResponse
                                        .getContentLength().getContentLength()) > sipStack
                                .getMaxMessageSize()); //DSFIXME:  CODE0008: Nested ternary operator in expression
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_796789046 = (sipStack.isLoggingEnabled());
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
                            boolean var7B7EDCF7240C6ECDC5603DF13532F268_1921624147 = (sipServerResponse instanceof SIPClientTransaction
                                && !((SIPClientTransaction) sipServerResponse)
                                        .checkFromTag(sipResponse));
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_1152213548 = (sipStack.isLoggingEnabled());
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
                            boolean varDB4FC2DFFC674AF9290D5BD5A8705AB9_661757751 = (sipServerResponse instanceof SIPTransaction
                                && !((SIPTransaction) sipServerResponse).passToListener());
                            ((SIPTransaction) sipServerResponse).releaseSem();
                        } //End collapsed parenthetic
                    } //End block
                } //End block
                {
                    sipStack
                            .getStackLogger()
                            .logWarning(
                                    "Application is blocked -- could not acquire semaphore -- dropping response");
                } //End block
            } //End block
        } //End block
        finally 
        { }
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.072 -0400", hash_original_method = "D4E0A0BC15B98D38AEFE5154BA5871D0", hash_generated_method = "F28E3A20CC7A20A5B83A6DFBF41F26A8")
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
                                    tcpMessageProcessor.notify();
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
                            boolean var2AB968A8303910EE00F810B6DE3410F9_1174874571 = (sipStack.isLoggingEnabled());
                            sipStack.getStackLogger().logDebug("IOException  closing sock " + ex);
                        } //End collapsed parenthetic
                        try 
                        {
                            {
                                {
                                    tcpMessageProcessor.notify();
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
                    InternalErrorHandler.handleException(ex, sipStack.getStackLogger());
                } //End block
            } //End block
        } //End block
        finally 
        {
            this.isRunning = false;
            this.tcpMessageProcessor.remove(this);
            myParser.close();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.072 -0400", hash_original_method = "588DDE9A59AB3DB90B101694890D3C99", hash_generated_method = "99D3DCE5DA682319A2B659FFC777497D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void uncache() {
        {
            this.tcpMessageProcessor.remove(this);
        } //End block
        // ---------- Original Method ----------
        //if (isCached && !isRunning) {
    		//this.tcpMessageProcessor.remove(this);
    	//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.072 -0400", hash_original_method = "A3550F5A4A6E2000221840888A01CA8A", hash_generated_method = "06E8AA6753E09E5D342B75CA1A60D370")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_328729543 = (!this.getClass().equals(other.getClass()));
            {
                TCPMessageChannel that;
                that = (TCPMessageChannel) other;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!this.getClass().equals(other.getClass()))
            //return false;
        //else {
            //TCPMessageChannel that = (TCPMessageChannel) other;
            //if (this.mySock != that.mySock)
                //return false;
            //else
                //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.072 -0400", hash_original_method = "2DA7D0C3A567190913C90FAF0FAC7F20", hash_generated_method = "58979362A3AE877CCBF773AE1BAF83A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getKey() {
        {
            this.key = MessageChannel.getKey(this.peerAddress, this.peerPort, "TCP");
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (this.key != null) {
            //return this.key;
        //} else {
            //this.key = MessageChannel.getKey(this.peerAddress, this.peerPort, "TCP");
            //return this.key;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.072 -0400", hash_original_method = "11E5C6A8F9691D7C5E18B4FE0A22A301", hash_generated_method = "920B683A8C58316DA05AA021EE3CF91F")
    @DSModeled(DSC.SAFE)
    public String getViaHost() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return myAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.073 -0400", hash_original_method = "97574FAF366AF2CA74D034931ECBD71B", hash_generated_method = "F3A772E88F5816E9F0434E98DC05D330")
    @DSModeled(DSC.SAFE)
    public int getViaPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return myPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.073 -0400", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "AEBA702D6111FFED2D7D8A1EFD0D8FC1")
    @DSModeled(DSC.SAFE)
    public int getPeerPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return peerPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.073 -0400", hash_original_method = "B210BD4A713B5B982D229CB138437A53", hash_generated_method = "F180FFB8B6CC3A256CE55D06D42BE0D7")
    @DSModeled(DSC.SAFE)
    public int getPeerPacketSourcePort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.peerPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.073 -0400", hash_original_method = "97EAFF51EEE94208DA244D522468157C", hash_generated_method = "922814000EC0EE306451A6EDD8B61D7E")
    @DSModeled(DSC.SAFE)
    public InetAddress getPeerPacketSourceAddress() {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.peerAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.073 -0400", hash_original_method = "51201694E0EE76265BF39848EF10BE9C", hash_generated_method = "7FD317C466D6873CE376C80F23CBD437")
    @DSModeled(DSC.SAFE)
    public boolean isSecure() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
}

