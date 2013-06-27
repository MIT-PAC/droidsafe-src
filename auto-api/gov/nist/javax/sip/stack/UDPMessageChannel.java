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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.431 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "3233C5012C49C796F9D6BBC8E02EAB41")

    protected SIPTransactionStack sipStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.431 -0400", hash_original_field = "8C35693B192604DA4AB63AD19D48096F", hash_generated_field = "0A43681EE1A6E215BE82E39AC59DFE7C")

    protected StringMsgParser myParser;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.431 -0400", hash_original_field = "D7FA5E7DC9BACC5016B81E35D44D1C5F", hash_generated_field = "DB2440387A41D5016778DA700632E003")

    private InetAddress peerAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.431 -0400", hash_original_field = "AA48C74491DE12FAB31F14F04DE0F567", hash_generated_field = "DEE18A414D72F7D580E73EF519B5B75F")

    private String myAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.431 -0400", hash_original_field = "E2843BEFA12DEA2BD46F0D29DAA8CB35", hash_generated_field = "917EBAB90EE3EF0904EF1CC7129F7C3B")

    private int peerPacketSourcePort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.431 -0400", hash_original_field = "1906DDE6FBF1A1A564E69A91EBCF4043", hash_generated_field = "31AFBD6F92700654B3E6CD25C4BAE79B")

    private InetAddress peerPacketSourceAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.431 -0400", hash_original_field = "BBD5741C4F9994864582D25DD194C4DE", hash_generated_field = "FE74A5BA5CFBB5B6DC2B68FEFA76ECFC")

    private int peerPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.431 -0400", hash_original_field = "EDB6E8FD971C3E6879E1A00995BCB702", hash_generated_field = "EB665B7537D07145A6FCAD2DB460EADC")

    private String peerProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.431 -0400", hash_original_field = "AB99FC537949F4680FB25A11A38B0042", hash_generated_field = "AD61806C610E09EDA888D5EC477B22F2")

    protected int myPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.431 -0400", hash_original_field = "C1C12C1266B0C0AC2B9F460C87F4F641", hash_generated_field = "5DCE0469450ABB74FDB5A37D9DFDF23A")

    private DatagramPacket incomingPacket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.431 -0400", hash_original_field = "52E9EDC753D35EB688ED2EC5FA2A70C4", hash_generated_field = "FDC149166FA9FE14388FB5695DD3C00D")

    private long receptionTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.431 -0400", hash_original_field = "19007373CE3841015C166CC983644A31", hash_generated_field = "DE4903FFD06AF3966ED05EEB79D4D38C")

    private Hashtable<String,PingBackTimerTask> pingBackRecord = new Hashtable<String,PingBackTimerTask>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.436 -0400", hash_original_method = "03A64681434F0E8B0C9121AC8F1C5237", hash_generated_method = "F4678F6815B5D9C8069EEBE0118DBC8E")
    protected  UDPMessageChannel(SIPTransactionStack stack,
            UDPMessageProcessor messageProcessor) {
        super.messageProcessor = messageProcessor;
        this.sipStack = stack;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.450 -0400", hash_original_method = "1756885BA9DE2BFD3C0F236D276D29E7", hash_generated_method = "A8F9DAD2506D82E9CA43A085ABAB4A4A")
    protected  UDPMessageChannel(SIPTransactionStack stack,
            UDPMessageProcessor messageProcessor, DatagramPacket packet) {
        this.incomingPacket = packet;
        super.messageProcessor = messageProcessor;
        this.sipStack = stack;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.451 -0400", hash_original_method = "776DD93072EC88FB0665477FC0515605", hash_generated_method = "5DF6B55B93F4A25D6159C967AF784696")
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
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_2071918334 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.452 -0400", hash_original_method = "E6EA1046257028C8ED28AF4C13B7A731", hash_generated_method = "DDE6193767C7BE575A5FEEC4E08F6C7B")
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
                        boolean varAD73BCE40D73F49090BF24139EA25CB8_1335535402 = (((UDPMessageProcessor) messageProcessor).messageQueue
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.458 -0400", hash_original_method = "2D23A147968127857F47AE9C2F0B0301", hash_generated_method = "EA8B2AD71ADC7B1F1D9210DA2E6EF4E4")
    private void processIncomingDataPacket(DatagramPacket packet) throws Exception {
        this.peerAddress = packet.getAddress();
        int packetLength;
        packetLength = packet.getLength();
        byte[] bytes;
        bytes = packet.getData();
        byte[] msgBytes;
        msgBytes = new byte[packetLength];
        System.arraycopy(bytes, 0, msgBytes, 0, packetLength);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_352036426 = (sipStack.isLoggingEnabled());
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
                boolean varCD7A6467843458627CC99D2CD95A9CA6_221714196 = (sipStack.isLoggingEnabled());
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
                boolean var641C9D2BCF73834F157CB50DF975B192_9915852 = (!msgString.startsWith("SIP/") && !msgString.startsWith("ACK "));
                {
                    String badReqRes;
                    badReqRes = createBadReqRes(msgString, ex);
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_2107469122 = (sipStack.isLoggingEnabled());
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
                            boolean var2AB968A8303910EE00F810B6DE3410F9_1988723499 = (sipStack.isLoggingEnabled());
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
                boolean varCD7A6467843458627CC99D2CD95A9CA6_230795766 = (sipStack.isLoggingEnabled());
                {
                    this.sipStack.getStackLogger().logDebug("Rejecting message !  + Null message parsed.");
                } //End block
            } //End collapsed parenthetic
            {
                boolean var9004E0463DC06B1DD21A25050AF4C311_2006364587 = (pingBackRecord.get(packet.getAddress().getHostAddress() + ":" + packet.getPort()) == null);
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
            boolean var59CC7428458ADFC3199C90345ABEB8AF_786470705 = (sipMessage.getFrom() == null || sipMessage.getTo() == null
                || sipMessage.getCallId() == null
                || sipMessage.getCSeq() == null
                || sipMessage.getViaHeaders() == null);
            {
                String badmsg;
                badmsg = new String(msgBytes);
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_119371749 = (sipStack.isLoggingEnabled());
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
                    boolean var2EC34FA9788EADA768699B2545557487_605592783 = (hasRPort
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.486 -0400", hash_original_method = "DCEA2882E2241B5A52F15EAA80B8F270", hash_generated_method = "38E91307F543A1FDEFA85C6FB5AF11DC")
    public void processMessage(SIPMessage sipMessage) {
        {
            SIPRequest sipRequest;
            sipRequest = (SIPRequest) sipMessage;
            {
                boolean varB20158C23C001B703CFD19B38FE62BAB_1879940455 = (sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES));
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
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_158646247 = (sipStack.isLoggingEnabled());
                    {
                        this.sipStack.getStackLogger()
                            .logWarning("Null request interface returned -- dropping request");
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1848975452 = (sipStack.isLoggingEnabled());
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
                        boolean varDFD8B605D678E12460F98516E8CB0D44_1865969209 = (!sipServerTx.passToListener());
                        {
                            ((SIPTransaction) sipServerRequest).releaseSem();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_324423879 = (sipStack.isLoggingEnabled());
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
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1295197082 = (sipStack.isLoggingEnabled());
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
                        boolean varE75FAA60313661E30299B4B6DCAFA965_146039143 = (sipServerResponse instanceof SIPClientTransaction
                            && !((SIPClientTransaction) sipServerResponse)
                                    .checkFromTag(sipResponse));
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_2095715565 = (sipStack.isLoggingEnabled());
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
                        boolean varE830882F52F0DDC064CFB33E0C94EB7E_2010256302 = (sipServerResponse instanceof SIPTransaction
                            && !((SIPTransaction) sipServerResponse)
                                    .passToListener());
                        ((SIPTransaction) sipServerResponse).releaseSem();
                    } //End collapsed parenthetic
                } //End block
            } //End block
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_588765244 = (sipStack.isLoggingEnabled());
                    {
                        this.sipStack.getStackLogger().logDebug("null sipServerResponse!");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(sipMessage.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.499 -0400", hash_original_method = "148F3D833D327E61A5116C1FE99BCAC0", hash_generated_method = "F8A89729F49A02C08322E5CBF7433EFD")
    public void handleException(ParseException ex, SIPMessage sipMessage,
            Class hdrClass, String header, String message) throws ParseException {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1742555929 = (sipStack.isLoggingEnabled());
            this.sipStack.getStackLogger().logException(ex);
        } //End collapsed parenthetic
        {
            boolean varA507267BF4B92BB4BF284B01D1D5F764_1874278956 = ((hdrClass != null)
                && (hdrClass.equals(From.class) || hdrClass.equals(To.class)
                        || hdrClass.equals(CSeq.class)
                        || hdrClass.equals(Via.class)
                        || hdrClass.equals(CallID.class)
                        || hdrClass.equals(RequestLine.class) || hdrClass
                        .equals(StatusLine.class)));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_789852091 = (sipStack.isLoggingEnabled());
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
        addTaint(ex.getTaint());
        addTaint(sipMessage.getTaint());
        addTaint(hdrClass.getTaint());
        addTaint(header.getTaint());
        addTaint(message.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.725 -0400", hash_original_method = "5949601888B92CAB7F6BB9E6373E9083", hash_generated_method = "DCA8D01E5BAAD65DC174F1089EBEB07F")
    public void sendMessage(SIPMessage sipMessage) throws IOException {
        {
            boolean var3BF3C2EA8CA9182E664AB6FE30991BAF_1084385784 = (sipStack.isLoggingEnabled() && this.sipStack.isLogStackTraceOnMessageSend());
            {
                {
                    boolean var8DA488598994EBF1C41434FD73AFB7C6_2074636024 = (sipMessage instanceof SIPRequest &&
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
                        boolean var37D638BEA91B51F1E4F5579247CF5778_336726396 = (messageProcessor.getIpAddress().equals(this.peerAddress)
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
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_2061462914 = (sipStack.isLoggingEnabled());
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
                boolean var161C41EFE3B277A3D1A2C98433E0C178_803200928 = (sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES) && !sipMessage.isNullRequest());
                logMessage(sipMessage, peerAddress, peerPort, time);
                {
                    boolean varA725024344C592B5004E395739F1C5C4_87528901 = (sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_DEBUG));
                    sipStack.getStackLogger().logDebug("Sent EMPTY Message");
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        addTaint(sipMessage.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.727 -0400", hash_original_method = "E29573D85212414C15B5600ED44221C0", hash_generated_method = "6F7A4048471D5993239552C951188D3A")
    protected void sendMessage(byte[] msg, InetAddress peerAddress,
            int peerPort, boolean reConnect) throws IOException {
        {
            boolean var3BF3C2EA8CA9182E664AB6FE30991BAF_1364773818 = (sipStack.isLoggingEnabled() && this.sipStack.isLogStackTraceOnMessageSend());
            {
                this.sipStack.getStackLogger().logStackTrace(StackLogger.TRACE_INFO);
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1653547226 = (sipStack.isLoggingEnabled());
                {
                    this.sipStack.getStackLogger().logDebug(getClass().getName()
                        + ":sendMessage: Dropping reply!");
                } //End block
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) throw new IOException("Receiver port not set ");
        } //End block
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_790619600 = (sipStack.isLoggingEnabled());
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
        addTaint(msg[0]);
        addTaint(peerAddress.getTaint());
        addTaint(peerPort);
        addTaint(reConnect);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.746 -0400", hash_original_method = "38908DF8BAD797C5C3B9904DFAB1ABDF", hash_generated_method = "376F5C10F892543975E8BC831299766A")
    protected void sendMessage(byte[] msg, InetAddress peerAddress,
            int peerPort, String peerProtocol, boolean retry) throws IOException {
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1225224905 = (sipStack.isLoggingEnabled());
                {
                    this.sipStack.getStackLogger().logDebug(getClass().getName()
                        + ":sendMessage: Dropping reply!");
                } //End block
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) throw new IOException("Receiver port not set ");
        } //End block
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_844280198 = (sipStack.isLoggingEnabled());
                {
                    this.sipStack.getStackLogger().logDebug( ":sendMessage " + peerAddress.getHostAddress() + "/"
                        + peerPort + "\n" + " messageSize = " + msg.length);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean varD90E5EEAD7F10D5D3C85319211A35E0C_2117038678 = (peerProtocol.compareToIgnoreCase("UDP") == 0);
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
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1455190432 = (sipStack.isLoggingEnabled());
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
        addTaint(msg[0]);
        addTaint(peerAddress.getTaint());
        addTaint(peerPort);
        addTaint(peerProtocol.getTaint());
        addTaint(retry);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.747 -0400", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "051C2FAF9AEFD5340CF8E1FD69C32E64")
    public SIPTransactionStack getSIPStack() {
        SIPTransactionStack varB4EAC82CA7396A68D541C85D26508E83_766128622 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_766128622 = sipStack;
        varB4EAC82CA7396A68D541C85D26508E83_766128622.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_766128622;
        // ---------- Original Method ----------
        //return sipStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.754 -0400", hash_original_method = "B7A5D479C43293000A9EAFE6F93DF6D0", hash_generated_method = "481ABDE724AA10A0573DDF6B6FD8EA79")
    public String getTransport() {
        String varB4EAC82CA7396A68D541C85D26508E83_821310119 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_821310119 = SIPConstants.UDP;
        varB4EAC82CA7396A68D541C85D26508E83_821310119.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_821310119;
        // ---------- Original Method ----------
        //return SIPConstants.UDP;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.755 -0400", hash_original_method = "EA072AA1AE1B409D48E6BC6990EBDEC5", hash_generated_method = "D7F4D978CC3AEC2D00333D6A383F706D")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_1639616872 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1639616872 = messageProcessor.getIpAddress().getHostAddress();
        varB4EAC82CA7396A68D541C85D26508E83_1639616872.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1639616872;
        // ---------- Original Method ----------
        //return messageProcessor.getIpAddress().getHostAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.756 -0400", hash_original_method = "891FD85C4A46ECEDCCE8E5933BDC3ADD", hash_generated_method = "A53A219C8FE29BB9001746E3D648D75F")
    public int getPort() {
        int var08018CA200139FEC794EAAFB8EB517CE_1307825113 = (((UDPMessageProcessor) messageProcessor).getPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2050663804 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2050663804;
        // ---------- Original Method ----------
        //return ((UDPMessageProcessor) messageProcessor).getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.756 -0400", hash_original_method = "86CAA293F63DFC3CC87A4ACD6BC27DDA", hash_generated_method = "7FD58C0ED8A4D0B68B6CD8F3DB802C1E")
    public String getPeerName() {
        String varB4EAC82CA7396A68D541C85D26508E83_424214325 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_424214325 = peerAddress.getHostName();
        varB4EAC82CA7396A68D541C85D26508E83_424214325.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_424214325;
        // ---------- Original Method ----------
        //return peerAddress.getHostName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.757 -0400", hash_original_method = "A07C7EAAB254DF7A2A64ECDA7F650470", hash_generated_method = "0B7D2D837E55EBA2291961FB2671B0CF")
    public String getPeerAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_844231979 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_844231979 = peerAddress.getHostAddress();
        varB4EAC82CA7396A68D541C85D26508E83_844231979.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_844231979;
        // ---------- Original Method ----------
        //return peerAddress.getHostAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.757 -0400", hash_original_method = "1F29EC3BC94C3E0863F530FCD37A61F3", hash_generated_method = "34E9225A8DE093A1AF85FCB1EC5C785E")
    protected InetAddress getPeerInetAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_2131420430 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2131420430 = peerAddress;
        varB4EAC82CA7396A68D541C85D26508E83_2131420430.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2131420430;
        // ---------- Original Method ----------
        //return peerAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.758 -0400", hash_original_method = "3F01B3F60F79E6CB5C3DF3B66FDD88DE", hash_generated_method = "F25D5A7ACC08A33391FE76147AC7311D")
    public boolean equals(Object other) {
        boolean retval;
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_610737363 = (!this.getClass().equals(other.getClass()));
            {
                retval = false;
            } //End block
            {
                UDPMessageChannel that;
                that = (UDPMessageChannel) other;
                retval = this.getKey().equals(that.getKey());
            } //End block
        } //End collapsed parenthetic
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_268477422 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_268477422;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.777 -0400", hash_original_method = "8A0A97143B2090B701AABAA2A97E73FB", hash_generated_method = "14C6DBF41A19D7F3A9E1AA0574DF5DC4")
    public String getKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_990078992 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_990078992 = getKey(peerAddress, peerPort, "UDP");
        varB4EAC82CA7396A68D541C85D26508E83_990078992.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_990078992;
        // ---------- Original Method ----------
        //return getKey(peerAddress, peerPort, "UDP");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.778 -0400", hash_original_method = "66F44212C04D4B032E5D57BC9126F4FF", hash_generated_method = "4BC1EDD8B0670A34F9C8BD026C663A03")
    public int getPeerPacketSourcePort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_446364466 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_446364466;
        // ---------- Original Method ----------
        //return peerPacketSourcePort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.779 -0400", hash_original_method = "DC065FB3DE06142DBC04F100FD01BCF3", hash_generated_method = "1BDAD4C6C49F372D013E5F02A5A7A8EC")
    public InetAddress getPeerPacketSourceAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1380741230 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1380741230 = peerPacketSourceAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1380741230.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1380741230;
        // ---------- Original Method ----------
        //return peerPacketSourceAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.779 -0400", hash_original_method = "B7C8CBECE48532207EA3107C3752BABB", hash_generated_method = "6CE193BFAD99CC8B8F46B9639F9E03D3")
    public String getViaHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_594476294 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_594476294 = this.myAddress;
        varB4EAC82CA7396A68D541C85D26508E83_594476294.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_594476294;
        // ---------- Original Method ----------
        //return this.myAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.780 -0400", hash_original_method = "F69C682C43E3A7CF8FCB14E212CB7049", hash_generated_method = "71D00C411507ED152E89E3193682576B")
    public int getViaPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_842391506 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_842391506;
        // ---------- Original Method ----------
        //return this.myPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.780 -0400", hash_original_method = "457243F9D7A1AB9FD34866D85709C85D", hash_generated_method = "898BA9C7162F42C362D590AA3D6B584B")
    public boolean isReliable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_705429775 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_705429775;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.780 -0400", hash_original_method = "51201694E0EE76265BF39848EF10BE9C", hash_generated_method = "08D2CB0A5D4B2BF1BF7FB92140824102")
    public boolean isSecure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_383000235 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_383000235;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.781 -0400", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "62C627C292F6F05ED25E0E24C087B108")
    public int getPeerPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_701340695 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_701340695;
        // ---------- Original Method ----------
        //return peerPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.796 -0400", hash_original_method = "DB79607DA3ACB5FA2D24428DF2713F98", hash_generated_method = "60CDCF58A4D81F35DE364168A1B09E63")
    public String getPeerProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_241355797 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_241355797 = this.peerProtocol;
        varB4EAC82CA7396A68D541C85D26508E83_241355797.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_241355797;
        // ---------- Original Method ----------
        //return this.peerProtocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.797 -0400", hash_original_method = "B96EF178F3ED1A0DFACDA94649407E5C", hash_generated_method = "1CF5A5DB4E3FE1187B00A561217E4793")
    public void close() {
        // ---------- Original Method ----------
    }

    
    class PingBackTimerTask extends TimerTask {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.797 -0400", hash_original_field = "9D0DE3EE8DA929F164DA3D6942A26C0E", hash_generated_field = "902291576A6EA4536D6C9669E1B1BFD7")

        String ipAddress;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.797 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "5A948EF636511EF149269A68FE278AED")

        int port;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.798 -0400", hash_original_method = "041AEFB77EA8D7413831FA09D8E7E5F2", hash_generated_method = "AF34990A25633808182801353E3CAE7C")
        public  PingBackTimerTask(String ipAddress, int port) {
            this.ipAddress = ipAddress;
            this.port = port;
            pingBackRecord.put(ipAddress + ":" + port, this);
            // ---------- Original Method ----------
            //this.ipAddress = ipAddress;
            //this.port = port;
            //pingBackRecord.put(ipAddress + ":" + port, this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.801 -0400", hash_original_method = "6BA8F9798D5715ABDAD288256921D45A", hash_generated_method = "A12DB3F698D6F6B742E8AA41F07B747A")
        @Override
        public void run() {
            pingBackRecord.remove(ipAddress + ":" + port);
            // ---------- Original Method ----------
            //pingBackRecord.remove(ipAddress + ":" + port);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.802 -0400", hash_original_method = "E214E7BC5755C758A91BCF58AAE3832E", hash_generated_method = "A80B61D163BB962B7FA2261BB8776677")
        @Override
        public int hashCode() {
            int varFAFA3497566668EE5F9BFBDEC9425D0B_1953291519 = ((ipAddress + ":" + port).hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_182459272 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_182459272;
            // ---------- Original Method ----------
            //return (ipAddress + ":" + port).hashCode();
        }

        
    }


    
}

