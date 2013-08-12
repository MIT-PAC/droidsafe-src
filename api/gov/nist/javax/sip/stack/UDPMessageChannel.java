package gov.nist.javax.sip.stack;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.053 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "3233C5012C49C796F9D6BBC8E02EAB41")

    protected SIPTransactionStack sipStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.053 -0400", hash_original_field = "8C35693B192604DA4AB63AD19D48096F", hash_generated_field = "0A43681EE1A6E215BE82E39AC59DFE7C")

    protected StringMsgParser myParser;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.053 -0400", hash_original_field = "D7FA5E7DC9BACC5016B81E35D44D1C5F", hash_generated_field = "DB2440387A41D5016778DA700632E003")

    private InetAddress peerAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.053 -0400", hash_original_field = "AA48C74491DE12FAB31F14F04DE0F567", hash_generated_field = "DEE18A414D72F7D580E73EF519B5B75F")

    private String myAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.053 -0400", hash_original_field = "E2843BEFA12DEA2BD46F0D29DAA8CB35", hash_generated_field = "917EBAB90EE3EF0904EF1CC7129F7C3B")

    private int peerPacketSourcePort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.053 -0400", hash_original_field = "1906DDE6FBF1A1A564E69A91EBCF4043", hash_generated_field = "31AFBD6F92700654B3E6CD25C4BAE79B")

    private InetAddress peerPacketSourceAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.053 -0400", hash_original_field = "BBD5741C4F9994864582D25DD194C4DE", hash_generated_field = "FE74A5BA5CFBB5B6DC2B68FEFA76ECFC")

    private int peerPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.053 -0400", hash_original_field = "EDB6E8FD971C3E6879E1A00995BCB702", hash_generated_field = "EB665B7537D07145A6FCAD2DB460EADC")

    private String peerProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.053 -0400", hash_original_field = "AB99FC537949F4680FB25A11A38B0042", hash_generated_field = "AD61806C610E09EDA888D5EC477B22F2")

    protected int myPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.053 -0400", hash_original_field = "C1C12C1266B0C0AC2B9F460C87F4F641", hash_generated_field = "5DCE0469450ABB74FDB5A37D9DFDF23A")

    private DatagramPacket incomingPacket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.053 -0400", hash_original_field = "52E9EDC753D35EB688ED2EC5FA2A70C4", hash_generated_field = "FDC149166FA9FE14388FB5695DD3C00D")

    private long receptionTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.053 -0400", hash_original_field = "19007373CE3841015C166CC983644A31", hash_generated_field = "DE4903FFD06AF3966ED05EEB79D4D38C")

    private Hashtable<String,PingBackTimerTask> pingBackRecord = new Hashtable<String,PingBackTimerTask>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.054 -0400", hash_original_method = "03A64681434F0E8B0C9121AC8F1C5237", hash_generated_method = "19FE0DB1F35C1B867E3F19F8F675652D")
    protected  UDPMessageChannel(SIPTransactionStack stack,
            UDPMessageProcessor messageProcessor) {
        super.messageProcessor = messageProcessor;
        this.sipStack = stack;
        Thread mythread = new Thread(this);
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.055 -0400", hash_original_method = "1756885BA9DE2BFD3C0F236D276D29E7", hash_generated_method = "B6119B8D65B92CD937056FF8F4DDCCDC")
    protected  UDPMessageChannel(SIPTransactionStack stack,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.057 -0400", hash_original_method = "776DD93072EC88FB0665477FC0515605", hash_generated_method = "7613B602B46BE7944019C9100A86CCB1")
    protected  UDPMessageChannel(InetAddress targetAddr, int port,
            SIPTransactionStack sipStack, UDPMessageProcessor messageProcessor) {
        peerAddress = targetAddr;
        peerPort = port;
        peerProtocol = "UDP";
        super.messageProcessor = messageProcessor;
        this.myAddress = messageProcessor.getIpAddress().getHostAddress();
        this.myPort = messageProcessor.getPort();
        this.sipStack = sipStack;
        if(sipStack.isLoggingEnabled())        
        {
            this.sipStack.getStackLogger().logDebug("Creating message channel "
                    + targetAddr.getHostAddress() + "/" + port);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.059 -0400", hash_original_method = "E6EA1046257028C8ED28AF4C13B7A731", hash_generated_method = "5E52B0490617E2DCAB6B4A11F2874906")
    public void run() {
        ThreadAuditor.ThreadHandle threadHandle = null;
        while
(true)        
        {
            if(myParser == null)            
            {
                myParser = new StringMsgParser();
                myParser.setParseExceptionListener(this);
            } //End block
            DatagramPacket packet;
            if(sipStack.threadPoolSize != -1)            
            {
                synchronized
(((UDPMessageProcessor) messageProcessor).messageQueue)                {
                    while
(((UDPMessageProcessor) messageProcessor).messageQueue
                            .isEmpty())                    
                    {
                        if(!((UDPMessageProcessor) messageProcessor).isRunning)                        
                        return;
                        try 
                        {
                            if(threadHandle == null)                            
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
                        {
                            if(!((UDPMessageProcessor) messageProcessor).isRunning)                            
                            return;
                        } //End block
                    } //End block
                    packet = (DatagramPacket) ((UDPMessageProcessor) messageProcessor).messageQueue
                            .removeFirst();
                } //End block
                this.incomingPacket = packet;
            } //End block
            else
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
            if(sipStack.threadPoolSize == -1)            
            {
                return;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.063 -0400", hash_original_method = "2D23A147968127857F47AE9C2F0B0301", hash_generated_method = "2CA7A331983DDF57027DA579105AD0C0")
    private void processIncomingDataPacket(DatagramPacket packet) throws Exception {
        this.peerAddress = packet.getAddress();
        int packetLength = packet.getLength();
        byte[] bytes = packet.getData();
        byte[] msgBytes = new byte[packetLength];
        System.arraycopy(bytes, 0, msgBytes, 0, packetLength);
        if(sipStack.isLoggingEnabled())        
        {
            this.sipStack.getStackLogger()
                    .logDebug("UDPMessageChannel: processIncomingDataPacket : peerAddress = "
                            + peerAddress.getHostAddress() + "/"
                            + packet.getPort() + " Length = " + packetLength);
        } //End block
        SIPMessage sipMessage = null;
        try 
        {
            this.receptionTime = System.currentTimeMillis();
            sipMessage = myParser.parseSIPMessage(msgBytes);
            myParser = null;
        } //End block
        catch (ParseException ex)
        {
            myParser = null;
            if(sipStack.isLoggingEnabled())            
            {
                this.sipStack.getStackLogger().logDebug("Rejecting message !  "
                        + new String(msgBytes));
                this.sipStack.getStackLogger().logDebug("error message "
                        + ex.getMessage());
                this.sipStack.getStackLogger().logException(ex);
            } //End block
            String msgString = new String(msgBytes, 0, packetLength);
            if(!msgString.startsWith("SIP/") && !msgString.startsWith("ACK "))            
            {
                String badReqRes = createBadReqRes(msgString, ex);
                if(badReqRes != null)                
                {
                    if(sipStack.isLoggingEnabled())                    
                    {
                        sipStack.getStackLogger().logDebug(
                                "Sending automatic 400 Bad Request:");
                        sipStack.getStackLogger().logDebug(badReqRes);
                    } //End block
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
                else
                {
                    if(sipStack.isLoggingEnabled())                    
                    {
                        sipStack
                                .getStackLogger()
                                .logDebug(
                                        "Could not formulate automatic 400 Bad Request");
                    } //End block
                } //End block
            } //End block
            return;
        } //End block
        if(sipMessage == null)        
        {
            if(sipStack.isLoggingEnabled())            
            {
                this.sipStack.getStackLogger().logDebug("Rejecting message !  + Null message parsed.");
            } //End block
            if(pingBackRecord.get(packet.getAddress().getHostAddress() + ":" + packet.getPort()) == null)            
            {
                byte[] retval = "\r\n\r\n".getBytes();
                DatagramPacket keepalive = new DatagramPacket(retval,0,retval.length,packet.getAddress(),packet.getPort());
                ((UDPMessageProcessor)this.messageProcessor).sock.send(keepalive);
                this.sipStack.getTimer().schedule(new PingBackTimerTask(packet.getAddress().getHostAddress(), 
                            packet.getPort()), 1000);
            } //End block
            return;
        } //End block
        ViaList viaList = sipMessage.getViaHeaders();
        if(sipMessage.getFrom() == null || sipMessage.getTo() == null
                || sipMessage.getCallId() == null
                || sipMessage.getCSeq() == null
                || sipMessage.getViaHeaders() == null)        
        {
            String badmsg = new String(msgBytes);
            if(sipStack.isLoggingEnabled())            
            {
                this.sipStack.getStackLogger().logError("bad message " + badmsg);
                this.sipStack.getStackLogger().logError(">>> Dropped Bad Msg "
                        + "From = " + sipMessage.getFrom() + "To = "
                        + sipMessage.getTo() + "CallId = "
                        + sipMessage.getCallId() + "CSeq = "
                        + sipMessage.getCSeq() + "Via = "
                        + sipMessage.getViaHeaders());
            } //End block
            return;
        } //End block
        if(sipMessage instanceof SIPRequest)        
        {
            Via v = (Via) viaList.getFirst();
            Hop hop = sipStack.addressResolver.resolveAddress(v.getHop());
            this.peerPort = hop.getPort();
            this.peerProtocol = v.getTransport();
            this.peerPacketSourceAddress = packet.getAddress();
            this.peerPacketSourcePort = packet.getPort();
            try 
            {
                this.peerAddress = packet.getAddress();
                boolean hasRPort = v.hasParameter(Via.RPORT);
                if(hasRPort
                        || !hop.getHost().equals(
                                this.peerAddress.getHostAddress()))                
                {
                    v.setParameter(Via.RECEIVED, this.peerAddress
                            .getHostAddress());
                } //End block
                if(hasRPort)                
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
        else
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.065 -0400", hash_original_method = "DCEA2882E2241B5A52F15EAA80B8F270", hash_generated_method = "809D794932CC21C98A933CAAFC45C586")
    public void processMessage(SIPMessage sipMessage) {
        addTaint(sipMessage.getTaint());
        if(sipMessage instanceof SIPRequest)        
        {
            SIPRequest sipRequest = (SIPRequest) sipMessage;
            if(sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES))            
            {
                this.sipStack.serverLogger.logMessage(sipMessage, this
                        .getPeerHostPort().toString(), this.getHost() + ":"
                        + this.myPort, false, receptionTime);
            } //End block
            ServerRequestInterface sipServerRequest = sipStack
                    .newSIPServerRequest(sipRequest, this);
            if(sipServerRequest == null)            
            {
                if(sipStack.isLoggingEnabled())                
                {
                    this.sipStack.getStackLogger()
                            .logWarning("Null request interface returned -- dropping request");
                } //End block
                return;
            } //End block
            if(sipStack.isLoggingEnabled())            
            this.sipStack.getStackLogger().logDebug("About to process "
                        + sipRequest.getFirstLine() + "/" + sipServerRequest);
            try 
            {
                sipServerRequest.processRequest(sipRequest, this);
            } //End block
            finally 
            {
                if(sipServerRequest instanceof SIPTransaction)                
                {
                    SIPServerTransaction sipServerTx = (SIPServerTransaction) sipServerRequest;
                    if(!sipServerTx.passToListener())                    
                    {
                        ((SIPTransaction) sipServerRequest).releaseSem();
                    } //End block
                } //End block
            } //End block
            if(sipStack.isLoggingEnabled())            
            this.sipStack.getStackLogger().logDebug("Done processing "
                        + sipRequest.getFirstLine() + "/" + sipServerRequest);
        } //End block
        else
        {
            SIPResponse sipResponse = (SIPResponse) sipMessage;
            try 
            {
                sipResponse.checkHeaders();
            } //End block
            catch (ParseException ex)
            {
                if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger()
                            .logError("Dropping Badly formatted response message >>> "
                                    + sipResponse);
                return;
            } //End block
            ServerResponseInterface sipServerResponse = sipStack
                    .newSIPServerResponse(sipResponse, this);
            if(sipServerResponse != null)            
            {
                try 
                {
                    if(sipServerResponse instanceof SIPClientTransaction
                            && !((SIPClientTransaction) sipServerResponse)
                                    .checkFromTag(sipResponse))                    
                    {
                        if(sipStack.isLoggingEnabled())                        
                        sipStack.getStackLogger()
                                    .logError("Dropping response message with invalid tag >>> "
                                            + sipResponse);
                        return;
                    } //End block
                    sipServerResponse.processResponse(sipResponse, this);
                } //End block
                finally 
                {
                    if(sipServerResponse instanceof SIPTransaction
                            && !((SIPTransaction) sipServerResponse)
                                    .passToListener())                    
                    ((SIPTransaction) sipServerResponse).releaseSem();
                } //End block
            } //End block
            else
            {
                if(sipStack.isLoggingEnabled())                
                {
                    this.sipStack.getStackLogger().logDebug("null sipServerResponse!");
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.066 -0400", hash_original_method = "148F3D833D327E61A5116C1FE99BCAC0", hash_generated_method = "016E6D1B68FB40B431353D5431004703")
    public void handleException(ParseException ex, SIPMessage sipMessage,
            Class hdrClass, String header, String message) throws ParseException {
        addTaint(message.getTaint());
        addTaint(header.getTaint());
        addTaint(hdrClass.getTaint());
        addTaint(sipMessage.getTaint());
        addTaint(ex.getTaint());
        if(sipStack.isLoggingEnabled())        
        this.sipStack.getStackLogger().logException(ex);
        if((hdrClass != null)
                && (hdrClass.equals(From.class) || hdrClass.equals(To.class)
                        || hdrClass.equals(CSeq.class)
                        || hdrClass.equals(Via.class)
                        || hdrClass.equals(CallID.class)
                        || hdrClass.equals(RequestLine.class) || hdrClass
                        .equals(StatusLine.class)))        
        {
            if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logError("BAD MESSAGE!");
                sipStack.getStackLogger().logError(message);
            } //End block
            ex.addTaint(taint);
            throw ex;
        } //End block
        else
        {
            sipMessage.addUnparsed(header);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.067 -0400", hash_original_method = "5949601888B92CAB7F6BB9E6373E9083", hash_generated_method = "E2C84BC50D52D4CBEAAC273BEA41E931")
    public void sendMessage(SIPMessage sipMessage) throws IOException {
        addTaint(sipMessage.getTaint());
        if(sipStack.isLoggingEnabled() && this.sipStack.isLogStackTraceOnMessageSend())        
        {
            if(sipMessage instanceof SIPRequest &&
                    ((SIPRequest)sipMessage).getRequestLine() != null)            
            {
                this.sipStack.getStackLogger().logStackTrace(StackLogger.TRACE_INFO);
            } //End block
            else
            {
                this.sipStack.getStackLogger().logStackTrace(StackLogger.TRACE_INFO);
            } //End block
        } //End block
        long time = System.currentTimeMillis();
        try 
        {
for(MessageProcessor messageProcessor : sipStack
                    .getMessageProcessors())
            {
                if(messageProcessor.getIpAddress().equals(this.peerAddress)
                        && messageProcessor.getPort() == this.peerPort
                        && messageProcessor.getTransport().equals(
                                this.peerProtocol))                
                {
                    MessageChannel messageChannel = messageProcessor
                            .createMessageChannel(this.peerAddress,
                                    this.peerPort);
                    if(messageChannel instanceof RawMessageChannel)                    
                    {
                        ((RawMessageChannel) messageChannel)
                                .processMessage(sipMessage);
                        if(sipStack.isLoggingEnabled())                        
                        sipStack.getStackLogger().logDebug("Self routing message");
                        return;
                    } //End block
                } //End block
            } //End block
            byte[] msg = sipMessage.encodeAsBytes( this.getTransport() );
            sendMessage(msg, peerAddress, peerPort, peerProtocol,
                    sipMessage instanceof SIPRequest);
        } //End block
        catch (IOException ex)
        {
            ex.addTaint(taint);
            throw ex;
        } //End block
        catch (Exception ex)
        {
            sipStack.getStackLogger().logError("An exception occured while sending message",ex);
            IOException var295C1AD2872F097E096FF695C791C8A3_1469144677 = new IOException(
                    "An exception occured while sending message");
            var295C1AD2872F097E096FF695C791C8A3_1469144677.addTaint(taint);
            throw var295C1AD2872F097E096FF695C791C8A3_1469144677;
        } //End block
        finally 
        {
            if(sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES) && !sipMessage.isNullRequest())            
            logMessage(sipMessage, peerAddress, peerPort, time);
            else
            if(sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_DEBUG))            
            sipStack.getStackLogger().logDebug("Sent EMPTY Message");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.070 -0400", hash_original_method = "E29573D85212414C15B5600ED44221C0", hash_generated_method = "9745BE369FE44CAF7A5A502B2FF7805C")
    protected void sendMessage(byte[] msg, InetAddress peerAddress,
            int peerPort, boolean reConnect) throws IOException {
        addTaint(reConnect);
        addTaint(peerPort);
        addTaint(peerAddress.getTaint());
        addTaint(msg[0]);
        if(sipStack.isLoggingEnabled() && this.sipStack.isLogStackTraceOnMessageSend())        
        {
            this.sipStack.getStackLogger().logStackTrace(StackLogger.TRACE_INFO);
        } //End block
        if(peerPort == -1)        
        {
            if(sipStack.isLoggingEnabled())            
            {
                this.sipStack.getStackLogger().logDebug(getClass().getName()
                        + ":sendMessage: Dropping reply!");
            } //End block
            IOException var77D7B83DCCAE312A2B89EEC914DE8301_991172258 = new IOException("Receiver port not set ");
            var77D7B83DCCAE312A2B89EEC914DE8301_991172258.addTaint(taint);
            throw var77D7B83DCCAE312A2B89EEC914DE8301_991172258;
        } //End block
        else
        {
            if(sipStack.isLoggingEnabled())            
            {
                this.sipStack.getStackLogger().logDebug("sendMessage " + peerAddress.getHostAddress() + "/"
                        + peerPort + "\n" + "messageSize =  "  + msg.length + " message = " + new String(msg));
                this.sipStack.getStackLogger().logDebug("*******************\n");
            } //End block
        } //End block
        DatagramPacket reply = new DatagramPacket(msg, msg.length, peerAddress,
                peerPort);
        try 
        {
            DatagramSocket sock;
            boolean created = false;
            if(sipStack.udpFlag)            
            {
                sock = ((UDPMessageProcessor) messageProcessor).sock;
            } //End block
            else
            {
                sock = new DatagramSocket();
                created = true;
            } //End block
            sock.send(reply);
            if(created)            
            sock.close();
        } //End block
        catch (IOException ex)
        {
            ex.addTaint(taint);
            throw ex;
        } //End block
        catch (Exception ex)
        {
            InternalErrorHandler.handleException(ex);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.072 -0400", hash_original_method = "38908DF8BAD797C5C3B9904DFAB1ABDF", hash_generated_method = "7A5E49801E96AECF222C89F21FFFCAF3")
    protected void sendMessage(byte[] msg, InetAddress peerAddress,
            int peerPort, String peerProtocol, boolean retry) throws IOException {
        addTaint(retry);
        addTaint(peerProtocol.getTaint());
        addTaint(peerPort);
        addTaint(peerAddress.getTaint());
        addTaint(msg[0]);
        if(peerPort == -1)        
        {
            if(sipStack.isLoggingEnabled())            
            {
                this.sipStack.getStackLogger().logDebug(getClass().getName()
                        + ":sendMessage: Dropping reply!");
            } //End block
            IOException var77D7B83DCCAE312A2B89EEC914DE8301_1621944204 = new IOException("Receiver port not set ");
            var77D7B83DCCAE312A2B89EEC914DE8301_1621944204.addTaint(taint);
            throw var77D7B83DCCAE312A2B89EEC914DE8301_1621944204;
        } //End block
        else
        {
            if(sipStack.isLoggingEnabled())            
            {
                this.sipStack.getStackLogger().logDebug( ":sendMessage " + peerAddress.getHostAddress() + "/"
                        + peerPort + "\n" + " messageSize = " + msg.length);
            } //End block
        } //End block
        if(peerProtocol.compareToIgnoreCase("UDP") == 0)        
        {
            DatagramPacket reply = new DatagramPacket(msg, msg.length,
                    peerAddress, peerPort);
            try 
            {
                DatagramSocket sock;
                if(sipStack.udpFlag)                
                {
                    sock = ((UDPMessageProcessor) messageProcessor).sock;
                } //End block
                else
                {
                    sock = sipStack.getNetworkLayer().createDatagramSocket();
                } //End block
                if(sipStack.isLoggingEnabled())                
                {
                    this.sipStack.getStackLogger().logDebug("sendMessage "
                            + peerAddress.getHostAddress() + "/" + peerPort
                            + "\n" + new String(msg));
                } //End block
                sock.send(reply);
                if(!sipStack.udpFlag)                
                sock.close();
            } //End block
            catch (IOException ex)
            {
                ex.addTaint(taint);
                throw ex;
            } //End block
            catch (Exception ex)
            {
                InternalErrorHandler.handleException(ex);
            } //End block
        } //End block
        else
        {
            Socket outputSocket = sipStack.ioHandler.sendBytes(
                    this.messageProcessor.getIpAddress(), peerAddress,
                    peerPort, "tcp", msg, retry,this);
            OutputStream myOutputStream = outputSocket.getOutputStream();
            myOutputStream.write(msg, 0, msg.length);
            myOutputStream.flush();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.072 -0400", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "9886BD4C37165540AA249BD0E8BD2A2D")
    public SIPTransactionStack getSIPStack() {
SIPTransactionStack var0FC1F21ED47F4C0C48881B0DAF112A16_1220940735 =         sipStack;
        var0FC1F21ED47F4C0C48881B0DAF112A16_1220940735.addTaint(taint);
        return var0FC1F21ED47F4C0C48881B0DAF112A16_1220940735;
        // ---------- Original Method ----------
        //return sipStack;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.072 -0400", hash_original_method = "B7A5D479C43293000A9EAFE6F93DF6D0", hash_generated_method = "0A6CDAC496708B416BA0515007147944")
    public String getTransport() {
String varB9F6AB126E8E48FAE23CD708DF3205F6_939518682 =         SIPConstants.UDP;
        varB9F6AB126E8E48FAE23CD708DF3205F6_939518682.addTaint(taint);
        return varB9F6AB126E8E48FAE23CD708DF3205F6_939518682;
        // ---------- Original Method ----------
        //return SIPConstants.UDP;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.073 -0400", hash_original_method = "EA072AA1AE1B409D48E6BC6990EBDEC5", hash_generated_method = "C4C36BA5D4C44B297FECC263C9127673")
    public String getHost() {
String var3010CADA26293A91387A56B6EBEF85DF_872371468 =         messageProcessor.getIpAddress().getHostAddress();
        var3010CADA26293A91387A56B6EBEF85DF_872371468.addTaint(taint);
        return var3010CADA26293A91387A56B6EBEF85DF_872371468;
        // ---------- Original Method ----------
        //return messageProcessor.getIpAddress().getHostAddress();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.073 -0400", hash_original_method = "891FD85C4A46ECEDCCE8E5933BDC3ADD", hash_generated_method = "415BD76B901A495D54608EC7638AAFD4")
    public int getPort() {
        int var621830C7D878CD68BF97A2283D3307A1_664951716 = (((UDPMessageProcessor) messageProcessor).getPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_179990409 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_179990409;
        // ---------- Original Method ----------
        //return ((UDPMessageProcessor) messageProcessor).getPort();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.073 -0400", hash_original_method = "86CAA293F63DFC3CC87A4ACD6BC27DDA", hash_generated_method = "D5ED85478FC0F37E7A1E75C7F3E7024F")
    public String getPeerName() {
String var1A57F3CFCCC4040722A799E9F720F59E_436740486 =         peerAddress.getHostName();
        var1A57F3CFCCC4040722A799E9F720F59E_436740486.addTaint(taint);
        return var1A57F3CFCCC4040722A799E9F720F59E_436740486;
        // ---------- Original Method ----------
        //return peerAddress.getHostName();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.073 -0400", hash_original_method = "A07C7EAAB254DF7A2A64ECDA7F650470", hash_generated_method = "9B0DC758AB3979FE53B12EA701B994C9")
    public String getPeerAddress() {
String var4D1B58EF74DF31190A62E0DF268BAE94_2076613966 =         peerAddress.getHostAddress();
        var4D1B58EF74DF31190A62E0DF268BAE94_2076613966.addTaint(taint);
        return var4D1B58EF74DF31190A62E0DF268BAE94_2076613966;
        // ---------- Original Method ----------
        //return peerAddress.getHostAddress();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.074 -0400", hash_original_method = "1F29EC3BC94C3E0863F530FCD37A61F3", hash_generated_method = "0BFB4A5F0E3B87604DF7D190EA3C977E")
    protected InetAddress getPeerInetAddress() {
InetAddress var73F565C01AAA4A3FCE210191AB87441A_1624596376 =         peerAddress;
        var73F565C01AAA4A3FCE210191AB87441A_1624596376.addTaint(taint);
        return var73F565C01AAA4A3FCE210191AB87441A_1624596376;
        // ---------- Original Method ----------
        //return peerAddress;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.074 -0400", hash_original_method = "3F01B3F60F79E6CB5C3DF3B66FDD88DE", hash_generated_method = "12FFB93B772389660E3E99EB71BFAF82")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(other == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_623782516 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_394489596 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_394489596;
        }
        boolean retval;
        if(!this.getClass().equals(other.getClass()))        
        {
            retval = false;
        } //End block
        else
        {
            UDPMessageChannel that = (UDPMessageChannel) other;
            retval = this.getKey().equals(that.getKey());
        } //End block
        boolean var020B759ADEF679A47CB9AFE965BB2314_1966364116 = (retval);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_972598906 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_972598906;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.075 -0400", hash_original_method = "8A0A97143B2090B701AABAA2A97E73FB", hash_generated_method = "FB776CA082DBEA102FC50B07D1C283B9")
    public String getKey() {
String varE99C9D8FFDB2234A8E8B2D86E3B2B163_1266550456 =         getKey(peerAddress, peerPort, "UDP");
        varE99C9D8FFDB2234A8E8B2D86E3B2B163_1266550456.addTaint(taint);
        return varE99C9D8FFDB2234A8E8B2D86E3B2B163_1266550456;
        // ---------- Original Method ----------
        //return getKey(peerAddress, peerPort, "UDP");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.075 -0400", hash_original_method = "66F44212C04D4B032E5D57BC9126F4FF", hash_generated_method = "630D7D415D00E9657AD7F7D3C96D9FA6")
    public int getPeerPacketSourcePort() {
        int varE2843BEFA12DEA2BD46F0D29DAA8CB35_1935618646 = (peerPacketSourcePort);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_471008515 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_471008515;
        // ---------- Original Method ----------
        //return peerPacketSourcePort;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.075 -0400", hash_original_method = "DC065FB3DE06142DBC04F100FD01BCF3", hash_generated_method = "418F4C3823998716575B181AA85ABC70")
    public InetAddress getPeerPacketSourceAddress() {
InetAddress var01E4E5B4A09CE35E2D0F4C2A49E83401_573044958 =         peerPacketSourceAddress;
        var01E4E5B4A09CE35E2D0F4C2A49E83401_573044958.addTaint(taint);
        return var01E4E5B4A09CE35E2D0F4C2A49E83401_573044958;
        // ---------- Original Method ----------
        //return peerPacketSourceAddress;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.075 -0400", hash_original_method = "B7C8CBECE48532207EA3107C3752BABB", hash_generated_method = "2BC284C010C780220A7EA731E5F5EE51")
    public String getViaHost() {
String varE17BD31CB51ED41A42007A2AA16E19B8_87498555 =         this.myAddress;
        varE17BD31CB51ED41A42007A2AA16E19B8_87498555.addTaint(taint);
        return varE17BD31CB51ED41A42007A2AA16E19B8_87498555;
        // ---------- Original Method ----------
        //return this.myAddress;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.075 -0400", hash_original_method = "F69C682C43E3A7CF8FCB14E212CB7049", hash_generated_method = "66C75121D6C7A10E7308E348C870691A")
    public int getViaPort() {
        int varC6715F0AAF6C865AE075715F5CF6B31B_569444158 = (this.myPort);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_581418413 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_581418413;
        // ---------- Original Method ----------
        //return this.myPort;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.076 -0400", hash_original_method = "457243F9D7A1AB9FD34866D85709C85D", hash_generated_method = "DE0D7E79F0F2EA1198A6151D8E445F8B")
    public boolean isReliable() {
        boolean var68934A3E9455FA72420237EB05902327_72456643 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1777340173 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1777340173;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.076 -0400", hash_original_method = "51201694E0EE76265BF39848EF10BE9C", hash_generated_method = "E34DE3AD3FE9FE9BE2490A8C230FF4A9")
    public boolean isSecure() {
        boolean var68934A3E9455FA72420237EB05902327_64443567 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_171683783 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_171683783;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.076 -0400", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "F0B74623848EAE9A1FB27C6737BD94D5")
    public int getPeerPort() {
        int varBBD5741C4F9994864582D25DD194C4DE_1348410129 = (peerPort);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1645511141 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1645511141;
        // ---------- Original Method ----------
        //return peerPort;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.076 -0400", hash_original_method = "DB79607DA3ACB5FA2D24428DF2713F98", hash_generated_method = "FB73F840F76CB6C0B8DF13B13DE47F19")
    public String getPeerProtocol() {
String var6B5233BA3C9F99490638F3C0025EA1D3_1480770416 =         this.peerProtocol;
        var6B5233BA3C9F99490638F3C0025EA1D3_1480770416.addTaint(taint);
        return var6B5233BA3C9F99490638F3C0025EA1D3_1480770416;
        // ---------- Original Method ----------
        //return this.peerProtocol;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.076 -0400", hash_original_method = "B96EF178F3ED1A0DFACDA94649407E5C", hash_generated_method = "1CF5A5DB4E3FE1187B00A561217E4793")
    public void close() {
        // ---------- Original Method ----------
    }

    
    class PingBackTimerTask extends TimerTask {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.077 -0400", hash_original_field = "9D0DE3EE8DA929F164DA3D6942A26C0E", hash_generated_field = "902291576A6EA4536D6C9669E1B1BFD7")

        String ipAddress;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.077 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "5A948EF636511EF149269A68FE278AED")

        int port;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.077 -0400", hash_original_method = "041AEFB77EA8D7413831FA09D8E7E5F2", hash_generated_method = "AF34990A25633808182801353E3CAE7C")
        public  PingBackTimerTask(String ipAddress, int port) {
            this.ipAddress = ipAddress;
            this.port = port;
            pingBackRecord.put(ipAddress + ":" + port, this);
            // ---------- Original Method ----------
            //this.ipAddress = ipAddress;
            //this.port = port;
            //pingBackRecord.put(ipAddress + ":" + port, this);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.078 -0400", hash_original_method = "6BA8F9798D5715ABDAD288256921D45A", hash_generated_method = "A12DB3F698D6F6B742E8AA41F07B747A")
        @Override
        public void run() {
            pingBackRecord.remove(ipAddress + ":" + port);
            // ---------- Original Method ----------
            //pingBackRecord.remove(ipAddress + ":" + port);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.078 -0400", hash_original_method = "E214E7BC5755C758A91BCF58AAE3832E", hash_generated_method = "8641BE77ABE3BD885E71C12734B6C9BB")
        @Override
        public int hashCode() {
            int var099F0198AE3EF107E309423157D58795_1985068139 = ((ipAddress + ":" + port).hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_686268882 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_686268882;
            // ---------- Original Method ----------
            //return (ipAddress + ":" + port).hashCode();
        }

        
    }


    
}

