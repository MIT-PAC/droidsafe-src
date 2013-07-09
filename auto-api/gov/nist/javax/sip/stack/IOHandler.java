package gov.nist.javax.sip.stack;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.357 -0400", hash_original_field = "86B49D1C8FD26DA78BB808FB5DDCB721", hash_generated_field = "7C78FF5476489511BDB7D6F9C761D492")

    private Semaphore ioSemaphore = new Semaphore(1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.357 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "B028268F85C87F49A0E45B93954BF938")

    private SipStackImpl sipStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.357 -0400", hash_original_field = "8BF3F4CDEE0036CE044C3EC8062F4B25", hash_generated_field = "B68F58F2C322702141148CA8E78DA8DE")

    private ConcurrentHashMap<String, Socket> socketTable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.358 -0400", hash_original_method = "9386B11A19881B80900AAECD631287FD", hash_generated_method = "30C5DFDA3ACE98208A6E4D447958B5B9")
    protected  IOHandler(SIPTransactionStack sipStack) {
        this.sipStack = (SipStackImpl) sipStack;
        this.socketTable = new ConcurrentHashMap<String, Socket>();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    protected static String makeKey(InetAddress addr, int port) {
        return addr.getHostAddress() + ":" + port;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.358 -0400", hash_original_method = "C27932DA9A29AAAE15A518DF16F6A526", hash_generated_method = "E9F9D5C006349CBC8EC968B317A469BC")
    protected void putSocket(String key, Socket sock) {
        socketTable.put(key, sock);
        addTaint(key.getTaint());
        addTaint(sock.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.358 -0400", hash_original_method = "89115ADF83703D7A5E1F215A0319659A", hash_generated_method = "E52E5A8B57D0857F2AF975AE145C2225")
    protected Socket getSocket(String key) {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1249537148 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1249537148 = (Socket) socketTable.get(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1249537148.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1249537148;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.359 -0400", hash_original_method = "92816C2E9E6D943B13D719E81BC3AA88", hash_generated_method = "C7765CA3E4D3F9731E15ED57EE0F3B45")
    protected void removeSocket(String key) {
        socketTable.remove(key);
        addTaint(key.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.359 -0400", hash_original_method = "F53BBC08C4AFCA76781E5C2EA0968907", hash_generated_method = "A99C5B97ABDF62EF659338A4B43986B4")
    private void writeChunks(OutputStream outputStream, byte[] bytes, int length) throws IOException {
        {
            int chunksize = 8 * 1024;
            {
                int p = 0;
                p += chunksize;
                {
                    int chunk;
                    chunk = chunksize;
                    chunk = length - p;
                    outputStream.write(bytes, p, chunk);
                } 
            } 
        } 
        outputStream.flush();
        addTaint(outputStream.getTaint());
        addTaint(bytes[0]);
        addTaint(length);
        
        
            
            
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.359 -0400", hash_original_method = "175D748D3B44D56B75F881FF6379A368", hash_generated_method = "B3EB1633BA3F651C316928D57CB73AEB")
    public SocketAddress obtainLocalAddress(InetAddress dst, int dstPort,
            InetAddress localAddress, int localPort) throws IOException {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_1632332282 = null; 
        String key = makeKey(dst, dstPort);
        Socket clientSock = getSocket(key);
        {
            clientSock = sipStack.getNetworkLayer().createSocket(dst, dstPort, localAddress,
                    localPort);
            putSocket(key, clientSock);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1632332282 = clientSock.getLocalSocketAddress();
        addTaint(dst.getTaint());
        addTaint(dstPort);
        addTaint(localAddress.getTaint());
        addTaint(localPort);
        varB4EAC82CA7396A68D541C85D26508E83_1632332282.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1632332282;
        
        
        
        
            
                    
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.363 -0400", hash_original_method = "4FFA41D6F7F1FFB50CF7951492094FCE", hash_generated_method = "0622EC60B4AB774B17B0BFC183B5DFBE")
    public Socket sendBytes(InetAddress senderAddress, InetAddress receiverAddress,
            int contactPort, String transport, byte[] bytes, boolean retry,
            MessageChannel messageChannel) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_491993616 = null; 
        Socket varB4EAC82CA7396A68D541C85D26508E83_1522506632 = null; 
        Socket varB4EAC82CA7396A68D541C85D26508E83_2110391742 = null; 
        int retry_count = 0;
        int max_retry;
        max_retry = 2;
        max_retry = 1;
        int length = bytes.length;
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_162565203 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "sendBytes " + transport + " inAddr " + receiverAddress.getHostAddress()
                            + " port = " + contactPort + " length = " + length);
            } 
        } 
        {
            boolean var1A97FA1C52344C6F82991A70F7F16D9A_1878394854 = (sipStack.isLoggingEnabled() && sipStack.isLogStackTraceOnMessageSend());
            {
                sipStack.getStackLogger().logStackTrace(StackLogger.TRACE_INFO);
            } 
        } 
        {
            boolean varF32ED8CDFEFB2594AE29580FE7D2C53B_2139764742 = (transport.compareToIgnoreCase(TCP) == 0);
            {
                String key = makeKey(receiverAddress, contactPort);
                try 
                {
                    boolean retval = this.ioSemaphore.tryAcquire(10000, TimeUnit.MILLISECONDS);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IOException(
                            "Could not acquire IO Semaphore after 10 seconds -- giving up ");
                    } 
                } 
                catch (InterruptedException ex)
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("exception in acquiring sem");
                } 
                Socket clientSock = getSocket(key);
                try 
                {
                    {
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1265658982 = (sipStack.isLoggingEnabled());
                                {
                                    sipStack.getStackLogger().logDebug("inaddr = " + receiverAddress);
                                    sipStack.getStackLogger().logDebug("port = " + contactPort);
                                } 
                            } 
                            clientSock = sipStack.getNetworkLayer().createSocket(receiverAddress,
                                contactPort, senderAddress);
                            OutputStream outputStream = clientSock.getOutputStream();
                            writeChunks(outputStream, bytes, length);
                            putSocket(key, clientSock);
                        } 
                        {
                            try 
                            {
                                OutputStream outputStream = clientSock.getOutputStream();
                                writeChunks(outputStream, bytes, length);
                            } 
                            catch (IOException ex)
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_663606717 = (sipStack.isLoggingEnabled());
                                    sipStack.getStackLogger().logDebug(
                                        "IOException occured retryCount " + retry_count);
                                } 
                                removeSocket(key);
                                try 
                                {
                                    clientSock.close();
                                } 
                                catch (Exception e)
                                { }
                                clientSock = null;
                            } 
                        } 
                    } 
                } 
                finally 
                {
                    ioSemaphore.release();
                } 
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1108769950 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logDebug(this.socketTable.toString());
                            sipStack.getStackLogger().logError(
                            "Could not connect to " + receiverAddress + ":" + contactPort);
                        } 
                    } 
                    if (DroidSafeAndroidRuntime.control) throw new IOException("Could not connect to " + receiverAddress + ":"
                        + contactPort);
                } 
                varB4EAC82CA7396A68D541C85D26508E83_491993616 = clientSock;
            } 
            {
                boolean varBFE8E44C254EF553DDC47360C83E9B95_1676192772 = (transport.compareToIgnoreCase(TLS) == 0);
                {
                    String key = makeKey(receiverAddress, contactPort);
                    try 
                    {
                        boolean retval = this.ioSemaphore.tryAcquire(10000, TimeUnit.MILLISECONDS);
                        if (DroidSafeAndroidRuntime.control) throw new IOException("Timeout acquiring IO SEM");
                    } 
                    catch (InterruptedException ex)
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IOException("exception in acquiring sem");
                    } 
                    Socket clientSock = getSocket(key);
                    try 
                    {
                        {
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_1632955761 = (sipStack.isLoggingEnabled());
                                    {
                                        sipStack.getStackLogger().logDebug("inaddr = " + receiverAddress);
                                        sipStack.getStackLogger().logDebug("port = " + contactPort);
                                    } 
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
                            } 
                            {
                                try 
                                {
                                    OutputStream outputStream = clientSock.getOutputStream();
                                    writeChunks(outputStream, bytes, length);
                                } 
                                catch (IOException ex)
                                {
                                    {
                                        boolean var6FE8ACC5352DCA3449210F8EDED912B3_1455775034 = (sipStack.isLoggingEnabled());
                                        sipStack.getStackLogger().logException(ex);
                                    } 
                                    removeSocket(key);
                                    try 
                                    {
                                        clientSock.close();
                                    } 
                                    catch (Exception e)
                                    { }
                                    clientSock = null;
                                } 
                            } 
                        } 
                    } 
                    finally 
                    {
                        ioSemaphore.release();
                    } 
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IOException("Could not connect to " + receiverAddress + ":"
                        + contactPort);
                    } 
                    varB4EAC82CA7396A68D541C85D26508E83_1522506632 = clientSock;
                } 
                {
                    DatagramSocket datagramSock = sipStack.getNetworkLayer().createDatagramSocket();
                    datagramSock.connect(receiverAddress, contactPort);
                    DatagramPacket dgPacket = new DatagramPacket(bytes, 0, length, receiverAddress,
                    contactPort);
                    datagramSock.send(dgPacket);
                    datagramSock.close();
                    varB4EAC82CA7396A68D541C85D26508E83_2110391742 = null;
                } 
            } 
        } 
        addTaint(senderAddress.getTaint());
        addTaint(receiverAddress.getTaint());
        addTaint(contactPort);
        addTaint(transport.getTaint());
        addTaint(bytes[0]);
        addTaint(retry);
        addTaint(messageChannel.getTaint());
        Socket varA7E53CE21691AB073D9660D615818899_144025443; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_144025443 = varB4EAC82CA7396A68D541C85D26508E83_491993616;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_144025443 = varB4EAC82CA7396A68D541C85D26508E83_1522506632;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_144025443 = varB4EAC82CA7396A68D541C85D26508E83_2110391742;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_144025443.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_144025443;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.364 -0400", hash_original_method = "1D520544B315CDC75D81B88E4BB64341", hash_generated_method = "C44CA4D2E7BF039CFA0DA91C231B79EE")
    public void closeAll() {
        {
            Enumeration<Socket> values = socketTable.elements();
            boolean var2E328B5AFAF57F06673F2C1E812A4A2B_80101872 = (values.hasMoreElements());
            {
                Socket s = (Socket) values.nextElement();
                try 
                {
                    s.close();
                } 
                catch (IOException ex)
                { }
            } 
        } 
        
        
            
            
                
            
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.364 -0400", hash_original_field = "E7E305FD91DFAD258D05CEF692A3FDA3", hash_generated_field = "2A19A36B452D88CDD5B3F26D17F7563A")

    private static String TCP = "tcp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.364 -0400", hash_original_field = "02AC7105BC9267167A7FE52691A37BAB", hash_generated_field = "1AD174C59CE89A66B72D18168F821A73")

    private static String TLS = "tls";
}

