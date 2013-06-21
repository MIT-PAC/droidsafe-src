package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.StackLogger;
import gov.nist.javax.sip.SipStackImpl;
import java.io.*;
import java.net.*;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSocket;

class IOHandler {
    private Semaphore ioSemaphore = new Semaphore(1);
    private SipStackImpl sipStack;
    private ConcurrentHashMap<String, Socket> socketTable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.844 -0400", hash_original_method = "9386B11A19881B80900AAECD631287FD", hash_generated_method = "33DB924DCC7C594FE5C6B161DB956B5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected IOHandler(SIPTransactionStack sipStack) {
        dsTaint.addTaint(sipStack.dsTaint);
        this.sipStack = (SipStackImpl) sipStack;
        this.socketTable = new ConcurrentHashMap<String, Socket>();
        // ---------- Original Method ----------
        //this.sipStack = (SipStackImpl) sipStack;
        //this.socketTable = new ConcurrentHashMap<String, Socket>();
    }

    
        protected static String makeKey(InetAddress addr, int port) {
        return addr.getHostAddress() + ":" + port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.845 -0400", hash_original_method = "C27932DA9A29AAAE15A518DF16F6A526", hash_generated_method = "B33EAE09D2969A98E63480E91DFAA40C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void putSocket(String key, Socket sock) {
        dsTaint.addTaint(sock.dsTaint);
        dsTaint.addTaint(key);
        socketTable.put(key, sock);
        // ---------- Original Method ----------
        //socketTable.put(key, sock);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.845 -0400", hash_original_method = "89115ADF83703D7A5E1F215A0319659A", hash_generated_method = "4B6F37EFAA4A00D6F45D3DFBA466D9E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Socket getSocket(String key) {
        dsTaint.addTaint(key);
        Socket varEE318964A5ABA3DD86D7AEF4F9CFFC24_1840531862 = ((Socket) socketTable.get(key));
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (Socket) socketTable.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.845 -0400", hash_original_method = "92816C2E9E6D943B13D719E81BC3AA88", hash_generated_method = "15CDBC878C7F3B0425F9AFDB0FCE2C83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void removeSocket(String key) {
        dsTaint.addTaint(key);
        socketTable.remove(key);
        // ---------- Original Method ----------
        //socketTable.remove(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.845 -0400", hash_original_method = "F53BBC08C4AFCA76781E5C2EA0968907", hash_generated_method = "3FF0BC200714AB07493CA14629565938")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeChunks(OutputStream outputStream, byte[] bytes, int length) throws IOException {
        dsTaint.addTaint(bytes[0]);
        dsTaint.addTaint(outputStream.dsTaint);
        dsTaint.addTaint(length);
        {
            int chunksize;
            chunksize = 8 * 1024;
            {
                int p;
                p = 0;
                p += chunksize;
                {
                    int chunk;
                    chunk = chunksize;
                    chunk = length - p;
                    outputStream.write(bytes, p, chunk);
                } //End block
            } //End collapsed parenthetic
        } //End block
        outputStream.flush();
        // ---------- Original Method ----------
        //synchronized (outputStream) {
            //int chunksize = 8 * 1024;
            //for (int p = 0; p < length; p += chunksize) {
                //int chunk = p + chunksize < length ? chunksize : length - p;
                //outputStream.write(bytes, p, chunk);
            //}
        //}
        //outputStream.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.846 -0400", hash_original_method = "175D748D3B44D56B75F881FF6379A368", hash_generated_method = "F37C2B276DD58A944B72B82DB10C3E64")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketAddress obtainLocalAddress(InetAddress dst, int dstPort,
            InetAddress localAddress, int localPort) throws IOException {
        dsTaint.addTaint(localAddress.dsTaint);
        dsTaint.addTaint(dstPort);
        dsTaint.addTaint(localPort);
        dsTaint.addTaint(dst.dsTaint);
        String key;
        key = makeKey(dst, dstPort);
        Socket clientSock;
        clientSock = getSocket(key);
        {
            clientSock = sipStack.getNetworkLayer().createSocket(dst, dstPort, localAddress,
                    localPort);
            putSocket(key, clientSock);
        } //End block
        SocketAddress varE86E9679D247005D0B3C9E3910C683E2_873789086 = (clientSock.getLocalSocketAddress());
        return (SocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //String key = makeKey(dst, dstPort);
        //Socket clientSock = getSocket(key);
        //if (clientSock == null) {
            //clientSock = sipStack.getNetworkLayer().createSocket(dst, dstPort, localAddress,
                    //localPort);
            //putSocket(key, clientSock);
        //}
        //return clientSock.getLocalSocketAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.847 -0400", hash_original_method = "4FFA41D6F7F1FFB50CF7951492094FCE", hash_generated_method = "A9357FA50574D40DA7EB30188E2C3E40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Socket sendBytes(InetAddress senderAddress, InetAddress receiverAddress,
            int contactPort, String transport, byte[] bytes, boolean retry,
            MessageChannel messageChannel) throws IOException {
        dsTaint.addTaint(senderAddress.dsTaint);
        dsTaint.addTaint(bytes[0]);
        dsTaint.addTaint(transport);
        dsTaint.addTaint(messageChannel.dsTaint);
        dsTaint.addTaint(contactPort);
        dsTaint.addTaint(retry);
        dsTaint.addTaint(receiverAddress.dsTaint);
        int retry_count;
        retry_count = 0;
        int max_retry;
        max_retry = 2;
        max_retry = 1;
        int length;
        length = bytes.length;
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1361601411 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "sendBytes " + transport + " inAddr " + receiverAddress.getHostAddress()
                            + " port = " + contactPort + " length = " + length);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var1A97FA1C52344C6F82991A70F7F16D9A_2025287250 = (sipStack.isLoggingEnabled() && sipStack.isLogStackTraceOnMessageSend());
            {
                sipStack.getStackLogger().logStackTrace(StackLogger.TRACE_INFO);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varF32ED8CDFEFB2594AE29580FE7D2C53B_2114387368 = (transport.compareToIgnoreCase(TCP) == 0);
            {
                String key;
                key = makeKey(receiverAddress, contactPort);
                try 
                {
                    boolean retval;
                    retval = this.ioSemaphore.tryAcquire(10000, TimeUnit.MILLISECONDS);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IOException(
                            "Could not acquire IO Semaphore after 10 seconds -- giving up ");
                    } //End block
                } //End block
                catch (InterruptedException ex)
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("exception in acquiring sem");
                } //End block
                Socket clientSock;
                clientSock = getSocket(key);
                try 
                {
                    {
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1224190985 = (sipStack.isLoggingEnabled());
                                {
                                    sipStack.getStackLogger().logDebug("inaddr = " + receiverAddress);
                                    sipStack.getStackLogger().logDebug("port = " + contactPort);
                                } //End block
                            } //End collapsed parenthetic
                            clientSock = sipStack.getNetworkLayer().createSocket(receiverAddress,
                                contactPort, senderAddress);
                            OutputStream outputStream;
                            outputStream = clientSock.getOutputStream();
                            writeChunks(outputStream, bytes, length);
                            putSocket(key, clientSock);
                        } //End block
                        {
                            try 
                            {
                                OutputStream outputStream;
                                outputStream = clientSock.getOutputStream();
                                writeChunks(outputStream, bytes, length);
                            } //End block
                            catch (IOException ex)
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_292155626 = (sipStack.isLoggingEnabled());
                                    sipStack.getStackLogger().logDebug(
                                        "IOException occured retryCount " + retry_count);
                                } //End collapsed parenthetic
                                removeSocket(key);
                                try 
                                {
                                    clientSock.close();
                                } //End block
                                catch (Exception e)
                                { }
                                clientSock = null;
                            } //End block
                        } //End block
                    } //End block
                } //End block
                finally 
                {
                    ioSemaphore.release();
                } //End block
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1489166045 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logDebug(this.socketTable.toString());
                            sipStack.getStackLogger().logError(
                            "Could not connect to " + receiverAddress + ":" + contactPort);
                        } //End block
                    } //End collapsed parenthetic
                    if (DroidSafeAndroidRuntime.control) throw new IOException("Could not connect to " + receiverAddress + ":"
                        + contactPort);
                } //End block
            } //End block
            {
                boolean varBFE8E44C254EF553DDC47360C83E9B95_839514205 = (transport.compareToIgnoreCase(TLS) == 0);
                {
                    String key;
                    key = makeKey(receiverAddress, contactPort);
                    try 
                    {
                        boolean retval;
                        retval = this.ioSemaphore.tryAcquire(10000, TimeUnit.MILLISECONDS);
                        if (DroidSafeAndroidRuntime.control) throw new IOException("Timeout acquiring IO SEM");
                    } //End block
                    catch (InterruptedException ex)
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IOException("exception in acquiring sem");
                    } //End block
                    Socket clientSock;
                    clientSock = getSocket(key);
                    try 
                    {
                        {
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_1884921952 = (sipStack.isLoggingEnabled());
                                    {
                                        sipStack.getStackLogger().logDebug("inaddr = " + receiverAddress);
                                        sipStack.getStackLogger().logDebug("port = " + contactPort);
                                    } //End block
                                } //End collapsed parenthetic
                                clientSock = sipStack.getNetworkLayer().createSSLSocket(receiverAddress,
                                contactPort, senderAddress);
                                SSLSocket sslsock;
                                sslsock = (SSLSocket) clientSock;
                                HandshakeCompletedListener listner;
                                listner = new HandshakeCompletedListenerImpl(
                                (TLSMessageChannel) messageChannel);
                                ((TLSMessageChannel) messageChannel)
                                .setHandshakeCompletedListener(listner);
                                sslsock.addHandshakeCompletedListener(listner);
                                sslsock.setEnabledProtocols(sipStack.getEnabledProtocols());
                                sslsock.startHandshake();
                                OutputStream outputStream;
                                outputStream = clientSock.getOutputStream();
                                writeChunks(outputStream, bytes, length);
                                putSocket(key, clientSock);
                            } //End block
                            {
                                try 
                                {
                                    OutputStream outputStream;
                                    outputStream = clientSock.getOutputStream();
                                    writeChunks(outputStream, bytes, length);
                                } //End block
                                catch (IOException ex)
                                {
                                    {
                                        boolean var6FE8ACC5352DCA3449210F8EDED912B3_1059844096 = (sipStack.isLoggingEnabled());
                                        sipStack.getStackLogger().logException(ex);
                                    } //End collapsed parenthetic
                                    removeSocket(key);
                                    try 
                                    {
                                        clientSock.close();
                                    } //End block
                                    catch (Exception e)
                                    { }
                                    clientSock = null;
                                } //End block
                            } //End block
                        } //End block
                    } //End block
                    finally 
                    {
                        ioSemaphore.release();
                    } //End block
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IOException("Could not connect to " + receiverAddress + ":"
                        + contactPort);
                    } //End block
                } //End block
                {
                    DatagramSocket datagramSock;
                    datagramSock = sipStack.getNetworkLayer().createDatagramSocket();
                    datagramSock.connect(receiverAddress, contactPort);
                    DatagramPacket dgPacket;
                    dgPacket = new DatagramPacket(bytes, 0, length, receiverAddress,
                    contactPort);
                    datagramSock.send(dgPacket);
                    datagramSock.close();
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.848 -0400", hash_original_method = "1D520544B315CDC75D81B88E4BB64341", hash_generated_method = "C7E0D2603D7020C5C487BD92986BC04F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void closeAll() {
        {
            Enumeration<Socket> values;
            values = socketTable.elements();
            boolean var2E328B5AFAF57F06673F2C1E812A4A2B_1903246994 = (values.hasMoreElements());
            {
                Socket s;
                s = (Socket) values.nextElement();
                try 
                {
                    s.close();
                } //End block
                catch (IOException ex)
                { }
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (Enumeration<Socket> values = socketTable.elements(); values.hasMoreElements();) {
            //Socket s = (Socket) values.nextElement();
            //try {
                //s.close();
            //} catch (IOException ex) {
            //}
        //}
    }

    
    private static String TCP = "tcp";
    private static String TLS = "tls";
}

