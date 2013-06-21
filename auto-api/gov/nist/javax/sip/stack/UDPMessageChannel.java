package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
import java.util.HashSet;
import java.util.Hashtable;
import java.util.TimerTask;
import javax.sip.address.Hop;

public class UDPMessageChannel extends MessageChannel implements ParseExceptionListener, Runnable, RawMessageChannel {
    protected SIPTransactionStack sipStack;
    protected StringMsgParser myParser;
    private InetAddress peerAddress;
    private String myAddress;
    private int peerPacketSourcePort;
    private InetAddress peerPacketSourceAddress;
    private int peerPort;
    private String peerProtocol;
    protected int myPort;
    private DatagramPacket incomingPacket;
    private long receptionTime;
    private Hashtable<String,PingBackTimerTask> pingBackRecord = new Hashtable<String,PingBackTimerTask>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.273 -0400", hash_original_method = "03A64681434F0E8B0C9121AC8F1C5237", hash_generated_method = "7AAA8B977F7087451C65E1E0FBBA115F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected UDPMessageChannel(SIPTransactionStack stack,
            UDPMessageProcessor messageProcessor) {
        dsTaint.addTaint(messageProcessor.dsTaint);
        dsTaint.addTaint(stack.dsTaint);
        super.messageProcessor = messageProcessor;
        Thread mythread;
        mythread = new Thread(this);
        this.myAddress = messageProcessor.getIpAddress().getHostAddress();
        this.myPort = messageProcessor.getPort();
        mythread.setName("UDPMessageChannelThread");
        mythread.setDaemon(true);
        mythread.start();
        // ---------- Original Method ----------
        //super.messageProcessor = messageProcessor;
        //this.sipStack = stack;
        //Thread mythread = new Thread(this);
        //this.myAddress = messageProcessor.getIpAddress().getHostAddress();
        //this.myPort = messageProcessor.getPort();
        //mythread.setName("UDPMessageChannelThread");
        //mythread.setDaemon(true);
        //mythread.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.274 -0400", hash_original_method = "1756885BA9DE2BFD3C0F236D276D29E7", hash_generated_method = "99964ACD84941E268CBC3ED48CFEE7AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected UDPMessageChannel(SIPTransactionStack stack,
            UDPMessageProcessor messageProcessor, DatagramPacket packet) {
        dsTaint.addTaint(packet.dsTaint);
        dsTaint.addTaint(messageProcessor.dsTaint);
        dsTaint.addTaint(stack.dsTaint);
        super.messageProcessor = messageProcessor;
        this.myAddress = messageProcessor.getIpAddress().getHostAddress();
        this.myPort = messageProcessor.getPort();
        Thread mythread;
        mythread = new Thread(this);
        mythread.setDaemon(true);
        mythread.setName("UDPMessageChannelThread");
        mythread.start();
        // ---------- Original Method ----------
        //this.incomingPacket = packet;
        //super.messageProcessor = messageProcessor;
        //this.sipStack = stack;
        //this.myAddress = messageProcessor.getIpAddress().getHostAddress();
        //this.myPort = messageProcessor.getPort();
        //Thread mythread = new Thread(this);
        //mythread.setDaemon(true);
        //mythread.setName("UDPMessageChannelThread");
        //mythread.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.274 -0400", hash_original_method = "776DD93072EC88FB0665477FC0515605", hash_generated_method = "C979FC03431980C9B17E8F22D56DCF45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected UDPMessageChannel(InetAddress targetAddr, int port,
            SIPTransactionStack sipStack, UDPMessageProcessor messageProcessor) {
        dsTaint.addTaint(port);
        dsTaint.addTaint(targetAddr.dsTaint);
        dsTaint.addTaint(sipStack.dsTaint);
        dsTaint.addTaint(messageProcessor.dsTaint);
        peerProtocol = "UDP";
        super.messageProcessor = messageProcessor;
        this.myAddress = messageProcessor.getIpAddress().getHostAddress();
        this.myPort = messageProcessor.getPort();
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1089559440 = (sipStack.isLoggingEnabled());
            {
                this.sipStack.getStackLogger().logDebug("Creating message channel "
                    + targetAddr.getHostAddress() + "/" + port);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //peerAddress = targetAddr;
        //peerPort = port;
        //peerProtocol = "UDP";
        //super.messageProcessor = messageProcessor;
        //this.myAddress = messageProcessor.getIpAddress().getHostAddress();
        //this.myPort = messageProcessor.getPort();
        //this.sipStack = sipStack;
        //if (sipStack.isLoggingEnabled()) {
            //this.sipStack.getStackLogger().logDebug("Creating message channel "
                    //+ targetAddr.getHostAddress() + "/" + port);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.275 -0400", hash_original_method = "E6EA1046257028C8ED28AF4C13B7A731", hash_generated_method = "E8318F5E46BE3D9E2535D9DB958E5AAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void run() {
        ThreadAuditor.ThreadHandle threadHandle;
        threadHandle = null;
        {
            {
                myParser = new StringMsgParser();
                myParser.setParseExceptionListener(this);
            } //End block
            DatagramPacket packet;
            {
                {
                    {
                        boolean varAD73BCE40D73F49090BF24139EA25CB8_1340325327 = (((UDPMessageProcessor) messageProcessor).messageQueue
                            .isEmpty());
                        {
                            try 
                            {
                                {
                                    threadHandle = sipStack.getThreadAuditor()
                                        .addCurrentThread();
                                } //End block
                                threadHandle.ping();
                                ((UDPMessageProcessor) messageProcessor).messageQueue
                                    .wait(threadHandle
                                            .getPingIntervalInMillisecs());
                            } //End block
                            catch (InterruptedException ex)
                            { }
                        } //End block
                    } //End collapsed parenthetic
                    packet = (DatagramPacket) ((UDPMessageProcessor) messageProcessor).messageQueue
                            .removeFirst();
                } //End block
                this.incomingPacket = packet;
            } //End block
            {
                packet = this.incomingPacket;
            } //End block
            try 
            {
                processIncomingDataPacket(packet);
            } //End block
            catch (Exception e)
            {
                sipStack.getStackLogger().logError(
                        "Error while processing incoming UDP packet", e);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.276 -0400", hash_original_method = "2D23A147968127857F47AE9C2F0B0301", hash_generated_method = "8D714180DA8F747E6D52ECB01019BF54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void processIncomingDataPacket(DatagramPacket packet) throws Exception {
        dsTaint.addTaint(packet.dsTaint);
        this.peerAddress = packet.getAddress();
        int packetLength;
        packetLength = packet.getLength();
        byte[] bytes;
        bytes = packet.getData();
        byte[] msgBytes;
        msgBytes = new byte[packetLength];
        System.arraycopy(bytes, 0, msgBytes, 0, packetLength);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_100097802 = (sipStack.isLoggingEnabled());
            {
                this.sipStack.getStackLogger()
                    .logDebug("UDPMessageChannel: processIncomingDataPacket : peerAddress = "
                            + peerAddress.getHostAddress() + "/"
                            + packet.getPort() + " Length = " + packetLength);
            } //End block
        } //End collapsed parenthetic
        SIPMessage sipMessage;
        sipMessage = null;
        try 
        {
            this.receptionTime = System.currentTimeMillis();
            sipMessage = myParser.parseSIPMessage(msgBytes);
            myParser = null;
        } //End block
        catch (ParseException ex)
        {
            myParser = null;
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1838546523 = (sipStack.isLoggingEnabled());
                {
                    this.sipStack.getStackLogger().logDebug("Rejecting message !  "
                        + new String(msgBytes));
                    this.sipStack.getStackLogger().logDebug("error message "
                        + ex.getMessage());
                    this.sipStack.getStackLogger().logException(ex);
                } //End block
            } //End collapsed parenthetic
            String msgString;
            msgString = new String(msgBytes, 0, packetLength);
            {
                boolean var641C9D2BCF73834F157CB50DF975B192_108207279 = (!msgString.startsWith("SIP/") && !msgString.startsWith("ACK "));
                {
                    String badReqRes;
                    badReqRes = createBadReqRes(msgString, ex);
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_1599965243 = (sipStack.isLoggingEnabled());
                            {
                                sipStack.getStackLogger().logDebug(
                                "Sending automatic 400 Bad Request:");
                                sipStack.getStackLogger().logDebug(badReqRes);
                            } //End block
                        } //End collapsed parenthetic
                        try 
                        {
                            this.sendMessage(badReqRes.getBytes(), peerAddress,
                                packet.getPort(), "UDP", false);
                        } //End block
                        catch (IOException e)
                        {
                            this.sipStack.getStackLogger().logException(e);
                        } //End block
                    } //End block
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_1934682568 = (sipStack.isLoggingEnabled());
                            {
                                sipStack
                                .getStackLogger()
                                .logDebug(
                                        "Could not formulate automatic 400 Bad Request");
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_366356957 = (sipStack.isLoggingEnabled());
                {
                    this.sipStack.getStackLogger().logDebug("Rejecting message !  + Null message parsed.");
                } //End block
            } //End collapsed parenthetic
            {
                boolean var9004E0463DC06B1DD21A25050AF4C311_2016423584 = (pingBackRecord.get(packet.getAddress().getHostAddress() + ":" + packet.getPort()) == null);
                {
                    byte[] retval;
                    retval = "\r\n\r\n".getBytes();
                    DatagramPacket keepalive;
                    keepalive = new DatagramPacket(retval,0,retval.length,packet.getAddress(),packet.getPort());
                    ((UDPMessageProcessor)this.messageProcessor).sock.send(keepalive);
                    this.sipStack.getTimer().schedule(new PingBackTimerTask(packet.getAddress().getHostAddress(), 
                            packet.getPort()), 1000);
                } //End block
            } //End collapsed parenthetic
        } //End block
        ViaList viaList;
        viaList = sipMessage.getViaHeaders();
        {
            boolean var59CC7428458ADFC3199C90345ABEB8AF_786105577 = (sipMessage.getFrom() == null || sipMessage.getTo() == null
                || sipMessage.getCallId() == null
                || sipMessage.getCSeq() == null
                || sipMessage.getViaHeaders() == null);
            {
                String badmsg;
                badmsg = new String(msgBytes);
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_641580455 = (sipStack.isLoggingEnabled());
                    {
                        this.sipStack.getStackLogger().logError("bad message " + badmsg);
                        this.sipStack.getStackLogger().logError(">>> Dropped Bad Msg "
                        + "From = " + sipMessage.getFrom() + "To = "
                        + sipMessage.getTo() + "CallId = "
                        + sipMessage.getCallId() + "CSeq = "
                        + sipMessage.getCSeq() + "Via = "
                        + sipMessage.getViaHeaders());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            Via v;
            v = (Via) viaList.getFirst();
            Hop hop;
            hop = sipStack.addressResolver.resolveAddress(v.getHop());
            this.peerPort = hop.getPort();
            this.peerProtocol = v.getTransport();
            this.peerPacketSourceAddress = packet.getAddress();
            this.peerPacketSourcePort = packet.getPort();
            try 
            {
                this.peerAddress = packet.getAddress();
                boolean hasRPort;
                hasRPort = v.hasParameter(Via.RPORT);
                {
                    boolean var2EC34FA9788EADA768699B2545557487_238704726 = (hasRPort
                        || !hop.getHost().equals(
                                this.peerAddress.getHostAddress()));
                    {
                        v.setParameter(Via.RECEIVED, this.peerAddress
                            .getHostAddress());
                    } //End block
                } //End collapsed parenthetic
                {
                    v.setParameter(Via.RPORT, Integer
                            .toString(this.peerPacketSourcePort));
                } //End block
            } //End block
            catch (java.text.ParseException ex1)
            {
                InternalErrorHandler.handleException(ex1);
            } //End block
        } //End block
        {
            this.peerPacketSourceAddress = packet.getAddress();
            this.peerPacketSourcePort = packet.getPort();
            this.peerAddress = packet.getAddress();
            this.peerPort = packet.getPort();
            this.peerProtocol = ((Via) viaList.getFirst()).getTransport();
        } //End block
        this.processMessage(sipMessage);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.278 -0400", hash_original_method = "DCEA2882E2241B5A52F15EAA80B8F270", hash_generated_method = "56B50ADDE1C4A2FA874D42BE8E78386F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void processMessage(SIPMessage sipMessage) {
        dsTaint.addTaint(sipMessage.dsTaint);
        {
            SIPRequest sipRequest;
            sipRequest = (SIPRequest) sipMessage;
            {
                boolean varB20158C23C001B703CFD19B38FE62BAB_1021148921 = (sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES));
                {
                    this.sipStack.serverLogger.logMessage(sipMessage, this
                        .getPeerHostPort().toString(), this.getHost() + ":"
                        + this.myPort, false, receptionTime);
                } //End block
            } //End collapsed parenthetic
            ServerRequestInterface sipServerRequest;
            sipServerRequest = sipStack
                    .newSIPServerRequest(sipRequest, this);
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1461845297 = (sipStack.isLoggingEnabled());
                    {
                        this.sipStack.getStackLogger()
                            .logWarning("Null request interface returned -- dropping request");
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_824096293 = (sipStack.isLoggingEnabled());
                this.sipStack.getStackLogger().logDebug("About to process "
                        + sipRequest.getFirstLine() + "/" + sipServerRequest);
            } //End collapsed parenthetic
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
                        boolean varDFD8B605D678E12460F98516E8CB0D44_34407646 = (!sipServerTx.passToListener());
                        {
                            ((SIPTransaction) sipServerRequest).releaseSem();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_417152520 = (sipStack.isLoggingEnabled());
                this.sipStack.getStackLogger().logDebug("Done processing "
                        + sipRequest.getFirstLine() + "/" + sipServerRequest);
            } //End collapsed parenthetic
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
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_846355419 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger()
                            .logError("Dropping Badly formatted response message >>> "
                                    + sipResponse);
                } //End collapsed parenthetic
            } //End block
            ServerResponseInterface sipServerResponse;
            sipServerResponse = sipStack
                    .newSIPServerResponse(sipResponse, this);
            {
                try 
                {
                    {
                        boolean varE75FAA60313661E30299B4B6DCAFA965_757538490 = (sipServerResponse instanceof SIPClientTransaction
                            && !((SIPClientTransaction) sipServerResponse)
                                    .checkFromTag(sipResponse));
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_471012097 = (sipStack.isLoggingEnabled());
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
                        boolean varE830882F52F0DDC064CFB33E0C94EB7E_2015008731 = (sipServerResponse instanceof SIPTransaction
                            && !((SIPTransaction) sipServerResponse)
                                    .passToListener());
                        ((SIPTransaction) sipServerResponse).releaseSem();
                    } //End collapsed parenthetic
                } //End block
            } //End block
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1822540121 = (sipStack.isLoggingEnabled());
                    {
                        this.sipStack.getStackLogger().logDebug("null sipServerResponse!");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.278 -0400", hash_original_method = "148F3D833D327E61A5116C1FE99BCAC0", hash_generated_method = "083A2DE0389E1A3BB7AA82ED4CB59EF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void handleException(ParseException ex, SIPMessage sipMessage,
            Class hdrClass, String header, String message) throws ParseException {
        dsTaint.addTaint(message);
        dsTaint.addTaint(ex.dsTaint);
        dsTaint.addTaint(sipMessage.dsTaint);
        dsTaint.addTaint(hdrClass.dsTaint);
        dsTaint.addTaint(header);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1791203191 = (sipStack.isLoggingEnabled());
            this.sipStack.getStackLogger().logException(ex);
        } //End collapsed parenthetic
        {
            boolean varA507267BF4B92BB4BF284B01D1D5F764_354988970 = ((hdrClass != null)
                && (hdrClass.equals(From.class) || hdrClass.equals(To.class)
                        || hdrClass.equals(CSeq.class)
                        || hdrClass.equals(Via.class)
                        || hdrClass.equals(CallID.class)
                        || hdrClass.equals(RequestLine.class) || hdrClass
                        .equals(StatusLine.class)));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_684341828 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logError("BAD MESSAGE!");
                        sipStack.getStackLogger().logError(message);
                    } //End block
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw ex;
            } //End block
            {
                sipMessage.addUnparsed(header);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (sipStack.isLoggingEnabled())
            //this.sipStack.getStackLogger().logException(ex);
        //if ((hdrClass != null)
                //&& (hdrClass.equals(From.class) || hdrClass.equals(To.class)
                        //|| hdrClass.equals(CSeq.class)
                        //|| hdrClass.equals(Via.class)
                        //|| hdrClass.equals(CallID.class)
                        //|| hdrClass.equals(RequestLine.class) || hdrClass
                        //.equals(StatusLine.class))) {
        	//if (sipStack.isLoggingEnabled()) {
        		//sipStack.getStackLogger().logError("BAD MESSAGE!");
            	//sipStack.getStackLogger().logError(message);
        	//}
            //throw ex;
        //} else {
            //sipMessage.addUnparsed(header);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.301 -0400", hash_original_method = "5949601888B92CAB7F6BB9E6373E9083", hash_generated_method = "0F4F27C37A67DEC752AD61966B152771")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendMessage(SIPMessage sipMessage) throws IOException {
        dsTaint.addTaint(sipMessage.dsTaint);
        {
            boolean var3BF3C2EA8CA9182E664AB6FE30991BAF_775799690 = (sipStack.isLoggingEnabled() && this.sipStack.isLogStackTraceOnMessageSend());
            {
                {
                    boolean var8DA488598994EBF1C41434FD73AFB7C6_1720611854 = (sipMessage instanceof SIPRequest &&
                    ((SIPRequest)sipMessage).getRequestLine() != null);
                    {
                        this.sipStack.getStackLogger().logStackTrace(StackLogger.TRACE_INFO);
                    } //End block
                    {
                        this.sipStack.getStackLogger().logStackTrace(StackLogger.TRACE_INFO);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        long time;
        time = System.currentTimeMillis();
        try 
        {
            {
                MessageProcessor messageProcessor = sipStack
                    .getMessageProcessors()[0];
                {
                    {
                        boolean var37D638BEA91B51F1E4F5579247CF5778_2140230634 = (messageProcessor.getIpAddress().equals(this.peerAddress)
                        && messageProcessor.getPort() == this.peerPort
                        && messageProcessor.getTransport().equals(
                                this.peerProtocol));
                        {
                            MessageChannel messageChannel;
                            messageChannel = messageProcessor
                            .createMessageChannel(this.peerAddress,
                                    this.peerPort);
                            {
                                ((RawMessageChannel) messageChannel)
                                .processMessage(sipMessage);
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_347074677 = (sipStack.isLoggingEnabled());
                                    sipStack.getStackLogger().logDebug("Self routing message");
                                } //End collapsed parenthetic
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            byte[] msg;
            msg = sipMessage.encodeAsBytes( this.getTransport() );
            sendMessage(msg, peerAddress, peerPort, peerProtocol,
                    sipMessage instanceof SIPRequest);
        } //End block
        catch (IOException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw ex;
        } //End block
        catch (Exception ex)
        {
            sipStack.getStackLogger().logError("An exception occured while sending message",ex);
            if (DroidSafeAndroidRuntime.control) throw new IOException(
                    "An exception occured while sending message");
        } //End block
        finally 
        {
            {
                boolean var161C41EFE3B277A3D1A2C98433E0C178_1128027517 = (sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES) && !sipMessage.isNullRequest());
                logMessage(sipMessage, peerAddress, peerPort, time);
                {
                    boolean varA725024344C592B5004E395739F1C5C4_773784530 = (sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_DEBUG));
                    sipStack.getStackLogger().logDebug("Sent EMPTY Message");
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.302 -0400", hash_original_method = "E29573D85212414C15B5600ED44221C0", hash_generated_method = "801A1DDDA0908ECBB35618C9C4EC5A3B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void sendMessage(byte[] msg, InetAddress peerAddress,
            int peerPort, boolean reConnect) throws IOException {
        dsTaint.addTaint(reConnect);
        dsTaint.addTaint(peerAddress.dsTaint);
        dsTaint.addTaint(msg[0]);
        dsTaint.addTaint(peerPort);
        {
            boolean var3BF3C2EA8CA9182E664AB6FE30991BAF_805130221 = (sipStack.isLoggingEnabled() && this.sipStack.isLogStackTraceOnMessageSend());
            {
                this.sipStack.getStackLogger().logStackTrace(StackLogger.TRACE_INFO);
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1656277556 = (sipStack.isLoggingEnabled());
                {
                    this.sipStack.getStackLogger().logDebug(getClass().getName()
                        + ":sendMessage: Dropping reply!");
                } //End block
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) throw new IOException("Receiver port not set ");
        } //End block
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1675072988 = (sipStack.isLoggingEnabled());
                {
                    this.sipStack.getStackLogger().logDebug("sendMessage " + peerAddress.getHostAddress() + "/"
                        + peerPort + "\n" + "messageSize =  "  + msg.length + " message = " + new String(msg));
                    this.sipStack.getStackLogger().logDebug("*******************\n");
                } //End block
            } //End collapsed parenthetic
        } //End block
        DatagramPacket reply;
        reply = new DatagramPacket(msg, msg.length, peerAddress,
                peerPort);
        try 
        {
            DatagramSocket sock;
            boolean created;
            created = false;
            {
                sock = ((UDPMessageProcessor) messageProcessor).sock;
            } //End block
            {
                sock = new DatagramSocket();
                created = true;
            } //End block
            sock.send(reply);
            sock.close();
        } //End block
        catch (IOException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw ex;
        } //End block
        catch (Exception ex)
        {
            InternalErrorHandler.handleException(ex);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.302 -0400", hash_original_method = "38908DF8BAD797C5C3B9904DFAB1ABDF", hash_generated_method = "7C3B09DC43A8383FF5CCE5CAEB42B03D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void sendMessage(byte[] msg, InetAddress peerAddress,
            int peerPort, String peerProtocol, boolean retry) throws IOException {
        dsTaint.addTaint(peerProtocol);
        dsTaint.addTaint(peerAddress.dsTaint);
        dsTaint.addTaint(retry);
        dsTaint.addTaint(msg[0]);
        dsTaint.addTaint(peerPort);
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_550840928 = (sipStack.isLoggingEnabled());
                {
                    this.sipStack.getStackLogger().logDebug(getClass().getName()
                        + ":sendMessage: Dropping reply!");
                } //End block
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) throw new IOException("Receiver port not set ");
        } //End block
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1767449108 = (sipStack.isLoggingEnabled());
                {
                    this.sipStack.getStackLogger().logDebug( ":sendMessage " + peerAddress.getHostAddress() + "/"
                        + peerPort + "\n" + " messageSize = " + msg.length);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean varD90E5EEAD7F10D5D3C85319211A35E0C_209359638 = (peerProtocol.compareToIgnoreCase("UDP") == 0);
            {
                DatagramPacket reply;
                reply = new DatagramPacket(msg, msg.length,
                    peerAddress, peerPort);
                try 
                {
                    DatagramSocket sock;
                    {
                        sock = ((UDPMessageProcessor) messageProcessor).sock;
                    } //End block
                    {
                        sock = sipStack.getNetworkLayer().createDatagramSocket();
                    } //End block
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_352762317 = (sipStack.isLoggingEnabled());
                        {
                            this.sipStack.getStackLogger().logDebug("sendMessage "
                            + peerAddress.getHostAddress() + "/" + peerPort
                            + "\n" + new String(msg));
                        } //End block
                    } //End collapsed parenthetic
                    sock.send(reply);
                    sock.close();
                } //End block
                catch (IOException ex)
                {
                    if (DroidSafeAndroidRuntime.control) throw ex;
                } //End block
                catch (Exception ex)
                {
                    InternalErrorHandler.handleException(ex);
                } //End block
            } //End block
            {
                Socket outputSocket;
                outputSocket = sipStack.ioHandler.sendBytes(
                    this.messageProcessor.getIpAddress(), peerAddress,
                    peerPort, "tcp", msg, retry,this);
                OutputStream myOutputStream;
                myOutputStream = outputSocket.getOutputStream();
                myOutputStream.write(msg, 0, msg.length);
                myOutputStream.flush();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.303 -0400", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "0AAC993F2B0EE288482DFA16632D8269")
    @DSModeled(DSC.SAFE)
    public SIPTransactionStack getSIPStack() {
        return (SIPTransactionStack)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sipStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.303 -0400", hash_original_method = "B7A5D479C43293000A9EAFE6F93DF6D0", hash_generated_method = "447B990ABE7D82F1DD8055F64757B036")
    @DSModeled(DSC.SAFE)
    public String getTransport() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return SIPConstants.UDP;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.303 -0400", hash_original_method = "EA072AA1AE1B409D48E6BC6990EBDEC5", hash_generated_method = "F2BF4711C9ACCA4FC16EA028E84094B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getHost() {
        String var5BCD5252B9BD017465FD628ED7276DDA_82867235 = (messageProcessor.getIpAddress().getHostAddress());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return messageProcessor.getIpAddress().getHostAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.303 -0400", hash_original_method = "891FD85C4A46ECEDCCE8E5933BDC3ADD", hash_generated_method = "9DBE8F13F0D9EA28EFF2DE546B4A1737")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPort() {
        int var08018CA200139FEC794EAAFB8EB517CE_862228639 = (((UDPMessageProcessor) messageProcessor).getPort());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return ((UDPMessageProcessor) messageProcessor).getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.303 -0400", hash_original_method = "86CAA293F63DFC3CC87A4ACD6BC27DDA", hash_generated_method = "FB5A251203C7EF6881DBA9EADE38679C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPeerName() {
        String varDE6457F2C82F05D08D0D085B8F4661BD_470127943 = (peerAddress.getHostName());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return peerAddress.getHostName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.303 -0400", hash_original_method = "A07C7EAAB254DF7A2A64ECDA7F650470", hash_generated_method = "70431C9241E1D9FD5E29EA73B8B601A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPeerAddress() {
        String var47E3F0432452243B392A376991773E94_449180899 = (peerAddress.getHostAddress());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return peerAddress.getHostAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.304 -0400", hash_original_method = "1F29EC3BC94C3E0863F530FCD37A61F3", hash_generated_method = "B75EA17B15223DF670C4300DF5D740DC")
    @DSModeled(DSC.SAFE)
    protected InetAddress getPeerInetAddress() {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return peerAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.304 -0400", hash_original_method = "3F01B3F60F79E6CB5C3DF3B66FDD88DE", hash_generated_method = "F3B2A430E277BDEF47EE2C6540EA63FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        boolean retval;
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_637326585 = (!this.getClass().equals(other.getClass()));
            {
                retval = false;
            } //End block
            {
                UDPMessageChannel that;
                that = (UDPMessageChannel) other;
                retval = this.getKey().equals(that.getKey());
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (other == null)
            //return false;
        //boolean retval;
        //if (!this.getClass().equals(other.getClass())) {
            //retval = false;
        //} else {
            //UDPMessageChannel that = (UDPMessageChannel) other;
            //retval = this.getKey().equals(that.getKey());
        //}
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.304 -0400", hash_original_method = "8A0A97143B2090B701AABAA2A97E73FB", hash_generated_method = "F41DBC9AEAEB4A138AAB5E63A3F596C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getKey() {
        String var8A66DE08122FD6EC4FCDDEF7A05AC867_2071140845 = (getKey(peerAddress, peerPort, "UDP"));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getKey(peerAddress, peerPort, "UDP");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.304 -0400", hash_original_method = "66F44212C04D4B032E5D57BC9126F4FF", hash_generated_method = "F297C331E54364C1F51C42BBD20DE144")
    @DSModeled(DSC.SAFE)
    public int getPeerPacketSourcePort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return peerPacketSourcePort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.304 -0400", hash_original_method = "DC065FB3DE06142DBC04F100FD01BCF3", hash_generated_method = "EA514EEE7FFF2B4B31DF65E138A3BC3F")
    @DSModeled(DSC.SAFE)
    public InetAddress getPeerPacketSourceAddress() {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return peerPacketSourceAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.304 -0400", hash_original_method = "B7C8CBECE48532207EA3107C3752BABB", hash_generated_method = "F60101C6B2B04C84924E3397632C9510")
    @DSModeled(DSC.SAFE)
    public String getViaHost() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.myAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.304 -0400", hash_original_method = "F69C682C43E3A7CF8FCB14E212CB7049", hash_generated_method = "D64E273F55D666A1CE85DBE5F985853A")
    @DSModeled(DSC.SAFE)
    public int getViaPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.myPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.305 -0400", hash_original_method = "457243F9D7A1AB9FD34866D85709C85D", hash_generated_method = "E95DFCAB43CE008AFCB8CFF32023A226")
    @DSModeled(DSC.SAFE)
    public boolean isReliable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.305 -0400", hash_original_method = "51201694E0EE76265BF39848EF10BE9C", hash_generated_method = "7FD317C466D6873CE376C80F23CBD437")
    @DSModeled(DSC.SAFE)
    public boolean isSecure() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.305 -0400", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "AEBA702D6111FFED2D7D8A1EFD0D8FC1")
    @DSModeled(DSC.SAFE)
    public int getPeerPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return peerPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.305 -0400", hash_original_method = "DB79607DA3ACB5FA2D24428DF2713F98", hash_generated_method = "B04499CEAABB7F00BDAEC74FE715B53A")
    @DSModeled(DSC.SAFE)
    public String getPeerProtocol() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.peerProtocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.305 -0400", hash_original_method = "B96EF178F3ED1A0DFACDA94649407E5C", hash_generated_method = "1CF5A5DB4E3FE1187B00A561217E4793")
    @DSModeled(DSC.SAFE)
    public void close() {
        // ---------- Original Method ----------
    }

    
    class PingBackTimerTask extends TimerTask {
        String ipAddress;
        int port;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.305 -0400", hash_original_method = "041AEFB77EA8D7413831FA09D8E7E5F2", hash_generated_method = "E489A984B32F1A4B54676692A902980F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PingBackTimerTask(String ipAddress, int port) {
            dsTaint.addTaint(port);
            dsTaint.addTaint(ipAddress);
            pingBackRecord.put(ipAddress + ":" + port, this);
            // ---------- Original Method ----------
            //this.ipAddress = ipAddress;
            //this.port = port;
            //pingBackRecord.put(ipAddress + ":" + port, this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.306 -0400", hash_original_method = "6BA8F9798D5715ABDAD288256921D45A", hash_generated_method = "A12DB3F698D6F6B742E8AA41F07B747A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void run() {
            pingBackRecord.remove(ipAddress + ":" + port);
            // ---------- Original Method ----------
            //pingBackRecord.remove(ipAddress + ":" + port);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.306 -0400", hash_original_method = "E214E7BC5755C758A91BCF58AAE3832E", hash_generated_method = "E0CBD0BBF689FE0AFCAC393A4AF6F919")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int varFAFA3497566668EE5F9BFBDEC9425D0B_1089408647 = ((ipAddress + ":" + port).hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return (ipAddress + ":" + port).hashCode();
        }

        
    }


    
}

