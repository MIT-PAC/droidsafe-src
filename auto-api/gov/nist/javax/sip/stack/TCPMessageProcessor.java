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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.435 -0400", hash_original_field = "ABC7702D7C8D3D2EE6A5C679253AE9AF", hash_generated_field = "D720E7EA87A425C9C359604A7CD3BB49")

    protected int nConnections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.435 -0400", hash_original_field = "39044C41F340C67BFA15E91CC6E98E7D", hash_generated_field = "CE50F8CB2D618D5E2ED1602B4F1188A5")

    private boolean isRunning;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.436 -0400", hash_original_field = "F75352A00C7229AEEA2716B24EB94882", hash_generated_field = "ABA66BF5920EEDB54F4A360C721737A3")

    private Hashtable tcpMessageChannels;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.436 -0400", hash_original_field = "618D0D13042EA7F3CEEF526A7531E730", hash_generated_field = "3CA1EEC3C31C7352901A5A9695447AE6")

    private ArrayList<TCPMessageChannel> incomingTcpMessageChannels;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.445 -0400", hash_original_field = "317D37B0EDC7BD7CBD25D97F53A16CE5", hash_generated_field = "FB56C66DB0DF522F5632D1532BCC403B")

    private ServerSocket sock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.445 -0400", hash_original_field = "A771D64D63DE5E52A6605CCC6FAC3F7C", hash_generated_field = "8B62D61316200E61EA0A60A5551D82D6")

    protected int useCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.446 -0400", hash_original_method = "DF01D933234B7570953E27AF1B039A12", hash_generated_method = "414F0FF1E67B2F85561664A6EB2843A9")
    protected  TCPMessageProcessor(InetAddress ipAddress, SIPTransactionStack sipStack, int port) {
        super(ipAddress, port, "tcp",sipStack);
        this.sipStack = sipStack;
        this.tcpMessageChannels = new Hashtable();
        this.incomingTcpMessageChannels = new ArrayList<TCPMessageChannel>();
        addTaint(ipAddress.getTaint());
        addTaint(sipStack.getTaint());
        addTaint(port);
        // ---------- Original Method ----------
        //this.sipStack = sipStack;
        //this.tcpMessageChannels = new Hashtable();
        //this.incomingTcpMessageChannels = new ArrayList<TCPMessageChannel>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.447 -0400", hash_original_method = "1E47DBAC30060B20437BE89450E78A73", hash_generated_method = "553DF4580290E5B43779CDA02B721636")
    public void start() throws IOException {
        Thread thread;
        thread = new Thread(this);
        thread.setName("TCPMessageProcessorThread");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.setDaemon(true);
        this.sock = sipStack.getNetworkLayer().createServerSocket(getPort(), 0, getIpAddress());
        {
            boolean varFE83D78CDCA90CC090E44B6626DEB41E_268596454 = (getIpAddress().getHostAddress().equals(IN_ADDR_ANY)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.447 -0400", hash_original_method = "BD1C6A6330D89BF80F1DBE244E3DBF31", hash_generated_method = "7E6BA8E3427A1F6BB7A6AF286CF0C70C")
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
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1938423156 = (sipStack.isLoggingEnabled());
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
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_469792774 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.448 -0400", hash_original_method = "8ED81941CDC62D91B3E3601661099BB4", hash_generated_method = "14D3E205B75107CB2AB4E8C36165158B")
    public String getTransport() {
        String varB4EAC82CA7396A68D541C85D26508E83_140670849 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_140670849 = "tcp";
        varB4EAC82CA7396A68D541C85D26508E83_140670849.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_140670849;
        // ---------- Original Method ----------
        //return "tcp";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.448 -0400", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "A0864C04FE7067BE01B2D451F1E5B872")
    public SIPTransactionStack getSIPStack() {
        SIPTransactionStack varB4EAC82CA7396A68D541C85D26508E83_537338737 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_537338737 = sipStack;
        varB4EAC82CA7396A68D541C85D26508E83_537338737.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_537338737;
        // ---------- Original Method ----------
        //return sipStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.455 -0400", hash_original_method = "EFC3C9ACE40E1AFA4E42220FC9A24C72", hash_generated_method = "8D3710430FF53E0AE996CA43A6831431")
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
            boolean var03729FD53960D8DCA3A41A13A0229637_1876857697 = (it.hasNext());
            {
                TCPMessageChannel next;
                next = (TCPMessageChannel) it.next();
                next.close();
            } //End block
        } //End collapsed parenthetic
        {
            Iterator incomingMCIterator;
            incomingMCIterator = incomingTcpMessageChannels.iterator();
            boolean var02145023CCC7750962C816C772AD4FC3_1730441804 = (incomingMCIterator
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.456 -0400", hash_original_method = "E63037070BE0B3824038F0C58AF2A6B7", hash_generated_method = "1F95C36D575D08DF6CE07B3E0B212BF1")
    protected synchronized void remove(TCPMessageChannel tcpMessageChannel) {
        String key;
        key = tcpMessageChannel.getKey();
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_657400260 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(Thread.currentThread() + " removing " + key);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB53D4E08822069DDA601F76ED9A80DA6_681596964 = (tcpMessageChannels.get(key) == tcpMessageChannel);
            {
                this.tcpMessageChannels.remove(key);
            } //End block
        } //End collapsed parenthetic
        incomingTcpMessageChannels.remove(tcpMessageChannel);
        addTaint(tcpMessageChannel.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.468 -0400", hash_original_method = "357F90D56DF658376E8E30660A48F527", hash_generated_method = "1085513D68FCD7DA1F2E825F005A3100")
    public synchronized MessageChannel createMessageChannel(HostPort targetHostPort) throws IOException {
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_570861870 = null; //Variable for return #1
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_842153134 = null; //Variable for return #2
        String key;
        key = MessageChannel.getKey(targetHostPort, "TCP");
        {
            boolean varED1B0539F1F1458335819AA7F1CACAFC_1274233700 = (tcpMessageChannels.get(key) != null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_570861870 = (TCPMessageChannel) this.tcpMessageChannels.get(key);
            } //End block
            {
                TCPMessageChannel retval;
                retval = new TCPMessageChannel(targetHostPort.getInetAddress(),
                    targetHostPort.getPort(), sipStack, this);
                this.tcpMessageChannels.put(key, retval);
                retval.isCached = true;
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_554788372 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug("key " + key);
                        sipStack.getStackLogger().logDebug("Creating " + retval);
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_842153134 = retval;
            } //End block
        } //End collapsed parenthetic
        addTaint(targetHostPort.getTaint());
        MessageChannel varA7E53CE21691AB073D9660D615818899_1069430278; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1069430278 = varB4EAC82CA7396A68D541C85D26508E83_570861870;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1069430278 = varB4EAC82CA7396A68D541C85D26508E83_842153134;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1069430278.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1069430278;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.468 -0400", hash_original_method = "A1867B08C1B2C4003FD16CE7D97D4BE3", hash_generated_method = "9015931417BCEC1BD3013594406D8819")
    protected synchronized void cacheMessageChannel(TCPMessageChannel messageChannel) {
        String key;
        key = messageChannel.getKey();
        TCPMessageChannel currentChannel;
        currentChannel = (TCPMessageChannel) tcpMessageChannels.get(key);
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_269150194 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Closing " + key);
            } //End collapsed parenthetic
            currentChannel.close();
        } //End block
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_173956685 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("Caching " + key);
        } //End collapsed parenthetic
        this.tcpMessageChannels.put(key, messageChannel);
        addTaint(messageChannel.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.469 -0400", hash_original_method = "C7BFFB891EADFA809295B1E355E1D388", hash_generated_method = "20D6E2CB9B8F32AA34FE87F4A0B67AB7")
    public synchronized MessageChannel createMessageChannel(InetAddress host, int port) throws IOException {
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_1846940325 = null; //Variable for return #1
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_1073234185 = null; //Variable for return #2
        try 
        {
            String key;
            key = MessageChannel.getKey(host, port, "TCP");
            {
                boolean var32ECC15F3F0A6B264B1AF22E5961D90C_1363253473 = (tcpMessageChannels.get(key) != null);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1846940325 = (TCPMessageChannel) this.tcpMessageChannels.get(key);
                } //End block
                {
                    TCPMessageChannel retval;
                    retval = new TCPMessageChannel(host, port, sipStack, this);
                    this.tcpMessageChannels.put(key, retval);
                    retval.isCached = true;
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1953008055 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logDebug("key " + key);
                            sipStack.getStackLogger().logDebug("Creating " + retval);
                        } //End block
                    } //End collapsed parenthetic
                    varB4EAC82CA7396A68D541C85D26508E83_1073234185 = retval;
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (UnknownHostException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException(ex.getMessage());
        } //End block
        addTaint(host.getTaint());
        addTaint(port);
        MessageChannel varA7E53CE21691AB073D9660D615818899_1389047377; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1389047377 = varB4EAC82CA7396A68D541C85D26508E83_1846940325;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1389047377 = varB4EAC82CA7396A68D541C85D26508E83_1073234185;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1389047377.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1389047377;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.470 -0400", hash_original_method = "248B80D43EBE2633D052A5A2C5B180CB", hash_generated_method = "A227F8F986C12FEA5355BCB93E57EB0E")
    public int getMaximumMessageSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_997392379 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_997392379;
        // ---------- Original Method ----------
        //return Integer.MAX_VALUE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.470 -0400", hash_original_method = "C4E752535BCB329601986DF8A32049BD", hash_generated_method = "80E35A1B593154421EF7BA4D7C1DA245")
    public boolean inUse() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2034331393 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2034331393;
        // ---------- Original Method ----------
        //return this.useCount != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.470 -0400", hash_original_method = "549BD73BE1E8477C39668DF3AD0A0CF5", hash_generated_method = "98D1BBC12C373CD14CACE5F429C28B0A")
    public int getDefaultTargetPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_602695389 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_602695389;
        // ---------- Original Method ----------
        //return 5060;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.470 -0400", hash_original_method = "51201694E0EE76265BF39848EF10BE9C", hash_generated_method = "FCD4FBAF0E2216238CC4648F53A4C2DC")
    public boolean isSecure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1004202046 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1004202046;
        // ---------- Original Method ----------
        //return false;
    }

    
}

