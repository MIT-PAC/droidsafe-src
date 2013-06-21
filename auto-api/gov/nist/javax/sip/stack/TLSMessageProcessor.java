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
    protected int nConnections;
    private boolean isRunning;
    private Hashtable<String, TLSMessageChannel> tlsMessageChannels;
    private ServerSocket sock;
    protected int useCount = 0;
    private ArrayList<TLSMessageChannel> incomingTlsMessageChannels;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.180 -0400", hash_original_method = "625854FFB2FE295DE1DAD8EB11451B94", hash_generated_method = "4B2305C03CC3D69A720B6110E37BB896")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected TLSMessageProcessor(InetAddress ipAddress, SIPTransactionStack sipStack, int port) {
        super(ipAddress, port, "tls",sipStack);
        dsTaint.addTaint(port);
        dsTaint.addTaint(sipStack.dsTaint);
        dsTaint.addTaint(ipAddress.dsTaint);
        this.sipStack = sipStack;
        this.tlsMessageChannels = new Hashtable<String, TLSMessageChannel>();
        this.incomingTlsMessageChannels = new ArrayList<TLSMessageChannel>();
        // ---------- Original Method ----------
        //this.sipStack = sipStack;
        //this.tlsMessageChannels = new Hashtable<String, TLSMessageChannel>();
        //this.incomingTlsMessageChannels = new ArrayList<TLSMessageChannel>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.181 -0400", hash_original_method = "B69BE838486F71F317B5A550A92CFA4E", hash_generated_method = "84D601FD7583D04CC0CC80DD806A40FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.181 -0400", hash_original_method = "010F4DD19A92034627C31D97E026477A", hash_generated_method = "DC97E51ECF380A1160CCC6E0BF5CE035")
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
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_374195171 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.181 -0400", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "0AAC993F2B0EE288482DFA16632D8269")
    @DSModeled(DSC.SAFE)
    public SIPTransactionStack getSIPStack() {
        return (SIPTransactionStack)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sipStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.182 -0400", hash_original_method = "BE95A6D6EF1264E8946D0F06241C6C5A", hash_generated_method = "A4A4A0E1ED07CE2E5613E09CDA29CD16")
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
        en = tlsMessageChannels.values();
        {
            Iterator it;
            it = en.iterator();
            boolean var03729FD53960D8DCA3A41A13A0229637_1807388209 = (it.hasNext());
            {
                TLSMessageChannel next;
                next = (TLSMessageChannel) it.next();
                next.close();
            } //End block
        } //End collapsed parenthetic
        {
            Iterator incomingMCIterator;
            incomingMCIterator = incomingTlsMessageChannels.iterator();
            boolean var02145023CCC7750962C816C772AD4FC3_1079182013 = (incomingMCIterator
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.182 -0400", hash_original_method = "49128F6B4DFB9F6CFFFDE7784E6898EB", hash_generated_method = "AAD21FA33ECC3A61301C119325E41513")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected synchronized void remove(TLSMessageChannel tlsMessageChannel) {
        dsTaint.addTaint(tlsMessageChannel.dsTaint);
        String key;
        key = tlsMessageChannel.getKey();
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1837045018 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(Thread.currentThread() + " removing " + key);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var82717004E4624C3F5BD538E61F2FBB2A_441345464 = (tlsMessageChannels.get(key) == tlsMessageChannel);
            this.tlsMessageChannels.remove(key);
        } //End collapsed parenthetic
        incomingTlsMessageChannels.remove(tlsMessageChannel);
        // ---------- Original Method ----------
        //String key = tlsMessageChannel.getKey();
        //if (sipStack.isLoggingEnabled()) {
            //sipStack.getStackLogger().logDebug(Thread.currentThread() + " removing " + key);
        //}
        //if (tlsMessageChannels.get(key) == tlsMessageChannel)
            //this.tlsMessageChannels.remove(key);
        //incomingTlsMessageChannels.remove(tlsMessageChannel);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.182 -0400", hash_original_method = "E2A4A9C2C749BC9ACAA11AC1B54DE26B", hash_generated_method = "F24C231FD2440DDB3AAA2F5710B85155")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized MessageChannel createMessageChannel(HostPort targetHostPort) throws IOException {
        dsTaint.addTaint(targetHostPort.dsTaint);
        String key;
        key = MessageChannel.getKey(targetHostPort, "TLS");
        {
            boolean var92C3CA59539D6814B760C707BBC045D0_43620573 = (tlsMessageChannels.get(key) != null);
            {
                MessageChannel var91D1206496AA5DCCF310586B711FC473_277294961 = ((TLSMessageChannel) this.tlsMessageChannels.get(key));
            } //End block
            {
                TLSMessageChannel retval;
                retval = new TLSMessageChannel(targetHostPort.getInetAddress(),
                    targetHostPort.getPort(), sipStack, this);
                this.tlsMessageChannels.put(key, retval);
                retval.isCached = true;
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_853576035 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug("key " + key);
                        sipStack.getStackLogger().logDebug("Creating " + retval);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (MessageChannel)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.183 -0400", hash_original_method = "EAE2407B3CE4BB7D6FC77F5E6B72F7C1", hash_generated_method = "98B1C56F223B50A01375FF75229BA79D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected synchronized void cacheMessageChannel(TLSMessageChannel messageChannel) {
        dsTaint.addTaint(messageChannel.dsTaint);
        String key;
        key = messageChannel.getKey();
        TLSMessageChannel currentChannel;
        currentChannel = (TLSMessageChannel) tlsMessageChannels.get(key);
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1837008362 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Closing " + key);
            } //End collapsed parenthetic
            currentChannel.close();
        } //End block
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1898130251 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("Caching " + key);
        } //End collapsed parenthetic
        this.tlsMessageChannels.put(key, messageChannel);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.183 -0400", hash_original_method = "E42B1ACE44C65E212B4362CBBBBFF2DD", hash_generated_method = "8816A84472889AAB3AE0CA8A2FA94268")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized MessageChannel createMessageChannel(InetAddress host, int port) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host.dsTaint);
        try 
        {
            String key;
            key = MessageChannel.getKey(host, port, "TLS");
            {
                boolean varF4CA62E1BC21A8BF70A1D16FD5BE5584_1264717830 = (tlsMessageChannels.get(key) != null);
                {
                    MessageChannel var5757C42E4EF78A73AB2DBB7A604F1767_1877683184 = ((TLSMessageChannel) this.tlsMessageChannels.get(key));
                } //End block
                {
                    TLSMessageChannel retval;
                    retval = new TLSMessageChannel(host, port, sipStack, this);
                    this.tlsMessageChannels.put(key, retval);
                    retval.isCached = true;
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_133917055 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.183 -0400", hash_original_method = "248B80D43EBE2633D052A5A2C5B180CB", hash_generated_method = "A58B9C3C9C7400719F924DEA2BF5D863")
    @DSModeled(DSC.SAFE)
    public int getMaximumMessageSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Integer.MAX_VALUE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.183 -0400", hash_original_method = "C4E752535BCB329601986DF8A32049BD", hash_generated_method = "48F163C1FB4FB666CF02A1CF224E52EE")
    @DSModeled(DSC.SAFE)
    public boolean inUse() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.useCount != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.184 -0400", hash_original_method = "B951ECFC8A9F13621942685951F4919F", hash_generated_method = "0499DAB798C22AC3D40CFA559A5A3071")
    @DSModeled(DSC.SAFE)
    public int getDefaultTargetPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 5061;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.184 -0400", hash_original_method = "57D47F2F9FCDF87C613C3BEA50BCDEDC", hash_generated_method = "67C0E42DCF50A0B25E27F2905154C352")
    @DSModeled(DSC.SAFE)
    public boolean isSecure() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
}

