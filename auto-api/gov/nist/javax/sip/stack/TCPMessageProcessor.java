package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.net.SocketException;
import gov.nist.core.*;
import java.net.*;
import java.util.*;

public class TCPMessageProcessor extends MessageProcessor {
    protected int nConnections;
    private boolean isRunning;
    private Hashtable tcpMessageChannels;
    private ArrayList<TCPMessageChannel> incomingTcpMessageChannels;
    private ServerSocket sock;
    protected int useCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.086 -0400", hash_original_method = "DF01D933234B7570953E27AF1B039A12", hash_generated_method = "752E68203AF50FAC7A10B2A470CAE740")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected TCPMessageProcessor(InetAddress ipAddress, SIPTransactionStack sipStack, int port) {
        super(ipAddress, port, "tcp",sipStack);
        dsTaint.addTaint(port);
        dsTaint.addTaint(sipStack.dsTaint);
        dsTaint.addTaint(ipAddress.dsTaint);
        this.sipStack = sipStack;
        this.tcpMessageChannels = new Hashtable();
        this.incomingTcpMessageChannels = new ArrayList<TCPMessageChannel>();
        // ---------- Original Method ----------
        //this.sipStack = sipStack;
        //this.tcpMessageChannels = new Hashtable();
        //this.incomingTcpMessageChannels = new ArrayList<TCPMessageChannel>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.087 -0400", hash_original_method = "1E47DBAC30060B20437BE89450E78A73", hash_generated_method = "214D0F71A6353BF155FB8A7BECC2845A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void start() throws IOException {
        Thread thread;
        thread = new Thread(this);
        thread.setName("TCPMessageProcessorThread");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.setDaemon(true);
        this.sock = sipStack.getNetworkLayer().createServerSocket(getPort(), 0, getIpAddress());
        {
            boolean varFE83D78CDCA90CC090E44B6626DEB41E_1293191593 = (getIpAddress().getHostAddress().equals(IN_ADDR_ANY)
                || getIpAddress().getHostAddress().equals(IN6_ADDR_ANY));
            {
                super.setIpAddress(sock.getInetAddress());
            } //End block
        } //End collapsed parenthetic
        this.isRunning = true;
        thread.start();
        // ---------- Original Method ----------
        //Thread thread = new Thread(this);
        //thread.setName("TCPMessageProcessorThread");
        //thread.setPriority(Thread.MAX_PRIORITY);
        //thread.setDaemon(true);
        //this.sock = sipStack.getNetworkLayer().createServerSocket(getPort(), 0, getIpAddress());
        //if (getIpAddress().getHostAddress().equals(IN_ADDR_ANY)
                //|| getIpAddress().getHostAddress().equals(IN6_ADDR_ANY)) {
            //super.setIpAddress(sock.getInetAddress());
        //}
        //this.isRunning = true;
        //thread.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.087 -0400", hash_original_method = "BD1C6A6330D89BF80F1DBE244E3DBF31", hash_generated_method = "26361B7AABD2896C735DD6E7335A204C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void run() {
        {
            try 
            {
                {
                    {
                        try 
                        {
                            this.wait();
                        } //End block
                        catch (InterruptedException ex)
                        { }
                    } //End block
                } //End block
                Socket newsock;
                newsock = sock.accept();
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_579457282 = (sipStack.isLoggingEnabled());
                    {
                        getSIPStack().getStackLogger().logDebug("Accepting new connection!");
                    } //End block
                } //End collapsed parenthetic
                incomingTcpMessageChannels.add(new TCPMessageChannel(newsock, sipStack, this));
            } //End block
            catch (SocketException ex)
            {
                this.isRunning = false;
            } //End block
            catch (IOException ex)
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_500865751 = (sipStack.isLoggingEnabled());
                    getSIPStack().getStackLogger().logException(ex);
                } //End collapsed parenthetic
            } //End block
            catch (Exception ex)
            {
                InternalErrorHandler.handleException(ex);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.087 -0400", hash_original_method = "8ED81941CDC62D91B3E3601661099BB4", hash_generated_method = "1C931A72103A910BC29938FDCEEBDBB1")
    @DSModeled(DSC.SAFE)
    public String getTransport() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "tcp";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.087 -0400", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "0AAC993F2B0EE288482DFA16632D8269")
    @DSModeled(DSC.SAFE)
    public SIPTransactionStack getSIPStack() {
        return (SIPTransactionStack)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sipStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.088 -0400", hash_original_method = "EFC3C9ACE40E1AFA4E42220FC9A24C72", hash_generated_method = "33E3D56D1857D968B00034D760E5DC1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void stop() {
        isRunning = false;
        try 
        {
            sock.close();
        } //End block
        catch (IOException e)
        {
            e.printStackTrace();
        } //End block
        Collection en;
        en = tcpMessageChannels.values();
        {
            Iterator it;
            it = en.iterator();
            boolean var03729FD53960D8DCA3A41A13A0229637_1179614034 = (it.hasNext());
            {
                TCPMessageChannel next;
                next = (TCPMessageChannel) it.next();
                next.close();
            } //End block
        } //End collapsed parenthetic
        {
            Iterator incomingMCIterator;
            incomingMCIterator = incomingTcpMessageChannels.iterator();
            boolean var02145023CCC7750962C816C772AD4FC3_1872171959 = (incomingMCIterator
                .hasNext());
            {
                TCPMessageChannel next;
                next = (TCPMessageChannel) incomingMCIterator.next();
                next.close();
            } //End block
        } //End collapsed parenthetic
        this.notify();
        // ---------- Original Method ----------
        //isRunning = false;
        //try {
            //sock.close();
        //} catch (IOException e) {
            //e.printStackTrace();
        //}
        //Collection en = tcpMessageChannels.values();
        //for (Iterator it = en.iterator(); it.hasNext();) {
            //TCPMessageChannel next = (TCPMessageChannel) it.next();
            //next.close();
        //}
        //for (Iterator incomingMCIterator = incomingTcpMessageChannels.iterator(); incomingMCIterator
                //.hasNext();) {
            //TCPMessageChannel next = (TCPMessageChannel) incomingMCIterator.next();
            //next.close();
        //}
        //this.notify();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.088 -0400", hash_original_method = "E63037070BE0B3824038F0C58AF2A6B7", hash_generated_method = "FB6C30DEA6B8417A1C5D13B8BECD05B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected synchronized void remove(TCPMessageChannel tcpMessageChannel) {
        dsTaint.addTaint(tcpMessageChannel.dsTaint);
        String key;
        key = tcpMessageChannel.getKey();
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_637072745 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(Thread.currentThread() + " removing " + key);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB53D4E08822069DDA601F76ED9A80DA6_1112771913 = (tcpMessageChannels.get(key) == tcpMessageChannel);
            {
                this.tcpMessageChannels.remove(key);
            } //End block
        } //End collapsed parenthetic
        incomingTcpMessageChannels.remove(tcpMessageChannel);
        // ---------- Original Method ----------
        //String key = tcpMessageChannel.getKey();
        //if (sipStack.isLoggingEnabled()) {
            //sipStack.getStackLogger().logDebug(Thread.currentThread() + " removing " + key);
        //}
        //if (tcpMessageChannels.get(key) == tcpMessageChannel) {
            //this.tcpMessageChannels.remove(key);
        //}
        //incomingTcpMessageChannels.remove(tcpMessageChannel);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.088 -0400", hash_original_method = "357F90D56DF658376E8E30660A48F527", hash_generated_method = "3815DF25FD103D644EAFDA3B848FE094")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized MessageChannel createMessageChannel(HostPort targetHostPort) throws IOException {
        dsTaint.addTaint(targetHostPort.dsTaint);
        String key;
        key = MessageChannel.getKey(targetHostPort, "TCP");
        {
            boolean varED1B0539F1F1458335819AA7F1CACAFC_1583285226 = (tcpMessageChannels.get(key) != null);
            {
                MessageChannel var2BDFFEAACBFB3C60C08777484BE659B5_1181024975 = ((TCPMessageChannel) this.tcpMessageChannels.get(key));
            } //End block
            {
                TCPMessageChannel retval;
                retval = new TCPMessageChannel(targetHostPort.getInetAddress(),
                    targetHostPort.getPort(), sipStack, this);
                this.tcpMessageChannels.put(key, retval);
                retval.isCached = true;
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1638892679 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug("key " + key);
                        sipStack.getStackLogger().logDebug("Creating " + retval);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (MessageChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //String key = MessageChannel.getKey(targetHostPort, "TCP");
        //if (tcpMessageChannels.get(key) != null) {
            //return (TCPMessageChannel) this.tcpMessageChannels.get(key);
        //} else {
            //TCPMessageChannel retval = new TCPMessageChannel(targetHostPort.getInetAddress(),
                    //targetHostPort.getPort(), sipStack, this);
            //this.tcpMessageChannels.put(key, retval);
            //retval.isCached = true;
            //if (sipStack.isLoggingEnabled()) {
                //sipStack.getStackLogger().logDebug("key " + key);
                //sipStack.getStackLogger().logDebug("Creating " + retval);
            //}
            //return retval;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.089 -0400", hash_original_method = "A1867B08C1B2C4003FD16CE7D97D4BE3", hash_generated_method = "2DAC665D7EFB412674996A4FDE517B46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected synchronized void cacheMessageChannel(TCPMessageChannel messageChannel) {
        dsTaint.addTaint(messageChannel.dsTaint);
        String key;
        key = messageChannel.getKey();
        TCPMessageChannel currentChannel;
        currentChannel = (TCPMessageChannel) tcpMessageChannels.get(key);
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_279103152 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Closing " + key);
            } //End collapsed parenthetic
            currentChannel.close();
        } //End block
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1332702301 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("Caching " + key);
        } //End collapsed parenthetic
        this.tcpMessageChannels.put(key, messageChannel);
        // ---------- Original Method ----------
        //String key = messageChannel.getKey();
        //TCPMessageChannel currentChannel = (TCPMessageChannel) tcpMessageChannels.get(key);
        //if (currentChannel != null) {
            //if (sipStack.isLoggingEnabled())
                //sipStack.getStackLogger().logDebug("Closing " + key);
            //currentChannel.close();
        //}
        //if (sipStack.isLoggingEnabled())
            //sipStack.getStackLogger().logDebug("Caching " + key);
        //this.tcpMessageChannels.put(key, messageChannel);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.089 -0400", hash_original_method = "C7BFFB891EADFA809295B1E355E1D388", hash_generated_method = "A78FEAE9DB15A9388E25C3988E40A4F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized MessageChannel createMessageChannel(InetAddress host, int port) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host.dsTaint);
        try 
        {
            String key;
            key = MessageChannel.getKey(host, port, "TCP");
            {
                boolean var32ECC15F3F0A6B264B1AF22E5961D90C_455344375 = (tcpMessageChannels.get(key) != null);
                {
                    MessageChannel var40F1E50687A43793006D9D1C5634BD73_496091145 = ((TCPMessageChannel) this.tcpMessageChannels.get(key));
                } //End block
                {
                    TCPMessageChannel retval;
                    retval = new TCPMessageChannel(host, port, sipStack, this);
                    this.tcpMessageChannels.put(key, retval);
                    retval.isCached = true;
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_12598795 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logDebug("key " + key);
                            sipStack.getStackLogger().logDebug("Creating " + retval);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (UnknownHostException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException(ex.getMessage());
        } //End block
        return (MessageChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //String key = MessageChannel.getKey(host, port, "TCP");
            //if (tcpMessageChannels.get(key) != null) {
                //return (TCPMessageChannel) this.tcpMessageChannels.get(key);
            //} else {
                //TCPMessageChannel retval = new TCPMessageChannel(host, port, sipStack, this);
                //this.tcpMessageChannels.put(key, retval);
                //retval.isCached = true;
                //if (sipStack.isLoggingEnabled()) {
                    //sipStack.getStackLogger().logDebug("key " + key);
                    //sipStack.getStackLogger().logDebug("Creating " + retval);
                //}
                //return retval;
            //}
        //} catch (UnknownHostException ex) {
            //throw new IOException(ex.getMessage());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.089 -0400", hash_original_method = "248B80D43EBE2633D052A5A2C5B180CB", hash_generated_method = "A58B9C3C9C7400719F924DEA2BF5D863")
    @DSModeled(DSC.SAFE)
    public int getMaximumMessageSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Integer.MAX_VALUE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.089 -0400", hash_original_method = "C4E752535BCB329601986DF8A32049BD", hash_generated_method = "48F163C1FB4FB666CF02A1CF224E52EE")
    @DSModeled(DSC.SAFE)
    public boolean inUse() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.useCount != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.090 -0400", hash_original_method = "549BD73BE1E8477C39668DF3AD0A0CF5", hash_generated_method = "8401D47F99A5F58D3683F33A3E38B4D5")
    @DSModeled(DSC.SAFE)
    public int getDefaultTargetPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 5060;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.090 -0400", hash_original_method = "51201694E0EE76265BF39848EF10BE9C", hash_generated_method = "7FD317C466D6873CE376C80F23CBD437")
    @DSModeled(DSC.SAFE)
    public boolean isSecure() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
}

