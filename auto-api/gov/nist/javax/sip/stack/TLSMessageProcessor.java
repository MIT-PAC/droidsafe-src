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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.594 -0400", hash_original_field = "ABC7702D7C8D3D2EE6A5C679253AE9AF", hash_generated_field = "D720E7EA87A425C9C359604A7CD3BB49")

    protected int nConnections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.594 -0400", hash_original_field = "39044C41F340C67BFA15E91CC6E98E7D", hash_generated_field = "CE50F8CB2D618D5E2ED1602B4F1188A5")

    private boolean isRunning;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.594 -0400", hash_original_field = "812366AFB87FEE30EB54A9F80708E917", hash_generated_field = "F9EEBC64CC7E0970F5BCA104E833B093")

    private Hashtable<String, TLSMessageChannel> tlsMessageChannels;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.594 -0400", hash_original_field = "317D37B0EDC7BD7CBD25D97F53A16CE5", hash_generated_field = "FB56C66DB0DF522F5632D1532BCC403B")

    private ServerSocket sock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.594 -0400", hash_original_field = "565BA180312610DDE2BA2E2026D497C4", hash_generated_field = "1DC0791E679E20EB98C16DB302A56E6D")

    protected int useCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.594 -0400", hash_original_field = "45CCA41745ACD205A06850F50929AFA3", hash_generated_field = "93B52B6ED94104F7CA5FDE37F83993D5")

    private ArrayList<TLSMessageChannel> incomingTlsMessageChannels;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.597 -0400", hash_original_method = "625854FFB2FE295DE1DAD8EB11451B94", hash_generated_method = "116A39962D2DD2C055FE04F7D393DB95")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.599 -0400", hash_original_method = "B69BE838486F71F317B5A550A92CFA4E", hash_generated_method = "84D601FD7583D04CC0CC80DD806A40FD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.602 -0400", hash_original_method = "010F4DD19A92034627C31D97E026477A", hash_generated_method = "02887BE9855D4FD27B1B60F747BB6662")
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
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1991336921 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.602 -0400", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "4BED097960677CE5408B96D2E89C3BE4")
    public SIPTransactionStack getSIPStack() {
        SIPTransactionStack varB4EAC82CA7396A68D541C85D26508E83_176115289 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_176115289 = sipStack;
        varB4EAC82CA7396A68D541C85D26508E83_176115289.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_176115289;
        // ---------- Original Method ----------
        //return sipStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.604 -0400", hash_original_method = "BE95A6D6EF1264E8946D0F06241C6C5A", hash_generated_method = "2F65BF4453733D71B4BE3555D752111B")
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
            boolean var03729FD53960D8DCA3A41A13A0229637_848350937 = (it.hasNext());
            {
                TLSMessageChannel next;
                next = (TLSMessageChannel) it.next();
                next.close();
            } //End block
        } //End collapsed parenthetic
        {
            Iterator incomingMCIterator;
            incomingMCIterator = incomingTlsMessageChannels.iterator();
            boolean var02145023CCC7750962C816C772AD4FC3_1531810020 = (incomingMCIterator
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.605 -0400", hash_original_method = "49128F6B4DFB9F6CFFFDE7784E6898EB", hash_generated_method = "47EC6FC59B5D73E197ED9F7438D77769")
    protected synchronized void remove(TLSMessageChannel tlsMessageChannel) {
        String key;
        key = tlsMessageChannel.getKey();
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1413620964 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(Thread.currentThread() + " removing " + key);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var82717004E4624C3F5BD538E61F2FBB2A_325880213 = (tlsMessageChannels.get(key) == tlsMessageChannel);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.605 -0400", hash_original_method = "E2A4A9C2C749BC9ACAA11AC1B54DE26B", hash_generated_method = "37A3F4AA2B90E01B769B722AC40181E1")
    public synchronized MessageChannel createMessageChannel(HostPort targetHostPort) throws IOException {
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_1824596206 = null; //Variable for return #1
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_430311432 = null; //Variable for return #2
        String key;
        key = MessageChannel.getKey(targetHostPort, "TLS");
        {
            boolean var92C3CA59539D6814B760C707BBC045D0_798317994 = (tlsMessageChannels.get(key) != null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1824596206 = (TLSMessageChannel) this.tlsMessageChannels.get(key);
            } //End block
            {
                TLSMessageChannel retval;
                retval = new TLSMessageChannel(targetHostPort.getInetAddress(),
                    targetHostPort.getPort(), sipStack, this);
                this.tlsMessageChannels.put(key, retval);
                retval.isCached = true;
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1013545582 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug("key " + key);
                        sipStack.getStackLogger().logDebug("Creating " + retval);
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_430311432 = retval;
            } //End block
        } //End collapsed parenthetic
        addTaint(targetHostPort.getTaint());
        MessageChannel varA7E53CE21691AB073D9660D615818899_859454956; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_859454956 = varB4EAC82CA7396A68D541C85D26508E83_1824596206;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_859454956 = varB4EAC82CA7396A68D541C85D26508E83_430311432;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_859454956.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_859454956;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.612 -0400", hash_original_method = "EAE2407B3CE4BB7D6FC77F5E6B72F7C1", hash_generated_method = "43DAB2232449055E69B430051CBF0817")
    protected synchronized void cacheMessageChannel(TLSMessageChannel messageChannel) {
        String key;
        key = messageChannel.getKey();
        TLSMessageChannel currentChannel;
        currentChannel = (TLSMessageChannel) tlsMessageChannels.get(key);
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1944948712 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Closing " + key);
            } //End collapsed parenthetic
            currentChannel.close();
        } //End block
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1800734293 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.622 -0400", hash_original_method = "E42B1ACE44C65E212B4362CBBBBFF2DD", hash_generated_method = "9299E679E5B4AB1EF0D84F2E29E75D53")
    public synchronized MessageChannel createMessageChannel(InetAddress host, int port) throws IOException {
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_1512289839 = null; //Variable for return #1
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_200107281 = null; //Variable for return #2
        try 
        {
            String key;
            key = MessageChannel.getKey(host, port, "TLS");
            {
                boolean varF4CA62E1BC21A8BF70A1D16FD5BE5584_384172835 = (tlsMessageChannels.get(key) != null);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1512289839 = (TLSMessageChannel) this.tlsMessageChannels.get(key);
                } //End block
                {
                    TLSMessageChannel retval;
                    retval = new TLSMessageChannel(host, port, sipStack, this);
                    this.tlsMessageChannels.put(key, retval);
                    retval.isCached = true;
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1172246097 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logDebug("key " + key);
                            sipStack.getStackLogger().logDebug("Creating " + retval);
                        } //End block
                    } //End collapsed parenthetic
                    varB4EAC82CA7396A68D541C85D26508E83_200107281 = retval;
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (UnknownHostException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException(ex.getMessage());
        } //End block
        addTaint(host.getTaint());
        addTaint(port);
        MessageChannel varA7E53CE21691AB073D9660D615818899_1791925569; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1791925569 = varB4EAC82CA7396A68D541C85D26508E83_1512289839;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1791925569 = varB4EAC82CA7396A68D541C85D26508E83_200107281;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1791925569.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1791925569;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.625 -0400", hash_original_method = "248B80D43EBE2633D052A5A2C5B180CB", hash_generated_method = "AC30DD4CCBE1FAE6261BF6E8BB0E97AE")
    public int getMaximumMessageSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1192336220 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1192336220;
        // ---------- Original Method ----------
        //return Integer.MAX_VALUE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.625 -0400", hash_original_method = "C4E752535BCB329601986DF8A32049BD", hash_generated_method = "D4FE1D7112E46752A91706A78DCE9A8A")
    public boolean inUse() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_562843495 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_562843495;
        // ---------- Original Method ----------
        //return this.useCount != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.629 -0400", hash_original_method = "B951ECFC8A9F13621942685951F4919F", hash_generated_method = "97CA64EAEDF67721CEFC88B85E79150C")
    public int getDefaultTargetPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2143441520 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2143441520;
        // ---------- Original Method ----------
        //return 5061;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.629 -0400", hash_original_method = "57D47F2F9FCDF87C613C3BEA50BCDEDC", hash_generated_method = "8E7CF681145049214BC906B633520C74")
    public boolean isSecure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1271106324 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1271106324;
        // ---------- Original Method ----------
        //return true;
    }

    
}

