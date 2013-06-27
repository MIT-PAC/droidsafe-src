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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.897 -0400", hash_original_field = "52CA6755165FFD50983D257A0F1E043B", hash_generated_field = "F3B00F7E70704D963CC4197CD003FB94")

    private Socket mySock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.897 -0400", hash_original_field = "8C35693B192604DA4AB63AD19D48096F", hash_generated_field = "152EC54D2111EF26096DF65FC2003536")

    private PipelinedMsgParser myParser;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.897 -0400", hash_original_field = "0EDD5FF84F2278A8C37689A050537727", hash_generated_field = "E9FA88EF5BFDD4D9156AADE5BC087A4C")

    private InputStream myClientInputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.898 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "2E3018221E30480EB0F957E72002C7D8")

    private String key;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.898 -0400", hash_original_field = "1AC7B394035E343F285A6A4ED1096126", hash_generated_field = "F8E96F7362B3E7CD3DE3A2778DC87A58")

    protected boolean isCached;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.898 -0400", hash_original_field = "39044C41F340C67BFA15E91CC6E98E7D", hash_generated_field = "911E18F9BE05473489F5F21C894DF579")

    protected boolean isRunning;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.898 -0400", hash_original_field = "9842605C72E3BC73DA5398CE4B5EB840", hash_generated_field = "8890F3B68DD2F65EEDEBEEF6284B3EE1")

    private Thread mythread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.898 -0400", hash_original_field = "AA48C74491DE12FAB31F14F04DE0F567", hash_generated_field = "DEE18A414D72F7D580E73EF519B5B75F")

    private String myAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.915 -0400", hash_original_field = "AB99FC537949F4680FB25A11A38B0042", hash_generated_field = "1FBEE69CBCB5E71F900C5C964DA7ADBD")

    private int myPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.915 -0400", hash_original_field = "D7FA5E7DC9BACC5016B81E35D44D1C5F", hash_generated_field = "DB2440387A41D5016778DA700632E003")

    private InetAddress peerAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.915 -0400", hash_original_field = "BBD5741C4F9994864582D25DD194C4DE", hash_generated_field = "FE74A5BA5CFBB5B6DC2B68FEFA76ECFC")

    private int peerPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.915 -0400", hash_original_field = "EDB6E8FD971C3E6879E1A00995BCB702", hash_generated_field = "EB665B7537D07145A6FCAD2DB460EADC")

    private String peerProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.915 -0400", hash_original_field = "8A2A02C2F7B9C43A9E25E5C24EA3F0F6", hash_generated_field = "5A3C22CB6AA628C04F88A4A28D40ED17")

    private TLSMessageProcessor tlsMessageProcessor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.915 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "ABE627693A01BDDC6597F9AB66B3018E")

    private SIPTransactionStack sipStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.915 -0400", hash_original_field = "7B8AE7FFC44A9C7B49E7C7EA6A6D3757", hash_generated_field = "12E7910E7EDE55EAF4A3D89EE23A6BC7")

    private HandshakeCompletedListener handshakeCompletedListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.917 -0400", hash_original_method = "358EB7732CC002B4969C64CA3912C6FF", hash_generated_method = "09B820E27371167CC98310A94C30AD46")
    protected  TLSMessageChannel(Socket sock, SIPTransactionStack sipStack,
            TLSMessageProcessor msgProcessor) throws IOException {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_976895875 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.925 -0400", hash_original_method = "36AC589476275C6F111789614D727487", hash_generated_method = "F5A46D96601021C40B489BDA68BEE204")
    protected  TLSMessageChannel(InetAddress inetAddr, int port, SIPTransactionStack sipStack,
            TLSMessageProcessor messageProcessor) throws IOException {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_35439303 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.938 -0400", hash_original_method = "16D0E6CF226A4618D75D1B422CC8FCDF", hash_generated_method = "4B72F02EA1EFD3C8C87FD7744A6B8891")
    public boolean isReliable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_83102518 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_83102518;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.938 -0400", hash_original_method = "9757D034E975DAF9D22BACDE50FF4335", hash_generated_method = "8F98CB807142DBCC861FF202A306C98D")
    public void close() {
        try 
        {
            mySock.close();
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_557183895 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Closing message Channel " + this);
            } //End collapsed parenthetic
        } //End block
        catch (IOException ex)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_280980315 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.939 -0400", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "4A788F968438089B1C2F9015F48B688D")
    public SIPTransactionStack getSIPStack() {
        SIPTransactionStack varB4EAC82CA7396A68D541C85D26508E83_955444644 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_955444644 = sipStack;
        varB4EAC82CA7396A68D541C85D26508E83_955444644.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_955444644;
        // ---------- Original Method ----------
        //return sipStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.939 -0400", hash_original_method = "00B4B3FBB10028B216605159EFB81D52", hash_generated_method = "8723408778B46D97E3AFFB13BD2A20A6")
    public String getTransport() {
        String varB4EAC82CA7396A68D541C85D26508E83_2009879157 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2009879157 = "tls";
        varB4EAC82CA7396A68D541C85D26508E83_2009879157.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2009879157;
        // ---------- Original Method ----------
        //return "tls";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.940 -0400", hash_original_method = "59CC467573DB54CDCEF540AE63F43735", hash_generated_method = "F62F7E85534F36CE6FB1070881AC4281")
    public String getPeerAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_1886282478 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_63009007 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1886282478 = peerAddress.getHostAddress();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_63009007 = getHost();
        String varA7E53CE21691AB073D9660D615818899_374007535; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_374007535 = varB4EAC82CA7396A68D541C85D26508E83_1886282478;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_374007535 = varB4EAC82CA7396A68D541C85D26508E83_63009007;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_374007535.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_374007535;
        // ---------- Original Method ----------
        //if (peerAddress != null) {
            //return peerAddress.getHostAddress();
        //} else
            //return getHost();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.949 -0400", hash_original_method = "1F29EC3BC94C3E0863F530FCD37A61F3", hash_generated_method = "2BEDF33BE0D648142628D758F9121F23")
    protected InetAddress getPeerInetAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1568813679 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1568813679 = peerAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1568813679.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1568813679;
        // ---------- Original Method ----------
        //return peerAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.950 -0400", hash_original_method = "DB79607DA3ACB5FA2D24428DF2713F98", hash_generated_method = "AFDB233F622E936ADB2F5DABE2CA56F3")
    public String getPeerProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_1064864646 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1064864646 = this.peerProtocol;
        varB4EAC82CA7396A68D541C85D26508E83_1064864646.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1064864646;
        // ---------- Original Method ----------
        //return this.peerProtocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.951 -0400", hash_original_method = "769119032395AFB8B9E88BC54405133A", hash_generated_method = "858E345A45BD6D8FF4A9FC20DF7C07DF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.967 -0400", hash_original_method = "99193C77E68A5ABE715A7A9AC8040C34", hash_generated_method = "9341D968BA900D8F2C73AB88C5864158")
    public void sendMessage(SIPMessage sipMessage) throws IOException {
        byte[] msg;
        msg = sipMessage.encodeAsBytes(this.getTransport());
        long time;
        time = System.currentTimeMillis();
        this.sendMessage(msg, sipMessage instanceof SIPRequest);
        {
            boolean var53DEB6CBCADF9510253D9D22204998C3_226166686 = (this.sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.968 -0400", hash_original_method = "C6D6B3579ACFAA2466286D67BFFE3003", hash_generated_method = "A9714A1617B2C74B10EAA47EAA8CC391")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.970 -0400", hash_original_method = "F10EA794C47048E710B5CED57C611CE1", hash_generated_method = "309AC6B4B5F2322723FF4437EB8C2354")
    public void handleException(ParseException ex, SIPMessage sipMessage, Class hdrClass,
            String header, String message) throws ParseException {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1644514477 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logException(ex);
        } //End collapsed parenthetic
        {
            boolean var4AF4DF15E5A9AA725DAB2E0A6B114A9C_593740691 = ((hdrClass != null)
                && (hdrClass.equals(From.class) || hdrClass.equals(To.class)
                        || hdrClass.equals(CSeq.class) || hdrClass.equals(Via.class)
                        || hdrClass.equals(CallID.class) || hdrClass.equals(RequestLine.class) || hdrClass
                        .equals(StatusLine.class)));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1152935688 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logDebug("Encountered bad message \n" + message);
                } //End collapsed parenthetic
                String msgString;
                msgString = sipMessage.toString();
                {
                    boolean varD14AB56EAEC4527AFDDBDB5F15852E6F_173169444 = (!msgString.startsWith("SIP/") && !msgString.startsWith("ACK "));
                    {
                        String badReqRes;
                        badReqRes = createBadReqRes(msgString, ex);
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_27335032 = (sipStack.isLoggingEnabled());
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
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1361753318 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.973 -0400", hash_original_method = "0B661C1775BD5742177C9AA146CAD19A", hash_generated_method = "316B6EAC6229ED817D1DDB04C3DBFC0D")
    public void processMessage(SIPMessage sipMessage) throws Exception {
        try 
        {
            {
                boolean var75ACC6F471BB1A68962D9AE1797FBD7B_197293913 = (sipMessage.getFrom() == null || sipMessage.getTo() == null
                    || sipMessage.getCallId() == null || sipMessage.getCSeq() == null
                    || sipMessage.getViaHeaders() == null);
                {
                    String badmsg;
                    badmsg = sipMessage.encode();
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_258715930 = (sipStack.isLoggingEnabled());
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
                        boolean var07142A8EFF3EF4AD30BCBC85CFE5B232_119220538 = (v.hasParameter(Via.RPORT)
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
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_855923879 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug("----Processing Message---");
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var329151020C352D7210D49BED1EED92B4_1791789902 = (this.sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES));
                    {
                        sipStack.serverLogger.logMessage(sipMessage, this.getPeerHostPort().toString(),
                            this.messageProcessor.getIpAddress().getHostAddress() + ":"
                                    + this.messageProcessor.getPort(), false, receptionTime);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varBFE4F5560E1DAE5D9C4B756065954E9B_1013100630 = (sipStack.getMaxMessageSize() > 0
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
                                boolean varD802744989A665132B75B392ADE40209_1758778515 = (!sipServerTx.passToListener());
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
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1642250383 = (sipStack.isLoggingEnabled());
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
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_155915285 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger()
                                .logError("Dropping Badly formatted response message >>> "
                                        + sipResponse);
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var13C0D42D19654498AAF89BA284743FD1_431116724 = (sipStack.getMaxMessageSize() > 0
                        && sipResponse.getSize()
                                + (sipResponse.getContentLength() == null ? 0 : sipResponse
                                        .getContentLength().getContentLength()) > sipStack
                                .getMaxMessageSize()); //DSFIXME:  CODE0008: Nested ternary operator in expression
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_389043053 = (sipStack.isLoggingEnabled());
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
                            boolean var7B7EDCF7240C6ECDC5603DF13532F268_111834242 = (sipServerResponse instanceof SIPClientTransaction
                                && !((SIPClientTransaction) sipServerResponse)
                                        .checkFromTag(sipResponse));
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_887950331 = (sipStack.isLoggingEnabled());
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
                            boolean varDB4FC2DFFC674AF9290D5BD5A8705AB9_1096938258 = (sipServerResponse instanceof SIPTransaction
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.010 -0400", hash_original_method = "F77124F9292782877CB3E3F72C9E9606", hash_generated_method = "226E17326F2FC0179E1DC64B6C227A52")
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
                            boolean var2AB968A8303910EE00F810B6DE3410F9_584015410 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.017 -0400", hash_original_method = "C5292C7D09796AA7B556BAA154B95B16", hash_generated_method = "4846BBE21700A1CEFFBC05D2CDF13274")
    protected void uncache() {
        {
            this.tlsMessageProcessor.remove(this);
        } //End block
        // ---------- Original Method ----------
        //if (isCached && !isRunning) {    	
    		//this.tlsMessageProcessor.remove(this);
    	//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.017 -0400", hash_original_method = "DA67C78A7E91B7C25B2E6DD841A2A96C", hash_generated_method = "FEF9F010F52C9F270A7FD4F262D8CF0D")
    public boolean equals(Object other) {
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_501862821 = (!this.getClass().equals(other.getClass()));
            {
                TLSMessageChannel that;
                that = (TLSMessageChannel) other;
            } //End block
        } //End collapsed parenthetic
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1802809301 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1802809301;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.019 -0400", hash_original_method = "1173AC840F0483E84550BBD280ADF1B8", hash_generated_method = "51D18CAA94C85C3CF526F80072AC8EA3")
    public String getKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_261971338 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_899282712 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_261971338 = this.key;
        } //End block
        {
            this.key = MessageChannel.getKey(this.peerAddress, this.peerPort, "TLS");
            varB4EAC82CA7396A68D541C85D26508E83_899282712 = this.key;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_957671258; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_957671258 = varB4EAC82CA7396A68D541C85D26508E83_261971338;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_957671258 = varB4EAC82CA7396A68D541C85D26508E83_899282712;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_957671258.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_957671258;
        // ---------- Original Method ----------
        //if (this.key != null) {
            //return this.key;
        //} else {
            //this.key = MessageChannel.getKey(this.peerAddress, this.peerPort, "TLS");
            //return this.key;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.024 -0400", hash_original_method = "11E5C6A8F9691D7C5E18B4FE0A22A301", hash_generated_method = "B6B2C5C81F73A1FE1890C57F8F933174")
    public String getViaHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_988173590 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_988173590 = myAddress;
        varB4EAC82CA7396A68D541C85D26508E83_988173590.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_988173590;
        // ---------- Original Method ----------
        //return myAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.025 -0400", hash_original_method = "97574FAF366AF2CA74D034931ECBD71B", hash_generated_method = "FE004B04579AA6A337992D3BD567AC0F")
    public int getViaPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1025774076 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1025774076;
        // ---------- Original Method ----------
        //return myPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.025 -0400", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "F5F79D431C17E8EB9269C53D133B02B4")
    public int getPeerPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2077639758 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2077639758;
        // ---------- Original Method ----------
        //return peerPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.025 -0400", hash_original_method = "B210BD4A713B5B982D229CB138437A53", hash_generated_method = "4684CC1B3051C7CB8EA0E4DF9DA5CFB3")
    public int getPeerPacketSourcePort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_786553445 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_786553445;
        // ---------- Original Method ----------
        //return this.peerPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.035 -0400", hash_original_method = "97EAFF51EEE94208DA244D522468157C", hash_generated_method = "55523722B1AF252230EC222C9205663E")
    public InetAddress getPeerPacketSourceAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_590333325 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_590333325 = this.peerAddress;
        varB4EAC82CA7396A68D541C85D26508E83_590333325.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_590333325;
        // ---------- Original Method ----------
        //return this.peerAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.035 -0400", hash_original_method = "57D47F2F9FCDF87C613C3BEA50BCDEDC", hash_generated_method = "8DFBAFA26523C67489A783085BB658D4")
    public boolean isSecure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_166585731 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_166585731;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.035 -0400", hash_original_method = "17DB109E74C9C419B95A49BDAE918BA7", hash_generated_method = "58C9BB24EBB7523196DDC479C0D53915")
    public void setHandshakeCompletedListener(
            HandshakeCompletedListener handshakeCompletedListenerImpl) {
        this.handshakeCompletedListener = handshakeCompletedListenerImpl;
        // ---------- Original Method ----------
        //this.handshakeCompletedListener = handshakeCompletedListenerImpl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.036 -0400", hash_original_method = "6CFE0616A7B6D8A833DC048924F270CA", hash_generated_method = "3251BAD55C6C6394C222513DB063DF2D")
    public HandshakeCompletedListenerImpl getHandshakeCompletedListener() {
        HandshakeCompletedListenerImpl varB4EAC82CA7396A68D541C85D26508E83_1651064789 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1651064789 = (HandshakeCompletedListenerImpl) handshakeCompletedListener;
        varB4EAC82CA7396A68D541C85D26508E83_1651064789.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1651064789;
        // ---------- Original Method ----------
        //return (HandshakeCompletedListenerImpl) handshakeCompletedListener;
    }

    
}

