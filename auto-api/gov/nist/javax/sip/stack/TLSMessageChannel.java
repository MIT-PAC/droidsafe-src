package gov.nist.javax.sip.stack;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.942 -0400", hash_original_field = "52CA6755165FFD50983D257A0F1E043B", hash_generated_field = "F3B00F7E70704D963CC4197CD003FB94")

    private Socket mySock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.942 -0400", hash_original_field = "8C35693B192604DA4AB63AD19D48096F", hash_generated_field = "152EC54D2111EF26096DF65FC2003536")

    private PipelinedMsgParser myParser;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.942 -0400", hash_original_field = "0EDD5FF84F2278A8C37689A050537727", hash_generated_field = "E9FA88EF5BFDD4D9156AADE5BC087A4C")

    private InputStream myClientInputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.942 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "2E3018221E30480EB0F957E72002C7D8")

    private String key;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.942 -0400", hash_original_field = "1AC7B394035E343F285A6A4ED1096126", hash_generated_field = "F8E96F7362B3E7CD3DE3A2778DC87A58")

    protected boolean isCached;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.942 -0400", hash_original_field = "39044C41F340C67BFA15E91CC6E98E7D", hash_generated_field = "911E18F9BE05473489F5F21C894DF579")

    protected boolean isRunning;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.942 -0400", hash_original_field = "9842605C72E3BC73DA5398CE4B5EB840", hash_generated_field = "8890F3B68DD2F65EEDEBEEF6284B3EE1")

    private Thread mythread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.942 -0400", hash_original_field = "AA48C74491DE12FAB31F14F04DE0F567", hash_generated_field = "DEE18A414D72F7D580E73EF519B5B75F")

    private String myAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.942 -0400", hash_original_field = "AB99FC537949F4680FB25A11A38B0042", hash_generated_field = "1FBEE69CBCB5E71F900C5C964DA7ADBD")

    private int myPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.942 -0400", hash_original_field = "D7FA5E7DC9BACC5016B81E35D44D1C5F", hash_generated_field = "DB2440387A41D5016778DA700632E003")

    private InetAddress peerAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.942 -0400", hash_original_field = "BBD5741C4F9994864582D25DD194C4DE", hash_generated_field = "FE74A5BA5CFBB5B6DC2B68FEFA76ECFC")

    private int peerPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.942 -0400", hash_original_field = "EDB6E8FD971C3E6879E1A00995BCB702", hash_generated_field = "EB665B7537D07145A6FCAD2DB460EADC")

    private String peerProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.942 -0400", hash_original_field = "8A2A02C2F7B9C43A9E25E5C24EA3F0F6", hash_generated_field = "5A3C22CB6AA628C04F88A4A28D40ED17")

    private TLSMessageProcessor tlsMessageProcessor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.942 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "ABE627693A01BDDC6597F9AB66B3018E")

    private SIPTransactionStack sipStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.942 -0400", hash_original_field = "7B8AE7FFC44A9C7B49E7C7EA6A6D3757", hash_generated_field = "12E7910E7EDE55EAF4A3D89EE23A6BC7")

    private HandshakeCompletedListener handshakeCompletedListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.944 -0400", hash_original_method = "358EB7732CC002B4969C64CA3912C6FF", hash_generated_method = "9AC159C7048ACA975309D78A2C17BFB7")
    protected  TLSMessageChannel(Socket sock, SIPTransactionStack sipStack,
            TLSMessageProcessor msgProcessor) throws IOException {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_904220999 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("creating new TLSMessageChannel (incoming)");
                sipStack.getStackLogger().logStackTrace();
            } 
        } 
        mySock = (SSLSocket) sock;
        {
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
        this.sipStack = sipStack;
        this.tlsMessageProcessor = msgProcessor;
        this.myPort = this.tlsMessageProcessor.getPort();
        this.peerPort = mySock.getPort();
        super.messageProcessor = msgProcessor;
        mythread.start();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.944 -0400", hash_original_method = "36AC589476275C6F111789614D727487", hash_generated_method = "E2B6D2457720707B45E663BAAE1F52FD")
    protected  TLSMessageChannel(InetAddress inetAddr, int port, SIPTransactionStack sipStack,
            TLSMessageProcessor messageProcessor) throws IOException {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1018064298 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("creating new TLSMessageChannel (outgoing)");
                sipStack.getStackLogger().logStackTrace();
            } 
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.945 -0400", hash_original_method = "16D0E6CF226A4618D75D1B422CC8FCDF", hash_generated_method = "CD0E13DBB915E9A420D6E7367F334DEB")
    public boolean isReliable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_538126117 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_538126117;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.946 -0400", hash_original_method = "9757D034E975DAF9D22BACDE50FF4335", hash_generated_method = "1F7595CA480023418F3C8E6FF595D04F")
    public void close() {
        try 
        {
            mySock.close();
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1359803655 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Closing message Channel " + this);
            } 
        } 
        catch (IOException ex)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_5360699 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Error closing socket " + ex);
            } 
        } 
        
        
            
                
            
                
        
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.947 -0400", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "08D61EB3B25A9F188E4EE3E3803DCBB8")
    public SIPTransactionStack getSIPStack() {
        SIPTransactionStack varB4EAC82CA7396A68D541C85D26508E83_2120091892 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2120091892 = sipStack;
        varB4EAC82CA7396A68D541C85D26508E83_2120091892.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2120091892;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.948 -0400", hash_original_method = "00B4B3FBB10028B216605159EFB81D52", hash_generated_method = "5910AC690AD7AF0ED47D2343B072E5E6")
    public String getTransport() {
        String varB4EAC82CA7396A68D541C85D26508E83_1225445936 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1225445936 = "tls";
        varB4EAC82CA7396A68D541C85D26508E83_1225445936.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1225445936;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.948 -0400", hash_original_method = "59CC467573DB54CDCEF540AE63F43735", hash_generated_method = "5F21AF0D533138FC5EB58E63A0B81AE5")
    public String getPeerAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_1585184325 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_994062192 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1585184325 = peerAddress.getHostAddress();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_994062192 = getHost();
        String varA7E53CE21691AB073D9660D615818899_901475672; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_901475672 = varB4EAC82CA7396A68D541C85D26508E83_1585184325;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_901475672 = varB4EAC82CA7396A68D541C85D26508E83_994062192;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_901475672.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_901475672;
        
        
            
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.949 -0400", hash_original_method = "1F29EC3BC94C3E0863F530FCD37A61F3", hash_generated_method = "450AABC71D6ACEF598179D5FF848F9BE")
    protected InetAddress getPeerInetAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1479548503 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1479548503 = peerAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1479548503.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1479548503;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.949 -0400", hash_original_method = "DB79607DA3ACB5FA2D24428DF2713F98", hash_generated_method = "E18C82EB5BEDC917701FD2A4C005D886")
    public String getPeerProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_1507891770 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1507891770 = this.peerProtocol;
        varB4EAC82CA7396A68D541C85D26508E83_1507891770.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1507891770;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.950 -0400", hash_original_method = "769119032395AFB8B9E88BC54405133A", hash_generated_method = "F982501FE8B8E71257D1072B37B0DC47")
    private void sendMessage(byte[] msg, boolean retry) throws IOException {
        Socket sock = this.sipStack.ioHandler.sendBytes(
                this.getMessageProcessor().getIpAddress(), this.peerAddress, this.peerPort,
                this.peerProtocol, msg, retry,this);
        {
            try 
            {
                mySock.close();
            } 
            catch (IOException ex)
            { }
            mySock = sock;
            this.myClientInputStream = mySock.getInputStream();
            Thread thread = new Thread(this);
            thread.setDaemon(true);
            thread.setName("TLSMessageChannelThread");
            thread.start();
        } 
        addTaint(msg[0]);
        addTaint(retry);
        
        
                
                
        
            
                
                    
            
            
            
            
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.950 -0400", hash_original_method = "99193C77E68A5ABE715A7A9AC8040C34", hash_generated_method = "8EBF9B8634B34DEB2067FAE6A3415DB9")
    public void sendMessage(SIPMessage sipMessage) throws IOException {
        byte[] msg = sipMessage.encodeAsBytes(this.getTransport());
        long time = System.currentTimeMillis();
        this.sendMessage(msg, sipMessage instanceof SIPRequest);
        {
            boolean var53DEB6CBCADF9510253D9D22204998C3_1501784088 = (this.sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES));
            logMessage(sipMessage, peerAddress, peerPort, time);
        } 
        addTaint(sipMessage.getTaint());
        
        
        
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.950 -0400", hash_original_method = "C6D6B3579ACFAA2466286D67BFFE3003", hash_generated_method = "2ED404DB1051C9D97FB907320C6763E9")
    public void sendMessage(byte message[], InetAddress receiverAddress, int receiverPort,
            boolean retry) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Null argument");
        Socket sock = this.sipStack.ioHandler.sendBytes(this.messageProcessor.getIpAddress(),
                receiverAddress, receiverPort, "TLS", message, retry, this);
        {
            try 
            {
                mySock.close();
            } 
            catch (IOException ex)
            { }
            mySock = sock;
            this.myClientInputStream = mySock.getInputStream();
            Thread mythread = new Thread(this);
            mythread.setDaemon(true);
            mythread.setName("TLSMessageChannelThread");
            mythread.start();
        } 
        addTaint(message[0]);
        addTaint(receiverAddress.getTaint());
        addTaint(receiverPort);
        addTaint(retry);
        
        
            
        
                
        
            
                
                    
            
            
            
            
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.951 -0400", hash_original_method = "F10EA794C47048E710B5CED57C611CE1", hash_generated_method = "0DA8EE36CFD340655F9DCBBEBF020A9F")
    public void handleException(ParseException ex, SIPMessage sipMessage, Class hdrClass,
            String header, String message) throws ParseException {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1643925065 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logException(ex);
        } 
        {
            boolean var4AF4DF15E5A9AA725DAB2E0A6B114A9C_456204232 = ((hdrClass != null)
                && (hdrClass.equals(From.class) || hdrClass.equals(To.class)
                        || hdrClass.equals(CSeq.class) || hdrClass.equals(Via.class)
                        || hdrClass.equals(CallID.class) || hdrClass.equals(RequestLine.class) || hdrClass
                        .equals(StatusLine.class)));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1462750278 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logDebug("Encountered bad message \n" + message);
                } 
                String msgString = sipMessage.toString();
                {
                    boolean varD14AB56EAEC4527AFDDBDB5F15852E6F_592705366 = (!msgString.startsWith("SIP/") && !msgString.startsWith("ACK "));
                    {
                        String badReqRes = createBadReqRes(msgString, ex);
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1623613301 = (sipStack.isLoggingEnabled());
                                {
                                    sipStack.getStackLogger().logDebug("Sending automatic 400 Bad Request:");
                                    sipStack.getStackLogger().logDebug(badReqRes);
                                } 
                            } 
                            try 
                            {
                                this.sendMessage(badReqRes.getBytes(), this.getPeerInetAddress(), this
                                .getPeerPort(), false);
                            } 
                            catch (IOException e)
                            {
                                this.sipStack.getStackLogger().logException(e);
                            } 
                        } 
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_620296410 = (sipStack.isLoggingEnabled());
                                {
                                    sipStack.getStackLogger().logDebug(
                                "Could not formulate automatic 400 Bad Request");
                                } 
                            } 
                        } 
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.953 -0400", hash_original_method = "0B661C1775BD5742177C9AA146CAD19A", hash_generated_method = "EAB2435DC7B61970016F9AF5E1B42D06")
    public void processMessage(SIPMessage sipMessage) throws Exception {
        try 
        {
            {
                boolean var75ACC6F471BB1A68962D9AE1797FBD7B_98075462 = (sipMessage.getFrom() == null || sipMessage.getTo() == null
                    || sipMessage.getCallId() == null || sipMessage.getCSeq() == null
                    || sipMessage.getViaHeaders() == null);
                {
                    String badmsg = sipMessage.encode();
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_161887938 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logError("bad message " + badmsg);
                            sipStack.getStackLogger().logError(">>> Dropped Bad Msg");
                        } 
                    } 
                } 
            } 
            ViaList viaList = sipMessage.getViaHeaders();
            {
                Via v = (Via) viaList.getFirst();
                Hop hop = sipStack.addressResolver.resolveAddress(v.getHop());
                this.peerProtocol = v.getTransport();
                try 
                {
                    this.peerAddress = mySock.getInetAddress();
                    {
                        boolean var07142A8EFF3EF4AD30BCBC85CFE5B232_1248472907 = (v.hasParameter(Via.RPORT)
                            || !hop.getHost().equals(this.peerAddress.getHostAddress()));
                        {
                            v.setParameter(Via.RECEIVED, this.peerAddress.getHostAddress());
                        } 
                    } 
                    v.setParameter(Via.RPORT, Integer.toString(this.peerPort));
                } 
                catch (java.text.ParseException ex)
                {
                    InternalErrorHandler.handleException(ex);
                } 
                {
                    ((TLSMessageProcessor) this.messageProcessor).cacheMessageChannel(this);
                    this.isCached = true;
                    String key = IOHandler.makeKey(mySock.getInetAddress(), this.peerPort);
                    sipStack.ioHandler.putSocket(key, mySock);
                } 
            } 
            long receptionTime = System.currentTimeMillis();
            {
                SIPRequest sipRequest = (SIPRequest) sipMessage;
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_38438825 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug("----Processing Message---");
                    } 
                } 
                {
                    boolean var329151020C352D7210D49BED1EED92B4_1702259984 = (this.sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES));
                    {
                        sipStack.serverLogger.logMessage(sipMessage, this.getPeerHostPort().toString(),
                            this.messageProcessor.getIpAddress().getHostAddress() + ":"
                                    + this.messageProcessor.getPort(), false, receptionTime);
                    } 
                } 
                {
                    boolean varBFE4F5560E1DAE5D9C4B756065954E9B_836830 = (sipStack.getMaxMessageSize() > 0
                        && sipRequest.getSize()
                                + (sipRequest.getContentLength() == null ? 0 : sipRequest
                                        .getContentLength().getContentLength()) > sipStack
                                .getMaxMessageSize()); 
                    {
                        SIPResponse sipResponse = sipRequest
                            .createResponse(SIPResponse.MESSAGE_TOO_LARGE);
                        byte[] resp = sipResponse.encodeAsBytes(this.getTransport());
                        this.sendMessage(resp, false);
                        if (DroidSafeAndroidRuntime.control) throw new Exception("Message size exceeded");
                    } 
                } 
                ServerRequestInterface sipServerRequest = sipStack.newSIPServerRequest(
                        sipRequest, this);
                {
                    try 
                    {
                        sipServerRequest.processRequest(sipRequest, this);
                    } 
                    finally 
                    {
                        {
                            SIPServerTransaction sipServerTx = (SIPServerTransaction) sipServerRequest;
                            {
                                boolean varD802744989A665132B75B392ADE40209_2085189612 = (!sipServerTx.passToListener());
                                ((SIPTransaction) sipServerRequest).releaseSem();
                            } 
                        } 
                    } 
                } 
                {
                    SIPResponse response = sipRequest
                            .createResponse(Response.SERVICE_UNAVAILABLE);
                    RetryAfter retryAfter = new RetryAfter();
                    try 
                    {
                        retryAfter.setRetryAfter((int) (10 * (Math.random())));
                        response.setHeader(retryAfter);
                        this.sendMessage(response);
                    } 
                    catch (Exception e)
                    { }
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1075848988 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger()
                            .logWarning("Dropping message -- could not acquire semaphore");
                    } 
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
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1486248185 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger()
                                .logError("Dropping Badly formatted response message >>> "
                                        + sipResponse);
                    } 
                } 
                {
                    boolean var13C0D42D19654498AAF89BA284743FD1_531449187 = (sipStack.getMaxMessageSize() > 0
                        && sipResponse.getSize()
                                + (sipResponse.getContentLength() == null ? 0 : sipResponse
                                        .getContentLength().getContentLength()) > sipStack
                                .getMaxMessageSize()); 
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_356349563 = (sipStack.isLoggingEnabled());
                            this.sipStack.getStackLogger().logDebug("Message size exceeded");
                        } 
                    } 
                } 
                ServerResponseInterface sipServerResponse = sipStack.newSIPServerResponse(
                        sipResponse, this);
                {
                    try 
                    {
                        {
                            boolean var7B7EDCF7240C6ECDC5603DF13532F268_963808284 = (sipServerResponse instanceof SIPClientTransaction
                                && !((SIPClientTransaction) sipServerResponse)
                                        .checkFromTag(sipResponse));
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_590979098 = (sipStack.isLoggingEnabled());
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
                            boolean varDB4FC2DFFC674AF9290D5BD5A8705AB9_1737214300 = (sipServerResponse instanceof SIPTransaction
                                && !((SIPTransaction) sipServerResponse).passToListener());
                            {
                                ((SIPTransaction) sipServerResponse).releaseSem();
                            } 
                        } 
                    } 
                } 
                {
                    sipStack.getStackLogger().logWarning("Could not get semaphore... dropping response");
                } 
            } 
        } 
        finally 
        { }
        addTaint(sipMessage.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.954 -0400", hash_original_method = "F77124F9292782877CB3E3F72C9E9606", hash_generated_method = "64DF54C3121226A8B1C10FC5D91B9759")
    public void run() {
        Pipeline hispipe = null;
        hispipe = new Pipeline(myClientInputStream, sipStack.readTimeout,
                ((SIPTransactionStack) sipStack).getTimer());
        myParser = new PipelinedMsgParser(this, hispipe, this.sipStack.getMaxMessageSize());
        myParser.processInput();
        int bufferSize = 4096;
        this.isRunning = true;
        try 
        {
            {
                try 
                {
                    byte[] msg = new byte[bufferSize];
                    int nbytes = myClientInputStream.read(msg, 0, bufferSize);
                    {
                        hispipe.write("\r\n\r\n".getBytes("UTF-8"));
                        try 
                        {
                            {
                                {
                                    tlsMessageProcessor.notify();
                                } 
                            } 
                            hispipe.close();
                            mySock.close();
                        } 
                        catch (IOException ioex)
                        { }
                    } 
                    hispipe.write(msg, 0, nbytes);
                } 
                catch (IOException ex)
                {
                    try 
                    {
                        hispipe.write("\r\n\r\n".getBytes("UTF-8"));
                    } 
                    catch (Exception e)
                    { }
                    try 
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_1118888170 = (sipStack.isLoggingEnabled());
                            sipStack.getStackLogger().logDebug("IOException  closing sock " + ex);
                        } 
                        try 
                        {
                            {
                                {
                                    tlsMessageProcessor.notify();
                                } 
                            } 
                            mySock.close();
                            hispipe.close();
                        } 
                        catch (IOException ioex)
                        { }
                    } 
                    catch (Exception ex1)
                    { }
                } 
                catch (Exception ex)
                {
                    InternalErrorHandler.handleException(ex);
                } 
            } 
        } 
        finally 
        {
            this.isRunning = false;
            this.tlsMessageProcessor.remove(this);
            this.myParser.close();
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.955 -0400", hash_original_method = "C5292C7D09796AA7B556BAA154B95B16", hash_generated_method = "4846BBE21700A1CEFFBC05D2CDF13274")
    protected void uncache() {
        {
            this.tlsMessageProcessor.remove(this);
        } 
        
        
    		
    	
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.956 -0400", hash_original_method = "DA67C78A7E91B7C25B2E6DD841A2A96C", hash_generated_method = "77417E53D22E1F62B823D79411EBEF9E")
    public boolean equals(Object other) {
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_230304767 = (!this.getClass().equals(other.getClass()));
            {
                TLSMessageChannel that = (TLSMessageChannel) other;
            } 
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1484651248 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1484651248;
        
        
            
        
            
            
                
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.958 -0400", hash_original_method = "1173AC840F0483E84550BBD280ADF1B8", hash_generated_method = "63D3C3F3AD6E83EA7B99C79D9EC02F30")
    public String getKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_1927868847 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_566502043 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1927868847 = this.key;
        } 
        {
            this.key = MessageChannel.getKey(this.peerAddress, this.peerPort, "TLS");
            varB4EAC82CA7396A68D541C85D26508E83_566502043 = this.key;
        } 
        String varA7E53CE21691AB073D9660D615818899_1238016801; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1238016801 = varB4EAC82CA7396A68D541C85D26508E83_1927868847;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1238016801 = varB4EAC82CA7396A68D541C85D26508E83_566502043;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1238016801.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1238016801;
        
        
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.959 -0400", hash_original_method = "11E5C6A8F9691D7C5E18B4FE0A22A301", hash_generated_method = "044EF05D5F19C3A9442D7E9D9A511A48")
    public String getViaHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_273080565 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_273080565 = myAddress;
        varB4EAC82CA7396A68D541C85D26508E83_273080565.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_273080565;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.959 -0400", hash_original_method = "97574FAF366AF2CA74D034931ECBD71B", hash_generated_method = "3F696FB860BE945317F10415C06381F8")
    public int getViaPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1586432045 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1586432045;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.960 -0400", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "ACF13DBA146035F0FA91873B9179D5A4")
    public int getPeerPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_273581222 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_273581222;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.961 -0400", hash_original_method = "B210BD4A713B5B982D229CB138437A53", hash_generated_method = "E079B48FC05ED97F0DE4E4DF247B9AF8")
    public int getPeerPacketSourcePort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_744584815 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_744584815;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.964 -0400", hash_original_method = "97EAFF51EEE94208DA244D522468157C", hash_generated_method = "DBB4A3D43B962BB6F433FF0128E414D0")
    public InetAddress getPeerPacketSourceAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_923939581 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_923939581 = this.peerAddress;
        varB4EAC82CA7396A68D541C85D26508E83_923939581.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_923939581;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.966 -0400", hash_original_method = "57D47F2F9FCDF87C613C3BEA50BCDEDC", hash_generated_method = "D2234EF1C6CD14961EDDCCD0E768E7DB")
    public boolean isSecure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1961208835 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1961208835;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.967 -0400", hash_original_method = "17DB109E74C9C419B95A49BDAE918BA7", hash_generated_method = "58C9BB24EBB7523196DDC479C0D53915")
    public void setHandshakeCompletedListener(
            HandshakeCompletedListener handshakeCompletedListenerImpl) {
        this.handshakeCompletedListener = handshakeCompletedListenerImpl;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.968 -0400", hash_original_method = "6CFE0616A7B6D8A833DC048924F270CA", hash_generated_method = "C37A0B2630EBC090927143B6E6678D3E")
    public HandshakeCompletedListenerImpl getHandshakeCompletedListener() {
        HandshakeCompletedListenerImpl varB4EAC82CA7396A68D541C85D26508E83_586145877 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_586145877 = (HandshakeCompletedListenerImpl) handshakeCompletedListener;
        varB4EAC82CA7396A68D541C85D26508E83_586145877.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_586145877;
        
        
    }

    
}

