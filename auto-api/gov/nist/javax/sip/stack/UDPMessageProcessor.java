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
    private int port;
    protected LinkedList messageQueue;
    protected LinkedList messageChannels;
    protected int threadPoolSize;
    protected DatagramSocket sock;
    protected boolean isRunning;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.317 -0400", hash_original_method = "B90AB6AB06537F29C47617DE501651D0", hash_generated_method = "84627AF7690B0108E47E143C4C70077B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected UDPMessageProcessor(InetAddress ipAddress,
            SIPTransactionStack sipStack, int port) throws IOException {
        super(ipAddress, port, "udp",sipStack);
        dsTaint.addTaint(port);
        dsTaint.addTaint(sipStack.dsTaint);
        dsTaint.addTaint(ipAddress.dsTaint);
        this.sipStack = sipStack;
        this.messageQueue = new LinkedList();
        try 
        {
            this.sock = sipStack.getNetworkLayer().createDatagramSocket(port,
                    ipAddress);
            sock.setReceiveBufferSize(sipStack.getReceiveUdpBufferSize());
            sock.setSendBufferSize(sipStack.getSendUdpBufferSize());
            {
                boolean var46FED3B4BFF5116E71958BFD793E43B5_1029265754 = (sipStack.getThreadAuditor().isEnabled());
                {
                    sock.setSoTimeout((int) sipStack.getThreadAuditor().getPingIntervalInMillisecs());
                } //End block
            } //End collapsed parenthetic
            {
                boolean varD1BE6C23219ED1C9F3C841855E84D09F_244530315 = (ipAddress.getHostAddress().equals(IN_ADDR_ANY)  ||
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.319 -0400", hash_original_method = "1804D4B8ED6914D43C8BF926A65BA4F9", hash_generated_method = "4021B087F2BB6C57EEDF3334B742310D")
    @DSModeled(DSC.SAFE)
    public int getPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.320 -0400", hash_original_method = "5E3073F0FEC53FA8E5673A840E14FE8B", hash_generated_method = "CF0772845371C43C29E6A36B1CCF5C68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.323 -0400", hash_original_method = "5BA484CD985BE2E9792A2B4863AB23E2", hash_generated_method = "DFD4F9F30E75840D375A83F4FA6EED92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                        boolean var57B163C27C030E6A3FA5B4D24C92F446_192747323 = (this.messageQueue.size() >= HIGHWAT);
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_777315836 = (sipStack.isLoggingEnabled());
                                {
                                    sipStack.getStackLogger().logDebug("Dropping message -- queue length exceeded");
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            boolean var5FE425B75B6597412D9AB90A0E23C029_400924705 = (this.messageQueue.size() > LOWAT && this .messageQueue.size() < HIGHWAT);
                            {
                                float threshold;
                                threshold = ((float)(messageQueue.size() - LOWAT))/ ((float)(HIGHWAT - LOWAT));
                                boolean decision;
                                decision = Math.random() > 1.0 - threshold;
                                {
                                    {
                                        boolean var6FE8ACC5352DCA3449210F8EDED912B3_300286712 = (sipStack.isLoggingEnabled());
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
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_909174213 = (sipStack.isLoggingEnabled());
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
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_904728679 = (sipStack.isLoggingEnabled());
                    getSIPStack().getStackLogger()
                            .logDebug("UDPMessageProcessor: Got an IO Exception");
                } //End collapsed parenthetic
            } //End block
            catch (Exception ex)
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_753931358 = (sipStack.isLoggingEnabled());
                    getSIPStack().getStackLogger()
                            .logDebug("UDPMessageProcessor: Unexpected Exception - quitting");
                } //End collapsed parenthetic
                InternalErrorHandler.handleException(ex);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.323 -0400", hash_original_method = "98470A6BD6E1C018549BCC7706D1DEF2", hash_generated_method = "932E19E0176FC6DC67FFB37935BC33B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.323 -0400", hash_original_method = "026D790579A301E1D49F85E52A57E43F", hash_generated_method = "F65200E28DD2D02E3D677E7DC5FB6566")
    @DSModeled(DSC.SAFE)
    public String getTransport() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "udp";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.324 -0400", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "0AAC993F2B0EE288482DFA16632D8269")
    @DSModeled(DSC.SAFE)
    public SIPTransactionStack getSIPStack() {
        return (SIPTransactionStack)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sipStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.324 -0400", hash_original_method = "886709B501C0AFC116858EC5EEF3AF72", hash_generated_method = "8CD982E8879B1FCCD9DB6B75EECA6A81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MessageChannel createMessageChannel(HostPort targetHostPort) throws UnknownHostException {
        dsTaint.addTaint(targetHostPort.dsTaint);
        MessageChannel var0696AE0B7E1C187335C429D260BBD587_1048572039 = (new UDPMessageChannel(targetHostPort.getInetAddress(),
                targetHostPort.getPort(), sipStack, this));
        return (MessageChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new UDPMessageChannel(targetHostPort.getInetAddress(),
                //targetHostPort.getPort(), sipStack, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.324 -0400", hash_original_method = "3D05557B9B28DB0617B949ABC7CCF983", hash_generated_method = "01291CEC1393E69738855C9F6342A146")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MessageChannel createMessageChannel(InetAddress host, int port) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host.dsTaint);
        MessageChannel varB5682123F6CB4E29D6B81F4B4257DC2F_1821580005 = (new UDPMessageChannel(host, port, sipStack, this));
        return (MessageChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new UDPMessageChannel(host, port, sipStack, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.324 -0400", hash_original_method = "549BD73BE1E8477C39668DF3AD0A0CF5", hash_generated_method = "8401D47F99A5F58D3683F33A3E38B4D5")
    @DSModeled(DSC.SAFE)
    public int getDefaultTargetPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 5060;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.324 -0400", hash_original_method = "51201694E0EE76265BF39848EF10BE9C", hash_generated_method = "7FD317C466D6873CE376C80F23CBD437")
    @DSModeled(DSC.SAFE)
    public boolean isSecure() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.324 -0400", hash_original_method = "DB826EFA52B3A7F2C697730E780269B9", hash_generated_method = "CA5727F0077C91141EB7432CFA3FACA5")
    @DSModeled(DSC.SAFE)
    public int getMaximumMessageSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 8*1024;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.325 -0400", hash_original_method = "08919BACEEB275448156EA2ACF7B3D6A", hash_generated_method = "6810B4AD139FDFB4F777A5069355FBBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean inUse() {
        {
            boolean var47A9601AF273D53C51D4724029DABDA6_1499281384 = (messageQueue.size() != 0);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (messageQueue) {
            //return messageQueue.size() != 0;
        //}
    }

    
    private static final int HIGHWAT=5000;
    private static final int LOWAT=2500;
}

