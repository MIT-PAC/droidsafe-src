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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.044 -0400", hash_original_field = "52CA6755165FFD50983D257A0F1E043B", hash_generated_field = "F3B00F7E70704D963CC4197CD003FB94")

    private Socket mySock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.044 -0400", hash_original_field = "8C35693B192604DA4AB63AD19D48096F", hash_generated_field = "152EC54D2111EF26096DF65FC2003536")

    private PipelinedMsgParser myParser;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.044 -0400", hash_original_field = "0EDD5FF84F2278A8C37689A050537727", hash_generated_field = "E9FA88EF5BFDD4D9156AADE5BC087A4C")

    private InputStream myClientInputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.044 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "2E3018221E30480EB0F957E72002C7D8")

    private String key;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.044 -0400", hash_original_field = "1AC7B394035E343F285A6A4ED1096126", hash_generated_field = "F8E96F7362B3E7CD3DE3A2778DC87A58")

    protected boolean isCached;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.044 -0400", hash_original_field = "39044C41F340C67BFA15E91CC6E98E7D", hash_generated_field = "911E18F9BE05473489F5F21C894DF579")

    protected boolean isRunning;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.044 -0400", hash_original_field = "9842605C72E3BC73DA5398CE4B5EB840", hash_generated_field = "8890F3B68DD2F65EEDEBEEF6284B3EE1")

    private Thread mythread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.044 -0400", hash_original_field = "AA48C74491DE12FAB31F14F04DE0F567", hash_generated_field = "DEE18A414D72F7D580E73EF519B5B75F")

    private String myAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.044 -0400", hash_original_field = "AB99FC537949F4680FB25A11A38B0042", hash_generated_field = "1FBEE69CBCB5E71F900C5C964DA7ADBD")

    private int myPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.044 -0400", hash_original_field = "D7FA5E7DC9BACC5016B81E35D44D1C5F", hash_generated_field = "DB2440387A41D5016778DA700632E003")

    private InetAddress peerAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.044 -0400", hash_original_field = "BBD5741C4F9994864582D25DD194C4DE", hash_generated_field = "FE74A5BA5CFBB5B6DC2B68FEFA76ECFC")

    private int peerPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.044 -0400", hash_original_field = "EDB6E8FD971C3E6879E1A00995BCB702", hash_generated_field = "EB665B7537D07145A6FCAD2DB460EADC")

    private String peerProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.044 -0400", hash_original_field = "8A2A02C2F7B9C43A9E25E5C24EA3F0F6", hash_generated_field = "5A3C22CB6AA628C04F88A4A28D40ED17")

    private TLSMessageProcessor tlsMessageProcessor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.044 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "ABE627693A01BDDC6597F9AB66B3018E")

    private SIPTransactionStack sipStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.044 -0400", hash_original_field = "7B8AE7FFC44A9C7B49E7C7EA6A6D3757", hash_generated_field = "12E7910E7EDE55EAF4A3D89EE23A6BC7")

    private HandshakeCompletedListener handshakeCompletedListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.046 -0400", hash_original_method = "358EB7732CC002B4969C64CA3912C6FF", hash_generated_method = "7C12B2CB5E012DE58518D1FF701E3CFE")
    protected  TLSMessageChannel(Socket sock, SIPTransactionStack sipStack,
            TLSMessageProcessor msgProcessor) throws IOException {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1558249529 = (sipStack.isLoggingEnabled());
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
        this.sipStack = sipStack;
        this.tlsMessageProcessor = msgProcessor;
        this.myPort = this.tlsMessageProcessor.getPort();
        this.peerPort = mySock.getPort();
        super.messageProcessor = msgProcessor;
        mythread.start();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.069 -0400", hash_original_method = "36AC589476275C6F111789614D727487", hash_generated_method = "B0C29BC4A98DB3E8F059EE346CC97B8C")
    protected  TLSMessageChannel(InetAddress inetAddr, int port, SIPTransactionStack sipStack,
            TLSMessageProcessor messageProcessor) throws IOException {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1446282468 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("creating new TLSMessageChannel (outgoing)");
                sipStack.getStackLogger().logStackTrace();
            } //End block
        } //End collapsed parenthetic
        this.peerAddress = inetAddr;
        this.peerPort = port;
        this.myPort = messageProcessor.getPort();
        this.peerProtocol = "TLS";
        this.sipStack = sipStack;
        this.tlsMessageProcessor = messageProcessor;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.070 -0400", hash_original_method = "16D0E6CF226A4618D75D1B422CC8FCDF", hash_generated_method = "D96FC3C2A0914A96CB925D47C4395A4E")
    public boolean isReliable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_753746207 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_753746207;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.079 -0400", hash_original_method = "9757D034E975DAF9D22BACDE50FF4335", hash_generated_method = "F6B32B90BE08F90DA2C6C144F4A1CBBB")
    public void close() {
        try 
        {
            mySock.close();
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_488920422 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Closing message Channel " + this);
            } //End collapsed parenthetic
        } //End block
        catch (IOException ex)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_2110512509 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.080 -0400", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "781CE010D269F47B974AB0701C0F0956")
    public SIPTransactionStack getSIPStack() {
        SIPTransactionStack varB4EAC82CA7396A68D541C85D26508E83_1981959201 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1981959201 = sipStack;
        varB4EAC82CA7396A68D541C85D26508E83_1981959201.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1981959201;
        // ---------- Original Method ----------
        //return sipStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.080 -0400", hash_original_method = "00B4B3FBB10028B216605159EFB81D52", hash_generated_method = "D160C343960F0065EEF90849CA858DDD")
    public String getTransport() {
        String varB4EAC82CA7396A68D541C85D26508E83_1565280924 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1565280924 = "tls";
        varB4EAC82CA7396A68D541C85D26508E83_1565280924.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1565280924;
        // ---------- Original Method ----------
        //return "tls";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.081 -0400", hash_original_method = "59CC467573DB54CDCEF540AE63F43735", hash_generated_method = "B650D5CDC1B455C986A24C48C69D869F")
    public String getPeerAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_1285079804 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_181150866 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1285079804 = peerAddress.getHostAddress();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_181150866 = getHost();
        String varA7E53CE21691AB073D9660D615818899_999196901; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_999196901 = varB4EAC82CA7396A68D541C85D26508E83_1285079804;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_999196901 = varB4EAC82CA7396A68D541C85D26508E83_181150866;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_999196901.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_999196901;
        // ---------- Original Method ----------
        //if (peerAddress != null) {
            //return peerAddress.getHostAddress();
        //} else
            //return getHost();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.081 -0400", hash_original_method = "1F29EC3BC94C3E0863F530FCD37A61F3", hash_generated_method = "683592E496DA50D122566D38788EF821")
    protected InetAddress getPeerInetAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_580009527 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_580009527 = peerAddress;
        varB4EAC82CA7396A68D541C85D26508E83_580009527.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_580009527;
        // ---------- Original Method ----------
        //return peerAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.082 -0400", hash_original_method = "DB79607DA3ACB5FA2D24428DF2713F98", hash_generated_method = "5C622DE7162A357A71E9A7D4EA3E0FAB")
    public String getPeerProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_1915596951 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1915596951 = this.peerProtocol;
        varB4EAC82CA7396A68D541C85D26508E83_1915596951.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1915596951;
        // ---------- Original Method ----------
        //return this.peerProtocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.083 -0400", hash_original_method = "769119032395AFB8B9E88BC54405133A", hash_generated_method = "858E345A45BD6D8FF4A9FC20DF7C07DF")
    private void sendMessage(byte[] msg, boolean retry) throws IOException {
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
        addTaint(msg[0]);
        addTaint(retry);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.083 -0400", hash_original_method = "99193C77E68A5ABE715A7A9AC8040C34", hash_generated_method = "6E5B8CEFF60A5E15198CB345A5F29986")
    public void sendMessage(SIPMessage sipMessage) throws IOException {
        byte[] msg;
        msg = sipMessage.encodeAsBytes(this.getTransport());
        long time;
        time = System.currentTimeMillis();
        this.sendMessage(msg, sipMessage instanceof SIPRequest);
        {
            boolean var53DEB6CBCADF9510253D9D22204998C3_1003124324 = (this.sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES));
            logMessage(sipMessage, peerAddress, peerPort, time);
        } //End collapsed parenthetic
        addTaint(sipMessage.getTaint());
        // ---------- Original Method ----------
        //byte[] msg = sipMessage.encodeAsBytes(this.getTransport());
        //long time = System.currentTimeMillis();
        //this.sendMessage(msg, sipMessage instanceof SIPRequest);
        //if (this.sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES))
            //logMessage(sipMessage, peerAddress, peerPort, time);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.087 -0400", hash_original_method = "C6D6B3579ACFAA2466286D67BFFE3003", hash_generated_method = "A9714A1617B2C74B10EAA47EAA8CC391")
    public void sendMessage(byte message[], InetAddress receiverAddress, int receiverPort,
            boolean retry) throws IOException {
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
        addTaint(message);
        addTaint(receiverAddress.getTaint());
        addTaint(receiverPort);
        addTaint(retry);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.110 -0400", hash_original_method = "F10EA794C47048E710B5CED57C611CE1", hash_generated_method = "B60CBE0903ADB7CA03D7AF97677E8313")
    public void handleException(ParseException ex, SIPMessage sipMessage, Class hdrClass,
            String header, String message) throws ParseException {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1433375609 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logException(ex);
        } //End collapsed parenthetic
        {
            boolean var4AF4DF15E5A9AA725DAB2E0A6B114A9C_822849866 = ((hdrClass != null)
                && (hdrClass.equals(From.class) || hdrClass.equals(To.class)
                        || hdrClass.equals(CSeq.class) || hdrClass.equals(Via.class)
                        || hdrClass.equals(CallID.class) || hdrClass.equals(RequestLine.class) || hdrClass
                        .equals(StatusLine.class)));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1943897787 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logDebug("Encountered bad message \n" + message);
                } //End collapsed parenthetic
                String msgString;
                msgString = sipMessage.toString();
                {
                    boolean varD14AB56EAEC4527AFDDBDB5F15852E6F_193561803 = (!msgString.startsWith("SIP/") && !msgString.startsWith("ACK "));
                    {
                        String badReqRes;
                        badReqRes = createBadReqRes(msgString, ex);
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1424819438 = (sipStack.isLoggingEnabled());
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
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1516679409 = (sipStack.isLoggingEnabled());
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
        addTaint(ex.getTaint());
        addTaint(sipMessage.getTaint());
        addTaint(hdrClass.getTaint());
        addTaint(header.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.130 -0400", hash_original_method = "0B661C1775BD5742177C9AA146CAD19A", hash_generated_method = "1899C360B5565E33C7013F023CB04A4B")
    public void processMessage(SIPMessage sipMessage) throws Exception {
        try 
        {
            {
                boolean var75ACC6F471BB1A68962D9AE1797FBD7B_680454039 = (sipMessage.getFrom() == null || sipMessage.getTo() == null
                    || sipMessage.getCallId() == null || sipMessage.getCSeq() == null
                    || sipMessage.getViaHeaders() == null);
                {
                    String badmsg;
                    badmsg = sipMessage.encode();
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_560556910 = (sipStack.isLoggingEnabled());
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
                        boolean var07142A8EFF3EF4AD30BCBC85CFE5B232_477166039 = (v.hasParameter(Via.RPORT)
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
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1209439302 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug("----Processing Message---");
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var329151020C352D7210D49BED1EED92B4_1779590027 = (this.sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES));
                    {
                        sipStack.serverLogger.logMessage(sipMessage, this.getPeerHostPort().toString(),
                            this.messageProcessor.getIpAddress().getHostAddress() + ":"
                                    + this.messageProcessor.getPort(), false, receptionTime);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varBFE4F5560E1DAE5D9C4B756065954E9B_1080687626 = (sipStack.getMaxMessageSize() > 0
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
                                boolean varD802744989A665132B75B392ADE40209_1635722790 = (!sipServerTx.passToListener());
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
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1038159533 = (sipStack.isLoggingEnabled());
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
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1004364310 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger()
                                .logError("Dropping Badly formatted response message >>> "
                                        + sipResponse);
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var13C0D42D19654498AAF89BA284743FD1_739688861 = (sipStack.getMaxMessageSize() > 0
                        && sipResponse.getSize()
                                + (sipResponse.getContentLength() == null ? 0 : sipResponse
                                        .getContentLength().getContentLength()) > sipStack
                                .getMaxMessageSize()); //DSFIXME:  CODE0008: Nested ternary operator in expression
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_234439603 = (sipStack.isLoggingEnabled());
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
                            boolean var7B7EDCF7240C6ECDC5603DF13532F268_247700359 = (sipServerResponse instanceof SIPClientTransaction
                                && !((SIPClientTransaction) sipServerResponse)
                                        .checkFromTag(sipResponse));
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_859587783 = (sipStack.isLoggingEnabled());
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
                            boolean varDB4FC2DFFC674AF9290D5BD5A8705AB9_981065465 = (sipServerResponse instanceof SIPTransaction
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
        addTaint(sipMessage.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.143 -0400", hash_original_method = "F77124F9292782877CB3E3F72C9E9606", hash_generated_method = "594B1F6E42B8EEC705302381937A2D4B")
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
                            boolean var2AB968A8303910EE00F810B6DE3410F9_1360434537 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.145 -0400", hash_original_method = "C5292C7D09796AA7B556BAA154B95B16", hash_generated_method = "4846BBE21700A1CEFFBC05D2CDF13274")
    protected void uncache() {
        {
            this.tlsMessageProcessor.remove(this);
        } //End block
        // ---------- Original Method ----------
        //if (isCached && !isRunning) {    	
    		//this.tlsMessageProcessor.remove(this);
    	//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.145 -0400", hash_original_method = "DA67C78A7E91B7C25B2E6DD841A2A96C", hash_generated_method = "0DD59E788A71900D6B19B1BE7E6F8305")
    public boolean equals(Object other) {
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_2035443330 = (!this.getClass().equals(other.getClass()));
            {
                TLSMessageChannel that;
                that = (TLSMessageChannel) other;
            } //End block
        } //End collapsed parenthetic
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1151513279 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1151513279;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.171 -0400", hash_original_method = "1173AC840F0483E84550BBD280ADF1B8", hash_generated_method = "69863D4680E5FDA7DF74D45CAAACDA01")
    public String getKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_1424580444 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1936254123 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1424580444 = this.key;
        } //End block
        {
            this.key = MessageChannel.getKey(this.peerAddress, this.peerPort, "TLS");
            varB4EAC82CA7396A68D541C85D26508E83_1936254123 = this.key;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1500653181; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1500653181 = varB4EAC82CA7396A68D541C85D26508E83_1424580444;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1500653181 = varB4EAC82CA7396A68D541C85D26508E83_1936254123;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1500653181.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1500653181;
        // ---------- Original Method ----------
        //if (this.key != null) {
            //return this.key;
        //} else {
            //this.key = MessageChannel.getKey(this.peerAddress, this.peerPort, "TLS");
            //return this.key;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.172 -0400", hash_original_method = "11E5C6A8F9691D7C5E18B4FE0A22A301", hash_generated_method = "32D79AC8B01A1E98A0C768A34CE9E53E")
    public String getViaHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_1014547787 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1014547787 = myAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1014547787.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1014547787;
        // ---------- Original Method ----------
        //return myAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.172 -0400", hash_original_method = "97574FAF366AF2CA74D034931ECBD71B", hash_generated_method = "2A3204059E04D67B5974A4411352A980")
    public int getViaPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_707204366 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_707204366;
        // ---------- Original Method ----------
        //return myPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.173 -0400", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "F8799D9424D3FEA538B31697506FD4AC")
    public int getPeerPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_542307425 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_542307425;
        // ---------- Original Method ----------
        //return peerPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.174 -0400", hash_original_method = "B210BD4A713B5B982D229CB138437A53", hash_generated_method = "BFF78F3C3DA11A42B87FC39AB5C50D40")
    public int getPeerPacketSourcePort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_3813319 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_3813319;
        // ---------- Original Method ----------
        //return this.peerPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.175 -0400", hash_original_method = "97EAFF51EEE94208DA244D522468157C", hash_generated_method = "341177A5568541B4FA8861E4F1111024")
    public InetAddress getPeerPacketSourceAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_743230657 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_743230657 = this.peerAddress;
        varB4EAC82CA7396A68D541C85D26508E83_743230657.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_743230657;
        // ---------- Original Method ----------
        //return this.peerAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.176 -0400", hash_original_method = "57D47F2F9FCDF87C613C3BEA50BCDEDC", hash_generated_method = "6C8BEF1320961A37C361D2D367B1F227")
    public boolean isSecure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1955634642 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1955634642;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.176 -0400", hash_original_method = "17DB109E74C9C419B95A49BDAE918BA7", hash_generated_method = "58C9BB24EBB7523196DDC479C0D53915")
    public void setHandshakeCompletedListener(
            HandshakeCompletedListener handshakeCompletedListenerImpl) {
        this.handshakeCompletedListener = handshakeCompletedListenerImpl;
        // ---------- Original Method ----------
        //this.handshakeCompletedListener = handshakeCompletedListenerImpl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.177 -0400", hash_original_method = "6CFE0616A7B6D8A833DC048924F270CA", hash_generated_method = "A94A6A1596C583D5398E364096224DF6")
    public HandshakeCompletedListenerImpl getHandshakeCompletedListener() {
        HandshakeCompletedListenerImpl varB4EAC82CA7396A68D541C85D26508E83_344359979 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_344359979 = (HandshakeCompletedListenerImpl) handshakeCompletedListener;
        varB4EAC82CA7396A68D541C85D26508E83_344359979.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_344359979;
        // ---------- Original Method ----------
        //return (HandshakeCompletedListenerImpl) handshakeCompletedListener;
    }

    
}

