package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketOptions;

class LocalSocketImpl {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.261 -0500", hash_original_field = "2E69C796FF6BAD53C79A467DE3BC8E3D", hash_generated_field = "355E2A769FEE7E54D6F0256760F338B6")

    private SocketInputStream fis;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.263 -0500", hash_original_field = "552BC59F43395032D4325FD66EF9333D", hash_generated_field = "8156E266B6831DBC7B3771E7C35EF804")

    private SocketOutputStream fos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.265 -0500", hash_original_field = "9D5A947E961D94B570F8A7277DB09B59", hash_generated_field = "201F2893E6616F00DF8FC16933452C93")

    private Object readMonitor = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.267 -0500", hash_original_field = "2BB68BEB056ABF539B644ED112FA8AFD", hash_generated_field = "3AEEFF96894C6EA6FF9C01F76A902604")

    private Object writeMonitor = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.270 -0500", hash_original_field = "DC35B29CA7114A0CAB311A30B93CBE5F", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

    private FileDescriptor fd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.272 -0500", hash_original_field = "9CF2319FEDB29C1E6FE6830C6EF0FC50", hash_generated_field = "ED9E888FFF51174497B2AEAE0992D2B7")

    /** file descriptor array received during a previous read */
    FileDescriptor[] inboundFileDescriptors;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.274 -0500", hash_original_field = "5C2DA72A39F5E44715644D1AB34D0887", hash_generated_field = "5C2DA72A39F5E44715644D1AB34D0887")

    FileDescriptor[] outboundFileDescriptors;

    /**
     * Create a new instance.
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.358 -0500", hash_original_method = "EB46FEA2FE489ABD86FB64E17870F7D5", hash_generated_method = "EB46FEA2FE489ABD86FB64E17870F7D5")
    
LocalSocketImpl()
    {
    }

    /**
     * Create a new instance from a file descriptor representing
     * a bound socket. The state of the file descriptor is not checked here
     *  but the caller can verify socket state by calling listen().
     *
     * @param fd non-null; bound file descriptor
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.360 -0500", hash_original_method = "D456C6C1E42DF15F5B9AFA3DF483BFD5", hash_generated_method = "D456C6C1E42DF15F5B9AFA3DF483BFD5")
    
LocalSocketImpl(FileDescriptor fd) throws IOException
    {
        this.fd = fd;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.305 -0500", hash_original_method = "2758981D1030A8FDA90CA71A02304595", hash_generated_method = "322BB37FF722A58BB18D2DD8EAADCCB4")
    
    private int available_native(FileDescriptor fd) throws IOException{
    	//Formerly a native method
    	addTaint(fd.getTaint());
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.308 -0500", hash_original_method = "C4F1C4509B0A008CEB1A520A33B1432C", hash_generated_method = "0BFB7D9CE40F5048B9859812C60A147E")
    
    private void close_native(FileDescriptor fd) throws IOException{
    	//Formerly a native method
    	addTaint(fd.getTaint());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.312 -0500", hash_original_method = "C5E1B2BCA848D2C54F079D7825712FAA", hash_generated_method = "A13C1097AE2EBE781454EF6A4EF629C5")
    
    private int read_native(FileDescriptor fd) throws IOException{
    	//Formerly a native method
    	addTaint(fd.getTaint());
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.316 -0500", hash_original_method = "6C0CD8F9940E6252A80F192C7FCEF247", hash_generated_method = "AE77DEEB20B582CDED5DF51CEB0BCE60")
    
    private int readba_native(byte[] b, int off, int len,
                FileDescriptor fd) throws IOException{
    	//Formerly a native method
    	addTaint(b[0]);
    	addTaint(off);
    	addTaint(len);
    	addTaint(fd.getTaint());
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.319 -0500", hash_original_method = "411B6D80F43D59E374103A18918D197B", hash_generated_method = "79B65129E58ACA13031F891365D948B8")
    
    private void writeba_native(byte[] b, int off, int len,
                FileDescriptor fd) throws IOException{
    	//Formerly a native method
    	addTaint(b[0]);
    	addTaint(off);
    	addTaint(len);
    	addTaint(fd.getTaint());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.323 -0500", hash_original_method = "EC6860394B0EC0B22E9CA8C353E6B2CD", hash_generated_method = "B030B14DF820690DE3A9F7798B1447FC")
    
    private void write_native(int b, FileDescriptor fd)
                throws IOException{
    	//Formerly a native method
    	addTaint(b);
    	addTaint(fd.getTaint());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.326 -0500", hash_original_method = "FB81706A2E5D939365DC1E11BB4FE7D5", hash_generated_method = "EE262E1FDADAEC621A39F51506C3E6DA")
    
    private void connectLocal(FileDescriptor fd, String name,
                int namespace) throws IOException{
    	//Formerly a native method
    	addTaint(fd.getTaint());
    	addTaint(name.getTaint());
    	addTaint(namespace);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.330 -0500", hash_original_method = "62C617B37F715EB0C7D8B05FC6062D1C", hash_generated_method = "CE48C7AFB77AF7187A6547FCD34D998B")
    
    private void bindLocal(FileDescriptor fd, String name, int namespace)
                throws IOException{
    	//Formerly a native method
    	addTaint(fd.getTaint());
    	addTaint(name.getTaint());
    	addTaint(namespace);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.248 -0400", hash_original_method = "91E7A83B201CCE6F03E99B6B97993D3C", hash_generated_method = "BF4DB921189260FDA30B994461CFCF87")
    private FileDescriptor create_native(boolean stream) throws IOException {
        FileDescriptor fd = new FileDescriptor();
        fd.addTaint(this.taint);
        return fd;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.337 -0500", hash_original_method = "565F45EE1777149341C55D43CF68422B", hash_generated_method = "DA50784D3A2A11405647175C8DFB1DDE")
    
    private void listen_native(FileDescriptor fd, int backlog)
                throws IOException{
    	//Formerly a native method
    	addTaint(fd.getTaint());
    	addTaint(backlog);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.341 -0500", hash_original_method = "AE79C436903413982C1AAE7FD29B4B48", hash_generated_method = "369C1532C460807B4DB74051FBE9C4F9")
    
    private void shutdown(FileDescriptor fd, boolean shutdownInput){
    	//Formerly a native method
    	addTaint(fd.getTaint());
    	addTaint(shutdownInput);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.248 -0400", hash_original_method = "0137F99D53D5E10D02D5A211BB31B969", hash_generated_method = "5F1B13E48615D9E4FD0789735B8F4C85")
    private Credentials getPeerCredentials_native(
            FileDescriptor fd) throws IOException {
    	Credentials creds = new Credentials(0, 0, 0);
    	creds.addTaint(this.taint);
    	return creds;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.349 -0500", hash_original_method = "57547C3595B23A135CCDE37FD7052F1D", hash_generated_method = "0C8D608554554E90ADE360CC50CEEE96")
    
    private int getOption_native(FileDescriptor fd, int optID)
                throws IOException{
    	//Formerly a native method
    	addTaint(fd.getTaint());
    	addTaint(optID);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.352 -0500", hash_original_method = "DE678D0521D206818FAC33E612ECDEF9", hash_generated_method = "08C25418222347227013F52740105F39")
    
    private void setOption_native(FileDescriptor fd, int optID,
                int b, int value) throws IOException{
    	//Formerly a native method
    	addTaint(fd.getTaint());
    	addTaint(optID);
    	addTaint(b);
    	addTaint(value);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.249 -0400", hash_original_method = "AD93B21D07861EA052C26EC40030E4DA", hash_generated_method = "0BA24B5688D235E53CBDA81423459803")
    private FileDescriptor accept(FileDescriptor fd, LocalSocketImpl s) throws IOException {
        FileDescriptor fd2 = new FileDescriptor();
        fd2.addTaint(this.taint);
        return fd2;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.362 -0500", hash_original_method = "910906868F2A4F19B7D2844E1F779346", hash_generated_method = "40FFCDDF45EF3AA1E9C1A0DE5B81F59B")
    
public String toString() {
        return super.toString() + " fd:" + fd;
    }

    /**
     * Creates a socket in the underlying OS.
     *
     * @param stream true if this should be a stream socket, false for
     * datagram.
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.364 -0500", hash_original_method = "C69FBA5615AE4C555A8E605188FC5D70", hash_generated_method = "9529B15B91709FA3F46AA05F5D5D1C6A")
    
public void create (boolean stream) throws IOException {
        // no error if socket already created
        // need this for LocalServerSocket.accept()
        if (fd == null) {
            fd = create_native(stream);
        }
    }

    /**
     * Closes the socket.
     *
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.367 -0500", hash_original_method = "ABF18B5E6666C8F5D8A2BB5F41F5792B", hash_generated_method = "1495D91B7F701DFBD52DE5E640C10B6D")
    
public void close() throws IOException {
        synchronized (LocalSocketImpl.this) {
            if (fd == null) return;
            close_native(fd);
            fd = null;
        }
    }

    /** note timeout presently ignored */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.369 -0500", hash_original_method = "425C245C15643B6C00C58E49D6A6C651", hash_generated_method = "C2258CD53F30B7AF255CD975E6523897")
    
protected void connect(LocalSocketAddress address, int timeout)
                        throws IOException
    {        
        if (fd == null) {
            throw new IOException("socket not created");
        }

        connectLocal(fd, address.getName(), address.getNamespace().getId());
    }

    /**
     * Binds this socket to an endpoint name. May only be called on an instance
     * that has not yet been bound.
     *
     * @param endpoint endpoint address
     * @throws IOException
     */
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.371 -0500", hash_original_method = "D301FBD428349B466ACCB27339A08D2F", hash_generated_method = "1EF36E0E81A21E092BB79644E67D0F14")
    
public void bind(LocalSocketAddress endpoint) throws IOException
    {
        if (fd == null) {
            throw new IOException("socket not created");
        }

        bindLocal(fd, endpoint.getName(), endpoint.getNamespace().getId());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.373 -0500", hash_original_method = "A6DEE76A07DA4242CC30FE3245F17D51", hash_generated_method = "9D29C411A79A57E8E61C79D82CF3B991")
    
protected void listen(int backlog) throws IOException
    {
        if (fd == null) {
            throw new IOException("socket not created");
        }

        listen_native(fd, backlog);
    }

    /**
     * Accepts a new connection to the socket. Blocks until a new
     * connection arrives.
     *
     * @param s a socket that will be used to represent the new connection.
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.376 -0500", hash_original_method = "E2D863498299C9CF5B0AE6150A21C675", hash_generated_method = "55529CB19A733293335AFAE2A6F95874")
    
protected void accept(LocalSocketImpl s) throws IOException
    {
        if (fd == null) {
            throw new IOException("socket not created");
        }

        s.fd = accept(fd, s);
    }

    /**
     * Retrieves the input stream for this instance.
     *
     * @return input stream
     * @throws IOException if socket has been closed or cannot be created.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.378 -0500", hash_original_method = "D37322C17A1B9B191A9C32D9BD81E000", hash_generated_method = "6FD9301C4C1D3F08AEF60AB79F19C5D3")
    
protected InputStream getInputStream() throws IOException
    {
        if (fd == null) {
            throw new IOException("socket not created");
        }

        synchronized (this) {
            if (fis == null) {
                fis = new SocketInputStream();
            }

            return fis;
        }
    }

    /**
     * Retrieves the output stream for this instance.
     *
     * @return output stream
     * @throws IOException if socket has been closed or cannot be created.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.380 -0500", hash_original_method = "2E8F2E95CF2F6CF40AEA3B38F9B68B34", hash_generated_method = "F020EBF0AD51BA094F15DE6ECA348FD7")
    
protected OutputStream getOutputStream() throws IOException
    { 
        if (fd == null) {
            throw new IOException("socket not created");
        }

        synchronized (this) {
            if (fos == null) {
                fos = new SocketOutputStream();
            }

            return fos;
        }
    }

    /**
     * Returns the number of bytes available for reading without blocking.
     *
     * @return >= 0 count bytes available
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.382 -0500", hash_original_method = "A7CC818E7F384DAEC54D76069E9C5019", hash_generated_method = "E8FCEBA0D995DB6EE22CA1B5390C8697")
    
protected int available() throws IOException
    {
        return getInputStream().available();
    }

    /**
     * Shuts down the input side of the socket.
     *
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.384 -0500", hash_original_method = "CED8C1FFBDBF9F9E7A40EC2B2E6DD909", hash_generated_method = "56C8F96BF000F0F44095BF73C52F23CD")
    
protected void shutdownInput() throws IOException
    {
        if (fd == null) {
            throw new IOException("socket not created");
        }

        shutdown(fd, true);
    }

    /**
     * Shuts down the output side of the socket.
     *
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.387 -0500", hash_original_method = "DE98B1F2C9FD8DEEFDCE620E4EB90078", hash_generated_method = "6D1117DFD61BC43538CCCF7511692C33")
    
protected void shutdownOutput() throws IOException
    {
        if (fd == null) {
            throw new IOException("socket not created");
        }

        shutdown(fd, false);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.389 -0500", hash_original_method = "C1B4172ED9A628993584DE4384B8AF55", hash_generated_method = "C8664C638E6E7676776FC905B50F6CA8")
    
protected FileDescriptor getFileDescriptor()
    {
        return fd;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.391 -0500", hash_original_method = "84442B2358C6BD30716C7D72481FD8C4", hash_generated_method = "3435B1388EBB6C0D83AB9F72304C63D8")
    
protected boolean supportsUrgentData()
    {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.394 -0500", hash_original_method = "EC21D6BA9A1DE1709D242100460B4B8C", hash_generated_method = "D6EA5B8B738754F7655D6E287D58060A")
    
protected void sendUrgentData(int data) throws IOException
    {
        throw new RuntimeException ("not impled");
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.396 -0500", hash_original_method = "02CEF5E6368D2209C8707863BE147BD2", hash_generated_method = "74EFBAA0E814C92024470C9BA113EC79")
    
public Object getOption(int optID) throws IOException
    {
        if (fd == null) {
            throw new IOException("socket not created");
        }

        if (optID == SocketOptions.SO_TIMEOUT) {
            return 0;
        }
        
        int value = getOption_native(fd, optID);
        switch (optID)
        {
            case SocketOptions.SO_RCVBUF:
            case SocketOptions.SO_SNDBUF:
                return value;
            case SocketOptions.SO_REUSEADDR:
            default:
                return value;
        }
    }

    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.398 -0500", hash_original_method = "A0313708A2FB484B7104FAC62F0E39B4", hash_generated_method = "88D277497D8007967B2FDCAA44913C24")
    
public void setOption(int optID, Object value)
            throws IOException {
        /*
         * Boolean.FALSE is used to disable some options, so it
         * is important to distinguish between FALSE and unset.
         * We define it here that -1 is unset, 0 is FALSE, and 1
         * is TRUE.
         */
        int boolValue = -1;
        int intValue = 0;

        if (fd == null) {
            throw new IOException("socket not created");
        }

        if (value instanceof Integer) {
            intValue = (Integer)value;
        } else if (value instanceof Boolean) {
            boolValue = ((Boolean) value)? 1 : 0;
        } else {
            throw new IOException("bad value: " + value);
        }

        setOption_native(fd, optID, boolValue, intValue);
    }

    /**
     * Enqueues a set of file descriptors to send to the peer. The queue
     * is one deep. The file descriptors will be sent with the next write
     * of normal data, and will be delivered in a single ancillary message.
     * See "man 7 unix" SCM_RIGHTS on a desktop Linux machine.
     *
     * @param fds non-null; file descriptors to send.
     * @throws IOException
     */
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.400 -0500", hash_original_method = "AEC4AD692525702323537BC369199B7F", hash_generated_method = "4A891BE68D75308B131997586EE23B05")
    
public void setFileDescriptorsForSend(FileDescriptor[] fds) {
        synchronized(writeMonitor) {
            outboundFileDescriptors = fds;
        }
    }

    /**
     * Retrieves a set of file descriptors that a peer has sent through
     * an ancillary message. This method retrieves the most recent set sent,
     * and then returns null until a new set arrives.
     * File descriptors may only be passed along with regular data, so this
     * method can only return a non-null after a read operation.
     *
     * @return null or file descriptor array
     * @throws IOException
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.403 -0500", hash_original_method = "D444308F286D853D2E5F97ACF37B86DF", hash_generated_method = "36DAF8135E7E0ABE09E6A4524064A836")
    
public FileDescriptor[] getAncillaryFileDescriptors() throws IOException {
        synchronized(readMonitor) {
            FileDescriptor[] result = inboundFileDescriptors;

            inboundFileDescriptors = null;
            return result;
        }
    }

    /**
     * Retrieves the credentials of this socket's peer. Only valid on
     * connected sockets.
     *
     * @return non-null; peer credentials
     * @throws IOException
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.405 -0500", hash_original_method = "3E3240E544229F6BEFF619755963B808", hash_generated_method = "CF858812CA4F6308F56B0B5E8D38BD13")
    
public Credentials getPeerCredentials() throws IOException
    {
        return getPeerCredentials_native(fd);
    }

    /**
     * Retrieves the socket name from the OS.
     *
     * @return non-null; socket name
     * @throws IOException on failure
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.406 -0500", hash_original_method = "C6AD39B00524B9355CA4153DB07C4B13", hash_generated_method = "D8218971A0D58DC34787D527528E6156")
    
public LocalSocketAddress getSockAddress() throws IOException
    {
        return null;
        //TODO implement this
        //return getSockName_native(fd);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.408 -0500", hash_original_method = "CA22E17CA63436350E75BC7DD678FC6C", hash_generated_method = "1437CF8B9AA89AA1DD5C1019A36E2B47")
    
@Override
    protected void finalize() throws IOException {
        close();
    }
    
    class SocketInputStream extends InputStream {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.293 -0400", hash_original_method = "AF927FBDB8352BCBCFDDC9969A694B0C", hash_generated_method = "AF927FBDB8352BCBCFDDC9969A694B0C")
        public SocketInputStream ()
        {
            //Synthesized constructor
        }
        /** {@inheritDoc} */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.277 -0500", hash_original_method = "8F92B1C37F1E7B064EB55148DFA3D6F8", hash_generated_method = "13FE18489CE7D80AD7769190047FA841")
        
@Override
        public int available() throws IOException {
            return available_native(fd);
        }

        /** {@inheritDoc} */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.279 -0500", hash_original_method = "C23E504E812AF14B0F4062FED57A7B1E", hash_generated_method = "1ACBAB8B5A6705B56494966CD922491C")
        
@Override
        public void close() throws IOException {
            LocalSocketImpl.this.close();
        }

        /** {@inheritDoc} */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.281 -0500", hash_original_method = "395E06403A9BB7E16A5F2E3FCA2C1758", hash_generated_method = "50FEC6D2F5EEB194633B0219A38358AA")
        
@Override
        public int read() throws IOException {
            int ret;
            synchronized (readMonitor) {
                FileDescriptor myFd = fd;
                if (myFd == null) throw new IOException("socket closed");

                ret = read_native(myFd);
                return ret;
            }
        }

        /** {@inheritDoc} */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.284 -0500", hash_original_method = "03121A7AC3B4E7519E88953F37DA485C", hash_generated_method = "CFD5B18414297C5D63F6DE9EDDF7232C")
        
@Override
        public int read(byte[] b) throws IOException {
            return read(b, 0, b.length);
        }

        /** {@inheritDoc} */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.286 -0500", hash_original_method = "554DCEA621C79251D4E71F6BA8C4411B", hash_generated_method = "32C6E525B1BE064854CD72B345699AD5")
        
@Override
        public int read(byte[] b, int off, int len) throws IOException {
            synchronized (readMonitor) {
                FileDescriptor myFd = fd;
                if (myFd == null) throw new IOException("socket closed");

                if (off < 0 || len < 0 || (off + len) > b.length ) {
                    throw new ArrayIndexOutOfBoundsException();
                }

                int ret = readba_native(b, off, len, myFd);

                return ret;
            }
        }
        
    }
    
    class SocketOutputStream extends OutputStream {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.294 -0400", hash_original_method = "9DAA385F4ED568E05EE1F0223FEA6D4A", hash_generated_method = "9DAA385F4ED568E05EE1F0223FEA6D4A")
        public SocketOutputStream ()
        {
            //Synthesized constructor
        }
        /** {@inheritDoc} */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.291 -0500", hash_original_method = "C23E504E812AF14B0F4062FED57A7B1E", hash_generated_method = "1ACBAB8B5A6705B56494966CD922491C")
        
@Override
        public void close() throws IOException {
            LocalSocketImpl.this.close();
        }

        /** {@inheritDoc} */
        @DSSink({DSSinkKind.NETWORK})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.294 -0500", hash_original_method = "E1D4EA7BC5A1A039095C078064FA6BD5", hash_generated_method = "7D09861B37E141F39BE351A56688C45A")
        
@Override
        public void write (byte[] b) throws IOException {
            write(b, 0, b.length);
        }
        
        /** {@inheritDoc} */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.296 -0500", hash_original_method = "EBF729639A281DEC85F834E9B1299F05", hash_generated_method = "ED4C74392129B7713D5435E0B7CF9389")
        
@Override
        public void write (byte[] b, int off, int len) throws IOException {
            synchronized (writeMonitor) {
                FileDescriptor myFd = fd;
                if (myFd == null) throw new IOException("socket closed");

                if (off < 0 || len < 0 || (off + len) > b.length ) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                writeba_native(b, off, len, myFd);
            }
        }

        /** {@inheritDoc} */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.299 -0500", hash_original_method = "0B4435377A393210C076C48249BA83BB", hash_generated_method = "024C608DDBDDDB6ABBACDC1BA4A0D8E2")
        
@Override
        public void write (int b) throws IOException {
            synchronized (writeMonitor) {
                FileDescriptor myFd = fd;
                if (myFd == null) throw new IOException("socket closed");
                write_native(b, myFd);
            }
        }
        
    }
    
}

