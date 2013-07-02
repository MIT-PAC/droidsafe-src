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
import java.util.TimerTask;
import javax.sip.address.Hop;

public class TCPMessageChannel extends MessageChannel implements SIPMessageListener, Runnable, RawMessageChannel {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.765 -0400", hash_original_field = "52CA6755165FFD50983D257A0F1E043B", hash_generated_field = "F3B00F7E70704D963CC4197CD003FB94")

    private Socket mySock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.765 -0400", hash_original_field = "8C35693B192604DA4AB63AD19D48096F", hash_generated_field = "152EC54D2111EF26096DF65FC2003536")

    private PipelinedMsgParser myParser;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.765 -0400", hash_original_field = "0EDD5FF84F2278A8C37689A050537727", hash_generated_field = "5631DED65C3B5D9167CB9D9A47D5D03A")

    protected InputStream myClientInputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.765 -0400", hash_original_field = "8D01696ED532963D851C7717792CB333", hash_generated_field = "7FAB60C2DCAEF3BF5FBD0260A9FAB955")

    protected OutputStream myClientOutputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.765 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "32361AD5112AD88D374E45078833A152")

    protected String key;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.765 -0400", hash_original_field = "1AC7B394035E343F285A6A4ED1096126", hash_generated_field = "F8E96F7362B3E7CD3DE3A2778DC87A58")

    protected boolean isCached;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.765 -0400", hash_original_field = "39044C41F340C67BFA15E91CC6E98E7D", hash_generated_field = "911E18F9BE05473489F5F21C894DF579")

    protected boolean isRunning;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.765 -0400", hash_original_field = "9842605C72E3BC73DA5398CE4B5EB840", hash_generated_field = "8890F3B68DD2F65EEDEBEEF6284B3EE1")

    private Thread mythread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.765 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "3233C5012C49C796F9D6BBC8E02EAB41")

    protected SIPTransactionStack sipStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.765 -0400", hash_original_field = "AA48C74491DE12FAB31F14F04DE0F567", hash_generated_field = "52302EBB56B387342DED9EB749307DE1")

    protected String myAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.765 -0400", hash_original_field = "AB99FC537949F4680FB25A11A38B0042", hash_generated_field = "AD61806C610E09EDA888D5EC477B22F2")

    protected int myPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.765 -0400", hash_original_field = "D7FA5E7DC9BACC5016B81E35D44D1C5F", hash_generated_field = "5F6E05F1C4EB951C3527127A288505CA")

    protected InetAddress peerAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.766 -0400", hash_original_field = "BBD5741C4F9994864582D25DD194C4DE", hash_generated_field = "6A69B321E52130622ADD35A2A3F00BA6")

    protected int peerPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.766 -0400", hash_original_field = "EDB6E8FD971C3E6879E1A00995BCB702", hash_generated_field = "FBF73E4EC3FC246E9E63B41E9D9708E4")

    protected String peerProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.766 -0400", hash_original_field = "3F76902303B4A9F0BE6E5268A619EBF6", hash_generated_field = "5B259E81F7C4616BF3121004579047E4")

    private TCPMessageProcessor tcpMessageProcessor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.766 -0400", hash_original_method = "A2B275A41CF549D2A1285292B7E5107C", hash_generated_method = "1B936302B48EAC3381B05CB0C4A70DD8")
    protected  TCPMessageChannel(SIPTransactionStack sipStack) {
        this.sipStack = sipStack;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.766 -0400", hash_original_method = "5A50CDCBFA2341437DDE39E7C9C5EE35", hash_generated_method = "F50222256B8EE737455BF9C311F330EE")
    protected  TCPMessageChannel(Socket sock, SIPTransactionStack sipStack,
            TCPMessageProcessor msgProcessor) throws IOException {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1512000890 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("creating new TCPMessageChannel ");
                sipStack.getStackLogger().logStackTrace();
            } 
        } 
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
        
        
            
            
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.767 -0400", hash_original_method = "C53C1DE79ECD9DAACE8708608E931C74", hash_generated_method = "EA8F43B14C78FB229658DCA02800ECA7")
    protected  TCPMessageChannel(InetAddress inetAddr, int port, SIPTransactionStack sipStack,
            TCPMessageProcessor messageProcessor) throws IOException {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1559539579 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("creating new TCPMessageChannel ");
                sipStack.getStackLogger().logStackTrace();
            } 
        } 
        this.peerAddress = inetAddr;
        this.peerPort = port;
        this.myPort = messageProcessor.getPort();
        this.peerProtocol = "TCP";
        this.sipStack = sipStack;
        this.tcpMessageProcessor = messageProcessor;
        this.myAddress = messageProcessor.getIpAddress().getHostAddress();
        this.key = MessageChannel.getKey(peerAddress, peerPort, "TCP");
        super.messageProcessor = messageProcessor;
        
        
            
            
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.768 -0400", hash_original_method = "16D0E6CF226A4618D75D1B422CC8FCDF", hash_generated_method = "B40BBF6F6F49465994FB41D8E100ACC2")
    public boolean isReliable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1405753501 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1405753501;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.768 -0400", hash_original_method = "D9B233459FD7A72AC548D3BF0383246D", hash_generated_method = "54969063E676EE94DBA158C993EFEBFB")
    public void close() {
        try 
        {
            {
                mySock.close();
                mySock = null;
            } 
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1110810312 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Closing message Channel " + this);
            } 
        } 
        catch (IOException ex)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_361501425 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Error closing socket " + ex);
            } 
        } 
        
        
            
                
                
            
            
                
        
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.769 -0400", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "69A0FFABA6DE1DE6091223129363894D")
    public SIPTransactionStack getSIPStack() {
        SIPTransactionStack varB4EAC82CA7396A68D541C85D26508E83_1887019512 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1887019512 = sipStack;
        varB4EAC82CA7396A68D541C85D26508E83_1887019512.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1887019512;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.770 -0400", hash_original_method = "0D1837A773C1185791E8B7504B01CB2E", hash_generated_method = "6E0FF273F69BD2B1A642DAEA4CB0FCDF")
    public String getTransport() {
        String varB4EAC82CA7396A68D541C85D26508E83_1554796013 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1554796013 = "TCP";
        varB4EAC82CA7396A68D541C85D26508E83_1554796013.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1554796013;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.770 -0400", hash_original_method = "59CC467573DB54CDCEF540AE63F43735", hash_generated_method = "D2DEA4DA3FD4295824AE9C9D446FE899")
    public String getPeerAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_871969154 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_152536765 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_871969154 = peerAddress.getHostAddress();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_152536765 = getHost();
        String varA7E53CE21691AB073D9660D615818899_1241798398; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1241798398 = varB4EAC82CA7396A68D541C85D26508E83_871969154;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1241798398 = varB4EAC82CA7396A68D541C85D26508E83_152536765;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1241798398.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1241798398;
        
        
            
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.771 -0400", hash_original_method = "1F29EC3BC94C3E0863F530FCD37A61F3", hash_generated_method = "9B22F4A0CD2BA75DA5CB666CF3943CE6")
    protected InetAddress getPeerInetAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1342283009 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1342283009 = peerAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1342283009.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1342283009;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.771 -0400", hash_original_method = "DB79607DA3ACB5FA2D24428DF2713F98", hash_generated_method = "C88B2246A17D78D1A60286E550F74DA6")
    public String getPeerProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_369532891 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_369532891 = this.peerProtocol;
        varB4EAC82CA7396A68D541C85D26508E83_369532891.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_369532891;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.772 -0400", hash_original_method = "3044E621F64D9746C61861BC2D15D7B8", hash_generated_method = "C4C783D463CDA45E59D810AB342B26E0")
    private void sendMessage(byte[] msg, boolean retry) throws IOException {
        Socket sock = this.sipStack.ioHandler.sendBytes(this.messageProcessor.getIpAddress(),
                this.peerAddress, this.peerPort, this.peerProtocol, msg, retry, this);
        {
            try 
            {
                mySock.close();
            } 
            catch (IOException ex)
            { }
            mySock = sock;
            this.myClientInputStream = mySock.getInputStream();
            this.myClientOutputStream = mySock.getOutputStream();
            Thread thread = new Thread(this);
            thread.setDaemon(true);
            thread.setName("TCPMessageChannelThread");
            thread.start();
        } 
        addTaint(msg[0]);
        addTaint(retry);
        
        
                
        
            
                
                    
            
            
            
            
            
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.772 -0400", hash_original_method = "05F3A695AC32E3040A89EFF8F81F947F", hash_generated_method = "18C49CE250C91660DB8B83B5EC168CF4")
    public void sendMessage(SIPMessage sipMessage) throws IOException {
        byte[] msg = sipMessage.encodeAsBytes(this.getTransport());
        long time = System.currentTimeMillis();
        this.sendMessage(msg, true);
        {
            boolean var53DEB6CBCADF9510253D9D22204998C3_364740017 = (this.sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES));
            logMessage(sipMessage, peerAddress, peerPort, time);
        } 
        addTaint(sipMessage.getTaint());
        
        
        
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.774 -0400", hash_original_method = "089EEE36759D74C41252D6311E4E6671", hash_generated_method = "B226A9E248267096AAEA76495DE45A87")
    public void sendMessage(byte message[], InetAddress receiverAddress, int receiverPort,
            boolean retry) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Null argument");
        Socket sock = this.sipStack.ioHandler.sendBytes(this.messageProcessor.getIpAddress(),
                receiverAddress, receiverPort, "TCP", message, retry, this);
        {
            {
                sipStack.getTimer().schedule(new TimerTask() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.773 -0400", hash_original_method = "73BB2678B4D3B10E0EB61D0433282932", hash_generated_method = "7BA4EB57642749E6346FF1308768F7F0")
                    @Override
                    public boolean cancel() {
                        try 
                        {
                            mySock.close();
                            super.cancel();
                        } 
                        catch (IOException ex)
                        { }
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1415334466 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1415334466;
                        
                        
                            
                            
                        
                        
                        
                    }
                    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.773 -0400", hash_original_method = "1800F2338CC81B9692B7DA0DF6DF5AE0", hash_generated_method = "387B19C1830DE243C8CB852FA2680BDB")
                    @Override
                    public void run() {
                        try 
                        {
                            mySock.close();
                        } 
                        catch (IOException ex)
                        { }
                        
                        
                            
                        
                        
                    }
}, 8000);
            } 
            mySock = sock;
            this.myClientInputStream = mySock.getInputStream();
            this.myClientOutputStream = mySock.getOutputStream();
            Thread mythread = new Thread(this);
            mythread.setDaemon(true);
            mythread.setName("TCPMessageChannelThread");
            mythread.start();
        } 
        addTaint(message[0]);
        addTaint(receiverAddress.getTaint());
        addTaint(receiverPort);
        addTaint(retry);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.775 -0400", hash_original_method = "10E78FE9041FD1B7C26A106A739E4ED8", hash_generated_method = "60539FBC31754B2A2D0391EAE4341A80")
    public void handleException(ParseException ex, SIPMessage sipMessage, Class hdrClass,
            String header, String message) throws ParseException {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1252248778 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logException(ex);
        } 
        {
            boolean var4AF4DF15E5A9AA725DAB2E0A6B114A9C_1042451908 = ((hdrClass != null)
                && (hdrClass.equals(From.class) || hdrClass.equals(To.class)
                        || hdrClass.equals(CSeq.class) || hdrClass.equals(Via.class)
                        || hdrClass.equals(CallID.class) || hdrClass.equals(RequestLine.class) || hdrClass
                        .equals(StatusLine.class)));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1141029877 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug(
                        "Encountered Bad Message \n" + sipMessage.toString());
                    } 
                } 
                String msgString = sipMessage.toString();
                {
                    boolean varD14AB56EAEC4527AFDDBDB5F15852E6F_27998424 = (!msgString.startsWith("SIP/") && !msgString.startsWith("ACK "));
                    {
                        String badReqRes = createBadReqRes(msgString, ex);
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1605293462 = (sipStack.isLoggingEnabled());
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
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1209679751 = (sipStack.isLoggingEnabled());
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.776 -0400", hash_original_method = "688E2F52AD2D71AD93C4E5B7CEC68AD5", hash_generated_method = "FF276E6035E76FCFD6ABF2E5FD8EC2AF")
    public void processMessage(SIPMessage sipMessage) throws Exception {
        try 
        {
            {
                boolean varB9F954BFA525F3DD48043E6E9EFACC67_724987874 = (sipMessage.getFrom() == null
                    || 
                    sipMessage.getTo() == null || sipMessage.getCallId() == null
                    || sipMessage.getCSeq() == null || sipMessage.getViaHeaders() == null);
                {
                    String badmsg = sipMessage.encode();
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_615553963 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logDebug(">>> Dropped Bad Msg");
                            sipStack.getStackLogger().logDebug(badmsg);
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
                        boolean var07142A8EFF3EF4AD30BCBC85CFE5B232_384590643 = (v.hasParameter(Via.RPORT)
                            || !hop.getHost().equals(this.peerAddress.getHostAddress()));
                        {
                            v.setParameter(Via.RECEIVED, this.peerAddress.getHostAddress());
                        } 
                    } 
                    v.setParameter(Via.RPORT, Integer.toString(this.peerPort));
                } 
                catch (java.text.ParseException ex)
                {
                    InternalErrorHandler.handleException(ex, sipStack.getStackLogger());
                } 
                {
                    ((TCPMessageProcessor) this.messageProcessor).cacheMessageChannel(this);
                    this.isCached = true;
                    int remotePort = ((java.net.InetSocketAddress) mySock.getRemoteSocketAddress()).getPort();
                    String key = IOHandler.makeKey(mySock.getInetAddress(), remotePort);
                    sipStack.ioHandler.putSocket(key, mySock);
                } 
            } 
            long receptionTime = System.currentTimeMillis();
            {
                SIPRequest sipRequest = (SIPRequest) sipMessage;
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1455063305 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug("----Processing Message---");
                    } 
                } 
                {
                    boolean var329151020C352D7210D49BED1EED92B4_882243376 = (this.sipStack.getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES));
                    {
                        sipStack.serverLogger.logMessage(sipMessage, this.getPeerHostPort().toString(),
                            this.getMessageProcessor().getIpAddress().getHostAddress() + ":"
                                    + this.getMessageProcessor().getPort(), false, receptionTime);
                    } 
                } 
                {
                    boolean varBFE4F5560E1DAE5D9C4B756065954E9B_1008500048 = (sipStack.getMaxMessageSize() > 0
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
                                boolean varD802744989A665132B75B392ADE40209_1587538607 = (!sipServerTx.passToListener());
                                ((SIPTransaction) sipServerRequest).releaseSem();
                            } 
                        } 
                    } 
                } 
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1199073643 = (sipStack.isLoggingEnabled());
                        this.sipStack.getStackLogger()
                            .logWarning("Dropping request -- could not acquire semaphore in 10 sec");
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
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_184200621 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger()
                                .logError("Dropping Badly formatted response message >>> "
                                        + sipResponse);
                    } 
                } 
                {
                    boolean var13C0D42D19654498AAF89BA284743FD1_1735290784 = (sipStack.getMaxMessageSize() > 0
                        && sipResponse.getSize()
                                + (sipResponse.getContentLength() == null ? 0 : sipResponse
                                        .getContentLength().getContentLength()) > sipStack
                                .getMaxMessageSize()); 
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_219546495 = (sipStack.isLoggingEnabled());
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
                            boolean var7B7EDCF7240C6ECDC5603DF13532F268_1252021694 = (sipServerResponse instanceof SIPClientTransaction
                                && !((SIPClientTransaction) sipServerResponse)
                                        .checkFromTag(sipResponse));
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_430904799 = (sipStack.isLoggingEnabled());
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
                            boolean varDB4FC2DFFC674AF9290D5BD5A8705AB9_1918759628 = (sipServerResponse instanceof SIPTransaction
                                && !((SIPTransaction) sipServerResponse).passToListener());
                            ((SIPTransaction) sipServerResponse).releaseSem();
                        } 
                    } 
                } 
                {
                    sipStack
                            .getStackLogger()
                            .logWarning(
                                    "Application is blocked -- could not acquire semaphore -- dropping response");
                } 
            } 
        } 
        finally 
        { }
        addTaint(sipMessage.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.777 -0400", hash_original_method = "D4E0A0BC15B98D38AEFE5154BA5871D0", hash_generated_method = "E8C267B822D2B21C517A0CDFF688B089")
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
                                    tcpMessageProcessor.notify();
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
                            boolean var2AB968A8303910EE00F810B6DE3410F9_2138604772 = (sipStack.isLoggingEnabled());
                            sipStack.getStackLogger().logDebug("IOException  closing sock " + ex);
                        } 
                        try 
                        {
                            {
                                {
                                    tcpMessageProcessor.notify();
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
                    InternalErrorHandler.handleException(ex, sipStack.getStackLogger());
                } 
            } 
        } 
        finally 
        {
            this.isRunning = false;
            this.tcpMessageProcessor.remove(this);
            myParser.close();
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.778 -0400", hash_original_method = "588DDE9A59AB3DB90B101694890D3C99", hash_generated_method = "99D3DCE5DA682319A2B659FFC777497D")
    protected void uncache() {
        {
            this.tcpMessageProcessor.remove(this);
        } 
        
        
    		
    	
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.778 -0400", hash_original_method = "A3550F5A4A6E2000221840888A01CA8A", hash_generated_method = "B1D9C276C1868234B9FB3A567C78BD64")
    public boolean equals(Object other) {
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_1073619265 = (!this.getClass().equals(other.getClass()));
            {
                TCPMessageChannel that = (TCPMessageChannel) other;
            } 
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1360235447 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1360235447;
        
        
            
        
            
            
                
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.779 -0400", hash_original_method = "2DA7D0C3A567190913C90FAF0FAC7F20", hash_generated_method = "152E81E3C1DB59A46AC2E637BBD420C4")
    public String getKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_854993518 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1776342976 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_854993518 = this.key;
        } 
        {
            this.key = MessageChannel.getKey(this.peerAddress, this.peerPort, "TCP");
            varB4EAC82CA7396A68D541C85D26508E83_1776342976 = this.key;
        } 
        String varA7E53CE21691AB073D9660D615818899_1182541837; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1182541837 = varB4EAC82CA7396A68D541C85D26508E83_854993518;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1182541837 = varB4EAC82CA7396A68D541C85D26508E83_1776342976;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1182541837.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1182541837;
        
        
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.780 -0400", hash_original_method = "11E5C6A8F9691D7C5E18B4FE0A22A301", hash_generated_method = "25DC6D601F50A885E38789AE9E3FD23F")
    public String getViaHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_1957019293 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1957019293 = myAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1957019293.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1957019293;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.780 -0400", hash_original_method = "97574FAF366AF2CA74D034931ECBD71B", hash_generated_method = "AE18FEB6E6B21C5A84520FC4A48F0F15")
    public int getViaPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2112362397 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2112362397;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.781 -0400", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "39FE9E50106DFA2A31EEB656C091B9D8")
    public int getPeerPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_62299708 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_62299708;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.781 -0400", hash_original_method = "B210BD4A713B5B982D229CB138437A53", hash_generated_method = "66EDDFED514BD91BEBE9FF7C952FF42A")
    public int getPeerPacketSourcePort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1184355345 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1184355345;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.781 -0400", hash_original_method = "97EAFF51EEE94208DA244D522468157C", hash_generated_method = "6C3E2E0D9E57DAE31191AB2C9460BE4C")
    public InetAddress getPeerPacketSourceAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1993746136 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1993746136 = this.peerAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1993746136.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1993746136;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.782 -0400", hash_original_method = "51201694E0EE76265BF39848EF10BE9C", hash_generated_method = "4644EB773EBF93C68803F4A4AF5FCE81")
    public boolean isSecure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_136544888 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_136544888;
        
        
    }

    
}

