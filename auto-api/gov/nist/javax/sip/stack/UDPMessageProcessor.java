package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.util.LinkedList;
import java.net.*;
import gov.nist.core.*;

public class UDPMessageProcessor extends MessageProcessor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.835 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.835 -0400", hash_original_field = "C938FFE4BD56522A7A21A98657F47F2A", hash_generated_field = "C93CF307E97B9E62367601E63458BFCC")

    protected LinkedList messageQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.835 -0400", hash_original_field = "430227A9310EA04063863CFF91801A04", hash_generated_field = "6AE79C808B860BF3147A11B4D0A7A4B0")

    protected LinkedList messageChannels;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.836 -0400", hash_original_field = "CDE1F9B6C35FC856E715F186A9E26998", hash_generated_field = "C7EB24484DBA63450BB85C2FA7FA489F")

    protected int threadPoolSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.836 -0400", hash_original_field = "317D37B0EDC7BD7CBD25D97F53A16CE5", hash_generated_field = "43E95EAF82890431E324C86C2CA01A7C")

    protected DatagramSocket sock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.836 -0400", hash_original_field = "39044C41F340C67BFA15E91CC6E98E7D", hash_generated_field = "911E18F9BE05473489F5F21C894DF579")

    protected boolean isRunning;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.846 -0400", hash_original_method = "B90AB6AB06537F29C47617DE501651D0", hash_generated_method = "D2395B3A4A61042600646FD604F511C7")
    protected  UDPMessageProcessor(InetAddress ipAddress,
            SIPTransactionStack sipStack, int port) throws IOException {
        super(ipAddress, port, "udp",sipStack);
        this.sipStack = sipStack;
        this.messageQueue = new LinkedList();
        this.port = port;
        try 
        {
            this.sock = sipStack.getNetworkLayer().createDatagramSocket(port,
                    ipAddress);
            sock.setReceiveBufferSize(sipStack.getReceiveUdpBufferSize());
            sock.setSendBufferSize(sipStack.getSendUdpBufferSize());
            {
                boolean var46FED3B4BFF5116E71958BFD793E43B5_796074924 = (sipStack.getThreadAuditor().isEnabled());
                {
                    sock.setSoTimeout((int) sipStack.getThreadAuditor().getPingIntervalInMillisecs());
                } //End block
            } //End collapsed parenthetic
            {
                boolean varD1BE6C23219ED1C9F3C841855E84D09F_485142325 = (ipAddress.getHostAddress().equals(IN_ADDR_ANY)  ||
                 ipAddress.getHostAddress().equals(IN6_ADDR_ANY));
                {
                    super.setIpAddress( sock.getLocalAddress() );
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (SocketException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException(ex.getMessage());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.846 -0400", hash_original_method = "1804D4B8ED6914D43C8BF926A65BA4F9", hash_generated_method = "563A8518FF3D227E9D78DB6B1181FE32")
    public int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1592508049 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1592508049;
        // ---------- Original Method ----------
        //return this.port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.847 -0400", hash_original_method = "5E3073F0FEC53FA8E5673A840E14FE8B", hash_generated_method = "CF0772845371C43C29E6A36B1CCF5C68")
    public void start() throws IOException {
        this.isRunning = true;
        Thread thread;
        thread = new Thread(this);
        thread.setDaemon(true);
        thread.setName("UDPMessageProcessorThread");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        // ---------- Original Method ----------
        //this.isRunning = true;
        //Thread thread = new Thread(this);
        //thread.setDaemon(true);
        //thread.setName("UDPMessageProcessorThread");
        //thread.setPriority(Thread.MAX_PRIORITY);
        //thread.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.848 -0400", hash_original_method = "5BA484CD985BE2E9792A2B4863AB23E2", hash_generated_method = "A9277628C929EF14F3B12EA0D2022587")
    public void run() {
        this.messageChannels = new LinkedList();
        {
            {
                int i;
                i = 0;
                {
                    UDPMessageChannel channel;
                    channel = new UDPMessageChannel(sipStack,
                        this);
                    this.messageChannels.add(channel);
                } //End block
            } //End collapsed parenthetic
        } //End block
        ThreadAuditor.ThreadHandle threadHandle;
        threadHandle = sipStack.getThreadAuditor().addCurrentThread();
        {
            try 
            {
                threadHandle.ping();
                int bufsize;
                bufsize = sock.getReceiveBufferSize();
                byte message[];
                message = new byte[bufsize];
                DatagramPacket packet;
                packet = new DatagramPacket(message, bufsize);
                sock.receive(packet);
                {
                    {
                        boolean var57B163C27C030E6A3FA5B4D24C92F446_14231618 = (this.messageQueue.size() >= HIGHWAT);
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1558260052 = (sipStack.isLoggingEnabled());
                                {
                                    sipStack.getStackLogger().logDebug("Dropping message -- queue length exceeded");
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            boolean var5FE425B75B6597412D9AB90A0E23C029_985967997 = (this.messageQueue.size() > LOWAT && this .messageQueue.size() < HIGHWAT);
                            {
                                float threshold;
                                threshold = ((float)(messageQueue.size() - LOWAT))/ ((float)(HIGHWAT - LOWAT));
                                boolean decision;
                                decision = Math.random() > 1.0 - threshold;
                                {
                                    {
                                        boolean var6FE8ACC5352DCA3449210F8EDED912B3_634735427 = (sipStack.isLoggingEnabled());
                                        {
                                            sipStack.getStackLogger().logDebug("Dropping message with probability  " + (1.0 - threshold));
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        this.messageQueue.add(packet);
                        this.messageQueue.notify();
                    } //End block
                } //End block
                {
                    new UDPMessageChannel(sipStack, this, packet);
                } //End block
            } //End block
            catch (SocketTimeoutException ex)
            { }
            catch (SocketException ex)
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_2134475931 = (sipStack.isLoggingEnabled());
                    getSIPStack().getStackLogger()
                            .logDebug("UDPMessageProcessor: Stopping");
                } //End collapsed parenthetic
                isRunning = false;
                {
                    this.messageQueue.notifyAll();
                } //End block
            } //End block
            catch (IOException ex)
            {
                isRunning = false;
                ex.printStackTrace();
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_238010527 = (sipStack.isLoggingEnabled());
                    getSIPStack().getStackLogger()
                            .logDebug("UDPMessageProcessor: Got an IO Exception");
                } //End collapsed parenthetic
            } //End block
            catch (Exception ex)
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_2080025286 = (sipStack.isLoggingEnabled());
                    getSIPStack().getStackLogger()
                            .logDebug("UDPMessageProcessor: Unexpected Exception - quitting");
                } //End collapsed parenthetic
                InternalErrorHandler.handleException(ex);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.858 -0400", hash_original_method = "98470A6BD6E1C018549BCC7706D1DEF2", hash_generated_method = "932E19E0176FC6DC67FFB37935BC33B9")
    public void stop() {
        {
            this.isRunning = false;
            this.messageQueue.notifyAll();
            sock.close();
        } //End block
        // ---------- Original Method ----------
        //synchronized (this.messageQueue) {
            //this.isRunning = false;
            //this.messageQueue.notifyAll();
            //sock.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.859 -0400", hash_original_method = "026D790579A301E1D49F85E52A57E43F", hash_generated_method = "5E62B94E3289744BE2E32560772EA188")
    public String getTransport() {
        String varB4EAC82CA7396A68D541C85D26508E83_1763699465 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1763699465 = "udp";
        varB4EAC82CA7396A68D541C85D26508E83_1763699465.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1763699465;
        // ---------- Original Method ----------
        //return "udp";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.859 -0400", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "744EF90FD43686111F011746581B441F")
    public SIPTransactionStack getSIPStack() {
        SIPTransactionStack varB4EAC82CA7396A68D541C85D26508E83_1459060760 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1459060760 = sipStack;
        varB4EAC82CA7396A68D541C85D26508E83_1459060760.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1459060760;
        // ---------- Original Method ----------
        //return sipStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.869 -0400", hash_original_method = "886709B501C0AFC116858EC5EEF3AF72", hash_generated_method = "5D85394E9A1B0159ECD1FA407DC2DC4E")
    public MessageChannel createMessageChannel(HostPort targetHostPort) throws UnknownHostException {
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_1239535389 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1239535389 = new UDPMessageChannel(targetHostPort.getInetAddress(),
                targetHostPort.getPort(), sipStack, this);
        addTaint(targetHostPort.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1239535389.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1239535389;
        // ---------- Original Method ----------
        //return new UDPMessageChannel(targetHostPort.getInetAddress(),
                //targetHostPort.getPort(), sipStack, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.870 -0400", hash_original_method = "3D05557B9B28DB0617B949ABC7CCF983", hash_generated_method = "077D677A6D9B7D97B2E17B8B1E2B88DB")
    public MessageChannel createMessageChannel(InetAddress host, int port) throws IOException {
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_889325144 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_889325144 = new UDPMessageChannel(host, port, sipStack, this);
        addTaint(host.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_889325144.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_889325144;
        // ---------- Original Method ----------
        //return new UDPMessageChannel(host, port, sipStack, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.871 -0400", hash_original_method = "549BD73BE1E8477C39668DF3AD0A0CF5", hash_generated_method = "55DDA490F4E0E0939CE6BD7272906391")
    public int getDefaultTargetPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_903419218 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_903419218;
        // ---------- Original Method ----------
        //return 5060;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.871 -0400", hash_original_method = "51201694E0EE76265BF39848EF10BE9C", hash_generated_method = "F73AB3553632E3DEE1FBE8CB33E7FECD")
    public boolean isSecure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1318826996 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1318826996;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.872 -0400", hash_original_method = "DB826EFA52B3A7F2C697730E780269B9", hash_generated_method = "4EDE56025AD08A1A8ECFBDC57FCF6A88")
    public int getMaximumMessageSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1851198136 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1851198136;
        // ---------- Original Method ----------
        //return 8*1024;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.872 -0400", hash_original_method = "08919BACEEB275448156EA2ACF7B3D6A", hash_generated_method = "7DD7E7504B6A325E8F7EBBD5E07C9E51")
    public boolean inUse() {
        {
            boolean var47A9601AF273D53C51D4724029DABDA6_555052650 = (messageQueue.size() != 0);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1874030634 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1874030634;
        // ---------- Original Method ----------
        //synchronized (messageQueue) {
            //return messageQueue.size() != 0;
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.872 -0400", hash_original_field = "885D79652DA64F9295484A7C2C959B72", hash_generated_field = "917993EB19017C45514475F8357278E2")

    private static int HIGHWAT = 5000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.872 -0400", hash_original_field = "F2286BC39DF4D606D545B47616E9B69E", hash_generated_field = "3ABC2514788A8A3BA16CB5E182F75DBA")

    private static int LOWAT = 2500;
}

