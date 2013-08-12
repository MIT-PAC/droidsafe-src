package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.core.HostPort;
import gov.nist.core.InternalErrorHandler;
import gov.nist.core.ThreadAuditor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.LinkedList;






public class UDPMessageProcessor extends MessageProcessor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.106 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.106 -0400", hash_original_field = "C938FFE4BD56522A7A21A98657F47F2A", hash_generated_field = "C93CF307E97B9E62367601E63458BFCC")

    protected LinkedList messageQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.106 -0400", hash_original_field = "430227A9310EA04063863CFF91801A04", hash_generated_field = "6AE79C808B860BF3147A11B4D0A7A4B0")

    protected LinkedList messageChannels;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.106 -0400", hash_original_field = "CDE1F9B6C35FC856E715F186A9E26998", hash_generated_field = "C7EB24484DBA63450BB85C2FA7FA489F")

    protected int threadPoolSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.106 -0400", hash_original_field = "317D37B0EDC7BD7CBD25D97F53A16CE5", hash_generated_field = "43E95EAF82890431E324C86C2CA01A7C")

    protected DatagramSocket sock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.106 -0400", hash_original_field = "39044C41F340C67BFA15E91CC6E98E7D", hash_generated_field = "911E18F9BE05473489F5F21C894DF579")

    protected boolean isRunning;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.107 -0400", hash_original_method = "B90AB6AB06537F29C47617DE501651D0", hash_generated_method = "DFDEAA70CD4A6FE61DD77994AFC8EE1D")
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
            if(sipStack.getThreadAuditor().isEnabled())            
            {
                sock.setSoTimeout((int) sipStack.getThreadAuditor().getPingIntervalInMillisecs());
            } //End block
            if(ipAddress.getHostAddress().equals(IN_ADDR_ANY)  ||
                 ipAddress.getHostAddress().equals(IN6_ADDR_ANY))            
            {
                super.setIpAddress( sock.getLocalAddress() );
            } //End block
        } //End block
        catch (SocketException ex)
        {
            IOException var1FC0CF6650AEC5395B2E1C7E06C33B6F_1090691050 = new IOException(ex.getMessage());
            var1FC0CF6650AEC5395B2E1C7E06C33B6F_1090691050.addTaint(taint);
            throw var1FC0CF6650AEC5395B2E1C7E06C33B6F_1090691050;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.108 -0400", hash_original_method = "1804D4B8ED6914D43C8BF926A65BA4F9", hash_generated_method = "6ACCC62E1696E2820CB3AE3D8C464C0A")
    public int getPort() {
        int var02075052AFB1BA5EC4413B52BC401B14_1607871866 = (this.port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1364957200 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1364957200;
        // ---------- Original Method ----------
        //return this.port;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.109 -0400", hash_original_method = "5E3073F0FEC53FA8E5673A840E14FE8B", hash_generated_method = "A0972AE4DD5850B550374F0CE8279628")
    public void start() throws IOException {
        this.isRunning = true;
        Thread thread = new Thread(this);
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.110 -0400", hash_original_method = "5BA484CD985BE2E9792A2B4863AB23E2", hash_generated_method = "EA6CC3C43F774879BF434881D63A2374")
    public void run() {
        this.messageChannels = new LinkedList();
        if(sipStack.threadPoolSize != -1)        
        {
for(int i = 0;i < sipStack.threadPoolSize;i++)
            {
                UDPMessageChannel channel = new UDPMessageChannel(sipStack,
                        this);
                this.messageChannels.add(channel);
            } //End block
        } //End block
        ThreadAuditor.ThreadHandle threadHandle = sipStack.getThreadAuditor().addCurrentThread();
        while
(this.isRunning)        
        {
            try 
            {
                threadHandle.ping();
                int bufsize = sock.getReceiveBufferSize();
                byte message[] = new byte[bufsize];
                DatagramPacket packet = new DatagramPacket(message, bufsize);
                sock.receive(packet);
                if(sipStack.stackDoesCongestionControl)                
                {
                    if(this.messageQueue.size() >= HIGHWAT)                    
                    {
                        if(sipStack.isLoggingEnabled())                        
                        {
                            sipStack.getStackLogger().logDebug("Dropping message -- queue length exceeded");
                        } //End block
                        continue;
                    } //End block
                    else
                    if(this.messageQueue.size() > LOWAT && this .messageQueue.size() < HIGHWAT)                    
                    {
                        float threshold = ((float)(messageQueue.size() - LOWAT))/ ((float)(HIGHWAT - LOWAT));
                        boolean decision = Math.random() > 1.0 - threshold;
                        if(decision)                        
                        {
                            if(sipStack.isLoggingEnabled())                            
                            {
                                sipStack.getStackLogger().logDebug("Dropping message with probability  " + (1.0 - threshold));
                            } //End block
                            continue;
                        } //End block
                    } //End block
                } //End block
                if(sipStack.threadPoolSize != -1)                
                {
                    synchronized
(this.messageQueue)                    {
                        this.messageQueue.add(packet);
                        this.messageQueue.notify();
                    } //End block
                } //End block
                else
                {
                    new UDPMessageChannel(sipStack, this, packet);
                } //End block
            } //End block
            catch (SocketTimeoutException ex)
            {
            } //End block
            catch (SocketException ex)
            {
                if(sipStack.isLoggingEnabled())                
                getSIPStack().getStackLogger()
                            .logDebug("UDPMessageProcessor: Stopping");
                isRunning = false;
                synchronized
(this.messageQueue)                {
                    this.messageQueue.notifyAll();
                } //End block
            } //End block
            catch (IOException ex)
            {
                isRunning = false;
                ex.printStackTrace();
                if(sipStack.isLoggingEnabled())                
                getSIPStack().getStackLogger()
                            .logDebug("UDPMessageProcessor: Got an IO Exception");
            } //End block
            catch (Exception ex)
            {
                if(sipStack.isLoggingEnabled())                
                getSIPStack().getStackLogger()
                            .logDebug("UDPMessageProcessor: Unexpected Exception - quitting");
                InternalErrorHandler.handleException(ex);
                return;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.111 -0400", hash_original_method = "98470A6BD6E1C018549BCC7706D1DEF2", hash_generated_method = "DEE9E68F7495B51DEDE73AD9F0860BE7")
    public void stop() {
        synchronized
(this.messageQueue)        {
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.111 -0400", hash_original_method = "026D790579A301E1D49F85E52A57E43F", hash_generated_method = "57C143D768E111AF059230F9A78AAC71")
    public String getTransport() {
String varE18869BCC217F933D5BEC4AD2789E8C2_45037072 =         "udp";
        varE18869BCC217F933D5BEC4AD2789E8C2_45037072.addTaint(taint);
        return varE18869BCC217F933D5BEC4AD2789E8C2_45037072;
        // ---------- Original Method ----------
        //return "udp";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.112 -0400", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "D9718C6EFF17AC9E2FC6BAE25165E70B")
    public SIPTransactionStack getSIPStack() {
SIPTransactionStack var0FC1F21ED47F4C0C48881B0DAF112A16_87332513 =         sipStack;
        var0FC1F21ED47F4C0C48881B0DAF112A16_87332513.addTaint(taint);
        return var0FC1F21ED47F4C0C48881B0DAF112A16_87332513;
        // ---------- Original Method ----------
        //return sipStack;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.112 -0400", hash_original_method = "886709B501C0AFC116858EC5EEF3AF72", hash_generated_method = "8EB94608C9ADA10F3ED231E8D448E45E")
    public MessageChannel createMessageChannel(HostPort targetHostPort) throws UnknownHostException {
        addTaint(targetHostPort.getTaint());
MessageChannel var51A5FA6D80BB3999C3854A889F036DB4_1664124002 =         new UDPMessageChannel(targetHostPort.getInetAddress(),
                targetHostPort.getPort(), sipStack, this);
        var51A5FA6D80BB3999C3854A889F036DB4_1664124002.addTaint(taint);
        return var51A5FA6D80BB3999C3854A889F036DB4_1664124002;
        // ---------- Original Method ----------
        //return new UDPMessageChannel(targetHostPort.getInetAddress(),
                //targetHostPort.getPort(), sipStack, this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.112 -0400", hash_original_method = "3D05557B9B28DB0617B949ABC7CCF983", hash_generated_method = "22C7EA03FDC0E3213A3598B326068458")
    public MessageChannel createMessageChannel(InetAddress host, int port) throws IOException {
        addTaint(port);
        addTaint(host.getTaint());
MessageChannel var4DFA87B35326126B9FDC6EC60744E8BF_801772448 =         new UDPMessageChannel(host, port, sipStack, this);
        var4DFA87B35326126B9FDC6EC60744E8BF_801772448.addTaint(taint);
        return var4DFA87B35326126B9FDC6EC60744E8BF_801772448;
        // ---------- Original Method ----------
        //return new UDPMessageChannel(host, port, sipStack, this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.112 -0400", hash_original_method = "549BD73BE1E8477C39668DF3AD0A0CF5", hash_generated_method = "F056A78F6FBD91067BF56B67630297D6")
    public int getDefaultTargetPort() {
        int var8D749EA54F6657B0396C204D3148DA60_553153831 = (5060);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_811317514 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_811317514;
        // ---------- Original Method ----------
        //return 5060;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.113 -0400", hash_original_method = "51201694E0EE76265BF39848EF10BE9C", hash_generated_method = "7314A70738D64057E0E99BB76702CA9B")
    public boolean isSecure() {
        boolean var68934A3E9455FA72420237EB05902327_1943941834 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_404111670 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_404111670;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.113 -0400", hash_original_method = "DB826EFA52B3A7F2C697730E780269B9", hash_generated_method = "87DFFD6BD6895010A148744D5109573A")
    public int getMaximumMessageSize() {
        int varAD04A08C2844A5CBB6EB9D33A60594F0_1064090436 = (8*1024);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1159199367 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1159199367;
        // ---------- Original Method ----------
        //return 8*1024;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.113 -0400", hash_original_method = "08919BACEEB275448156EA2ACF7B3D6A", hash_generated_method = "5F5D7108BE459BA263F651CADBD5C3FD")
    public boolean inUse() {
        synchronized
(messageQueue)        {
            boolean var40229282B35DBE2FF9DA4A8C21EEBA3E_1855638135 = (messageQueue.size() != 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_938086936 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_938086936;
        } //End block
        // ---------- Original Method ----------
        //synchronized (messageQueue) {
            //return messageQueue.size() != 0;
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.113 -0400", hash_original_field = "885D79652DA64F9295484A7C2C959B72", hash_generated_field = "174D18645F1F98D2E6C01C2210EC5A14")

    private static final int HIGHWAT = 5000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.113 -0400", hash_original_field = "F2286BC39DF4D606D545B47616E9B69E", hash_generated_field = "A95D179CF5D63D2E6F42DEFD017C99EB")

    private static final int LOWAT = 2500;
}

