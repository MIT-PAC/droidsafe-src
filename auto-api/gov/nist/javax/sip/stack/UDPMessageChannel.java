package gov.nist.javax.sip.stack;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.173 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "3233C5012C49C796F9D6BBC8E02EAB41")

    protected SIPTransactionStack sipStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.173 -0400", hash_original_field = "8C35693B192604DA4AB63AD19D48096F", hash_generated_field = "0A43681EE1A6E215BE82E39AC59DFE7C")

    protected StringMsgParser myParser;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.173 -0400", hash_original_field = "D7FA5E7DC9BACC5016B81E35D44D1C5F", hash_generated_field = "DB2440387A41D5016778DA700632E003")

    private InetAddress peerAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.173 -0400", hash_original_field = "AA48C74491DE12FAB31F14F04DE0F567", hash_generated_field = "DEE18A414D72F7D580E73EF519B5B75F")

    private String myAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.173 -0400", hash_original_field = "E2843BEFA12DEA2BD46F0D29DAA8CB35", hash_generated_field = "917EBAB90EE3EF0904EF1CC7129F7C3B")

    private int peerPacketSourcePort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.173 -0400", hash_original_field = "1906DDE6FBF1A1A564E69A91EBCF4043", hash_generated_field = "31AFBD6F92700654B3E6CD25C4BAE79B")

    private InetAddress peerPacketSourceAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.173 -0400", hash_original_field = "BBD5741C4F9994864582D25DD194C4DE", hash_generated_field = "FE74A5BA5CFBB5B6DC2B68FEFA76ECFC")

    private int peerPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.173 -0400", hash_original_field = "EDB6E8FD971C3E6879E1A00995BCB702", hash_generated_field = "EB665B7537D07145A6FCAD2DB460EADC")

    private String peerProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.173 -0400", hash_original_field = "AB99FC537949F4680FB25A11A38B0042", hash_generated_field = "AD61806C610E09EDA888D5EC477B22F2")

    protected int myPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.173 -0400", hash_original_field = "C1C12C1266B0C0AC2B9F460C87F4F641", hash_generated_field = "5DCE0469450ABB74FDB5A37D9DFDF23A")

    private DatagramPacket incomingPacket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.173 -0400", hash_original_field = "52E9EDC753D35EB688ED2EC5FA2A70C4", hash_generated_field = "FDC149166FA9FE14388FB5695DD3C00D")

    private long receptionTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.173 -0400", hash_original_field = "19007373CE3841015C166CC983644A31", hash_generated_field = "DE4903FFD06AF3966ED05EEB79D4D38C")

    private Hashtable<String,PingBackTimerTask> pingBackRecord = new Hashtable<String,PingBackTimerTask>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.174 -0400", hash_original_method = "03A64681434F0E8B0C9121AC8F1C5237", hash_generated_method = "19FE0DB1F35C1B867E3F19F8F675652D")
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
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.174 -0400", hash_original_method = "1756885BA9DE2BFD3C0F236D276D29E7", hash_generated_method = "B6119B8D65B92CD937056FF8F4DDCCDC")
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
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.174 -0400", hash_original_method = "776DD93072EC88FB0665477FC0515605", hash_generated_method = "71D561385CB732FFF5FE93E3539E7D56")
    protected  UDPMessageChannel(InetAddress targetAddr, int port,
            SIPTransactionStack sipStack, UDPMessageProcessor messageProcessor) {
        peerAddress = targetAddr;
        peerPort = port;
        peerProtocol = "UDP";
        super.messageProcessor = messageProcessor;
        this.myAddress = messageProcessor.getIpAddress().getHostAddress();
        this.myPort = messageProcessor.getPort();
        this.sipStack = sipStack;
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1225180729 = (sipStack.isLoggingEnabled());
            {
                this.sipStack.getStackLogger().logDebug("Creating message channel "
                    + targetAddr.getHostAddress() + "/" + port);
            } 
        } 
        
        
        
        
        
        
        
        
        
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.175 -0400", hash_original_method = "E6EA1046257028C8ED28AF4C13B7A731", hash_generated_method = "F13DB9AABFCA2EFA83118F1A0452C04C")
    public void run() {
        ThreadAuditor.ThreadHandle threadHandle = null;
        {
            {
                myParser = new StringMsgParser();
                myParser.setParseExceptionListener(this);
            } 
            DatagramPacket packet;
            {
                {
                    {
                        boolean varAD73BCE40D73F49090BF24139EA25CB8_1567072168 = (((UDPMessageProcessor) messageProcessor).messageQueue
                            .isEmpty());
                        {
                            try 
                            {
                                {
                                    threadHandle = sipStack.getThreadAuditor()
                                        .addCurrentThread();
                                } 
                                threadHandle.ping();
                                ((UDPMessageProcessor) messageProcessor).messageQueue
                                    .wait(threadHandle
                                            .getPingIntervalInMillisecs());
                            } 
                            catch (InterruptedException ex)
                            { }
                        } 
                    } 
                    packet = (DatagramPacket) ((UDPMessageProcessor) messageProcessor).messageQueue
                            .removeFirst();
                } 
                this.incomingPacket = packet;
            } 
            {
                packet = this.incomingPacket;
            } 
            try 
            {
                processIncomingDataPacket(packet);
            } 
            catch (Exception e)
            {
                sipStack.getStackLogger().logError(
                        "Error while processing incoming UDP packet", e);
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.178 -0400", hash_original_method = "2D23A147968127857F47AE9C2F0B0301", hash_generated_method = "E7E556F01D5F5EA30F26433A564178DA")
    private void processIncomingDataPacket(DatagramPacket packet) throws Exception {
        this.peerAddress = packet.getAddress();
        int packetLength = packet.getLength();
        byte[] bytes = packet.getData();
        byte[] msgBytes = new byte[packetLength];
        System.arraycopy(bytes, 0, msgBytes, 0, packetLength);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_376512701 = (sipStack.isLoggingEnabled());
            {
                this.sipStack.getStackLogger()
                    .logDebug("UDPMessageChannel: processIncomingDataPacket : peerAddress = "
                            + peerAddress.getHostAddress() + "/"
                            + packet.getPort() + " Length = " + packetLength);
            } 
        } 
        SIPMessage sipMessage = null;
        try 
        {
            this.receptionTime = System.currentTimeMillis();
            sipMessage = myParser.parseSIPMessage(msgBytes);
            myParser = null;
        } 
        catch (ParseException ex)
        {
            myParser = null;
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1392243120 = (sipStack.isLoggingEnabled());
                {
                    this.sipStack.getStackLogger().logDebug("Rejecting message !  "
                        + new String(msgBytes));
                    this.sipStack.getStackLogger().logDebug("error message "
                        + ex.getMessage());
                    this.sipStack.getStackLogger().logException(ex);
                } 
            } 
            String msgString = new String(msgBytes, 0, packetLength);
            {
                boolean var641C9D2BCF73834F157CB50DF975B192_1008477219 = (!msgString.startsWith("SIP/") && !msgString.startsWith("ACK "));
                {
                    String badReqRes = createBadReqRes(msgString, ex);
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_753907950 = (sipStack.isLoggingEnabled());
                            {
                                sipStack.getStackLogger().logDebug(
                                "Sending automatic 400 Bad Request:");
                                sipStack.getStackLogger().logDebug(badReqRes);
                            } 
                        } 
                        try 
                        {
                            this.sendMessage(badReqRes.getBytes(), peerAddress,
                                packet.getPort(), "UDP", false);
                        } 
                        catch (IOException e)
                        {
                            this.sipStack.getStackLogger().logException(e);
                        } 
                    } 
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_1254694848 = (sipStack.isLoggingEnabled());
                            {
                                sipStack
                                .getStackLogger()
                                .logDebug(
                                        "Could not formulate automatic 400 Bad Request");
                            } 
                        } 
                    } 
                } 
            } 
        } 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_303723775 = (sipStack.isLoggingEnabled());
                {
                    this.sipStack.getStackLogger().logDebug("Rejecting message !  + Null message parsed.");
                } 
            } 
            {
                boolean var9004E0463DC06B1DD21A25050AF4C311_700972613 = (pingBackRecord.get(packet.getAddress().getHostAddress() + ":" + packet.getPort()) == null);
                {
                    byte[] retval = "\r\n\r\n".getBytes();
                    DatagramPacket keepalive = new DatagramPacket(retval,0,retval.length,packet.getAddress(),packet.getPort());
                    ((UDPMessageProcessor)this.messageProcessor).sock.send(keepalive);
                    this.sipStack.getTimer().schedule(new PingBackTimerTask(packet.getAddress().getHostAddress(), 
                            packet.getPort()), 1000);
                } 
            } 
        } 
        ViaList viaList = sipMessage.getViaHeaders();
        {
            boolean var59CC7428458ADFC3199C90345ABEB8AF_800760582 = (sipMessage.getFrom() == null || sipMessage.getTo() == null
                || sipMessage.getCallId() == null
                || sipMessage.getCSeq() == null
                || sipMessage.getViaHeaders() == null);
            {
                String badmsg = new String(msgBytes);
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_923545714 = (sipStack.isLoggingEnabled());
                    {
                        this.sipStack.getStackLogger().logError("bad message " + badmsg);
                        this.sipStack.getStackLogger().logError(">>> Dropped Bad Msg "
                        + "From = " + sipMessage.getFrom() + "To = "
                        + sipMessage.getTo() + "CallId = "
                        + sipMessage.getCallId() + "CSeq = "
                        + sipMessage.getCSeq() + "Via = "
                        + sipMessage.getViaHeaders());
                    } 
                } 
            } 
        } 
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
                {
                    boolean var2EC34FA9788EADA768699B2545557487_687797501 = (hasRPort
                        || !hop.getHost().equals(
                                this.peerAddress.getHostAddress()));
                    {
                        v.setParameter(Via.RECEIVED, this.peerAddress
                            .getHostAddress());
                    } 
                } 
                {
                    v.setParameter(Via.RPORT, Integer
                            .toString(this.peerPacketSourcePort));
                } 
            } 
            catch (java.text.ParseException ex1)
            {
                InternalErrorHandler.handleException(ex1);
            } 
        } 
        {
            this.peerPacketSourceAddress = packet.getAddress();
            this.peerPacketSourcePort = packet.getPort();
            this.peerAddress = packet.getAddress();
            this.peerPort = packet.getPort();
            this.peerProtocol = ((Via) viaList.getFirst()).getTransport();
        } 
        this.processMessage(sipMessage);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.179 -0400", hash_original_method = "DCEA2882E2241B5A52F15EAA80B8F270", hash_generated_method = "C9ED0166F0E7BC6D8D1230DE3D5B19B9")
    public void processMessage(SIPMessage sipMessage) {
        {
            SIPRequest sipRequest = (SIPRequest) sipMessage;
            {
                boolean varB20158C23C001B703CFD19B38FE62BAB_240403251 = (sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES));
                {
                    this.sipStack.serverLogger.logMessage(sipMessage, this
                        .getPeerHostPort().toString(), this.getHost() + ":"
                        + this.myPort, false, receptionTime);
                } 
            } 
            ServerRequestInterface sipServerRequest = sipStack
                    .newSIPServerRequest(sipRequest, this);
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1941745980 = (sipStack.isLoggingEnabled());
                    {
                        this.sipStack.getStackLogger()
                            .logWarning("Null request interface returned -- dropping request");
                    } 
                } 
            } 
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_742469413 = (sipStack.isLoggingEnabled());
                this.sipStack.getStackLogger().logDebug("About to process "
                        + sipRequest.getFirstLine() + "/" + sipServerRequest);
            } 
            try 
            {
                sipServerRequest.processRequest(sipRequest, this);
            } 
            finally 
            {
                {
                    SIPServerTransaction sipServerTx = (SIPServerTransaction) sipServerRequest;
                    {
                        boolean varDFD8B605D678E12460F98516E8CB0D44_1030867335 = (!sipServerTx.passToListener());
                        {
                            ((SIPTransaction) sipServerRequest).releaseSem();
                        } 
                    } 
                } 
            } 
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1604197948 = (sipStack.isLoggingEnabled());
                this.sipStack.getStackLogger().logDebug("Done processing "
                        + sipRequest.getFirstLine() + "/" + sipServerRequest);
            } 
        } 
        {
            SIPResponse sipResponse = (SIPResponse) sipMessage;
            try 
            {
                sipResponse.checkHeaders();
            } 
            catch (ParseException ex)
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_173463750 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger()
                            .logError("Dropping Badly formatted response message >>> "
                                    + sipResponse);
                } 
            } 
            ServerResponseInterface sipServerResponse = sipStack
                    .newSIPServerResponse(sipResponse, this);
            {
                try 
                {
                    {
                        boolean varE75FAA60313661E30299B4B6DCAFA965_1236748121 = (sipServerResponse instanceof SIPClientTransaction
                            && !((SIPClientTransaction) sipServerResponse)
                                    .checkFromTag(sipResponse));
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_495637900 = (sipStack.isLoggingEnabled());
                                sipStack.getStackLogger()
                                    .logError("Dropping response message with invalid tag >>> "
                                            + sipResponse);
                            } 
                        } 
                    } 
                    sipServerResponse.processResponse(sipResponse, this);
                } 
                finally 
                {
                    {
                        boolean varE830882F52F0DDC064CFB33E0C94EB7E_644285717 = (sipServerResponse instanceof SIPTransaction
                            && !((SIPTransaction) sipServerResponse)
                                    .passToListener());
                        ((SIPTransaction) sipServerResponse).releaseSem();
                    } 
                } 
            } 
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_187175021 = (sipStack.isLoggingEnabled());
                    {
                        this.sipStack.getStackLogger().logDebug("null sipServerResponse!");
                    } 
                } 
            } 
        } 
        addTaint(sipMessage.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.180 -0400", hash_original_method = "148F3D833D327E61A5116C1FE99BCAC0", hash_generated_method = "FFA33AE0FF079A492F3763D0CC76895C")
    public void handleException(ParseException ex, SIPMessage sipMessage,
            Class hdrClass, String header, String message) throws ParseException {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1334529949 = (sipStack.isLoggingEnabled());
            this.sipStack.getStackLogger().logException(ex);
        } 
        {
            boolean varA507267BF4B92BB4BF284B01D1D5F764_1913149767 = ((hdrClass != null)
                && (hdrClass.equals(From.class) || hdrClass.equals(To.class)
                        || hdrClass.equals(CSeq.class)
                        || hdrClass.equals(Via.class)
                        || hdrClass.equals(CallID.class)
                        || hdrClass.equals(RequestLine.class) || hdrClass
                        .equals(StatusLine.class)));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1048440016 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logError("BAD MESSAGE!");
                        sipStack.getStackLogger().logError(message);
                    } 
                } 
                if (DroidSafeAndroidRuntime.control) throw ex;
            } 
            {
                sipMessage.addUnparsed(header);
            } 
        } 
        addTaint(ex.getTaint());
        addTaint(sipMessage.getTaint());
        addTaint(hdrClass.getTaint());
        addTaint(header.getTaint());
        addTaint(message.getTaint());
        
        
            
        
                
                        
                        
                        
                        
                        
        	
        		
            	
        	
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.202 -0400", hash_original_method = "5949601888B92CAB7F6BB9E6373E9083", hash_generated_method = "82CA494D920288D5F34C257C56DFF652")
    public void sendMessage(SIPMessage sipMessage) throws IOException {
        {
            boolean var3BF3C2EA8CA9182E664AB6FE30991BAF_210438621 = (sipStack.isLoggingEnabled() && this.sipStack.isLogStackTraceOnMessageSend());
            {
                {
                    boolean var8DA488598994EBF1C41434FD73AFB7C6_422108308 = (sipMessage instanceof SIPRequest &&
                    ((SIPRequest)sipMessage).getRequestLine() != null);
                    {
                        this.sipStack.getStackLogger().logStackTrace(StackLogger.TRACE_INFO);
                    } 
                    {
                        this.sipStack.getStackLogger().logStackTrace(StackLogger.TRACE_INFO);
                    } 
                } 
            } 
        } 
        long time = System.currentTimeMillis();
        try 
        {
            {
                MessageProcessor messageProcessor = sipStack
                    .getMessageProcessors()[0];
                {
                    {
                        boolean var37D638BEA91B51F1E4F5579247CF5778_500533439 = (messageProcessor.getIpAddress().equals(this.peerAddress)
                        && messageProcessor.getPort() == this.peerPort
                        && messageProcessor.getTransport().equals(
                                this.peerProtocol));
                        {
                            MessageChannel messageChannel = messageProcessor
                            .createMessageChannel(this.peerAddress,
                                    this.peerPort);
                            {
                                ((RawMessageChannel) messageChannel)
                                .processMessage(sipMessage);
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_1678129685 = (sipStack.isLoggingEnabled());
                                    sipStack.getStackLogger().logDebug("Self routing message");
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            byte[] msg = sipMessage.encodeAsBytes( this.getTransport() );
            sendMessage(msg, peerAddress, peerPort, peerProtocol,
                    sipMessage instanceof SIPRequest);
        } 
        catch (IOException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw ex;
        } 
        catch (Exception ex)
        {
            sipStack.getStackLogger().logError("An exception occured while sending message",ex);
            if (DroidSafeAndroidRuntime.control) throw new IOException(
                    "An exception occured while sending message");
        } 
        finally 
        {
            {
                boolean var161C41EFE3B277A3D1A2C98433E0C178_90307620 = (sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES) && !sipMessage.isNullRequest());
                logMessage(sipMessage, peerAddress, peerPort, time);
                {
                    boolean varA725024344C592B5004E395739F1C5C4_102210390 = (sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_DEBUG));
                    sipStack.getStackLogger().logDebug("Sent EMPTY Message");
                } 
            } 
        } 
        addTaint(sipMessage.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.203 -0400", hash_original_method = "E29573D85212414C15B5600ED44221C0", hash_generated_method = "671FB46BC7AFAA1F44E44EEEBCD3B960")
    protected void sendMessage(byte[] msg, InetAddress peerAddress,
            int peerPort, boolean reConnect) throws IOException {
        {
            boolean var3BF3C2EA8CA9182E664AB6FE30991BAF_81727636 = (sipStack.isLoggingEnabled() && this.sipStack.isLogStackTraceOnMessageSend());
            {
                this.sipStack.getStackLogger().logStackTrace(StackLogger.TRACE_INFO);
            } 
        } 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_188996134 = (sipStack.isLoggingEnabled());
                {
                    this.sipStack.getStackLogger().logDebug(getClass().getName()
                        + ":sendMessage: Dropping reply!");
                } 
            } 
            if (DroidSafeAndroidRuntime.control) throw new IOException("Receiver port not set ");
        } 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_646488671 = (sipStack.isLoggingEnabled());
                {
                    this.sipStack.getStackLogger().logDebug("sendMessage " + peerAddress.getHostAddress() + "/"
                        + peerPort + "\n" + "messageSize =  "  + msg.length + " message = " + new String(msg));
                    this.sipStack.getStackLogger().logDebug("*******************\n");
                } 
            } 
        } 
        DatagramPacket reply = new DatagramPacket(msg, msg.length, peerAddress,
                peerPort);
        try 
        {
            DatagramSocket sock;
            boolean created = false;
            {
                sock = ((UDPMessageProcessor) messageProcessor).sock;
            } 
            {
                sock = new DatagramSocket();
                created = true;
            } 
            sock.send(reply);
            sock.close();
        } 
        catch (IOException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw ex;
        } 
        catch (Exception ex)
        {
            InternalErrorHandler.handleException(ex);
        } 
        addTaint(msg[0]);
        addTaint(peerAddress.getTaint());
        addTaint(peerPort);
        addTaint(reConnect);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.204 -0400", hash_original_method = "38908DF8BAD797C5C3B9904DFAB1ABDF", hash_generated_method = "7127A2896922C4D722AC71E630D457B1")
    protected void sendMessage(byte[] msg, InetAddress peerAddress,
            int peerPort, String peerProtocol, boolean retry) throws IOException {
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_146016638 = (sipStack.isLoggingEnabled());
                {
                    this.sipStack.getStackLogger().logDebug(getClass().getName()
                        + ":sendMessage: Dropping reply!");
                } 
            } 
            if (DroidSafeAndroidRuntime.control) throw new IOException("Receiver port not set ");
        } 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_186950395 = (sipStack.isLoggingEnabled());
                {
                    this.sipStack.getStackLogger().logDebug( ":sendMessage " + peerAddress.getHostAddress() + "/"
                        + peerPort + "\n" + " messageSize = " + msg.length);
                } 
            } 
        } 
        {
            boolean varD90E5EEAD7F10D5D3C85319211A35E0C_930473372 = (peerProtocol.compareToIgnoreCase("UDP") == 0);
            {
                DatagramPacket reply = new DatagramPacket(msg, msg.length,
                    peerAddress, peerPort);
                try 
                {
                    DatagramSocket sock;
                    {
                        sock = ((UDPMessageProcessor) messageProcessor).sock;
                    } 
                    {
                        sock = sipStack.getNetworkLayer().createDatagramSocket();
                    } 
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1488118435 = (sipStack.isLoggingEnabled());
                        {
                            this.sipStack.getStackLogger().logDebug("sendMessage "
                            + peerAddress.getHostAddress() + "/" + peerPort
                            + "\n" + new String(msg));
                        } 
                    } 
                    sock.send(reply);
                    sock.close();
                } 
                catch (IOException ex)
                {
                    if (DroidSafeAndroidRuntime.control) throw ex;
                } 
                catch (Exception ex)
                {
                    InternalErrorHandler.handleException(ex);
                } 
            } 
            {
                Socket outputSocket = sipStack.ioHandler.sendBytes(
                    this.messageProcessor.getIpAddress(), peerAddress,
                    peerPort, "tcp", msg, retry,this);
                OutputStream myOutputStream = outputSocket.getOutputStream();
                myOutputStream.write(msg, 0, msg.length);
                myOutputStream.flush();
            } 
        } 
        addTaint(msg[0]);
        addTaint(peerAddress.getTaint());
        addTaint(peerPort);
        addTaint(peerProtocol.getTaint());
        addTaint(retry);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.204 -0400", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "D15A757F2439A67057432D9923B0CA36")
    public SIPTransactionStack getSIPStack() {
        SIPTransactionStack varB4EAC82CA7396A68D541C85D26508E83_1346939470 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1346939470 = sipStack;
        varB4EAC82CA7396A68D541C85D26508E83_1346939470.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1346939470;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.205 -0400", hash_original_method = "B7A5D479C43293000A9EAFE6F93DF6D0", hash_generated_method = "BBE1B1FEDB80D2EBD8ADBE466D21C3E8")
    public String getTransport() {
        String varB4EAC82CA7396A68D541C85D26508E83_1595420409 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1595420409 = SIPConstants.UDP;
        varB4EAC82CA7396A68D541C85D26508E83_1595420409.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1595420409;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.205 -0400", hash_original_method = "EA072AA1AE1B409D48E6BC6990EBDEC5", hash_generated_method = "04A96D73F9A1BFF20BE766A150D62C55")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_2069087659 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2069087659 = messageProcessor.getIpAddress().getHostAddress();
        varB4EAC82CA7396A68D541C85D26508E83_2069087659.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2069087659;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.206 -0400", hash_original_method = "891FD85C4A46ECEDCCE8E5933BDC3ADD", hash_generated_method = "B0A5EA7DA76612802DA7364DA1D50F5D")
    public int getPort() {
        int var08018CA200139FEC794EAAFB8EB517CE_598916528 = (((UDPMessageProcessor) messageProcessor).getPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_181554240 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_181554240;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.206 -0400", hash_original_method = "86CAA293F63DFC3CC87A4ACD6BC27DDA", hash_generated_method = "A680197A96DC95BFE6375CAA2F5DB0A9")
    public String getPeerName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1746449449 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1746449449 = peerAddress.getHostName();
        varB4EAC82CA7396A68D541C85D26508E83_1746449449.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1746449449;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.206 -0400", hash_original_method = "A07C7EAAB254DF7A2A64ECDA7F650470", hash_generated_method = "0F2E5D6F8F4109C6278307465D7268DD")
    public String getPeerAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_184008532 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_184008532 = peerAddress.getHostAddress();
        varB4EAC82CA7396A68D541C85D26508E83_184008532.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_184008532;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.207 -0400", hash_original_method = "1F29EC3BC94C3E0863F530FCD37A61F3", hash_generated_method = "646FE009F96DC048404C87E93C7C5F06")
    protected InetAddress getPeerInetAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1065294393 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1065294393 = peerAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1065294393.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1065294393;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.207 -0400", hash_original_method = "3F01B3F60F79E6CB5C3DF3B66FDD88DE", hash_generated_method = "96F3C9970020FA5711A805927D60290B")
    public boolean equals(Object other) {
        boolean retval;
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_864942298 = (!this.getClass().equals(other.getClass()));
            {
                retval = false;
            } 
            {
                UDPMessageChannel that = (UDPMessageChannel) other;
                retval = this.getKey().equals(that.getKey());
            } 
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_35990522 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_35990522;
        
        
            
        
        
            
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.208 -0400", hash_original_method = "8A0A97143B2090B701AABAA2A97E73FB", hash_generated_method = "94BF2ABF88F9139CFE4CC955CFF99137")
    public String getKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_1406644245 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1406644245 = getKey(peerAddress, peerPort, "UDP");
        varB4EAC82CA7396A68D541C85D26508E83_1406644245.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1406644245;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.208 -0400", hash_original_method = "66F44212C04D4B032E5D57BC9126F4FF", hash_generated_method = "D91722B9838E20F1407D14A322903798")
    public int getPeerPacketSourcePort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_529275511 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_529275511;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.208 -0400", hash_original_method = "DC065FB3DE06142DBC04F100FD01BCF3", hash_generated_method = "27B8326DF1C71F9E80B08EB3E7EF9D84")
    public InetAddress getPeerPacketSourceAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1210079930 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1210079930 = peerPacketSourceAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1210079930.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1210079930;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.209 -0400", hash_original_method = "B7C8CBECE48532207EA3107C3752BABB", hash_generated_method = "B281B307C37ECAF7EDFF2442E8AC2A00")
    public String getViaHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_1549251639 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1549251639 = this.myAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1549251639.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1549251639;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.209 -0400", hash_original_method = "F69C682C43E3A7CF8FCB14E212CB7049", hash_generated_method = "D753CAD28977A0B2B0776349CFA868AF")
    public int getViaPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1803576829 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1803576829;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.209 -0400", hash_original_method = "457243F9D7A1AB9FD34866D85709C85D", hash_generated_method = "D7A5DC0B6DC404AC8B6CDC3CD8934526")
    public boolean isReliable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1359349484 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1359349484;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.209 -0400", hash_original_method = "51201694E0EE76265BF39848EF10BE9C", hash_generated_method = "C5834A0C348D6890EEA1FD2DB0BE9B80")
    public boolean isSecure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1980457439 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1980457439;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.209 -0400", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "F2C30B6C2ADC2341A30AA048E4BBCF05")
    public int getPeerPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1740695797 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1740695797;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.210 -0400", hash_original_method = "DB79607DA3ACB5FA2D24428DF2713F98", hash_generated_method = "FAB39294323B309808FA1E9AE4F7F768")
    public String getPeerProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_10869145 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_10869145 = this.peerProtocol;
        varB4EAC82CA7396A68D541C85D26508E83_10869145.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_10869145;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.210 -0400", hash_original_method = "B96EF178F3ED1A0DFACDA94649407E5C", hash_generated_method = "1CF5A5DB4E3FE1187B00A561217E4793")
    public void close() {
        
    }

    
    class PingBackTimerTask extends TimerTask {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.210 -0400", hash_original_field = "9D0DE3EE8DA929F164DA3D6942A26C0E", hash_generated_field = "902291576A6EA4536D6C9669E1B1BFD7")

        String ipAddress;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.210 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "5A948EF636511EF149269A68FE278AED")

        int port;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.210 -0400", hash_original_method = "041AEFB77EA8D7413831FA09D8E7E5F2", hash_generated_method = "AF34990A25633808182801353E3CAE7C")
        public  PingBackTimerTask(String ipAddress, int port) {
            this.ipAddress = ipAddress;
            this.port = port;
            pingBackRecord.put(ipAddress + ":" + port, this);
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.211 -0400", hash_original_method = "6BA8F9798D5715ABDAD288256921D45A", hash_generated_method = "A12DB3F698D6F6B742E8AA41F07B747A")
        @Override
        public void run() {
            pingBackRecord.remove(ipAddress + ":" + port);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.211 -0400", hash_original_method = "E214E7BC5755C758A91BCF58AAE3832E", hash_generated_method = "3D3AC354238C08FCD6D8B21EEC5E37A2")
        @Override
        public int hashCode() {
            int varFAFA3497566668EE5F9BFBDEC9425D0B_1066613968 = ((ipAddress + ":" + port).hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_311452653 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_311452653;
            
            
        }

        
    }


    
}

