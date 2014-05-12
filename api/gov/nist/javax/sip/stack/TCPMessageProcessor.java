package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

public class TCPMessageProcessor extends MessageProcessor {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.874 -0500", hash_original_field = "3E7D136CB50987E965906415399DB0D1", hash_generated_field = "D720E7EA87A425C9C359604A7CD3BB49")

    protected int nConnections;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.877 -0500", hash_original_field = "5EBE085FDB38216257993802E75ABBBF", hash_generated_field = "CE50F8CB2D618D5E2ED1602B4F1188A5")

    private boolean isRunning;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.879 -0500", hash_original_field = "80DB71A53B0781054FD4E3FEDE7D2953", hash_generated_field = "ABA66BF5920EEDB54F4A360C721737A3")

    private Hashtable tcpMessageChannels;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.881 -0500", hash_original_field = "B78EFB6ADF0D0F60798CFF8DE9761D94", hash_generated_field = "3CA1EEC3C31C7352901A5A9695447AE6")

    private ArrayList<TCPMessageChannel> incomingTcpMessageChannels;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.884 -0500", hash_original_field = "F87D5147B4D201968440828D580BDC80", hash_generated_field = "FB56C66DB0DF522F5632D1532BCC403B")

    private ServerSocket sock;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.886 -0500", hash_original_field = "43A0963BA6DFAE0550944671844C16DD", hash_generated_field = "8B62D61316200E61EA0A60A5551D82D6")

    protected int useCount;

    /**
     * Constructor.
     * 
     * @param sipStack SIPStack structure.
     * @param port port where this message processor listens.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.889 -0500", hash_original_method = "DF01D933234B7570953E27AF1B039A12", hash_generated_method = "60EC148A10AF7CAA6761BE13BC897301")
    
protected TCPMessageProcessor(InetAddress ipAddress, SIPTransactionStack sipStack, int port) {
        super(ipAddress, port, "tcp",sipStack);

        this.sipStack = sipStack;

        this.tcpMessageChannels = new Hashtable();
        this.incomingTcpMessageChannels = new ArrayList<TCPMessageChannel>();
    }

    /**
     * Start the processor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.893 -0500", hash_original_method = "1E47DBAC30060B20437BE89450E78A73", hash_generated_method = "6A957EBFBE1B410FA9909AE20F97CB3F")
    
public void start() throws IOException {
        Thread thread = new Thread(this);
        thread.setName("TCPMessageProcessorThread");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.setDaemon(true);
        this.sock = sipStack.getNetworkLayer().createServerSocket(getPort(), 0, getIpAddress());
        if (getIpAddress().getHostAddress().equals(IN_ADDR_ANY)
                || getIpAddress().getHostAddress().equals(IN6_ADDR_ANY)) {
            // Store the address to which we are actually bound
            super.setIpAddress(sock.getInetAddress());

        }
        this.isRunning = true;
        thread.start();

    }

    /**
     * Run method for the thread that gets created for each accept socket.
     */
    @DSSpec(DSCat.THREADING)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.897 -0500", hash_original_method = "BD1C6A6330D89BF80F1DBE244E3DBF31", hash_generated_method = "2E2352B9AC294EC89AB900FF85D56561")
    
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
                if (sipStack.isLoggingEnabled()) {
                    getSIPStack().getStackLogger().logDebug("Accepting new connection!");
                }
                // Note that for an incoming message channel, the
                // thread is already running
               
                incomingTcpMessageChannels.add(new TCPMessageChannel(newsock, sipStack, this));
            } catch (SocketException ex) {
                this.isRunning = false;
            } catch (IOException ex) {
                // Problem accepting connection.
                if (sipStack.isLoggingEnabled())
                    getSIPStack().getStackLogger().logException(ex);
                continue;
            } catch (Exception ex) {
                InternalErrorHandler.handleException(ex);
            }
        }
    }

    /**
     * Return the transport string.
     * 
     * @return the transport string
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.899 -0500", hash_original_method = "8ED81941CDC62D91B3E3601661099BB4", hash_generated_method = "C34EF21A0D0D7DE117709E967556F61E")
    
public String getTransport() {
        return "tcp";
    }

    /**
     * Returns the stack.
     * 
     * @return my sip stack.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.902 -0500", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "7DFF2B9EFB272B5F349D68AD73E9A18C")
    
public SIPTransactionStack getSIPStack() {
        return sipStack;
    }

    /**
     * Stop the message processor. Feature suggested by Jeff Keyser.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.905 -0500", hash_original_method = "EFC3C9ACE40E1AFA4E42220FC9A24C72", hash_generated_method = "F66C33970BF05D2E98CDEA91DEC65093")
    
public synchronized void stop() {
        isRunning = false;
        // this.listeningPoint = null;
        try {
            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collection en = tcpMessageChannels.values();
        for (Iterator it = en.iterator(); it.hasNext();) {
            TCPMessageChannel next = (TCPMessageChannel) it.next();
            next.close();
        }
        // RRPN: fix
        for (Iterator incomingMCIterator = incomingTcpMessageChannels.iterator(); incomingMCIterator
                .hasNext();) {
            TCPMessageChannel next = (TCPMessageChannel) incomingMCIterator.next();
            next.close();
        }

        this.notify();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.908 -0500", hash_original_method = "E63037070BE0B3824038F0C58AF2A6B7", hash_generated_method = "A7A8F04B2311565F47926EF503E4EFE1")
    
protected synchronized void remove(TCPMessageChannel tcpMessageChannel) {

        String key = tcpMessageChannel.getKey();
        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug(Thread.currentThread() + " removing " + key);
        }

        /** May have been removed already */
        if (tcpMessageChannels.get(key) == tcpMessageChannel) {
            this.tcpMessageChannels.remove(key);
        }

        incomingTcpMessageChannels.remove(tcpMessageChannel);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.911 -0500", hash_original_method = "357F90D56DF658376E8E30660A48F527", hash_generated_method = "49C43853E7AA59BB4833394590865264")
    
public synchronized MessageChannel createMessageChannel(HostPort targetHostPort)
            throws IOException {
        String key = MessageChannel.getKey(targetHostPort, "TCP");
        if (tcpMessageChannels.get(key) != null) {
            return (TCPMessageChannel) this.tcpMessageChannels.get(key);
        } else {
            TCPMessageChannel retval = new TCPMessageChannel(targetHostPort.getInetAddress(),
                    targetHostPort.getPort(), sipStack, this);
            this.tcpMessageChannels.put(key, retval);
            retval.isCached = true;
            if (sipStack.isLoggingEnabled()) {
                sipStack.getStackLogger().logDebug("key " + key);
                sipStack.getStackLogger().logDebug("Creating " + retval);
            }
            return retval;
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.914 -0500", hash_original_method = "A1867B08C1B2C4003FD16CE7D97D4BE3", hash_generated_method = "294E9958873093E2C8DCBC888D67E184")
    
protected synchronized void cacheMessageChannel(TCPMessageChannel messageChannel) {
        String key = messageChannel.getKey();
        TCPMessageChannel currentChannel = (TCPMessageChannel) tcpMessageChannels.get(key);
        if (currentChannel != null) {
            if (sipStack.isLoggingEnabled())
                sipStack.getStackLogger().logDebug("Closing " + key);
            currentChannel.close();
        }
        if (sipStack.isLoggingEnabled())
            sipStack.getStackLogger().logDebug("Caching " + key);
        this.tcpMessageChannels.put(key, messageChannel);

    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.917 -0500", hash_original_method = "C7BFFB891EADFA809295B1E355E1D388", hash_generated_method = "89CB28300D5ACD61145C88B90F3B6E10")
    
public synchronized MessageChannel createMessageChannel(InetAddress host, int port)
            throws IOException {
        try {
            String key = MessageChannel.getKey(host, port, "TCP");
            if (tcpMessageChannels.get(key) != null) {
                return (TCPMessageChannel) this.tcpMessageChannels.get(key);
            } else {
                TCPMessageChannel retval = new TCPMessageChannel(host, port, sipStack, this);
                this.tcpMessageChannels.put(key, retval);
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
     * TCP can handle an unlimited number of bytes.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.920 -0500", hash_original_method = "248B80D43EBE2633D052A5A2C5B180CB", hash_generated_method = "CA9A4BABAD31A74E1D32220278B56EB2")
    
public int getMaximumMessageSize() {
        return Integer.MAX_VALUE;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.923 -0500", hash_original_method = "C4E752535BCB329601986DF8A32049BD", hash_generated_method = "B4CA0ABE6335781D018588C30F03B3CA")
    
public boolean inUse() {
        return this.useCount != 0;
    }

    /**
     * Default target port for TCP
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.925 -0500", hash_original_method = "549BD73BE1E8477C39668DF3AD0A0CF5", hash_generated_method = "A974BC08491FBE134376CBCCEE27369D")
    
public int getDefaultTargetPort() {
        return 5060;
    }

    /**
     * TCP is not a secure protocol.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:27.928 -0500", hash_original_method = "51201694E0EE76265BF39848EF10BE9C", hash_generated_method = "49E6B3D175AEB85C0CC035D6E473FA9A")
    
public boolean isSecure() {
        return false;
    }
    
}

