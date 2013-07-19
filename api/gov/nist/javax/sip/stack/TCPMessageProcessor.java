package gov.nist.javax.sip.stack;

// Droidsafe Imports
import gov.nist.core.HostPort;
import gov.nist.core.InternalErrorHandler;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class TCPMessageProcessor extends MessageProcessor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.684 -0400", hash_original_field = "ABC7702D7C8D3D2EE6A5C679253AE9AF", hash_generated_field = "D720E7EA87A425C9C359604A7CD3BB49")

    protected int nConnections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.684 -0400", hash_original_field = "39044C41F340C67BFA15E91CC6E98E7D", hash_generated_field = "CE50F8CB2D618D5E2ED1602B4F1188A5")

    private boolean isRunning;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.685 -0400", hash_original_field = "F75352A00C7229AEEA2716B24EB94882", hash_generated_field = "ABA66BF5920EEDB54F4A360C721737A3")

    private Hashtable tcpMessageChannels;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.685 -0400", hash_original_field = "618D0D13042EA7F3CEEF526A7531E730", hash_generated_field = "3CA1EEC3C31C7352901A5A9695447AE6")

    private ArrayList<TCPMessageChannel> incomingTcpMessageChannels;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.685 -0400", hash_original_field = "317D37B0EDC7BD7CBD25D97F53A16CE5", hash_generated_field = "FB56C66DB0DF522F5632D1532BCC403B")

    private ServerSocket sock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.685 -0400", hash_original_field = "A771D64D63DE5E52A6605CCC6FAC3F7C", hash_generated_field = "8B62D61316200E61EA0A60A5551D82D6")

    protected int useCount;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.686 -0400", hash_original_method = "DF01D933234B7570953E27AF1B039A12", hash_generated_method = "C33F2C4BEE20E7C4A39AD914B8A706CD")
    protected  TCPMessageProcessor(InetAddress ipAddress, SIPTransactionStack sipStack, int port) {
        super(ipAddress, port, "tcp",sipStack);
        addTaint(port);
        addTaint(sipStack.getTaint());
        addTaint(ipAddress.getTaint());
        this.sipStack = sipStack;
        this.tcpMessageChannels = new Hashtable();
        this.incomingTcpMessageChannels = new ArrayList<TCPMessageChannel>();
        // ---------- Original Method ----------
        //this.sipStack = sipStack;
        //this.tcpMessageChannels = new Hashtable();
        //this.incomingTcpMessageChannels = new ArrayList<TCPMessageChannel>();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.687 -0400", hash_original_method = "1E47DBAC30060B20437BE89450E78A73", hash_generated_method = "823BEB743EA85CA587911E0E95E89BCD")
    public void start() throws IOException {
        Thread thread = new Thread(this);
        thread.setName("TCPMessageProcessorThread");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.setDaemon(true);
        this.sock = sipStack.getNetworkLayer().createServerSocket(getPort(), 0, getIpAddress());
        if(getIpAddress().getHostAddress().equals(IN_ADDR_ANY)
                || getIpAddress().getHostAddress().equals(IN6_ADDR_ANY))        
        {
            super.setIpAddress(sock.getInetAddress());
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.688 -0400", hash_original_method = "BD1C6A6330D89BF80F1DBE244E3DBF31", hash_generated_method = "5C57E52D44004D24BE78F0C2181A753D")
    public void run() {
        while
(this.isRunning)        
        {
            try 
            {
                synchronized
(this)                {
                    while
(sipStack.maxConnections != -1
                            && this.nConnections >= sipStack.maxConnections)                    
                    {
                        try 
                        {
                            this.wait();
                            if(!this.isRunning)                            
                            return;
                        } //End block
                        catch (InterruptedException ex)
                        {
                            break;
                        } //End block
                    } //End block
                    this.nConnections++;
                } //End block
                Socket newsock = sock.accept();
                if(sipStack.isLoggingEnabled())                
                {
                    getSIPStack().getStackLogger().logDebug("Accepting new connection!");
                } //End block
                incomingTcpMessageChannels.add(new TCPMessageChannel(newsock, sipStack, this));
            } //End block
            catch (SocketException ex)
            {
                this.isRunning = false;
            } //End block
            catch (IOException ex)
            {
                if(sipStack.isLoggingEnabled())                
                getSIPStack().getStackLogger().logException(ex);
                continue;
            } //End block
            catch (Exception ex)
            {
                InternalErrorHandler.handleException(ex);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.689 -0400", hash_original_method = "8ED81941CDC62D91B3E3601661099BB4", hash_generated_method = "297169B0669214D72509D07FABDB6F9C")
    public String getTransport() {
String var8E0D2DE928CCB79EDAB8450D3E99835F_1558016299 =         "tcp";
        var8E0D2DE928CCB79EDAB8450D3E99835F_1558016299.addTaint(taint);
        return var8E0D2DE928CCB79EDAB8450D3E99835F_1558016299;
        // ---------- Original Method ----------
        //return "tcp";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.689 -0400", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "5D6470B5927265932874E0A9803E8881")
    public SIPTransactionStack getSIPStack() {
SIPTransactionStack var0FC1F21ED47F4C0C48881B0DAF112A16_73699537 =         sipStack;
        var0FC1F21ED47F4C0C48881B0DAF112A16_73699537.addTaint(taint);
        return var0FC1F21ED47F4C0C48881B0DAF112A16_73699537;
        // ---------- Original Method ----------
        //return sipStack;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.690 -0400", hash_original_method = "EFC3C9ACE40E1AFA4E42220FC9A24C72", hash_generated_method = "0ADA05DA1EAA9FB54575A52DE260C3A0")
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
        Collection en = tcpMessageChannels.values();
for(Iterator it = en.iterator();it.hasNext();)
        {
            TCPMessageChannel next = (TCPMessageChannel) it.next();
            next.close();
        } //End block
for(Iterator incomingMCIterator = incomingTcpMessageChannels.iterator();incomingMCIterator
                .hasNext();)
        {
            TCPMessageChannel next = (TCPMessageChannel) incomingMCIterator.next();
            next.close();
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.691 -0400", hash_original_method = "E63037070BE0B3824038F0C58AF2A6B7", hash_generated_method = "0076BE748E4A1B2201EEA83B9A95F88B")
    protected synchronized void remove(TCPMessageChannel tcpMessageChannel) {
        addTaint(tcpMessageChannel.getTaint());
        String key = tcpMessageChannel.getKey();
        if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug(Thread.currentThread() + " removing " + key);
        } //End block
        if(tcpMessageChannels.get(key) == tcpMessageChannel)        
        {
            this.tcpMessageChannels.remove(key);
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.691 -0400", hash_original_method = "357F90D56DF658376E8E30660A48F527", hash_generated_method = "C1941D98624F48C51526E2F018040FA3")
    public synchronized MessageChannel createMessageChannel(HostPort targetHostPort) throws IOException {
        addTaint(targetHostPort.getTaint());
        String key = MessageChannel.getKey(targetHostPort, "TCP");
        if(tcpMessageChannels.get(key) != null)        
        {
MessageChannel var4C05898260929B2209F5B503D0FD49A9_1412073268 =             (TCPMessageChannel) this.tcpMessageChannels.get(key);
            var4C05898260929B2209F5B503D0FD49A9_1412073268.addTaint(taint);
            return var4C05898260929B2209F5B503D0FD49A9_1412073268;
        } //End block
        else
        {
            TCPMessageChannel retval = new TCPMessageChannel(targetHostPort.getInetAddress(),
                    targetHostPort.getPort(), sipStack, this);
            this.tcpMessageChannels.put(key, retval);
            retval.isCached = true;
            if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logDebug("key " + key);
                sipStack.getStackLogger().logDebug("Creating " + retval);
            } //End block
MessageChannel varF9E19AD6135C970F387F77C6F3DE4477_412070776 =             retval;
            varF9E19AD6135C970F387F77C6F3DE4477_412070776.addTaint(taint);
            return varF9E19AD6135C970F387F77C6F3DE4477_412070776;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.692 -0400", hash_original_method = "A1867B08C1B2C4003FD16CE7D97D4BE3", hash_generated_method = "1F323C9BBD0AD0F826E368DA5DD7D480")
    protected synchronized void cacheMessageChannel(TCPMessageChannel messageChannel) {
        addTaint(messageChannel.getTaint());
        String key = messageChannel.getKey();
        TCPMessageChannel currentChannel = (TCPMessageChannel) tcpMessageChannels.get(key);
        if(currentChannel != null)        
        {
            if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logDebug("Closing " + key);
            currentChannel.close();
        } //End block
        if(sipStack.isLoggingEnabled())        
        sipStack.getStackLogger().logDebug("Caching " + key);
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.693 -0400", hash_original_method = "C7BFFB891EADFA809295B1E355E1D388", hash_generated_method = "123058EB0A15D988963A80A2E3C2F13D")
    public synchronized MessageChannel createMessageChannel(InetAddress host, int port) throws IOException {
        addTaint(port);
        addTaint(host.getTaint());
        try 
        {
            String key = MessageChannel.getKey(host, port, "TCP");
            if(tcpMessageChannels.get(key) != null)            
            {
MessageChannel var4C05898260929B2209F5B503D0FD49A9_1342957999 =                 (TCPMessageChannel) this.tcpMessageChannels.get(key);
                var4C05898260929B2209F5B503D0FD49A9_1342957999.addTaint(taint);
                return var4C05898260929B2209F5B503D0FD49A9_1342957999;
            } //End block
            else
            {
                TCPMessageChannel retval = new TCPMessageChannel(host, port, sipStack, this);
                this.tcpMessageChannels.put(key, retval);
                retval.isCached = true;
                if(sipStack.isLoggingEnabled())                
                {
                    sipStack.getStackLogger().logDebug("key " + key);
                    sipStack.getStackLogger().logDebug("Creating " + retval);
                } //End block
MessageChannel varF9E19AD6135C970F387F77C6F3DE4477_1664653639 =                 retval;
                varF9E19AD6135C970F387F77C6F3DE4477_1664653639.addTaint(taint);
                return varF9E19AD6135C970F387F77C6F3DE4477_1664653639;
            } //End block
        } //End block
        catch (UnknownHostException ex)
        {
            IOException var1FC0CF6650AEC5395B2E1C7E06C33B6F_475078463 = new IOException(ex.getMessage());
            var1FC0CF6650AEC5395B2E1C7E06C33B6F_475078463.addTaint(taint);
            throw var1FC0CF6650AEC5395B2E1C7E06C33B6F_475078463;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.694 -0400", hash_original_method = "248B80D43EBE2633D052A5A2C5B180CB", hash_generated_method = "CA61EB8D3F47168839A96CD3C0CD87B9")
    public int getMaximumMessageSize() {
        int varE7A95D949116A2DA0F0FA83DC6E76C00_1810363956 = (Integer.MAX_VALUE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1916593720 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1916593720;
        // ---------- Original Method ----------
        //return Integer.MAX_VALUE;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.694 -0400", hash_original_method = "C4E752535BCB329601986DF8A32049BD", hash_generated_method = "4752F42D8D20289C252F28164861D563")
    public boolean inUse() {
        boolean varBD86A4DC7E4A98958B2E800FF150F372_1986341825 = (this.useCount != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1489504343 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1489504343;
        // ---------- Original Method ----------
        //return this.useCount != 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.694 -0400", hash_original_method = "549BD73BE1E8477C39668DF3AD0A0CF5", hash_generated_method = "FCE868B427BE9C4E990FF81A9C72BFED")
    public int getDefaultTargetPort() {
        int var8D749EA54F6657B0396C204D3148DA60_58705435 = (5060);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_916468030 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_916468030;
        // ---------- Original Method ----------
        //return 5060;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.694 -0400", hash_original_method = "51201694E0EE76265BF39848EF10BE9C", hash_generated_method = "E64F01080F7D3F459F741A91795E4BCD")
    public boolean isSecure() {
        boolean var68934A3E9455FA72420237EB05902327_629770744 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_54670560 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_54670560;
        // ---------- Original Method ----------
        //return false;
    }

    
}

