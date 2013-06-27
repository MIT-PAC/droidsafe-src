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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.437 -0400", hash_original_field = "52CA6755165FFD50983D257A0F1E043B", hash_generated_field = "F3B00F7E70704D963CC4197CD003FB94")

    private Socket mySock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.437 -0400", hash_original_field = "8C35693B192604DA4AB63AD19D48096F", hash_generated_field = "152EC54D2111EF26096DF65FC2003536")

    private PipelinedMsgParser myParser;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.438 -0400", hash_original_field = "0EDD5FF84F2278A8C37689A050537727", hash_generated_field = "5631DED65C3B5D9167CB9D9A47D5D03A")

    protected InputStream myClientInputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.438 -0400", hash_original_field = "8D01696ED532963D851C7717792CB333", hash_generated_field = "7FAB60C2DCAEF3BF5FBD0260A9FAB955")

    protected OutputStream myClientOutputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.438 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "32361AD5112AD88D374E45078833A152")

    protected String key;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.438 -0400", hash_original_field = "1AC7B394035E343F285A6A4ED1096126", hash_generated_field = "F8E96F7362B3E7CD3DE3A2778DC87A58")

    protected boolean isCached;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.438 -0400", hash_original_field = "39044C41F340C67BFA15E91CC6E98E7D", hash_generated_field = "911E18F9BE05473489F5F21C894DF579")

    protected boolean isRunning;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.438 -0400", hash_original_field = "9842605C72E3BC73DA5398CE4B5EB840", hash_generated_field = "8890F3B68DD2F65EEDEBEEF6284B3EE1")

    private Thread mythread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.438 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "3233C5012C49C796F9D6BBC8E02EAB41")

    protected SIPTransactionStack sipStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.438 -0400", hash_original_field = "AA48C74491DE12FAB31F14F04DE0F567", hash_generated_field = "52302EBB56B387342DED9EB749307DE1")

    protected String myAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.438 -0400", hash_original_field = "AB99FC537949F4680FB25A11A38B0042", hash_generated_field = "AD61806C610E09EDA888D5EC477B22F2")

    protected int myPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.438 -0400", hash_original_field = "D7FA5E7DC9BACC5016B81E35D44D1C5F", hash_generated_field = "5F6E05F1C4EB951C3527127A288505CA")

    protected InetAddress peerAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.438 -0400", hash_original_field = "BBD5741C4F9994864582D25DD194C4DE", hash_generated_field = "6A69B321E52130622ADD35A2A3F00BA6")

    protected int peerPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.438 -0400", hash_original_field = "EDB6E8FD971C3E6879E1A00995BCB702", hash_generated_field = "FBF73E4EC3FC246E9E63B41E9D9708E4")

    protected String peerProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.438 -0400", hash_original_field = "3F76902303B4A9F0BE6E5268A619EBF6", hash_generated_field = "5B259E81F7C4616BF3121004579047E4")

    private TCPMessageProcessor tcpMessageProcessor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.439 -0400", hash_original_method = "A2B275A41CF549D2A1285292B7E5107C", hash_generated_method = "1B936302B48EAC3381B05CB0C4A70DD8")
    protected  TCPMessageChannel(SIPTransactionStack sipStack) {
        this.sipStack = sipStack;
        // ---------- Original Method ----------
        //this.sipStack = sipStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.441 -0400", hash_original_method = "5A50CDCBFA2341437DDE39E7C9C5EE35", hash_generated_method = "E1DFA210142374FD81C73F98E7C653DD")
    protected  TCPMessageChannel(Socket sock, SIPTransactionStack sipStack,
            TCPMessageProcessor msgProcessor) throws IOException {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_652139263 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("creating new TCPMessageChannel ");
                sipStack.getStackLogger().logStackTrace();
            } //End block
        } //End collapsed parenthetic
        mySock = sock;
        peerAddress = mySock.getInetAddress();
        myAddress = msgProcessor.getIpAddress().getHostAddress();
        myClientInputStream = mySock.getInputStream();
        myClientOutputStream = mySock.getOutputStream();
        mythread = new Thread(this);
        mythread.setDaemon(true);
        mythread.setName("TCPMessageChannelThread");
        this.sipStack = sipStack;
        this.peerPort = mySock.getPort();
        this.tcpMessageProcessor = msgProcessor;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.443 -0400", hash_original_method = "C53C1DE79ECD9DAACE8708608E931C74", hash_generated_method = "8E3A4038B325E957E06A27C3B8738F1D")
    protected  TCPMessageChannel(InetAddress inetAddr, int port, SIPTransactionStack sipStack,
            TCPMessageProcessor messageProcessor) throws IOException {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1989976684 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("creating new TCPMessageChannel ");
                sipStack.getStackLogger().logStackTrace();
            } //End block
        } //End collapsed parenthetic
        this.peerAddress = inetAddr;
        this.peerPort = port;
        this.myPort = messageProcessor.getPort();
        this.peerProtocol = "TCP";
        this.sipStack = sipStack;
        this.tcpMessageProcessor = messageProcessor;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.444 -0400", hash_original_method = "16D0E6CF226A4618D75D1B422CC8FCDF", hash_generated_method = "B46819D4AAC3CA1C2EDB03184D3455C7")
    public boolean isReliable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1576563710 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1576563710;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.444 -0400", hash_original_method = "D9B233459FD7A72AC548D3BF0383246D", hash_generated_method = "A69DB7B5C73C37A0572240E86B30513E")
    public void close() {
        try 
        {
            {
                mySock.close();
                mySock = null;
            } //End block
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1758254824 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Closing message Channel " + this);
            } //End collapsed parenthetic
        } //End block
        catch (IOException ex)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_316474375 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.445 -0400", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "53FAD5DB86725940FA23C8E36C05A22D")
    public SIPTransactionStack getSIPStack() {
        SIPTransactionStack varB4EAC82CA7396A68D541C85D26508E83_1028781412 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1028781412 = sipStack;
        varB4EAC82CA7396A68D541C85D26508E83_1028781412.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1028781412;
        // ---------- Original Method ----------
        //return sipStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.445 -0400", hash_original_method = "0D1837A773C1185791E8B7504B01CB2E", hash_generated_method = "E73C513564D99A4A554AC3F07FB59A02")
    public String getTransport() {
        String varB4EAC82CA7396A68D541C85D26508E83_1433877419 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1433877419 = "TCP";
        varB4EAC82CA7396A68D541C85D26508E83_1433877419.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1433877419;
        // ---------- Original Method ----------
        //return "TCP";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.446 -0400", hash_original_method = "59CC467573DB54CDCEF540AE63F43735", hash_generated_method = "23D6890089C6E1C0D9E23267CDF78B71")
    public String getPeerAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_1809805118 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_921941326 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1809805118 = peerAddress.getHostAddress();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_921941326 = getHost();
        String varA7E53CE21691AB073D9660D615818899_411683935; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_411683935 = varB4EAC82CA7396A68D541C85D26508E83_1809805118;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_411683935 = varB4EAC82CA7396A68D541C85D26508E83_921941326;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_411683935.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_411683935;
        // ---------- Original Method ----------
        //if (peerAddress != null) {
            //return peerAddress.getHostAddress();
        //} else
            //return getHost();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.448 -0400", hash_original_method = "1F29EC3BC94C3E0863F530FCD37A61F3", hash_generated_method = "5BC7E9E84BDE70A1966C3472D74310B5")
    protected InetAddress getPeerInetAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1232826506 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1232826506 = peerAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1232826506.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1232826506;
        // ---------- Original Method ----------
        //return peerAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.450 -0400", hash_original_method = "DB79607DA3ACB5FA2D24428DF2713F98", hash_generated_method = "3DAC915EEFB515AF282D2686EE61A081")
    public String getPeerProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_1427248652 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1427248652 = this.peerProtocol;
        varB4EAC82CA7396A68D541C85D26508E83_1427248652.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1427248652;
        // ---------- Original Method ----------
        //return this.peerProtocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.451 -0400", hash_original_method = "3044E621F64D9746C61861BC2D15D7B8", hash_generated_method = "E3638F4206EB9C183351370BAC0FA7FC")
    private void sendMessage(byte[] msg, boolean retry) throws IOException {
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
        addTaint(msg[0]);
        addTaint(retry);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.452 -0400", hash_original_method = "05F3A695AC32E3040A89EFF8F81F947F", hash_generated_method = "F825BF4B7B8F33A8311AD1C11DC6AA5F")
    public void sendMessage(SIPMessage sipMessage) throws IOException {
        byte[] msg;
        msg = sipMessage.encodeAsBytes(this.getTransport());
        long time;
        time = System.currentTimeMillis();
        this.sendMessage(msg, true);
        {
            boolean var53DEB6CBCADF9510253D9D22204998C3_266584569 = (this.sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES));
            logMessage(sipMessage, peerAddress, peerPort, time);
        } //End collapsed parenthetic
        addTaint(sipMessage.getTaint());
        // ---------- Original Method ----------
        //byte[] msg = sipMessage.encodeAsBytes(this.getTransport());
        //long time = System.currentTimeMillis();
        //this.sendMessage(msg, true);
        //if (this.sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES))
            //logMessage(sipMessage, peerAddress, peerPort, time);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.460 -0400", hash_original_method = "089EEE36759D74C41252D6311E4E6671", hash_generated_method = "EB3E2B8AE0010C52D282D24A0175D1CC")
    public void sendMessage(byte message[], InetAddress receiverAddress, int receiverPort,
            boolean retry) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Null argument");
        Socket sock;
        sock = this.sipStack.ioHandler.sendBytes(this.messageProcessor.getIpAddress(),
                receiverAddress, receiverPort, "TCP", message, retry, this);
        {
            {
                sipStack.getTimer().schedule(new TimerTask() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.456 -0400", hash_original_method = "73BB2678B4D3B10E0EB61D0433282932", hash_generated_method = "7D21C700FDD4920BD65C43B1217CE037")
                    @Override
                    public boolean cancel() {
                        try 
                        {
                            mySock.close();
                            super.cancel();
                        } //End block
                        catch (IOException ex)
                        { }
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_496616678 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_496616678;
                        // ---------- Original Method ----------
                        //try {
                            //mySock.close();
                            //super.cancel();
                        //} catch (IOException ex) {
                        //}
                        //return true;
                    }
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.459 -0400", hash_original_method = "1800F2338CC81B9692B7DA0DF6DF5AE0", hash_generated_method = "387B19C1830DE243C8CB852FA2680BDB")
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
        addTaint(message);
        addTaint(receiverAddress.getTaint());
        addTaint(receiverPort);
        addTaint(retry);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.461 -0400", hash_original_method = "10E78FE9041FD1B7C26A106A739E4ED8", hash_generated_method = "2609550A95DF454F090C9E64F3AF58A4")
    public void handleException(ParseException ex, SIPMessage sipMessage, Class hdrClass,
            String header, String message) throws ParseException {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_2137541813 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logException(ex);
        } //End collapsed parenthetic
        {
            boolean var4AF4DF15E5A9AA725DAB2E0A6B114A9C_1546506336 = ((hdrClass != null)
                && (hdrClass.equals(From.class) || hdrClass.equals(To.class)
                        || hdrClass.equals(CSeq.class) || hdrClass.equals(Via.class)
                        || hdrClass.equals(CallID.class) || hdrClass.equals(RequestLine.class) || hdrClass
                        .equals(StatusLine.class)));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_934378357 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug(
                        "Encountered Bad Message \n" + sipMessage.toString());
                    } //End block
                } //End collapsed parenthetic
                String msgString;
                msgString = sipMessage.toString();
                {
                    boolean varD14AB56EAEC4527AFDDBDB5F15852E6F_2064340141 = (!msgString.startsWith("SIP/") && !msgString.startsWith("ACK "));
                    {
                        String badReqRes;
                        badReqRes = createBadReqRes(msgString, ex);
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_350954611 = (sipStack.isLoggingEnabled());
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
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_363963264 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.476 -0400", hash_original_method = "688E2F52AD2D71AD93C4E5B7CEC68AD5", hash_generated_method = "3022E17528F92EBC873B485DA9E4D0CA")
    public void processMessage(SIPMessage sipMessage) throws Exception {
        try 
        {
            {
                boolean varB9F954BFA525F3DD48043E6E9EFACC67_716449441 = (sipMessage.getFrom() == null
                    || 
                    sipMessage.getTo() == null || sipMessage.getCallId() == null
                    || sipMessage.getCSeq() == null || sipMessage.getViaHeaders() == null);
                {
                    String badmsg;
                    badmsg = sipMessage.encode();
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1243121348 = (sipStack.isLoggingEnabled());
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
                        boolean var07142A8EFF3EF4AD30BCBC85CFE5B232_1780080789 = (v.hasParameter(Via.RPORT)
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
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_163842644 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug("----Processing Message---");
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var329151020C352D7210D49BED1EED92B4_639180478 = (this.sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES));
                    {
                        sipStack.serverLogger.logMessage(sipMessage, this.getPeerHostPort().toString(),
                            this.getMessageProcessor().getIpAddress().getHostAddress() + ":"
                                    + this.getMessageProcessor().getPort(), false, receptionTime);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varBFE4F5560E1DAE5D9C4B756065954E9B_1959255914 = (sipStack.getMaxMessageSize() > 0
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
                                boolean varD802744989A665132B75B392ADE40209_1638318608 = (!sipServerTx.passToListener());
                                ((SIPTransaction) sipServerRequest).releaseSem();
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End block
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1710250223 = (sipStack.isLoggingEnabled());
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
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_730171656 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger()
                                .logError("Dropping Badly formatted response message >>> "
                                        + sipResponse);
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var13C0D42D19654498AAF89BA284743FD1_812059972 = (sipStack.getMaxMessageSize() > 0
                        && sipResponse.getSize()
                                + (sipResponse.getContentLength() == null ? 0 : sipResponse
                                        .getContentLength().getContentLength()) > sipStack
                                .getMaxMessageSize()); //DSFIXME:  CODE0008: Nested ternary operator in expression
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_945543193 = (sipStack.isLoggingEnabled());
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
                            boolean var7B7EDCF7240C6ECDC5603DF13532F268_1957317927 = (sipServerResponse instanceof SIPClientTransaction
                                && !((SIPClientTransaction) sipServerResponse)
                                        .checkFromTag(sipResponse));
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_1192944002 = (sipStack.isLoggingEnabled());
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
                            boolean varDB4FC2DFFC674AF9290D5BD5A8705AB9_489417236 = (sipServerResponse instanceof SIPTransaction
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
        addTaint(sipMessage.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.490 -0400", hash_original_method = "D4E0A0BC15B98D38AEFE5154BA5871D0", hash_generated_method = "1FBFC8470341EAB70BFAF80EA7876654")
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
                            boolean var2AB968A8303910EE00F810B6DE3410F9_1505789119 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.490 -0400", hash_original_method = "588DDE9A59AB3DB90B101694890D3C99", hash_generated_method = "99D3DCE5DA682319A2B659FFC777497D")
    protected void uncache() {
        {
            this.tcpMessageProcessor.remove(this);
        } //End block
        // ---------- Original Method ----------
        //if (isCached && !isRunning) {
    		//this.tcpMessageProcessor.remove(this);
    	//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.502 -0400", hash_original_method = "A3550F5A4A6E2000221840888A01CA8A", hash_generated_method = "E3B45AA756FBD6A8280A57D65905F65D")
    public boolean equals(Object other) {
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_18834373 = (!this.getClass().equals(other.getClass()));
            {
                TCPMessageChannel that;
                that = (TCPMessageChannel) other;
            } //End block
        } //End collapsed parenthetic
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_53293481 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_53293481;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.503 -0400", hash_original_method = "2DA7D0C3A567190913C90FAF0FAC7F20", hash_generated_method = "F6E2AC9EE5095CBBAD587965B702824E")
    public String getKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_840049905 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_784177111 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_840049905 = this.key;
        } //End block
        {
            this.key = MessageChannel.getKey(this.peerAddress, this.peerPort, "TCP");
            varB4EAC82CA7396A68D541C85D26508E83_784177111 = this.key;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_911577704; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_911577704 = varB4EAC82CA7396A68D541C85D26508E83_840049905;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_911577704 = varB4EAC82CA7396A68D541C85D26508E83_784177111;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_911577704.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_911577704;
        // ---------- Original Method ----------
        //if (this.key != null) {
            //return this.key;
        //} else {
            //this.key = MessageChannel.getKey(this.peerAddress, this.peerPort, "TCP");
            //return this.key;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.504 -0400", hash_original_method = "11E5C6A8F9691D7C5E18B4FE0A22A301", hash_generated_method = "9E7CFEC665C51E34D0F8508FD8A2A463")
    public String getViaHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_631016594 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_631016594 = myAddress;
        varB4EAC82CA7396A68D541C85D26508E83_631016594.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_631016594;
        // ---------- Original Method ----------
        //return myAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.504 -0400", hash_original_method = "97574FAF366AF2CA74D034931ECBD71B", hash_generated_method = "A5E20A84F4DEE03639EFE9AB80843929")
    public int getViaPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_224678955 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_224678955;
        // ---------- Original Method ----------
        //return myPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.504 -0400", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "15D110D1B1060F80F093B1068DB04A43")
    public int getPeerPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_307021564 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_307021564;
        // ---------- Original Method ----------
        //return peerPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.505 -0400", hash_original_method = "B210BD4A713B5B982D229CB138437A53", hash_generated_method = "90DA2A1398800C8010E7F886DDD65EC6")
    public int getPeerPacketSourcePort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_358885157 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_358885157;
        // ---------- Original Method ----------
        //return this.peerPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.511 -0400", hash_original_method = "97EAFF51EEE94208DA244D522468157C", hash_generated_method = "2AE4E92F66AE244187254B9A5EA1BEAF")
    public InetAddress getPeerPacketSourceAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_2062802320 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2062802320 = this.peerAddress;
        varB4EAC82CA7396A68D541C85D26508E83_2062802320.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2062802320;
        // ---------- Original Method ----------
        //return this.peerAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.511 -0400", hash_original_method = "51201694E0EE76265BF39848EF10BE9C", hash_generated_method = "4404D03ECFB9F6B0145BF15E252D090A")
    public boolean isSecure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1165726609 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1165726609;
        // ---------- Original Method ----------
        //return false;
    }

    
}

