package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.StackLogger;
import gov.nist.javax.sip.SipStackImpl;

import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSocket;

class IOHandler {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.051 -0500", hash_original_method = "4B1CA4C3CA931CD3E3AFB484B6B8381F", hash_generated_method = "88A9B49895794BEEF7CE060C07F9E314")
    
protected static String makeKey(InetAddress addr, int port) {
        return addr.getHostAddress() + ":" + port;

    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.042 -0500", hash_original_field = "68703AB10816D405D1396AB032A64065", hash_generated_field = "2A19A36B452D88CDD5B3F26D17F7563A")

    private static String TCP = "tcp";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.045 -0500", hash_original_field = "5B35D8051830BFBA2689666E17D62408", hash_generated_field = "1AD174C59CE89A66B72D18168F821A73")

    private static String TLS = "tls";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.036 -0500", hash_original_field = "9D08B66A2720241C8C7031CEECD4BB7E", hash_generated_field = "7C78FF5476489511BDB7D6F9C761D492")

    private Semaphore ioSemaphore = new Semaphore(1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.039 -0500", hash_original_field = "03821C4D777C0A4AB8577E0C5F2371D6", hash_generated_field = "B028268F85C87F49A0E45B93954BF938")

    private SipStackImpl sipStack;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.048 -0500", hash_original_field = "016E5301717F28BDAE1198DDAD121AC8", hash_generated_field = "109FC548DB903A00E753C207C6D25B9B")

    // sending tcp messages.
    private ConcurrentHashMap<String, Socket> socketTable;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.054 -0500", hash_original_method = "9386B11A19881B80900AAECD631287FD", hash_generated_method = "A54ED3EED49DCB200EE2FFA1183108CB")
    
protected IOHandler(SIPTransactionStack sipStack) {
        this.sipStack = (SipStackImpl) sipStack;
        this.socketTable = new ConcurrentHashMap<String, Socket>();

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.057 -0500", hash_original_method = "C27932DA9A29AAAE15A518DF16F6A526", hash_generated_method = "CBA62305F873B952EADFD55881A64CBD")
    
protected void putSocket(String key, Socket sock) {
        socketTable.put(key, sock);

    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.059 -0500", hash_original_method = "89115ADF83703D7A5E1F215A0319659A", hash_generated_method = "263EA2C66CEBA537DDB2AB15A23D13F5")
    
protected Socket getSocket(String key) {
        return (Socket) socketTable.get(key);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.063 -0500", hash_original_method = "92816C2E9E6D943B13D719E81BC3AA88", hash_generated_method = "514B5D2733335CA9417491AF648674E1")
    
protected void removeSocket(String key) {
        socketTable.remove(key);
    }

    /**
     * A private function to write things out. This needs to be synchronized as writes can occur
     * from multiple threads. We write in chunks to allow the other side to synchronize for large
     * sized writes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.066 -0500", hash_original_method = "F53BBC08C4AFCA76781E5C2EA0968907", hash_generated_method = "1470972030CEE1CDA08B198406DF9EBA")
    
private void writeChunks(OutputStream outputStream, byte[] bytes, int length)
            throws IOException {
        // Chunk size is 16K - this hack is for large
        // writes over slow connections.
        synchronized (outputStream) {
            // outputStream.write(bytes,0,length);
            int chunksize = 8 * 1024;
            for (int p = 0; p < length; p += chunksize) {
                int chunk = p + chunksize < length ? chunksize : length - p;
                outputStream.write(bytes, p, chunk);
            }
        }
        outputStream.flush();
    }

    /**
     * Creates and binds, if necessary, a socket connected to the specified destination address
     * and port and then returns its local address.
     * 
     * @param dst the destination address that the socket would need to connect to.
     * @param dstPort the port number that the connection would be established with.
     * @param localAddress the address that we would like to bind on (null for the "any" address).
     * @param localPort the port that we'd like our socket to bind to (0 for a random port).
     * 
     * @return the SocketAddress that this handler would use when connecting to the specified
     *         destination address and port.
     * 
     * @throws IOException
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.069 -0500", hash_original_method = "175D748D3B44D56B75F881FF6379A368", hash_generated_method = "0662F4A3A7CAF843B9C43E85E8EEC9A3")
    
public SocketAddress obtainLocalAddress(InetAddress dst, int dstPort,
            InetAddress localAddress, int localPort) throws IOException {
        String key = makeKey(dst, dstPort);

        Socket clientSock = getSocket(key);

        if (clientSock == null) {
            clientSock = sipStack.getNetworkLayer().createSocket(dst, dstPort, localAddress,
                    localPort);
            putSocket(key, clientSock);
        }

        return clientSock.getLocalSocketAddress();

    }

    /**
     * Send an array of bytes.
     * 
     * @param receiverAddress -- inet address
     * @param contactPort -- port to connect to.
     * @param transport -- tcp or udp.
     * @param retry -- retry to connect if the other end closed connection
     * @throws IOException -- if there is an IO exception sending message.
     */

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.074 -0500", hash_original_method = "4FFA41D6F7F1FFB50CF7951492094FCE", hash_generated_method = "CE65233D6945B45F5217A055FCCED981")
    
public Socket sendBytes(InetAddress senderAddress, InetAddress receiverAddress,
            int contactPort, String transport, byte[] bytes, boolean retry,
            MessageChannel messageChannel) throws IOException {
        int retry_count = 0;
        int max_retry = retry ? 2 : 1;
        // Server uses TCP transport. TCP client sockets are cached
        int length = bytes.length;
        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug(
                    "sendBytes " + transport + " inAddr " + receiverAddress.getHostAddress()
                            + " port = " + contactPort + " length = " + length);
        }
        if (sipStack.isLoggingEnabled() && sipStack.isLogStackTraceOnMessageSend()) {
            sipStack.getStackLogger().logStackTrace(StackLogger.TRACE_INFO);
        }
        if (transport.compareToIgnoreCase(TCP) == 0) {
            String key = makeKey(receiverAddress, contactPort);
            // This should be in a synchronized block ( reported by
            // Jayashenkhar ( lucent ).

            try {
                boolean retval = this.ioSemaphore.tryAcquire(10000, TimeUnit.MILLISECONDS); 
                if (!retval) {
                    throw new IOException(
                            "Could not acquire IO Semaphore after 10 seconds -- giving up ");
                }
            } catch (InterruptedException ex) {
                throw new IOException("exception in acquiring sem");
            }
            Socket clientSock = getSocket(key);

            try {

                while (retry_count < max_retry) {
                    if (clientSock == null) {
                        if (sipStack.isLoggingEnabled()) {
                            sipStack.getStackLogger().logDebug("inaddr = " + receiverAddress);
                            sipStack.getStackLogger().logDebug("port = " + contactPort);
                        }
                        // note that the IP Address for stack may not be
                        // assigned.
                        // sender address is the address of the listening point.
                        // in version 1.1 all listening points have the same IP
                        // address (i.e. that of the stack). In version 1.2
                        // the IP address is on a per listening point basis.
                        clientSock = sipStack.getNetworkLayer().createSocket(receiverAddress,
                                contactPort, senderAddress);
                        OutputStream outputStream = clientSock.getOutputStream();
                        writeChunks(outputStream, bytes, length);
                        putSocket(key, clientSock);
                        break;
                    } else {
                        try {
                            OutputStream outputStream = clientSock.getOutputStream();
                            writeChunks(outputStream, bytes, length);
                            break;
                        } catch (IOException ex) {
                            if (sipStack.isLoggingEnabled())
                                sipStack.getStackLogger().logDebug(
                                        "IOException occured retryCount " + retry_count);
                            // old connection is bad.
                            // remove from our table.
                            removeSocket(key);
                            try {
                                clientSock.close();
                            } catch (Exception e) {
                            }
                            clientSock = null;
                            retry_count++;
                        }
                    }
                }
            } finally {
                ioSemaphore.release();
            }

            if (clientSock == null) {

                if (sipStack.isLoggingEnabled()) {
                    sipStack.getStackLogger().logDebug(this.socketTable.toString());
                    sipStack.getStackLogger().logError(
                            "Could not connect to " + receiverAddress + ":" + contactPort);
                }

                throw new IOException("Could not connect to " + receiverAddress + ":"
                        + contactPort);
            } else
                return clientSock;

            // Added by Daniel J. Martinez Manzano <dani@dif.um.es>
            // Copied and modified from the former section for TCP
        } else if (transport.compareToIgnoreCase(TLS) == 0) {
            String key = makeKey(receiverAddress, contactPort);
            try {
                boolean retval = this.ioSemaphore.tryAcquire(10000, TimeUnit.MILLISECONDS);
                if (!retval)
                    throw new IOException("Timeout acquiring IO SEM");
            } catch (InterruptedException ex) {
                throw new IOException("exception in acquiring sem");
            }
            Socket clientSock = getSocket(key);

            try {
                while (retry_count < max_retry) {
                    if (clientSock == null) {
                        if (sipStack.isLoggingEnabled()) {
                            sipStack.getStackLogger().logDebug("inaddr = " + receiverAddress);
                            sipStack.getStackLogger().logDebug("port = " + contactPort);
                        }

                        clientSock = sipStack.getNetworkLayer().createSSLSocket(receiverAddress,
                                contactPort, senderAddress);
                        SSLSocket sslsock = (SSLSocket) clientSock;
                        HandshakeCompletedListener listner = new HandshakeCompletedListenerImpl(
                                (TLSMessageChannel) messageChannel);
                        ((TLSMessageChannel) messageChannel)
                                .setHandshakeCompletedListener(listner);
                        sslsock.addHandshakeCompletedListener(listner);
                        sslsock.setEnabledProtocols(sipStack.getEnabledProtocols());
                        sslsock.startHandshake();

                        OutputStream outputStream = clientSock.getOutputStream();
                        writeChunks(outputStream, bytes, length);
                        putSocket(key, clientSock);
                        break;
                    } else {
                        try {
                            OutputStream outputStream = clientSock.getOutputStream();
                            writeChunks(outputStream, bytes, length);
                            break;
                        } catch (IOException ex) {
                            if (sipStack.isLoggingEnabled())
                                sipStack.getStackLogger().logException(ex);
                            // old connection is bad.
                            // remove from our table.
                            removeSocket(key);
                            try {
                                clientSock.close();
                            } catch (Exception e) {
                            }
                            clientSock = null;
                            retry_count++;
                        }
                    }
                }
            } finally {
                ioSemaphore.release();
            }
            if (clientSock == null) {
                throw new IOException("Could not connect to " + receiverAddress + ":"
                        + contactPort);
            } else
                return clientSock;

        } else {
            // This is a UDP transport...
            DatagramSocket datagramSock = sipStack.getNetworkLayer().createDatagramSocket();
            datagramSock.connect(receiverAddress, contactPort);
            DatagramPacket dgPacket = new DatagramPacket(bytes, 0, length, receiverAddress,
                    contactPort);
            datagramSock.send(dgPacket);
            datagramSock.close();
            return null;
        }

    }

    /**
     * Close all the cached connections.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:16.077 -0500", hash_original_method = "1D520544B315CDC75D81B88E4BB64341", hash_generated_method = "60A75AFC705A685BCC44264D1862E84A")
    
public void closeAll() {
        for (Enumeration<Socket> values = socketTable.elements(); values.hasMoreElements();) {
            Socket s = (Socket) values.nextElement();
            try {
                s.close();
            } catch (IOException ex) {
            }
        }

    }
}

