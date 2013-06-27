package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.HostPort;
import gov.nist.javax.sip.SipStackImpl;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

public class TLSMessageProcessor extends MessageProcessor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.967 -0400", hash_original_field = "ABC7702D7C8D3D2EE6A5C679253AE9AF", hash_generated_field = "D720E7EA87A425C9C359604A7CD3BB49")

    protected int nConnections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.968 -0400", hash_original_field = "39044C41F340C67BFA15E91CC6E98E7D", hash_generated_field = "CE50F8CB2D618D5E2ED1602B4F1188A5")

    private boolean isRunning;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.968 -0400", hash_original_field = "812366AFB87FEE30EB54A9F80708E917", hash_generated_field = "F9EEBC64CC7E0970F5BCA104E833B093")

    private Hashtable<String, TLSMessageChannel> tlsMessageChannels;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.968 -0400", hash_original_field = "317D37B0EDC7BD7CBD25D97F53A16CE5", hash_generated_field = "FB56C66DB0DF522F5632D1532BCC403B")

    private ServerSocket sock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.968 -0400", hash_original_field = "565BA180312610DDE2BA2E2026D497C4", hash_generated_field = "1DC0791E679E20EB98C16DB302A56E6D")

    protected int useCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.968 -0400", hash_original_field = "45CCA41745ACD205A06850F50929AFA3", hash_generated_field = "93B52B6ED94104F7CA5FDE37F83993D5")

    private ArrayList<TLSMessageChannel> incomingTlsMessageChannels;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.969 -0400", hash_original_method = "625854FFB2FE295DE1DAD8EB11451B94", hash_generated_method = "116A39962D2DD2C055FE04F7D393DB95")
    protected  TLSMessageProcessor(InetAddress ipAddress, SIPTransactionStack sipStack, int port) {
        super(ipAddress, port, "tls",sipStack);
        this.sipStack = sipStack;
        this.tlsMessageChannels = new Hashtable<String, TLSMessageChannel>();
        this.incomingTlsMessageChannels = new ArrayList<TLSMessageChannel>();
        addTaint(ipAddress.getTaint());
        addTaint(sipStack.getTaint());
        addTaint(port);
        // ---------- Original Method ----------
        //this.sipStack = sipStack;
        //this.tlsMessageChannels = new Hashtable<String, TLSMessageChannel>();
        //this.incomingTlsMessageChannels = new ArrayList<TLSMessageChannel>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.969 -0400", hash_original_method = "B69BE838486F71F317B5A550A92CFA4E", hash_generated_method = "84D601FD7583D04CC0CC80DD806A40FD")
    public void start() throws IOException {
        Thread thread;
        thread = new Thread(this);
        thread.setName("TLSMessageProcessorThread");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.setDaemon(true);
        this.sock = sipStack.getNetworkLayer().createSSLServerSocket(this.getPort(), 0,
                this.getIpAddress());
        ((SSLServerSocket) this.sock).setNeedClientAuth(false);
        ((SSLServerSocket) this.sock).setUseClientMode(false);
        ((SSLServerSocket) this.sock).setWantClientAuth(true);
        String [] enabledCiphers;
        enabledCiphers = ((SipStackImpl)sipStack).getEnabledCipherSuites();
        ((SSLServerSocket) this.sock).setEnabledCipherSuites(enabledCiphers);
        ((SSLServerSocket)this.sock).setWantClientAuth(true);
        this.isRunning = true;
        thread.start();
        // ---------- Original Method ----------
        //Thread thread = new Thread(this);
        //thread.setName("TLSMessageProcessorThread");
        //thread.setPriority(Thread.MAX_PRIORITY);
        //thread.setDaemon(true);
        //this.sock = sipStack.getNetworkLayer().createSSLServerSocket(this.getPort(), 0,
                //this.getIpAddress());
        //((SSLServerSocket) this.sock).setNeedClientAuth(false);
        //((SSLServerSocket) this.sock).setUseClientMode(false);
        //((SSLServerSocket) this.sock).setWantClientAuth(true);
        //String []enabledCiphers = ((SipStackImpl)sipStack).getEnabledCipherSuites();
        //((SSLServerSocket) this.sock).setEnabledCipherSuites(enabledCiphers);
        //((SSLServerSocket)this.sock).setWantClientAuth(true);
        //this.isRunning = true;
        //thread.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.971 -0400", hash_original_method = "010F4DD19A92034627C31D97E026477A", hash_generated_method = "4C77FBAFB49817E42038A0E5E10F8F35")
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
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1174806266 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logDebug("Accepting new connection!");
                } //End collapsed parenthetic
                incomingTlsMessageChannels.add(new TLSMessageChannel(newsock, sipStack, this));
            } //End block
            catch (SocketException ex)
            {
                {
                    sipStack.getStackLogger().logError(
                    "Fatal - SocketException occured while Accepting connection", ex);
                    this.isRunning = false;
                } //End block
            } //End block
            catch (SSLException ex)
            {
                this.isRunning = false;
                sipStack.getStackLogger().logError(
                        "Fatal - SSSLException occured while Accepting connection", ex);
            } //End block
            catch (IOException ex)
            {
                sipStack.getStackLogger().logError("Problem Accepting Connection", ex);
            } //End block
            catch (Exception ex)
            {
                sipStack.getStackLogger().logError("Unexpected Exception!", ex);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.984 -0400", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "BB5AA65FF3E0A7F5FB405693A3F8DC70")
    public SIPTransactionStack getSIPStack() {
        SIPTransactionStack varB4EAC82CA7396A68D541C85D26508E83_42304770 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_42304770 = sipStack;
        varB4EAC82CA7396A68D541C85D26508E83_42304770.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_42304770;
        // ---------- Original Method ----------
        //return sipStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.985 -0400", hash_original_method = "BE95A6D6EF1264E8946D0F06241C6C5A", hash_generated_method = "A2025B60F5EE19D154BDFF838ED5DBC9")
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
        en = tlsMessageChannels.values();
        {
            Iterator it;
            it = en.iterator();
            boolean var03729FD53960D8DCA3A41A13A0229637_842703652 = (it.hasNext());
            {
                TLSMessageChannel next;
                next = (TLSMessageChannel) it.next();
                next.close();
            } //End block
        } //End collapsed parenthetic
        {
            Iterator incomingMCIterator;
            incomingMCIterator = incomingTlsMessageChannels.iterator();
            boolean var02145023CCC7750962C816C772AD4FC3_2126548514 = (incomingMCIterator
                .hasNext());
            {
                TLSMessageChannel next;
                next = (TLSMessageChannel) incomingMCIterator.next();
                next.close();
            } //End block
        } //End collapsed parenthetic
        this.notify();
        // ---------- Original Method ----------
        //if (!isRunning)
            //return;
        //isRunning = false;
        //try {
            //sock.close();
        //} catch (IOException e) {
            //e.printStackTrace();
        //}
        //Collection en = tlsMessageChannels.values();
        //for (Iterator it = en.iterator(); it.hasNext();) {
            //TLSMessageChannel next = (TLSMessageChannel) it.next();
            //next.close();
        //}
        //for (Iterator incomingMCIterator = incomingTlsMessageChannels.iterator(); incomingMCIterator
                //.hasNext();) {
            //TLSMessageChannel next = (TLSMessageChannel) incomingMCIterator.next();
            //next.close();
        //}
        //this.notify();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.986 -0400", hash_original_method = "49128F6B4DFB9F6CFFFDE7784E6898EB", hash_generated_method = "5E24E4561E3B657A668CEF53DAD0010F")
    protected synchronized void remove(TLSMessageChannel tlsMessageChannel) {
        String key;
        key = tlsMessageChannel.getKey();
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1674113802 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(Thread.currentThread() + " removing " + key);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var82717004E4624C3F5BD538E61F2FBB2A_1081947912 = (tlsMessageChannels.get(key) == tlsMessageChannel);
            this.tlsMessageChannels.remove(key);
        } //End collapsed parenthetic
        incomingTlsMessageChannels.remove(tlsMessageChannel);
        addTaint(tlsMessageChannel.getTaint());
        // ---------- Original Method ----------
        //String key = tlsMessageChannel.getKey();
        //if (sipStack.isLoggingEnabled()) {
            //sipStack.getStackLogger().logDebug(Thread.currentThread() + " removing " + key);
        //}
        //if (tlsMessageChannels.get(key) == tlsMessageChannel)
            //this.tlsMessageChannels.remove(key);
        //incomingTlsMessageChannels.remove(tlsMessageChannel);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.986 -0400", hash_original_method = "E2A4A9C2C749BC9ACAA11AC1B54DE26B", hash_generated_method = "DDB9CA7B530655E4BA94FC180475FC2C")
    public synchronized MessageChannel createMessageChannel(HostPort targetHostPort) throws IOException {
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_771119268 = null; //Variable for return #1
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_952092405 = null; //Variable for return #2
        String key;
        key = MessageChannel.getKey(targetHostPort, "TLS");
        {
            boolean var92C3CA59539D6814B760C707BBC045D0_1418708715 = (tlsMessageChannels.get(key) != null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_771119268 = (TLSMessageChannel) this.tlsMessageChannels.get(key);
            } //End block
            {
                TLSMessageChannel retval;
                retval = new TLSMessageChannel(targetHostPort.getInetAddress(),
                    targetHostPort.getPort(), sipStack, this);
                this.tlsMessageChannels.put(key, retval);
                retval.isCached = true;
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1452467775 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug("key " + key);
                        sipStack.getStackLogger().logDebug("Creating " + retval);
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_952092405 = retval;
            } //End block
        } //End collapsed parenthetic
        addTaint(targetHostPort.getTaint());
        MessageChannel varA7E53CE21691AB073D9660D615818899_2139110549; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2139110549 = varB4EAC82CA7396A68D541C85D26508E83_771119268;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2139110549 = varB4EAC82CA7396A68D541C85D26508E83_952092405;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2139110549.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2139110549;
        // ---------- Original Method ----------
        //String key = MessageChannel.getKey(targetHostPort, "TLS");
        //if (tlsMessageChannels.get(key) != null) {
            //return (TLSMessageChannel) this.tlsMessageChannels.get(key);
        //} else {
            //TLSMessageChannel retval = new TLSMessageChannel(targetHostPort.getInetAddress(),
                    //targetHostPort.getPort(), sipStack, this);
            //this.tlsMessageChannels.put(key, retval);
            //retval.isCached = true;
            //if (sipStack.isLoggingEnabled()) {
                //sipStack.getStackLogger().logDebug("key " + key);
                //sipStack.getStackLogger().logDebug("Creating " + retval);
            //}
            //return retval;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.995 -0400", hash_original_method = "EAE2407B3CE4BB7D6FC77F5E6B72F7C1", hash_generated_method = "A0B3CC248BF55B2B52DD48451047EA7C")
    protected synchronized void cacheMessageChannel(TLSMessageChannel messageChannel) {
        String key;
        key = messageChannel.getKey();
        TLSMessageChannel currentChannel;
        currentChannel = (TLSMessageChannel) tlsMessageChannels.get(key);
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_27887944 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Closing " + key);
            } //End collapsed parenthetic
            currentChannel.close();
        } //End block
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1866623204 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("Caching " + key);
        } //End collapsed parenthetic
        this.tlsMessageChannels.put(key, messageChannel);
        addTaint(messageChannel.getTaint());
        // ---------- Original Method ----------
        //String key = messageChannel.getKey();
        //TLSMessageChannel currentChannel = (TLSMessageChannel) tlsMessageChannels.get(key);
        //if (currentChannel != null) {
            //if (sipStack.isLoggingEnabled())
                //sipStack.getStackLogger().logDebug("Closing " + key);
            //currentChannel.close();
        //}
        //if (sipStack.isLoggingEnabled())
            //sipStack.getStackLogger().logDebug("Caching " + key);
        //this.tlsMessageChannels.put(key, messageChannel);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.996 -0400", hash_original_method = "E42B1ACE44C65E212B4362CBBBBFF2DD", hash_generated_method = "BE93613F1A8F523A99F417F8430F00D2")
    public synchronized MessageChannel createMessageChannel(InetAddress host, int port) throws IOException {
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_997937695 = null; //Variable for return #1
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_932553626 = null; //Variable for return #2
        try 
        {
            String key;
            key = MessageChannel.getKey(host, port, "TLS");
            {
                boolean varF4CA62E1BC21A8BF70A1D16FD5BE5584_1433000957 = (tlsMessageChannels.get(key) != null);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_997937695 = (TLSMessageChannel) this.tlsMessageChannels.get(key);
                } //End block
                {
                    TLSMessageChannel retval;
                    retval = new TLSMessageChannel(host, port, sipStack, this);
                    this.tlsMessageChannels.put(key, retval);
                    retval.isCached = true;
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_209086082 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logDebug("key " + key);
                            sipStack.getStackLogger().logDebug("Creating " + retval);
                        } //End block
                    } //End collapsed parenthetic
                    varB4EAC82CA7396A68D541C85D26508E83_932553626 = retval;
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (UnknownHostException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException(ex.getMessage());
        } //End block
        addTaint(host.getTaint());
        addTaint(port);
        MessageChannel varA7E53CE21691AB073D9660D615818899_626494623; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_626494623 = varB4EAC82CA7396A68D541C85D26508E83_997937695;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_626494623 = varB4EAC82CA7396A68D541C85D26508E83_932553626;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_626494623.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_626494623;
        // ---------- Original Method ----------
        //try {
            //String key = MessageChannel.getKey(host, port, "TLS");
            //if (tlsMessageChannels.get(key) != null) {
                //return (TLSMessageChannel) this.tlsMessageChannels.get(key);
            //} else {
                //TLSMessageChannel retval = new TLSMessageChannel(host, port, sipStack, this);
                //this.tlsMessageChannels.put(key, retval);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.996 -0400", hash_original_method = "248B80D43EBE2633D052A5A2C5B180CB", hash_generated_method = "320724F9E9BCA9785E92D863DD569945")
    public int getMaximumMessageSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_552816470 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_552816470;
        // ---------- Original Method ----------
        //return Integer.MAX_VALUE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.000 -0400", hash_original_method = "C4E752535BCB329601986DF8A32049BD", hash_generated_method = "0F8FBB5B8EBD1BA97B2E32541F16E4F0")
    public boolean inUse() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_331700847 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_331700847;
        // ---------- Original Method ----------
        //return this.useCount != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.001 -0400", hash_original_method = "B951ECFC8A9F13621942685951F4919F", hash_generated_method = "6EC842188CB2810CF879ED3C008BDB3B")
    public int getDefaultTargetPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_281656408 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_281656408;
        // ---------- Original Method ----------
        //return 5061;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.001 -0400", hash_original_method = "57D47F2F9FCDF87C613C3BEA50BCDEDC", hash_generated_method = "F9879E671708FFC8495623752E8458CB")
    public boolean isSecure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1483325317 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1483325317;
        // ---------- Original Method ----------
        //return true;
    }

    
}

