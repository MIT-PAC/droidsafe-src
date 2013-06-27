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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.104 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.104 -0400", hash_original_field = "C938FFE4BD56522A7A21A98657F47F2A", hash_generated_field = "C93CF307E97B9E62367601E63458BFCC")

    protected LinkedList messageQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.104 -0400", hash_original_field = "430227A9310EA04063863CFF91801A04", hash_generated_field = "6AE79C808B860BF3147A11B4D0A7A4B0")

    protected LinkedList messageChannels;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.104 -0400", hash_original_field = "CDE1F9B6C35FC856E715F186A9E26998", hash_generated_field = "C7EB24484DBA63450BB85C2FA7FA489F")

    protected int threadPoolSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.104 -0400", hash_original_field = "317D37B0EDC7BD7CBD25D97F53A16CE5", hash_generated_field = "43E95EAF82890431E324C86C2CA01A7C")

    protected DatagramSocket sock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.105 -0400", hash_original_field = "39044C41F340C67BFA15E91CC6E98E7D", hash_generated_field = "911E18F9BE05473489F5F21C894DF579")

    protected boolean isRunning;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.106 -0400", hash_original_method = "B90AB6AB06537F29C47617DE501651D0", hash_generated_method = "2FB7C4491BB9C58D45923FD89159C82B")
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
                boolean var46FED3B4BFF5116E71958BFD793E43B5_878414352 = (sipStack.getThreadAuditor().isEnabled());
                {
                    sock.setSoTimeout((int) sipStack.getThreadAuditor().getPingIntervalInMillisecs());
                } //End block
            } //End collapsed parenthetic
            {
                boolean varD1BE6C23219ED1C9F3C841855E84D09F_276710571 = (ipAddress.getHostAddress().equals(IN_ADDR_ANY)  ||
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.106 -0400", hash_original_method = "1804D4B8ED6914D43C8BF926A65BA4F9", hash_generated_method = "4DEE4DEFFE9261A7E9505704F1646C45")
    public int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2020747969 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2020747969;
        // ---------- Original Method ----------
        //return this.port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.126 -0400", hash_original_method = "5E3073F0FEC53FA8E5673A840E14FE8B", hash_generated_method = "CF0772845371C43C29E6A36B1CCF5C68")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.129 -0400", hash_original_method = "5BA484CD985BE2E9792A2B4863AB23E2", hash_generated_method = "6EDEA97B0E153E421E9A64A6ABE811E7")
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
                        boolean var57B163C27C030E6A3FA5B4D24C92F446_1060268367 = (this.messageQueue.size() >= HIGHWAT);
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_964482166 = (sipStack.isLoggingEnabled());
                                {
                                    sipStack.getStackLogger().logDebug("Dropping message -- queue length exceeded");
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            boolean var5FE425B75B6597412D9AB90A0E23C029_215477298 = (this.messageQueue.size() > LOWAT && this .messageQueue.size() < HIGHWAT);
                            {
                                float threshold;
                                threshold = ((float)(messageQueue.size() - LOWAT))/ ((float)(HIGHWAT - LOWAT));
                                boolean decision;
                                decision = Math.random() > 1.0 - threshold;
                                {
                                    {
                                        boolean var6FE8ACC5352DCA3449210F8EDED912B3_1680477636 = (sipStack.isLoggingEnabled());
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
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1156425218 = (sipStack.isLoggingEnabled());
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
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1423271490 = (sipStack.isLoggingEnabled());
                    getSIPStack().getStackLogger()
                            .logDebug("UDPMessageProcessor: Got an IO Exception");
                } //End collapsed parenthetic
            } //End block
            catch (Exception ex)
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1943844363 = (sipStack.isLoggingEnabled());
                    getSIPStack().getStackLogger()
                            .logDebug("UDPMessageProcessor: Unexpected Exception - quitting");
                } //End collapsed parenthetic
                InternalErrorHandler.handleException(ex);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.129 -0400", hash_original_method = "98470A6BD6E1C018549BCC7706D1DEF2", hash_generated_method = "932E19E0176FC6DC67FFB37935BC33B9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.137 -0400", hash_original_method = "026D790579A301E1D49F85E52A57E43F", hash_generated_method = "44C62E6FB91E09E349277C27BFD9C964")
    public String getTransport() {
        String varB4EAC82CA7396A68D541C85D26508E83_1711736635 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1711736635 = "udp";
        varB4EAC82CA7396A68D541C85D26508E83_1711736635.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1711736635;
        // ---------- Original Method ----------
        //return "udp";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.137 -0400", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "9BE84AC88226BD7A078BD08178698871")
    public SIPTransactionStack getSIPStack() {
        SIPTransactionStack varB4EAC82CA7396A68D541C85D26508E83_1038659667 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1038659667 = sipStack;
        varB4EAC82CA7396A68D541C85D26508E83_1038659667.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1038659667;
        // ---------- Original Method ----------
        //return sipStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.138 -0400", hash_original_method = "886709B501C0AFC116858EC5EEF3AF72", hash_generated_method = "979074399B45D254461AE66527856336")
    public MessageChannel createMessageChannel(HostPort targetHostPort) throws UnknownHostException {
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_1392173546 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1392173546 = new UDPMessageChannel(targetHostPort.getInetAddress(),
                targetHostPort.getPort(), sipStack, this);
        addTaint(targetHostPort.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1392173546.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1392173546;
        // ---------- Original Method ----------
        //return new UDPMessageChannel(targetHostPort.getInetAddress(),
                //targetHostPort.getPort(), sipStack, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.138 -0400", hash_original_method = "3D05557B9B28DB0617B949ABC7CCF983", hash_generated_method = "523E76F11D493381E51CD5C86309F755")
    public MessageChannel createMessageChannel(InetAddress host, int port) throws IOException {
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_1334425842 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1334425842 = new UDPMessageChannel(host, port, sipStack, this);
        addTaint(host.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_1334425842.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1334425842;
        // ---------- Original Method ----------
        //return new UDPMessageChannel(host, port, sipStack, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.139 -0400", hash_original_method = "549BD73BE1E8477C39668DF3AD0A0CF5", hash_generated_method = "B92DAE871680292EEC1A307271DFFC0D")
    public int getDefaultTargetPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_540790970 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_540790970;
        // ---------- Original Method ----------
        //return 5060;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.149 -0400", hash_original_method = "51201694E0EE76265BF39848EF10BE9C", hash_generated_method = "D2A3AD77E2E5E484C000917AD368857F")
    public boolean isSecure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1226305425 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1226305425;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.149 -0400", hash_original_method = "DB826EFA52B3A7F2C697730E780269B9", hash_generated_method = "277A5591EA8CF0695BA7400E2A193424")
    public int getMaximumMessageSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_517402475 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_517402475;
        // ---------- Original Method ----------
        //return 8*1024;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.149 -0400", hash_original_method = "08919BACEEB275448156EA2ACF7B3D6A", hash_generated_method = "40444D21420D7D49DCFF465F940FA41C")
    public boolean inUse() {
        {
            boolean var47A9601AF273D53C51D4724029DABDA6_1694679535 = (messageQueue.size() != 0);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_495034048 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_495034048;
        // ---------- Original Method ----------
        //synchronized (messageQueue) {
            //return messageQueue.size() != 0;
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.149 -0400", hash_original_field = "885D79652DA64F9295484A7C2C959B72", hash_generated_field = "917993EB19017C45514475F8357278E2")

    private static int HIGHWAT = 5000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.149 -0400", hash_original_field = "F2286BC39DF4D606D545B47616E9B69E", hash_generated_field = "3ABC2514788A8A3BA16CB5E182F75DBA")

    private static int LOWAT = 2500;
}

