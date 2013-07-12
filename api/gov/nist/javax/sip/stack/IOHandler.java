package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.498 -0400", hash_original_field = "86B49D1C8FD26DA78BB808FB5DDCB721", hash_generated_field = "7C78FF5476489511BDB7D6F9C761D492")

    private Semaphore ioSemaphore = new Semaphore(1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.498 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "B028268F85C87F49A0E45B93954BF938")

    private SipStackImpl sipStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.498 -0400", hash_original_field = "8BF3F4CDEE0036CE044C3EC8062F4B25", hash_generated_field = "B68F58F2C322702141148CA8E78DA8DE")

    private ConcurrentHashMap<String, Socket> socketTable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.500 -0400", hash_original_method = "9386B11A19881B80900AAECD631287FD", hash_generated_method = "30C5DFDA3ACE98208A6E4D447958B5B9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.501 -0400", hash_original_method = "C27932DA9A29AAAE15A518DF16F6A526", hash_generated_method = "E68C363F6D49FA8E4C6F973D09518EB5")
    protected void putSocket(String key, Socket sock) {
        addTaint(sock.getTaint());
        addTaint(key.getTaint());
        socketTable.put(key, sock);
        // ---------- Original Method ----------
        //socketTable.put(key, sock);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.501 -0400", hash_original_method = "89115ADF83703D7A5E1F215A0319659A", hash_generated_method = "F0AB9D8B6CDFD6571B0D2E20B2EE540F")
    protected Socket getSocket(String key) {
        addTaint(key.getTaint());
Socket var1C4C10334B791AF9AB0467C72691123D_1038535706 =         (Socket) socketTable.get(key);
        var1C4C10334B791AF9AB0467C72691123D_1038535706.addTaint(taint);
        return var1C4C10334B791AF9AB0467C72691123D_1038535706;
        // ---------- Original Method ----------
        //return (Socket) socketTable.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.501 -0400", hash_original_method = "92816C2E9E6D943B13D719E81BC3AA88", hash_generated_method = "1EDBA6242590D8BA552C0B2ECEF726A0")
    protected void removeSocket(String key) {
        addTaint(key.getTaint());
        socketTable.remove(key);
        // ---------- Original Method ----------
        //socketTable.remove(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.502 -0400", hash_original_method = "F53BBC08C4AFCA76781E5C2EA0968907", hash_generated_method = "559A94D296D5862D53A7A9BE92844E9A")
    private void writeChunks(OutputStream outputStream, byte[] bytes, int length) throws IOException {
        addTaint(length);
        addTaint(bytes[0]);
        addTaint(outputStream.getTaint());
        synchronized
(outputStream)        {
            int chunksize = 8 * 1024;
for(int p = 0;p < length;p += chunksize)
            {
                int chunk = p + chunksize < length ? chunksize : length - p;
                outputStream.write(bytes, p, chunk);
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.503 -0400", hash_original_method = "175D748D3B44D56B75F881FF6379A368", hash_generated_method = "CDF49C6AD54CAFCC64A6A7428E48499F")
    public SocketAddress obtainLocalAddress(InetAddress dst, int dstPort,
            InetAddress localAddress, int localPort) throws IOException {
        addTaint(localPort);
        addTaint(localAddress.getTaint());
        addTaint(dstPort);
        addTaint(dst.getTaint());
        String key = makeKey(dst, dstPort);
        Socket clientSock = getSocket(key);
    if(clientSock == null)        
        {
            clientSock = sipStack.getNetworkLayer().createSocket(dst, dstPort, localAddress,
                    localPort);
            putSocket(key, clientSock);
        } //End block
SocketAddress var70ADFD022F13ED9D3F6C14787284317D_105508478 =         clientSock.getLocalSocketAddress();
        var70ADFD022F13ED9D3F6C14787284317D_105508478.addTaint(taint);
        return var70ADFD022F13ED9D3F6C14787284317D_105508478;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.507 -0400", hash_original_method = "4FFA41D6F7F1FFB50CF7951492094FCE", hash_generated_method = "5D76C975E9B6EB434B12A44535463D8C")
    public Socket sendBytes(InetAddress senderAddress, InetAddress receiverAddress,
            int contactPort, String transport, byte[] bytes, boolean retry,
            MessageChannel messageChannel) throws IOException {
        addTaint(messageChannel.getTaint());
        addTaint(retry);
        addTaint(bytes[0]);
        addTaint(transport.getTaint());
        addTaint(contactPort);
        addTaint(receiverAddress.getTaint());
        addTaint(senderAddress.getTaint());
        int retry_count = 0;
        int max_retry = retry ? 2 : 1;
        int length = bytes.length;
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug(
                    "sendBytes " + transport + " inAddr " + receiverAddress.getHostAddress()
                            + " port = " + contactPort + " length = " + length);
        } //End block
    if(sipStack.isLoggingEnabled() && sipStack.isLogStackTraceOnMessageSend())        
        {
            sipStack.getStackLogger().logStackTrace(StackLogger.TRACE_INFO);
        } //End block
    if(transport.compareToIgnoreCase(TCP) == 0)        
        {
            String key = makeKey(receiverAddress, contactPort);
            try 
            {
                boolean retval = this.ioSemaphore.tryAcquire(10000, TimeUnit.MILLISECONDS);
    if(!retval)                
                {
                    IOException var2DD6CC0C3A6B1EFCF909AF4AEED83567_1993339861 = new IOException(
                            "Could not acquire IO Semaphore after 10 seconds -- giving up ");
                    var2DD6CC0C3A6B1EFCF909AF4AEED83567_1993339861.addTaint(taint);
                    throw var2DD6CC0C3A6B1EFCF909AF4AEED83567_1993339861;
                } //End block
            } //End block
            catch (InterruptedException ex)
            {
                IOException varABD98BB3731DB97FC3481A2F15C0E069_1189187285 = new IOException("exception in acquiring sem");
                varABD98BB3731DB97FC3481A2F15C0E069_1189187285.addTaint(taint);
                throw varABD98BB3731DB97FC3481A2F15C0E069_1189187285;
            } //End block
            Socket clientSock = getSocket(key);
            try 
            {
                while
(retry_count < max_retry)                
                {
    if(clientSock == null)                    
                    {
    if(sipStack.isLoggingEnabled())                        
                        {
                            sipStack.getStackLogger().logDebug("inaddr = " + receiverAddress);
                            sipStack.getStackLogger().logDebug("port = " + contactPort);
                        } //End block
                        clientSock = sipStack.getNetworkLayer().createSocket(receiverAddress,
                                contactPort, senderAddress);
                        OutputStream outputStream = clientSock.getOutputStream();
                        writeChunks(outputStream, bytes, length);
                        putSocket(key, clientSock);
                        break;
                    } //End block
                    else
                    {
                        try 
                        {
                            OutputStream outputStream = clientSock.getOutputStream();
                            writeChunks(outputStream, bytes, length);
                            break;
                        } //End block
                        catch (IOException ex)
                        {
    if(sipStack.isLoggingEnabled())                            
                            sipStack.getStackLogger().logDebug(
                                        "IOException occured retryCount " + retry_count);
                            removeSocket(key);
                            try 
                            {
                                clientSock.close();
                            } //End block
                            catch (Exception e)
                            {
                            } //End block
                            clientSock = null;
                            retry_count++;
                        } //End block
                    } //End block
                } //End block
            } //End block
            finally 
            {
                ioSemaphore.release();
            } //End block
    if(clientSock == null)            
            {
    if(sipStack.isLoggingEnabled())                
                {
                    sipStack.getStackLogger().logDebug(this.socketTable.toString());
                    sipStack.getStackLogger().logError(
                            "Could not connect to " + receiverAddress + ":" + contactPort);
                } //End block
                IOException varB3CFEA0C43C3483A685A0A72FE42C36A_1161462028 = new IOException("Could not connect to " + receiverAddress + ":"
                        + contactPort);
                varB3CFEA0C43C3483A685A0A72FE42C36A_1161462028.addTaint(taint);
                throw varB3CFEA0C43C3483A685A0A72FE42C36A_1161462028;
            } //End block
            else
            {
Socket var8B5650BAADD309AEF2F5CD57ED239E43_1412891508 =             clientSock;
            var8B5650BAADD309AEF2F5CD57ED239E43_1412891508.addTaint(taint);
            return var8B5650BAADD309AEF2F5CD57ED239E43_1412891508;
            }
        } //End block
        else
    if(transport.compareToIgnoreCase(TLS) == 0)        
        {
            String key = makeKey(receiverAddress, contactPort);
            try 
            {
                boolean retval = this.ioSemaphore.tryAcquire(10000, TimeUnit.MILLISECONDS);
    if(!retval)                
                {
                IOException var27E8C74399A62292247CE1E2792AEF30_55611408 = new IOException("Timeout acquiring IO SEM");
                var27E8C74399A62292247CE1E2792AEF30_55611408.addTaint(taint);
                throw var27E8C74399A62292247CE1E2792AEF30_55611408;
                }
            } //End block
            catch (InterruptedException ex)
            {
                IOException varABD98BB3731DB97FC3481A2F15C0E069_1242828914 = new IOException("exception in acquiring sem");
                varABD98BB3731DB97FC3481A2F15C0E069_1242828914.addTaint(taint);
                throw varABD98BB3731DB97FC3481A2F15C0E069_1242828914;
            } //End block
            Socket clientSock = getSocket(key);
            try 
            {
                while
(retry_count < max_retry)                
                {
    if(clientSock == null)                    
                    {
    if(sipStack.isLoggingEnabled())                        
                        {
                            sipStack.getStackLogger().logDebug("inaddr = " + receiverAddress);
                            sipStack.getStackLogger().logDebug("port = " + contactPort);
                        } //End block
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
                    } //End block
                    else
                    {
                        try 
                        {
                            OutputStream outputStream = clientSock.getOutputStream();
                            writeChunks(outputStream, bytes, length);
                            break;
                        } //End block
                        catch (IOException ex)
                        {
    if(sipStack.isLoggingEnabled())                            
                            sipStack.getStackLogger().logException(ex);
                            removeSocket(key);
                            try 
                            {
                                clientSock.close();
                            } //End block
                            catch (Exception e)
                            {
                            } //End block
                            clientSock = null;
                            retry_count++;
                        } //End block
                    } //End block
                } //End block
            } //End block
            finally 
            {
                ioSemaphore.release();
            } //End block
    if(clientSock == null)            
            {
                IOException varB3CFEA0C43C3483A685A0A72FE42C36A_1076358907 = new IOException("Could not connect to " + receiverAddress + ":"
                        + contactPort);
                varB3CFEA0C43C3483A685A0A72FE42C36A_1076358907.addTaint(taint);
                throw varB3CFEA0C43C3483A685A0A72FE42C36A_1076358907;
            } //End block
            else
            {
Socket var8B5650BAADD309AEF2F5CD57ED239E43_352182106 =             clientSock;
            var8B5650BAADD309AEF2F5CD57ED239E43_352182106.addTaint(taint);
            return var8B5650BAADD309AEF2F5CD57ED239E43_352182106;
            }
        } //End block
        else
        {
            DatagramSocket datagramSock = sipStack.getNetworkLayer().createDatagramSocket();
            datagramSock.connect(receiverAddress, contactPort);
            DatagramPacket dgPacket = new DatagramPacket(bytes, 0, length, receiverAddress,
                    contactPort);
            datagramSock.send(dgPacket);
            datagramSock.close();
Socket var540C13E9E156B687226421B24F2DF178_2136313105 =             null;
            var540C13E9E156B687226421B24F2DF178_2136313105.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2136313105;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.510 -0400", hash_original_method = "1D520544B315CDC75D81B88E4BB64341", hash_generated_method = "259251E5C5E4A849066D432898E2B327")
    public void closeAll() {
for(Enumeration<Socket> values = socketTable.elements();values.hasMoreElements();)
        {
            Socket s = (Socket) values.nextElement();
            try 
            {
                s.close();
            } //End block
            catch (IOException ex)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //for (Enumeration<Socket> values = socketTable.elements(); values.hasMoreElements();) {
            //Socket s = (Socket) values.nextElement();
            //try {
                //s.close();
            //} catch (IOException ex) {
            //}
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.510 -0400", hash_original_field = "E7E305FD91DFAD258D05CEF692A3FDA3", hash_generated_field = "2A19A36B452D88CDD5B3F26D17F7563A")

    private static String TCP = "tcp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.510 -0400", hash_original_field = "02AC7105BC9267167A7FE52691A37BAB", hash_generated_field = "1AD174C59CE89A66B72D18168F821A73")

    private static String TLS = "tls";
}

