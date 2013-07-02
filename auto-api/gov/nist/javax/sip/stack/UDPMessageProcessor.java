package gov.nist.javax.sip.stack;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.util.LinkedList;
import java.net.*;
import gov.nist.core.*;

public class UDPMessageProcessor extends MessageProcessor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.254 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.254 -0400", hash_original_field = "C938FFE4BD56522A7A21A98657F47F2A", hash_generated_field = "C93CF307E97B9E62367601E63458BFCC")

    protected LinkedList messageQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.254 -0400", hash_original_field = "430227A9310EA04063863CFF91801A04", hash_generated_field = "6AE79C808B860BF3147A11B4D0A7A4B0")

    protected LinkedList messageChannels;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.254 -0400", hash_original_field = "CDE1F9B6C35FC856E715F186A9E26998", hash_generated_field = "C7EB24484DBA63450BB85C2FA7FA489F")

    protected int threadPoolSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.254 -0400", hash_original_field = "317D37B0EDC7BD7CBD25D97F53A16CE5", hash_generated_field = "43E95EAF82890431E324C86C2CA01A7C")

    protected DatagramSocket sock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.254 -0400", hash_original_field = "39044C41F340C67BFA15E91CC6E98E7D", hash_generated_field = "911E18F9BE05473489F5F21C894DF579")

    protected boolean isRunning;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.255 -0400", hash_original_method = "B90AB6AB06537F29C47617DE501651D0", hash_generated_method = "775BC040CD2D8C8C2A8FFE9B85AEAAC0")
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
                boolean var46FED3B4BFF5116E71958BFD793E43B5_896040852 = (sipStack.getThreadAuditor().isEnabled());
                {
                    sock.setSoTimeout((int) sipStack.getThreadAuditor().getPingIntervalInMillisecs());
                } 
            } 
            {
                boolean varD1BE6C23219ED1C9F3C841855E84D09F_1184803719 = (ipAddress.getHostAddress().equals(IN_ADDR_ANY)  ||
                 ipAddress.getHostAddress().equals(IN6_ADDR_ANY));
                {
                    super.setIpAddress( sock.getLocalAddress() );
                } 
            } 
        } 
        catch (SocketException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException(ex.getMessage());
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.256 -0400", hash_original_method = "1804D4B8ED6914D43C8BF926A65BA4F9", hash_generated_method = "DB37D0616C8A0CE34B3C06042E2C066B")
    public int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1777791535 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1777791535;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.256 -0400", hash_original_method = "5E3073F0FEC53FA8E5673A840E14FE8B", hash_generated_method = "A0972AE4DD5850B550374F0CE8279628")
    public void start() throws IOException {
        this.isRunning = true;
        Thread thread = new Thread(this);
        thread.setDaemon(true);
        thread.setName("UDPMessageProcessorThread");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.257 -0400", hash_original_method = "5BA484CD985BE2E9792A2B4863AB23E2", hash_generated_method = "9E428EF511DE1006CD71C2E9E29909F8")
    public void run() {
        this.messageChannels = new LinkedList();
        {
            {
                int i = 0;
                {
                    UDPMessageChannel channel = new UDPMessageChannel(sipStack,
                        this);
                    this.messageChannels.add(channel);
                } 
            } 
        } 
        ThreadAuditor.ThreadHandle threadHandle = sipStack.getThreadAuditor().addCurrentThread();
        {
            try 
            {
                threadHandle.ping();
                int bufsize = sock.getReceiveBufferSize();
                byte message[] = new byte[bufsize];
                DatagramPacket packet = new DatagramPacket(message, bufsize);
                sock.receive(packet);
                {
                    {
                        boolean var57B163C27C030E6A3FA5B4D24C92F446_2052566369 = (this.messageQueue.size() >= HIGHWAT);
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1850323104 = (sipStack.isLoggingEnabled());
                                {
                                    sipStack.getStackLogger().logDebug("Dropping message -- queue length exceeded");
                                } 
                            } 
                        } 
                        {
                            boolean var5FE425B75B6597412D9AB90A0E23C029_499041088 = (this.messageQueue.size() > LOWAT && this .messageQueue.size() < HIGHWAT);
                            {
                                float threshold = ((float)(messageQueue.size() - LOWAT))/ ((float)(HIGHWAT - LOWAT));
                                boolean decision = Math.random() > 1.0 - threshold;
                                {
                                    {
                                        boolean var6FE8ACC5352DCA3449210F8EDED912B3_1707580942 = (sipStack.isLoggingEnabled());
                                        {
                                            sipStack.getStackLogger().logDebug("Dropping message with probability  " + (1.0 - threshold));
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
                {
                    {
                        this.messageQueue.add(packet);
                        this.messageQueue.notify();
                    } 
                } 
                {
                    new UDPMessageChannel(sipStack, this, packet);
                } 
            } 
            catch (SocketTimeoutException ex)
            { }
            catch (SocketException ex)
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_819607739 = (sipStack.isLoggingEnabled());
                    getSIPStack().getStackLogger()
                            .logDebug("UDPMessageProcessor: Stopping");
                } 
                isRunning = false;
                {
                    this.messageQueue.notifyAll();
                } 
            } 
            catch (IOException ex)
            {
                isRunning = false;
                ex.printStackTrace();
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_741252170 = (sipStack.isLoggingEnabled());
                    getSIPStack().getStackLogger()
                            .logDebug("UDPMessageProcessor: Got an IO Exception");
                } 
            } 
            catch (Exception ex)
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1154825794 = (sipStack.isLoggingEnabled());
                    getSIPStack().getStackLogger()
                            .logDebug("UDPMessageProcessor: Unexpected Exception - quitting");
                } 
                InternalErrorHandler.handleException(ex);
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.258 -0400", hash_original_method = "98470A6BD6E1C018549BCC7706D1DEF2", hash_generated_method = "932E19E0176FC6DC67FFB37935BC33B9")
    public void stop() {
        {
            this.isRunning = false;
            this.messageQueue.notifyAll();
            sock.close();
        } 
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.259 -0400", hash_original_method = "026D790579A301E1D49F85E52A57E43F", hash_generated_method = "BA17D630F68A96E79DD85188A6DBFD1D")
    public String getTransport() {
        String varB4EAC82CA7396A68D541C85D26508E83_1375721119 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1375721119 = "udp";
        varB4EAC82CA7396A68D541C85D26508E83_1375721119.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1375721119;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.259 -0400", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "6791ABDF8BE113CE37EDA8DAF1054689")
    public SIPTransactionStack getSIPStack() {
        SIPTransactionStack varB4EAC82CA7396A68D541C85D26508E83_941541027 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_941541027 = sipStack;
        varB4EAC82CA7396A68D541C85D26508E83_941541027.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_941541027;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.260 -0400", hash_original_method = "886709B501C0AFC116858EC5EEF3AF72", hash_generated_method = "AC3C3F17CEF3368EB158A839E63D2FD3")
    public MessageChannel createMessageChannel(HostPort targetHostPort) throws UnknownHostException {
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_1710232669 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1710232669 = new UDPMessageChannel(targetHostPort.getInetAddress(),
                targetHostPort.getPort(), sipStack, this);
        addTaint(targetHostPort.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1710232669.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1710232669;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.260 -0400", hash_original_method = "3D05557B9B28DB0617B949ABC7CCF983", hash_generated_method = "51AB9993C2AD0D8050BDE02FE6366435")
    public MessageChannel createMessageChannel(InetAddress host, int port) throws IOException {
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_828506076 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_828506076 = new UDPMessageChannel(host, port, sipStack, this);
        addTaint(host.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_828506076.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_828506076;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.261 -0400", hash_original_method = "549BD73BE1E8477C39668DF3AD0A0CF5", hash_generated_method = "0F4E8D9F9DE28227B32457B47595666B")
    public int getDefaultTargetPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1920985104 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1920985104;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.261 -0400", hash_original_method = "51201694E0EE76265BF39848EF10BE9C", hash_generated_method = "4C7DD5987CAF749015029BF7B5261BC2")
    public boolean isSecure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2006106903 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2006106903;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.261 -0400", hash_original_method = "DB826EFA52B3A7F2C697730E780269B9", hash_generated_method = "129DDBB3AAFD952ACDC574A1A776B05F")
    public int getMaximumMessageSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2083800168 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2083800168;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.261 -0400", hash_original_method = "08919BACEEB275448156EA2ACF7B3D6A", hash_generated_method = "CCFFF397EF28DC152A0DAC7E6C448143")
    public boolean inUse() {
        {
            boolean var47A9601AF273D53C51D4724029DABDA6_194134881 = (messageQueue.size() != 0);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1142270491 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1142270491;
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.261 -0400", hash_original_field = "885D79652DA64F9295484A7C2C959B72", hash_generated_field = "174D18645F1F98D2E6C01C2210EC5A14")

    private static final int HIGHWAT = 5000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.261 -0400", hash_original_field = "F2286BC39DF4D606D545B47616E9B69E", hash_generated_field = "A95D179CF5D63D2E6F42DEFD017C99EB")

    private static final int LOWAT = 2500;
}

