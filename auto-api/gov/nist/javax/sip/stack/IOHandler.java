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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.884 -0400", hash_original_field = "86B49D1C8FD26DA78BB808FB5DDCB721", hash_generated_field = "7C78FF5476489511BDB7D6F9C761D492")

    private Semaphore ioSemaphore = new Semaphore(1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.884 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "B028268F85C87F49A0E45B93954BF938")

    private SipStackImpl sipStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.884 -0400", hash_original_field = "8BF3F4CDEE0036CE044C3EC8062F4B25", hash_generated_field = "B68F58F2C322702141148CA8E78DA8DE")

    private ConcurrentHashMap<String, Socket> socketTable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.884 -0400", hash_original_method = "9386B11A19881B80900AAECD631287FD", hash_generated_method = "30C5DFDA3ACE98208A6E4D447958B5B9")
    protected  IOHandler(SIPTransactionStack sipStack) {
        this.sipStack = (SipStackImpl) sipStack;
        this.socketTable = new ConcurrentHashMap<String, Socket>();
        // ---------- Original Method ----------
        //this.sipStack = (SipStackImpl) sipStack;
        //this.socketTable = new ConcurrentHashMap<String, Socket>();
    }

    
        protected static String makeKey(InetAddress addr, int port) {
        return addr.getHostAddress() + ":" + port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.885 -0400", hash_original_method = "C27932DA9A29AAAE15A518DF16F6A526", hash_generated_method = "E9F9D5C006349CBC8EC968B317A469BC")
    protected void putSocket(String key, Socket sock) {
        socketTable.put(key, sock);
        addTaint(key.getTaint());
        addTaint(sock.getTaint());
        // ---------- Original Method ----------
        //socketTable.put(key, sock);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.885 -0400", hash_original_method = "89115ADF83703D7A5E1F215A0319659A", hash_generated_method = "4A203859FCE0E89E380162B3EC6189D9")
    protected Socket getSocket(String key) {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1970760607 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1970760607 = (Socket) socketTable.get(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1970760607.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1970760607;
        // ---------- Original Method ----------
        //return (Socket) socketTable.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.886 -0400", hash_original_method = "92816C2E9E6D943B13D719E81BC3AA88", hash_generated_method = "C7765CA3E4D3F9731E15ED57EE0F3B45")
    protected void removeSocket(String key) {
        socketTable.remove(key);
        addTaint(key.getTaint());
        // ---------- Original Method ----------
        //socketTable.remove(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.889 -0400", hash_original_method = "F53BBC08C4AFCA76781E5C2EA0968907", hash_generated_method = "7F1BB1BC126C85A98213CD7E0808B26A")
    private void writeChunks(OutputStream outputStream, byte[] bytes, int length) throws IOException {
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
        addTaint(outputStream.getTaint());
        addTaint(bytes[0]);
        addTaint(length);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.891 -0400", hash_original_method = "175D748D3B44D56B75F881FF6379A368", hash_generated_method = "E9C05A6232B54C0A85EC5D0EF1D65466")
    public SocketAddress obtainLocalAddress(InetAddress dst, int dstPort,
            InetAddress localAddress, int localPort) throws IOException {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_1087790792 = null; //Variable for return #1
        String key;
        key = makeKey(dst, dstPort);
        Socket clientSock;
        clientSock = getSocket(key);
        {
            clientSock = sipStack.getNetworkLayer().createSocket(dst, dstPort, localAddress,
                    localPort);
            putSocket(key, clientSock);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1087790792 = clientSock.getLocalSocketAddress();
        addTaint(dst.getTaint());
        addTaint(dstPort);
        addTaint(localAddress.getTaint());
        addTaint(localPort);
        varB4EAC82CA7396A68D541C85D26508E83_1087790792.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1087790792;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.913 -0400", hash_original_method = "4FFA41D6F7F1FFB50CF7951492094FCE", hash_generated_method = "82D63D755763CFF389BAC6EBFB9917B9")
    public Socket sendBytes(InetAddress senderAddress, InetAddress receiverAddress,
            int contactPort, String transport, byte[] bytes, boolean retry,
            MessageChannel messageChannel) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_809326552 = null; //Variable for return #1
        Socket varB4EAC82CA7396A68D541C85D26508E83_1764244798 = null; //Variable for return #2
        Socket varB4EAC82CA7396A68D541C85D26508E83_1084298593 = null; //Variable for return #3
        int retry_count;
        retry_count = 0;
        int max_retry;
        max_retry = 2;
        max_retry = 1;
        int length;
        length = bytes.length;
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_85240148 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "sendBytes " + transport + " inAddr " + receiverAddress.getHostAddress()
                            + " port = " + contactPort + " length = " + length);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var1A97FA1C52344C6F82991A70F7F16D9A_2091333607 = (sipStack.isLoggingEnabled() && sipStack.isLogStackTraceOnMessageSend());
            {
                sipStack.getStackLogger().logStackTrace(StackLogger.TRACE_INFO);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varF32ED8CDFEFB2594AE29580FE7D2C53B_1258085152 = (transport.compareToIgnoreCase(TCP) == 0);
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
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1347095259 = (sipStack.isLoggingEnabled());
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
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_1620302662 = (sipStack.isLoggingEnabled());
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
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1699784651 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logDebug(this.socketTable.toString());
                            sipStack.getStackLogger().logError(
                            "Could not connect to " + receiverAddress + ":" + contactPort);
                        } //End block
                    } //End collapsed parenthetic
                    if (DroidSafeAndroidRuntime.control) throw new IOException("Could not connect to " + receiverAddress + ":"
                        + contactPort);
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_809326552 = clientSock;
            } //End block
            {
                boolean varBFE8E44C254EF553DDC47360C83E9B95_930868185 = (transport.compareToIgnoreCase(TLS) == 0);
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
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_1100988069 = (sipStack.isLoggingEnabled());
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
                                        boolean var6FE8ACC5352DCA3449210F8EDED912B3_176789894 = (sipStack.isLoggingEnabled());
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
                    varB4EAC82CA7396A68D541C85D26508E83_1764244798 = clientSock;
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
                    varB4EAC82CA7396A68D541C85D26508E83_1084298593 = null;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(senderAddress.getTaint());
        addTaint(receiverAddress.getTaint());
        addTaint(contactPort);
        addTaint(transport.getTaint());
        addTaint(bytes[0]);
        addTaint(retry);
        addTaint(messageChannel.getTaint());
        Socket varA7E53CE21691AB073D9660D615818899_890898582; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_890898582 = varB4EAC82CA7396A68D541C85D26508E83_809326552;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_890898582 = varB4EAC82CA7396A68D541C85D26508E83_1764244798;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_890898582 = varB4EAC82CA7396A68D541C85D26508E83_1084298593;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_890898582.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_890898582;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.922 -0400", hash_original_method = "1D520544B315CDC75D81B88E4BB64341", hash_generated_method = "260572450F1DA4C14D54F9C46653C2CF")
    public void closeAll() {
        {
            Enumeration<Socket> values;
            values = socketTable.elements();
            boolean var2E328B5AFAF57F06673F2C1E812A4A2B_1416272848 = (values.hasMoreElements());
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.922 -0400", hash_original_field = "E7E305FD91DFAD258D05CEF692A3FDA3", hash_generated_field = "2A19A36B452D88CDD5B3F26D17F7563A")

    private static String TCP = "tcp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.922 -0400", hash_original_field = "02AC7105BC9267167A7FE52691A37BAB", hash_generated_field = "1AD174C59CE89A66B72D18168F821A73")

    private static String TLS = "tls";
}

