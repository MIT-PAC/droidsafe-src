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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.705 -0400", hash_original_field = "52CA6755165FFD50983D257A0F1E043B", hash_generated_field = "F3B00F7E70704D963CC4197CD003FB94")

    private Socket mySock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.705 -0400", hash_original_field = "8C35693B192604DA4AB63AD19D48096F", hash_generated_field = "152EC54D2111EF26096DF65FC2003536")

    private PipelinedMsgParser myParser;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.705 -0400", hash_original_field = "0EDD5FF84F2278A8C37689A050537727", hash_generated_field = "5631DED65C3B5D9167CB9D9A47D5D03A")

    protected InputStream myClientInputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.705 -0400", hash_original_field = "8D01696ED532963D851C7717792CB333", hash_generated_field = "7FAB60C2DCAEF3BF5FBD0260A9FAB955")

    protected OutputStream myClientOutputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.705 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "32361AD5112AD88D374E45078833A152")

    protected String key;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.705 -0400", hash_original_field = "1AC7B394035E343F285A6A4ED1096126", hash_generated_field = "F8E96F7362B3E7CD3DE3A2778DC87A58")

    protected boolean isCached;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.705 -0400", hash_original_field = "39044C41F340C67BFA15E91CC6E98E7D", hash_generated_field = "911E18F9BE05473489F5F21C894DF579")

    protected boolean isRunning;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.705 -0400", hash_original_field = "9842605C72E3BC73DA5398CE4B5EB840", hash_generated_field = "8890F3B68DD2F65EEDEBEEF6284B3EE1")

    private Thread mythread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.705 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "3233C5012C49C796F9D6BBC8E02EAB41")

    protected SIPTransactionStack sipStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.705 -0400", hash_original_field = "AA48C74491DE12FAB31F14F04DE0F567", hash_generated_field = "52302EBB56B387342DED9EB749307DE1")

    protected String myAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.706 -0400", hash_original_field = "AB99FC537949F4680FB25A11A38B0042", hash_generated_field = "AD61806C610E09EDA888D5EC477B22F2")

    protected int myPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.706 -0400", hash_original_field = "D7FA5E7DC9BACC5016B81E35D44D1C5F", hash_generated_field = "5F6E05F1C4EB951C3527127A288505CA")

    protected InetAddress peerAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.706 -0400", hash_original_field = "BBD5741C4F9994864582D25DD194C4DE", hash_generated_field = "6A69B321E52130622ADD35A2A3F00BA6")

    protected int peerPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.706 -0400", hash_original_field = "EDB6E8FD971C3E6879E1A00995BCB702", hash_generated_field = "FBF73E4EC3FC246E9E63B41E9D9708E4")

    protected String peerProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.706 -0400", hash_original_field = "3F76902303B4A9F0BE6E5268A619EBF6", hash_generated_field = "5B259E81F7C4616BF3121004579047E4")

    private TCPMessageProcessor tcpMessageProcessor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.706 -0400", hash_original_method = "A2B275A41CF549D2A1285292B7E5107C", hash_generated_method = "1B936302B48EAC3381B05CB0C4A70DD8")
    protected  TCPMessageChannel(SIPTransactionStack sipStack) {
        this.sipStack = sipStack;
        // ---------- Original Method ----------
        //this.sipStack = sipStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.714 -0400", hash_original_method = "5A50CDCBFA2341437DDE39E7C9C5EE35", hash_generated_method = "0EB633E9AED24365DD015D2552ACDEA2")
    protected  TCPMessageChannel(Socket sock, SIPTransactionStack sipStack,
            TCPMessageProcessor msgProcessor) throws IOException {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_924486060 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.715 -0400", hash_original_method = "C53C1DE79ECD9DAACE8708608E931C74", hash_generated_method = "72AAF3011FE930214EC2328BDA315369")
    protected  TCPMessageChannel(InetAddress inetAddr, int port, SIPTransactionStack sipStack,
            TCPMessageProcessor messageProcessor) throws IOException {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_67016540 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.715 -0400", hash_original_method = "16D0E6CF226A4618D75D1B422CC8FCDF", hash_generated_method = "64C7035B3FD0CAC9C9708944E6B40B23")
    public boolean isReliable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_65462586 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_65462586;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.716 -0400", hash_original_method = "D9B233459FD7A72AC548D3BF0383246D", hash_generated_method = "B88454FCDDBC2BD2FA75E965992BDFB7")
    public void close() {
        try 
        {
            {
                mySock.close();
                mySock = null;
            } //End block
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_516533111 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Closing message Channel " + this);
            } //End collapsed parenthetic
        } //End block
        catch (IOException ex)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_703507741 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.716 -0400", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "0AF4626C48DD4A335EB78CF5207E2707")
    public SIPTransactionStack getSIPStack() {
        SIPTransactionStack varB4EAC82CA7396A68D541C85D26508E83_1678448171 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1678448171 = sipStack;
        varB4EAC82CA7396A68D541C85D26508E83_1678448171.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1678448171;
        // ---------- Original Method ----------
        //return sipStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.728 -0400", hash_original_method = "0D1837A773C1185791E8B7504B01CB2E", hash_generated_method = "15C2E251BF01C6FBCB3EE3CDE031CF6B")
    public String getTransport() {
        String varB4EAC82CA7396A68D541C85D26508E83_230292056 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_230292056 = "TCP";
        varB4EAC82CA7396A68D541C85D26508E83_230292056.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_230292056;
        // ---------- Original Method ----------
        //return "TCP";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.729 -0400", hash_original_method = "59CC467573DB54CDCEF540AE63F43735", hash_generated_method = "000B4F2455D67F6107162AE37E0ACF92")
    public String getPeerAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_118024096 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_970833551 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_118024096 = peerAddress.getHostAddress();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_970833551 = getHost();
        String varA7E53CE21691AB073D9660D615818899_1941034869; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1941034869 = varB4EAC82CA7396A68D541C85D26508E83_118024096;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1941034869 = varB4EAC82CA7396A68D541C85D26508E83_970833551;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1941034869.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1941034869;
        // ---------- Original Method ----------
        //if (peerAddress != null) {
            //return peerAddress.getHostAddress();
        //} else
            //return getHost();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.729 -0400", hash_original_method = "1F29EC3BC94C3E0863F530FCD37A61F3", hash_generated_method = "C030F4AF476258A901DC2C44A891D3A9")
    protected InetAddress getPeerInetAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1961868868 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1961868868 = peerAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1961868868.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1961868868;
        // ---------- Original Method ----------
        //return peerAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.730 -0400", hash_original_method = "DB79607DA3ACB5FA2D24428DF2713F98", hash_generated_method = "5879ABE2617886790A345847ACC847FA")
    public String getPeerProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_1878791149 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1878791149 = this.peerProtocol;
        varB4EAC82CA7396A68D541C85D26508E83_1878791149.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1878791149;
        // ---------- Original Method ----------
        //return this.peerProtocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.730 -0400", hash_original_method = "3044E621F64D9746C61861BC2D15D7B8", hash_generated_method = "E3638F4206EB9C183351370BAC0FA7FC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.731 -0400", hash_original_method = "05F3A695AC32E3040A89EFF8F81F947F", hash_generated_method = "B96688B21EF17A7C65F5DE098FADDA4A")
    public void sendMessage(SIPMessage sipMessage) throws IOException {
        byte[] msg;
        msg = sipMessage.encodeAsBytes(this.getTransport());
        long time;
        time = System.currentTimeMillis();
        this.sendMessage(msg, true);
        {
            boolean var53DEB6CBCADF9510253D9D22204998C3_1104818263 = (this.sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.732 -0400", hash_original_method = "089EEE36759D74C41252D6311E4E6671", hash_generated_method = "C76497DF5EA739D93859BC5970791EC2")
    public void sendMessage(byte message[], InetAddress receiverAddress, int receiverPort,
            boolean retry) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Null argument");
        Socket sock;
        sock = this.sipStack.ioHandler.sendBytes(this.messageProcessor.getIpAddress(),
                receiverAddress, receiverPort, "TCP", message, retry, this);
        {
            {
                sipStack.getTimer().schedule(new TimerTask() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.732 -0400", hash_original_method = "73BB2678B4D3B10E0EB61D0433282932", hash_generated_method = "2FCAF9D14A76C659A49FBF3FD78D0ED9")
                    @Override
                    public boolean cancel() {
                        try 
                        {
                            mySock.close();
                            super.cancel();
                        } //End block
                        catch (IOException ex)
                        { }
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1672965373 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1672965373;
                        // ---------- Original Method ----------
                        //try {
                            //mySock.close();
                            //super.cancel();
                        //} catch (IOException ex) {
                        //}
                        //return true;
                    }
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.732 -0400", hash_original_method = "1800F2338CC81B9692B7DA0DF6DF5AE0", hash_generated_method = "387B19C1830DE243C8CB852FA2680BDB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.751 -0400", hash_original_method = "10E78FE9041FD1B7C26A106A739E4ED8", hash_generated_method = "2B2535E464D9248C8F063943FA3037B0")
    public void handleException(ParseException ex, SIPMessage sipMessage, Class hdrClass,
            String header, String message) throws ParseException {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_563891219 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logException(ex);
        } //End collapsed parenthetic
        {
            boolean var4AF4DF15E5A9AA725DAB2E0A6B114A9C_816570670 = ((hdrClass != null)
                && (hdrClass.equals(From.class) || hdrClass.equals(To.class)
                        || hdrClass.equals(CSeq.class) || hdrClass.equals(Via.class)
                        || hdrClass.equals(CallID.class) || hdrClass.equals(RequestLine.class) || hdrClass
                        .equals(StatusLine.class)));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_920540012 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug(
                        "Encountered Bad Message \n" + sipMessage.toString());
                    } //End block
                } //End collapsed parenthetic
                String msgString;
                msgString = sipMessage.toString();
                {
                    boolean varD14AB56EAEC4527AFDDBDB5F15852E6F_1986531718 = (!msgString.startsWith("SIP/") && !msgString.startsWith("ACK "));
                    {
                        String badReqRes;
                        badReqRes = createBadReqRes(msgString, ex);
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1465696261 = (sipStack.isLoggingEnabled());
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
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1249318731 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.764 -0400", hash_original_method = "688E2F52AD2D71AD93C4E5B7CEC68AD5", hash_generated_method = "C74A7C32F734079BCE1B1D7279F9A1DE")
    public void processMessage(SIPMessage sipMessage) throws Exception {
        try 
        {
            {
                boolean varB9F954BFA525F3DD48043E6E9EFACC67_1930192064 = (sipMessage.getFrom() == null
                    || 
                    sipMessage.getTo() == null || sipMessage.getCallId() == null
                    || sipMessage.getCSeq() == null || sipMessage.getViaHeaders() == null);
                {
                    String badmsg;
                    badmsg = sipMessage.encode();
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1682398905 = (sipStack.isLoggingEnabled());
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
                        boolean var07142A8EFF3EF4AD30BCBC85CFE5B232_504454346 = (v.hasParameter(Via.RPORT)
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
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1826271930 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug("----Processing Message---");
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var329151020C352D7210D49BED1EED92B4_1793617320 = (this.sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES));
                    {
                        sipStack.serverLogger.logMessage(sipMessage, this.getPeerHostPort().toString(),
                            this.getMessageProcessor().getIpAddress().getHostAddress() + ":"
                                    + this.getMessageProcessor().getPort(), false, receptionTime);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varBFE4F5560E1DAE5D9C4B756065954E9B_1645272488 = (sipStack.getMaxMessageSize() > 0
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
                                boolean varD802744989A665132B75B392ADE40209_1057799977 = (!sipServerTx.passToListener());
                                ((SIPTransaction) sipServerRequest).releaseSem();
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End block
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1124763627 = (sipStack.isLoggingEnabled());
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
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1056522692 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger()
                                .logError("Dropping Badly formatted response message >>> "
                                        + sipResponse);
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var13C0D42D19654498AAF89BA284743FD1_554940174 = (sipStack.getMaxMessageSize() > 0
                        && sipResponse.getSize()
                                + (sipResponse.getContentLength() == null ? 0 : sipResponse
                                        .getContentLength().getContentLength()) > sipStack
                                .getMaxMessageSize()); //DSFIXME:  CODE0008: Nested ternary operator in expression
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_491283398 = (sipStack.isLoggingEnabled());
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
                            boolean var7B7EDCF7240C6ECDC5603DF13532F268_123153429 = (sipServerResponse instanceof SIPClientTransaction
                                && !((SIPClientTransaction) sipServerResponse)
                                        .checkFromTag(sipResponse));
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_1141235477 = (sipStack.isLoggingEnabled());
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
                            boolean varDB4FC2DFFC674AF9290D5BD5A8705AB9_625353346 = (sipServerResponse instanceof SIPTransaction
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.776 -0400", hash_original_method = "D4E0A0BC15B98D38AEFE5154BA5871D0", hash_generated_method = "F5520D26589E4E58171FF11FDBE52F8F")
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
                            boolean var2AB968A8303910EE00F810B6DE3410F9_1217296987 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.776 -0400", hash_original_method = "588DDE9A59AB3DB90B101694890D3C99", hash_generated_method = "99D3DCE5DA682319A2B659FFC777497D")
    protected void uncache() {
        {
            this.tcpMessageProcessor.remove(this);
        } //End block
        // ---------- Original Method ----------
        //if (isCached && !isRunning) {
    		//this.tcpMessageProcessor.remove(this);
    	//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.777 -0400", hash_original_method = "A3550F5A4A6E2000221840888A01CA8A", hash_generated_method = "1969CC285A371F1C456AA93661BE092A")
    public boolean equals(Object other) {
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_1396844060 = (!this.getClass().equals(other.getClass()));
            {
                TCPMessageChannel that;
                that = (TCPMessageChannel) other;
            } //End block
        } //End collapsed parenthetic
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_29878148 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_29878148;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.778 -0400", hash_original_method = "2DA7D0C3A567190913C90FAF0FAC7F20", hash_generated_method = "734743C8585801DB46D477D4C894CB9D")
    public String getKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_516811749 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2037287991 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_516811749 = this.key;
        } //End block
        {
            this.key = MessageChannel.getKey(this.peerAddress, this.peerPort, "TCP");
            varB4EAC82CA7396A68D541C85D26508E83_2037287991 = this.key;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_732638770; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_732638770 = varB4EAC82CA7396A68D541C85D26508E83_516811749;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_732638770 = varB4EAC82CA7396A68D541C85D26508E83_2037287991;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_732638770.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_732638770;
        // ---------- Original Method ----------
        //if (this.key != null) {
            //return this.key;
        //} else {
            //this.key = MessageChannel.getKey(this.peerAddress, this.peerPort, "TCP");
            //return this.key;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.782 -0400", hash_original_method = "11E5C6A8F9691D7C5E18B4FE0A22A301", hash_generated_method = "1740146E2876C868AD2828D5BF96670D")
    public String getViaHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_1661080586 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1661080586 = myAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1661080586.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1661080586;
        // ---------- Original Method ----------
        //return myAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.782 -0400", hash_original_method = "97574FAF366AF2CA74D034931ECBD71B", hash_generated_method = "7C2B03AE27524D03CE99920FD4644965")
    public int getViaPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1146717334 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1146717334;
        // ---------- Original Method ----------
        //return myPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.782 -0400", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "463E3D0614711CE1EE6456509E42FA94")
    public int getPeerPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_400015206 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_400015206;
        // ---------- Original Method ----------
        //return peerPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.783 -0400", hash_original_method = "B210BD4A713B5B982D229CB138437A53", hash_generated_method = "7037B129F99FD03A0927DCA6694B3429")
    public int getPeerPacketSourcePort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1243898159 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1243898159;
        // ---------- Original Method ----------
        //return this.peerPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.795 -0400", hash_original_method = "97EAFF51EEE94208DA244D522468157C", hash_generated_method = "3CFEA77A47D26204CD89394A432E5F5D")
    public InetAddress getPeerPacketSourceAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1974435687 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1974435687 = this.peerAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1974435687.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1974435687;
        // ---------- Original Method ----------
        //return this.peerAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.795 -0400", hash_original_method = "51201694E0EE76265BF39848EF10BE9C", hash_generated_method = "AE42F076F740C400DEE53C6F166D5544")
    public boolean isSecure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1825522249 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1825522249;
        // ---------- Original Method ----------
        //return false;
    }

    
}

