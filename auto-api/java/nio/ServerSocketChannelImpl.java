package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.PlainServerSocketImpl;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketImpl;
import java.net.SocketTimeoutException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.IllegalBlockingModeException;
import java.nio.channels.NotYetBoundException;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import libcore.io.IoUtils;

final class ServerSocketChannelImpl extends ServerSocketChannel implements FileDescriptorChannel {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.195 -0400", hash_original_field = "61F2529360AEC54F5DC9804B842CF3FA", hash_generated_field = "6A9FD930739602076044D5E8A08C62AF")

    private ServerSocketAdapter socket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.196 -0400", hash_original_field = "86CCEC3D9FF0E9C0514506E982CDC08B", hash_generated_field = "E5435F593B4B4C544AAC5D578CFF6639")

    private SocketImpl impl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.196 -0400", hash_original_field = "1EA05BED8F3F3741889B40C4407A936D", hash_generated_field = "AD4F2B698EC37BEC9EEE873CE57E921D")

    private boolean isBound = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.196 -0400", hash_original_field = "09B41F28A47510F64B0C05A1E76FE064", hash_generated_field = "1632DBE80D46ED7B89E6515D49182309")

    private Object acceptLock = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.196 -0400", hash_original_method = "073E2905C9482C63193DCF1A83313D92", hash_generated_method = "E243E41B05F228B0BCC8A54E6822A71A")
    public  ServerSocketChannelImpl(SelectorProvider sp) throws IOException {
        super(sp);
        this.socket = new ServerSocketAdapter(this);
        this.impl = socket.getImpl$();
        addTaint(sp.getTaint());
        // ---------- Original Method ----------
        //this.socket = new ServerSocketAdapter(this);
        //this.impl = socket.getImpl$();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.197 -0400", hash_original_method = "0B1D553D9DA92AA497AE372DB2D8B920", hash_generated_method = "BDB4E6BE80DD13495EFEB74CAEACCB31")
    @Override
    public ServerSocket socket() {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_799865367 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_799865367 = socket;
        varB4EAC82CA7396A68D541C85D26508E83_799865367.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_799865367;
        // ---------- Original Method ----------
        //return socket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.197 -0400", hash_original_method = "B7A0B638220973E2E0E163125709103A", hash_generated_method = "6B73B13A72EA60E38ACD175C2258DC07")
    @Override
    public SocketChannel accept() throws IOException {
        SocketChannel varB4EAC82CA7396A68D541C85D26508E83_1841528890 = null; //Variable for return #1
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_1500982891 = (!isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new NotYetBoundException();
        } //End block
        SocketChannelImpl result;
        result = new SocketChannelImpl(provider(), false);
        boolean connected;
        connected = false;
        try 
        {
            begin();
            {
                {
                    Object var33E828BB1AE54859E7CEF26AF86CF91F_1242777542 = (blockingLock());
                    {
                        {
                            try 
                            {
                                socket.implAccept(result);
                            } //End block
                            catch (SocketTimeoutException e)
                            { }
                        } //End block
                        {
                            boolean var0B927209D6F467F43EA9730294067322_81504587 = (isBlocking());
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        finally 
        {
            end(result.socket().isConnected());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1841528890 = result.socket().isConnected() ? result : null;
        varB4EAC82CA7396A68D541C85D26508E83_1841528890.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1841528890;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.198 -0400", hash_original_method = "691B92594A92F5155DBD81F8E2ED268A", hash_generated_method = "986159082FC75A0A82F4EA61EE00EAB9")
    @Override
    protected void implConfigureBlocking(boolean blocking) throws IOException {
        {
            Object var964C97B960BB46676C47DA572AAFDDC9_1798139746 = (blockingLock());
            {
                IoUtils.setBlocking(impl.getFD$(), blocking);
            } //End block
        } //End collapsed parenthetic
        addTaint(blocking);
        // ---------- Original Method ----------
        //synchronized (blockingLock()) {
            //IoUtils.setBlocking(impl.getFD$(), blocking);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.198 -0400", hash_original_method = "1ADA3F28F78BF67A471F8136E0D07F3B", hash_generated_method = "5E7407ED736AB5B273CD0C4F901BD232")
    synchronized protected void implCloseSelectableChannel() throws IOException {
        {
            boolean varD46A2716AEC08881570CED6916EA1310_1102177179 = (!socket.isClosed());
            {
                socket.close();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!socket.isClosed()) {
            //socket.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.198 -0400", hash_original_method = "6D4849F20A76F796E10F0B815FB14502", hash_generated_method = "27FC2B0D95A460FDC03A235CD6ECF4BA")
    public FileDescriptor getFD() {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_705631540 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_705631540 = impl.getFD$();
        varB4EAC82CA7396A68D541C85D26508E83_705631540.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_705631540;
        // ---------- Original Method ----------
        //return impl.getFD$();
    }

    
    private static class ServerSocketAdapter extends ServerSocket {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.203 -0400", hash_original_field = "32CC750E4B8FCA138B4D6BCBE118C5DB", hash_generated_field = "4409938A65C53F969FE8732C261D10D0")

        private ServerSocketChannelImpl channelImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.203 -0400", hash_original_method = "01F94E3226EECA786EFC49C8330A8199", hash_generated_method = "5321552FFAD79EAB3F4957EEB1F59589")
          ServerSocketAdapter(ServerSocketChannelImpl aChannelImpl) throws IOException {
            this.channelImpl = aChannelImpl;
            // ---------- Original Method ----------
            //this.channelImpl = aChannelImpl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.203 -0400", hash_original_method = "BBE5EDFC9B689589BC654E0B103C84FF", hash_generated_method = "1204E5E122F3192084306C075A847A41")
        @Override
        public void bind(SocketAddress localAddress, int backlog) throws IOException {
            super.bind(localAddress, backlog);
            channelImpl.isBound = true;
            addTaint(localAddress.getTaint());
            addTaint(backlog);
            // ---------- Original Method ----------
            //super.bind(localAddress, backlog);
            //channelImpl.isBound = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.220 -0400", hash_original_method = "FFAB0B1226A929FA42E5D3CF52806643", hash_generated_method = "374761C7EBE7B307E30B255B76EE28B3")
        @Override
        public Socket accept() throws IOException {
            Socket varB4EAC82CA7396A68D541C85D26508E83_203077503 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
            } //End block
            SocketChannel sc;
            sc = channelImpl.accept();
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_203077503 = sc.socket();
            varB4EAC82CA7396A68D541C85D26508E83_203077503.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_203077503;
            // ---------- Original Method ----------
            //if (!channelImpl.isBound) {
                //throw new IllegalBlockingModeException();
            //}
            //SocketChannel sc = channelImpl.accept();
            //if (sc == null) {
                //throw new IllegalBlockingModeException();
            //}
            //return sc.socket();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.221 -0400", hash_original_method = "65367E3BCE6469B06918214294C7E857", hash_generated_method = "2F84FA0AC68FF985D36E98B6E3BEB552")
        public Socket implAccept(SocketChannelImpl clientSocketChannel) throws IOException {
            Socket varB4EAC82CA7396A68D541C85D26508E83_424366883 = null; //Variable for return #1
            Socket clientSocket;
            clientSocket = clientSocketChannel.socket();
            boolean connectOK;
            connectOK = false;
            try 
            {
                {
                    super.implAccept(clientSocket);
                    clientSocketChannel.setConnected();
                    clientSocketChannel.setBound(true);
                    clientSocketChannel.finishAccept();
                } //End block
                connectOK = true;
            } //End block
            finally 
            {
                {
                    clientSocket.close();
                } //End block
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_424366883 = clientSocket;
            addTaint(clientSocketChannel.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_424366883.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_424366883;
            // ---------- Original Method ----------
            //Socket clientSocket = clientSocketChannel.socket();
            //boolean connectOK = false;
            //try {
                //synchronized (this) {
                    //super.implAccept(clientSocket);
                    //clientSocketChannel.setConnected();
                    //clientSocketChannel.setBound(true);
                    //clientSocketChannel.finishAccept();
                //}
                //connectOK = true;
            //} finally {
                //if (!connectOK) {
                    //clientSocket.close();
                //}
            //}
            //return clientSocket;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.222 -0400", hash_original_method = "9062324EB68516522A00021BE06AA12D", hash_generated_method = "60471388E323E097F39C1E20D3D0EBE2")
        @Override
        public ServerSocketChannel getChannel() {
            ServerSocketChannel varB4EAC82CA7396A68D541C85D26508E83_1022968163 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1022968163 = channelImpl;
            varB4EAC82CA7396A68D541C85D26508E83_1022968163.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1022968163;
            // ---------- Original Method ----------
            //return channelImpl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.222 -0400", hash_original_method = "F11CC1C6B1751A820DF0839300E56C28", hash_generated_method = "A22027547633263A1752696AFCB5EFA4")
        @Override
        public boolean isBound() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_483975915 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_483975915;
            // ---------- Original Method ----------
            //return channelImpl.isBound;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.222 -0400", hash_original_method = "67582FB1AEE3F050543A066EF39FFBDB", hash_generated_method = "116E840E6FB3EE8EBA6CC205D8451624")
        @Override
        public void bind(SocketAddress localAddress) throws IOException {
            super.bind(localAddress);
            channelImpl.isBound = true;
            addTaint(localAddress.getTaint());
            // ---------- Original Method ----------
            //super.bind(localAddress);
            //channelImpl.isBound = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.223 -0400", hash_original_method = "7BB2E5C011080F2650E0866A01912B69", hash_generated_method = "78171B2FEA902E50FC9194D23A73630B")
        @Override
        public void close() throws IOException {
            {
                {
                    boolean var732C27B9F7BFDC492915355DF0E33D1C_1147151757 = (channelImpl.isOpen());
                    {
                        channelImpl.close();
                    } //End block
                    {
                        super.close();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            // ---------- Original Method ----------
            //synchronized (channelImpl) {
                //if (channelImpl.isOpen()) {
                    //channelImpl.close();
                //} else {
                    //super.close();
                //}
            //}
        }

        
    }


    
}

