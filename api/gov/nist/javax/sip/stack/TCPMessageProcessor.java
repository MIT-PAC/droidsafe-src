package gov.nist.javax.sip.stack;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.net.SocketException;
import gov.nist.core.*;
import java.net.*;
import java.util.*;

public class TCPMessageProcessor extends MessageProcessor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.813 -0400", hash_original_field = "ABC7702D7C8D3D2EE6A5C679253AE9AF", hash_generated_field = "D720E7EA87A425C9C359604A7CD3BB49")

    protected int nConnections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.813 -0400", hash_original_field = "39044C41F340C67BFA15E91CC6E98E7D", hash_generated_field = "CE50F8CB2D618D5E2ED1602B4F1188A5")

    private boolean isRunning;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.813 -0400", hash_original_field = "F75352A00C7229AEEA2716B24EB94882", hash_generated_field = "ABA66BF5920EEDB54F4A360C721737A3")

    private Hashtable tcpMessageChannels;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.813 -0400", hash_original_field = "618D0D13042EA7F3CEEF526A7531E730", hash_generated_field = "3CA1EEC3C31C7352901A5A9695447AE6")

    private ArrayList<TCPMessageChannel> incomingTcpMessageChannels;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.813 -0400", hash_original_field = "317D37B0EDC7BD7CBD25D97F53A16CE5", hash_generated_field = "FB56C66DB0DF522F5632D1532BCC403B")

    private ServerSocket sock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.813 -0400", hash_original_field = "A771D64D63DE5E52A6605CCC6FAC3F7C", hash_generated_field = "8B62D61316200E61EA0A60A5551D82D6")

    protected int useCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.814 -0400", hash_original_method = "DF01D933234B7570953E27AF1B039A12", hash_generated_method = "414F0FF1E67B2F85561664A6EB2843A9")
    protected  TCPMessageProcessor(InetAddress ipAddress, SIPTransactionStack sipStack, int port) {
        super(ipAddress, port, "tcp",sipStack);
        this.sipStack = sipStack;
        this.tcpMessageChannels = new Hashtable();
        this.incomingTcpMessageChannels = new ArrayList<TCPMessageChannel>();
        addTaint(ipAddress.getTaint());
        addTaint(sipStack.getTaint());
        addTaint(port);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.814 -0400", hash_original_method = "1E47DBAC30060B20437BE89450E78A73", hash_generated_method = "530A44CEE9CE1317606DEADDAC30762F")
    public void start() throws IOException {
        Thread thread = new Thread(this);
        thread.setName("TCPMessageProcessorThread");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.setDaemon(true);
        this.sock = sipStack.getNetworkLayer().createServerSocket(getPort(), 0, getIpAddress());
        {
            boolean varFE83D78CDCA90CC090E44B6626DEB41E_87005546 = (getIpAddress().getHostAddress().equals(IN_ADDR_ANY)
                || getIpAddress().getHostAddress().equals(IN6_ADDR_ANY));
            {
                super.setIpAddress(sock.getInetAddress());
            } 
        } 
        this.isRunning = true;
        thread.start();
        
        
        
        
        
        
        
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.815 -0400", hash_original_method = "BD1C6A6330D89BF80F1DBE244E3DBF31", hash_generated_method = "150DBF501BDCE16DECE05F4AA593AE92")
    public void run() {
        {
            try 
            {
                {
                    {
                        try 
                        {
                            this.wait();
                        } 
                        catch (InterruptedException ex)
                        { }
                    } 
                } 
                Socket newsock = sock.accept();
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_70610981 = (sipStack.isLoggingEnabled());
                    {
                        getSIPStack().getStackLogger().logDebug("Accepting new connection!");
                    } 
                } 
                incomingTcpMessageChannels.add(new TCPMessageChannel(newsock, sipStack, this));
            } 
            catch (SocketException ex)
            {
                this.isRunning = false;
            } 
            catch (IOException ex)
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1528461088 = (sipStack.isLoggingEnabled());
                    getSIPStack().getStackLogger().logException(ex);
                } 
            } 
            catch (Exception ex)
            {
                InternalErrorHandler.handleException(ex);
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.816 -0400", hash_original_method = "8ED81941CDC62D91B3E3601661099BB4", hash_generated_method = "035274D99F914720078E6E6E2A9405CF")
    public String getTransport() {
        String varB4EAC82CA7396A68D541C85D26508E83_1666443436 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1666443436 = "tcp";
        varB4EAC82CA7396A68D541C85D26508E83_1666443436.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1666443436;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.816 -0400", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "1E34CECDA1F4695B59A4AB472A4C715E")
    public SIPTransactionStack getSIPStack() {
        SIPTransactionStack varB4EAC82CA7396A68D541C85D26508E83_2076088320 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2076088320 = sipStack;
        varB4EAC82CA7396A68D541C85D26508E83_2076088320.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2076088320;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.817 -0400", hash_original_method = "EFC3C9ACE40E1AFA4E42220FC9A24C72", hash_generated_method = "D2A42C19EA2E02E792CFAD2B005DE5AF")
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
        {
            Iterator it = en.iterator();
            boolean var03729FD53960D8DCA3A41A13A0229637_440333748 = (it.hasNext());
            {
                TCPMessageChannel next = (TCPMessageChannel) it.next();
                next.close();
            } 
        } 
        {
            Iterator incomingMCIterator = incomingTcpMessageChannels.iterator();
            boolean var02145023CCC7750962C816C772AD4FC3_502740641 = (incomingMCIterator
                .hasNext());
            {
                TCPMessageChannel next = (TCPMessageChannel) incomingMCIterator.next();
                next.close();
            } 
        } 
        this.notify();
        
        
        
            
        
            
        
        
        
            
            
        
        
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.818 -0400", hash_original_method = "E63037070BE0B3824038F0C58AF2A6B7", hash_generated_method = "B301EAD2AB7BEC4FE5ED04830A0037ED")
    protected synchronized void remove(TCPMessageChannel tcpMessageChannel) {
        String key = tcpMessageChannel.getKey();
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_2029631132 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(Thread.currentThread() + " removing " + key);
            } 
        } 
        {
            boolean varB53D4E08822069DDA601F76ED9A80DA6_2086212820 = (tcpMessageChannels.get(key) == tcpMessageChannel);
            {
                this.tcpMessageChannels.remove(key);
            } 
        } 
        incomingTcpMessageChannels.remove(tcpMessageChannel);
        addTaint(tcpMessageChannel.getTaint());
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.819 -0400", hash_original_method = "357F90D56DF658376E8E30660A48F527", hash_generated_method = "A6424EC19DD2B2D4119FF7D6DF8D8A76")
    public synchronized MessageChannel createMessageChannel(HostPort targetHostPort) throws IOException {
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_450072599 = null; 
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_150610106 = null; 
        String key = MessageChannel.getKey(targetHostPort, "TCP");
        {
            boolean varED1B0539F1F1458335819AA7F1CACAFC_1817166709 = (tcpMessageChannels.get(key) != null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_450072599 = (TCPMessageChannel) this.tcpMessageChannels.get(key);
            } 
            {
                TCPMessageChannel retval = new TCPMessageChannel(targetHostPort.getInetAddress(),
                    targetHostPort.getPort(), sipStack, this);
                this.tcpMessageChannels.put(key, retval);
                retval.isCached = true;
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1321811689 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug("key " + key);
                        sipStack.getStackLogger().logDebug("Creating " + retval);
                    } 
                } 
                varB4EAC82CA7396A68D541C85D26508E83_150610106 = retval;
            } 
        } 
        addTaint(targetHostPort.getTaint());
        MessageChannel varA7E53CE21691AB073D9660D615818899_384236634; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_384236634 = varB4EAC82CA7396A68D541C85D26508E83_450072599;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_384236634 = varB4EAC82CA7396A68D541C85D26508E83_150610106;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_384236634.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_384236634;
        
        
        
            
        
            
                    
            
            
            
                
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.820 -0400", hash_original_method = "A1867B08C1B2C4003FD16CE7D97D4BE3", hash_generated_method = "AFF7E6B58C52EEA3624E84136AB40CBD")
    protected synchronized void cacheMessageChannel(TCPMessageChannel messageChannel) {
        String key = messageChannel.getKey();
        TCPMessageChannel currentChannel = (TCPMessageChannel) tcpMessageChannels.get(key);
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1474058115 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Closing " + key);
            } 
            currentChannel.close();
        } 
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1528020345 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("Caching " + key);
        } 
        this.tcpMessageChannels.put(key, messageChannel);
        addTaint(messageChannel.getTaint());
        
        
        
        
            
                
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.821 -0400", hash_original_method = "C7BFFB891EADFA809295B1E355E1D388", hash_generated_method = "A1075CF4D27E9E2A4EDEBEC280066FBD")
    public synchronized MessageChannel createMessageChannel(InetAddress host, int port) throws IOException {
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_2116417105 = null; 
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_745792319 = null; 
        try 
        {
            String key = MessageChannel.getKey(host, port, "TCP");
            {
                boolean var32ECC15F3F0A6B264B1AF22E5961D90C_590738350 = (tcpMessageChannels.get(key) != null);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_2116417105 = (TCPMessageChannel) this.tcpMessageChannels.get(key);
                } 
                {
                    TCPMessageChannel retval = new TCPMessageChannel(host, port, sipStack, this);
                    this.tcpMessageChannels.put(key, retval);
                    retval.isCached = true;
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1986895327 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logDebug("key " + key);
                            sipStack.getStackLogger().logDebug("Creating " + retval);
                        } 
                    } 
                    varB4EAC82CA7396A68D541C85D26508E83_745792319 = retval;
                } 
            } 
        } 
        catch (UnknownHostException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException(ex.getMessage());
        } 
        addTaint(host.getTaint());
        addTaint(port);
        MessageChannel varA7E53CE21691AB073D9660D615818899_2076429344; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2076429344 = varB4EAC82CA7396A68D541C85D26508E83_2116417105;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2076429344 = varB4EAC82CA7396A68D541C85D26508E83_745792319;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2076429344.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2076429344;
        
        
            
            
                
            
                
                
                
                
                    
                    
                
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.821 -0400", hash_original_method = "248B80D43EBE2633D052A5A2C5B180CB", hash_generated_method = "8AC2E37889159D3B656908D43FAEF827")
    public int getMaximumMessageSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1799684157 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1799684157;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.821 -0400", hash_original_method = "C4E752535BCB329601986DF8A32049BD", hash_generated_method = "36D83C593C36C8E1E7AC3249617E2C09")
    public boolean inUse() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_998092561 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_998092561;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.822 -0400", hash_original_method = "549BD73BE1E8477C39668DF3AD0A0CF5", hash_generated_method = "05AE8A2AC8E34A3CBFA8D1DF35135759")
    public int getDefaultTargetPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1313626852 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1313626852;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.822 -0400", hash_original_method = "51201694E0EE76265BF39848EF10BE9C", hash_generated_method = "0530AFC8A893C81E1F85183E0F6F8733")
    public boolean isSecure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1768534608 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1768534608;
        
        
    }

    
}

