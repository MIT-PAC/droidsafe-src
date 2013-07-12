package gov.nist.javax.sip.stack;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.342 -0400", hash_original_field = "52CA6755165FFD50983D257A0F1E043B", hash_generated_field = "F3B00F7E70704D963CC4197CD003FB94")

    private Socket mySock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.342 -0400", hash_original_field = "8C35693B192604DA4AB63AD19D48096F", hash_generated_field = "152EC54D2111EF26096DF65FC2003536")

    private PipelinedMsgParser myParser;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.342 -0400", hash_original_field = "0EDD5FF84F2278A8C37689A050537727", hash_generated_field = "E9FA88EF5BFDD4D9156AADE5BC087A4C")

    private InputStream myClientInputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.342 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "2E3018221E30480EB0F957E72002C7D8")

    private String key;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.342 -0400", hash_original_field = "1AC7B394035E343F285A6A4ED1096126", hash_generated_field = "F8E96F7362B3E7CD3DE3A2778DC87A58")

    protected boolean isCached;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.342 -0400", hash_original_field = "39044C41F340C67BFA15E91CC6E98E7D", hash_generated_field = "911E18F9BE05473489F5F21C894DF579")

    protected boolean isRunning;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.342 -0400", hash_original_field = "9842605C72E3BC73DA5398CE4B5EB840", hash_generated_field = "8890F3B68DD2F65EEDEBEEF6284B3EE1")

    private Thread mythread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.343 -0400", hash_original_field = "AA48C74491DE12FAB31F14F04DE0F567", hash_generated_field = "DEE18A414D72F7D580E73EF519B5B75F")

    private String myAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.343 -0400", hash_original_field = "AB99FC537949F4680FB25A11A38B0042", hash_generated_field = "1FBEE69CBCB5E71F900C5C964DA7ADBD")

    private int myPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.343 -0400", hash_original_field = "D7FA5E7DC9BACC5016B81E35D44D1C5F", hash_generated_field = "DB2440387A41D5016778DA700632E003")

    private InetAddress peerAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.343 -0400", hash_original_field = "BBD5741C4F9994864582D25DD194C4DE", hash_generated_field = "FE74A5BA5CFBB5B6DC2B68FEFA76ECFC")

    private int peerPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.343 -0400", hash_original_field = "EDB6E8FD971C3E6879E1A00995BCB702", hash_generated_field = "EB665B7537D07145A6FCAD2DB460EADC")

    private String peerProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.343 -0400", hash_original_field = "8A2A02C2F7B9C43A9E25E5C24EA3F0F6", hash_generated_field = "5A3C22CB6AA628C04F88A4A28D40ED17")

    private TLSMessageProcessor tlsMessageProcessor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.343 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "ABE627693A01BDDC6597F9AB66B3018E")

    private SIPTransactionStack sipStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.343 -0400", hash_original_field = "7B8AE7FFC44A9C7B49E7C7EA6A6D3757", hash_generated_field = "12E7910E7EDE55EAF4A3D89EE23A6BC7")

    private HandshakeCompletedListener handshakeCompletedListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.345 -0400", hash_original_method = "358EB7732CC002B4969C64CA3912C6FF", hash_generated_method = "41AAD92E4FE6A62BC4352A5940D4CEFE")
    protected  TLSMessageChannel(Socket sock, SIPTransactionStack sipStack,
            TLSMessageProcessor msgProcessor) throws IOException {
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug("creating new TLSMessageChannel (incoming)");
            sipStack.getStackLogger().logStackTrace();
        } 
        mySock = (SSLSocket) sock;
    if(sock instanceof SSLSocket)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.347 -0400", hash_original_method = "36AC589476275C6F111789614D727487", hash_generated_method = "2CE7C94DFE28824CA1172998A97A2E0D")
    protected  TLSMessageChannel(InetAddress inetAddr, int port, SIPTransactionStack sipStack,
            TLSMessageProcessor messageProcessor) throws IOException {
    if(sipStack.isLoggingEnabled())        
        {
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.348 -0400", hash_original_method = "16D0E6CF226A4618D75D1B422CC8FCDF", hash_generated_method = "50B63E8A9125046B754C738DBA9F6C8C")
    public boolean isReliable() {
        boolean varB326B5062B2F0E69046810717534CB09_371540679 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1191584347 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1191584347;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.348 -0400", hash_original_method = "9757D034E975DAF9D22BACDE50FF4335", hash_generated_method = "76776E889B7121D34E819849FCBAB07F")
    public void close() {
        try 
        {
    if(mySock != null)            
            mySock.close();
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logDebug("Closing message Channel " + this);
        } 
        catch (IOException ex)
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logDebug("Error closing socket " + ex);
        } 
        
        
            
                
            
                
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.348 -0400", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "4606CD9CFC23A5ED6CF96D8134A9CCA9")
    public SIPTransactionStack getSIPStack() {
SIPTransactionStack var0FC1F21ED47F4C0C48881B0DAF112A16_413527862 =         sipStack;
        var0FC1F21ED47F4C0C48881B0DAF112A16_413527862.addTaint(taint);
        return var0FC1F21ED47F4C0C48881B0DAF112A16_413527862;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.348 -0400", hash_original_method = "00B4B3FBB10028B216605159EFB81D52", hash_generated_method = "4D7D1D540B28B099A78E0F6D5EFFE6A2")
    public String getTransport() {
String varB8D2FCEBAA9B11CA37B9DB1974AA0DF8_735130341 =         "tls";
        varB8D2FCEBAA9B11CA37B9DB1974AA0DF8_735130341.addTaint(taint);
        return varB8D2FCEBAA9B11CA37B9DB1974AA0DF8_735130341;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.349 -0400", hash_original_method = "59CC467573DB54CDCEF540AE63F43735", hash_generated_method = "CD5EF99A68B5B2B26C510CE1718B6E9D")
    public String getPeerAddress() {
    if(peerAddress != null)        
        {
String var4D1B58EF74DF31190A62E0DF268BAE94_922776360 =             peerAddress.getHostAddress();
            var4D1B58EF74DF31190A62E0DF268BAE94_922776360.addTaint(taint);
            return var4D1B58EF74DF31190A62E0DF268BAE94_922776360;
        } 
        else
        {
String var5C0621B65E898A3E2061530CDD6F20D5_1119000736 =         getHost();
        var5C0621B65E898A3E2061530CDD6F20D5_1119000736.addTaint(taint);
        return var5C0621B65E898A3E2061530CDD6F20D5_1119000736;
        }
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.349 -0400", hash_original_method = "1F29EC3BC94C3E0863F530FCD37A61F3", hash_generated_method = "F4C91206D82558EB99C5611C3763275E")
    protected InetAddress getPeerInetAddress() {
InetAddress var73F565C01AAA4A3FCE210191AB87441A_832565165 =         peerAddress;
        var73F565C01AAA4A3FCE210191AB87441A_832565165.addTaint(taint);
        return var73F565C01AAA4A3FCE210191AB87441A_832565165;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.349 -0400", hash_original_method = "DB79607DA3ACB5FA2D24428DF2713F98", hash_generated_method = "D3BC134F6C498ACE92D839C76276ACFF")
    public String getPeerProtocol() {
String var6B5233BA3C9F99490638F3C0025EA1D3_882244978 =         this.peerProtocol;
        var6B5233BA3C9F99490638F3C0025EA1D3_882244978.addTaint(taint);
        return var6B5233BA3C9F99490638F3C0025EA1D3_882244978;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.350 -0400", hash_original_method = "769119032395AFB8B9E88BC54405133A", hash_generated_method = "A816F38E2B010419DF44D99118FA6F4D")
    private void sendMessage(byte[] msg, boolean retry) throws IOException {
        addTaint(retry);
        addTaint(msg[0]);
        Socket sock = this.sipStack.ioHandler.sendBytes(
                this.getMessageProcessor().getIpAddress(), this.peerAddress, this.peerPort,
                this.peerProtocol, msg, retry,this);
    if(sock != mySock && sock != null)        
        {
            try 
            {
    if(mySock != null)                
                mySock.close();
            } 
            catch (IOException ex)
            {
            } 
            mySock = sock;
            this.myClientInputStream = mySock.getInputStream();
            Thread thread = new Thread(this);
            thread.setDaemon(true);
            thread.setName("TLSMessageChannelThread");
            thread.start();
        } 
        
        
                
                
        
            
                
                    
            
            
            
            
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.350 -0400", hash_original_method = "99193C77E68A5ABE715A7A9AC8040C34", hash_generated_method = "3AFE7FB96641BAB0037F900E9E93B940")
    public void sendMessage(SIPMessage sipMessage) throws IOException {
        addTaint(sipMessage.getTaint());
        byte[] msg = sipMessage.encodeAsBytes(this.getTransport());
        long time = System.currentTimeMillis();
        this.sendMessage(msg, sipMessage instanceof SIPRequest);
    if(this.sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES))        
        logMessage(sipMessage, peerAddress, peerPort, time);
        
        
        
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.351 -0400", hash_original_method = "C6D6B3579ACFAA2466286D67BFFE3003", hash_generated_method = "7000238C721A267201B201B5F10E6C42")
    public void sendMessage(byte message[], InetAddress receiverAddress, int receiverPort,
            boolean retry) throws IOException {
        addTaint(retry);
        addTaint(receiverPort);
        addTaint(receiverAddress.getTaint());
        addTaint(message[0]);
    if(message == null || receiverAddress == null)        
        {
        IllegalArgumentException varFDDDD686508FEB178E9B557172ECF36A_1244038275 = new IllegalArgumentException("Null argument");
        varFDDDD686508FEB178E9B557172ECF36A_1244038275.addTaint(taint);
        throw varFDDDD686508FEB178E9B557172ECF36A_1244038275;
        }
        Socket sock = this.sipStack.ioHandler.sendBytes(this.messageProcessor.getIpAddress(),
                receiverAddress, receiverPort, "TLS", message, retry, this);
    if(sock != mySock && sock != null)        
        {
            try 
            {
    if(mySock != null)                
                mySock.close();
            } 
            catch (IOException ex)
            {
            } 
            mySock = sock;
            this.myClientInputStream = mySock.getInputStream();
            Thread mythread = new Thread(this);
            mythread.setDaemon(true);
            mythread.setName("TLSMessageChannelThread");
            mythread.start();
        } 
        
        
            
        
                
        
            
                
                    
            
            
            
            
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.352 -0400", hash_original_method = "F10EA794C47048E710B5CED57C611CE1", hash_generated_method = "588C0A974D5F9045F3D8141797986EB6")
    public void handleException(ParseException ex, SIPMessage sipMessage, Class hdrClass,
            String header, String message) throws ParseException {
        addTaint(message.getTaint());
        addTaint(header.getTaint());
        addTaint(hdrClass.getTaint());
        addTaint(sipMessage.getTaint());
        addTaint(ex.getTaint());
    if(sipStack.isLoggingEnabled())        
        sipStack.getStackLogger().logException(ex);
    if((hdrClass != null)
                && (hdrClass.equals(From.class) || hdrClass.equals(To.class)
                        || hdrClass.equals(CSeq.class) || hdrClass.equals(Via.class)
                        || hdrClass.equals(CallID.class) || hdrClass.equals(RequestLine.class) || hdrClass
                        .equals(StatusLine.class)))        
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logDebug("Encountered bad message \n" + message);
            String msgString = sipMessage.toString();
    if(!msgString.startsWith("SIP/") && !msgString.startsWith("ACK "))            
            {
                String badReqRes = createBadReqRes(msgString, ex);
    if(badReqRes != null)                
                {
    if(sipStack.isLoggingEnabled())                    
                    {
                        sipStack.getStackLogger().logDebug("Sending automatic 400 Bad Request:");
                        sipStack.getStackLogger().logDebug(badReqRes);
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
                else
                {
    if(sipStack.isLoggingEnabled())                    
                    {
                        sipStack.getStackLogger().logDebug(
                                "Could not formulate automatic 400 Bad Request");
                    } 
                } 
            } 
            ex.addTaint(taint);
            throw ex;
        } 
        else
        {
            sipMessage.addUnparsed(header);
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.355 -0400", hash_original_method = "0B661C1775BD5742177C9AA146CAD19A", hash_generated_method = "05A21F6385E7E48B87FC162E64626AC8")
    public void processMessage(SIPMessage sipMessage) throws Exception {
        addTaint(sipMessage.getTaint());
        try 
        {
    if(sipMessage.getFrom() == null || sipMessage.getTo() == null
                    || sipMessage.getCallId() == null || sipMessage.getCSeq() == null
                    || sipMessage.getViaHeaders() == null)            
            {
                String badmsg = sipMessage.encode();
    if(sipStack.isLoggingEnabled())                
                {
                    sipStack.getStackLogger().logError("bad message " + badmsg);
                    sipStack.getStackLogger().logError(">>> Dropped Bad Msg");
                } 
                return;
            } 
            ViaList viaList = sipMessage.getViaHeaders();
    if(sipMessage instanceof SIPRequest)            
            {
                Via v = (Via) viaList.getFirst();
                Hop hop = sipStack.addressResolver.resolveAddress(v.getHop());
                this.peerProtocol = v.getTransport();
                try 
                {
                    this.peerAddress = mySock.getInetAddress();
    if(v.hasParameter(Via.RPORT)
                            || !hop.getHost().equals(this.peerAddress.getHostAddress()))                    
                    {
                        v.setParameter(Via.RECEIVED, this.peerAddress.getHostAddress());
                    } 
                    v.setParameter(Via.RPORT, Integer.toString(this.peerPort));
                } 
                catch (java.text.ParseException ex)
                {
                    InternalErrorHandler.handleException(ex);
                } 
    if(!this.isCached)                
                {
                    ((TLSMessageProcessor) this.messageProcessor).cacheMessageChannel(this);
                    this.isCached = true;
                    String key = IOHandler.makeKey(mySock.getInetAddress(), this.peerPort);
                    sipStack.ioHandler.putSocket(key, mySock);
                } 
            } 
            long receptionTime = System.currentTimeMillis();
    if(sipMessage instanceof SIPRequest)            
            {
                SIPRequest sipRequest = (SIPRequest) sipMessage;
    if(sipStack.isLoggingEnabled())                
                {
                    sipStack.getStackLogger().logDebug("----Processing Message---");
                } 
    if(this.sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES))                
                {
                    sipStack.serverLogger.logMessage(sipMessage, this.getPeerHostPort().toString(),
                            this.messageProcessor.getIpAddress().getHostAddress() + ":"
                                    + this.messageProcessor.getPort(), false, receptionTime);
                } 
    if(sipStack.getMaxMessageSize() > 0
                        && sipRequest.getSize()
                                + (sipRequest.getContentLength() == null ? 0 : sipRequest
                                        .getContentLength().getContentLength()) > sipStack
                                .getMaxMessageSize())                
                {
                    SIPResponse sipResponse = sipRequest
                            .createResponse(SIPResponse.MESSAGE_TOO_LARGE);
                    byte[] resp = sipResponse.encodeAsBytes(this.getTransport());
                    this.sendMessage(resp, false);
                    Exception varDF678B266A68FE82BCEBF8807C609878_82820708 = new Exception("Message size exceeded");
                    varDF678B266A68FE82BCEBF8807C609878_82820708.addTaint(taint);
                    throw varDF678B266A68FE82BCEBF8807C609878_82820708;
                } 
                ServerRequestInterface sipServerRequest = sipStack.newSIPServerRequest(
                        sipRequest, this);
    if(sipServerRequest != null)                
                {
                    try 
                    {
                        sipServerRequest.processRequest(sipRequest, this);
                    } 
                    finally 
                    {
    if(sipServerRequest instanceof SIPTransaction)                        
                        {
                            SIPServerTransaction sipServerTx = (SIPServerTransaction) sipServerRequest;
    if(!sipServerTx.passToListener())                            
                            ((SIPTransaction) sipServerRequest).releaseSem();
                        } 
                    } 
                } 
                else
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
                    {
                    } 
    if(sipStack.isLoggingEnabled())                    
                    sipStack.getStackLogger()
                            .logWarning("Dropping message -- could not acquire semaphore");
                } 
            } 
            else
            {
                SIPResponse sipResponse = (SIPResponse) sipMessage;
                try 
                {
                    sipResponse.checkHeaders();
                } 
                catch (ParseException ex)
                {
    if(sipStack.isLoggingEnabled())                    
                    sipStack.getStackLogger()
                                .logError("Dropping Badly formatted response message >>> "
                                        + sipResponse);
                    return;
                } 
    if(sipStack.getMaxMessageSize() > 0
                        && sipResponse.getSize()
                                + (sipResponse.getContentLength() == null ? 0 : sipResponse
                                        .getContentLength().getContentLength()) > sipStack
                                .getMaxMessageSize())                
                {
    if(sipStack.isLoggingEnabled())                    
                    this.sipStack.getStackLogger().logDebug("Message size exceeded");
                    return;
                } 
                ServerResponseInterface sipServerResponse = sipStack.newSIPServerResponse(
                        sipResponse, this);
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
                        } 
                        sipServerResponse.processResponse(sipResponse, this);
                    } 
                    finally 
                    {
    if(sipServerResponse instanceof SIPTransaction
                                && !((SIPTransaction) sipServerResponse).passToListener())                        
                        {
                            ((SIPTransaction) sipServerResponse).releaseSem();
                        } 
                    } 
                } 
                else
                {
                    sipStack.getStackLogger().logWarning("Could not get semaphore... dropping response");
                } 
            } 
        } 
        finally 
        {
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.358 -0400", hash_original_method = "F77124F9292782877CB3E3F72C9E9606", hash_generated_method = "4FA7C0EB39A797D56DAD727C818F71E4")
    public void run() {
        Pipeline hispipe = null;
        hispipe = new Pipeline(myClientInputStream, sipStack.readTimeout,
                ((SIPTransactionStack) sipStack).getTimer());
        myParser = new PipelinedMsgParser(this, hispipe, this.sipStack.getMaxMessageSize());
        myParser.processInput();
        int bufferSize = 4096;
        this.tlsMessageProcessor.useCount++;
        this.isRunning = true;
        try 
        {
            while
(true)            
            {
                try 
                {
                    byte[] msg = new byte[bufferSize];
                    int nbytes = myClientInputStream.read(msg, 0, bufferSize);
    if(nbytes == -1)                    
                    {
                        hispipe.write("\r\n\r\n".getBytes("UTF-8"));
                        try 
                        {
    if(sipStack.maxConnections != -1)                            
                            {
                                synchronized
(tlsMessageProcessor)                                {
                                    tlsMessageProcessor.nConnections--;
                                    tlsMessageProcessor.notify();
                                } 
                            } 
                            hispipe.close();
                            mySock.close();
                        } 
                        catch (IOException ioex)
                        {
                        } 
                        return;
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
                    {
                    } 
                    try 
                    {
    if(sipStack.isLoggingEnabled())                        
                        sipStack.getStackLogger().logDebug("IOException  closing sock " + ex);
                        try 
                        {
    if(sipStack.maxConnections != -1)                            
                            {
                                synchronized
(tlsMessageProcessor)                                {
                                    tlsMessageProcessor.nConnections--;
                                    tlsMessageProcessor.notify();
                                } 
                            } 
                            mySock.close();
                            hispipe.close();
                        } 
                        catch (IOException ioex)
                        {
                        } 
                    } 
                    catch (Exception ex1)
                    {
                    } 
                    return;
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
            this.tlsMessageProcessor.useCount--;
            this.myParser.close();
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.359 -0400", hash_original_method = "C5292C7D09796AA7B556BAA154B95B16", hash_generated_method = "19BD5C548BA646BC51923EE3FA878094")
    protected void uncache() {
    if(isCached && !isRunning)        
        {
            this.tlsMessageProcessor.remove(this);
        } 
        
        
    		
    	
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.360 -0400", hash_original_method = "DA67C78A7E91B7C25B2E6DD841A2A96C", hash_generated_method = "F9194830FD9FEA6BC5775DF4AE7AF272")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(!this.getClass().equals(other.getClass()))        
        {
        boolean var68934A3E9455FA72420237EB05902327_620152220 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_120849930 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_120849930;
        }
        else
        {
            TLSMessageChannel that = (TLSMessageChannel) other;
    if(this.mySock != that.mySock)            
            {
            boolean var68934A3E9455FA72420237EB05902327_553925073 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1005845218 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1005845218;
            }
            else
            {
            boolean varB326B5062B2F0E69046810717534CB09_1071421886 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1576307606 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1576307606;
            }
        } 
        
        
            
        
            
            
                
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.360 -0400", hash_original_method = "1173AC840F0483E84550BBD280ADF1B8", hash_generated_method = "398DBC9EDBC3A9048140320140BD47A7")
    public String getKey() {
    if(this.key != null)        
        {
String var28438ADFC1608AABD649C75D36B519BF_225855677 =             this.key;
            var28438ADFC1608AABD649C75D36B519BF_225855677.addTaint(taint);
            return var28438ADFC1608AABD649C75D36B519BF_225855677;
        } 
        else
        {
            this.key = MessageChannel.getKey(this.peerAddress, this.peerPort, "TLS");
String var28438ADFC1608AABD649C75D36B519BF_1118416829 =             this.key;
            var28438ADFC1608AABD649C75D36B519BF_1118416829.addTaint(taint);
            return var28438ADFC1608AABD649C75D36B519BF_1118416829;
        } 
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.360 -0400", hash_original_method = "11E5C6A8F9691D7C5E18B4FE0A22A301", hash_generated_method = "C85676017DFB6D234182607C780B11C6")
    public String getViaHost() {
String varE7034C1BD80371A3EE602CF085A2802A_350967377 =         myAddress;
        varE7034C1BD80371A3EE602CF085A2802A_350967377.addTaint(taint);
        return varE7034C1BD80371A3EE602CF085A2802A_350967377;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.361 -0400", hash_original_method = "97574FAF366AF2CA74D034931ECBD71B", hash_generated_method = "23857EA0C1F46280AF7846B1142CA13A")
    public int getViaPort() {
        int varAB99FC537949F4680FB25A11A38B0042_788123074 = (myPort);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1040909475 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1040909475;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.361 -0400", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "811D164E6E8C798487CC0B69132680C1")
    public int getPeerPort() {
        int varBBD5741C4F9994864582D25DD194C4DE_1916270067 = (peerPort);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2143356902 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2143356902;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.361 -0400", hash_original_method = "B210BD4A713B5B982D229CB138437A53", hash_generated_method = "D780337C1EAA163B37E4DEBE3FABCC3C")
    public int getPeerPacketSourcePort() {
        int var863AF973F56BABC8062C15431981E0EC_1098859910 = (this.peerPort);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1784956384 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1784956384;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.362 -0400", hash_original_method = "97EAFF51EEE94208DA244D522468157C", hash_generated_method = "F80B3DBD0EFA94BC072950C898988384")
    public InetAddress getPeerPacketSourceAddress() {
InetAddress varCB519CCE5105BD67F1450F075D5E971F_406420451 =         this.peerAddress;
        varCB519CCE5105BD67F1450F075D5E971F_406420451.addTaint(taint);
        return varCB519CCE5105BD67F1450F075D5E971F_406420451;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.362 -0400", hash_original_method = "57D47F2F9FCDF87C613C3BEA50BCDEDC", hash_generated_method = "A4AD8C92183587B087FEE93C04F8FA95")
    public boolean isSecure() {
        boolean varB326B5062B2F0E69046810717534CB09_882667647 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_453811120 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_453811120;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.362 -0400", hash_original_method = "17DB109E74C9C419B95A49BDAE918BA7", hash_generated_method = "58C9BB24EBB7523196DDC479C0D53915")
    public void setHandshakeCompletedListener(
            HandshakeCompletedListener handshakeCompletedListenerImpl) {
        this.handshakeCompletedListener = handshakeCompletedListenerImpl;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.362 -0400", hash_original_method = "6CFE0616A7B6D8A833DC048924F270CA", hash_generated_method = "454552630A37C942491ACEE947C1F4B7")
    public HandshakeCompletedListenerImpl getHandshakeCompletedListener() {
HandshakeCompletedListenerImpl var9A2E431CC033EB690CBDC6286A497C3F_1016214848 =         (HandshakeCompletedListenerImpl) handshakeCompletedListener;
        var9A2E431CC033EB690CBDC6286A497C3F_1016214848.addTaint(taint);
        return var9A2E431CC033EB690CBDC6286A497C3F_1016214848;
        
        
    }

    
}

