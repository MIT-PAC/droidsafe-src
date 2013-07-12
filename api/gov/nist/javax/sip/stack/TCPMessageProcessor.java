package gov.nist.javax.sip.stack;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.net.SocketException;
import gov.nist.core.*;
import java.net.*;
import java.util.*;

public class TCPMessageProcessor extends MessageProcessor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.217 -0400", hash_original_field = "ABC7702D7C8D3D2EE6A5C679253AE9AF", hash_generated_field = "D720E7EA87A425C9C359604A7CD3BB49")

    protected int nConnections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.217 -0400", hash_original_field = "39044C41F340C67BFA15E91CC6E98E7D", hash_generated_field = "CE50F8CB2D618D5E2ED1602B4F1188A5")

    private boolean isRunning;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.217 -0400", hash_original_field = "F75352A00C7229AEEA2716B24EB94882", hash_generated_field = "ABA66BF5920EEDB54F4A360C721737A3")

    private Hashtable tcpMessageChannels;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.217 -0400", hash_original_field = "618D0D13042EA7F3CEEF526A7531E730", hash_generated_field = "3CA1EEC3C31C7352901A5A9695447AE6")

    private ArrayList<TCPMessageChannel> incomingTcpMessageChannels;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.218 -0400", hash_original_field = "317D37B0EDC7BD7CBD25D97F53A16CE5", hash_generated_field = "FB56C66DB0DF522F5632D1532BCC403B")

    private ServerSocket sock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.218 -0400", hash_original_field = "A771D64D63DE5E52A6605CCC6FAC3F7C", hash_generated_field = "8B62D61316200E61EA0A60A5551D82D6")

    protected int useCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.218 -0400", hash_original_method = "DF01D933234B7570953E27AF1B039A12", hash_generated_method = "C33F2C4BEE20E7C4A39AD914B8A706CD")
    protected  TCPMessageProcessor(InetAddress ipAddress, SIPTransactionStack sipStack, int port) {
        super(ipAddress, port, "tcp",sipStack);
        addTaint(port);
        addTaint(sipStack.getTaint());
        addTaint(ipAddress.getTaint());
        this.sipStack = sipStack;
        this.tcpMessageChannels = new Hashtable();
        this.incomingTcpMessageChannels = new ArrayList<TCPMessageChannel>();
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.219 -0400", hash_original_method = "1E47DBAC30060B20437BE89450E78A73", hash_generated_method = "823BEB743EA85CA587911E0E95E89BCD")
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
        } 
        this.isRunning = true;
        thread.start();
        
        
        
        
        
        
        
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.220 -0400", hash_original_method = "BD1C6A6330D89BF80F1DBE244E3DBF31", hash_generated_method = "5C57E52D44004D24BE78F0C2181A753D")
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
                        } 
                        catch (InterruptedException ex)
                        {
                            break;
                        } 
                    } 
                    this.nConnections++;
                } 
                Socket newsock = sock.accept();
    if(sipStack.isLoggingEnabled())                
                {
                    getSIPStack().getStackLogger().logDebug("Accepting new connection!");
                } 
                incomingTcpMessageChannels.add(new TCPMessageChannel(newsock, sipStack, this));
            } 
            catch (SocketException ex)
            {
                this.isRunning = false;
            } 
            catch (IOException ex)
            {
    if(sipStack.isLoggingEnabled())                
                getSIPStack().getStackLogger().logException(ex);
                continue;
            } 
            catch (Exception ex)
            {
                InternalErrorHandler.handleException(ex);
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.221 -0400", hash_original_method = "8ED81941CDC62D91B3E3601661099BB4", hash_generated_method = "B18A23B37902B7AB4C9E6631362A2DEA")
    public String getTransport() {
String var8E0D2DE928CCB79EDAB8450D3E99835F_491257671 =         "tcp";
        var8E0D2DE928CCB79EDAB8450D3E99835F_491257671.addTaint(taint);
        return var8E0D2DE928CCB79EDAB8450D3E99835F_491257671;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.221 -0400", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "CF4AE864673E4764BEAA29CF7A84B1E8")
    public SIPTransactionStack getSIPStack() {
SIPTransactionStack var0FC1F21ED47F4C0C48881B0DAF112A16_934751351 =         sipStack;
        var0FC1F21ED47F4C0C48881B0DAF112A16_934751351.addTaint(taint);
        return var0FC1F21ED47F4C0C48881B0DAF112A16_934751351;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.221 -0400", hash_original_method = "EFC3C9ACE40E1AFA4E42220FC9A24C72", hash_generated_method = "0ADA05DA1EAA9FB54575A52DE260C3A0")
    public synchronized void stop() {
        isRunning = false;
        try 
        {
            sock.close();
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        } 
        Collection en = tcpMessageChannels.values();
for(Iterator it = en.iterator();it.hasNext();)
        {
            TCPMessageChannel next = (TCPMessageChannel) it.next();
            next.close();
        } 
for(Iterator incomingMCIterator = incomingTcpMessageChannels.iterator();incomingMCIterator
                .hasNext();)
        {
            TCPMessageChannel next = (TCPMessageChannel) incomingMCIterator.next();
            next.close();
        } 
        this.notify();
        
        
        
            
        
            
        
        
        
            
            
        
        
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.222 -0400", hash_original_method = "E63037070BE0B3824038F0C58AF2A6B7", hash_generated_method = "0076BE748E4A1B2201EEA83B9A95F88B")
    protected synchronized void remove(TCPMessageChannel tcpMessageChannel) {
        addTaint(tcpMessageChannel.getTaint());
        String key = tcpMessageChannel.getKey();
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug(Thread.currentThread() + " removing " + key);
        } 
    if(tcpMessageChannels.get(key) == tcpMessageChannel)        
        {
            this.tcpMessageChannels.remove(key);
        } 
        incomingTcpMessageChannels.remove(tcpMessageChannel);
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.223 -0400", hash_original_method = "357F90D56DF658376E8E30660A48F527", hash_generated_method = "298867680E90BC314C77AB286C96C5C5")
    public synchronized MessageChannel createMessageChannel(HostPort targetHostPort) throws IOException {
        addTaint(targetHostPort.getTaint());
        String key = MessageChannel.getKey(targetHostPort, "TCP");
    if(tcpMessageChannels.get(key) != null)        
        {
MessageChannel var4C05898260929B2209F5B503D0FD49A9_1242310155 =             (TCPMessageChannel) this.tcpMessageChannels.get(key);
            var4C05898260929B2209F5B503D0FD49A9_1242310155.addTaint(taint);
            return var4C05898260929B2209F5B503D0FD49A9_1242310155;
        } 
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
            } 
MessageChannel varF9E19AD6135C970F387F77C6F3DE4477_87826386 =             retval;
            varF9E19AD6135C970F387F77C6F3DE4477_87826386.addTaint(taint);
            return varF9E19AD6135C970F387F77C6F3DE4477_87826386;
        } 
        
        
        
            
        
            
                    
            
            
            
                
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.223 -0400", hash_original_method = "A1867B08C1B2C4003FD16CE7D97D4BE3", hash_generated_method = "1F323C9BBD0AD0F826E368DA5DD7D480")
    protected synchronized void cacheMessageChannel(TCPMessageChannel messageChannel) {
        addTaint(messageChannel.getTaint());
        String key = messageChannel.getKey();
        TCPMessageChannel currentChannel = (TCPMessageChannel) tcpMessageChannels.get(key);
    if(currentChannel != null)        
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logDebug("Closing " + key);
            currentChannel.close();
        } 
    if(sipStack.isLoggingEnabled())        
        sipStack.getStackLogger().logDebug("Caching " + key);
        this.tcpMessageChannels.put(key, messageChannel);
        
        
        
        
            
                
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.224 -0400", hash_original_method = "C7BFFB891EADFA809295B1E355E1D388", hash_generated_method = "019EB4C00A6A264E38BE0A319A3B1045")
    public synchronized MessageChannel createMessageChannel(InetAddress host, int port) throws IOException {
        addTaint(port);
        addTaint(host.getTaint());
        try 
        {
            String key = MessageChannel.getKey(host, port, "TCP");
    if(tcpMessageChannels.get(key) != null)            
            {
MessageChannel var4C05898260929B2209F5B503D0FD49A9_1225631086 =                 (TCPMessageChannel) this.tcpMessageChannels.get(key);
                var4C05898260929B2209F5B503D0FD49A9_1225631086.addTaint(taint);
                return var4C05898260929B2209F5B503D0FD49A9_1225631086;
            } 
            else
            {
                TCPMessageChannel retval = new TCPMessageChannel(host, port, sipStack, this);
                this.tcpMessageChannels.put(key, retval);
                retval.isCached = true;
    if(sipStack.isLoggingEnabled())                
                {
                    sipStack.getStackLogger().logDebug("key " + key);
                    sipStack.getStackLogger().logDebug("Creating " + retval);
                } 
MessageChannel varF9E19AD6135C970F387F77C6F3DE4477_393893903 =                 retval;
                varF9E19AD6135C970F387F77C6F3DE4477_393893903.addTaint(taint);
                return varF9E19AD6135C970F387F77C6F3DE4477_393893903;
            } 
        } 
        catch (UnknownHostException ex)
        {
            IOException var1FC0CF6650AEC5395B2E1C7E06C33B6F_1762963652 = new IOException(ex.getMessage());
            var1FC0CF6650AEC5395B2E1C7E06C33B6F_1762963652.addTaint(taint);
            throw var1FC0CF6650AEC5395B2E1C7E06C33B6F_1762963652;
        } 
        
        
            
            
                
            
                
                
                
                
                    
                    
                
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.225 -0400", hash_original_method = "248B80D43EBE2633D052A5A2C5B180CB", hash_generated_method = "B693B9B7D4D12E5538578BE18C5CB345")
    public int getMaximumMessageSize() {
        int varE7A95D949116A2DA0F0FA83DC6E76C00_868130536 = (Integer.MAX_VALUE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_391081691 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_391081691;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.225 -0400", hash_original_method = "C4E752535BCB329601986DF8A32049BD", hash_generated_method = "425DBD0B4357CD438E7F695C6642E8A6")
    public boolean inUse() {
        boolean varBD86A4DC7E4A98958B2E800FF150F372_1701966733 = (this.useCount != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1707773729 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1707773729;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.226 -0400", hash_original_method = "549BD73BE1E8477C39668DF3AD0A0CF5", hash_generated_method = "F2BBDD50C7105AD3FA742EE30664CB17")
    public int getDefaultTargetPort() {
        int var8D749EA54F6657B0396C204D3148DA60_894612737 = (5060);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2053506148 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2053506148;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.226 -0400", hash_original_method = "51201694E0EE76265BF39848EF10BE9C", hash_generated_method = "88180E06564B21D8257DBB74001195F9")
    public boolean isSecure() {
        boolean var68934A3E9455FA72420237EB05902327_1761507037 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_349428949 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_349428949;
        
        
    }

    
}

