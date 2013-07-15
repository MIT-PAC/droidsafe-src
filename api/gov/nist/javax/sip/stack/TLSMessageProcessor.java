package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.392 -0400", hash_original_field = "ABC7702D7C8D3D2EE6A5C679253AE9AF", hash_generated_field = "D720E7EA87A425C9C359604A7CD3BB49")

    protected int nConnections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.392 -0400", hash_original_field = "39044C41F340C67BFA15E91CC6E98E7D", hash_generated_field = "CE50F8CB2D618D5E2ED1602B4F1188A5")

    private boolean isRunning;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.392 -0400", hash_original_field = "812366AFB87FEE30EB54A9F80708E917", hash_generated_field = "F9EEBC64CC7E0970F5BCA104E833B093")

    private Hashtable<String, TLSMessageChannel> tlsMessageChannels;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.392 -0400", hash_original_field = "317D37B0EDC7BD7CBD25D97F53A16CE5", hash_generated_field = "FB56C66DB0DF522F5632D1532BCC403B")

    private ServerSocket sock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.392 -0400", hash_original_field = "565BA180312610DDE2BA2E2026D497C4", hash_generated_field = "1DC0791E679E20EB98C16DB302A56E6D")

    protected int useCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.392 -0400", hash_original_field = "45CCA41745ACD205A06850F50929AFA3", hash_generated_field = "93B52B6ED94104F7CA5FDE37F83993D5")

    private ArrayList<TLSMessageChannel> incomingTlsMessageChannels;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.393 -0400", hash_original_method = "625854FFB2FE295DE1DAD8EB11451B94", hash_generated_method = "93982FF0AF11823800F729A927DBA008")
    protected  TLSMessageProcessor(InetAddress ipAddress, SIPTransactionStack sipStack, int port) {
        super(ipAddress, port, "tls",sipStack);
        addTaint(port);
        addTaint(sipStack.getTaint());
        addTaint(ipAddress.getTaint());
        this.sipStack = sipStack;
        this.tlsMessageChannels = new Hashtable<String, TLSMessageChannel>();
        this.incomingTlsMessageChannels = new ArrayList<TLSMessageChannel>();
        // ---------- Original Method ----------
        //this.sipStack = sipStack;
        //this.tlsMessageChannels = new Hashtable<String, TLSMessageChannel>();
        //this.incomingTlsMessageChannels = new ArrayList<TLSMessageChannel>();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.394 -0400", hash_original_method = "B69BE838486F71F317B5A550A92CFA4E", hash_generated_method = "00132EE04A0C25CFB6354B8A68B13323")
    public void start() throws IOException {
        Thread thread = new Thread(this);
        thread.setName("TLSMessageProcessorThread");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.setDaemon(true);
        this.sock = sipStack.getNetworkLayer().createSSLServerSocket(this.getPort(), 0,
                this.getIpAddress());
        ((SSLServerSocket) this.sock).setNeedClientAuth(false);
        ((SSLServerSocket) this.sock).setUseClientMode(false);
        ((SSLServerSocket) this.sock).setWantClientAuth(true);
        String [] enabledCiphers = ((SipStackImpl)sipStack).getEnabledCipherSuites();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.395 -0400", hash_original_method = "010F4DD19A92034627C31D97E026477A", hash_generated_method = "AA759EF25E09778719ED10F86C980458")
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
                sipStack.getStackLogger().logDebug("Accepting new connection!");
                incomingTlsMessageChannels.add(new TLSMessageChannel(newsock, sipStack, this));
            } //End block
            catch (SocketException ex)
            {
    if(this.isRunning)                
                {
                    sipStack.getStackLogger().logError(
                    "Fatal - SocketException occured while Accepting connection", ex);
                    this.isRunning = false;
                    break;
                } //End block
            } //End block
            catch (SSLException ex)
            {
                this.isRunning = false;
                sipStack.getStackLogger().logError(
                        "Fatal - SSSLException occured while Accepting connection", ex);
                break;
            } //End block
            catch (IOException ex)
            {
                sipStack.getStackLogger().logError("Problem Accepting Connection", ex);
                continue;
            } //End block
            catch (Exception ex)
            {
                sipStack.getStackLogger().logError("Unexpected Exception!", ex);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.396 -0400", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "FBD6E20BFA80BFA8DC2E21125D40CFA4")
    public SIPTransactionStack getSIPStack() {
SIPTransactionStack var0FC1F21ED47F4C0C48881B0DAF112A16_159863479 =         sipStack;
        var0FC1F21ED47F4C0C48881B0DAF112A16_159863479.addTaint(taint);
        return var0FC1F21ED47F4C0C48881B0DAF112A16_159863479;
        // ---------- Original Method ----------
        //return sipStack;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.397 -0400", hash_original_method = "BE95A6D6EF1264E8946D0F06241C6C5A", hash_generated_method = "6D9BE9F52DAD12BD858D0792D1624D31")
    public synchronized void stop() {
    if(!isRunning)        
        return;
        isRunning = false;
        try 
        {
            sock.close();
        } //End block
        catch (IOException e)
        {
            e.printStackTrace();
        } //End block
        Collection en = tlsMessageChannels.values();
for(Iterator it = en.iterator();it.hasNext();)
        {
            TLSMessageChannel next = (TLSMessageChannel) it.next();
            next.close();
        } //End block
for(Iterator incomingMCIterator = incomingTlsMessageChannels.iterator();incomingMCIterator
                .hasNext();)
        {
            TLSMessageChannel next = (TLSMessageChannel) incomingMCIterator.next();
            next.close();
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.397 -0400", hash_original_method = "49128F6B4DFB9F6CFFFDE7784E6898EB", hash_generated_method = "68CF497D0FDCBF6E16D3A838584D7986")
    protected synchronized void remove(TLSMessageChannel tlsMessageChannel) {
        addTaint(tlsMessageChannel.getTaint());
        String key = tlsMessageChannel.getKey();
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug(Thread.currentThread() + " removing " + key);
        } //End block
    if(tlsMessageChannels.get(key) == tlsMessageChannel)        
        this.tlsMessageChannels.remove(key);
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.398 -0400", hash_original_method = "E2A4A9C2C749BC9ACAA11AC1B54DE26B", hash_generated_method = "2C8508ECBC1C119F2C7189CB27692B96")
    public synchronized MessageChannel createMessageChannel(HostPort targetHostPort) throws IOException {
        addTaint(targetHostPort.getTaint());
        String key = MessageChannel.getKey(targetHostPort, "TLS");
    if(tlsMessageChannels.get(key) != null)        
        {
MessageChannel var4BE7638D5E38A3D0169DE770CD2931E8_1573738053 =             (TLSMessageChannel) this.tlsMessageChannels.get(key);
            var4BE7638D5E38A3D0169DE770CD2931E8_1573738053.addTaint(taint);
            return var4BE7638D5E38A3D0169DE770CD2931E8_1573738053;
        } //End block
        else
        {
            TLSMessageChannel retval = new TLSMessageChannel(targetHostPort.getInetAddress(),
                    targetHostPort.getPort(), sipStack, this);
            this.tlsMessageChannels.put(key, retval);
            retval.isCached = true;
    if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logDebug("key " + key);
                sipStack.getStackLogger().logDebug("Creating " + retval);
            } //End block
MessageChannel varF9E19AD6135C970F387F77C6F3DE4477_1813871696 =             retval;
            varF9E19AD6135C970F387F77C6F3DE4477_1813871696.addTaint(taint);
            return varF9E19AD6135C970F387F77C6F3DE4477_1813871696;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.399 -0400", hash_original_method = "EAE2407B3CE4BB7D6FC77F5E6B72F7C1", hash_generated_method = "8906A7EA31BCE0280202AC9CA9A6CB6A")
    protected synchronized void cacheMessageChannel(TLSMessageChannel messageChannel) {
        addTaint(messageChannel.getTaint());
        String key = messageChannel.getKey();
        TLSMessageChannel currentChannel = (TLSMessageChannel) tlsMessageChannels.get(key);
    if(currentChannel != null)        
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logDebug("Closing " + key);
            currentChannel.close();
        } //End block
    if(sipStack.isLoggingEnabled())        
        sipStack.getStackLogger().logDebug("Caching " + key);
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.400 -0400", hash_original_method = "E42B1ACE44C65E212B4362CBBBBFF2DD", hash_generated_method = "746F58DFA593A45D436D16F08935E6E3")
    public synchronized MessageChannel createMessageChannel(InetAddress host, int port) throws IOException {
        addTaint(port);
        addTaint(host.getTaint());
        try 
        {
            String key = MessageChannel.getKey(host, port, "TLS");
    if(tlsMessageChannels.get(key) != null)            
            {
MessageChannel var4BE7638D5E38A3D0169DE770CD2931E8_1326649973 =                 (TLSMessageChannel) this.tlsMessageChannels.get(key);
                var4BE7638D5E38A3D0169DE770CD2931E8_1326649973.addTaint(taint);
                return var4BE7638D5E38A3D0169DE770CD2931E8_1326649973;
            } //End block
            else
            {
                TLSMessageChannel retval = new TLSMessageChannel(host, port, sipStack, this);
                this.tlsMessageChannels.put(key, retval);
                retval.isCached = true;
    if(sipStack.isLoggingEnabled())                
                {
                    sipStack.getStackLogger().logDebug("key " + key);
                    sipStack.getStackLogger().logDebug("Creating " + retval);
                } //End block
MessageChannel varF9E19AD6135C970F387F77C6F3DE4477_928121106 =                 retval;
                varF9E19AD6135C970F387F77C6F3DE4477_928121106.addTaint(taint);
                return varF9E19AD6135C970F387F77C6F3DE4477_928121106;
            } //End block
        } //End block
        catch (UnknownHostException ex)
        {
            IOException var1FC0CF6650AEC5395B2E1C7E06C33B6F_204384111 = new IOException(ex.getMessage());
            var1FC0CF6650AEC5395B2E1C7E06C33B6F_204384111.addTaint(taint);
            throw var1FC0CF6650AEC5395B2E1C7E06C33B6F_204384111;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.400 -0400", hash_original_method = "248B80D43EBE2633D052A5A2C5B180CB", hash_generated_method = "6457AA8E0582B8AB98F79E8526072027")
    public int getMaximumMessageSize() {
        int varE7A95D949116A2DA0F0FA83DC6E76C00_953080864 = (Integer.MAX_VALUE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1122397139 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1122397139;
        // ---------- Original Method ----------
        //return Integer.MAX_VALUE;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.400 -0400", hash_original_method = "C4E752535BCB329601986DF8A32049BD", hash_generated_method = "A0650F02BD230F7F46F5D1F27BFA0A72")
    public boolean inUse() {
        boolean varBD86A4DC7E4A98958B2E800FF150F372_2096473923 = (this.useCount != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_15358364 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_15358364;
        // ---------- Original Method ----------
        //return this.useCount != 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.401 -0400", hash_original_method = "B951ECFC8A9F13621942685951F4919F", hash_generated_method = "5D64337807B1EE83E4F2BF5A21105336")
    public int getDefaultTargetPort() {
        int varF466E84E4D899DDA09BE2BF2D3D7ECE3_472777232 = (5061);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_201280559 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_201280559;
        // ---------- Original Method ----------
        //return 5061;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.401 -0400", hash_original_method = "57D47F2F9FCDF87C613C3BEA50BCDEDC", hash_generated_method = "9801585D475B2351D7CF4B9D9A7411D7")
    public boolean isSecure() {
        boolean varB326B5062B2F0E69046810717534CB09_1216435038 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1454176071 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1454176071;
        // ---------- Original Method ----------
        //return true;
    }

    
}

