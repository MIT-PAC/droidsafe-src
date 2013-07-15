package gov.nist.javax.sip.stack;

// Droidsafe Imports
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
import java.util.TimerTask;
import javax.sip.address.Hop;

public class TCPMessageChannel extends MessageChannel implements SIPMessageListener, Runnable, RawMessageChannel {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.166 -0400", hash_original_field = "52CA6755165FFD50983D257A0F1E043B", hash_generated_field = "F3B00F7E70704D963CC4197CD003FB94")

    private Socket mySock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.166 -0400", hash_original_field = "8C35693B192604DA4AB63AD19D48096F", hash_generated_field = "152EC54D2111EF26096DF65FC2003536")

    private PipelinedMsgParser myParser;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.166 -0400", hash_original_field = "0EDD5FF84F2278A8C37689A050537727", hash_generated_field = "5631DED65C3B5D9167CB9D9A47D5D03A")

    protected InputStream myClientInputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.166 -0400", hash_original_field = "8D01696ED532963D851C7717792CB333", hash_generated_field = "7FAB60C2DCAEF3BF5FBD0260A9FAB955")

    protected OutputStream myClientOutputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.166 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "32361AD5112AD88D374E45078833A152")

    protected String key;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.166 -0400", hash_original_field = "1AC7B394035E343F285A6A4ED1096126", hash_generated_field = "F8E96F7362B3E7CD3DE3A2778DC87A58")

    protected boolean isCached;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.166 -0400", hash_original_field = "39044C41F340C67BFA15E91CC6E98E7D", hash_generated_field = "911E18F9BE05473489F5F21C894DF579")

    protected boolean isRunning;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.166 -0400", hash_original_field = "9842605C72E3BC73DA5398CE4B5EB840", hash_generated_field = "8890F3B68DD2F65EEDEBEEF6284B3EE1")

    private Thread mythread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.167 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "3233C5012C49C796F9D6BBC8E02EAB41")

    protected SIPTransactionStack sipStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.167 -0400", hash_original_field = "AA48C74491DE12FAB31F14F04DE0F567", hash_generated_field = "52302EBB56B387342DED9EB749307DE1")

    protected String myAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.167 -0400", hash_original_field = "AB99FC537949F4680FB25A11A38B0042", hash_generated_field = "AD61806C610E09EDA888D5EC477B22F2")

    protected int myPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.167 -0400", hash_original_field = "D7FA5E7DC9BACC5016B81E35D44D1C5F", hash_generated_field = "5F6E05F1C4EB951C3527127A288505CA")

    protected InetAddress peerAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.167 -0400", hash_original_field = "BBD5741C4F9994864582D25DD194C4DE", hash_generated_field = "6A69B321E52130622ADD35A2A3F00BA6")

    protected int peerPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.167 -0400", hash_original_field = "EDB6E8FD971C3E6879E1A00995BCB702", hash_generated_field = "FBF73E4EC3FC246E9E63B41E9D9708E4")

    protected String peerProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.167 -0400", hash_original_field = "3F76902303B4A9F0BE6E5268A619EBF6", hash_generated_field = "5B259E81F7C4616BF3121004579047E4")

    private TCPMessageProcessor tcpMessageProcessor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.167 -0400", hash_original_method = "A2B275A41CF549D2A1285292B7E5107C", hash_generated_method = "1B936302B48EAC3381B05CB0C4A70DD8")
    protected  TCPMessageChannel(SIPTransactionStack sipStack) {
        this.sipStack = sipStack;
        // ---------- Original Method ----------
        //this.sipStack = sipStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.170 -0400", hash_original_method = "5A50CDCBFA2341437DDE39E7C9C5EE35", hash_generated_method = "9D1C166DE284CF235872A564337541EF")
    protected  TCPMessageChannel(Socket sock, SIPTransactionStack sipStack,
            TCPMessageProcessor msgProcessor) throws IOException {
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug("creating new TCPMessageChannel ");
            sipStack.getStackLogger().logStackTrace();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.171 -0400", hash_original_method = "C53C1DE79ECD9DAACE8708608E931C74", hash_generated_method = "A71D1B8DFA113935CD794EF6033C0018")
    protected  TCPMessageChannel(InetAddress inetAddr, int port, SIPTransactionStack sipStack,
            TCPMessageProcessor messageProcessor) throws IOException {
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug("creating new TCPMessageChannel ");
            sipStack.getStackLogger().logStackTrace();
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.172 -0400", hash_original_method = "16D0E6CF226A4618D75D1B422CC8FCDF", hash_generated_method = "69883BB357718DBD4483B3F329F8F78F")
    public boolean isReliable() {
        boolean varB326B5062B2F0E69046810717534CB09_296194946 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1118488262 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1118488262;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.172 -0400", hash_original_method = "D9B233459FD7A72AC548D3BF0383246D", hash_generated_method = "4BBC087E0C0EDCC1396542B103C26268")
    public void close() {
        try 
        {
    if(mySock != null)            
            {
                mySock.close();
                mySock = null;
            } //End block
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logDebug("Closing message Channel " + this);
        } //End block
        catch (IOException ex)
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logDebug("Error closing socket " + ex);
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.173 -0400", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "6C04E3DB846DBAEF74BBC2573A244314")
    public SIPTransactionStack getSIPStack() {
SIPTransactionStack var0FC1F21ED47F4C0C48881B0DAF112A16_1478242929 =         sipStack;
        var0FC1F21ED47F4C0C48881B0DAF112A16_1478242929.addTaint(taint);
        return var0FC1F21ED47F4C0C48881B0DAF112A16_1478242929;
        // ---------- Original Method ----------
        //return sipStack;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.173 -0400", hash_original_method = "0D1837A773C1185791E8B7504B01CB2E", hash_generated_method = "FA05ACF19E1027DEBDF29271D13C2384")
    public String getTransport() {
String var5830B3663182492A52FBA750E975BF49_1656821954 =         "TCP";
        var5830B3663182492A52FBA750E975BF49_1656821954.addTaint(taint);
        return var5830B3663182492A52FBA750E975BF49_1656821954;
        // ---------- Original Method ----------
        //return "TCP";
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.173 -0400", hash_original_method = "59CC467573DB54CDCEF540AE63F43735", hash_generated_method = "DB98B1F0C960C32924DFBA2B4F0514C9")
    public String getPeerAddress() {
    if(peerAddress != null)        
        {
String var4D1B58EF74DF31190A62E0DF268BAE94_437670534 =             peerAddress.getHostAddress();
            var4D1B58EF74DF31190A62E0DF268BAE94_437670534.addTaint(taint);
            return var4D1B58EF74DF31190A62E0DF268BAE94_437670534;
        } //End block
        else
        {
String var5C0621B65E898A3E2061530CDD6F20D5_737566983 =         getHost();
        var5C0621B65E898A3E2061530CDD6F20D5_737566983.addTaint(taint);
        return var5C0621B65E898A3E2061530CDD6F20D5_737566983;
        }
        // ---------- Original Method ----------
        //if (peerAddress != null) {
            //return peerAddress.getHostAddress();
        //} else
            //return getHost();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.173 -0400", hash_original_method = "1F29EC3BC94C3E0863F530FCD37A61F3", hash_generated_method = "084CB092FD75FAD2EE6E9F9006DC759C")
    protected InetAddress getPeerInetAddress() {
InetAddress var73F565C01AAA4A3FCE210191AB87441A_486835722 =         peerAddress;
        var73F565C01AAA4A3FCE210191AB87441A_486835722.addTaint(taint);
        return var73F565C01AAA4A3FCE210191AB87441A_486835722;
        // ---------- Original Method ----------
        //return peerAddress;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.174 -0400", hash_original_method = "DB79607DA3ACB5FA2D24428DF2713F98", hash_generated_method = "CF9D1F9BD1D7111D1D64BFF44867EB93")
    public String getPeerProtocol() {
String var6B5233BA3C9F99490638F3C0025EA1D3_1407174560 =         this.peerProtocol;
        var6B5233BA3C9F99490638F3C0025EA1D3_1407174560.addTaint(taint);
        return var6B5233BA3C9F99490638F3C0025EA1D3_1407174560;
        // ---------- Original Method ----------
        //return this.peerProtocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.174 -0400", hash_original_method = "3044E621F64D9746C61861BC2D15D7B8", hash_generated_method = "6D7A1477D2773BC8944B430042F5A288")
    private void sendMessage(byte[] msg, boolean retry) throws IOException {
        addTaint(retry);
        addTaint(msg[0]);
        Socket sock = this.sipStack.ioHandler.sendBytes(this.messageProcessor.getIpAddress(),
                this.peerAddress, this.peerPort, this.peerProtocol, msg, retry, this);
    if(sock != mySock && sock != null)        
        {
            try 
            {
    if(mySock != null)                
                mySock.close();
            } //End block
            catch (IOException ex)
            {
            } //End block
            mySock = sock;
            this.myClientInputStream = mySock.getInputStream();
            this.myClientOutputStream = mySock.getOutputStream();
            Thread thread = new Thread(this);
            thread.setDaemon(true);
            thread.setName("TCPMessageChannelThread");
            thread.start();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.175 -0400", hash_original_method = "05F3A695AC32E3040A89EFF8F81F947F", hash_generated_method = "B676ADEA8367A850F76CEC88B8F4E236")
    public void sendMessage(SIPMessage sipMessage) throws IOException {
        addTaint(sipMessage.getTaint());
        byte[] msg = sipMessage.encodeAsBytes(this.getTransport());
        long time = System.currentTimeMillis();
        this.sendMessage(msg, true);
    if(this.sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES))        
        logMessage(sipMessage, peerAddress, peerPort, time);
        // ---------- Original Method ----------
        //byte[] msg = sipMessage.encodeAsBytes(this.getTransport());
        //long time = System.currentTimeMillis();
        //this.sendMessage(msg, true);
        //if (this.sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES))
            //logMessage(sipMessage, peerAddress, peerPort, time);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.176 -0400", hash_original_method = "089EEE36759D74C41252D6311E4E6671", hash_generated_method = "566FE1E243A12FEB899F623D25734E80")
    public void sendMessage(byte message[], InetAddress receiverAddress, int receiverPort,
            boolean retry) throws IOException {
        addTaint(retry);
        addTaint(receiverPort);
        addTaint(receiverAddress.getTaint());
        addTaint(message[0]);
    if(message == null || receiverAddress == null)        
        {
        IllegalArgumentException varFDDDD686508FEB178E9B557172ECF36A_1410993099 = new IllegalArgumentException("Null argument");
        varFDDDD686508FEB178E9B557172ECF36A_1410993099.addTaint(taint);
        throw varFDDDD686508FEB178E9B557172ECF36A_1410993099;
        }
        Socket sock = this.sipStack.ioHandler.sendBytes(this.messageProcessor.getIpAddress(),
                receiverAddress, receiverPort, "TCP", message, retry, this);
    if(sock != mySock && sock != null)        
        {
    if(mySock != null)            
            {
                sipStack.getTimer().schedule(new TimerTask() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.176 -0400", hash_original_method = "73BB2678B4D3B10E0EB61D0433282932", hash_generated_method = "279532CA7DF3FF6A257017B79D52F33D")
        @Override
        public boolean cancel() {
            try 
            {
                mySock.close();
                super.cancel();
            } //End block
            catch (IOException ex)
            {
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_98781285 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_850824279 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_850824279;
            // ---------- Original Method ----------
            //try {
                            //mySock.close();
                            //super.cancel();
                        //} catch (IOException ex) {
                        //}
            //return true;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.176 -0400", hash_original_method = "1800F2338CC81B9692B7DA0DF6DF5AE0", hash_generated_method = "29BDECE855C8E53B7F56E04B838408E9")
        @Override
        public void run() {
            try 
            {
                mySock.close();
            } //End block
            catch (IOException ex)
            {
            } //End block
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
            Thread mythread = new Thread(this);
            mythread.setDaemon(true);
            mythread.setName("TCPMessageChannelThread");
            mythread.start();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.177 -0400", hash_original_method = "10E78FE9041FD1B7C26A106A739E4ED8", hash_generated_method = "9AB52A3F88966B0E20D117752474CBD7")
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
            {
                sipStack.getStackLogger().logDebug(
                        "Encountered Bad Message \n" + sipMessage.toString());
            } //End block
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
                    } //End block
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
                else
                {
    if(sipStack.isLoggingEnabled())                    
                    {
                        sipStack.getStackLogger().logDebug(
                                "Could not formulate automatic 400 Bad Request");
                    } //End block
                } //End block
            } //End block
            ex.addTaint(taint);
            throw ex;
        } //End block
        else
        {
            sipMessage.addUnparsed(header);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.181 -0400", hash_original_method = "688E2F52AD2D71AD93C4E5B7CEC68AD5", hash_generated_method = "0A9A51260611109D74BED12BBAD3CDD8")
    public void processMessage(SIPMessage sipMessage) throws Exception {
        addTaint(sipMessage.getTaint());
        try 
        {
    if(sipMessage.getFrom() == null
                    || 
                    sipMessage.getTo() == null || sipMessage.getCallId() == null
                    || sipMessage.getCSeq() == null || sipMessage.getViaHeaders() == null)            
            {
                String badmsg = sipMessage.encode();
    if(sipStack.isLoggingEnabled())                
                {
                    sipStack.getStackLogger().logDebug(">>> Dropped Bad Msg");
                    sipStack.getStackLogger().logDebug(badmsg);
                } //End block
                return;
            } //End block
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
                    } //End block
                    v.setParameter(Via.RPORT, Integer.toString(this.peerPort));
                } //End block
                catch (java.text.ParseException ex)
                {
                    InternalErrorHandler.handleException(ex, sipStack.getStackLogger());
                } //End block
    if(!this.isCached)                
                {
                    ((TCPMessageProcessor) this.messageProcessor).cacheMessageChannel(this);
                    this.isCached = true;
                    int remotePort = ((java.net.InetSocketAddress) mySock.getRemoteSocketAddress()).getPort();
                    String key = IOHandler.makeKey(mySock.getInetAddress(), remotePort);
                    sipStack.ioHandler.putSocket(key, mySock);
                } //End block
            } //End block
            long receptionTime = System.currentTimeMillis();
    if(sipMessage instanceof SIPRequest)            
            {
                SIPRequest sipRequest = (SIPRequest) sipMessage;
    if(sipStack.isLoggingEnabled())                
                {
                    sipStack.getStackLogger().logDebug("----Processing Message---");
                } //End block
    if(this.sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES))                
                {
                    sipStack.serverLogger.logMessage(sipMessage, this.getPeerHostPort().toString(),
                            this.getMessageProcessor().getIpAddress().getHostAddress() + ":"
                                    + this.getMessageProcessor().getPort(), false, receptionTime);
                } //End block
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
                    Exception varDF678B266A68FE82BCEBF8807C609878_1090987405 = new Exception("Message size exceeded");
                    varDF678B266A68FE82BCEBF8807C609878_1090987405.addTaint(taint);
                    throw varDF678B266A68FE82BCEBF8807C609878_1090987405;
                } //End block
                ServerRequestInterface sipServerRequest = sipStack.newSIPServerRequest(
                        sipRequest, this);
    if(sipServerRequest != null)                
                {
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
                            ((SIPTransaction) sipServerRequest).releaseSem();
                        } //End block
                    } //End block
                } //End block
                else
                {
    if(sipStack.isLoggingEnabled())                    
                    this.sipStack.getStackLogger()
                            .logWarning("Dropping request -- could not acquire semaphore in 10 sec");
                } //End block
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
    if(sipStack.getMaxMessageSize() > 0
                        && sipResponse.getSize()
                                + (sipResponse.getContentLength() == null ? 0 : sipResponse
                                        .getContentLength().getContentLength()) > sipStack
                                .getMaxMessageSize())                
                {
    if(sipStack.isLoggingEnabled())                    
                    this.sipStack.getStackLogger().logDebug("Message size exceeded");
                    return;
                } //End block
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
                        } //End block
                        sipServerResponse.processResponse(sipResponse, this);
                    } //End block
                    finally 
                    {
    if(sipServerResponse instanceof SIPTransaction
                                && !((SIPTransaction) sipServerResponse).passToListener())                        
                        ((SIPTransaction) sipServerResponse).releaseSem();
                    } //End block
                } //End block
                else
                {
                    sipStack
                            .getStackLogger()
                            .logWarning(
                                    "Application is blocked -- could not acquire semaphore -- dropping response");
                } //End block
            } //End block
        } //End block
        finally 
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.184 -0400", hash_original_method = "D4E0A0BC15B98D38AEFE5154BA5871D0", hash_generated_method = "D75C9C0A6827BEE84B741494712FB2A6")
    public void run() {
        Pipeline hispipe = null;
        hispipe = new Pipeline(myClientInputStream, sipStack.readTimeout,
                ((SIPTransactionStack) sipStack).getTimer());
        myParser = new PipelinedMsgParser(this, hispipe, this.sipStack.getMaxMessageSize());
        myParser.processInput();
        int bufferSize = 4096;
        this.tcpMessageProcessor.useCount++;
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
(tcpMessageProcessor)                                {
                                    tcpMessageProcessor.nConnections--;
                                    tcpMessageProcessor.notify();
                                } //End block
                            } //End block
                            hispipe.close();
                            mySock.close();
                        } //End block
                        catch (IOException ioex)
                        {
                        } //End block
                        return;
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
                    {
                    } //End block
                    try 
                    {
    if(sipStack.isLoggingEnabled())                        
                        sipStack.getStackLogger().logDebug("IOException  closing sock " + ex);
                        try 
                        {
    if(sipStack.maxConnections != -1)                            
                            {
                                synchronized
(tcpMessageProcessor)                                {
                                    tcpMessageProcessor.nConnections--;
                                    tcpMessageProcessor.notify();
                                } //End block
                            } //End block
                            mySock.close();
                            hispipe.close();
                        } //End block
                        catch (IOException ioex)
                        {
                        } //End block
                    } //End block
                    catch (Exception ex1)
                    {
                    } //End block
                    return;
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
            this.tcpMessageProcessor.useCount--;
            myParser.close();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.185 -0400", hash_original_method = "588DDE9A59AB3DB90B101694890D3C99", hash_generated_method = "B3F2B3138D609DF54D84403064B1C6C7")
    protected void uncache() {
    if(isCached && !isRunning)        
        {
            this.tcpMessageProcessor.remove(this);
        } //End block
        // ---------- Original Method ----------
        //if (isCached && !isRunning) {
    		//this.tcpMessageProcessor.remove(this);
    	//}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.185 -0400", hash_original_method = "A3550F5A4A6E2000221840888A01CA8A", hash_generated_method = "6F3206EA5FA47F61B2E3B11404816AE1")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(!this.getClass().equals(other.getClass()))        
        {
        boolean var68934A3E9455FA72420237EB05902327_63777220 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_124255945 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_124255945;
        }
        else
        {
            TCPMessageChannel that = (TCPMessageChannel) other;
    if(this.mySock != that.mySock)            
            {
            boolean var68934A3E9455FA72420237EB05902327_1049764037 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1790488645 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1790488645;
            }
            else
            {
            boolean varB326B5062B2F0E69046810717534CB09_1421677281 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1722038673 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1722038673;
            }
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.186 -0400", hash_original_method = "2DA7D0C3A567190913C90FAF0FAC7F20", hash_generated_method = "509C344BF3D087A3A460ACD21BB8D00E")
    public String getKey() {
    if(this.key != null)        
        {
String var28438ADFC1608AABD649C75D36B519BF_268599164 =             this.key;
            var28438ADFC1608AABD649C75D36B519BF_268599164.addTaint(taint);
            return var28438ADFC1608AABD649C75D36B519BF_268599164;
        } //End block
        else
        {
            this.key = MessageChannel.getKey(this.peerAddress, this.peerPort, "TCP");
String var28438ADFC1608AABD649C75D36B519BF_1038163474 =             this.key;
            var28438ADFC1608AABD649C75D36B519BF_1038163474.addTaint(taint);
            return var28438ADFC1608AABD649C75D36B519BF_1038163474;
        } //End block
        // ---------- Original Method ----------
        //if (this.key != null) {
            //return this.key;
        //} else {
            //this.key = MessageChannel.getKey(this.peerAddress, this.peerPort, "TCP");
            //return this.key;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.186 -0400", hash_original_method = "11E5C6A8F9691D7C5E18B4FE0A22A301", hash_generated_method = "E550435AFA1B5A68BAEA379A69B980E0")
    public String getViaHost() {
String varE7034C1BD80371A3EE602CF085A2802A_923441358 =         myAddress;
        varE7034C1BD80371A3EE602CF085A2802A_923441358.addTaint(taint);
        return varE7034C1BD80371A3EE602CF085A2802A_923441358;
        // ---------- Original Method ----------
        //return myAddress;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.187 -0400", hash_original_method = "97574FAF366AF2CA74D034931ECBD71B", hash_generated_method = "99EBF41A951863F46F8E737DCBDC98F2")
    public int getViaPort() {
        int varAB99FC537949F4680FB25A11A38B0042_889935036 = (myPort);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1050929591 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1050929591;
        // ---------- Original Method ----------
        //return myPort;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.187 -0400", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "B4D925BD5D7223F214FC5FD44CCAA43B")
    public int getPeerPort() {
        int varBBD5741C4F9994864582D25DD194C4DE_1464354764 = (peerPort);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1987057079 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1987057079;
        // ---------- Original Method ----------
        //return peerPort;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.187 -0400", hash_original_method = "B210BD4A713B5B982D229CB138437A53", hash_generated_method = "D863E662319AECF89357992486384D65")
    public int getPeerPacketSourcePort() {
        int var863AF973F56BABC8062C15431981E0EC_401757654 = (this.peerPort);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1677677193 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1677677193;
        // ---------- Original Method ----------
        //return this.peerPort;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.187 -0400", hash_original_method = "97EAFF51EEE94208DA244D522468157C", hash_generated_method = "DB1FED4F005871DFB79BD6B051EB8FA7")
    public InetAddress getPeerPacketSourceAddress() {
InetAddress varCB519CCE5105BD67F1450F075D5E971F_1027949073 =         this.peerAddress;
        varCB519CCE5105BD67F1450F075D5E971F_1027949073.addTaint(taint);
        return varCB519CCE5105BD67F1450F075D5E971F_1027949073;
        // ---------- Original Method ----------
        //return this.peerAddress;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.188 -0400", hash_original_method = "51201694E0EE76265BF39848EF10BE9C", hash_generated_method = "633DC11625C61C4C51C9AE9C1490FBBB")
    public boolean isSecure() {
        boolean var68934A3E9455FA72420237EB05902327_733289455 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_679589466 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_679589466;
        // ---------- Original Method ----------
        //return false;
    }

    
}

