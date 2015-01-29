package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.HostPort;
import gov.nist.javax.sip.SipStackImpl;

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

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLServerSocket;

public class TLSMessageProcessor extends MessageProcessor {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.803 -0500", hash_original_field = "3E7D136CB50987E965906415399DB0D1", hash_generated_field = "D720E7EA87A425C9C359604A7CD3BB49")

    protected int nConnections;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.806 -0500", hash_original_field = "5EBE085FDB38216257993802E75ABBBF", hash_generated_field = "CE50F8CB2D618D5E2ED1602B4F1188A5")

    private boolean isRunning;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.809 -0500", hash_original_field = "959CE6BF0A6F182DD9867A432238FC87", hash_generated_field = "F9EEBC64CC7E0970F5BCA104E833B093")

    private Hashtable<String, TLSMessageChannel> tlsMessageChannels;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.812 -0500", hash_original_field = "F87D5147B4D201968440828D580BDC80", hash_generated_field = "FB56C66DB0DF522F5632D1532BCC403B")

    private ServerSocket sock;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.814 -0500", hash_original_field = "1FB513CCC6764195350E057EABA09B44", hash_generated_field = "1DC0791E679E20EB98C16DB302A56E6D")

    protected int useCount = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.817 -0500", hash_original_field = "C5DB6D818E0B7BCA91032FDFDE928C68", hash_generated_field = "93B52B6ED94104F7CA5FDE37F83993D5")

    private ArrayList<TLSMessageChannel> incomingTlsMessageChannels;

    /**
     * Constructor.
     * 
     * @param ipAddress -- inet address where I am listening.
     * @param sipStack SIPStack structure.
     * @param port port where this message processor listens.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.820 -0500", hash_original_method = "625854FFB2FE295DE1DAD8EB11451B94", hash_generated_method = "CC3B74D1431FDA0E4628DB58D1F98F93")
    
protected TLSMessageProcessor(InetAddress ipAddress, SIPTransactionStack sipStack, int port) {
        super(ipAddress, port, "tls",sipStack);
        this.sipStack = sipStack;
        this.tlsMessageChannels = new Hashtable<String, TLSMessageChannel>();
        this.incomingTlsMessageChannels = new ArrayList<TLSMessageChannel>();

    }

    /**
     * Start the processor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.824 -0500", hash_original_method = "B69BE838486F71F317B5A550A92CFA4E", hash_generated_method = "25A014A1FEF19B4236FB3CA40FF0BD1E")
    
public void start() throws IOException {
        Thread thread = new Thread(this);
        thread.setName("TLSMessageProcessorThread");
        // ISSUE 184
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.setDaemon(true);

        this.sock = sipStack.getNetworkLayer().createSSLServerSocket(this.getPort(), 0,
                this.getIpAddress());
        ((SSLServerSocket) this.sock).setNeedClientAuth(false);
        ((SSLServerSocket) this.sock).setUseClientMode(false);
        ((SSLServerSocket) this.sock).setWantClientAuth(true);
        String []enabledCiphers = ((SipStackImpl)sipStack).getEnabledCipherSuites();
        ((SSLServerSocket) this.sock).setEnabledCipherSuites(enabledCiphers);
        ((SSLServerSocket)this.sock).setWantClientAuth(true);

        this.isRunning = true;
        thread.start();

    }

    /**
     * Run method for the thread that gets created for each accept socket.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.827 -0500", hash_original_method = "010F4DD19A92034627C31D97E026477A", hash_generated_method = "3A402C5C0641CAA4728B7DF4E6CF9B56")
    
public void run() {
        // Accept new connectins on our socket.
        while (this.isRunning) {
            try {
                synchronized (this) {
                    // sipStack.maxConnections == -1 means we are
                    // willing to handle an "infinite" number of
                    // simultaneous connections (no resource limitation).
                    // This is the default behavior.
                    while (sipStack.maxConnections != -1
                            && this.nConnections >= sipStack.maxConnections) {
                        try {
                            this.wait();

                            if (!this.isRunning)
                                return;
                        } catch (InterruptedException ex) {
                            break;
                        }
                    }
                    this.nConnections++;
                }

                Socket newsock = sock.accept();
               
                if (sipStack.isLoggingEnabled())
                    sipStack.getStackLogger().logDebug("Accepting new connection!");
                
               // Note that for an incoming message channel, the
               // thread is already running

                incomingTlsMessageChannels.add(new TLSMessageChannel(newsock, sipStack, this));
            } catch (SocketException ex) {
                if ( this.isRunning ) {
                  sipStack.getStackLogger().logError(
                    "Fatal - SocketException occured while Accepting connection", ex);
                  this.isRunning = false;
                  break;
                }
            } catch (SSLException ex) {
                this.isRunning = false;
                sipStack.getStackLogger().logError(
                        "Fatal - SSSLException occured while Accepting connection", ex);
                break;
            } catch (IOException ex) {
                // Problem accepting connection.
                sipStack.getStackLogger().logError("Problem Accepting Connection", ex);
                continue;
            } catch (Exception ex) {
                sipStack.getStackLogger().logError("Unexpected Exception!", ex);
            }
        }
    }

    /**
     * Returns the stack.
     * 
     * @return my sip stack.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.829 -0500", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "7DFF2B9EFB272B5F349D68AD73E9A18C")
    
public SIPTransactionStack getSIPStack() {
        return sipStack;
    }

    /**
     * Stop the message processor. Feature suggested by Jeff Keyser.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.833 -0500", hash_original_method = "BE95A6D6EF1264E8946D0F06241C6C5A", hash_generated_method = "642732700FA1CD6509DEBEB54281BCE2")
    
public synchronized void stop() {
        if (!isRunning)
            return;

        isRunning = false;
        try {
            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collection en = tlsMessageChannels.values();
        for (Iterator it = en.iterator(); it.hasNext();) {
            TLSMessageChannel next = (TLSMessageChannel) it.next();
            next.close();
        }
        for (Iterator incomingMCIterator = incomingTlsMessageChannels.iterator(); incomingMCIterator
                .hasNext();) {
            TLSMessageChannel next = (TLSMessageChannel) incomingMCIterator.next();
            next.close();
        }
        this.notify();

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.836 -0500", hash_original_method = "49128F6B4DFB9F6CFFFDE7784E6898EB", hash_generated_method = "C4AB21ADDE8CA1B2156CF3EA0B996F55")
    
protected synchronized void remove(TLSMessageChannel tlsMessageChannel) {

        String key = tlsMessageChannel.getKey();
        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug(Thread.currentThread() + " removing " + key);
        }

        /** May have been removed already */
        if (tlsMessageChannels.get(key) == tlsMessageChannel)
            this.tlsMessageChannels.remove(key);
        
        incomingTlsMessageChannels.remove(tlsMessageChannel);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.840 -0500", hash_original_method = "E2A4A9C2C749BC9ACAA11AC1B54DE26B", hash_generated_method = "ADD2B33F2771244593947CEFF0B26842")
    
public synchronized MessageChannel createMessageChannel(HostPort targetHostPort)
            throws IOException {
        String key = MessageChannel.getKey(targetHostPort, "TLS");
        if (tlsMessageChannels.get(key) != null) {
            return (TLSMessageChannel) this.tlsMessageChannels.get(key);
        } else {
            TLSMessageChannel retval = new TLSMessageChannel(targetHostPort.getInetAddress(),
                    targetHostPort.getPort(), sipStack, this);
            this.tlsMessageChannels.put(key, retval);
            retval.isCached = true;
            if (sipStack.isLoggingEnabled()) {
                sipStack.getStackLogger().logDebug("key " + key);
                sipStack.getStackLogger().logDebug("Creating " + retval);
            }
            return retval;
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.843 -0500", hash_original_method = "EAE2407B3CE4BB7D6FC77F5E6B72F7C1", hash_generated_method = "0A338B0A736847EB50D535119659EAEC")
    
protected synchronized void cacheMessageChannel(TLSMessageChannel messageChannel) {
        String key = messageChannel.getKey();
        TLSMessageChannel currentChannel = (TLSMessageChannel) tlsMessageChannels.get(key);
        if (currentChannel != null) {
            if (sipStack.isLoggingEnabled())
                sipStack.getStackLogger().logDebug("Closing " + key);
            currentChannel.close();
        }
        if (sipStack.isLoggingEnabled())
            sipStack.getStackLogger().logDebug("Caching " + key);
        this.tlsMessageChannels.put(key, messageChannel);

    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.846 -0500", hash_original_method = "E42B1ACE44C65E212B4362CBBBBFF2DD", hash_generated_method = "33241DE227631787DE49E3F122CAB7D3")
    
public synchronized MessageChannel createMessageChannel(InetAddress host, int port)
            throws IOException {
        try {
            String key = MessageChannel.getKey(host, port, "TLS");
            if (tlsMessageChannels.get(key) != null) {
                return (TLSMessageChannel) this.tlsMessageChannels.get(key);
            } else {
                TLSMessageChannel retval = new TLSMessageChannel(host, port, sipStack, this);
                this.tlsMessageChannels.put(key, retval);
                retval.isCached = true;
                if (sipStack.isLoggingEnabled()) {
                    sipStack.getStackLogger().logDebug("key " + key);
                    sipStack.getStackLogger().logDebug("Creating " + retval);
                }
                return retval;
            }
        } catch (UnknownHostException ex) {
            throw new IOException(ex.getMessage());
        }
    }

    /**
     * TLS can handle an unlimited number of bytes.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.848 -0500", hash_original_method = "248B80D43EBE2633D052A5A2C5B180CB", hash_generated_method = "CA9A4BABAD31A74E1D32220278B56EB2")
    
public int getMaximumMessageSize() {
        return Integer.MAX_VALUE;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.851 -0500", hash_original_method = "C4E752535BCB329601986DF8A32049BD", hash_generated_method = "B4CA0ABE6335781D018588C30F03B3CA")
    
public boolean inUse() {
        return this.useCount != 0;
    }

    /**
     * Default target port for TLS
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.853 -0500", hash_original_method = "B951ECFC8A9F13621942685951F4919F", hash_generated_method = "504286D67C4B3F7559AF77DEEA329DAA")
    
public int getDefaultTargetPort() {
        return 5061;
    }

    /**
     * TLS is a secure protocol.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:26.857 -0500", hash_original_method = "57D47F2F9FCDF87C613C3BEA50BCDEDC", hash_generated_method = "DDFD1156A672B3D06EE42F0698E0914D")
    
public boolean isSecure() {
        return true;
    }
    
}

